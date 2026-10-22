package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusEnvelope;", "", "status", "", "message", "", "data", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusEnvelope;", "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CaocaoCredentialStatusEnvelope {

    @SerializedName("data")
    private final CaocaoCredentialStatusData data;

    @SerializedName("msg")
    private final String message;

    @SerializedName("status")
    private final Integer status;

    public CaocaoCredentialStatusEnvelope() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CaocaoCredentialStatusEnvelope copy$default(CaocaoCredentialStatusEnvelope caocaoCredentialStatusEnvelope, Integer num, String str, CaocaoCredentialStatusData caocaoCredentialStatusData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = caocaoCredentialStatusEnvelope.status;
        }
        if ((i10 & 2) != 0) {
            str = caocaoCredentialStatusEnvelope.message;
        }
        if ((i10 & 4) != 0) {
            caocaoCredentialStatusData = caocaoCredentialStatusEnvelope.data;
        }
        return caocaoCredentialStatusEnvelope.copy(num, str, caocaoCredentialStatusData);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final CaocaoCredentialStatusData getData() {
        return this.data;
    }

    public final CaocaoCredentialStatusEnvelope copy(Integer status, String message, CaocaoCredentialStatusData data) {
        return new CaocaoCredentialStatusEnvelope(status, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaocaoCredentialStatusEnvelope)) {
            return false;
        }
        CaocaoCredentialStatusEnvelope caocaoCredentialStatusEnvelope = (CaocaoCredentialStatusEnvelope) other;
        return p.d(this.status, caocaoCredentialStatusEnvelope.status) && p.d(this.message, caocaoCredentialStatusEnvelope.message) && p.d(this.data, caocaoCredentialStatusEnvelope.data);
    }

    public final CaocaoCredentialStatusData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        Integer num = this.status;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        CaocaoCredentialStatusData caocaoCredentialStatusData = this.data;
        return iHashCode2 + (caocaoCredentialStatusData != null ? caocaoCredentialStatusData.hashCode() : 0);
    }

    public String toString() {
        return "CaocaoCredentialStatusEnvelope(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public CaocaoCredentialStatusEnvelope(Integer num, String str, CaocaoCredentialStatusData caocaoCredentialStatusData) {
        this.status = num;
        this.message = str;
        this.data = caocaoCredentialStatusData;
    }

    public /* synthetic */ CaocaoCredentialStatusEnvelope(Integer num, String str, CaocaoCredentialStatusData caocaoCredentialStatusData, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : caocaoCredentialStatusData);
    }
}
