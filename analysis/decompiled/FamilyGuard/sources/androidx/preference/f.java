package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e;
import androidx.lifecycle.X;
import androidx.preference.DialogPreference;

/* loaded from: classes.dex */
public abstract class f extends DialogInterfaceOnCancelListenerC0510e implements DialogInterface.OnClickListener {

    /* renamed from: A0, reason: collision with root package name */
    private int f11066A0;

    /* renamed from: B0, reason: collision with root package name */
    private BitmapDrawable f11067B0;

    /* renamed from: C0, reason: collision with root package name */
    private int f11068C0;

    /* renamed from: v0, reason: collision with root package name */
    private DialogPreference f11069v0;

    /* renamed from: w0, reason: collision with root package name */
    private CharSequence f11070w0;

    /* renamed from: x0, reason: collision with root package name */
    private CharSequence f11071x0;

    /* renamed from: y0, reason: collision with root package name */
    private CharSequence f11072y0;

    /* renamed from: z0, reason: collision with root package name */
    private CharSequence f11073z0;

    private static class a {
        static void a(Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    private void o2(Dialog dialog) {
        a.a(dialog.getWindow());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f11070w0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f11071x0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f11072y0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f11073z0);
        bundle.putInt("PreferenceDialogFragment.layout", this.f11066A0);
        BitmapDrawable bitmapDrawable = this.f11067B0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e
    public Dialog b2(Bundle bundle) {
        this.f11068C0 = -2;
        c.a aVarH = new c.a(A1()).m(this.f11070w0).e(this.f11067B0).j(this.f11071x0, this).h(this.f11072y0, this);
        View viewL2 = l2(A1());
        if (viewL2 != null) {
            k2(viewL2);
            aVarH.n(viewL2);
        } else {
            aVarH.f(this.f11073z0);
        }
        n2(aVarH);
        androidx.appcompat.app.c cVarA = aVarH.a();
        if (j2()) {
            o2(cVarA);
        }
        return cVarA;
    }

    public DialogPreference i2() {
        if (this.f11069v0 == null) {
            this.f11069v0 = (DialogPreference) ((DialogPreference.a) Y()).a(z1().getString("key"));
        }
        return this.f11069v0;
    }

    protected boolean j2() {
        return false;
    }

    protected void k2(View view) {
        int i5;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f11073z0;
            if (TextUtils.isEmpty(charSequence)) {
                i5 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i5 = 0;
            }
            if (viewFindViewById.getVisibility() != i5) {
                viewFindViewById.setVisibility(i5);
            }
        }
    }

    protected View l2(Context context) {
        int i5 = this.f11066A0;
        if (i5 == 0) {
            return null;
        }
        return F().inflate(i5, (ViewGroup) null);
    }

    public abstract void m2(boolean z5);

    protected void n2(c.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i5) {
        this.f11068C0 = i5;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m2(this.f11068C0 == -1);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        X xY = Y();
        if (!(xY instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) xY;
        String string = z1().getString("key");
        if (bundle != null) {
            this.f11070w0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f11071x0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f11072y0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f11073z0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f11066A0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f11067B0 = new BitmapDrawable(Q(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.a(string);
        this.f11069v0 = dialogPreference;
        this.f11070w0 = dialogPreference.U0();
        this.f11071x0 = this.f11069v0.W0();
        this.f11072y0 = this.f11069v0.V0();
        this.f11073z0 = this.f11069v0.T0();
        this.f11066A0 = this.f11069v0.S0();
        Drawable drawableR0 = this.f11069v0.R0();
        if (drawableR0 == null || (drawableR0 instanceof BitmapDrawable)) {
            this.f11067B0 = (BitmapDrawable) drawableR0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableR0.getIntrinsicWidth(), drawableR0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableR0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableR0.draw(canvas);
        this.f11067B0 = new BitmapDrawable(Q(), bitmapCreateBitmap);
    }
}
