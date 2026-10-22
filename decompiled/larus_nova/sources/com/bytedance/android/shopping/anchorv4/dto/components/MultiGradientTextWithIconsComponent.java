package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bHÆ\u0003Ju\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiGradientTextWithIconsComponent;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "space", "", "leftSpace", "labelList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/GradientTextWithIconsComponent;", "alignStrategy", "statusId", "", "states", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;IILjava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getAlignStrategy", "()I", "getLabelList", "()Ljava/util/List;", "getLeftSpace", "getShowEvent", "getSpace", "getStates", "getStatusId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiGradientTextWithIconsComponent implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("align_strategy")
    private final int alignStrategy;

    @SerializedName("label_list")
    private final List<GradientTextWithIconsComponent> labelList;

    @SerializedName("left_space")
    private final int leftSpace;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f166523space;

    @SerializedName("states")
    private final List<MultiGradientTextWithIconsComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    public MultiGradientTextWithIconsComponent() {
        this(null, 0, 0, null, 0, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiGradientTextWithIconsComponent copy$default(MultiGradientTextWithIconsComponent r100, Action r110, int r111, int r112, List r113, int r114, String r115, List r116, List r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Action r101 = r100.action;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.f166523space;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.leftSpace;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.labelList;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.alignStrategy;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.statusId;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = r100.states;
    L31:
        if ((r118 & 128) == 0) goto L33;
        List r108 = r100.showEvent;
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

    public final Action component1() {
        return this.action;
    }

    public final int component2() {
        return this.f166523space;
    }

    public final int component3() {
        return this.leftSpace;
    }

    public final List<GradientTextWithIconsComponent> component4() {
        return this.labelList;
    }

    public final int component5() {
        return this.alignStrategy;
    }

    public final String component6() {
        return this.statusId;
    }

    public final List<MultiGradientTextWithIconsComponent> component7() {
        return this.states;
    }

    public final List<ShowEvent> component8() {
        return this.showEvent;
    }

    public final MultiGradientTextWithIconsComponent copy(Action r110, int r111, int r112, List<GradientTextWithIconsComponent> r113, int r114, String r115, List<MultiGradientTextWithIconsComponent> r116, List<ShowEvent> r117) {
        return new MultiGradientTextWithIconsComponent(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MultiGradientTextWithIconsComponent) == false) goto L22;
        MultiGradientTextWithIconsComponent r101 = (MultiGradientTextWithIconsComponent) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (this.f166523space == r101.f166523space) goto L10;
        return false;
    L10:
        if (this.leftSpace == r101.leftSpace) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.labelList, r101.labelList) == true) goto L14;
        return false;
    L14:
        if (this.alignStrategy == r101.alignStrategy) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f166523space) * 31) + this.leftSpace) * 31;
        List<GradientTextWithIconsComponent> r104 = this.labelList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.alignStrategy) * 31;
        String r107 = this.statusId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<MultiGradientTextWithIconsComponent> r110 = this.states;
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
        return "MultiGradientTextWithIconsComponent(action=" + this.action + ", space=" + this.f166523space + ", leftSpace=" + this.leftSpace + ", labelList=" + this.labelList + ", alignStrategy=" + this.alignStrategy + ", statusId=" + this.statusId + ", states=" + this.states + ", showEvent=" + this.showEvent + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final List<GradientTextWithIconsComponent> getLabelList() {
        return this.labelList;
    }

    public final int getLeftSpace() {
        return this.leftSpace;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final int getSpace() {
        return this.f166523space;
    }

    public final List<MultiGradientTextWithIconsComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public MultiGradientTextWithIconsComponent(Action r100, int r101, int r102, List<GradientTextWithIconsComponent> r103, int r104, String r105, List<MultiGradientTextWithIconsComponent> r106, List<ShowEvent> r107) {
        this.action = r100;
        this.f166523space = r101;
        this.leftSpace = r102;
        this.labelList = r103;
        this.alignStrategy = r104;
        this.statusId = r105;
        this.states = r106;
        this.showEvent = r107;
    }

    public /* synthetic */ MultiGradientTextWithIconsComponent(Action r110, int r111, int r112, List r113, int r114, String r115, List r116, List r117, int r118, DefaultConstructorMarker r119) {
        List r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Action r101 = null;
    L6:
        int r102 = 0;
        if ((r118 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r118 & 16) != 0) goto L23;
        r102 = r114;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r103, r104, r105, r102, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
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
