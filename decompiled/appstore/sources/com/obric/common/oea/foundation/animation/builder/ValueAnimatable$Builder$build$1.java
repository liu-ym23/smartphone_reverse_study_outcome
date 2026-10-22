package com.obric.common.oea.foundation.animation.builder;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    public ValueAnimatable$Builder$build$1(d.a r10) {
        super(r10, d.a.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        return d.a.a((d.a) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object r10) {
        d.a.b((d.a) this.receiver, (ib.a) r10);
    }
}
