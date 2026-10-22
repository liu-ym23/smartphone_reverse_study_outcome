package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter c0;

    /* renamed from: d0, reason: collision with root package name */
    public Spinner f2338d0;

    /* renamed from: e0, reason: collision with root package name */
    public final a f2339e0;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle);
        this.f2339e0 = new a();
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.c0 = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.X;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void j() {
        super.j();
        ArrayAdapter arrayAdapter = this.c0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void n(h hVar) {
        int length;
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) hVar.itemView.findViewById(R.id.spinner);
        this.f2338d0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.c0);
        this.f2338d0.setOnItemSelectedListener(this.f2339e0);
        Spinner spinner2 = this.f2338d0;
        String str = this.Z;
        if (str == null || (charSequenceArr = this.Y) == null) {
            length = -1;
        } else {
            length = charSequenceArr.length - 1;
            while (length >= 0) {
                if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    break;
                } else {
                    length--;
                }
            }
            length = -1;
        }
        spinner2.setSelection(length);
        super.n(hVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void o() {
        this.f2338d0.performClick();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (i10 >= 0) {
                DropDownPreference dropDownPreference = DropDownPreference.this;
                String string = dropDownPreference.Y[i10].toString();
                if (string.equals(dropDownPreference.Z) || !dropDownPreference.a(string)) {
                    return;
                }
                dropDownPreference.C(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
