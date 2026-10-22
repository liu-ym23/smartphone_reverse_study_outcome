package com.obric.aiagent.product.platform.api.memory;

import android.os.Bundle;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricMemoryActionCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricMemoryActionCallback {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    /* JADX INFO: renamed from: lambda$XghXPFJsUCUng4I1nS-Sdt33bn8, reason: not valid java name */
    public static /* synthetic */ ObricMemoryActionCallback$assistantStub$2$1 m211lambda$XghXPFJsUCUng4I1nSSdt33bn8(ObricMemoryActionCallback r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ObricMemoryActionCallback$obricStub$2$1 lambda$bdywNjedrNvqFgvSwysQjWtk93c(ObricMemoryActionCallback r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    public abstract void onAction(int r1, Bundle r2);

    public ObricMemoryActionCallback() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricMemoryActionCallback$bdywNjedrNvqFgvSwysQjWtk93c(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricMemoryActionCallback$XghXPFJsUCUng4I1nSSdt33bn8(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback$obricStub$2$1] */
    private static final ObricMemoryActionCallback$obricStub$2$1 obricStub_delegate$lambda$0(final ObricMemoryActionCallback r1) {
        return new ObricMemoryActionCallback$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.memory.ObricMemoryActionCallback$assistantStub$2$1] */
    private static final ObricMemoryActionCallback$assistantStub$2$1 assistantStub_delegate$lambda$1(final ObricMemoryActionCallback r1) {
        return new ObricMemoryActionCallback$assistantStub$2$1(r1);
    }
}
