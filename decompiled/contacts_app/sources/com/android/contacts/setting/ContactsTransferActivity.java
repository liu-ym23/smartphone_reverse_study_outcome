package com.android.contacts.setting;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactLocaleUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.button.OIconButton;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.TipsView;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsTransferActivity extends BaseActivity implements View.OnClickListener, TransferFragment.TransferCompletedCallback {
    private static final int REQUEST_CODE_GET_DEST_ACCOUNT = 1003;
    private static final int REQUEST_CODE_GET_SRC_ACCOUNT = 1002;
    private static final String TAG = "ContactsTransferActivity";
    private final String BASE_SELECTION;
    private AccountTypeManager mAccountTypes;
    private OListItemGeneral mCopyBtn;
    private TextView mCopyBtnText;
    private TextView mDestAccountNameView;
    private AccountWithDataSet mExportAccount;
    private FragmentManager mFragmentManager;
    private AccountWithDataSet mImportAccount;
    private OIconButton mSelectDestAccountBtn;
    private OIconButton mSelectSrcAccountBtn;
    private TextView mSrcAccountNameView;
    private OListItemGeneral mTransferBtn;
    private TextView mTransferBtnText;
    private TipsView mTransferContactsBottomMsgView1;
    private TipsView mTransferContactsBottomMsgView2;
    private TipsView mTransferContactsMsgView;
    private TransferFragment mTransferFragment;
    private ArrayList<Long> mTransferRawContactsIds;

    private class ValidateTask extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ ContactsTransferActivity this$0;

        private ValidateTask(ContactsTransferActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ValidateTask(ContactsTransferActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... r10) {
            int r0 = 0;
            if (ContactsTransferActivity.access$200(this.this$0) == null) goto L33;
            if (ContactsTransferActivity.access$300(this.this$0) == null) goto L33;
            if (ContactsTransferActivity.access$300(this.this$0).size() <= 0) goto L33;
            if (TextUtils.isEmpty(ContactsTransferActivity.access$200(this.this$0).dataSet) == false) goto L11;
            String[] r11 = {ContactsTransferActivity.access$200(this.this$0).name, ContactsTransferActivity.access$200(this.this$0).type};
            String r1 = "deleted != 1 AND account_name = ? AND account_type = ? AND data_set IS NULL";
        L12:
            Cursor r12 = this.this$0.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, r1, r11, null);
            ArrayList r2 = new ArrayList();
            if (r12 != null) goto L34;
        L22:
            ArrayList r13 = new ArrayList();
            boolean r3 = false;
        L24:
            if (r0 >= ContactsTransferActivity.access$300(this.this$0).size()) goto L30;
            if (r2.contains(ContactsTransferActivity.access$300(this.this$0).get(r0)) == false) goto L28;
            r13.add((Long) ContactsTransferActivity.access$300(this.this$0).get(r0));
        L29:
            r0 = r0 + 1;
            goto L24
        L28:
            r3 = true;
            goto L29
        L30:
            ContactsTransferActivity.access$302(this.this$0, r13);
            return Boolean.valueOf(r3);
        L34:
        L19:
            th = move-exception;
            r12.close();
            throw th;
        L15:
            if (r12.moveToNext() == false) goto L18;
            r2.add(Long.valueOf(r12.getLong(0)));     // Catch: Throwable -> L19
            goto L34
        L18:
            r12.close();
            goto L22
        L11:
            r11 = new String[]{ContactsTransferActivity.access$200(this.this$0).name, ContactsTransferActivity.access$200(this.this$0).type, ContactsTransferActivity.access$200(this.this$0).dataSet};
            r1 = "deleted != 1 AND account_name = ? AND account_type = ? AND data_set = ?";
        L33:
            return false;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r1) {
            if (this.this$0.isFinishing() == false) goto L5;
            return;
        L5:
            ContactsTransferActivity.access$400(this.this$0);
            ContactsTransferActivity.access$500(this.this$0).setOnClickListener(this.this$0);
        }
    }

    public void com_android_contacts_setting_ContactsTransferActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_setting_ContactsTransferActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_contacts_setting_ContactsTransferActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_setting_ContactsTransferActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ContactsTransferActivity() {
        this.BASE_SELECTION = "deleted != 1 AND account_name = ? AND account_type = ?";
    }

    static /* synthetic */ void access$000(ContactsTransferActivity r0) {
        r0.resetTransferContactsPanel();
    }

    static /* synthetic */ AccountWithDataSet access$200(ContactsTransferActivity r0) {
        return r0.mImportAccount;
    }

    static /* synthetic */ ArrayList access$300(ContactsTransferActivity r0) {
        return r0.mTransferRawContactsIds;
    }

    static /* synthetic */ ArrayList access$302(ContactsTransferActivity r0, ArrayList r1) {
        r0.mTransferRawContactsIds = r1;
        return r1;
    }

    static /* synthetic */ void access$400(ContactsTransferActivity r0) {
        r0.updateTransferContactsPanel();
    }

    static /* synthetic */ OIconButton access$500(ContactsTransferActivity r0) {
        return r0.mSelectSrcAccountBtn;
    }

    static /* synthetic */ TransferFragment access$600(ContactsTransferActivity r0) {
        return r0.mTransferFragment;
    }

    static /* synthetic */ AccountWithDataSet access$700(ContactsTransferActivity r0) {
        return r0.mExportAccount;
    }

    public void com_android_contacts_setting_ContactsTransferActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        setContentView(R.layout.contacts_transfer_layout);
        UiUtils.setWindowColorStatusBar(this);
        getWindow().setBackgroundDrawable(null);
        this.mAccountTypes = AccountTypeManager.getInstance(this);
        this.mFragmentManager = getFragmentManager();
        configTitle();
        OIconButton r10 = (OIconButton) findViewById(R.id.btn_select_src_account);
        this.mSelectSrcAccountBtn = r10;
        r10.setOnClickListener(this);
        OIconButton r11 = (OIconButton) findViewById(R.id.btn_select_dest_account);
        this.mSelectDestAccountBtn = r11;
        r11.setOnClickListener(this);
        this.mSrcAccountNameView = (TextView) findViewById(R.id.tv_src_account_name);
        this.mDestAccountNameView = (TextView) findViewById(R.id.tv_dest_account_name);
        this.mTransferContactsMsgView = (TipsView) findViewById(R.id.transfer_contacts_msg_view);
        this.mTransferContactsMsgView.setText(getResources().getString(R.string.transfer_contacts_msg, new Object[]{getResources().getString(R.string.default_src_account_name), getResources().getString(R.string.default_dest_account_name)}));
        String r12 = getResources().getString(R.string.copy_or_transfer_contacts_helper_info_1, new Object[]{getResources().getString(R.string.default_dest_account_name)});
        TipsView r0 = (TipsView) findViewById(R.id.transfer_contacts_bottom_msg_view_1);
        this.mTransferContactsBottomMsgView1 = r0;
        r0.setText(r12);
        String r13 = getResources().getString(R.string.copy_or_transfer_contacts_helper_info_2, new Object[]{getResources().getString(R.string.default_dest_account_name)});
        TipsView r1 = (TipsView) findViewById(R.id.transfer_contacts_bottom_msg_view_2);
        this.mTransferContactsBottomMsgView2 = r1;
        r1.setText(r13);
        OListItemGeneral r14 = (OListItemGeneral) findViewById(R.id.btn_copy_contacts);
        this.mCopyBtn = r14;
        r14.setEnabled(false);
        this.mCopyBtn.setOnClickListener(this);
        TextView r15 = this.mCopyBtn.mTvTitle;
        this.mCopyBtnText = r15;
        r15.setTextColor(getResources().getColor(R.color.oui_accent_fg));
        ViewGroup.LayoutParams r16 = this.mCopyBtnText.getLayoutParams();
        r16.width = -1;
        this.mCopyBtnText.setLayoutParams(r16);
        this.mCopyBtnText.setGravity(17);
        this.mCopyBtnText.setText(getString(R.string.copy_contacts_to, new Object[]{getString(R.string.default_dest_account_name)}));
        OListItemGeneral r17 = (OListItemGeneral) findViewById(R.id.btn_transfer_contacts);
        this.mTransferBtn = r17;
        r17.setEnabled(false);
        this.mTransferBtn.setOnClickListener(this);
        TextView r18 = this.mTransferBtn.mTvTitle;
        this.mTransferBtnText = r18;
        r18.setTextColor(getResources().getColor(R.color.oui_accent_fg));
        ViewGroup.LayoutParams r19 = this.mTransferBtnText.getLayoutParams();
        r19.width = -1;
        this.mTransferBtnText.setLayoutParams(r19);
        this.mTransferBtnText.setGravity(17);
        this.mTransferBtnText.setText(getString(R.string.transfer_contacts_to, new Object[]{getString(R.string.default_dest_account_name)}));
        TransferFragment r20 = (TransferFragment) this.mFragmentManager.findFragmentByTag(TransferFragment.FRAGMENT_TAG);
        this.mTransferFragment = r20;
        if (r20 != null) goto L5;
        this.mTransferFragment = new TransferFragment();
        this.mFragmentManager.beginTransaction().add(this.mTransferFragment, TransferFragment.FRAGMENT_TAG).commit();
        return;
    L5:
        r20.restart();
    }

    public void com_android_contacts_setting_ContactsTransferActivity__onNewIntent$___twin___(Intent r2) {
        super.onNewIntent(r2);
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onNewIntent");
    L5:
        TransferFragment r3 = this.mTransferFragment;
        if (r3 != null) goto L8;
    L9:
        validateTransferRawContacts();
        return;
    L8:
        if (r3.isTransferStarted() == false) goto L9;
    }

    @Override // com.android.contacts.setting.TransferFragment.TransferCompletedCallback
    public void transferCompleted(final String r2) {
        runOnUiThread(new AnonymousClass1(this, r2));
    }

    private void configTitle() {
        Intent r0 = getIntent();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        ((OFloatingTitleBar) findViewById(R.id.otitlebar)).addStartAction(TitleBarUtil.getLeftRes(r1), -1, new AnonymousClass2(this));
        return;
    L5:
        if (r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r1 = true;
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        switch(r4.getId()) {
            case 2131362119: goto L21;
            case 2131362162: goto L17;
            case 2131362163: goto L5;
            case 2131362172: goto L21;
            default: goto L25;
        };
    L5:
        Intent r5 = new Intent(this, TransferAccountsActivity.class);
        r5.putExtra("transfer_direction", "src");
        AccountWithDataSet r0 = this.mExportAccount;
        if (r0 == null) goto L8;
        r5.putExtra("exclude_account", r0);
    L8:
        AccountWithDataSet r1 = this.mImportAccount;
        if (r1 == null) goto L11;
        r5.putExtra("old_src_account", r1);
    L11:
        ArrayList<Long> r2 = this.mTransferRawContactsIds;
        if (r2 != null) goto L14;
    L16:
        startActivityForResult(r5, 1002);
        return;
    L14:
        if (r2.size() <= 0) goto L16;
        r5.putExtra("com.android.contacts.extra.PHONE_IDS", this.mTransferRawContactsIds);
        goto L16
    L17:
        Intent r6 = new Intent(this, TransferAccountsActivity.class);
        r6.putExtra("transfer_direction", "dest");
        AccountWithDataSet r3 = this.mImportAccount;
        if (r3 == null) goto L20;
        r6.putExtra("exclude_account", r3);
    L20:
        startActivityForResult(r6, 1003);
        return;
    L21:
        askExportOrNot(r4.getId());
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 != 1002) goto L8;
        this.mImportAccount = (AccountWithDataSet) r4.getParcelableExtra("src_account");
        this.mTransferRawContactsIds = (ArrayList) r4.getExtra("transfer_rawcontacts");
    L12:
        updateTransferContactsPanel();
        return;
    L8:
        if (r2 != 1003) goto L12;
        this.mExportAccount = (AccountWithDataSet) r4.getParcelableExtra("dest_account");
        goto L12
    }

    private void validateTransferRawContacts() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "validateTransferRawContacts");
    L5:
        this.mSelectSrcAccountBtn.setOnClickListener(null);
        this.mCopyBtn.setEnabled(false);
        this.mTransferBtn.setEnabled(false);
        new ValidateTask(this, null).execute(new Void[0]);
    }

    private void updateTransferContactsPanel() {
        int r0 = (int) getResources().getDimension(R.dimen.image_view_transfer_contacts_padding);
        AccountWithDataSet r1 = this.mImportAccount;
        if (r1 != null) goto L5;
    L7:
        this.mSrcAccountNameView.setText(R.string.default_src_account_name);
        this.mSelectSrcAccountBtn.setPadding(0, 0, 0, 0);
        this.mSelectSrcAccountBtn.setImageResource(R.drawable.transfer_contacts_add_account);
    L8:
        AccountWithDataSet r2 = this.mExportAccount;
        if (r2 == null) goto L11;
        AccountType r3 = this.mAccountTypes.getAccountType(r2.type, this.mExportAccount.dataSet);
        this.mDestAccountNameView.setText(r3.getDisplayLabel(this));
        this.mSelectDestAccountBtn.setPadding(r0, r0, r0, r0);
        this.mSelectDestAccountBtn.setImageDrawable(r3.getDisplayIcon(this));
        String r4 = getAccountDisplayLabel((String) r3.getDisplayLabel(this), false);
        this.mCopyBtnText.setText(getString(R.string.copy_contacts_to, new Object[]{r4}));
        this.mTransferBtnText.setText(getString(R.string.transfer_contacts_to, new Object[]{r4}));
        this.mTransferContactsBottomMsgView1.setText(getResources().getString(R.string.copy_or_transfer_contacts_helper_info_1, new Object[]{r4}));
        this.mTransferContactsBottomMsgView2.setText(getResources().getString(R.string.copy_or_transfer_contacts_helper_info_2, new Object[]{r4}));
    L13:
        if (this.mImportAccount == null) goto L21;
        ArrayList<Long> r5 = this.mTransferRawContactsIds;
        if (r5 == null) goto L21;
        if (r5.size() <= 0) goto L21;
        if (this.mExportAccount == null) goto L21;
        this.mCopyBtn.setEnabled(true);
        this.mTransferBtn.setEnabled(true);
        return;
    L21:
        this.mCopyBtn.setEnabled(false);
        this.mTransferBtn.setEnabled(false);
        return;
    L11:
        this.mDestAccountNameView.setText(R.string.default_dest_account_name);
        this.mSelectDestAccountBtn.setPadding(0, 0, 0, 0);
        this.mSelectDestAccountBtn.setImageResource(R.drawable.transfer_contacts_add_account);
        this.mCopyBtnText.setText(getString(R.string.copy_contacts_to, new Object[]{getString(R.string.default_dest_account_name)}));
        this.mTransferBtnText.setText(getString(R.string.transfer_contacts_to, new Object[]{getString(R.string.default_dest_account_name)}));
        this.mTransferContactsBottomMsgView1.setText(getResources().getString(R.string.copy_or_transfer_contacts_helper_info_1, new Object[]{getResources().getString(R.string.default_dest_account_name)}));
        this.mTransferContactsBottomMsgView2.setText(getResources().getString(R.string.copy_or_transfer_contacts_helper_info_2, new Object[]{getResources().getString(R.string.default_dest_account_name)}));
        goto L13
    L5:
        if (this.mTransferRawContactsIds == null) goto L7;
        AccountType r6 = this.mAccountTypes.getAccountType(r1.type, this.mImportAccount.dataSet);
        int r7 = this.mTransferRawContactsIds.size();
        this.mSrcAccountNameView.setText(getResources().getQuantityString(R.plurals.account_statistics_summary, r7, new Object[]{Integer.valueOf(r7)}));
        this.mSelectSrcAccountBtn.setPadding(r0, r0, r0, r0);
        this.mSelectSrcAccountBtn.setImageDrawable(r6.getDisplayIcon(this));
        goto L8
    }

    private void resetTransferContactsPanel() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        this.mSelectSrcAccountBtn.setPadding(0, 0, 0, 0);
        this.mSelectSrcAccountBtn.setImageResource(R.drawable.transfer_contacts_add_account);
        this.mSelectDestAccountBtn.setPadding(0, 0, 0, 0);
        this.mSelectDestAccountBtn.setImageResource(R.drawable.transfer_contacts_add_account);
        this.mSrcAccountNameView.setText(R.string.default_src_account_name);
        this.mDestAccountNameView.setText(R.string.default_dest_account_name);
        this.mCopyBtn.setEnabled(false);
        this.mTransferBtn.setEnabled(false);
        this.mCopyBtnText.setText(getString(R.string.copy_contacts_to, new Object[]{getString(R.string.default_dest_account_name)}));
        this.mTransferBtnText.setText(getString(R.string.transfer_contacts_to, new Object[]{getString(R.string.default_dest_account_name)}));
        this.mTransferContactsBottomMsgView1.setText(getResources().getString(R.string.copy_or_transfer_contacts_helper_info_1, new Object[]{getResources().getString(R.string.default_dest_account_name)}));
        this.mTransferContactsBottomMsgView2.setText(getResources().getString(R.string.copy_or_transfer_contacts_helper_info_2, new Object[]{getResources().getString(R.string.default_dest_account_name)}));
        this.mImportAccount = null;
        this.mExportAccount = null;
        this.mTransferRawContactsIds = null;
    }

    private void askExportOrNot(final int r6) {
        int r0 = this.mTransferRawContactsIds.size();
        if (r6 != R.id.btn_copy_contacts) goto L5;
        String r1 = getResources().getQuantityString(R.plurals.copy_contacts_confirm_msg, r0, new Object[]{Integer.valueOf(r0)});
    L6:
        AlertDialog.Builder r2 = new AlertDialog.Builder(new ContextThemeWrapper(this, android.R.style.Theme.DeviceDefault.Light.Dialog));
        r2.setMessage(r1);
        r2.setPositiveButton(android.R.string.ok, new AnonymousClass3(this, r6));
        r2.setNegativeButton(android.R.string.cancel, null);
        AlertDialog r5 = r2.create();
        r5.setCanceledOnTouchOutside(false);
        r5.show();
        return;
    L5:
        r1 = getResources().getQuantityString(R.plurals.transfer_contacts_confirm_msg, r0, new Object[]{Integer.valueOf(r0)});
        goto L6
    }

    private String getAccountDisplayLabel(String r2, boolean r3) {
        String r1 = Locale.getDefault().getLanguage().toLowerCase();
        if (ContactLocaleUtils.CHINESE_LANGUAGE.equals(r1) == true) goto L5;
    L12:
        return r2;
    L5:
        if (ContactsUtils.isChinese(r2) == true) goto L12;
        if (r3 == false) goto L9;
        StringBuilder r4 = new StringBuilder(HanziToPinyin.Token.SEPARATOR).append(r2).append(HanziToPinyin.Token.SEPARATOR);
    L11:
        return r4.toString();
    L9:
        r4 = new StringBuilder(HanziToPinyin.Token.SEPARATOR).append(r2);
        goto L11
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_setting_ContactsTransferActivity_com_obric_privacyhook_PrivacyHook_onCreate(ContactsTransferActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsTransferActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_setting_ContactsTransferActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_setting_ContactsTransferActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ContactsTransferActivity r1) {
        com_android_contacts_setting_ContactsTransferActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_setting_ContactsTransferActivity_com_obric_privacyhook_PrivacyHook_onStop(ContactsTransferActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsTransferActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_setting_ContactsTransferActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onNewIntent")
    public static void com_android_contacts_setting_ContactsTransferActivity_com_obric_privacyhook_PrivacyHook_onNewIntent(ContactsTransferActivity r2, Intent r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ContactsTransferActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r3);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_setting_ContactsTransferActivity__onNewIntent$___twin___(r3);
    }
}
