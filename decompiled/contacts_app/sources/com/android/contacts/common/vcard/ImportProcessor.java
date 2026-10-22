package com.android.contacts.common.vcard;

import android.accounts.Account;
import android.content.ContentResolver;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.vcard.VCardEntry;
import com.android.vcard.VCardEntryCommitter;
import com.android.vcard.VCardEntryConstructor;
import com.android.vcard.VCardEntryHandler;
import com.android.vcard.VCardInterpreter;
import com.android.vcard.VCardParser;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.exception.VCardException;
import com.android.vcard.exception.VCardNestedException;
import com.android.vcard.exception.VCardNotSupportedException;
import com.android.vcard.exception.VCardVersionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ImportProcessor extends ProcessorBase implements VCardEntryHandler {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardImport";
    private volatile boolean mCanceled;
    private int mCurrentCount;
    private volatile boolean mDone;
    private final List<Uri> mFailedUris;
    private final ImportRequest mImportRequest;
    private final int mJobId;
    private final VCardImportExportListener mListener;
    private final ContentResolver mResolver;
    private final VCardService mService;
    private int mTotalCount;
    private VCardParser mVCardParser;

    @Override // com.android.contacts.common.vcard.ProcessorBase
    public final int getType() {
        return 1;
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onEnd() {
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onStart() {
    }

    public ImportProcessor(VCardService r2, VCardImportExportListener r3, ImportRequest r4, int r5) {
        this.mFailedUris = new ArrayList();
        this.mCurrentCount = 0;
        this.mTotalCount = 0;
        this.mService = r2;
        this.mResolver = r2.getContentResolver();
        this.mListener = r3;
        this.mImportRequest = r4;
        this.mJobId = r5;
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onEntryCreated(VCardEntry r8) {
        int r5 = this.mCurrentCount + 1;
        this.mCurrentCount = r5;
        VCardImportExportListener r1 = this.mListener;
        if (r1 == null) goto L6;
        r1.onImportParsed(this.mImportRequest, this.mJobId, r8, r5, this.mTotalCount);
        return;
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        runInternal();     // Catch: Throwable -> L15 RuntimeException -> L17 OutOfMemoryError -> L20
        if (isCancelled() == false) goto L8;
        VCardImportExportListener r1 = this.mListener;     // Catch: Throwable -> L15 RuntimeException -> L17 OutOfMemoryError -> L20
        if (r1 == null) goto L8;
        r1.onImportCanceled(this.mImportRequest, this.mJobId);     // Catch: Throwable -> L15 RuntimeException -> L17 OutOfMemoryError -> L20
    L8:
        monitor-enter(this);
        this.mDone = true;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        monitor-enter(this);
        this.mDone = true;     // Catch: Throwable -> L27
        throw th;
    L27:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "OutOfMemoryError thrown during import", e);     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L17:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "RuntimeException thrown during import", e);     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    }

    private void runInternal() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, String.format("vCard import (id: %d) has started.", new Object[]{Integer.valueOf(this.mJobId)}));
        ImportRequest r2 = this.mImportRequest;
        if (isCancelled() == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Canceled before actually handling parameter (" + r2.uri + ")");
        return;
    L7:
        if (r2.vcardVersion != 0) goto L9;
        int[] r5 = {1, 2};
    L10:
        int[] r13 = r5;
        Uri r6 = r2.uri;
        Account r7 = r2.account;
        int r10 = r2.estimatedVCardType;
        String r11 = r2.estimatedCharset;
        this.mTotalCount += r2.entryCount;
        VCardEntryConstructor r12 = new VCardEntryConstructor(r10, r7, r11);
        VCardEntryCommitter r8 = new VCardEntryCommitter(this.mResolver);
        r12.addEntryHandler(r8);
        r12.addEntryHandler(this);
        InputStream r14 = null;
        if (r6 == null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "start importing one vCard (Uri: " + r6 + ")");     // Catch: Throwable -> L28 IOException -> L32
        InputStream r0 = this.mResolver.openInputStream(r6);     // Catch: Throwable -> L28 IOException -> L32
    L18:
        if (r0 != null) goto L66;
        boolean r3 = false;
    L25:
        if (r0 != null) goto L60;
    L36:
        this.mService.handleFinishImportNotification(this.mJobId, r3);
        if (r3 == true) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to read one vCard file: " + r6);
        this.mFailedUris.add(r6);
        return;
    L39:
        if (isCancelled() == false) goto L41;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "vCard import has been canceled (uri: " + r6 + ")");
        return;
    L41:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Successfully finished importing one vCard file: " + r6);
        ArrayList<Uri> r1 = r8.getCreatedUris();
        if (this.mListener == null) goto L69;
        if (r1 != null) goto L45;
    L47:
        if (r1 != null) goto L49;
    L50:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Created Uris is null or 0 length though the creation itself is successful.");
    L51:
        this.mListener.onImportFinished(this.mImportRequest, this.mJobId, null);
        return;
    L49:
        if (r1.size() != 0) goto L51;
    L45:
        if (r1.size() != 1) goto L47;
        this.mListener.onImportFinished(this.mImportRequest, this.mJobId, r1.get(0));
        return;
    L69:
        return;
    L60:
        r0.close();     // Catch: Exception -> L54
        goto L36
    L66:
        r3 = readOneVCard(r0, r10, r11, r12, r13);     // Catch: Throwable -> L22 IOException -> L56
    L22:
        th = th;
        r14 = r0;
    L29:
        if (r14 != null) goto L58;
    L31:
        throw th;
    L58:
        r14.close();     // Catch: Exception -> L55
    L33:
        if (r0 != null) goto L62;
    L35:
        r3 = false;
        goto L36
    L62:
        r0.close();     // Catch: Exception -> L57
        goto L35
    L14:
        if (r2.data == null) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "start importing one vCard (byte[])");     // Catch: Throwable -> L28 IOException -> L32
        r0 = new ByteArrayInputStream(r2.data);     // Catch: Throwable -> L28 IOException -> L32
        goto L18
    L17:
        r0 = null;
    L32:
        r0 = null;
    L28:
        th = th;
        goto L29
    L9:
        r5 = new int[]{r2.vcardVersion};
        goto L10
    }

    private boolean readOneVCard(InputStream r7, int r8, String r9, VCardInterpreter r10, int[] r11) {
        int r12 = r11.length;
        int r1 = 0;
    L3:
        if (r1 >= r12) goto L74;
        int r2 = r11[r1];
        if (r1 <= 0) goto L9;
    L27:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, e.toString());     // Catch: Throwable -> L25
        if (r7 == null) goto L48;
    L64:
        r7.close();     // Catch: IOException -> L55
    L48:
        r1 = r1 + 1;
    L25:
        th = move-exception;
        if (r7 != null) goto L58;
    L51:
        throw th;
    L58:
        r7.close();     // Catch: IOException -> L54
    L41:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Nested Exception is found.");     // Catch: Throwable -> L25
        if (r7 == null) goto L48;
    L44:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "IOException was emitted: " + e.getMessage());     // Catch: Throwable -> L25
        if (r7 == null) goto L48;
    L37:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, e.toString());     // Catch: Throwable -> L25
        if (r7 == null) goto L48;
    L7:
        if ((r10 instanceof VCardEntryConstructor) == false) goto L9;
        ((VCardEntryConstructor) r10).clear();     // Catch: Throwable -> L25 VCardException -> L27 VCardVersionException -> L32 VCardNotSupportedException -> L37 VCardNestedException -> L41 IOException -> L44
        goto L9
    L33:
        if (r1 != (r12 - 1)) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Appropriate version for this vCard is not found.");     // Catch: Throwable -> L25
    L35:
        if (r7 == null) goto L48;
    L9:
        monitor-enter(this);     // Catch: Throwable -> L25 VCardException -> L27 VCardVersionException -> L32 VCardNotSupportedException -> L37 VCardNestedException -> L41 IOException -> L44
        if (r2 != 2) goto L13;
        VCardParser r3 = new VCardParser_V30(r8);     // Catch: Throwable -> L22
    L14:
        this.mVCardParser = r3;     // Catch: Throwable -> L22
        if (isCancelled() == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "ImportProcessor already recieves cancel request, so send cancel request to vCard parser too.");     // Catch: Throwable -> L22
        this.mVCardParser.cancel();     // Catch: Throwable -> L22
    L17:
        monitor-exit(this);     // Catch: Throwable -> L22
        this.mVCardParser.parse(r7, r10);     // Catch: Throwable -> L25 VCardException -> L27 VCardVersionException -> L32 VCardNotSupportedException -> L37 VCardNestedException -> L41 IOException -> L44
        if (r7 != null) goto L61;
    L21:
        return true;
    L61:
        r7.close();     // Catch: IOException -> L53
        goto L21
    L13:
        r3 = new VCardParser_V21(r8);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25 VCardException -> L27 VCardVersionException -> L32 VCardNotSupportedException -> L37 VCardNestedException -> L41 IOException -> L44
    L74:
        return false;
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean cancel(boolean r2) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.mDone == false) goto L6;
    L19:
        monitor-exit(this);
        return false;
    L6:
        if (this.mCanceled == true) goto L19;
        this.mCanceled = true;     // Catch: Throwable -> L22
        monitor-enter(this);     // Catch: Throwable -> L22
        VCardParser r0 = this.mVCardParser;     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        r0.cancel();     // Catch: Throwable -> L16
    L13:
        monitor-exit(this);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.mCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.contacts.common.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean isDone() {
        monitor-enter(this);
        boolean r0 = this.mDone;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
