package w4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJV\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b \u0010\u0011R\u001a\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b!\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\"\u0010\u001a¨\u0006#"}, d2 = {"Lw4/d;", "", "", "id", "", "messageId", "groupId", "", "variantIndex", "sessionId", "snapshotJson", "archivedAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", Const.INTENT_KEY_APIKEY, "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)Lw4/d;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "e", "()J", "Ljava/lang/String;", "f", Const.INTENT_KEY_UMID, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.d, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChatMessageVariant {
    private final long archivedAt;
    private final String groupId;
    private final long id;
    private final String messageId;
    private final String sessionId;
    private final String snapshotJson;
    private final int variantIndex;

    public ChatMessageVariant(long j10, String messageId, String groupId, int i10, String sessionId, String snapshotJson, long j11) {
        p.i(messageId, "messageId");
        p.i(groupId, "groupId");
        p.i(sessionId, "sessionId");
        p.i(snapshotJson, "snapshotJson");
        this.id = j10;
        this.messageId = messageId;
        this.groupId = groupId;
        this.variantIndex = i10;
        this.sessionId = sessionId;
        this.snapshotJson = snapshotJson;
        this.archivedAt = j11;
    }

    public static /* synthetic */ ChatMessageVariant b(ChatMessageVariant chatMessageVariant, long j10, String str, String str2, int i10, String str3, String str4, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = chatMessageVariant.id;
        }
        long j12 = j10;
        if ((i11 & 2) != 0) {
            str = chatMessageVariant.messageId;
        }
        String str5 = str;
        if ((i11 & 4) != 0) {
            str2 = chatMessageVariant.groupId;
        }
        String str6 = str2;
        if ((i11 & 8) != 0) {
            i10 = chatMessageVariant.variantIndex;
        }
        return chatMessageVariant.a(j12, str5, str6, i10, (i11 & 16) != 0 ? chatMessageVariant.sessionId : str3, (i11 & 32) != 0 ? chatMessageVariant.snapshotJson : str4, (i11 & 64) != 0 ? chatMessageVariant.archivedAt : j11);
    }

    public final ChatMessageVariant a(long id, String messageId, String groupId, int variantIndex, String sessionId, String snapshotJson, long archivedAt) {
        p.i(messageId, "messageId");
        p.i(groupId, "groupId");
        p.i(sessionId, "sessionId");
        p.i(snapshotJson, "snapshotJson");
        return new ChatMessageVariant(id, messageId, groupId, variantIndex, sessionId, snapshotJson, archivedAt);
    }

    /* renamed from: c, reason: from getter */
    public final long getArchivedAt() {
        return this.archivedAt;
    }

    /* renamed from: d, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: e, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessageVariant)) {
            return false;
        }
        ChatMessageVariant chatMessageVariant = (ChatMessageVariant) other;
        return this.id == chatMessageVariant.id && p.d(this.messageId, chatMessageVariant.messageId) && p.d(this.groupId, chatMessageVariant.groupId) && this.variantIndex == chatMessageVariant.variantIndex && p.d(this.sessionId, chatMessageVariant.sessionId) && p.d(this.snapshotJson, chatMessageVariant.snapshotJson) && this.archivedAt == chatMessageVariant.archivedAt;
    }

    /* renamed from: f, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: g, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: h, reason: from getter */
    public final String getSnapshotJson() {
        return this.snapshotJson;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.id) * 31) + this.messageId.hashCode()) * 31) + this.groupId.hashCode()) * 31) + Integer.hashCode(this.variantIndex)) * 31) + this.sessionId.hashCode()) * 31) + this.snapshotJson.hashCode()) * 31) + Long.hashCode(this.archivedAt);
    }

    /* renamed from: i, reason: from getter */
    public final int getVariantIndex() {
        return this.variantIndex;
    }

    public String toString() {
        return "ChatMessageVariant(id=" + this.id + ", messageId=" + this.messageId + ", groupId=" + this.groupId + ", variantIndex=" + this.variantIndex + ", sessionId=" + this.sessionId + ", snapshotJson=" + this.snapshotJson + ", archivedAt=" + this.archivedAt + ")";
    }

    public /* synthetic */ ChatMessageVariant(long j10, String str, String str2, int i10, String str3, String str4, long j11, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 0L : j10, str, str2, i10, str3, str4, (i11 & 64) != 0 ? System.currentTimeMillis() : j11);
    }
}
