package com.android.contacts.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayOrderPreference extends ListPreference {
    private Context mContext;
    private ContactsPreferences mPreferences;

    @Override // android.preference.Preference
    protected boolean shouldPersist() {
        return false;
    }

    public DisplayOrderPreference(Context r1) {
        super(r1);
        prepare();
    }

    public DisplayOrderPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        prepare();
    }

    private void prepare() {
        this.mContext = getContext();
        this.mPreferences = new ContactsPreferences(this.mContext);
        setEntries(new String[]{this.mContext.getString(R.string.display_options_view_given_name_first), this.mContext.getString(R.string.display_options_view_family_name_first)});
        setEntryValues(new String[]{String.valueOf(1), String.valueOf(2)});
        setValue(String.valueOf(this.mPreferences.getDisplayOrder()));
    }

    @Override // android.preference.ListPreference, android.preference.Preference
    public CharSequence getSummary() {
        int r0 = this.mPreferences.getDisplayOrder();
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
        return null;
    L9:
        return this.mContext.getString(R.string.display_options_view_family_name_first);
    L11:
        return this.mContext.getString(R.string.display_options_view_given_name_first);
    }

    @Override // android.preference.Preference
    protected boolean persistString(String r2) {
        int r3 = Integer.parseInt(r2);
        if (r3 == this.mPreferences.getDisplayOrder()) goto L7;
        this.mPreferences.setDisplayOrder(r3);
        notifyChanged();
        return true;
    L7:
        return true;
    }
}
