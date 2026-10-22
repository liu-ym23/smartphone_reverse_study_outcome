package Y4;

import android.widget.CompoundButton;
import com.stepos.common.preference.SwitchPreferenceCompat;
import stepos.support.v7.app.Q;

/* loaded from: classes3.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1562a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1562a = i;
        this.b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        switch (this.f1562a) {
            case 0:
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) this.b;
                if (!switchPreferenceCompat.callChangeListener(Boolean.valueOf(z10))) {
                    compoundButton.setChecked(!z10);
                    break;
                } else {
                    switchPreferenceCompat.setChecked(z10);
                    break;
                }
            default:
                ((Q) this.b).getButton(-1).setEnabled(!z10);
                break;
        }
    }
}
