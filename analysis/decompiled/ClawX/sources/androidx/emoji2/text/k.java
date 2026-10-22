package androidx.emoji2.text;

import android.content.Context;
import d8.j1;
import d8.s3;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f617a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f618b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f619c;
    public final /* synthetic */ Object d;

    public /* synthetic */ k(Object obj, Object obj2, Object obj3, int i8) {
        this.f617a = i8;
        this.f618b = obj;
        this.f619c = obj2;
        this.d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f617a) {
            case 0:
                m mVar = (m) this.f618b;
                b8.h hVar = (b8.h) this.f619c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.d;
                try {
                    v vVarN = a.a.n((Context) mVar.f621a);
                    if (vVarN == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    u uVar = (u) vVarN.f641a;
                    synchronized (uVar.d) {
                        uVar.f638f = threadPoolExecutor;
                    }
                    vVarN.f641a.e(new l(hVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    hVar.z(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            default:
                s3 s3Var = (s3) this.f618b;
                CompletableFuture completableFuture = (CompletableFuture) this.f619c;
                try {
                    completableFuture.complete(s3Var.e((j1) this.d));
                    return;
                } catch (IOException e9) {
                    completableFuture.completeExceptionally(e9);
                    return;
                }
        }
    }
}
