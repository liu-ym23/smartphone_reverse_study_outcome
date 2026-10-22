package com.bytedance.android.livehostapi.business.depend.xplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JY\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/CloudGameState;", "", "initLogId", "", "codecType", "core", "roomId", "businessParams", "mergeStreamToken", "podRtcUserId", "isPodReconnect", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBusinessParams", "()Ljava/lang/String;", "setBusinessParams", "(Ljava/lang/String;)V", "getCodecType", "setCodecType", "getCore", "setCore", "getInitLogId", "()Z", "setPodReconnect", "(Z)V", "getMergeStreamToken", "setMergeStreamToken", "getPodRtcUserId", "setPodRtcUserId", "getRoomId", "setRoomId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CloudGameState {
    private String businessParams;
    private String codecType;
    private String core;
    private final String initLogId;
    private boolean isPodReconnect;
    private String mergeStreamToken;
    private String podRtcUserId;
    private String roomId;

    public static /* synthetic */ CloudGameState copy$default(CloudGameState r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.initLogId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.codecType;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.core;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.roomId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.businessParams;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.mergeStreamToken;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.podRtcUserId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.isPodReconnect;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.initLogId;
    }

    public final String component2() {
        return this.codecType;
    }

    public final String component3() {
        return this.core;
    }

    public final String component4() {
        return this.roomId;
    }

    public final String component5() {
        return this.businessParams;
    }

    public final String component6() {
        return this.mergeStreamToken;
    }

    public final String component7() {
        return this.podRtcUserId;
    }

    public final boolean component8() {
        return this.isPodReconnect;
    }

    public final CloudGameState copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "initLogId");
        Intrinsics.checkNotNullParameter(r111, "codecType");
        Intrinsics.checkNotNullParameter(r112, "core");
        Intrinsics.checkNotNullParameter(r113, "roomId");
        Intrinsics.checkNotNullParameter(r114, "businessParams");
        Intrinsics.checkNotNullParameter(r115, "mergeStreamToken");
        Intrinsics.checkNotNullParameter(r116, "podRtcUserId");
        return new CloudGameState(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CloudGameState) == false) goto L22;
        CloudGameState r101 = (CloudGameState) r100;
        if (Intrinsics.areEqual(this.initLogId, r101.initLogId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.codecType, r101.codecType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.core, r101.core) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.businessParams, r101.businessParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.mergeStreamToken, r101.mergeStreamToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.podRtcUserId, r101.podRtcUserId) == true) goto L20;
        return false;
    L20:
        if (this.isPodReconnect == r101.isPodReconnect) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.initLogId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.codecType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.core;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.roomId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.businessParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.mergeStreamToken;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.podRtcUserId;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        int r120 = (r118 + r101) * 31;
        boolean r121 = this.isPodReconnect;
        ?? r122 = r121;
        if (r121 == false) goto L33;
        r122 = 1;
    L33:
        return r120 + r122;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CloudGameState(initLogId=" + this.initLogId + ", codecType=" + this.codecType + ", core=" + this.core + ", roomId=" + this.roomId + ", businessParams=" + this.businessParams + ", mergeStreamToken=" + this.mergeStreamToken + ", podRtcUserId=" + this.podRtcUserId + ", isPodReconnect=" + this.isPodReconnect + ")";
    }

    public final String getBusinessParams() {
        return this.businessParams;
    }

    public final String getCodecType() {
        return this.codecType;
    }

    public final String getCore() {
        return this.core;
    }

    public final String getInitLogId() {
        return this.initLogId;
    }

    public final String getMergeStreamToken() {
        return this.mergeStreamToken;
    }

    public final String getPodRtcUserId() {
        return this.podRtcUserId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final boolean isPodReconnect() {
        return this.isPodReconnect;
    }

    public final void setBusinessParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.businessParams = r100;
    }

    public final void setCodecType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.codecType = r100;
    }

    public final void setCore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.core = r100;
    }

    public final void setMergeStreamToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mergeStreamToken = r100;
    }

    public final void setPodReconnect(boolean r100) {
        this.isPodReconnect = r100;
    }

    public final void setPodRtcUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.podRtcUserId = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public CloudGameState(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "initLogId");
        Intrinsics.checkNotNullParameter(r101, "codecType");
        Intrinsics.checkNotNullParameter(r102, "core");
        Intrinsics.checkNotNullParameter(r103, "roomId");
        Intrinsics.checkNotNullParameter(r104, "businessParams");
        Intrinsics.checkNotNullParameter(r105, "mergeStreamToken");
        Intrinsics.checkNotNullParameter(r106, "podRtcUserId");
        this.initLogId = r100;
        this.codecType = r101;
        this.core = r102;
        this.roomId = r103;
        this.businessParams = r104;
        this.mergeStreamToken = r105;
        this.podRtcUserId = r106;
        this.isPodReconnect = r107;
    }

    public /* synthetic */ CloudGameState(String r100, String r110, String r111, String r112, String r113, String r114, String r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        String r101 = "";
        if ((r117 & 2) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r117 & 4) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r117 & 8) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r117 & 16) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r117 & 32) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r117 & 64) != 0) goto L27;
        r101 = r115;
    L27:
        if ((r117 & 128) == 0) goto L29;
        boolean r107 = false;
    L30:
        this(r100, r102, r103, r104, r105, r106, r101, r107);
        return;
    L29:
        r107 = r116;
        goto L30
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
