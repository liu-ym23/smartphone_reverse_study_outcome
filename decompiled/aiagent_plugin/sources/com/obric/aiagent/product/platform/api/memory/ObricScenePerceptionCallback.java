package com.obric.aiagent.product.platform.api.memory;

import android.os.Bundle;
import d.f;
import d.g;
import d.h.b.o;
import d.x;
import obric.memorydata.MemoryManagerProxy;

/* JADX INFO: compiled from: ObricScenePerceptionCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricScenePerceptionCallback {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    public static /* synthetic */ x lambda$1HxbeJpJsFyNvrlPuY7kYyxHt8c(ObricScenePerceptionCallback r0, int r1, Bundle r2) {
        return assistantStub_delegate$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ MemoryManagerProxy.ScenePerceptionCallbackWrapper lambda$BNOFhdaNHrYQ7lwS7pXNLDLHWOo(ObricScenePerceptionCallback r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$SuanS2EzGzbu2tAvUF6jbDL-2mU, reason: not valid java name */
    public static /* synthetic */ void m215lambda$SuanS2EzGzbu2tAvUF6jbDL2mU(ObricScenePerceptionCallback r0, int r1, Bundle r2) {
        obricStub_delegate$lambda$1$lambda$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$fqNhS5SO9wyGQa5E6dl8CgKe-Gk, reason: not valid java name */
    public static /* synthetic */ Object m216lambda$fqNhS5SO9wyGQa5E6dl8CgKeGk(ObricScenePerceptionCallback r0) {
        return assistantStub_delegate$lambda$3(r0);
    }

    public abstract void onAction(int r1, Bundle r2);

    public ObricScenePerceptionCallback() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricScenePerceptionCallback$BNOFhdaNHrYQ7lwS7pXNLDLHWOo(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricScenePerceptionCallback$fqNhS5SO9wyGQa5E6dl8CgKeGk(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    private static final MemoryManagerProxy.ScenePerceptionCallbackWrapper obricStub_delegate$lambda$1(final ObricScenePerceptionCallback r1) {
        return new $$Lambda$ObricScenePerceptionCallback$SuanS2EzGzbu2tAvUF6jbDL2mU(r1);
    }

    private static final void obricStub_delegate$lambda$1$lambda$0(ObricScenePerceptionCallback r0, int r1, Bundle r2) {
        o.a(r2);
        r0.onAction(r1, r2);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    private static final Object assistantStub_delegate$lambda$3(final ObricScenePerceptionCallback r1) {
        return ObricScenePerceptionCallbackKt.access$newScenePerceptionCallbackWrapperProxy("aiassistant.memorydata.MemoryManagerProxy$ScenePerceptionCallbackWrapper", new $$Lambda$ObricScenePerceptionCallback$1HxbeJpJsFyNvrlPuY7kYyxHt8c(r1));
    }

    private static final x assistantStub_delegate$lambda$3$lambda$2(ObricScenePerceptionCallback r1, int r2, Bundle r3) {
        o.e(r3, "p1");
        r1.onAction(r2, r3);
        return x.f38692a;
    }
}
