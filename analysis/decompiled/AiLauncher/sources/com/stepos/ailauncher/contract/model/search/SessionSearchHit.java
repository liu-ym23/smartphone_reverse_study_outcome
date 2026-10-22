package com.stepos.ailauncher.contract.model.search;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "", "sessionId", "", "agentId", "deviceId", "title", "snippet", "matchedField", "Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;", "updatedAt", "", "agentLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;JLjava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getAgentId", "getDeviceId", "getTitle", "getSnippet", "getMatchedField", "()Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;", "getUpdatedAt", "()J", "getAgentLabel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SessionSearchHit {
    private final String agentId;
    private final String agentLabel;
    private final String deviceId;
    private final SearchMatchedField matchedField;
    private final String sessionId;
    private final String snippet;
    private final String title;
    private final long updatedAt;

    public SessionSearchHit(String sessionId, String agentId, String deviceId, String title, String snippet, SearchMatchedField matchedField, long j10, String agentLabel) {
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(snippet, "snippet");
        p.i(matchedField, "matchedField");
        p.i(agentLabel, "agentLabel");
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.title = title;
        this.snippet = snippet;
        this.matchedField = matchedField;
        this.updatedAt = j10;
        this.agentLabel = agentLabel;
    }

    public static /* synthetic */ SessionSearchHit copy$default(SessionSearchHit sessionSearchHit, String str, String str2, String str3, String str4, String str5, SearchMatchedField searchMatchedField, long j10, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sessionSearchHit.sessionId;
        }
        if ((i10 & 2) != 0) {
            str2 = sessionSearchHit.agentId;
        }
        if ((i10 & 4) != 0) {
            str3 = sessionSearchHit.deviceId;
        }
        if ((i10 & 8) != 0) {
            str4 = sessionSearchHit.title;
        }
        if ((i10 & 16) != 0) {
            str5 = sessionSearchHit.snippet;
        }
        if ((i10 & 32) != 0) {
            searchMatchedField = sessionSearchHit.matchedField;
        }
        if ((i10 & 64) != 0) {
            j10 = sessionSearchHit.updatedAt;
        }
        if ((i10 & 128) != 0) {
            str6 = sessionSearchHit.agentLabel;
        }
        String str7 = str6;
        long j11 = j10;
        String str8 = str5;
        SearchMatchedField searchMatchedField2 = searchMatchedField;
        return sessionSearchHit.copy(str, str2, str3, str4, str8, searchMatchedField2, j11, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSnippet() {
        return this.snippet;
    }

    /* renamed from: component6, reason: from getter */
    public final SearchMatchedField getMatchedField() {
        return this.matchedField;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAgentLabel() {
        return this.agentLabel;
    }

    public final SessionSearchHit copy(String sessionId, String agentId, String deviceId, String title, String snippet, SearchMatchedField matchedField, long updatedAt, String agentLabel) {
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(snippet, "snippet");
        p.i(matchedField, "matchedField");
        p.i(agentLabel, "agentLabel");
        return new SessionSearchHit(sessionId, agentId, deviceId, title, snippet, matchedField, updatedAt, agentLabel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionSearchHit)) {
            return false;
        }
        SessionSearchHit sessionSearchHit = (SessionSearchHit) other;
        return p.d(this.sessionId, sessionSearchHit.sessionId) && p.d(this.agentId, sessionSearchHit.agentId) && p.d(this.deviceId, sessionSearchHit.deviceId) && p.d(this.title, sessionSearchHit.title) && p.d(this.snippet, sessionSearchHit.snippet) && this.matchedField == sessionSearchHit.matchedField && this.updatedAt == sessionSearchHit.updatedAt && p.d(this.agentLabel, sessionSearchHit.agentLabel);
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentLabel() {
        return this.agentLabel;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final SearchMatchedField getMatchedField() {
        return this.matchedField;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((this.sessionId.hashCode() * 31) + this.agentId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.snippet.hashCode()) * 31) + this.matchedField.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31) + this.agentLabel.hashCode();
    }

    public String toString() {
        return "SessionSearchHit(sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", title=" + this.title + ", snippet=" + this.snippet + ", matchedField=" + this.matchedField + ", updatedAt=" + this.updatedAt + ", agentLabel=" + this.agentLabel + ")";
    }

    public /* synthetic */ SessionSearchHit(String str, String str2, String str3, String str4, String str5, SearchMatchedField searchMatchedField, long j10, String str6, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, str4, (i10 & 16) != 0 ? "" : str5, searchMatchedField, j10, (i10 & 128) != 0 ? "" : str6);
    }
}
