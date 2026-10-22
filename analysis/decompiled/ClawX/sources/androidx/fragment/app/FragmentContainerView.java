package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.stepos.stepclaw.R;
import com.stepos.stepclaw.SecurePrefs;
import e0.a0;
import e0.x0;
import e0.z;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00028\u0000\"\n\b\u0000\u0010\u0010*\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/animation/LayoutTransition;", "transition", "Lb5/a0;", "setLayoutTransition", "(Landroid/animation/LayoutTransition;)V", "Landroid/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "(Landroid/view/View$OnApplyWindowInsetsListener;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "(Z)V", "Landroidx/fragment/app/f;", "F", "getFragment", "()Landroidx/fragment/app/f;", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f653a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f654b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f655c;
    public boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        p.e(context, "context");
        this.f653a = new ArrayList();
        this.f654b = new ArrayList();
        this.d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q0.a.f4838a, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + AbstractJsonLexerKt.STRING);
        }
    }

    public final void a(View view) {
        if (this.f654b.contains(view)) {
            this.f653a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int i8, ViewGroup.LayoutParams layoutParams) {
        p.e(child, "child");
        Object tag = child.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof f ? (f) tag : null) != null) {
            super.addView(child, i8, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        x0 x0VarC;
        p.e(insets, "insets");
        x0 x0VarC2 = x0.c(null, insets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f655c;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, insets);
            p.d(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            x0VarC = x0.c(null, windowInsetsOnApplyWindowInsets);
        } else {
            int[] iArr = a0.f2285a;
            WindowInsets windowInsetsB = x0VarC2.b();
            if (windowInsetsB != null && !windowInsetsB.equals(windowInsetsB)) {
                x0VarC2 = x0.c(this, windowInsetsB);
            }
            x0VarC = x0VarC2;
        }
        if (!x0VarC.f2338a.n()) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                int[] iArr2 = a0.f2285a;
                WindowInsets windowInsetsB2 = x0VarC.b();
                if (windowInsetsB2 != null) {
                    WindowInsets windowInsetsA = z.a(childAt, windowInsetsB2);
                    if (!windowInsetsA.equals(windowInsetsB2)) {
                        x0.c(childAt, windowInsetsA);
                    }
                }
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        p.e(canvas, "canvas");
        if (this.d) {
            ArrayList arrayList = this.f653a;
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View child, long j4) {
        p.e(canvas, "canvas");
        p.e(child, "child");
        if (this.d) {
            ArrayList arrayList = this.f653a;
            if (!arrayList.isEmpty() && arrayList.contains(child)) {
                return false;
            }
        }
        return super.drawChild(canvas, child, j4);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        p.e(view, "view");
        this.f654b.remove(view);
        if (this.f653a.remove(view)) {
            this.d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends f> F getFragment() {
        f fVar;
        View view = this;
        while (true) {
            fVar = null;
            if (view == null) {
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            f fVar2 = tag instanceof f ? (f) tag : null;
            if (fVar2 != null) {
                fVar = fVar2;
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (fVar != null) {
            throw new IllegalStateException("The Fragment " + fVar + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
        }
        throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        p.e(insets, "insets");
        return insets;
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
                View view = getChildAt(childCount);
                p.d(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        p.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i8) {
        View view = getChildAt(i8);
        p.d(view, "view");
        a(view);
        super.removeViewAt(i8);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        p.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i8, int i9) {
        int i10 = i8 + i9;
        for (int i11 = i8; i11 < i10; i11++) {
            View view = getChildAt(i11);
            p.d(view, "view");
            a(view);
        }
        super.removeViews(i8, i9);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i8, int i9) {
        int i10 = i8 + i9;
        for (int i11 = i8; i11 < i10; i11++) {
            View view = getChildAt(i11);
            p.d(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i8, i9);
    }

    public final void setDrawDisappearingViewsLast(boolean drawDisappearingViewsFirst) {
        this.d = drawDisappearingViewsFirst;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition transition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        p.e(listener, "listener");
        this.f655c = listener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        p.e(view, "view");
        if (view.getParent() == this) {
            this.f654b.add(view);
        }
        super.startViewTransition(view);
    }
}
