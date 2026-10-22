package com.android.contacts.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.common.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.account.AccountWithDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AccountsListAdapter extends BaseAdapter {
    private final AccountTypeManager mAccountTypes;
    private final List<AccountWithDataSet> mAccounts;
    private final Context mContext;
    private int mCustomLayout;
    private final LayoutInflater mInflater;

    public static final enum AccountListFilter extends Enum<AccountListFilter> {
        private static final /* synthetic */ AccountListFilter[] $VALUES = null;
        public static final AccountListFilter ACCOUNTS_CONTACT_WRITABLE = null;
        public static final AccountListFilter ACCOUNTS_CONTACT_WRITABLE_WITHOUT_SIM = null;
        public static final AccountListFilter ACCOUNTS_GROUP_WRITABLE = null;
        public static final AccountListFilter ALL_ACCOUNTS = null;

        private static /* synthetic */ AccountListFilter[] $values() {
            return new AccountListFilter[]{ALL_ACCOUNTS, ACCOUNTS_CONTACT_WRITABLE, ACCOUNTS_GROUP_WRITABLE, ACCOUNTS_CONTACT_WRITABLE_WITHOUT_SIM};
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
            ACCOUNTS_CONTACT_WRITABLE_WITHOUT_SIM = new AccountListFilter("ACCOUNTS_CONTACT_WRITABLE_WITHOUT_SIM", 3);
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

    public AccountsListAdapter(Context r3, AccountListFilter r4, AccountWithDataSet r5) {
        this.mCustomLayout = -1;
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

    private List<AccountWithDataSet> getAccounts(AccountListFilter r5) {
        boolean r1 = true;
        if (r5 == AccountListFilter.ACCOUNTS_GROUP_WRITABLE) goto L5;
        AccountTypeManager r4 = this.mAccountTypes;
        if (r5 != AccountListFilter.ACCOUNTS_CONTACT_WRITABLE) goto L9;
    L12:
        List<AccountWithDataSet> r6 = r4.getAccounts(r1);
        ArrayList r0 = new ArrayList();
        if (r5 != AccountListFilter.ACCOUNTS_CONTACT_WRITABLE_WITHOUT_SIM) goto L21;
        Iterator<AccountWithDataSet> r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        AccountWithDataSet r2 = r7.next();
        if ("com.android.sim".equals(r2.type) == false) goto L16;
        r0.add(r2);
        goto L16
    L20:
        r6.removeAll(r0);
    L21:
        return r6;
    L9:
        if (r5 == AccountListFilter.ACCOUNTS_CONTACT_WRITABLE_WITHOUT_SIM) goto L12;
        r1 = false;
        goto L12
    L5:
        return new ArrayList(this.mAccountTypes.getAccounts(true, 2));
    }

    public void setCustomLayout(int r1) {
        this.mCustomLayout = r1;
    }

    @Override // android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        if (r7 != null) goto L9;
        LayoutInflater r9 = this.mInflater;
        int r0 = this.mCustomLayout;
        if (r0 > 0) goto L8;
        r0 = R.layout.account_selector_list_item;
    L8:
        r7 = r9.inflate(r0, r8, false);
    L9:
        TextView r10 = (TextView) r7.findViewById(android.R.id.text1);
        TextView r1 = (TextView) r7.findViewById(android.R.id.text2);
        ImageView r2 = (ImageView) r7.findViewById(android.R.id.icon);
        AccountWithDataSet r11 = this.mAccounts.get(r6);
        AccountType r3 = this.mAccountTypes.getAccountType(r11.type, r11.dataSet);
        r10.setText(r3.getDisplayLabel(this.mContext));
        r1.setText(r11.name);
        r1.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r2.setImageDrawable(r3.getDisplayIcon(this.mContext));
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
