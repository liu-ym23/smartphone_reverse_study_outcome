package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, m0.g.a(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle), 0);
    }

    @Override // androidx.preference.Preference
    public final boolean i() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void n(h hVar) {
        super.n(hVar);
        hVar.itemView.setAccessibilityHeading(true);
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return !super.i();
    }
}
