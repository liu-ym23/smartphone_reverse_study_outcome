package com.bytedance.android.monitorV2.constant;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.android.monitorV2.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class MonitorGlobalSp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f162991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences f162992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Application f162993c = null;

    static {
        f162991a = LazyKt.lazy(MonitorGlobalSp$sp$2.INSTANCE);
        f162993c = g.e().f163040a;
    }

    @JvmStatic
    public static final boolean a() {
        Intrinsics.checkNotNullParameter("monitor_validation_switch", "key");
        Application r100 = f162993c;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (f162992b != null) goto L8;
        f162992b = r100.getSharedPreferences("monitor_sdk", 4);
    L8:
        SharedPreferences r101 = f162992b;
        if (r101 != null) goto L11;
        return false;
    L11:
        return r101.getBoolean("monitor_validation_switch", false);
    }

    public static SharedPreferences c() {
        return (SharedPreferences) f162991a.getValue();
    }

    @JvmStatic
    public static final long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f162993c == null) goto L10;
        SharedPreferences r101 = c();
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.getLong(r100, 0);
    L10:
        return 0;
    }

    @JvmStatic
    public static final String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        if (f162993c == null) goto L13;
        SharedPreferences r102 = c();
        if (r102 == null) goto L12;
        String r103 = r102.getString(r100, r101);
        if (r103 != null) goto L11;
        return r101;
    L11:
        return r103;
    L12:
        return r101;
    L13:
        return r101;
    }

    @JvmStatic
    public static final void e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f162993c != null) goto L5;
        return;
    L5:
        SharedPreferences r102 = c();
        if (r102 == null) goto L13;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L14;
        SharedPreferences.Editor r104 = r103.putLong(r100, r101);
        if (r104 == null) goto L15;
        r104.apply();
        return;
    L15:
        return;
    L14:
        return;
    }

    @JvmStatic
    public static final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (f162993c != null) goto L5;
        return;
    L5:
        SharedPreferences r102 = c();
        if (r102 == null) goto L13;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L14;
        SharedPreferences.Editor r104 = r103.putString(r100, r101);
        if (r104 == null) goto L15;
        r104.apply();
        return;
    L15:
        return;
    L14:
        return;
    }
}
