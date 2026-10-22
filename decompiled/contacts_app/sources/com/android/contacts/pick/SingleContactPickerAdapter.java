package com.android.contacts.pick;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.android.contacts.widget.AvatarImageView;

/* JADX INFO: loaded from: classes2.dex */
public class SingleContactPickerAdapter extends PickerAdapter {
    public SingleContactPickerAdapter(Activity r1) {
        super(r1);
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        SamContact r13 = getItem(r10);
        if (r13.getType() != 1) goto L6;
        View r9 = LayoutInflater.from(this.mContext).inflate(R.layout.contact_list_item_profile, null);
        ((TextView) r9.findViewById(R.id.name)).setText(r13.name);
        return r9;
    L6:
        if (r11 != null) goto L8;
    L11:
        PickerAdapter.ViewHolder r14 = new PickerAdapter.ViewHolder();
        r11 = LayoutInflater.from(this.mContext).inflate(R.layout.single_contact_picket_list_item, null);
        r14.name = (TextView) r11.findViewById(R.id.name);
        r14.photo = (AvatarImageView) r11.findViewById(R.id.photo);
        r11.setTag(r14);
    L12:
        setHighlightedName(r14.name, r13.name);
        r14.photo.setPhotoID(r13.photoId);
        this.mPhotoManager.loadPhoto(r14.photo, r13.photoId, false, false);
        return r11;
    L8:
        if (r11.getTag() == null) goto L11;
        r14 = (PickerAdapter.ViewHolder) r11.getTag();
        goto L12
    }
}
