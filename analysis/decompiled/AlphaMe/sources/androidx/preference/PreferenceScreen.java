package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean T;

    @RestrictTo({EnumC0546d.f12494c})
    public PreferenceScreen(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, Z2.I.m(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
        this.T = true;
    }

    @Override // androidx.preference.Preference
    public final void m() {
        F f4;
        if (this.f4089m != null || this.f4090n != null || B() == 0 || (f4 = this.f4078b.f4031j) == null) {
            return;
        }
        f4.onNavigateToScreen(this);
    }
}
