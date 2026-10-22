package v4;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.db.converter.AgentMessageJson;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.core.download.ModelFlowMeta;
import h8.C4148a;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w4.ChatMessage;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lv4/a;", "", "<init>", "()V", "Lw4/c;", "message", "", Const.INTENT_KEY_PKGNAME, "(Lw4/c;)Ljava/lang/String;", "json", "", "time", "groupId", "", "variantIndex", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JLjava/lang/String;I)Lw4/c;", "TAG", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5657a {
    private static final String TAG = "ChatMessageSnapshotJson";
    public static final C5657a INSTANCE = new C5657a();
    private static final Gson gson = new Gson();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0082\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b%\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b&\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b)\u0010\u001dR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b*\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b+\u0010\u001bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b,\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b.\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b/\u0010\u001bR\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b3\u0010\u001bR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b4\u0010\u001bR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b5\u00102R\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b6\u00102R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b7\u0010\u001b¨\u00068"}, d2 = {"Lv4/a$a;", "", "", "messageId", "sessionId", "agentId", "viewSpliteId", "", "isLike", "isDisLike", "serverItemId", "pairId", DidiCardProvider.KEY_TRACE_ID, "status", "errorCode", "errorMessage", "", "suggestions", "hint", "approvalRequestId", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "uiActions", "partsJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_APIKEY, "p", "I", "r", "q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, "n", "l", "c", Const.INTENT_KEY_UMID, "Ljava/util/List;", "m", "()Ljava/util/List;", "e", Const.INTENT_KEY_PKGNAME, "k", "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: v4.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class Snapshot {
        private final String agentId;
        private final String approvalRequestId;
        private final int errorCode;
        private final String errorMessage;
        private final String hint;
        private final int isDisLike;
        private final int isLike;
        private final String messageId;
        private final String pairId;
        private final String partsJson;
        private final String serverItemId;
        private final String sessionId;
        private final List<ReferenceSource> sources;
        private final String status;
        private final List<String> suggestions;
        private final String traceId;
        private final List<String> uiActions;
        private final String viewSpliteId;

        public Snapshot() {
            this(null, null, null, null, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, null, 262143, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* renamed from: b, reason: from getter */
        public final String getApprovalRequestId() {
            return this.approvalRequestId;
        }

        /* renamed from: c, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: d, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        /* renamed from: e, reason: from getter */
        public final String getHint() {
            return this.hint;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return p.d(this.messageId, snapshot.messageId) && p.d(this.sessionId, snapshot.sessionId) && p.d(this.agentId, snapshot.agentId) && p.d(this.viewSpliteId, snapshot.viewSpliteId) && this.isLike == snapshot.isLike && this.isDisLike == snapshot.isDisLike && p.d(this.serverItemId, snapshot.serverItemId) && p.d(this.pairId, snapshot.pairId) && p.d(this.traceId, snapshot.traceId) && p.d(this.status, snapshot.status) && this.errorCode == snapshot.errorCode && p.d(this.errorMessage, snapshot.errorMessage) && p.d(this.suggestions, snapshot.suggestions) && p.d(this.hint, snapshot.hint) && p.d(this.approvalRequestId, snapshot.approvalRequestId) && p.d(this.sources, snapshot.sources) && p.d(this.uiActions, snapshot.uiActions) && p.d(this.partsJson, snapshot.partsJson);
        }

        /* renamed from: f, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: g, reason: from getter */
        public final String getPairId() {
            return this.pairId;
        }

        /* renamed from: h, reason: from getter */
        public final String getPartsJson() {
            return this.partsJson;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((((((((this.messageId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.viewSpliteId.hashCode()) * 31) + Integer.hashCode(this.isLike)) * 31) + Integer.hashCode(this.isDisLike)) * 31) + this.serverItemId.hashCode()) * 31) + this.pairId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31) + this.errorMessage.hashCode()) * 31;
            List<String> list = this.suggestions;
            int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.hint.hashCode()) * 31;
            String str = this.approvalRequestId;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            List<ReferenceSource> list2 = this.sources;
            int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<String> list3 = this.uiActions;
            return ((iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.partsJson.hashCode();
        }

        /* renamed from: i, reason: from getter */
        public final String getServerItemId() {
            return this.serverItemId;
        }

        /* renamed from: j, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final List<ReferenceSource> k() {
            return this.sources;
        }

        /* renamed from: l, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        public final List<String> m() {
            return this.suggestions;
        }

        /* renamed from: n, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public final List<String> o() {
            return this.uiActions;
        }

        /* renamed from: p, reason: from getter */
        public final String getViewSpliteId() {
            return this.viewSpliteId;
        }

        /* renamed from: q, reason: from getter */
        public final int getIsDisLike() {
            return this.isDisLike;
        }

        /* renamed from: r, reason: from getter */
        public final int getIsLike() {
            return this.isLike;
        }

        public String toString() {
            return "Snapshot(messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", viewSpliteId=" + this.viewSpliteId + ", isLike=" + this.isLike + ", isDisLike=" + this.isDisLike + ", serverItemId=" + this.serverItemId + ", pairId=" + this.pairId + ", traceId=" + this.traceId + ", status=" + this.status + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", suggestions=" + this.suggestions + ", hint=" + this.hint + ", approvalRequestId=" + this.approvalRequestId + ", sources=" + this.sources + ", uiActions=" + this.uiActions + ", partsJson=" + this.partsJson + ")";
        }

        public Snapshot(String messageId, String sessionId, String agentId, String viewSpliteId, int i10, int i11, String serverItemId, String pairId, String traceId, String status, int i12, String errorMessage, List<String> list, String hint, String str, List<ReferenceSource> list2, List<String> list3, String partsJson) {
            p.i(messageId, "messageId");
            p.i(sessionId, "sessionId");
            p.i(agentId, "agentId");
            p.i(viewSpliteId, "viewSpliteId");
            p.i(serverItemId, "serverItemId");
            p.i(pairId, "pairId");
            p.i(traceId, "traceId");
            p.i(status, "status");
            p.i(errorMessage, "errorMessage");
            p.i(hint, "hint");
            p.i(partsJson, "partsJson");
            this.messageId = messageId;
            this.sessionId = sessionId;
            this.agentId = agentId;
            this.viewSpliteId = viewSpliteId;
            this.isLike = i10;
            this.isDisLike = i11;
            this.serverItemId = serverItemId;
            this.pairId = pairId;
            this.traceId = traceId;
            this.status = status;
            this.errorCode = i12;
            this.errorMessage = errorMessage;
            this.suggestions = list;
            this.hint = hint;
            this.approvalRequestId = str;
            this.sources = list2;
            this.uiActions = list3;
            this.partsJson = partsJson;
        }

        public /* synthetic */ Snapshot(String str, String str2, String str3, String str4, int i10, int i11, String str5, String str6, String str7, String str8, int i12, String str9, List list, String str10, String str11, List list2, List list3, String str12, int i13, i iVar) {
            this((i13 & 1) != 0 ? "" : str, (i13 & 2) != 0 ? "" : str2, (i13 & 4) != 0 ? "" : str3, (i13 & 8) != 0 ? "" : str4, (i13 & 16) != 0 ? 0 : i10, (i13 & 32) != 0 ? 0 : i11, (i13 & 64) != 0 ? "" : str5, (i13 & 128) != 0 ? "" : str6, (i13 & 256) != 0 ? "" : str7, (i13 & 512) != 0 ? "COMPLETED" : str8, (i13 & 1024) == 0 ? i12 : 0, (i13 & 2048) != 0 ? "" : str9, (i13 & 4096) != 0 ? null : list, (i13 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? ModelFlowMeta.PLAN_NONE : str10, (i13 & 16384) != 0 ? null : str11, (i13 & 32768) != 0 ? null : list2, (i13 & 65536) != 0 ? null : list3, (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? "" : str12);
        }
    }

    public final ChatMessage a(String json, long time, String groupId, int variantIndex) {
        Snapshot snapshot;
        Object objB;
        String str;
        Object obj;
        Object objB2;
        AgentRole agentRole;
        p.i(json, "json");
        p.i(groupId, "groupId");
        if (H.x0(json)) {
            return null;
        }
        try {
            snapshot = (Snapshot) gson.fromJson(json, Snapshot.class);
        } catch (Exception e10) {
            C4148a.g(TAG, "decode failed: " + json, e10, false, 8, null);
            snapshot = null;
        }
        if (snapshot == null) {
            return null;
        }
        if (H.x0(snapshot.getMessageId())) {
            C4148a.u(TAG, "decode: blank messageId in snapshot, drop", false, 4, null);
            return null;
        }
        String messageId = snapshot.getMessageId();
        String sessionId = snapshot.getSessionId();
        String agentId = snapshot.getAgentId();
        AgentRole agentRole2 = AgentRole.ASSISTANT;
        String viewSpliteId = snapshot.getViewSpliteId();
        int isLike = snapshot.getIsLike();
        int isDisLike = snapshot.getIsDisLike();
        String serverItemId = snapshot.getServerItemId();
        String pairId = snapshot.getPairId();
        String traceId = snapshot.getTraceId();
        String status = snapshot.getStatus();
        Object obj2 = EReplyStatus.COMPLETED;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(EReplyStatus.valueOf(status));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) == null) {
            obj = objB;
            str = sessionId;
        } else {
            str = sessionId;
            C4148a.u(TAG, "unknown enum value '" + status + "' for " + EReplyStatus.class.getSimpleName() + ", fallback to " + obj2, false, 4, null);
            obj = obj2;
        }
        EReplyStatus eReplyStatus = (Enum) obj;
        int errorCode = snapshot.getErrorCode();
        String str2 = str;
        String errorMessage = snapshot.getErrorMessage();
        List<String> listM = snapshot.m();
        String hint = snapshot.getHint();
        Object obj3 = ChatHintType.NONE;
        try {
            objB2 = Result.b(ChatHintType.valueOf(hint));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.e(objB2) == null) {
            obj3 = objB2;
            agentRole = agentRole2;
        } else {
            agentRole = agentRole2;
            C4148a.u(TAG, "unknown enum value '" + hint + "' for " + ChatHintType.class.getSimpleName() + ", fallback to " + obj3, false, 4, null);
        }
        ChatMessage chatMessage = new ChatMessage(messageId, str2, agentId, time, agentRole, viewSpliteId, isLike, isDisLike, serverItemId, pairId, traceId, eReplyStatus, errorCode, errorMessage, listM, (Enum) obj3, false, snapshot.getApprovalRequestId(), snapshot.k(), groupId, variantIndex, snapshot.o(), 65536, null);
        chatMessage.L(AgentMessageJson.INSTANCE.b(snapshot.getPartsJson()));
        return chatMessage;
    }

    public final String b(ChatMessage message) {
        p.i(message, "message");
        try {
            String json = gson.toJson(new Snapshot(message.getMessageId(), message.getSessionId(), message.getAgentId(), message.getViewSpliteId(), message.getIsLike(), message.getIsDisLike(), message.getServerItemId(), message.getPairId(), message.getTraceId(), message.getStatus().name(), message.getErrorCode(), message.getErrorMessage(), message.u(), message.getHint().name(), message.getApprovalRequestId(), message.s(), message.x(), AgentMessageJson.INSTANCE.d(message.i())));
            p.f(json);
            return json;
        } catch (Exception e10) {
            C4148a.g(TAG, "encode failed, messageId=" + message.getMessageId(), e10, false, 8, null);
            return "";
        }
    }
}
