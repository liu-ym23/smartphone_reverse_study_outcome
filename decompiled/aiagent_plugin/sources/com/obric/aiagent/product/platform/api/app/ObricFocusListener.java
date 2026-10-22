package com.obric.aiagent.product.platform.api.app;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricFocusListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricFocusListener {
    private final f obricStub$delegate;

    public static /* synthetic */ ObricFocusListener$obricStub$2$1 lambda$3kXRE6_lQyxEfmaz33nGI__ArJo(ObricFocusListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    public abstract void onFocusForeground(String r1, int r2);

    public abstract void onFreeformEntered(String r1);

    public abstract void onFreeformExited(String r1);

    public ObricFocusListener() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricFocusListener$3kXRE6_lQyxEfmaz33nGI__ArJo(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricFocusListener$obricStub$2$1] */
    private static final ObricFocusListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricFocusListener r1) {
        return new ObricFocusListener$obricStub$2$1(r1);
    }
}
