package com.bytedance.android.livehostapi.business.depend.dislike;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Je\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/dislike/RecommendToFriendsParams;", "", "anchorId", "", "roomId", "", "enterFromMerge", "enterMethod", "isFans", "requestId", "liveMode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "isFromPreview", "", "entranceName", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;ZLjava/lang/String;)V", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "getAnchorId", "getEnterFromMerge", "getEnterMethod", "getEntranceName", "isFromMorePanel", "()Z", "setFromMorePanel", "(Z)V", "getLiveMode", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getRequestId", "getRoomId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendToFriendsParams {
    private String actionType;
    private final String anchorId;
    private final String enterFromMerge;
    private final String enterMethod;
    private final String entranceName;
    private final String isFans;
    private boolean isFromMorePanel;
    private final boolean isFromPreview;
    private final LiveMode liveMode;
    private final String requestId;
    private final long roomId;

    public static /* synthetic */ RecommendToFriendsParams copy$default(RecommendToFriendsParams r110, String r111, long r112, String r113, String r114, String r115, String r116, LiveMode r117, boolean r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.anchorId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = r110.roomId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.enterFromMerge;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.enterMethod;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.isFans;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.requestId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        LiveMode r106 = r110.liveMode;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r118 = r110.isFromPreview;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r107 = r110.entranceName;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.anchorId;
    }

    public final long component2() {
        return this.roomId;
    }

    public final String component3() {
        return this.enterFromMerge;
    }

    public final String component4() {
        return this.enterMethod;
    }

    public final String component5() {
        return this.isFans;
    }

    public final String component6() {
        return this.requestId;
    }

    public final LiveMode component7() {
        return this.liveMode;
    }

    public final boolean component8() {
        return this.isFromPreview;
    }

    public final String component9() {
        return this.entranceName;
    }

    public final RecommendToFriendsParams copy(String r110, long r111, String r112, String r113, String r114, String r115, LiveMode r210, boolean r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "anchorId");
        Intrinsics.checkNotNullParameter(r112, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r113, "enterMethod");
        Intrinsics.checkNotNullParameter(r114, "isFans");
        Intrinsics.checkNotNullParameter(r115, "requestId");
        Intrinsics.checkNotNullParameter(r212, "entranceName");
        return new RecommendToFriendsParams(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RecommendToFriendsParams) == false) goto L24;
        RecommendToFriendsParams r101 = (RecommendToFriendsParams) r100;
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L8;
        return false;
    L8:
        if (this.roomId == r101.roomId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFromMerge, r101.enterFromMerge) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isFans, r101.isFans) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveMode, r101.liveMode) == true) goto L20;
        return false;
    L20:
        if (this.isFromPreview == r101.isFromPreview) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.entranceName, r101.entranceName) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v26 */
    public int hashCode() {
        String r100 = this.anchorId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.roomId;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.enterFromMerge;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.enterMethod;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.isFans;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.requestId;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        LiveMode r117 = this.liveMode;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.isFromPreview;
        ?? r121 = r120;
        if (r120 == false) goto L29;
        r121 = 1;
    L29:
        int r122 = (r119 + r121) * 31;
        String r123 = this.entranceName;
        if (r123 == null) goto L33;
        r101 = r123.hashCode();
    L33:
        return r122 + r101;
    L25:
        r118 = 0;
        goto L26
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
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RecommendToFriendsParams(anchorId=" + this.anchorId + ", roomId=" + this.roomId + ", enterFromMerge=" + this.enterFromMerge + ", enterMethod=" + this.enterMethod + ", isFans=" + this.isFans + ", requestId=" + this.requestId + ", liveMode=" + this.liveMode + ", isFromPreview=" + this.isFromPreview + ", entranceName=" + this.entranceName + ")";
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceName() {
        return this.entranceName;
    }

    public final LiveMode getLiveMode() {
        return this.liveMode;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String isFans() {
        return this.isFans;
    }

    public final boolean isFromMorePanel() {
        return this.isFromMorePanel;
    }

    public final boolean isFromPreview() {
        return this.isFromPreview;
    }

    public final void setActionType(String r100) {
        this.actionType = r100;
    }

    public final void setFromMorePanel(boolean r100) {
        this.isFromMorePanel = r100;
    }

    public RecommendToFriendsParams(String r100, long r101, String r102, String r103, String r104, String r105, LiveMode r106, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        Intrinsics.checkNotNullParameter(r102, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r103, "enterMethod");
        Intrinsics.checkNotNullParameter(r104, "isFans");
        Intrinsics.checkNotNullParameter(r105, "requestId");
        Intrinsics.checkNotNullParameter(r111, "entranceName");
        this.anchorId = r100;
        this.roomId = r101;
        this.enterFromMerge = r102;
        this.enterMethod = r103;
        this.isFans = r104;
        this.requestId = r105;
        this.liveMode = r106;
        this.isFromPreview = r110;
        this.entranceName = r111;
        this.actionType = "";
    }

    public /* synthetic */ RecommendToFriendsParams(String r110, long r111, String r112, String r113, String r114, String r210, LiveMode r211, boolean r212, String r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = "0";
    L7:
        if ((r214 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r214 & 256) == 0) goto L29;
        String r115 = "";
    L30:
        this(r100, r101, r102, r103, r104, r105, r211, r212, r115);
        return;
    L29:
        r115 = r213;
        goto L30
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
