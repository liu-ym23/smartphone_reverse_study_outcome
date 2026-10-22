package com.obric.aiagent.product.platform.api.app;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricAppSwitchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricAppSwitchListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    /* JADX INFO: renamed from: lambda$0nrJN_9PXI-Mmt-bvKC9ICX5ZKE, reason: not valid java name */
    public static /* synthetic */ ObricAppSwitchListener$assistantStub$2$1 m207lambda$0nrJN_9PXIMmtbvKC9ICX5ZKE(ObricAppSwitchListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    public static /* synthetic */ ObricAppSwitchListener$obricStub$2$1 lambda$ctN09jmleUQa989I5SQVYXYjOzA(ObricAppSwitchListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public abstract void onAppBackground(String r1);

    public abstract void onAppForeground(String r1);

    public ObricAppSwitchListener() {
        this.assistantStub$delegate = g.a(new $$Lambda$ObricAppSwitchListener$0nrJN_9PXIMmtbvKC9ICX5ZKE(this));
        this.obricStub$delegate = g.a(new $$Lambda$ObricAppSwitchListener$ctN09jmleUQa989I5SQVYXYjOzA(this));
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener$assistantStub$2$1] */
    private static final ObricAppSwitchListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricAppSwitchListener r1) {
        return new ObricAppSwitchListener$assistantStub$2$1(r1);
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener$obricStub$2$1] */
    private static final ObricAppSwitchListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricAppSwitchListener r1) {
        return new ObricAppSwitchListener$obricStub$2$1(r1);
    }
}
