package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.R;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class r extends D implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public Handler f3809a;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3818j;

    /* renamed from: l, reason: collision with root package name */
    public Dialog f3820l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3821m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3822n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3823o;

    /* renamed from: b, reason: collision with root package name */
    public final RunnableC0282d f3810b = new RunnableC0282d(1, this);

    /* renamed from: c, reason: collision with root package name */
    public final DialogInterfaceOnCancelListenerC0292n f3811c = new DialogInterfaceOnCancelListenerC0292n(this);

    /* renamed from: d, reason: collision with root package name */
    public final DialogInterfaceOnDismissListenerC0293o f3812d = new DialogInterfaceOnDismissListenerC0293o(this);

    /* renamed from: e, reason: collision with root package name */
    public int f3813e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f3814f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3815g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3816h = true;

    /* renamed from: i, reason: collision with root package name */
    public int f3817i = -1;

    /* renamed from: k, reason: collision with root package name */
    public final C0294p f3819k = new C0294p(this);

    /* renamed from: p, reason: collision with root package name */
    public boolean f3824p = false;

    @Override // androidx.fragment.app.D
    public final J createFragmentContainer() {
        return new C0295q(this, super.createFragmentContainer());
    }

    public final void g(boolean z4, boolean z5) {
        if (this.f3822n) {
            return;
        }
        this.f3822n = true;
        this.f3823o = false;
        Dialog dialog = this.f3820l;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f3820l.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.f3809a.getLooper()) {
                    onDismiss(this.f3820l);
                } else {
                    this.f3809a.post(this.f3810b);
                }
            }
        }
        this.f3821m = true;
        if (this.f3817i >= 0) {
            Y parentFragmentManager = getParentFragmentManager();
            int i4 = this.f3817i;
            parentFragmentManager.getClass();
            if (i4 < 0) {
                throw new IllegalArgumentException(AbstractC0351g.m("Bad id: ", i4));
            }
            parentFragmentManager.v(new X(parentFragmentManager, i4), z4);
            this.f3817i = -1;
            return;
        }
        Y parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        C0279a c0279a = new C0279a(parentFragmentManager2);
        c0279a.f3703p = true;
        Y y4 = this.mFragmentManager;
        if (y4 != null && y4 != c0279a.f3704q) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
        c0279a.b(new e0(this, 3));
        if (z4) {
            c0279a.d(true);
        } else {
            c0279a.d(false);
        }
    }

    public Dialog h() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.p(requireContext(), this.f3814f);
    }

    @Override // androidx.fragment.app.D
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.D
    public final void onAttach(Context context) {
        Object obj;
        super.onAttach(context);
        androidx.lifecycle.P viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        C0294p c0294p = this.f3819k;
        viewLifecycleOwnerLiveData.getClass();
        androidx.lifecycle.P.a("observeForever");
        androidx.lifecycle.M m4 = new androidx.lifecycle.M(viewLifecycleOwnerLiveData, c0294p);
        m.g gVar = viewLifecycleOwnerLiveData.f3890b;
        m.c cVarA = gVar.a(c0294p);
        if (cVarA != null) {
            obj = cVarA.f13510b;
        } else {
            m.c cVar = new m.c(c0294p, m4);
            gVar.f13521d++;
            m.c cVar2 = gVar.f13519b;
            if (cVar2 == null) {
                gVar.f13518a = cVar;
                gVar.f13519b = cVar;
            } else {
                cVar2.f13511c = cVar;
                cVar.f13512d = cVar2;
                gVar.f13519b = cVar;
            }
            obj = null;
        }
        androidx.lifecycle.O o4 = (androidx.lifecycle.O) obj;
        if (o4 instanceof androidx.lifecycle.N) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (o4 == null) {
            m4.b(true);
        }
        if (this.f3823o) {
            return;
        }
        this.f3822n = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.D
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3809a = new Handler();
        this.f3816h = this.mContainerId == 0;
        if (bundle != null) {
            this.f3813e = bundle.getInt("android:style", 0);
            this.f3814f = bundle.getInt("android:theme", 0);
            this.f3815g = bundle.getBoolean("android:cancelable", true);
            this.f3816h = bundle.getBoolean("android:showsDialog", this.f3816h);
            this.f3817i = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.D
    public final void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f3820l;
        if (dialog != null) {
            this.f3821m = true;
            dialog.setOnDismissListener(null);
            this.f3820l.dismiss();
            if (!this.f3822n) {
                onDismiss(this.f3820l);
            }
            this.f3820l = null;
            this.f3824p = false;
        }
    }

    @Override // androidx.fragment.app.D
    public final void onDetach() {
        super.onDetach();
        if (!this.f3823o && !this.f3822n) {
            this.f3822n = true;
        }
        androidx.lifecycle.P viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        C0294p c0294p = this.f3819k;
        viewLifecycleOwnerLiveData.getClass();
        androidx.lifecycle.P.a("removeObserver");
        androidx.lifecycle.O o4 = (androidx.lifecycle.O) viewLifecycleOwnerLiveData.f3890b.c(c0294p);
        if (o4 == null) {
            return;
        }
        o4.c();
        o4.b(false);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f3821m) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        g(true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:29:0x0050, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x0068), top: B:48:0x001a }] */
    @Override // androidx.fragment.app.D
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.onGetLayoutInflater(r8)
            boolean r0 = r7.f3816h
            r1 = 2
            java.lang.String r2 = "FragmentManager"
            if (r0 == 0) goto L9a
            boolean r3 = r7.f3818j
            if (r3 == 0) goto L11
            goto L9a
        L11:
            if (r0 != 0) goto L14
            goto L71
        L14:
            boolean r0 = r7.f3824p
            if (r0 != 0) goto L71
            r0 = 0
            r3 = 1
            r7.f3818j = r3     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.h()     // Catch: java.lang.Throwable -> L4e
            r7.f3820l = r4     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.f3816h     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L68
            int r5 = r7.f3813e     // Catch: java.lang.Throwable -> L4e
            if (r5 == r3) goto L3b
            if (r5 == r1) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L4e
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L4e
        L3e:
            android.content.Context r4 = r7.getContext()     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L50
            android.app.Dialog r5 = r7.f3820l     // Catch: java.lang.Throwable -> L4e
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L4e
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r8 = move-exception
            goto L6e
        L50:
            android.app.Dialog r4 = r7.f3820l     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.f3815g     // Catch: java.lang.Throwable -> L4e
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.f3820l     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.n r5 = r7.f3811c     // Catch: java.lang.Throwable -> L4e
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.f3820l     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.o r5 = r7.f3812d     // Catch: java.lang.Throwable -> L4e
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L4e
            r7.f3824p = r3     // Catch: java.lang.Throwable -> L4e
            goto L6b
        L68:
            r3 = 0
            r7.f3820l = r3     // Catch: java.lang.Throwable -> L4e
        L6b:
            r7.f3818j = r0
            goto L71
        L6e:
            r7.f3818j = r0
            throw r8
        L71:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L8d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "get layout inflater for DialogFragment "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r1 = " from dialog context"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
        L8d:
            android.app.Dialog r7 = r7.f3820l
            if (r7 == 0) goto L99
            android.content.Context r7 = r7.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r7)
        L99:
            return r8
        L9a:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto Ld5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "getting layout inflater for DialogFragment "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r7 = r7.f3816h
            if (r7 != 0) goto Lc4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "mShowsDialog = false: "
            r7.<init>(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r2, r7)
            goto Ld5
        Lc4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "mCreatingDialog = true: "
            r7.<init>(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r2, r7)
        Ld5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.r.onGetLayoutInflater(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.D
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.f3820l;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i4 = this.f3813e;
        if (i4 != 0) {
            bundle.putInt("android:style", i4);
        }
        int i5 = this.f3814f;
        if (i5 != 0) {
            bundle.putInt("android:theme", i5);
        }
        boolean z4 = this.f3815g;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f3816h;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i6 = this.f3817i;
        if (i6 != -1) {
            bundle.putInt("android:backStackId", i6);
        }
    }

    @Override // androidx.fragment.app.D
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f3820l;
        if (dialog != null) {
            this.f3821m = false;
            dialog.show();
            View decorView = this.f3820l.getWindow().getDecorView();
            B0.f.r0(decorView, this);
            Intrinsics.checkNotNullParameter(decorView, "<this>");
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            com.airbnb.lottie.h.E(decorView, this);
        }
    }

    @Override // androidx.fragment.app.D
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f3820l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.D
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f3820l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3820l.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.D
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.f3820l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3820l.onRestoreInstanceState(bundle2);
    }
}
