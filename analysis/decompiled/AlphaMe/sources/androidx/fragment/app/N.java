package androidx.fragment.app;

import a0.AbstractC0153a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b0.AbstractC0357c;
import b0.C0356b;
import b0.C0358d;
import b0.EnumC0355a;
import ch.qos.logback.core.joran.action.Action;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class N implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final Y f3632a;

    public N(Y y4) {
        this.f3632a = y4;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        c0 c0VarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        Y y4 = this.f3632a;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, y4);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Action.CLASS_ATTRIBUTE);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0153a.f2263a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue != null) {
            try {
                if (D.class.isAssignableFrom(T.b(context.getClassLoader(), attributeValue))) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    D fragment = resourceId != -1 ? y4.A(resourceId) : null;
                    if (fragment == null && string != null) {
                        fragment = y4.B(string);
                    }
                    if (fragment == null && id != -1) {
                        fragment = y4.A(id);
                    }
                    if (fragment == null) {
                        T tD = y4.D();
                        context.getClassLoader();
                        fragment = tD.a(attributeValue);
                        fragment.mFromLayout = true;
                        fragment.mFragmentId = resourceId != 0 ? resourceId : id;
                        fragment.mContainerId = id;
                        fragment.mTag = string;
                        fragment.mInLayout = true;
                        fragment.mFragmentManager = y4;
                        L l4 = y4.f3682u;
                        fragment.mHost = l4;
                        fragment.onInflate(l4.f3626b, attributeSet, fragment.mSavedFragmentState);
                        c0VarF = y4.a(fragment);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (fragment.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        fragment.mInLayout = true;
                        fragment.mFragmentManager = y4;
                        L l5 = y4.f3682u;
                        fragment.mHost = l5;
                        fragment.onInflate(l5.f3626b, attributeSet, fragment.mSavedFragmentState);
                        c0VarF = y4.f(fragment);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    C0356b c0356b = AbstractC0357c.f4364a;
                    Intrinsics.checkNotNullParameter(fragment, "fragment");
                    C0358d c0358d = new C0358d(fragment, viewGroup, 0);
                    AbstractC0357c.c(c0358d);
                    C0356b c0356bA = AbstractC0357c.a(fragment);
                    if (c0356bA.f4362a.contains(EnumC0355a.f4355d) && AbstractC0357c.e(c0356bA, fragment.getClass(), C0358d.class)) {
                        AbstractC0357c.b(c0356bA, c0358d);
                    }
                    fragment.mContainer = viewGroup;
                    c0VarF.j();
                    c0VarF.i();
                    View view2 = fragment.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(B0.g.n("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.mView.getTag() == null) {
                        fragment.mView.setTag(string);
                    }
                    fragment.mView.addOnAttachStateChangeListener(new M(this, c0VarF));
                    return fragment.mView;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        return null;
    }
}
