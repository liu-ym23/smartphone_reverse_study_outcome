package com.obric.aiagent.product.platform.api.app;

import android.app.IObricSystemAnimationListener;
import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricSystemAnimationListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricSystemAnimationListener {
    private final f obricStub$delegate;

    public static /* synthetic */ ObricSystemAnimationListener$obricStub$2$1 lambda$SubPtnH5laTN8OWlkW9rDTMWdqA(ObricSystemAnimationListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    public abstract void onSystemAnimationStateChanged(int r1, boolean r2, int r3, int r4, ComponentName r5, ComponentName[] r6, int[] r7);

    public ObricSystemAnimationListener() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricSystemAnimationListener$SubPtnH5laTN8OWlkW9rDTMWdqA(this));
    }

    public final IObricSystemAnimationListener getObricStub() {
        return (IObricSystemAnimationListener) ZeusTransformUtils.preCheckCast(this.obricStub$delegate.b(), IObricSystemAnimationListener.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricSystemAnimationListener$obricStub$2$1] */
    private static final ObricSystemAnimationListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricSystemAnimationListener r1) {
        return new ObricSystemAnimationListener$obricStub$2$1(r1);
    }
}
