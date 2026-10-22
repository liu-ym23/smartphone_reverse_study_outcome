package L9;

import V9.i;
import V9.l;
import V9.w;
import V9.y;
import java.io.IOException;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public abstract class b implements w {

    /* renamed from: a, reason: collision with root package name */
    public final l f945a;
    public boolean b;
    public final /* synthetic */ A8.a c;

    public b(A8.a aVar) {
        this.c = aVar;
        this.f945a = new l(((i) aVar.e).timeout());
    }

    public final void b() {
        A8.a aVar = this.c;
        int i = aVar.b;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + aVar.b);
        }
        l lVar = this.f945a;
        y yVar = lVar.e;
        lVar.e = y.d;
        yVar.a();
        yVar.b();
        aVar.b = 6;
    }

    @Override // V9.w
    public long e(V9.g sink, long j5) throws IOException {
        A8.a aVar = this.c;
        k.f(sink, "sink");
        try {
            return ((i) aVar.e).e(sink, j5);
        } catch (IOException e) {
            ((okhttp3.internal.connection.a) aVar.d).k();
            this.b();
            throw e;
        }
    }

    @Override // V9.w
    public final y timeout() {
        return this.f945a;
    }
}
