package ci7;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.UriType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f23866a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f23868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f23869c;

        public final void a() {
            k r100 = this.f23869c;
            Context r101 = this.f23867a;
            String r102 = this.f23868b;
            r100.getClass();
            long r103 = System.currentTimeMillis();
            boolean r104 = false;
            Uri.Builder r105 = k.b(r101);     // Catch: Throwable -> L9
            r105.appendQueryParameter("scheme", r102);     // Catch: Throwable -> L9
            String r106 = mi7.f.b(r105.toString(), new HashMap());     // Catch: Throwable -> L9
            if (r106 != null) goto L13;
            mi7.c.d(r103, 0, "request error, response is null");     // Catch: Throwable -> L7
        L29:
            String r107 = "";
        L30:
            k r108 = this.f23869c;
            String r109 = this.f23868b;
            r108.getClass();
            if (TextUtils.isEmpty(r109) == false) goto L41;
            ConcurrentHashMap<Class<?>, di7.d> r110 = w.f23890a;
            ei7.a r111 = (ei7.a) w.b(ei7.a.class);
            if (r111 == null) goto L36;
            s r112 = r111.k();
        L37:
            if (r112 == null) goto L39;
            r104 = r112.c(r107);
        L39:
            if (r104 == false) goto L41;
            Application r113 = l.f23871a;
            UriType r114 = UriType.DEVICE_PRINT;
            l.f23872b = r114;
            mi7.c.b(r114, r107);
            goto L41
        L36:
            r112 = null;
        L41:
            fi7.d.a(r107, "", null, true);
            return;
        L7:
            Throwable th10 = th;
        L11:
            th10.printStackTrace();
        L13:
            if (TextUtils.isEmpty(r106) == false) goto L47;
            mi7.c.d(r103, 0, "response empty");
            goto L29
        L47:
            JSONObject r115 = new JSONObject(r106);     // Catch: JSONException -> L17
        L19:
            if (r115 != null) goto L22;
            mi7.c.d(r103, 0, "response not json");
            goto L29
        L22:
            if (r115.optInt("code") != 0) goto L28;
            JSONObject r116 = r115.optJSONObject("data");
            if (r116 != null) goto L26;
            r107 = "";
        L27:
            mi7.c.d(r103, 1, "success");
            goto L30
        L26:
            r107 = r116.optString("scheme");
            goto L27
        L28:
            mi7.c.d(r103, 0, r115.optString("message"));
        L17:
            e = move-exception;
            e.printStackTrace();
            r115 = null;
        L9:
            th = move-exception;
            th10 = th;
            r106 = null;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(k r100, Context r101, String r102) {
            this.f23869c = r100;
            this.f23867a = r101;
            this.f23868b = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f23870a = null;

        static {
            f23870a = new k();
        }
    }

    public k() {
        this.f23866a = new AtomicBoolean(true);
    }

    public static Uri.Builder b(Context r100) {
        Uri.Builder r101 = UriProtector.parse("https://zlink.toutiao.com/api/get_deeplink_data").buildUpon();
        IZlinkDepend r102 = p.a();
        if (r102 == null) goto L8;
        r101.appendQueryParameter("aid", r102.getAppId());
        String r103 = r102.getDeviceId();
        if (TextUtils.isEmpty(r103) == false) goto L7;
        r103 = "";
    L7:
        r101.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_DID, r103);
    L8:
        r101.appendQueryParameter("os", "android");
        r101.appendQueryParameter("db", Build.BRAND);
        r101.appendQueryParameter("dm", Build.MODEL);
        if (r100 == null) goto L16;
        WindowManager r104 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r104 == null) goto L13;
        Display r105 = r104.getDefaultDisplay();
    L14:
        if (r105 == null) goto L16;
        DisplayMetrics r106 = new DisplayMetrics();
        r105.getMetrics(r106);
        int r107 = r106.widthPixels;
        int r108 = r106.heightPixels;
        r101.appendQueryParameter("sw", "" + r107);
        r101.appendQueryParameter("sh", "" + r108);
        goto L16
    L13:
        r105 = null;
    L16:
        return r101;
    }

    public final void a(Context r100, String r101) {
        if (this.f23866a.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        List<WeakReference<ki7.b>> r102 = ki7.c.f503641a;
        if (ki7.d.b(r100).optBoolean("deeplink_enable_device_print", true) == true) goto L9;
        return;
    L9:
        if (mi7.b.a(r100) == false) goto L11;
    L13:
        mi7.h.a(new a(this, r100, r101));
        return;
    L11:
        if (mi7.b.f514088a == true) goto L13;
    }
}
