package com.stepos.agentframework.chatcore.audit;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.AgentModeration;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJA\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/m;", "", "<init>", "()V", "", "sessionId", "Lu4/c;", "moderation", "protocolMessageId", "Lcom/stepos/agentframework/chatcore/audit/m$a;", "c", "(Ljava/lang/String;Lu4/c;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/audit/m$a;", "kind", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "channelMessageId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/audit/m$a;", "prefix", "idempotencyKey", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m {
    public static final m INSTANCE = new m();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/m$a;", "", "", "kind", "targetId", "idempotencyKey", "", "usedProtocolFallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_UMID, "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.audit.m$a, reason: from toString */
    public static final /* data */ class Identity {
        private final String idempotencyKey;
        private final String kind;
        private final String targetId;
        private final boolean usedProtocolFallback;

        public Identity(String kind, String targetId, String idempotencyKey, boolean z10) {
            p.i(kind, "kind");
            p.i(targetId, "targetId");
            p.i(idempotencyKey, "idempotencyKey");
            this.kind = kind;
            this.targetId = targetId;
            this.idempotencyKey = idempotencyKey;
            this.usedProtocolFallback = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getIdempotencyKey() {
            return this.idempotencyKey;
        }

        /* renamed from: b, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        /* renamed from: c, reason: from getter */
        public final String getTargetId() {
            return this.targetId;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getUsedProtocolFallback() {
            return this.usedProtocolFallback;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Identity)) {
                return false;
            }
            Identity identity = (Identity) other;
            return p.d(this.kind, identity.kind) && p.d(this.targetId, identity.targetId) && p.d(this.idempotencyKey, identity.idempotencyKey) && this.usedProtocolFallback == identity.usedProtocolFallback;
        }

        public int hashCode() {
            return (((((this.kind.hashCode() * 31) + this.targetId.hashCode()) * 31) + this.idempotencyKey.hashCode()) * 31) + Boolean.hashCode(this.usedProtocolFallback);
        }

        public String toString() {
            return "Identity(kind=" + this.kind + ", targetId=" + this.targetId + ", idempotencyKey=" + this.idempotencyKey + ", usedProtocolFallback=" + this.usedProtocolFallback + ")";
        }
    }

    public static /* synthetic */ Identity d(m mVar, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            str5 = null;
        }
        return mVar.b(str, str2, str3, str4, str5);
    }

    public static /* synthetic */ Identity e(m mVar, String str, AgentModeration cVar, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return mVar.c(str, cVar, str2);
    }

    public final String a(String prefix, String idempotencyKey) {
        p.i(prefix, "prefix");
        if (idempotencyKey == null || idempotencyKey.length() == 0) {
            return prefix + UUID.randomUUID();
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        p.h(UTF_8, "UTF_8");
        byte[] bytes = idempotencyKey.getBytes(UTF_8);
        p.h(bytes, "getBytes(...)");
        return prefix + UUID.nameUUIDFromBytes(bytes);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatcore.audit.m.Identity b(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r9 = this;
            java.lang.String r9 = "sessionId"
            kotlin.jvm.internal.p.i(r10, r9)
            if (r11 != 0) goto L9
            java.lang.String r11 = ""
        L9:
            int r9 = r11.length()
            java.lang.String r0 = "run_blocked"
            if (r9 != 0) goto L12
            r11 = r0
        L12:
            int r9 = r11.hashCode()
            r1 = 0
            switch(r9) {
                case -955145163: goto L36;
                case -192401192: goto L2b;
                case 874022968: goto L24;
                case 1504213368: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L3f
        L1b:
            java.lang.String r9 = "user_blocked"
            boolean r9 = r11.equals(r9)
            if (r9 != 0) goto L34
            goto L3f
        L24:
            boolean r9 = r11.equals(r0)
            if (r9 != 0) goto L40
            goto L3f
        L2b:
            java.lang.String r9 = "user_revert"
            boolean r9 = r11.equals(r9)
            if (r9 != 0) goto L34
            goto L3f
        L34:
            r12 = r13
            goto L40
        L36:
            java.lang.String r9 = "privacy_blocked"
            boolean r9 = r11.equals(r9)
            if (r9 == 0) goto L3f
            goto L40
        L3f:
            r12 = r1
        L40:
            if (r12 == 0) goto L49
            int r9 = r12.length()
            if (r9 <= 0) goto L49
            goto L4a
        L49:
            r12 = r1
        L4a:
            if (r14 == 0) goto L53
            int r9 = r14.length()
            if (r9 <= 0) goto L53
            goto L54
        L53:
            r14 = r1
        L54:
            if (r12 != 0) goto L59
            if (r14 != 0) goto L5a
            return r1
        L59:
            r14 = r12
        L5a:
            com.stepos.agentframework.chatcore.audit.m$a r9 = new com.stepos.agentframework.chatcore.audit.m$a
            java.lang.String[] r10 = new java.lang.String[]{r10, r11, r14}
            java.util.List r10 = Z8.C1173v.p(r10)
            r0 = r10
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r7 = 62
            r8 = 0
            java.lang.String r1 = "|"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r10 = Z8.F.A0(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != 0) goto L79
            r12 = 1
            goto L7a
        L79:
            r12 = 0
        L7a:
            r9.<init>(r11, r14, r10, r12)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.audit.m.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.stepos.agentframework.chatcore.audit.m$a");
    }

    public final Identity c(String sessionId, AgentModeration moderation, String protocolMessageId) {
        p.i(sessionId, "sessionId");
        p.i(moderation, "moderation");
        return b(sessionId, moderation.getKind(), moderation.getRunId(), moderation.getChannelMessageId(), protocolMessageId);
    }
}
