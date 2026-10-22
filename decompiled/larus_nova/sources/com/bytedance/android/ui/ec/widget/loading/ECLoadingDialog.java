package com.bytedance.android.ui.ec.widget.loading;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\b\u0010\r\u001a\u00020\nH\u0002J$\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000fR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECLoadingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/content/DialogInterface$OnKeyListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "onCloseClickListener", "Lkotlin/Function0;", "", "addCloseClickListener", "listener", "initViews", "onKey", "", "dialog", "Landroid/content/DialogInterface;", "keyCode", "event", "Landroid/view/KeyEvent;", "setDialogCancelable", "cancelable", "setDialogWidth", "setMessage", "text", "", "setShowCloseBtn", "show", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadingDialog extends AppCompatDialog implements DialogInterface.OnKeyListener {
    private Function0<Unit> onCloseClickListener;

    public ECLoadingDialog(Context r100) {
        int r101 = 0;
        this(r100, r101, 2, null);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        return false;
    }

    private final void initViews() {
        ECDuxLoadingAnimationView r100 = (ECDuxLoadingAnimationView) findViewById(R.id.loading_view);
        if (r100 == null) goto L5;
        r100.startAnimate();
    L5:
        View r101 = findViewById(R.id.close_btn);
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        r101.setOnClickListener(new ECLoadingDialog$initViews$$inlined$apply$lambda$1(this));
        return;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ Function0 access$getOnCloseClickListener$p(ECLoadingDialog r100) {
        return r100.onCloseClickListener;
    }

    private final void setDialogWidth(Context r100) {
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -2;
        r102.height = -2;
        r101.setAttributes(r102);
        float r103 = 10;
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r103, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r101.setGravity(17);
        r101.setDimAmount(0.0f);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        return;
    }

    public final void addCloseClickListener(Function0<Unit> r100) {
        this.onCloseClickListener = r100;
    }

    public final void setDialogCancelable(boolean r100) {
        setCancelable(r100);
        setCanceledOnTouchOutside(r100);
    }

    public final void setMessage(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L14;
        TextView r102 = (TextView) findViewById(R.id.text_view);
        if (r102 == null) goto L15;
        r102.setText(r100);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setShowCloseBtn(final boolean r100) {
        View r101 = findViewById(R.id.close_btn);
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.setVisibility(0);
        float r102 = 60;
        ViewExtensionsKt.expandTouchAreaForTopRightCorner(r101, MathKt.roundToInt(TypedValue.applyDimension(1, r102, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r102, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_loading_ECLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r101.setOnClickListener(new ECLoadingDialog$setShowCloseBtn$$inlined$apply$lambda$1(this, r100));
        return;
    L6:
        r101.setVisibility(8);
        return;
    }

    public ECLoadingDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        requestWindowFeature(1);
        setContentView(R.layout.ec_dux_double_ball_loading_toast);
        setDialogCancelable(true);
        setDialogWidth(r100);
        initViews();
    }

    public static final /* synthetic */ void access$setOnCloseClickListener$p(ECLoadingDialog r100, Function0 r101) {
        r100.onCloseClickListener = r101;
    }

    public /* synthetic */ ECLoadingDialog(Context r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addCloseClickListener$default(ECLoadingDialog r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.addCloseClickListener(r101);
    }
}
