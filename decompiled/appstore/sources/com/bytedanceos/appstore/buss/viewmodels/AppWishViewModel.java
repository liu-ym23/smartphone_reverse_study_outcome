package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;
import h7.d;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppWishViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f8943i;

    public AppWishViewModel() {
        this.f8938d = kotlin.b.b(AppWishViewModel$wishAppLiveData$2.INSTANCE);
        this.f8939e = kotlin.b.b(AppWishViewModel$recommondAppLiveData$2.INSTANCE);
        this.f8940f = kotlin.b.b(AppWishViewModel$commonGetWishAppLiveData$2.INSTANCE);
        this.f8941g = kotlin.b.b(AppWishViewModel$commonPostWishAppLiveData$2.INSTANCE);
        this.f8942h = kotlin.b.b(AppWishViewModel$postWishAppLiveData$2.INSTANCE);
        this.f8943i = new ArrayList();
        n();
    }

    public static final /* synthetic */ MutableLiveData f(AppWishViewModel r10) {
        return r10.i();
    }

    public static final /* synthetic */ ArrayList g(AppWishViewModel r10) {
        return r10.f8943i;
    }

    private final MutableLiveData i() {
        return (MutableLiveData) this.f8941g.getValue();
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8940f.getValue();
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8942h.getValue();
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8939e.getValue();
    }

    public final void l() {
        h.d(l0.a(this), null, null, new AppWishViewModel$getWishAppList$1(this, null), 3, null);
    }

    public final MutableLiveData m() {
        return (MutableLiveData) this.f8938d.getValue();
    }

    public final void n() {
        if (AccountDataCache.b().n() == true) goto L5;
        MutableLiveData r10 = m();
        String r11 = BaseApplication.c().getString(R.string.appstore_no_user);
        q.f(r11, "getString(...)");
        r10.p(new com.bytedanceos.appstore.buss.network.h.a(r11, -3, null, 4, null));
    L5:
        l();
    }

    public final void o(int r10, CommonAppEntity r11) {
        h.d(l0.a(this), null, null, new AppWishViewModel$postWishApp$1(this, r10, r11, null), 3, null);
    }

    public void p(LifecycleOwner r10) {
        q.g(r10, "owner");
        m().o(r10);
        h().o(r10);
        i().o(r10);
        j().o(r10);
    }
}
