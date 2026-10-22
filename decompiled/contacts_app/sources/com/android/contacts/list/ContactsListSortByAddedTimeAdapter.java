package com.android.contacts.list;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsListSortByAddedTimeAdapter extends ContactsListBaseAdapter {
    private Context mContext;

    public ContactsListSortByAddedTimeAdapter(Activity r1, ArrayList<SamContact> r2, ContactPhotoManager r3, AsyncImageLoader r4) {
        super(r1, r2, r3, r4);
        this.mContext = r1;
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, com.android.contacts.PinnedHeaderList.HeadersAdapter
    public View getHeaderView(int r1, View r2, ViewGroup r3) {
        if (r2 != null) goto L4;
        r2 = LayoutInflater.from(this.mContext).inflate(R.layout.header, null);
    L4:
        String r0 = this.mContext.getResources().getString(R.string.contacts_list_sortbyaddedtime_label);
        ((TextView) r2.findViewById(R.id.text)).setText(r0);
        r2.setTag(r0);
        return r2;
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, com.android.contacts.PinnedHeaderList.HeadersAdapter
    public long getHeaderId(int r1) {
        return this.mContacts.get(r1).timesContacted;
    }

    @Override // com.android.contacts.list.ContactsListBaseAdapter, android.widget.Adapter
    public View getView(int r25, View r26, ViewGroup r27) {
        ContactsListBaseAdapter.ViewHolder r1 = new ContactsListBaseAdapter.ViewHolder(this);
        SamContact r2 = this.mContacts.get(r25);
        if (r26 != null) goto L9;
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.contact_list_item, null);
        ViewStub r5 = (ViewStub) r4.findViewById(R.id.item_background_stub);
        if (ContactsUtils.isFeatureRTLDualSim() == false) goto L7;
        r5.setLayoutResource(R.layout.contact_item_horizontal_background_items_rtl);
    L8:
        r1.name = (TextView) r4.findViewById(R.id.name);
        r1.photo = (AvatarImageView) r4.findViewById(R.id.photo);
        r1.item = (QuickContactChildLayout) r4.findViewById(R.id.item);
        r1.bgItem = r4.findViewById(R.id.item_background);
        r1.avatarFrame = (FrameLayout) r4.findViewById(R.id.photo_frame);
        r1.simIcon = (ImageView) r4.findViewById(R.id.sim_id_icon);
        r1.blacklistView = (ImageView) r4.findViewById(R.id.blacklist_photo);
        r4.setTag(r1);
    L10:
        r1.name.setText(r2.name);
        r1.contactId = r2.contactId;
        r1.photo.setPhotoID(r2.photoId);
        this.mPhotoManager.loadPhoto(r1.photo, r2.photoId, false, false);
        int r6 = DSUtils.getSimIconResource(MoreContactUtils.getSubscription(r2.accountType, r2.accountName));
        if (r6 == 0) goto L13;
        r1.simIcon.setVisibility(0);
        r1.simIcon.setImageResource(r6);
        r1.name.setPadding(r1.name.getPaddingLeft(), r1.name.getPaddingTop(), 18, r1.name.getPaddingBottom());
    L15:
        if (this.mIsEdit == false) goto L20;
        r1.checkBoxFrame = (FrameLayout) r4.findViewById(R.id.checkBoxFrame);
        if (r1.checkBoxFrame != null) goto L19;
        r1.checkBoxFrame = (FrameLayout) ((ViewStub) r4.findViewById(R.id.checkBoxStub)).inflate();
    L19:
        r1.checkBox = (OCheckBox) r1.checkBoxFrame.findViewById(R.id.checkBox);
        r1.avatarFrame.setVisibility(8);
        r1.checkBoxFrame.setVisibility(0);
        ViewGroup.LayoutParams r7 = r1.checkBoxFrame.getLayoutParams();
        r7.width = -1;
        r7.height = -1;
        r1.checkBoxFrame.setLayoutParams(r7);
        r1.checkBoxFrame.setScaleX(1.0f);
        r1.checkBoxFrame.setScaleY(1.0f);
        r1.checkBoxFrame.setAlpha(1.0f);
        r1.checkBox.setChecked(isSelected(r25));
    L28:
        this.mBlacklistManager.loadBlacklist(r1.blacklistView, r2.contactId);
        r1.item.setBackgroundResource(R.drawable.contact_list_bg);
        return r4;
    L20:
        r1.avatarFrame.setVisibility(0);
        r1.avatarFrame.setScaleX(1.0f);
        r1.avatarFrame.setScaleY(1.0f);
        r1.avatarFrame.setAlpha(1.0f);
        if (r1.checkBoxFrame == null) goto L24;
        r1.checkBoxFrame.setVisibility(8);
    L24:
        if (getQuickContactListener().getQuickContactCacheId() != r2.contactId) goto L26;
        QuickContactHelper r3 = new QuickContactHelper(getQuickContactListener().getQuickContactHelperCache(), getActivity(), r1.item, this.mPhotoManager, getQuickContactListener(), r2.contactId, r2.LookKey, false);
    L27:
        r3.setTrackerTag("ContactListFragment");
        r1.helper = r3;
        goto L28
    L26:
        r3 = new QuickContactHelper(getActivity(), r1.item, this.mPhotoManager, getQuickContactListener(), r2.contactId, r2.LookKey, false);
        goto L27
    L13:
        r1.simIcon.setVisibility(8);
        r1.name.setPadding(r1.name.getPaddingLeft(), r1.name.getPaddingTop(), 0, r1.name.getPaddingBottom());
        goto L15
    L7:
        r5.setLayoutResource(R.layout.contact_item_horizontal_background_items);
        goto L8
    L9:
        r1 = (ContactsListBaseAdapter.ViewHolder) r26.getTag();
        checkItemReused(r1, r2);
        r4 = r26;
        goto L10
    }
}
