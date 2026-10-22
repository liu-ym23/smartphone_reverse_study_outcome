package com.obric.oui.texteffects;

import android.graphics.BlurMaskFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class OProtocolTextEffectTextView$drawTextLayer$2 extends FunctionReferenceImpl implements Function1<Float, BlurMaskFilter> {
    public OProtocolTextEffectTextView$drawTextLayer$2(Object r10) {
        super(1, r10, OProtocolTextEffectTextView.class, "getBlurMaskFilter", "getBlurMaskFilter(F)Landroid/graphics/BlurMaskFilter;", 0);
    }

    @Nullable
    public final BlurMaskFilter invoke(float r10) {
        return ((OProtocolTextEffectTextView) this.receiver).u(r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BlurMaskFilter invoke(Float r10) {
        return invoke(r10.floatValue());
    }
}
