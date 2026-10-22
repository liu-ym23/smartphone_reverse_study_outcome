package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile f f25348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f25349h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f25350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f25351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f25352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f25353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f25354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f25355f;

    public f() {
        this.f25350a = new a("udid");
        this.f25351b = new a("oaid");
        this.f25353d = new a("vaid");
        this.f25352c = new a("aaid");
        this.f25354e = new c();
    }

    public static d a(Cursor r100) {
        d r101 = new d(null, 0);
        if (r100 != null) goto L8;
        String r102 = "parseValue fail, cursor is null.";
    L5:
        a(r102);
        return r101;
    L8:
        if (r100.isClosed() == false) goto L10;
        r102 = "parseValue fail, cursor is closed.";
        goto L5
    L10:
        r100.moveToFirst();
        int r103 = r100.getColumnIndex("value");
        if (r103 < 0) goto L13;
        r101.f25345a = r100.getString(r103);
    L14:
        int r104 = r100.getColumnIndex("code");
        if (r104 < 0) goto L17;
        r101.f25346b = r100.getInt(r104);
    L18:
        int r105 = r100.getColumnIndex(AiBotPollingAuthResult.STATUS_EXPIRED);
        if (r105 < 0) goto L21;
        r101.f25347c = r100.getLong(r105);
    L22:
        return r101;
    L21:
        a("parseExpired fail, index < 0.");
        goto L22
    L17:
        a("parseCode fail, index < 0.");
        goto L18
    L13:
        a("parseValue fail, index < 0.");
        goto L14
    }

    public static final f a() {
        if (f25348g != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f25348g != null) goto L9;
        f25348g = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f25348g;
    }

    public static String a(PackageManager r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ProviderInfo r102 = r100.resolveContentProvider(r101, 0);
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((r102.applicationInfo.flags & 1) != 0) goto L12;
        return null;
    L12:
        return r102.packageName;
    }

    public static void a(String r100) {
    }

    public static void a(boolean r100) {
        f25349h = r100;
    }

    public static boolean a(Context r100) {
        a("querySupport version : 1.0.8");
        boolean r101 = false;
        Cursor r102 = null;
        r102 = com_alipay_sdk_m_i0_f_android_content_ContentResolver_query(r100.getContentResolver(), UriProtector.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);     // Catch: Throwable -> L16 Exception -> L18
        if (r102 == null) goto L14;
        d r103 = a(r102);     // Catch: Throwable -> L16 Exception -> L18
        if (1000 == r103.f25346b) goto L9;
    L11:
        r101 = true;
    L12:
        r102.close();
        return r101;
    L9:
        if ("0".equals(r103.f25345a) == false) goto L12;
    L14:
        if (r102 != null) goto L21;
    L22:
        return false;
    L21:
        r102.close();
    L18:
        e = move-exception;
        a("querySupport, Exception : " + e.getMessage());     // Catch: Throwable -> L16
        if (r102 == null) goto L22;
    L16:
        th = move-exception;
        if (r102 == null) goto L25;
        r102.close();
    L25:
        throw th;
    }

    private String b(Context r110, a r111) {
        a("queryId : " + r111.f25339c);
        Cursor r100 = null;
        String r101 = null;
        r101 = null;
        r101 = null;
        r100 = null;
        Cursor r102 = com_alipay_sdk_m_i0_f_android_content_ContentResolver_query(r110.getContentResolver(), UriProtector.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{r111.f25339c}, null);     // Catch: Throwable -> L25 Exception -> L27
        if (r102 == null) goto L14;
        d r103 = a(r102);     // Catch: Throwable -> L21 Exception -> L23
        r101 = r103.f25345a;     // Catch: Throwable -> L21 Exception -> L23
        r111.a(r101);     // Catch: Throwable -> L21 Exception -> L23
        r111.a(r103.f25347c);     // Catch: Throwable -> L21 Exception -> L23
        r111.a(r103.f25346b);     // Catch: Throwable -> L21 Exception -> L23
        a(r111.f25339c + " errorCode : " + r111.f25340d);     // Catch: Throwable -> L21 Exception -> L23
        if (r103.f25346b == 1000) goto L19;
        b(r110);     // Catch: Throwable -> L21 Exception -> L23
        if (a(r110, false) == true) goto L19;
        String r112 = "not support, forceQuery isSupported: ";
        String r113 = String.valueOf(a(r110, true));     // Catch: Throwable -> L21 Exception -> L23
    L18:
        a(r112.concat(r113));     // Catch: Throwable -> L21 Exception -> L23
    L19:
        if (r102 == null) goto L43;
    L32:
        r102.close();
        return r101;
    L43:
        return r101;
    L14:
        if (a(r110, false) == false) goto L19;
        r112 = "forceQuery isSupported : ";
        r113 = String.valueOf(a(r110, true));     // Catch: Throwable -> L21 Exception -> L23
    L23:
        e = e;
        String r114 = r101;
        r100 = r102;
    L29:
        a("queryId, Exception : " + e.getMessage());     // Catch: Throwable -> L25
        if (r100 == null) goto L34;
        r102 = r100;
        r101 = r114;
        goto L32
    L34:
        return r114;
    L21:
        th = th;
        r100 = r102;
    L35:
        if (r100 == null) goto L37;
        r100.close();
    L37:
        throw th;
    L27:
        e = e;
        r114 = null;
    L25:
        th = th;
        goto L35
    }

    public static String b(PackageManager r100, String r101) {
        PackageInfo r102 = r100.getPackageInfo(r101, 0);     // Catch: Exception -> L7
        if (r102 == null) goto L13;
        return r102.versionName;
    L13:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        a("getAppVersion, Exception : " + e.getMessage());
        return null;
    }

    private synchronized void b(Context r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f25355f == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        IntentFilter r101 = new IntentFilter();     // Catch: Throwable -> L10
        r101.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");     // Catch: Throwable -> L10
        e r102 = new e();     // Catch: Throwable -> L10
        this.f25355f = r102;     // Catch: Throwable -> L10
        INVOKEVIRTUAL_com_alipay_sdk_m_i0_f_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r102, r101, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final String a(Context r100, a r101) {
        if (r101 != null) goto L8;
        String r102 = "getId, openId = null.";
    L5:
        a(r102);
        return null;
    L8:
        if (r101.a() == false) goto L12;
        return r101.f25338b;
    L12:
        if (a(r100, true) == true) goto L15;
        r102 = "getId, isSupported = false.";
        goto L5
    L15:
        return b(r100, r101);
    }

    public final boolean a(Context r100, boolean r101) {
        if (this.f25354e.a() == false) goto L7;
        if (r101 == true) goto L7;
        return this.f25354e.b();
    L7:
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L10;
        return false;
    L10:
        String r103 = a(r102, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(r103) == false) goto L13;
        return false;
    L13:
        String r104 = b(r102, r103);
        if (this.f25354e.a() == true) goto L16;
    L19:
        this.f25354e.b(r104);
        boolean r105 = a(r100);
        a("query support, result : ".concat(String.valueOf(r105)));
        this.f25354e.a(r105);
        return r105;
    L16:
        if (this.f25354e.a(r104) == false) goto L19;
        a("use same version cache, safeVersion : ".concat(String.valueOf(r104)));
        return this.f25354e.b();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_alipay_sdk_m_i0_f_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, r111, r112, 4, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112);
    }

    private static Cursor com_alipay_sdk_m_i0_f_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
