package com.android.contacts.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.editor.ContactEditorUtils;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AccountSelectionMenuDialog;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes.dex */
public class ContactEditorAccountsChangedActivity extends ContactsActivity {
    public static final String EXCLUDE_SIM_ACCOUNTS_EXTRA = "exclude_sim_accounts";
    private static final int SUBACTIVITY_ADD_NEW_ACCOUNT = 1;
    private static final String TAG = "ContactEditorAccountsChangedActivity";
    private final DialogInterface.OnClickListener mAccountListItemClickListener;
    private AccountSelectionMenuDialog mAccountSelectionDialog;
    List<AccountWithDataSet> mAccounts;
    private OInsetSheet mAccountsOSheet;
    private final View.OnClickListener mAddAccountClickListener;
    private final DialogInterface.OnCancelListener mCancelAccountClickListener;
    private ContactEditorUtils mEditorUtils;

    public void com_android_contacts_activities_ContactEditorAccountsChangedActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactEditorAccountsChangedActivity() {
        this.mAccountListItemClickListener = new AnonymousClass1(this);
        this.mAddAccountClickListener = new AnonymousClass2(this);
        this.mCancelAccountClickListener = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(ContactEditorAccountsChangedActivity r0, AccountWithDataSet r1) {
        r0.saveAccountAndReturnResult(r1);
    }

    static /* synthetic */ ContactEditorUtils access$100(ContactEditorAccountsChangedActivity r0) {
        return r0.mEditorUtils;
    }

    static /* synthetic */ OInsetSheet access$200(ContactEditorAccountsChangedActivity r0) {
        return r0.mAccountsOSheet;
    }

    static /* synthetic */ View.OnClickListener access$300(ContactEditorAccountsChangedActivity r0) {
        return r0.mAddAccountClickListener;
    }

    static /* synthetic */ boolean access$400(ContactEditorAccountsChangedActivity r0, Intent r1) {
        return r0.shouldInterceptActivity(r1);
    }

    public void com_android_contacts_activities_ContactEditorAccountsChangedActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        UiUtils.setWindowColorStatusBar(this);
        this.mEditorUtils = ContactEditorUtils.getInstance(this);
        boolean r0 = true;
        List<AccountWithDataSet> r8 = AccountTypeManager.getInstance(this).getAccountsIncludeSIM(true);
        this.mAccounts = r8;
        int r9 = r8.size();
        if (r9 < 0) goto L73;
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ContactsUtils.CMCC_U1  " + ContactsUtils.FEATURE_CMCC);
    L7:
        int r3 = 0;
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == true) goto L10;
    L20:
        int r4 = 0;
    L21:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "numAccounts = " + r9 + ", simCount = " + r4);
        if (r9 < (r4 + 1)) goto L37;
        AccountWithDataSet r10 = this.mEditorUtils.getDefaultAccount();
        StringBuilder r5 = new StringBuilder("account = ");
        if (r10 != null) goto L26;
        String r6 = "null";
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r5.append(r6).toString());
        if (r10 == null) goto L33;
        if (LocalAccountContactsUtils.isLocalAccount(r10) == true) goto L33;
        Intent r11 = new Intent();
        r11.putExtra(ContactsContractSmt.get_INSERT_ACCOUNT(), this.mEditorUtils.getDefaultAccount());
        setResult(-1, r11);
        super.finish();
        return;
    L33:
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L35;
        this.mAccountSelectionDialog = (AccountSelectionMenuDialog) AccountSelectionUtil.getSelectAccountDialog(this, R.string.contact_editor_prompt_multiple_accounts_bytedance, this.mAccountListItemClickListener, this.mCancelAccountClickListener, AccountTypeManager.getInstance(this).getAccountsIncludeSIM(true));
    L36:
        this.mAccountSelectionDialog.show();
        return;
    L35:
        this.mAccountSelectionDialog = (AccountSelectionMenuDialog) AccountSelectionUtil.getSelectAccountDialog(this, R.string.contact_editor_prompt_multiple_accounts_bytedance, this.mAccountListItemClickListener, this.mCancelAccountClickListener);
        goto L36
    L26:
        r6 = r10.type;
        goto L27
    L37:
        AccountWithDataSet r12 = this.mEditorUtils.getDefaultAccount();
        if (LocalAccountContactsUtils.isLocalAccount(r12) == false) goto L40;
        Intent r2 = new Intent();
        r2.putExtra(ContactsContractSmt.get_INSERT_ACCOUNT(), r12);
        setResult(-1, r2);
        super.finish();
    L40:
        boolean r13 = getResources().getBoolean(R.bool.build_rom_to_release);
        ArrayList<String> r1 = new ArrayList();
        ArrayList<View.OnClickListener> r14 = new ArrayList();
        if (r13 == false) goto L43;
    L46:
        r1.add(getString(R.string.add_account));
        r14.add(new AnonymousClass4(this));
    L47:
        r1.add(getString(R.string.keep_local));
        r14.add(new AnonymousClass6(this));
        if (getIntent() != null) goto L50;
    L52:
        r0 = false;
    L54:
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == true) goto L56;
    L70:
        OInsetSheet r15 = new OInsetSheet(this);
        this.mAccountsOSheet = r15;
        r15.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        this.mAccountsOSheet.setHeaderView(genHeaderView());
        this.mAccountsOSheet.setContainerView(genContentView(r1, r14));
        this.mAccountsOSheet.setFooterView(null);
        this.mAccountsOSheet.setOnCancelListener(new AnonymousClass8(this));
        this.mAccountsOSheet.show();
        return;
    L56:
        if (DSUtils.isMultiSimEnabled() == false) goto L70;
        if (r0 == true) goto L70;
    L59:
        if (r3 >= DSUtils.getPhoneCount()) goto L70;
        if (DSUtils.hasIccCard(r3) == false) goto L69;
        if (DSUtils.isSimEnable(r3) == false) goto L69;
        final String r16 = MoreContactUtils.getSimAccountName(r3);
        if (MoreContactUtils.canSaveEmail(r3) == false) goto L67;
        final String r17 = "USIM";
    L68:
        r1.add(getMultiSimName(r3));
        r14.add(new AnonymousClass7(this, r16, r17));
        goto L69
    L67:
        r17 = SimContactsConstants.SIM_NAME;
    L69:
        r3 = r3 + 1;
        goto L59
    L50:
        if (getIntent().getBooleanExtra(EXCLUDE_SIM_ACCOUNTS_EXTRA, false) == false) goto L52;
    L43:
        if (ContactsUtils.isBytedanceCloudExist() == false) goto L46;
        r1.add(getString(R.string.add_account_bytedance));
        r14.add(new AnonymousClass5(this));
        goto L47
    L10:
        if (DSUtils.isMultiSimEnabled() == false) goto L20;
        int r18 = 0;
        r4 = 0;
    L13:
        if (r18 >= DSUtils.getPhoneCount()) goto L21;
        if (DSUtils.hasIccCard(r18) == false) goto L19;
        if (DSUtils.isSimEnable(r18) == false) goto L19;
        r4 = r4 + 1;
    L19:
        r18 = r18 + 1;
        goto L13
    L73:
        throw new IllegalStateException("Cannot have a negative number of accounts");
    }

    private View genHeaderView() {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this);
        r0.setShowLeftBack(false);
        r0.setTitleText(getResources().getString(R.string.contact_editor_prompt_zero_accounts_bytedance));
        OButton r1 = r0.createNeutralButton(this, r0.mRightContainer);
        r1.setButtonSourceBitmap(R.drawable.o_ic_close);
        r1.setOnClickListener(new AnonymousClass9(this));
        return r0;
    }

    private View genContentView(ArrayList<String> r10, ArrayList<View.OnClickListener> r11) {
        LinearLayout r0 = new LinearLayout(this);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this, 5.0d));
        int r3 = Math.min(r10.size(), r11.size());
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(this).inflate(R.layout.sheet_button_center_blue, null);
        r6.setText(r10.get(r5));
        r6.setOnClickListener(r11.get(r5));
        r6.setWidth(ContactsUtils.dipTopx(this, 296.0d));
        r6.setHeight(ContactsUtils.dipTopx(this, 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = ContactsUtils.dipTopx(this, 5.0d);
        r0.addView(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this, 15.0d));
        return r0;
    }

    private String getMultiSimName(int r1) {
        return DSUtils.getSimName(this, r1);
    }

    public void com_android_contacts_activities_ContactEditorAccountsChangedActivity__onDestroy$___twin___() {
        super.onDestroy();
        AccountSelectionMenuDialog r0 = this.mAccountSelectionDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mAccountSelectionDialog = null;
    L5:
        OInsetSheet r1 = this.mAccountsOSheet;
        if (r1 == null) goto L9;
        r1.dismiss();
        this.mAccountsOSheet = null;
        return;
    }

    public void com_android_contacts_activities_ContactEditorAccountsChangedActivity__finish$___twin___() {
        super.finish();
        AnimationUtil.switchActivityAnimation(this, 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r3 == 1) goto L5;
        return;
    L5:
        if (r4 == (-1)) goto L8;
        new Handler().postDelayed(new AnonymousClass10(this), 300);
        return;
    L8:
        AccountWithDataSet r6 = this.mEditorUtils.getCreatedAccount(r4, r5);
        if (r6 != null) goto L12;
        setResult(r4);
        finish();
        return;
    L12:
        saveAccountAndReturnResult(r6);
    }

    private void saveAccountAndReturnResult(AccountWithDataSet r3) {
        this.mEditorUtils.saveDefaultAndAllAccounts(r3);
        Intent r0 = new Intent();
        r0.putExtra(ContactsContractSmt.get_INSERT_ACCOUNT(), r3);
        setResult(-1, r0);
        finish();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactEditorAccountsChangedActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorAccountsChangedActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ContactEditorAccountsChangedActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactEditorAccountsChangedActivity r1) {
        com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactEditorAccountsChangedActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorAccountsChangedActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorAccountsChangedActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_onDestroy(ContactEditorAccountsChangedActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorAccountsChangedActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorAccountsChangedActivity__onDestroy$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_ContactEditorAccountsChangedActivity_com_obric_privacyhook_PrivacyHook_finish(ContactEditorAccountsChangedActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactEditorAccountsChangedActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_ContactEditorAccountsChangedActivity__finish$___twin___();
    }
}
