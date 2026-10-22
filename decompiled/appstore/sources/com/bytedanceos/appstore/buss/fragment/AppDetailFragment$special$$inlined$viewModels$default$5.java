package com.bytedanceos.appstore.buss.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/k0;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$8", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFragmentViewModelLazy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt$viewModels$8\n*L\n1#1,222:1\n*E\n"})
public final class AppDetailFragment$special$$inlined$viewModels$default$5 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Lazy $owner$delegate;
    final /* synthetic */ Fragment $this_viewModels;

    public AppDetailFragment$special$$inlined$viewModels$default$5(Fragment r10, Lazy r11) {
        this.$this_viewModels = r10;
        this.$owner$delegate = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelStoreOwner r10 = FragmentViewModelLazyKt.b(this.$owner$delegate);
        if ((r10 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
        HasDefaultViewModelProviderFactory r11 = (HasDefaultViewModelProviderFactory) r10;
    L6:
        if (r11 == null) goto L9;
        ViewModelProvider.Factory r12 = r11.getDefaultViewModelProviderFactory();
        if (r12 == null) goto L9;
        return r12;
    L9:
        ViewModelProvider.Factory r13 = this.$this_viewModels.getDefaultViewModelProviderFactory();
        kotlin.jvm.internal.q.f(r13, "defaultViewModelProviderFactory");
        return r13;
    L5:
        r11 = null;
        goto L6
    }
}
