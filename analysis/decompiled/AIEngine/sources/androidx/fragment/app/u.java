package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f2197a;

    public u(FragmentManager fragmentManager) {
        this.f2197a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        b0 b0VarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.f2197a;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l1.a.f10187a);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = Fragment.class.isAssignableFrom(s.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id2 = view != null ? view.getId() : 0;
                    if (id2 == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment fragmentA = resourceId != -1 ? fragmentManager.A(resourceId) : null;
                    if (fragmentA == null && string != null) {
                        fragmentA = fragmentManager.B(string);
                    }
                    if (fragmentA == null && id2 != -1) {
                        fragmentA = fragmentManager.A(id2);
                    }
                    if (fragmentA == null) {
                        s sVarD = fragmentManager.D();
                        context.getClassLoader();
                        fragmentA = sVarD.a(attributeValue);
                        fragmentA.mFromLayout = true;
                        fragmentA.mFragmentId = resourceId != 0 ? resourceId : id2;
                        fragmentA.mContainerId = id2;
                        fragmentA.mTag = string;
                        fragmentA.mInLayout = true;
                        fragmentA.mFragmentManager = fragmentManager;
                        t<?> tVar = fragmentManager.f2031u;
                        fragmentA.mHost = tVar;
                        fragmentA.onInflate((Context) tVar.f2194b, attributeSet, fragmentA.mSavedFragmentState);
                        b0VarF = fragmentManager.a(fragmentA);
                        if (FragmentManager.G(2)) {
                            Log.v("FragmentManager", "Fragment " + fragmentA + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (fragmentA.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                        }
                        fragmentA.mInLayout = true;
                        fragmentA.mFragmentManager = fragmentManager;
                        t<?> tVar2 = fragmentManager.f2031u;
                        fragmentA.mHost = tVar2;
                        fragmentA.onInflate((Context) tVar2.f2194b, attributeSet, fragmentA.mSavedFragmentState);
                        b0VarF = fragmentManager.f(fragmentA);
                        if (FragmentManager.G(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + fragmentA + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    FragmentStrictMode.a aVar = FragmentStrictMode.f2180a;
                    FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragmentA, "Attempting to use <fragment> tag to add fragment " + fragmentA + " to container " + viewGroup);
                    FragmentStrictMode.c(fragmentTagUsageViolation);
                    FragmentStrictMode.a aVarA = FragmentStrictMode.a(fragmentA);
                    if (aVarA.f2190a.contains(FragmentStrictMode.Flag.f2184d) && FragmentStrictMode.e(aVarA, fragmentA.getClass(), FragmentTagUsageViolation.class)) {
                        FragmentStrictMode.b(aVarA, fragmentTagUsageViolation);
                    }
                    fragmentA.mContainer = viewGroup;
                    b0VarF.j();
                    b0VarF.i();
                    View view2 = fragmentA.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(a0.a.k("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragmentA.mView.getTag() == null) {
                        fragmentA.mView.setTag(string);
                    }
                    fragmentA.mView.addOnAttachStateChangeListener(new a(b0VarF));
                    return fragmentA.mView;
                }
            }
        }
        return null;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f2198a;

        public a(b0 b0Var) {
            this.f2198a = b0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            b0 b0Var = this.f2198a;
            Fragment fragment = b0Var.f2081c;
            b0Var.j();
            SpecialEffectsController.f((ViewGroup) fragment.mView.getParent(), u.this.f2197a).e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
