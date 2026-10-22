package androidx.preference;

import android.widget.CompoundButton;

/* renamed from: androidx.preference.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0329a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4134a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TwoStatePreference f4135b;

    public /* synthetic */ C0329a(TwoStatePreference twoStatePreference, int i4) {
        this.f4134a = i4;
        this.f4135b = twoStatePreference;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        int i4 = this.f4134a;
        TwoStatePreference twoStatePreference = this.f4135b;
        switch (i4) {
            case 0:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) twoStatePreference;
                if (!checkBoxPreference.a(Boolean.valueOf(z4))) {
                    compoundButton.setChecked(!z4);
                    break;
                } else {
                    checkBoxPreference.z(z4);
                    break;
                }
            case 1:
                SwitchPreference switchPreference = (SwitchPreference) twoStatePreference;
                if (!switchPreference.a(Boolean.valueOf(z4))) {
                    compoundButton.setChecked(!z4);
                    break;
                } else {
                    switchPreference.z(z4);
                    break;
                }
            default:
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) twoStatePreference;
                if (!switchPreferenceCompat.a(Boolean.valueOf(z4))) {
                    compoundButton.setChecked(!z4);
                    break;
                } else {
                    switchPreferenceCompat.z(z4);
                    break;
                }
        }
    }
}
