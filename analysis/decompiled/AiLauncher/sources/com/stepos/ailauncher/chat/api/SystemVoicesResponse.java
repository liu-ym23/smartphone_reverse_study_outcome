package com.stepos.ailauncher.chat.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SystemVoicesResponse;", "", "success", "", "message", "", "voices", "", "voicesDetails", "", "Lcom/stepos/ailauncher/chat/api/VoiceDetail;", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getVoices", "()Ljava/util/List;", "getVoicesDetails", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SystemVoicesResponse {
    private final String message;
    private final boolean success;
    private final List<String> voices;

    @SerializedName("voices-details")
    private final Map<String, VoiceDetail> voicesDetails;

    public SystemVoicesResponse() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SystemVoicesResponse copy$default(SystemVoicesResponse systemVoicesResponse, boolean z10, String str, List list, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = systemVoicesResponse.success;
        }
        if ((i10 & 2) != 0) {
            str = systemVoicesResponse.message;
        }
        if ((i10 & 4) != 0) {
            list = systemVoicesResponse.voices;
        }
        if ((i10 & 8) != 0) {
            map = systemVoicesResponse.voicesDetails;
        }
        return systemVoicesResponse.copy(z10, str, list, map);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<String> component3() {
        return this.voices;
    }

    public final Map<String, VoiceDetail> component4() {
        return this.voicesDetails;
    }

    public final SystemVoicesResponse copy(boolean success, String message, List<String> voices, Map<String, VoiceDetail> voicesDetails) {
        return new SystemVoicesResponse(success, message, voices, voicesDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SystemVoicesResponse)) {
            return false;
        }
        SystemVoicesResponse systemVoicesResponse = (SystemVoicesResponse) other;
        return this.success == systemVoicesResponse.success && p.d(this.message, systemVoicesResponse.message) && p.d(this.voices, systemVoicesResponse.voices) && p.d(this.voicesDetails, systemVoicesResponse.voicesDetails);
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final List<String> getVoices() {
        return this.voices;
    }

    public final Map<String, VoiceDetail> getVoicesDetails() {
        return this.voicesDetails;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.voices;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, VoiceDetail> map = this.voicesDetails;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SystemVoicesResponse(success=" + this.success + ", message=" + this.message + ", voices=" + this.voices + ", voicesDetails=" + this.voicesDetails + ")";
    }

    public SystemVoicesResponse(boolean z10, String str, List<String> list, Map<String, VoiceDetail> map) {
        this.success = z10;
        this.message = str;
        this.voices = list;
        this.voicesDetails = map;
    }

    public /* synthetic */ SystemVoicesResponse(boolean z10, String str, List list, Map map, int i10, i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : list, (i10 & 8) != 0 ? null : map);
    }
}
