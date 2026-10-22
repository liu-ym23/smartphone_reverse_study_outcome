package w3;

import a6.b0;
import a6.c0;
import a6.e0;
import a6.j1;
import a6.r0;
import a6.t;
import a6.x1;
import b5.k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6189c = AtomicIntegerFieldUpdater.newUpdater(d.class, "closed");

    /* renamed from: a, reason: collision with root package name */
    public final k f6190a;

    /* renamed from: b, reason: collision with root package name */
    public final k f6191b;
    private volatile /* synthetic */ int closed = 0;

    public d() {
        final int i8 = 0;
        this.f6190a = b8.h.x(new p5.a(this) { // from class: w3.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f6188b;

            {
                this.f6188b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i9 = i8;
                d dVar = this.f6188b;
                switch (i9) {
                    case 0:
                        ((x3.d) dVar).d.getClass();
                        h6.e eVar = r0.f210a;
                        return h6.d.f3059c;
                    default:
                        return b8.h.I(new x1(null), new r4.e(c0.f142a)).t((b0) dVar.f6190a.getValue()).t(new e0("ktor-android-context"));
                }
            }
        });
        final int i9 = 1;
        this.f6191b = b8.h.x(new p5.a(this) { // from class: w3.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f6188b;

            {
                this.f6188b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i92 = i9;
                d dVar = this.f6188b;
                switch (i92) {
                    case 0:
                        ((x3.d) dVar).d.getClass();
                        h6.e eVar = r0.f210a;
                        return h6.d.f3059c;
                    default:
                        return b8.h.I(new x1(null), new r4.e(c0.f142a)).t((b0) dVar.f6190a.getValue()).t(new e0("ktor-android-context"));
                }
            }
        });
    }

    @Override // a6.f0
    public final f5.h b() {
        return (f5.h) this.f6191b.getValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (f6189c.compareAndSet(this, 0, 1)) {
            f5.f fVarO = b().o(c0.f143b);
            t tVar = fVarO instanceof t ? (t) fVarO : null;
            if (tVar == null) {
                return;
            }
            ((j1) tVar).f0();
        }
    }
}
