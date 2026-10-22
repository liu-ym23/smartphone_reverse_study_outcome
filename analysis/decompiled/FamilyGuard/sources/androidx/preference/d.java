package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: D0, reason: collision with root package name */
    Set<String> f11061D0 = new HashSet();

    /* renamed from: E0, reason: collision with root package name */
    boolean f11062E0;

    /* renamed from: F0, reason: collision with root package name */
    CharSequence[] f11063F0;

    /* renamed from: G0, reason: collision with root package name */
    CharSequence[] f11064G0;

    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i5, boolean z5) {
            if (z5) {
                d dVar = d.this;
                dVar.f11062E0 |= dVar.f11061D0.add(dVar.f11064G0[i5].toString());
            } else {
                d dVar2 = d.this;
                dVar2.f11062E0 |= dVar2.f11061D0.remove(dVar2.f11064G0[i5].toString());
            }
        }
    }

    private MultiSelectListPreference p2() {
        return (MultiSelectListPreference) i2();
    }

    public static d q2(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.G1(bundle);
        return dVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f11061D0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f11062E0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f11063F0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f11064G0);
    }

    @Override // androidx.preference.f
    public void m2(boolean z5) {
        if (z5 && this.f11062E0) {
            MultiSelectListPreference multiSelectListPreferenceP2 = p2();
            if (multiSelectListPreferenceP2.d(this.f11061D0)) {
                multiSelectListPreferenceP2.a1(this.f11061D0);
            }
        }
        this.f11062E0 = false;
    }

    @Override // androidx.preference.f
    protected void n2(c.a aVar) {
        super.n2(aVar);
        int length = this.f11064G0.length;
        boolean[] zArr = new boolean[length];
        for (int i5 = 0; i5 < length; i5++) {
            zArr[i5] = this.f11061D0.contains(this.f11064G0[i5].toString());
        }
        aVar.g(this.f11063F0, zArr, new a());
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle != null) {
            this.f11061D0.clear();
            this.f11061D0.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f11062E0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f11063F0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f11064G0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceP2 = p2();
        if (multiSelectListPreferenceP2.X0() == null || multiSelectListPreferenceP2.Y0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f11061D0.clear();
        this.f11061D0.addAll(multiSelectListPreferenceP2.Z0());
        this.f11062E0 = false;
        this.f11063F0 = multiSelectListPreferenceP2.X0();
        this.f11064G0 = multiSelectListPreferenceP2.Y0();
    }
}
