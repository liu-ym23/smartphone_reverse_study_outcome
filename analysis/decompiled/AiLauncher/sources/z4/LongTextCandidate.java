package z4;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.longtext.LongTextEntryReason;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001c"}, d2 = {"Lz4/c;", "", "Lz4/e;", "key", "", "source", "agentId", "", "partIndex", "<init>", "(Lz4/e;Ljava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lz4/e;", Const.INTENT_KEY_PKGNAME, "()Lz4/e;", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "I", "c", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z4.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class LongTextCandidate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String agentId;
    private final LongTextKey key;
    private final int partIndex;
    private final String source;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lz4/c$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/S1;", "item", "Lz4/c;", "f", "(Lcom/stepos/agentframework/chatui/S1;)Lz4/c;", "Lz4/a;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/S1;)Lz4/a;", "Lcom/stepos/agentframework/chatui/N1;", "message", "", "e", "(Lcom/stepos/agentframework/chatui/N1;)I", "bodyPartIndex", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatui/N1;I)Lcom/stepos/agentframework/chatui/N1;", Const.INTENT_KEY_UMID, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z4.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final LongTextAdmission b(LongTextEntryReason longTextEntryReason, int i10) {
            return new LongTextAdmission(null, longTextEntryReason, i10, 1, null);
        }

        public static /* synthetic */ LongTextAdmission c(LongTextEntryReason longTextEntryReason, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = -1;
            }
            return b(longTextEntryReason, i10);
        }

        public final LongTextAdmission a(S1 item) {
            String text;
            p.i(item, "item");
            DisplayMessage displayMessage = item instanceof DisplayMessage ? (DisplayMessage) item : null;
            if (displayMessage == null) {
                return c(LongTextEntryReason.NOT_MESSAGE, 0, 2, null);
            }
            if (displayMessage.getRole() != AgentRole.ASSISTANT) {
                return c(LongTextEntryReason.NOT_ASSISTANT, 0, 2, null);
            }
            if (displayMessage.getStatus() != EReplyStatus.COMPLETED) {
                return c(LongTextEntryReason.NOT_COMPLETED, 0, 2, null);
            }
            if (displayMessage.getMessageId().length() == 0) {
                return c(LongTextEntryReason.MISSING_ID, 0, 2, null);
            }
            if (displayMessage.getApprovalRequestId() != null) {
                return c(LongTextEntryReason.APPROVAL, 0, 2, null);
            }
            if (displayMessage.getAskUserConversation() != null) {
                return c(LongTextEntryReason.ASK_USER, 0, 2, null);
            }
            if (displayMessage.m().isEmpty()) {
                return c(LongTextEntryReason.EMPTY_PARTS, 0, 2, null);
            }
            int iE = e(displayMessage);
            DisplayChatMessage displayChatMessage = (DisplayChatMessage) F.t0(displayMessage.m(), iE);
            if (displayChatMessage == null) {
                return c(LongTextEntryReason.LAST_PART_NOT_TEXT, 0, 2, null);
            }
            if (displayChatMessage.getType() != AgentMessageType.TEXT) {
                return b(LongTextEntryReason.LAST_PART_NOT_TEXT, iE);
            }
            m content = displayChatMessage.getContent();
            m.TextMessage textMessage = content instanceof m.TextMessage ? (m.TextMessage) content : null;
            if (textMessage == null || (text = textMessage.getText()) == null) {
                return b(LongTextEntryReason.LAST_CONTENT_NOT_TEXT, iE);
            }
            if (i.INSTANCE.a(text) >= 2) {
                return b(LongTextEntryReason.IMAGE_GALLERY, iE);
            }
            if (!com.stepos.agentframework.chatui.longtext.b.INSTANCE.k(text)) {
                return b(LongTextEntryReason.LAST_TEXT_TOO_SHORT, iE);
            }
            int length = 0;
            for (int i10 = 0; i10 < iE; i10++) {
                DisplayChatMessage displayChatMessage2 = displayMessage.m().get(i10);
                if (displayChatMessage2.getType() != AgentMessageType.TEXT && displayChatMessage2.getType() != AgentMessageType.THINKING_TEXT && displayChatMessage2.getType() != AgentMessageType.TOOL) {
                    return b(LongTextEntryReason.UNSUPPORTED_PREFIX_PART, i10);
                }
                List<DisplayTool> listF = displayChatMessage2.f();
                if (listF != null) {
                    List<DisplayTool> list = listF;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (((DisplayTool) it.next()).getAppUIData() != null) {
                                return b(LongTextEntryReason.PREFIX_APP_UI, i10);
                            }
                        }
                    }
                }
                length += displayChatMessage2.getContent().h().length() + displayChatMessage2.getDeepThinkText().length();
                if (length >= 8192) {
                    return b(LongTextEntryReason.PREFIX_TOO_LONG, i10);
                }
            }
            return new LongTextAdmission(new LongTextCandidate(new LongTextKey(displayMessage.getSessionId(), displayMessage.getMessageId()), text, displayMessage.getAgentId(), iE), LongTextEntryReason.ELIGIBLE, 0, 4, null);
        }

        public final DisplayMessage d(DisplayMessage message, int bodyPartIndex) {
            p.i(message, "message");
            return DisplayMessage.e(message, null, null, null, null, null, null, F.p1(F.h0(message.m(), bodyPartIndex + 1)), 0L, null, null, null, 0, null, false, 0, null, null, null, null, null, null, null, 0L, null, 0, 0, null, false, 268435391, null);
        }

        public final int e(DisplayMessage message) {
            p.i(message, "message");
            List<DisplayChatMessage> listM = message.m();
            ListIterator<DisplayChatMessage> listIterator = listM.listIterator(listM.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().getType() != AgentMessageType.FILE) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }

        public final LongTextCandidate f(S1 item) {
            p.i(item, "item");
            return a(item).getCandidate();
        }

        public final DisplayMessage g(DisplayMessage message, int bodyPartIndex) {
            p.i(message, "message");
            List listP1 = F.p1(F.f1(message.m(), bodyPartIndex + 1));
            listP1.set(bodyPartIndex, DisplayChatMessage.b((DisplayChatMessage) listP1.get(bodyPartIndex), null, null, new m.TextMessage("", null, 2, null), null, false, 27, null));
            return DisplayMessage.e(message, null, null, null, null, null, null, listP1, 0L, null, null, null, 0, null, false, 0, null, null, null, null, null, null, null, 0L, null, 0, 0, null, false, 266338239, null);
        }

        public Companion() {
        }
    }

    public LongTextCandidate(LongTextKey key, String source, String agentId, int i10) {
        p.i(key, "key");
        p.i(source, "source");
        p.i(agentId, "agentId");
        this.key = key;
        this.source = source;
        this.agentId = agentId;
        this.partIndex = i10;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final LongTextKey getKey() {
        return this.key;
    }

    /* renamed from: c, reason: from getter */
    public final int getPartIndex() {
        return this.partIndex;
    }

    /* renamed from: d, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongTextCandidate)) {
            return false;
        }
        LongTextCandidate longTextCandidate = (LongTextCandidate) other;
        return p.d(this.key, longTextCandidate.key) && p.d(this.source, longTextCandidate.source) && p.d(this.agentId, longTextCandidate.agentId) && this.partIndex == longTextCandidate.partIndex;
    }

    public int hashCode() {
        return (((((this.key.hashCode() * 31) + this.source.hashCode()) * 31) + this.agentId.hashCode()) * 31) + Integer.hashCode(this.partIndex);
    }

    public String toString() {
        return "LongTextCandidate(key=" + this.key + ", source=" + this.source + ", agentId=" + this.agentId + ", partIndex=" + this.partIndex + ")";
    }
}
