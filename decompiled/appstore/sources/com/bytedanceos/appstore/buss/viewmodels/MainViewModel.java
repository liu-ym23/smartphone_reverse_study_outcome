package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.cms.beta.CmsDataWrap;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaTemplateEntity;
import com.bytedanceos.appstore.buss.network.g;
import h7.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class MainViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f8957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData f8959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f8960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f8963j;

    public MainViewModel() {
        this.f8957d = new MutableLiveData();
        this.f8958e = kotlin.b.b(MainViewModel$firstBootLiveData$2.INSTANCE);
        this.f8959f = new MutableLiveData();
        this.f8960g = new MutableLiveData();
        this.f8961h = kotlin.b.b(MainViewModel$searchContentLiveData$2.INSTANCE);
        this.f8962i = kotlin.b.b(MainViewModel$searchResultLiveData$2.INSTANCE);
        this.f8963j = new MutableLiveData();
    }

    public static final /* synthetic */ g f(MainViewModel r10, g r11) {
        return r10.m(r11);
    }

    public final MutableLiveData g() {
        return (MutableLiveData) this.f8958e.getValue();
    }

    public final MutableLiveData h() {
        return this.f8957d;
    }

    public final MutableLiveData i() {
        return this.f8960g;
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8961h.getValue();
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8962i.getValue();
    }

    public final MutableLiveData l() {
        return this.f8963j;
    }

    public final g m(g r10) {
        if ((r10 instanceof g.c) == false) goto L10;
        g.c r11 = (g.c) r10;
        CmsDataWrap r12 = (CmsDataWrap) r11.a();
        if (r12 == null) goto L7;
        List<BetaTemplateEntity> r13 = r12.getList();
    L8:
        ArrayList r14 = com.bytedanceos.appstore.buss.utilities.b.f8835a.a(r13);
        return new g.c(r11.b(), r11.c(), r14);
    L7:
        r13 = null;
        goto L8
    L10:
        if ((r10 instanceof g.a) == false) goto L13;
        g.a r15 = (g.a) r10;
        return new g.a(r15.a(), r15.b());
    L13:
        if ((r10 instanceof g.b) == false) goto L16;
        return r10;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public void n(LifecycleOwner r10) {
        q.g(r10, "owner");
        this.f8957d.o(r10);
        this.f8959f.o(r10);
        this.f8960g.o(r10);
        j().o(r10);
        k().o(r10);
        this.f8963j.o(r10);
    }

    public final void o(String r10) {
        q.g(r10, "searchResult");
        k().p(r10);
    }
}
