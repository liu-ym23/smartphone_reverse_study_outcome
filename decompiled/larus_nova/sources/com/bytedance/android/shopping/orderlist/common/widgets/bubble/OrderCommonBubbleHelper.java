package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonBubbleHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179999a = 0;

    public static final class a implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f180000a;

        public a(Function0 r100) {
            this.f180000a = r100;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            Function0 r100 = this.f180000a;
            if (r100 == null) goto L6;
            Unit r101 = (Unit) r100.invoke();
            return;
        }
    }

    static {
    }

    public static PopupWindow a(b r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderCommonBubbleHelper", OrderCommonBubbleHelper$showBubble$1.INSTANCE);
        Drawable r101 = null;
        BubbleContainer r102 = new BubbleContainer(r110.getContext(), null, 6, 0);
        Rect r103 = new Rect();
        r110.f180007f.getWindowVisibleDisplayFrame(r103);
        int[] r104 = new int[2];
        r110.f180007f.getLocationOnScreen(r104);
        int[] r105 = new int[2];
        r110.f180007f.getLocationInWindow(r105);
        int r106 = r104[0] - r105[0];
        int r107 = r104[1] - r105[1];
        r110.f180003b.set(r103.left - r106, r103.top - r107, r103.right - r106, r103.bottom - r107);
        int r108 = r110.f180003b.top + r110.f180014m;
        View r109 = r110.f180015n;
        if (r109 != null) goto L5;
        int r112 = Integer.MIN_VALUE;
    L6:
        int r113 = Math.max(r108, r112);
        int r114 = r110.f180003b.bottom - r110.f180014m;
        int[] r115 = new int[2];
        r110.f180007f.getLocationInWindow(r115);
        int r116 = r115[0];
        Rect r117 = new Rect(r116, r115[1], r110.f180007f.getWidth() + r116, r115[1] + r110.f180007f.getHeight());
        int r118 = (r110.f180010i + r110.f180013l) + r110.f180014m;
        int r119 = r117.top - r113;
        int r120 = r114 - r117.bottom;
        int r121 = com.bytedance.android.shopping.orderlist.common.widgets.bubble.a.f180001a[r110.f180008g.ordinal()];
        if (r121 == 1) goto L18;
        if (r121 != 2) goto L17;
        if (r120 < r118) goto L11;
        BubbleOrientation r122 = BubbleOrientation.BOTTOM;
    L25:
        r110.f180002a = r122;
        if (r122 != BubbleOrientation.TOP) goto L28;
        Point r123 = r110.b();
        Point r124 = new Point(r123.x - ((r110.f180009h + (r110.f180014m * 2)) / 2), (r123.y - r110.f180010i) - r110.f180013l);
    L29:
        int r125 = RangesKt.coerceIn(r124.y, r113, RangesKt.coerceAtLeast(r114 - ((r110.f180010i + r110.f180013l) + (r110.f180014m * 2)), r113));
        Rect r126 = r110.f180003b;
        int r127 = r126.left;
        r110.f180004c.set(RangesKt.coerceIn(r124.x, r127, RangesKt.coerceAtLeast(r126.right - (r110.f180009h + (r110.f180014m * 2)), r127)), r125);
        Intrinsics.checkNotNullParameter(r110, "info");
        Drawable r128 = r102.f179990d.getBackground();
        if ((r128 instanceof BackgroundDrawable) == false) goto L33;
        r101 = r128;
    L33:
        BackgroundDrawable r129 = (BackgroundDrawable) r101;
        if (r129 == null) goto L37;
        r129.setCornerRadius(r110.f180011j);
        r129.invalidateSelf();
    L37:
        if (r110.f180002a != BubbleOrientation.BOTTOM) goto L39;
        r102.f179988b.setVisibility(0);
        r102.f179989c.setVisibility(8);
        BubbleContainer.a(r102.f179988b, r110);
    L40:
        ViewGroup.LayoutParams r130 = r102.f179988b.getLayoutParams();
        r130.width = r110.f180012k;
        r130.height = r110.f180013l;
        ViewGroup.LayoutParams r131 = r102.f179989c.getLayoutParams();
        r131.width = r110.f180012k;
        r131.height = r110.f180013l;
        ViewGroup r132 = r102.f179987a;
        int r133 = r110.f180014m;
        r132.setPadding(r133, r133, r133, r133);
        r102.f179990d.addView(r110.f180006e);
        r102.f179991e.setShadowRadius(Math.max(r110.f180014m, r110.f180013l));
        PopupWindow r134 = new PopupWindow(r102, -2, -2, true);
        r134.setBackgroundDrawable(new ColorDrawable(0));
        Point r135 = r110.f180004c;
        View r136 = r110.f180007f;
        int r137 = r135.x;
        int r138 = r135.y;
        if (PopupWindowLancet.hasSubWindowToken(r136) == false) goto L44;
    L50:
        r134.setOnDismissListener(new a(r111));
        return r134;
    L44:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r134) == false) goto L46;
        r134.showAtLocation(r136, 0, r137, r138);
        goto L50
    L46:
        OverlaySource r139 = PopupWindowLancet.resolveSource(r136);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r134, r136, r139, 0, r137, r138) == true) goto L50;
        r134.showAtLocation(r136, 0, r137, r138);
        PopupWindowLancet.trackAfterShow(r134, r139, r136);
        goto L50
    L39:
        r102.f179988b.setVisibility(8);
        r102.f179989c.setVisibility(0);
        BubbleContainer.a(r102.f179989c, r110);
        goto L40
    L28:
        Point r140 = r110.a();
        r124 = new Point(r140.x - ((r110.f180009h + (r110.f180014m * 2)) / 2), r140.y);
        goto L29
    L11:
        if (r119 < r118) goto L13;
        r122 = BubbleOrientation.TOP;
        goto L25
    L13:
        if (r120 < r119) goto L15;
        r122 = BubbleOrientation.BOTTOM;
        goto L25
    L15:
        r122 = BubbleOrientation.TOP;
        goto L25
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r119 < r118) goto L20;
        r122 = BubbleOrientation.TOP;
        goto L25
    L20:
        if (r120 < r118) goto L22;
        r122 = BubbleOrientation.BOTTOM;
        goto L25
    L22:
        if (r119 < r120) goto L24;
        r122 = BubbleOrientation.TOP;
        goto L25
    L24:
        r122 = BubbleOrientation.BOTTOM;
        goto L25
    L5:
        int[] r141 = new int[2];
        r109.getLocationInWindow(r141);
        r112 = r109.getHeight() + r141[1];
        goto L6
    }
}
