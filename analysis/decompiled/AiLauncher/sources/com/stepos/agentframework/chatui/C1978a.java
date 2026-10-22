package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatui/a;", "Lcom/stepos/agentframework/chatui/r1;", "Lcom/stepos/agentframework/chatui/N1;", "target", "<init>", "(Lcom/stepos/agentframework/chatui/N1;)V", "", Const.INTENT_KEY_APIKEY, "()I", "Lcom/stepos/agentframework/chatui/N1;", "c", "()Lcom/stepos/agentframework/chatui/N1;", Const.INTENT_KEY_UMID, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1978a extends AbstractC2044r1 {
    private DisplayMessage target;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1978a(DisplayMessage target) {
        super(0, 1, null);
        kotlin.jvm.internal.p.i(target, "target");
        this.target = target;
    }

    @Override // com.stepos.agentframework.chatui.S1
    public int a() {
        return 4;
    }

    /* renamed from: c, reason: from getter */
    public final DisplayMessage getTarget() {
        return this.target;
    }

    public final void d(DisplayMessage displayMessage) {
        kotlin.jvm.internal.p.i(displayMessage, "<set-?>");
        this.target = displayMessage;
    }
}
