package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;

/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: D0, reason: collision with root package name */
    int f11057D0;

    /* renamed from: E0, reason: collision with root package name */
    private CharSequence[] f11058E0;

    /* renamed from: F0, reason: collision with root package name */
    private CharSequence[] f11059F0;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i5) {
            c cVar = c.this;
            cVar.f11057D0 = i5;
            cVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference p2() {
        return (ListPreference) i2();
    }

    public static c q2(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.G1(bundle);
        return cVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f11057D0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f11058E0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f11059F0);
    }

    @Override // androidx.preference.f
    public void m2(boolean z5) {
        int i5;
        if (!z5 || (i5 = this.f11057D0) < 0) {
            return;
        }
        String string = this.f11059F0[i5].toString();
        ListPreference listPreferenceP2 = p2();
        if (listPreferenceP2.d(string)) {
            listPreferenceP2.f1(string);
        }
    }

    @Override // androidx.preference.f
    protected void n2(c.a aVar) {
        super.n2(aVar);
        aVar.l(this.f11058E0, this.f11057D0, new a());
        aVar.j(null, null);
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle != null) {
            this.f11057D0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f11058E0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f11059F0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceP2 = p2();
        if (listPreferenceP2.Y0() == null || listPreferenceP2.a1() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f11057D0 = listPreferenceP2.X0(listPreferenceP2.b1());
        this.f11058E0 = listPreferenceP2.Y0();
        this.f11059F0 = listPreferenceP2.a1();
    }
}
