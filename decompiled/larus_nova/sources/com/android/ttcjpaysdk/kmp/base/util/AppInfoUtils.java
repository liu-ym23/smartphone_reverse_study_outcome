package com.android.ttcjpaysdk.kmp.base.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\b¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/AppInfoUtils;", "", "<init>", "()V", "getAppId", "", "getAppName", "isDebug", "", "getChannel", "getVersionName", "getVersionCode", "", "getPackageName", "getUpdateVersionCode", "getAppStartupTime", "getAppThemeColorMode", "", "isForeground", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppInfoUtils {
    public static final int $stable = 0;
    public static final AppInfoUtils INSTANCE = null;

    static {
        INSTANCE = new AppInfoUtils();
    }

    private AppInfoUtils() {
    }

    public final String getAppId() {
        return n96.a.a().getAppId();
    }

    public final String getAppName() {
        return n96.a.a().getAppName();
    }

    public final long getAppStartupTime() {
        return n96.a.a().B1();
    }

    public final int getAppThemeColorMode() {
        return n96.a.a().U1();
    }

    public final String getChannel() {
        return n96.a.a().getChannel();
    }

    public final String getPackageName() {
        return n96.a.a().getPackageName();
    }

    public final String getUpdateVersionCode() {
        return n96.a.a().getUpdateVersionCode();
    }

    public final long getVersionCode() {
        return n96.a.a().getVersionCode();
    }

    public final String getVersionName() {
        return n96.a.a().getVersionName();
    }

    public final boolean isDebug() {
        return n96.a.a().isDebug();
    }

    public final boolean isForeground() {
        return n96.a.a().isForeground();
    }
}
