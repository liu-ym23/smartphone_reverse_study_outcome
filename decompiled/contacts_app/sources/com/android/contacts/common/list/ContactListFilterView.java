package com.android.contacts.common.list;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.android.contacts.common.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes.dex */
public class ContactListFilterView extends LinearLayout {
    private static final String TAG = "ContactListFilterView";
    private TextView mAccountType;
    private TextView mAccountUserName;
    private ContactListFilter mFilter;
    private ImageView mIcon;
    private RadioButton mRadioButton;
    private boolean mSingleAccount;

    static {
    }

    public ContactListFilterView(Context r1) {
        super(r1);
    }

    public ContactListFilterView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setContactListFilter(ContactListFilter r1) {
        this.mFilter = r1;
    }

    public ContactListFilter getContactListFilter() {
        return this.mFilter;
    }

    public void setSingleAccount(boolean r1) {
        this.mSingleAccount = r1;
    }

    @Override // android.view.View
    public void setActivated(boolean r2) {
        super.setActivated(r2);
        RadioButton r0 = this.mRadioButton;
        if (r0 == null) goto L5;
        r0.setChecked(r2);
    L6:
        setContentDescription(generateContentDescription());
        return;
    L5:
        Log.wtf(TAG, "radio-button cannot be activated because it is null");
        goto L6
    }

    public boolean isChecked() {
        return this.mRadioButton.isChecked();
    }

    public void bindView(AccountTypeManager r4) {
        if (this.mAccountType != null) goto L6;
        this.mIcon = (ImageView) findViewById(R.id.icon);
        this.mAccountType = (TextView) findViewById(R.id.accountType);
        this.mAccountUserName = (TextView) findViewById(R.id.accountUserName);
        RadioButton r0 = (RadioButton) findViewById(R.id.radioButton);
        this.mRadioButton = r0;
        r0.setChecked(isActivated());
    L6:
        if (this.mFilter != null) goto L9;
        this.mAccountType.setText(R.string.common_contacts);
        return;
    L9:
        this.mAccountUserName.setVisibility(8);
        int r1 = this.mFilter.filterType;
        if (r1 != (-6)) goto L12;
        bindView(0, R.string.common_contacts);
    L31:
        setContentDescription(generateContentDescription());
        return;
    L12:
        if (r1 != (-5)) goto L14;
        bindView(0, R.string.list_filter_phones);
        goto L31
    L14:
        if (r1 != (-4)) goto L16;
        bindView(R.drawable.ic_menu_star_holo_light, R.string.list_filter_all_starred);
        goto L31
    L16:
        if (r1 != (-3)) goto L18;
        bindView(R.drawable.ic_menu_settings_holo_light, R.string.common_custom);
        goto L31
    L18:
        if (r1 == (-2)) goto L26;
        if (r1 != 0) goto L31;
        this.mAccountUserName.setVisibility(0);
        this.mIcon.setVisibility(0);
        if (this.mFilter.icon == null) goto L24;
        this.mIcon.setImageDrawable(this.mFilter.icon);
    L25:
        AccountType r5 = r4.getAccountType(this.mFilter.accountType, this.mFilter.dataSet);
        this.mAccountUserName.setText(this.mFilter.accountName);
        this.mAccountType.setText(r5.getDisplayLabel(getContext()));
        goto L31
    L24:
        this.mIcon.setImageResource(R.drawable.unknown_source);
        goto L25
    L26:
        bindView(0, R.string.common_all_contacts);
        goto L31
    }

    private void bindView(int r3, int r4) {
        if (r3 == 0) goto L4;
        this.mIcon.setVisibility(0);
        this.mIcon.setImageResource(r3);
    L5:
        this.mAccountType.setText(r4);
        return;
    L4:
        this.mIcon.setVisibility(8);
        goto L5
    }

    String generateContentDescription() {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(this.mAccountType.getText()) == true) goto L6;
        r0.append(this.mAccountType.getText());
    L6:
        if (TextUtils.isEmpty(this.mAccountUserName.getText()) == false) goto L8;
    L11:
        Context r1 = getContext();
        if (isActivated() == false) goto L14;
        int r4 = R.string.account_filter_view_checked;
    L16:
        return r1.getString(r4, new Object[]{r0.toString()});
    L14:
        r4 = R.string.account_filter_view_not_checked;
        goto L16
    L8:
        if (r0.length() <= 0) goto L10;
        r0.append(HanziToPinyin.Token.SEPARATOR);
    L10:
        r0.append(this.mAccountUserName.getText());
        goto L11
    }
}
