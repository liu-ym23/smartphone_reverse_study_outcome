package com.android.server.compat;

import android.app.compat.PackageOverride;
import android.content.pm.ApplicationInfo;
import com.android.internal.compat.AndroidBuildClassifier;
import com.android.internal.compat.CompatibilityChangeInfo;
import com.android.internal.compat.OverrideAllowedState;
import com.android.server.compat.config.Change;
import com.android.server.compat.overrides.ChangeOverrides;
import com.android.server.compat.overrides.OverrideValue;
import com.android.server.compat.overrides.RawOverrideValue;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class CompatChange extends CompatibilityChangeInfo {
    static final long CTS_SYSTEM_API_CHANGEID = 149391281;
    static final long CTS_SYSTEM_API_OVERRIDABLE_CHANGEID = 174043039;
    private ConcurrentHashMap<String, Boolean> mEvaluatedOverrides;
    ChangeListener mListener;
    private ConcurrentHashMap<String, PackageOverride> mRawOverrides;

    public interface ChangeListener {
        void onCompatChange(String r1);
    }

    public CompatChange(long changeId) {
        this(changeId, null, -1, -1, false, false, null, false);
    }

    public CompatChange(Change change) {
        this(change.getId(), change.getName(), change.getEnableAfterTargetSdk(), change.getEnableSinceTargetSdk(), change.getDisabled(), change.getLoggingOnly(), change.getDescription(), change.getOverridable());
    }

    public CompatChange(long changeId, String name, int enableAfterTargetSdk, int enableSinceTargetSdk, boolean disabled, boolean loggingOnly, String description, boolean overridable) {
        super(Long.valueOf(changeId), name, enableAfterTargetSdk, enableSinceTargetSdk, disabled, loggingOnly, description, overridable);
        this.mListener = null;
        this.mEvaluatedOverrides = new ConcurrentHashMap();
        this.mRawOverrides = new ConcurrentHashMap();
    }

    synchronized void registerListener(ChangeListener listener) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mListener != null) goto L11;
        this.mListener = listener;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalStateException("Listener for change " + toString() + " already registered.");     // Catch: Throwable -> L8
    }

    private void addPackageOverrideInternal(String pname, boolean enabled) {
        if (getLoggingOnly() == true) goto L7;
        this.mEvaluatedOverrides.put(pname, Boolean.valueOf(enabled));
        notifyListener(pname);
        return;
    L7:
        throw new IllegalArgumentException("Can't add overrides for a logging only change " + toString());
    }

    private void removePackageOverrideInternal(String pname) {
        if (this.mEvaluatedOverrides.remove(pname) == null) goto L6;
        notifyListener(pname);
        return;
    }

    synchronized void addPackageOverride(String packageName, PackageOverride override, OverrideAllowedState allowedState, Long versionCode) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (getLoggingOnly() == true) goto L11;
        this.mRawOverrides.put(packageName, override);     // Catch: Throwable -> L8
        recheckOverride(packageName, allowedState, versionCode);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException("Can't add overrides for a logging only change " + toString());     // Catch: Throwable -> L8
    }

    synchronized boolean recheckOverride(String packageName, OverrideAllowedState allowedState, Long versionCode) {
        monitor-enter(this);
        if (packageName != null) goto L31;
        monitor-exit(this);
        return false;
    L31:
    L20:
        th = move-exception;
        throw th;
    L8:
        if (allowedState.state != 0) goto L10;
        boolean allowed = true;
    L11:
        if (versionCode != null) goto L13;
    L26:
        removePackageOverrideInternal(packageName);     // Catch: Throwable -> L20
        monitor-exit(this);
        return false;
    L13:
        if (this.mRawOverrides.containsKey(packageName) == false) goto L26;
        if (allowed == false) goto L26;
        int overrideValue = this.mRawOverrides.get(packageName).evaluate(versionCode.longValue());     // Catch: Throwable -> L20
        switch(overrideValue) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L19;
            default: goto L24;
        };     // Catch: Throwable -> L20
    L19:
        addPackageOverrideInternal(packageName, false);     // Catch: Throwable -> L20
        goto L24
    L22:
        addPackageOverrideInternal(packageName, true);     // Catch: Throwable -> L20
        goto L24
    L23:
        removePackageOverrideInternal(packageName);     // Catch: Throwable -> L20
    L24:
        monitor-exit(this);
        return true;
    L10:
        allowed = false;
        goto L11
    }

    synchronized boolean removePackageOverride(String pname, OverrideAllowedState allowedState, Long versionCode) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mRawOverrides.containsKey(pname) == false) goto L11;
        allowedState.enforce(getId(), pname);     // Catch: Throwable -> L9
        this.mRawOverrides.remove(pname);     // Catch: Throwable -> L9
        recheckOverride(pname, allowedState, versionCode);     // Catch: Throwable -> L9
        monitor-exit(this);
        return true;
    L11:
        monitor-exit(this);
        return false;
    }

    boolean isEnabled(ApplicationInfo app, AndroidBuildClassifier buildClassifier) {
        if (app != null) goto L6;
        return defaultValue();
    L6:
        if (app.packageName == null) goto L12;
        Boolean enabled = this.mEvaluatedOverrides.get(app.packageName);
        if (enabled == null) goto L12;
        return enabled.booleanValue();
    L12:
        if (getDisabled() == false) goto L15;
        return false;
    L15:
        if (getEnableSinceTargetSdk() == (-1)) goto L20;
        int compareSdk = Math.min(app.targetSdkVersion, buildClassifier.platformTargetSdk());
        if (compareSdk >= getEnableSinceTargetSdk()) goto L19;
        return false;
    L19:
        return true;
    L20:
        return true;
    }

    boolean willBeEnabled(String packageName) {
        if (packageName == null) goto L4;
        PackageOverride override = this.mRawOverrides.get(packageName);
        if (override == null) goto L17;
        switch(override.evaluateForAllVersions()) {
            case 0: goto L15;
            case 1: goto L12;
            case 2: goto L10;
            default: goto L17;
        };
    L10:
        return false;
    L12:
        return true;
    L15:
        return defaultValue();
    L17:
        return defaultValue();
    L4:
        return defaultValue();
    }

    boolean defaultValue() {
        return !getDisabled();
    }

    synchronized void clearOverrides() {
        monitor-enter(this);
        this.mRawOverrides.clear();     // Catch: Throwable -> L6
        this.mEvaluatedOverrides.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void loadOverrides(ChangeOverrides changeOverrides) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (changeOverrides.getDeferred() == null) goto L12;
        Iterator<OverrideValue> r0 = changeOverrides.getDeferred().getOverrideValue().iterator();     // Catch: Throwable -> L9
    L7:
        if (r0.hasNext() == false) goto L12;
        OverrideValue override = r0.next();     // Catch: Throwable -> L9
        this.mRawOverrides.put(override.getPackageName(), new PackageOverride.Builder().setEnabled(override.getEnabled()).build());     // Catch: Throwable -> L9
    L12:
        if (changeOverrides.getValidated() == null) goto L18;
        Iterator<OverrideValue> r1 = changeOverrides.getValidated().getOverrideValue().iterator();     // Catch: Throwable -> L9
    L15:
        if (r1.hasNext() == false) goto L18;
        OverrideValue override2 = r1.next();     // Catch: Throwable -> L9
        this.mEvaluatedOverrides.put(override2.getPackageName(), Boolean.valueOf(override2.getEnabled()));     // Catch: Throwable -> L9
        this.mRawOverrides.put(override2.getPackageName(), new PackageOverride.Builder().setEnabled(override2.getEnabled()).build());     // Catch: Throwable -> L9
    L18:
        if (changeOverrides.getRaw() == null) goto L24;
        Iterator<RawOverrideValue> r2 = changeOverrides.getRaw().getRawOverrideValue().iterator();     // Catch: Throwable -> L9
    L20:
        if (r2.hasNext() == false) goto L24;
        RawOverrideValue override3 = r2.next();     // Catch: Throwable -> L9
        PackageOverride packageOverride = new PackageOverride.Builder().setMinVersionCode(override3.getMinVersionCode()).setMaxVersionCode(override3.getMaxVersionCode()).setEnabled(override3.getEnabled()).build();     // Catch: Throwable -> L9
        this.mRawOverrides.put(override3.getPackageName(), packageOverride);     // Catch: Throwable -> L9
    L24:
        monitor-exit(this);
    }

    synchronized ChangeOverrides saveOverrides() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mRawOverrides.isEmpty() == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ChangeOverrides changeOverrides = new ChangeOverrides();     // Catch: Throwable -> L12
        changeOverrides.setChangeId(getId());     // Catch: Throwable -> L12
        ChangeOverrides.Raw rawOverrides = new ChangeOverrides.Raw();     // Catch: Throwable -> L12
        List<RawOverrideValue> rawList = rawOverrides.getRawOverrideValue();     // Catch: Throwable -> L12
        Iterator<Map.Entry<String, PackageOverride>> r3 = this.mRawOverrides.entrySet().iterator();     // Catch: Throwable -> L12
    L10:
        if (r3.hasNext() == false) goto L14;
        Map.Entry<String, PackageOverride> entry = r3.next();     // Catch: Throwable -> L12
        RawOverrideValue override = new RawOverrideValue();     // Catch: Throwable -> L12
        override.setPackageName(entry.getKey());     // Catch: Throwable -> L12
        override.setMinVersionCode(entry.getValue().getMinVersionCode());     // Catch: Throwable -> L12
        override.setMaxVersionCode(entry.getValue().getMaxVersionCode());     // Catch: Throwable -> L12
        override.setEnabled(entry.getValue().isEnabled());     // Catch: Throwable -> L12
        rawList.add(override);     // Catch: Throwable -> L12
        goto L10
    L14:
        changeOverrides.setRaw(rawOverrides);     // Catch: Throwable -> L12
        ChangeOverrides.Validated validatedOverrides = new ChangeOverrides.Validated();     // Catch: Throwable -> L12
        List<OverrideValue> validatedList = validatedOverrides.getOverrideValue();     // Catch: Throwable -> L12
        Iterator<Map.Entry<String, Boolean>> r5 = this.mEvaluatedOverrides.entrySet().iterator();     // Catch: Throwable -> L12
    L16:
        if (r5.hasNext() == false) goto L18;
        Map.Entry<String, Boolean> entry2 = r5.next();     // Catch: Throwable -> L12
        OverrideValue override2 = new OverrideValue();     // Catch: Throwable -> L12
        override2.setPackageName(entry2.getKey());     // Catch: Throwable -> L12
        override2.setEnabled(entry2.getValue().booleanValue());     // Catch: Throwable -> L12
        validatedList.add(override2);     // Catch: Throwable -> L12
        goto L16
    L18:
        changeOverrides.setValidated(validatedOverrides);     // Catch: Throwable -> L12
        monitor-exit(this);
        return changeOverrides;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChangeId(").append(getId());
        if (getName() == null) goto L6;
        sb.append("; name=");
        sb.append(getName());
    L6:
        if (getEnableSinceTargetSdk() == (-1)) goto L9;
        sb.append("; enableSinceTargetSdk=");
        sb.append(getEnableSinceTargetSdk());
    L9:
        if (getDisabled() == false) goto L12;
        sb.append("; disabled");
    L12:
        if (getLoggingOnly() == false) goto L15;
        sb.append("; loggingOnly");
    L15:
        if (this.mEvaluatedOverrides.isEmpty() == true) goto L18;
        sb.append("; packageOverrides=");
        sb.append(this.mEvaluatedOverrides);
    L18:
        if (this.mRawOverrides.isEmpty() == true) goto L21;
        sb.append("; rawOverrides=");
        sb.append(this.mRawOverrides);
    L21:
        if (getOverridable() == false) goto L23;
        sb.append("; overridable");
    L23:
        sb.append(")");
        return sb.toString();
    }

    private synchronized void notifyListener(String packageName) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mListener == null) goto L9;
        this.mListener.onCompatChange(packageName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }
}
