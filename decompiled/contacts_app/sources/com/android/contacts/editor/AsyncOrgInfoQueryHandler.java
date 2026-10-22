package com.android.contacts.editor;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.util.BytedanceContactContract;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncOrgInfoQueryHandler extends Handler {
    public static final int TOKEN_MARK = 40;
    public static final int TOKEN_QUERY_ALL = 20;
    public static final int TOKEN_QUERY_COUNT = 10;
    public static final int TOKEN_QUERY_KEY = 30;
    private static Looper sLooper;
    final WeakReference<ContentResolver> mResolver;
    private Handler mWorkerThreadHandler;

    protected class WorkerHandler extends Handler {
        final /* synthetic */ AsyncOrgInfoQueryHandler this$0;

        public WorkerHandler(AsyncOrgInfoQueryHandler r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r18) {
            Message r2 = this.this$0.obtainMessage(r18.what, r18.arg1, r18.arg2, r18.obj);
            int r3 = r18.what;
            if (r3 != 10) goto L5;
        L14:
            String r1 = (String) r18.obj;
            Uri r9 = AsyncOrgInfoQueryHandler.access$000(this.this$0);
            String[] r4 = AsyncOrgInfoQueryHandler.access$100(this.this$0);
            String r11 = AsyncOrgInfoQueryHandler.access$200(this.this$0, r1, null);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AsyncOrgInfoQueryHandler", "handleMessage: " + r9 + ", " + r4 + ", " + r11);
            Cursor r8 = this.this$0.mResolver.get().query(r9, r4, r11, null, null);
            if (r8 != null) goto L17;
        L19:
            String r10 = null;
        L20:
            Uri r12 = AsyncOrgInfoQueryHandler.access$300(this.this$0);
            String r13 = AsyncOrgInfoQueryHandler.access$200(this.this$0, r1, r10);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AsyncOrgInfoQueryHandler", "handleMessage: " + r12 + ", " + r4 + ", " + r13);
            r2.obj = new MergeCursor(new Cursor[]{r8, this.this$0.mResolver.get().query(r12, r4, r13, null, "data14 DESC ")});
        L21:
            r2.setTarget(this.this$0);
            r2.sendToTarget();
            return;
        L17:
            if (r8.moveToFirst() == false) goto L19;
            r10 = r8.getString(1);
            goto L20
        L5:
            if (r3 == 20) goto L14;
            if (r3 == 30) goto L14;
            if (r3 != 40) goto L21;
            String r5 = (String) r18.obj;
            if (TextUtils.isEmpty(r5) == true) goto L21;
            Uri r6 = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "data");
            String[] r7 = {"vnd.android.cursor.item/organization", r5};
            ContentValues r14 = new ContentValues();
            r14.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, 1);
            this.this$0.mResolver.get().update(r6, r14, "mimetype=? AND data1=?", r7);
            this.this$0.mResolver.get().update(AsyncOrgInfoQueryHandler.access$000(this.this$0), r14, "mimetype=? AND data1=?", r7);
            goto L21
        }
    }

    static {
    }

    protected abstract void onMarkComplete(int r1);

    protected abstract void onQueryComplete(int r1, Cursor r2);

    static /* synthetic */ Uri access$000(AsyncOrgInfoQueryHandler r0) {
        return r0.getProfileUri();
    }

    static /* synthetic */ String[] access$100(AsyncOrgInfoQueryHandler r0) {
        return r0.getProjection();
    }

    static /* synthetic */ String access$200(AsyncOrgInfoQueryHandler r0, String r1, String r2) {
        return r0.getSelection(r1, r2);
    }

    static /* synthetic */ Uri access$300(AsyncOrgInfoQueryHandler r0) {
        return r0.getUri();
    }

    public AsyncOrgInfoQueryHandler(ContentResolver r3) {
        this.mResolver = new WeakReference(r3);
        monitor-enter(AsyncQueryHandler.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sLooper != null) goto L7;
        HandlerThread r0 = new HandlerThread("AsyncOrgInfoQueryHandler");     // Catch: Throwable -> L10
        r0.start();     // Catch: Throwable -> L10
        sLooper = r0.getLooper();     // Catch: Throwable -> L10
    L7:
        this.mWorkerThreadHandler = new WorkerHandler(this, sLooper);     // Catch: Throwable -> L10
        monitor-exit(AsyncQueryHandler.class);     // Catch: Throwable -> L10
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 10) goto L5;
    L12:
        onQueryComplete(r3.what, (Cursor) r3.obj);
        return;
    L5:
        if (r0 == 20) goto L12;
        if (r0 == 30) goto L12;
        if (r0 != 40) goto L15;
        onMarkComplete(r3.what);
        return;
    }

    private String getSelection(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r3 = r3.replace("'", "''");
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r4 = r4.replace("'", "''");
    L9:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        String r2 = "mimetype = 'vnd.android.cursor.item/organization' AND (data15 is null or data15 <> 1) AND data1 IS NOT NULL AND data1 <> ''";
    L13:
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return r2;
    L15:
        return r2 + " AND data1 <> '" + r4 + "'";
    L11:
        r2 = "mimetype = 'vnd.android.cursor.item/organization' AND (data15 is null or data15 <> 1) AND data1 <> '" + r3 + "' AND data1 like '%" + r3 + "%'";
        goto L13
    }

    private Uri getUri() {
        return Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "data/groupby_data1").buildUpon().appendQueryParameter("mergeMaxData14", "true").build();
    }

    private Uri getProfileUri() {
        return Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "profile/data");
    }

    private String[] getProjection() {
        return new String[]{"_id", "data1", "data14"};
    }

    public void startQuery(int r1, String r2) {
        this.mWorkerThreadHandler.obtainMessage(r1, r2).sendToTarget();
    }

    public void startMark(int r1, String r2) {
        this.mWorkerThreadHandler.obtainMessage(40, r2).sendToTarget();
    }
}
