package com.obric.aiagent.product.platform.api.memory;

import aiassistant.memorydata.MemoryManagerProxy;
import android.os.Bundle;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricSystemEventCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricSystemEventCallback {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    /* JADX INFO: renamed from: lambda$-0bjj_vq_CuMbd31ps26sk4ldU4, reason: not valid java name */
    public static /* synthetic */ MemoryManagerProxy.SystemEventCallbackWrapper m217lambda$0bjj_vq_CuMbd31ps26sk4ldU4(ObricSystemEventCallback r0) {
        return assistantStub_delegate$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$2WvTJ4fgum6QAM6OHPNYT-g7j7A, reason: not valid java name */
    public static /* synthetic */ obric.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper m218lambda$2WvTJ4fgum6QAM6OHPNYTg7j7A(ObricSystemEventCallback r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$B3Hd88zS21CQdWumPYDPEhltI_Y(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        obricStub_delegate$lambda$1$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$bUrXWi1MCpQpds3MjIwgl2v_K5Y(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        assistantStub_delegate$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public abstract void onEvent(int r1, int r2, Bundle r3);

    public ObricSystemEventCallback() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricSystemEventCallback$2WvTJ4fgum6QAM6OHPNYTg7j7A(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricSystemEventCallback$0bjj_vq_CuMbd31ps26sk4ldU4(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    private static final obric.memorydata.MemoryManagerProxy.SystemEventCallbackWrapper obricStub_delegate$lambda$1(final ObricSystemEventCallback r1) {
        return new $$Lambda$ObricSystemEventCallback$B3Hd88zS21CQdWumPYDPEhltI_Y(r1);
    }

    private static final void obricStub_delegate$lambda$1$lambda$0(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        r0.onEvent(r1, r2, r3);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    private static final MemoryManagerProxy.SystemEventCallbackWrapper assistantStub_delegate$lambda$3(final ObricSystemEventCallback r1) {
        return new $$Lambda$ObricSystemEventCallback$bUrXWi1MCpQpds3MjIwgl2v_K5Y(r1);
    }

    private static final void assistantStub_delegate$lambda$3$lambda$2(ObricSystemEventCallback r0, int r1, int r2, Bundle r3) {
        r0.onEvent(r1, r2, r3);
    }
}
