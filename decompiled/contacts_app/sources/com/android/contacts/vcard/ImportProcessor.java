package com.android.contacts.vcard;

import android.accounts.Account;
import android.content.ContentResolver;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.contacts.TrackOptUtils;
import com.android.contacts.util.NotificationManagerHelper;
import com.android.vcard.VCardConfig;
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

/* JADX INFO: loaded from: classes2.dex */
public class ImportProcessor extends ProcessorBase implements VCardEntryHandler {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardImport";
    private boolean mAllowJoin;
    private volatile boolean mCanceled;
    private int mCurrentCount;
    private volatile boolean mDone;
    private final List<Uri> mFailedUris;
    private final ImportRequest mImportRequest;
    private final int mJobId;
    private final VCardImportExportListener mListener;
    private final NotificationManagerHelper mNotificationHelper;
    private final ContentResolver mResolver;
    private final VCardService mService;
    private int mTotalCount;
    private VCardParser mVCardParser;

    @Override // com.android.contacts.vcard.ProcessorBase
    public final int getType() {
        return 1;
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onEnd() {
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onStart() {
    }

    static {
        DEBUG = VCardService.DEBUG;
    }

    public ImportProcessor(VCardService r2, VCardImportExportListener r3, ImportRequest r4, int r5) {
        this.mFailedUris = new ArrayList();
        this.mCurrentCount = 0;
        this.mTotalCount = 0;
        this.mAllowJoin = true;
        this.mService = r2;
        this.mResolver = r2.getContentResolver();
        this.mListener = r3;
        this.mImportRequest = r4;
        this.mJobId = r5;
        this.mNotificationHelper = new NotificationManagerHelper();
    }

    public ImportProcessor(VCardService r1, VCardImportExportListener r2, ImportRequest r3, int r4, boolean r5) {
        this(r1, r2, r3, r4);
        this.mAllowJoin = r5;
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onEntryCreated(VCardEntry r8) {
        this.mCurrentCount++;
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (this.mNotificationHelper.shouldNotifyNotificationLimit() == false) goto L9;
        this.mListener.onImportParsed(this.mImportRequest, this.mJobId, r8, this.mCurrentCount, this.mTotalCount);
        return;
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.RunnableFuture, java.lang.Runnable
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
        int[] r1 = {1, 2};
    L10:
        int[] r12 = r1;
        Uri r3 = r2.uri;
        Account r5 = r2.account;
        int r9 = r2.estimatedVCardType | VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING;
        String r10 = r2.estimatedCharset;
        int r8 = this.mTotalCount + r2.entryCount;
        this.mTotalCount = r8;
        TrackOptUtils.trackDeleteOperation("vcd", String.valueOf(r8));
        VCardEntryConstructor r11 = new VCardEntryConstructor(r9, r5, r10);
        VCardEntryCommitter r6 = new VCardEntryCommitter(this.mResolver);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Allow join contacts when import vcard: " + this.mAllowJoin);
        r6.setAllowJoin(this.mAllowJoin);
        r11.addEntryHandler(r6);
        r11.addEntryHandler(this);
        InputStream r13 = null;
        if (r3 == null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "start importing one vCard (Uri: " + r3 + ")");     // Catch: Throwable -> L28 IOException -> L32
        InputStream r0 = this.mResolver.openInputStream(r3);     // Catch: Throwable -> L28 IOException -> L32
    L18:
        if (r0 != null) goto L60;
        boolean r4 = false;
    L25:
        if (r0 != null) goto L54;
    L36:
        if (r4 == true) goto L38;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Failed to read one vCard file: " + r3);
        this.mFailedUris.add(r3);
    L48:
        this.mService.handleFinishImportNotification(this.mJobId, r4);
        return;
    L38:
        if (isCancelled() == false) goto L40;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "vCard import has been canceled (uri: " + r3 + ")");
        goto L48
    L40:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "Successfully finished importing one vCard file: " + r3);
        ArrayList<Uri> r7 = r6.getCreatedUris();
        if (this.mListener == null) goto L48;
        if (r7 != null) goto L44;
    L46:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Created Uris is null or 0 length though the creation itself is successful.");
        this.mListener.onImportFinished(this.mImportRequest, this.mJobId, null);
        goto L48
    L44:
        if (r7.size() <= 0) goto L46;
        this.mListener.onImportFinished(this.mImportRequest, this.mJobId, r7.get(0));
        goto L48
    L54:
        r0.close();     // Catch: Exception -> L50
        goto L36
    L60:
        r4 = readOneVCard(r0, r9, r10, r11, r12);     // Catch: Throwable -> L22 IOException -> L52
    L22:
        th = th;
        r13 = r0;
    L29:
        if (r13 != null) goto L58;
    L31:
        throw th;
    L58:
        r13.close();     // Catch: Exception -> L51
    L33:
        if (r0 != null) goto L56;
    L35:
        r4 = false;
        goto L36
    L56:
        r0.close();     // Catch: Exception -> L53
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
        r1 = new int[]{r2.vcardVersion};
        goto L10
    }

    private boolean readOneVCard(InputStream r7, int r8, String r9, VCardInterpreter r10, int[] r11) {
        int r12 = r11.length;
        int r1 = 0;
    L3:
        if (r1 >= r12) goto L79;
        int r2 = r11[r1];
        if (r1 <= 0) goto L9;
    L25:
        th = move-exception;
        if (r7 != null) goto L60;
    L55:
        throw th;
    L60:
        r7.close();     // Catch: IOException -> L58
    L48:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "IOException was emitted: " + e.getMessage());     // Catch: Throwable -> L25
        if (r7 == null) goto L52;
    L68:
        r7.close();     // Catch: IOException -> L59
    L52:
        r1 = r1 + 1;
    L45:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Nested Exception is found.");     // Catch: Throwable -> L25
        if (r7 == null) goto L52;
    L41:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, e.toString());     // Catch: Throwable -> L25
        if (r7 == null) goto L52;
    L32:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, e.toString());     // Catch: Throwable -> L25
        if (r7 == null) goto L52;
    L27:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "ArrayIndexOutOfBoundsException is found.");     // Catch: Throwable -> L25
        e.printStackTrace();     // Catch: Throwable -> L25
        if (r7 == null) goto L52;
    L7:
        if ((r10 instanceof VCardEntryConstructor) == false) goto L9;
        ((VCardEntryConstructor) r10).clear();     // Catch: Throwable -> L25 ArrayIndexOutOfBoundsException -> L27 VCardException -> L32 VCardVersionException -> L36 VCardNotSupportedException -> L41 VCardNestedException -> L45 IOException -> L48
        goto L9
    L37:
        if (r1 != (r12 - 1)) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Appropriate version for this vCard is not found.");     // Catch: Throwable -> L25
    L39:
        if (r7 == null) goto L52;
    L9:
        monitor-enter(this);     // Catch: Throwable -> L25 ArrayIndexOutOfBoundsException -> L27 VCardException -> L32 VCardVersionException -> L36 VCardNotSupportedException -> L41 VCardNestedException -> L45 IOException -> L48
        if (r2 != 2) goto L13;
        VCardParser r3 = new VCardParser_V30(r8);     // Catch: Throwable -> L22
    L14:
        this.mVCardParser = r3;     // Catch: Throwable -> L22
        if (isCancelled() == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(LOG_TAG, "ImportProcessor already recieves cancel request, so send cancel request to vCard parser too.");     // Catch: Throwable -> L22
        this.mVCardParser.cancel();     // Catch: Throwable -> L22
    L17:
        monitor-exit(this);     // Catch: Throwable -> L22
        this.mVCardParser.parse(r7, r10);     // Catch: Throwable -> L25 ArrayIndexOutOfBoundsException -> L27 VCardException -> L32 VCardVersionException -> L36 VCardNotSupportedException -> L41 VCardNestedException -> L45 IOException -> L48
        if (r7 != null) goto L65;
    L21:
        return true;
    L65:
        r7.close();     // Catch: IOException -> L57
        goto L21
    L13:
        r3 = new VCardParser_V21(r8);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25 ArrayIndexOutOfBoundsException -> L27 VCardException -> L32 VCardVersionException -> L36 VCardNotSupportedException -> L41 VCardNestedException -> L45 IOException -> L48
    L79:
        return false;
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean cancel(boolean r2) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(LOG_TAG, "ImportProcessor received cancel request");     // Catch: Throwable -> L25
    L7:
        if (this.mDone == false) goto L9;
    L22:
        monitor-exit(this);
        return false;
    L9:
        if (this.mCanceled == true) goto L22;
        this.mCanceled = true;     // Catch: Throwable -> L25
        monitor-enter(this);     // Catch: Throwable -> L25
        VCardParser r0 = this.mVCardParser;     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        r0.cancel();     // Catch: Throwable -> L19
    L16:
        monitor-exit(this);     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.mCanceled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.contacts.vcard.ProcessorBase, java.util.concurrent.Future
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
