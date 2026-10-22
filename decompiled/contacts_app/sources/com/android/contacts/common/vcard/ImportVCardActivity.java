package com.android.contacts.common.vcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.activity.RequestImportVCardPermissionsActivity;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.vcard.VCardEntryCounter;
import com.android.vcard.VCardParser;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.VCardSourceDetector;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardNestedException;
import com.android.vcard.exception.VCardVersionException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ImportVCardActivity extends Activity implements ImportVCardDialogFragment.Listener {
    private static final int FAILURE_NOTIFICATION_ID = 1;
    private static final String LOCAL_TMP_FILE_NAME_EXTRA = "com.android.contacts.common.vcard.LOCAL_TMP_FILE_NAME";
    private static final String LOG_TAG = "VCardImport";
    private static final int REQUEST_OPEN_DOCUMENT = 100;
    private static final int SELECT_ACCOUNT = 0;
    private static final String SOURCE_URI_DISPLAY_NAME = "com.android.contacts.common.vcard.SOURCE_URI_DISPLAY_NAME";
    private static final String STORAGE_VCARD_URI_PREFIX = "file:///storage";
    static final int VCARD_VERSION_AUTO_DETECT = 0;
    static final int VCARD_VERSION_V21 = 1;
    static final int VCARD_VERSION_V30 = 2;
    private AccountWithDataSet mAccount;
    private boolean mBind;
    private CancelListener mCancelListener;
    private ImportRequestConnection mConnection;
    private String mErrorMessage;
    private Handler mHandler;
    VCardImportExportListener mListener;
    private ProgressDialog mProgressDialogForCachingVCard;
    private VCardCacheThread mVCardCacheThread;

    private class CancelListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        final /* synthetic */ ImportVCardActivity this$0;

        private CancelListener(ImportVCardActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CancelListener(ImportVCardActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            this.this$0.finish();
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            this.this$0.finish();
        }
    }

    private class DialogDisplayer implements Runnable {
        private final int mResId;
        final /* synthetic */ ImportVCardActivity this$0;

        public DialogDisplayer(ImportVCardActivity r1, int r2) {
            this.this$0 = r1;
            this.mResId = r2;
        }

        public DialogDisplayer(ImportVCardActivity r2, String r3) {
            this.this$0 = r2;
            this.mResId = R.id.dialog_error_with_message;
            ImportVCardActivity.access$002(r2, r3);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.isFinishing() == true) goto L6;
            this.this$0.showDialog(this.mResId);
            return;
        }
    }

    private class ImportRequestConnection implements ServiceConnection {
        private VCardService mService;
        final /* synthetic */ ImportVCardActivity this$0;

        private ImportRequestConnection(ImportVCardActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ImportRequestConnection(ImportVCardActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void sendImportRequest(List<ImportRequest> r3) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Send an import request");
            this.mService.handleImportRequest(r3, this.this$0.mListener);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            this.mService = ((VCardService.MyBinder) r3).getService();
            ImportVCardActivity.access$202(this.this$0, true);
            if (ImportVCardActivity.access$300(this.this$0) == null) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, String.format("Connected to VCardService. Kick a vCard cache thread (uri: %s)", new Object[]{Arrays.toString(ImportVCardActivity.access$300(this.this$0).getSourceUris())}));
            ImportVCardActivity.access$300(this.this$0).start();
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
            ImportVCardActivity.access$202(this.this$0, false);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Disconnected from VCardService");
        }
    }

    private class VCardCacheThread extends Thread implements DialogInterface.OnCancelListener {
        private boolean mCanceled;
        private final String mDisplayName;
        private final byte[] mSource;
        private final String[] mSourceDisplayNames;
        private final Uri[] mSourceUris;
        private VCardParser mVCardParser;
        private PowerManager.WakeLock mWakeLock;
        final /* synthetic */ ImportVCardActivity this$0;

        public VCardCacheThread(ImportVCardActivity r2, Uri[] r3, String[] r4) {
            this.this$0 = r2;
            this.mSourceUris = r3;
            this.mSourceDisplayNames = r4;
            this.mSource = null;
            this.mWakeLock = ((PowerManager) r2.getSystemService("power")).newWakeLock(536870918, ImportVCardActivity.LOG_TAG);
            this.mDisplayName = null;
        }

        public void finalize() {
            PowerManager.WakeLock r0 = this.mWakeLock;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isHeld() == false) goto L9;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "WakeLock is being held.");
            this.mWakeLock.release();
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache thread starts running.");
            if (ImportVCardActivity.access$400(this.this$0) == null) goto L74;
            this.mWakeLock.acquire();
        L57:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "IOException during caching vCard", e);     // Catch: Throwable -> L55
            ImportVCardActivity r3 = this.this$0;     // Catch: Throwable -> L55
            ImportVCardActivity r5 = this.this$0;     // Catch: Throwable -> L55
            r3.runOnUiThread(new DialogDisplayer(r5, r5.getString(R.string.fail_reason_io_error)));     // Catch: Throwable -> L55
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L62;
        L61:
            ImportVCardActivity.access$500(this.this$0).dismiss();
            ImportVCardActivity.access$502(this.this$0, null);
        L62:
            this.this$0.finish();
            return;
        L63:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "OutOfMemoryError occured during caching vCard");     // Catch: Throwable -> L55
            System.gc();     // Catch: Throwable -> L55
            ImportVCardActivity r4 = this.this$0;     // Catch: Throwable -> L55
            ImportVCardActivity r6 = this.this$0;     // Catch: Throwable -> L55
            r4.runOnUiThread(new DialogDisplayer(r6, r6.getString(R.string.fail_reason_low_memory_during_import)));     // Catch: Throwable -> L55
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L62;
        L7:
            if (this.mCanceled != true) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache operation is canceled.");     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L12;
        L11:
            ImportVCardActivity.access$500(this.this$0).dismiss();
            ImportVCardActivity.access$502(this.this$0, null);
        L12:
            this.this$0.finish();
            return;
        L14:
            ArrayList r7 = new ArrayList();     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            byte[] r8 = this.mSource;     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            if (r8 != null) goto L77;
            Uri[] r9 = this.mSourceUris;     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            int r10 = r9.length;     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            int r11 = 0;
            int r12 = 0;
        L25:
            if (r11 >= r10) goto L49;
            Uri r13 = r9[r11];     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            if (this.mCanceled == true) goto L28;
            int r14 = r12 + 1;     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            ImportRequest r15 = constructImportRequest(null, r13, this.mSourceDisplayNames[r12]);     // Catch: IOException -> L38 VCardException -> L43 Throwable -> L55 OutOfMemoryError -> L63
        L32:
            if (this.mCanceled == true) goto L33;
            r7.add(r15);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            r11 = r11 + 1;     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            r12 = r14;
            goto L25
        L33:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache operation is canceled.");     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L12;
        L43:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "Maybe the file is in wrong format", e);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            this.this$0.showFailureNotification(R.string.fail_reason_not_supported);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L12;
        L38:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "Unexpected IOException", e);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            this.this$0.showFailureNotification(R.string.fail_reason_io_error);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L12;
        L28:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "vCard cache operation is canceled.");     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
        L49:
            if (r7.isEmpty() == true) goto L51;
            ImportVCardActivity.access$400(this.this$0).sendImportRequest(r7);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
        L52:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L62;
        L51:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Empty import requests. Ignore it.");     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            goto L52
        L77:
            r7.add(constructImportRequest(r8, null, this.mDisplayName));     // Catch: VCardException -> L19 Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
        L19:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ImportVCardActivity.LOG_TAG, "Maybe the file is in wrong format", e);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            this.this$0.showFailureNotification(R.string.fail_reason_not_supported);     // Catch: Throwable -> L55 IOException -> L57 OutOfMemoryError -> L63
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L12;
        L55:
            th = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Finished caching vCard.");
            this.mWakeLock.release();
            if (ImportVCardActivity.access$500(this.this$0) == null) goto L71;
            ImportVCardActivity.access$500(this.this$0).dismiss();
            ImportVCardActivity.access$502(this.this$0, null);
        L71:
            this.this$0.finish();
            throw th;
        L74:
            throw new NullPointerException("vCard cache thread must be launched after a service connection is established");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v15, types: [com.android.vcard.VCardParser] */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v2, types: [com.android.vcard.VCardSourceDetector] */
        /* JADX WARN: Type inference failed for: r8v20 */
        /* JADX WARN: Type inference failed for: r8v21 */
        /* JADX WARN: Type inference failed for: r8v22, types: [com.android.vcard.VCardInterpreter, com.android.vcard.VCardSourceDetector] */
        /* JADX WARN: Type inference failed for: r8v23 */
        /* JADX WARN: Type inference failed for: r8v24 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
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
        private ImportRequest constructImportRequest(byte[] r12, Uri r13, String r14) throws IOException, VCardException {
            ContentResolver r0 = this.this$0.getContentResolver();
            VCardEntryCounter r2 = null;
            r2 = null;
            r2 = null;
            Object r3 = null;
            int r5 = 1;
            if (r12 == null) goto L5;
            InputStream r6 = new ByteArrayInputStream(r12);     // Catch: VCardNestedException -> L50
        L66:
            this.mVCardParser = new VCardParser_V21();     // Catch: VCardNestedException -> L50
            VCardEntryCounter r7 = new VCardEntryCounter();     // Catch: Throwable -> L22 VCardVersionException -> L24
            ?? r8 = new VCardSourceDetector();     // Catch: Throwable -> L17 VCardVersionException -> L20
            this.mVCardParser.addInterpreter(r7);     // Catch: Throwable -> L15 VCardVersionException -> L58
            this.mVCardParser.addInterpreter(r8);     // Catch: Throwable -> L15 VCardVersionException -> L58
            VCardParser r4 = this.mVCardParser;     // Catch: Throwable -> L15 VCardVersionException -> L58
            r4.parse(r6);     // Catch: Throwable -> L15 VCardVersionException -> L58
            if (r6 != null) goto L86;
        L14:
            boolean r1 = false;
            r3 = r4;
            r8 = r8;
        L41:
            if (r1 == false) goto L65;
            r5 = 2;
        L65:
        L53:
            return new ImportRequest(ImportVCardActivity.access$600(this.this$0), r12, r13, r14, r8.getEstimatedType(), r8.getEstimatedCharset(), r5, r7.getCount());
        L86:
            r6.close();     // Catch: VCardNestedException -> L55 IOException -> L54
        L13:
            r2 = r7;
        L51:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ImportVCardActivity.LOG_TAG, "Nested Exception is found (it may be false-positive).");
            r7 = r2;
        L15:
            th = th;
        L19:
            r2 = r7;
        L47:
            if (r6 != null) goto L68;
        L49:
            throw th;     // Catch: VCardNestedException -> L56
        L68:
            r6.close();     // Catch: IOException -> L57 VCardNestedException -> L56
        L21:
            r2 = r7;
            r8 = r8;
        L72:
            r6.close();     // Catch: Throwable -> L27 IOException -> L59
        L27:
            th = th;
        L29:
            if (r12 == null) goto L31;
            InputStream r9 = new ByteArrayInputStream(r12);     // Catch: Throwable -> L27
        L32:
            r6 = r9;
            this.mVCardParser = new VCardParser_V30();     // Catch: Throwable -> L27
            r7 = new VCardEntryCounter();     // Catch: Throwable -> L27 VCardVersionException -> L62
            VCardSourceDetector r10 = new VCardSourceDetector();     // Catch: Throwable -> L15 VCardVersionException -> L61
            this.mVCardParser.addInterpreter(r7);     // Catch: Throwable -> L17 VCardVersionException -> L43
            this.mVCardParser.addInterpreter(r10);     // Catch: Throwable -> L17 VCardVersionException -> L43
            this.mVCardParser.parse(r6);     // Catch: Throwable -> L17 VCardVersionException -> L43
            if (r6 != null) goto L88;
        L40:
            r8 = r10;
            r1 = true;
            r3 = r10;
            goto L41
        L88:
            r6.close();     // Catch: VCardNestedException -> L39 IOException -> L60
        L39:
            r8 = r10;
        L43:
            r8 = r10;
            goto L44
        L44:
            r2 = r7;
        L46:
            throw new VCardException("vCard with unspported version.");     // Catch: Throwable -> L27
        L31:
            r9 = r0.openInputStream(r13);     // Catch: Throwable -> L27
        L20:
            r8 = 0;
            goto L21
        L24:
            r8 = 0;
        L22:
            th = th;
            r8 = 0;
        L17:
            th = th;
            r8 = r3;
            goto L19
        L5:
            r6 = r0.openInputStream(r13);     // Catch: VCardNestedException -> L50
        L50:
            r8 = 0;
            goto L51
        }

        public Uri[] getSourceUris() {
            return this.mSourceUris;
        }

        public void cancel() {
            this.mCanceled = true;
            VCardParser r1 = this.mVCardParser;
            if (r1 == null) goto L6;
            r1.cancel();
            return;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r2) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ImportVCardActivity.LOG_TAG, "Cancel request has come. Abort caching vCard.");
            cancel();
        }
    }

    public void com_android_contacts_common_vcard_ImportVCardActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_vcard_ImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ImportVCardActivity() {
        this.mHandler = new Handler();
        this.mBind = false;
        this.mCancelListener = new CancelListener(this, null);
    }

    static /* synthetic */ String access$002(ImportVCardActivity r0, String r1) {
        r0.mErrorMessage = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(ImportVCardActivity r0, boolean r1) {
        r0.mBind = r1;
        return r1;
    }

    static /* synthetic */ VCardCacheThread access$300(ImportVCardActivity r0) {
        return r0.mVCardCacheThread;
    }

    static /* synthetic */ VCardCacheThread access$302(ImportVCardActivity r0, VCardCacheThread r1) {
        r0.mVCardCacheThread = r1;
        return r1;
    }

    static /* synthetic */ ImportRequestConnection access$400(ImportVCardActivity r0) {
        return r0.mConnection;
    }

    static /* synthetic */ ProgressDialog access$500(ImportVCardActivity r0) {
        return r0.mProgressDialogForCachingVCard;
    }

    static /* synthetic */ ProgressDialog access$502(ImportVCardActivity r0, ProgressDialog r1) {
        r0.mProgressDialogForCachingVCard = r1;
        return r1;
    }

    static /* synthetic */ AccountWithDataSet access$600(ImportVCardActivity r0) {
        return r0.mAccount;
    }

    private void importVCard(Uri r4, String r5) {
        importVCard(new Uri[]{r4}, new String[]{r5});
    }

    private void importVCard(final Uri[] r2, final String[] r3) {
        runOnUiThread(new AnonymousClass1(this, r2, r3));
    }

    private String getDisplayName(Uri r10) {
        Cursor r2 = null;
        String r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        if (r10 != null) goto L31;
        return null;
    L31:
        Cursor r9 = getContentResolver().query(r10, new String[]{"_display_name"}, null, null, null);     // Catch: Throwable -> L27
        if (r9 != null) goto L33;
    L21:
        if (r9 == null) goto L24;
        r9.close();
    L24:
        if (TextUtils.isEmpty(r3) == true) goto L26;
        return r3;
    L26:
        return r10.getLastPathSegment();
    L33:
    L19:
        th = th;
        r2 = r9;
    L28:
        if (r2 == null) goto L30;
        r2.close();
    L30:
        throw th;
    L9:
        if (r9.getCount() <= 0) goto L21;
        if (r9.moveToFirst() == false) goto L21;
        if (r9.getCount() <= 1) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Unexpected multiple rows: " + r9.getCount());     // Catch: Throwable -> L19
    L15:
        int r0 = r9.getColumnIndex("_display_name");     // Catch: Throwable -> L19
        if (r0 < 0) goto L21;
        r3 = r9.getString(r0);     // Catch: Throwable -> L19
    L27:
        th = th;
        goto L28
    }

    private Uri copyTo(Uri r8, String r9) throws IOException {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, String.format("Copy a Uri to app local storage (%s -> %s)", new Object[]{r8, r9}));
        ReadableByteChannel r5 = null;
        FileChannel r6 = null;
        ReadableByteChannel r10 = Channels.newChannel(getContentResolver().openInputStream(r8));     // Catch: Throwable -> L24
        Uri r2 = Uri.parse(getFileStreamPath(r9).toURI().toString());     // Catch: Throwable -> L22
        r6 = openFileOutput(r9, 0).getChannel();     // Catch: Throwable -> L22
        ByteBuffer r7 = ByteBuffer.allocateDirect(8192);     // Catch: Throwable -> L22
    L6:
        if (r10.read(r7) == (-1)) goto L8;
        r7.flip();     // Catch: Throwable -> L22
        r6.write(r7);     // Catch: Throwable -> L22
        r7.compact();     // Catch: Throwable -> L22
        goto L6
    L8:
        r7.flip();     // Catch: Throwable -> L22
    L9:
        if (r7.hasRemaining() == false) goto L13;
        r6.write(r7);     // Catch: Throwable -> L22
        goto L9
    L13:
        if (r10 != null) goto L37;
    L17:
        if (r6 != null) goto L45;
    L21:
        return r2;
    L45:
        r6.close();     // Catch: IOException -> L20
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to close outputChannel");
        goto L21
    L37:
        r10.close();     // Catch: IOException -> L16
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to close inputChannel.");
    L22:
        th = th;
        FileChannel r11 = r6;
        r5 = r10;
        FileChannel r12 = r11;
    L26:
        if (r5 != null) goto L41;
    L30:
        if (r12 == null) goto L49;
        r12.close();     // Catch: IOException -> L33
        throw th;
    L33:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to close outputChannel");
        throw th;
    L49:
        throw th;
    L41:
        r5.close();     // Catch: IOException -> L29
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to close inputChannel.");
    L24:
        th = th;
        r12 = null;
        goto L26
    }

    private String readUriToLocalFile(Uri r5) {
        int r1 = 0;
    L3:
        String r2 = "import_tmp_" + r1 + ".vcf";
        if (getFileStreamPath(r2).exists() == false) goto L19;
        if (r1 == Integer.MAX_VALUE) goto L18;
        r1 = r1 + 1;
        goto L3
    L18:
        throw new RuntimeException("Exceeded cache limit");
    L19:
        copyTo(r5, r2);     // Catch: IOException -> L8 SecurityException -> L11
        return r2;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "IOException during caching vCard", e);
        showFailureNotification(R.string.fail_reason_io_error);
        return null;
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "SecurityException", e);
        showFailureNotification(R.string.fail_reason_io_error);
        return null;
    }

    private Uri readUriToLocalUri(Uri r1) {
        String r2 = readUriToLocalFile(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Uri.parse(getFileStreamPath(r2).toURI().toString());
    }

    private boolean isStorageUri(Uri r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.toString().startsWith(STORAGE_VCARD_URI_PREFIX) == false) goto L6;
        return true;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r8) {
        super.onCreate(r8);
        Uri r9 = getIntent().getData();
        if (isStorageUri(r9) == false) goto L8;
        if (RequestImportVCardPermissionsActivity.startPermissionActivity(this, isCallerSelf(this)) == false) goto L8;
        return;
    L8:
        if (r9 == null) goto L17;
        String r2 = getIntent().getStringExtra(LOCAL_TMP_FILE_NAME_EXTRA);
        String r4 = getIntent().getStringExtra(SOURCE_URI_DISPLAY_NAME);
        if (TextUtils.isEmpty(r2) == false) goto L16;
        r2 = readUriToLocalFile(r9);
        r4 = getDisplayName(r9);
        if (r2 != null) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Cannot load uri to local storage.");
        showFailureNotification(R.string.fail_reason_io_error);
        return;
    L15:
        getIntent().putExtra(LOCAL_TMP_FILE_NAME_EXTRA, r2);
        getIntent().putExtra(SOURCE_URI_DISPLAY_NAME, r4);
    L16:
        r9 = Uri.parse(getFileStreamPath(r2).toURI().toString());
    L19:
        if (RequestImportVCardPermissionsActivity.startPermissionActivity(this, isCallerSelf(this)) == false) goto L21;
        return;
    L21:
        Intent r3 = getIntent();
        if (r3 == null) goto L24;
        String r0 = r3.getStringExtra("account_name");
        String r5 = r3.getStringExtra("account_type");
        String r6 = r3.getStringExtra("data_set");
    L26:
        if (TextUtils.isEmpty(r0) == false) goto L28;
    L30:
        List<AccountWithDataSet> r1 = AccountTypeManager.getInstance(this).getAccounts(true);
        if (r1.size() != 0) goto L34;
        this.mAccount = null;
    L37:
        if (isCallerSelf(this) == false) goto L39;
        startImport(r9, r4);
        return;
    L39:
        ImportVCardDialogFragment.show(this, r9, r4);
        return;
    L34:
        if (r1.size() != 1) goto L41;
        this.mAccount = r1.get(0);
        goto L37
    L41:
        startActivityForResult(new Intent(this, SelectAccountActivity.class), 0);
        return;
    L28:
        if (TextUtils.isEmpty(r5) == true) goto L30;
        this.mAccount = new AccountWithDataSet(r0, r5, r6);
        goto L37
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "intent does not exist");
        r0 = null;
        r6 = null;
        r5 = null;
        goto L26
    L17:
        r4 = null;
        goto L19
    }

    private static boolean isCallerSelf(Activity r2) {
        ComponentName r0 = r2.getCallingActivity();
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = r0.getPackageName();
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.equals(r2.getApplicationContext().getPackageName());
    }

    @Override // com.android.contacts.common.vcard.ImportVCardDialogFragment.Listener
    public void onImportVCardConfirmed(Uri r1, String r2) {
        startImport(r1, r2);
    }

    @Override // com.android.contacts.common.vcard.ImportVCardDialogFragment.Listener
    public void onImportVCardDenied() {
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int r7, int r8, Intent r9) {
        super.onActivityResult(r7, r8, r9);
        if (r7 != 0) goto L13;
        if (r8 != (-1)) goto L9;
        this.mAccount = new AccountWithDataSet(r9.getStringExtra("account_name"), r9.getStringExtra("account_type"), r9.getStringExtra("data_set"));
        Uri r10 = getIntent().getData();
        if (r10 != null) goto L8;
        startImport(r10, null);
        return;
    L8:
        startImport(Uri.parse(getFileStreamPath(getIntent().getStringExtra(LOCAL_TMP_FILE_NAME_EXTRA)).toURI().toString()), getIntent().getStringExtra(SOURCE_URI_DISPLAY_NAME));
        return;
    L9:
        if (r8 == 0) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Result code was not OK nor CANCELED: " + r8);
    L11:
        finish();
        return;
    L13:
        if (r7 != 100) goto L48;
        if (r8 != (-1)) goto L37;
        ClipData r11 = r9.getClipData();
        if (r11 == null) goto L30;
        ArrayList r12 = new ArrayList();
        ArrayList r0 = new ArrayList();
        int r3 = 0;
    L19:
        if (r3 >= r11.getItemCount()) goto L27;
        Uri r4 = r11.getItemAt(r3).getUri();
        if (r4 == null) goto L25;
        Uri r5 = readUriToLocalUri(r4);
        if (r5 == null) goto L25;
        String r6 = getDisplayName(r4);
        r12.add(r5);
        r0.add(r6);
    L25:
        r3 = r3 + 1;
        goto L19
    L27:
        if (r12.isEmpty() == false) goto L29;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "No vCard was selected for import");
        finish();
        return;
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Multiple vCards selected for import: " + r12);
        importVCard((Uri[]) r12.toArray(new Uri[0]), (String[]) r0.toArray(new String[0]));
        return;
    L30:
        Uri r13 = r9.getData();
        if (r13 == null) goto L36;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "vCard selected for import: " + r13);
        Uri r14 = readUriToLocalUri(r13);
        if (r14 == null) goto L35;
        importVCard(r14, getDisplayName(r13));
        return;
    L35:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "No local URI for vCard import");
        finish();
        return;
    L36:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "No vCard was selected for import");
        finish();
        return;
    L37:
        if (r8 == 0) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Result code was not OK nor CANCELED" + r8);
    L39:
        finish();
        return;
    }

    private void startImport(Uri r4, String r5) {
        if (r4 == null) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Starting vCard import using Uri " + r4);
        importVCard(r4, r5);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Start vCard without Uri. The user will select vCard manually.");
        Intent r6 = new Intent("android.intent.action.OPEN_DOCUMENT");
        r6.addCategory("android.intent.category.OPENABLE");
        r6.setType("text/x-vcard");
        r6.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        startActivityForResult(r6, 100);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r2, Bundle r3) {
        if (r2 != R.id.dialog_cache_vcard) goto L10;
        if (this.mProgressDialogForCachingVCard != null) goto L8;
        String r4 = getString(R.string.caching_vcard_title);
        String r5 = getString(R.string.caching_vcard_message);
        ProgressDialog r0 = new ProgressDialog(this);
        this.mProgressDialogForCachingVCard = r0;
        r0.setTitle(r4);
        this.mProgressDialogForCachingVCard.setMessage(r5);
        this.mProgressDialogForCachingVCard.setProgressStyle(0);
        this.mProgressDialogForCachingVCard.setOnCancelListener(this.mVCardCacheThread);
        startVCardService();
    L8:
        return this.mProgressDialogForCachingVCard;
    L10:
        if (r2 != R.id.dialog_error_with_message) goto L17;
        String r6 = this.mErrorMessage;
        if (TextUtils.isEmpty(r6) == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Error message is null while it must not.");
        r6 = getString(R.string.fail_reason_unknown);
    L15:
        return new AlertDialog.Builder(this).setTitle(getString(R.string.reading_vcard_failed_title)).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(r6).setOnCancelListener(this.mCancelListener).setPositiveButton(android.R.string.ok, this.mCancelListener).create();
    L17:
        return super.onCreateDialog(r2, r3);
    }

    void startVCardService() {
        this.mConnection = new ImportRequestConnection(this, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Bind to VCardService.");
        startService(new Intent(this, VCardService.class));
        bindService(new Intent(this, VCardService.class), this.mConnection, 1);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle r2) {
        super.onRestoreInstanceState(r2);
        if (this.mProgressDialogForCachingVCard == null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Cache thread is still running. Show progress dialog again.");
        showDialog(R.id.dialog_cache_vcard);
        return;
    }

    void showFailureNotification(int r4) {
        ((NotificationManager) getSystemService("notification")).notify("VCardServiceFailure", 1, NotificationImportExportListener.constructImportFailureNotification(this, getString(r4)));
        this.mHandler.post(new AnonymousClass2(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.mBind == false) goto L6;
        unbindService(this.mConnection);
        this.mBind = false;
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_vcard_ImportVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ImportVCardActivity r1) {
        r1.com_android_contacts_common_vcard_ImportVCardActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
