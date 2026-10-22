package com.android.contacts.group;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.list.SamContact;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SendGroupAdapter extends BaseAdapter {
    List<SamContact> mContacts;
    private GroupDetailFragment mGroupDetailFragment;
    private boolean mIsSendEmail;
    private HashMap<Long, String> mSelectDateIds;

    private class OnViewClick extends ContactsCommonListItem.ContactsCommonListItemClickListener {
        SamContact contact;
        ContactsCommonListItem mCardListItem;
        Context mContext;
        int mPosition;
        final /* synthetic */ SendGroupAdapter this$0;

        public OnViewClick(SendGroupAdapter r1, int r2, ContactsCommonListItem r3, Context r4) {
            this.this$0 = r1;
            this.mPosition = r2;
            this.contact = r1.mContacts.get(this.mPosition);
            this.mCardListItem = r3;
            this.mContext = r4;
        }

        @Override // com.obric.utils.views.commonitemview.ContactsCommonListItem.ContactsCommonListItemClickListener
        public void onClick(View r4) {
            if (SendGroupAdapter.access$000(this.this$0).containsKey(Long.valueOf(this.contact.phoneId)) == true) goto L5;
            this.mCardListItem.setChecked(true);
            SendGroupAdapter.access$000(this.this$0).put(Long.valueOf(this.contact.phoneId), this.contact.phone);
            this.mCardListItem.setTitleColor(Integer.valueOf(this.mContext.getColor(R.color.oui_text_1)));
            this.mCardListItem.setSubtitleColor(Integer.valueOf(this.mContext.getColor(R.color.oui_blue_6)));
        L6:
            SendGroupAdapter.access$100(this.this$0).setSize(SendGroupAdapter.access$000(this.this$0).size());
            return;
        L5:
            this.mCardListItem.setChecked(false);
            SendGroupAdapter.access$000(this.this$0).remove(Long.valueOf(this.contact.phoneId));
            this.mCardListItem.setTitleColor(Integer.valueOf(this.mContext.getColor(R.color.oui_text_1)));
            this.mCardListItem.setSubtitleColor(Integer.valueOf(this.mContext.getColor(R.color.oui_text_3b)));
            goto L6
        }
    }

    static /* synthetic */ HashMap access$000(SendGroupAdapter r0) {
        return r0.mSelectDateIds;
    }

    static /* synthetic */ GroupDetailFragment access$100(SendGroupAdapter r0) {
        return r0.mGroupDetailFragment;
    }

    public SendGroupAdapter(GroupDetailFragment r2, List<SamContact> r3, boolean r4) {
        this.mSelectDateIds = new HashMap();
        this.mContacts = r3;
        this.mGroupDetailFragment = r2;
        this.mIsSendEmail = r4;
        r2.getActivity();
    }

    public List<SamContact> getContactsList() {
        return this.mContacts;
    }

    public void setContacts(List<SamContact> r6, HashSet<Long> r7) {
        this.mContacts = r6;
        if (this.mSelectDateIds.size() <= 0) goto L14;
        ArrayList r8 = new ArrayList();
        Iterator<Long> r0 = this.mSelectDateIds.keySet().iterator();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= this.mSelectDateIds.size()) goto L12;
        Long r3 = r0.next();
        if (r7.contains(r3) == true) goto L10;
        r8.add(r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (r1 >= r8.size()) goto L19;
        this.mSelectDateIds.remove(r8.get(r1));
        r1 = r1 + 1;
        goto L12
    L19:
        return;
    }

    public void setSecletAll(boolean r4) {
        this.mSelectDateIds.clear();
        if (r4 == false) goto L8;
        int r5 = 0;
    L6:
        if (r5 >= this.mContacts.size()) goto L8;
        this.mSelectDateIds.put(Long.valueOf(this.mContacts.get(r5).phoneId), this.mContacts.get(r5).phone);
        r5 = r5 + 1;
    L8:
        this.mGroupDetailFragment.setSize(this.mSelectDateIds.size());
        notifyDataSetChanged(true);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mContacts.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.mContacts.get(r1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        List<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.get(r1).phoneId;
    }

    public boolean isChecked(int r2) {
        return this.mSelectDateIds.containsKey(Long.valueOf(getItemId(r2)));
    }

    public boolean setChecked(int r7, boolean r8) {
        long r0 = getItemId(r7);
        if (r0 >= 0) goto L6;
        return false;
    L6:
        if (r8 == true) goto L8;
    L11:
        if (r8 == false) goto L13;
    L16:
        return false;
    L13:
        if (this.mSelectDateIds.containsKey(Long.valueOf(r0)) == false) goto L16;
        this.mSelectDateIds.remove(Long.valueOf(r0));
        return true;
    L8:
        if (this.mSelectDateIds.containsKey(Long.valueOf(r0)) == true) goto L11;
        this.mSelectDateIds.put(Long.valueOf(r0), ((SamContact) getItem(r7)).phone);
        return true;
    }

    public HashMap<Long, String> getSecletedContacts() {
        return this.mSelectDateIds;
    }

    @Override // android.widget.Adapter
    public View getView(int r9, View r10, ViewGroup r11) {
        FragmentActivity r12 = this.mGroupDetailFragment.getActivity();
        if (r12 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("SendGroupAdapter", "getView: context is null");
        return null;
    L7:
        if (r10 != null) goto L9;
        r10 = new ContactsCommonListItem(r12, null, 0);
    L9:
        ContactsCommonListItem r0 = (ContactsCommonListItem) r10;
        SamContact r2 = this.mContacts.get(r9);
        long r3 = r2.phoneId;
        r0.setTitleText(r2.name);
        if (this.mIsSendEmail == true) goto L12;
        r0.setSubtitleText(ContactsUtils.getContactPhoneDescribe(this.mGroupDetailFragment.getActivity(), r2.labelType, r2.label, r2.phone));
    L14:
        if (this.mSelectDateIds.containsKey(Long.valueOf(r3)) == true) goto L16;
        r0.setChecked(false);
        r0.setTitleColor(Integer.valueOf(r12.getColor(R.color.oui_text_1)));
        r0.setSubtitleColor(Integer.valueOf(r12.getColor(R.color.oui_text_3b)));
    L17:
        r0.setSelectedMode(true, true);
        r0.showDivider(true);
        r0.setOnClickListener(new OnViewClick(this, r9, r0, r12));
        return r10;
    L16:
        r0.setChecked(true);
        r0.setTitleColor(Integer.valueOf(r12.getColor(R.color.oui_text_1)));
        r0.setSubtitleColor(Integer.valueOf(r12.getColor(R.color.oui_blue_6)));
        goto L17
    L12:
        r0.setSubtitleText(ContactsUtils.getContactEmailDescrib(this.mGroupDetailFragment.getResources(), r2.labelType, r2.label, r2.phone));
        goto L14
    }

    public void notifyDataSetChanged(boolean r1) {
        super.notifyDataSetChanged();
        if (r1 == false) goto L6;
        this.mGroupDetailFragment.setSize(this.mSelectDateIds.size());
        return;
    }
}
