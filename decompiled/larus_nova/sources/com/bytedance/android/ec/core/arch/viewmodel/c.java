package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class c<VM extends ViewModel> implements Lazy<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VM f43897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<VM> f43898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ViewModelStore> f43899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<ViewModelProvider.Factory> f43900d;

    @Override // kotlin.Lazy
    public final Object getValue() {
        VM r100 = this.f43897a;
        if (r100 != null) goto L6;
        ViewModelProvider.Factory r101 = this.f43900d.invoke();
        VM r102 = (VM) new ViewModelProvider(this.f43899c.invoke(), r101).get(JvmClassMappingKt.getJavaClass(this.f43898b));
        this.f43897a = r102;
        return r102;
    L6:
        return r100;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f43897a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(KClass<VM> r100, Function0<? extends ViewModelStore> r101, Function0<? extends ViewModelProvider.Factory> r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModelClass");
        Intrinsics.checkNotNullParameter(r101, "storeProducer");
        Intrinsics.checkNotNullParameter(r102, "factoryProducer");
        this.f43898b = r100;
        this.f43899c = r101;
        this.f43900d = r102;
    }
}
