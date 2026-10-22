package bp7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f19987g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f19989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f19991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f19992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19993f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f19994a = null;

        static {
            f19994a = new d();
        }
    }

    static {
        f19987g = new AtomicBoolean(false);
    }

    public final void a() {
        if (this.f19988a != null) goto L7;
        zo7.b.b("YZSdkManager", "checkYZSdkSpHelperInit() mAppContext has not init");
        return;
    L7:
        if (this.f19989b != null) goto L26;
        AtomicBoolean r100 = f19987g;
        if (r100.get() == true) goto L26;
        this.f19992e.lock();
    L23:
        th = move-exception;
        this.f19992e.unlock();
        throw th;
    L13:
        if (this.f19989b == null) goto L15;
    L20:
        zo7.b.d("YZSdkManager", "ensureYZSdkSpHelperInit() inner, sp init already");     // Catch: Throwable -> L23
        this.f19992e.unlock();
        return;
    L15:
        if (r100.get() == true) goto L20;
        this.f19989b = new e(this.f19988a, this.f19990c);     // Catch: Throwable -> L23
        r100.compareAndSet(false, true);     // Catch: Throwable -> L23
        this.f19992e.unlock();
        return;
    L26:
        zo7.b.d("YZSdkManager", "ensureYZSdkSpHelperInit() sp init already");
    }

    public d() {
        this.f19990c = false;
        this.f19991d = false;
        this.f19992e = new ReentrantLock();
    }

    public final String b() {
        String r100 = zo7.a.a();
        boolean r101 = this.f19991d;
        zo7.b.d("YZSdkManager", "reportEvent() called with: phoneName = [" + r100 + "], isAsyncThreadDone = [" + r101 + "]");
        JSONObject r102 = new JSONObject();
        r102.put("thread_done", r101);     // Catch: JSONException -> L5
        r102.put("phone_brand", r100);     // Catch: JSONException -> L5
        r102.put("phone_model", Build.MODEL);     // Catch: JSONException -> L5
        zo7.c.a("yz_channel_status", r102, null);     // Catch: JSONException -> L5
    L7:
        vo7.a r103 = vo7.a.C8028a.f556510a;
        if (TextUtils.isEmpty(r103.f556508b) == false) goto L18;
        a();
        e r104 = this.f19989b;
        if (r104 != null) goto L12;
        return "";
    L12:
        if (r104.f19995a != null) goto L15;
        r104.a();
    L15:
        return r104.f19995a.getString("pre_install_channel", "");
    L18:
        return r103.f556508b;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void c(boolean r100) {
        a();
        e r101 = this.f19989b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f19995a != null) goto L7;
        r101.a();
    L7:
        SharedPreferences.Editor r102 = r101.f19995a.edit();
        r102.putBoolean("report_pre_install_channel", r100);
        r102.commit();
    }
}
