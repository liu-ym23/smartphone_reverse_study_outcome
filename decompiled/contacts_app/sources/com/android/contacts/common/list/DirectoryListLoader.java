package com.android.contacts.common.list;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.loader.content.AsyncTaskLoader;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.DirectoryCompat;

/* JADX INFO: loaded from: classes.dex */
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

        private DirectoryQuery() {
        }

        static {
            PROJECTION = new String[]{"_id", "packageName", "typeResourceId", "displayName", "photoSupport"};
        }

        public static Uri getDirectoryUri(int r1) {
            if (r1 == 3) goto L10;
            if (r1 == 2) goto L10;
            return DirectoryCompat.getContentUri();
        L10:
            return ContactsContract.Directory.CONTENT_URI;
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
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

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        getContext().getContentResolver().registerContentObserver(DirectoryQuery.getDirectoryUri(this.mDirectorySearchMode), false, this.mObserver);
        forceLoad();
    }

    @Override // androidx.loader.content.Loader
    protected void onStopLoading() {
        getContext().getContentResolver().unregisterContentObserver(this.mObserver);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        if (this.mDirectorySearchMode == 0) goto L5;
        MatrixCursor r1 = new MatrixCursor(RESULT_PROJECTION);
        Context r2 = getContext();
        PackageManager r3 = r2.getPackageManager();
        int r4 = this.mDirectorySearchMode;
        Cursor r5 = null;
        if (r4 == 1) goto L15;
        if (r4 == 2) goto L13;
        if (r4 != 3) goto L12;
        String r6 = "shortcutSupport IN (2, 1)";
    L14:
        String r12 = r6;
    L52:
        Cursor r7 = r2.getContentResolver().query(DirectoryQuery.getDirectoryUri(this.mDirectorySearchMode), DirectoryQuery.PROJECTION, r12, null, "_id");     // Catch: Throwable -> L42 RuntimeException -> L51
        if (r7 != null) goto L57;
        if (r7 == null) goto L20;
        r7.close();
    L20:
        return r1;
    L57:
        if (r7.moveToNext() == false) goto L37;
        long r9 = r7.getLong(0);     // Catch: Throwable -> L39 RuntimeException -> L41
        if (this.mLocalInvisibleDirectoryEnabled == true) goto L28;
        if (DirectoryCompat.isInvisibleDirectory(r9) == true) goto L57;
    L28:
        String r11 = r7.getString(1);     // Catch: Throwable -> L39 RuntimeException -> L41
        int r13 = r7.getInt(2);     // Catch: Throwable -> L39 RuntimeException -> L41
        if (TextUtils.isEmpty(r11) == true) goto L34;
        if (r13 == 0) goto L34;
        String r14 = r3.getResourcesForApplication(r11).getString(r13);     // Catch: Exception -> L33 Throwable -> L39 RuntimeException -> L41
    L35:
        r1.addRow(new Object[]{Long.valueOf(r9), r14, r7.getString(3), Integer.valueOf(r7.getInt(4))});     // Catch: Throwable -> L39 RuntimeException -> L41
    L33:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot obtain directory type from package: " + r11);     // Catch: Throwable -> L39 RuntimeException -> L41
    L34:
        r14 = null;
        goto L35
    L37:
        if (r7 == null) goto L47;
        r7.close();
    L47:
        return r1;
    L41:
        r5 = r7;
    L39:
        th = th;
        r5 = r7;
    L48:
        if (r5 == null) goto L50;
        r5.close();
    L50:
        throw th;
    L42:
        th = th;
    L44:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Runtime Exception when querying directory");     // Catch: Throwable -> L42
        if (r5 == null) goto L47;
        r5.close();
        goto L47
    L12:
        throw new RuntimeException("Unsupported directory search mode: " + this.mDirectorySearchMode);
    L13:
        r6 = "shortcutSupport=2";
        goto L14
    L15:
        r12 = null;
        goto L52
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

    @Override // androidx.loader.content.Loader
    protected void onReset() {
        stopLoading();
    }
}
