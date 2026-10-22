package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener;
import com.obric.matrix.sdk.network.InterfaceRequestListener;
import ec.d;
import ic.e;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PackageInfo f11920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f11921c = null;

    public static final class a implements DeviceInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f11922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.obric.matrix.platform.sdk.ones.init.a f11923b;

        public a(Context r10, com.obric.matrix.platform.sdk.ones.init.a r11) {
            this.f11922a = r10;
            this.f11923b = r11;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener
        public void onDeviceIdLoaded(String r10) {
            q.g(r10, "did");
            if (b.b(b.f11919a, r10) == true) goto L10;
            hc.b.d("BaseComponentInitHelper", "did is not valid", null, 4, null);
            return;
        L10:
            b.a(this.f11922a, r10, this.f11923b);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            hc.b.c("BaseComponentInitHelper", "initInterval error", th);
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener
        public void onInstallIdLoaded(String r10) {
            q.g(r10, "installId");
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.init.b$b, reason: collision with other inner class name */
    public static final class C0187b implements InterfaceRequestListener {
        public C0187b() {
        }

        @Override // com.obric.matrix.sdk.network.InterfaceRequestListener
        public void onApiDuration(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            Log.i("BaseComponentInitHelper", "onApiDuration:");
        }

        @Override // com.obric.matrix.sdk.network.InterfaceRequestListener
        public void onApiError(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            Log.i("BaseComponentInitHelper", "onApiError: ");
        }
    }

    static {
        f11919a = new b();
        f11921c = new AtomicBoolean(false);
    }

    public b() {
    }

    public static final /* synthetic */ void a(Context r10, String r11, com.obric.matrix.platform.sdk.ones.init.a r12) {
        d(r10, r11, r12);
    }

    public static final /* synthetic */ boolean b(b r10, String r11) {
        return r10.f(r11);
    }

    public static final void c(Context r10, com.obric.matrix.platform.sdk.ones.init.a r11) {
        q.g(r10, "context");
        q.g(r11, "baseComponentConfig");
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.m35constructorimpl(r10.getPackageManager().getPackageInfo(r10.getPackageName(), 128));     // Catch: Throwable -> L5
    L8:
        if (Result.m38exceptionOrNullimpl(r13) == null) goto L11;
        r13 = new PackageInfo();
    L11:
        f11920b = (PackageInfo) r13;
        a r14 = new a(r10, r11);
        d.a r15 = d.f19371l;
        if (r15.c() == true) goto L24;
        ec.a.C0244a r16 = new ec.a.C0244a().b(r11.d());
        PackageInfo r17 = f11920b;
        PackageInfo r18 = null;
        if (r17 != null) goto L16;
        q.y("packageInfo");
        r17 = null;
    L16:
        ec.a.C0244a r19 = r16.d(r17.versionCode);
        PackageInfo r20 = f11920b;
        if (r20 != null) goto L19;
        q.y("packageInfo");
    L20:
        String r21 = r18.versionName;
        if (r21 != null) goto L23;
        r21 = "";
    L23:
        ec.a.C0244a r22 = r19.e(r21);
        String r23 = r10.getPackageName();
        q.f(r23, "context.packageName");
        r15.b(r10, r22.c(r23).a());
        goto L24
    L19:
        r18 = r20;
    L24:
        r15.a().p(r14);
        return;
    L5:
        th = move-exception;
        Result.a r24 = Result.Companion;
        r13 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }

    public static final void d(Context r10, String r11, com.obric.matrix.platform.sdk.ones.init.a r12) {
        if (f11921c.compareAndSet(false, true) == true) goto L6;
        bc.a.c("BaseComponentInitHelper", "is inited");
        return;
    L6:
        f11919a.e(r10, r11, r12);
        InitHelper r13 = InitHelper.f11908a;
        Context r14 = r10.getApplicationContext();
        if (r14 == null) goto L11;
        r13.d((Application) r14, r12.d());
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final void e(Context r10, String r11, com.obric.matrix.platform.sdk.ones.init.a r12) {
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L4
        ApplicationInfo r14 = r10.getPackageManager().getApplicationInfo(r10.getPackageName(), PackageManager.ApplicationInfoFlags.of(128));     // Catch: Throwable -> L4
        q.f(r14, "context.packageManager.g….GET_META_DATA.toLong()))");     // Catch: Throwable -> L4
        Object r15 = Result.m35constructorimpl(r10.getString(r14.labelRes));     // Catch: Throwable -> L4
    L7:
        if (Result.m38exceptionOrNullimpl(r15) == null) goto L10;
        r15 = r12.b();     // Catch: PackageManager.NameNotFoundException -> L14
    L10:
        q.f(r15, "runCatching {\n          …ComponentConfig.appName }");     // Catch: PackageManager.NameNotFoundException -> L14
        String r16 = (String) r15;     // Catch: PackageManager.NameNotFoundException -> L14
        ic.d.a r17 = new ic.d.a().b(r12.a());     // Catch: PackageManager.NameNotFoundException -> L14
        PackageInfo r18 = f11920b;     // Catch: PackageManager.NameNotFoundException -> L14
        PackageInfo r19 = null;
        if (r18 != null) goto L16;
        q.y("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L14
        r18 = null;
    L16:
        ic.d.a r20 = r17.e(r18.versionCode);     // Catch: PackageManager.NameNotFoundException -> L14
        PackageInfo r21 = f11920b;     // Catch: PackageManager.NameNotFoundException -> L14
        if (r21 != null) goto L19;
        q.y("packageInfo");     // Catch: PackageManager.NameNotFoundException -> L14
    L20:
        String r22 = r19.versionName;     // Catch: PackageManager.NameNotFoundException -> L14
        if (r22 != null) goto L24;
        r22 = "";
    L24:
        ic.d.a r23 = r20.f(r22).c(r16);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        ic.d r24 = r23.d(r11).a();     // Catch: PackageManager.NameNotFoundException -> L14
        e r25 = e.f20559a;     // Catch: PackageManager.NameNotFoundException -> L14
        Context r26 = r10.getApplicationContext();     // Catch: PackageManager.NameNotFoundException -> L14
        if (r26 == null) goto L31;
        r25.b(r10, (Application) r26, r12.c(), r24, null, new C0187b());     // Catch: PackageManager.NameNotFoundException -> L14
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");     // Catch: PackageManager.NameNotFoundException -> L14
    L19:
        r19 = r21;
    L14:
        e = move-exception;
        Log.e("BaseComponentInitHelper", "initNetwork error " + e.getMessage());
        return;
    L4:
        th = move-exception;
        Result.a r27 = Result.Companion;     // Catch: PackageManager.NameNotFoundException -> L14
        r15 = Result.m35constructorimpl(kotlin.c.a(th));     // Catch: PackageManager.NameNotFoundException -> L14
        goto L7
    }

    public final boolean f(String r10) {
        if (r10 != null) goto L4;
    L11:
        return false;
    L4:
        if (r10.length() == 0) goto L11;
        if (q.b(r10, AdReportParam.ClickPosType.SKIP) == true) goto L11;
        if (q.b(r10, "-1") == true) goto L11;
        return true;
    }
}
