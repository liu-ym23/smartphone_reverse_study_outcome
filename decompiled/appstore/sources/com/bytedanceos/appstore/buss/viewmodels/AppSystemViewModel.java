package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import kotlin.Lazy;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSystemViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8932h;

    public AppSystemViewModel() {
        this.f8928d = kotlin.b.b(AppSystemViewModel$uninstallSystemAppLiveData$2.INSTANCE);
        this.f8929e = kotlin.b.b(AppSystemViewModel$recommendAppLiveData$2.INSTANCE);
        this.f8930f = 1;
        this.f8931g = 1;
        this.f8932h = 20;
        k();
        i();
    }

    public static final /* synthetic */ int f(AppSystemViewModel r10) {
        return r10.f8931g;
    }

    public static final /* synthetic */ int g(AppSystemViewModel r10) {
        return r10.f8932h;
    }

    public static final /* synthetic */ int h(AppSystemViewModel r10) {
        return r10.f8930f;
    }

    public final void i() {
        h.d(l0.a(this), null, null, new AppSystemViewModel$getRecommendAppList$1(this, null), 3, null);
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8929e.getValue();
    }

    public final void k() {
        h.d(l0.a(this), null, null, new AppSystemViewModel$getUninstallSystemAppList$1(this, null), 3, null);
    }

    public final MutableLiveData l() {
        return (MutableLiveData) this.f8928d.getValue();
    }
}
