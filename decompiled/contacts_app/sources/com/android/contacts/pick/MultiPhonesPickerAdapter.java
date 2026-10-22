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
public class MultiPhonesPickerAdapter extends PickerAdapter {
    public MultiPhonesPickerAdapter(Activity r1) {
        super(r1);
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L4;
        r5 = LayoutInflater.from(this.mContext).inflate(R.layout.multi_data_picker_list_item, null);
        PickerAdapter.ViewHolder r7 = new PickerAdapter.ViewHolder();
        r7.name = (TextView) r5.findViewById(R.id.name);
        r7.label = (TextView) r5.findViewById(R.id.label);
        r7.checkBox = (OCheckBox) r5.findViewById(R.id.checkBox);
        r5.setTag(r7);
    L5:
        SamContact r8 = getItem(r4);
        setHighlightedName(r7.name, r8.name);
        if (this.mPickerFragment.getSelectedIds().contains(Long.valueOf(r8.phoneId)) == true) goto L8;
        r7.checkBox.setChecked(false);
    L9:
        CharSequence r3 = getNumberHighlightDescription(r8.labelres, r8.label, r8.number);
        r7.label.setText(r3);
        return r5;
    L8:
        r7.checkBox.setChecked(true);
        goto L9
    L4:
        r7 = (PickerAdapter.ViewHolder) r5.getTag();
        goto L5
    }

    @Override // com.android.contacts.pick.PickerAdapter
    public long getKey(SamContact r1) {
        return r1.phoneId;
    }
}
