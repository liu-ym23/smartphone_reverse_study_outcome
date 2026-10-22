package com.bytedanceos.appstore.utils;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9539a;

    static {
        f9539a = "release-keys".equals(SystemProperties.get("ro.build.tags"));
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return f9539a;
    }
}
