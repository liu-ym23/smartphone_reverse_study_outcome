package com.android.contacts.vcard;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import android.os.Looper;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.UiUtils;
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
import com.obric.account.LocalAccountContactsUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NfcImportVCardActivity extends Activity implements ServiceConnection, VCardImportExportListener {
    private static final int FAILURE_NOTIFICATION_ID = 1;
    static final String FAILURE_NOTIFICATION_TAG = "VCardServiceFailure";
    private static final int SELECT_ACCOUNT = 1;
    private static final String TAG = "NfcImportVCardActivity";
    private AccountWithDataSet mAccount;
    private boolean mBindExecuted;
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
            r4[0].handleImportRequest(r1, this.this$0, true);
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
            if (NfcImportVCardActivity.access$000(this.this$0) == false) goto L6;
            NfcImportVCardActivity r0 = this.this$0;
            r0.unbindService(r0);
            NfcImportVCardActivity.access$002(this.this$0, false);
            return;
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
            if (NfcImportVCardActivity.access$000(this.this$0) == false) goto L6;
            NfcImportVCardActivity r2 = this.this$0;
            r2.unbindService(r2);
            NfcImportVCardActivity.access$002(this.this$0, false);
            return;
        }
    }

    public void com_android_contacts_vcard_NfcImportVCardActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onCancelRequest(CancelRequest r1, int r2) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onComplete() {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportCanceled(int r1, String r2) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportFailed(ExportRequest r1) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportFinished(int r1, String r2, String r3, PendingIntent r4) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportFinished(int r1, String r2, String r3, Intent r4) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportParsed(String r1, String r2, int r3, String r4, int r5, int r6) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onExportProcessed(ExportRequest r1, int r2) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportCanceled(ImportRequest r1, int r2) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportParsed(ImportRequest r1, int r2, VCardEntry r3, int r4, int r5) {
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportProcessed(ImportRequest r1, int r2, int r3, int r4) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_vcard_NfcImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public NfcImportVCardActivity() {
        this.mBindExecuted = false;
    }

    static /* synthetic */ boolean access$000(NfcImportVCardActivity r0) {
        return r0.mBindExecuted;
    }

    static /* synthetic */ boolean access$002(NfcImportVCardActivity r0, boolean r1) {
        r0.mBindExecuted = r1;
        return r1;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x008c: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:39:0x008c */
    ImportRequest createImportRequest() {
        VCardEntryCounter r3 = null;
        int r4 = 1;
        ByteArrayInputStream r5 = new ByteArrayInputStream(this.mRecord.getPayload());     // Catch: VCardException -> L41 VCardNestedException -> L44 IOException -> L48
        r5.mark(0);     // Catch: VCardException -> L41 VCardNestedException -> L44 IOException -> L48
        VCardParser_V21 r0 = new VCardParser_V21();     // Catch: VCardException -> L41 VCardNestedException -> L44 IOException -> L48
        VCardEntryCounter r6 = new VCardEntryCounter();     // Catch: Throwable -> L13 VCardInvalidLineException -> L15 VCardVersionException -> L19
        VCardSourceDetector r7 = new VCardSourceDetector();     // Catch: Throwable -> L9 VCardInvalidLineException -> L11 VCardVersionException -> L12
        r0.addInterpreter(r6);     // Catch: VCardInvalidLineException -> L52 VCardVersionException -> L54 Throwable -> L36
        r0.addInterpreter(r7);     // Catch: VCardInvalidLineException -> L52 VCardVersionException -> L54 Throwable -> L36
        r0.parse(r5);     // Catch: VCardInvalidLineException -> L52 VCardVersionException -> L54 Throwable -> L36
        r5.close();     // Catch: VCardNestedException -> L39 VCardException -> L41 IOException -> L51
    L47:
        return new ImportRequest(this.mAccount, this.mRecord.getPayload(), null, getString(R.string.nfc_vcard_file_name), r7.getEstimatedType(), r7.getEstimatedCharset(), r4, r6.getCount());
    L9:
        th = th;
    L64:
        r5.close();     // Catch: VCardNestedException -> L39 IOException -> L56 VCardException -> L41
    L40:
        throw th;     // Catch: VCardNestedException -> L39 VCardException -> L41 IOException -> L48
    L13:
        th = th;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed reading vcard dat VCardInvalidLineException.");     // Catch: Throwable -> L36
        showFailureNotification(R.string.vcard_import_failed);     // Catch: Throwable -> L36
        finish();     // Catch: Throwable -> L36
        r5.close();     // Catch: IOException -> L53 VCardNestedException -> L39 VCardException -> L41
    L18:
        return null;
    L20:
        r5.reset();     // Catch: Throwable -> L36
        r4 = 2;
        VCardParser_V30 r1 = new VCardParser_V30();     // Catch: Throwable -> L36
        VCardEntryCounter r8 = new VCardEntryCounter();     // Catch: VCardVersionException -> L58 Throwable -> L36
        VCardSourceDetector r9 = new VCardSourceDetector();     // Catch: Throwable -> L31 VCardVersionException -> L57
        r1.addInterpreter(r8);     // Catch: Throwable -> L28 VCardVersionException -> L30
        r1.addInterpreter(r9);     // Catch: Throwable -> L28 VCardVersionException -> L30
        r1.parse(r5);     // Catch: Throwable -> L28 VCardVersionException -> L30
        goto L68
    L77:
        r5.close();     // Catch: VCardNestedException -> L26 IOException -> L55 VCardException -> L41
    L26:
        r7 = r9;
        r3 = r8;
    L45:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Nested Exception is found (it may be false-positive).");
        r6 = r3;
    L27:
        r7 = r9;
        r6 = r8;
    L28:
        th = th;
        goto L64
    L31:
        th = th;
    L68:
        r5.close();     // Catch: IOException -> L59 VCardNestedException -> L39 VCardException -> L41
    L35:
        return null;
    L41:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error parsing vcard", e);
        return null;
    L36:
        th = th;
    L44:
        r7 = null;
    L39:
        r3 = r6;
    L48:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed reading vcard data", e);
        return null;
    }

    void showFailureNotification(int r4) {
        ((NotificationManager) getSystemService("notification")).notify(FAILURE_NOTIFICATION_TAG, 1, NotificationImportExportListener.constructImportFailureNotification(this, getString(r4)));
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this));
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        VCardService r4 = ((VCardService.MyBinder) r3).getService();
        new ImportTask(this).execute(new VCardService[]{r4});
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r5) {
        super.onCreate(r5);
        UiUtils.setWindowColorStatusBar(this);
        Intent r6 = getIntent();
        if ("android.nfc.action.NDEF_DISCOVERED".equals(r6.getAction()) == true) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknowon intent " + r6);
        finish();
    L5:
        Parcelable[] r0 = r6.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (r0 != null) goto L8;
    L32:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "not array extra in intent " + r6);
        finish();
        return;
    L8:
        if (r0.length <= 0) goto L32;
        Parcelable r1 = r0[0];
        if ((r1 instanceof NdefMessage) == false) goto L30;
        NdefRecord[] r2 = ((NdefMessage) r1).getRecords();
        if (r2 != null) goto L15;
    L28:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "No records " + r6);
        finish();
        return;
    L15:
        if (r2.length == 0) goto L28;
        NdefRecord r7 = r2[0];
        String r3 = new String(r7.getType(), Charset.forName("UTF8"));
        if (r7.getTnf() == 2) goto L20;
    L26:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Not a vcard");
        return;
    L20:
        if ("text/x-vcard".equalsIgnoreCase(r3) == false) goto L22;
    L24:
        this.mRecord = r7;
        this.mAccount = LocalAccountContactsUtils.getLocalAccountContacts(null);
        startImport();
        return;
    L22:
        if ("text/vcard".equals(r3) == true) goto L24;
    L30:
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.mBindExecuted == false) goto L6;
        unbindService(this);
        this.mBindExecuted = false;
        return;
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
        this.mBindExecuted = bindService(r0, this, 1);
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportFinished(ImportRequest r3, int r4, Uri r5) {
        if (isFinishing() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Late import -- ignoring");
        return;
    L6:
        if (r5 == null) goto L9;
        Uri r6 = ContactsContract.RawContacts.getContactLookupUri(getContentResolver(), r5);
        ActivityOptions r7 = ActivityOptions.makeCustomAnimation(this, R.anim.pop_up_in, 0);
        Intent r8 = new Intent("android.intent.action.VIEW", r6);
        r8.setPackage("com.android.contacts");
        r8.setFlags(268468224);
        startActivity(r8, r7.toBundle());
        new Handler(getMainLooper()).postDelayed(new AnonymousClass2(this), 300);
        return;
    }

    @Override // com.android.contacts.vcard.VCardImportExportListener
    public void onImportFailed(ImportRequest r1) {
        if (isFinishing() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Late import failure -- ignoring");
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_NfcImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NfcImportVCardActivity r1) {
        r1.com_android_contacts_vcard_NfcImportVCardActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
