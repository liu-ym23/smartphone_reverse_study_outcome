package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n3.j0;
import n3.k0;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f1287c;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f1288f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1289g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1290h;

    public final void a(View view) {
        if (this.f1288f.contains(view)) {
            this.f1287c.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        view.getTag(R.id.fragment_container_view_tag);
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        m1 m1VarD;
        windowInsets.getClass();
        m1 m1VarH = m1.h(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1289g;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            windowInsetsOnApplyWindowInsets.getClass();
            m1VarD = m1.h(null, windowInsetsOnApplyWindowInsets);
        } else {
            m1VarD = k0.d(this, m1VarH);
        }
        if (!m1VarD.f8737a.s()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                WeakHashMap weakHashMap = k0.f8724a;
                WindowInsets windowInsetsG = m1VarD.g();
                if (windowInsetsG != null) {
                    WindowInsets windowInsetsA = j0.a(childAt, windowInsetsG);
                    if (!windowInsetsA.equals(windowInsetsG)) {
                        m1.h(childAt, windowInsetsA);
                    }
                }
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.getClass();
        if (this.f1290h) {
            ArrayList arrayList = this.f1287c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        ArrayList arrayList = this.f1287c;
        canvas.getClass();
        view.getClass();
        if (this.f1290h && !arrayList.isEmpty() && arrayList.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        view.getClass();
        this.f1288f.remove(view);
        if (this.f1287c.remove(view)) {
            this.f1290h = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends e> F getFragment() {
        j jVar;
        View view = this;
        while (view != null) {
            view.getTag(R.id.fragment_container_view_tag);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        Context context = getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                jVar = null;
                break;
            }
            if (context instanceof j) {
                jVar = (j) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (jVar == null) {
            ad.o.f("View ", this, " is not within a subclass of FragmentActivity.");
            return null;
        }
        u supportFragmentManager = jVar.getSupportFragmentManager();
        getId();
        supportFragmentManager.g();
        return null;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        windowInsets.getClass();
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                childAt.getClass();
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        view.getClass();
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        childAt.getClass();
        a(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        view.getClass();
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i3) {
        int i10 = i + i3;
        for (int i11 = i; i11 < i10; i11++) {
            View childAt = getChildAt(i11);
            childAt.getClass();
            a(childAt);
        }
        super.removeViews(i, i3);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i3) {
        int i10 = i + i3;
        for (int i11 = i; i11 < i10; i11++) {
            View childAt = getChildAt(i11);
            childAt.getClass();
            a(childAt);
        }
        super.removeViewsInLayout(i, i3);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f1290h = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        onApplyWindowInsetsListener.getClass();
        this.f1289g = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        view.getClass();
        if (view.getParent() == this) {
            this.f1288f.add(view);
        }
        super.startViewTransition(view);
    }
}
