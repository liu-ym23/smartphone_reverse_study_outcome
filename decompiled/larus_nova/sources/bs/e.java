package bs;

import android.text.TextUtils;
import com.bytedance.retrofit2.Retrofit;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile f f20216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile e f20217e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class, Object> f20218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Retrofit f20219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Retrofit f20220c;

    public static e a() {
        if (f20217e != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f20217e != null) goto L9;
        f20217e = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f20217e;
    }

    public e() {
        this.f20218a = new ConcurrentHashMap();
    }

    public final <T> T b(Class<T> r100) {
        if (this.f20218a.contains(r100) == true) goto L31;
        Retrofit r101 = this.f20219b;
        if (r101 == null) goto L8;
    L23:
        if (r101 == null) goto L25;
        T r102 = (T) r101.create(r100);
    L27:
        if (this.f20219b == null) goto L29;
        this.f20218a.putIfAbsent(r100, r102);
    L29:
        return r102;
    L25:
        r102 = (T) Proxy.newProxyInstance(e.class.getClassLoader(), (Class[]) Arrays.asList(new Class[]{r100}).toArray(), new d());
        goto L27
    L8:
        if (f20216d != null) goto L22;
        Retrofit r103 = this.f20220c;
        if (r103 == null) goto L12;
    L11:
        r101 = r103;
        goto L23
    L12:
        r103 = null;
        yr.c.g("GamecpClient", "not inject retrofit provider, reflect RetrofitProvider");     // Catch: Throwable -> L15
        r103 = ((f) com.bytedance.android.gamecp.host_api.a.b().reflectInPlugin("com.bytedance.android.gamecp.common.network.biz.impl.utils.RetrofitProvider").newInstance()).getRetrofitInstance();     // Catch: Throwable -> L15
        this.f20220c = r103;     // Catch: Throwable -> L15
    L20:
        if (r103 != null) goto L11;
        r101 = new c().getRetrofitInstance();
        yr.c.f(new RuntimeException("not inject retrofit provider"), "setRetrofitProvider is not execute use default retrofitProvider");
    L15:
        th = move-exception;
        String r104 = th.getMessage();
        if (TextUtils.isEmpty(r104) == false) goto L19;
        r104 = "reflect RetrofitProvider exception";
    L19:
        yr.c.b("GamecpClient", r104);
        goto L20
    L22:
        r101 = f20216d.getRetrofitInstance();
        this.f20219b = r101;
        goto L23
    L31:
        return (T) this.f20218a.get(r100);
    }
}
