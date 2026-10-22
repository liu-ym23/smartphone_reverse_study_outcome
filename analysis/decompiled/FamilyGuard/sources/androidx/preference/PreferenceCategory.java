package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    @Override // androidx.preference.Preference
    public boolean M() {
        return false;
    }

    @Override // androidx.preference.Preference
    public boolean M0() {
        return !super.M();
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        lVar.itemView.setAccessibilityHeading(true);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11134e, R.attr.preferenceCategoryStyle));
    }
}
