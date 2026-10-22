package com.bytedance.android.ui.ec.widget.feedback;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.core.RetryPolicy;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020#2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010,\u001a\u00020#R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/android/ui/ec/widget/feedback/ECFeedbackEnterView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleEventObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "buttonText", "", "callback", "Lcom/bytedance/android/ui/ec/widget/feedback/ECFeedbackEnterView$OnFeedbackCallback;", "cornerRadiusDp", "iconResId", "iconSizeDp", "iconTextSpacingDp", "iconView", "Landroid/widget/ImageView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "paddingHorizontalDp", "paddingVerticalDp", "removeViewRunnable", "Ljava/lang/Runnable;", "rootView", "Landroid/view/ViewGroup;", "textColor", "textSizeSp", "", "textView", "Landroid/widget/TextView;", MapMonitorConst.EVENT_DESTROY, "", "initIconView", "initLifecycleListener", "initTextView", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setOnFeedBackCallBack", "show", "OnFeedbackCallback", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFeedbackEnterView extends FrameLayout implements LifecycleEventObserver {
    private final int bgColor;
    private final String buttonText;
    private OnFeedbackCallback callback;
    private final int cornerRadiusDp;
    private final int iconResId;
    private final int iconSizeDp;
    private final int iconTextSpacingDp;
    private final ImageView iconView;
    private LifecycleOwner lifecycleOwner;
    private final int paddingHorizontalDp;
    private final int paddingVerticalDp;
    private final Runnable removeViewRunnable;
    private ViewGroup rootView;
    private final int textColor;
    private final float textSizeSp;
    private final TextView textView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/feedback/ECFeedbackEnterView$OnFeedbackCallback;", "", "onFeedBackClick", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnFeedbackCallback {
        void onFeedBackClick();
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
        }
    }

    public ECFeedbackEnterView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECFeedbackEnterView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void destroy() {
        removeCallbacks(this.removeViewRunnable);
        this.removeViewRunnable.run();
    }

    private final void initIconView() {
        int r100 = UnitExtensionKt.dp2px(this.iconSizeDp);
        Drawable r101 = ContextCompat.getDrawable(getContext(), this.iconResId);
        this.iconView.setImageDrawable(r101);
        this.iconView.setLayoutParams(new FrameLayout.LayoutParams(r100, r100));
        this.iconView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private final void initTextView() {
        this.textView.setText(this.buttonText);
        this.textView.setTextColor(this.textColor);
        this.textView.setTextSize(this.textSizeSp);
        this.textView.setGravity(17);
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-2, -1);
        r100.leftMargin = UnitExtensionKt.dp2px(this.iconTextSpacingDp);
        r100.bottomMargin = UnitExtensionKt.dp2px(2);
        this.textView.setLayoutParams(r100);
    }

    public final void show() {
        removeCallbacks(this.removeViewRunnable);
        Context r100 = getContext();
        ViewGroup r101 = null;
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r102 = (Activity) r100;
        if (r102 == null) goto L8;
        r101 = (ViewGroup) r102.findViewById(R.id.content);
    L8:
        this.rootView = r101;
        if (r101 != null) goto L11;
    L13:
        postDelayed(this.removeViewRunnable, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        return;
    L11:
        if (r101.indexOfChild(this) != (-1)) goto L13;
        r101.addView(this);
        goto L13
    }

    private final void initLifecycleListener() {
        if ((getContext() instanceof LifecycleOwner) == false) goto L13;
        Object r100 = getContext();
        Lifecycle r101 = null;
        if ((r100 instanceof LifecycleOwner) == true) goto L7;
        r100 = null;
    L7:
        LifecycleOwner r102 = (LifecycleOwner) r100;
        this.lifecycleOwner = r102;
        if (r102 == null) goto L10;
        r101 = r102.getLifecycle();
    L10:
        if (r101 == null) goto L14;
        r101.addObserver(this);
        return;
    L14:
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_feedback_ECFeedbackEnterView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ OnFeedbackCallback access$getCallback$p(ECFeedbackEnterView r100) {
        return r100.callback;
    }

    public static final /* synthetic */ ViewGroup access$getRootView$p(ECFeedbackEnterView r100) {
        return r100.rootView;
    }

    public final void setOnFeedBackCallBack(OnFeedbackCallback r100) {
        this.callback = r100;
    }

    public static final /* synthetic */ void access$setCallback$p(ECFeedbackEnterView r100, OnFeedbackCallback r101) {
        r100.callback = r101;
    }

    public static final /* synthetic */ void access$setRootView$p(ECFeedbackEnterView r100, ViewGroup r101) {
        r100.rootView = r101;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (WhenMappings.$EnumSwitchMapping$0[r101.ordinal()] != 1) goto L7;
        destroy();
        this.lifecycleOwner = null;
        return;
    }

    public ECFeedbackEnterView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        int r112 = ColorProtector.parseColor("#B3000000");
        this.bgColor = r112;
        this.textColor = -1;
        this.textSizeSp = 12.0f;
        this.iconSizeDp = 16;
        this.cornerRadiusDp = 8;
        this.paddingHorizontalDp = 10;
        this.paddingVerticalDp = 8;
        this.iconTextSpacingDp = 4;
        this.iconResId = com.larus.nova.R.drawable.ic_s_s_ec_feedback_16;
        this.buttonText = "功能反馈";
        ImageView r101 = new ImageView(r100);
        this.iconView = r101;
        TextView r102 = new TextView(r100);
        this.textView = r102;
        this.removeViewRunnable = new ECFeedbackEnterView$removeViewRunnable$1(this);
        initLifecycleListener();
        LinearLayout r103 = new LinearLayout(r100);
        r103.setOrientation(0);
        r103.setGravity(16);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 16;
        r104.leftMargin = UnitExtensionKt.dp2px(16);
        Unit r113 = Unit.INSTANCE;
        r103.setLayoutParams(r104);
        r103.setClickable(true);
        r103.setFocusable(true);
        float r105 = TypedValue.applyDimension(1, 8, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_feedback_ECFeedbackEnterView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
        GradientDrawable r106 = new GradientDrawable();
        r106.setShape(0);
        r106.setColor(r112);
        r106.setCornerRadii(new float[]{r105, r105, r105, r105, r105, r105, r105, r105});
        r103.setBackground(r106);
        r103.setPadding(UnitExtensionKt.dp2px(10), UnitExtensionKt.dp2px(8), UnitExtensionKt.dp2px(10), UnitExtensionKt.dp2px(8));
        initIconView();
        initTextView();
        r103.addView(r101);
        r103.addView(r102);
        r103.setOnClickListener(new AnonymousClass1(this));
        addView(r103);
    }

    public /* synthetic */ ECFeedbackEnterView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
