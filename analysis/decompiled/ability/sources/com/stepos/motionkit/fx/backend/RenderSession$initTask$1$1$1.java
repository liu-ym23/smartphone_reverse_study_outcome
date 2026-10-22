package com.stepos.motionkit.fx.backend;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class RenderSession$initTask$1$1$1 extends FunctionReferenceImpl implements S7.a {
    public RenderSession$initTask$1$1$1(Object obj) {
        super(0, obj, AtomicBoolean.class, "get", "get()Z", 0);
    }

    @Override // S7.a
    public final Boolean invoke() {
        return Boolean.valueOf(((AtomicBoolean) this.receiver).get());
    }
}
