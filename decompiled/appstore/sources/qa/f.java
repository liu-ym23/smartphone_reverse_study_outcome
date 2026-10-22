package qa;

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
import com.bytedanceos.common.toolbox.i;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f23609b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f f23610c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f23611a;

    public class a extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f23612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f23613b;

        public a(f r10, Context r11) {
            this.f23613b = r10;
            this.f23612a = new WeakReference(r11);
        }

        public Bundle a(String... r10) {
            if (TextUtils.isEmpty(r10[0]) == false) goto L6;
            i.e("AutoUpdateUtils", "pkg is null");
            return null;
        L6:
            Bundle r11 = new Bundle();
            r11.putString("auto_update_pkg", r10[0]);
            Context r12 = (Context) this.f23612a.get();
            if (r12 != null) goto L9;
        L13:
            i.e("AutoUpdateUtils", "network is not available.");
            return null;
        L9:
            if (this.f23613b.g(r12.getApplicationContext()) == false) goto L13;
            Bundle r13 = f.a(this.f23613b, r12, r11, "checkAppUpdate");
            i.e("AutoUpdateUtils", "AutoUpdateTask: " + r13);
            return r13;
        }

        public void b(Bundle r10) {
            if (isCancelled() == true) goto L28;
            if (r10 == null) goto L28;
            if (r10.isEmpty() == true) goto L28;
            Context r11 = (Context) this.f23612a.get();
            if (r11 != null) goto L13;
            i.e("AutoUpdateUtils", "activity is null");
            return;
        L13:
            if ((r11 instanceof Activity) == false) goto L26;
            Activity r12 = (Activity) r11;
            if (r12.isFinishing() == false) goto L19;
            i.e("AutoUpdateUtils", "context is null.");
            return;
        L19:
            if (r12.getWindow() != null) goto L23;
            i.e("AutoUpdateUtils", "window is null.");
            return;
        L23:
            if (r12.isDestroyed() == false) goto L26;
            i.e("AutoUpdateUtils", "activity is destroyed.");
            return;
        L26:
            new e(r11, r10).t();
            return;
        L28:
            i.e("AutoUpdateUtils", "app update info is null.");
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r10) {
            return a((String[]) r10);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r10) {
            b((Bundle) r10);
        }
    }

    static {
        f23609b = Uri.parse("content://com.bytedanceos.appstore.auto_update");
        f23610c = null;
    }

    public f() {
    }

    public static /* synthetic */ Bundle a(f r10, Context r11, Bundle r12, String r13) {
        return r10.b(r11, r12, r13);
    }

    public static f e() {
        if (f23610c != null) goto L6;
        f23610c = new f();
    L6:
        return f23610c;
    }

    public final Bundle b(Context r10, Bundle r11, String r12) {
        if (r10 != null) goto L33;
        return null;
    L33:
        ContentProviderClient r13 = r10.getContentResolver().acquireUnstableContentProviderClient(f23609b);     // Catch: Throwable -> L19 RemoteException -> L21
        if (r13 != null) goto L10;
        if (r13 == null) goto L9;
        r13.close();
    L9:
        return null;
    L10:
        if (r11 == null) goto L30;
    L16:
        r11.putInt("client_ver", 1);     // Catch: Throwable -> L12 RemoteException -> L14
        Bundle r14 = r13.call(r12, null, r11);     // Catch: Throwable -> L12 RemoteException -> L14
        r13.close();
        return r14;
    L14:
        e = e;
    L23:
        i.l("AutoUpdateUtils", "contentProviderCall failed: " + r12, e);     // Catch: Throwable -> L12
        if (r13 == null) goto L26;
        r13.close();
    L26:
        return null;
    L12:
        Throwable th = th;
    L27:
        if (r13 == null) goto L29;
        r13.close();
    L29:
        throw th;
    L30:
        r11 = new Bundle();     // Catch: Throwable -> L12 RemoteException -> L14
        goto L16
    L21:
        e = e;
        r13 = null;
    L19:
        th = move-exception;
        r13 = null;
        th = th;
        goto L27
    }

    public void c(Context r10, String r11, int r12) {
        Bundle r13 = new Bundle();
        r13.putString("auto_update_pkg", r11);
        r13.putInt("auto_update_version_code", r12);
        b(r10, r13, "delayUpdate");
    }

    public int d(Context r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putString("auto_update_pkg", r11);
        Bundle r13 = b(r10, r12, "getDownloadProgress");
        if (r13 != null) goto L5;
        i.a("AutoUpdateUtils", "getDownloadProgress:extrais null");
        return -1;
    L5:
        return r13.getInt("auto_update_progress");
    }

    public void f(Context r10, String r11, Bundle r12) {
        r12.putString("auto_update_name", r11);
        b(r10, r12, "installApp");
    }

    public boolean g(Context r10) {
        ConnectivityManager r11 = (ConnectivityManager) r10.getSystemService("connectivity");
        if (r11 != null) goto L5;
        return false;
    L5:
        NetworkInfo r12 = r11.getActiveNetworkInfo();
        if (r12 != null) goto L9;
        return false;
    L9:
        return r12.isConnected();
    }

    public void h() {
        a r10 = this.f23611a;
        if (r10 == null) goto L6;
        r10.cancel(true);
        this.f23611a = null;
        return;
    }

    public void i(Activity r10, String r11) {
        a r12 = this.f23611a;
        if (r12 == null) goto L5;
        r12.cancel(true);
    L5:
        a r13 = new a(this, r10);
        this.f23611a = r13;
        r13.execute(new String[]{r11});
    }

    public void j(Context r10, String r11, boolean r12, Bundle r13) {
        r13.putString("auto_update_name", r11);
        r13.putBoolean("useMobile", r12);
        b(r10, r13, "startDownload");
    }

    public void k(Context r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putString("auto_update_pkg", r11);
        b(r10, r12, "stopDownload");
    }
}
