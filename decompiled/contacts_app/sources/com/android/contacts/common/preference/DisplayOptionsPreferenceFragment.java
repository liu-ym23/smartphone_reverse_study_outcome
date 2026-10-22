package com.android.contacts.common.preference;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.android.contacts.common.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.commonbind.ObjectFactory;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DisplayOptionsPreferenceFragment extends PreferenceFragment {
    public DisplayOptionsPreferenceFragment() {
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        addPreferencesFromResource(R.xml.preference_display_options);
        removeUnsupportedPreferences();
        addExtraPreferences();
        Preference r3 = findPreference("about");
        if (r3 == null) goto L6;
        r3.setOnPreferenceClickListener(new AnonymousClass1(this));
        return;
    }

    private void removeUnsupportedPreferences() {
        Resources r0 = getResources();
        if (r0.getBoolean(R.bool.config_sort_order_user_changeable) == true) goto L6;
        getPreferenceScreen().removePreference(findPreference("sortOrder"));
    L6:
        if (r0.getBoolean(R.bool.config_display_order_user_changeable) == true) goto L8;
        getPreferenceScreen().removePreference(findPreference("displayOrder"));
    L8:
        Context r1 = getContext();
        if (r1 != null) goto L11;
        return;
    L11:
        if (AccountTypeManager.getInstance(r1).getAccounts(true).isEmpty() == false) goto L15;
        getPreferenceScreen().removePreference(findPreference("accounts"));
        return;
    }

    private void addExtraPreferences() {
        PreferenceManager r0 = ObjectFactory.getPreferenceManager(getContext());
        if (r0 == null) goto L8;
        Iterator<Preference> r1 = r0.getPreferences().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Preference r2 = r1.next();
        getPreferenceScreen().addPreference(r2);
        goto L6
    L10:
        return;
    }

    @Override // android.app.Fragment
    public Context getContext() {
        return getActivity();
    }
}
