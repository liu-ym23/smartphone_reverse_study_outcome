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

    /* renamed from: e0, reason: collision with root package name */
    private final Context f10946e0;

    /* renamed from: f0, reason: collision with root package name */
    private final ArrayAdapter f10947f0;

    /* renamed from: g0, reason: collision with root package name */
    private Spinner f10948g0;

    /* renamed from: h0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f10949h0;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
            if (i5 >= 0) {
                String string = DropDownPreference.this.a1()[i5].toString();
                if (string.equals(DropDownPreference.this.b1()) || !DropDownPreference.this.d(string)) {
                    return;
                }
                DropDownPreference.this.f1(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f11132c);
    }

    private int h1(String str) {
        CharSequence[] charSequenceArrA1 = a1();
        if (str == null || charSequenceArrA1 == null) {
            return -1;
        }
        for (int length = charSequenceArrA1.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArrA1[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    private void i1() {
        this.f10947f0.clear();
        if (Y0() != null) {
            for (CharSequence charSequence : Y0()) {
                this.f10947f0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void Q() {
        super.Q();
        ArrayAdapter arrayAdapter = this.f10947f0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        Spinner spinner = (Spinner) lVar.itemView.findViewById(o.f11147e);
        this.f10948g0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f10947f0);
        this.f10948g0.setOnItemSelectedListener(this.f10949h0);
        this.f10948g0.setSelection(h1(b1()));
        super.W(lVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void X() {
        this.f10948g0.performClick();
    }

    @Override // androidx.preference.ListPreference
    public void e1(CharSequence[] charSequenceArr) {
        super.e1(charSequenceArr);
        i1();
    }

    protected ArrayAdapter g1() {
        return new ArrayAdapter(this.f10946e0, R.layout.simple_spinner_dropdown_item);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f10949h0 = new a();
        this.f10946e0 = context;
        this.f10947f0 = g1();
        i1();
    }
}
