package com.stepos.agentframework.chatcore.session.list;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.K;
import com.stepos.agentframework.chatcore.session.db.converter.AgentMessageJson;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import w4.ChatMessage;
import w4.MessagePart;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0000*\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "livePhase", "", "liveMessageId", "latestMessageId", "latestSettled", "", "e", "(Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;)Z", "phase", "coldStartInterrupted", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;Z)Z", "Lw4/c;", "c", "(Lw4/c;)Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "msg", "", "Lw4/f;", "parts", Const.INTENT_KEY_PKGNAME, "(Lw4/c;Ljava/util/List;)Lw4/c;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EReplyStatus.values().length];
            try {
                iArr[EReplyStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EReplyStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EReplyStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EReplyStatus.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EReplyStatus.TOOL_EXECUTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EReplyStatus.REPLYING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(((MessagePart) t10).getPartIndex()), Integer.valueOf(((MessagePart) t11).getPartIndex()));
        }
    }

    public static final ChatMessage b(ChatMessage chatMessage, List<MessagePart> list) {
        chatMessage.i().clear();
        if (!list.isEmpty()) {
            Iterator it = F.c1(list, new b()).iterator();
            while (it.hasNext()) {
                chatMessage.i().add(AgentMessageJson.INSTANCE.a(((MessagePart) it.next()).getPayloadJson()));
            }
        }
        return chatMessage;
    }

    public static final SessionChatPhase c(ChatMessage chatMessage) {
        p.i(chatMessage, "<this>");
        switch (a.$EnumSwitchMapping$0[chatMessage.getStatus().ordinal()]) {
            case 1:
            case 2:
                return K.d(chatMessage) ? SessionChatPhase.WAITING : SessionChatPhase.REPLIED;
            case 3:
                return SessionChatPhase.FAILED;
            case 4:
            case 5:
            case 6:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean d(SessionChatPhase phase, boolean z10) {
        p.i(phase, "phase");
        return !z10 || phase == SessionChatPhase.WAITING;
    }

    public static final boolean e(SessionChatPhase livePhase, String liveMessageId, String latestMessageId, SessionChatPhase sessionChatPhase) {
        p.i(livePhase, "livePhase");
        p.i(liveMessageId, "liveMessageId");
        p.i(latestMessageId, "latestMessageId");
        return livePhase == SessionChatPhase.REPLYING && sessionChatPhase != null && liveMessageId.length() != 0 && p.d(liveMessageId, latestMessageId);
    }
}
