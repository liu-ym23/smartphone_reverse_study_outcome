package com.android.contacts.common.vcard;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.util.AccountSelectionUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class SelectAccountActivity extends Activity {
    public static final String ACCOUNT_NAME = "account_name";
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String DATA_SET = "data_set";
    private static final String LOG_TAG = "SelectAccountActivity";
    private AccountSelectionUtil.AccountSelectedListener mAccountSelectionListener;

    private class CancelListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        final /* synthetic */ SelectAccountActivity this$0;

        private CancelListener(SelectAccountActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CancelListener(SelectAccountActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            this.this$0.finish();
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            this.this$0.finish();
        }
    }

    public void com_android_contacts_common_vcard_SelectAccountActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_vcard_SelectAccountActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SelectAccountActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r5) {
        super.onCreate(r5);
        final int r6 = R.string.import_from_vcf_file;
        final List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(this).getAccounts(true, 1);
        if (r0.size() != 0) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Account does not exist");
        finish();
        return;
    L7:
        if (r0.size() != 1) goto L10;
        AccountWithDataSet r7 = r0.get(0);
        Intent r1 = new Intent();
        r1.putExtra("account_name", r7.name);
        r1.putExtra("account_type", r7.type);
        r1.putExtra("data_set", r7.dataSet);
        setResult(-1, r1);
        finish();
        return;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "The number of available accounts: " + r0.size());
        this.mAccountSelectionListener = new AnonymousClass1(this, this, r0, r6);
        showDialog(r6);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r3, Bundle r4) {
        if (r3 != R.string.import_from_vcf_file) goto L11;
        AccountSelectionUtil.AccountSelectedListener r5 = this.mAccountSelectionListener;
        if (r5 == null) goto L9;
        return AccountSelectionUtil.getSelectAccountDialog(this, r3, r5, new CancelListener(this, null), false);
    L9:
        throw new NullPointerException("mAccountSelectionListener must not be null.");
    L11:
        return super.onCreateDialog(r3, r4);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_vcard_SelectAccountActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SelectAccountActivity r1) {
        r1.com_android_contacts_common_vcard_SelectAccountActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
