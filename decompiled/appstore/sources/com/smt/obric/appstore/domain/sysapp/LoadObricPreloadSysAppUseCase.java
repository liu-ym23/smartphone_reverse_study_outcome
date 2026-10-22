package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class LoadObricPreloadSysAppUseCase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f18074b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18075a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f18079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f18080e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f18081f;

        public a(String r10, String r11, long r12, String r13, String r14, String r15) {
            q.g(r10, "pkgName");
            q.g(r11, "appName");
            q.g(r13, "versionName");
            q.g(r14, ServerElements.ICON);
            q.g(r15, "apkFilePath");
            this.f18076a = r10;
            this.f18077b = r11;
            this.f18078c = r12;
            this.f18079d = r13;
            this.f18080e = r14;
            this.f18081f = r15;
        }

        public final String a() {
            return this.f18081f;
        }

        public final String b() {
            return this.f18077b;
        }

        public final String c() {
            return this.f18080e;
        }

        public final String d() {
            return this.f18076a;
        }

        public final long e() {
            return this.f18078c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(this.f18076a, r11.f18076a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f18077b, r11.f18077b) == true) goto L15;
            return false;
        L15:
            if (this.f18078c == r11.f18078c) goto L18;
            return false;
        L18:
            if (q.b(this.f18079d, r11.f18079d) == true) goto L21;
            return false;
        L21:
            if (q.b(this.f18080e, r11.f18080e) == true) goto L24;
            return false;
        L24:
            if (q.b(this.f18081f, r11.f18081f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final String f() {
            return this.f18079d;
        }

        public int hashCode() {
            return (((((((((this.f18076a.hashCode() * 31) + this.f18077b.hashCode()) * 31) + Long.hashCode(this.f18078c)) * 31) + this.f18079d.hashCode()) * 31) + this.f18080e.hashCode()) * 31) + this.f18081f.hashCode();
        }

        public String toString() {
            return "ApkInfo(pkgName=" + this.f18076a + ", appName=" + this.f18077b + ", versionCode=" + this.f18078c + ", versionName=" + this.f18079d + ", icon=" + this.f18080e + ", apkFilePath=" + this.f18081f + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f18074b = new b(null);
    }

    public LoadObricPreloadSysAppUseCase(Context r10) {
        q.g(r10, "context");
        this.f18075a = r10;
    }

    public static final /* synthetic */ Object a(LoadObricPreloadSysAppUseCase r10, File r11, Continuation r12) {
        return r10.d(r11, r12);
    }

    public static final /* synthetic */ AppInfo b(LoadObricPreloadSysAppUseCase r10, a r11) {
        return r10.e(r11);
    }

    public final Object c(String r10, Continuation r11) {
        if ((r11 instanceof LoadObricPreloadSysAppUseCase$invoke$1) == false) goto L7;
        LoadObricPreloadSysAppUseCase$invoke$1 r12 = (LoadObricPreloadSysAppUseCase$invoke$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        kotlin.c.b(r14);
    L18:
        return ((Result) r14).m44unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        CoroutineDispatcher r17 = l0.b();
        LoadObricPreloadSysAppUseCase$invoke$2 r18 = new LoadObricPreloadSysAppUseCase$invoke$2(r10, this, null);
        r12.label = 1;
        r14 = h.g(r17, r18, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new LoadObricPreloadSysAppUseCase$invoke$1(this, r11);
        goto L8
    }

    public final Object d(File r24, Continuation r25) {
        if ((r25 instanceof LoadObricPreloadSysAppUseCase$resolveApkInfo$1) == false) goto L7;
        LoadObricPreloadSysAppUseCase$resolveApkInfo$1 r10 = (LoadObricPreloadSysAppUseCase$resolveApkInfo$1) r25;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = kotlin.coroutines.intrinsics.a.d();
        int r14 = r10.label;
        a r15 = null;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        String r16 = (String) r10.L$4;
        PackageManager r17 = (PackageManager) r10.L$3;
        PackageInfo r18 = (PackageInfo) r10.L$2;
        LoadObricPreloadSysAppUseCase r19 = (LoadObricPreloadSysAppUseCase) r10.L$1;
        File r20 = (File) r10.L$0;
        kotlin.c.b(r12);
        File r110 = r20;
    L30:
        if (((Boolean) r12).booleanValue() == false) goto L32;
        PackageManager r21 = r17;
    L36:
        ApplicationInfo r22 = r18.applicationInfo;
        if (r22 == null) goto L46;
        CharSequence r23 = r22.loadLabel(r21);
        q.f(r23, "loadLabel(...)");
        ke.b.a r26 = ke.b.f21055b;
        String r27 = r110.getAbsolutePath();
        q.f(r27, "getAbsolutePath(...)");
        String r28 = r26.b(r27);
        if (q.b(r16, "com.obric.recorder") == false) goto L42;
        j.n("[SysAppNameDebug][LoadObricPreloadSysAppUseCase] resolve success path=" + r110.getAbsolutePath() + " pkg=" + r16 + " label=" + r23 + " version=" + r18.getLongVersionCode() + '/' + r18.versionName + " labelRes=" + r22.labelRes + " nonLocalizedLabel=" + r22.nonLocalizedLabel + " flags=" + r22.flags + " sourceDir=" + r22.sourceDir + " publicSourceDir=" + r22.publicSourceDir);
    L42:
        String r111 = r23.toString();
        long r112 = r18.getLongVersionCode();
        String r29 = r18.versionName;
        if (r29 != null) goto L45;
        r29 = "";
    L45:
        String r210 = r29;
        String r30 = r110.getAbsolutePath();
        q.f(r30, "getAbsolutePath(...)");
        r15 = new a(r16, r111, r112, r210, r28, r30);
    L46:
        if (r15 != null) goto L48;
        j.n("[AppStatus][SysApp] resolveApkInfo failed: " + r110.getAbsolutePath());
    L48:
        return r15;
    L32:
        if (q.b(r16, "com.obric.recorder") == false) goto L46;
        j.n("[SysAppNameDebug][LoadObricPreloadSysAppUseCase] resolve skip lbt path=" + r110.getAbsolutePath());
        goto L46
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r12);
        r21 = this.f18075a.getPackageManager();
        if (r21 != null) goto L17;
    L16:
        r110 = r24;
        goto L46
    L17:
        r18 = r21.getPackageArchiveInfo(r24.getAbsolutePath(), 0);
        if (r18 == null) goto L16;
        String r113 = r18.packageName;
        q.f(r113, "packageName");
        if (q.b(r113, "com.obric.recorder") == false) goto L24;
        j.n("[SysAppNameDebug][LoadObricPreloadSysAppUseCase] resolve start path=" + r24.getAbsolutePath() + " pkg=" + r113 + " version=" + r18.getLongVersionCode() + '/' + r18.versionName);
    L24:
        if (q.b("com.lbt.gms", r113) == false) goto L35;
        GmsUtil r114 = GmsUtil.f18070a;
        Context r115 = this.f18075a;
        r110 = r24;
        r10.L$0 = r110;
        r10.L$1 = this;
        r10.L$2 = r18;
        r10.L$3 = r21;
        r10.L$4 = r113;
        r10.label = 1;
        Object r31 = r114.a(r115, r10);
        if (r31 != r13) goto L28;
        return r13;
    L28:
        r17 = r21;
        r12 = r31;
        r16 = r113;
        goto L30
    L35:
        r110 = r24;
        r16 = r113;
    L7:
        r10 = new LoadObricPreloadSysAppUseCase$resolveApkInfo$1(this, r25);
        goto L8
    }

    public final AppInfo e(a r10) {
        AppInfo r11 = new AppInfo();
        if (q.b(r10.d(), "com.obric.recorder") == false) goto L5;
        j.n("[SysAppNameDebug][LoadObricPreloadSysAppUseCase] toAppInfo pkg=" + r10.d() + " name=" + r10.b() + " version=" + r10.e() + '/' + r10.f() + " path=" + r10.a());
    L5:
        r11.appName = r10.b();
        r11.appPackageName = r10.d();
        r11.appVersionCode = (int) r10.e();
        r11.appVersionName = r10.f();
        r11.appIcon = r10.c();
        r11.obricPreloadApkFilePath = r10.a();
        r11.appSource = "obric_sys_app";
        return r11;
    }
}
