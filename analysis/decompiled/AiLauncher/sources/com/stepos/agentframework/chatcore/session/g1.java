package com.stepos.agentframework.chatcore.session;

import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ§\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u001a2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J5\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\f¢\u0006\u0004\b%\u0010\u0003R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/g1;", "", "<init>", "()V", "", "Lw4/c;", "f", "()Ljava/util/List;", "", "messageIds", "", "failed", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/util/List;Z)V", "agentId", "sessionId", "tempSessionId", "pairId", DidiCardProvider.KEY_TRACE_ID, "Lu4/a;", "messages", "resendMessage", "userMessageId", "imageMessageId", "fileMessageId", "Lkotlin/Function1;", "onHandleMessage", "Lkotlin/Function2;", "onReplaceMessage", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lw4/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/p;)Ljava/util/List;", "", "c", "()J", "e", "(Ljava/lang/String;Lp9/p;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "", "userMessages", "Ljava/util/List;", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "groupedSendOrder", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class g1 {
    private static final a Companion = new a(null);
    private static final String TAG = "UserMessageAssembler";
    private final List<ChatMessage> userMessages = new ArrayList();
    private final List<AgentMessageType> groupedSendOrder = C1173v.p(AgentMessageType.IMAGE, AgentMessageType.VIDEO, AgentMessageType.FILE, AgentMessageType.TEXT);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/g1$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentMessageType.values().length];
            try {
                iArr[AgentMessageType.IMAGE_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void a() {
        this.userMessages.clear();
    }

    public final List<ChatMessage> b(String agentId, String sessionId, String tempSessionId, String pairId, String traceId, List<AgentMessage> messages, ChatMessage resendMessage, String userMessageId, String imageMessageId, String fileMessageId, InterfaceC5074l<? super ChatMessage, Y8.t> onHandleMessage, p9.p<? super ChatMessage, ? super String, Y8.t> onReplaceMessage) {
        LinkedHashMap linkedHashMap;
        Iterator it;
        long j10;
        String strC;
        String agentId2 = agentId;
        kotlin.jvm.internal.p.i(agentId2, "agentId");
        String sessionId2 = sessionId;
        kotlin.jvm.internal.p.i(sessionId2, "sessionId");
        String tempSessionId2 = tempSessionId;
        kotlin.jvm.internal.p.i(tempSessionId2, "tempSessionId");
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(messages, "messages");
        kotlin.jvm.internal.p.i(onHandleMessage, "onHandleMessage");
        kotlin.jvm.internal.p.i(onReplaceMessage, "onReplaceMessage");
        if (messages.isEmpty()) {
            return Z8.F.m1(this.userMessages);
        }
        ArrayList<AgentMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (!((AgentMessage) obj).getHiddenInUi()) {
                arrayList.add(obj);
            }
        }
        int i10 = 0;
        if (arrayList.size() != messages.size()) {
            C4148a.d(TAG, "createUserMessages: skip " + (messages.size() - arrayList.size()) + " hiddenInUi msg(s) from UI, total=" + messages.size(), false, 4, null);
        }
        if (arrayList.isEmpty()) {
            return Z8.F.m1(this.userMessages);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (AgentMessage agentMessage : arrayList) {
            AgentMessageType type = b.$EnumSwitchMapping$0[agentMessage.getType().ordinal()] == 1 ? AgentMessageType.IMAGE : agentMessage.getType();
            Object arrayList2 = linkedHashMap2.get(type);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap2.put(type, arrayList2);
            }
            ((List) arrayList2).add(agentMessage);
        }
        List listC = C1172u.c();
        for (AgentMessageType agentMessageType : this.groupedSendOrder) {
            if (linkedHashMap2.containsKey(agentMessageType)) {
                listC.add(agentMessageType);
            }
        }
        Set<AgentMessageType> setKeySet = linkedHashMap2.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        for (AgentMessageType agentMessageType2 : setKeySet) {
            if (!listC.contains(agentMessageType2)) {
                kotlin.jvm.internal.p.f(agentMessageType2);
                listC.add(agentMessageType2);
            }
        }
        List listA = C1172u.a(listC);
        int iIndexOf = listA.indexOf(AgentMessageType.TEXT);
        long jCurrentTimeMillis = (resendMessage == null || iIndexOf < 0) ? System.currentTimeMillis() : resendMessage.getTime() - iIndexOf;
        Iterator it2 = listA.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            AgentMessageType agentMessageType3 = (AgentMessageType) next;
            List listM = (List) linkedHashMap2.get(agentMessageType3);
            if (listM == null) {
                listM = C1173v.m();
            }
            List list = listM;
            if (list.isEmpty()) {
                linkedHashMap = linkedHashMap2;
                it = it2;
                j10 = jCurrentTimeMillis;
            } else {
                AgentMessageType agentMessageType4 = AgentMessageType.TEXT;
                if (agentMessageType3 == agentMessageType4 && userMessageId != null && userMessageId.length() != 0) {
                    linkedHashMap = linkedHashMap2;
                    it = it2;
                    strC = userMessageId;
                } else if (agentMessageType3 == AgentMessageType.IMAGE && imageMessageId != null && imageMessageId.length() != 0) {
                    linkedHashMap = linkedHashMap2;
                    it = it2;
                    strC = imageMessageId;
                } else if (agentMessageType3 != AgentMessageType.FILE || fileMessageId == null || fileMessageId.length() == 0) {
                    O6.m mVar = O6.m.INSTANCE;
                    linkedHashMap = linkedHashMap2;
                    StringBuilder sb2 = new StringBuilder();
                    it = it2;
                    sb2.append("user-");
                    sb2.append(jCurrentTimeMillis);
                    sb2.append(O6.l.DATE_SEPARATOR);
                    sb2.append(i10);
                    sb2.append(O6.l.DATE_SEPARATOR);
                    sb2.append(agentMessageType3);
                    strC = mVar.c(sb2.toString());
                } else {
                    linkedHashMap = linkedHashMap2;
                    it = it2;
                    strC = fileMessageId;
                }
                j10 = jCurrentTimeMillis;
                ChatMessage chatMessage = new ChatMessage(strC, sessionId2.length() == 0 ? tempSessionId2 : sessionId2, agentId2, i10 + jCurrentTimeMillis, AgentRole.USER, "", 0, 0, "", pairId, traceId, EReplyStatus.COMPLETED, 0, null, null, null, false, null, null, null, 0, null, 4190208, null);
                chatMessage.L(new ArrayList(list));
                this.userMessages.add(chatMessage);
                if (resendMessage == null || agentMessageType3 != agentMessageType4) {
                    onHandleMessage.invoke(chatMessage);
                } else {
                    onReplaceMessage.invoke(chatMessage, resendMessage.getMessageId());
                }
            }
            agentId2 = agentId;
            sessionId2 = sessionId;
            tempSessionId2 = tempSessionId;
            linkedHashMap2 = linkedHashMap;
            i10 = i11;
            it2 = it;
            jCurrentTimeMillis = j10;
        }
        return Z8.F.m1(this.userMessages);
    }

    public final long c() {
        Long l10;
        Iterator<T> it = this.userMessages.iterator();
        if (it.hasNext()) {
            Long lValueOf = Long.valueOf(((ChatMessage) it.next()).getTime());
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((ChatMessage) it.next()).getTime());
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
            l10 = lValueOf;
        } else {
            l10 = null;
        }
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public final void d(List<String> messageIds, boolean failed) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        if (messageIds.isEmpty()) {
            return;
        }
        HashSet hashSetK1 = Z8.F.k1(messageIds);
        for (ChatMessage chatMessage : this.userMessages) {
            if (hashSetK1.contains(chatMessage.getMessageId())) {
                chatMessage.Q(failed);
            }
        }
    }

    public final List<ChatMessage> e(String sessionId, p9.p<? super ChatMessage, ? super String, Y8.t> onReplaceMessage) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(onReplaceMessage, "onReplaceMessage");
        for (ChatMessage chatMessage : this.userMessages) {
            chatMessage.S(sessionId);
            onReplaceMessage.invoke(chatMessage, chatMessage.getMessageId());
        }
        return Z8.F.m1(this.userMessages);
    }

    public final List<ChatMessage> f() {
        return Z8.F.m1(this.userMessages);
    }
}
