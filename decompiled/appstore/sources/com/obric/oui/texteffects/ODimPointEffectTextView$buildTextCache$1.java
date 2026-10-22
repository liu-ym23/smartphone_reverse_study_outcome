package com.obric.oui.texteffects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ODimPointEffectTextView$buildTextCache$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    public ODimPointEffectTextView$buildTextCache$1(Object r10) {
        super(1, r10, ODimPointEffectTextView.class, "computeStartX", "computeStartX(F)F", 0);
    }

    @NotNull
    public final Float invoke(float r10) {
        return Float.valueOf(((ODimPointEffectTextView) this.receiver).k(r10));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Float invoke(Float r10) {
        return invoke(r10.floatValue());
    }
}
