package com.android.contacts.util;

import android.content.AsyncQueryHandler;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.PhoneCallDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class BlackListQueryHandler {
    private static final String AUTHORITY = "com.obric.nodisturb.provider";
    private static final String COLUMN_NAME = "bl_note";
    public static final String COLUMN_NUMBER = "bl_phone_number";
    private static final String COLUMN_PHOTO = "bl_photo";
    public static final Uri JOIN_OR_REMOVE_URI = null;
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";
    public static final String KEY_PHOTO = "photo";
    public static final String TAG = "BlackListQueryHandler";
    private static final int TOKEN_IS_ALL_IN_BLACKLIST = 4;
    private static final int TOKEN_IS_IN_BLACKLIST = 1;
    private static final int TOKEN_JOIN_BLACKLIST = 2;
    private static final int TOKEN_REMOVE_FROM_BLACKLIST = 3;
    private final Uri CHECK_NUMBER_URI;
    private BlackListChangeListener mCallback;
    private ContentResolver mContentResolver;
    private Context mContext;
    private QueryHandler mQueryHandler;
    private ExecutorService mThreadPool;

    public interface BlackListChangeListener {
        void updateUIForBlacklist(boolean r1, boolean r2);
    }

    public static class JoinBlackListTask extends AsyncTask<PhoneCallDetails, Void, HashMap<String, Object>> {
        private BlackListQueryHandler blackListQueryHandler;
        private Context context;
        private ContentResolver cr;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ HashMap<String, Object> doInBackground(PhoneCallDetails[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(HashMap<String, Object> r1) {
            onPostExecute2(r1);
        }

        public JoinBlackListTask(Context r1, BlackListQueryHandler r2) {
            this.context = r1;
            this.cr = r1.getContentResolver();
            this.blackListQueryHandler = r2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected HashMap<String, Object> doInBackground2(PhoneCallDetails... r9) {
            PhoneCallDetails r10 = r9[0];
            HashMap<String, Object> r1 = new HashMap();
            r1.put("name", r10.name);
            r1.put("number", r10.number);
            String r5 = "photo_id=" + r10.photoId + " AND mimetype = \"vnd.android.cursor.item/photo\"";
            Cursor r11 = null;
            r11 = this.cr.query(ContactsContract.Data.CONTENT_URI, new String[]{BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG}, r5, null, null);     // Catch: Throwable -> L15
            if (r11 != null) goto L6;
        L12:
            if (r11 == null) goto L14;
            r11.close();
        L14:
            return r1;
        L6:
            if (r11.moveToFirst() == false) goto L12;
            byte[] r8 = r11.getBlob(0);     // Catch: Throwable -> L15
            if (r8 == null) goto L12;
            if (r8.length <= 0) goto L12;
            r1.put(BlackListQueryHandler.KEY_PHOTO, r8);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (r11 == null) goto L18;
            r11.close();
        L18:
            throw th;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(HashMap<String, Object> r4) {
            String r0 = (String) r4.get("name");
            String r1 = (String) r4.get("number");
            byte[] r5 = (byte[]) r4.get(BlackListQueryHandler.KEY_PHOTO);
            this.blackListQueryHandler.doJoinBlacklistAction(r0, r5, r1);
        }
    }

    private class MultiHandleBlacklistTask extends AsyncTask<ArrayList<HashMap<String, Object>>, Void, Boolean> {
        public static final int DELETE = 2;
        public static final int INSERT = 1;
        private int action;
        private ContentResolver resolver;
        final /* synthetic */ BlackListQueryHandler this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(ArrayList<HashMap<String, Object>>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        public MultiHandleBlacklistTask(BlackListQueryHandler r1, int r2, ContentResolver r3) {
            this.this$0 = r1;
            this.action = r2;
            this.resolver = r3;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(ArrayList<HashMap<String, Object>>... r9) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(BlackListQueryHandler.TAG, "execute doInBackground");
            ArrayList<HashMap<String, Object>> r10 = r9[0];
            int r1 = this.action;
            if (r1 != 1) goto L26;
            ArrayList<ContentProviderOperation> r0 = new ArrayList();
            Iterator<HashMap<String, Object>> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L46;
            HashMap<String, Object> r2 = r11.next();
            String r5 = (String) r2.get("number");
            if (TextUtils.isEmpty(r5.trim()) == true) goto L6;
            ContentProviderOperation.Builder r6 = ContentProviderOperation.newInsert(BlackListQueryHandler.JOIN_OR_REMOVE_URI);
            r6.withValue(BlackListQueryHandler.COLUMN_NUMBER, r5);
            String r7 = (String) r2.get("name");
            if (TextUtils.isEmpty(r7) == true) goto L13;
            r6.withValue(BlackListQueryHandler.COLUMN_NAME, r7);
        L13:
            byte[] r3 = (byte[]) r2.get(BlackListQueryHandler.KEY_PHOTO);
            if (r3 != null) goto L16;
        L18:
            r0.add(r6.build());
            goto L6
        L16:
            if (r3.length <= 0) goto L18;
            r6.withValue(BlackListQueryHandler.COLUMN_PHOTO, r3);
            goto L18
        L46:
            this.resolver.applyBatch("com.obric.nodisturb.provider", r0);     // Catch: OperationApplicationException -> L21 RemoteException -> L23
            return true;
        L21:
            e = move-exception;
            e.printStackTrace();
            return null;
        L23:
            e = move-exception;
            e.printStackTrace();
            return null;
        L26:
            if (r1 != 2) goto L43;
            ArrayList<ContentProviderOperation> r4 = new ArrayList();
            Iterator<HashMap<String, Object>> r12 = r10.iterator();
        L29:
            if (r12.hasNext() == false) goto L44;
            String r8 = (String) r12.next().get("number");
            if (TextUtils.isEmpty(r8.trim()) == true) goto L29;
            String[] r13 = {r8};
            ContentProviderOperation.Builder r14 = ContentProviderOperation.newDelete(BlackListQueryHandler.JOIN_OR_REMOVE_URI);
            r14.withSelection("PHONE_NUMBERS_EQUAL(bl_phone_number, ?)", r13);
            r4.add(r14.build());
            goto L29
        L44:
            this.resolver.applyBatch("com.obric.nodisturb.provider", r4);     // Catch: OperationApplicationException -> L36 RemoteException -> L38
            return false;
        L36:
            e = move-exception;
            e.printStackTrace();
            return null;
        L38:
            e = move-exception;
            e.printStackTrace();
            return null;
        L43:
            throw new IllegalArgumentException("error action for this task.");
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r3) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(BlackListQueryHandler.TAG, "execute onPostExecute");
            if (r3 != null) goto L5;
            return;
        L5:
            if (BlackListQueryHandler.access$000(this.this$0) == null) goto L9;
            BlackListQueryHandler.access$000(this.this$0).updateUIForBlacklist(r3.booleanValue(), true);
            return;
        }
    }

    private class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ BlackListQueryHandler this$0;

        public QueryHandler(BlackListQueryHandler r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r3, Object r4, Cursor r5) {
            boolean r0 = true;
            if (r3 != 1) goto L20;
            if (r5 != null) goto L39;
        L10:
            r0 = false;
        L12:
            if (BlackListQueryHandler.access$000(this.this$0) == null) goto L14;
            BlackListQueryHandler.access$000(this.this$0).updateUIForBlacklist(r0, false);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            if (r5 == null) goto L18;
            r5.close();
        L18:
            throw th;
        L14:
            if (r5 == null) goto L36;
            r5.close();
            return;
        L36:
            return;
        L39:
            if (r5.moveToFirst() == false) goto L10;
        L20:
            if (r3 != 4) goto L42;
            if (r5 != null) goto L37;
        L27:
            r0 = false;
        L29:
            if (BlackListQueryHandler.access$000(this.this$0) == null) goto L31;
            BlackListQueryHandler.access$000(this.this$0).updateUIForBlacklist(r0, false);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            if (r5 == null) goto L35;
            r5.close();
        L35:
            throw th;
        L31:
            if (r5 == null) goto L43;
            r5.close();
            return;
        L43:
            return;
        L37:
            if (r5.getCount() <= 0) goto L27;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int r1, Object r2, int r3) {
            if (r1 == 3) goto L5;
            return;
        L5:
            if (r3 > 0) goto L7;
            boolean r4 = true;
        L9:
            if (BlackListQueryHandler.access$000(this.this$0) == null) goto L13;
            BlackListQueryHandler.access$000(this.this$0).updateUIForBlacklist(r4, true);
            return;
        L13:
            return;
        L7:
            r4 = false;
            goto L9
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int r1, Object r2, Uri r3) {
            if (r1 == 2) goto L5;
            return;
        L5:
            if (r3 == null) goto L7;
            boolean r4 = true;
        L9:
            if (BlackListQueryHandler.access$000(this.this$0) == null) goto L13;
            BlackListQueryHandler.access$000(this.this$0).updateUIForBlacklist(r4, true);
            return;
        L13:
            return;
        L7:
            r4 = false;
            goto L9
        }
    }

    static /* synthetic */ BlackListChangeListener access$000(BlackListQueryHandler r0) {
        return r0.mCallback;
    }

    static {
        JOIN_OR_REMOVE_URI = Uri.parse("content://com.obric.nodisturb.provider/blacklist");
    }

    public BlackListQueryHandler(Context r2) {
        this.CHECK_NUMBER_URI = Uri.parse("content://com.obric.nodisturb.provider/inblacklist");
        Context r3 = r2.getApplicationContext();
        this.mContext = r3;
        this.mContentResolver = r3.getContentResolver();
        this.mThreadPool = Executors.newCachedThreadPool();
        this.mQueryHandler = new QueryHandler(this, this.mContentResolver);
    }

    public void initBlacklist(String r10) {
        Uri r4 = Uri.withAppendedPath(this.CHECK_NUMBER_URI, r10);
        this.mQueryHandler.startQuery(1, null, r4, null, "deleted = 0", null, null);
    }

    public void initBlacklist(ArrayList<String> r10) {
        Iterator<String> r0 = r10.iterator();
        String r1 = "deleted = 0 AND (";
        boolean r2 = true;
    L4:
        if (r0.hasNext() == false) goto L9;
        String r3 = r0.next();
        if (r2 == true) goto L7;
        r1 = r1 + " or PHONE_NUMBERS_EQUAL (bl_phone_number,'" + r3 + "')";
        goto L4
    L7:
        r1 = r1 + "PHONE_NUMBERS_EQUAL (bl_phone_number,'" + r3 + "')";
        r2 = false;
        goto L4
    L9:
        this.mQueryHandler.startQuery(4, Integer.valueOf(r10.size()), JOIN_OR_REMOVE_URI, null, r1 + ")", null, null);
    }

    public void doJoinBlacklistAction(String r2) {
        doJoinBlacklistAction(null, null, r2);
    }

    public void doJoinBlacklistAction(String r3, byte[] r4, String r5) {
        if (TextUtils.isEmpty(r5.trim()) == false) goto L5;
        return;
    L5:
        ContentValues r0 = new ContentValues();
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0.put(COLUMN_NAME, r3);
    L8:
        if (r4 != null) goto L10;
    L12:
        r0.put(COLUMN_NUMBER, r5);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "doJoinBlacklistAction");
        this.mQueryHandler.startInsert(2, null, JOIN_OR_REMOVE_URI, r0);
        return;
    L10:
        if (r4.length <= 0) goto L12;
        r0.put(COLUMN_PHOTO, r4);
        goto L12
    }

    public void doMultiJoinBlacklistAction(ArrayList<HashMap<String, Object>> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L9;
        new MultiHandleBlacklistTask(this, 1, this.mContentResolver).executeOnExecutor(this.mThreadPool, new ArrayList[]{r4});
        return;
    }

    public void doRemoveBlacklistAction(String r7) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "doRemoveBlacklistAction ");
        this.mQueryHandler.startDelete(3, null, JOIN_OR_REMOVE_URI, "PHONE_NUMBERS_EQUAL(bl_phone_number, ?)", new String[]{r7});
    }

    public void doMultiRemoveBlacklistAction(ArrayList<HashMap<String, Object>> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L9;
        new MultiHandleBlacklistTask(this, 2, this.mContentResolver).executeOnExecutor(this.mThreadPool, new ArrayList[]{r4});
        return;
    }

    public void setCallback(BlackListChangeListener r1) {
        this.mCallback = r1;
    }
}
