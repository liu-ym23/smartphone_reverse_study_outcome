package com.android.contacts.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountsListAdapter extends BaseAdapter {
    private final AccountTypeManager mAccountTypes;
    private final List<AccountWithDataSet> mAccounts;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public static final enum AccountListFilter extends Enum<AccountListFilter> {
        private static final /* synthetic */ AccountListFilter[] $VALUES = null;
        public static final AccountListFilter ACCOUNTS_CONTACT_WRITABLE = null;
        public static final AccountListFilter ACCOUNTS_GROUP_WRITABLE = null;
        public static final AccountListFilter ALL_ACCOUNTS = null;

        private static /* synthetic */ AccountListFilter[] $values() {
            return new AccountListFilter[]{ALL_ACCOUNTS, ACCOUNTS_CONTACT_WRITABLE, ACCOUNTS_GROUP_WRITABLE};
        }

        private AccountListFilter(String r1, int r2) {
            super(r1, r2);
        }

        public static AccountListFilter valueOf(String r1) {
            return (AccountListFilter) Enum.valueOf(AccountListFilter.class, r1);
        }

        public static AccountListFilter[] values() {
            return (AccountListFilter[]) $VALUES.clone();
        }

        static {
            ALL_ACCOUNTS = new AccountListFilter("ALL_ACCOUNTS", 0);
            ACCOUNTS_CONTACT_WRITABLE = new AccountListFilter("ACCOUNTS_CONTACT_WRITABLE", 1);
            ACCOUNTS_GROUP_WRITABLE = new AccountListFilter("ACCOUNTS_GROUP_WRITABLE", 2);
            $VALUES = $values();
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public AccountsListAdapter(Context r2, AccountListFilter r3) {
        this(r2, r3, null);
    }

    public AccountsListAdapter(Context r2, List<AccountWithDataSet> r3) {
        this.mContext = r2;
        this.mAccountTypes = AccountTypeManager.getInstance(r2);
        this.mAccounts = r3;
        this.mInflater = LayoutInflater.from(r2);
    }

    public AccountsListAdapter(Context r3, AccountListFilter r4, AccountWithDataSet r5) {
        this.mContext = r3;
        this.mAccountTypes = AccountTypeManager.getInstance(r3);
        List<AccountWithDataSet> r6 = getAccounts(r4);
        this.mAccounts = r6;
        if (r5 != null) goto L5;
    L11:
        this.mInflater = LayoutInflater.from(r3);
        return;
    L5:
        if (r6.isEmpty() == true) goto L11;
        if (r6.get(0).equals(r5) == true) goto L11;
        if (r6.remove(r5) == false) goto L11;
        r6.add(0, r5);
        goto L11
    }

    private List<AccountWithDataSet> getAccounts(AccountListFilter r3) {
        if (r3 == AccountListFilter.ACCOUNTS_GROUP_WRITABLE) goto L5;
        AccountTypeManager r2 = this.mAccountTypes;
        if (r3 != AccountListFilter.ACCOUNTS_CONTACT_WRITABLE) goto L9;
        boolean r4 = true;
    L11:
        return new ArrayList(r2.getAccounts(r4));
    L9:
        r4 = false;
        goto L11
    L5:
        return new ArrayList(this.mAccountTypes.getGroupWritableAccounts());
    }

    @Override // android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        if (r7 != null) goto L5;
        r7 = this.mInflater.inflate(R.layout.account_selector_list_item, r8, false);
    L5:
        TextView r9 = (TextView) r7.findViewById(R.id.text1);
        TextView r0 = (TextView) r7.findViewById(R.id.text2);
        ImageView r1 = (ImageView) r7.findViewById(R.id.icon);
        AccountWithDataSet r10 = this.mAccounts.get(r6);
        AccountType r2 = this.mAccountTypes.getAccountType(r10.type, r10.dataSet);
        r9.setText(r2.getDisplayLabel(this.mContext));
        r0.setText(ContactsUtils.getAccountName(this.mContext, r10));
        r1.setImageDrawable(r2.getDisplayIcon(this.mContext));
        return r7;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mAccounts.size();
    }

    @Override // android.widget.Adapter
    public AccountWithDataSet getItem(int r1) {
        return this.mAccounts.get(r1);
    }
}
