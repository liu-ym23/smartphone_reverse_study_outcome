package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds;

    @Override // androidx.preference.PreferenceGroup
    protected boolean isOnSameScreenAsChildren() {
        return false;
    }

    public PreferenceScreen(Context r3, AttributeSet r4) {
        super(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
        this.mShouldUseGeneratedIds = true;
    }

    @Override // androidx.preference.Preference
    protected void onClick() {
        if (getIntent() == null) goto L5;
        return;
    L5:
        if (getFragment() == null) goto L7;
        return;
    L7:
        if (getPreferenceCount() == 0) goto L16;
        PreferenceManager.OnNavigateToScreenListener r0 = getPreferenceManager().getOnNavigateToScreenListener();
        if (r0 == null) goto L15;
        r0.onNavigateToScreen(this);
        return;
    L15:
        return;
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }

    public void setShouldUseGeneratedIds(boolean r2) {
        if (isAttached() == true) goto L7;
        this.mShouldUseGeneratedIds = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot change the usage of generated IDs while attached to the preference hierarchy");
    }
}
