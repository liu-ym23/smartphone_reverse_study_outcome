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

/* JADX INFO: loaded from: classes.dex */
public class q implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f3377a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f3378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f3379b;

        public a(q r10, a0 r11) {
            this.f3379b = r10;
            this.f3378a = r11;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            Fragment r11 = this.f3378a.k();
            this.f3378a.m();
            SpecialEffectsController.r((ViewGroup) r11.mView.getParent(), this.f3379b.f3377a).n();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }
    }

    public q(FragmentManager r10) {
        this.f3377a = r10;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r10, Context r11, AttributeSet r12) {
        return onCreateView(null, r10, r11, r12);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View r10, String r11, Context r12, AttributeSet r13) {
        if (FragmentContainerView.class.getName().equals(r11) == true) goto L5;
        Fragment r14 = null;
        if ("fragment".equals(r11) == true) goto L9;
        return null;
    L9:
        String r15 = r13.getAttributeValue(null, "class");
        TypedArray r16 = r12.obtainStyledAttributes(r13, R$styleable.Fragment);
        if (r15 != null) goto L12;
        r15 = r16.getString(R$styleable.Fragment_android_name);
    L12:
        int r17 = r16.getResourceId(R$styleable.Fragment_android_id, -1);
        String r18 = r16.getString(R$styleable.Fragment_android_tag);
        r16.recycle();
        if (r15 != null) goto L15;
    L61:
        return null;
    L15:
        if (p.b(r12.getClassLoader(), r15) == false) goto L61;
        if (r10 == null) goto L19;
        int r19 = r10.getId();
    L20:
        if (r19 != (-1)) goto L26;
        if (r17 != (-1)) goto L26;
        if (r18 != null) goto L26;
        throw new IllegalArgumentException(r13.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + r15);
    L26:
        if (r17 == (-1)) goto L28;
        r14 = this.f3377a.h0(r17);
    L28:
        if (r14 != null) goto L31;
        if (r18 == null) goto L31;
        r14 = this.f3377a.i0(r18);
    L31:
        if (r14 != null) goto L35;
        if (r19 == (-1)) goto L35;
        r14 = this.f3377a.h0(r19);
    L35:
        if (r14 != null) goto L44;
        r14 = this.f3377a.v0().a(r12.getClassLoader(), r15);
        r14.mFromLayout = true;
        if (r17 == 0) goto L39;
        int r110 = r17;
    L40:
        r14.mFragmentId = r110;
        r14.mContainerId = r19;
        r14.mTag = r18;
        r14.mInLayout = true;
        FragmentManager r111 = this.f3377a;
        r14.mFragmentManager = r111;
        r14.mHost = r111.y0();
        r14.onInflate(this.f3377a.y0().e(), r13, r14.mSavedFragmentState);
        a0 r112 = this.f3377a.j(r14);
        if (FragmentManager.L0(2) == false) goto L48;
        Log.v("FragmentManager", "Fragment " + r14 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(r17));
    L48:
        ViewGroup r20 = (ViewGroup) r10;
        FragmentStrictMode.i(r14, r20);
        r14.mContainer = r20;
        r112.m();
        r112.j();
        View r21 = r14.mView;
        if (r21 == null) goto L58;
        if (r17 == 0) goto L53;
        r21.setId(r17);
    L53:
        if (r14.mView.getTag() != null) goto L55;
        r14.mView.setTag(r18);
    L55:
        r14.mView.addOnAttachStateChangeListener(new a(this, r112));
        return r14.mView;
    L58:
        throw new IllegalStateException("Fragment " + r15 + " did not create a view.");
    L39:
        r110 = r19;
        goto L40
    L44:
        if (r14.mInLayout == true) goto L60;
        r14.mInLayout = true;
        FragmentManager r113 = this.f3377a;
        r14.mFragmentManager = r113;
        r14.mHost = r113.y0();
        r14.onInflate(this.f3377a.y0().e(), r13, r14.mSavedFragmentState);
        r112 = this.f3377a.v(r14);
        if (FragmentManager.L0(2) == false) goto L48;
        Log.v("FragmentManager", "Retained Fragment " + r14 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(r17));
        goto L48
    L60:
        throw new IllegalArgumentException(r13.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(r17) + ", tag " + r18 + ", or parent id 0x" + Integer.toHexString(r19) + " with another fragment for " + r15);
    L19:
        r19 = 0;
        goto L20
    L5:
        return new FragmentContainerView(r12, r13, this.f3377a);
    }
}
