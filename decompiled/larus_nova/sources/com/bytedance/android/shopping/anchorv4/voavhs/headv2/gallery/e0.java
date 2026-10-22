package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes13.dex */
public final class e0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f169297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f169298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveData f169299c;

    public e0(MediatorLiveData r100, Function2 r101, MutableLiveData r102) {
        this.f169297a = r100;
        this.f169298b = r101;
        this.f169299c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f169297a.setValue(this.f169298b.invoke(this.f169299c.getValue(), r100));
    }
}
