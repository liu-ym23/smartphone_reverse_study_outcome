package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends BubblePopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f43486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f43488c;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f43489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f43490b;

        public a(f r100, Function0 r101) {
            this.f43489a = r100;
            this.f43490b = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (this.f43489a.isOutsideTouchable() == true) goto L26;
            if (r101 == null) goto L17;
            f r102 = this.f43489a;
            float r103 = r101.getX(0);
            float r104 = r101.getY(0);
            if (r103 <= (r102.f43487b + vf4.a.b(26))) goto L8;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == false) goto L17;
            this.f43490b.invoke();
            goto L26
        L8:
            if (r103 < (r102.f43487b - vf4.a.b(4))) goto L14;
            if (r104 > 0) goto L14;
            if (r104 < vf4.a.b(-28)) goto L14;
            r105 = true;
        L17:
            if (r101 == null) goto L19;
            float r106 = r101.getY(0);
        L21:
            if (r106 < 0) goto L26;
            View r107 = this.f43489a.getContentView();
            if (r107 == null) goto L26;
            r107.dispatchTouchEvent(r101);
            goto L26
        L19:
            r106 = 0.0f;
        L26:
            if (this.f43489a.isFocusable() == true) goto L28;
        L30:
            return false;
        L28:
            if (this.f43489a.isOutsideTouchable() == true) goto L30;
            return true;
        }
    }

    @Override // com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow, android.widget.PopupWindow
    public final void dismiss() {
        StackTraceElement[] r100 = new Exception().getStackTrace();
        if (r100.length >= 2) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("dispatchKeyEvent", r100[1].getMethodName()) == true) goto L7;
        return;
    L7:
        if (this.f43488c.isAttachedToWindow() == false) goto L12;
        if (isShowing() == false) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L12:
        if (isShowing() == false) goto L18;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    }

    public f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(ExtKt.getActivity(r100), false, false);
        this.f43488c = r100;
    }

    public final void b(View r110, String r210, Function0<Unit> r211, Function0<Unit> r212, Function0<Unit> r213) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r211, "addCartListener");
        Intrinsics.checkNotNullParameter(r212, "stopRemindListener");
        Intrinsics.checkNotNullParameter(r213, "closeFragmentListener");
        setFocusable(true);
        setOutsideTouchable(false);
        setBackgroundDrawable(new ColorDrawable(0));
        LinearLayout r100 = new LinearLayout(this.f43488c.getContext());
        r100.setOrientation(1);
        r100.setGravity(17);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-2, vf4.a.b(74)));
        TextView r101 = new TextView(this.f43488c.getContext());
        r101.setText(r210);
        r101.setGravity(17);
        r101.setTextSize(13.0f);
        r101.setTextColor(-1);
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        com.bytedance.android.shopping.extensions.f.e(r101, 500);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r101.setMaxWidth(UIUtils.getScreenWidth(r101.getContext()) - ((int) UIUtils.dip2Px(r101.getContext(), 42.0f)));
        r100.addView(r101);
        LinearLayout r102 = new LinearLayout(this.f43488c.getContext());
        r102.setOrientation(0);
        r102.setGravity(17);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams r111 = r102.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r111 = null;
    L5:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        if (r112 == null) goto L8;
        r112.topMargin = vf4.a.b(8);
        r102.setLayoutParams(r112);
    L8:
        TextView r113 = new TextView(this.f43488c.getContext());
        r113.setText("不再提醒");
        r113.setTextSize(12.0f);
        r113.setGravity(17);
        r113.setTextColor(-1);
        com.bytedance.android.shopping.extensions.f.e(r113, 500);
        r113.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(78), vf4.a.b(23)));
        r113.setBackground(com.bytedance.commerce.base.drawable.a.a(SkuBubblePopupView$initView$stopRemindButton$1$1.INSTANCE));
        r113.setOnTouchListener(new e(r113));
        r113.setOnClickListener(new b(r212));
        TextView r103 = new TextView(this.f43488c.getContext());
        r103.setText("加入购物车");
        r103.setTextSize(12.0f);
        r103.setTextColor(-1);
        r103.setGravity(17);
        com.bytedance.android.shopping.extensions.f.e(r103, 500);
        r103.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(78), vf4.a.b(24)));
        r103.setBackground(com.bytedance.commerce.base.drawable.a.a(SkuBubblePopupView$initView$addCartButton$1$1.INSTANCE));
        r103.setOnTouchListener(new d(r103));
        r103.setOnClickListener(new c(r211));
        r102.addView(r113);
        FrameLayout r104 = new FrameLayout(this.f43488c.getContext());
        r104.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(8), -2));
        Unit r105 = Unit.INSTANCE;
        r102.addView(r104);
        r102.addView(r103);
        r100.addView(r102);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        setBubbleView(r100, Boolean.TRUE);     // Catch: Throwable -> L11
        setArrowVerticalSize(7);     // Catch: Throwable -> L11
        setArrowLongSize(20);     // Catch: Throwable -> L11
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L16;
        ECExceptionMonitor.e(r108);
    L16:
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        setAutoDismissDelayMillis(0);
        this.f43487b = r100.getMeasuredWidth();
        setTouchInterceptor(new a(this, r213));
        setBgColor(ColorProtector.parseColor("#393B44"));
        setNeedPath(false);
        setInAnimTime(100);
        setShadowLayerYOffset(4);
        setShowOutAnim(false);
        setShadowLayerColor(0);
        setHorizontalPadding(12);
        show(r110, (int) ((r100.getMeasuredWidth() / 2.0f) + vf4.a.b(Double.valueOf(3.5d))), -((int) ((r100.getMeasuredWidth() / 2.0f) + vf4.a.b(4))), 0, 80);
        this.f43486a = true;
        return;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
