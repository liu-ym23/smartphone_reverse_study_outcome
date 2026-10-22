package androidx.preference;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: l, reason: collision with root package name */
    public final Context f14321l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayAdapter f14322m;

    /* renamed from: n, reason: collision with root package name */
    public Spinner f14323n;

    /* renamed from: o, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f14324o;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (i10 >= 0) {
                String string = DropDownPreference.this.n()[i10].toString();
                if (string.equals(DropDownPreference.this.o()) || !DropDownPreference.this.callChangeListener(string)) {
                    return;
                }
                DropDownPreference.this.q(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.dropdownPreferenceStyle);
    }

    @Override // androidx.preference.Preference
    public void notifyChanged() {
        super.notifyChanged();
        ArrayAdapter arrayAdapter = this.f14322m;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        Spinner spinner = (Spinner) lVar.itemView.findViewById(R$id.spinner);
        this.f14323n = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f14322m);
        this.f14323n.setOnItemSelectedListener(this.f14324o);
        this.f14323n.setSelection(s(o()));
        super.onBindViewHolder(lVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        this.f14323n.performClick();
    }

    public ArrayAdapter r() {
        return new ArrayAdapter(this.f14321l, R.layout.simple_spinner_dropdown_item);
    }

    public final int s(String str) {
        CharSequence[] charSequenceArrN = n();
        if (str == null || charSequenceArrN == null) {
            return -1;
        }
        for (int length = charSequenceArrN.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArrN[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final void t() {
        this.f14322m.clear();
        if (l() != null) {
            for (CharSequence charSequence : l()) {
                this.f14322m.add(charSequence.toString());
            }
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f14324o = new a();
        this.f14321l = context;
        this.f14322m = r();
        t();
    }
}
