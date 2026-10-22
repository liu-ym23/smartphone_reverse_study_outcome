package qa;

import java.io.IOException;

/* renamed from: qa.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1866s extends V9.k {
    public final /* synthetic */ C1867t b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1866s(C1867t c1867t, V9.i iVar) {
        super(iVar);
        this.b = c1867t;
    }

    @Override // V9.w
    public final long e(V9.g sink, long j5) throws IOException {
        try {
            kotlin.jvm.internal.k.f(sink, "sink");
            return this.f1419a.e(sink, 8192L);
        } catch (IOException e) {
            this.b.d = e;
            throw e;
        }
    }
}
