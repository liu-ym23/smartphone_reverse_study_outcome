package com.android.contacts.list;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class DirectoryListLoader extends AsyncTaskLoader<Cursor> {
    public static final String DIRECTORY_TYPE = "directoryType";
    private static final String[] RESULT_PROJECTION = null;
    public static final int SEARCH_MODE_CONTACT_SHORTCUT = 2;
    public static final int SEARCH_MODE_DATA_SHORTCUT = 3;
    public static final int SEARCH_MODE_DEFAULT = 1;
    public static final int SEARCH_MODE_NONE = 0;
    private static final String TAG = "ContactEntryListAdapter";
    private MatrixCursor mDefaultDirectoryList;
    private int mDirectorySearchMode;
    private boolean mLocalInvisibleDirectoryEnabled;
    private final ContentObserver mObserver;

    private static final class DirectoryQuery {
        public static final int DISPLAY_NAME = 3;
        public static final int ID = 0;
        public static final String ORDER_BY = "_id";
        public static final int PACKAGE_NAME = 1;
        public static final int PHOTO_SUPPORT = 4;
        public static final String[] PROJECTION = null;
        public static final int TYPE_RESOURCE_ID = 2;
        public static final Uri URI = null;

        private DirectoryQuery() {
        }

        static {
            URI = ContactsContract.Directory.CONTENT_URI;
            PROJECTION = new String[]{"_id", "packageName", "typeResourceId", "displayName", "photoSupport"};
        }
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    static {
        RESULT_PROJECTION = new String[]{"_id", "directoryType", "displayName", "photoSupport"};
    }

    public DirectoryListLoader(Context r2) {
        super(r2);
        final Handler r0 = new Handler();
        this.mObserver = new AnonymousClass1(this, r0);
    }

    public void setDirectorySearchMode(int r1) {
        this.mDirectorySearchMode = r1;
    }

    public void setLocalInvisibleDirectoryEnabled(boolean r1) {
        this.mLocalInvisibleDirectoryEnabled = r1;
    }

    @Override // android.content.Loader
    protected void onStartLoading() {
        getContext().getContentResolver().registerContentObserver(ContactsContract.Directory.CONTENT_URI, false, this.mObserver);
        forceLoad();
    }

    @Override // android.content.Loader
    protected void onStopLoading() {
        getContext().getContentResolver().unregisterContentObserver(this.mObserver);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        if (this.mDirectorySearchMode == 0) goto L5;
        MatrixCursor r0 = new MatrixCursor(RESULT_PROJECTION);
        Context r1 = getContext();
        PackageManager r2 = r1.getPackageManager();
        int r3 = this.mDirectorySearchMode;
        if (r3 == 1) goto L24;
        String r8 = "";
        if (r3 == 2) goto L19;
        if (r3 != 3) goto L17;
        if (this.mLocalInvisibleDirectoryEnabled == true) goto L15;
        r8 = " AND _id!=1";
    L15:
        String r14 = "shortcutSupport IN (2, 1)".concat(r8);
    L27:
        Cursor r15 = r1.getContentResolver().query(DirectoryQuery.URI, DirectoryQuery.PROJECTION, r14, null, "_id");
    L47:
        if (r15.moveToNext() == false) goto L42;
        long r9 = r15.getLong(0);     // Catch: Throwable -> L44
        String r4 = r15.getString(1);     // Catch: Throwable -> L44
        int r10 = r15.getInt(2);     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r4) == true) goto L39;
        if (r10 == 0) goto L39;
        if (r2 == null) goto L39;
        Resources r11 = r2.getResourcesForApplication(r4);     // Catch: Exception -> L38 Throwable -> L44
        if (r11 == null) goto L39;
        String r5 = r11.getString(r10);     // Catch: Exception -> L38 Throwable -> L44
    L40:
        r0.addRow(new Object[]{Long.valueOf(r9), r5, r15.getString(3), Integer.valueOf(r15.getInt(4))});     // Catch: Throwable -> L44
    L38:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot obtain directory type from package: " + r4);     // Catch: Throwable -> L44
    L39:
        r5 = null;
        goto L40
    L42:
        r15.close();
        return r0;
    L44:
        th = move-exception;
        r15.close();
        throw th;
    L17:
        throw new RuntimeException("Unsupported directory search mode: " + this.mDirectorySearchMode);
    L19:
        if (this.mLocalInvisibleDirectoryEnabled == true) goto L22;
        r8 = " AND _id!=1";
    L22:
        r14 = "shortcutSupport=2".concat(r8);
        goto L27
    L24:
        if (this.mLocalInvisibleDirectoryEnabled == false) goto L26;
        r14 = null;
        goto L27
    L26:
        r14 = "_id!=1";
        goto L27
    L5:
        return getDefaultDirectories();
    }

    private Cursor getDefaultDirectories() {
        if (this.mDefaultDirectoryList != null) goto L6;
        MatrixCursor r0 = new MatrixCursor(RESULT_PROJECTION);
        this.mDefaultDirectoryList = r0;
        r0.addRow(new Object[]{0L, getContext().getString(R.string.common_contacts), null});
        this.mDefaultDirectoryList.addRow(new Object[]{1L, getContext().getString(R.string.common_others), null});
    L6:
        return this.mDefaultDirectoryList;
    }

    @Override // android.content.Loader
    protected void onReset() {
        stopLoading();
    }
}
