package p000if;

import android.content.Context;
import android.util.Log;
import com.danikula.videocache.HttpProxyCacheServer;
import java.io.File;
import p9.c;
import u9.e;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HttpProxyCacheServer f20593a;

    public static HttpProxyCacheServer a(Context r10) {
        HttpProxyCacheServer r11 = f20593a;
        if (r11 != null) goto L6;
        HttpProxyCacheServer r12 = d(r10);
        f20593a = r12;
        return r12;
    L6:
        return r11;
    }

    public static String b(Context r10, String r11) {
        return a(r10).getProxyUrl(r11);
    }

    public static void c(Context r10) {
        File r11 = e.e(r10);
        Log.d("MediaProxyUtils", "initProxyConfig, file:" + r11);
        if (r11.exists() == true) goto L5;
        r11.mkdirs();
    L5:
        c.f().g(new c.f(r10).b(r11).f(false).e(30000, 30000, 60000).c(3).d(true).a());
    }

    public static HttpProxyCacheServer d(Context r10) {
        return new HttpProxyCacheServer.Builder(r10).maxCacheSize(2147483648L).build();
    }
}
