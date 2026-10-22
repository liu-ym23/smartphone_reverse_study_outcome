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
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandAdapterForLocation extends ExpandAdapter {
    private Context mContext;

    public ExpandAdapterForLocation(Activity r1, ArrayList<ArrayList<SamContact>> r2, ContactPhotoManager r3, ExpandListView r4) {
        super(r1, r2, r3, r4);
        this.mContext = r1;
    }

    @Override // com.android.contacts.list.ExpandAdapter, android.widget.ExpandableListAdapter
    public long getChildId(int r1, int r2) {
        SamContact r0 = getChild(r1, r2);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.phoneId;
    }

    @Override // com.android.contacts.list.ExpandAdapter
    protected String getDefaultHeaderData() {
        return this.mContext.getResources().getString(R.string.unknown);
    }

    @Override // com.android.contacts.list.ExpandAdapter, android.widget.ExpandableListAdapter
    public View getChildView(int r23, int r24, boolean r25, View r26, ViewGroup r27) {
        ExpandAdapter.ViewHolder r1 = new ExpandAdapter.ViewHolder(this);
        SamContact r2 = getChild(r23, r24);
        if (r26 != null) goto L9;
        View r3 = LayoutInflater.from(this.mContext).inflate(R.layout.contact_list_item_sort_by_city, null);
        ViewStub r4 = (ViewStub) r3.findViewById(R.id.item_background_stub);
        if (ContactsUtils.isFeatureRTLDualSim() == false) goto L7;
        r4.setLayoutResource(R.layout.contact_item_horizontal_background_items_rtl);
    L8:
        r1.photo = (AvatarImageView) r3.findViewById(R.id.photo);
        r1.name = (TextView) r3.findViewById(R.id.name);
        r1.item = (QuickContactChildLayout) r3.findViewById(R.id.item);
        r1.bgItem = r3.findViewById(R.id.item_background);
        r1.avatarFrame = (FrameLayout) r3.findViewById(R.id.photo_frame);
        r1.simIcon = (ImageView) r3.findViewById(R.id.sim_id_icon);
        r1.blacklistView = (ImageView) r3.findViewById(R.id.blacklist_photo);
        r3.setTag(r1);
    L10:
        r1.contactId = r2.contactId;
        r1.name.setText(r2.name);
        r1.photo.setPhotoID(r2.photoId);
        this.mPhotoManager.loadPhoto(r1.photo, r2.photoId, false, false);
        int r5 = DSUtils.getSimIconResource(MoreContactUtils.getSubscription(r2.accountType, r2.accountName));
        if (r5 == 0) goto L13;
        r1.simIcon.setVisibility(0);
        r1.simIcon.setImageResource(r5);
    L15:
        if (this.mIsEdit == false) goto L20;
        r1.checkBoxFrame = (FrameLayout) r3.findViewById(R.id.checkBoxFrame);
        if (r1.checkBoxFrame != null) goto L19;
        r1.checkBoxFrame = (FrameLayout) ((ViewStub) r3.findViewById(R.id.checkBoxStub)).inflate();
    L19:
        r1.checkBox = (OCheckBox) r1.checkBoxFrame.findViewById(R.id.checkBox);
        r1.avatarFrame.setVisibility(8);
        r1.checkBoxFrame.setVisibility(0);
        r1.checkBoxFrame.setScaleX(1.0f);
        r1.checkBoxFrame.setScaleY(1.0f);
        r1.checkBoxFrame.setAlpha(1.0f);
        r1.checkBox.setChecked(isSelected(r23, r24));
    L28:
        this.mBlacklistManager.loadBlacklist(r1.blacklistView, r2.contactId);
        return r3;
    L20:
        r1.avatarFrame.setVisibility(0);
        r1.avatarFrame.setScaleX(1.0f);
        r1.avatarFrame.setScaleY(1.0f);
        r1.avatarFrame.setAlpha(1.0f);
        if (r1.checkBoxFrame == null) goto L23;
        r1.checkBoxFrame.setVisibility(8);
    L23:
        QuickContactListener r11 = getQuickContactListener();
        if (r11.getQuickContactCacheId() != r2.contactId) goto L26;
        QuickContactHelper r6 = new QuickContactHelper(r11.getQuickContactHelperCache(), getActivity(), r1.item, this.mPhotoManager, getQuickContactListener(), r2.contactId, r2.LookKey, false);
    L27:
        r6.setTrackerTag("ContactListFragment");
        r1.helper = r6;
        goto L28
    L26:
        r6 = new QuickContactHelper(getActivity(), r1.item, this.mPhotoManager, r11, r2.contactId, r2.LookKey, false);
        goto L27
    L13:
        r1.simIcon.setVisibility(8);
        goto L15
    L7:
        r4.setLayoutResource(R.layout.contact_item_horizontal_background_items);
        goto L8
    L9:
        r1 = (ExpandAdapter.ViewHolder) r26.getTag();
        checkItemReused(r1, r2);
        r3 = r26;
        goto L10
    }
}
