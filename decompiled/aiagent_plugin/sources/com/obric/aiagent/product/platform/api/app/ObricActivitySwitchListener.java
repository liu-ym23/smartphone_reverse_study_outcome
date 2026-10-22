package com.obric.aiagent.product.platform.api.app;

import android.content.ComponentName;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricActivitySwitchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricActivitySwitchListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    /* JADX INFO: renamed from: lambda$SEHcgD3SB4FBl-hSKmodz2wpGsM, reason: not valid java name */
    public static /* synthetic */ ObricActivitySwitchListener$assistantStub$2$1 m205lambda$SEHcgD3SB4FBlhSKmodz2wpGsM(ObricActivitySwitchListener r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$V0pZzuj4-9uccAr5hWtdzjKDVd8, reason: not valid java name */
    public static /* synthetic */ ObricActivitySwitchListener$obricStub$2$1 m206lambda$V0pZzuj49uccAr5hWtdzjKDVd8(ObricActivitySwitchListener r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public abstract void onActivityBackground(ComponentName r1);

    public abstract void onActivityForeground(ComponentName r1);

    public ObricActivitySwitchListener() {
        this.assistantStub$delegate = g.a(new $$Lambda$ObricActivitySwitchListener$SEHcgD3SB4FBlhSKmodz2wpGsM(this));
        this.obricStub$delegate = g.a(new $$Lambda$ObricActivitySwitchListener$V0pZzuj49uccAr5hWtdzjKDVd8(this));
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener$assistantStub$2$1] */
    private static final ObricActivitySwitchListener$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricActivitySwitchListener r1) {
        return new ObricActivitySwitchListener$assistantStub$2$1(r1);
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener$obricStub$2$1] */
    private static final ObricActivitySwitchListener$obricStub$2$1 obricStub_delegate$lambda$1(final ObricActivitySwitchListener r1) {
        return new ObricActivitySwitchListener$obricStub$2$1(r1);
    }
}
