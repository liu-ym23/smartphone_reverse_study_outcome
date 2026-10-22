package com.bytedance.android.livesdk.ktvapi.util;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f142339a;

    public c(MediatorLiveData r100) {
        this.f142339a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual(this.f142339a.getValue(), r100)) == false) goto L6;
        this.f142339a.setValue(r100);
        return;
    }
}
