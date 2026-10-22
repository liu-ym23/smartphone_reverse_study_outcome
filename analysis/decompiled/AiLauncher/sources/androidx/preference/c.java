package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.c;

/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: i, reason: collision with root package name */
    public int f14366i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence[] f14367j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence[] f14368k;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            c cVar = c.this;
            cVar.f14366i = i10;
            cVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    public static c w(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f14366i = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f14367j = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f14368k = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceV = v();
        if (listPreferenceV.l() == null || listPreferenceV.n() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f14366i = listPreferenceV.k(listPreferenceV.o());
        this.f14367j = listPreferenceV.l();
        this.f14368k = listPreferenceV.n();
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f14366i);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f14367j);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f14368k);
    }

    @Override // androidx.preference.f
    public void s(boolean z10) {
        int i10;
        if (!z10 || (i10 = this.f14366i) < 0) {
            return;
        }
        String string = this.f14368k[i10].toString();
        ListPreference listPreferenceV = v();
        if (listPreferenceV.callChangeListener(string)) {
            listPreferenceV.q(string);
        }
    }

    @Override // androidx.preference.f
    public void t(c.a aVar) {
        super.t(aVar);
        aVar.o(this.f14367j, this.f14366i, new a());
        aVar.m(null, null);
    }

    public final ListPreference v() {
        return (ListPreference) o();
    }
}
