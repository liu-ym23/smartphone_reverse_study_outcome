package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class MySubViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8968d;

    public MySubViewModel() {
        this.f8968d = kotlin.b.b(MySubViewModel$mySubLiveData$2.INSTANCE);
        f();
    }

    public final void f() {
        h.d(l0.a(this), null, null, new MySubViewModel$getMySub$1(this, null), 3, null);
    }

    public final MutableLiveData g() {
        return (MutableLiveData) this.f8968d.getValue();
    }

    public void h(LifecycleOwner r10) {
        q.g(r10, "owner");
        g().o(r10);
    }
}
