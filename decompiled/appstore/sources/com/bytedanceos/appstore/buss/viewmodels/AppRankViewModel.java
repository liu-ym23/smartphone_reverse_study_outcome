package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppRankViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8926i;

    public AppRankViewModel(int r10, String r11) {
        q.g(r11, "type");
        this.f8921d = r10;
        this.f8922e = r11;
        this.f8923f = kotlin.b.b(AppRankViewModel$appRankLiveData$2.INSTANCE);
        this.f8924g = 1;
        this.f8926i = 30;
        h();
    }

    public static final /* synthetic */ int f(AppRankViewModel r10) {
        return r10.f8921d;
    }

    public static final /* synthetic */ String g(AppRankViewModel r10) {
        return r10.f8922e;
    }

    public final void h() {
        h.d(l0.a(this), null, null, new AppRankViewModel$getAppRank$1(this, null), 3, null);
    }

    public final MutableLiveData i() {
        return (MutableLiveData) this.f8923f.getValue();
    }

    public final int j() {
        return this.f8924g;
    }

    public final int k() {
        return this.f8925h;
    }

    public final int l() {
        return this.f8926i;
    }

    public final void m() {
        int r10 = this.f8924g;
        if (r10 <= 1) goto L6;
        this.f8924g = r10 - 1;
        return;
    }

    public void n(LifecycleOwner r10) {
        q.g(r10, "owner");
        i().o(r10);
    }

    public final void o(int r10) {
        this.f8924g = r10;
    }

    public final void p(int r10) {
        this.f8925h = r10;
    }
}
