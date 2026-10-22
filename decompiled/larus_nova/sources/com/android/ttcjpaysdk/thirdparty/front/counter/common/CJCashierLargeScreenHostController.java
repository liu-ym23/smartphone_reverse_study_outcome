package com.android.ttcjpaysdk.thirdparty.front.counter.common;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\rJ\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0012H\u0002J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\bR\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/common/CJCashierLargeScreenHostController;", "", "rootView", "Landroid/view/ViewGroup;", "maskView", "Landroid/view/View;", "contentHost", "tag", "", "hostActivity", "Landroid/app/Activity;", "afterLayoutUpdated", "Lkotlin/Function1;", "", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/String;Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "bound", "", "defaultMaskColor", "", "enabled", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "bind", "enableLargeScreen", "dispatchAfterLayoutUpdated", "reason", "contentWidthUpdated", "doOnNextLayout", PickerReporterConstants.KEY.TARGET, "action", "Lkotlin/Function0;", "release", "updateContentHostWidth", "targetWidth", "updateLayout", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCashierLargeScreenHostController {
    public static final Companion Companion = null;
    private static final int LARGE_SCREEN_MASK_COLOR = 1461065763;
    private final Function1<String, Unit> afterLayoutUpdated;
    private boolean bound;
    private final ViewGroup contentHost;
    private final int defaultMaskColor;
    private boolean enabled;
    private final Activity hostActivity;
    private final View.OnLayoutChangeListener layoutChangeListener;
    private final View maskView;
    private final ViewGroup rootView;
    private final String tag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/common/CJCashierLargeScreenHostController$Companion;", "", "()V", "LARGE_SCREEN_MASK_COLOR", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void release() {
        if (this.bound == true) goto L5;
        return;
    L5:
        this.rootView.removeOnLayoutChangeListener(this.layoutChangeListener);
        this.bound = false;
    }

    public static final /* synthetic */ boolean access$getEnabled$p(CJCashierLargeScreenHostController r100) {
        return r100.enabled;
    }

    private final boolean updateContentHostWidth(int r100) {
        if (r100 > 0) goto L5;
        return false;
    L5:
        ViewGroup.LayoutParams r101 = this.contentHost.getLayoutParams();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.width != r100) goto L11;
        return false;
    L11:
        r101.width = r100;
        if ((r101 instanceof FrameLayout.LayoutParams) == false) goto L15;
        ((FrameLayout.LayoutParams) r101).gravity = 81;
    L17:
        this.contentHost.setLayoutParams(r101);
        this.contentHost.requestLayout();
        return true;
    L15:
        if ((r101 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        RelativeLayout.LayoutParams r102 = (RelativeLayout.LayoutParams) r101;
        r102.addRule(14, -1);
        r102.addRule(12, -1);
        goto L17
    }

    public final void bind(boolean r100) {
        int r101 = 0;
        if (r100 == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.enabled = r102;
        CJLogger.d(this.tag, "bind large-screen host, requestEnable=" + r100 + ", finalEnable=" + this.enabled);
        if (this.bound == true) goto L16;
        this.bound = true;
        this.rootView.addOnLayoutChangeListener(this.layoutChangeListener);
        this.contentHost.setClipChildren(true);
        this.contentHost.setClipToPadding(true);
        int r103 = this.contentHost.getChildCount();
    L11:
        if (r101 >= r103) goto L16;
        View r104 = this.contentHost.getChildAt(r101);
        if ((r104 instanceof ViewGroup) == false) goto L15;
        ViewGroup r105 = (ViewGroup) r104;
        r105.setClipChildren(true);
        r105.setClipToPadding(true);
    L15:
        r101 = r101 + 1;
    L16:
        updateLayout("bind");
        return;
    L5:
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == false) goto L7;
        r102 = true;
        goto L8
    }

    public final void updateLayout(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Integer r101 = Integer.valueOf(this.rootView.getWidth());
        boolean r102 = true;
        if (r101.intValue() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L11;
        int r104 = r101.intValue();
    L12:
        if (r104 > 0) goto L16;
        CJLogger.e(this.tag, "skip update large-screen layout: invalid root width, reason=" + r100);
        return;
    L16:
        if (this.enabled == false) goto L18;
        int r105 = CJPayLargeScreenUtils.resolveCashierVisibleWidthPx(this.hostActivity, r104);
    L20:
        if (this.enabled == true) goto L22;
    L24:
        r102 = false;
    L25:
        boolean r106 = updateContentHostWidth(r105);
        View r107 = this.maskView;
        if (r102 == false) goto L28;
        int r108 = 1461065763;
    L29:
        r107.setBackgroundColor(r108);
        this.maskView.setVisibility(0);
        CJLogger.d(this.tag, "update large-screen layout, reason=" + r100 + ", enabled=" + this.enabled + ", rootWidth=" + r104 + ", contentWidth=" + r105 + ", isLargeScreen=" + r102);
        dispatchAfterLayoutUpdated(r100, r106);
        return;
    L28:
        r108 = this.defaultMaskColor;
        goto L29
    L22:
        if (CJPayLargeScreenUtils.isLargeScreen(this.hostActivity, r104) == false) goto L24;
    L18:
        r105 = r104;
        goto L20
    L11:
        r104 = CJPayLargeScreenUtils.resolveWindowWidthPx(this.hostActivity, this.rootView);
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    private final void dispatchAfterLayoutUpdated(final String r100, boolean r101) {
        final Function1<String, Unit> r102 = this.afterLayoutUpdated;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
        doOnNextLayout(this.contentHost, new AnonymousClass1(r102, r100));
        return;
    L7:
        this.contentHost.post(new AnonymousClass2(r102, r100));
    }

    private final void doOnNextLayout(View r100, final Function0<Unit> r101) {
        r100.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC93661(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJCashierLargeScreenHostController(ViewGroup r100, View r101, ViewGroup r102, String r103, Activity r104, Function1<? super String, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "maskView");
        Intrinsics.checkNotNullParameter(r102, "contentHost");
        Intrinsics.checkNotNullParameter(r103, "tag");
        Intrinsics.checkNotNullParameter(r104, "hostActivity");
        this.rootView = r100;
        this.maskView = r101;
        this.contentHost = r102;
        this.tag = r103;
        this.hostActivity = r104;
        this.afterLayoutUpdated = r105;
        Drawable r106 = r101.getBackground();
        if ((r106 instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r107 = (ColorDrawable) r106;
    L6:
        if (r107 == null) goto L8;
        int r108 = r107.getColor();
    L9:
        this.defaultMaskColor = r108;
        this.layoutChangeListener = new CJCashierLargeScreenHostController$layoutChangeListener$1(this);
        return;
    L8:
        r108 = 0;
        goto L9
    L5:
        r107 = null;
        goto L6
    }

    public /* synthetic */ CJCashierLargeScreenHostController(ViewGroup r100, View r101, ViewGroup r110, String r111, Activity r112, Function1 r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = null;
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
