package com.bytedance.android.ui.ec.widget.checkbox;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.ui.ec.widget.tools.DrawableHelper;
import com.bytedance.android.ui.ec.widget.tools.ViewExtensionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0014J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u0012\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010\u0018J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\nJ\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "buttonDrawable", "Landroid/graphics/drawable/Drawable;", "checkedColorFilter", "Landroid/graphics/ColorFilter;", "colorChecked", "colorUnchecked", "disableClick", "iconSize", "isChecked", "onCheckedChangeListener", "Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox$OnCheckedChangeListener;", "shape", "size", "uncheckedColorFilter", "createColorFilter", "", "init", "onAttachedToWindow", "onCreateDrawableState", "", "extraSpace", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "setChecked", "newValue", "setOnCheckedChangeListener", "listener", "setShape", "type", "setSize", "syncButtonCheckState", "syncDrawableStyle", "toggle", "Companion", "OnCheckedChangeListener", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCheckBox extends AppCompatImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int CIRCLE = 0;
    public static final Companion Companion = null;
    public static final int LARGE = 1;
    public static final int SMALL = 0;
    public static final int SQUARE = 1;
    private boolean adaptForCSR;
    private Drawable buttonDrawable;
    private ColorFilter checkedColorFilter;
    private int colorChecked;
    private int colorUnchecked;
    private boolean disableClick;
    private int iconSize;
    private boolean isChecked;
    private OnCheckedChangeListener onCheckedChangeListener;
    private int shape;
    private int size;
    private ColorFilter uncheckedColorFilter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox$Companion;", "", "()V", "CHECKED_STATE_SET", "", "CIRCLE", "", "LARGE", "SMALL", "SQUARE", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox$OnCheckedChangeListener;", "", "onCheckedChanged", "", "buttonView", "Lcom/bytedance/android/ui/ec/widget/checkbox/ECCheckBox;", "isChecked", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnCheckedChangeListener {
        void onCheckedChanged(ECCheckBox r100, boolean r101);
    }

    static {
        Companion = new Companion(null);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    private final void createColorFilter() {
        int r100 = this.colorChecked;
        if (r100 == (-1)) goto L6;
        this.checkedColorFilter = DrawableHelper.INSTANCE.createTintBlackColorFilter(r100);
    L6:
        if (this.colorUnchecked == (-1)) goto L9;
        this.uncheckedColorFilter = new PorterDuffColorFilter(this.colorUnchecked, PorterDuff.Mode.SRC_IN);
        return;
    }

    private final void syncDrawableStyle() {
        int r100 = this.shape;
        if (r100 != 0) goto L5;
        Drawable r101 = getResources().getDrawable(com.larus.nova.R.drawable.ec_dux_checkbox_circle_always_light);
    L8:
        this.buttonDrawable = r101;
        setImageDrawable(r101);
        return;
    L5:
        if (r100 == 0) goto L7;
        r101 = getResources().getDrawable(com.larus.nova.R.drawable.ec_dux_checkbox_square_always_light);
        goto L8
    L7:
        r101 = getResources().getDrawable(com.larus.nova.R.drawable.ec_dux_checkbox_circle_always_light);
        goto L8
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }

    private final void syncButtonCheckState() {
        Drawable r100 = getDrawable();
        if (r100 == null) goto L5;
        r100.clearColorFilter();
    L5:
        createColorFilter();
        Drawable r101 = getDrawable();
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.isChecked == false) goto L10;
        ColorFilter r102 = this.checkedColorFilter;
    L11:
        r101.setColorFilter(r102);
        return;
    L10:
        r102 = this.uncheckedColorFilter;
        goto L11
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.adaptForCSR == false) goto L6;
        ViewExtensionsKt.expandTouchArea(this, MathKt.roundToInt(TypedValue.applyDimension(1, 44, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
        return;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r100 = super.performClick();
        if (r100 == true) goto L5;
        playSoundEffect(0);
    L5:
        return r100;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    public ECCheckBox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r100, null, 0, 4, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.isChecked == false) goto L5;
        access$mergeDrawableStates$s2666181(r101, CHECKED_STATE_SET);
    L5:
        return r101;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.disableClick == false) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.isChecked == r100) goto L8;
        this.isChecked = r100;
        syncButtonCheckState();
        refreshDrawableState();
        OnCheckedChangeListener r101 = this.onCheckedChangeListener;
        if (r101 == null) goto L9;
        r101.onCheckedChanged(this, this.isChecked);
        return;
    L9:
        return;
    }

    public final void setOnCheckedChangeListener(OnCheckedChangeListener r100) {
        this.onCheckedChangeListener = r100;
    }

    public final void setShape(int r100) {
        this.shape = r100;
        syncDrawableStyle();
        invalidate();
    }

    public final void setSize(int r100) {
        this.size = r100;
        if (r100 != 0) goto L5;
        int r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
    L6:
        this.iconSize = r101;
        requestLayout();
        return;
    L5:
        r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 20, INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_checkbox_ECCheckBox_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())));
        goto L6
    }

    public ECCheckBox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init$default(this, r100, r101, 0, 4, null);
    }

    public static final /* synthetic */ int[] access$mergeDrawableStates$s2666181(int[] r100, int[] r101) {
        return View.mergeDrawableStates(r100, r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = this.iconSize;
        if (r102 <= 0) goto L5;
        r100 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L5:
        int r103 = this.iconSize;
        if (r103 <= 0) goto L8;
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L8:
        super.onMeasure(r100, r101);
    }

    public ECCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.colorChecked = -1;
        this.colorUnchecked = -1;
        this.adaptForCSR = true;
        init(r100, r101, r102);
    }

    private final void init(Context r100, AttributeSet r101, int r102) {
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.adapt_for_csr, com.larus.nova.R.attr.checkBoxButton, com.larus.nova.R.attr.checkBoxCheckedColor, com.larus.nova.R.attr.checkBoxShape, com.larus.nova.R.attr.checkBoxSize, com.larus.nova.R.attr.checkBoxUncheckedColor, com.larus.nova.R.attr.disableClick}, r102, 0);
        this.shape = r103.getInt(3, 0);
        this.size = r103.getInt(4, 0);
        this.adaptForCSR = r103.getBoolean(0, true);
        this.colorChecked = r103.getColor(2, -1);
        this.colorUnchecked = r103.getColor(5, -1);
        Drawable r104 = r103.getDrawable(1);
        if (r104 != null) goto L5;
        r104 = getResources().getDrawable(com.larus.nova.R.drawable.ec_dux_checkbox_circle_always_light);
    L5:
        this.buttonDrawable = r104;
        this.disableClick = r103.getBoolean(6, false);
        r103.recycle();
        createColorFilter();
        setShape(this.shape);
        setSize(this.size);
        setBackgroundDrawable(null);
        syncButtonCheckState();
        setClickable(true);
    }

    public static /* synthetic */ void init$default(ECCheckBox r100, Context r101, AttributeSet r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = com.larus.nova.R.attr.DuxCheckBoxStyle;
    L5:
        r100.init(r101, r102, r103);
    }
}
