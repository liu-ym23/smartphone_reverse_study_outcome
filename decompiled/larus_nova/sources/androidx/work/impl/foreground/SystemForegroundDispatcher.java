package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes17.dex */
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = null;
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    String mCurrentForegroundWorkSpecId;
    final Map<String, ForegroundInfo> mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Set<WorkSpec> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<String, WorkSpec> mWorkSpecById;

    public interface Callback {
        void cancelNotification(int r100);

        void notify(int r100, Notification r101);

        void startForeground(int r100, int r101, Notification r102);

        void stop();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<String> r100) {
    }

    public void onDestroy() {
        this.mCallback = null;
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mConstraintsTracker.reset();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    }

    public WorkManagerImpl getWorkManager() {
        return this.mWorkManagerImpl;
    }

    public SystemForegroundDispatcher(Context r100) {
        this.mContext = r100;
        this.mLock = new Object();
        WorkManagerImpl r101 = WorkManagerImpl.getInstance(r100);
        this.mWorkManagerImpl = r101;
        TaskExecutor r102 = r101.getWorkTaskExecutor();
        this.mTaskExecutor = r102;
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mContext, r102, this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    public static Intent createStopForegroundIntent(Context r100) {
        Intent r101 = new Intent(r100, SystemForegroundService.class);
        r101.setAction(ACTION_STOP_FOREGROUND);
        return r101;
    }

    private void handleCancelWork(Intent r100) {
        Logger.get().info(TAG, String.format("Stopping foreground work for %s", new Object[]{r100}), new Throwable[0]);
        String r101 = r100.getStringExtra(KEY_WORKSPEC_ID);
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.mWorkManagerImpl.cancelWorkById(UUID.fromString(r101));
        return;
    }

    private void handleNotify(Intent r110) {
        int r100 = 0;
        int r101 = r110.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int r102 = r110.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String r103 = r110.getStringExtra(KEY_WORKSPEC_ID);
        Notification r111 = (Notification) r110.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(r101), r103, Integer.valueOf(r102)}), new Throwable[0]);
        if (r111 != null) goto L5;
        return;
    L5:
        if (this.mCallback == null) goto L23;
        this.mForegroundInfoById.put(r103, new ForegroundInfo(r101, r111, r102));
        if (TextUtils.isEmpty(this.mCurrentForegroundWorkSpecId) == false) goto L9;
        this.mCurrentForegroundWorkSpecId = r103;
        this.mCallback.startForeground(r101, r102, r111);
        return;
    L9:
        this.mCallback.notify(r101, r111);
        if (r102 != 0) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 29) goto L26;
        Iterator<Map.Entry<String, ForegroundInfo>> r112 = this.mForegroundInfoById.entrySet().iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        r100 = r100 | r112.next().getValue().getForegroundServiceType();
        goto L15
    L17:
        ForegroundInfo r113 = this.mForegroundInfoById.get(this.mCurrentForegroundWorkSpecId);
        if (r113 == null) goto L27;
        this.mCallback.startForeground(r113.getNotificationId(), r100, r113.getNotification());
        return;
    L27:
        return;
    L26:
        return;
    }

    private void handleStartForeground(Intent r100) {
        Logger.get().info(TAG, String.format("Started foreground service %s", new Object[]{r100}), new Throwable[0]);
        final String r101 = r100.getStringExtra(KEY_WORKSPEC_ID);
        final WorkDatabase r102 = this.mWorkManagerImpl.getWorkDatabase();
        this.mTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(this, r102, r101));
    }

    public void handleStop(Intent r100) {
        Logger.get().info(TAG, "Stopping foreground service", new Throwable[0]);
        Callback r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.stop();
        return;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<String> r100) {
        if (r100.isEmpty() == true) goto L8;
        Iterator<String> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();
        Logger.get().debug(TAG, String.format("Constraints unmet for WorkSpec %s", new Object[]{r102}), new Throwable[0]);
        this.mWorkManagerImpl.stopForegroundWork(r102);
        goto L6
    L10:
        return;
    }

    public void onStartCommand(Intent r100) {
        String r101 = r100.getAction();
        if (ACTION_START_FOREGROUND.equals(r101) == false) goto L6;
        handleStartForeground(r100);
        handleNotify(r100);
        return;
    L6:
        if (ACTION_NOTIFY.equals(r101) == false) goto L9;
        handleNotify(r100);
        return;
    L9:
        if (ACTION_CANCEL_WORK.equals(r101) == false) goto L12;
        handleCancelWork(r100);
        return;
    L12:
        if (ACTION_STOP_FOREGROUND.equals(r101) == false) goto L18;
        handleStop(r100);
        return;
    }

    public void setCallback(Callback r100) {
        if (this.mCallback == null) goto L6;
        Logger.get().error(TAG, "A callback already exists.", new Throwable[0]);
        return;
    L6:
        this.mCallback = r100;
    }

    public static Intent createCancelWorkIntent(Context r100, String r101) {
        Intent r102 = new Intent(r100, SystemForegroundService.class);
        r102.setAction(ACTION_CANCEL_WORK);
        r102.setData(UriProtector.parse(String.format("workspec://%s", new Object[]{r101})));
        r102.putExtra(KEY_WORKSPEC_ID, r101);
        return r102;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String r100, boolean r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        WorkSpec r103 = this.mWorkSpecById.remove(r100);     // Catch: Throwable -> L27
        if (r103 == null) goto L7;
        boolean r104 = this.mTrackedWorkSpecs.remove(r103);     // Catch: Throwable -> L27
    L8:
        if (r104 == false) goto L10;
        this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);     // Catch: Throwable -> L27
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L27
        ForegroundInfo r105 = this.mForegroundInfoById.remove(r100);
        if (r100.equals(this.mCurrentForegroundWorkSpecId) == true) goto L14;
    L22:
        Callback r106 = this.mCallback;
        if (r105 == null) goto L33;
        if (r106 == null) goto L34;
        Logger.get().debug(TAG, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(r105.getNotificationId()), r100, Integer.valueOf(r105.getForegroundServiceType())}), new Throwable[0]);
        r106.cancelNotification(r105.getNotificationId());
        return;
    L34:
        return;
    L33:
        return;
    L14:
        if (this.mForegroundInfoById.size() <= 0) goto L22;
        Iterator<Map.Entry<String, ForegroundInfo>> r107 = this.mForegroundInfoById.entrySet().iterator();
        Map.Entry<String, ForegroundInfo> r108 = r107.next();
    L16:
        Map.Entry<String, ForegroundInfo> r109 = r108;
        if (r107.hasNext() == false) goto L19;
        r108 = r107.next();
        goto L16
    L19:
        this.mCurrentForegroundWorkSpecId = r109.getKey();
        if (this.mCallback == null) goto L22;
        ForegroundInfo r110 = r109.getValue();
        this.mCallback.startForeground(r110.getNotificationId(), r110.getForegroundServiceType(), r110.getNotification());
        this.mCallback.cancelNotification(r110.getNotificationId());
        goto L22
    L7:
        r104 = false;
    L27:
        th = move-exception;
        throw th;
    }

    public SystemForegroundDispatcher(Context r100, WorkManagerImpl r101, WorkConstraintsTracker r102) {
        this.mContext = r100;
        this.mLock = new Object();
        this.mWorkManagerImpl = r101;
        this.mTaskExecutor = r101.getWorkTaskExecutor();
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = r102;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context r100, String r101, ForegroundInfo r102) {
        Intent r103 = new Intent(r100, SystemForegroundService.class);
        r103.setAction(ACTION_NOTIFY);
        r103.putExtra(KEY_NOTIFICATION_ID, r102.getNotificationId());
        r103.putExtra(KEY_FOREGROUND_SERVICE_TYPE, r102.getForegroundServiceType());
        r103.putExtra(KEY_NOTIFICATION, r102.getNotification());
        r103.putExtra(KEY_WORKSPEC_ID, r101);
        return r103;
    }

    public static Intent createStartForegroundIntent(Context r100, String r101, ForegroundInfo r102) {
        Intent r103 = new Intent(r100, SystemForegroundService.class);
        r103.setAction(ACTION_START_FOREGROUND);
        r103.putExtra(KEY_WORKSPEC_ID, r101);
        r103.putExtra(KEY_NOTIFICATION_ID, r102.getNotificationId());
        r103.putExtra(KEY_FOREGROUND_SERVICE_TYPE, r102.getForegroundServiceType());
        r103.putExtra(KEY_NOTIFICATION, r102.getNotification());
        r103.putExtra(KEY_WORKSPEC_ID, r101);
        return r103;
    }
}
