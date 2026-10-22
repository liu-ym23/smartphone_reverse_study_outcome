package q7;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.common.AdUtil;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.DeviceUtil;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Interceptor {
    public b() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        q.g(r10, "chain");
        Request r11 = r10.request();
        Request.a r12 = r11.h();
        r12.a("store-source", "obric");
        r7.a r13 = r7.a.f23768a;
        r12.a(NetKey.OSVER, r13.i());
        r12.a(NetKey.MODEL, r13.g());
        r12.a(NetKey.IMEI, r13.d());
        r12.a(NetKey.DEVICE_ID, r13.c());
        r12.a(NetKey.KEY_TYPE, r13.e());
        r12.a("User-Agent", r13.o());
        r12.a(NetKey.LANGUAGE, r13.f());
        r12.a(NetKey.APP_VERSION, "100003070");
        r12.a("Market-Version", "6.3");
        r12.a(NetKey.TIME_STAMP, r13.l());
        r12.a(NetKey.RESOLUTION, r13.j());
        r12.a(NetKey.TICKET, AccountDataCache.b().i());
        r12.a(NetKey.TOKEN, AccountDataCache.b().j());
        r12.a(NetKey.ANDROID_ID, DeviceUtil.a());
        r12.a("Terminal", DeviceUtil.j());
        r12.a("Is-Tnt", String.valueOf(DeviceUtil.k(BaseApplication.c())));
        r12.a("Orientation", String.valueOf(AdUtil.getOrientation(BaseApplication.c())));
        r12.a("Is-Teenager", "false");
        r12.a("Open-Id", AccountDataCache.b().k());
        r12.k(r11.k().p().b(NetKey.OSVER, r13.i()).b(NetKey.MODEL, r13.g()).b(NetKey.IMEI, r13.d()).c()).b();
        Response r14 = r10.proceed(r12.b());
        q.f(r14, "proceed(...)");
        return r14;
    }
}
