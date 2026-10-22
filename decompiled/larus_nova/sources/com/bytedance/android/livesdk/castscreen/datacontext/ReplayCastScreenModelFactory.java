package com.bytedance.android.livesdk.castscreen.datacontext;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/datacontext/ReplayCastScreenModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayCastScreenModelFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f104460a;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    public ReplayCastScreenModelFactory(DataCenter r100) {
        this.f104460a = r100;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        if (r100.isAssignableFrom(CastScreenViewModel.class) == false) goto L7;
        return new CastScreenViewModel(this.f104460a);
    L7:
        throw new IllegalArgumentException("unknown model ".concat(r100.getName()));
    }
}
