package com.obric.ui.popover;

import android.view.View;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuItemData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012:\b\u0002\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f¢\u0006\u0002\u0010\u0019J\t\u0010-\u001a\u00020\u0003HÆ\u0003J;\u0010.\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J¾\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2:\b\u0002\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00112\b\b\u0002\u0010\u0018\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\r\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%RC\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010#\u001a\u0004\b+\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*¨\u0006?"}, d2 = {"Lcom/obric/ui/popover/MenuItemData;", "", "itemType", "Lcom/obric/ui/popover/ItemType;", "imageRes", "", "tailImageRes", "resTint", "title", "", "subTitle", MaterialConfigFormatNames.CHECKED, "", "isHeightLight", "badgeInfo", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "pos", "", "enabled", "(Lcom/obric/ui/popover/ItemType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;Z)V", "getBadgeInfo", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "getChecked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnabled", "()Z", "getImageRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemType", "()Lcom/obric/ui/popover/ItemType;", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "getResTint", "getSubTitle", "()Ljava/lang/CharSequence;", "getTailImageRes", "getTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/ui/popover/ItemType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;Z)Lcom/obric/ui/popover/MenuItemData;", "equals", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MenuItemData {
    private final OPopoverEntranceMenuView.Builder.BadgeInfo badgeInfo;
    private final Boolean checked;
    private final boolean enabled;
    private final Integer imageRes;
    private final Boolean isHeightLight;
    private final ItemType itemType;
    private final Function2<View, Integer, Unit> onClick;
    private final Integer resTint;
    private final CharSequence subTitle;
    private final Integer tailImageRes;
    private final CharSequence title;

    public MenuItemData() {
        this(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    public MenuItemData(ItemType r16) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, null, null, null, null, null, null, null, null, null, false, 2046, null);
    }

    public MenuItemData(ItemType r16, Integer r17) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, null, null, null, null, null, null, null, null, false, 2044, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, null, null, null, null, null, null, null, false, 2040, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, null, null, null, null, null, null, false, 2032, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19, CharSequence r20) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, r20, null, null, null, null, null, false, 2016, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, r20, r21, null, null, null, null, false, 1984, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, Boolean r22) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, r20, r21, r22, null, null, null, false, 1920, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, Boolean r22, Boolean r23) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, r20, r21, r22, r23, null, null, false, 1792, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, Boolean r22, Boolean r23, OPopoverEntranceMenuView.Builder.BadgeInfo r24) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, null, false, 1536, null);
    }

    public MenuItemData(ItemType r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, Boolean r22, Boolean r23, OPopoverEntranceMenuView.Builder.BadgeInfo r24, Function2<? super View, ? super Integer, Unit> r25) {
        Intrinsics.checkNotNullParameter(r16, "itemType");
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, false, 1024, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MenuItemData copy$default(MenuItemData r12, ItemType r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, Boolean r19, Boolean r20, OPopoverEntranceMenuView.Builder.BadgeInfo r21, Function2 r22, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        ItemType r2 = r12.itemType;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Integer r3 = r12.imageRes;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = r12.tailImageRes;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = r12.resTint;
    L19:
        if ((r24 & 16) == 0) goto L21;
        CharSequence r6 = r12.title;
    L23:
        if ((r24 & 32) == 0) goto L25;
        CharSequence r7 = r12.subTitle;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Boolean r8 = r12.checked;
    L31:
        if ((r24 & 128) == 0) goto L33;
        Boolean r9 = r12.isHeightLight;
    L35:
        if ((r24 & 256) == 0) goto L37;
        OPopoverEntranceMenuView.Builder.BadgeInfo r10 = r12.badgeInfo;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Function2 r11 = r12.onClick;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        boolean r1 = r12.enabled;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final ItemType component1() {
        return this.itemType;
    }

    public final Function2<View, Integer, Unit> component10() {
        return this.onClick;
    }

    public final boolean component11() {
        return this.enabled;
    }

    public final Integer component2() {
        return this.imageRes;
    }

    public final Integer component3() {
        return this.tailImageRes;
    }

    public final Integer component4() {
        return this.resTint;
    }

    public final CharSequence component5() {
        return this.title;
    }

    public final CharSequence component6() {
        return this.subTitle;
    }

    public final Boolean component7() {
        return this.checked;
    }

    public final Boolean component8() {
        return this.isHeightLight;
    }

    public final OPopoverEntranceMenuView.Builder.BadgeInfo component9() {
        return this.badgeInfo;
    }

    public final MenuItemData copy(ItemType r14, Integer r15, Integer r16, Integer r17, CharSequence r18, CharSequence r19, Boolean r20, Boolean r21, OPopoverEntranceMenuView.Builder.BadgeInfo r22, Function2<? super View, ? super Integer, Unit> r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r14, "itemType");
        return new MenuItemData(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MenuItemData) == true) goto L8;
        return false;
    L8:
        MenuItemData r6 = (MenuItemData) r5;
        if (this.itemType == r6.itemType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageRes, r6.imageRes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tailImageRes, r6.tailImageRes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resTint, r6.resTint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.checked, r6.checked) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isHeightLight, r6.isHeightLight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.badgeInfo, r6.badgeInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.onClick, r6.onClick) == true) goto L39;
        return false;
    L39:
        if (this.enabled == r6.enabled) goto L41;
        return false;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = this.itemType.hashCode() * 31;
        Integer r1 = this.imageRes;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.tailImageRes;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.resTint;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        CharSequence r11 = this.title;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        CharSequence r14 = this.subTitle;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.checked;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.isHeightLight;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        OPopoverEntranceMenuView.Builder.BadgeInfo r23 = this.badgeInfo;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Function2<View, Integer, Unit> r26 = this.onClick;
        if (r26 == null) goto L38;
        r2 = r26.hashCode();
    L38:
        int r27 = (r25 + r2) * 31;
        boolean r28 = this.enabled;
        ?? r29 = r28;
        if (r28 == false) goto L42;
        r29 = 1;
    L42:
        return r27 + r29;
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("MenuItemData(itemType=");
        r0.append(this.itemType).append(", imageRes=").append(this.imageRes).append(", tailImageRes=").append(this.tailImageRes).append(", resTint=").append(this.resTint).append(", title=").append(this.title).append(", subTitle=").append(this.subTitle).append(", checked=").append(this.checked).append(", isHeightLight=").append(this.isHeightLight).append(", badgeInfo=").append(this.badgeInfo).append(", onClick=").append(this.onClick).append(", enabled=").append(this.enabled).append(')');
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItemData(ItemType r2, Integer r3, Integer r4, Integer r5, CharSequence r6, CharSequence r7, Boolean r8, Boolean r9, OPopoverEntranceMenuView.Builder.BadgeInfo r10, Function2<? super View, ? super Integer, Unit> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "itemType");
        this.itemType = r2;
        this.imageRes = r3;
        this.tailImageRes = r4;
        this.resTint = r5;
        this.title = r6;
        this.subTitle = r7;
        this.checked = r8;
        this.isHeightLight = r9;
        this.badgeInfo = r10;
        this.onClick = r11;
        this.enabled = r12;
    }

    public /* synthetic */ MenuItemData(ItemType r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, Boolean r19, Boolean r20, OPopoverEntranceMenuView.Builder.BadgeInfo r21, Function2 r22, boolean r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        ItemType r1 = ItemType.TEXT;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Integer r2 = 0;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = 0;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = 0;
    L19:
        if ((r24 & 16) == 0) goto L21;
    L22:
        Function2 r8 = null;
        if ((r24 & 32) == 0) goto L25;
        CharSequence r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Boolean r3 = false;
    L31:
        if ((r24 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        OPopoverEntranceMenuView.Builder.BadgeInfo r10 = null;
    L39:
        if ((r24 & 512) != 0) goto L43;
        r8 = r22;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        boolean r0 = true;
    L46:
        this(r1, r2, r4, r5, r6, r7, r3, r9, r10, r8, r0);
        return;
    L45:
        r0 = r23;
        goto L46
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r3 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        CharSequence r6 = r17;
        goto L22
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }

    public final ItemType getItemType() {
        return this.itemType;
    }

    public final Integer getImageRes() {
        return this.imageRes;
    }

    public final Integer getTailImageRes() {
        return this.tailImageRes;
    }

    public final Integer getResTint() {
        return this.resTint;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final CharSequence getSubTitle() {
        return this.subTitle;
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final Boolean isHeightLight() {
        return this.isHeightLight;
    }

    public final OPopoverEntranceMenuView.Builder.BadgeInfo getBadgeInfo() {
        return this.badgeInfo;
    }

    public final Function2<View, Integer, Unit> getOnClick() {
        return this.onClick;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
