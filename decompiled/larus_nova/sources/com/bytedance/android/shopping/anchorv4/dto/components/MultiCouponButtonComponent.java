package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.elements.CouponButtonElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\tHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\u007f\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiCouponButtonComponent;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "space", "", "leftSpace", "couponType", "buttonList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/CouponButtonElement;", "alignStrategy", "statusId", "", "states", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;IIILjava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getAlignStrategy", "()I", "getButtonList", "()Ljava/util/List;", "getCouponType", "getLeftSpace", "getShowEvent", "getSpace", "getStates", "getStatusId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCouponButtonComponent implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("align_strategy")
    private final int alignStrategy;

    @SerializedName("coupon_list")
    private final List<CouponButtonElement> buttonList;

    @SerializedName(a.KEY_COUPON_TYPE)
    private final int couponType;

    @SerializedName("left_space")
    private final int leftSpace;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f166522space;

    @SerializedName("states")
    private final List<MultiCouponButtonComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    public MultiCouponButtonComponent() {
        this(null, 0, 0, 0, null, 0, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiCouponButtonComponent copy$default(MultiCouponButtonComponent r110, Action r111, int r112, int r113, int r114, List r115, int r116, String r117, List r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.f166522space;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.leftSpace;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.couponType;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r104 = r110.buttonList;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.alignStrategy;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.statusId;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r107 = r110.states;
    L35:
        if ((r210 & 256) == 0) goto L37;
        List r108 = r110.showEvent;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
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

    public final int component2() {
        return this.f166522space;
    }

    public final int component3() {
        return this.leftSpace;
    }

    public final int component4() {
        return this.couponType;
    }

    public final List<CouponButtonElement> component5() {
        return this.buttonList;
    }

    public final int component6() {
        return this.alignStrategy;
    }

    public final String component7() {
        return this.statusId;
    }

    public final List<MultiCouponButtonComponent> component8() {
        return this.states;
    }

    public final List<ShowEvent> component9() {
        return this.showEvent;
    }

    public final MultiCouponButtonComponent copy(Action r110, int r111, int r112, int r113, List<CouponButtonElement> r114, int r115, String r116, List<MultiCouponButtonComponent> r117, List<ShowEvent> r210) {
        return new MultiCouponButtonComponent(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MultiCouponButtonComponent) == false) goto L24;
        MultiCouponButtonComponent r101 = (MultiCouponButtonComponent) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (this.f166522space == r101.f166522space) goto L10;
        return false;
    L10:
        if (this.leftSpace == r101.leftSpace) goto L12;
        return false;
    L12:
        if (this.couponType == r101.couponType) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buttonList, r101.buttonList) == true) goto L16;
        return false;
    L16:
        if (this.alignStrategy == r101.alignStrategy) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + this.f166522space) * 31) + this.leftSpace) * 31) + this.couponType) * 31;
        List<CouponButtonElement> r104 = this.buttonList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.alignStrategy) * 31;
        String r107 = this.statusId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<MultiCouponButtonComponent> r110 = this.states;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ShowEvent> r113 = this.showEvent;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "MultiCouponButtonComponent(action=" + this.action + ", space=" + this.f166522space + ", leftSpace=" + this.leftSpace + ", couponType=" + this.couponType + ", buttonList=" + this.buttonList + ", alignStrategy=" + this.alignStrategy + ", statusId=" + this.statusId + ", states=" + this.states + ", showEvent=" + this.showEvent + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final List<CouponButtonElement> getButtonList() {
        return this.buttonList;
    }

    public final int getCouponType() {
        return this.couponType;
    }

    public final int getLeftSpace() {
        return this.leftSpace;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final int getSpace() {
        return this.f166522space;
    }

    public final List<MultiCouponButtonComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public MultiCouponButtonComponent(Action r100, int r101, int r102, int r103, List<CouponButtonElement> r104, int r105, String r106, List<MultiCouponButtonComponent> r107, List<ShowEvent> r108) {
        this.action = r100;
        this.f166522space = r101;
        this.leftSpace = r102;
        this.couponType = r103;
        this.buttonList = r104;
        this.alignStrategy = r105;
        this.statusId = r106;
        this.states = r107;
        this.showEvent = r108;
    }

    public /* synthetic */ MultiCouponButtonComponent(Action r110, int r111, int r112, int r113, List r114, int r115, String r116, List r117, List r118, int r210, DefaultConstructorMarker r211) {
        List r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Action r101 = null;
    L6:
        int r102 = 0;
        if ((r210 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r210 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r210 & 32) != 0) goto L27;
        r102 = r115;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r103, r104, r105, r106, r102, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
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
        r101 = r110;
        goto L6
    }
}
