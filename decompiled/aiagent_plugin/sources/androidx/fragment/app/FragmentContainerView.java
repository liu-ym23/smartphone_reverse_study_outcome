package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private ArrayList<View> mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst;
    private ArrayList<View> mTransitioningFragmentViews;

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r1) {
        return r1;
    }

    public FragmentContainerView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mDrawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public FragmentContainerView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mDrawDisappearingViewsFirst = true;
        if (r7 == null) goto L15;
        String r8 = r7.getClassAttribute();
        TypedArray r9 = r6.obtainStyledAttributes(r7, R.styleable.FragmentContainerView);
        if (r8 != null) goto L7;
        r8 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.FragmentContainerView_android_name, "styleable", "FragmentContainerView_android_name"));
        String r10 = "android:name";
    L8:
        r9.recycle();
        if (r8 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r10 + "=\"" + r8 + "\"");
    L7:
        r10 = "class";
        goto L8
    }

    FragmentContainerView(Context r7, AttributeSet r8, FragmentManager r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r10, r11);
        this.mDrawDisappearingViewsFirst = true;
        String r1 = r11.getClassAttribute();
        TypedArray r2 = r10.obtainStyledAttributes(r11, R.styleable.FragmentContainerView);
        if (r1 != null) goto L5;
        r1 = r2.getString(ZeusTransformUtils.mapRes(R.styleable.FragmentContainerView_android_name, "styleable", "FragmentContainerView_android_name"));
    L5:
        String r3 = r2.getString(ZeusTransformUtils.mapRes(R.styleable.FragmentContainerView_android_tag, "styleable", "FragmentContainerView_android_tag"));
        r2.recycle();
        int r4 = getId();
        Fragment r5 = r9.c(r4);
        if (r1 == null) goto L15;
        if (r5 != null) goto L15;
        if (r4 > 0) goto L14;
        if (r3 == null) goto L11;
        String r6 = " with tag " + r3;
    L13:
        throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + r1 + r6);
    L11:
        r6 = "";
        goto L13
    L14:
        Fragment r12 = r9.D().c(r10.getClassLoader(), r1);
        r12.onInflate(r10, r11, null);
        r9.a().c(true).a(this, r12, r3).e();
    L15:
        r9.a(this);
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r3) {
        if (Build.VERSION.SDK_INT >= 18) goto L7;
        super.setLayoutTransition(r3);
        return;
    L7:
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener r3) {
        this.mApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnApplyWindowInsetsListener.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r5) {
        al r0 = al.a(r5);
        View.OnApplyWindowInsetsListener r1 = this.mApplyWindowInsetsListener;
        if (r1 == null) goto L5;
        al r2 = al.a(r1.onApplyWindowInsets(this, r5));
    L7:
        if (r2.f() == true) goto L11;
        int r3 = getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        ViewCompat.b(getChildAt(r4), r2);
        r4 = r4 + 1;
    L11:
        return r5;
    L5:
        r2 = ViewCompat.a(this, r0);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        if (this.mDrawDisappearingViewsFirst == true) goto L5;
    L10:
        super.dispatchDraw(r5);
        return;
    L5:
        if (this.mDisappearingFragmentChildren == null) goto L10;
        int r0 = 0;
    L8:
        if (r0 >= this.mDisappearingFragmentChildren.size()) goto L10;
        super.drawChild(r5, (View) ZeusTransformUtils.preCheckCast(this.mDisappearingFragmentChildren.get(r0), View.class, "com.obric.aiagent.plugin"), getDrawingTime());
        r0 = r0 + 1;
        goto L8
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r2, View r3, long r4) {
        if (this.mDrawDisappearingViewsFirst == false) goto L13;
        ArrayList<View> r0 = this.mDisappearingFragmentChildren;
        if (r0 == null) goto L13;
        if (r0.size() <= 0) goto L13;
        if (this.mDisappearingFragmentChildren.contains(r3) == false) goto L13;
        return false;
    L13:
        return super.drawChild(r2, r3, r4);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View r2) {
        if (r2.getParent() == this) goto L5;
    L8:
        super.startViewTransition(r2);
        return;
    L5:
        if (this.mTransitioningFragmentViews != null) goto L7;
        this.mTransitioningFragmentViews = new ArrayList();
    L7:
        this.mTransitioningFragmentViews.add(r2);
        goto L8
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View r2) {
        ArrayList<View> r0 = this.mTransitioningFragmentViews;
        if (r0 == null) goto L9;
        r0.remove(r2);
        ArrayList<View> r1 = this.mDisappearingFragmentChildren;
        if (r1 == null) goto L9;
        if (r1.remove(r2) == false) goto L9;
        this.mDrawDisappearingViewsFirst = true;
    L9:
        super.endViewTransition(r2);
    }

    void setDrawDisappearingViewsLast(boolean r1) {
        this.mDrawDisappearingViewsFirst = r1;
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (FragmentManager.a(r2) == null) goto L7;
        super.addView(r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + r2 + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View r2, int r3, ViewGroup.LayoutParams r4, boolean r5) {
        if (FragmentManager.a(r2) == null) goto L7;
        return super.addViewInLayout(r2, r3, r4, r5);
    L7:
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + r2 + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r2) {
        addDisappearingFragmentView(getChildAt(r2));
        super.removeViewAt(r2);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View r1) {
        addDisappearingFragmentView(r1);
        super.removeViewInLayout(r1);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r1) {
        addDisappearingFragmentView(r1);
        super.removeView(r1);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r3, int r4) {
        int r0 = r3;
    L4:
        if (r0 >= (r3 + r4)) goto L6;
        addDisappearingFragmentView(getChildAt(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        super.removeViews(r3, r4);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r3, int r4) {
        int r0 = r3;
    L4:
        if (r0 >= (r3 + r4)) goto L6;
        addDisappearingFragmentView(getChildAt(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        super.removeViewsInLayout(r3, r4);
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        addDisappearingFragmentView(getChildAt(r0));
        r0 = r0 - 1;
        goto L3
    L5:
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r1, boolean r2) {
        if (r2 == false) goto L4;
        addDisappearingFragmentView(r1);
    L4:
        super.removeDetachedView(r1, r2);
    }

    private void addDisappearingFragmentView(View r2) {
        ArrayList<View> r0 = this.mTransitioningFragmentViews;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.contains(r2) == true) goto L7;
        return;
    L7:
        if (this.mDisappearingFragmentChildren != null) goto L9;
        this.mDisappearingFragmentChildren = new ArrayList();
    L9:
        this.mDisappearingFragmentChildren.add(r2);
    }
}
