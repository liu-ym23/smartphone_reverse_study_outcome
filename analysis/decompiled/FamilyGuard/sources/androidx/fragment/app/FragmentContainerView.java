package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.Y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final List<View> f10423a;

    /* renamed from: b, reason: collision with root package name */
    private final List<View> f10424b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f10425c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10426d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f10427a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            j4.k.g(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            j4.k.g(view, "v");
            j4.k.g(windowInsets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            j4.k.f(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        j4.k.g(context, "context");
    }

    private final void a(View view) {
        if (this.f10424b.contains(view)) {
            this.f10423a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        j4.k.g(view, "child");
        if (x.z0(view) != null) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        Y yW;
        j4.k.g(windowInsets, "insets");
        Y yT = Y.t(windowInsets);
        j4.k.f(yT, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f10425c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f10427a;
            j4.k.d(onApplyWindowInsetsListener);
            yW = Y.t(aVar.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            yW = androidx.core.view.H.W(this, yT);
        }
        j4.k.f(yW, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!yW.n()) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                androidx.core.view.H.g(getChildAt(i5), yW);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        j4.k.g(canvas, "canvas");
        if (this.f10426d) {
            Iterator<T> it = this.f10423a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j5) {
        j4.k.g(canvas, "canvas");
        j4.k.g(view, "child");
        if (this.f10426d && !this.f10423a.isEmpty() && this.f10423a.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        j4.k.g(view, "view");
        this.f10424b.remove(view);
        if (this.f10423a.remove(view)) {
            this.f10426d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends ComponentCallbacksC0511f> F getFragment() {
        return (F) x.i0(this).f0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        j4.k.g(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                j4.k.f(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        j4.k.g(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i5) {
        View childAt = getChildAt(i5);
        j4.k.f(childAt, "view");
        a(childAt);
        super.removeViewAt(i5);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        j4.k.g(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            j4.k.f(childAt, "view");
            a(childAt);
        }
        super.removeViews(i5, i6);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            j4.k.f(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i5, i6);
    }

    public final void setDrawDisappearingViewsLast(boolean z5) {
        this.f10426d = z5;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        j4.k.g(onApplyWindowInsetsListener, "listener");
        this.f10425c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        j4.k.g(view, "view");
        if (view.getParent() == this) {
            this.f10424b.add(view);
        }
        super.startViewTransition(view);
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i5, int i6, j4.g gVar) {
        this(context, attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i5) {
        String str;
        super(context, attributeSet, i5);
        j4.k.g(context, "context");
        this.f10423a = new ArrayList();
        this.f10424b = new ArrayList();
        this.f10426d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = S.c.f5205e;
            j4.k.f(iArr, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(S.c.f5206f);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, x xVar) {
        String str;
        super(context, attributeSet);
        j4.k.g(context, "context");
        j4.k.g(attributeSet, "attrs");
        j4.k.g(xVar, "fm");
        this.f10423a = new ArrayList();
        this.f10424b = new ArrayList();
        this.f10426d = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = S.c.f5205e;
        j4.k.f(iArr, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(S.c.f5206f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(S.c.f5207g);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        ComponentCallbacksC0511f componentCallbacksC0511fF0 = xVar.f0(id);
        if (classAttribute != null && componentCallbacksC0511fF0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = BuildConfig.FLAVOR;
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            ComponentCallbacksC0511f componentCallbacksC0511fA = xVar.q0().a(context.getClassLoader(), classAttribute);
            j4.k.f(componentCallbacksC0511fA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            componentCallbacksC0511fA.H0(context, attributeSet, null);
            xVar.m().v(true).d(this, componentCallbacksC0511fA, string).l();
        }
        xVar.S0(this);
    }
}
