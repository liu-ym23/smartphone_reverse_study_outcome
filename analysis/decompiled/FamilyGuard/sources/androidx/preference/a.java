package androidx.preference;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: D0, reason: collision with root package name */
    private EditText f11051D0;

    /* renamed from: E0, reason: collision with root package name */
    private CharSequence f11052E0;

    /* renamed from: F0, reason: collision with root package name */
    private final Runnable f11053F0 = new RunnableC0143a();

    /* renamed from: G0, reason: collision with root package name */
    private long f11054G0 = -1;

    /* renamed from: androidx.preference.a$a, reason: collision with other inner class name */
    class RunnableC0143a implements Runnable {
        RunnableC0143a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.s2();
        }
    }

    private EditTextPreference p2() {
        return (EditTextPreference) i2();
    }

    private boolean q2() {
        long j5 = this.f11054G0;
        return j5 != -1 && j5 + 1000 > SystemClock.currentThreadTimeMillis();
    }

    public static a r2(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.G1(bundle);
        return aVar;
    }

    private void t2(boolean z5) {
        this.f11054G0 = z5 ? SystemClock.currentThreadTimeMillis() : -1L;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f11052E0);
    }

    @Override // androidx.preference.f
    protected boolean j2() {
        return true;
    }

    @Override // androidx.preference.f
    protected void k2(View view) {
        super.k2(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f11051D0 = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f11051D0.setText(this.f11052E0);
        EditText editText2 = this.f11051D0;
        editText2.setSelection(editText2.getText().length());
        p2().X0();
    }

    @Override // androidx.preference.f
    public void m2(boolean z5) {
        if (z5) {
            String string = this.f11051D0.getText().toString();
            EditTextPreference editTextPreferenceP2 = p2();
            if (editTextPreferenceP2.d(string)) {
                editTextPreferenceP2.Z0(string);
            }
        }
    }

    void s2() {
        if (q2()) {
            EditText editText = this.f11051D0;
            if (editText == null || !editText.isFocused()) {
                t2(false);
            } else if (((InputMethodManager) this.f11051D0.getContext().getSystemService("input_method")).showSoftInput(this.f11051D0, 0)) {
                t2(false);
            } else {
                this.f11051D0.removeCallbacks(this.f11053F0);
                this.f11051D0.postDelayed(this.f11053F0, 50L);
            }
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle == null) {
            this.f11052E0 = p2().Y0();
        } else {
            this.f11052E0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }
}
