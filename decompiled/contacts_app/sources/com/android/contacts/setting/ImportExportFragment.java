package com.android.contacts.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.editor.SelectAccountDialogFragment;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.util.AccountSelectionMenuDialog;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.Constants;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.vcard.ExportSimContacts;
import com.android.contacts.vcard.ImportSimContacts;
import com.android.internal.telephony.TelephonyIntents;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.ui.OFloatingTitleBarHolder;
import java.util.ArrayList;
import java.util.List;
import obric.app.MenuDialogListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class ImportExportFragment extends Fragment implements SelectAccountDialogFragment.Listener {
    private static final String KEY_RES_ID = "resourceId";
    private static final int REQUEST_CODE_PICK_CONTACTS = 10;
    public static final String STATE_CANCEL = "STATE_CANCEL";
    public static final String STATE_NONE = "STATE_NONE";
    public static final String STATE_SETTINGS = "STATE_SETTINGS";
    private static final String TAG = "ImportExportFragment";
    private BroadcastReceiver mBroadcastReceiver;
    private OCardListItem mBtnExportToSim;
    private OCardListItem mBtnImportFromCloud;
    private OCardListItem mBtnImportFromExternalSdcard;
    private OCardListItem mBtnImportFromOtherAccounts;
    private OCardListItem mBtnImportFromOtherPhone;
    private OCardListItem mBtnImportFromSim;
    protected View mBtnLeftCancel;
    protected View mBtnLeftSettingsBack;
    private OCardListItem mBtnTransferContacts;
    private Context mContext;
    private int mExportItem;
    private AlertDialog mExportSelectionDialog;
    private OCardListItem mExportView;
    protected OFloatingTitleBarHolder mFloatingTitleBarHolder;
    private int mImExportSimId;
    private View mParents;
    BroadcastReceiver mSimStateReceiver;
    public OFloatingTitleBar mTitleBar;

    private class SimPhbLoadResult {
        int adnCapacity;
        int adnUsedCount;
        final /* synthetic */ ImportExportFragment this$0;

        private SimPhbLoadResult(ImportExportFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SimPhbLoadResult(ImportExportFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        public String toString() {
            return "SimPhbLoadResult{adnCapacity=" + this.adnCapacity + ", adnUsedCount=" + this.adnUsedCount + '}';
        }
    }

    public class SimSelectAdapter extends MenuDialogListAdapter {
        private Context mContext;
        private List<SimItemInfo> mSimItemInfos;
        final /* synthetic */ ImportExportFragment this$0;

        private class SimItemInfo {
            int adnCount;
            String operatorName;
            int simIconResId;
            String simName;
            String simPhoneNumber;
            final /* synthetic */ SimSelectAdapter this$1;

            SimItemInfo(SimSelectAdapter r1, int r2, String r3) {
                this.this$1 = r1;
                this.adnCount = -1;
                this.simIconResId = r2;
                this.simName = r3;
            }

            public String toString() {
                return "SimItemInfo{simIconResId=" + this.simIconResId + ", simName='" + this.simName + "', operatorName='" + this.operatorName + "', simPhoneNumber='" + this.simPhoneNumber + "', adnCount=" + this.adnCount + '}';
            }
        }

        @Override // obric.app.MenuDialogListAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return null;
        }

        @Override // obric.app.MenuDialogListAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        static /* synthetic */ List access$1100(SimSelectAdapter r0) {
            return r0.mSimItemInfos;
        }

        static /* synthetic */ Context access$1200(SimSelectAdapter r0) {
            return r0.mContext;
        }

        public SimSelectAdapter(ImportExportFragment r1, Context r2, Fragment r3) {
            this.this$0 = r1;
            super(r2, new ArrayList(), new ArrayList());
            this.mContext = r2;
            asyncQuerySimInfo();
        }

        private void asyncQuerySimInfo() {
            this.mSimItemInfos = new ArrayList();
            SimItemInfo r0 = new SimItemInfo(this, DSUtils.getBigSimIconResource(0), DSUtils.getSimName(this.mContext, 0));
            SimItemInfo r1 = new SimItemInfo(this, DSUtils.getBigSimIconResource(1), DSUtils.getSimName(this.mContext, 1));
            this.mSimItemInfos.add(r0);
            this.mSimItemInfos.add(r1);
            new Thread(new AnonymousClass1(this)).start();
        }

        @Override // obric.app.MenuDialogListAdapter, android.widget.Adapter
        public int getCount() {
            return this.mSimItemInfos.size();
        }

        @Override // obric.app.MenuDialogListAdapter, android.widget.Adapter
        public View getView(int r9, View r10, ViewGroup r11) {
            if (r10 != null) goto L5;
            r10 = LayoutInflater.from(this.mContext).inflate(R.layout.sim_select_menu_item, null);
        L5:
            SimItemInfo r12 = this.mSimItemInfos.get(r9);
            ImageView r13 = (ImageView) r10.findViewById(R.id.icon);
            View r0 = r10.findViewById(R.id.item_progress_circle);
            TextView r1 = (TextView) r10.findViewById(R.id.name);
            TextView r2 = (TextView) r10.findViewById(R.id.opt_name);
            TextView r3 = (TextView) r10.findViewById(R.id.number);
            TextView r4 = (TextView) r10.findViewById(R.id.count);
            BytedanceApi.setMaxTextSize(r4, ContactsUtils.dipTopx(this.mContext, 15.6d));
            r13.setImageResource(r12.simIconResId);
            r1.setText(r12.simName);
            if (TextUtils.isEmpty(r12.operatorName) == true) goto L9;
            r2.setText(r12.operatorName);
        L9:
            if (TextUtils.isEmpty(r12.simPhoneNumber) == true) goto L12;
            r3.setText(r12.simPhoneNumber);
        L12:
            if (r12.adnCount == (-1)) goto L14;
            r0.setVisibility(8);
            r4.setText(this.mContext.getResources().getQuantityString(R.plurals.person, r12.adnCount, new Object[]{Integer.valueOf(r12.adnCount)}));
        L15:
            return r10;
        L14:
            r0.setVisibility(0);
            r4.setText("");
            goto L15
        }
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountSelectorCancelled() {
    }

    public ImportExportFragment() {
        this.mBtnLeftCancel = null;
        this.mBtnLeftSettingsBack = null;
        this.mImExportSimId = 0;
        this.mSimStateReceiver = new AnonymousClass12(this);
        this.mExportItem = 1;
        this.mBroadcastReceiver = new AnonymousClass18(this);
    }

    static /* synthetic */ Context access$000(ImportExportFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$100(ImportExportFragment r0, int r1) {
        r0.showSimSelectDialog(r1);
    }

    static /* synthetic */ OCardListItem access$1000(ImportExportFragment r0) {
        return r0.mExportView;
    }

    static /* synthetic */ int access$1400(ImportExportFragment r0) {
        return r0.mExportItem;
    }

    static /* synthetic */ int access$1402(ImportExportFragment r0, int r1) {
        r0.mExportItem = r1;
        return r1;
    }

    static /* synthetic */ AlertDialog access$1500(ImportExportFragment r0) {
        return r0.mExportSelectionDialog;
    }

    static /* synthetic */ OCardListItem access$1600(ImportExportFragment r0) {
        return r0.mBtnImportFromExternalSdcard;
    }

    static /* synthetic */ int access$200(ImportExportFragment r0) {
        return r0.mImExportSimId;
    }

    static /* synthetic */ int access$202(ImportExportFragment r0, int r1) {
        r0.mImExportSimId = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300(ImportExportFragment r0, int r1) {
        return r0.handleImportRequest(r1);
    }

    static /* synthetic */ void access$400(ImportExportFragment r0) {
        r0.showExportSelectionDialog();
    }

    static /* synthetic */ void access$500(ImportExportFragment r0) {
        r0.handleExoprtToSimRequest();
    }

    static /* synthetic */ void access$600(ImportExportFragment r0) {
        r0.handleTransferContactsRequest();
    }

    static /* synthetic */ void access$700(ImportExportFragment r0) {
        r0.handleImportContactsFromOtherPhoneRequest();
    }

    static /* synthetic */ void access$800(ImportExportFragment r0) {
        r0.updateSimOperationButtonState();
    }

    static /* synthetic */ void access$900(String r0) {
        log(r0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mContext = getActivity();
        return inflateAndSetupView(r2, r3, r4, R.layout.contacts_setting_ie_fragment);
    }

    protected View inflateAndSetupView(LayoutInflater r1, ViewGroup r2, Bundle r3, int r4) {
        View r5 = r1.inflate(r4, r2, false);
        this.mParents = r5;
        configTitle(r5);
        ((OCardListItem) this.mParents.findViewById(R.id.btn_import_from_sdcard)).setOnContentClickListener(new AnonymousClass1(this));
        OCardListItem r6 = (OCardListItem) this.mParents.findViewById(R.id.btn_import_from_external_sdcard);
        this.mBtnImportFromExternalSdcard = r6;
        r6.setOnContentClickListener(new AnonymousClass2(this));
        OCardListItem r7 = (OCardListItem) this.mParents.findViewById(R.id.btn_import_from_sim);
        this.mBtnImportFromSim = r7;
        r7.setOnContentClickListener(new AnonymousClass3(this));
        OCardListItem r8 = (OCardListItem) this.mParents.findViewById(R.id.btn_export_to_sdcard);
        this.mExportView = r8;
        r8.setOnContentClickListener(new AnonymousClass4(this));
        OCardListItem r9 = (OCardListItem) this.mParents.findViewById(R.id.btn_import_from_cloud);
        this.mBtnImportFromCloud = r9;
        r9.setOnContentClickListener(new AnonymousClass5(this));
        OCardListItem r10 = (OCardListItem) this.mParents.findViewById(R.id.btn_import_from_other_accounts);
        this.mBtnImportFromOtherAccounts = r10;
        r10.setOnContentClickListener(new AnonymousClass6(this));
        if (ContactsUtils.isBytedanceCloudExist() == true) goto L5;
        this.mBtnImportFromCloud.setVisibility(8);
    L5:
        OCardListItem r11 = (OCardListItem) this.mParents.findViewById(R.id.btn_export_to_sim);
        this.mBtnExportToSim = r11;
        r11.setOnContentClickListener(new AnonymousClass7(this));
        OCardListItem r12 = (OCardListItem) this.mParents.findViewById(R.id.btn_transfer_contacts);
        this.mBtnTransferContacts = r12;
        r12.setOnContentClickListener(new AnonymousClass8(this));
        OCardListItem r13 = (OCardListItem) this.mParents.findViewById(R.id.btn_import_from_other_phone);
        this.mBtnImportFromOtherPhone = r13;
        r13.setOnContentClickListener(new AnonymousClass9(this));
        if (isImportFromOtherPhoneSupported() == true) goto L9;
        this.mBtnImportFromOtherPhone.setVisibility(8);
    L9:
        return this.mParents;
    }

    private boolean isImportFromOtherPhoneSupported() {
        PackageManager r3 = this.mContext.getPackageManager();
        Intent r0 = new Intent();
        r0.setClassName(ContactsUtils.IMPORT_OTHER_PHONE_PACKAGE_NAME, ContactsUtils.IMPORT_OTHER_PHONE_ACTIVITY_NAME);
        List<ResolveInfo> r4 = r3.queryIntentActivities(r0, 1);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    private void configTitle(View r5) {
        Intent r0 = getActivity().getIntent();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        this.mTitleBar = (OFloatingTitleBar) r5.findViewById(R.id.otitlebar);
        OFloatingTitleBarHolder r6 = new OFloatingTitleBarHolder(this.mTitleBar);
        this.mFloatingTitleBarHolder = r6;
        this.mBtnLeftSettingsBack = r6.addStartAction(STATE_SETTINGS, TitleBarUtil.getLeftRes(r1), new AnonymousClass10(this));
        this.mBtnLeftCancel = this.mFloatingTitleBarHolder.addStartAction("STATE_CANCEL", R.drawable.icon_cancel_22_22, new AnonymousClass11(this));
        this.mFloatingTitleBarHolder.startButtonToState(STATE_SETTINGS);
        return;
    L5:
        if (r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r1 = true;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        registerSimStateChangeReceiver();
    }

    private void registerSimStateChangeReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        if (DSUtils.isMTKPlatform() == false) goto L5;
        r0.addAction(DSUtils.ACTION_PHB_STATE_CHANGED);
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mSimStateReceiver, r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mContext.unregisterReceiver(this.mSimStateReceiver);
    }

    private void updateSimOperationButtonState() {
        boolean r1 = true;
        boolean r0 = !ContactsUtils.isNoSim(this.mContext);
        if (DSUtils.isMTKPlatform() == true) goto L5;
    L13:
        this.mBtnImportFromSim.setEnabled(r0);
        this.mBtnExportToSim.setEnabled(r0);
        return;
    L5:
        if (ContactsUtils.isNoSim(this.mContext) == false) goto L7;
    L11:
        r1 = false;
    L12:
        r0 = r1;
        goto L13
    L7:
        if (DSUtils.isSim1PhbReady() == true) goto L12;
        if (DSUtils.isSim2PhbReady() == false) goto L11;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.setting.ImportExportFragment$13] */
    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateSimOperationButtonState();
        new AnonymousClass13(this).execute(new Void[0]);
        boolean r0 = !ContactsUtils.isFeaturePhoneMode();
        this.mBtnImportFromOtherAccounts.setEnabled(r0);
        this.mBtnImportFromCloud.setEnabled(r0);
        this.mBtnImportFromOtherPhone.setEnabled(r0);
        if (ContactsUtils.getExternalSdcardExportDirectoryPath() == null) goto L5;
        this.mBtnImportFromExternalSdcard.setVisibility(0);
    L6:
        listenExternalSdcardEjectEvent();
        return;
    L5:
        this.mBtnImportFromExternalSdcard.setVisibility(8);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(this.mBroadcastReceiver);
        AlertDialog r0 = this.mExportSelectionDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mExportSelectionDialog.dismiss();
        return;
    }

    public void resetBackText() {
        OFloatingTitleBarHolder r1 = this.mFloatingTitleBarHolder;
        if (r1 == null) goto L6;
        r1.startButtonToState("STATE_CANCEL");
        return;
    }

    private void showSimSelectDialog(final int r4) {
        AccountSelectionMenuDialog r0 = new AccountSelectionMenuDialog(this.mContext);
        r0.setTitle(this.mContext.getString(R.string.sim_select_dialog_title));
        r0.setAdapter(new SimSelectAdapter(this, this.mContext, this), new AnonymousClass14(this, r4));
        r0.show();
    }

    private boolean handleImportRequest(int r3) {
        doImport(this.mContext, r3, null);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.setting.ImportExportFragment$15] */
    private void handleExoprtToSimRequest() {
        new AnonymousClass15(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void handleTransferContactsRequest() {
        Intent r0 = new Intent(getActivity(), ContactsTransferActivity.class);
        r0.putExtra(Constants.EXTRA_FROM_SETTINGS, true);
        startActivity(r0);
        AnimationUtil.switchActivityAnimation(getActivity(), 5);
    }

    private void handleImportContactsFromOtherPhoneRequest() {
        Intent r0 = new Intent();
        r0.setClassName(ContactsUtils.IMPORT_OTHER_PHONE_PACKAGE_NAME, ContactsUtils.IMPORT_OTHER_PHONE_ACTIVITY_NAME);
        r0.setAction("android.intent.action.MAIN");
        r0.setFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Skip import contacts from other phone: activity is null");
        return;
    L11:
        r3.startActivity(r0);     // Catch: Throwable -> L8
        AnimationUtil.switchActivityAnimation(r3, 5);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to start import contacts from other phone", e);
        ContactsApplication.showToast(R.string.quickcontact_missing_app, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        log("onActivityResult, requestCode = " + r3 + ", resultCode = " + r4);
        if (r4 == (-1)) goto L6;
        return;
    L6:
        if (10 != r3) goto L16;
        Intent r6 = new Intent(this.mContext, ExportSimContacts.class);
        ArrayList r7 = (ArrayList) r5.getExtra("com.android.contacts.extra.PHONE_IDS");
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() <= 0) goto L18;
        r6.putExtra("com.android.contacts.extra.PHONE_IDS", r7);
        if (DSUtils.isMultiSimEnabled() == false) goto L14;
        r6.putExtra(DSUtils.SUBSCRIPTION_KEY, this.mImExportSimId);
    L14:
        int r8 = DSUtils.getAdnMaxCount(this.mImExportSimId) - DSUtils.getAdnCount(this.mContext, this.mImExportSimId);
        log("simFreeSpace = " + r8);
        r6.putExtra("sim_free_space", r8);
        startActivity(r6);
        return;
    L18:
        return;
    }

    private void doExport(Context r2, int r3) {
        Intent r4 = new Intent(this.mContext, ImportSimContacts.class);
        r4.putExtra("export_flag", true);
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        r4.putExtra(DSUtils.SUBSCRIPTION_KEY, this.mImExportSimId);
    L5:
        startActivity(r4);
    }

    private void doImport(Context r2, int r3, AccountWithDataSet r4) {
        if (r3 == R.id.btn_import_from_sim) goto L5;
        AccountSelectionUtil.doImport(this.mContext, r3, r4);
        return;
    L5:
        if (ContactsUtils.isNoSim(r2) == false) goto L8;
        Toast.makeText(r2, R.string.toast_no_sim, 0).show();
        return;
    L8:
        Intent r5 = new Intent(this.mContext, ImportSimContacts.class);
        r5.putExtra(ImportSimContacts.EXTRA_ACCOUNT, r4);
        if (DSUtils.isMultiSimEnabled() == false) goto L11;
        r5.putExtra(DSUtils.SUBSCRIPTION_KEY, this.mImExportSimId);
    L11:
        startActivity(r5);
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountChosen(AccountWithDataSet r3, Bundle r4) {
        doImport(this.mContext, r4.getInt(KEY_RES_ID), r3);
    }

    private void showExportSelectionDialog() {
        String[] r0 = {getString(R.string.export_contacts_selection_internal), getString(R.string.sd_card)};
        AlertDialog.Builder r1 = new AlertDialog.Builder(new ContextThemeWrapper(this.mContext, android.R.style.Theme.DeviceDefault.Light.Dialog));
        this.mExportItem = 1;
        this.mExportSelectionDialog = r1.setTitle(R.string.export_contacts_selection_title).setSingleChoiceItems(r0, 1, new AnonymousClass17(this)).setPositiveButton(android.R.string.ok, new AnonymousClass16(this)).setNegativeButton(android.R.string.cancel, null).show();
    }

    private void listenExternalSdcardEjectEvent() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.MEDIA_REMOVED");
        r0.addAction("android.intent.action.MEDIA_EJECT");
        r0.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        r0.addAction("android.intent.action.MEDIA_UNMOUNTED");
        r0.addDataScheme("file");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mBroadcastReceiver, r0);
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }
}
