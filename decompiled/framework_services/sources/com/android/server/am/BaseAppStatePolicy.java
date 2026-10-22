package com.android.server.am;

import android.provider.DeviceConfig;
import com.android.server.am.BaseAppStateTracker;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAppStatePolicy<T extends BaseAppStateTracker> {
    protected final boolean mDefaultTrackerEnabled;
    protected final BaseAppStateTracker.Injector<?> mInjector;
    protected final String mKeyTrackerEnabled;
    protected final T mTracker;
    volatile boolean mTrackerEnabled;

    public abstract void onTrackerEnabled(boolean r1);

    BaseAppStatePolicy(BaseAppStateTracker.Injector<?> injector, T tracker, String keyTrackerEnabled, boolean defaultTrackerEnabled) {
        this.mInjector = injector;
        this.mTracker = tracker;
        this.mKeyTrackerEnabled = keyTrackerEnabled;
        this.mDefaultTrackerEnabled = defaultTrackerEnabled;
    }

    void updateTrackerEnabled() {
        boolean enabled = DeviceConfig.getBoolean("activity_manager", this.mKeyTrackerEnabled, this.mDefaultTrackerEnabled);
        if (enabled == this.mTrackerEnabled) goto L6;
        this.mTrackerEnabled = enabled;
        onTrackerEnabled(enabled);
        return;
    }

    public void onPropertiesChanged(String name) {
        if (this.mKeyTrackerEnabled.equals(name) == false) goto L6;
        updateTrackerEnabled();
        return;
    }

    public int getProposedRestrictionLevel(String packageName, int uid, int maxLevel) {
        return 0;
    }

    public void onSystemReady() {
        updateTrackerEnabled();
    }

    public boolean isEnabled() {
        return this.mTrackerEnabled;
    }

    public int shouldExemptUid(int uid) {
        return this.mTracker.mAppRestrictionController.getBackgroundRestrictionExemptionReason(uid);
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print(this.mKeyTrackerEnabled);
        pw.print('=');
        pw.println(this.mTrackerEnabled);
    }
}
