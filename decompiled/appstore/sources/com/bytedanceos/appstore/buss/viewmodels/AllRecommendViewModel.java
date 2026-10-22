package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AllRecommendViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8880e;

    public AllRecommendViewModel(int r10) {
        this.f8879d = r10;
        this.f8880e = kotlin.b.b(AllRecommendViewModel$allRecommendLiveData$2.INSTANCE);
        g();
    }

    public static final /* synthetic */ int f(AllRecommendViewModel r10) {
        return r10.f8879d;
    }

    public final void g() {
        h.d(l0.a(this), null, null, new AllRecommendViewModel$getAllRecommend$1(this, null), 3, null);
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8880e.getValue();
    }
}
