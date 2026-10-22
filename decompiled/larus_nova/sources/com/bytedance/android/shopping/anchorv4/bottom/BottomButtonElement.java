package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0096\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*¨\u0006?"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElement;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "mainTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "subTitle", "weight", "", "statusId", "", "states", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "displayAsCountDown", "", "countDownTemplate", "clickMaskColor", "intervalTime", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getClickMaskColor", "()Ljava/lang/String;", "getCountDownTemplate", "getDisplayAsCountDown", "()Z", "getIntervalTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMainTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getStates", "()Ljava/util/List;", "getStatusId", "getSubTitle", "getWeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonElement;", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonElement implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("background")
    private final Background background;

    @SerializedName("click_mask_color")
    private final String clickMaskColor;

    @SerializedName("count_down_template")
    private final String countDownTemplate;

    @SerializedName("display_as_count_down")
    private final boolean displayAsCountDown;

    @SerializedName("interval_time")
    private final Long intervalTime;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    private final TextWithOneIconElement mainTitle;

    @SerializedName("states")
    private final List<TextElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final TextWithOneIconElement subTitle;

    @SerializedName("weight")
    private final Float weight;

    public BottomButtonElement() {
        this(null, null, null, null, null, null, null, false, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BottomButtonElement copy$default(BottomButtonElement r110, Action r111, Background r112, TextWithOneIconElement r113, TextWithOneIconElement r114, Float r115, String r116, List r117, boolean r210, String r211, String r212, Long r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Background r101 = r110.background;
    L11:
        if ((r214 & 4) == 0) goto L13;
        TextWithOneIconElement r102 = r110.mainTitle;
    L15:
        if ((r214 & 8) == 0) goto L17;
        TextWithOneIconElement r103 = r110.subTitle;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Float r104 = r110.weight;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.statusId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r106 = r110.states;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r107 = r110.displayAsCountDown;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.countDownTemplate;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.clickMaskColor;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Long r108 = r110.intervalTime;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final Action component1() {
        return this.action;
    }

    public final String component10() {
        return this.clickMaskColor;
    }

    public final Long component11() {
        return this.intervalTime;
    }

    public final Background component2() {
        return this.background;
    }

    public final TextWithOneIconElement component3() {
        return this.mainTitle;
    }

    public final TextWithOneIconElement component4() {
        return this.subTitle;
    }

    public final Float component5() {
        return this.weight;
    }

    public final String component6() {
        return this.statusId;
    }

    public final List<TextElement> component7() {
        return this.states;
    }

    public final boolean component8() {
        return this.displayAsCountDown;
    }

    public final String component9() {
        return this.countDownTemplate;
    }

    public final BottomButtonElement copy(Action r110, Background r111, TextWithOneIconElement r112, TextWithOneIconElement r113, Float r114, String r115, List<TextElement> r210, boolean r211, String r212, String r213, Long r214) {
        return new BottomButtonElement(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BottomButtonElement) == false) goto L28;
        BottomButtonElement r101 = (BottomButtonElement) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.weight, r101.weight) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L20;
        return false;
    L20:
        if (this.displayAsCountDown == r101.displayAsCountDown) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.countDownTemplate, r101.countDownTemplate) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clickMaskColor, r101.clickMaskColor) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.intervalTime, r101.intervalTime) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v36 */
    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Background r104 = this.background;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextWithOneIconElement r107 = this.mainTitle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextWithOneIconElement r110 = this.subTitle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.weight;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.statusId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<TextElement> r119 = this.states;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.displayAsCountDown;
        ?? r123 = r122;
        if (r122 == false) goto L33;
        r123 = 1;
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.countDownTemplate;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.clickMaskColor;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.intervalTime;
        if (r131 == null) goto L45;
        r101 = r131.hashCode();
    L45:
        return r130 + r101;
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L29:
        r120 = 0;
        goto L30
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
        return "BottomButtonElement(action=" + this.action + ", background=" + this.background + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", weight=" + this.weight + ", statusId=" + this.statusId + ", states=" + this.states + ", displayAsCountDown=" + this.displayAsCountDown + ", countDownTemplate=" + this.countDownTemplate + ", clickMaskColor=" + this.clickMaskColor + ", intervalTime=" + this.intervalTime + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final String getClickMaskColor() {
        return this.clickMaskColor;
    }

    public final String getCountDownTemplate() {
        return this.countDownTemplate;
    }

    public final boolean getDisplayAsCountDown() {
        return this.displayAsCountDown;
    }

    public final Long getIntervalTime() {
        return this.intervalTime;
    }

    public final TextWithOneIconElement getMainTitle() {
        return this.mainTitle;
    }

    public final List<TextElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final TextWithOneIconElement getSubTitle() {
        return this.subTitle;
    }

    public final Float getWeight() {
        return this.weight;
    }

    public BottomButtonElement(Action r100, Background r101, TextWithOneIconElement r102, TextWithOneIconElement r103, Float r104, String r105, List<TextElement> r106, boolean r107, String r108, String r110, Long r111) {
        this.action = r100;
        this.background = r101;
        this.mainTitle = r102;
        this.subTitle = r103;
        this.weight = r104;
        this.statusId = r105;
        this.states = r106;
        this.displayAsCountDown = r107;
        this.countDownTemplate = r108;
        this.clickMaskColor = r110;
        this.intervalTime = r111;
    }

    public /* synthetic */ BottomButtonElement(Action r110, Background r111, TextWithOneIconElement r112, TextWithOneIconElement r113, Float r114, String r115, List r116, boolean r210, String r211, String r212, Long r213, int r214, DefaultConstructorMarker r215) {
        Long r100 = null;
        if ((r214 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Background r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        TextWithOneIconElement r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        TextWithOneIconElement r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Float r105 = Float.valueOf(1.0f);
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
}
