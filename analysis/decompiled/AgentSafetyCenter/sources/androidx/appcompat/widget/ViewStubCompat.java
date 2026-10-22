package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import g.a;
import java.lang.ref.WeakReference;
import m.y2;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: c, reason: collision with root package name */
    public int f825c;

    /* renamed from: f, reason: collision with root package name */
    public int f826f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f827g;

    /* renamed from: h, reason: collision with root package name */
    public LayoutInflater f828h;

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f825c = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.A, i, 0);
        this.f826f = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f825c = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(0, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            f.e("ViewStub must have a non-null ViewGroup viewParent");
            return null;
        }
        if (this.f825c == 0) {
            g5.f.s("ViewStub must have a valid layoutResource");
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f828h;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f825c, viewGroup, false);
        int i = this.f826f;
        if (i != -1) {
            viewInflate.setId(i);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f827g = new WeakReference(viewInflate);
        return viewInflate;
    }

    public int getInflatedId() {
        return this.f826f;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f828h;
    }

    public int getLayoutResource() {
        return this.f825c;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f826f = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f828h = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f825c = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference weakReference = this.f827g;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            } else {
                f.e("setVisibility called on un-referenced view");
                return;
            }
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public void setOnInflateListener(y2 y2Var) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
