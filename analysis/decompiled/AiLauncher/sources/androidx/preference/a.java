package androidx.preference;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: i, reason: collision with root package name */
    public EditText f14360i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f14361j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f14362k = new RunnableC0174a();

    /* renamed from: l, reason: collision with root package name */
    public long f14363l = -1;

    /* renamed from: androidx.preference.a$a, reason: collision with other inner class name */
    public class RunnableC0174a implements Runnable {
        public RunnableC0174a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.y();
        }
    }

    public static a x(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f14361j = v().l();
        } else {
            this.f14361j = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f14361j);
    }

    @Override // androidx.preference.f
    public boolean p() {
        return true;
    }

    @Override // androidx.preference.f
    public void q(View view) {
        super.q(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f14360i = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f14360i.setText(this.f14361j);
        EditText editText2 = this.f14360i;
        editText2.setSelection(editText2.getText().length());
        v().k();
    }

    @Override // androidx.preference.f
    public void s(boolean z10) {
        if (z10) {
            String string = this.f14360i.getText().toString();
            EditTextPreference editTextPreferenceV = v();
            if (editTextPreferenceV.callChangeListener(string)) {
                editTextPreferenceV.m(string);
            }
        }
    }

    public final EditTextPreference v() {
        return (EditTextPreference) o();
    }

    public final boolean w() {
        long j10 = this.f14363l;
        return j10 != -1 && j10 + 1000 > SystemClock.currentThreadTimeMillis();
    }

    public void y() {
        if (w()) {
            EditText editText = this.f14360i;
            if (editText == null || !editText.isFocused()) {
                z(false);
            } else if (((InputMethodManager) this.f14360i.getContext().getSystemService("input_method")).showSoftInput(this.f14360i, 0)) {
                z(false);
            } else {
                this.f14360i.removeCallbacks(this.f14362k);
                this.f14360i.postDelayed(this.f14362k, 50L);
            }
        }
    }

    public final void z(boolean z10) {
        this.f14363l = z10 ? SystemClock.currentThreadTimeMillis() : -1L;
    }
}
