package com.android.server.flags;

import android.flags.IFeatureFlagsCallback;
import android.flags.SyncableFlag;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.DeviceConfig;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class DynamicFlagBinderDelegate {
    private static final Function<Integer, Set<IFeatureFlagsCallback>> NEW_CALLBACK_SET = null;
    private final Map<Integer, Set<IFeatureFlagsCallback>> mCallbacks;
    private final DeviceConfig.OnPropertiesChangedListener mDeviceConfigListener;
    private final FlagCache<DynamicFlagData> mDynamicFlags;
    private final FlagOverrideStore.FlagChangeCallback mFlagChangeCallback;
    private final FlagOverrideStore mFlagStore;

    private class BinderGriever implements IBinder.DeathRecipient {
        private final int mPid;
        final /* synthetic */ DynamicFlagBinderDelegate this$0;

        /* synthetic */ BinderGriever(DynamicFlagBinderDelegate r1, int r2, DynamicFlagBinderDelegateIA r3) {
            this(r1, r2);
        }

        private BinderGriever(DynamicFlagBinderDelegate r1, int pid) {
            this.this$0 = r1;
            this.mPid = pid;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Map r0 = DynamicFlagBinderDelegate.m4236$$Nest$fgetmCallbacks(this.this$0);
            monitor-enter(r0);
            DynamicFlagBinderDelegate.m4236$$Nest$fgetmCallbacks(this.this$0).remove(Integer.valueOf(this.mPid));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class DynamicFlagData {
        private String mDefaultValue;
        private final String mName;
        private final String mNamespace;
        private final Set<Integer> mPids;
        private String mValue;

        /* synthetic */ DynamicFlagData(String r1, String r2, DynamicFlagBinderDelegateIA r3) {
            this(r1, r2);
        }

        private DynamicFlagData(String namespace, String name) {
            this.mPids = new HashSet();
            this.mNamespace = namespace;
            this.mName = name;
        }

        String getValue() {
            return this.mValue;
        }

        void setValue(String value) {
            this.mValue = value;
        }

        String getDefaultValue() {
            return this.mDefaultValue;
        }

        void setDefaultValue(String value) {
            this.mDefaultValue = value;
        }

        void addClientPid(int pid) {
            this.mPids.add(Integer.valueOf(pid));
        }

        boolean containsPid(int pid) {
            return this.mPids.contains(Integer.valueOf(pid));
        }

        public boolean equals(Object other) {
            if (other != null) goto L5;
        L18:
            return false;
        L5:
            if ((other instanceof DynamicFlagData) == false) goto L18;
            DynamicFlagData o = (DynamicFlagData) other;
            if (this.mName.equals(o.mName) == true) goto L10;
            return false;
        L10:
            if (this.mNamespace.equals(o.mNamespace) == true) goto L12;
            return false;
        L12:
            if (this.mValue.equals(o.mValue) == true) goto L14;
            return false;
        L14:
            if (this.mDefaultValue.equals(o.mDefaultValue) == false) goto L22;
            return true;
        L22:
            return false;
        }

        public int hashCode() {
            return ((this.mName.hashCode() + this.mNamespace.hashCode()) + this.mValue.hashCode()) + this.mDefaultValue.hashCode();
        }
    }

    public static /* synthetic */ void $r8$lambda$fWvFD6E6pxuCvm1CYmzUojbk9uM(SyncableFlag r0, IFeatureFlagsCallback r1) {
        lambda$new$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qiqeobqWainxV-HWXiQLJqnkHyo, reason: not valid java name */
    public static /* synthetic */ void m4234$r8$lambda$qiqeobqWainxVHWXiQLJqnkHyo(DynamicFlagBinderDelegate r0, String r1, String r2, String r3) {
        r0.lambda$new$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$vcppf9Un-gROJ-J-LEIMgIKeYoY, reason: not valid java name */
    public static /* synthetic */ Set m4235$r8$lambda$vcppf9UngROJJLEIMgIKeYoY(Integer r0) {
        return lambda$static$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m4236$$Nest$fgetmCallbacks(DynamicFlagBinderDelegate r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDynamicFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ FlagCache m4237$$Nest$fgetmDynamicFlags(DynamicFlagBinderDelegate r0) {
        return r0.mDynamicFlags;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlagChangeCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ FlagOverrideStore.FlagChangeCallback m4238$$Nest$fgetmFlagChangeCallback(DynamicFlagBinderDelegate r0) {
        return r0.mFlagChangeCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlagStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ FlagOverrideStore m4239$$Nest$fgetmFlagStore(DynamicFlagBinderDelegate r0) {
        return r0.mFlagStore;
    }

    static {
        NEW_CALLBACK_SET = new DynamicFlagBinderDelegate$$ExternalSyntheticLambda1();
    }

    private static /* synthetic */ Set lambda$static$0(Integer k) {
        return new HashSet();
    }

    private /* synthetic */ void lambda$new$2(String namespace, String name, String value) {
        if (this.mDynamicFlags.contains(namespace, name) == true) goto L5;
        return;
    L5:
        DynamicFlagData data = this.mDynamicFlags.getOrNull(namespace, name);
        if (data != null) goto L8;
        return;
    L8:
        if (value != null) goto L14;
        if (data.getValue().equals(data.getDefaultValue()) == false) goto L12;
        return;
    L12:
        value = data.getDefaultValue();
    L16:
        data.setValue(value);
        Map<Integer, Set<IFeatureFlagsCallback>> r1 = this.mCallbacks;
        monitor-enter(r1);
        Set<IFeatureFlagsCallback> cbCopy = new HashSet();     // Catch: Throwable -> L24
        Iterator<Integer> r3 = this.mCallbacks.keySet().iterator();     // Catch: Throwable -> L24
    L20:
        if (r3.hasNext() == false) goto L27;
        Integer pid = r3.next();     // Catch: Throwable -> L24
        if (data.containsPid(pid.intValue()) == false) goto L20;
        cbCopy.addAll(this.mCallbacks.get(pid));     // Catch: Throwable -> L24
        goto L20
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L24
        final SyncableFlag sFlag = new SyncableFlag(namespace, name, value, true);
        cbCopy.forEach(new DynamicFlagBinderDelegate$$ExternalSyntheticLambda0(sFlag));
        return;
    L24:
        th = move-exception;
        throw th;
    L14:
        if (data.getValue().equals(value) == false) goto L16;
    }

    private static /* synthetic */ void lambda$new$1(SyncableFlag sFlag, IFeatureFlagsCallback cb) {
        cb.onFlagChange(sFlag);     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.w("FeatureFlagsService", "Failed to communicate flag change to client.");
    }

    DynamicFlagBinderDelegate(FlagOverrideStore flagStore) {
        this.mDynamicFlags = new FlagCache();
        this.mCallbacks = new HashMap();
        this.mDeviceConfigListener = new AnonymousClass1(this);
        this.mFlagChangeCallback = new DynamicFlagBinderDelegate$$ExternalSyntheticLambda2(this);
        this.mFlagStore = flagStore;
        this.mFlagStore.setChangeCallback(this.mFlagChangeCallback);
    }

    SyncableFlag syncDynamicFlag(int pid, SyncableFlag sf) {
        if (sf.isDynamic() == true) goto L5;
        return sf;
    L5:
        String ns = sf.getNamespace();
        String name = sf.getName();
        DynamicFlagData data = this.mDynamicFlags.getOrNull(ns, name);
        String value = getFlagValue(ns, name, sf.getValue());
        if (this.mDynamicFlags.containsNamespace(ns) == true) goto L8;
        DeviceConfig.addOnPropertiesChangedListener(ns, BackgroundThread.getExecutor(), this.mDeviceConfigListener);
    L8:
        data.addClientPid(pid);
        data.setValue(value);
        data.setDefaultValue(sf.getValue());
        return new SyncableFlag(sf.getNamespace(), sf.getName(), value, true);
    }

    void registerCallback(int pid, IFeatureFlagsCallback callback) {
        Map<Integer, Set<IFeatureFlagsCallback>> r0 = this.mCallbacks;
        monitor-enter(r0);
        Set<IFeatureFlagsCallback> callbacks = this.mCallbacks.computeIfAbsent(Integer.valueOf(pid), NEW_CALLBACK_SET);     // Catch: Throwable -> L17
        callbacks.add(callback);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        callback.asBinder().linkToDeath(new BinderGriever(this, pid, null), 0);     // Catch: RemoteException -> L8
        return;
    L9:
        Slog.e("FeatureFlagsService", "Failed to link to binder death. Callback not registered.");
        monitor-enter(this.mCallbacks);
        callbacks.remove(callback);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;
    }

    void unregisterCallback(int pid, IFeatureFlagsCallback callback) {
        Map<Integer, Set<IFeatureFlagsCallback>> r0 = this.mCallbacks;
        monitor-enter(r0);
        Set<IFeatureFlagsCallback> callbacks = this.mCallbacks.computeIfAbsent(Integer.valueOf(pid), NEW_CALLBACK_SET);     // Catch: Throwable -> L7
        callbacks.remove(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    String getFlagValue(String namespace, String name, String defaultValue) {
        String value = null;
        DynamicFlagData data = this.mDynamicFlags.getOrNull(namespace, name);
        if (data == null) goto L5;
        value = data.getValue();
    L7:
        if (Build.IS_USER == true) goto L10;
        if (value != null) goto L10;
        value = this.mFlagStore.get(namespace, name);
    L10:
        if (value != null) goto L13;
        String value2 = DeviceConfig.getString(namespace, name, defaultValue);
        return value2;
    L13:
        return value;
    L5:
        DynamicFlagData data2 = new DynamicFlagData(namespace, name, null);
        this.mDynamicFlags.setIfChanged(namespace, name, data2);
        goto L7
    }
}
