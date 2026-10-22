package androidx.preference;

import android.os.Bundle;
import androidx.appcompat.app.C0182h;
import androidx.appcompat.app.C0186l;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: androidx.preference.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0340l extends t {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence[] f4149A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence[] f4150B;

    /* renamed from: y, reason: collision with root package name */
    public final HashSet f4151y = new HashSet();

    /* renamed from: z, reason: collision with root package name */
    public boolean f4152z;

    @Override // androidx.preference.t
    public final void k(boolean z4) {
        if (z4 && this.f4152z) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) i();
            HashSet hashSet = this.f4151y;
            if (multiSelectListPreference.a(hashSet)) {
                multiSelectListPreference.z(hashSet);
            }
        }
        this.f4152z = false;
    }

    @Override // androidx.preference.t
    public final void l(C0186l c0186l) {
        int length = this.f4150B.length;
        boolean[] zArr = new boolean[length];
        for (int i4 = 0; i4 < length; i4++) {
            zArr[i4] = this.f4151y.contains(this.f4150B[i4].toString());
        }
        CharSequence[] charSequenceArr = this.f4149A;
        DialogInterfaceOnMultiChoiceClickListenerC0339k dialogInterfaceOnMultiChoiceClickListenerC0339k = new DialogInterfaceOnMultiChoiceClickListenerC0339k(this);
        C0182h c0182h = (C0182h) c0186l.f2661c;
        c0182h.f2608l = charSequenceArr;
        c0182h.f2616t = dialogInterfaceOnMultiChoiceClickListenerC0339k;
        c0182h.f2612p = zArr;
        c0182h.f2613q = true;
    }

    @Override // androidx.preference.t, androidx.fragment.app.r, androidx.fragment.app.D
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        HashSet hashSet = this.f4151y;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f4152z = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f4149A = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f4150B = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) i();
        if (multiSelectListPreference.T == null || (charSequenceArr = multiSelectListPreference.f4060U) == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.f4061V);
        this.f4152z = false;
        this.f4149A = multiSelectListPreference.T;
        this.f4150B = charSequenceArr;
    }

    @Override // androidx.preference.t, androidx.fragment.app.r, androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f4151y));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f4152z);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f4149A);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f4150B);
    }
}
