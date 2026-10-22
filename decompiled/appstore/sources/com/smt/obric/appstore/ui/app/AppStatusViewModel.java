package com.smt.obric.appstore.ui.app;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.ConfirmDialog;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.GetAppStatusUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.ResumeAppDownloadUseCase;
import com.smt.obric.appstore.ktx.PackageInfoKTxKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes4.dex */
public final class AppStatusViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GetAppStatusUseCase f18155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnqueueAppInstallTaskUseCase f18156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.smt.obric.appstore.domain.usecase.app.install.c f18157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ResumeAppDownloadUseCase f18158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.smt.obric.appstore.domain.usecase.app.install.b f18159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableStateFlow f18160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlow f18161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f18162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public he.a f18163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f18164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableSharedFlow f18165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SharedFlow f18166o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0220a f18167a = null;

        /* JADX INFO: renamed from: com.smt.obric.appstore.ui.app.AppStatusViewModel$a$a, reason: collision with other inner class name */
        public static final class C0220a {
            public /* synthetic */ C0220a(DefaultConstructorMarker r10) {
                this();
            }

            public final AppStatusViewModel a() {
                AppInstallActor.Companion r10 = AppInstallActor.f17891n;
                return new AppStatusViewModel(new GetAppStatusUseCase(r10.b(), false, 2, null), new EnqueueAppInstallTaskUseCase(r10.b()), new com.smt.obric.appstore.domain.usecase.app.install.c(), new ResumeAppDownloadUseCase(r10.b()), new com.smt.obric.appstore.domain.usecase.app.install.b());
            }

            public C0220a() {
            }
        }

        static {
            f18167a = new C0220a(null);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18168a = null;

        static {
            int[] r10 = new int[AppUIStatus.Status.values().length];
            r10[AppUIStatus.Status.UpdateAvailable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r10[AppUIStatus.Status.NotInstalled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r10[AppUIStatus.Status.DownloadFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r10[AppUIStatus.Status.DownloadPaused.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r10[AppUIStatus.Status.DownloadWaitWiFi.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r10[AppUIStatus.Status.DownloadPending.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r10[AppUIStatus.Status.DownloadRunning.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r10[AppUIStatus.Status.Installing.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r10[AppUIStatus.Status.Installed.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f18168a = r10;
        }
    }

    public AppStatusViewModel(GetAppStatusUseCase r10, EnqueueAppInstallTaskUseCase r11, com.smt.obric.appstore.domain.usecase.app.install.c r12, ResumeAppDownloadUseCase r13, com.smt.obric.appstore.domain.usecase.app.install.b r14) {
        q.g(r10, "getAppStatusUseCase");
        q.g(r11, "enqueueAppDownloadUseCase");
        q.g(r12, "pauseAppDownloadUseCase");
        q.g(r13, "resumeAppDownloadUseCase");
        q.g(r14, "openAppUseCase");
        this.f18155d = r10;
        this.f18156e = r11;
        this.f18157f = r12;
        this.f18158g = r13;
        this.f18159h = r14;
        MutableStateFlow r15 = f1.a(AppUIStatus.f18171h.a());
        this.f18160i = r15;
        this.f18161j = kotlinx.coroutines.flow.c.b(r15);
        MutableSharedFlow r16 = b1.a(0, 100, BufferOverflow.DROP_OLDEST);
        this.f18165n = r16;
        this.f18166o = kotlinx.coroutines.flow.c.a(r16);
    }

    public static /* synthetic */ void f(Function2 r10, boolean r11, Function2 r12, int r13, int r14, boolean r15, Bundle r16) {
        x(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void g(AppStatusViewModel r10, Activity r11, AppUIStatus r12, int r13, int r14, boolean r15, Bundle r16) {
        w(r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ EnqueueAppInstallTaskUseCase h(AppStatusViewModel r10) {
        return r10.f18156e;
    }

    public static final /* synthetic */ GetAppStatusUseCase i(AppStatusViewModel r10) {
        return r10.f18155d;
    }

    public static final /* synthetic */ com.smt.obric.appstore.domain.usecase.app.install.c j(AppStatusViewModel r10) {
        return r10.f18157f;
    }

    public static final /* synthetic */ ResumeAppDownloadUseCase k(AppStatusViewModel r10) {
        return r10.f18158g;
    }

    public static final /* synthetic */ MutableSharedFlow l(AppStatusViewModel r10) {
        return r10.f18165n;
    }

    public static final /* synthetic */ MutableStateFlow m(AppStatusViewModel r10) {
        return r10.f18160i;
    }

    public static final void w(AppStatusViewModel r10, Activity r11, AppUIStatus r12, int r13, int r14, boolean r15, Bundle r16) {
        q.g(r10, "this$0");
        q.g(r11, "$activity");
        q.g(r12, "$currentStatus");
        if (r14 != (-1)) goto L6;
        he.a r17 = r12.b();
        q.d(r17);
        r10.s(r11, r17, true, "");
        return;
    }

    public static final void x(Function2 r10, boolean r11, Function2 r12, int r13, int r14, boolean r15, Bundle r16) {
        q.g(r10, "$execute");
        q.g(r12, "$waitWiFi");
        if (r14 != (-2)) goto L5;
        e.Y0(true, r15);
        e0.e(R$string.wifi_auto_download);
        r12.mo0invoke(Boolean.valueOf(r11), Boolean.TRUE);
        return;
    L5:
        if (r14 != (-1)) goto L11;
        e.Y0(false, r15);
        r10.mo0invoke(Boolean.FALSE, Boolean.valueOf(r11));
        return;
    }

    public final void n(com.smt.obric.appstore.domain.app.entity.a r10) {
        q.g(r10, "req");
        Job r11 = this.f18164m;
        if (r11 != null) goto L5;
    L8:
        this.f18164m = h.d(l0.a(this), null, null, new AppStatusViewModel$enqueueDownload$1(this, r10, null), 3, null);
        return;
    L5:
        if (r11.isActive() != true) goto L8;
        j.s("[AppStatus][AppStatusViewModel][Intent] enqueueDownload : skip: enqueueJob is active");
    }

    public final SharedFlow o() {
        return this.f18166o;
    }

    public final StateFlow p() {
        return this.f18161j;
    }

    public final void q(he.a r10) {
        q.g(r10, "targetAppInfo");
        j.n("[AppStatus][AppStatusViewModel][Intent] load, pkg=" + r10.j() + ", versionCode=" + r10.o());
        this.f18163l = r10;
        this.f18160i.setValue(AppUIStatus.f18171h.a());
        Job r11 = this.f18162k;
        if (r11 == null) goto L5;
        Job.a.b(r11, null, 1, null);
    L5:
        this.f18162k = h.d(l0.a(this), null, null, new AppStatusViewModel$load$1(this, r10, null), 3, null);
    }

    public final void r() {
        j.n("[AppStatus][AppStatusViewModel][Intent] open");
        String r10 = ((AppUIStatus) this.f18160i.getValue()).e();
        if (r10 != null) goto L6;
        j.s("[AppStatus][AppStatusViewModel][Intent] open :  skip: null pkg");
        return;
    L6:
        this.f18159h.a(r10);
    }

    public final void s(Activity r10, final he.a r11, boolean r12, final String r13) {
        q.g(r10, "activity");
        q.g(r11, "appInfo");
        q.g(r13, "pageSource");
        j.n("[AppStatus][AppStatusViewModel][Intent] operate, curStatus=" + ((AppUIStatus) this.f18160i.getValue()).f() + ", appInfo=" + r11.q());
        if (((AppUIStatus) this.f18160i.getValue()).d() == false) goto L6;
        j.s("[AppStatus][AppStatusViewModel][Intent] operate : skip: loading");
        return;
    L6:
        final AppUIStatus.Status r14 = ((AppUIStatus) this.f18160i.getValue()).f();
        if (r14 != null) goto L10;
        return;
    L10:
        switch(b.f18168a[r14.ordinal()]) {
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L26;
        };
    L12:
        r();
        return;
    L13:
        j.s("[AppStatus][AppStatusViewModel][Intent] operate : skip: installing");
        return;
    L14:
        t();
        return;
    L15:
        t();
        return;
    L16:
        v(r10, r12, (AppUIStatus) this.f18160i.getValue(), new AppStatusViewModel$operate$6(this), new AppStatusViewModel$operate$7(this, r11));
        return;
    L17:
        v(r10, r12, (AppUIStatus) this.f18160i.getValue(), new AppStatusViewModel$operate$4(this, r11), new AppStatusViewModel$operate$5(this, r11));
        return;
    L18:
        oe.a.a("appstore_btn_click_download_app", new AppStatusViewModel$operate$1(r11, r13, r14));
        v(r10, r12, (AppUIStatus) this.f18160i.getValue(), new AppStatusViewModel$operate$2(this, r11), new AppStatusViewModel$operate$3(this, r11));
        return;
    }

    public final void t() {
        j.n("[AppStatus][AppStatusViewModel][Intent] pause");
        com.smt.obric.appstore.domain.app.entity.a r10 = ((AppUIStatus) this.f18160i.getValue()).c();
        if (r10 != null) goto L6;
        j.s("[AppStatus][AppStatusViewModel][Intent] pause :  skip: null task");
        return;
    L6:
        h.d(l0.a(this), null, null, new AppStatusViewModel$pause$1(this, r10, null), 3, null);
    }

    public final void u(boolean r10) {
        j.n("[AppStatus][AppStatusViewModel][Intent] resume");
        com.smt.obric.appstore.domain.app.entity.a r11 = ((AppUIStatus) this.f18160i.getValue()).c();
        if (r11 != null) goto L6;
        j.s("[AppStatus][AppStatusViewModel][Intent] resume :  skip: null task");
        return;
    L6:
        h.d(l0.a(this), null, null, new AppStatusViewModel$resume$1(this, r11, r10, null), 3, null);
    }

    public final void v(final Activity r10, final boolean r11, final AppUIStatus r12, final Function2 r13, final Function2 r14) {
        he.a r15 = r12.b();
        boolean r16 = true;
        if (r15 == null) goto L10;
        String r17 = r15.k();
        if (r17 == null) goto L10;
        if ((!o.r(r17)) != true) goto L10;
        r13.mo0invoke(Boolean.FALSE, Boolean.valueOf(r11));
        return;
    L10:
        String r18 = r12.e();
        q.d(r18);
        he.a r19 = r12.b();
        if (r19 == null) goto L13;
        String r20 = r19.l();
    L14:
        if (r11 == false) goto L16;
    L19:
        int r21 = e.A();
        if (r21 == 0) goto L53;
        if (r21 != 1) goto L23;
        boolean r22 = false;
        if (e.G(0) == true) goto L30;
    L37:
        if (r16 == true) goto L39;
        return;
    L39:
        he.a r23 = r12.b();
        if (r23 == null) goto L44;
        Long r24 = r23.c();
        if (r24 == null) goto L44;
        long r25 = r24.longValue();
    L45:
        com.smt.obric.appstore.domain.app.entity.a r110 = r12.c();
        if (r110 == null) goto L48;
        long r26 = r110.j();
    L49:
        long r27 = bg.h.e(r25 - r26, 0);
        if (r10.isFinishing() == true) goto L55;
        ConfirmDialog r111 = ConfirmDialog.newInstance(19, r27, r22);
        r111.setOnClickListener(new com.smt.obric.appstore.ui.app.b(r13, r11, r14));
        r111.show(r10.getFragmentManager(), "mobile_data_reminder");
        this.f18165n.tryEmit(AppStatusEvent.a.f18151a);
        return;
    L55:
        return;
    L48:
        r26 = 0;
    L44:
        r25 = 0;
        goto L45
    L30:
        if (e.G(1) == true) goto L32;
        r13.mo0invoke(Boolean.FALSE, Boolean.valueOf(r11));
    L36:
        r16 = false;
        r22 = true;
        goto L37
    L32:
        if (r12.f() != AppUIStatus.Status.DownloadWaitWiFi) goto L34;
        r22 = true;
        goto L37
    L34:
        e0.e(R$string.wifi_auto_download);
        r14.mo0invoke(Boolean.valueOf(r11), Boolean.FALSE);
        goto L36
    L23:
        if (r21 != 2) goto L56;
        r13.mo0invoke(Boolean.valueOf(!e.t0()), Boolean.valueOf(r11));
        return;
    L56:
        return;
    L53:
        e0.e(R$string.retry_connection);
        return;
    L16:
        if (PackageInfoKTxKt.d(r10, r18, r20) == false) goto L19;
        ConfirmDialog r112 = ConfirmDialog.newInstance(27, true, null);
        r112.setOnClickListener(new com.smt.obric.appstore.ui.app.a(this, r10, r12));
        r112.show(r10.getFragmentManager(), "force_install_reminder");
        return;
    L13:
        r20 = null;
        goto L14
    }

    public final void y(Activity r10, final he.a r11) {
        q.g(r10, "activity");
        q.g(r11, "appInfo");
        j.n("[AppStatus][AppStatusViewModel][Intent] tryEnqueueOrResume, curStatus=" + ((AppUIStatus) this.f18160i.getValue()).f() + ", appInfo=" + r11.q());
        if (((AppUIStatus) this.f18160i.getValue()).d() == false) goto L6;
        j.s("[AppStatus][AppStatusViewModel][Intent] tryEnqueueOrResume : skip: loading, appInfo=" + r11.q());
        return;
    L6:
        AppUIStatus.Status r12 = ((AppUIStatus) this.f18160i.getValue()).f();
        if (r12 != null) goto L10;
        return;
    L10:
        switch(b.f18168a[r12.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            default: goto L18;
        };
    L12:
        this.f18165n.tryEmit(AppStatusEvent.b.f18152a);
        j.s("[AppStatus][AppStatusViewModel][Intent] tryEnqueueOrResume : skip: status=" + r12 + ", appInfo=" + r11.q());
        return;
    L13:
        v(r10, false, (AppUIStatus) this.f18160i.getValue(), new AppStatusViewModel$tryEnqueueOrResume$3(this), new AppStatusViewModel$tryEnqueueOrResume$4(this, r11));
        return;
    L14:
        v(r10, false, (AppUIStatus) this.f18160i.getValue(), new AppStatusViewModel$tryEnqueueOrResume$1(this, r11), new AppStatusViewModel$tryEnqueueOrResume$2(this, r11));
        return;
    }
}
