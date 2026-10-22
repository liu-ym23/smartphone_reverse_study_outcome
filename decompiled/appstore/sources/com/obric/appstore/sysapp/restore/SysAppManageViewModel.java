package com.obric.appstore.sysapp.restore;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.ObricSysappWifiUpdateSetting;
import com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes3.dex */
public final class SysAppManageViewModel extends k0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f10993n = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LoadSysAppUseCase f10994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObricSysappWifiUpdateSetting f10995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableStateFlow f10996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateFlow f10997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableStateFlow f10998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StateFlow f10999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f11000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableStateFlow f11001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final StateFlow f11002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final StateFlow f11003m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LoadSysAppUseCase.Filter f11004a;

        public b(LoadSysAppUseCase.Filter r10) {
            q.g(r10, "filter");
            this.f11004a = r10;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            q.g(r10, "modelClass");
            if (r10.isAssignableFrom(SysAppManageViewModel.class) == false) goto L7;
            return new SysAppManageViewModel(this.f11004a);
        L7:
            throw new IllegalArgumentException("Unknown ViewModel class: " + r10.getName());
        }
    }

    static {
        f10993n = new a(null);
    }

    public SysAppManageViewModel(LoadSysAppUseCase.Filter r10) {
        q.g(r10, "filter");
        BaseApplication r11 = BaseApplication.c();
        q.f(r11, "getContext(...)");
        this.f10994d = new LoadSysAppUseCase(r11, r10);
        BaseApplication r12 = BaseApplication.c();
        q.f(r12, "getContext(...)");
        ObricSysappWifiUpdateSetting r13 = new ObricSysappWifiUpdateSetting(r12);
        this.f10995e = r13;
        MutableStateFlow r14 = f1.a(null);
        this.f10996f = r14;
        this.f10997g = kotlinx.coroutines.flow.c.b(r14);
        MutableStateFlow r15 = f1.a(Boolean.FALSE);
        this.f10998h = r15;
        this.f10999i = kotlinx.coroutines.flow.c.b(r15);
        MutableStateFlow r16 = f1.a(null);
        this.f11001k = r16;
        this.f11002l = kotlinx.coroutines.flow.c.b(r16);
        this.f11003m = kotlinx.coroutines.flow.c.Q(r13.values(), l0.a(this), SharingStarted.a.b(SharingStarted.Companion, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, 0, 2, null), null);
    }

    public static final /* synthetic */ LoadSysAppUseCase f(SysAppManageViewModel r10) {
        return r10.f10994d;
    }

    public static final /* synthetic */ ObricSysappWifiUpdateSetting g(SysAppManageViewModel r10) {
        return r10.f10995e;
    }

    public static final /* synthetic */ MutableStateFlow h(SysAppManageViewModel r10) {
        return r10.f11001k;
    }

    public static final /* synthetic */ MutableStateFlow i(SysAppManageViewModel r10) {
        return r10.f10996f;
    }

    public static final /* synthetic */ MutableStateFlow j(SysAppManageViewModel r10) {
        return r10.f10998h;
    }

    public static /* synthetic */ void o(SysAppManageViewModel r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = false;
    L5:
        r10.n(r11);
    }

    @Override // androidx.lifecycle.k0
    public void d() {
        super.d();
    }

    public final StateFlow k() {
        return this.f11002l;
    }

    public final StateFlow l() {
        return this.f10997g;
    }

    public final StateFlow m() {
        return this.f11003m;
    }

    public final void n(boolean r10) {
        j.n("SysAppRestoreViewModel.refresh, loading: " + this.f10998h + ".value, force: " + r10);
        if (((Boolean) this.f10998h.getValue()).booleanValue() == false) goto L6;
        if (r10 == true) goto L6;
        return;
    L6:
        Job r11 = this.f11000j;
        if (r11 == null) goto L9;
        Job.a.b(r11, null, 1, null);
    L9:
        this.f11000j = h.d(l0.a(this), null, null, new SysAppManageViewModel$refresh$1(this, null), 3, null);
    }

    public final void p(boolean r10) {
        j.n("SysAppRestoreViewModel.setWifiUpdateEnabled: " + r10);
        h.d(l0.a(this), null, null, new SysAppManageViewModel$setWifiUpdateEnabled$1(this, r10, null), 3, null);
    }
}
