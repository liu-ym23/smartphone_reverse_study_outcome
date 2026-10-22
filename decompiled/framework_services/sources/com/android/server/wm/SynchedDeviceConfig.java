package com.android.server.wm;

import android.provider.DeviceConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class SynchedDeviceConfig implements DeviceConfig.OnPropertiesChangedListener {
    private final Map<String, SynchedDeviceConfigEntry> mDeviceConfigEntries;
    private final Executor mExecutor;
    private final String mNamespace;

    static class SynchedDeviceConfigBuilder {
        private final Map<String, SynchedDeviceConfigEntry> mDeviceConfigEntries;
        private final Executor mExecutor;
        private final String mNamespace;

        /* synthetic */ SynchedDeviceConfigBuilder(String r1, Executor r2, SynchedDeviceConfigIA r3) {
            this(r1, r2);
        }

        private SynchedDeviceConfigBuilder(String namespace, Executor executor) {
            this.mDeviceConfigEntries = new ConcurrentHashMap();
            this.mNamespace = namespace;
            this.mExecutor = executor;
        }

        SynchedDeviceConfigBuilder addDeviceConfigEntry(String key, boolean defaultValue, boolean enabled) {
            if (this.mDeviceConfigEntries.containsKey(key) == true) goto L7;
            this.mDeviceConfigEntries.put(key, new SynchedDeviceConfigEntry(key, defaultValue, enabled, null));
            return this;
        L7:
            throw new AssertionError("Key already present: " + key);
        }

        SynchedDeviceConfig build() {
            return SynchedDeviceConfig.m10159$$Nest$mstart(SynchedDeviceConfig.m10160$$Nest$mupdateFlags(new SynchedDeviceConfig(this.mNamespace, this.mExecutor, this.mDeviceConfigEntries, null)));
        }
    }

    private static class SynchedDeviceConfigEntry {
        private final boolean mBuildTimeFlagEnabled;
        private final boolean mDefaultValue;
        private final String mFlagKey;
        private volatile boolean mOverrideValue;

        /* JADX INFO: renamed from: -$$Nest$fgetmDefaultValue, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10161$$Nest$fgetmDefaultValue(SynchedDeviceConfigEntry r0) {
            return r0.mDefaultValue;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFlagKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m10162$$Nest$fgetmFlagKey(SynchedDeviceConfigEntry r0) {
            return r0.mFlagKey;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetValue, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10163$$Nest$mgetValue(SynchedDeviceConfigEntry r0) {
            return r0.getValue();
        }

        /* JADX INFO: renamed from: -$$Nest$misBuildTimeFlagEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10164$$Nest$misBuildTimeFlagEnabled(SynchedDeviceConfigEntry r0) {
            return r0.isBuildTimeFlagEnabled();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateValue, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10165$$Nest$mupdateValue(SynchedDeviceConfigEntry r0, boolean r1) {
            r0.updateValue(r1);
        }

        /* synthetic */ SynchedDeviceConfigEntry(String r1, boolean r2, boolean r3, SynchedDeviceConfigIA r4) {
            this(r1, r2, r3);
        }

        private SynchedDeviceConfigEntry(String flagKey, boolean defaultValue, boolean enabled) {
            this.mFlagKey = flagKey;
            this.mDefaultValue = defaultValue;
            this.mOverrideValue = defaultValue;
            this.mBuildTimeFlagEnabled = enabled;
        }

        private void updateValue(boolean newValue) {
            this.mOverrideValue = newValue;
        }

        private boolean getValue() {
            if (this.mBuildTimeFlagEnabled == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mOverrideValue == false) goto L7;
            return true;
        }

        private boolean isBuildTimeFlagEnabled() {
            return this.mBuildTimeFlagEnabled;
        }
    }

    public static /* synthetic */ void $r8$lambda$wnSiPqxpYWD7zDbmlb4cH3CKru0(SynchedDeviceConfig r0, String r1, SynchedDeviceConfigEntry r2) {
        r0.lambda$updateFlags$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
    static /* bridge */ /* synthetic */ SynchedDeviceConfig m10159$$Nest$mstart(SynchedDeviceConfig r0) {
        return r0.start();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ SynchedDeviceConfig m10160$$Nest$mupdateFlags(SynchedDeviceConfig r0) {
        return r0.updateFlags();
    }

    /* synthetic */ SynchedDeviceConfig(String r1, Executor r2, Map r3, SynchedDeviceConfigIA r4) {
        this(r1, r2, r3);
    }

    static SynchedDeviceConfigBuilder builder(String namespace, Executor executor) {
        return new SynchedDeviceConfigBuilder(namespace, executor, null);
    }

    private SynchedDeviceConfig(String namespace, Executor executor, Map<String, SynchedDeviceConfigEntry> deviceConfigEntries) {
        this.mNamespace = namespace;
        this.mExecutor = executor;
        this.mDeviceConfigEntries = deviceConfigEntries;
    }

    public void onPropertiesChanged(DeviceConfig.Properties properties) {
        Iterator<SynchedDeviceConfigEntry> r0 = this.mDeviceConfigEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        SynchedDeviceConfigEntry entry = r0.next();
        if (properties.getKeyset().contains(SynchedDeviceConfigEntry.m10162$$Nest$fgetmFlagKey(entry)) == false) goto L4;
        SynchedDeviceConfigEntry.m10165$$Nest$mupdateValue(entry, properties.getBoolean(SynchedDeviceConfigEntry.m10162$$Nest$fgetmFlagKey(entry), SynchedDeviceConfigEntry.m10161$$Nest$fgetmDefaultValue(entry)));
        goto L4
    }

    private SynchedDeviceConfig start() {
        DeviceConfig.addOnPropertiesChangedListener(this.mNamespace, this.mExecutor, this);
        return this;
    }

    private /* synthetic */ void lambda$updateFlags$0(String key, SynchedDeviceConfigEntry entry) {
        SynchedDeviceConfigEntry.m10165$$Nest$mupdateValue(entry, isDeviceConfigFlagEnabled(key, SynchedDeviceConfigEntry.m10161$$Nest$fgetmDefaultValue(entry)));
    }

    private SynchedDeviceConfig updateFlags() {
        this.mDeviceConfigEntries.forEach(new SynchedDeviceConfig$$ExternalSyntheticLambda0(this));
        return this;
    }

    boolean getFlagValue(String key) {
        SynchedDeviceConfigEntry entry = this.mDeviceConfigEntries.get(key);
        if (entry == null) goto L7;
        return SynchedDeviceConfigEntry.m10163$$Nest$mgetValue(entry);
    L7:
        throw new IllegalArgumentException("Unexpected flag name: " + key);
    }

    boolean isBuildTimeFlagEnabled(String key) {
        SynchedDeviceConfigEntry entry = this.mDeviceConfigEntries.get(key);
        if (entry == null) goto L7;
        return SynchedDeviceConfigEntry.m10164$$Nest$misBuildTimeFlagEnabled(entry);
    L7:
        throw new IllegalArgumentException("Unexpected flag name: " + key);
    }

    private boolean isDeviceConfigFlagEnabled(String key, boolean defaultValue) {
        return DeviceConfig.getBoolean(this.mNamespace, key, defaultValue);
    }
}
