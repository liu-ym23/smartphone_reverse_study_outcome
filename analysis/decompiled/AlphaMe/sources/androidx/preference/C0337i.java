package androidx.preference;

import android.os.Bundle;
import androidx.appcompat.app.C0182h;
import androidx.appcompat.app.C0186l;

/* renamed from: androidx.preference.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0337i extends t {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence[] f4143A;

    /* renamed from: y, reason: collision with root package name */
    public int f4144y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence[] f4145z;

    @Override // androidx.preference.t
    public final void k(boolean z4) {
        int i4;
        if (!z4 || (i4 = this.f4144y) < 0) {
            return;
        }
        String string = this.f4143A[i4].toString();
        ListPreference listPreference = (ListPreference) i();
        if (listPreference.a(string)) {
            listPreference.B(string);
        }
    }

    @Override // androidx.preference.t
    public final void l(C0186l c0186l) {
        CharSequence[] charSequenceArr = this.f4145z;
        int i4 = this.f4144y;
        DialogInterfaceOnClickListenerC0336h dialogInterfaceOnClickListenerC0336h = new DialogInterfaceOnClickListenerC0336h(this);
        Object obj = c0186l.f2661c;
        C0182h c0182h = (C0182h) obj;
        c0182h.f2608l = charSequenceArr;
        c0182h.f2610n = dialogInterfaceOnClickListenerC0336h;
        c0182h.f2615s = i4;
        c0182h.f2614r = true;
        C0182h c0182h2 = (C0182h) obj;
        c0182h2.f2603g = null;
        c0182h2.f2604h = null;
    }

    @Override // androidx.preference.t, androidx.fragment.app.r, androidx.fragment.app.D
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4144y = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f4145z = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f4143A = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) i();
        if (listPreference.T == null || (charSequenceArr = listPreference.f4054U) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f4144y = listPreference.z(listPreference.f4055V);
        this.f4145z = listPreference.T;
        this.f4143A = charSequenceArr;
    }

    @Override // androidx.preference.t, androidx.fragment.app.r, androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f4144y);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f4145z);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f4143A);
    }
}
