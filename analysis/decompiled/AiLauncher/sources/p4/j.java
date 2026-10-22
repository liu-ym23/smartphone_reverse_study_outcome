package p4;

import La.D;
import La.H;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import u4.m;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000L\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0007*\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\t\u001a;\u0010\u000f\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0016\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001a\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019\u001a-\u0010\u001b\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\"\u0010#\u001a\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010(\u001a\u001f\u0010,\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010(\u001a\u001f\u0010-\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010(\u001a\u0017\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u00100\u001a\u0017\u00101\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b1\u00100\u001a\u0011\u00102\u001a\u00020\f*\u00020\u0001¢\u0006\u0004\b2\u00103\u001a\u0013\u00104\u001a\u00020\f*\u00020\u0001H\u0002¢\u0006\u0004\b4\u00103\u001a)\u00106\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b6\u00107\u001a!\u00108\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0004\b8\u00109\u001a'\u0010<\u001a\b\u0012\u0004\u0012\u00020:0;*\b\u0012\u0004\u0012\u00020:0\u00002\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b<\u0010=\"\u0014\u0010>\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00106\"\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006B"}, d2 = {"", "Lw4/c;", "local", "remote", "Lp4/k;", ExifInterface.LONGITUDE_EAST, "(Ljava/util/List;Ljava/util/List;)Lp4/k;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lw4/c;)Z", "v", "", "", "usedLocalIds", "remainingRemote", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;Ljava/util/Set;Ljava/util/List;)Lw4/c;", "unusedLocal", "", "J", "(Ljava/util/List;Ljava/util/List;)I", "remoteText", "n", "(Ljava/util/List;Ljava/util/Set;Ljava/lang/String;)Lw4/c;", "l", "(Ljava/util/List;Ljava/util/Set;)Lw4/c;", "m", "k", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "x", "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)Z", "remoteMsg", "localInquiryEchoes", "w", "(Lw4/c;Ljava/lang/String;Ljava/util/Set;)Z", "o", "(Ljava/util/List;)Ljava/util/Set;", "localText", "u", "(Ljava/lang/String;Ljava/lang/String;)Z", "y", "localNorm", "remoteNorm", "z", "B", "text", "D", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lw4/c;)Ljava/lang/String;", "F", "userSendFailed", "I", "(Lw4/c;Lw4/c;Z)Lw4/c;", "C", "(Lw4/c;Lw4/c;)Lw4/c;", "Lu4/a;", "", "K", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "MIN_FRAGMENT_CHARS", "Lkotlin/text/Regex;", "WHITESPACE_RUN", "Lkotlin/text/Regex;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {
    private static final int MIN_FRAGMENT_CHARS = 8;
    private static final Regex WHITESPACE_RUN = new Regex("\\s+");

    public static final boolean A(ChatMessage chatMessage) {
        return chatMessage.getRole() == AgentRole.ASSISTANT && chatMessage.getStatus() == EReplyStatus.CANCELED && chatMessage.getHint() == ChatHintType.STOPPED;
    }

    public static final boolean B(String str, String str2) {
        if (str.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (p.d(str, str2)) {
            return true;
        }
        if (str.length() > str2.length()) {
            str2 = str;
            str = str2;
        }
        if (str.length() < 8) {
            return false;
        }
        return D.X(str2, str, false, 2, null) || H.g0(str2, str, false, 2, null);
    }

    public static final ChatMessage C(ChatMessage chatMessage, ChatMessage chatMessage2) {
        if (A(chatMessage) || v(chatMessage)) {
            return null;
        }
        String strF = F(chatMessage);
        O6.f fVar = O6.f.INSTANCE;
        String strB = fVar.b(strF);
        String strB2 = fVar.b(F(chatMessage2));
        if (strB2.length() == 0 || (strB.length() > strB2.length() && D.X(strB, strB2, false, 2, null))) {
            strB2 = strB;
        }
        boolean zD = p.d(strF, strB);
        if (p.d(strB2, strB) && chatMessage.getStatus() == chatMessage2.getStatus() && zD) {
            return null;
        }
        ChatMessage chatMessageB = ChatMessage.b(chatMessage, null, null, null, 0L, null, null, 0, 0, null, null, null, null, 0, null, null, null, false, null, null, null, 0, null, 4194303, null);
        chatMessageB.U(chatMessage2.getStatus());
        chatMessageB.H(chatMessage2.getErrorCode());
        chatMessageB.I(chatMessage2.getErrorMessage());
        if (chatMessageB.getRole() == AgentRole.USER) {
            chatMessageB.Q(chatMessage.getSendFailed());
        }
        chatMessageB.L(K(chatMessage.i(), strB2));
        return chatMessageB;
    }

    public static final String D(String str) {
        return WHITESPACE_RUN.l(H.D1(str).toString(), " ");
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02c3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final p4.ChannelHistoryMergePlan E(java.util.List<w4.ChatMessage> r29, java.util.List<w4.ChatMessage> r30) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.j.E(java.util.List, java.util.List):p4.k");
    }

    public static final String F(ChatMessage chatMessage) {
        return H.D1(SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.F(F.d0(chatMessage.i()), new InterfaceC5074l() { // from class: p4.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(j.G((AgentMessage) obj));
            }
        }), "", null, null, 0, null, new InterfaceC5074l() { // from class: p4.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j.H((AgentMessage) obj);
            }
        }, 30, null)).toString();
    }

    public static final boolean G(AgentMessage it) {
        p.i(it, "it");
        return it.getType() == AgentMessageType.TEXT;
    }

    public static final CharSequence H(AgentMessage it) {
        p.i(it, "it");
        return it.getContent().h();
    }

    public static final ChatMessage I(ChatMessage chatMessage, ChatMessage chatMessage2, boolean z10) {
        if (z10) {
            return null;
        }
        AgentRole role = chatMessage.getRole();
        AgentRole agentRole = AgentRole.ASSISTANT;
        if (role != agentRole || chatMessage2.getRole() != agentRole || chatMessage2.getStatus() != EReplyStatus.COMPLETED) {
            return null;
        }
        if (chatMessage.getStatus() == EReplyStatus.START || chatMessage.getStatus() == EReplyStatus.REPLYING || chatMessage.getStatus() == EReplyStatus.TOOL_EXECUTING) {
            return C(chatMessage, chatMessage2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r0 = r0 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int J(java.util.List<w4.ChatMessage> r6, java.util.List<w4.ChatMessage> r7) {
        /*
            int r0 = r6.size()
            int r1 = r7.size()
            int r0 = java.lang.Math.min(r0, r1)
        Lc:
            if (r0 <= 0) goto L5f
            java.util.List r1 = Z8.F.g1(r6, r0)
            r2 = r7
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = Z8.F.f1(r2, r0)
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            v9.i r3 = Z8.C1173v.n(r3)
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L2e
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L2e
            goto L59
        L2e:
            java.util.Iterator r3 = r3.iterator()
        L32:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L59
            r4 = r3
            Z8.M r4 = (Z8.M) r4
            int r4 = r4.nextInt()
            java.lang.Object r5 = r1.get(r4)
            w4.c r5 = (w4.ChatMessage) r5
            com.stepos.agentframework.chatcore.session.AgentRole r5 = r5.getRole()
            java.lang.Object r4 = r2.get(r4)
            w4.c r4 = (w4.ChatMessage) r4
            com.stepos.agentframework.chatcore.session.AgentRole r4 = r4.getRole()
            if (r5 != r4) goto L56
            goto L32
        L56:
            int r0 = r0 + (-1)
            goto Lc
        L59:
            int r6 = r6.size()
            int r6 = r6 - r0
            return r6
        L5f:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.j.J(java.util.List, java.util.List):int");
    }

    public static final List<AgentMessage> K(List<AgentMessage> list, String str) {
        ArrayList arrayList = new ArrayList(list.size() + 1);
        boolean z10 = false;
        for (AgentMessage agentMessage : list) {
            if (agentMessage.getType() != AgentMessageType.TEXT) {
                arrayList.add(agentMessage);
            } else if (!z10) {
                arrayList.add(AgentMessage.b(agentMessage, null, null, new m.TextMessage(str, null), null, false, false, 59, null));
                z10 = true;
            }
        }
        if (!z10 && str.length() > 0) {
            arrayList.add(new AgentMessage(AgentMessageType.TEXT, null, new m.TextMessage(str, null, 2, null), null, false, false, 58, null));
        }
        return arrayList;
    }

    public static final String h(ChatMessage chatMessage) {
        p.i(chatMessage, "<this>");
        return O6.f.INSTANCE.b(F(chatMessage));
    }

    public static final String i(String str) {
        return WHITESPACE_RUN.l(str, "");
    }

    public static final ChatMessage j(List<ChatMessage> list, Set<String> set, List<ChatMessage> list2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!set.contains(((ChatMessage) obj).getMessageId())) {
                arrayList.add(obj);
            }
        }
        ChatMessage chatMessage = (ChatMessage) F.t0(arrayList, J(arrayList, list2));
        if (chatMessage == null || chatMessage.getRole() != AgentRole.USER) {
            return null;
        }
        return chatMessage;
    }

    public static final ChatMessage k(List<ChatMessage> list, Set<String> set) {
        int iNextIndex;
        Object next;
        ListIterator<ChatMessage> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            ChatMessage chatMessagePrevious = listIterator.previous();
            if (set.contains(chatMessagePrevious.getMessageId()) && chatMessagePrevious.getRole() == AgentRole.USER) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        Iterator<T> it = list.subList(iNextIndex >= 0 ? iNextIndex + 1 : 0, list.size()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ChatMessage chatMessage = (ChatMessage) next;
            if (!set.contains(chatMessage.getMessageId()) && chatMessage.getRole() == AgentRole.ASSISTANT) {
                break;
            }
        }
        return (ChatMessage) next;
    }

    public static final ChatMessage l(List<ChatMessage> list, Set<String> set) {
        ChatMessage chatMessageK = k(list, set);
        if (chatMessageK == null || chatMessageK.getStatus() != EReplyStatus.COMPLETED || A(chatMessageK)) {
            return null;
        }
        return chatMessageK;
    }

    public static final ChatMessage m(List<ChatMessage> list, Set<String> set) {
        int iNextIndex;
        ListIterator<ChatMessage> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            ChatMessage chatMessagePrevious = listIterator.previous();
            if (set.contains(chatMessagePrevious.getMessageId()) && chatMessagePrevious.getRole() == AgentRole.USER) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        int i10 = iNextIndex >= 0 ? iNextIndex + 1 : 0;
        if (i10 >= list.size()) {
            return null;
        }
        int size = list.size();
        while (i10 < size) {
            ChatMessage chatMessage = list.get(i10);
            if (chatMessage.getRole() == AgentRole.USER) {
                break;
            }
            if (chatMessage.getRole() == AgentRole.ASSISTANT && !set.contains(chatMessage.getMessageId())) {
                if (A(chatMessage)) {
                    return null;
                }
                if (x(chatMessage.getStatus())) {
                    return chatMessage;
                }
            }
            i10++;
        }
        return null;
    }

    public static final ChatMessage n(List<ChatMessage> list, Set<String> set, String str) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ChatMessage chatMessage = (ChatMessage) next;
            if (!set.contains(chatMessage.getMessageId()) && chatMessage.getRole() == AgentRole.ASSISTANT) {
                break;
            }
        }
        ChatMessage chatMessage2 = (ChatMessage) next;
        if (chatMessage2 == null || !A(chatMessage2)) {
            return null;
        }
        String strH = h(chatMessage2);
        if (strH.length() == 0 || D.X(str, strH, false, 2, null)) {
            return chatMessage2;
        }
        return null;
    }

    public static final Set<String> o(List<ChatMessage> list) {
        return SequencesKt___SequencesKt.f0(SequencesKt___SequencesKt.G(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.S(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.L(F.d0(list), new InterfaceC5074l() { // from class: p4.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j.p((ChatMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: p4.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(j.q((AgentMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: p4.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j.r((AgentMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: p4.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j.s((String) obj);
            }
        }), new InterfaceC5074l() { // from class: p4.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(j.t((String) obj));
            }
        }));
    }

    public static final Ka.j p(ChatMessage it) {
        p.i(it, "it");
        return F.d0(it.i());
    }

    public static final boolean q(AgentMessage it) {
        p.i(it, "it");
        return it.getType() == AgentMessageType.INQUIRY;
    }

    public static final String r(AgentMessage it) {
        p.i(it, "it");
        m content = it.getContent();
        m.InquiryMessage inquiryMessage = content instanceof m.InquiryMessage ? (m.InquiryMessage) content : null;
        if (inquiryMessage != null) {
            return inquiryMessage.getSummary();
        }
        return null;
    }

    public static final String s(String it) {
        p.i(it, "it");
        return D(it);
    }

    public static final boolean t(String it) {
        p.i(it, "it");
        return it.length() == 0;
    }

    public static final boolean u(String str, String str2) {
        return B(D(str), D(str2)) || B(i(str), i(str2));
    }

    public static final boolean v(ChatMessage chatMessage) {
        return chatMessage.getRole() == AgentRole.ASSISTANT && (D.X(chatMessage.getMessageId(), RunBlockedEvent.AUDIT_BLOCKED_REPLY_PREFIX, false, 2, null) || D.X(chatMessage.getMessageId(), RunBlockedEvent.PRIVACY_BLOCKED_REPLY_PREFIX, false, 2, null));
    }

    public static final boolean w(ChatMessage chatMessage, String str, Set<String> set) {
        if (chatMessage.getRole() != AgentRole.USER || str.length() == 0 || set.isEmpty()) {
            return false;
        }
        return set.contains(D(str));
    }

    public static final boolean x(EReplyStatus eReplyStatus) {
        return eReplyStatus == EReplyStatus.CANCELED || eReplyStatus == EReplyStatus.REPLYING || eReplyStatus == EReplyStatus.ERROR || eReplyStatus == EReplyStatus.TOOL_EXECUTING || eReplyStatus == EReplyStatus.START;
    }

    public static final boolean y(String str, String str2) {
        return z(D(str), D(str2)) || z(i(str), i(str2));
    }

    public static final boolean z(String str, String str2) {
        return str.length() >= 8 && str2.length() > str.length() && D.X(str2, str, false, 2, null);
    }
}
