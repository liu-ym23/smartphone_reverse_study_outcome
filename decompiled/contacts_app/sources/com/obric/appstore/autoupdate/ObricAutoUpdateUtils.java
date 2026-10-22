package com.obric.appstore.autoupdate;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class ObricAutoUpdateUtils {
    private static final String APP_UPDATE_SDK_VERSION = "client_ver";
    public static final String INTENT_EXTRAS_FILE_EXIST = "auto_update_file_exist";
    public static final String INTENT_EXTRAS_LOG = "auto_update_log";
    public static final String INTENT_EXTRAS_MD5 = "auto_update_md5";
    public static final String INTENT_EXTRAS_MODEL = "auto_update_model";
    public static final String INTENT_EXTRAS_NAME = "auto_update_name";
    public static final String INTENT_EXTRAS_PACKAGE = "auto_update_pkg";
    public static final String INTENT_EXTRAS_PROGRESS = "auto_update_progress";
    public static final String INTENT_EXTRAS_SIZE = "auto_update_size";
    public static final String INTENT_EXTRAS_URL = "auto_update_url";
    public static final String INTENT_EXTRAS_USE_MOBILE = "useMobile";
    public static final String INTENT_EXTRAS_VERSION_CODE = "auto_update_version_code";
    public static final String INTENT_EXTRAS_VERSION_NAME = "auto_update_version_name";
    private static final String METHOD_APP_UPDATE = "checkAppUpdate";
    private static final String METHOD_DELAY_UPDATE = "delayUpdate";
    private static final String METHOD_GET_PRGRESS = "getDownloadProgress";
    private static final String METHOD_INSTALL = "installApp";
    private static final String METHOD_START_DOWNLOAD = "startDownload";
    private static final String METHOD_STOP_DOWNLOAD = "stopDownload";
    public static final int MODEL_FORCE_UPDATE = 2;
    private static final String TAG = "AutoUpdateUtils";
    private static final Uri URI = null;
    private static final int VERSION = 1;
    private static ObricAutoUpdateUtils mInstance;
    private AutoUpdateTask mTask;

    private class AutoUpdateTask extends AsyncTask<String, Void, Bundle> {
        private WeakReference<Context> mActivity;
        final /* synthetic */ ObricAutoUpdateUtils this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Bundle doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Bundle r1) {
            onPostExecute2(r1);
        }

        public AutoUpdateTask(ObricAutoUpdateUtils r1, Context r2) {
            this.this$0 = r1;
            this.mActivity = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Bundle doInBackground2(String... r6) {
            if (TextUtils.isEmpty(r6[0]) == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "pkg is null");
            return null;
        L6:
            Bundle r1 = new Bundle();
            r1.putString(ObricAutoUpdateUtils.INTENT_EXTRAS_PACKAGE, r6[0]);
            Context r7 = this.mActivity.get();
            if (r7 != null) goto L9;
        L13:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "network is not available.");
            return null;
        L9:
            if (this.this$0.isNetworkAvailable(r7.getApplicationContext()) == false) goto L13;
            Bundle r5 = ObricAutoUpdateUtils.access$000(this.this$0, r7, r1, ObricAutoUpdateUtils.METHOD_APP_UPDATE);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "AutoUpdateTask: " + r5);
            return r5;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Bundle r4) {
            if (isCancelled() == true) goto L28;
            if (r4 == null) goto L28;
            if (r4.isEmpty() == true) goto L28;
            Context r3 = this.mActivity.get();
            if (r3 != null) goto L13;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "activity is null");
            return;
        L13:
            if ((r3 instanceof Activity) == false) goto L26;
            Activity r0 = (Activity) r3;
            if (r0.isFinishing() == false) goto L19;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "context is null.");
            return;
        L19:
            if (r0.getWindow() != null) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "window is null.");
            return;
        L23:
            if (r0.isDestroyed() == false) goto L26;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "activity is destroyed.");
            return;
        L26:
            new FindNewVersionDialog(r3, r4).show();
            return;
        L28:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(ObricAutoUpdateUtils.TAG, "app update info is null.");
        }
    }

    static /* synthetic */ Bundle access$000(ObricAutoUpdateUtils r0, Context r1, Bundle r2, String r3) {
        return r0.contentProviderCall(r1, r2, r3);
    }

    static {
        URI = Uri.parse("content://com.bytedanceos.appstore.auto_update");
        mInstance = null;
    }

    private ObricAutoUpdateUtils() {
    }

    public static ObricAutoUpdateUtils getInstance() {
        if (mInstance != null) goto L6;
        mInstance = new ObricAutoUpdateUtils();
    L6:
        return mInstance;
    }

    public void stopDownload(Context r3, String r4) {
        Bundle r0 = new Bundle();
        r0.putString(INTENT_EXTRAS_PACKAGE, r4);
        contentProviderCall(r3, r0, METHOD_STOP_DOWNLOAD);
    }

    public void installApp(Context r2, String r3, Bundle r4) {
        r4.putString(INTENT_EXTRAS_NAME, r3);
        contentProviderCall(r2, r4, METHOD_INSTALL);
    }

    public void startDownload(Context r2, String r3, boolean r4, Bundle r5) {
        r5.putString(INTENT_EXTRAS_NAME, r3);
        r5.putBoolean(INTENT_EXTRAS_USE_MOBILE, r4);
        contentProviderCall(r2, r5, METHOD_START_DOWNLOAD);
    }

    public int getDownloadProgress(Context r3, String r4) {
        Bundle r0 = new Bundle();
        r0.putString(INTENT_EXTRAS_PACKAGE, r4);
        Bundle r2 = contentProviderCall(r3, r0, METHOD_GET_PRGRESS);
        if (r2 != null) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getDownloadProgress:extrais null");
        return -1;
    L5:
        return r2.getInt(INTENT_EXTRAS_PROGRESS);
    }

    public void delayUpdate(Context r3, String r4, int r5) {
        Bundle r0 = new Bundle();
        r0.putString(INTENT_EXTRAS_PACKAGE, r4);
        r0.putInt(INTENT_EXTRAS_VERSION_CODE, r5);
        contentProviderCall(r3, r0, METHOD_DELAY_UPDATE);
    }

    public void onStartCheckUpdate(Activity r3, String r4) {
        AutoUpdateTask r0 = this.mTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        AutoUpdateTask r1 = new AutoUpdateTask(this, r3);
        this.mTask = r1;
        r1.execute(new String[]{r4});
    }

    public void onDestoryCheckUpdate() {
        AutoUpdateTask r0 = this.mTask;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mTask = null;
        return;
    }

    public boolean isNetworkAvailable(Context r1) {
        ConnectivityManager r0 = (ConnectivityManager) r1.getSystemService("connectivity");
        if (r0 != null) goto L5;
        return false;
    L5:
        NetworkInfo r2 = r0.getActiveNetworkInfo();
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.isConnected();
    }

    private Bundle contentProviderCall(Context r4, Bundle r5, String r6) {
        if (r4 != null) goto L33;
        return null;
    L33:
        ContentProviderClient r7 = r4.getContentResolver().acquireUnstableContentProviderClient(URI);     // Catch: Throwable -> L18 RemoteException -> L20
        if (r7 != null) goto L10;
        if (r7 == null) goto L9;
        r7.close();
    L9:
        return null;
    L10:
        if (r5 == null) goto L30;
    L12:
        r5.putInt(APP_UPDATE_SDK_VERSION, 1);     // Catch: RemoteException -> L16 Throwable -> L26
        Bundle r3 = r7.call(r6, null, r5);     // Catch: RemoteException -> L16 Throwable -> L26
        if (r7 == null) goto L15;
        r7.close();
    L15:
        return r3;
    L16:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L26
        if (r7 == null) goto L25;
        r7.close();
    L25:
        return null;
    L26:
        Throwable th = th;
    L27:
        if (r7 == null) goto L29;
        r7.close();
    L29:
        throw th;
    L30:
        r5 = new Bundle();     // Catch: RemoteException -> L16 Throwable -> L26
        goto L12
    L20:
        e = e;
        r7 = null;
    L18:
        th = move-exception;
        r7 = null;
        th = th;
        goto L27
    }

    public void onStartCheckUpdateNoActivity(Context r3, String r4) {
        AutoUpdateTask r0 = this.mTask;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        AutoUpdateTask r1 = new AutoUpdateTask(this, r3);
        this.mTask = r1;
        r1.execute(new String[]{r4});
    }
}
