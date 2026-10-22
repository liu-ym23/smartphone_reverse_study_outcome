package com.obric.aiagent.product.platform.api.inputmethod;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricInputMethodListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricInputMethodListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    /* JADX INFO: renamed from: lambda$PM5KbFVW-SDI4xW-WCoQWCeoWOo, reason: not valid java name */
    public static /* synthetic */ ObricInputMethodListener$assistantStub$2$1 m210lambda$PM5KbFVWSDI4xWWCoQWCeoWOo(ObricInputMethodListener r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ObricInputMethodListener$obricStub$2$1 lambda$sY0MbhSyqYJJCij7jppEAcMEpzo(ObricInputMethodListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    public abstract void onInputMethodHidden();

    public abstract void onInputMethodShown();

    public ObricInputMethodListener() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricInputMethodListener$sY0MbhSyqYJJCij7jppEAcMEpzo(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricInputMethodListener$PM5KbFVWSDI4xWWCoQWCeoWOo(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener$obricStub$2$1] */
    private static final ObricInputMethodListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricInputMethodListener r1) {
        return new ObricInputMethodListener$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener$assistantStub$2$1] */
    private static final ObricInputMethodListener$assistantStub$2$1 assistantStub_delegate$lambda$1(final ObricInputMethodListener r1) {
        return new ObricInputMethodListener$assistantStub$2$1(r1);
    }
}
