package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: Y, reason: collision with root package name */
    public final ArrayAdapter f4018Y;

    /* renamed from: Z, reason: collision with root package name */
    public Spinner f4019Z;

    /* renamed from: k0, reason: collision with root package name */
    public final C0331c f4020k0;

    public DropDownPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle);
        this.f4020k0 = new C0331c(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.f4018Y = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.T;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void h() {
        super.h();
        ArrayAdapter arrayAdapter = this.f4018Y;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) {
        int length;
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) k4.itemView.findViewById(R.id.spinner);
        this.f4019Z = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f4018Y);
        this.f4019Z.setOnItemSelectedListener(this.f4020k0);
        Spinner spinner2 = this.f4019Z;
        String str = this.f4055V;
        if (str == null || (charSequenceArr = this.f4054U) == null) {
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
        super.l(k4);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void m() {
        this.f4019Z.performClick();
    }
}
