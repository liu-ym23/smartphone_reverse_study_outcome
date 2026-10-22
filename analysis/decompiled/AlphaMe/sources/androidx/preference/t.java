package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C0182h;
import androidx.appcompat.app.C0186l;
import androidx.appcompat.app.DialogInterfaceC0187m;
import ch.qos.logback.core.joran.action.Action;

/* loaded from: classes.dex */
public abstract class t extends androidx.fragment.app.r implements DialogInterface.OnClickListener {

    /* renamed from: q, reason: collision with root package name */
    public DialogPreference f4155q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f4156r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f4157s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f4158t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f4159u;

    /* renamed from: v, reason: collision with root package name */
    public int f4160v;

    /* renamed from: w, reason: collision with root package name */
    public BitmapDrawable f4161w;

    /* renamed from: x, reason: collision with root package name */
    public int f4162x;

    @Override // androidx.fragment.app.r
    public final Dialog h() {
        this.f4162x = -2;
        C0186l c0186l = new C0186l(requireContext());
        CharSequence charSequence = this.f4156r;
        Object obj = c0186l.f2661c;
        ((C0182h) obj).f2600d = charSequence;
        ((C0182h) obj).f2599c = this.f4161w;
        C0182h c0182h = (C0182h) obj;
        c0182h.f2603g = this.f4157s;
        c0182h.f2604h = this;
        C0182h c0182h2 = (C0182h) obj;
        c0182h2.f2605i = this.f4158t;
        c0182h2.f2606j = this;
        requireContext();
        int i4 = this.f4160v;
        View viewInflate = i4 != 0 ? getLayoutInflater().inflate(i4, (ViewGroup) null) : null;
        if (viewInflate != null) {
            j(viewInflate);
            ((C0182h) c0186l.f2661c).f2611o = viewInflate;
        } else {
            ((C0182h) c0186l.f2661c).f2602f = this.f4159u;
        }
        l(c0186l);
        DialogInterfaceC0187m dialogInterfaceC0187mB = c0186l.b();
        if (this instanceof C0333e) {
            s.a(dialogInterfaceC0187mB.getWindow());
        }
        return dialogInterfaceC0187mB;
    }

    public final DialogPreference i() {
        if (this.f4155q == null) {
            this.f4155q = (DialogPreference) ((InterfaceC0330b) getTargetFragment()).findPreference(requireArguments().getString(Action.KEY_ATTRIBUTE));
        }
        return this.f4155q;
    }

    public void j(View view) {
        int i4;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f4159u;
            if (TextUtils.isEmpty(charSequence)) {
                i4 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i4 = 0;
            }
            if (viewFindViewById.getVisibility() != i4) {
                viewFindViewById.setVisibility(i4);
            }
        }
    }

    public abstract void k(boolean z4);

    public void l(C0186l c0186l) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        this.f4162x = i4;
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.D
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j0.h targetFragment = getTargetFragment();
        if (!(targetFragment instanceof InterfaceC0330b)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        InterfaceC0330b interfaceC0330b = (InterfaceC0330b) targetFragment;
        String string = requireArguments().getString(Action.KEY_ATTRIBUTE);
        if (bundle != null) {
            this.f4156r = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f4157s = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f4158t = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f4159u = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f4160v = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f4161w = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) interfaceC0330b.findPreference(string);
        this.f4155q = dialogPreference;
        this.f4156r = dialogPreference.f4012N;
        this.f4157s = dialogPreference.f4015Q;
        this.f4158t = dialogPreference.f4016R;
        this.f4159u = dialogPreference.f4013O;
        this.f4160v = dialogPreference.f4017S;
        Drawable drawable = dialogPreference.f4014P;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            this.f4161w = (BitmapDrawable) drawable;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.f4161w = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        k(this.f4162x == -1);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.D
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f4156r);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f4157s);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f4158t);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f4159u);
        bundle.putInt("PreferenceDialogFragment.layout", this.f4160v);
        BitmapDrawable bitmapDrawable = this.f4161w;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
