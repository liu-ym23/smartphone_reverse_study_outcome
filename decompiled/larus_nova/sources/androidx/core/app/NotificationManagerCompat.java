package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = null;
    private static final Object sLock = null;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static List<StatusBarNotification> getActiveNotifications(NotificationManager r100) {
            StatusBarNotification[] r101 = r100.getActiveNotifications();
            if (r101 != null) goto L7;
            return new ArrayList();
        L7:
            return Arrays.asList(r101);
        }

        public static int getCurrentInterruptionFilter(NotificationManager r100) {
            return r100.getCurrentInterruptionFilter();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean areNotificationsEnabled(NotificationManager r100) {
            return r100.areNotificationsEnabled();
        }

        public static int getImportance(NotificationManager r100) {
            return r100.getImportance();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static String getId(NotificationChannel r100) {
            return r100.getId();
        }

        public static List<NotificationChannelGroup> getNotificationChannelGroups(NotificationManager r100) {
            return r100.getNotificationChannelGroups();
        }

        public static List<NotificationChannel> getNotificationChannels(NotificationManager r100) {
            return r100.getNotificationChannels();
        }

        public static String getId(NotificationChannelGroup r100) {
            return r100.getId();
        }

        public static void createNotificationChannel(NotificationManager r100, NotificationChannel r101) {
            r100.createNotificationChannel(r101);
        }

        public static void createNotificationChannelGroup(NotificationManager r100, NotificationChannelGroup r101) {
            r100.createNotificationChannelGroup(r101);
        }

        public static void createNotificationChannelGroups(NotificationManager r100, List<NotificationChannelGroup> r101) {
            r100.createNotificationChannelGroups(r101);
        }

        public static void createNotificationChannels(NotificationManager r100, List<NotificationChannel> r101) {
            r100.createNotificationChannels(r101);
        }

        public static void deleteNotificationChannel(NotificationManager r100, String r101) {
            r100.deleteNotificationChannel(r101);
        }

        public static void deleteNotificationChannelGroup(NotificationManager r100, String r101) {
            r100.deleteNotificationChannelGroup(r101);
        }

        public static NotificationChannel getNotificationChannel(NotificationManager r100, String r101) {
            return r100.getNotificationChannel(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static NotificationChannelGroup getNotificationChannelGroup(NotificationManager r100, String r101) {
            return r100.getNotificationChannelGroup(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static String getParentChannelId(NotificationChannel r100) {
            return r100.getParentChannelId();
        }

        public static NotificationChannel getNotificationChannel(NotificationManager r100, String r101, String r102) {
            return r100.getNotificationChannel(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static boolean canUseFullScreenIntent(NotificationManager r100) {
            return r100.canUseFullScreenIntent();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class CancelTask implements Task {
        final boolean all;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f15337id;
        final String packageName;
        final String tag;

        public String toString() {
            return "CancelTask[packageName:" + this.packageName + ", id:" + this.f15337id + ", tag:" + this.tag + ", all:" + this.all + "]";
        }

        public CancelTask(String r100) {
            this.packageName = r100;
            this.f15337id = 0;
            this.tag = null;
            this.all = true;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel r100) throws RemoteException {
            if (this.all == false) goto L5;
            r100.cancelAll(this.packageName);
            return;
        L5:
            r100.cancel(this.packageName, this.f15337id, this.tag);
        }

        public CancelTask(String r100, int r101, String r102) {
            this.packageName = r100;
            this.f15337id = r101;
            this.tag = r102;
            this.all = false;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class NotificationWithIdAndTag {
        final int mId;
        Notification mNotification;
        final String mTag;

        public NotificationWithIdAndTag(int r100, Notification r101) {
            this(null, r100, r101);
        }

        public NotificationWithIdAndTag(String r100, int r101, Notification r102) {
            this.mTag = r100;
            this.mId = r101;
            this.mNotification = r102;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class NotifyTask implements Task {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f15338id;
        final Notification notif;
        final String packageName;
        final String tag;

        public String toString() {
            return "NotifyTask[packageName:" + this.packageName + ", id:" + this.f15338id + ", tag:" + this.tag + "]";
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel r100) throws RemoteException {
            r100.notify(this.packageName, this.f15338id, this.tag, this.notif);
        }

        public NotifyTask(String r100, int r101, String r102, Notification r103) {
            this.packageName = r100;
            this.f15338id = r101;
            this.tag = r102;
            this.notif = r103;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName r100, IBinder r101) {
            this.componentName = r100;
            this.iBinder = r101;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap;

        public static class ListenerRecord {
            boolean bound;
            final ComponentName componentName;
            int retryCount;
            INotificationSideChannel service;
            ArrayDeque<Task> taskQueue;

            public ListenerRecord(ComponentName r100) {
                this.bound = false;
                this.taskQueue = new ArrayDeque();
                this.retryCount = 0;
                this.componentName = r100;
            }
        }

        private void updateListenerMap() {
            Set<String> r100 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (r100.equals(this.mCachedEnabledPackages) == false) goto L5;
            return;
        L5:
            this.mCachedEnabledPackages = r100;
            List<ResolveInfo> r101 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet r102 = new HashSet();
            Iterator<ResolveInfo> r103 = r101.iterator();
        L7:
            if (r103.hasNext() == false) goto L15;
            ResolveInfo r104 = r103.next();
            if (r100.contains(r104.serviceInfo.packageName) == false) goto L7;
            ServiceInfo r105 = r104.serviceInfo;
            ComponentName r106 = new ComponentName(r105.packageName, r105.name);
            if (r104.serviceInfo.permission != null) goto L13;
            r102.add(r106);
            goto L7
        L13:
            r106.toString();
            goto L7
        L15:
            Iterator r107 = r102.iterator();
        L17:
            if (r107.hasNext() == false) goto L24;
            ComponentName r108 = (ComponentName) r107.next();
            if (this.mRecordMap.containsKey(r108) == true) goto L17;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L23;
            Objects.toString(r108);
        L23:
            this.mRecordMap.put(r108, new ListenerRecord(r108));
            goto L17
        L24:
            Iterator<Map.Entry<ComponentName, ListenerRecord>> r109 = this.mRecordMap.entrySet().iterator();
        L26:
            if (r109.hasNext() == false) goto L33;
            Map.Entry<ComponentName, ListenerRecord> r110 = r109.next();
            if (r102.contains(r110.getKey()) == true) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L32;
            Objects.toString(r110.getKey());
        L32:
            ensureServiceUnbound(r110.getValue());
            r109.remove();
            goto L26
        }

        public SideChannelManager(Context r100) {
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = r100;
            PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("NotificationManagerCompat");
            this.mHandlerThread = r101;
            ThreadMethodProxy.start(r101);
            this.mHandler = new Handler(r101.getLooper(), this);
        }

        private boolean ensureServiceBound(ListenerRecord r100) {
            if (r100.bound == false) goto L6;
            return true;
        L6:
            Intent r101 = new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(r100.componentName);
            boolean r102 = this.mContext.bindService(r101, this, 33);
            r100.bound = r102;
            if (r102 == false) goto L9;
            r100.retryCount = 0;
        L11:
            return r100.bound;
        L9:
            Objects.toString(r100.componentName);
            this.mContext.unbindService(this);
            goto L11
        }

        private void ensureServiceUnbound(ListenerRecord r100) {
            if (r100.bound == false) goto L5;
            this.mContext.unbindService(this);
            r100.bound = false;
        L5:
            r100.service = null;
        }

        private void handleQueueTask(Task r100) {
            updateListenerMap();
            Iterator<ListenerRecord> r101 = this.mRecordMap.values().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ListenerRecord r102 = r101.next();
            r102.taskQueue.add(r100);
            processListenerQueue(r102);
            goto L4
        }

        private void handleRetryListenerQueue(ComponentName r100) {
            ListenerRecord r101 = this.mRecordMap.get(r100);
            if (r101 == null) goto L6;
            processListenerQueue(r101);
            return;
        }

        private void handleServiceDisconnected(ComponentName r100) {
            ListenerRecord r101 = this.mRecordMap.get(r100);
            if (r101 == null) goto L6;
            ensureServiceUnbound(r101);
            return;
        }

        private void processListenerQueue(ListenerRecord r100) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L6;
            Objects.toString(r100.componentName);
            r100.taskQueue.size();
        L6:
            if (r100.taskQueue.isEmpty() == false) goto L9;
            return;
        L9:
            if (ensureServiceBound(r100) == true) goto L11;
        L29:
            scheduleListenerRetry(r100);
            return;
        L11:
            if (r100.service == null) goto L29;
        L13:
            Task r101 = r100.taskQueue.peek();
            if (r101 == null) goto L26;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L19;
            r101.toString();     // Catch: RemoteException -> L21 DeadObjectException -> L22
        L19:
            r101.send(r100.service);     // Catch: RemoteException -> L21 DeadObjectException -> L22
            r100.taskQueue.remove();     // Catch: RemoteException -> L21 DeadObjectException -> L22
            goto L13
        L21:
            Objects.toString(r100.componentName);
        L23:
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L26;
            Objects.toString(r100.componentName);
        L26:
            if (r100.taskQueue.isEmpty() == true) goto L36;
            scheduleListenerRetry(r100);
            return;
        }

        private void scheduleListenerRetry(ListenerRecord r100) {
            if (this.mHandler.hasMessages(3, r100.componentName) == false) goto L5;
            return;
        L5:
            int r101 = r100.retryCount + 1;
            r100.retryCount = r101;
            if (r101 <= 6) goto L9;
            r100.taskQueue.size();
            Objects.toString(r100.componentName);
            r100.taskQueue.clear();
            return;
        L9:
            int r102 = (1 << (r101 - 1)) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == true) goto L12;
        L12:
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, r100.componentName), r102);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 == 0) goto L17;
            if (r101 != 1) goto L6;
            ServiceConnectedEvent r102 = (ServiceConnectedEvent) r100.obj;
            handleServiceConnected(r102.componentName, r102.iBinder);
            return true;
        L6:
            if (r101 != 2) goto L8;
            handleServiceDisconnected((ComponentName) r100.obj);
            return true;
        L8:
            if (r101 == 3) goto L11;
            return false;
        L11:
            handleRetryListenerQueue((ComponentName) r100.obj);
            return true;
        L17:
            handleQueueTask((Task) r100.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Objects.toString(r100);
        L5:
            this.mHandler.obtainMessage(2, r100).sendToTarget();
        }

        public void queueTask(Task r100) {
            this.mHandler.obtainMessage(0, r100).sendToTarget();
        }

        private void handleServiceConnected(ComponentName r100, IBinder r101) {
            ListenerRecord r102 = this.mRecordMap.get(r100);
            if (r102 == null) goto L6;
            r102.service = INotificationSideChannel.Stub.asInterface(r101);
            r102.retryCount = 0;
            processListenerQueue(r102);
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r100, IBinder r101) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3) == false) goto L5;
            Objects.toString(r100);
        L5:
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(r100, r101)).sendToTarget();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface Task {
        void send(INotificationSideChannel r100) throws RemoteException;
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        AppOpsManager r100 = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo r101 = this.mContext.getApplicationInfo();
        String r102 = this.mContext.getApplicationContext().getPackageName();
        int r103 = r101.uid;
        Class r104 = INVOKESTATIC_androidx_core_app_NotificationManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppOpsManager.class.getName());     // Catch: Throwable -> L12
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L12
        if (((Integer) r104.getMethod(CHECK_OP_NO_THROW, new Class[]{r105, r105, String.class}).invoke(r100, new Object[]{Integer.valueOf(((Integer) r104.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(r103), r102})).intValue() == 0) goto L15;
        return false;
    L15:
        return true;
    L16:
        return true;
    L5:
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public boolean canUseFullScreenIntent() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 29) goto L6;
        return true;
    L6:
        if (r100 >= 34) goto L13;
        if (androidx_core_app_NotificationManagerCompat_android_content_Context_checkSelfPermission(this.mContext, "android.permission.USE_FULL_SCREEN_INTENT") == 0) goto L14;
        return false;
    L14:
        return true;
    L13:
        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public List<StatusBarNotification> getActiveNotifications() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getActiveNotifications(this.mNotificationManager);
    L7:
        return new ArrayList();
    }

    public int getCurrentInterruptionFilter() {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return 0;
    L7:
        return Api23Impl.getCurrentInterruptionFilter(this.mNotificationManager);
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return -1000;
    L5:
        return Api24Impl.getImportance(this.mNotificationManager);
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 26) goto L19;
        List<NotificationChannelGroup> r101 = getNotificationChannelGroups();
        if (r101.isEmpty() == true) goto L19;
        if (r100 < 28) goto L9;
        List<NotificationChannel> r102 = Collections.emptyList();
    L10:
        ArrayList r103 = new ArrayList(r101.size());
        Iterator<NotificationChannelGroup> r104 = r101.iterator();
    L12:
        if (r104.hasNext() == false) goto L17;
        NotificationChannelGroup r105 = r104.next();
        if (Build.VERSION.SDK_INT >= 28) goto L15;
        r103.add(new NotificationChannelGroupCompat(r105, r102));
        goto L12
    L15:
        r103.add(new NotificationChannelGroupCompat(r105));
        goto L12
    L17:
        return r103;
    L9:
        r102 = getNotificationChannels();
    L19:
        return Collections.emptyList();
    }

    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getNotificationChannels(this.mNotificationManager);
    L7:
        return Collections.emptyList();
    }

    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        List<NotificationChannel> r100 = getNotificationChannels();
        if (r100.isEmpty() == true) goto L12;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<NotificationChannel> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(new NotificationChannelCompat(r102.next()));
        goto L8
    L10:
        return r101;
    L12:
        return Collections.emptyList();
    }

    private NotificationManagerCompat(Context r100) {
        this.mContext = r100;
        this.mNotificationManager = (NotificationManager) r100.getSystemService("notification");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_app_NotificationManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static NotificationManagerCompat from(Context r100) {
        return new NotificationManagerCompat(r100);
    }

    public static Set<String> getEnabledListenerPackages(Context r100) {
        String r101 = androidx_core_app_NotificationManagerCompat_android_provider_Settings$Secure_getString(r100.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        Object r102 = sEnabledNotificationListenersLock;
        monitor-enter(r102);
        if (r101 != null) goto L20;
    L14:
        Set<String> r103 = sEnabledNotificationListenerPackages;     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return r103;
    L17:
        th = move-exception;
        throw th;
    L20:
        if (r101.equals(sEnabledNotificationListeners) == true) goto L14;
        String[] r104 = r101.split(":", -1);     // Catch: Throwable -> L17
        HashSet r105 = new HashSet(r104.length);     // Catch: Throwable -> L17
        int r106 = r104.length;     // Catch: Throwable -> L17
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L13;
        ComponentName r108 = ComponentName.unflattenFromString(r104[r107]);     // Catch: Throwable -> L17
        if (r108 == null) goto L12;
        r105.add(r108.getPackageName());     // Catch: Throwable -> L17
    L12:
        r107 = r107 + 1;     // Catch: Throwable -> L17
        goto L8
    L13:
        sEnabledNotificationListenerPackages = r105;     // Catch: Throwable -> L17
        sEnabledNotificationListeners = r101;     // Catch: Throwable -> L17
        goto L14
    }

    private void pushSideChannelQueue(Task r100) {
        Object r101 = sLock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSideChannelManager != null) goto L7;
        sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        sSideChannelManager.queueTask(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    private static boolean useSideChannelForNotification(Notification r100) {
        Bundle r101 = NotificationCompat.getExtras(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getBoolean(EXTRA_USE_SIDE_CHANNEL) == false) goto L7;
        return true;
    }

    public void cancel(int r100) {
        cancel(null, r100);
    }

    public void createNotificationChannel(NotificationChannel r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannel(this.mNotificationManager, r100);
        return;
    }

    public void createNotificationChannelGroup(NotificationChannelGroup r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroup(this.mNotificationManager, r100);
        return;
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r100);
        return;
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L14;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<NotificationChannelGroupCompat> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(r102.next().getNotificationChannelGroup());
        goto L8
    L10:
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, r101);
        return;
    }

    public void createNotificationChannels(List<NotificationChannel> r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.createNotificationChannels(this.mNotificationManager, r100);
        return;
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L14;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<NotificationChannelCompat> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.add(r102.next().getNotificationChannel());
        goto L8
    L10:
        Api26Impl.createNotificationChannels(this.mNotificationManager, r101);
        return;
    }

    public void deleteNotificationChannel(String r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, r100);
        return;
    }

    public void deleteNotificationChannelGroup(String r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, r100);
        return;
    }

    public void deleteUnlistedNotificationChannels(Collection<String> r100) {
        if (Build.VERSION.SDK_INT < 26) goto L16;
        Iterator<NotificationChannel> r101 = Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
    L6:
        if (r101.hasNext() == false) goto L25;
        NotificationChannel r102 = r101.next();
        if (r100.contains(Api26Impl.getId(r102)) == true) goto L6;
        if (Build.VERSION.SDK_INT < 30) goto L15;
        if (r100.contains(Api30Impl.getParentChannelId(r102)) == true) goto L6;
    L15:
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(r102));
        goto L6
    L25:
        return;
    }

    public NotificationChannel getNotificationChannel(String r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.getNotificationChannel(this.mNotificationManager, r100);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r100) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r101 = getNotificationChannel(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r101);
    L8:
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L7;
        return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, r100);
    L7:
        if (r101 < 26) goto L14;
        Iterator<NotificationChannelGroup> r102 = getNotificationChannelGroups().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        NotificationChannelGroup r103 = r102.next();
        if (Api26Impl.getId(r103).equals(r100) == false) goto L10;
        return r103;
    L14:
        return null;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L9;
        NotificationChannelGroup r102 = getNotificationChannelGroup(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelGroupCompat(r102);
    L9:
        if (r101 < 26) goto L16;
        NotificationChannelGroup r103 = getNotificationChannelGroup(r100);
        if (r103 != null) goto L13;
        return null;
    L13:
        return new NotificationChannelGroupCompat(r103, getNotificationChannels());
    L16:
        return null;
    }

    public void notify(List<NotificationWithIdAndTag> r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        NotificationWithIdAndTag r103 = (NotificationWithIdAndTag) ListProtector.get(r100, r102);
        notify(r103.mTag, r103.mId, r103.mNotification);
        r102 = r102 + 1;
        goto L3
    }

    public void createNotificationChannel(NotificationChannelCompat r100) {
        createNotificationChannel(r100.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat r100) {
        createNotificationChannelGroup(r100.getNotificationChannelGroup());
    }

    public NotificationManagerCompat(NotificationManager r100, Context r101) {
        this.mContext = r101;
        this.mNotificationManager = r100;
    }

    private static int androidx_core_app_NotificationManagerCompat_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_androidx_core_app_NotificationManagerCompat_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String androidx_core_app_NotificationManagerCompat_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    public void cancel(String r100, int r101) {
        this.mNotificationManager.cancel(r100, r101);
    }

    public NotificationChannel getNotificationChannel(String r100, String r101) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getNotificationChannel(this.mNotificationManager, r100, r101);
    L7:
        return getNotificationChannel(r100);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String r100, String r101) {
        if (Build.VERSION.SDK_INT < 26) goto L8;
        NotificationChannel r102 = getNotificationChannel(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new NotificationChannelCompat(r102);
    L8:
        return null;
    }

    public void notify(int r100, Notification r101) {
        notify(null, r100, r101);
    }

    public void notify(String r100, int r101, Notification r102) {
        if (useSideChannelForNotification(r102) == false) goto L5;
        pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), r101, r100, r102));
        this.mNotificationManager.cancel(r100, r101);
        return;
    L5:
        this.mNotificationManager.notify(r100, r101, r102);
    }
}
