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
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class ObricAutoUpdateUtils {
    private static final String TAG = "AutoUpdateUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f22443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ObricAutoUpdateUtils f22444b;

    private class AutoUpdateTask extends AsyncTask<String, Void, Bundle> {
        private WeakReference<Context> mActivity;
        final /* synthetic */ ObricAutoUpdateUtils this$0;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.i(r0, r1);
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ Bundle doInBackground(String[] r3) {
            return doInBackground2((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(Bundle r3) {
            onPostExecute2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"));
        }

        public AutoUpdateTask(ObricAutoUpdateUtils r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.mActivity = new WeakReference(r5);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Bundle doInBackground2(String... r8) {
            if (TextUtils.isEmpty(r8[0]) == false) goto L6;
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "pkg is null");
            return null;
        L6:
            Bundle r1 = new Bundle();
            r1.putString("auto_update_pkg", r8[0]);
            Context r9 = (Context) ZeusTransformUtils.preCheckCast(this.mActivity.get(), Context.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L9;
        L13:
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "network is not available.");
            return null;
        L9:
            if (this.this$0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L13;
            Bundle r7 = ObricAutoUpdateUtils.a(this.this$0, r9, r1, "checkAppUpdate");
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "AutoUpdateTask: " + r7);
            return r7;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Bundle r5) {
            if (isCancelled() == true) goto L28;
            if (r5 == null) goto L28;
            if (r5.isEmpty() == true) goto L28;
            Context r4 = (Context) ZeusTransformUtils.preCheckCast(this.mActivity.get(), Context.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L13;
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "activity is null");
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L26;
            Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.aiagent.plugin");
            if (r0.isFinishing() == false) goto L19;
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "context is null.");
            return;
        L19:
            if (ZeusTransformUtils.getWindow(r0, "com.obric.aiagent.plugin") != null) goto L23;
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "window is null.");
            return;
        L23:
            if (r0.isDestroyed() == false) goto L26;
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "activity is destroyed.");
            return;
        L26:
            new a(r4, r5).a();
            return;
        L28:
            INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(ObricAutoUpdateUtils.TAG, "app update info is null.");
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_appstore_autoupdate_ObricAutoUpdateUtils$AutoUpdateTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    static /* synthetic */ Bundle a(ObricAutoUpdateUtils r2, Context r3, Bundle r4, String r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    static {
        f22443a = Uri.parse("content://com.bytedanceos.appstore.auto_update");
        f22444b = null;
    }

    private ObricAutoUpdateUtils() {
    }

    public static ObricAutoUpdateUtils a() {
        if (f22444b != null) goto L6;
        f22444b = new ObricAutoUpdateUtils();
    L6:
        return f22444b;
    }

    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        r0.putString("auto_update_pkg", r4);
        a(r5, r0, "stopDownload");
    }

    public void a(Context r3, String r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        r5.putString("auto_update_name", r4);
        a(r6, r5, "installApp");
    }

    public void a(Context r3, String r4, boolean r5, Bundle r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        r6.putString("auto_update_name", r4);
        r6.putBoolean("useMobile", r5);
        a(r7, r6, "startDownload");
    }

    public int b(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        r0.putString("auto_update_pkg", r4);
        Bundle r2 = a(r5, r0, "getDownloadProgress");
        if (r2 != null) goto L5;
        a(TAG, "getDownloadProgress:extrais null");
        return -1;
    L5:
        return r2.getInt("auto_update_progress");
    }

    public void a(Context r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        r0.putString("auto_update_pkg", r4);
        r0.putInt("auto_update_version_code", r5);
        a(r6, r0, "delayUpdate");
    }

    public boolean a(Context r2) {
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        NetworkInfo r3 = r1.getActiveNetworkInfo();
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isConnected();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v6 */
    private Bundle a(Context r4, Bundle r5, String r6) {
        ContentProviderClient r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L33;
        return null;
    L33:
        ContentProviderClient r7 = r3.getContentResolver().acquireUnstableContentProviderClient(f22443a);     // Catch: Throwable -> L18 RemoteException -> L20
        if (r7 != null) goto L10;
        if (r7 == null) goto L9;
        r7.close();
    L9:
        return null;
    L10:
        if (r5 == null) goto L31;
    L12:
        r5.putInt("client_ver", 1);     // Catch: RemoteException -> L16 Throwable -> L26
        Bundle r8 = r7.call(r6, null, r5);     // Catch: RemoteException -> L16 Throwable -> L26
        if (r7 == null) goto L15;
        r7.close();
    L15:
        return r8;
    L16:
        e = e;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L26
        if (r7 == null) goto L25;
        r7.close();
    L25:
        return null;
    L31:
        r5 = new Bundle();     // Catch: RemoteException -> L16 Throwable -> L26
        goto L12
    L20:
        e = e;
        r7 = null;
    L18:
        th = move-exception;
        th = th;
        r3 = 0;
    L27:
        if (r3 == 0) goto L29;
        r3.close();
    L29:
        throw th;
    L26:
        th = th;
        goto L27
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
