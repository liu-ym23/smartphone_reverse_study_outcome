package k2;

import android.widget.CompoundButton;
import com.stepos.common.preference.SwitchPreferenceCompat;

/* renamed from: k2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0678a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwitchPreferenceCompat f13336a;

    public C0678a(SwitchPreferenceCompat switchPreferenceCompat) {
        this.f13336a = switchPreferenceCompat;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        Boolean boolValueOf = Boolean.valueOf(z4);
        SwitchPreferenceCompat switchPreferenceCompat = this.f13336a;
        if (switchPreferenceCompat.a(boolValueOf)) {
            switchPreferenceCompat.z(z4);
        } else {
            compoundButton.setChecked(!z4);
        }
    }
}
