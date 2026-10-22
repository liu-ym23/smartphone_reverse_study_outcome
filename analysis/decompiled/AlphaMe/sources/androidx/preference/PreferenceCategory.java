package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, Z2.I.m(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle));
    }

    @Override // androidx.preference.Preference
    public final boolean g() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) {
        super.l(k4);
        k4.itemView.setAccessibilityHeading(true);
    }

    @Override // androidx.preference.Preference
    public final boolean w() {
        return !super.g();
    }
}
