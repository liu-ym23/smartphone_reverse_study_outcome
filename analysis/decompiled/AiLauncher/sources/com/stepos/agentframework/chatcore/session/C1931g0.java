package com.stepos.agentframework.chatcore.session;

import La.C0951a;
import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/g0;", "", "<init>", "()V", "Lw4/c;", "message", "", "name", "resultJson", "", "c", "(Lw4/c;Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "CARD_TOOL_PREFIX", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.g0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1931g0 {
    private static final String CARD_TOOL_PREFIX = "card:";
    public static final C1931g0 INSTANCE = new C1931g0();
    private static final String TAG = "LateCardToolMerge";

    public static final Ka.j d(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<AgentTool> listG = it.g();
        if (listG == null) {
            listG = C1173v.m();
        }
        return Z8.F.d0(listG);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r2 = "structuredContent"
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2f
            com.google.gson.JsonElement r3 = com.google.gson.JsonParser.parseString(r3)     // Catch: java.lang.Throwable -> L2f
            boolean r1 = r3.isJsonObject()     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L10
            goto L11
        L10:
            r3 = r0
        L11:
            if (r3 == 0) goto L2d
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L1a
            goto L2d
        L1a:
            boolean r1 = r3.has(r2)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L22
            r1 = r3
            goto L23
        L22:
            r1 = r0
        L23:
            if (r1 != 0) goto L31
            java.lang.String r1 = "result"
            com.google.gson.JsonObject r1 = r3.getAsJsonObject(r1)     // Catch: java.lang.Throwable -> L2f
            if (r1 != 0) goto L31
        L2d:
            r2 = r0
            goto L55
        L2f:
            r2 = move-exception
            goto L5a
        L31:
            com.google.gson.JsonObject r2 = r1.getAsJsonObject(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2d
            java.lang.String r3 = "taskId"
            com.google.gson.JsonElement r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2d
            java.lang.String r2 = r2.getAsString()     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2d
            java.lang.CharSequence r2 = La.H.D1(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2d
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L2f
            if (r3 <= 0) goto L2d
        L55:
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L2f
            goto L64
        L5a:
            kotlin.Result$a r3 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.C4849c.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L64:
            boolean r3 = kotlin.Result.g(r2)
            if (r3 == 0) goto L6b
            goto L6c
        L6b:
            r0 = r2
        L6c:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.C1931g0.b(java.lang.String):java.lang.String");
    }

    public final boolean c(ChatMessage message, String name, String resultJson) {
        String string;
        Object next;
        AgentMessage agentMessagePrevious;
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(resultJson, "resultJson");
        if (La.H.x0(name) || La.H.x0(resultJson)) {
            return false;
        }
        String strB = b(resultJson);
        if (strB == null) {
            C4148a.u(TAG, "card envelope has no structuredContent.taskId, fall back to content hash name=" + name, false, 4, null);
        }
        if (strB == null) {
            string = Integer.toString(resultJson.hashCode(), C0951a.a(16));
            kotlin.jvm.internal.p.h(string, "toString(...)");
        } else {
            string = strB;
        }
        String str = CARD_TOOL_PREFIX + message.getMessageId() + ServerSentEventKt.COLON + string;
        Iterator it = SequencesKt___SequencesKt.L(Z8.F.d0(message.i()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.f0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C1931g0.d((AgentMessage) obj);
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((AgentTool) next).getToolCallId(), str)) {
                break;
            }
        }
        AgentTool agentTool = (AgentTool) next;
        if (agentTool != null) {
            if (kotlin.jvm.internal.p.d(agentTool.getResult(), resultJson)) {
                return false;
            }
            C4148a.k(TAG, "override card tool name=" + name + " taskId=" + strB + " toolCallId=" + str, false, 4, null);
            agentTool.K(resultJson);
            agentTool.A(true);
            agentTool.x(null);
            return true;
        }
        AgentTool agentTool2 = new AgentTool(str, null, name, null, null, null, null, true, null, resultJson, null, null, null, 0, false, null, 0, 0L, false, 507258, null);
        List<AgentMessage> listI = message.i();
        ListIterator<AgentMessage> listIterator = listI.listIterator(listI.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                agentMessagePrevious = null;
                break;
            }
            agentMessagePrevious = listIterator.previous();
            if (agentMessagePrevious.getType() == AgentMessageType.TOOL) {
                break;
            }
        }
        AgentMessage agentMessage = agentMessagePrevious;
        if (agentMessage != null) {
            List<AgentTool> listG = agentMessage.g();
            if (listG == null) {
                listG = C1173v.m();
            }
            agentMessage.l(Z8.F.T0(listG, agentTool2));
        } else {
            message.i().add(new AgentMessage(AgentMessageType.TOOL, null, null, C1172u.e(agentTool2), false, false, 54, null));
        }
        C4148a.k(TAG, "append card tool name=" + name + " taskId=" + strB + " messageId=" + message.getMessageId() + " toolCallId=" + str, false, 4, null);
        return true;
    }
}
