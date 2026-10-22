package androidx.preference;

import android.view.View;
import android.widget.AdapterView;

/* renamed from: androidx.preference.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0331c implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DropDownPreference f4136a;

    public C0331c(DropDownPreference dropDownPreference) {
        this.f4136a = dropDownPreference;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
        if (i4 >= 0) {
            DropDownPreference dropDownPreference = this.f4136a;
            String string = dropDownPreference.f4054U[i4].toString();
            if (string.equals(dropDownPreference.f4055V) || !dropDownPreference.a(string)) {
                return;
            }
            dropDownPreference.B(string);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
