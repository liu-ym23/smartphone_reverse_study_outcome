package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import kotlin.Lazy;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCategoryViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8886e;

    public AppCategoryViewModel(int r10) {
        this.f8885d = r10;
        this.f8886e = kotlin.b.b(AppCategoryViewModel$categoryLiveData$2.INSTANCE);
        g();
    }

    public static final /* synthetic */ int f(AppCategoryViewModel r10) {
        return r10.f8885d;
    }

    public final void g() {
        h.d(l0.a(this), null, null, new AppCategoryViewModel$getCategoryList$1(this, null), 3, null);
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8886e.getValue();
    }
}
