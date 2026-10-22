package com.android.contacts.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.vcard.ImportVCardActivity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSelectionUtil {
    private static final String LOG_TAG = "AccountSelectionUtil";
    public static Uri mPath = null;
    public static boolean mVCardShare = false;

    public static class AccountSelectedListener implements DialogInterface.OnClickListener {
        protected final List<AccountWithDataSet> mAccountList;
        private final Context mContext;
        private final int mResId;

        public AccountSelectedListener(Context r3, List<AccountWithDataSet> r4, int r5) {
            if (r4 != null) goto L5;
        L6:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(AccountSelectionUtil.LOG_TAG, "The size of Account list is 0.");
        L7:
            this.mContext = r3;
            this.mAccountList = r4;
            this.mResId = r5;
            return;
        L5:
            if (r4.size() != 0) goto L7;
            goto L6
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            r2.dismiss();
            AccountSelectionUtil.doImport(this.mContext, this.mResId, this.mAccountList.get(r3));
        }
    }

    static {
    }

    public AccountSelectionUtil() {
    }

    public static Dialog getSelectAccountDialog(Context r1, int r2) {
        return getSelectAccountDialog(r1, r2, null, null);
    }

    public static Dialog getSelectAccountDialog(Context r1, int r2, DialogInterface.OnClickListener r3) {
        return getSelectAccountDialog(r1, r2, r3, null);
    }

    public static Dialog getSelectAccountDialogInFragment(Context r2, DialogInterface.OnClickListener r3, DialogInterface.OnClickListener r4) {
        AccountsListAdapter r5 = new AccountsListAdapter(r2, AccountsListAdapter.AccountListFilter.ACCOUNTS_GROUP_WRITABLE);
        AccountSelectionMenuDialog r0 = new AccountSelectionMenuDialog(r2);
        r0.setTitle(r2.getString(R.string.choose_an_account));
        r0.setAdapter(r5, r3);
        r0.setCanceledOnTouchOutside(true);
        return r0;
    }

    public static Dialog getSelectAccountDialog(Context r1, int r2, DialogInterface.OnClickListener r3, DialogInterface.OnCancelListener r4) {
        return getSelectAccountDialog(r1, r2, r3, r4, null);
    }

    public static Dialog getSelectAccountDialog(Context r4, int r5, DialogInterface.OnClickListener r6, DialogInterface.OnCancelListener r7, List<AccountWithDataSet> r8) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "The number of available accounts: " + AccountTypeManager.getInstance(r4).getAccounts(true).size());
        if (r6 != null) goto L5;
        r6 = new AnonymousClass1();
    L5:
        if (r7 != null) goto L7;
        r7 = new AnonymousClass2();
    L7:
        new AnonymousClass3();
        if (r8 != null) goto L10;
        AccountsListAdapter r9 = new AccountsListAdapter(r4, AccountsListAdapter.AccountListFilter.ACCOUNTS_GROUP_WRITABLE);
    L11:
        AccountSelectionMenuDialog r0 = new AccountSelectionMenuDialog(r4);
        r0.setTitle(r4.getString(r5));
        r0.setAdapter(r9, r6);
        r0.setOnCancelListener(r7);
        r0.setCanceledOnTouchOutside(true);
        return r0;
    L10:
        r9 = new AccountsListAdapter(r4, r8);
        goto L11
    }

    public static void doImport(Context r1, int r2, AccountWithDataSet r3) {
        if (r2 != R.id.btn_import_from_external_sdcard) goto L5;
        doImportFromSdCard(r1, r3, true);
        return;
    L5:
        if (r2 != R.id.btn_import_from_sdcard) goto L11;
        doImportFromSdCard(r1, r3, false);
        return;
    }

    public static void doImportFromSdCard(Context r3, AccountWithDataSet r4, boolean r5) {
        Intent r0 = new Intent(r3, ImportVCardActivity.class);
        if (r4 == null) goto L6;
        r0.putExtra("account_name", r4.name);
        r0.putExtra("account_type", r4.type);
        r0.putExtra("data_set", r4.dataSet);
    L6:
        if (mVCardShare == false) goto L8;
        r0.setAction("android.intent.action.VIEW");
        r0.setData(mPath);
    L8:
        mVCardShare = false;
        mPath = null;
        r0.putExtra("isImportFromExternalSdcard", r5);
        r3.startActivity(r0);
    }
}
