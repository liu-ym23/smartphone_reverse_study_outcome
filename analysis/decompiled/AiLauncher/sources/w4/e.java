package w4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import com.stepos.agentframework.chatcore.session.Q;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b2\b\u0007\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010*\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u00103\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u00106R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\"\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u00103\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u00106R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001e¨\u0006?"}, d2 = {"Lw4/e;", "", "", "id", "", "sessionId", "title", "agentId", "deviceId", "", "createTime", "lastActiveAt", "lastReadAt", "", "isTempSession", "sessionKind", "sendFailed", "titleSource", "deleteStatus", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZIZII)V", "o", "()Z", "m", "n", "p", "I", "e", "()I", "setId", "(I)V", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "k", "s", Const.INTENT_KEY_APIKEY, "setAgentId", Const.INTENT_KEY_UMID, "setDeviceId", "J", Const.INTENT_KEY_PKGNAME, "()J", "setCreateTime", "(J)V", "f", "setLastActiveAt", Const.INTENT_KEY_BACKGROUND_COMMAND, "setLastReadAt", "Z", "q", "setTempSession", "(Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "setSessionKind", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setSendFailed", "l", "t", "c", "r", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    private String agentId;
    private long createTime;
    private int deleteStatus;
    private String deviceId;
    private int id;
    private boolean isTempSession;
    private long lastActiveAt;
    private long lastReadAt;
    private boolean sendFailed;
    private String sessionId;
    private int sessionKind;
    private String title;
    private int titleSource;

    public e(int i10, String sessionId, String title, String agentId, String deviceId, long j10, long j11, long j12, boolean z10, int i11, boolean z11, int i12, int i13) {
        p.i(sessionId, "sessionId");
        p.i(title, "title");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        this.id = i10;
        this.sessionId = sessionId;
        this.title = title;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.createTime = j10;
        this.lastActiveAt = j11;
        this.lastReadAt = j12;
        this.isTempSession = z10;
        this.sessionKind = i11;
        this.sendFailed = z11;
        this.titleSource = i12;
        this.deleteStatus = i13;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getDeleteStatus() {
        return this.deleteStatus;
    }

    /* renamed from: d, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: e, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: f, reason: from getter */
    public final long getLastActiveAt() {
        return this.lastActiveAt;
    }

    /* renamed from: g, reason: from getter */
    public final long getLastReadAt() {
        return this.lastReadAt;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getSendFailed() {
        return this.sendFailed;
    }

    /* renamed from: i, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: j, reason: from getter */
    public final int getSessionKind() {
        return this.sessionKind;
    }

    /* renamed from: k, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: l, reason: from getter */
    public final int getTitleSource() {
        return this.titleSource;
    }

    public final boolean m() {
        return Q.INSTANCE.a(this.deleteStatus);
    }

    public final boolean n() {
        return Q.INSTANCE.b(this.deleteStatus);
    }

    public final boolean o() {
        return this.lastReadAt >= this.lastActiveAt;
    }

    public final boolean p() {
        ConversationSessionIds conversationSessionIds = ConversationSessionIds.INSTANCE;
        return conversationSessionIds.h(this.sessionId) || conversationSessionIds.e(this.sessionId);
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsTempSession() {
        return this.isTempSession;
    }

    public final void r(int i10) {
        this.deleteStatus = i10;
    }

    public final void s(String str) {
        p.i(str, "<set-?>");
        this.title = str;
    }

    public final void t(int i10) {
        this.titleSource = i10;
    }

    public /* synthetic */ e(int i10, String str, String str2, String str3, String str4, long j10, long j11, long j12, boolean z10, int i11, boolean z11, int i12, int i13, int i14, kotlin.jvm.internal.i iVar) {
        this((i14 & 1) != 0 ? 0 : i10, str, str2, str3, (i14 & 16) != 0 ? "" : str4, (i14 & 32) != 0 ? System.currentTimeMillis() : j10, (i14 & 64) != 0 ? System.currentTimeMillis() : j11, (i14 & 128) != 0 ? 0L : j12, (i14 & 256) != 0 ? false : z10, (i14 & 512) != 0 ? ConversationSessionKind.NORMAL.getCode() : i11, (i14 & 1024) != 0 ? false : z11, (i14 & 2048) != 0 ? 0 : i12, (i14 & 4096) != 0 ? 0 : i13);
    }
}
