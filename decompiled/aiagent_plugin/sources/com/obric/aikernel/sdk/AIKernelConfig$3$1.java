package com.obric.aikernel.sdk;

import d.h.a.a;
import d.h.b.p;

/* JADX INFO: compiled from: AIKernelConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AIKernelConfig$3$1 extends p implements a<Integer> {
    final /* synthetic */ AIKernelConfig this$0;

    AIKernelConfig$3$1(AIKernelConfig r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.h.a.a
    public final Integer invoke() {
        return Integer.valueOf(AIKernelConfig.access$getStaticLlmMode$p(this.this$0));
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
