package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001b\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0004*\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatui/j2;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatui/S1;", "currentItems", "Lcom/stepos/agentframework/chatui/N1;", "incomingMessages", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Ljava/util/List;)Z", "messages", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Z", "current", "incoming", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/N1;)Z", "e", "Lcom/stepos/agentframework/chatui/j2$a;", "c", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/util/List;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j2 {
    public static final j2 INSTANCE = new j2();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/j2$a;", "", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "type", "", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "<init>", "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "getType", "()Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "Ljava/lang/String;", "getIdentity", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j2$a, reason: from toString */
    public static final /* data */ class ImageStableKey {
        private final String identity;
        private final AgentMessageType type;

        public ImageStableKey(AgentMessageType type, String identity) {
            kotlin.jvm.internal.p.i(type, "type");
            kotlin.jvm.internal.p.i(identity, "identity");
            this.type = type;
            this.identity = identity;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageStableKey)) {
                return false;
            }
            ImageStableKey imageStableKey = (ImageStableKey) other;
            return this.type == imageStableKey.type && kotlin.jvm.internal.p.d(this.identity, imageStableKey.identity);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.identity.hashCode();
        }

        public String toString() {
            return "ImageStableKey(type=" + this.type + ", identity=" + this.identity + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentMessageType.values().length];
            try {
                iArr[AgentMessageType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentMessageType.IMAGE_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentMessageType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean a(List<DisplayMessage> messages) {
        boolean z10;
        List<DisplayMessage> list = messages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<DisplayChatMessage> listM = ((DisplayMessage) it.next()).m();
            if ((listM instanceof Collection) && listM.isEmpty()) {
                z10 = false;
            } else {
                for (DisplayChatMessage displayChatMessage : listM) {
                    int i10 = b.$EnumSwitchMapping$0[displayChatMessage.getType().ordinal()];
                    if ((i10 == 1 || i10 == 2) ? true : i10 != 3 ? false : com.stepos.agentframework.uikit.O.INSTANCE.b(displayChatMessage.getContent().h())) {
                        z10 = true;
                        break;
                    }
                }
                z10 = false;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(List<? extends S1> currentItems, List<DisplayMessage> incomingMessages) {
        kotlin.jvm.internal.p.i(currentItems, "currentItems");
        kotlin.jvm.internal.p.i(incomingMessages, "incomingMessages");
        if (!a(incomingMessages)) {
            return false;
        }
        int i10 = 0;
        for (S1 s12 : currentItems) {
            if (s12 instanceof DisplayMessage) {
                if (i10 >= incomingMessages.size() || !INSTANCE.d((DisplayMessage) s12, incomingMessages.get(i10))) {
                    return false;
                }
                i10++;
            }
        }
        return i10 == incomingMessages.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087 A[PHI: r3
      0x0087: PHI (r3v14 java.lang.String) = (r3v5 java.lang.String), (r3v8 java.lang.String), (r3v10 java.lang.String), (r3v15 java.lang.String) binds: [B:29:0x005b, B:38:0x0071, B:47:0x0084, B:22:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.agentframework.chatui.j2.ImageStableKey> c(com.stepos.agentframework.chatui.DisplayMessage r6) {
        /*
            r5 = this;
            java.util.List r5 = r6.m()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        Lf:
            boolean r0 = r5.hasNext()
            r1 = 0
            if (r0 == 0) goto L97
            java.lang.Object r0 = r5.next()
            com.stepos.agentframework.chatui.J1 r0 = (com.stepos.agentframework.chatui.DisplayChatMessage) r0
            com.stepos.agentframework.chatcore.session.AgentMessageType r2 = r0.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r3 = com.stepos.agentframework.chatcore.session.AgentMessageType.IMAGE
            if (r2 == r3) goto L2e
            com.stepos.agentframework.chatcore.session.AgentMessageType r2 = r0.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r3 = com.stepos.agentframework.chatcore.session.AgentMessageType.IMAGE_URL
            if (r2 == r3) goto L2e
            goto L90
        L2e:
            u4.m r2 = r0.getContent()
            boolean r3 = r2 instanceof u4.m.ImageMessage
            if (r3 == 0) goto L39
            u4.m$e r2 = (u4.m.ImageMessage) r2
            goto L3a
        L39:
            r2 = r1
        L3a:
            if (r2 != 0) goto L3d
            goto L90
        L3d:
            java.lang.String r3 = r2.getFileId()
            if (r3 == 0) goto L4d
            boolean r4 = La.H.x0(r3)
            if (r4 != 0) goto L4a
            goto L4b
        L4a:
            r3 = r1
        L4b:
            if (r3 != 0) goto L87
        L4d:
            java.lang.String r3 = r2.getUrl()
            if (r3 == 0) goto L5a
            boolean r4 = La.H.x0(r3)
            if (r4 != 0) goto L5a
            goto L5b
        L5a:
            r3 = r1
        L5b:
            if (r3 != 0) goto L87
            android.net.Uri r3 = r2.getUri()
            if (r3 == 0) goto L70
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L70
            boolean r4 = La.H.x0(r3)
            if (r4 != 0) goto L70
            goto L71
        L70:
            r3 = r1
        L71:
            if (r3 != 0) goto L87
            java.lang.String r2 = r2.getLocalPath()
            if (r2 == 0) goto L83
            boolean r3 = La.H.x0(r2)
            if (r3 != 0) goto L80
            goto L81
        L80:
            r2 = r1
        L81:
            r3 = r2
            goto L84
        L83:
            r3 = r1
        L84:
            if (r3 != 0) goto L87
            goto L90
        L87:
            com.stepos.agentframework.chatui.j2$a r1 = new com.stepos.agentframework.chatui.j2$a
            com.stepos.agentframework.chatcore.session.AgentMessageType r0 = r0.getType()
            r1.<init>(r0, r3)
        L90:
            if (r1 == 0) goto Lf
            r6.add(r1)
            goto Lf
        L97:
            boolean r5 = r6.isEmpty()
            if (r5 != 0) goto L9e
            return r6
        L9e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.j2.c(com.stepos.agentframework.chatui.N1):java.util.List");
    }

    public final boolean d(DisplayMessage current, DisplayMessage incoming) {
        List<ImageStableKey> listC;
        List<ImageStableKey> listC2;
        if (e(current, incoming)) {
            return true;
        }
        if (kotlin.jvm.internal.p.d(current.getMessageId(), incoming.getMessageId()) && current.getRole() == incoming.getRole() && current.getStatus() == incoming.getStatus() && current.getErrorCode() == incoming.getErrorCode() && kotlin.jvm.internal.p.d(current.getErrorMessage(), incoming.getErrorMessage()) && current.getSendState() == incoming.getSendState() && (listC = c(current)) != null && (listC2 = c(incoming)) != null) {
            return kotlin.jvm.internal.p.d(listC, listC2);
        }
        return false;
    }

    public final boolean e(DisplayMessage current, DisplayMessage incoming) {
        return kotlin.jvm.internal.p.d(DisplayMessage.e(current, null, null, null, null, null, null, null, 0L, null, incoming.z(), null, 0, null, incoming.getNeedActionBarShow(), 0, null, null, null, null, null, null, null, 0L, null, 0, 0, null, false, 268426751, null), incoming);
    }
}
