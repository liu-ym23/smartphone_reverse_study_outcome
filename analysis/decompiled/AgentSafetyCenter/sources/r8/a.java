package r8;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.stepos.openidsdk.OpenIdHelper;
import hc.h;
import java.lang.invoke.VarHandle;
import jb.i;
import jb.v;
import kc.e0;
import kc.k1;
import kc.w;
import pc.c;
import rc.d;
import rc.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10474a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f10475b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f10476c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f10477d;

    static {
        k1 k1VarC = w.c();
        e eVar = e0.f7430a;
        f10477d = w.a(ac.a.N(k1VarC, d.f10552f));
    }

    public static final void a(Context context) {
        Object objL;
        Object objL2;
        if (OpenIdHelper.isSupported()) {
            try {
                String oaid = OpenIdHelper.getOAID(context);
                oaid.getClass();
                objL = h.w0(oaid).toString();
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            Throwable thB = i.b(objL);
            if (thB != null) {
                Log.w("DeviceIdProvider", "refresh OAID failed", thB);
            }
            if (i.b(objL) != null) {
                objL = "";
            }
            String str = (String) objL;
            if (h.g0(str)) {
                return;
            }
            f10475b = str;
            Log.i("DeviceIdProvider", "OAID refreshed ok len=" + str.length());
            try {
            } catch (Throwable th2) {
                objL2 = id.c.l(th2);
            }
            if (!n6.a.f8775g) {
                throw new IllegalStateException("UsageStatsProxy3 is not initialised - invoke at least once with parameterised init");
            }
            ma.e eVar = ma.d.f8538a;
            ma.c cVar = new ma.c(0);
            cVar.f8537f = eVar;
            VarHandle.storeStoreFence();
            sa.c.f(cVar);
            objL2 = v.f6774a;
            Throwable thB2 = i.b(objL2);
            if (thB2 != null) {
                Log.w("UsageStatsInit", "refreshDeviceInfo failed", thB2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [jb.h] */
    public static String b(Context context) {
        String str;
        Context applicationContext;
        String strL;
        String str2 = f10475b;
        if (h.g0(str2)) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        str = "";
        if (context != null && (applicationContext = context.getApplicationContext()) != null && !Looper.getMainLooper().isCurrentThread() && OpenIdHelper.isSupported()) {
            try {
                String oaid = OpenIdHelper.getOAID(applicationContext);
                oaid.getClass();
                strL = h.w0(oaid).toString();
            } catch (Throwable th) {
                strL = id.c.l(th);
            }
            Throwable thB = i.b(strL);
            if (thB != null) {
                Log.w("DeviceIdProvider", "getOAID failed", thB);
            }
            str = i.b(strL) == null ? strL : "";
            if (!h.g0(str)) {
                f10475b = str;
            }
        }
        return str;
    }
}
