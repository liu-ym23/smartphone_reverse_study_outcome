package com.obric.appstore.util;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11068a;

    public b() {
    }

    public abstract void a(Object r10);

    @Override // androidx.lifecycle.Observer
    public void onChanged(Object r10) {
        if (kotlin.jvm.internal.q.b(r10, this.f11068a) == false) goto L5;
        return;
    L5:
        this.f11068a = r10;
        a(r10);
    }
}
