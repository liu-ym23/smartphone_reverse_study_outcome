package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class PageAppsViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8971f;

    public PageAppsViewModel(int r10, int r11) {
        this.f8969d = r10;
        this.f8970e = r11;
        this.f8971f = kotlin.b.b(PageAppsViewModel$pageLiveData$2.INSTANCE);
        h();
    }

    public static final /* synthetic */ int f(PageAppsViewModel r10) {
        return r10.f8970e;
    }

    public static final /* synthetic */ int g(PageAppsViewModel r10) {
        return r10.f8969d;
    }

    public final void h() {
        h.d(l0.a(this), null, null, new PageAppsViewModel$getPageApps$1(this, null), 3, null);
    }

    public final MutableLiveData i() {
        return (MutableLiveData) this.f8971f.getValue();
    }

    public void j(LifecycleOwner r10) {
        q.g(r10, "owner");
        i().o(r10);
    }
}
