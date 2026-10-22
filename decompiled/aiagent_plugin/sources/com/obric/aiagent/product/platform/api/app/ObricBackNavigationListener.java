package com.obric.aiagent.product.platform.api.app;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricBackNavigationListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricBackNavigationListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    public static /* synthetic */ ObricBackNavigationListener$obricStub$2$1 lambda$3VZCsXK9Q7u0kcGLleZ7PWWK260(ObricBackNavigationListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ObricBackNavigationListener$assistantStub$2$1 lambda$bOiHnMioIU4eKFEd9tvMbvCVqwA(ObricBackNavigationListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    public void onBackNavigationDone() {
    }

    public void onBackNavigationStarted() {
    }

    public ObricBackNavigationListener() {
        this.assistantStub$delegate = g.a(new $$Lambda$ObricBackNavigationListener$bOiHnMioIU4eKFEd9tvMbvCVqwA(this));
        this.obricStub$delegate = g.a(new $$Lambda$ObricBackNavigationListener$3VZCsXK9Q7u0kcGLleZ7PWWK260(this));
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener$assistantStub$2$1] */
    private static final ObricBackNavigationListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricBackNavigationListener r1) {
        return new ObricBackNavigationListener$assistantStub$2$1(r1);
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener$obricStub$2$1] */
    private static final ObricBackNavigationListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricBackNavigationListener r1) {
        return new ObricBackNavigationListener$obricStub$2$1(r1);
    }
}
