package com.android.contacts.pick;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PinnedHeaderList.HeadersAdapter;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.list.SamContact;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.SortComparatorForMultiPicker;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PickerAdapter extends BaseAdapter implements QuickContactListAdapterListener, HeadersAdapter {
    private static final String TAG = "PickerAdapter";
    private boolean displaySelectedItems;
    private ForegroundColorSpan foregroundColorSpan;
    public Activity mActivity;
    protected ArrayList<SamContact> mContacts;
    private int mContactsSize;
    public Context mContext;
    public HashMap<Long, SamContact> mCopiedSelectedContacts;
    public LayoutInflater mInflater;
    public ContactPhotoManager mPhotoManager;
    public PickerFragment mPickerFragment;
    private QuickContactListener mQuickContactListener;
    protected String searchKey;

    public static class ViewHolder {
        OCheckBox checkBox;
        TextView date;
        TextView label;
        TextView name;
        AvatarImageView photo;
        TextView photoBg;
        RelativeLayout root;

        public ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    public long getKey(SamContact r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r1, View r2, ViewGroup r3) {
        return null;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public PickerAdapter(Activity r3) {
        this.mCopiedSelectedContacts = new HashMap();
        this.displaySelectedItems = true;
        this.mContext = r3;
        this.mActivity = r3;
        this.foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oui_blue_6));
    }

    public void setDisplaySelectedItems(boolean r1) {
        this.displaySelectedItems = r1;
    }

    public boolean isDisplaySelectedItems() {
        return this.displaySelectedItems;
    }

    public void setPhotoManger(ContactPhotoManager r1) {
        this.mPhotoManager = r1;
    }

    public void setContacts(ArrayList<SamContact> r3) {
        this.searchKey = null;
        if (r3 != null) goto L5;
        ArrayList<SamContact> r0 = new ArrayList();
    L7:
        if (this.mPickerFragment.mSearchResultListView.getVisibility() != 0) goto L9;
    L15:
        this.mContacts = r0;
    L16:
        updateContactsSize();
        return;
    L9:
        if (this.displaySelectedItems == false) goto L15;
        if (r3 != null) goto L12;
    L14:
        this.mContacts = r0;
        refreshCopiedContacts(false);
        goto L16
    L12:
        if (this.mCopiedSelectedContacts.size() == 0) goto L14;
        copiedContacts(r3);
        goto L14
    L5:
        r0 = new ArrayList(r3);
        goto L7
    }

    private void copiedContacts(ArrayList<SamContact> r7) {
        ArrayList r0 = new ArrayList(this.mCopiedSelectedContacts.values());
        HashSet r1 = new HashSet();
        Iterator<SamContact> r2 = r7.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Long.valueOf(getKey(r2.next())));
        goto L4
    L6:
        Iterator r3 = r0.iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        SamContact r4 = (SamContact) r3.next();
        long r5 = getKey(r4);
        if (SortComparatorForMultiPicker.SPECIAL_LABLE_FOR_SELECTED.equals(r4.section) == false) goto L14;
        if (r1.contains(Long.valueOf(r5)) == false) goto L14;
    L15:
        this.mCopiedSelectedContacts.remove(Long.valueOf(r5));
    L14:
        if (r1.contains(Long.valueOf(r5)) == true) goto L8;
    L16:
        r7.addAll(this.mCopiedSelectedContacts.values());
    }

    public void setContacts(ArrayList<SamContact> r2, String r3) {
        if (r2 != null) goto L4;
        ArrayList<SamContact> r4 = new ArrayList();
    L5:
        this.mContacts = r4;
        this.searchKey = r3;
        updateContactsSize();
        return;
    L4:
        r4 = new ArrayList(r2);
        goto L5
    }

    public void refreshCopiedContacts(boolean r11) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "refreshCopiedContacts");
        if (this.mContacts != null) goto L6;
        return;
    L6:
        if (this.displaySelectedItems == true) goto L9;
        notifyDataSetChanged();
        return;
    L9:
        int r0 = this.mPickerFragment.mListView.getFirstVisiblePosition();
        int r2 = this.mCopiedSelectedContacts.size();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator<SamContact> r5 = this.mContacts.iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        SamContact r6 = r5.next();
        if (this.mPickerFragment.getSelectedIds().contains(Long.valueOf(getKey(r6))) == true) goto L14;
        r4.add(r6);
        goto L11
    L14:
        r3.add(r6);
        goto L11
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "refreshCopiedContacts after filter");
        Iterator r7 = r3.iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        addContactForCheckedItem((SamContact) r7.next());
        goto L18
    L20:
        Iterator r8 = r4.iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        removeContactAfterUncheck((SamContact) r8.next());
        goto L22
    L24:
        int r9 = this.mCopiedSelectedContacts.size();
        Collections.sort(this.mContacts, new SortComparatorForMultiPicker(this.mContext));
        notifyDataSetChanged();
        if (ActivityManager.isUserAMonkey() == true) goto L32;
        if (r11 == false) goto L32;
        if ((r9 - r2) == 0) goto L32;
        if (r2 != 0) goto L31;
        this.mPickerFragment.mListView.setPosition((r0 + r9) - r2, false);
        goto L32
    L31:
        this.mPickerFragment.mListView.setPosition((r0 + r9) - r2, true);
    L32:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "refreshCopiedContacts return");
    }

    private boolean addContactForCheckedItem(SamContact r5) {
        if (this.mCopiedSelectedContacts.containsKey(Long.valueOf(getKey(r5))) == false) goto L6;
        return false;
    L6:
        SamContact r0 = r5.getCopy();
        r0.section = SortComparatorForMultiPicker.SPECIAL_LABLE_FOR_SELECTED;
        this.mCopiedSelectedContacts.put(Long.valueOf(getKey(r5)), r0);
        this.mContacts.add(this.mCopiedSelectedContacts.get(Long.valueOf(getKey(r5))));
        return true;
    }

    private void removeContactAfterUncheck(SamContact r5) {
        if (this.mCopiedSelectedContacts.containsKey(Long.valueOf(getKey(r5))) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.searchKey) == false) goto L7;
        this.mContacts.remove(this.mCopiedSelectedContacts.get(Long.valueOf(getKey(r5))));
    L7:
        this.mCopiedSelectedContacts.remove(Long.valueOf(getKey(r5)));
    }

    protected CharSequence getNumberHighlightDescription(int r6, CharSequence r7, String r8) {
        String r9 = ContactsUtils.getContactPhoneDescribe(this.mContext, r6, r7, r8);
        if (TextUtils.isEmpty(this.searchKey) == true) goto L29;
        String r10 = this.searchKey.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "");
        int r11 = r8.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "").indexOf(r10);
        if (r11 < 0) goto L29;
        int r0 = r9.length();
        int r1 = 0;
    L8:
        if (r1 >= r11) goto L16;
        if (r1 >= r0) goto L15;
        if (r9.charAt(r1) != ' ') goto L13;
    L14:
        r11 = r11 + 1;
        goto L15
    L13:
        if (r9.charAt(r1) == '-') goto L14;
    L15:
        r1 = r1 + 1;
        goto L8
    L16:
        int r12 = r10.length() + r11;
        int r2 = r11;
    L17:
        if (r2 >= r12) goto L25;
        if (r2 >= r0) goto L24;
        if (r9.charAt(r2) != ' ') goto L22;
    L23:
        r12 = r12 + 1;
        goto L24
    L22:
        if (r9.charAt(r2) == '-') goto L23;
    L24:
        r2 = r2 + 1;
        goto L17
    L25:
        SpannableString r3 = new SpannableString(r9);
        if (r12 >= r0) goto L28;
        r3.setSpan(this.foregroundColorSpan, r11, r12, 18);
    L28:
        return r3;
    L29:
        return r9;
    }

    public void setPickerFragment(PickerFragment r1) {
        this.mPickerFragment = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public void setQuickContactListener(QuickContactListener r1) {
        this.mQuickContactListener = r1;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public QuickContactListener getQuickContactListener() {
        return this.mQuickContactListener;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetChanged();
        this.mPickerFragment.mListView.refreshHintViewSize();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        QuickContactListener r0 = this.mQuickContactListener;
        if (r0 == null) goto L5;
        r0.hideQuickContactWithoutAnimation(false);
    L5:
        super.notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public View getHeaderView(int r4, View r5, ViewGroup r6) {
        if (r5 != null) goto L4;
        r5 = LayoutInflater.from(this.mContext).inflate(R.layout.header, null);
    L4:
        ArrayList<SamContact> r7 = this.mContacts;
        if (r7 == null) goto L14;
        if (r4 < 0) goto L14;
        if (r4 >= r7.size()) goto L14;
        SamContact r8 = this.mContacts.get(r4);
        TextView r9 = (TextView) r5.findViewById(R.id.text);
        if (SortComparatorForMultiPicker.SPECIAL_LABLE_FOR_SELECTED.equals(r8.section) == false) goto L13;
        r9.setText(this.mContext.getResources().getQuantityString(R.plurals.selected_contact, this.mCopiedSelectedContacts.size(), new Object[]{Integer.valueOf(this.mCopiedSelectedContacts.size())}));
        goto L14
    L13:
        r9.setText(r8.section);
    L14:
        return r5;
    }

    @Override // com.android.contacts.PinnedHeaderList.HeadersAdapter
    public long getHeaderId(int r2) {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 == null) goto L10;
        if (r2 >= 0) goto L6;
        return -1;
    L6:
        if (r2 < r0.size()) goto L9;
        return -1;
    L9:
        return this.mContacts.get(r2).section.hashCode();
    L10:
        return -1;
    }

    @Override // android.widget.Adapter
    public SamContact getItem(int r2) {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 == null) goto L10;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        if (r2 < r0.size()) goto L9;
        return null;
    L9:
        return this.mContacts.get(r2);
    L10:
        return null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListAdapterListener
    public Activity getActivity() {
        return this.mActivity;
    }

    public int getContactsSize() {
        return this.mContactsSize;
    }

    private void updateContactsSize() {
        HashSet<Long> r0 = getAllContactsIds();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        this.mContactsSize = r1;
        return;
    L5:
        r1 = r0.size();
        goto L6
    }

    public List<SamContact> getAllContacts() {
        ArrayList<SamContact> r0 = this.mContacts;
        if (r0 != null) goto L6;
        return Collections.emptyList();
    L6:
        return Collections.unmodifiableList(r0);
    }

    public HashSet<Long> getAllContactsIds() {
        if (this.mContacts != null) goto L6;
        return null;
    L6:
        HashSet<Long> r0 = new HashSet();
        Iterator<SamContact> r1 = this.mContacts.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r0.add(Long.valueOf(getKey(r1.next())));
        goto L8
    L10:
        return r0;
    }

    protected void setHighlightedName(TextView r5, String r6) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.searchKey) == false) goto L7;
    L14:
        r5.setText(r6);
        return;
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        SpannableStringBuilder r0 = new SpannableStringBuilder(r6);
        if (TextUtils.isEmpty(this.searchKey) == false) goto L11;
    L13:
        r5.setText(r0);
        return;
    L11:
        if (r6.contains(this.searchKey) == false) goto L13;
        r0.setSpan(this.foregroundColorSpan, r6.indexOf(this.searchKey), r6.indexOf(this.searchKey) + this.searchKey.length(), 18);
        goto L13
    }
}
