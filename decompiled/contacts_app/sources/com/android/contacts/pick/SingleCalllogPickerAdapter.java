package com.android.contacts.pick;

import android.app.Activity;
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
import com.android.contacts.numberassistant.NumberInfosQueryManager;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes2.dex */
public class SingleCalllogPickerAdapter extends PickerAdapter implements NumberInfosQueryManager.NumberInfosQueryListener {
    private final PhoneNumberHelper mPhoneNumberHelper;

    public SingleCalllogPickerAdapter(Activity r1, PhoneNumberHelper r2) {
        super(r1);
        this.mPhoneNumberHelper = r2;
    }

    @Override // com.android.contacts.pick.PickerAdapter, android.widget.Adapter
    public View getView(int r5, View r6, ViewGroup r7) {
        PickerAdapter.ViewHolder r8 = new PickerAdapter.ViewHolder();
        if (r6 != null) goto L5;
        r6 = LayoutInflater.from(this.mContext).inflate(R.layout.single_calllog_picker_list_item, null);
        r8.name = (TextView) r6.findViewById(R.id.name);
        r8.label = (TextView) r6.findViewById(R.id.label);
        r8.date = (TextView) r6.findViewById(R.id.date);
        r6.setTag(r8);
    L6:
        r8.label.setTag(null);
        SamContact r9 = getItem(r5);
        if (r9.presentation == 1) goto L10;
        r8.name.setText(this.mPhoneNumberHelper.getDisplayNumber(r9.number, null, r9.presentation));
        r8.label.setTag(null);
        r8.label.setText("");
    L25:
        r8.date.setText(DateFormat.getDateFormat(this.mContext).format(Long.valueOf(r9.date)) + HanziToPinyin.Token.SEPARATOR + DateFormat.getTimeFormat(this.mContext).format(Long.valueOf(r9.date)));
        return r6;
    L10:
        if (r9.lookupUri != null) goto L12;
    L20:
        r8.name.setText(r9.number);
        r8.label.setTag(r9.number);
        if (r9.labelType == 0) goto L24;
        r8.label.setText(ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), r9.labelType, r9.label));
    L24:
        NumberInfosQueryManager.getInstance().startQuery(r9.number, r8, this);
        goto L25
    L12:
        if (TextUtils.isEmpty(r9.lookupUri.toString()) == true) goto L20;
        if (TextUtils.isEmpty(r9.name) == false) goto L19;
        r8.name.setText(r9.number);
        if (r9.labelType == 0) goto L25;
        r8.label.setText(ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), r9.labelType, r9.label));
        goto L25
    L19:
        r8.name.setText(r9.name);
        r8.label.setText(ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), r9.labelType, r9.label));
        goto L25
    L5:
        r8 = (PickerAdapter.ViewHolder) r6.getTag();
        goto L6
    }

    @Override // com.android.contacts.numberassistant.NumberInfosQueryManager.NumberInfosQueryListener
    public void onQueryComplete(String r1, Object r2, String r3) {
        if ((r2 instanceof PickerAdapter.ViewHolder) == false) goto L15;
        PickerAdapter.ViewHolder r4 = (PickerAdapter.ViewHolder) r2;
        if (r4.label != null) goto L7;
        return;
    L7:
        if (r4.label.getTag() == null) goto L17;
        if (r3 != null) goto L10;
        return;
    L10:
        if (TextUtils.equals((String) r4.label.getTag(), r1) == true) goto L12;
        return;
    L12:
        if (TextUtils.equals(r4.label.getText(), r3) == true) goto L20;
        r4.label.setText(r3);
        return;
    L20:
        return;
    L17:
        return;
    }
}
