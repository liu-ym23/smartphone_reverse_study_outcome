package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ComponentCallbacksC0511f;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e;
import androidx.fragment.app.x;
import androidx.preference.DialogPreference;
import androidx.preference.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class g extends ComponentCallbacksC0511f implements j.c, j.a, j.b, DialogPreference.a {

    /* renamed from: g0, reason: collision with root package name */
    private j f11075g0;

    /* renamed from: h0, reason: collision with root package name */
    RecyclerView f11076h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f11077i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f11078j0;

    /* renamed from: l0, reason: collision with root package name */
    private Runnable f11080l0;

    /* renamed from: f0, reason: collision with root package name */
    private final c f11074f0 = new c();

    /* renamed from: k0, reason: collision with root package name */
    private int f11079k0 = p.f11151c;

    /* renamed from: m0, reason: collision with root package name */
    private final Handler f11081m0 = new a(Looper.getMainLooper());

    /* renamed from: n0, reason: collision with root package name */
    private final Runnable f11082n0 = new b();

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.V1();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.f11076h0;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    private class c extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f11085a;

        /* renamed from: b, reason: collision with root package name */
        private int f11086b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f11087c = true;

        c() {
        }

        private boolean d(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            if (!(childViewHolder instanceof l) || !((l) childViewHolder).c()) {
                return false;
            }
            boolean z5 = this.f11087c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z5;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            return (childViewHolder2 instanceof l) && ((l) childViewHolder2).b();
        }

        public void a(boolean z5) {
            this.f11087c = z5;
        }

        public void b(Drawable drawable) {
            if (drawable != null) {
                this.f11086b = drawable.getIntrinsicHeight();
            } else {
                this.f11086b = 0;
            }
            this.f11085a = drawable;
            g.this.f11076h0.invalidateItemDecorations();
        }

        public void c(int i5) {
            this.f11086b = i5;
            g.this.f11076h0.invalidateItemDecorations();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (d(view, recyclerView)) {
                rect.bottom = this.f11086b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.f11085a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = recyclerView.getChildAt(i5);
                if (d(childAt, recyclerView)) {
                    int y5 = ((int) childAt.getY()) + childAt.getHeight();
                    this.f11085a.setBounds(0, y5, width, this.f11086b + y5);
                    this.f11085a.draw(canvas);
                }
            }
        }
    }

    public interface d {
        boolean a(g gVar, Preference preference);
    }

    public interface e {
        boolean a(g gVar, Preference preference);
    }

    public interface f {
        boolean a(g gVar, PreferenceScreen preferenceScreen);
    }

    private void f2() {
        if (this.f11081m0.hasMessages(1)) {
            return;
        }
        this.f11081m0.obtainMessage(1).sendToTarget();
    }

    private void g2() {
        if (this.f11075g0 == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void k2() {
        X1().setAdapter(null);
        PreferenceScreen preferenceScreenY1 = Y1();
        if (preferenceScreenY1 != null) {
            preferenceScreenY1.Z();
        }
        e2();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void C0() {
        this.f11081m0.removeCallbacks(this.f11082n0);
        this.f11081m0.removeMessages(1);
        if (this.f11077i0) {
            k2();
        }
        this.f11076h0 = null;
        super.C0();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        PreferenceScreen preferenceScreenY1 = Y1();
        if (preferenceScreenY1 != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenY1.s0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
        this.f11075g0.q(this);
        this.f11075g0.o(this);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        super.T0();
        this.f11075g0.q(null);
        this.f11075g0.o(null);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenY1;
        super.U0(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenY1 = Y1()) != null) {
            preferenceScreenY1.r0(bundle2);
        }
        if (this.f11077i0) {
            V1();
            Runnable runnable = this.f11080l0;
            if (runnable != null) {
                runnable.run();
                this.f11080l0 = null;
            }
        }
        this.f11078j0 = true;
    }

    public void U1(int i5) {
        g2();
        j2(this.f11075g0.m(A1(), i5, Y1()));
    }

    void V1() {
        PreferenceScreen preferenceScreenY1 = Y1();
        if (preferenceScreenY1 != null) {
            X1().setAdapter(a2(preferenceScreenY1));
            preferenceScreenY1.T();
        }
        Z1();
    }

    public ComponentCallbacksC0511f W1() {
        return null;
    }

    public final RecyclerView X1() {
        return this.f11076h0;
    }

    public PreferenceScreen Y1() {
        return this.f11075g0.k();
    }

    protected void Z1() {
    }

    @Override // androidx.preference.DialogPreference.a
    public <T extends Preference> T a(CharSequence charSequence) {
        j jVar = this.f11075g0;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(charSequence);
    }

    protected RecyclerView.Adapter a2(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    public RecyclerView.LayoutManager b2() {
        return new LinearLayoutManager(A1());
    }

    public abstract void c2(Bundle bundle, String str);

    public RecyclerView d2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (A1().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(o.f11144b)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(p.f11152d, viewGroup, false);
        recyclerView2.setLayoutManager(b2());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    protected void e2() {
    }

    @Override // androidx.preference.j.a
    public void g(Preference preference) {
        DialogInterfaceOnCancelListenerC0510e dialogInterfaceOnCancelListenerC0510eQ2;
        boolean zA = W1() instanceof d ? ((d) W1()).a(this, preference) : false;
        for (ComponentCallbacksC0511f componentCallbacksC0511fJ = this; !zA && componentCallbacksC0511fJ != null; componentCallbacksC0511fJ = componentCallbacksC0511fJ.J()) {
            if (componentCallbacksC0511fJ instanceof d) {
                zA = ((d) componentCallbacksC0511fJ).a(this, preference);
            }
        }
        if (!zA && (w() instanceof d)) {
            zA = ((d) w()).a(this, preference);
        }
        if (!zA && (q() instanceof d)) {
            zA = ((d) q()).a(this, preference);
        }
        if (!zA && K().g0("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                dialogInterfaceOnCancelListenerC0510eQ2 = androidx.preference.a.r2(preference.s());
            } else if (preference instanceof ListPreference) {
                dialogInterfaceOnCancelListenerC0510eQ2 = androidx.preference.c.q2(preference.s());
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                }
                dialogInterfaceOnCancelListenerC0510eQ2 = androidx.preference.d.q2(preference.s());
            }
            dialogInterfaceOnCancelListenerC0510eQ2.O1(this, 0);
            dialogInterfaceOnCancelListenerC0510eQ2.h2(K(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    @Override // androidx.preference.j.b
    public void h(PreferenceScreen preferenceScreen) {
        boolean zA = W1() instanceof f ? ((f) W1()).a(this, preferenceScreen) : false;
        for (ComponentCallbacksC0511f componentCallbacksC0511fJ = this; !zA && componentCallbacksC0511fJ != null; componentCallbacksC0511fJ = componentCallbacksC0511fJ.J()) {
            if (componentCallbacksC0511fJ instanceof f) {
                zA = ((f) componentCallbacksC0511fJ).a(this, preferenceScreen);
            }
        }
        if (!zA && (w() instanceof f)) {
            zA = ((f) w()).a(this, preferenceScreen);
        }
        if (zA || !(q() instanceof f)) {
            return;
        }
        ((f) q()).a(this, preferenceScreen);
    }

    public void h2(Drawable drawable) {
        this.f11074f0.b(drawable);
    }

    public void i2(int i5) {
        this.f11074f0.c(i5);
    }

    @Override // androidx.preference.j.c
    public boolean j(Preference preference) {
        if (preference.o() == null) {
            return false;
        }
        boolean zA = W1() instanceof e ? ((e) W1()).a(this, preference) : false;
        for (ComponentCallbacksC0511f componentCallbacksC0511fJ = this; !zA && componentCallbacksC0511fJ != null; componentCallbacksC0511fJ = componentCallbacksC0511fJ.J()) {
            if (componentCallbacksC0511fJ instanceof e) {
                zA = ((e) componentCallbacksC0511fJ).a(this, preference);
            }
        }
        if (!zA && (w() instanceof e)) {
            zA = ((e) w()).a(this, preference);
        }
        if (!zA && (q() instanceof e)) {
            zA = ((e) q()).a(this, preference);
        }
        if (zA) {
            return true;
        }
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        x xVarK = K();
        Bundle bundleM = preference.m();
        ComponentCallbacksC0511f componentCallbacksC0511fA = xVarK.q0().a(y1().getClassLoader(), preference.o());
        componentCallbacksC0511fA.G1(bundleM);
        componentCallbacksC0511fA.O1(this, 0);
        xVarK.m().s(((View) B1().getParent()).getId(), componentCallbacksC0511fA).g(null).i();
        return true;
    }

    public void j2(PreferenceScreen preferenceScreen) {
        if (!this.f11075g0.r(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        e2();
        this.f11077i0 = true;
        if (this.f11078j0) {
            f2();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        TypedValue typedValue = new TypedValue();
        A1().getTheme().resolveAttribute(m.f11138i, typedValue, true);
        int i5 = typedValue.resourceId;
        if (i5 == 0) {
            i5 = r.f11158a;
        }
        A1().getTheme().applyStyle(i5, false);
        j jVar = new j(A1());
        this.f11075g0 = jVar;
        jVar.p(this);
        c2(bundle, u() != null ? u().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = A1().obtainStyledAttributes(null, s.f11264v0, m.f11135f, 0);
        this.f11079k0 = typedArrayObtainStyledAttributes.getResourceId(s.f11266w0, this.f11079k0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(s.f11268x0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(s.f11270y0, -1);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(s.f11272z0, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(A1());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f11079k0, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewD2 = d2(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewD2 == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f11076h0 = recyclerViewD2;
        recyclerViewD2.addItemDecoration(this.f11074f0);
        h2(drawable);
        if (dimensionPixelSize != -1) {
            i2(dimensionPixelSize);
        }
        this.f11074f0.a(z5);
        if (this.f11076h0.getParent() == null) {
            viewGroup2.addView(this.f11076h0);
        }
        this.f11081m0.post(this.f11082n0);
        return viewInflate;
    }
}
