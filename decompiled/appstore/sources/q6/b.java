package q6;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.TTNetInit;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CountDownLatch f23550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f23551e;

    public b(String r10, int r11) {
        this.f23547a = r10;
        this.f23548b = r11;
        this.f23549c = UUID.randomUUID().toString();
        this.f23550d = new CountDownLatch(1);
    }

    public void a() {
        this.f23550d.await();
    }

    public void b() {
        SsCronetHttpClient.y(TTNetInit.getTTNetDepend().getContext()).f0(this.f23547a, this.f23548b, this.f23549c);
    }

    public c c() {
        return this.f23551e;
    }

    public void d() {
        this.f23550d.countDown();
    }

    public void e(c r10) {
        this.f23551e = r10;
    }

    public String f() {
        return this.f23549c;
    }
}
