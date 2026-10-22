package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J4\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u000f\u001a\u00020\bHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashPermissionInfoResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "component2", "", "component3", "status", "popupInfo", "requestId", "copy", "(Ljava/lang/Integer;Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;Ljava/lang/String;)Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashPermissionInfoResponse;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getStatus", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "getPopupInfo", "()Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;Ljava/lang/String;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlashPermissionInfoResponse extends g implements Serializable {

    @SerializedName("popup_info")
    private final ECV2PopupInfo popupInfo;

    @SerializedName("log_id")
    private final String requestId;

    @SerializedName("status")
    private final Integer status;

    public ECFlashPermissionInfoResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ECFlashPermissionInfoResponse copy$default(ECFlashPermissionInfoResponse r100, Integer r101, ECV2PopupInfo r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.popupInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.requestId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.status;
    }

    public final ECV2PopupInfo component2() {
        return this.popupInfo;
    }

    public final String component3() {
        return this.requestId;
    }

    public final ECFlashPermissionInfoResponse copy(Integer r100, ECV2PopupInfo r101, String r102) {
        return new ECFlashPermissionInfoResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECFlashPermissionInfoResponse) == false) goto L12;
        ECFlashPermissionInfoResponse r101 = (ECFlashPermissionInfoResponse) r100;
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popupInfo, r101.popupInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.status;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECV2PopupInfo r104 = this.popupInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.requestId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECFlashPermissionInfoResponse(status=" + this.status + ", popupInfo=" + this.popupInfo + ", requestId=" + this.requestId + ")";
    }

    public final ECV2PopupInfo getPopupInfo() {
        return this.popupInfo;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public ECFlashPermissionInfoResponse(Integer r100, ECV2PopupInfo r101, String r102) {
        this.status = r100;
        this.popupInfo = r101;
        this.requestId = r102;
    }

    public /* synthetic */ ECFlashPermissionInfoResponse(Integer r100, ECV2PopupInfo r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
