package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class SubDetailViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f8985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f8986h;

    public SubDetailViewModel(int r10, String r11) {
        q.g(r11, "id");
        this.f8982d = r10;
        this.f8983e = r11;
        this.f8984f = kotlin.b.b(SubDetailViewModel$subInfoLiveData$2.INSTANCE);
        this.f8985g = new MutableLiveData();
        this.f8986h = new MutableLiveData();
        i();
        k();
    }

    public static final /* synthetic */ String f(SubDetailViewModel r10) {
        return r10.f8983e;
    }

    public static final /* synthetic */ int g(SubDetailViewModel r10) {
        return r10.f8982d;
    }

    public final MutableLiveData h() {
        return this.f8986h;
    }

    public final void i() {
        h.d(l0.a(this), null, null, new SubDetailViewModel$getSubInfo$1(this, null), 3, null);
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8984f.getValue();
    }

    public final void k() {
        h.d(l0.a(this), null, null, new SubDetailViewModel$getSubInfoRecommend$1(this, null), 3, null);
    }

    public final MutableLiveData l() {
        return this.f8985g;
    }
}
