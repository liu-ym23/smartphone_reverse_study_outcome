package com.android.contacts.common.vcard;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.activity.RequestPermissionsActivity;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.util.ImplicitIntentsUtil;
import com.android.vcard.VCardEntry;
import com.android.vcard.VCardEntryCounter;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.VCardSourceDetector;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardInvalidLineException;
import com.android.vcard.exception.VCardNestedException;
import com.android.vcard.exception.VCardVersionException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class NfcImportVCardActivity extends Activity implements ServiceConnection, VCardImportExportListener {
    private static final int FAILURE_NOTIFICATION_ID = 1;
    private static final int SELECT_ACCOUNT = 1;
    private static final String TAG = "NfcImportVCardActivity";
    private AccountWithDataSet mAccount;
    private Handler mHandler;
    private NdefRecord mRecord;

    class ImportTask extends AsyncTask<VCardService, Void, ImportRequest> {
        final /* synthetic */ NfcImportVCardActivity this$0;

        ImportTask(NfcImportVCardActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ ImportRequest doInBackground(VCardService[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(ImportRequest r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public ImportRequest doInBackground2(VCardService... r4) {
            ImportRequest r0 = this.this$0.createImportRequest();
            if (r0 != null) goto L6;
            return null;
        L6:
            ArrayList r1 = new ArrayList();
            r1.add(r0);
            r4[0].handleImportRequest(r1, this.this$0);
            return r0;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.AsyncTask
        public void onCancelled() {
            NfcImportVCardActivity r0 = this.this$0;
            r0.unbindService(r0);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(ImportRequest r1) {
            if (r1 != null) goto L4;
            this.this$0.finish();
        L4:
            NfcImportVCardActivity r0 = this.this$0;
            r0.unbindService(r0);
        }
    }

    public void com_android_contacts_common_vcard_NfcImportVCardActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onCancelRequest(CancelRequest r1, int r2) {
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onComplete() {
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onExportFailed(ExportRequest r1) {
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onExportProcessed(ExportRequest r1, int r2) {
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportCanceled(ImportRequest r1, int r2) {
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportParsed(ImportRequest r1, int r2, VCardEntry r3, int r4, int r5) {
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportProcessed(ImportRequest r1, int r2, int r3) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_vcard_NfcImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public NfcImportVCardActivity() {
        this.mHandler = new Handler();
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0096: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:40:0x0096 */
    ImportRequest createImportRequest() {
        VCardEntryCounter r3 = null;
        int r4 = 1;
        ByteArrayInputStream r5 = new ByteArrayInputStream(this.mRecord.getPayload());     // Catch: VCardException -> L42 VCardNestedException -> L45 IOException -> L49
        r5.mark(0);     // Catch: VCardException -> L42 VCardNestedException -> L45 IOException -> L49
        VCardParser_V21 r0 = new VCardParser_V21();     // Catch: VCardException -> L42 VCardNestedException -> L45 IOException -> L49
        VCardEntryCounter r6 = new VCardEntryCounter();     // Catch: Throwable -> L13 VCardInvalidLineException -> L15 VCardVersionException -> L19
        VCardSourceDetector r7 = new VCardSourceDetector();     // Catch: Throwable -> L9 VCardInvalidLineException -> L11 VCardVersionException -> L12
        r0.addInterpreter(r6);     // Catch: VCardInvalidLineException -> L53 VCardVersionException -> L55 Throwable -> L37
        r0.addInterpreter(r7);     // Catch: VCardInvalidLineException -> L53 VCardVersionException -> L55 Throwable -> L37
        r0.parse(r5);     // Catch: VCardInvalidLineException -> L53 VCardVersionException -> L55 Throwable -> L37
        r5.close();     // Catch: VCardNestedException -> L40 VCardException -> L42 IOException -> L52
    L48:
        return new ImportRequest(this.mAccount, this.mRecord.getPayload(), null, getString(R.string.nfc_vcard_file_name), r7.getEstimatedType(), r7.getEstimatedCharset(), r4, r6.getCount());
    L9:
        th = th;
    L61:
        r5.close();     // Catch: VCardNestedException -> L40 IOException -> L57 VCardException -> L42
    L41:
        throw th;     // Catch: VCardNestedException -> L40 VCardException -> L42 IOException -> L49
    L13:
        th = th;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed reading vcard data VCardInvalidLineException.");     // Catch: Throwable -> L37
        showFailureNotification(R.string.vcard_import_failed);     // Catch: Throwable -> L37
        finish();     // Catch: Throwable -> L37
        r5.close();     // Catch: IOException -> L54 VCardNestedException -> L40 VCardException -> L42
    L18:
        return null;
    L20:
        r5.reset();     // Catch: Throwable -> L37
        r4 = 2;
        VCardParser_V30 r1 = new VCardParser_V30();     // Catch: Throwable -> L37
        VCardEntryCounter r8 = new VCardEntryCounter();     // Catch: VCardVersionException -> L59 Throwable -> L37
        VCardSourceDetector r9 = new VCardSourceDetector();     // Catch: Throwable -> L31 VCardVersionException -> L58
        r1.addInterpreter(r8);     // Catch: Throwable -> L28 VCardVersionException -> L30
        r1.addInterpreter(r9);     // Catch: Throwable -> L28 VCardVersionException -> L30
        r1.parse(r5);     // Catch: Throwable -> L28 VCardVersionException -> L30
        goto L34
    L78:
        r5.close();     // Catch: VCardNestedException -> L26 IOException -> L56 VCardException -> L42
    L26:
        r7 = r9;
        r3 = r8;
    L46:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Nested Exception is found (it may be false-positive).");
        r6 = r3;
    L27:
        r7 = r9;
        r6 = r8;
    L28:
        th = th;
        goto L61
    L31:
        th = th;
    L34:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "vCard with unsupported version.");     // Catch: Throwable -> L37
        showFailureNotification(R.string.fail_reason_not_supported);     // Catch: Throwable -> L37
        r5.close();     // Catch: IOException -> L60 VCardNestedException -> L40 VCardException -> L42
    L36:
        return null;
    L40:
        r3 = r6;
    L49:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed reading vCard data", e);
        showFailureNotification(R.string.fail_reason_io_error);
        return null;
    L42:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error parsing vCard", e);
        showFailureNotification(R.string.fail_reason_not_supported);
        return null;
    L37:
        th = th;
    L45:
        r7 = null;
        goto L46
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        VCardService r4 = ((VCardService.MyBinder) r3).getService();
        new ImportTask(this).execute(new VCardService[]{r4});
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (RequestPermissionsActivity.startPermissionActivity(this) == false) goto L5;
        return;
    L5:
        Intent r5 = getIntent();
        if ("android.nfc.action.NDEF_DISCOVERED".equals(r5.getAction()) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknowon intent " + r5);
        finish();
        return;
    L9:
        String r0 = r5.getType();
        if (r0 != null) goto L12;
    L26:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Not a vcard");
        finish();
        return;
    L12:
        if ("text/x-vcard".equals(r0) == false) goto L14;
    L16:
        this.mRecord = ((NdefMessage) r5.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0]).getRecords()[0];
        List<AccountWithDataSet> r6 = AccountTypeManager.getInstance(this).getAccounts(true);
        if (r6.size() != 0) goto L20;
        this.mAccount = null;
    L22:
        startImport();
        return;
    L20:
        if (r6.size() != 1) goto L24;
        this.mAccount = r6.get(0);
        goto L22
    L24:
        startActivityForResult(new Intent(this, SelectAccountActivity.class), 1);
        return;
    L14:
        if ("text/vcard".equals(r0) == true) goto L16;
        goto L16
    }

    @Override // android.app.Activity
    public void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r3 == 1) goto L5;
        return;
    L5:
        if (r4 != (-1)) goto L7;
        this.mAccount = new AccountWithDataSet(r5.getStringExtra("account_name"), r5.getStringExtra("account_type"), r5.getStringExtra("data_set"));
        startImport();
        return;
    L7:
        finish();
    }

    private void startImport() {
        Intent r0 = new Intent(this, VCardService.class);
        startService(r0);
        bindService(r0, this, 1);
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportFinished(ImportRequest r1, int r2, Uri r3) {
        if (isFinishing() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Late import -- ignoring");
        return;
    L6:
        if (r3 == null) goto L9;
        Intent r4 = new Intent("android.intent.action.VIEW", ContactsContract.RawContacts.getContactLookupUri(getContentResolver(), r3));
        r4.setPackage(getPackageName());
        ImplicitIntentsUtil.startActivityInAppIfPossible(this, r4);
        finish();
        return;
    }

    @Override // com.android.contacts.common.vcard.VCardImportExportListener
    public void onImportFailed(ImportRequest r1) {
        if (isFinishing() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Late import failure -- ignoring");
        return;
    L6:
        showFailureNotification(R.string.vcard_import_request_rejected_message);
        finish();
    }

    void showFailureNotification(int r4) {
        ((NotificationManager) getSystemService("notification")).notify("VCardServiceFailure", 1, NotificationImportExportListener.constructImportFailureNotification(this, getString(r4)));
        this.mHandler.post(new AnonymousClass1(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_vcard_NfcImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NfcImportVCardActivity r1) {
        r1.com_android_contacts_common_vcard_NfcImportVCardActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
