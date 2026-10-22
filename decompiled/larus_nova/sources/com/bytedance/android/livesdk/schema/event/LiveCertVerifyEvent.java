package com.bytedance.android.livesdk.schema.event;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J[\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/schema/event/LiveCertVerifyEvent;", "", "errorCode", "", "errorMsg", "", "ticket", ControlRule.KEY_EXTRA_DATA, "Lorg/json/JSONObject;", "status", "Lcom/bytedance/android/livesdk/schema/event/LiveCertStatus;", "scene", "uniqueId", "(ILjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/android/livesdk/schema/event/LiveCertStatus;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getExtraData", "()Lorg/json/JSONObject;", "setExtraData", "(Lorg/json/JSONObject;)V", "getScene", "setScene", "getStatus", "()Lcom/bytedance/android/livesdk/schema/event/LiveCertStatus;", "setStatus", "(Lcom/bytedance/android/livesdk/schema/event/LiveCertStatus;)V", "getTicket", "setTicket", "getUniqueId", "setUniqueId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCertVerifyEvent {
    private int errorCode;
    private String errorMsg;
    private JSONObject extraData;
    private String scene;
    private LiveCertStatus status;
    private String ticket;
    private String uniqueId;

    public static /* synthetic */ LiveCertVerifyEvent copy$default(LiveCertVerifyEvent r100, int r101, String r102, String r103, JSONObject r104, LiveCertStatus r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.errorMsg;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.ticket;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.extraData;
    L14:
        JSONObject r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.status;
    L17:
        LiveCertStatus r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.scene;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.uniqueId;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final String component3() {
        return this.ticket;
    }

    public final JSONObject component4() {
        return this.extraData;
    }

    public final LiveCertStatus component5() {
        return this.status;
    }

    public final String component6() {
        return this.scene;
    }

    public final String component7() {
        return this.uniqueId;
    }

    public final LiveCertVerifyEvent copy(int r110, String r111, String r112, JSONObject r113, LiveCertStatus r114, String r115, String r116) {
        return new LiveCertVerifyEvent(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveCertVerifyEvent) == false) goto L20;
        LiveCertVerifyEvent r101 = (LiveCertVerifyEvent) r100;
        if (this.errorCode == r101.errorCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ticket, r101.ticket) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r100 = this.errorCode * 31;
        String r101 = this.errorMsg;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.ticket;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        JSONObject r108 = this.extraData;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        LiveCertStatus r111 = this.status;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.scene;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.uniqueId;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "LiveCertVerifyEvent(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", ticket=" + this.ticket + ", extraData=" + this.extraData + ", status=" + this.status + ", scene=" + this.scene + ", uniqueId=" + this.uniqueId + ")";
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final JSONObject getExtraData() {
        return this.extraData;
    }

    public final String getScene() {
        return this.scene;
    }

    public final LiveCertStatus getStatus() {
        return this.status;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public final void setExtraData(JSONObject r100) {
        this.extraData = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setStatus(LiveCertStatus r100) {
        this.status = r100;
    }

    public final void setTicket(String r100) {
        this.ticket = r100;
    }

    public final void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public LiveCertVerifyEvent(int r100, String r101, String r102, JSONObject r103, LiveCertStatus r104, String r105, String r106) {
        this.errorCode = r100;
        this.errorMsg = r101;
        this.ticket = r102;
        this.extraData = r103;
        this.status = r104;
        this.scene = r105;
        this.uniqueId = r106;
    }

    public /* synthetic */ LiveCertVerifyEvent(int r110, String r111, String r112, JSONObject r113, LiveCertStatus r114, String r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 16) == 0) goto L5;
        LiveCertStatus r100 = null;
    L7:
        if ((r117 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 64) == 0) goto L13;
        String r102 = null;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
