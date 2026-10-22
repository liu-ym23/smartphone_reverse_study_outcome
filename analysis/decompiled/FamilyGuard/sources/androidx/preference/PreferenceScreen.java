package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.j;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: b0, reason: collision with root package name */
    private boolean f11019b0;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.content.res.k.a(context, m.f11136g, R.attr.preferenceScreenStyle));
        this.f11019b0 = true;
    }

    @Override // androidx.preference.Preference
    protected void X() {
        j.b bVarG;
        if (r() != null || o() != null || X0() == 0 || (bVarG = E().g()) == null) {
            return;
        }
        bVarG.h(this);
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean Y0() {
        return false;
    }

    public boolean f1() {
        return this.f11019b0;
    }
}
