package com.bytedance.android.shopping.base.arch.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes13.dex */
public final class a<VM extends ViewModel> implements Lazy<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VM f170689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<VM> f170690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ViewModelStore> f170691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<ViewModelProvider.Factory> f170692d;

    @Override // kotlin.Lazy
    public final Object getValue() {
        VM r100 = this.f170689a;
        if (r100 != null) goto L6;
        ViewModelProvider.Factory r101 = this.f170692d.invoke();
        VM r102 = (VM) new ViewModelProvider(this.f170691c.invoke(), r101).get(JvmClassMappingKt.getJavaClass(this.f170690b));
        this.f170689a = r102;
        return r102;
    L6:
        return r100;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this.f170689a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public a(KClass r100, FragmentViewModelLazyKt$viewModels$2 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModelClass");
        Intrinsics.checkNotNullParameter(r101, "storeProducer");
        Intrinsics.checkNotNullParameter(r102, "factoryProducer");
        this.f170690b = r100;
        this.f170691c = r101;
        this.f170692d = r102;
    }
}
