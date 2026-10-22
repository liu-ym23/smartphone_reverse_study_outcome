package com.bytedance.android.ui.ec.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.GravityCompat;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ui.base.widget.scroll.MaxHeightScrollView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0019J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J\u0018\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020(J\u0012\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u0006J\u000e\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0011R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/dialog/ECAlertDialog;", "Landroidx/appcompat/app/AppCompatDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "buttonLL", "Landroid/widget/LinearLayout;", "cancelTextView", "Landroid/widget/TextView;", "confirmTextView", "contentFL", "Landroid/widget/FrameLayout;", "contentTextView", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/view/View;", "divider1", "titleTextView", "titleViewTopPlaceHolder", "topContainer", "adjustMargin", "", "enableLargeFont", "", "hideNegativeButton", "init", "openContentClick", "setDialogCancelable", "cancelable", "setDialogWidth", "setMessage", "message", "", "setMessageGravityCenter", "setMessageGravityStart", "setNegativeButton", "cancelText", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "setPositiveButton", "confirmText", d.f25925o, "title", "setTitleTopPlaceHolderVisibility", "isVisible", "height", "setTopCustomView", "topView", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAlertDialog extends AppCompatDialog {
    private LinearLayout buttonLL;
    private TextView cancelTextView;
    private TextView confirmTextView;
    private FrameLayout contentFL;
    private TextView contentTextView;
    private View divider;
    private View divider1;
    private TextView titleTextView;
    private View titleViewTopPlaceHolder;
    private FrameLayout topContainer;

    private final void adjustMargin() {
        View r100 = this.divider1;
        ViewGroup.LayoutParams r101 = null;
        if (r100 != null) goto L5;
    L19:
        View r102 = this.divider1;
        if (r102 == null) goto L32;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof LinearLayout.LayoutParams) == false) goto L25;
        r101 = r103;
    L25:
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r101;
        if (r104 == null) goto L33;
        r104.setMargins(0, 0, 0, 0);
        r102.setLayoutParams(r104);
        return;
    L33:
        return;
    L32:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L19;
        FrameLayout r105 = this.contentFL;
        if (r105 != null) goto L9;
    L10:
        View r106 = this.divider1;
        if (r106 == null) goto L29;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof LinearLayout.LayoutParams) == false) goto L16;
        r101 = r107;
    L16:
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r101;
        if (r108 == null) goto L30;
        r108.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 24, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), 0, 0);
        r106.setLayoutParams(r108);
        return;
    L30:
        return;
    L29:
        return;
    L9:
        if (r105.getVisibility() == 0) goto L19;
        goto L10
    }

    public final void hideNegativeButton() {
        TextView r100 = this.cancelTextView;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        View r101 = this.divider;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public final void openContentClick() {
        TextView r100 = this.contentTextView;
        if (r100 == null) goto L6;
        r100.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    public final void setMessageGravityCenter() {
        TextView r100 = this.contentTextView;
        if (r100 == null) goto L6;
        r100.setGravity(17);
        return;
    }

    public final void setMessageGravityStart() {
        TextView r100 = this.contentTextView;
        if (r100 == null) goto L6;
        r100.setGravity(GravityCompat.START);
        return;
    }

    private final void init() {
        setContentView(R.layout.ec_dux_alert_dialog);
        this.contentFL = (FrameLayout) findViewById(R.id.fl_content);
        this.contentTextView = (TextView) findViewById(R.id.tv_message);
        this.titleTextView = (TextView) findViewById(R.id.tv_title);
        this.titleViewTopPlaceHolder = findViewById(R.id.view_title_top_place_holder);
        this.buttonLL = (LinearLayout) findViewById(R.id.ll_button);
        this.cancelTextView = (TextView) findViewById(R.id.tv_cancel);
        this.confirmTextView = (TextView) findViewById(R.id.tv_confirm);
        this.divider = findViewById(R.id.view_divider);
        this.divider1 = findViewById(R.id.view_divider_1);
        this.topContainer = (FrameLayout) findViewById(R.id.top_container);
        MaxHeightScrollView r100 = (MaxHeightScrollView) findViewById(R.id.scroll_view);
        if (r100 == null) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L7;
        r101.addOnGlobalLayoutListener(new AnonymousClass1(this));
    L7:
        setDialogWidth();
        setDialogCancelable(false);
    }

    private final void setDialogWidth() {
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.width = -1;
        r101.height = -2;
        r100.setAttributes(r101);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setPadding(0, 0, 0, 0);
        r100.setBackgroundDrawableResource(R.color.transparent);
        return;
    }

    public ECAlertDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        init();
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void enableLargeFont(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 2;
    L5:
        TextView r102 = this.titleTextView;
        if (r102 == null) goto L8;
        r102.setTextSize(r101, 17.0f);
    L8:
        TextView r103 = this.contentTextView;
        if (r103 == null) goto L11;
        r103.setTextSize(r101, 14.0f);
    L11:
        TextView r104 = this.cancelTextView;
        if (r104 == null) goto L14;
        r104.setTextSize(r101, 15.0f);
    L14:
        TextView r105 = this.confirmTextView;
        if (r105 == null) goto L18;
        r105.setTextSize(r101, 15.0f);
        return;
    L18:
        return;
    L4:
        r101 = 1;
        goto L5
    }

    public final void setDialogCancelable(boolean r100) {
        setCancelable(r100);
        setCanceledOnTouchOutside(r100);
    }

    public final void setMessage(CharSequence r100) {
        FrameLayout r101 = this.contentFL;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = this.contentTextView;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        TextView r103 = this.contentTextView;
        if (r103 == null) goto L11;
        r103.setText(r100);
    L11:
        adjustMargin();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence r100) {
        TextView r101 = this.titleTextView;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        View r102 = this.titleViewTopPlaceHolder;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        TextView r103 = this.titleTextView;
        if (r103 == null) goto L12;
        r103.setText(r100);
        return;
    }

    public final void setTopCustomView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "topView");
        FrameLayout r101 = this.topContainer;
        if (r101 == null) goto L6;
        r101.addView(r100);
        return;
    }

    public ECAlertDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        init();
    }

    public final void setNegativeButton(CharSequence r100, final DialogInterface.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r101, "onClickListener");
        LinearLayout r102 = this.buttonLL;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        View r103 = this.divider;
        if (r103 == null) goto L8;
        r103.setVisibility(0);
    L8:
        View r104 = this.divider1;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        TextView r105 = this.cancelTextView;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        TextView r106 = this.cancelTextView;
        if (r106 == null) goto L17;
        r106.setText(r100);
    L17:
        TextView r107 = this.cancelTextView;
        if (r107 == null) goto L20;
        r107.setOnClickListener(new ViewOnClickListenerC104091(this, r101));
    L20:
        adjustMargin();
    }

    public final void setPositiveButton(CharSequence r100, final DialogInterface.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r101, "onClickListener");
        LinearLayout r102 = this.buttonLL;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        View r103 = this.divider1;
        if (r103 == null) goto L8;
        r103.setVisibility(0);
    L8:
        TextView r104 = this.confirmTextView;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        TextView r105 = this.confirmTextView;
        if (r105 == null) goto L14;
        r105.setText(r100);
    L14:
        TextView r106 = this.confirmTextView;
        if (r106 == null) goto L17;
        r106.setOnClickListener(new ViewOnClickListenerC104101(this, r101));
    L17:
        adjustMargin();
    }

    public final void setTitleTopPlaceHolderVisibility(boolean r100, int r101) {
        if (r100 == false) goto L14;
        View r102 = this.titleViewTopPlaceHolder;
        if (r102 == null) goto L6;
        r102.setVisibility(0);
    L6:
        View r103 = this.titleViewTopPlaceHolder;
        if (r103 == null) goto L18;
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L12;
        r104.height = r101;
        Unit r105 = Unit.INSTANCE;
    L13:
        r103.setLayoutParams(r104);
        return;
    L12:
        r104 = null;
        goto L13
    L18:
        return;
    L14:
        View r106 = this.titleViewTopPlaceHolder;
        if (r106 == null) goto L20;
        r106.setVisibility(8);
        return;
    }

    public static /* synthetic */ void setTitleTopPlaceHolderVisibility$default(ECAlertDialog r100, boolean r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_dialog_ECAlertDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    L5:
        r100.setTitleTopPlaceHolderVisibility(r101, r102);
    }
}
