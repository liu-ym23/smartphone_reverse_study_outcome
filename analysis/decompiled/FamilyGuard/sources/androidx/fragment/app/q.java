package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class q implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    final x f10713a;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ E f10714a;

        a(E e6) {
            this.f10714a = e6;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ComponentCallbacksC0511f componentCallbacksC0511fK = this.f10714a.k();
            this.f10714a.m();
            M.n((ViewGroup) componentCallbacksC0511fK.f10613I.getParent(), q.this.f10713a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    q(x xVar) {
        this.f10713a = xVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        E eT;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f10713a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, S.c.f5201a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(S.c.f5202b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(S.c.f5203c, -1);
        String string = typedArrayObtainStyledAttributes.getString(S.c.f5204d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !C0520o.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        ComponentCallbacksC0511f componentCallbacksC0511fF0 = resourceId != -1 ? this.f10713a.f0(resourceId) : null;
        if (componentCallbacksC0511fF0 == null && string != null) {
            componentCallbacksC0511fF0 = this.f10713a.g0(string);
        }
        if (componentCallbacksC0511fF0 == null && id != -1) {
            componentCallbacksC0511fF0 = this.f10713a.f0(id);
        }
        if (componentCallbacksC0511fF0 == null) {
            componentCallbacksC0511fF0 = this.f10713a.q0().a(context.getClassLoader(), attributeValue);
            componentCallbacksC0511fF0.f10646o = true;
            componentCallbacksC0511fF0.f10655x = resourceId != 0 ? resourceId : id;
            componentCallbacksC0511fF0.f10656y = id;
            componentCallbacksC0511fF0.f10657z = string;
            componentCallbacksC0511fF0.f10647p = true;
            x xVar = this.f10713a;
            componentCallbacksC0511fF0.f10651t = xVar;
            componentCallbacksC0511fF0.f10652u = xVar.s0();
            componentCallbacksC0511fF0.H0(this.f10713a.s0().f(), attributeSet, componentCallbacksC0511fF0.f10630b);
            eT = this.f10713a.h(componentCallbacksC0511fF0);
            if (x.F0(2)) {
                Log.v("FragmentManager", "Fragment " + componentCallbacksC0511fF0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (componentCallbacksC0511fF0.f10647p) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            componentCallbacksC0511fF0.f10647p = true;
            x xVar2 = this.f10713a;
            componentCallbacksC0511fF0.f10651t = xVar2;
            componentCallbacksC0511fF0.f10652u = xVar2.s0();
            componentCallbacksC0511fF0.H0(this.f10713a.s0().f(), attributeSet, componentCallbacksC0511fF0.f10630b);
            eT = this.f10713a.t(componentCallbacksC0511fF0);
            if (x.F0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + componentCallbacksC0511fF0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        T.c.g(componentCallbacksC0511fF0, viewGroup);
        componentCallbacksC0511fF0.f10612H = viewGroup;
        eT.m();
        eT.j();
        View view2 = componentCallbacksC0511fF0.f10613I;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (componentCallbacksC0511fF0.f10613I.getTag() == null) {
            componentCallbacksC0511fF0.f10613I.setTag(string);
        }
        componentCallbacksC0511fF0.f10613I.addOnAttachStateChangeListener(new a(eT));
        return componentCallbacksC0511fF0.f10613I;
    }
}
