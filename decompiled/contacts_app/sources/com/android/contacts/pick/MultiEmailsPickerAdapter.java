package com.android.contacts.pick;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public class MultiEmailsPickerAdapter extends PickerAdapter {
    public MultiEmailsPickerAdapter(Activity r1) {
        super(r1);
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        if (r7 != null) goto L4;
        r7 = LayoutInflater.from(this.mContext).inflate(R.layout.multi_data_picker_list_item, null);
        PickerAdapter.ViewHolder r9 = new PickerAdapter.ViewHolder();
        r9.name = (TextView) r7.findViewById(R.id.name);
        r9.label = (TextView) r7.findViewById(R.id.label);
        r9.checkBox = (OCheckBox) r7.findViewById(R.id.checkBox);
        r7.setTag(r9);
    L5:
        SamContact r10 = getItem(r6);
        setHighlightedName(r9.name, r10.name);
        r9.label.setText(ContactsUtils.getContactEmailDescrib(this.mContext.getResources(), r10.labelres, r10.label, r10.number));
        if (this.mPickerFragment.getSelectedIds().contains(Long.valueOf(r10.phoneId)) == true) goto L8;
        r9.checkBox.setChecked(false);
    L9:
        return r7;
    L8:
        r9.checkBox.setChecked(true);
        goto L9
    L4:
        r9 = (PickerAdapter.ViewHolder) r7.getTag();
        goto L5
    }

    @Override // com.android.contacts.pick.PickerAdapter
    public long getKey(SamContact r1) {
        return r1.phoneId;
    }
}
