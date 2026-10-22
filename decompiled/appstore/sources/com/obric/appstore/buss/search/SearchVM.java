package com.obric.appstore.buss.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.l0;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchVM extends com.obric.appstore.base.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f10869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData f10870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData f10871f;

    public SearchVM(@NotNull b0 r10) {
        q.g(r10, "savedStateHandle");
        this.f10869d = r10;
        this.f10870e = new MutableLiveData();
        this.f10871f = new MutableLiveData();
    }

    public static final /* synthetic */ MutableLiveData f(SearchVM r10) {
        return r10.f10871f;
    }

    public final void g() {
        kotlinx.coroutines.h.d(l0.a(this), null, null, new SearchVM$clearSearchHistory$1(this, null), 3, null);
    }

    public final b0 h() {
        return this.f10869d;
    }

    public final LiveData i() {
        return this.f10871f;
    }

    public final LiveData j() {
        return this.f10870e;
    }

    public final void k() {
        kotlinx.coroutines.h.d(l0.a(this), null, null, new SearchVM$init$1(this, null), 3, null);
    }

    public final void l(String r10) {
        q.g(r10, "kwd");
        this.f10870e.p(new j(r10, false));
    }

    public final void m(String r10) {
        q.g(r10, "kwd");
        kotlinx.coroutines.h.d(l0.a(this), null, null, new SearchVM$updateSearchHistory$1(this, r10, null), 3, null);
    }
}
