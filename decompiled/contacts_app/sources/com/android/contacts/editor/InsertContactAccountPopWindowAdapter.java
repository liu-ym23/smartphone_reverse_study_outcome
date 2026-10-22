package com.android.contacts.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InsertContactAccountPopWindowAdapter extends BaseAdapter {
    private AccountTypeManager mAccountTypes;
    private Context mContext;
    private AccountWithDataSet mDefalutAccount;
    private List<AccountWithDataSet> mLists;

    /* JADX INFO: renamed from: com.android.contacts.editor.InsertContactAccountPopWindowAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ViewHolder {
        TextView accountImage;
        TextView accountNameLabel;
        TextView accountTypeLabel;
        TextView check;
        RelativeLayout item;
        final /* synthetic */ InsertContactAccountPopWindowAdapter this$0;

        private ViewHolder(InsertContactAccountPopWindowAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ViewHolder(InsertContactAccountPopWindowAdapter r1, AnonymousClass1 r2) {
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

    public InsertContactAccountPopWindowAdapter(Context r1, List<AccountWithDataSet> r2, AccountTypeManager r3) {
        this.mContext = r1;
        this.mLists = r2;
        this.mAccountTypes = r3;
    }

    public void setDefalutAccount(AccountWithDataSet r1) {
        this.mDefalutAccount = r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mLists.size();
    }

    @Override // android.widget.Adapter
    public AccountWithDataSet getItem(int r1) {
        return this.mLists.get(r1);
    }

    public String getItemName(int r3) {
        AccountWithDataSet r4 = getItem(r3);
        String r5 = (String) this.mAccountTypes.getAccountType(r4.type, r4.dataSet).getDisplayLabel(this.mContext);
        if (r5.equals(this.mContext.getResources().getString(R.string.account_phone)) == true) goto L5;
        return r5;
    L5:
        return this.mContext.getResources().getString(R.string.local_bytedance_contact);
    }

    @Override // android.widget.Adapter
    public View getView(int r5, View r6, ViewGroup r7) {
        AnonymousClass1 r8 = null;
        if (r6 != null) goto L5;
        r6 = LayoutInflater.from(this.mContext).inflate(R.layout.account_popupwindow_layout, null);
        ViewHolder r0 = new ViewHolder(this, r8);
        r0.accountTypeLabel = (TextView) r6.findViewById(R.id.account_type);
        r0.accountNameLabel = (TextView) r6.findViewById(R.id.account_name);
        r0.check = (TextView) r6.findViewById(R.id.check);
        r0.accountImage = (TextView) r6.findViewById(R.id.account_icon);
        r6.setTag(r0);
    L6:
        r0.item = (RelativeLayout) r6.findViewById(R.id.item);
        AccountWithDataSet r9 = getItem(r5);
        AccountType r1 = this.mAccountTypes.getAccountType(r9.type, r9.dataSet);
        r0.accountTypeLabel.setText(r1.getDisplayLabel(this.mContext));
        r0.accountNameLabel.setText(ContactsUtils.getAccountName(this.mContext, r9));
        r0.accountImage.setBackground(r1.getDisplayIcon(this.mContext));
        if (r9.equals(this.mDefalutAccount) == false) goto L9;
    L12:
        r0.check.setBackgroundResource(R.drawable.account_selected);
    L13:
        return r6;
    L9:
        if (DSUtils.areSameSimAccount(r9, this.mDefalutAccount) == true) goto L12;
        r0.check.setBackground(null);
        goto L13
    L5:
        r0 = (ViewHolder) r6.getTag();
        goto L6
    }
}
