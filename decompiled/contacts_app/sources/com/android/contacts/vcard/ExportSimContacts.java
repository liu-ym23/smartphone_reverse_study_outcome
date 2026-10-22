package com.android.contacts.vcard;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.NotificationManagerHelper;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.ProgressDialog;
import com.android.internal.telephony.TelephonyIntents;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.base.AbstractDialog;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ExportSimContacts extends Activity {
    private static final boolean DBG = false;
    private static final String EXPORT_SIM_CHANNEL_ID = "export_sim_channel";
    private static final String LOG_TAG = "ExportSimContacts";
    private static final int NOTIFICATION_ID = 19;
    protected static final int STATE_IMPORT_ERROR = -2;
    protected static final int STATE_IMPORT_FINISH = 4;
    protected static final int STATE_IMPORT_ING = 3;
    protected static final int STATE_NA = -3;
    protected static final int STATE_QUERY_ERROR = -1;
    protected static final int STATE_QUERY_FINISH = 2;
    protected static final int STATE_QUERY_ING = 1;
    private boolean inBackground;
    private AbstractDialog mAirPlanDialog;
    private AbstractDialog mAskDialog;
    private AbstractDialog mCommonDialog;
    private ArrayList<Long> mContactIds;
    private ArrayList<ContactInfo> mContactInfoList;
    private Context mContext;
    private ExportAllSimContactsThread mExportThread;
    private DialogInterface.OnClickListener mFinishListener;
    private ProgressDialog mLoadingDialog;
    private NotificationManagerHelper mNotificationHelper;
    private NotificationManager mNotificationManager;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private ProgressBodyController mProgressBodyController;
    private AbstractDialog mProgressDialog;
    QueryThread mQueryThread;
    private int mSimId;
    BroadcastReceiver mSimStateReceiver;
    private int mState;
    private boolean mStopImport;
    private Notification notification;

    private class ContactInfo {
        String anrNumber;
        String email;
        String name;
        String number;
        final /* synthetic */ ExportSimContacts this$0;

        private ContactInfo(ExportSimContacts r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ContactInfo(ExportSimContacts r1, AnonymousClass1 r2) {
            this(r1);
        }

        public String toString() {
            return "name: " + this.name + ", number: " + this.number + ", anrNumber: " + this.anrNumber + ", email: " + this.email;
        }
    }

    private class ExportAllSimContactsThread extends Thread implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
        protected boolean mCanceled;
        final /* synthetic */ ExportSimContacts this$0;

        public ExportAllSimContactsThread(ExportSimContacts r1) {
            this.this$0 = r1;
            super("ExportAllSimContactsThread");
            this.mCanceled = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            int r0 = ExportSimContacts.access$000(this.this$0).size();
            Notification.Builder r1 = new Notification.Builder(ExportSimContacts.access$100(this.this$0), ExportSimContacts.EXPORT_SIM_CHANNEL_ID);
            Iterator r2 = ExportSimContacts.access$000(this.this$0).iterator();
            int r5 = 0;
        L7:
            if (r2.hasNext() == false) goto L20;
            ContactInfo r6 = (ContactInfo) r2.next();
            if (this.mCanceled == true) goto L20;
            r5 = r5 + 1;
            if (ExportSimContacts.access$200(this.this$0) == true) goto L14;
        L16:
            ExportSimContacts r8 = this.this$0;
            ExportSimContacts.access$600(r8, r6, ExportSimContacts.access$500(r8));
            if (ExportSimContacts.access$700(this.this$0) == null) goto L7;
            ExportSimContacts.access$700(this.this$0).incrementProgressBy(1);
            goto L7
        L14:
            if (ExportSimContacts.access$300(this.this$0).shouldNotifyNotificationLimit() == false) goto L16;
            ExportSimContacts.access$400(this.this$0, r1, r0, r5);
        L20:
            if (ExportSimContacts.access$800(this.this$0) == false) goto L22;
            final String r3 = ExportSimContacts.access$100(this.this$0).getString(R.string.export_contacts_from_sim_canceled);
        L23:
            ExportSimContacts.access$900(this.this$0);
            Intent r4 = new Intent("android.intent.action.VIEW", ContactsContract.Contacts.CONTENT_URI);
            r4.setPackage("com.android.contacts");
            Notification.Builder r7 = new Notification.Builder(ExportSimContacts.access$100(this.this$0), ExportSimContacts.EXPORT_SIM_CHANNEL_ID);
            r7.setAutoCancel(true).setTicker(r3).setContentTitle(r3).setSmallIcon(android.R.drawable.stat_sys_download).setContentIntent(PendingIntent.getActivity(ExportSimContacts.access$100(this.this$0), 0, r4, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING));
            ExportSimContacts.access$1000(this.this$0).notify(19, r7.build());
            ExportSimContacts.access$802(this.this$0, false);
            this.this$0.runOnUiThread(new AnonymousClass1(this, r3));
            return;
        L22:
            r3 = ExportSimContacts.access$100(this.this$0).getString(R.string.export_contacts_from_sim_finish);
            goto L23
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            this.mCanceled = true;
            ExportSimContacts.access$802(this.this$0, true);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-2)) goto L5;
            this.this$0.finish();
            this.mCanceled = true;
            ExportSimContacts.access$802(this.this$0, true);
            ExportSimContacts.access$1100(this.this$0).dismiss();
            return;
        L5:
            ExportSimContacts.log("Unknown button event has come: " + r2.toString());
        }
    }

    private class QueryThread extends Thread {
        public boolean isStoped;
        private ArrayList<Long> mContactsIds;
        private int mSimId;
        final /* synthetic */ ExportSimContacts this$0;

        public QueryThread(ExportSimContacts r1, ArrayList<Long> r2, int r3) {
            this.this$0 = r1;
            this.isStoped = false;
            if (r2 == null) goto L5;
            this.mContactsIds = r2;
        L6:
            this.mSimId = r3;
            return;
        L5:
            this.mContactsIds = new ArrayList();
            goto L6
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ExportSimContacts.log("QueryThread start run");
            ArrayList r2 = new ArrayList();
            Uri r9 = ContactsContract.Data.CONTENT_URI;
            ExportSimContacts.log("selection: contact_id = ? AND (mimetype = ? OR mimetype = ?)");
            String[] r11 = {"display_name", "mimetype", "data1"};
            Iterator<Long> r12 = this.mContactsIds.iterator();
        L4:
            if (r12.hasNext() == false) goto L41;
            long r3 = r12.next().longValue();
            if (this.isStoped == true) goto L41;
            ExportSimContacts.log("id: " + r3);
            String r17 = "vnd.android.cursor.item/email_v2";
            Cursor r4 = this.this$0.getContentResolver().query(r9, r11, "contact_id = ? AND (mimetype = ? OR mimetype = ?)", new String[]{String.valueOf(r3), "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2"}, null);
            ExportSimContacts.log("cur = " + r4);
            if (r4 == null) goto L4;
            ExportSimContacts.log("cor count: " + r4.getCount());
            if (r4.moveToFirst() == false) goto L33;
            ContactInfo r5 = new ContactInfo(this.this$0, null);     // Catch: Throwable -> L34 Exception -> L36
            r5.name = r4.getString(0);     // Catch: Throwable -> L34 Exception -> L36
        L14:
            String r6 = r4.getString(1);     // Catch: Throwable -> L34 Exception -> L36
            String r7 = r4.getString(2);     // Catch: Throwable -> L34 Exception -> L36
            if ("vnd.android.cursor.item/phone_v2".equals(r6) == true) goto L17;
            String r8 = r17;
            if (r8.equals(r6) == true) goto L26;
        L29:
            if (r4.moveToNext() == false) goto L30;
            r17 = r8;
            goto L14
        L30:
            r2.add(r5);     // Catch: Throwable -> L34 Exception -> L36
            goto L33
        L26:
            if (TextUtils.isEmpty(r5.email) == false) goto L29;
            r5.email = r7;     // Catch: Throwable -> L34 Exception -> L36
            goto L29
        L17:
            if (TextUtils.isEmpty(r5.number) == false) goto L21;
            r5.number = r7;     // Catch: Throwable -> L34 Exception -> L36
        L19:
            r8 = r17;
            goto L29
        L21:
            if (TextUtils.isEmpty(r5.anrNumber) == false) goto L19;
            r5.anrNumber = r7;     // Catch: Throwable -> L34 Exception -> L36
        L33:
            r4.close();
            goto L4
        L36:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            r4.close();
            throw th;
        L41:
            ExportSimContacts.access$002(this.this$0, r2);
            this.this$0.runOnUiThread(new AnonymousClass1(this));
        }
    }

    private class SimOpt {
        static final int OPT_DELETE = 2;
        static final int OPT_INSERT = 1;
        static final int OPT_UPDATE = 3;
        ContactInfo newInfo;
        ContactInfo oldInfo;
        int opt;
        int simId;
        final /* synthetic */ ExportSimContacts this$0;

        private SimOpt(ExportSimContacts r1) {
            this.this$0 = r1;
        }
    }

    public void com_android_contacts_vcard_ExportSimContacts__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_vcard_ExportSimContacts_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ExportSimContacts() {
        this.mStopImport = false;
        this.inBackground = false;
        this.mSimId = 0;
        this.mContactInfoList = new ArrayList();
        this.mSimStateReceiver = new AnonymousClass1(this);
        this.mOnCancelListener = new AnonymousClass3(this);
        this.mFinishListener = new AnonymousClass4(this);
    }

    static /* synthetic */ ArrayList access$000(ExportSimContacts r0) {
        return r0.mContactInfoList;
    }

    static /* synthetic */ ArrayList access$002(ExportSimContacts r0, ArrayList r1) {
        r0.mContactInfoList = r1;
        return r1;
    }

    static /* synthetic */ Context access$100(ExportSimContacts r0) {
        return r0.mContext;
    }

    static /* synthetic */ NotificationManager access$1000(ExportSimContacts r0) {
        return r0.mNotificationManager;
    }

    static /* synthetic */ AbstractDialog access$1100(ExportSimContacts r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ void access$1200(ExportSimContacts r0) {
        r0.closeAllDialog();
    }

    static /* synthetic */ void access$1300(ExportSimContacts r0) {
        r0.importAll();
    }

    static /* synthetic */ void access$1500(ExportSimContacts r0) {
        r0.queryComplete();
    }

    static /* synthetic */ boolean access$200(ExportSimContacts r0) {
        return r0.inBackground;
    }

    static /* synthetic */ NotificationManagerHelper access$300(ExportSimContacts r0) {
        return r0.mNotificationHelper;
    }

    static /* synthetic */ void access$400(ExportSimContacts r0, Notification.Builder r1, int r2, int r3) {
        r0.doProgressNotification(r1, r2, r3);
    }

    static /* synthetic */ int access$500(ExportSimContacts r0) {
        return r0.mSimId;
    }

    static /* synthetic */ void access$600(ExportSimContacts r0, ContactInfo r1, int r2) {
        r0.doExportOneSimContact(r1, r2);
    }

    static /* synthetic */ ProgressBodyController access$700(ExportSimContacts r0) {
        return r0.mProgressBodyController;
    }

    static /* synthetic */ boolean access$800(ExportSimContacts r0) {
        return r0.mStopImport;
    }

    static /* synthetic */ boolean access$802(ExportSimContacts r0, boolean r1) {
        r0.mStopImport = r1;
        return r1;
    }

    static /* synthetic */ void access$900(ExportSimContacts r0) {
        r0.resetState();
    }

    static {
        DBG = ContactsUtils.DEBUG;
    }

    private void doProgressNotification(Notification.Builder r7, int r8, int r9) {
        if (this.inBackground == true) goto L5;
        return;
    L5:
        r7.setOngoing(true).setOnlyAlertOnce(true).setProgress(r8, r9, false).setContentTitle(this.mContext.getString(R.string.exportingSimContacts)).setSmallIcon(R.drawable.contact_icon).setContentIntent(PendingIntent.getActivity(this.mContext, 0, new Intent(this.mContext, ExportSimContacts.class), 1140850688));
        if (r8 <= 0) goto L8;
        r7.setContentText(this.mContext.getString(R.string.percentage, new Object[]{String.valueOf((r9 * 100) / r8)}));
    L8:
        Notification r10 = r7.build();
        this.notification = r10;
        this.mNotificationManager.notify(19, r10);
    }

    private void doExportOneSimContact(ContactInfo r9, int r10) {
        log("mContext = " + this.mContext + ", info: " + r9 + " simId: " + r10);
        Uri r8 = MoreContactUtils.insertToCard(this.mContext, r9.name, r9.number, r9.email, r9.anrNumber, r10, ContactsUtils.FEATURE_SIM_PHONEBOOK);
        if (r8 != null) goto L5;
        log("insert sim contact failed, name: " + r9.name + ", number: " + r9.number);
        return;
    L5:
        log("insert contact success: " + r8);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        UiUtils.setWindowColorStatusBar(this);
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mNotificationManager.createNotificationChannel(new NotificationChannel(EXPORT_SIM_CHANNEL_ID, "Export To Sim", 3));
        this.mNotificationHelper = new NotificationManagerHelper();
        Intent r5 = getIntent();
        this.mContext = this;
        this.mState = -3;
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        this.mSimId = r5.getIntExtra(DSUtils.SUBSCRIPTION_KEY, 0);
    L5:
        ArrayList<Long> r6 = (ArrayList) r5.getExtra("com.android.contacts.extra.PHONE_IDS");
        log("contacts ids: " + r6);
        start(r6, this.mSimId);
        IntentFilter r7 = new IntentFilter();
        r7.addAction(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mSimStateReceiver, r7);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        setBackground(false);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        setBackground(true);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mSimStateReceiver);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent r2) {
        super.onNewIntent(r2);
        start(this.mContactIds, this.mSimId);
    }

    public void start(final ArrayList<Long> r3, final int r4) {
        new Handler().postDelayed(new AnonymousClass2(this, r3, r4), 500);
    }

    public void startInternal(ArrayList<Long> r3, int r4) {
        if (isAirplaneModeOn() == false) goto L6;
        showAirPlan();
        return;
    L6:
        this.mNotificationManager.cancel(19);
        this.inBackground = false;
        int r0 = this.mState;
        if (r0 != (-3)) goto L9;
        query(r3, r4);
        return;
    L9:
        if (r0 == 1) goto L17;
        if (r0 == 3) goto L14;
        log("eeeeeeeee-ExportSimContacts");
        return;
    L14:
        if (this.mProgressDialog.isShowing() == true) goto L22;
        this.mProgressDialog.show();
        return;
    L22:
        return;
    L17:
        if (this.mLoadingDialog.isShowing() == true) goto L24;
        this.mLoadingDialog.show();
        return;
    }

    private void resetState() {
        this.mState = -3;
    }

    public void stop() {
        closeAllDialog();
        resetState();
        QueryThread r0 = this.mQueryThread;
        if (r0 == null) goto L5;
        r0.isStoped = true;
    L5:
        ExportAllSimContactsThread r2 = this.mExportThread;
        if (r2 == null) goto L9;
        r2.mCanceled = true;
        return;
    }

    public void setBackground(boolean r2) {
        this.inBackground = r2;
        log("set background " + r2);
    }

    private void closeAllDialog() {
        ProgressDialog r0 = this.mLoadingDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        AbstractDialog r1 = this.mAskDialog;
        if (r1 == null) goto L8;
        r1.dismiss();
    L8:
        AbstractDialog r2 = this.mCommonDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
    L11:
        AbstractDialog r3 = this.mProgressDialog;
        if (r3 == null) goto L14;
        r3.dismiss();
    L14:
        finish();
    }

    private void query(ArrayList<Long> r4, int r5) {
        log("query: starting an async query: " + getQueryUri());
        QueryThread r0 = this.mQueryThread;
        if (r0 != null) goto L5;
    L8:
        QueryThread r1 = new QueryThread(this, r4, r5);
        this.mQueryThread = r1;
        r1.start();
        if (this.mLoadingDialog != null) goto L12;
        ProgressDialog r6 = new ProgressDialog(this.mContext);
        this.mLoadingDialog = r6;
        r6.setOnCancelListener(this.mOnCancelListener);
        this.mLoadingDialog.setMessage(this.mContext.getString(R.string.simContacts_dataLoading));
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
    L12:
        if (isFinishing() == false) goto L14;
    L16:
        this.mState = 1;
        return;
    L14:
        if (this.mLoadingDialog.isShowing() == true) goto L16;
        this.mLoadingDialog.show();
        goto L16
    L5:
        if (r0.isAlive() == false) goto L8;
    }

    private Uri getQueryUri() {
        Uri r0 = Uri.parse(SimContactsConstants.SIM_URI);
        if (DSUtils.isMultiSimEnabled() == true) goto L5;
        return r0;
    L5:
        return DSUtils.getSimContactsQueryUri(this.mSimId);
    }

    private void showAirPlan() {
        if (this.mAirPlanDialog != null) goto L6;
        OAlertDialog r0 = new OAlertDialogBuilder(this).title(getResources().getString(R.string.export_simContacts_airplaneMode), true).horizontalButton().positiveButton(android.R.string.ok, this.mFinishListener).build();
        this.mAirPlanDialog = r0;
        r0.setCancelable(true);
        this.mAirPlanDialog.setCanceledOnTouchOutside(true);
        this.mAirPlanDialog.setOnCancelListener(this.mOnCancelListener);
    L6:
        if (isFinishing() == true) goto L9;
        this.mAirPlanDialog.show();
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AnimationUtil.switchActivityAnimation(this, 0);
    }

    private void askImportOrNot(int r6) {
        if (isFinishing() == false) goto L6;
        log("Import Sim Contact Activity is finish.");
        return;
    L6:
        String r7 = this.mContext.getResources().getQuantityString(R.plurals.export_contacts_to_sim, r6, new Object[]{Integer.valueOf(r6)});
        if (this.mAskDialog != null) goto L9;
        OAlertDialog r8 = new OAlertDialogBuilder(this).title(r7, true).horizontalButton().positiveButton(android.R.string.ok, new AnonymousClass5(this)).negativeButton(android.R.string.cancel, this.mFinishListener).build();
        this.mAskDialog = r8;
        r8.setCancelable(true);
        this.mAskDialog.setCanceledOnTouchOutside(false);
        this.mAskDialog.setOnCancelListener(this.mOnCancelListener);
    L9:
        this.mAskDialog.show();
    }

    private boolean isAirplaneModeOn() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void queryComplete() {
        resetState();
        ProgressDialog r0 = this.mLoadingDialog;
        if (r0 != null) goto L5;
    L7:
        ArrayList<ContactInfo> r1 = this.mContactInfoList;
        if (r1 != null) goto L10;
    L13:
        OAlertDialogUtils.showConfirmationDialog(this, getString(R.string.export_simContacts_empty), null, getString(R.string.common_ok), new AnonymousClass6(this), null, getString(R.string.common_cancel), null, null);
        return;
    L10:
        if (r1.size() <= 0) goto L13;
        askImportOrNot(this.mContactInfoList.size());
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mLoadingDialog.dismiss();
        goto L7
    }

    private void importAll() {
        this.mContext.getString(R.string.simContacts_title);
        String r0 = this.mContext.getString(R.string.exportingSimContacts);
        this.mExportThread = new ExportAllSimContactsThread(this);
        if (this.mContactInfoList != null) goto L6;
        log("cursor is null. Ignore silently.");
        return;
    L6:
        ProgressBodyController r2 = new ProgressBodyController(this);
        this.mProgressBodyController = r2;
        r2.setProgress(this.mContactInfoList.size(), 0);
        OAlertDialog r1 = new OAlertDialogBuilder(this).title(R.string.simContacts_title).message(r0).body(this.mProgressBodyController).horizontalButton().negativeButton(android.R.string.cancel, this.mExportThread).build();
        this.mProgressDialog = r1;
        r1.setCanceledOnTouchOutside(false);
        this.mProgressDialog.setOnCancelListener(this.mExportThread);
        this.mProgressDialog.setOnDismissListener(new AnonymousClass7(this));
        this.mProgressDialog.show();
        this.mExportThread.start();
        this.mState = 3;
    }

    protected static void log(String r1) {
        if (DBG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, r1);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_ExportSimContacts_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ExportSimContacts r1) {
        r1.com_android_contacts_vcard_ExportSimContacts__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
