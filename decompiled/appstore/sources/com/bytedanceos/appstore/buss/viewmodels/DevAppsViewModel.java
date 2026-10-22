package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.common.toolbox.ServerElements;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class DevAppsViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8949h;

    public DevAppsViewModel(String r10, String r11) {
        q.g(r10, ServerElements.DEVELOPER);
        q.g(r11, "developerId");
        this.f8945d = r10;
        this.f8946e = r11;
        this.f8947f = kotlin.b.b(DevAppsViewModel$devAppsLiveData$2.INSTANCE);
        this.f8948g = 1;
        this.f8949h = 30;
        i();
    }

    public static final /* synthetic */ String f(DevAppsViewModel r10) {
        return r10.f8945d;
    }

    public static final /* synthetic */ String g(DevAppsViewModel r10) {
        return r10.f8946e;
    }

    public final int h() {
        return this.f8948g;
    }

    public final void i() {
        h.d(l0.a(this), null, null, new DevAppsViewModel$getDevApps$1(this, null), 3, null);
    }

    public final MutableLiveData j() {
        return (MutableLiveData) this.f8947f.getValue();
    }

    public final int k() {
        return this.f8949h;
    }

    public final void l() {
        int r10 = this.f8948g;
        if (r10 <= 1) goto L6;
        this.f8948g = r10 - 1;
        return;
    }

    public void m(LifecycleOwner r10) {
        q.g(r10, "owner");
        j().o(r10);
    }

    public final void n(int r10) {
        this.f8948g = r10;
    }
}
