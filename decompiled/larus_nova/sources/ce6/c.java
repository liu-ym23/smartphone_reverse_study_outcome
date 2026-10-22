package ce6;

import com.lynx.canvas.KryptonLLog;
import d8a.g;
import d8a.i;
import java.io.InputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.c f23463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f23464b;

    @Override // d8a.g
    public final void onFailed(i r100) {
        String r101 = r100.f467442b;
        KryptonLLog.e("KryptonCanvasLoaderService", "requestResource error " + r101);
        this.f23463a.a(r101);
    }

    @Override // d8a.g
    public final void onSuccess(i r100) {
        InputStream r101 = r100.f467444d;
        b.e(r101, this.f23463a, b.a(this.f23464b, r100));     // Catch: OutOfMemoryError -> L5 Exception -> L7
    L13:
        return;
    L7:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "load from remote exception: " + e.toString());
        r100.f467442b = e.toString();
        return;
    L5:
        e = move-exception;
        KryptonLLog.e("KryptonCanvasLoaderService", "load from remote out of memory");
        r100.f467442b = e.toString();
    }

    public c(b r100, b.c r101) {
        this.f23464b = r100;
        this.f23463a = r101;
    }
}
