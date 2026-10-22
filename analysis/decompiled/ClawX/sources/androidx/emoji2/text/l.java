package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends b8.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b8.h f620c;
    public final /* synthetic */ ThreadPoolExecutor d;

    public l(b8.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f620c = hVar;
        this.d = threadPoolExecutor;
    }

    @Override // b8.h
    public final void A(a1.w wVar) {
        ThreadPoolExecutor threadPoolExecutor = this.d;
        try {
            this.f620c.A(wVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // b8.h
    public final void z(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.d;
        try {
            this.f620c.z(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
