package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5685n;
import w4.ChatMessage;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/w0;", "", "<init>", "()V", "", "Lw4/c;", "dbMessages", AuthSessionDto.STATUS_PENDING, "Lcom/stepos/agentframework/chatcore/session/w0$a;", "c", "(Ljava/util/List;Ljava/util/List;)Lcom/stepos/agentframework/chatcore/session/w0$a;", "db", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/c;Lw4/c;)Z", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "TAG", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.w0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1962w0 {
    public static final C1962w0 INSTANCE = new C1962w0();
    private static final String TAG = "PendingMessageMerge";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/w0$a;", "", "", "Lw4/c;", "messages", "", "overlaidIds", "replacedPlaceholderIds", "extraIds", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "getOverlaidIds", "getReplacedPlaceholderIds", "getExtraIds", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.w0$a, reason: from toString */
    public static final /* data */ class Result {
        private final List<String> extraIds;
        private final List<ChatMessage> messages;
        private final List<String> overlaidIds;
        private final List<String> replacedPlaceholderIds;

        public Result(List<ChatMessage> messages, List<String> overlaidIds, List<String> replacedPlaceholderIds, List<String> extraIds) {
            kotlin.jvm.internal.p.i(messages, "messages");
            kotlin.jvm.internal.p.i(overlaidIds, "overlaidIds");
            kotlin.jvm.internal.p.i(replacedPlaceholderIds, "replacedPlaceholderIds");
            kotlin.jvm.internal.p.i(extraIds, "extraIds");
            this.messages = messages;
            this.overlaidIds = overlaidIds;
            this.replacedPlaceholderIds = replacedPlaceholderIds;
            this.extraIds = extraIds;
        }

        public final List<ChatMessage> a() {
            return this.messages;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return kotlin.jvm.internal.p.d(this.messages, result.messages) && kotlin.jvm.internal.p.d(this.overlaidIds, result.overlaidIds) && kotlin.jvm.internal.p.d(this.replacedPlaceholderIds, result.replacedPlaceholderIds) && kotlin.jvm.internal.p.d(this.extraIds, result.extraIds);
        }

        public int hashCode() {
            return (((((this.messages.hashCode() * 31) + this.overlaidIds.hashCode()) * 31) + this.replacedPlaceholderIds.hashCode()) * 31) + this.extraIds.hashCode();
        }

        public String toString() {
            return "Result(messages=" + this.messages + ", overlaidIds=" + this.overlaidIds + ", replacedPlaceholderIds=" + this.replacedPlaceholderIds + ", extraIds=" + this.extraIds + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.w0$b */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((ChatMessage) t10).getTime()), Long.valueOf(((ChatMessage) t11).getTime()));
        }
    }

    public static final String d(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getMessageId();
    }

    public static final CharSequence e(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getMessageId() + ServerSentEventKt.COLON + it.getStatus();
    }

    public final Result c(List<ChatMessage> dbMessages, List<ChatMessage> pending) {
        ArrayList arrayList;
        ArrayList arrayList2;
        kotlin.jvm.internal.p.i(dbMessages, "dbMessages");
        kotlin.jvm.internal.p.i(pending, "pending");
        if (pending.isEmpty()) {
            return new Result(dbMessages, C1173v.m(), C1173v.m(), C1173v.m());
        }
        List<ChatMessage> list = pending;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (((ChatMessage) obj).getMessageId().length() > 0) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(arrayList3, 10)), 16));
        for (Object obj2 : arrayList3) {
            linkedHashMap.put(((ChatMessage) obj2).getMessageId(), obj2);
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            ChatMessage chatMessage = (ChatMessage) obj3;
            if (chatMessage.getRole() == AgentRole.ASSISTANT && chatMessage.getPairId().length() > 0 && chatMessage.getMessageId().length() > 0) {
                arrayList4.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(arrayList4, 10)), 16));
        for (Object obj4 : arrayList4) {
            linkedHashMap2.put(((ChatMessage) obj4).getPairId(), obj4);
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList(dbMessages.size() + pending.size());
        Iterator<ChatMessage> it = dbMessages.iterator();
        while (true) {
            ChatMessage chatMessage2 = null;
            if (!it.hasNext()) {
                break;
            }
            ChatMessage next = it.next();
            ChatMessage chatMessage3 = (ChatMessage) linkedHashMap.get(next.getMessageId());
            if (chatMessage3 != null) {
                if (chatMessage3.getSendFailed() && !next.getSendFailed()) {
                    next.Q(true);
                }
                if (g(next, chatMessage3)) {
                    arrayList7.add(chatMessage3);
                    arrayList5.add(next.getMessageId());
                }
            }
            if (next.getRole() == AgentRole.ASSISTANT && next.getPairId().length() > 0) {
                chatMessage2 = (ChatMessage) linkedHashMap2.get(next.getPairId());
            }
            if (chatMessage2 == null || kotlin.jvm.internal.p.d(chatMessage2.getMessageId(), next.getMessageId()) || !h(next, chatMessage2)) {
                arrayList7.add(next);
            } else {
                arrayList6.add(next.getMessageId());
            }
        }
        HashSet hashSetC0 = SequencesKt___SequencesKt.c0(SequencesKt___SequencesKt.R(Z8.F.d0(arrayList7), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.u0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj5) {
                return C1962w0.d((ChatMessage) obj5);
            }
        }));
        ArrayList arrayList8 = new ArrayList();
        for (Object obj5 : list) {
            ChatMessage chatMessage4 = (ChatMessage) obj5;
            if (chatMessage4.getMessageId().length() > 0 && !hashSetC0.contains(chatMessage4.getMessageId())) {
                arrayList8.add(obj5);
            }
        }
        if (arrayList5.isEmpty() && arrayList6.isEmpty() && arrayList8.isEmpty()) {
            arrayList2 = arrayList8;
            arrayList = arrayList6;
        } else {
            arrayList = arrayList6;
            arrayList2 = arrayList8;
            C4148a.k(TAG, "merge overlay=" + Z8.F.A0(arrayList5, null, null, null, 0, null, null, 63, null) + " replacePlaceholder=" + Z8.F.A0(arrayList, null, null, null, 0, null, null, 63, null) + " extras=" + Z8.F.A0(arrayList2, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.v0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj6) {
                    return C1962w0.e((ChatMessage) obj6);
                }
            }, 31, null) + " db=" + dbMessages.size() + " out=" + (arrayList7.size() + arrayList2.size()), false, 4, null);
        }
        if (arrayList2.isEmpty()) {
            return new Result(arrayList7, arrayList5, arrayList, C1173v.m());
        }
        List listC1 = Z8.F.c1(Z8.F.S0(arrayList7, arrayList2), new b());
        ArrayList arrayList9 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList9.add(((ChatMessage) it2.next()).getMessageId());
        }
        return new Result(listC1, arrayList5, arrayList, arrayList9);
    }

    public final boolean f(ChatMessage pending, ChatMessage db2) {
        return pending.i().size() > db2.i().size() || p4.j.h(pending).length() > p4.j.h(db2).length();
    }

    public final boolean g(ChatMessage db2, ChatMessage pending) {
        if (pending.getRole() != AgentRole.ASSISTANT) {
            return false;
        }
        return !pending.getStatus().isTerminal() ? !db2.getStatus().isTerminal() || f(pending, db2) : !db2.getStatus().isTerminal();
    }

    public final boolean h(ChatMessage db2, ChatMessage pending) {
        AgentRole role = db2.getRole();
        AgentRole agentRole = AgentRole.ASSISTANT;
        if (role == agentRole && pending.getRole() == agentRole && db2.getPairId().length() != 0 && kotlin.jvm.internal.p.d(db2.getPairId(), pending.getPairId())) {
            return !pending.getStatus().isTerminal() || pending.i().size() >= db2.i().size();
        }
        return false;
    }
}
