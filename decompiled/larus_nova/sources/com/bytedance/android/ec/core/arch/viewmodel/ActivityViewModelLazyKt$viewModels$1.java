package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentActivity;", "VM", "Landroidx/lifecycle/ViewModel;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements Function0<FragmentActivity> {
    final /* synthetic */ FragmentActivity $this_viewModels;

    public ActivityViewModelLazyKt$viewModels$1(FragmentActivity r100) {
        this.$this_viewModels = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FragmentActivity invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FragmentActivity invoke() {
        return this.$this_viewModels;
    }
}
