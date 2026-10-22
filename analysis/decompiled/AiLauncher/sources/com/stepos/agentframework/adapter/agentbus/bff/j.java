package com.stepos.agentframework.adapter.agentbus.bff;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/protobuf/g;", "", "c", "(Lcom/stepos/agentframework/protobuf/g;)Z", Const.INTENT_KEY_APIKEY, "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {
    public static final boolean a(com.stepos.agentframework.protobuf.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        String command = gVar.d().getCommand();
        if (command == null || H.x0(command)) {
            return false;
        }
        return kotlin.jvm.internal.p.d(command, AgentProxyCommand.COMMAND_CHAT.getValue()) || kotlin.jvm.internal.p.d(command, AgentProxyCommand.COMMAND_CHAT_APPROVAL.getValue()) || kotlin.jvm.internal.p.d(command, AgentProxyCommand.COMMAND_CHAT_CANCEL.getValue());
    }

    public static final boolean b(String str) {
        return ExternalAgent.INSTANCE.b(str) != null;
    }

    public static final boolean c(com.stepos.agentframework.protobuf.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        String command = gVar.d().getCommand();
        if (command == null || H.x0(command)) {
            return false;
        }
        return kotlin.jvm.internal.p.d(command, AgentProxyCommand.COMMAND_RECEIVE.getValue());
    }
}
