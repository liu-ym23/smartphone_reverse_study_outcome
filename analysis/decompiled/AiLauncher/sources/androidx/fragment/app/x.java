package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* loaded from: classes.dex */
public class x implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f14148a;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I f14149a;

        public a(I i10) {
            this.f14149a = i10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f14149a.k();
            this.f14149a.m();
            SpecialEffectsController.u((ViewGroup) fragmentK.mView.getParent(), x.this.f14148a).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public x(FragmentManager fragmentManager) {
        this.f14148a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        I iY;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f14148a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !v.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentK0 = resourceId != -1 ? this.f14148a.k0(resourceId) : null;
        if (fragmentK0 == null && string != null) {
            fragmentK0 = this.f14148a.l0(string);
        }
        if (fragmentK0 == null && id != -1) {
            fragmentK0 = this.f14148a.k0(id);
        }
        if (fragmentK0 == null) {
            fragmentK0 = this.f14148a.x0().a(context.getClassLoader(), attributeValue);
            fragmentK0.mFromLayout = true;
            fragmentK0.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentK0.mContainerId = id;
            fragmentK0.mTag = string;
            fragmentK0.mInLayout = true;
            FragmentManager fragmentManager = this.f14148a;
            fragmentK0.mFragmentManager = fragmentManager;
            fragmentK0.mHost = fragmentManager.A0();
            fragmentK0.onInflate(this.f14148a.A0().getContext(), attributeSet, fragmentK0.mSavedFragmentState);
            iY = this.f14148a.j(fragmentK0);
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentK0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentK0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentK0.mInLayout = true;
            FragmentManager fragmentManager2 = this.f14148a;
            fragmentK0.mFragmentManager = fragmentManager2;
            fragmentK0.mHost = fragmentManager2.A0();
            fragmentK0.onInflate(this.f14148a.A0().getContext(), attributeSet, fragmentK0.mSavedFragmentState);
            iY = this.f14148a.y(fragmentK0);
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentK0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.g(fragmentK0, viewGroup);
        fragmentK0.mContainer = viewGroup;
        iY.m();
        iY.j();
        View view2 = fragmentK0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentK0.mView.getTag() == null) {
            fragmentK0.mView.setTag(string);
        }
        fragmentK0.mView.addOnAttachStateChangeListener(new a(iY));
        return fragmentK0.mView;
    }
}
