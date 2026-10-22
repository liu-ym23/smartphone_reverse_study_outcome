package com.obric.aiagent.product.platform.api.view;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricWindowGestureListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricWindowGestureListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    public static /* synthetic */ ObricWindowGestureListener$obricStub$2$1 lambda$kmwktPYb1xXYc9rC0uls1SeaJbU(ObricWindowGestureListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$o9e-Ez7jbs6gf1wqn6oicC2UF10, reason: not valid java name */
    public static /* synthetic */ ObricWindowGestureListener$assistantStub$2$1 m225lambda$o9eEz7jbs6gf1wqn6oicC2UF10(ObricWindowGestureListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    public abstract void onHomeSwipeUp();

    public ObricWindowGestureListener() {
        this.assistantStub$delegate = g.a(new $$Lambda$ObricWindowGestureListener$o9eEz7jbs6gf1wqn6oicC2UF10(this));
        this.obricStub$delegate = g.a(new $$Lambda$ObricWindowGestureListener$kmwktPYb1xXYc9rC0uls1SeaJbU(this));
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener$assistantStub$2$1] */
    private static final ObricWindowGestureListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricWindowGestureListener r1) {
        return new ObricWindowGestureListener$assistantStub$2$1(r1);
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener$obricStub$2$1] */
    private static final ObricWindowGestureListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricWindowGestureListener r1) {
        return new ObricWindowGestureListener$obricStub$2$1(r1);
    }
}
