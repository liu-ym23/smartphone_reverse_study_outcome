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
import android.view.W;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import androidx.preference.DialogPreference;

/* loaded from: classes.dex */
public abstract class f extends DialogInterfaceOnCancelListenerC1374l implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public DialogPreference f14375a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f14376b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f14377c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f14378d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f14379e;

    /* renamed from: f, reason: collision with root package name */
    public int f14380f;

    /* renamed from: g, reason: collision with root package name */
    public BitmapDrawable f14381g;

    /* renamed from: h, reason: collision with root package name */
    public int f14382h;

    public static class a {
        public static void a(Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    public DialogPreference o() {
        if (this.f14375a == null) {
            this.f14375a = (DialogPreference) ((DialogPreference.a) getTargetFragment()).findPreference(requireArguments().getString("key"));
        }
        return this.f14375a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f14382h = i10;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) targetFragment;
        String string = requireArguments().getString("key");
        if (bundle != null) {
            this.f14376b = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f14377c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f14378d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f14379e = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f14380f = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f14381g = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.findPreference(string);
        this.f14375a = dialogPreference;
        this.f14376b = dialogPreference.e();
        this.f14377c = this.f14375a.j();
        this.f14378d = this.f14375a.i();
        this.f14379e = this.f14375a.c();
        this.f14380f = this.f14375a.b();
        Drawable drawableA = this.f14375a.a();
        if (drawableA == null || (drawableA instanceof BitmapDrawable)) {
            this.f14381g = (BitmapDrawable) drawableA;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableA.getIntrinsicWidth(), drawableA.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableA.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableA.draw(canvas);
        this.f14381g = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public Dialog onCreateDialog(Bundle bundle) {
        this.f14382h = -2;
        c.a aVarJ = new c.a(requireContext()).q(this.f14376b).e(this.f14381g).m(this.f14377c, this).j(this.f14378d, this);
        View viewR = r(requireContext());
        if (viewR != null) {
            q(viewR);
            aVarJ.r(viewR);
        } else {
            aVarJ.g(this.f14379e);
        }
        t(aVarJ);
        androidx.appcompat.app.c cVarA = aVarJ.a();
        if (p()) {
            u(cVarA);
        }
        return cVarA;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        s(this.f14382h == -1);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f14376b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f14377c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f14378d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f14379e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f14380f);
        BitmapDrawable bitmapDrawable = this.f14381g;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public boolean p() {
        return false;
    }

    public void q(View view) {
        int i10;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f14379e;
            if (TextUtils.isEmpty(charSequence)) {
                i10 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i10 = 0;
            }
            if (viewFindViewById.getVisibility() != i10) {
                viewFindViewById.setVisibility(i10);
            }
        }
    }

    public View r(Context context) {
        int i10 = this.f14380f;
        if (i10 == 0) {
            return null;
        }
        return getLayoutInflater().inflate(i10, (ViewGroup) null);
    }

    public abstract void s(boolean z10);

    public void t(c.a aVar) {
    }

    public final void u(Dialog dialog) {
        a.a(dialog.getWindow());
    }
}
