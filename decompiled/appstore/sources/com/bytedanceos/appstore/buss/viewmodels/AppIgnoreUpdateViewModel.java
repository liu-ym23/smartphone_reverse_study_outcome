package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppIgnoreUpdateViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8918d;

    public AppIgnoreUpdateViewModel() {
        this.f8918d = kotlin.b.b(AppIgnoreUpdateViewModel$ignoreUpdateAppLiveData$2.INSTANCE);
        g();
    }

    public final MutableLiveData f() {
        return (MutableLiveData) this.f8918d.getValue();
    }

    public final void g() {
        h.d(l0.a(this), kotlinx.coroutines.l0.a(), null, new AppIgnoreUpdateViewModel$getIgnoreUpdateApps$1(this, null), 2, null);
    }

    public final void h(CommonAppEntity r10) {
        if (r10 == null) goto L5;
        h.d(l0.a(this), kotlinx.coroutines.l0.a(), null, new AppIgnoreUpdateViewModel$removeIgnoreUpdateApp$1$1(this, r10, null), 2, null);
        return;
    }

    public void i(LifecycleOwner r10) {
        q.g(r10, "owner");
        f().o(r10);
    }
}
