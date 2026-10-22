package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewResponse;", "", "code", "", "msg", "", "data", "Lcom/stepos/ailauncher/chat/api/SafetyReviewData;", "<init>", "(ILjava/lang/String;Lcom/stepos/ailauncher/chat/api/SafetyReviewData;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/stepos/ailauncher/chat/api/SafetyReviewData;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewResponse {
    private final int code;
    private final SafetyReviewData data;
    private final String msg;

    public SafetyReviewResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ SafetyReviewResponse copy$default(SafetyReviewResponse safetyReviewResponse, int i10, String str, SafetyReviewData safetyReviewData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = safetyReviewResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = safetyReviewResponse.msg;
        }
        if ((i11 & 4) != 0) {
            safetyReviewData = safetyReviewResponse.data;
        }
        return safetyReviewResponse.copy(i10, str, safetyReviewData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component3, reason: from getter */
    public final SafetyReviewData getData() {
        return this.data;
    }

    public final SafetyReviewResponse copy(int code, String msg, SafetyReviewData data) {
        return new SafetyReviewResponse(code, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewResponse)) {
            return false;
        }
        SafetyReviewResponse safetyReviewResponse = (SafetyReviewResponse) other;
        return this.code == safetyReviewResponse.code && p.d(this.msg, safetyReviewResponse.msg) && p.d(this.data, safetyReviewResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final SafetyReviewData getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        SafetyReviewData safetyReviewData = this.data;
        return iHashCode2 + (safetyReviewData != null ? safetyReviewData.hashCode() : 0);
    }

    public String toString() {
        return "SafetyReviewResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public SafetyReviewResponse(int i10, String str, SafetyReviewData safetyReviewData) {
        this.code = i10;
        this.msg = str;
        this.data = safetyReviewData;
    }

    public /* synthetic */ SafetyReviewResponse(int i10, String str, SafetyReviewData safetyReviewData, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : safetyReviewData);
    }
}
