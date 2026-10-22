package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean Z;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, m0.g.a(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle), 0);
        this.Z = true;
    }

    @Override // androidx.preference.Preference
    public final void o() {
        PreferenceFragmentCompat preferenceFragmentCompat;
        if (this.f2358p != null || this.f2359q != null || this.T.size() == 0 || (preferenceFragmentCompat = this.f2348b.f2417j) == null) {
            return;
        }
        preferenceFragmentCompat.onNavigateToScreen(this);
    }
}
