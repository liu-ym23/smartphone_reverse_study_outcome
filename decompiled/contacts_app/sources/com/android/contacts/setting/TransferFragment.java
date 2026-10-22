package com.android.contacts.setting;

import android.app.Activity;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityModifier;
import com.android.contacts.util.ContactLocaleUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.widget.CustomProgressDialog;
import com.android.vcard.VCardConfig;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class TransferFragment extends Fragment {
    public static final int COPY = 0;
    public static final String FRAGMENT_TAG = "TransferFragment";
    private static final int NOTIFICATION_ID = 20;
    private static final String TAG = "TransferFragment";
    public static final int TRANSFER = 1;
    private static final String TRANSFER_CHANNEL_ID = "transfer_channel";
    private final String BASE_SELECTION;
    private boolean inBackground;
    private AccountWithDataSet mExportAccount;
    private AccountWithDataSet mImportAccount;
    private NotificationManager mNotificationManager;
    private int mOperation;
    private CustomProgressDialog mProgressDialog;
    private boolean mStopExport;
    private ArrayList<Long> mTransferRawContactsIds;
    private volatile boolean mTransferStarted;
    private Notification notification;
    private TransferRawContactsThread thread;

    public interface TransferCompletedCallback {
        void transferCompleted(String r1);
    }

    private class TransferRawContactsThread extends Thread implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        private Context mContext;
        private AtomicInteger mCurrentCount;
        private boolean mDeleteSrc;
        final /* synthetic */ TransferFragment this$0;

        public TransferRawContactsThread(TransferFragment r2, Context r3, boolean r4) {
            this.this$0 = r2;
            super("TransferRawContactsThread");
            this.mCurrentCount = new AtomicInteger(0);
            this.mContext = r3;
            this.mDeleteSrc = r4;
        }

        public boolean isCopying() {
            return !this.mDeleteSrc;
        }

        public int getCurrentCount() {
            return this.mCurrentCount.get();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (TransferFragment.access$000(this.this$0) != null) goto L5;
        L53:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("TransferFragment", "mImportAccount or mContext is null");
            return;
        L5:
            if (this.mContext == null) goto L53;
            if (ContactsUtils.DEBUG == false) goto L11;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("TransferFragment", "Begin Export, mDeleteSrc = " + this.mDeleteSrc);
        L11:
            if (TextUtils.isEmpty(TransferFragment.access$000(this.this$0).dataSet) == false) goto L13;
            String[] r0 = {TransferFragment.access$000(this.this$0).name, TransferFragment.access$000(this.this$0).type};
            String r2 = "deleted != 1 AND account_name = ? AND account_type = ? AND data_set IS NULL";
        L14:
            Cursor r1 = this.mContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, r2, r0, null);
            int r3 = TransferFragment.access$100(this.this$0).size();
            this.mCurrentCount.set(0);
            Notification.Builder r5 = new Notification.Builder(this.mContext, TransferFragment.TRANSFER_CHANNEL_ID);
            if (r1 == null) goto L38;
        L55:
            if (r1.moveToNext() == false) goto L33;
            if (TransferFragment.access$200(this.this$0) == true) goto L33;
            String r6 = r1.getString(0);     // Catch: Throwable -> L34
        L28:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L34
            if (ContactsUtils.DEBUG == false) goto L55;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("TransferFragment", "Exception occurred when exporting rawContact: " + r6);     // Catch: Throwable -> L34
            goto L55
        L23:
            if (TransferFragment.access$100(this.this$0).contains(Long.valueOf(Long.parseLong(r6))) == false) goto L55;
            exportRawContact(r6);     // Catch: Exception -> L28 Throwable -> L34
            TransferFragment.access$300(this.this$0).incrementProgressBy(1);     // Catch: Exception -> L28 Throwable -> L34
            this.mCurrentCount.incrementAndGet();     // Catch: Exception -> L28 Throwable -> L34
            if (TransferFragment.access$400(this.this$0) == false) goto L55;
            TransferFragment.access$500(this.this$0, r5, r3, this.mCurrentCount.get(), this.mDeleteSrc);     // Catch: Exception -> L28 Throwable -> L34
        L33:
            r1.close();
        L34:
            th = move-exception;
            r1.close();
            throw th;
        L38:
            if (TransferFragment.access$200(this.this$0) == false) goto L42;
            String r4 = this.mContext.getString(R.string.copy_raw_contacts_canceled);
            if (this.mDeleteSrc == false) goto L45;
            r4 = this.mContext.getString(R.string.transfer_raw_contacts_canceled);
        L45:
            Intent r7 = new Intent("android.intent.action.VIEW", ContactsContract.Contacts.CONTENT_URI);
            r7.setPackage("com.android.contacts");
            Notification.Builder r8 = new Notification.Builder(this.mContext, TransferFragment.TRANSFER_CHANNEL_ID);
            r8.setAutoCancel(true).setTicker(r4).setContentTitle(r4).setSmallIcon(android.R.drawable.stat_sys_download).setContentIntent(PendingIntent.getActivity(this.mContext, 0, r7, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING));
            TransferFragment.access$600(this.this$0).notify(20, r8.build());
            if (ContactsUtils.DEBUG == false) goto L48;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("TransferFragment", "Finish Export");
        L48:
            TransferFragment.access$202(this.this$0, false);
            TransferFragment.access$300(this.this$0).dismiss();
            Object r9 = this.mContext;
            if ((r9 instanceof TransferCompletedCallback) == false) goto L51;
            ((TransferCompletedCallback) r9).transferCompleted(r4);
        L51:
            TransferFragment.access$702(this.this$0, false);
            return;
        L42:
            r4 = this.this$0.getResources().getQuantityString(R.plurals.copy_raw_contacts_finished, r3, new Object[]{Integer.valueOf(r3)});
            if (this.mDeleteSrc == false) goto L45;
            r4 = this.this$0.getResources().getQuantityString(R.plurals.transfer_raw_contacts_finished, r3, new Object[]{Integer.valueOf(r3)});
            goto L45
        L13:
            r0 = new String[]{TransferFragment.access$000(this.this$0).name, TransferFragment.access$000(this.this$0).type, TransferFragment.access$000(this.this$0).dataSet};
            r2 = "deleted != 1 AND account_name = ? AND account_type = ? AND data_set = ?";
            goto L14
        }

        private void exportRawContact(String r18) {
            if (TransferFragment.access$800(this.this$0) != null) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("TransferFragment", "mExportAccount is null");
            return;
        L6:
            EntityIterator r16 = null;
            EntityIterator r17 = ContactsContract.RawContacts.newEntityIterator(this.mContext.getContentResolver().query(ContactsContract.RawContactsEntity.CONTENT_URI, null, "_id=?", new String[]{r18}, null));     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (r17 != null) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TransferFragment", "EntityIterator is null");     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (r17 == null) goto L76;
            r17.close();
            return;
        L76:
            return;
        L14:
            if (r17.hasNext() == true) goto L20;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("TransferFragment", "Data does not exist. raw_contact_id: " + r18);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (r17 == null) goto L77;
            r17.close();
            return;
        L77:
            return;
        L20:
            if (this.mDeleteSrc == false) goto L22;
            removeRawContact(r18);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
        L22:
            ArrayList<ContentProviderOperation> r1 = new ArrayList();     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            int r5 = r1.size();     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            ContentProviderOperation.Builder r8 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            r8.withValue("account_name", TransferFragment.access$800(this.this$0).name);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            r8.withValue("account_type", TransferFragment.access$800(this.this$0).type);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (TextUtils.isEmpty(TransferFragment.access$800(this.this$0).dataSet) == true) goto L25;
            r8.withValue("data_set", TransferFragment.access$800(this.this$0).dataSet);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
        L25:
            r1.add(r8.build());     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
        L27:
            if (r17.hasNext() == false) goto L49;
            Iterator<Entity.NamedContentValues> r9 = ((Entity) r17.next()).getSubValues().iterator();     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
        L30:
            if (r9.hasNext() == false) goto L27;
            Entity.NamedContentValues r10 = r9.next();     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            ContentValues r11 = r10.values;     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            r11.remove("_id");     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            String r12 = r11.getAsString("mimetype");     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if ("vnd.android.cursor.item/group_membership".equals(r12) == true) goto L30;
            if ("vnd.android.cursor.item/contact_event".equals(r12) == false) goto L48;
            AccountType r13 = AccountTypeManager.getInstance(this.mContext).getAccountTypeForAccount(TransferFragment.access$000(this.this$0));     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            AccountType r14 = AccountTypeManager.getInstance(this.mContext).getAccountTypeForAccount(TransferFragment.access$800(this.this$0));     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            DataKind r15 = r13.getKindForMimetype("vnd.android.cursor.item/contact_event");     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            DataKind r19 = r14.getKindForMimetype("vnd.android.cursor.item/contact_event");     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (EntityModifier.hasEditTypes(r15) == false) goto L48;
            if (EntityModifier.hasEditTypes(r19) == false) goto L48;
            AccountType.EditType r110 = new AccountType.EditType(4, -1);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            boolean r6 = r15.typeList.contains(r110);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            boolean r111 = r19.typeList.contains(r110);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (r11.getAsInteger(DBHelper.COL_DATA2) != null) goto L43;
            int r112 = 0;
        L44:
            if (r112 != 4) goto L48;
            if (r6 == false) goto L48;
            if (r111 == true) goto L48;
            r11.put(DBHelper.COL_DATA2, 3);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            goto L48
        L43:
            r112 = r11.getAsInteger(DBHelper.COL_DATA2).intValue();     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
        L48:
            ContentProviderOperation.Builder r7 = ContentProviderOperation.newInsert(r10.uri);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            r7.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r5);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            r7.withValues(r11);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            r1.add(r7.build());     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            goto L30
        L49:
            this.mContext.getContentResolver().applyBatch("com.android.contacts", r1);     // Catch: Throwable -> L53 OperationApplicationException -> L55 RemoteException -> L60
            if (r17 == null) goto L78;
            r17.close();
            return;
        L78:
            return;
        L53:
            th = move-exception;
            if (0 == 0) goto L67;
            r16.close();
        L67:
            throw th;
        L55:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TransferFragment", String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));     // Catch: Throwable -> L53
            if (0 == 0) goto L79;
            r16.close();
            return;
        L79:
            return;
        L60:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TransferFragment", String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));     // Catch: Throwable -> L53
            if (0 == 0) goto L80;
            r16.close();
            return;
        }

        private void removeRawContact(String r3) {
            this.mContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{r3});
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r2) {
            if (ContactsUtils.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("TransferFragment", "mProgressDialog onCancel invoked");
        L5:
            TransferFragment.access$202(this.this$0, true);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-2)) goto L5;
            TransferFragment.access$202(this.this$0, true);
            TransferFragment.access$300(this.this$0).dismiss();
            return;
        L5:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TransferFragment", "Unknown button event has come: " + r2.toString());
        }
    }

    public TransferFragment() {
        this.mOperation = -1;
        this.inBackground = false;
        this.mStopExport = false;
        this.mTransferStarted = false;
        this.BASE_SELECTION = "deleted != 1 AND account_name = ? AND account_type = ?";
    }

    static /* synthetic */ AccountWithDataSet access$000(TransferFragment r0) {
        return r0.mImportAccount;
    }

    static /* synthetic */ ArrayList access$100(TransferFragment r0) {
        return r0.mTransferRawContactsIds;
    }

    static /* synthetic */ boolean access$200(TransferFragment r0) {
        return r0.mStopExport;
    }

    static /* synthetic */ boolean access$202(TransferFragment r0, boolean r1) {
        r0.mStopExport = r1;
        return r1;
    }

    static /* synthetic */ CustomProgressDialog access$300(TransferFragment r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ boolean access$400(TransferFragment r0) {
        return r0.inBackground;
    }

    static /* synthetic */ void access$500(TransferFragment r0, Notification.Builder r1, int r2, int r3, boolean r4) {
        r0.doProgressNotification(r1, r2, r3, r4);
    }

    static /* synthetic */ NotificationManager access$600(TransferFragment r0) {
        return r0.mNotificationManager;
    }

    static /* synthetic */ boolean access$702(TransferFragment r0, boolean r1) {
        r0.mTransferStarted = r1;
        return r1;
    }

    static /* synthetic */ AccountWithDataSet access$800(TransferFragment r0) {
        return r0.mExportAccount;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        setRetainInstance(true);
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("TransferFragment", "onCreate");
    L5:
        this.mNotificationManager = (NotificationManager) getActivity().getSystemService("notification");
        NotificationChannel r5 = new NotificationChannel(TRANSFER_CHANNEL_ID, "Transfer", 3);
        this.mNotificationManager.createNotificationChannel(r5);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setBackground(false);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        setBackground(true);
    }

    private void setBackground(boolean r2) {
        this.inBackground = r2;
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("TransferFragment", "setBackground = " + r2);
        return;
    }

    public int getOperation() {
        return this.mOperation;
    }

    public void setOperation(int r1) {
        this.mOperation = r1;
    }

    public void setImportAccount(AccountWithDataSet r1) {
        this.mImportAccount = r1;
    }

    public void setExportAccount(AccountWithDataSet r1) {
        this.mExportAccount = r1;
    }

    public void setTransferRawContactsIds(ArrayList<Long> r1) {
        this.mTransferRawContactsIds = r1;
    }

    public boolean isTransferStarted() {
        return this.mTransferStarted;
    }

    public void start() {
        int r0 = this.mOperation;
        if (r0 == 0) goto L7;
        if (r0 == 1) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TransferFragment", "invalid operation");
        return;
    L7:
        if (r0 != 0) goto L9;
        int r1 = R.string.copy_contacts;
    L10:
        String r2 = getString(r1);
        if (this.mImportAccount != null) goto L13;
        return;
    L13:
        if (this.mExportAccount != null) goto L15;
        return;
    L15:
        if (this.mTransferRawContactsIds != null) goto L17;
        return;
    L17:
        if (getActivity() == null) goto L35;
        AccountTypeManager r3 = AccountTypeManager.getInstance(getActivity());
        AccountType r4 = r3.getAccountType(this.mImportAccount.type, this.mImportAccount.dataSet);
        AccountType r5 = r3.getAccountType(this.mExportAccount.type, this.mExportAccount.dataSet);
        Resources r6 = getResources();
        if (this.mOperation != 0) goto L22;
        int r7 = R.string.copy_raw_contacts_msg;
    L23:
        boolean r8 = false;
        String r9 = r6.getString(r7, new Object[]{getAccountDisplayLabel((String) r4.getDisplayLabel(getActivity()), true), getAccountDisplayLabel((String) r5.getDisplayLabel(getActivity()), true)});
        CustomProgressDialog r10 = new CustomProgressDialog(new ContextThemeWrapper(getActivity(), android.R.style.Theme.DeviceDefault.Light.Dialog));
        this.mProgressDialog = r10;
        r10.setTitle(r2);
        this.mProgressDialog.setMessage(r9);
        CustomProgressDialog r11 = this.mProgressDialog;
        if (this.mOperation != 0) goto L26;
        int r12 = R.string.copy_raw_contacts_ongoing;
    L27:
        r11.setProgressDescription(getString(r12));
        this.mProgressDialog.setButton(-2, getString(android.R.string.cancel), this.thread);
        this.mProgressDialog.setProgress(0);
        this.mProgressDialog.setMax(this.mTransferRawContactsIds.size());
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
        this.mProgressDialog.show();
        Activity r13 = getActivity();
        if (this.mOperation == 0) goto L30;
        r8 = true;
    L30:
        TransferRawContactsThread r14 = new TransferRawContactsThread(this, r13, r8);
        this.thread = r14;
        r14.start();
        this.mTransferStarted = true;
        return;
    L26:
        r12 = R.string.transfer_raw_contacts_ongoing;
        goto L27
    L22:
        r7 = R.string.transfer_raw_contacts_msg;
        goto L23
    L35:
        return;
    L9:
        r1 = R.string.transfer_contacts;
        goto L10
    }

    public void restart() {
        int r0 = this.mOperation;
        if (r0 == 0) goto L7;
        if (r0 == 1) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TransferFragment", "invalid operation");
        return;
    L7:
        if (r0 != 0) goto L9;
        int r1 = R.string.copy_contacts;
    L10:
        String r2 = getString(r1);
        if (this.mImportAccount != null) goto L13;
        return;
    L13:
        if (this.mExportAccount != null) goto L15;
        return;
    L15:
        if (this.mTransferRawContactsIds != null) goto L17;
        return;
    L17:
        if (getActivity() != null) goto L20;
        return;
    L20:
        if (this.thread != null) goto L22;
        return;
    L22:
        if (this.mTransferStarted == false) goto L37;
        AccountTypeManager r3 = AccountTypeManager.getInstance(getActivity());
        AccountType r4 = r3.getAccountType(this.mImportAccount.type, this.mImportAccount.dataSet);
        AccountType r5 = r3.getAccountType(this.mExportAccount.type, this.mExportAccount.dataSet);
        Resources r6 = getResources();
        if (this.mOperation != 0) goto L26;
        int r7 = R.string.copy_raw_contacts_msg;
    L27:
        String r8 = r6.getString(r7, new Object[]{getAccountDisplayLabel((String) r4.getDisplayLabel(getActivity()), true), getAccountDisplayLabel((String) r5.getDisplayLabel(getActivity()), true)});
        CustomProgressDialog r9 = new CustomProgressDialog(new ContextThemeWrapper(getActivity(), android.R.style.Theme.DeviceDefault.Light.Dialog));
        this.mProgressDialog = r9;
        r9.setTitle(r2);
        this.mProgressDialog.setMessage(r8);
        CustomProgressDialog r10 = this.mProgressDialog;
        if (this.mOperation != 0) goto L30;
        int r11 = R.string.copy_raw_contacts_ongoing;
    L31:
        r10.setProgressDescription(getString(r11));
        this.mProgressDialog.setButton(-2, getString(android.R.string.cancel), this.thread);
        this.mProgressDialog.setMax(this.mTransferRawContactsIds.size());
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
        this.mProgressDialog.show();
        this.mProgressDialog.setProgress(this.thread.getCurrentCount());
        return;
    L30:
        r11 = R.string.transfer_raw_contacts_ongoing;
        goto L31
    L26:
        r7 = R.string.transfer_raw_contacts_msg;
        goto L27
    L37:
        return;
    L9:
        r1 = R.string.transfer_contacts;
        goto L10
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

    private void doProgressNotification(Notification.Builder r6, int r7, int r8, boolean r9) {
        if (this.inBackground == true) goto L5;
        return;
    L5:
        Intent r0 = new Intent(getActivity(), ContactsTransferActivity.class);
        String r1 = getString(R.string.copy_contacts);
        if (r9 == false) goto L8;
        r1 = getString(R.string.transfer_contacts);
    L8:
        r6.setOngoing(true).setProgress(r7, r8, false).setContentTitle(r1).setSmallIcon(R.drawable.contact_icon).setContentIntent(PendingIntent.getActivity(getActivity(), 0, r0, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING));
        if (r7 <= 0) goto L11;
        r6.setContentText(getString(R.string.percentage, new Object[]{String.valueOf((r8 * 100) / r7)}));
    L11:
        r6.setAutoCancel(true);
        Notification r10 = r6.build();
        this.notification = r10;
        this.mNotificationManager.notify(20, r10);
    }
}
