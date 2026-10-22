package androidx.fragment.app;

import android.app.Activity;
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
import android.view.Window;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.Y;
import androidx.lifecycle.Z;
import c0.C0577g;

/* renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0510e extends ComponentCallbacksC0511f implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: f0, reason: collision with root package name */
    private Handler f10582f0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f10591o0;

    /* renamed from: q0, reason: collision with root package name */
    private Dialog f10593q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f10594r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f10595s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f10596t0;

    /* renamed from: g0, reason: collision with root package name */
    private Runnable f10583g0 = new a();

    /* renamed from: h0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f10584h0 = new b();

    /* renamed from: i0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f10585i0 = new c();

    /* renamed from: j0, reason: collision with root package name */
    private int f10586j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private int f10587k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f10588l0 = true;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f10589m0 = true;

    /* renamed from: n0, reason: collision with root package name */
    private int f10590n0 = -1;

    /* renamed from: p0, reason: collision with root package name */
    private androidx.lifecycle.C<InterfaceC0539t> f10592p0 = new d();

    /* renamed from: u0, reason: collision with root package name */
    private boolean f10597u0 = false;

    /* renamed from: androidx.fragment.app.e$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogInterfaceOnCancelListenerC0510e.this.f10585i0.onDismiss(DialogInterfaceOnCancelListenerC0510e.this.f10593q0);
        }
    }

    /* renamed from: androidx.fragment.app.e$b */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0510e.this.f10593q0 != null) {
                DialogInterfaceOnCancelListenerC0510e dialogInterfaceOnCancelListenerC0510e = DialogInterfaceOnCancelListenerC0510e.this;
                dialogInterfaceOnCancelListenerC0510e.onCancel(dialogInterfaceOnCancelListenerC0510e.f10593q0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.e$c */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0510e.this.f10593q0 != null) {
                DialogInterfaceOnCancelListenerC0510e dialogInterfaceOnCancelListenerC0510e = DialogInterfaceOnCancelListenerC0510e.this;
                dialogInterfaceOnCancelListenerC0510e.onDismiss(dialogInterfaceOnCancelListenerC0510e.f10593q0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.e$d */
    class d implements androidx.lifecycle.C<InterfaceC0539t> {
        d() {
        }

        @Override // androidx.lifecycle.C
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC0539t interfaceC0539t) {
            if (interfaceC0539t == null || !DialogInterfaceOnCancelListenerC0510e.this.f10589m0) {
                return;
            }
            View viewB1 = DialogInterfaceOnCancelListenerC0510e.this.B1();
            if (viewB1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC0510e.this.f10593q0 != null) {
                if (x.F0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC0510e.this.f10593q0);
                }
                DialogInterfaceOnCancelListenerC0510e.this.f10593q0.setContentView(viewB1);
            }
        }
    }

    /* renamed from: androidx.fragment.app.e$e, reason: collision with other inner class name */
    class C0133e extends AbstractC0518m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0518m f10602a;

        C0133e(AbstractC0518m abstractC0518m) {
            this.f10602a = abstractC0518m;
        }

        @Override // androidx.fragment.app.AbstractC0518m
        public View c(int i5) {
            return this.f10602a.d() ? this.f10602a.c(i5) : DialogInterfaceOnCancelListenerC0510e.this.c2(i5);
        }

        @Override // androidx.fragment.app.AbstractC0518m
        public boolean d() {
            return this.f10602a.d() || DialogInterfaceOnCancelListenerC0510e.this.d2();
        }
    }

    private void Y1(boolean z5, boolean z6, boolean z7) {
        if (this.f10595s0) {
            return;
        }
        this.f10595s0 = true;
        this.f10596t0 = false;
        Dialog dialog = this.f10593q0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f10593q0.dismiss();
            if (!z6) {
                if (Looper.myLooper() == this.f10582f0.getLooper()) {
                    onDismiss(this.f10593q0);
                } else {
                    this.f10582f0.post(this.f10583g0);
                }
            }
        }
        this.f10594r0 = true;
        if (this.f10590n0 >= 0) {
            if (z7) {
                K().X0(this.f10590n0, 1);
            } else {
                K().V0(this.f10590n0, 1, z5);
            }
            this.f10590n0 = -1;
            return;
        }
        G gM = K().m();
        gM.v(true);
        gM.r(this);
        if (z7) {
            gM.k();
        } else if (z5) {
            gM.j();
        } else {
            gM.i();
        }
    }

    private void e2(Bundle bundle) {
        if (this.f10589m0 && !this.f10597u0) {
            try {
                this.f10591o0 = true;
                Dialog dialogB2 = b2(bundle);
                this.f10593q0 = dialogB2;
                if (this.f10589m0) {
                    g2(dialogB2, this.f10586j0);
                    Context contextW = w();
                    if (contextW instanceof Activity) {
                        this.f10593q0.setOwnerActivity((Activity) contextW);
                    }
                    this.f10593q0.setCancelable(this.f10588l0);
                    this.f10593q0.setOnCancelListener(this.f10584h0);
                    this.f10593q0.setOnDismissListener(this.f10585i0);
                    this.f10597u0 = true;
                } else {
                    this.f10593q0 = null;
                }
                this.f10591o0 = false;
            } catch (Throwable th) {
                this.f10591o0 = false;
                throw th;
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void C0() {
        super.C0();
        Dialog dialog = this.f10593q0;
        if (dialog != null) {
            this.f10594r0 = true;
            dialog.setOnDismissListener(null);
            this.f10593q0.dismiss();
            if (!this.f10595s0) {
                onDismiss(this.f10593q0);
            }
            this.f10593q0 = null;
            this.f10597u0 = false;
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void D0() {
        super.D0();
        if (!this.f10596t0 && !this.f10595s0) {
            this.f10595s0 = true;
        }
        c0().l(this.f10592p0);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public LayoutInflater E0(Bundle bundle) {
        LayoutInflater layoutInflaterE0 = super.E0(bundle);
        if (this.f10589m0 && !this.f10591o0) {
            e2(bundle);
            if (x.F0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f10593q0;
            if (dialog != null) {
                return layoutInflaterE0.cloneInContext(dialog.getContext());
            }
        } else if (x.F0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.f10589m0) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterE0;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterE0;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        Dialog dialog = this.f10593q0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i5 = this.f10586j0;
        if (i5 != 0) {
            bundle.putInt("android:style", i5);
        }
        int i6 = this.f10587k0;
        if (i6 != 0) {
            bundle.putInt("android:theme", i6);
        }
        boolean z5 = this.f10588l0;
        if (!z5) {
            bundle.putBoolean("android:cancelable", z5);
        }
        boolean z6 = this.f10589m0;
        if (!z6) {
            bundle.putBoolean("android:showsDialog", z6);
        }
        int i7 = this.f10590n0;
        if (i7 != -1) {
            bundle.putInt("android:backStackId", i7);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
        Dialog dialog = this.f10593q0;
        if (dialog != null) {
            this.f10594r0 = false;
            dialog.show();
            View decorView = this.f10593q0.getWindow().getDecorView();
            Y.a(decorView, this);
            Z.a(decorView, this);
            C0577g.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        super.T0();
        Dialog dialog = this.f10593q0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void V0(Bundle bundle) {
        Bundle bundle2;
        super.V0(bundle);
        if (this.f10593q0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f10593q0.onRestoreInstanceState(bundle2);
    }

    public void X1() {
        Y1(false, false, false);
    }

    public Dialog Z1() {
        return this.f10593q0;
    }

    public int a2() {
        return this.f10587k0;
    }

    public Dialog b2(Bundle bundle) {
        if (x.F0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new androidx.activity.k(A1(), a2());
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    void c1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.c1(layoutInflater, viewGroup, bundle);
        if (this.f10613I != null || this.f10593q0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f10593q0.onRestoreInstanceState(bundle2);
    }

    View c2(int i5) {
        Dialog dialog = this.f10593q0;
        if (dialog != null) {
            return dialog.findViewById(i5);
        }
        return null;
    }

    boolean d2() {
        return this.f10597u0;
    }

    public final Dialog f2() {
        Dialog dialogZ1 = Z1();
        if (dialogZ1 != null) {
            return dialogZ1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void g2(Dialog dialog, int i5) {
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void h2(x xVar, String str) {
        this.f10595s0 = false;
        this.f10596t0 = true;
        G gM = xVar.m();
        gM.v(true);
        gM.e(this, str);
        gM.i();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    AbstractC0518m l() {
        return new C0133e(super.l());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f10594r0) {
            return;
        }
        if (x.F0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        Y1(true, true, false);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    @Deprecated
    public void p0(Bundle bundle) {
        super.p0(bundle);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void s0(Context context) {
        super.s0(context);
        c0().h(this.f10592p0);
        if (this.f10596t0) {
            return;
        }
        this.f10595s0 = false;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f10582f0 = new Handler();
        this.f10589m0 = this.f10656y == 0;
        if (bundle != null) {
            this.f10586j0 = bundle.getInt("android:style", 0);
            this.f10587k0 = bundle.getInt("android:theme", 0);
            this.f10588l0 = bundle.getBoolean("android:cancelable", true);
            this.f10589m0 = bundle.getBoolean("android:showsDialog", this.f10589m0);
            this.f10590n0 = bundle.getInt("android:backStackId", -1);
        }
    }
}
