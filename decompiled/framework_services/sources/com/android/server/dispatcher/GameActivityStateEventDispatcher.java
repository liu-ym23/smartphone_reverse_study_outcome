package com.android.server.dispatcher;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.util.Slog;
import android.view.SurfaceControl;
import com.android.server.am.HostingRecord;
import com.android.server.scene.SceneUtils;
import com.android.server.wm.ActivityRecord;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class GameActivityStateEventDispatcher extends AbsDispatcher<GameActivityStateObserver> {
    private static final AbsDispatcher.Lazy<GameActivityStateEventDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.GameActivityStateEventDispatcher";
    private RecordActivity mFirstCreateFullActivity;
    private RecordActivity mResumedActivity;

    public static class RecordActivity {
        public static final String TAG = "RecordActivity";
        public final ComponentName mActivity;
        public final int mActivityType;
        public final int mDisplayId;
        public final ActivityInfo mInfo;
        public final int mPid;
        public final ActivityRecord mRecord;
        public final int mStackId;
        public final SurfaceControl mSurfaceControl;
        public final int mTaskHashcode;
        public final IBinder mToken;
        public final int mUserId;
        public final int mWindowMode;

        public RecordActivity(ActivityRecord record, ComponentName activity, int windowMode, int activityType, int displayId, ActivityInfo info, int pid, int userId, int stackId, int taskHashcode) {
            this.mRecord = record;
            this.mActivity = activity;
            this.mWindowMode = windowMode;
            this.mActivityType = activityType;
            this.mDisplayId = displayId;
            this.mInfo = info;
            this.mPid = pid;
            this.mUserId = userId;
            this.mStackId = stackId;
            this.mTaskHashcode = taskHashcode;
            if (record == null) goto L5;
            SurfaceControl r0 = record.getSurfaceControl();
        L6:
            this.mSurfaceControl = r0;
            IBinder token = null;
            Field field = this.mRecord.getClass().getDeclaredField("token");     // Catch: Exception -> L9
            field.setAccessible(true);     // Catch: Exception -> L9
            token = (IBinder) field.get(this.mRecord);     // Catch: Exception -> L9
        L11:
            this.mToken = token;
            return;
        L9:
            e = move-exception;
            Log.i(TAG, "RecordActivity token: " + e.getMessage());
            goto L11
        L5:
            r0 = null;
            goto L6
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("window_mode", this.mWindowMode);
            bundle.putInt("activity_type", this.mActivityType);
            bundle.putInt("display_id", this.mDisplayId);
            bundle.putInt(SceneUtils.KEY_PID, this.mPid);
            bundle.putInt("user_id", this.mUserId);
            bundle.putInt("stack_id", this.mStackId);
            bundle.putInt("task_hash_code", this.mTaskHashcode);
            bundle.putParcelable(HostingRecord.HOSTING_TYPE_ACTIVITY, this.mActivity);
            bundle.putParcelable("info", this.mInfo);
            bundle.putBinder("token", this.mToken);
            return bundle;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L33:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L33;
            RecordActivity that = (RecordActivity) o;
            if (this.mWindowMode != that.mWindowMode) goto L32;
            if (this.mActivityType != that.mActivityType) goto L32;
            if (this.mDisplayId != that.mDisplayId) goto L32;
            if (this.mPid != that.mPid) goto L32;
            if (this.mUserId != that.mUserId) goto L32;
            if (this.mStackId != that.mStackId) goto L32;
            if (this.mTaskHashcode != that.mTaskHashcode) goto L32;
            if (Objects.equals(this.mRecord, that.mRecord) == false) goto L32;
            if (Objects.equals(this.mActivity, that.mActivity) == false) goto L32;
            if (Objects.equals(this.mInfo, that.mInfo) == false) goto L32;
            return true;
        L32:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mRecord, this.mActivity, Integer.valueOf(this.mWindowMode), Integer.valueOf(this.mActivityType), Integer.valueOf(this.mDisplayId), this.mInfo, Integer.valueOf(this.mPid), Integer.valueOf(this.mUserId), Integer.valueOf(this.mStackId), Integer.valueOf(this.mTaskHashcode)});
        }

        public String toString() {
            return "RecordActivity{mActivity=" + this.mActivity + ", mWindowMode=" + this.mWindowMode + ", mActivityType=" + this.mActivityType + ", mDisplayId=" + this.mDisplayId + ", mPid=" + this.mPid + ", mUserId=" + this.mUserId + ", mStackId=" + this.mStackId + ", mTaskHashcode=" + this.mTaskHashcode + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$9Cb_goSH8rOY1Zt_tuF3kPg0iVM(GameActivityStateEventDispatcher r0, int r1, ActivityInfo r2, int r3, int r4, int r5, int r6, ActivityRecord r7, ComponentName r8, int r9, int r10) {
        r0.lambda$notifyGameFullActivityFirstCreate$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ GameActivityStateEventDispatcher $r8$lambda$GaerXPfFdgvHb1tJUdvos4ecQiw() {
        return new GameActivityStateEventDispatcher();
    }

    /* JADX INFO: renamed from: $r8$lambda$_jQ1i8N3UFpjQ-FnIJ4Em_ueBNo, reason: not valid java name */
    public static /* synthetic */ void m3553$r8$lambda$_jQ1i8N3UFpjQFnIJ4Em_ueBNo(GameActivityStateEventDispatcher r0, GameActivityStateObserver r1) {
        r0.lambda$notifyGameFullActivityFirstCreate$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$g18PEvhTM0avVPv7vhA-qGL6YCk, reason: not valid java name */
    public static /* synthetic */ void m3554$r8$lambda$g18PEvhTM0avVPv7vhAqGL6YCk(RecordActivity r0, GameActivityStateObserver r1) {
        lambda$notifyGameActivityResumed$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$t9LnXbOlWzzLnqfzyn139ZWYPEo(GameActivityStateEventDispatcher r0, int r1, ActivityInfo r2, int r3, int r4, int r5, int r6, ActivityRecord r7, ComponentName r8, int r9, int r10) {
        r0.lambda$notifyGameActivityResumed$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new GameActivityStateEventDispatcher$$ExternalSyntheticLambda4());
    }

    private GameActivityStateEventDispatcher() {
    }

    public static GameActivityStateEventDispatcher getInstance() {
        return (GameActivityStateEventDispatcher) INSTANCE.get();
    }

    public RecordActivity getCreateFullActivity() {
        return this.mFirstCreateFullActivity;
    }

    public RecordActivity getResumedActivity() {
        return this.mResumedActivity;
    }

    private /* synthetic */ void lambda$notifyGameFullActivityFirstCreate$0(int displayId, ActivityInfo info, int stackId, int pid, int windowMode, int activityType, ActivityRecord record, ComponentName component, int userId, int taskHashcode) {
        notifyGameFullActivityFirstCreate(displayId, info, stackId, pid, windowMode, activityType, record, component, userId, taskHashcode);
    }

    public void notifyGameFullActivityFirstCreate(final int displayId, final ActivityInfo info, final int stackId, final int pid, final int windowMode, final int activityType, final ActivityRecord record, final ComponentName component, final int userId, final int taskHashcode) {
        if (switchThreads(new GameActivityStateEventDispatcher$$ExternalSyntheticLambda2(this, displayId, info, stackId, pid, windowMode, activityType, record, component, userId, taskHashcode)) == false) goto L5;
        return;
    L5:
        this.mFirstCreateFullActivity = new RecordActivity(record, component, windowMode, activityType, displayId, info, pid, userId, stackId, taskHashcode);
        notifyObserver(new GameActivityStateEventDispatcher$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$notifyGameFullActivityFirstCreate$1(GameActivityStateObserver observer) {
        observer.onFullActivityFirstCreate(this.mFirstCreateFullActivity);
    }

    private /* synthetic */ void lambda$notifyGameActivityResumed$2(int displayId, ActivityInfo info, int stackId, int pid, int windowMode, int activityType, ActivityRecord record, ComponentName component, int userId, int taskHashcode) {
        notifyGameActivityResumed(displayId, info, stackId, pid, windowMode, activityType, record, component, userId, taskHashcode);
    }

    public void notifyGameActivityResumed(final int displayId, final ActivityInfo info, final int stackId, final int pid, final int windowMode, final int activityType, final ActivityRecord record, final ComponentName component, final int userId, final int taskHashcode) {
        if (switchThreads(new GameActivityStateEventDispatcher$$ExternalSyntheticLambda0(this, displayId, info, stackId, pid, windowMode, activityType, record, component, userId, taskHashcode)) == false) goto L6;
        return;
    L6:
        if ("com.tencent.mm".equals(component.getPackageName()) == false) goto L8;
        int code = taskHashcode;
    L9:
        final RecordActivity resumedActivity = new RecordActivity(record, component, windowMode, activityType, displayId, info, pid, userId, stackId, code);
        notifyObserver(new GameActivityStateEventDispatcher$$ExternalSyntheticLambda1(resumedActivity));
        if (this.mObservers.size() != 0) goto L13;
        Slog.e(TAG, "notifyGameActivityResumed error instance");
        return;
    L13:
        return;
    L8:
        code = 0;
        goto L9
    }

    private static /* synthetic */ void lambda$notifyGameActivityResumed$3(RecordActivity resumedActivity, GameActivityStateObserver observer) {
        observer.onActivityResumed(resumedActivity);
    }
}
