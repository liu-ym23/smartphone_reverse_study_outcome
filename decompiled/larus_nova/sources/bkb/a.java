package bkb;

import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;
import com.ss.android.lark.log.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.concurrent.CountDownLatch;
import se6.j;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f19389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int[] f19390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ py5.b f19391d;

    @Override // se6.j
    public final void b(OnFetchResponse.OnProgressResponse r100) {
    }

    @Override // se6.j
    public final void a(OnFetchResponse.OnErrorResponse r100) {
        this.f19389b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onErrorResponse called: " + this.f19388a);
    }

    @Override // se6.j
    public final void c(OnFetchResponse.OnSuccessResponse r100) {
        this.f19389b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onSuccessResponse called: " + this.f19388a);
    }

    @Override // se6.j
    public final void d(LarkResponse r100) {
        this.f19389b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onFetchResponse called: " + this.f19388a);
    }

    @Override // se6.j
    public final void e(OnFetchResponse.OnHeaderResponse r100) {
        Log.i("LarkGeckoClient", "downloadFile, onHeaderResponse called: " + this.f19388a);
    }

    @Override // se6.j
    public final void f(OnFetchResponse.OnBodyResponse r100) {
        int[] r101 = this.f19390c;
        r101[0] = r101[0] + 1;
        BufferedInputStream r102 = new BufferedInputStream(new ByteArrayInputStream(r100.body.toByteArray()));
        byte[] r103 = new byte[2048];     // Catch: Throwable -> L10 Exception -> L12
    L4:
        int r104 = r102.read(r103, 0, 2048);     // Catch: Throwable -> L10 Exception -> L12
        if (r104 == (-1)) goto L8;
        this.f19391d.write(r103, 0, r104);     // Catch: Throwable -> L10 Exception -> L12
    L8:
        ez5.b.a(r102);
        return;
    L12:
        e = move-exception;
        throw new RuntimeException("LarkGeckoClient, downloadFile failed, url:" + this.f19388a + ", caused by:" + e.getMessage(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ez5.b.a(r102);
        throw th;
    }

    @Override // se6.j
    public final void g(OnFetchResponse.OnCancelResponse r100) {
        this.f19389b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onCancelResponse called: " + this.f19388a);
    }

    public a(String r100, CountDownLatch r101, int[] r102, py5.b r103) {
        this.f19388a = r100;
        this.f19389b = r101;
        this.f19390c = r102;
        this.f19391d = r103;
    }
}
