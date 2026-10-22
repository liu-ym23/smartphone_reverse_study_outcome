package com.android.contacts.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EditContactsAccountPopWindowAdapter extends BaseAdapter {
    private AccountTypeManager mAccountTypes;
    private Context mContext;
    private int mDefaultPosition;
    private List<AccountWithDataSet> mLists;

    /* JADX INFO: renamed from: com.android.contacts.editor.EditContactsAccountPopWindowAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ViewHolder {
        TextView accountImage;
        TextView accountNameLabel;
        TextView accountTypeLabel;
        TextView check;
        RelativeLayout item;
        final /* synthetic */ EditContactsAccountPopWindowAdapter this$0;

        private ViewHolder(EditContactsAccountPopWindowAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ViewHolder(EditContactsAccountPopWindowAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public EditContactsAccountPopWindowAdapter(Context r1, List<AccountWithDataSet> r2, AccountTypeManager r3) {
        this.mContext = r1;
        this.mLists = r2;
        this.mAccountTypes = r3;
    }

    public void setDefaultAccount(int r1) {
        this.mDefaultPosition = r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mLists.size();
    }

    @Override // android.widget.Adapter
    public AccountWithDataSet getItem(int r1) {
        return this.mLists.get(r1);
    }

    public String getItemName(int r4) {
        AccountWithDataSet r5 = getItem(r4);
        String r0 = (String) this.mAccountTypes.getAccountType(r5.type, r5.dataSet).getDisplayLabel(this.mContext);
        if (r0.equals(this.mContext.getResources().getString(R.string.account_phone)) == false) goto L6;
        r0 = this.mContext.getResources().getString(R.string.local_bytedance_contact);
    L6:
        if (Constants.LOCAL_MIXED_ACCOUNT_NAME.equals(r5.name) == true) goto L8;
        return r0;
    L8:
        if (Constants.LOCAL_MIXED_ACCOUNT_TYPE.equals(r5.type) == false) goto L12;
        return "";
    L12:
        return r0;
    }

    @Override // android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        AnonymousClass1 r9 = null;
        if (r7 != null) goto L5;
        r7 = LayoutInflater.from(this.mContext).inflate(R.layout.account_popupwindow_layout, null);
        ViewHolder r0 = new ViewHolder(this, r9);
        r0.accountTypeLabel = (TextView) r7.findViewById(R.id.account_type);
        r0.accountNameLabel = (TextView) r7.findViewById(R.id.account_name);
        r0.check = (TextView) r7.findViewById(R.id.check);
        r0.accountImage = (TextView) r7.findViewById(R.id.account_icon);
        r7.setTag(r0);
    L6:
        r0.item = (RelativeLayout) r7.findViewById(R.id.item);
        AccountWithDataSet r1 = getItem(r6);
        AccountType r2 = this.mAccountTypes.getAccountType(r1.type, r1.dataSet);
        if (Constants.LOCAL_MIXED_ACCOUNT_TYPE.equals(r1.type) == false) goto L9;
        r0.accountTypeLabel.setText(R.string.mixed_contact_account_type);
        r0.accountNameLabel.setText(R.string.mixed_contact_account_name);
        r0.accountImage.setBackground(this.mContext.getResources().getDrawable(R.drawable.ic_account_mixed_contact));
    L11:
        if (r6 != this.mDefaultPosition) goto L13;
        r0.check.setBackgroundResource(R.drawable.account_selected);
    L14:
        return r7;
    L13:
        r0.check.setBackground(null);
        goto L14
    L9:
        r0.accountTypeLabel.setText(r2.getDisplayLabel(this.mContext));
        r0.accountNameLabel.setText(ContactsUtils.getAccountName(this.mContext, r1));
        r0.accountImage.setBackground(r2.getDisplayIcon(this.mContext));
        goto L11
    L5:
        r0 = (ViewHolder) r7.getTag();
        goto L6
    }
}
