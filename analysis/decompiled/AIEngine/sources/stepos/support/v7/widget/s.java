package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.stepos.aiengine.R;
import stepos.support.v7.app.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f12843e = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f12844a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12845b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12846c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12847d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @SuppressLint({"RestrictedApi"})
    public class a extends LinearLayoutCompat implements View.OnLongClickListener {
        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.f.class.getName());
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.f.class.getName());
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            getLocationOnScreen(new int[2]);
            Context context = getContext();
            getWidth();
            getHeight();
            int i10 = context.getResources().getDisplayMetrics().widthPixels;
            throw null;
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public final void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int i12 = s.f12843e;
            throw null;
        }

        @Override // android.view.View
        public final void setSelected(boolean z) {
            boolean z3 = isSelected() != z;
            super.setSelected(z);
            if (z3 && z) {
                sendAccessibilityEvent(4);
            }
            int i10 = s.f12843e;
            throw null;
        }
    }

    static {
        x0.a.a(0.17f, 0.17f, 0.2f, 1.0f);
        x0.a.a(0.33f, 0.0f, 0.83f, 0.83f);
        x0.a.a(0.17f, 0.17f, 0.2f, 1.0f);
        new DecelerateInterpolator();
    }

    private void setSelectedTabView(int i10) {
        throw null;
    }

    public final void a(boolean z) throws Resources.NotFoundException {
        int dimensionPixelSize;
        if (this.f12847d != z) {
            this.f12847d = z;
            Context context = fe.a.a(getContext()).f8850a;
            if (this.f12847d) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ce.a.f3420j, R.attr.steposToolbarStyleFullScreen, 0);
                dimensionPixelSize = typedArrayObtainStyledAttributes.getLayoutDimension(13, context.getResources().getDimensionPixelSize(R.dimen.stepos_action_button_min_height_appcompat));
                typedArrayObtainStyledAttributes.recycle();
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_stacked_max_height);
            }
            setContentHeight(dimensionPixelSize);
        }
    }

    public final boolean b() {
        return this.f12845b && !this.f12847d;
    }

    public float getContentBottom() {
        throw null;
    }

    public int getContentStart() {
        getPaddingStart();
        throw null;
    }

    public int getTabStripWidth() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        int dimensionPixelSize;
        Context context = fe.a.a(getContext()).f8850a;
        if (this.f12847d) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ce.a.f3420j, R.attr.steposToolbarStyleFullScreen, 0);
            dimensionPixelSize = typedArrayObtainStyledAttributes.getLayoutDimension(13, context.getResources().getDimensionPixelSize(R.dimen.stepos_action_button_min_height_appcompat));
            typedArrayObtainStyledAttributes.recycle();
        } else {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_stacked_max_height);
        }
        if (b()) {
            setContentHeight((int) l8.f.a(55.0f, getContext()));
        } else {
            setContentHeight(dimensionPixelSize);
        }
        context.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((a) view).getClass();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        setFillViewport(View.MeasureSpec.getMode(i10) == 1073741824);
        setTabsGravity(this.f12844a);
        throw null;
    }

    public void setAdaptTabWidthNoScroll(boolean z) {
        if (this.f12846c == z) {
            return;
        }
        this.f12846c = z;
        requestLayout();
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.f12845b = z;
        if (b()) {
            new de.a().f8490a = (int) l8.f.a(16.0f, getContext());
            throw null;
        }
    }

    public void setContentHeight(int i10) {
        requestLayout();
    }

    public void setIndicatorDrawable(Drawable drawable) {
        throw null;
    }

    public void setTabSelected(int i10) {
        throw null;
    }

    public void setTabsGravity(int i10) {
        this.f12844a = i10;
    }

    private void setTabsGravityInner(int i10) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
    }

    public void setEqualTabWidth(boolean z) {
    }

    public void setIsAloneTabContainer(boolean z) {
    }

    public void setNeedCollapse(boolean z) {
    }
}
