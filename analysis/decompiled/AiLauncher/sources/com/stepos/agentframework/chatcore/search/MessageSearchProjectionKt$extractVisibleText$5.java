package com.stepos.agentframework.chatcore.search;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class MessageSearchProjectionKt$extractVisibleText$5 extends FunctionReferenceImpl implements InterfaceC5074l<String, String> {
    public static final MessageSearchProjectionKt$extractVisibleText$5 INSTANCE = new MessageSearchProjectionKt$extractVisibleText$5();

    public MessageSearchProjectionKt$extractVisibleText$5() {
        super(1, MessageSearchProjectionKt.class, "normalizeVisibleText", "normalizeVisibleText(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // p9.InterfaceC5074l
    public final String invoke(String p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return MessageSearchProjectionKt.n(p02);
    }
}
