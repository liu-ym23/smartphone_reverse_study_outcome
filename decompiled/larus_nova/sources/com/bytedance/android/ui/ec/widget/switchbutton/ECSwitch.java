package com.bytedance.android.ui.ec.widget.switchbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/switchbutton/ECSwitch;", "Lcom/bytedance/android/ui/ec/widget/switchbutton/CustomSwitchCompat;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "onAttachedToWindow", "", "setChecked", "checked", "setCheckedInner", "withHapticFeedback", "withAnim", "setCheckedWithoutFeedback", "setEnabled", "enabled", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSwitch extends CustomSwitchCompat {
    private boolean adaptForCSR;

    public ECSwitch(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECSwitch(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        ViewExtensionsKt.expandTouchArea(this, MathKt.roundToInt(TypedValue.applyDimension(1, 45, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // com.bytedance.android.ui.ec.widget.switchbutton.CustomSwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        setCheckedInner(r100, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r100) {
        setCheckedInner(r100, false, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L5;
        float r101 = 1.0f;
    L6:
        setAlpha(r101);
        return;
    L5:
        r101 = 0.5f;
        goto L6
    }

    public ECSwitch(Context r110, AttributeSet r210, int r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r210, r211);
        this.adaptForCSR = true;
        setLayerType(1, null);
        ShapeDrawable r100 = new ShapeDrawable(new OvalShapeWithShadow(r110));
        float r101 = 21;
        r100.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r100.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        Unit r102 = Unit.INSTANCE;
        setThumbDrawable(r100);
        ShapeDrawable r103 = new ShapeDrawable();
        float r104 = 25;
        r103.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r104, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        float r105 = 43;
        r103.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r105, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        float r106 = (float) 12.5d;
        r103.setShape(new RoundRectShape(new float[]{TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r103, ContextCompat.getColor(r110, R.color.ec_dux_line_reverse));
        ShapeDrawable r107 = new ShapeDrawable();
        r107.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r104, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r107.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r105, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        r107.setShape(new RoundRectShape(new float[]{TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())), TypedValue.applyDimension(1, r106, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r107, ContextCompat.getColor(r110, R.color.ec_dux_const_switch_bg));
        TransitionDrawable r108 = new TransitionDrawable(new ShapeDrawable[]{r103, r107});
        r108.setCrossFadeEnabled(true);
        setTrackDrawable(r108);
        Drawable r109 = getTrackDrawable();
        if (r109 == null) goto L13;
        ((TransitionDrawable) r109).resetTransition();
        float r111 = 2;
        setThumbConstraintRight(MathKt.roundToInt(TypedValue.applyDimension(1, r111, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        setThumbConstraintLeft(MathKt.roundToInt(TypedValue.applyDimension(1, r111, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_switchbutton_ECSwitch_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        if (isChecked() == false) goto L11;
        Drawable r112 = getTrackDrawable();
        if (r112 == null) goto L10;
        ((TransitionDrawable) r112).startTransition(180);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L11:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    private final void setCheckedInner(boolean r100, boolean r101, boolean r102) {
        if (r100 == isChecked()) goto L21;
        if (r102 == false) goto L21;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L21;
        if (r100 == false) goto L14;
        Drawable r103 = getTrackDrawable();
        if (r103 == null) goto L13;
        ((TransitionDrawable) r103).startTransition(180);
    L17:
        if (r101 == false) goto L21;
        performHapticFeedback(1, 2);
        goto L21
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L14:
        Drawable r104 = getTrackDrawable();
        if (r104 == null) goto L20;
        ((TransitionDrawable) r104).reverseTransition(180);
        goto L17
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L21:
        super.setChecked(r100);
    }

    public /* synthetic */ ECSwitch(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
