package com.smt.obric.appstore.domain.usecase.app.install;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.capabilitykit.PackageUtils;
import com.smt.obric.appstore.domain.oapplet.InstalledOApplets;
import com.smt.obric.appstore.domain.oapplet.OAppletInfo;
import com.smt.obric.appstore.domain.oapplet.OAppletUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18145a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ Object a(a r10, Context r11) {
            return r10.b(r11);
        }

        public final Object b(Context r10) {
            Result.a r11 = Result.Companion;     // Catch: Throwable -> L11
            Object r12 = r10.getSystemService("activity");     // Catch: Throwable -> L11
            q.e(r12, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L11
            ActivityManager r13 = (ActivityManager) r12;     // Catch: Throwable -> L11
            List<ActivityManager.RunningTaskInfo> r14 = r13.getRunningTasks(1000);     // Catch: Throwable -> L11
            if (r14 == null) goto L17;
            q.d(r14);     // Catch: Throwable -> L11
            Iterator<T> r15 = r14.iterator();     // Catch: Throwable -> L11
        L7:
            if (r15.hasNext() == false) goto L17;
            ActivityManager.RunningTaskInfo r16 = (ActivityManager.RunningTaskInfo) r15.next();     // Catch: Throwable -> L11
            ComponentName r17 = r16.baseActivity;     // Catch: Throwable -> L11
            if (r17 == null) goto L13;
            String r18 = r17.getPackageName();     // Catch: Throwable -> L11
        L15:
            if (q.b(r18, PackageUtils.NOVA_PKG_NAME) == false) goto L7;
            r13.moveTaskToFront(r16.taskId, 1);     // Catch: Throwable -> L11
        L18:
            return Result.m35constructorimpl(Unit.f21064a);
        L13:
            r18 = null;
        L17:
            Uri r19 = Uri.parse("doubao://flow/home");     // Catch: Throwable -> L11
            q.f(r19, "parse(this)");     // Catch: Throwable -> L11
            Intent r20 = new Intent("android.intent.action.VIEW", r19);     // Catch: Throwable -> L11
            r20.setPackage(PackageUtils.NOVA_PKG_NAME);     // Catch: Throwable -> L11
            r20.addCategory("android.intent.category.DEFAULT");     // Catch: Throwable -> L11
            r20.addFlags(268435456);     // Catch: Throwable -> L11
            r10.startActivity(r20);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.a r21 = Result.Companion;
            return Result.m35constructorimpl(kotlin.c.a(th));
        }

        public a() {
        }
    }

    static {
        f18145a = new a(null);
    }

    public b() {
    }

    public final void a(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        BaseApplication r11 = BaseApplication.c();
        q.f(r11, "getContext(...)");
        OAppletUtil r12 = OAppletUtil.f18065a;
        if (r12.g(r10) == false) goto L17;
        Map r13 = (Map) InstalledOApplets.f18057a.f().getValue();
        if (r13 == null) goto L42;
        OAppletInfo r14 = (OAppletInfo) r13.get(r10);
        if (r14 == null) goto L43;
        Result.a r15 = Result.Companion;     // Catch: Throwable -> L10
        r12.h(r11, r14);     // Catch: Throwable -> L10
        Object r16 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L10
    L12:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L15;
        j.q("[OApplet] OpenAppUseCase openOApplet failed, pkg: " + r10 + ", action=" + r14.getAction(), r17);
    L15:
        Result.m34boximpl(r16);
        return;
    L10:
        th = move-exception;
        Result.a r18 = Result.Companion;
        r16 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L12
    L43:
        return;
    L42:
        return;
    L17:
        if (e.K0(r11, r10) == true) goto L45;
        boolean r19 = false;
        Result.a r20 = Result.Companion;     // Catch: Throwable -> L21
        Object r21 = Result.m35constructorimpl(r11.getPackageManager().getPackageInfo(r10, 0));     // Catch: Throwable -> L21
    L24:
        if (Result.m41isFailureimpl(r21) == false) goto L26;
        r21 = null;
    L26:
        if (r21 == null) goto L29;
        r19 = true;
    L29:
        if (q.b(PackageUtils.NOVA_PKG_NAME, r10) == false) goto L32;
        a.a(f18145a, r11);
        return;
    L32:
        if (q.b("com.bytedance.obric.airecordassistant", r10) == false) goto L34;
        e0.g(r11.getString(R$string.system_app_only_widget));
        return;
    L34:
        if (r19 == true) goto L36;
        e0.g(r11.getString(R$string.app_uninstalled));
        return;
    L36:
        e0.g(r11.getString(R$string.system_app_no_main_activiy));
        return;
    L21:
        th = move-exception;
        Result.a r22 = Result.Companion;
        r21 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L24
    }
}
