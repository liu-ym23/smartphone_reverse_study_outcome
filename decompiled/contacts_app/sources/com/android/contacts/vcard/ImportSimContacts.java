package com.android.contacts.vcard;

import android.accounts.Account;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AccountSelectionMenuDialog;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.NotificationManagerHelper;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.ProgressDialog;
import com.android.internal.telephony.TelephonyIntents;
import com.android.vcard.VCardConfig;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ImportSimContacts extends Activity {
    public static final String CONTACT_ADDED_TIME_MIMETYPE = "vnd.android.cursor.item/added_time";
    private static final boolean DBG = false;
    protected static final int DELETE_TOKEN = 3;
    public static final String EXTRA_ACCOUNT = "account";
    private static final String IMPORT_SIM_CHANNEL_ID = "import_sim_channel";
    protected static final int INSERT_TOKEN = 1;
    private static final String KEY_ANRS_1 = "anrs";
    private static final String KEY_ANRS_2 = "additionalNumber";
    private static final String KEY_EMAIL = "emails";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";
    private static final String LOG_TAG = "ImportSimContacts";
    private static final int NOTIFICATION_ID = 18;
    protected static final int QUERY_TOKEN = 0;
    protected static final int STATE_IMPORT_ERROR = -2;
    protected static final int STATE_IMPORT_FINISH = 4;
    protected static final int STATE_IMPORT_ING = 3;
    protected static final int STATE_NA = -3;
    protected static final int STATE_QUERY_ERROR = -1;
    protected static final int STATE_QUERY_FINISH = 2;
    protected static final int STATE_QUERY_ING = 1;
    private static final String TAG = "ImportSimContacts";
    protected static final int UPDATE_TOKEN = 2;
    static final ContentValues sEmptyContentValues = null;
    private boolean allowJoin;
    private boolean inBackground;
    private Account mAccount;
    private AbstractDialog mAirPlanDialog;
    private AbstractDialog mAskDialog;
    private AbstractDialog mAskJoinDialog;
    private OAlertDialogBuilder mCommonBuilder;
    private AbstractDialog mCommonDialog;
    private Context mContext;
    protected Cursor mCursor;
    private DialogInterface.OnClickListener mFinishListener;
    private DialogInterface.OnClickListener mJoinListener;
    private ProgressDialog mLoadingDialog;
    private NotificationManagerHelper mNotificationHelper;
    private NotificationManager mNotificationManager;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private ProgressBodyController mProgressBodyController;
    private AbstractDialog mProgressDialog;
    protected QueryHandler mQueryHandler;
    private int mSimId;
    BroadcastReceiver mSimStateReceiver;
    private int mState;
    private boolean mStopImport;
    private Notification notification;
    private ImportAllSimContactsThread thread;

    private class ImportAllSimContactsThread extends Thread implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
        protected boolean mCanceled;
        final /* synthetic */ ImportSimContacts this$0;

        public ImportAllSimContactsThread(ImportSimContacts r1) {
            this.this$0 = r1;
            super("ImportAllSimContactsThread");
            this.mCanceled = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ContentResolver r0 = ImportSimContacts.access$000(this.this$0).getContentResolver();
            if (this.mCanceled == false) goto L6;
            ImportSimContacts.access$100(this.this$0);
            return;
        L6:
            this.this$0.mCursor.moveToPosition(-1);
            int r1 = this.this$0.mCursor.getCount();
            Notification.Builder r2 = new Notification.Builder(ImportSimContacts.access$000(this.this$0), ImportSimContacts.IMPORT_SIM_CHANNEL_ID);
            int r5 = 0;
        L8:
            if (this.this$0.mCursor == null) goto L26;
            if (this.this$0.mCursor.moveToNext() == false) goto L26;
            if (ImportSimContacts.access$200(this.this$0) == true) goto L26;
            r5 = r5 + 1;
            if (ImportSimContacts.access$300(this.this$0) == true) goto L16;
        L18:
            ImportSimContacts.actuallyImportOneSimContact(this.this$0.mCursor, r0, ImportSimContacts.access$600(this.this$0), ImportSimContacts.access$700(this.this$0));
            if (ImportSimContacts.access$800(this.this$0) == null) goto L22;
            ImportSimContacts.access$800(this.this$0).incrementProgressBy(1);
        L22:
            if (this.mCanceled == false) goto L8;
            ImportSimContacts.access$100(this.this$0);
            ImportSimContacts.access$900(this.this$0).cancel(18);
            return;
        L16:
            if (ImportSimContacts.access$400(this.this$0).shouldNotifyNotificationLimit() == false) goto L18;
            ImportSimContacts.access$500(this.this$0, r2, r1, r5);
        L26:
            if (ImportSimContacts.access$200(this.this$0) == false) goto L28;
            final String r3 = ImportSimContacts.access$000(this.this$0).getString(R.string.import_contacts_from_sim_canceled);
        L29:
            ImportSimContacts.access$1000(this.this$0);
            Intent r4 = new Intent("android.intent.action.VIEW", ContactsContract.Contacts.CONTENT_URI);
            r4.setPackage("com.android.contacts");
            Notification.Builder r6 = new Notification.Builder(ImportSimContacts.access$000(this.this$0), ImportSimContacts.IMPORT_SIM_CHANNEL_ID);
            r6.setAutoCancel(true).setTicker(r3).setContentTitle(r3).setSmallIcon(android.R.drawable.stat_sys_download).setContentIntent(PendingIntent.getActivity(ImportSimContacts.access$000(this.this$0), 0, r4, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING));
            ImportSimContacts.access$900(this.this$0).notify(18, r6.build());
            ImportSimContacts.access$202(this.this$0, false);
            this.this$0.runOnUiThread(new AnonymousClass1(this, r3));
            return;
        L28:
            r3 = ImportSimContacts.access$000(this.this$0).getString(R.string.import_contacts_from_sim_finish);
            goto L29
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            this.mCanceled = true;
            ImportSimContacts.access$202(this.this$0, true);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-2)) goto L5;
            this.this$0.finish();
            this.mCanceled = true;
            ImportSimContacts.access$202(this.this$0, true);
            ImportSimContacts.access$1100(this.this$0).dismiss();
            return;
        L5:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ImportSimContacts", "Unknown button event has come: " + r2.toString());
        }
    }

    private static class NamePhoneTypePair {
        final String name;
        final int phoneType;

        public NamePhoneTypePair(String r6) {
            int r0 = r6.length();
            int r1 = r0 - 2;
            if (r1 >= 0) goto L5;
        L20:
            this.phoneType = 7;
            this.name = r6;
            return;
        L5:
            if (r6.charAt(r1) != '/') goto L20;
            char r2 = Character.toUpperCase(r6.charAt(r0 - 1));
            if (r2 != 'W') goto L10;
            this.phoneType = 3;
        L19:
            this.name = r6.substring(0, r1);
            return;
        L10:
            if (r2 != 'M') goto L12;
        L18:
            this.phoneType = 2;
            goto L19
        L12:
            if (r2 == 'O') goto L18;
            if (r2 != 'H') goto L17;
            this.phoneType = 1;
            goto L19
        L17:
            this.phoneType = 7;
            goto L19
        }
    }

    private class QueryHandler extends AsyncQueryHandler {
        protected boolean isStoped;
        final /* synthetic */ ImportSimContacts this$0;

        public QueryHandler(ImportSimContacts r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
            this.isStoped = false;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            if (this.isStoped == false) goto L5;
            return;
        L5:
            ImportSimContacts.access$1500(this.this$0, r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int r1, Object r2, Uri r3) {
            ImportSimContacts.log("onInsertComplete: requery");
            ImportSimContacts.access$1600(this.this$0);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onUpdateComplete(int r1, Object r2, int r3) {
            ImportSimContacts.log("onUpdateComplete: requery");
            ImportSimContacts.access$1600(this.this$0);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int r1, Object r2, int r3) {
            ImportSimContacts.log("onDeleteComplete: requery");
            ImportSimContacts.access$1600(this.this$0);
        }
    }

    public void com_android_contacts_vcard_ImportSimContacts__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_vcard_ImportSimContacts_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ImportSimContacts() {
        this.mCursor = null;
        this.mStopImport = false;
        this.inBackground = false;
        this.mSimId = 0;
        this.allowJoin = true;
        this.mSimStateReceiver = new AnonymousClass1(this);
        this.mOnCancelListener = new AnonymousClass2(this);
        this.mFinishListener = new AnonymousClass3(this);
        this.mJoinListener = new AnonymousClass5(this);
    }

    static /* synthetic */ Context access$000(ImportSimContacts r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$100(ImportSimContacts r0) {
        r0.releaseCursor();
    }

    static /* synthetic */ void access$1000(ImportSimContacts r0) {
        r0.resetState();
    }

    static /* synthetic */ AbstractDialog access$1100(ImportSimContacts r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ void access$1200(ImportSimContacts r0) {
        r0.closeAllDialog();
    }

    static /* synthetic */ void access$1300(ImportSimContacts r0, int r1) {
        r0.askJoinOrNot(r1);
    }

    static /* synthetic */ void access$1400(ImportSimContacts r0) {
        r0.importAll();
    }

    static /* synthetic */ void access$1500(ImportSimContacts r0, Cursor r1) {
        r0.processQueryResult(r1);
    }

    static /* synthetic */ void access$1600(ImportSimContacts r0) {
        r0.reQuery();
    }

    static /* synthetic */ void access$1700(ImportSimContacts r0) {
        r0.importAllInternal();
    }

    static /* synthetic */ boolean access$200(ImportSimContacts r0) {
        return r0.mStopImport;
    }

    static /* synthetic */ boolean access$202(ImportSimContacts r0, boolean r1) {
        r0.mStopImport = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300(ImportSimContacts r0) {
        return r0.inBackground;
    }

    static /* synthetic */ NotificationManagerHelper access$400(ImportSimContacts r0) {
        return r0.mNotificationHelper;
    }

    static /* synthetic */ void access$500(ImportSimContacts r0, Notification.Builder r1, int r2, int r3) {
        r0.doProgressNotification(r1, r2, r3);
    }

    static /* synthetic */ Account access$600(ImportSimContacts r0) {
        return r0.mAccount;
    }

    static /* synthetic */ Account access$602(ImportSimContacts r0, Account r1) {
        r0.mAccount = r1;
        return r1;
    }

    static /* synthetic */ boolean access$700(ImportSimContacts r0) {
        return r0.allowJoin;
    }

    static /* synthetic */ boolean access$702(ImportSimContacts r0, boolean r1) {
        r0.allowJoin = r1;
        return r1;
    }

    static /* synthetic */ ProgressBodyController access$800(ImportSimContacts r0) {
        return r0.mProgressBodyController;
    }

    static /* synthetic */ NotificationManager access$900(ImportSimContacts r0) {
        return r0.mNotificationManager;
    }

    static {
        DBG = ContactsUtils.DEBUG;
        sEmptyContentValues = new ContentValues();
    }

    private void doProgressNotification(Notification.Builder r7, int r8, int r9) {
        if (this.inBackground == true) goto L5;
        return;
    L5:
        r7.setOngoing(true).setOnlyAlertOnce(true).setProgress(r8, r9, false).setContentTitle(this.mContext.getString(R.string.importingSimContacts)).setSmallIcon(R.drawable.contact_icon).setContentIntent(PendingIntent.getActivity(this.mContext, 0, new Intent(this.mContext, ImportSimContacts.class), 1107296256));
        if (r8 <= 0) goto L8;
        r7.setContentText(this.mContext.getString(R.string.percentage, new Object[]{String.valueOf((r9 * 100) / r8)}));
    L8:
        Notification r10 = r7.build();
        this.notification = r10;
        this.mNotificationManager.notify(18, r10);
    }

    private void releaseCursor() {
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isClosed() == true) goto L9;
        log("releaseCursor");
        this.mCursor.close();
        this.mCursor = null;
        return;
    }

    public static void actuallyImportOneSimContact(Cursor r17, ContentResolver r18, Account r19, boolean r20) {
        int r4 = r17.getColumnIndex("name");
        String r5 = r17.getString(r4);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        NamePhoneTypePair r6 = new NamePhoneTypePair(r5);
        String r7 = r6.name;
        int r8 = r6.phoneType;
        String r9 = r17.getString(r17.getColumnIndex("number"));
        int r10 = r17.getColumnIndex("anrs");
        if (r10 >= 0) goto L8;
        r10 = r17.getColumnIndex(KEY_ANRS_2);
    L8:
        String[] r11 = null;
        if (r10 < 0) goto L11;
        String r12 = r17.getString(r10);
    L12:
        String r13 = r17.getString(r17.getColumnIndex("emails"));
        log("actuallyImportOneSimContact, name = " + r17.getString(r4) + ", phoneNumber = " + r9 + ", anrsString = " + r12 + ", emailAddresses = " + r13);
        if (TextUtils.isEmpty(r13) == true) goto L15;
        String[] r0 = r13.split(SimContactsConstants.EMAIL_SEP);
    L17:
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r11 = r12.split(SimContactsConstants.ANR_SEP);
    L19:
        ArrayList<ContentProviderOperation> r14 = new ArrayList();
        ContentProviderOperation.Builder r15 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        if (r20 == true) goto L22;
        r15.withValue("aggregation_mode", 3);
    L22:
        if (r19 == null) goto L24;
        r15.withValue("account_name", r19.name);
        r15.withValue("account_type", r19.type);
    L25:
        r14.add(r15.build());
        ContentProviderOperation.Builder r1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        int r16 = 0;
        r1.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r1.withValue("mimetype", "vnd.android.cursor.item/name");
        r1.withValue("data1", r7);
        r14.add(r1.build());
        if (r9 != null) goto L28;
    L30:
        if (r11 == null) goto L40;
        int r21 = r11.length;
        int r110 = 0;
    L32:
        if (r110 >= r21) goto L40;
        String r111 = r11[r110];
        if (r111 == null) goto L39;
        if (TextUtils.isEmpty(r111.trim()) == true) goto L39;
        ContentProviderOperation.Builder r112 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r112.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r16);
        r112.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        r112.withValue(DBHelper.COL_DATA2, Integer.valueOf(r8));
        r112.withValue("data1", r111);
        r14.add(r112.build());
    L39:
        r110 = r110 + 1;
        r16 = 0;
    L40:
        if (r0 == null) goto L58;
        int r2 = r0.length;
        int r22 = 0;
    L42:
        if (r22 >= r2) goto L58;
        String r23 = r0[r22];
        if (r23 == null) goto L49;
        if (TextUtils.isEmpty(r23.trim()) == true) goto L49;
        ContentProviderOperation.Builder r24 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r24.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r24.withValue("mimetype", "vnd.android.cursor.item/email_v2");
        r24.withValue(DBHelper.COL_DATA2, 4);
        r24.withValue("data1", r23);
        r14.add(r24.build());
    L49:
        r22 = r22 + 1;
    L58:
        r18.applyBatch("com.android.contacts", r14);     // Catch: OperationApplicationException -> L53 RemoteException -> L55
    L69:
        return;
    L53:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ImportSimContacts", String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return;
    L55:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ImportSimContacts", String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return;
    L28:
        if (TextUtils.isEmpty(r9.trim()) == true) goto L30;
        ContentProviderOperation.Builder r113 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r113.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, 0);
        r113.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        r113.withValue(DBHelper.COL_DATA2, Integer.valueOf(r8));
        r113.withValue("data1", r9);
        r113.withValue("is_primary", 1);
        r14.add(r113.build());
        goto L30
    L24:
        r15.withValues(sEmptyContentValues);
        goto L25
    L15:
        r0 = null;
        goto L17
    L11:
        r12 = null;
        goto L12
    }

    private static ContentProviderOperation getAddTimeValues(int r3) {
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r0.withValue("data1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        r0.withValue(DBHelper.COL_DATA2, "0");
        r0.withValue(DBHelper.COL_DATA3, "added time");
        r0.withValue(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, String.valueOf(System.currentTimeMillis()));
        r0.withValue("is_primary", 0);
        r0.withValue("is_super_primary", 0);
        r0.withValue("data_version", 0);
        r0.withValue("mimetype", "vnd.android.cursor.item/added_time");
        r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r3);
        return r0.build();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        UiUtils.setWindowColorStatusBar(this);
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        NotificationChannel r5 = new NotificationChannel(IMPORT_SIM_CHANNEL_ID, "Import From Sim", 3);
        this.mNotificationManager.createNotificationChannel(r5);
        this.mNotificationHelper = new NotificationManagerHelper();
        Intent r6 = getIntent();
        this.mContext = this;
        this.mState = -3;
        this.mAccount = (Account) r6.getParcelableExtra(EXTRA_ACCOUNT);
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        this.mSimId = r6.getIntExtra(DSUtils.SUBSCRIPTION_KEY, 0);
    L5:
        this.mQueryHandler = new QueryHandler(this, this.mContext.getContentResolver());
        start();
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
        stop();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        start();
    }

    private void start() {
        if (isAirplaneModeOn() == false) goto L6;
        showAirPlan();
        return;
    L6:
        this.mNotificationManager.cancel(18);
        this.inBackground = false;
        int r0 = this.mState;
        if (r0 != (-3)) goto L9;
        query();
        return;
    L9:
        if (r0 == 1) goto L17;
        if (r0 == 3) goto L14;
        log("eeeeeeeee");
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

    private void stop() {
        log("stop");
        closeAllDialog();
        resetState();
        QueryHandler r0 = this.mQueryHandler;
        if (r0 == null) goto L5;
        r0.isStoped = true;
    L5:
        ImportAllSimContactsThread r1 = this.thread;
        if (r1 == null) goto L8;
        r1.mCanceled = true;
    L8:
        ImportAllSimContactsThread r2 = this.thread;
        if (r2 != null) goto L11;
    L12:
        releaseCursor();
        return;
    L11:
        if (r2.isAlive() == false) goto L12;
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
        AbstractDialog r4 = this.mAskJoinDialog;
        if (r4 == null) goto L17;
        r4.dismiss();
    L17:
        finish();
    }

    private void query() {
        Uri r3 = getQueryUri();
        log("query: starting an async query: " + r3);
        this.mQueryHandler.startQuery(0, null, r3, null, null, null, null);
        if (this.mLoadingDialog != null) goto L6;
        ProgressDialog r0 = new ProgressDialog(this.mContext);
        this.mLoadingDialog = r0;
        r0.setOnCancelListener(this.mOnCancelListener);
        this.mLoadingDialog.setMessage(this.mContext.getString(R.string.simContacts_emptyLoading));
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
    L6:
        if (isFinishing() == true) goto L8;
        this.mLoadingDialog.show();
    L8:
        this.mState = 1;
    }

    private Uri getQueryUri() {
        Uri r0 = Uri.parse(SimContactsConstants.SIM_URI);
        if (DSUtils.isMultiSimEnabled() == true) goto L5;
        return r0;
    L5:
        return DSUtils.getSimContactsQueryUri(this.mSimId);
    }

    private void reQuery() {
        query();
    }

    private void showAirPlan() {
        if (this.mAirPlanDialog != null) goto L6;
        OAlertDialog r0 = new OAlertDialogBuilder(this).title(getResources().getString(R.string.simContacts_airplaneMode), true).horizontalButton().positiveButton(android.R.string.ok, this.mFinishListener).build();
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

    private void showCommonAlert(int r4) {
        AbstractDialog r0 = this.mCommonDialog;
        if (r0 != null) goto L5;
    L11:
        OAlertDialogBuilder r5 = new OAlertDialogBuilder(this).title(getResources().getString(r4), false).positiveButton(android.R.string.ok, this.mFinishListener).negativeButton(android.R.string.cancel, this.mFinishListener);
        this.mCommonBuilder = r5;
        OAlertDialog r6 = r5.build();
        this.mCommonDialog = r6;
        r6.setCancelable(true);
        this.mCommonDialog.setCanceledOnTouchOutside(true);
        this.mCommonDialog.setOnCancelListener(this.mOnCancelListener);
    L13:
        if (isFinishing() == true) goto L16;
        this.mCommonDialog.show();
        return;
    L16:
        return;
    L5:
        if (this.mCommonBuilder == null) goto L11;
        if (r0.isShowing() == false) goto L10;
        this.mCommonDialog.dismiss();
    L10:
        this.mCommonBuilder.title(getResources().getString(r4), true);
        this.mCommonDialog = this.mCommonBuilder.build();
        goto L13
    }

    private void askImportOrNot(final int r6) {
        if (isFinishing() == true) goto L5;
        String r0 = this.mContext.getResources().getQuantityString(R.plurals.import_contacts_from_sim, r6, new Object[]{Integer.valueOf(r6)});
        if (this.mAskDialog != null) goto L11;
        OAlertDialog r7 = new OAlertDialogBuilder(this).title(r0, true).horizontalButton().positiveButton(android.R.string.ok, new AnonymousClass4(this, r6)).negativeButton(android.R.string.cancel, this.mFinishListener).build();
        this.mAskDialog = r7;
        r7.setCancelable(true);
        this.mAskDialog.setCanceledOnTouchOutside(false);
        this.mAskDialog.setOnCancelListener(this.mOnCancelListener);
    L11:
        this.mAskDialog.show();
        return;
    L5:
        if (ContactsUtils.DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ImportSimContacts", "Import Sim Contact Activity is finish.");
        return;
    }

    private void askJoinOrNot(int r3) {
        if (isFinishing() == false) goto L9;
        if (ContactsUtils.DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ImportSimContacts", "Import Sim Contact Activity is finish.");
        return;
    L13:
        return;
    L9:
        if (this.mAskJoinDialog != null) goto L11;
        OAlertDialog r4 = new OAlertDialogBuilder(this).title(R.string.common_merge_contacts).message(R.string.import_join_contacts_hint).horizontalButton().positiveButton(R.string.import_not_join, this.mJoinListener).negativeButton(R.string.common_merge, this.mJoinListener).build();
        this.mAskJoinDialog = r4;
        r4.setCancelable(true);
        this.mAskJoinDialog.setCanceledOnTouchOutside(false);
        this.mAskJoinDialog.setOnCancelListener(this.mOnCancelListener);
    L11:
        this.mAskJoinDialog.show();
    }

    private boolean isAirplaneModeOn() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void processQueryResult(Cursor r3) {
        resetState();
        ProgressDialog r0 = this.mLoadingDialog;
        if (r0 != null) goto L5;
    L7:
        if (r3 == null) goto L9;
        log("cursor " + r3 + " cursor.getCount()  " + r3.getCount());
    L10:
        if (r3 != null) goto L12;
    L15:
        if (r3 == null) goto L17;
        r3.close();
    L17:
        showCommonAlert(R.string.simContacts_empty);
        return;
    L12:
        if (r3.getCount() <= 0) goto L15;
        this.mCursor = r3;
        askImportOrNot(r3.getCount());
        return;
    L9:
        log("cursor is null");
        goto L10
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mLoadingDialog.dismiss();
        goto L7
    }

    private void importAll() {
        if (this.mAccount != null) goto L10;
        List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(this.mContext).getAccounts(true);
        int r2 = r0.size();
        if (r2 <= 1) goto L7;
        ((AccountSelectionMenuDialog) AccountSelectionUtil.getSelectAccountDialog(this.mContext, R.string.select_import_account_prompt, new AnonymousClass6(this), new AnonymousClass7(this))).show();
        return;
    L7:
        if (r2 != 1) goto L9;
        this.mAccount = r0.get(0);
        importAllInternal();
        return;
    L9:
        importAllInternal();
        return;
    L10:
        importAllInternal();
    }

    private void importAllInternal() {
        this.mContext.getString(R.string.simContacts_title);
        String r0 = this.mContext.getString(R.string.importingSimContacts);
        this.thread = new ImportAllSimContactsThread(this);
        if (this.mCursor != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ImportSimContacts", "cursor is null. Ignore silently.");
        return;
    L6:
        ProgressBodyController r2 = new ProgressBodyController(this);
        this.mProgressBodyController = r2;
        r2.setProgress(this.mCursor.getCount(), 0);
        com.obric.oui.dialog.alert.OAlertDialog r1 = new com.obric.oui.dialog.alert.OAlertDialogBuilder(this).title(R.string.simContacts_title).message(r0).body(this.mProgressBodyController).horizontalButton().negativeButton(android.R.string.cancel, this.thread).build();
        this.mProgressDialog = r1;
        r1.setCanceledOnTouchOutside(false);
        this.mProgressDialog.setOnCancelListener(this.thread);
        this.mProgressDialog.setOnDismissListener(new AnonymousClass8(this));
        this.mProgressDialog.show();
        this.thread.start();
        this.mState = 3;
    }

    protected static void log(String r1) {
        if (DBG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ImportSimContacts", r1);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_ImportSimContacts_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ImportSimContacts r1) {
        r1.com_android_contacts_vcard_ImportSimContacts__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
