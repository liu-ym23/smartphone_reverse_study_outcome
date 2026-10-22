package com.android.contacts.common.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public final class SortOrderPreference extends ListPreference {
    private Context mContext;
    private ContactsPreferences mPreferences;

    @Override // android.preference.Preference
    protected boolean shouldPersist() {
        return false;
    }

    public SortOrderPreference(Context r1) {
        super(r1);
        prepare();
    }

    public SortOrderPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        prepare();
    }

    private void prepare() {
        this.mContext = getContext();
        this.mPreferences = new ContactsPreferences(this.mContext);
        setEntries(new String[]{this.mContext.getString(R.string.common_given_name), this.mContext.getString(R.string.common_last_name)});
        setEntryValues(new String[]{String.valueOf(1), String.valueOf(2)});
        setValue(String.valueOf(this.mPreferences.getSortOrder()));
    }

    @Override // android.preference.ListPreference, android.preference.Preference
    public CharSequence getSummary() {
        int r0 = this.mPreferences.getSortOrder();
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
        return null;
    L9:
        return this.mContext.getString(R.string.common_last_name);
    L11:
        return this.mContext.getString(R.string.common_given_name);
    }

    @Override // android.preference.Preference
    protected boolean persistString(String r2) {
        int r3 = Integer.parseInt(r2);
        if (r3 == this.mPreferences.getSortOrder()) goto L7;
        this.mPreferences.setSortOrder(r3);
        notifyChanged();
        return true;
    L7:
        return true;
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder r1) {
        super.onPrepareDialogBuilder(r1);
        r1.setNegativeButton(null, null);
    }
}
