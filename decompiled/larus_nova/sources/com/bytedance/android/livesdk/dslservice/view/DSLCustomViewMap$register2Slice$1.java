package com.bytedance.android.livesdk.dslservice.view;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import fu1.e;
import fu1.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yt1.f;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/ecom/arch/slice/render/elements/BaseSlcViewManager;", "it", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DSLCustomViewMap$register2Slice$1 extends Lambda implements Function1<SlcTemplateContext, BaseSlcViewManager<?>> {
    final /* synthetic */ f $provider;

    public DSLCustomViewMap$register2Slice$1(f r100) {
        this.$provider = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BaseSlcViewManager<?> invoke2(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = this.$provider.getType();
        if (r101 == 1) goto L20;
        if (r101 != 2) goto L7;
        f r102 = this.$provider;
        if (r102 == null) goto L18;
        return new fu1.f(r100, r102);
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<out android.view.ViewGroup>");
    L7:
        if (r101 != 3) goto L21;
        f r103 = this.$provider;
        if (r103 == null) goto L13;
        return new e(r100, r103);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<out com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView>");
    L21:
        return new g(r100, this.$provider);
    L20:
        return new g(r100, this.$provider);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BaseSlcViewManager<?> invoke(SlcTemplateContext r100) {
        return invoke2(r100);
    }
}
