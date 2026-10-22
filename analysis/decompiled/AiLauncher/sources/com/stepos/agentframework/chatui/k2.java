package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ReconnectReason;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatui/k2;", "Lcom/stepos/agentframework/chatui/r1;", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "reason", "<init>", "(Lcom/stepos/agentframework/chatcore/session/ReconnectReason;)V", "", Const.INTENT_KEY_APIKEY, "()I", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "c", "()Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class k2 extends AbstractC2044r1 {
    public static final String ID = "reconnect_prompt_placeholder";
    private final ReconnectReason reason;

    /* JADX WARN: Multi-variable type inference failed */
    public k2() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.stepos.agentframework.chatui.S1
    public int a() {
        return 7;
    }

    /* renamed from: c, reason: from getter */
    public final ReconnectReason getReason() {
        return this.reason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k2(ReconnectReason reason) {
        super(0, 1, null);
        kotlin.jvm.internal.p.i(reason, "reason");
        this.reason = reason;
    }

    public /* synthetic */ k2(ReconnectReason reconnectReason, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? ReconnectReason.NETWORK_FAILED : reconnectReason);
    }
}
