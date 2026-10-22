package p4;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lp4/a;", "", "sessionId", "agentId", "Lw4/c;", Const.INTENT_KEY_APIKEY, "(Lp4/a;Ljava/lang/String;Ljava/lang/String;)Lw4/c;", "", "NON_DIALOG_ROLES", "Ljava/util/Set;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    private static final Set<String> NON_DIALOG_ROLES = Y.j("system", "tool", "toolcall", "tool_call", "toolresult", "tool_result", "function", "function_call");

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final w4.ChatMessage a(p4.AgentRemoteChatMessage r29, java.lang.String r30, java.lang.String r31) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r29
            kotlin.jvm.internal.p.i(r1, r0)
            java.lang.String r0 = "sessionId"
            r4 = r30
            kotlin.jvm.internal.p.i(r4, r0)
            java.lang.String r0 = "agentId"
            r5 = r31
            kotlin.jvm.internal.p.i(r5, r0)
            java.lang.String r0 = r1.getId()
            int r0 = r0.length()
            r2 = 0
            if (r0 != 0) goto L21
            return r2
        L21:
            java.lang.String r0 = r1.getRole()
            if (r0 == 0) goto L3d
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r0, r3)
            if (r0 == 0) goto L3d
            java.lang.CharSequence r0 = La.H.D1(r0)
            java.lang.String r0 = r0.toString()
            goto L3e
        L3d:
            r0 = r2
        L3e:
            java.lang.String r28 = ""
            if (r0 != 0) goto L44
            r0 = r28
        L44:
            int r3 = r0.length()
            if (r3 != 0) goto L4b
            goto L53
        L4b:
            java.util.Set<java.lang.String> r3 = p4.b.NON_DIALOG_ROLES
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L54
        L53:
            return r2
        L54:
            java.lang.String r3 = "user"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r3)
            if (r0 == 0) goto L60
            com.stepos.agentframework.chatcore.session.AgentRole r0 = com.stepos.agentframework.chatcore.session.AgentRole.USER
        L5e:
            r8 = r0
            goto L63
        L60:
            com.stepos.agentframework.chatcore.session.AgentRole r0 = com.stepos.agentframework.chatcore.session.AgentRole.ASSISTANT
            goto L5e
        L63:
            java.lang.String r3 = r1.getId()
            java.lang.Long r0 = r1.getTime()
            r6 = 0
            if (r0 == 0) goto L7f
            long r9 = r0.longValue()
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 <= 0) goto L78
            goto L79
        L78:
            r0 = r2
        L79:
            if (r0 == 0) goto L7f
            long r6 = r0.longValue()
        L7f:
            java.lang.String r13 = r1.getId()
            com.stepos.agentframework.chatcore.session.EReplyStatus r15 = com.stepos.agentframework.chatcore.session.EReplyStatus.COMPLETED
            r0 = r2
            w4.c r2 = new w4.c
            java.lang.String r9 = ""
            r10 = 0
            r11 = 0
            java.lang.String r12 = ""
            java.lang.String r14 = ""
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 4190208(0x3ff000, float:5.871732E-39)
            r27 = 0
            r2.<init>(r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            u4.a r3 = new u4.a
            com.stepos.agentframework.chatcore.session.AgentMessageType r4 = com.stepos.agentframework.chatcore.session.AgentMessageType.TEXT
            u4.m$h r6 = new u4.m$h
            O6.f r5 = O6.f.INSTANCE
            java.lang.String r1 = r1.getContent()
            if (r1 != 0) goto Lbc
            r1 = r28
        Lbc:
            java.lang.String r1 = r5.b(r1)
            r5 = 2
            r6.<init>(r1, r0, r5, r0)
            r10 = 58
            r11 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            u4.a[] r0 = new u4.AgentMessage[]{r3}
            java.util.ArrayList r0 = Z8.C1173v.h(r0)
            r2.L(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.b.a(p4.a, java.lang.String, java.lang.String):w4.c");
    }
}
