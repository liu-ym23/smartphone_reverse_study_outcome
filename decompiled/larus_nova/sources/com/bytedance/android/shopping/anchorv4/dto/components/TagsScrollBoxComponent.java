package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n¢\u0006\u0002\u0010\u0014J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nHÆ\u0003J\u008b\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nHÆ\u0001J\u0013\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0007HÖ\u0001J\t\u0010:\u001a\u00020\u0010HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "Ljava/io/Serializable;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "space", "", "leftSpace", "buttonList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "scrollable", "", "alignStrategy", "statusId", "", "states", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;IILjava/util/List;ZILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "setAction", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;)V", "getAlignStrategy", "()I", "setAlignStrategy", "(I)V", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getLeftSpace", "getScrollable", "()Z", "getShowEvent", "getSpace", "getStates", "getStatusId", "()Ljava/lang/String;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagsScrollBoxComponent implements Serializable {

    @SerializedName("action")
    private Action action;

    @SerializedName("align_strategy")
    private int alignStrategy;

    @SerializedName("background")
    private final Background background;

    @SerializedName("button_list")
    private List<TextWithOneIconElement> buttonList;

    @SerializedName("left_space")
    private final int leftSpace;

    @SerializedName("scrollable")
    private final boolean scrollable;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f166524space;

    @SerializedName("states")
    private final List<TagsScrollBoxComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    public TagsScrollBoxComponent() {
        this(null, null, 0, 0, null, false, 0, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagsScrollBoxComponent copy$default(TagsScrollBoxComponent r110, Background r111, Action r112, int r113, int r114, List r115, boolean r116, int r117, String r118, List r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Background r100 = r110.background;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Action r101 = r110.action;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = r110.f166524space;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.leftSpace;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r104 = r110.buttonList;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.scrollable;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.alignStrategy;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.statusId;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r119 = r110.states;
    L39:
        if ((r212 & 512) == 0) goto L41;
        List r108 = r110.showEvent;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    public final Background component1() {
        return this.background;
    }

    public final List<ShowEvent> component10() {
        return this.showEvent;
    }

    public final Action component2() {
        return this.action;
    }

    public final int component3() {
        return this.f166524space;
    }

    public final int component4() {
        return this.leftSpace;
    }

    public final List<TextWithOneIconElement> component5() {
        return this.buttonList;
    }

    public final boolean component6() {
        return this.scrollable;
    }

    public final int component7() {
        return this.alignStrategy;
    }

    public final String component8() {
        return this.statusId;
    }

    public final List<TagsScrollBoxComponent> component9() {
        return this.states;
    }

    public final TagsScrollBoxComponent copy(Background r110, Action r111, int r112, int r113, List<TextWithOneIconElement> r114, boolean r115, int r116, String r210, List<TagsScrollBoxComponent> r211, List<ShowEvent> r212) {
        return new TagsScrollBoxComponent(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TagsScrollBoxComponent) == false) goto L26;
        TagsScrollBoxComponent r101 = (TagsScrollBoxComponent) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L10;
        return false;
    L10:
        if (this.f166524space == r101.f166524space) goto L12;
        return false;
    L12:
        if (this.leftSpace == r101.leftSpace) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buttonList, r101.buttonList) == true) goto L16;
        return false;
    L16:
        if (this.scrollable == r101.scrollable) goto L18;
        return false;
    L18:
        if (this.alignStrategy == r101.alignStrategy) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        Background r100 = this.background;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Action r104 = this.action;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f166524space) * 31) + this.leftSpace) * 31;
        List<TextWithOneIconElement> r107 = this.buttonList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.scrollable;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (((r109 + r111) * 31) + this.alignStrategy) * 31;
        String r113 = this.statusId;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        List<TagsScrollBoxComponent> r116 = this.states;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        List<ShowEvent> r119 = this.showEvent;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
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
        return "TagsScrollBoxComponent(background=" + this.background + ", action=" + this.action + ", space=" + this.f166524space + ", leftSpace=" + this.leftSpace + ", buttonList=" + this.buttonList + ", scrollable=" + this.scrollable + ", alignStrategy=" + this.alignStrategy + ", statusId=" + this.statusId + ", states=" + this.states + ", showEvent=" + this.showEvent + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final List<TextWithOneIconElement> getButtonList() {
        return this.buttonList;
    }

    public final int getLeftSpace() {
        return this.leftSpace;
    }

    public final boolean getScrollable() {
        return this.scrollable;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final int getSpace() {
        return this.f166524space;
    }

    public final List<TagsScrollBoxComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final void setAction(Action r100) {
        this.action = r100;
    }

    public final void setAlignStrategy(int r100) {
        this.alignStrategy = r100;
    }

    public final void setButtonList(List<TextWithOneIconElement> r100) {
        this.buttonList = r100;
    }

    public TagsScrollBoxComponent(Background r100, Action r101, int r102, int r103, List<TextWithOneIconElement> r104, boolean r105, int r106, String r107, List<TagsScrollBoxComponent> r108, List<ShowEvent> r110) {
        this.background = r100;
        this.action = r101;
        this.f166524space = r102;
        this.leftSpace = r103;
        this.buttonList = r104;
        this.scrollable = r105;
        this.alignStrategy = r106;
        this.statusId = r107;
        this.states = r108;
        this.showEvent = r110;
    }

    public /* synthetic */ TagsScrollBoxComponent(Background r110, Action r111, int r112, int r113, List r114, boolean r115, int r116, String r117, List r210, List r211, int r212, DefaultConstructorMarker r213) {
        List r100 = null;
        if ((r212 & 1) == 0) goto L5;
        Background r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Action r102 = null;
    L10:
        int r103 = 0;
        if ((r212 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r212 & 64) != 0) goto L31;
        r103 = r116;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r104, r105, r106, r107, r103, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L25:
        r107 = r115;
        goto L27
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
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
