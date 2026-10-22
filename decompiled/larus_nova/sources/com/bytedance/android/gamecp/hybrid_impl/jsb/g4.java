package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f4 f57505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f57506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f57507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h4 f57508d;

    public g4(f4 r100, CallContext r101, List r102, h4 r103) {
        this.f57505a = r100;
        this.f57506b = r101;
        this.f57507c = r102;
        this.f57508d = r103;
    }

    public final void a() {
        Context r100 = this.f57506b.getContext();
        List r101 = this.f57507c;
        Integer r102 = this.f57508d.a();
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packages");
        f4 r105 = this.f57505a;
        GetInstalledAppInfoResultModel r106 = new GetInstalledAppInfoResultModel();
        r106.a(GetInstalledAppInfoResultModel.Code.Success);
        GetInstalledAppInfoResultModel.a r107 = new GetInstalledAppInfoResultModel.a();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r101.iterator();
        int r110 = 0;
    L8:
        if (r109.hasNext() == false) goto L37;
        String r111 = (String) r109.next();
        GetInstalledAppInfoResultModel.b r112 = null;
        PackageManager r113 = r100.getPackageManager();     // Catch: Exception -> L32
        PackageInfo r114 = r113.getPackageInfo(r111, r103);     // Catch: Exception -> L32
        if (r114 == null) goto L20;
        GetInstalledAppInfoResultModel.b r115 = new GetInstalledAppInfoResultModel.b();     // Catch: Exception -> L32
        r115.d(r111);     // Catch: Exception -> L32
        ApplicationInfo r116 = r114.applicationInfo;     // Catch: Exception -> L32
        if (r116 != null) goto L42;
    L21:
        String r117 = null;
    L22:
        r115.a(r117);     // Catch: Exception -> L32
        f4 r118 = r105;
        r115.c(String.valueOf(r114.firstInstallTime));     // Catch: Exception -> L39
        r115.e(String.valueOf(r114.lastUpdateTime));     // Catch: Exception -> L39
        r115.f(String.valueOf(r114.versionCode));     // Catch: Exception -> L39
        r115.g(r114.versionName);     // Catch: Exception -> L39
        r110 = r110 + 1;     // Catch: Exception -> L39
        if (r110 > r104) goto L31;
        ApplicationInfo r119 = r114.applicationInfo;     // Catch: Exception -> L39
        if (r119 == null) goto L29;
        Drawable r120 = r119.loadIcon(r113);     // Catch: Exception -> L39
    L30:
        r115.b(f4.b.a(r120));     // Catch: Exception -> L39
        goto L31
    L29:
        r120 = null;
    L31:
        r112 = r115;
    L34:
        if (r112 == null) goto L36;
        r108.add(r112);
    L36:
        r105 = r118;
        r103 = 0;
        goto L8
    L42:
        CharSequence r121 = r116.loadLabel(r113);     // Catch: Exception -> L19
        if (r121 == null) goto L21;
        r117 = r121.toString();     // Catch: Exception -> L19
    L20:
        r118 = r105;
    L32:
        r118 = r105;
        goto L34
    L37:
        r107.a(r108);
        Unit r122 = Unit.INSTANCE;
        r106.b(r107);
        r105.finishWithResult(r106);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
