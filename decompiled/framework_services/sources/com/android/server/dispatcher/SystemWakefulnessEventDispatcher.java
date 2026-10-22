package com.android.server.dispatcher;

import android.os.Bundle;
import android.os.SystemClock;
import com.android.server.policy.PhoneWindowManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SystemWakefulnessEventDispatcher extends AbsDispatcher<SystemWakefulnessObserver> {
    private static final AbsDispatcher.Lazy<SystemWakefulnessEventDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.SystemWakefulnessEventDispatcher";
    public static final int WAKEFULNESS_ASLEEP = 0;
    public static final int WAKEFULNESS_AWAKE = 1;
    public static final int WAKEFULNESS_DOZING = 3;
    public static final int WAKEFULNESS_DREAMING = 2;
    private GlobalWakefulness mGlobalWakefulness;
    private Wakefulness mWakefulness;

    public static class GlobalWakefulness {
        public final String details;
        public final long eventTime;
        public final long mTime;
        public final int newWakefulness;
        public final String opPackageName;
        public final int reason;
        public final int uid;

        /* synthetic */ GlobalWakefulness(int r1, long r2, int r4, int r5, String r6, String r7, SystemWakefulnessEventDispatcherIA r8) {
            this(r1, r2, r4, r5, r6, r7);
        }

        private GlobalWakefulness(int newWakefulness, long eventTime, int uid, int reason, String details, String opPackageName) {
            this.newWakefulness = newWakefulness;
            this.eventTime = eventTime;
            this.uid = uid;
            this.reason = reason;
            this.details = details;
            this.opPackageName = opPackageName;
            this.mTime = SystemClock.elapsedRealtime();
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L25:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L25;
            GlobalWakefulness that = (GlobalWakefulness) o;
            if (this.newWakefulness != that.newWakefulness) goto L24;
            if (this.eventTime != that.eventTime) goto L24;
            if (this.uid != that.uid) goto L24;
            if (this.reason != that.reason) goto L24;
            if (Objects.equals(this.details, that.details) == false) goto L24;
            if (Objects.equals(this.opPackageName, that.opPackageName) == false) goto L24;
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.newWakefulness), Long.valueOf(this.eventTime), Integer.valueOf(this.uid), Integer.valueOf(this.reason), this.details, this.opPackageName});
        }

        public String toString() {
            return "GlobalWakefulness{newWakefulness=" + this.newWakefulness + ", eventTime=" + this.eventTime + ", uid=" + this.uid + ", reason=" + this.reason + ", details='" + this.details + "', opPackageName='" + this.opPackageName + "'}";
        }

        public Bundle toBundle() {
            Bundle data = new Bundle();
            data.putInt("wakefulness", this.newWakefulness);
            data.putLong("eventTime", this.eventTime);
            data.putInt("uid", this.uid);
            data.putInt(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, this.reason);
            data.putString("details", this.details);
            data.putString("opPackageName", this.opPackageName);
            data.putLong("time", this.mTime);
            return data;
        }
    }

    public static class Wakefulness {
        public final int mGroupId;
        public final boolean mIsDozing;
        public final long mTime;
        public final int mWakefulness;

        /* synthetic */ Wakefulness(boolean r1, int r2, int r3, SystemWakefulnessEventDispatcherIA r4) {
            this(r1, r2, r3);
        }

        private Wakefulness(boolean isDozing, int groupId, int wakefulness) {
            this.mIsDozing = isDozing;
            this.mGroupId = groupId;
            this.mWakefulness = wakefulness;
            this.mTime = SystemClock.elapsedRealtime();
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L19;
            Wakefulness that = (Wakefulness) o;
            if (this.mIsDozing != that.mIsDozing) goto L18;
            if (this.mGroupId != that.mGroupId) goto L18;
            if (this.mWakefulness != that.mWakefulness) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.mIsDozing), Integer.valueOf(this.mGroupId), Integer.valueOf(this.mWakefulness)});
        }

        public String toString() {
            return "Wakefulness{mIsDozing=" + this.mIsDozing + ", mGroupId=" + this.mGroupId + ", mWakefulness=" + this.mWakefulness + '}';
        }

        public Bundle toBundle() {
            Bundle data = new Bundle();
            data.putBoolean("doze", this.mIsDozing);
            data.putInt("groupId", this.mGroupId);
            data.putInt("wakefulness", this.mWakefulness);
            data.putLong("time", this.mTime);
            return data;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$b-O9i7KkaBcmZp7FBjbcZYYRIe0, reason: not valid java name */
    public static /* synthetic */ void m3557$r8$lambda$bO9i7KkaBcmZp7FBjbcZYYRIe0(SystemWakefulnessEventDispatcher r0, int r1, long r2, int r4, int r5, String r6, String r7) {
        r0.lambda$notifyGlobalWakefulnessChanged$0(r1, r2, r4, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$cPtdN47Ixn4WKew0Osb5wFwhd6Q(SystemWakefulnessEventDispatcher r0, SystemWakefulnessObserver r1) {
        r0.lambda$onUpdateGlobalWakefulnessIntner$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$oIqnDCA6poUX0y-sqNBBJwAWXDQ, reason: not valid java name */
    public static /* synthetic */ SystemWakefulnessEventDispatcher m3558$r8$lambda$oIqnDCA6poUX0ysqNBBJwAWXDQ() {
        return new SystemWakefulnessEventDispatcher();
    }

    /* JADX INFO: renamed from: $r8$lambda$u9rhgsTLEE4Y6mz_qwWcgB-Tmx8, reason: not valid java name */
    public static /* synthetic */ void m3559$r8$lambda$u9rhgsTLEE4Y6mz_qwWcgBTmx8(SystemWakefulnessEventDispatcher r0, Wakefulness r1, boolean r2) {
        r0.lambda$onWakefulnessChangedIntner$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$v2jYTff7jeqeUqUsfZEMNJonDrM(SystemWakefulnessEventDispatcher r0, SystemWakefulnessObserver r1) {
        r0.lambda$onWakefulnessChangedIntner$3(r1);
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new SystemWakefulnessEventDispatcher$$ExternalSyntheticLambda1());
    }

    private SystemWakefulnessEventDispatcher() {
    }

    public static SystemWakefulnessEventDispatcher getInstance() {
        return (SystemWakefulnessEventDispatcher) INSTANCE.get();
    }

    public GlobalWakefulness getGlobalWakefulness() {
        return this.mGlobalWakefulness;
    }

    public Wakefulness getWakefulness() {
        return this.mWakefulness;
    }

    private /* synthetic */ void lambda$notifyGlobalWakefulnessChanged$0(int newWakefulness, long eventTime, int uid, int reason, String details, String opPackageName) {
        notifyGlobalWakefulnessChanged(newWakefulness, eventTime, uid, reason, details, opPackageName);
    }

    public void notifyGlobalWakefulnessChanged(final int newWakefulness, final long eventTime, final int uid, final int reason, final String details, final String opPackageName) {
        if (switchThreads(new SystemWakefulnessEventDispatcher$$ExternalSyntheticLambda2(this, newWakefulness, eventTime, uid, reason, details, opPackageName)) == false) goto L5;
        return;
    L5:
        GlobalWakefulness globalWakefulness = new GlobalWakefulness(newWakefulness, eventTime, uid, reason, details, opPackageName, null);
        onUpdateGlobalWakefulnessIntner(globalWakefulness, false);
    }

    private void onUpdateGlobalWakefulnessIntner(GlobalWakefulness globalWakefulness, boolean notify) {
        if (notify == false) goto L4;
    L5:
        this.mGlobalWakefulness = globalWakefulness;
        notifyObserver(new SystemWakefulnessEventDispatcher$$ExternalSyntheticLambda0(this));
        return;
    L4:
        if (globalWakefulness.equals(this.mGlobalWakefulness) == false) goto L5;
    }

    private /* synthetic */ void lambda$onUpdateGlobalWakefulnessIntner$1(SystemWakefulnessObserver observer) {
        observer.onUpdateGlobalWakefulness(this.mGlobalWakefulness);
    }

    public void notifyWakefulnessChanged(int groupId, int wakefulness) {
        if (wakefulness != 3) goto L5;
        boolean isDozing = true;
    L6:
        onWakefulnessChangedIntner(new Wakefulness(isDozing, groupId, wakefulness, null), false);
        return;
    L5:
        isDozing = false;
        goto L6
    }

    private /* synthetic */ void lambda$onWakefulnessChangedIntner$2(Wakefulness wakefulness, boolean notify) {
        onWakefulnessChangedIntner(wakefulness, notify);
    }

    private void onWakefulnessChangedIntner(final Wakefulness wakefulness, final boolean notify) {
        if (switchThreads(new SystemWakefulnessEventDispatcher$$ExternalSyntheticLambda3(this, wakefulness, notify)) == false) goto L5;
        return;
    L5:
        if (notify == false) goto L7;
    L8:
        this.mWakefulness = wakefulness;
        notifyObserver(new SystemWakefulnessEventDispatcher$$ExternalSyntheticLambda4(this));
        return;
    L7:
        if (wakefulness.equals(this.mWakefulness) == false) goto L8;
    }

    private /* synthetic */ void lambda$onWakefulnessChangedIntner$3(SystemWakefulnessObserver observer) {
        observer.onWakefulnessChanged(this.mWakefulness);
    }
}
