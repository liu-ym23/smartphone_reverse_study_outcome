package com.android.contacts.pick;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public class MultiContactsPickerAdapter extends PickerAdapter {
    public MultiContactsPickerAdapter(Activity r1) {
        super(r1);
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L4;
        PickerAdapter.ViewHolder r7 = new PickerAdapter.ViewHolder();
        View r8 = LayoutInflater.from(this.mContext).inflate(R.layout.multi_contact_picket_list_item, null);
        r7.name = (TextView) r8.findViewById(R.id.name);
        r7.checkBox = (OCheckBox) r8.findViewById(R.id.checkBox);
        r8.setTag(r7);
    L5:
        SamContact r9 = getItem(r4);
        setHighlightedName(r7.name, r9.name);
        if (this.mPickerFragment.getSelectedIds().contains(Long.valueOf(r9.contactId)) == true) goto L8;
        r7.checkBox.setChecked(false);
    L9:
        return r8;
    L8:
        r7.checkBox.setChecked(true);
        goto L9
    L4:
        PickerAdapter.ViewHolder r10 = (PickerAdapter.ViewHolder) r5.getTag();
        r8 = r5;
        r7 = r10;
        goto L5
    }

    @Override // com.android.contacts.pick.PickerAdapter
    public long getKey(SamContact r1) {
        if ((this.mPickerFragment instanceof MultiRawContactsPickerFragment) == false) goto L7;
        return r1.raw_contactid;
    L7:
        return r1.contactId;
    }
}
