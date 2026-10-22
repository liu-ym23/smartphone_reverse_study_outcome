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
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandAdapterForCompany extends ExpandAdapter {
    private Context mContext;

    public ExpandAdapterForCompany(Activity r1, ArrayList<ArrayList<SamContact>> r2, ContactPhotoManager r3, ExpandListView r4) {
        super(r1, r2, r3, r4);
        this.mContext = r1;
    }

    @Override // com.android.contacts.list.ExpandAdapter, android.widget.ExpandableListAdapter
    public long getChildId(int r1, int r2) {
        SamContact r0 = getChild(r1, r2);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.contactId;
    }

    @Override // com.android.contacts.list.ExpandAdapter
    protected String getDefaultHeaderData() {
        return this.mContext.getString(R.string.contacts_sort_by_company_default_header);
    }

    @Override // com.android.contacts.list.ExpandAdapter, android.widget.ExpandableListAdapter
    public View getChildView(int r25, int r26, boolean r27, View r28, ViewGroup r29) {
        SamContact r1 = getChild(r25, r26);
        ExpandAdapter.ViewHolder r2 = new ExpandAdapter.ViewHolder(this);
        if (r28 != null) goto L9;
        View r3 = LayoutInflater.from(this.mContext).inflate(R.layout.contact_list_item_sort_by_company, null);
        ViewStub r4 = (ViewStub) r3.findViewById(R.id.item_background_stub);
        if (ContactsUtils.isFeatureRTLDualSim() == false) goto L7;
        r4.setLayoutResource(R.layout.contact_item_horizontal_background_items_rtl);
    L8:
        r2.photo = (AvatarImageView) r3.findViewById(R.id.photo);
        r2.name = (TextView) r3.findViewById(R.id.name);
        r2.item = (QuickContactChildLayout) r3.findViewById(R.id.item);
        r2.bgItem = r3.findViewById(R.id.item_background);
        r2.avatarFrame = (FrameLayout) r3.findViewById(R.id.photo_frame);
        r2.checkBoxFrame = (FrameLayout) r3.findViewById(R.id.checkBoxFrame);
        r2.checkBox = (OCheckBox) r3.findViewById(R.id.checkBox);
        r2.rightHand = (TextView) r3.findViewById(R.id.right_hand);
        r2.simIcon = (ImageView) r3.findViewById(R.id.sim_id_icon);
        r3.setTag(r2);
    L10:
        r2.contactId = r1.contactId;
        r2.name.setText(r1.name);
        r2.photo.setPhotoID(r1.photoId);
        this.mPhotoManager.loadPhoto(r2.photo, r1.photoId, false, false);
        int r5 = DSUtils.getSimIconResource(MoreContactUtils.getSubscription(r1.accountType, r1.accountName));
        if (r5 == 0) goto L13;
        r2.simIcon.setVisibility(0);
        r2.simIcon.setImageResource(r5);
    L15:
        if (this.mIsEdit == false) goto L17;
        r2.avatarFrame.setVisibility(8);
        r2.checkBoxFrame.setVisibility(0);
        r2.checkBoxFrame.setScaleX(1.0f);
        r2.checkBoxFrame.setScaleY(1.0f);
        r2.checkBoxFrame.setAlpha(1.0f);
        r2.rightHand.setVisibility(8);
        r2.checkBox.setChecked(isSelected(r25, r26));
    L22:
        return r3;
    L17:
        r2.avatarFrame.setVisibility(0);
        r2.avatarFrame.setScaleX(1.0f);
        r2.avatarFrame.setScaleY(1.0f);
        r2.avatarFrame.setAlpha(1.0f);
        r2.checkBoxFrame.setVisibility(8);
        long r6 = getChildId(r25, r26);
        if (getQuickContactListener().getQuickContactCacheId() != r6) goto L20;
        QuickContactHelper r7 = new QuickContactHelper(getQuickContactListener().getQuickContactHelperCache(), getActivity(), r2.item, this.mPhotoManager, getQuickContactListener(), r1.contactId, r1.LookKey, false);
    L21:
        r7.setTrackerTag("ContactListFragment");
        r2.helper = r7;
        goto L22
    L20:
        r7 = new QuickContactHelper(getActivity(), r2.item, this.mPhotoManager, getQuickContactListener(), r1.contactId, r1.LookKey, false);
        goto L21
    L13:
        r2.simIcon.setVisibility(8);
        goto L15
    L7:
        r4.setLayoutResource(R.layout.contact_item_horizontal_background_items);
        goto L8
    L9:
        r2 = (ExpandAdapter.ViewHolder) r28.getTag();
        checkItemReused(r2, r1);
        r3 = r28;
        goto L10
    }

    @Override // com.android.contacts.list.ExpandAdapter
    protected void setBackgroundItemButtonsOnClickListener(View r4, View.OnClickListener r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int[] r0 = {R.id.umb_phone, R.id.umb_phone_1, R.id.umb_phone_2, R.id.umb_message, R.id.umb_star, R.id.umb_group, R.id.umb_avatar};
        int r1 = 0;
    L5:
        if (r1 >= 7) goto L10;
        View r2 = r4.findViewById(r0[r1]);
        if (r2 == null) goto L9;
        r2.setOnClickListener(r5);
    L9:
        r1 = r1 + 1;
        goto L5
    }
}
