package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.j;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14340a;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, s0.k.a(context, R$attr.preferenceScreenStyle, R.attr.preferenceScreenStyle));
        this.f14340a = true;
    }

    public boolean a() {
        return this.f14340a;
    }

    @Override // androidx.preference.PreferenceGroup
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        j.b bVarE;
        if (getIntent() != null || getFragment() != null || getPreferenceCount() == 0 || (bVarE = getPreferenceManager().e()) == null) {
            return;
        }
        bVarE.onNavigateToScreen(this);
    }
}
