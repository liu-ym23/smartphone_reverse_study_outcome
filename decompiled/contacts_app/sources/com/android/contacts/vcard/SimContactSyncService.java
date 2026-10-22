package com.android.contacts.vcard;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.internal.telephony.IccCardConstants;
import com.obric.privacyhook.BaseIntentService;

/* JADX INFO: loaded from: classes2.dex */
public class SimContactSyncService extends BaseIntentService {
    private static final String[] COLUMN_NAMES = null;
    private static final Object LOCK = null;
    private static final int MSG_IMPORT = 10;
    private static final int MSG_REMOVE = 20;
    private static boolean[] sCanceled;
    private Handler mWorkHandler;
    private HandlerThread mWorkThread;

    private class SimContactWorkHandle extends Handler {
        final /* synthetic */ SimContactSyncService this$0;

        public SimContactWorkHandle(SimContactSyncService r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            SimContactSyncService.access$000("handleMessage, " + r4.what + " , threadId = " + Thread.currentThread().getId());
            Object r0 = SimContactSyncService.access$100();
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (10 != r4.what) goto L8;
            SimContactSyncService.access$200(this.this$0, r4.arg1);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L8:
            if (20 != r4.what) goto L10;
            SimContactSyncService.access$300(this.this$0, r4.arg1);     // Catch: Throwable -> L12
            goto L10
        }
    }

    static /* synthetic */ void access$000(String r0) {
        log(r0);
    }

    static /* synthetic */ Object access$100() {
        return LOCK;
    }

    static /* synthetic */ void access$200(SimContactSyncService r0, int r1) {
        r0.doImportSimContactsToDB(r1);
    }

    static /* synthetic */ void access$300(SimContactSyncService r0, int r1) {
        r0.doRemoveSimContactsFromDB(r1);
    }

    static {
        sCanceled = new boolean[2];
        LOCK = new Object();
        COLUMN_NAMES = new String[]{"name", "number", SimContactsConstants.STR_EMAILS, SimContactsConstants.STR_ANRS};
    }

    public SimContactSyncService() {
        super("ExportSimContactService");
    }

    private void stopImportExport(int r2) {
        log("stopImportExport simSlot = " + r2);
        if (r2 == (-1)) goto L6;
        sCanceled[r2] = true;
        return;
    }

    private void startImportSimContacts(int r3) {
        log("startImportSimContacts sim = " + r3);
        initWorkHandler();
        Message r0 = new Message();
        r0.arg1 = r3;
        r0.what = 10;
        this.mWorkHandler.sendMessage(r0);
    }

    private void startRemoveSimContacts(int r3) {
        log("startRemoveSimContacts sim = " + r3);
        initWorkHandler();
        Message r0 = new Message();
        r0.arg1 = r3;
        r0.what = 20;
        this.mWorkHandler.sendMessage(r0);
    }

    private void initWorkHandler() {
        log("initWorkHandler");
        if (this.mWorkThread != null) goto L6;
        this.mWorkThread = new HandlerThread("SimContactSyncService_WorkThread");
    L6:
        if (this.mWorkThread.isAlive() == true) goto L9;
        this.mWorkThread.start();
    L9:
        if (this.mWorkHandler != null) goto L12;
        this.mWorkHandler = new SimContactWorkHandle(this, this.mWorkThread.getLooper());
        return;
    }

    private void destroyWorkHandler() {
        log("destroyWorkHandler");
        HandlerThread r1 = this.mWorkThread;
        if (r1 == null) goto L6;
        r1.getLooper().quitSafely();
        return;
    }

    @Override // com.obric.privacyhook.BaseIntentService
    protected void handleAction(String r3, Intent r4) {
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == true) goto L5;
        return;
    L5:
        String r5 = r4.getStringExtra(IccCardConstants.INTENT_KEY_ICC_STATE);
        int r6 = r4.getIntExtra("slot", -1);
        if (IccCardConstants.INTENT_VALUE_ICC_LOADED.equals(r5) == false) goto L9;
        stopImportExport(r6);
        startImportSimContacts(r6);
        return;
    L9:
        if (IccCardConstants.INTENT_VALUE_ICC_ABSENT.equals(r5) == false) goto L13;
        stopImportExport(r6);
        startRemoveSimContacts(r6);
        return;
    }

    private void doImportSimContactsToDB(int r5) {
        log("start doImportSimContactsToDB sim = " + r5);
        int r1 = 0;
        if (r5 == (-1)) goto L6;
        sCanceled[r5] = false;
        doRemoveSimContactsFromDB(r5);
        importSimContactsToDB(r5);
        log("finish doImportSimContactsToDB sim = " + r5);
        return;
    L6:
        boolean[] r6 = sCanceled;
        r6[0] = false;
        r6[1] = false;
        doRemoveSimContactsFromDB();
        int[] r0 = {0, 1};
    L7:
        if (r1 >= 2) goto L12;
        int r2 = r0[r1];
        if (sCanceled[r2] == true) goto L10;
        importSimContactsToDB(r2);
        r1 = r1 + 1;
        goto L7
    L10:
        return;
    L12:
        log("finish doImportSimContactsToDB sim");
    }

    private void importSimContactsToDB(int r8) {
        ContentResolver r7 = getContentResolver();
        if (DSUtils.isSimEnable(r8) == true) goto L6;
        log("the sim " + r8 + " is invalid.");
        return;
    L6:
        Cursor r1 = r7.query(DSUtils.getSimContactsQueryUri(r8), COLUMN_NAMES, null, null, null);
        if (r1 != null) goto L30;
        return;
    L30:
        log("sim " + r8 + " has contacts " + r1.getCount() + ",  support email and anr ? " + MoreContactUtils.canSaveEmail(r8));     // Catch: Throwable -> L22 Exception -> L24
        r1.moveToPosition(-1);     // Catch: Throwable -> L22 Exception -> L24
    L10:
        if (r1.moveToNext() == false) goto L26;
        if (sCanceled[r8] == true) goto L14;
        String[] r2 = new String[4];     // Catch: Throwable -> L22 Exception -> L24
        int r3 = 0;
    L18:
        if (r3 >= 4) goto L20;
        r2[r3] = r1.getString(r3);     // Catch: Throwable -> L22 Exception -> L24
        r3 = r3 + 1;     // Catch: Throwable -> L22 Exception -> L24
        goto L18
    L20:
        MoreContactUtils.insertToPhone(r2, r7, r8);     // Catch: Throwable -> L22 Exception -> L24
        goto L10
    L14:
        r1.close();
        return;
    L26:
        r1.close();
        return;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r1.close();
        throw th;
    }

    private void doRemoveSimContactsFromDB() {
        log("doRemoveSimContactsFromDB");
        doRemoveSimContactsFromDB(-1);
    }

    private void doRemoveSimContactsFromDB(int r3) {
        log("doRemoveSimContactsFromDB sim = " + r3);
        if (r3 == (-1)) goto L5;
        String r4 = "account_type=? AND account_name = '" + MoreContactUtils.getSimAccountName(r3) + "'";
    L6:
        getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, r4, new String[]{"com.android.sim"});
        return;
    L5:
        r4 = "account_type=?";
        goto L6
    }

    @Override // com.obric.privacyhook.BaseIntentService, android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        destroyWorkHandler();
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("SimContactSyncService", r1);
        return;
    }
}
