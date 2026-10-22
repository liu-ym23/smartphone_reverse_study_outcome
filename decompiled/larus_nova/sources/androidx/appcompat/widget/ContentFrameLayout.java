package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor != null) goto L6;
        this.mFixedHeightMajor = new TypedValue();
    L6:
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor != null) goto L6;
        this.mFixedHeightMinor = new TypedValue();
    L6:
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor != null) goto L6;
        this.mFixedWidthMajor = new TypedValue();
    L6:
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor != null) goto L6;
        this.mFixedWidthMinor = new TypedValue();
    L6:
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor != null) goto L6;
        this.mMinWidthMajor = new TypedValue();
    L6:
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor != null) goto L6;
        this.mMinWidthMinor = new TypedValue();
    L6:
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener r100 = this.mAttachListener;
        if (r100 == null) goto L6;
        r100.onAttachedFromWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener r100 = this.mAttachListener;
        if (r100 == null) goto L6;
        r100.onDetachedFromWindow();
        return;
    }

    public ContentFrameLayout(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ContentFrameLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void dispatchFitSystemWindows(Rect r100) {
        fitSystemWindows(r100);
    }

    public void setAttachListener(OnAttachListener r100) {
        this.mAttachListener = r100;
    }

    public ContentFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r110, int r111) {
        DisplayMetrics r100 = INVOKEVIRTUAL_androidx_appcompat_widget_ContentFrameLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getContext().getResources());
        boolean r101 = true;
        if (r100.widthPixels >= r100.heightPixels) goto L5;
        boolean r102 = true;
    L6:
        int r103 = View.MeasureSpec.getMode(r110);
        int r104 = View.MeasureSpec.getMode(r111);
        if (r103 != Integer.MIN_VALUE) goto L22;
        if (r102 == false) goto L10;
        TypedValue r112 = this.mFixedWidthMinor;
    L11:
        if (r112 == null) goto L22;
        int r113 = r112.type;
        if (r113 == 0) goto L22;
        if (r113 != 5) goto L17;
        float r114 = r112.getDimension(r100);
    L16:
        int r115 = (int) r114;
    L20:
        if (r115 <= 0) goto L22;
        Rect r116 = this.mDecorPadding;
        r110 = View.MeasureSpec.makeMeasureSpec(Math.min(r115 - (r116.left + r116.right), View.MeasureSpec.getSize(r110)), 1073741824);
        boolean r117 = true;
    L23:
        if (r104 != Integer.MIN_VALUE) goto L38;
        if (r102 == false) goto L26;
        TypedValue r105 = this.mFixedHeightMajor;
    L27:
        if (r105 == null) goto L38;
        int r118 = r105.type;
        if (r118 == 0) goto L38;
        if (r118 != 5) goto L33;
        float r106 = r105.getDimension(r100);
    L32:
        int r107 = (int) r106;
    L36:
        if (r107 <= 0) goto L38;
        Rect r119 = this.mDecorPadding;
        r111 = View.MeasureSpec.makeMeasureSpec(Math.min(r107 - (r119.top + r119.bottom), View.MeasureSpec.getSize(r111)), 1073741824);
        goto L38
    L33:
        if (r118 != 6) goto L35;
        int r120 = r100.heightPixels;
        r106 = r105.getFraction(r120, r120);
        goto L32
    L35:
        r107 = 0;
        goto L36
    L26:
        r105 = this.mFixedHeightMinor;
    L38:
        super.onMeasure(r110, r111);
        int r121 = getMeasuredWidth();
        int r108 = View.MeasureSpec.makeMeasureSpec(r121, 1073741824);
        if (r117 == true) goto L57;
        if (r103 != Integer.MIN_VALUE) goto L57;
        if (r102 == false) goto L43;
        TypedValue r109 = this.mMinWidthMinor;
    L44:
        if (r109 == null) goto L57;
        int r122 = r109.type;
        if (r122 == 0) goto L57;
        if (r122 != 5) goto L50;
        float r123 = r109.getDimension(r100);
    L49:
        int r124 = (int) r123;
    L53:
        if (r124 <= 0) goto L55;
        Rect r125 = this.mDecorPadding;
        r124 = r124 - (r125.left + r125.right);
    L55:
        if (r121 >= r124) goto L57;
        r108 = View.MeasureSpec.makeMeasureSpec(r124, 1073741824);
    L58:
        if (r101 == false) goto L61;
        super.onMeasure(r108, r111);
        return;
    L61:
        return;
    L50:
        if (r122 != 6) goto L52;
        int r126 = r100.widthPixels;
        r123 = r109.getFraction(r126, r126);
        goto L49
    L52:
        r124 = 0;
        goto L53
    L43:
        r109 = this.mMinWidthMajor;
    L57:
        r101 = false;
        goto L58
    L17:
        if (r113 != 6) goto L19;
        int r127 = r100.widthPixels;
        r114 = r112.getFraction(r127, r127);
        goto L16
    L19:
        r115 = 0;
        goto L20
    L10:
        r112 = this.mFixedWidthMajor;
    L22:
        r117 = false;
        goto L23
    L5:
        r102 = false;
        goto L6
    }

    public ContentFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mDecorPadding = new Rect();
    }

    public void setDecorPadding(int r100, int r101, int r102, int r103) {
        this.mDecorPadding.set(r100, r101, r102, r103);
        if (ViewCompat.isLaidOut(this) == false) goto L6;
        requestLayout();
        return;
    }
}
