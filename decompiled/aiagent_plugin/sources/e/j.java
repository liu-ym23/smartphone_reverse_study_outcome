package e;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aa f38728a;

    public j(aa r3) {
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "delegate");
        this.f38728a = r4;
    }

    public final aa b() {
        return this.f38728a;
    }

    @Override // e.aa
    public long a(e r2, long r3) {
        d.h.b.o.e(r2, "sink");
        return this.f38728a.a(r2, r3);
    }

    @Override // e.aa
    public ab a() {
        return this.f38728a.a();
    }

    @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38728a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f38728a + ')';
    }
}
