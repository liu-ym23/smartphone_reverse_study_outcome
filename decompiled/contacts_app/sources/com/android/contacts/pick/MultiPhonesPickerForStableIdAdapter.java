package com.android.contacts.pick;

import android.app.Activity;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.SortComparatorForMultiPicker;

/* JADX INFO: loaded from: classes2.dex */
public class MultiPhonesPickerForStableIdAdapter extends MultiPhonesPickerAdapter {
    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public MultiPhonesPickerForStableIdAdapter(Activity r1) {
        super(r1);
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public long getItemId(int r5) {
        SamContact r4 = getItem(r5);
        long r0 = r4.contactId + ((long) r4.hashCode());
        if (r4.section.equals(SortComparatorForMultiPicker.SPECIAL_LABLE_FOR_SELECTED) == true) goto L5;
        return r0;
    L5:
        return r0 * (-1);
    }
}
