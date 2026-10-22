package androidx.preference;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* renamed from: androidx.preference.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0333e extends t {

    /* renamed from: A, reason: collision with root package name */
    public final u f4137A = new u(1, this);

    /* renamed from: B, reason: collision with root package name */
    public long f4138B = -1;

    /* renamed from: y, reason: collision with root package name */
    public EditText f4139y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f4140z;

    @Override // androidx.preference.t
    public final void j(View view) {
        super.j(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f4139y = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f4139y.setText(this.f4140z);
        EditText editText2 = this.f4139y;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) i()).getClass();
    }

    @Override // androidx.preference.t
    public final void k(boolean z4) {
        if (z4) {
            String string = this.f4139y.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) i();
            if (editTextPreference.a(string)) {
                editTextPreference.z(string);
            }
        }
    }

    public final void m() {
        long j4 = this.f4138B;
        if (j4 == -1 || j4 + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return;
        }
        EditText editText = this.f4139y;
        if (editText == null || !editText.isFocused()) {
            this.f4138B = -1L;
            return;
        }
        if (((InputMethodManager) this.f4139y.getContext().getSystemService("input_method")).showSoftInput(this.f4139y, 0)) {
            this.f4138B = -1L;
            return;
        }
        EditText editText2 = this.f4139y;
        u uVar = this.f4137A;
        editText2.removeCallbacks(uVar);
        this.f4139y.postDelayed(uVar, 50L);
    }

    @Override // androidx.preference.t, androidx.fragment.app.r, androidx.fragment.app.D
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f4140z = ((EditTextPreference) i()).T;
        } else {
            this.f4140z = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.t, androidx.fragment.app.r, androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f4140z);
    }
}
