package com.stepos.agentframework.adapter.agentbus;

import Z8.C1173v;
import a4.Message;
import a4.ToolCall;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.ToolStatus;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.Map;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"La4/w;", "", "max", "", Const.INTENT_KEY_UMID, "(La4/w;I)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(La4/w;)I", "c", "(La4/w;)Ljava/lang/String;", "TOOLS_MAX_ENTRIES", "I", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1835k {
    private static final int TOOLS_MAX_ENTRIES = 32;

    public static final int b(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        int iHashCode = message.getRole().hashCode() * 31;
        String replyTo = message.getReplyTo();
        int iHashCode2 = (iHashCode + (replyTo != null ? replyTo.hashCode() : 0)) * 31;
        Object obj = message.d().get(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID);
        int iHashCode3 = (iHashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = message.d().get("streaming");
        int iHashCode4 = ((((iHashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31) + message.a().size()) * 31) + message.g().size();
        for (ToolCall toolCall : message.g()) {
            iHashCode4 = (((iHashCode4 * 31) + toolCall.getName().hashCode()) * 31) + toolCall.getStatus().hashCode();
        }
        return iHashCode4;
    }

    public static final String c(Message message) {
        kotlin.jvm.internal.p.i(message, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("role=");
        sb2.append(message.getRole());
        sb2.append(" replyTo=");
        sb2.append(message.getReplyTo());
        sb2.append(" terminal=");
        sb2.append(AgentBusChannelOpsKt.v(message));
        sb2.append(" contentLen=");
        sb2.append(message.getContent().length());
        sb2.append(" metadata=");
        sb2.append(message.d());
        sb2.append(" content=");
        sb2.append(message.getContent());
        sb2.append(" delta=");
        sb2.append(message.getDelta());
        sb2.append(" attachments=");
        sb2.append(message.a());
        sb2.append(" toolCalls(");
        sb2.append(message.g().size());
        sb2.append(")=[");
        int i10 = 0;
        for (Object obj : message.g()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ToolCall toolCall = (ToolCall) obj;
            if (i10 > 0) {
                sb2.append(" | ");
            }
            sb2.append("id=");
            sb2.append(toolCall.getId());
            sb2.append(" name=");
            sb2.append(toolCall.getName());
            sb2.append(" status=");
            sb2.append(toolCall.getStatus());
            sb2.append(" arguments=");
            sb2.append(toolCall.a());
            sb2.append(" result=");
            sb2.append(toolCall.f());
            sb2.append(" update=");
            sb2.append(toolCall.h());
            sb2.append(" errorCode=");
            sb2.append(toolCall.getErrorCode());
            sb2.append(" errorMessage=");
            sb2.append(toolCall.getErrorMessage());
            i10 = i11;
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static final String d(Message message, int i10) {
        kotlin.jvm.internal.p.i(message, "<this>");
        if (message.g().isEmpty()) {
            return "";
        }
        String strO = SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.Z(Z8.F.d0(message.g()), i10), Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1835k.f((ToolCall) obj);
            }
        }, 30, null);
        int size = message.g().size() - i10;
        if (size <= 0) {
            return strO;
        }
        return strO + ",…<+" + size + ">";
    }

    public static /* synthetic */ String e(Message message, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 32;
        }
        return d(message, i10);
    }

    public static final CharSequence f(ToolCall tc2) {
        kotlin.jvm.internal.p.i(tc2, "tc");
        String name = tc2.getName();
        ToolStatus status = tc2.getStatus();
        Map<String, Object> mapF = tc2.f();
        return name + "(" + status + ",result=" + (mapF != null ? mapF.size() : 0) + "field)";
    }
}
