package com.android.contacts.common.util;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.vcard.ImportVCardActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccountSelectionUtil {
    private static final String LOG_TAG = "AccountSelectionUtil";
    private static int mImportSub = -1;
    public static Uri mPath = null;
    public static boolean mVCardShare = false;

    public static class AccountSelectedListener implements DialogInterface.OnClickListener {
        protected List<AccountWithDataSet> mAccountList;
        private final Activity mActivity;
        private final int mResId;
        private final int mSubscriptionId;

        public AccountSelectedListener(Activity r3, List<AccountWithDataSet> r4, int r5, int r6) {
            if (r4 != null) goto L5;
        L6:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(AccountSelectionUtil.LOG_TAG, "The size of Account list is 0.");
        L7:
            this.mActivity = r3;
            this.mAccountList = r4;
            this.mResId = r5;
            this.mSubscriptionId = r6;
            return;
        L5:
            if (r4.size() != 0) goto L7;
            goto L6
        }

        public AccountSelectedListener(Activity r2, List<AccountWithDataSet> r3, int r4) {
            this(r2, r3, r4, -1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r3, int r4) {
            r3.dismiss();
            AccountSelectionUtil.doImport(this.mActivity, this.mResId, this.mAccountList.get(r4), this.mSubscriptionId);
        }

        void setAccountList(List<AccountWithDataSet> r1) {
            this.mAccountList = r1;
        }
    }

    static {
    }

    public AccountSelectionUtil() {
    }

    public static void setImportSubscription(int r0) {
        mImportSub = r0;
    }

    public static Dialog getSelectAccountDialog(Activity r1, int r2) {
        return getSelectAccountDialog(r1, r2, null, null);
    }

    public static Dialog getSelectAccountDialog(Activity r1, int r2, DialogInterface.OnClickListener r3) {
        return getSelectAccountDialog(r1, r2, r3, null);
    }

    public static Dialog getSelectAccountDialog(Activity r1, int r2, DialogInterface.OnClickListener r3, DialogInterface.OnCancelListener r4) {
        return getSelectAccountDialog(r1, r2, r3, r4, true);
    }

    public static Dialog getSelectAccountDialog(final Activity r7, int r8, DialogInterface.OnClickListener r9, DialogInterface.OnCancelListener r10, boolean r11) {
        final AccountTypeManager r5 = AccountTypeManager.getInstance(r7);
        r5.getAccounts(true);
        if (r11 == false) goto L5;
        List<AccountWithDataSet> r12 = r5.getAccounts(true);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "The number of available accounts: " + r12.size());
        final LayoutInflater r4 = (LayoutInflater) new ContextThemeWrapper(r7, R.style.Theme.Light).getSystemService("layout_inflater");
        final int r2 = com.android.contacts.common.R.layout.account_selector_list_item_condensed;
        final List<AccountWithDataSet> r3 = r12;
        ArrayAdapter<AccountWithDataSet> r6 = new AnonymousClass1(r7, r2, r3, r4, r5);
        if (r9 != null) goto L10;
        r9 = new AccountSelectedListener(r7, r12, r8);
    L12:
        if (r10 != null) goto L15;
        r10 = new AnonymousClass2();
    L15:
        return new AlertDialog.Builder(r7).setTitle(com.android.contacts.common.R.string.dialog_new_contact_account).setSingleChoiceItems(r6, 0, r9).setOnCancelListener(r10).create();
    L10:
        if ((r9 instanceof AccountSelectedListener) == false) goto L12;
        ((AccountSelectedListener) r9).setAccountList(r12);
        goto L12
    L5:
        r12 = r5.getAccounts(true, 1);
        goto L6
    }

    public static void doImport(Activity r1, int r2, AccountWithDataSet r3, int r4) {
        if (r2 != com.android.contacts.common.R.string.import_from_sim) goto L6;
        doImportFromSim(r1, r3, r4);
        return;
    L6:
        if (r2 != com.android.contacts.common.R.string.import_from_vcf_file) goto L10;
        doImportFromVcfFile(r1, r3);
        return;
    }

    public static void doImportFromSim(Activity r2, AccountWithDataSet r3, int r4) {
        Intent r5 = new Intent(SimContactsConstants.ACTION_MULTI_PICK_SIM);
        if (r3 == null) goto L5;
        r5.putExtra("account_name", r3.name);
        r5.putExtra("account_type", r3.type);
        r5.putExtra("data_set", r3.dataSet);
    L5:
        r5.putExtra("slot", mImportSub);
        r2.startActivity(r5);
    }

    public static void doImportFromVcfFile(Activity r3, AccountWithDataSet r4) {
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
        r3.startActivityForResult(r0, 0);
    }
}
