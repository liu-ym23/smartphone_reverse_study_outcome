package com.bytedance.android.livesdk.ktvimpl.base.component;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f142407a;

    public a(Function1 r100) {
        this.f142407a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f142407a.invoke(r100);
    }
}
