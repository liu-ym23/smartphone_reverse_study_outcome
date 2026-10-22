package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes13.dex */
public final class d0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f169290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f169291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveData f169292c;

    public d0(MediatorLiveData r100, Function2 r101, MutableLiveData r102) {
        this.f169290a = r100;
        this.f169291b = r101;
        this.f169292c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f169290a.setValue(this.f169291b.invoke(r100, this.f169292c.getValue()));
    }
}
