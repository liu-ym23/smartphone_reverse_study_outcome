package com.android.contacts.pick;

import android.app.Activity;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.list.SamContact;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.HanziToPinyin;
import com.obric.oui.checkbox.OCheckBox;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MultiCalllogsPickerAdapter extends PickerAdapter {
    private final PhoneNumberHelper mPhoneNumberHelper;
    private HashSet<String> mSelectedChecked;

    private class NumberInfoCallback extends NumberInfosManager.NumberInfosListenerAdatper {
        String mNumber;
        TextView mTextView;
        final /* synthetic */ MultiCalllogsPickerAdapter this$0;

        public NumberInfoCallback(MultiCalllogsPickerAdapter r1, TextView r2, String r3) {
            this.this$0 = r1;
            this.mNumber = r3;
            this.mTextView = r2;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListenerAdatper, com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryNumberInfosDone(final NumberInfosManager.NumberInfos r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            TextView r0 = this.mTextView;
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.getVisibility() != 0) goto L17;
            Object r1 = this.mTextView.getTag();
            if (r1 != null) goto L11;
            return;
        L11:
            if ((r1 instanceof String) == true) goto L13;
            return;
        L13:
            if (((String) r1).equals(this.mNumber) == false) goto L20;
            new Handler(this.this$0.mContext.getMainLooper()).post(new AnonymousClass1(this, r3));
            return;
        L20:
            return;
        }
    }

    public MultiCalllogsPickerAdapter(Activity r1, PhoneNumberHelper r2) {
        super(r1);
        this.mSelectedChecked = new HashSet();
        this.mPhoneNumberHelper = r2;
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        PickerAdapter.ViewHolder r9 = new PickerAdapter.ViewHolder();
        if (r7 != null) goto L5;
        r7 = LayoutInflater.from(this.mContext).inflate(R.layout.multi_calllog_picker_list_item, null);
        r9.name = (TextView) r7.findViewById(R.id.name);
        r9.label = (TextView) r7.findViewById(R.id.label);
        r9.date = (TextView) r7.findViewById(R.id.date);
        r9.checkBox = (OCheckBox) r7.findViewById(R.id.checkBox);
        r7.setTag(r9);
    L6:
        SamContact r10 = getItem(r6);
        if (r10.lookupUri != null) goto L9;
    L12:
        r9.name.setText(r10.number);
        TextView r0 = r9.label;
        r0.setTag(r10.number);
        NumberInfosManager.getInstance().getBaseAndMarkInfosAsync(r10.number, new NumberInfoCallback(this, r0, r10.number));
    L13:
        r9.date.setText(DateFormat.getDateFormat(this.mContext).format(Long.valueOf(r10.date)) + HanziToPinyin.Token.SEPARATOR + DateFormat.getTimeFormat(this.mContext).format(Long.valueOf(r10.date)));
        if (this.mSelectedChecked.contains(r10.number) == true) goto L16;
        r9.checkBox.setChecked(false);
    L17:
        return r7;
    L16:
        r9.checkBox.setChecked(true);
        goto L17
    L9:
        if (TextUtils.isEmpty(r10.lookupUri.toString()) == true) goto L12;
        r9.name.setText(r10.name);
        r9.label.setText(ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), r10.labelType, r10.label));
        goto L13
    L5:
        r9 = (PickerAdapter.ViewHolder) r7.getTag();
        goto L6
    }

    public void setChecked(String r2) {
        if (this.mSelectedChecked.contains(r2) == false) goto L5;
        this.mSelectedChecked.remove(r2);
    L6:
        notifyDataSetChanged();
        return;
    L5:
        this.mSelectedChecked.add(r2);
        goto L6
    }

    public boolean isChecked(int r1) {
        String r2 = getNumber(r1);
        return this.mSelectedChecked.contains(r2);
    }

    public String getNumber(int r2) {
        if (this.mContacts != null) goto L7;
        return null;
    L7:
        return getItem(r2).number;
    }

    public HashSet<String> getSelectedChecked() {
        return this.mSelectedChecked;
    }

    public String[] getChecked() {
        HashSet<String> r1 = this.mSelectedChecked;
        return (String[]) r1.toArray(new String[r1.size()]);
    }

    @Override // com.android.contacts.pick.PickerAdapter
    public long getKey(SamContact r1) {
        return r1.number.hashCode();
    }
}
