package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f8972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8978j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8979k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8980l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8981m;

    public SearchViewModel() {
        this.f8973e = kotlin.b.b(SearchViewModel$searchRecommendLiveData$2.INSTANCE);
        this.f8974f = kotlin.b.b(SearchViewModel$searchTipLiveData$2.INSTANCE);
        this.f8975g = kotlin.b.b(SearchViewModel$searchResultLiveData$2.INSTANCE);
        this.f8976h = kotlin.b.b(SearchViewModel$searchHistoryLiveData$2.INSTANCE);
        this.f8979k = 1;
        this.f8980l = 30;
        this.f8981m = 2;
        j();
    }

    public final void f() {
        h.d(l0.a(this), null, null, new SearchViewModel$clearSearchHistory$1(null), 3, null);
    }

    public final int g() {
        return this.f8979k;
    }

    public final boolean h() {
        return this.f8978j;
    }

    public final LiveData i() {
        return (LiveData) this.f8976h.getValue();
    }

    public final void j() {
        h.d(l0.a(this), null, null, new SearchViewModel$getSearchRecommend$1(this, null), 3, null);
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8973e.getValue();
    }

    public final void l(String r10) {
        q.g(r10, "searchKey");
        h.d(l0.a(this), null, null, new SearchViewModel$getSearchResult$1(this, r10, null), 3, null);
    }

    public final MutableLiveData m() {
        return (MutableLiveData) this.f8975g.getValue();
    }

    public final void n(String r10) {
        q.g(r10, "searchKey");
        Job r11 = this.f8972d;
        if (r11 == null) goto L5;
        Job.a.b(r11, null, 1, null);
    L5:
        this.f8972d = h.d(l0.a(this), null, null, new SearchViewModel$getSearchTip$1(this, r10, null), 3, null);
    }

    public final MutableLiveData o() {
        return (MutableLiveData) this.f8974f.getValue();
    }

    public final int p() {
        return this.f8980l;
    }

    public final int q() {
        return this.f8977i;
    }

    public final int r() {
        return this.f8981m;
    }

    public final void s() {
        int r10 = this.f8979k;
        if (r10 <= 1) goto L6;
        this.f8979k = r10 - 1;
        return;
    }

    public void t(LifecycleOwner r10) {
        q.g(r10, "owner");
        k().o(r10);
        o().o(r10);
        m().o(r10);
        i().o(r10);
    }

    public final void u(int r10) {
        this.f8979k = r10;
    }

    public final void v(boolean r10) {
        this.f8978j = r10;
    }

    public final void w(int r10) {
        this.f8977i = r10;
    }
}
