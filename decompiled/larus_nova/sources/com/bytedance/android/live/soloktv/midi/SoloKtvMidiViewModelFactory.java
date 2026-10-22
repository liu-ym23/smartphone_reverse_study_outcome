package com.bytedance.android.live.soloktv.midi;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/soloktv/midi/SoloKtvMidiViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvMidiViewModelFactory implements ViewModelProvider.Factory {
    public SoloKtvMidiViewModelFactory() {
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        if (r100.isAssignableFrom(SoloKtvMidiViewModel.class) == false) goto L7;
        return new SoloKtvMidiViewModel();
    L7:
        throw new IllegalArgumentException("unknown model ".concat(r100.getName()));
    }
}
