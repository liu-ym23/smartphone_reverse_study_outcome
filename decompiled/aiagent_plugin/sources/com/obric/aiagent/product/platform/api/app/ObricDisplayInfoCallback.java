package com.obric.aiagent.product.platform.api.app;

import d.f;
import d.g;

/* JADX INFO: compiled from: ObricDisplayInfoCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricDisplayInfoCallback {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    public static /* synthetic */ ObricDisplayInfoCallback$assistantStub$2$1 lambda$7SUUbnd7WUt8dY_DXgm1CGhBYGE(ObricDisplayInfoCallback r0) {
        return assistantStub_delegate$lambda$0(r0);
    }

    public static /* synthetic */ ObricDisplayInfoCallback$obricStub$2$1 lambda$Vgx9YT3iOXhqwRvoe7PBDJxaczo(ObricDisplayInfoCallback r0) {
        return obricStub_delegate$lambda$1(r0);
    }

    public abstract void onDisplaySecureChanged(int r1, boolean r2);

    public ObricDisplayInfoCallback() {
        this.assistantStub$delegate = g.a(new $$Lambda$ObricDisplayInfoCallback$7SUUbnd7WUt8dY_DXgm1CGhBYGE(this));
        this.obricStub$delegate = g.a(new $$Lambda$ObricDisplayInfoCallback$Vgx9YT3iOXhqwRvoe7PBDJxaczo(this));
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback$assistantStub$2$1] */
    private static final ObricDisplayInfoCallback$assistantStub$2$1 assistantStub_delegate$lambda$0(final ObricDisplayInfoCallback r1) {
        return new ObricDisplayInfoCallback$assistantStub$2$1(r1);
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback$obricStub$2$1] */
    private static final ObricDisplayInfoCallback$obricStub$2$1 obricStub_delegate$lambda$1(final ObricDisplayInfoCallback r1) {
        return new ObricDisplayInfoCallback$obricStub$2$1(r1);
    }
}
