package com.android.contacts.vcard;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SelectAccountActivity extends ContactsActivity {
    public static final String ACCOUNT_NAME = "account_name";
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String DATA_SET = "data_set";
    public static final String EXTRA_FROM_OUTSIDE = "from_outside";
    private static final String LOG_TAG = "SelectAccountActivity";
    private AccountSelectionUtil.AccountSelectedListener mAccountSelectionListener;
    private boolean mIsFromOutside;

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
        public void onCancel(DialogInterface r2) {
            if (SelectAccountActivity.access$000(this.this$0) == false) goto L5;
            this.this$0.setResult(0);
        L5:
            this.this$0.finish();
        }
    }

    public void com_android_contacts_vcard_SelectAccountActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_vcard_SelectAccountActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_vcard_SelectAccountActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SelectAccountActivity() {
        this.mIsFromOutside = false;
    }

    static /* synthetic */ boolean access$000(SelectAccountActivity r0) {
        return r0.mIsFromOutside;
    }

    public void com_android_contacts_vcard_SelectAccountActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        getWindow().addSystemFlags(524288);
        UiUtils.setWindowColorStatusBar(this);
        final List<AccountWithDataSet> r10 = AccountTypeManager.getInstance(this).getAccounts(true);
        this.mIsFromOutside = IntentUtils.getBooleanExtra(getIntent(), EXTRA_FROM_OUTSIDE, false);
        if (r10.size() != 0) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "No writable account, fallback to phone-local storage");
        Intent r11 = new Intent();
        String r1 = (String) null;
        r11.putExtra("account_name", null);
        r11.putExtra("account_type", null);
        r11.putExtra("data_set", null);
        setResult(-1, r11);
        finish();
        return;
    L7:
        if (r10.size() != 1) goto L10;
        AccountWithDataSet r12 = r10.get(0);
        Intent r0 = new Intent();
        r0.putExtra("account_name", r12.name);
        r0.putExtra("account_type", r12.type);
        r0.putExtra("data_set", r12.dataSet);
        setResult(-1, r0);
        finish();
        return;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "The number of available accounts: " + r10.size());
        final int r2 = R.string.import_from_sdcard;
        this.mAccountSelectionListener = new AnonymousClass1(this, this, r10, r2);
        showDialog(R.string.import_from_sdcard);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r2, Bundle r3) {
        if (r2 != R.string.import_from_sdcard) goto L5;
        AccountSelectionUtil.AccountSelectedListener r4 = this.mAccountSelectionListener;
        if (r4 == null) goto L11;
        return AccountSelectionUtil.getSelectAccountDialog(this, R.string.choose_an_account, r4, new CancelListener(this, null));
    L11:
        throw new NullPointerException("mAccountSelectionListener must not be null.");
    L5:
        return super.onCreateDialog(r2, r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_vcard_SelectAccountActivity_com_obric_privacyhook_PrivacyHook_onCreate(SelectAccountActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SelectAccountActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_vcard_SelectAccountActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_SelectAccountActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SelectAccountActivity r1) {
        com_android_contacts_vcard_SelectAccountActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_vcard_SelectAccountActivity_com_obric_privacyhook_PrivacyHook_onStop(SelectAccountActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SelectAccountActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_vcard_SelectAccountActivity__onStop$___twin___();
    }
}
