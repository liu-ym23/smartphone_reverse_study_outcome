package l8;

import android.accounts.Account;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.util.Log;
import hc.h;
import hc.o;
import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f7755a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static volatile m f7756b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Context f7757c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile String f7758d;

    /* renamed from: e, reason: collision with root package name */
    public static final e.a f7759e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f7760f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile long f7761g;

    static {
        e.a aVar = new e.a();
        aVar.f3331a = new Object();
        VarHandle.storeStoreFence();
        f7759e = aVar;
    }

    public static String a(boolean z10) {
        boolean zX;
        m mVar = f7756b;
        if (mVar == null) {
            return "";
        }
        if (h.g0(b())) {
            Log.d("MzAccountSession", "getAuthToken skip: no local account");
            return "";
        }
        boolean z11 = false;
        try {
            String str = mVar.x(null, z10)[0];
            String string = str != null ? h.w0(str).toString() : null;
            if (string == null) {
                string = "";
            }
            if (string.length() == 0) {
                Log.w("MzAccountSession", "getAuthToken returned empty");
                return string;
            }
            String string2 = h.w0(string).toString();
            if (string2.length() > 0) {
                f7758d = string2;
            }
            Log.d("MzAccountSession", "getAuthToken ok len=" + string.length());
            return string;
        } catch (j8.a e10) {
            for (Throwable cause = e10; cause != null; cause = cause.getCause()) {
                if ((cause instanceof OperationCanceledException) || (cause instanceof CancellationException)) {
                    zX = false;
                    break;
                }
            }
            String message = e10.getMessage();
            if (message == null) {
                message = "";
            }
            zX = h.X(message, "用户取消", false);
            if (zX) {
                f7760f = true;
                f7761g = System.currentTimeMillis();
                Log.i("MzAccountSession", "getAuthToken declined by user");
            } else {
                for (Throwable cause2 = e10; cause2 != null; cause2 = cause2.getCause()) {
                    if ((cause2 instanceof OperationCanceledException) || (cause2 instanceof CancellationException)) {
                        z11 = true;
                        break;
                    }
                }
                if (z11) {
                    Log.d("MzAccountSession", "getAuthToken cancelled by activity transition", e10);
                }
            }
            Log.w("MzAccountSession", "getAuthToken for gateway failed, auth UI suppressed", e10);
            return "";
        }
    }

    public static String b() {
        Context context;
        try {
            m mVar = f7756b;
            String str = null;
            if (mVar != null && (context = (Context) mVar.f9741f) != null) {
                Account accountY = a.a.y(context);
                str = accountY == null ? "" : accountY.name;
            }
            return str == null ? "" : str;
        } catch (Exception e10) {
            Log.w("MzAccountSession", "getLocalAccountId failed", e10);
            return "";
        }
    }

    public static boolean c() {
        String str = f7758d;
        if (str == null) {
            str = "";
        }
        if (!h.g0(str)) {
            return true;
        }
        if (h.g0(b())) {
            Log.d("MzAccountSession", "peek skip: no local account");
            return false;
        }
        if (f7760f) {
            long jCurrentTimeMillis = System.currentTimeMillis() - f7761g;
            if (f7761g > 0 && jCurrentTimeMillis < 1800000) {
                Log.d("MzAccountSession", "peek skip: user declined auth within cooldown");
                return false;
            }
            f7760f = false;
        }
        return !h.g0(a(false));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ad.n e() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.b.e():ad.n");
    }

    public final boolean d(String str) {
        boolean zG0;
        str.getClass();
        synchronized (f7759e.f3331a) {
            try {
                String string = h.w0(str).toString();
                zG0 = true;
                if (o.U(string, "Bearer ", true)) {
                    string = h.w0(string.substring(7)).toString();
                }
                String str2 = f7758d;
                if (str2 == null) {
                    str2 = "";
                }
                String string2 = h.w0(str2).toString();
                if (string2.length() <= 0 || string2.equals(string)) {
                    f7758d = null;
                    zG0 = true ^ h.g0(a(true));
                }
            } finally {
            }
        }
        Log.i("MzAccountSession", "401 token refresh ".concat(zG0 ? "ready" : "unavailable"));
        return zG0;
    }
}
