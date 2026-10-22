package com.android.server.wm;

import android.R;
import android.content.res.Resources;
import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.util.ArraySet;
import com.android.internal.os.BackgroundThread;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class HighRefreshRateDenylist {
    private final String[] mDefaultDenylist;
    private final ArraySet<String> mDenylistedPackages;
    private final Object mLock;

    private class OnPropertiesChangedListener implements DeviceConfig.OnPropertiesChangedListener {
        final /* synthetic */ HighRefreshRateDenylist this$0;

        /* synthetic */ OnPropertiesChangedListener(HighRefreshRateDenylist r1, HighRefreshRateDenylistIA r2) {
            this(r1);
        }

        private OnPropertiesChangedListener(HighRefreshRateDenylist r1) {
            this.this$0 = r1;
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            if (properties.getKeyset().contains("high_refresh_rate_blacklist") == false) goto L6;
            HighRefreshRateDenylist.m9995$$Nest$mupdateDenylist(this.this$0, properties.getString("high_refresh_rate_blacklist", null));
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDenylist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9995$$Nest$mupdateDenylist(HighRefreshRateDenylist r0, String r1) {
        r0.updateDenylist(r1);
    }

    static HighRefreshRateDenylist create(Resources r) {
        return new HighRefreshRateDenylist(r, DeviceConfigInterface.REAL);
    }

    HighRefreshRateDenylist(Resources r, DeviceConfigInterface deviceConfig) {
        this.mDenylistedPackages = new ArraySet();
        this.mLock = new Object();
        this.mDefaultDenylist = r.getStringArray(R.array.config_networkSupportedKeepaliveCount);
        deviceConfig.addOnPropertiesChangedListener("display_manager", BackgroundThread.getExecutor(), new OnPropertiesChangedListener(this, null));
        String property = deviceConfig.getProperty("display_manager", "high_refresh_rate_blacklist");
        updateDenylist(property);
    }

    private void updateDenylist(String property) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDenylistedPackages.clear();     // Catch: Throwable -> L11
        int r1 = 0;
        if (property == null) goto L15;
        String[] packages = property.split(",");     // Catch: Throwable -> L11
        int r3 = packages.length;     // Catch: Throwable -> L11
    L7:
        if (r1 >= r3) goto L18;
        String pkg = packages[r1];     // Catch: Throwable -> L11
        String pkgName = pkg.trim();     // Catch: Throwable -> L11
        if (pkgName.isEmpty() == true) goto L13;
        this.mDenylistedPackages.add(pkgName);     // Catch: Throwable -> L11
    L13:
        r1 = r1 + 1;     // Catch: Throwable -> L11
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L15:
        String[] r2 = this.mDefaultDenylist;     // Catch: Throwable -> L11
        int r4 = r2.length;     // Catch: Throwable -> L11
    L16:
        if (r1 >= r4) goto L18;
        String pkg2 = r2[r1];     // Catch: Throwable -> L11
        this.mDenylistedPackages.add(pkg2);     // Catch: Throwable -> L11
        r1 = r1 + 1;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    boolean isDenylisted(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mDenylistedPackages.contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        pw.println("High Refresh Rate Denylist");
        pw.println("  Packages:");
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<String> r1 = this.mDenylistedPackages.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        String pkg = r1.next();     // Catch: Throwable -> L8
        pw.println("    " + pkg);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
