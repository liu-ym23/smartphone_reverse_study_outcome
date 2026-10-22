package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class b extends Preference {

    /* renamed from: T, reason: collision with root package name */
    private long f11056T;

    b(Context context, List<Preference> list, long j5) {
        super(context);
        R0();
        S0(list);
        this.f11056T = j5 + 1000000;
    }

    private void R0() {
        z0(p.f11149a);
        v0(n.f11142a);
        I0(q.f11154b);
        D0(999);
    }

    private void S0(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence string = null;
        for (Preference preference : list) {
            CharSequence charSequenceI = preference.I();
            boolean z5 = preference instanceof PreferenceGroup;
            if (z5 && !TextUtils.isEmpty(charSequenceI)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.v())) {
                if (z5) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceI)) {
                string = string == null ? charSequenceI : l().getString(q.f11157e, string, charSequenceI);
            }
        }
        G0(string);
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        lVar.e(false);
    }

    @Override // androidx.preference.Preference
    long q() {
        return this.f11056T;
    }
}
