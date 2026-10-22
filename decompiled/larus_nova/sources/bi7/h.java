package bi7;

import android.app.Application;
import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import ci7.k;
import ci7.l;
import ci7.p;
import ci7.s;
import ci7.x;
import ci7.z;
import com.bytedance.applog.AppLog;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.UriType;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mi7.m;
import mi7.n;
import mi7.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ClipData f19154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile h f19155c;

    public h() {
    }

    public static h g() {
        if (f19155c != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f19155c != null) goto L9;
        f19155c = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f19155c;
    }

    public static boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (r100.startsWith("ttcb") == false) goto L16;
        return true;
    L16:
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r100), "zlink");     // Catch: Throwable -> L12
    L15:
        return !TextUtils.isEmpty(r101);
    L12:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L15
    }

    @Override // ci7.s
    public final boolean a(String r100) {
        return e(r100);
    }

    @Override // ci7.s
    public final boolean c(String r100) {
        return n.a(r100);
    }

    @Override // ci7.s
    public final boolean d(long r100, ClipData r101) {
        return c.a.f19147a.a(r101);
    L4:
        th = move-exception;
        fi7.d.a("", "", r101, false);
        th.printStackTrace();
        return false;
    }

    @Override // ci7.s
    public final boolean b(Context r100, String r101, ClipData r102) {
        if (e(r101) == false) goto L36;
        f19153a = r101;
        f19154b = r102;
        IZlinkDepend r103 = p.a();
        if (r103 == null) goto L35;
        if (TextUtils.isEmpty(r103.getDeviceId()) == false) goto L35;
        mi7.i r104 = new mi7.i("clipboard_invoke", "did is empty", null, m.f514108a);     // Catch: Exception -> L15
        IExecutor r105 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L15
        if (r105 == null) goto L17;
        r105.executeWithSingleThread(r104);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L15
    L17:
        if (o.b(r100) == false) goto L35;
    L33:
        AppLog.addDataObserver(e.b());     // Catch: NoClassDefFoundError -> L37
        goto L35
    L20:
        if (f.f19149a == null) goto L22;
    L31:
        jta.g.b(f.f19149a);     // Catch: NoClassDefFoundError -> L33
        goto L35
    L22:
        monitor-enter(f.class);     // Catch: NoClassDefFoundError -> L33
    L28:
        th = move-exception;
        throw th;     // Catch: NoClassDefFoundError -> L33
    L24:
        if (f.f19149a != null) goto L26;
        f.f19149a = new f();     // Catch: Throwable -> L28
    L26:
        monitor-exit(f.class);     // Catch: Throwable -> L28
    L35:
        return f(r101, r102, false);
    L36:
        return false;
    }

    public final boolean f(String r100, ClipData r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r104 = r100;
    L6:
        mi7.c.a("zlink_clipboard_verify", r103);
        if (r102 == false) goto L10;
        return true;
    L10:
        if (TextUtils.isEmpty(r104) == true) goto L21;
        CopyOnWriteArrayList<Uri> r105 = x.f23891a;
        if (r105 != null) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L21;
        ci7.d.a(l.a(), r100, r101);
        return true;
    L14:
        if (r105.size() <= 0) goto L16;
        r106 = true;
    L21:
        if (n.a(r104) == false) goto L52;
        Application r107 = l.f23871a;
        UriType r108 = UriType.CLIPBOARD;
        l.f23872b = r108;
        mi7.c.b(r108, r104);
        JSONObject r109 = null;
        if (TextUtils.isEmpty(r104) == true) goto L25;
        Uri r110 = UriProtector.parse(r104);
    L26:
        if (r110 != null) goto L58;
    L31:
        String r111 = null;
    L33:
        if (TextUtils.isEmpty(r111) == false) goto L54;
    L39:
        mi7.h.e(new g(r104, r100, r101, r109));
        Application r112 = l.a();
        List<WeakReference<ki7.b>> r113 = ki7.c.f503641a;
        if (ki7.d.b(r112).optBoolean("deeplink_device_fingerprint_ab", true) == false) goto L42;
        k.b.f23870a.a(l.a(), r104);
    L42:
        return true;
    L54:
        r109 = new JSONObject(r111);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.printStackTrace();
        goto L39
    L58:
        r111 = UriProtector.getQueryParameter(r110, "zlink_data");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L25:
        r110 = null;
        goto L26
    L52:
        mi7.j r114 = new mi7.j("clipboard_invoke", "scheme not in schemeList", new JSONObject(), m.f514108a);     // Catch: Exception -> L50
        IExecutor r115 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L50
        if (r115 != null) goto L56;
    L51:
        goto L49
    L56:
        r115.executeWithSingleThread(r114);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L50
    L49:
        return false;
    L5:
        r104 = ci7.a.a("", r100, r103);
        goto L6
    }
}
