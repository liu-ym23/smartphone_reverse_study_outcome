package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: i, reason: collision with root package name */
    public Set<String> f14370i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public boolean f14371j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence[] f14372k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence[] f14373l;

    public class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i10, boolean z10) {
            if (z10) {
                d dVar = d.this;
                dVar.f14371j |= dVar.f14370i.add(dVar.f14373l[i10].toString());
            } else {
                d dVar2 = d.this;
                dVar2.f14371j |= dVar2.f14370i.remove(dVar2.f14373l[i10].toString());
            }
        }
    }

    public static d w(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f14370i.clear();
            this.f14370i.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f14371j = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f14372k = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f14373l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceV = v();
        if (multiSelectListPreferenceV.k() == null || multiSelectListPreferenceV.l() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f14370i.clear();
        this.f14370i.addAll(multiSelectListPreferenceV.m());
        this.f14371j = false;
        this.f14372k = multiSelectListPreferenceV.k();
        this.f14373l = multiSelectListPreferenceV.l();
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f14370i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f14371j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f14372k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f14373l);
    }

    @Override // androidx.preference.f
    public void s(boolean z10) {
        if (z10 && this.f14371j) {
            MultiSelectListPreference multiSelectListPreferenceV = v();
            if (multiSelectListPreferenceV.callChangeListener(this.f14370i)) {
                multiSelectListPreferenceV.n(this.f14370i);
            }
        }
        this.f14371j = false;
    }

    @Override // androidx.preference.f
    public void t(c.a aVar) {
        super.t(aVar);
        int length = this.f14373l.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = this.f14370i.contains(this.f14373l[i10].toString());
        }
        aVar.h(this.f14372k, zArr, new a());
    }

    public final MultiSelectListPreference v() {
        return (MultiSelectListPreference) o();
    }
}
