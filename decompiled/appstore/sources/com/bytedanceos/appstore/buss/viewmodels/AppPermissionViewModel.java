package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPermissionViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8920e;

    public AppPermissionViewModel(String r10) {
        q.g(r10, "appPackageName");
        this.f8919d = r10;
        this.f8920e = kotlin.b.b(AppPermissionViewModel$appPermissionLiveData$2.INSTANCE);
        g();
    }

    public static final /* synthetic */ String f(AppPermissionViewModel r10) {
        return r10.f8919d;
    }

    public final void g() {
        h.d(l0.a(this), null, null, new AppPermissionViewModel$getAppPermission$1(this, null), 3, null);
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8920e.getValue();
    }
}
