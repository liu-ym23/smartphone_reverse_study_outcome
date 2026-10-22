package com.obric.ui.popover;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OUIPopoverHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\fH\u0002J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J4\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¨\u0006\u001e"}, d2 = {"Lcom/obric/ui/popover/OUIPopoverHelper;", "", "()V", "decideOffsetInfo", "Lcom/obric/ui/popover/OffsetInfo;", "popover", "Lcom/obric/oui/popover/v2/OPopover;", MaterialConfigFormatNames.DIRECTION, "Lcom/obric/ui/popover/Direct;", "targetView", "Landroid/view/View;", "isMiddle", "", "genMenu", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "activity", "Landroid/app/Activity;", "list", "", "Lcom/obric/ui/popover/MenuItemData;", "enableOption", "genPopover", "getGravity", "", "getIsMiddle", "showPopupAtAnchorView", "", "direct", BatteryTypeInf.BATTERY_LOC_API, "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OUIPopoverHelper {
    public static final OUIPopoverHelper INSTANCE = null;

    /* JADX INFO: compiled from: OUIPopoverHelper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[ItemType.values().length];
            r0[ItemType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L42:
            r0[ItemType.TEXT_WITH_BADGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L60:
            r0[ItemType.TEXT_WITH_ARROW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L44:
            r0[ItemType.FILTERS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L46:
            r0[ItemType.DIVIDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L12:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[Direct.values().length];
            r1[Direct.TOP_RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L38:
            r1[Direct.BOTTOM_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L50:
            r1[Direct.TOP_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            r1[Direct.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L48:
            r1[Direct.TOP_MID.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L40:
            r1[Direct.BOTTOM_MID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L54:
            r1[Direct.LEFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L58:
            r1[Direct.RIGHT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L21:
            $EnumSwitchMapping$1 = r1;
        }
    }

    static {
        INSTANCE = new OUIPopoverHelper();
    }

    private OUIPopoverHelper() {
    }

    public static /* synthetic */ void showPopupAtAnchorView$default(Activity r0, OPopover r1, Direct r2, View r3, int[] r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L5;
        r4 = null;
    L5:
        showPopupAtAnchorView(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void showPopupAtAnchorView(Activity r13, OPopover r14, Direct r15, View r16, int[] r17) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "popover");
        Intrinsics.checkNotNullParameter(r15, "direct");
        Intrinsics.checkNotNullParameter(r16, "targetView");
        if (r17 == null) goto L5;
        OPopoverHelperEx.showPopoverSmartlyAtLocation$default(OPopoverHelperEx.INSTANCE, r13, r14, r17[0], r17[1], false, 0, 48, null);
        return;
    L5:
        OPopoverHelperEx.showPopoverSmartly$default(OPopoverHelperEx.INSTANCE, r14, r16, INSTANCE.getGravity(r15), false, 0, false, 0, 0, 248, null);
    }

    public static /* synthetic */ OPopover genPopover$default(Activity r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = false;
    L6:
        return genPopover(r0, r1, r2);
    }

    @JvmStatic
    public static final OPopover genPopover(Activity r1, List<MenuItemData> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "list");
        OPopoverEntranceMenuView r4 = INSTANCE.genMenu(r1, r2, r3);
        return new OPopover.Builder(r1).setView(r4).build();
    }

    private final OPopoverEntranceMenuView genMenu(Activity r18, final List<MenuItemData> r19, boolean r20) {
        OPopoverEntranceMenuView.Builder r13 = new OPopoverEntranceMenuView.Builder(r18);
        if (r20 == false) goto L5;
        r13.enableOption();
    L5:
        List<MenuItemData> r14 = r19;
        Iterator<T> r15 = r14.iterator();
    L6:
        boolean r2 = true;
        boolean r3 = false;
        if (r15.hasNext() == false) goto L40;
        final MenuItemData r1 = (MenuItemData) r15.next();
        CharSequence r4 = r1.getSubTitle();
        if (r4 != null) goto L11;
    L16:
        CharSequence r6 = null;
    L17:
        int r5 = WhenMappings.$EnumSwitchMapping$0[r1.getItemType().ordinal()];
        if (r5 != 1) goto L20;
        Integer r7 = r1.getImageRes();
        Integer r8 = r1.getResTint();
        CharSequence r9 = r1.getTitle();
        Boolean r10 = r1.isHeightLight();
        if (r10 == null) goto L38;
        r3 = r10.booleanValue();
    L38:
        OPopoverEntranceMenuView.Builder.addPopoverItemWithBadge$default(r13, r7, r8, r9, r6, null, r3, r1.getBadgeInfo(), new OUIPopoverHelper$genMenu$1$1$1(r1), 16, null);
        goto L6
    L20:
        if (r5 != 2) goto L22;
        OPopoverEntranceMenuView.Builder.addPopoverItemWithBadge$default(r13, r1.getImageRes(), r1.getResTint(), r1.getTitle(), r6, null, false, r1.getBadgeInfo(), r1.getOnClick(), 48, null);
        goto L6
    L22:
        if (r5 != 3) goto L24;
        OPopoverEntranceMenuView.Builder.addPopoverItemWithArrow$default(r13, r1.getImageRes(), r1.getResTint(), r1.getTitle(), r6, null, false, r1.getOnClick(), 48, null);
        goto L6
    L24:
        if (r5 != 4) goto L26;
        Integer r11 = r1.getImageRes();
        Integer r12 = r1.getTailImageRes();
        Integer r16 = r1.getResTint();
        CharSequence r17 = r1.getTitle();
        Boolean r110 = r1.getChecked();
        if (r110 == null) goto L32;
        r3 = r110.booleanValue();
    L32:
        OPopoverEntranceMenuView.Builder.addPopoverLeftOptionItem$default(r13, r11, r12, r16, r17, r6, false, false, r3, r1.getOnClick(), 96, null);
        goto L6
    L26:
        if (r5 != 5) goto L6;
        r13.addItemDivider();
        goto L6
    L11:
        if (r4.length() <= 0) goto L13;
        boolean r21 = true;
    L14:
        if (r21 == false) goto L16;
        r6 = r4;
        goto L17
    L13:
        r21 = false;
        goto L14
    L40:
        if ((r14 instanceof Collection) == true) goto L42;
    L44:
        Iterator<T> r22 = r14.iterator();
    L46:
        if (r22.hasNext() == false) goto L43;
        if ((!((MenuItemData) r22.next()).getEnabled()) == false) goto L46;
    L49:
        if (r2 == false) goto L52;
        r13.setItemLayoutProcess(new OUIPopoverHelper$genMenu$1$3(r19));
    L52:
        return r13.build();
    L43:
        r2 = false;
        goto L49
    L42:
        if (r14.isEmpty() == false) goto L44;
        goto L43
    }

    private final OffsetInfo decideOffsetInfo(OPopover r7, Direct r8, View r9, boolean r10) {
        OffsetInfo r6 = new OffsetInfo(0, 0, 0.0f, 7, null);
        switch(WhenMappings.$EnumSwitchMapping$1[r8.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L25;
        };
    L20:
        r6.setXOffset(r9.getMeasuredWidth() - r7.getMeasuredWidth());
        r6.setArrowOffset(1000.0f);
        if (r8 != Direct.TOP_RIGHT) goto L23;
        int r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L24:
        r6.setYOffset(r11);
        goto L25
    L23:
        r11 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L25:
        if (r10 == false) goto L27;
        r6.setXOffset(0);
    L27:
        return r6;
    L6:
        if (r8 != Direct.LEFT) goto L8;
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L9:
        r6.setXOffset(r12);
        goto L25
    L8:
        r12 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L9
    L11:
        if (r8 != Direct.TOP_MID) goto L13;
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L14:
        r6.setYOffset(r13);
        goto L25
    L13:
        r13 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L14
    L16:
        if (r8 != Direct.TOP_LEFT) goto L18;
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
    L19:
        r6.setYOffset(r14);
        goto L25
    L18:
        r14 = -MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()));
        goto L19
    }

    private final boolean getIsMiddle(Direct r1) {
        if (r1 != Direct.TOP_MID) goto L5;
    L8:
        return true;
    L5:
        if (r1 == Direct.BOTTOM_MID) goto L8;
        return false;
    }

    private final int getGravity(Direct r1) {
        switch(WhenMappings.$EnumSwitchMapping$1[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return 5;
    L7:
        return 3;
    L8:
        return 80;
    L9:
        return 48;
    L10:
        return 83;
    L11:
        return 51;
    L12:
        return 85;
    L13:
        return 53;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
