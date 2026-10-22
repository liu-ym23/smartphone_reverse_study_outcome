package a4;

import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends id.k {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ id.k f188c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ ThreadPoolExecutor f189d;

    @Override // id.k
    public final void J(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f189d;
        try {
            this.f188c.J(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // id.k
    public final void K(p5.i iVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f189d;
        try {
            this.f188c.K(iVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
