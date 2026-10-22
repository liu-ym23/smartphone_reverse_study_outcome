package com.bytedance.bdinstall.oaid;

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
/* JADX INFO: loaded from: classes.dex */
final class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.bdinstall.j.r<Boolean> f6397a = null;

    /* JADX INFO: compiled from: HWOaidImpl.java */
    static class a extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f6398a;

        a() {
            this.f6398a = 0;
        }
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Huawei";
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public /* synthetic */ k.a c(Context r3) {
        return d((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    static {
        f6397a = new AnonymousClass1();
    }

    e() {
    }

    static boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(f6397a.c(new Object[]{r5}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public boolean b(Context r2) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    public a d(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        a r6 = new a();
        if (Build.VERSION.SDK_INT >= 24) goto L14;
    L10:
        Pair<String, Boolean> r1 = f(r4);
        if (r1 == null) goto L13;
        r6.f6412b = (String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.aiagent.plugin");
        r6.f6413c = ((Boolean) ZeusTransformUtils.preCheckCast(r1.second, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        r6.f6398a = e(r4);
    L13:
        return r6;
    L14:
        String r2 = Settings.Global.getString(r4.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r3 = Settings.Global.getString(r4.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r6.f6412b = r2;     // Catch: Throwable -> L8
        r6.f6413c = Boolean.parseBoolean(r3);     // Catch: Throwable -> L8
        r6.f6398a = 202003021704L;     // Catch: Throwable -> L8
        return r6;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    private static int e(Context r2) {
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

    private static Pair<String, Boolean> f(Context r4) {
        return (Pair) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new AnonymousClass2()).a(), Pair.class, "com.obric.aiagent.plugin");
    }
}
