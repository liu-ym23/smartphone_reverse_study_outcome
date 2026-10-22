package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class GiftViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8956h;

    public GiftViewModel(int r10, int r11) {
        this.f8952d = r10;
        this.f8953e = r11;
        this.f8954f = kotlin.b.b(GiftViewModel$commonMyGiftLiveData$2.INSTANCE);
        this.f8955g = kotlin.b.b(GiftViewModel$allGiftLiveData$2.INSTANCE);
        this.f8956h = kotlin.b.b(GiftViewModel$myGiftLiveData$2.INSTANCE);
        if (AccountDataCache.b().n() == false) goto L5;
        k();
    L6:
        h();
        return;
    L5:
        MutableLiveData r12 = l();
        String r13 = BaseApplication.c().getString(R.string.appstore_no_user);
        q.f(r13, "getString(...)");
        r12.p(new h.a(r13, -3, null, 4, null));
        goto L6
    }

    public static final /* synthetic */ int f(GiftViewModel r10) {
        return r10.f8953e;
    }

    public static final /* synthetic */ int g(GiftViewModel r10) {
        return r10.f8952d;
    }

    public final void h() {
        kotlinx.coroutines.h.d(l0.a(this), null, null, new GiftViewModel$getAllGift$1(this, null), 3, null);
    }

    public final MutableLiveData i() {
        return (MutableLiveData) this.f8955g.getValue();
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8954f.getValue();
    }

    public final void k() {
        kotlinx.coroutines.h.d(l0.a(this), null, null, new GiftViewModel$getMyGift$1(this, null), 3, null);
    }

    public final MutableLiveData l() {
        return (MutableLiveData) this.f8956h.getValue();
    }

    public void m(LifecycleOwner r10) {
        q.g(r10, "owner");
        j().o(r10);
        i().o(r10);
        l().o(r10);
    }
}
