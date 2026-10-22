package com.stepos.core.model.bridge;

import kotlin.jvm.internal.g;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeChatBridge {
    public static final NativeChatBridge INSTANCE = new NativeChatBridge();
    private static a<Boolean> delegate;

    private NativeChatBridge() {
    }

    public final void register(a<Boolean> resetChat) {
        g.f(resetChat, "resetChat");
        delegate = resetChat;
    }

    public final boolean resetChat() {
        a<Boolean> aVar = delegate;
        if (aVar != null) {
            return aVar.invoke().booleanValue();
        }
        return false;
    }
}
