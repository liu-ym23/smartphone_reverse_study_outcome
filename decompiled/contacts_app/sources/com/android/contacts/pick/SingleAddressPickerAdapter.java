package com.android.contacts.pick;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.widget.AvatarImageView;

/* JADX INFO: loaded from: classes2.dex */
public class SingleAddressPickerAdapter extends PickerAdapter {
    public SingleAddressPickerAdapter(Activity r1) {
        super(r1);
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L4;
        r11 = LayoutInflater.from(this.mContext).inflate(R.layout.single_data_picker_list_item, null);
        PickerAdapter.ViewHolder r13 = new PickerAdapter.ViewHolder();
        r13.name = (TextView) r11.findViewById(R.id.name);
        r13.photo = (AvatarImageView) r11.findViewById(R.id.photo);
        r13.label = (TextView) r11.findViewById(R.id.label);
        r11.setTag(r13);
    L5:
        SamContact r14 = getItem(r10);
        r13.name.setText(r14.name);
        r13.label.setText(ContactsUtils.getContactPhoneDescribe(this.mContext, r14.labelres, r14.label, r14.number));
        r13.photo.setPhotoID(r14.photoId);
        this.mPhotoManager.loadPhoto(r13.photo, r14.photoId, false, false);
        return r11;
    L4:
        r13 = (PickerAdapter.ViewHolder) r11.getTag();
        goto L5
    }
}
