package com.obric.aiagent.product.platform.api.notification;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricNotificationListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricNotificationListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    public static /* synthetic */ ObricNotificationListener$obricStub$2$1 lambda$dRqg68pKcJtT13NGiprPUZhpFCo(ObricNotificationListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$jnsutbr1QyceU2H39JvFA-wQ0YA, reason: not valid java name */
    public static /* synthetic */ ObricNotificationListener$assistantStub$2$1 m219lambda$jnsutbr1QyceU2H39JvFAwQ0YA(ObricNotificationListener r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    public abstract void onPanelHidden();

    public abstract void onPanelShown();

    public ObricNotificationListener() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricNotificationListener$dRqg68pKcJtT13NGiprPUZhpFCo(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricNotificationListener$jnsutbr1QyceU2H39JvFAwQ0YA(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.notification.ObricNotificationListener$obricStub$2$1] */
    private static final ObricNotificationListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricNotificationListener r1) {
        return new ObricNotificationListener$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.notification.ObricNotificationListener$assistantStub$2$1] */
    private static final ObricNotificationListener$assistantStub$2$1 assistantStub_delegate$lambda$1(final ObricNotificationListener r1) {
        return new ObricNotificationListener$assistantStub$2$1(r1);
    }
}
