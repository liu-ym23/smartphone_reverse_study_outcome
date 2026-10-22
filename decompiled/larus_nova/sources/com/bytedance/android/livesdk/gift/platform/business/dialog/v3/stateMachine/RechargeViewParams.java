package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J=\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RechargeViewParams;", "", "", "component1", "", "component2", "", "component3", "Lcom/bytedance/android/live/base/model/message/a5;", "component4", "", "component5", "text", "textColorRes", "textSize", "touchText", "enableAnchorPanelEntrance", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "I", "getTextColorRes", "()I", FaceService.girlLabel, "getTextSize", "()F", "Lcom/bytedance/android/live/base/model/message/a5;", "getTouchText", "()Lcom/bytedance/android/live/base/model/message/a5;", "Z", "getEnableAnchorPanelEntrance", "()Z", "<init>", "(Ljava/lang/String;IFLcom/bytedance/android/live/base/model/message/a5;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RechargeViewParams {
    private final boolean enableAnchorPanelEntrance;
    private final String text;
    private final int textColorRes;
    private final float textSize;
    private final a5 touchText;

    public RechargeViewParams() {
        this(null, 0, 0.0f, null, false, 31, null);
    }

    public static /* synthetic */ RechargeViewParams copy$default(RechargeViewParams r100, String r101, int r102, float r103, a5 r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.textColorRes;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.textSize;
    L11:
        float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.touchText;
    L14:
        a5 r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableAnchorPanelEntrance;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.textColorRes;
    }

    public final float component3() {
        return this.textSize;
    }

    public final a5 component4() {
        return this.touchText;
    }

    public final boolean component5() {
        return this.enableAnchorPanelEntrance;
    }

    public final RechargeViewParams copy(String r100, int r101, float r110, a5 r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return new RechargeViewParams(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RechargeViewParams) == false) goto L16;
        RechargeViewParams r101 = (RechargeViewParams) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (this.textColorRes == r101.textColorRes) goto L10;
        return false;
    L10:
        if (Float.compare(this.textSize, r101.textSize) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.touchText, r101.touchText) == true) goto L14;
        return false;
    L14:
        if (this.enableAnchorPanelEntrance == r101.enableAnchorPanelEntrance) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.textColorRes) * 31) + Float.floatToIntBits(this.textSize)) * 31;
        a5 r104 = this.touchText;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.enableAnchorPanelEntrance;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RechargeViewParams(text=" + this.text + ", textColorRes=" + this.textColorRes + ", textSize=" + this.textSize + ", touchText=" + this.touchText + ", enableAnchorPanelEntrance=" + this.enableAnchorPanelEntrance + ")";
    }

    public final boolean getEnableAnchorPanelEntrance() {
        return this.enableAnchorPanelEntrance;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final a5 getTouchText() {
        return this.touchText;
    }

    public RechargeViewParams(String r100, int r101, float r102, a5 r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.text = r100;
        this.textColorRes = r101;
        this.textSize = r102;
        this.touchText = r103;
        this.enableAnchorPanelEntrance = r104;
    }

    public /* synthetic */ RechargeViewParams(String r100, int r101, float r102, a5 r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r105 & 2) == 0) goto L8;
        int r111 = R.color.ttlive_gift_bottom_recharge_color;
    L10:
        if ((r105 & 4) == 0) goto L12;
        float r106 = 0.0f;
    L14:
        if ((r105 & 8) == 0) goto L16;
        r103 = null;
    L16:
        a5 r107 = r103;
        if ((r105 & 16) == 0) goto L19;
        boolean r108 = false;
    L20:
        this(r100, r111, r106, r107, r108);
        return;
    L19:
        r108 = r104;
        goto L20
    L12:
        r106 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
