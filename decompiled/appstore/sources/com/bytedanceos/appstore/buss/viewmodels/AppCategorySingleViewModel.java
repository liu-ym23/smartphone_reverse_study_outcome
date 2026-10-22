package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCategorySingleViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8884g;

    public AppCategorySingleViewModel(int r10) {
        this.f8881d = r10;
        this.f8882e = kotlin.b.b(AppCategorySingleViewModel$categoryLiveData$2.INSTANCE);
        this.f8883f = 1;
        this.f8884g = 30;
        i();
    }

    public static final /* synthetic */ int f(AppCategorySingleViewModel r10) {
        return r10.f8881d;
    }

    public final MutableLiveData g() {
        return (MutableLiveData) this.f8882e.getValue();
    }

    public final int h() {
        return this.f8883f;
    }

    public final void i() {
        h.d(l0.a(this), null, null, new AppCategorySingleViewModel$getOneCategoryList$1(this, null), 3, null);
    }

    public final int j() {
        return this.f8884g;
    }

    public void k(LifecycleOwner r10) {
        q.g(r10, "owner");
        g().o(r10);
    }

    public final void l(int r10) {
        this.f8883f = r10;
    }
}
