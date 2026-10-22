package com.bytedance.android.shopping.anchorv4.dto;

import com.google.gson.annotations.SerializedName;
import e73.d;
import e73.g;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J{\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001J\t\u0010\u001e\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\u0013\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b&\u0010%R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b'\u0010%R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b(\u0010%R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b)\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010\u0017\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010/R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b0\u0010%R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u00103R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b4\u0010%R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b5\u0010%¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/Control;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "component5", "Le73/g;", "component6", "", "component7", "component8", "Le73/d;", "component9", "component10", "component11", "gulControl", "shopRecommendsControl", "detailControl", "searchWordsControl", "longConnectionEnabled", "popupWithClose", "pageSlideActionsOffset", "shouldOptimizeHalfContainerCloseInteraction", "chunkSplitDetail", "forbidCache", "enableHalfScreenTransitionAnimation", "copy", "", "toString", "hashCode", "", "other", "equals", "Z", "getGulControl", "()Z", "getShopRecommendsControl", "getDetailControl", "getSearchWordsControl", "getLongConnectionEnabled", "Le73/g;", "getPopupWithClose", "()Le73/g;", "I", "getPageSlideActionsOffset", "()I", "getShouldOptimizeHalfContainerCloseInteraction", "Le73/d;", "getChunkSplitDetail", "()Le73/d;", "getForbidCache", "getEnableHalfScreenTransitionAnimation", "<init>", "(ZZZZZLe73/g;IZLe73/d;ZZ)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Control implements Serializable {

    @SerializedName("chunk_split_detail")
    private final d chunkSplitDetail;

    @SerializedName("detail_control")
    private final boolean detailControl;

    @SerializedName("enable_half_screen_transition_animation")
    private final boolean enableHalfScreenTransitionAnimation;

    @SerializedName("forbid_cache")
    private final boolean forbidCache;

    @SerializedName("gul_control")
    private final boolean gulControl;

    @SerializedName("long_connection_enabled")
    private final boolean longConnectionEnabled;

    @SerializedName("page_slide_actions_offset")
    private final int pageSlideActionsOffset;

    @SerializedName("popup_when_close")
    private final g popupWithClose;

    @SerializedName("search_words_control")
    private final boolean searchWordsControl;

    @SerializedName("shop_recommends_control")
    private final boolean shopRecommendsControl;

    @SerializedName("should_optimize_half_container_close_interaction")
    private final boolean shouldOptimizeHalfContainerCloseInteraction;

    public Control() {
        this(false, false, false, false, false, null, 0, false, null, false, false, 2047, null);
    }

    public static /* synthetic */ Control copy$default(Control r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, g r116, int r117, boolean r210, d r211, boolean r212, boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        boolean r100 = r110.gulControl;
    L7:
        if ((r214 & 2) == 0) goto L9;
        boolean r101 = r110.shopRecommendsControl;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r102 = r110.detailControl;
    L15:
        if ((r214 & 8) == 0) goto L17;
        boolean r103 = r110.searchWordsControl;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r104 = r110.longConnectionEnabled;
    L23:
        if ((r214 & 32) == 0) goto L25;
        g r105 = r110.popupWithClose;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r106 = r110.pageSlideActionsOffset;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r107 = r110.shouldOptimizeHalfContainerCloseInteraction;
    L35:
        if ((r214 & 256) == 0) goto L37;
        d r118 = r110.chunkSplitDetail;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r119 = r110.forbidCache;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        boolean r108 = r110.enableHalfScreenTransitionAnimation;
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

    public final boolean component1() {
        return this.gulControl;
    }

    public final boolean component10() {
        return this.forbidCache;
    }

    public final boolean component11() {
        return this.enableHalfScreenTransitionAnimation;
    }

    public final boolean component2() {
        return this.shopRecommendsControl;
    }

    public final boolean component3() {
        return this.detailControl;
    }

    public final boolean component4() {
        return this.searchWordsControl;
    }

    public final boolean component5() {
        return this.longConnectionEnabled;
    }

    public final g component6() {
        return this.popupWithClose;
    }

    public final int component7() {
        return this.pageSlideActionsOffset;
    }

    public final boolean component8() {
        return this.shouldOptimizeHalfContainerCloseInteraction;
    }

    public final d component9() {
        return this.chunkSplitDetail;
    }

    public final Control copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, g r115, int r210, boolean r211, d r212, boolean r213, boolean r214) {
        return new Control(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Control) == false) goto L28;
        Control r101 = (Control) r100;
        if (this.gulControl == r101.gulControl) goto L8;
        return false;
    L8:
        if (this.shopRecommendsControl == r101.shopRecommendsControl) goto L10;
        return false;
    L10:
        if (this.detailControl == r101.detailControl) goto L12;
        return false;
    L12:
        if (this.searchWordsControl == r101.searchWordsControl) goto L14;
        return false;
    L14:
        if (this.longConnectionEnabled == r101.longConnectionEnabled) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.popupWithClose, r101.popupWithClose) == true) goto L18;
        return false;
    L18:
        if (this.pageSlideActionsOffset == r101.pageSlideActionsOffset) goto L20;
        return false;
    L20:
        if (this.shouldOptimizeHalfContainerCloseInteraction == r101.shouldOptimizeHalfContainerCloseInteraction) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.chunkSplitDetail, r101.chunkSplitDetail) == true) goto L24;
        return false;
    L24:
        if (this.forbidCache == r101.forbidCache) goto L26;
        return false;
    L26:
        if (this.enableHalfScreenTransitionAnimation == r101.enableHalfScreenTransitionAnimation) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public int hashCode() {
        boolean r100 = this.gulControl;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.shopRecommendsControl;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.detailControl;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.searchWordsControl;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.longConnectionEnabled;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        g r116 = this.popupWithClose;
        int r117 = 0;
        if (r116 == null) goto L20;
        int r118 = r116.hashCode();
    L21:
        int r119 = (((r115 + r118) * 31) + this.pageSlideActionsOffset) * 31;
        boolean r120 = this.shouldOptimizeHalfContainerCloseInteraction;
        ?? r121 = r120;
        if (r120 == false) goto L24;
        r121 = 1;
    L24:
        int r122 = (r119 + r121) * 31;
        d r123 = this.chunkSplitDetail;
        if (r123 == null) goto L27;
        r117 = r123.hashCode();
    L27:
        int r124 = (r122 + r117) * 31;
        boolean r125 = this.forbidCache;
        ?? r126 = r125;
        if (r125 == false) goto L30;
        r126 = 1;
    L30:
        int r127 = (r124 + r126) * 31;
        boolean r128 = this.enableHalfScreenTransitionAnimation;
        if (r128 == true) goto L35;
        r101 = r128;
    L35:
        return r127 + r101;
    L20:
        r118 = 0;
        goto L21
    }

    public String toString() {
        return "Control(gulControl=" + this.gulControl + ", shopRecommendsControl=" + this.shopRecommendsControl + ", detailControl=" + this.detailControl + ", searchWordsControl=" + this.searchWordsControl + ", longConnectionEnabled=" + this.longConnectionEnabled + ", popupWithClose=" + this.popupWithClose + ", pageSlideActionsOffset=" + this.pageSlideActionsOffset + ", shouldOptimizeHalfContainerCloseInteraction=" + this.shouldOptimizeHalfContainerCloseInteraction + ", chunkSplitDetail=" + this.chunkSplitDetail + ", forbidCache=" + this.forbidCache + ", enableHalfScreenTransitionAnimation=" + this.enableHalfScreenTransitionAnimation + ")";
    }

    public final d getChunkSplitDetail() {
        return this.chunkSplitDetail;
    }

    public final boolean getDetailControl() {
        return this.detailControl;
    }

    public final boolean getEnableHalfScreenTransitionAnimation() {
        return this.enableHalfScreenTransitionAnimation;
    }

    public final boolean getForbidCache() {
        return this.forbidCache;
    }

    public final boolean getGulControl() {
        return this.gulControl;
    }

    public final boolean getLongConnectionEnabled() {
        return this.longConnectionEnabled;
    }

    public final int getPageSlideActionsOffset() {
        return this.pageSlideActionsOffset;
    }

    public final g getPopupWithClose() {
        return this.popupWithClose;
    }

    public final boolean getSearchWordsControl() {
        return this.searchWordsControl;
    }

    public final boolean getShopRecommendsControl() {
        return this.shopRecommendsControl;
    }

    public final boolean getShouldOptimizeHalfContainerCloseInteraction() {
        return this.shouldOptimizeHalfContainerCloseInteraction;
    }

    public Control(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, g r105, int r106, boolean r107, d r108, boolean r110, boolean r111) {
        this.gulControl = r100;
        this.shopRecommendsControl = r101;
        this.detailControl = r102;
        this.searchWordsControl = r103;
        this.longConnectionEnabled = r104;
        this.popupWithClose = r105;
        this.pageSlideActionsOffset = r106;
        this.shouldOptimizeHalfContainerCloseInteraction = r107;
        this.chunkSplitDetail = r108;
        this.forbidCache = r110;
        this.enableHalfScreenTransitionAnimation = r111;
    }

    public /* synthetic */ Control(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, g r115, int r116, boolean r210, d r211, boolean r212, boolean r213, int r214, DefaultConstructorMarker r215) {
        boolean r100 = false;
        if ((r214 & 1) == 0) goto L5;
        boolean r101 = false;
    L6:
        boolean r102 = true;
        if ((r214 & 2) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r214 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r105 = false;
    L22:
        d r106 = null;
        if ((r214 & 32) == 0) goto L25;
        g r107 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r108 = 0;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r117 = false;
    L35:
        if ((r214 & 256) != 0) goto L39;
        r106 = r211;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r118 = false;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r103, r104, r102, r105, r107, r108, r117, r106, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L33:
        r117 = r210;
        goto L35
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
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
