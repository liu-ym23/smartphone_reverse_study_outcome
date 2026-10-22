package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0016\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014Jp\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b$\u0010\u0018R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b+\u0010*R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/m;", "", "", "sessionId", "requestId", "title", "body", "riskLevel", "", "Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "buttons", "", "createdAt", "expiresAt", "", "answered", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JJZ)V", "now", "k", "(J)Z", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JJZ)Lcom/stepos/ailauncher/taskstore/livenotification/m;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", "e", "()Ljava/util/List;", "J", "f", "()J", "getExpiresAt", "Z", "c", "()Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.m, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class PendingRisk {
    private final boolean answered;
    private final String body;
    private final List<RiskLiveButton> buttons;
    private final long createdAt;
    private final long expiresAt;
    private final String requestId;
    private final String riskLevel;
    private final String sessionId;
    private final String title;

    public PendingRisk(String sessionId, String requestId, String title, String body, String riskLevel, List<RiskLiveButton> buttons, long j10, long j11, boolean z10) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        kotlin.jvm.internal.p.i(buttons, "buttons");
        this.sessionId = sessionId;
        this.requestId = requestId;
        this.title = title;
        this.body = body;
        this.riskLevel = riskLevel;
        this.buttons = buttons;
        this.createdAt = j10;
        this.expiresAt = j11;
        this.answered = z10;
    }

    public static /* synthetic */ PendingRisk b(PendingRisk pendingRisk, String str, String str2, String str3, String str4, String str5, List list, long j10, long j11, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pendingRisk.sessionId;
        }
        if ((i10 & 2) != 0) {
            str2 = pendingRisk.requestId;
        }
        if ((i10 & 4) != 0) {
            str3 = pendingRisk.title;
        }
        if ((i10 & 8) != 0) {
            str4 = pendingRisk.body;
        }
        if ((i10 & 16) != 0) {
            str5 = pendingRisk.riskLevel;
        }
        if ((i10 & 32) != 0) {
            list = pendingRisk.buttons;
        }
        if ((i10 & 64) != 0) {
            j10 = pendingRisk.createdAt;
        }
        if ((i10 & 128) != 0) {
            j11 = pendingRisk.expiresAt;
        }
        if ((i10 & 256) != 0) {
            z10 = pendingRisk.answered;
        }
        boolean z11 = z10;
        long j12 = j11;
        long j13 = j10;
        String str6 = str5;
        List list2 = list;
        return pendingRisk.a(str, str2, str3, str4, str6, list2, j13, j12, z11);
    }

    public final PendingRisk a(String sessionId, String requestId, String title, String body, String riskLevel, List<RiskLiveButton> buttons, long createdAt, long expiresAt, boolean answered) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        kotlin.jvm.internal.p.i(buttons, "buttons");
        return new PendingRisk(sessionId, requestId, title, body, riskLevel, buttons, createdAt, expiresAt, answered);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getAnswered() {
        return this.answered;
    }

    /* renamed from: d, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final List<RiskLiveButton> e() {
        return this.buttons;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingRisk)) {
            return false;
        }
        PendingRisk pendingRisk = (PendingRisk) other;
        return kotlin.jvm.internal.p.d(this.sessionId, pendingRisk.sessionId) && kotlin.jvm.internal.p.d(this.requestId, pendingRisk.requestId) && kotlin.jvm.internal.p.d(this.title, pendingRisk.title) && kotlin.jvm.internal.p.d(this.body, pendingRisk.body) && kotlin.jvm.internal.p.d(this.riskLevel, pendingRisk.riskLevel) && kotlin.jvm.internal.p.d(this.buttons, pendingRisk.buttons) && this.createdAt == pendingRisk.createdAt && this.expiresAt == pendingRisk.expiresAt && this.answered == pendingRisk.answered;
    }

    /* renamed from: f, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: g, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: h, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public int hashCode() {
        return (((((((((((((((this.sessionId.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.body.hashCode()) * 31) + this.riskLevel.hashCode()) * 31) + this.buttons.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.expiresAt)) * 31) + Boolean.hashCode(this.answered);
    }

    /* renamed from: i, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final boolean k(long now) {
        return now >= this.expiresAt;
    }

    public String toString() {
        return "PendingRisk(sessionId=" + this.sessionId + ", requestId=" + this.requestId + ", title=" + this.title + ", body=" + this.body + ", riskLevel=" + this.riskLevel + ", buttons=" + this.buttons + ", createdAt=" + this.createdAt + ", expiresAt=" + this.expiresAt + ", answered=" + this.answered + ")";
    }

    public /* synthetic */ PendingRisk(String str, String str2, String str3, String str4, String str5, List list, long j10, long j11, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, str5, list, j10, j11, (i10 & 256) != 0 ? false : z10);
    }
}
