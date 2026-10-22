package com.android.contacts;

import android.content.AsyncQueryHandler;
import android.database.Cursor;
import android.net.Uri;
import android.provider.VoicemailContract;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;

/* JADX INFO: loaded from: classes.dex */
public class CallDetailActivityQueryHandler extends AsyncQueryHandler {
    private static final int HAS_CONTENT_COLUMN_INDEX = 1;
    private static final int QUERY_VOICEMAIL_CONTENT_TOKEN = 101;
    private static final int QUERY_VOICEMAIL_STATUS_TOKEN = 102;
    private static final int SOURCE_PACKAGE_COLUMN_INDEX = 0;
    private static final String TAG = "CallDetail";
    private final String[] VOICEMAIL_CONTENT_PROJECTION;
    private final CallDetailActivity mCallDetailActivity;

    public CallDetailActivityQueryHandler(CallDetailActivity r3) {
        super(r3.getContentResolver());
        this.VOICEMAIL_CONTENT_PROJECTION = new String[]{"source_package", "has_content"};
        this.mCallDetailActivity = r3;
    }

    public void startVoicemailStatusQuery(Uri r9) {
        startQuery(101, null, r9, this.VOICEMAIL_CONTENT_PROJECTION, null, null, null);
    }

    @Override // android.content.AsyncQueryHandler
    protected synchronized void onQueryComplete(int r9, Object r10, Cursor r11) {
        monitor-enter(this);
        if (r9 != 101) goto L15;
        if (moveToFirst(r11) == true) goto L9;
    L11:
        this.mCallDetailActivity.updateVoicemailStatusMessage(null);     // Catch: Throwable -> L12
    L18:
        MoreCloseables.closeQuietly(r11);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L9:
        if (hasNoAudio(r11) == false) goto L11;
        startQuery(102, null, VoicemailContract.Status.buildSourceUri(getSourcePackage(r11)), VoicemailStatusHelperImpl.PROJECTION, null, null, null);     // Catch: Throwable -> L12
        goto L18
    L15:
        if (r9 != 102) goto L17;
        this.mCallDetailActivity.updateVoicemailStatusMessage(r11);     // Catch: Throwable -> L12
        goto L18
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknown query completed: ignoring: " + r9);     // Catch: Throwable -> L12
    L23:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        MoreCloseables.closeQuietly(r11);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    }

    private boolean moveToFirst(Cursor r1) {
        if (r1 != null) goto L4;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cursor not valid, could not move to first");
        return false;
    L4:
        if (r1.moveToFirst() == false) goto L8;
        return true;
    }

    private boolean hasNoAudio(Cursor r1) {
        if (r1.getInt(1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private String getSourcePackage(Cursor r1) {
        return r1.getString(0);
    }
}
