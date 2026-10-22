package com.stepos.agentframework.chatcore.session;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010!J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010%\"\u0004\b.\u0010/R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010,\u001a\u0004\b0\u0010%\"\u0004\b1\u0010/R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00102\u001a\u0004\b3\u0010'\"\u0004\b4\u00105R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00106\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010=\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010@R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010,\u001a\u0004\bA\u0010%\"\u0004\bB\u0010/R\"\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010=\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010@R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010,\u001a\u0004\bE\u0010%\"\u0004\bF\u0010/R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010,\u001a\u0004\bG\u0010%\"\u0004\bH\u0010/R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010/R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010,\u001a\u0004\bK\u0010%\"\u0004\bL\u0010/R\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00106\u001a\u0004\bM\u00108\"\u0004\bN\u0010:R\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00106\u001a\u0004\bO\u00108\"\u0004\bP\u0010:R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u00106\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00106\u001a\u0004\bS\u00108\"\u0004\bT\u0010:R\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00106\u001a\u0004\bU\u00108\"\u0004\bV\u0010:R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u00106\u001a\u0004\bW\u00108\"\u0004\bX\u0010:R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u00106\u001a\u0004\bY\u00108\"\u0004\bZ\u0010:R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00106\u001a\u0004\b[\u00108\"\u0004\b\\\u0010:R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00106\u001a\u0004\b]\u00108\"\u0004\b^\u0010:¨\u0006_"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "Ljava/io/Serializable;", "", "agentId", "secretKey", "", "llm", "", "timeoutSeconds", "silentUploadWaitMs", "", "stream", "defaultSessionId", "newSession", "defaultQuestion", "contentFilterReplyText", "errorContentReplayText", "agentType", "sendTimeoutMs", "offlineSendTimeoutMs", "postAckTimeoutMs", "streamStallTimeoutMs", "reconnectSettledStallTimeoutMs", "networkToastDelayMs", "cotCollapseDelayMs", "sendingDotsDelayMs", "retryHistoryPullTimeoutMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJJZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJJJJJ)V", ExifInterface.LONGITUDE_EAST, "()Z", "finishReason", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "rawMessage", Const.INTENT_KEY_PKGNAME, "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "w", "(Ljava/lang/String;)V", "n", "setSecretKey", "I", "getLlm", "setLlm", "(I)V", "J", "getTimeoutSeconds", "()J", "setTimeoutSeconds", "(J)V", "t", "setSilentUploadWaitMs", "Z", "u", "D", "(Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "C", "f", "z", "getContentFilterReplyText", "y", "getErrorContentReplayText", "setErrorContentReplayText", Const.INTENT_KEY_UMID, "x", "q", "setSendTimeoutMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "setOfflineSendTimeoutMs", "k", "setPostAckTimeoutMs", "v", "setStreamStallTimeoutMs", "l", "setReconnectSettledStallTimeoutMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setNetworkToastDelayMs", "e", "setCotCollapseDelayMs", "s", "setSendingDotsDelayMs", "m", "setRetryHistoryPullTimeoutMs", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SessionConfig implements Serializable {
    private String agentId;
    private String agentType;
    private String contentFilterReplyText;
    private long cotCollapseDelayMs;
    private String defaultQuestion;
    private String defaultSessionId;
    private String errorContentReplayText;
    private int llm;
    private long networkToastDelayMs;
    private boolean newSession;
    private long offlineSendTimeoutMs;
    private long postAckTimeoutMs;
    private long reconnectSettledStallTimeoutMs;
    private long retryHistoryPullTimeoutMs;
    private String secretKey;
    private long sendTimeoutMs;
    private long sendingDotsDelayMs;
    private long silentUploadWaitMs;
    private boolean stream;
    private long streamStallTimeoutMs;
    private long timeoutSeconds;

    public SessionConfig() {
        this(null, null, 0, 0L, 0L, false, null, false, null, null, null, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 2097151, null);
    }

    public final void A(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.defaultSessionId = str;
    }

    public final void C(boolean z10) {
        this.newSession = z10;
    }

    public final void D(boolean z10) {
        this.stream = z10;
    }

    public final boolean E() {
        return C1963x.INSTANCE.a(this.agentType);
    }

    public final String a(String finishReason) {
        if (finishReason == null || kotlin.jvm.internal.p.d(finishReason, "")) {
            return null;
        }
        return kotlin.jvm.internal.p.d(finishReason, "content_filter") ? this.contentFilterReplyText : kotlin.jvm.internal.p.d(Build.TYPE, "userdebug") ? finishReason : this.errorContentReplayText;
    }

    public final String b(String rawMessage) {
        if (rawMessage == null) {
            rawMessage = "";
        }
        if (kotlin.jvm.internal.p.d(Build.TYPE, "userdebug")) {
            return rawMessage;
        }
        if (La.H.x0(rawMessage)) {
            return "";
        }
        for (int i10 = 0; i10 < rawMessage.length(); i10++) {
            char cCharAt = rawMessage.charAt(i10);
            if (19968 <= cCharAt && cCharAt < 40960) {
                return rawMessage;
            }
        }
        return this.errorContentReplayText;
    }

    /* renamed from: c, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: d, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: e, reason: from getter */
    public final long getCotCollapseDelayMs() {
        return this.cotCollapseDelayMs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionConfig)) {
            return false;
        }
        SessionConfig sessionConfig = (SessionConfig) other;
        return kotlin.jvm.internal.p.d(this.agentId, sessionConfig.agentId) && kotlin.jvm.internal.p.d(this.secretKey, sessionConfig.secretKey) && this.llm == sessionConfig.llm && this.timeoutSeconds == sessionConfig.timeoutSeconds && this.silentUploadWaitMs == sessionConfig.silentUploadWaitMs && this.stream == sessionConfig.stream && kotlin.jvm.internal.p.d(this.defaultSessionId, sessionConfig.defaultSessionId) && this.newSession == sessionConfig.newSession && kotlin.jvm.internal.p.d(this.defaultQuestion, sessionConfig.defaultQuestion) && kotlin.jvm.internal.p.d(this.contentFilterReplyText, sessionConfig.contentFilterReplyText) && kotlin.jvm.internal.p.d(this.errorContentReplayText, sessionConfig.errorContentReplayText) && kotlin.jvm.internal.p.d(this.agentType, sessionConfig.agentType) && this.sendTimeoutMs == sessionConfig.sendTimeoutMs && this.offlineSendTimeoutMs == sessionConfig.offlineSendTimeoutMs && this.postAckTimeoutMs == sessionConfig.postAckTimeoutMs && this.streamStallTimeoutMs == sessionConfig.streamStallTimeoutMs && this.reconnectSettledStallTimeoutMs == sessionConfig.reconnectSettledStallTimeoutMs && this.networkToastDelayMs == sessionConfig.networkToastDelayMs && this.cotCollapseDelayMs == sessionConfig.cotCollapseDelayMs && this.sendingDotsDelayMs == sessionConfig.sendingDotsDelayMs && this.retryHistoryPullTimeoutMs == sessionConfig.retryHistoryPullTimeoutMs;
    }

    /* renamed from: f, reason: from getter */
    public final String getDefaultQuestion() {
        return this.defaultQuestion;
    }

    /* renamed from: g, reason: from getter */
    public final String getDefaultSessionId() {
        return this.defaultSessionId;
    }

    /* renamed from: h, reason: from getter */
    public final long getNetworkToastDelayMs() {
        return this.networkToastDelayMs;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.agentId.hashCode() * 31) + this.secretKey.hashCode()) * 31) + Integer.hashCode(this.llm)) * 31) + Long.hashCode(this.timeoutSeconds)) * 31) + Long.hashCode(this.silentUploadWaitMs)) * 31) + Boolean.hashCode(this.stream)) * 31) + this.defaultSessionId.hashCode()) * 31) + Boolean.hashCode(this.newSession)) * 31;
        String str = this.defaultQuestion;
        return ((((((((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.contentFilterReplyText.hashCode()) * 31) + this.errorContentReplayText.hashCode()) * 31) + this.agentType.hashCode()) * 31) + Long.hashCode(this.sendTimeoutMs)) * 31) + Long.hashCode(this.offlineSendTimeoutMs)) * 31) + Long.hashCode(this.postAckTimeoutMs)) * 31) + Long.hashCode(this.streamStallTimeoutMs)) * 31) + Long.hashCode(this.reconnectSettledStallTimeoutMs)) * 31) + Long.hashCode(this.networkToastDelayMs)) * 31) + Long.hashCode(this.cotCollapseDelayMs)) * 31) + Long.hashCode(this.sendingDotsDelayMs)) * 31) + Long.hashCode(this.retryHistoryPullTimeoutMs);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getNewSession() {
        return this.newSession;
    }

    /* renamed from: j, reason: from getter */
    public final long getOfflineSendTimeoutMs() {
        return this.offlineSendTimeoutMs;
    }

    /* renamed from: k, reason: from getter */
    public final long getPostAckTimeoutMs() {
        return this.postAckTimeoutMs;
    }

    /* renamed from: l, reason: from getter */
    public final long getReconnectSettledStallTimeoutMs() {
        return this.reconnectSettledStallTimeoutMs;
    }

    /* renamed from: m, reason: from getter */
    public final long getRetryHistoryPullTimeoutMs() {
        return this.retryHistoryPullTimeoutMs;
    }

    /* renamed from: n, reason: from getter */
    public final String getSecretKey() {
        return this.secretKey;
    }

    /* renamed from: q, reason: from getter */
    public final long getSendTimeoutMs() {
        return this.sendTimeoutMs;
    }

    /* renamed from: s, reason: from getter */
    public final long getSendingDotsDelayMs() {
        return this.sendingDotsDelayMs;
    }

    /* renamed from: t, reason: from getter */
    public final long getSilentUploadWaitMs() {
        return this.silentUploadWaitMs;
    }

    public String toString() {
        return "SessionConfig(agentId=" + this.agentId + ", secretKey=" + this.secretKey + ", llm=" + this.llm + ", timeoutSeconds=" + this.timeoutSeconds + ", silentUploadWaitMs=" + this.silentUploadWaitMs + ", stream=" + this.stream + ", defaultSessionId=" + this.defaultSessionId + ", newSession=" + this.newSession + ", defaultQuestion=" + this.defaultQuestion + ", contentFilterReplyText=" + this.contentFilterReplyText + ", errorContentReplayText=" + this.errorContentReplayText + ", agentType=" + this.agentType + ", sendTimeoutMs=" + this.sendTimeoutMs + ", offlineSendTimeoutMs=" + this.offlineSendTimeoutMs + ", postAckTimeoutMs=" + this.postAckTimeoutMs + ", streamStallTimeoutMs=" + this.streamStallTimeoutMs + ", reconnectSettledStallTimeoutMs=" + this.reconnectSettledStallTimeoutMs + ", networkToastDelayMs=" + this.networkToastDelayMs + ", cotCollapseDelayMs=" + this.cotCollapseDelayMs + ", sendingDotsDelayMs=" + this.sendingDotsDelayMs + ", retryHistoryPullTimeoutMs=" + this.retryHistoryPullTimeoutMs + ")";
    }

    /* renamed from: u, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    /* renamed from: v, reason: from getter */
    public final long getStreamStallTimeoutMs() {
        return this.streamStallTimeoutMs;
    }

    public final void w(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.agentId = str;
    }

    public final void x(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.agentType = str;
    }

    public final void y(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.contentFilterReplyText = str;
    }

    public final void z(String str) {
        this.defaultQuestion = str;
    }

    public SessionConfig(String agentId, String secretKey, int i10, long j10, long j11, boolean z10, String defaultSessionId, boolean z11, String str, String contentFilterReplyText, String errorContentReplayText, String agentType, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(secretKey, "secretKey");
        kotlin.jvm.internal.p.i(defaultSessionId, "defaultSessionId");
        kotlin.jvm.internal.p.i(contentFilterReplyText, "contentFilterReplyText");
        kotlin.jvm.internal.p.i(errorContentReplayText, "errorContentReplayText");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        this.agentId = agentId;
        this.secretKey = secretKey;
        this.llm = i10;
        this.timeoutSeconds = j10;
        this.silentUploadWaitMs = j11;
        this.stream = z10;
        this.defaultSessionId = defaultSessionId;
        this.newSession = z11;
        this.defaultQuestion = str;
        this.contentFilterReplyText = contentFilterReplyText;
        this.errorContentReplayText = errorContentReplayText;
        this.agentType = agentType;
        this.sendTimeoutMs = j12;
        this.offlineSendTimeoutMs = j13;
        this.postAckTimeoutMs = j14;
        this.streamStallTimeoutMs = j15;
        this.reconnectSettledStallTimeoutMs = j16;
        this.networkToastDelayMs = j17;
        this.cotCollapseDelayMs = j18;
        this.sendingDotsDelayMs = j19;
        this.retryHistoryPullTimeoutMs = j20;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SessionConfig(String str, String str2, int i10, long j10, long j11, boolean z10, String str3, boolean z11, String str4, String str5, String str6, String str7, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, int i11, kotlin.jvm.internal.i iVar) {
        String strB;
        String strD;
        String str8 = (i11 & 1) != 0 ? "" : str;
        String str9 = (i11 & 2) != 0 ? "sat_5n8vHo96TRLBdygUqZnwCjLc33jd9LxkY2sZSq5FwxvBUiVVTISaOkoO1DjvEr9d" : str2;
        int i12 = (i11 & 4) != 0 ? 1 : i10;
        long j21 = (i11 & 8) != 0 ? 30L : j10;
        long j22 = (i11 & 16) != 0 ? 30000L : j11;
        boolean z12 = (i11 & 32) != 0 ? false : z10;
        String str10 = (i11 & 64) == 0 ? str3 : "";
        boolean z13 = (i11 & 128) == 0 ? z11 : false;
        String str11 = (i11 & 256) != 0 ? null : str4;
        if ((i11 & 512) != 0) {
            strB = com.stepos.agentframework.chatcore.audit.k.INSTANCE.b();
            if (strB.length() == 0) {
                strB = "抱歉，这个问题我暂时无法回答你，换个话题聊聊吧~";
            }
        } else {
            strB = str5;
        }
        if ((i11 & 1024) != 0) {
            strD = com.stepos.agentframework.chatcore.audit.k.INSTANCE.d();
            if (strD.length() == 0) {
                strD = "暂时无法生成回答，可重新发送";
            }
        } else {
            strD = str6;
        }
        this(str8, str9, i12, j21, j22, z12, str10, z13, str11, strB, strD, (i11 & 2048) != 0 ? "remote" : str7, (i11 & 4096) != 0 ? 120000L : j12, (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 5000L : j13, (i11 & 16384) != 0 ? 180000L : j14, (32768 & i11) != 0 ? 180000L : j15, (65536 & i11) != 0 ? 30000L : j16, (131072 & i11) != 0 ? 10000L : j17, (262144 & i11) != 0 ? 3000L : j18, (524288 & i11) == 0 ? j19 : 10000L, (i11 & 1048576) != 0 ? 180000L : j20);
    }
}
