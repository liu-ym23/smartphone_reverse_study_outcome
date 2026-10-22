package com.stepos.agentframework.adapter.agentbus.bff;

import Ka.t;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.protobuf.d;
import com.stepos.agentframework.protobuf.e;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u000b\u001aE\u0010\b\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\f\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "packageName", "sessionId", "requestId", "decision", "reason", "askUserQuestion", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[B", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "messageId", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "delta", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {
    public static final byte[] b(String str, String sessionId, String requestId, String decision, String reason, String str2) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(decision, "decision");
        kotlin.jvm.internal.p.i(reason, "reason");
        e.a aVarG = com.stepos.agentframework.protobuf.e.g();
        if (str == null) {
            str = "";
        }
        com.stepos.agentframework.protobuf.e eVarBuild = aVarG.a("packageName", str).f("agentproxy").d(AgentProxyCommand.COMMAND_CHAT_APPROVAL.getValue()).build();
        d.a aVarA = com.stepos.agentframework.protobuf.d.d().a("session_id", sessionId).a("request_id", requestId).a("decision", decision).a("reason", reason);
        if (str2 != null) {
            if (H.x0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                aVarA.a("ask_user_question", str2);
            }
        }
        byte[] byteArray = com.stepos.agentframework.protobuf.g.e().d(eVarBuild).a(aVarA.build().toByteString()).build().toByteArray();
        kotlin.jvm.internal.p.h(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final String c(String content, String delta) {
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(delta, "delta");
        String string = H.D1(content).toString();
        return string.length() == 0 ? H.D1(delta).toString() : string;
    }

    public static final String d(String str, String str2, String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        return (String) SequencesKt___SequencesKt.J(SequencesKt___SequencesKt.S(t.w(str, str2, requestId), new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.bff.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.e((String) obj);
            }
        }));
    }

    public static final String e(String str) {
        String string;
        if (str == null || (string = H.D1(str).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }
}
