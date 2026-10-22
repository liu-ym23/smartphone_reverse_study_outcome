package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HWOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class g implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.ss.android.deviceregister.c.f<Boolean> f37370a = null;

    static {
        f37370a = new AnonymousClass1();
    }

    g() {
    }

    static boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(f37370a.c(new Object[]{r5}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.o
    public boolean b(Context r2) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.deviceregister.base.o
    public o.a c(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.a r6 = new o.a();
        if (Build.VERSION.SDK_INT >= 24) goto L14;
    L10:
        Pair<String, Boolean> r1 = e(r4);
        if (r1 == null) goto L13;
        r6.f37379a = (String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.aiagent.plugin");
        r6.f37380b = ((Boolean) ZeusTransformUtils.preCheckCast(r1.second, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        r6.f37381c = d(r4);
    L13:
        return r6;
    L14:
        String r2 = Settings.Global.getString(r4.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r3 = Settings.Global.getString(r4.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r6.f37379a = r2;     // Catch: Throwable -> L8
        r6.f37380b = Boolean.parseBoolean(r3);     // Catch: Throwable -> L8
        r6.f37381c = 202003021704L;     // Catch: Throwable -> L8
        return r6;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    private static int d(Context r2) {
        PackageInfo r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo("com.huawei.hwid", 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r3 == null) goto L12;
        return r3.versionCode;
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private static Pair<String, Boolean> e(Context r4) {
        return (Pair) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new AnonymousClass2()).a(), Pair.class, "com.obric.aiagent.plugin");
    }
}
