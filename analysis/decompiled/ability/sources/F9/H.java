package F9;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class H extends K {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f627a;
    public final B b;
    public final Object c;

    public /* synthetic */ H(B b, Object obj, int i) {
        this.f627a = i;
        this.b = b;
        this.c = obj;
    }

    @Override // F9.K
    public final long contentLength() {
        switch (this.f627a) {
            case 0:
                return ((File) this.c).length();
            case 1:
                return ((ByteString) this.c).c();
            default:
                return ((K) this.c).contentLength();
        }
    }

    @Override // F9.K
    public final B contentType() {
        switch (this.f627a) {
        }
        return this.b;
    }

    @Override // F9.K
    public final void writeTo(V9.h sink) {
        int i = this.f627a;
        Object obj = this.c;
        switch (i) {
            case 0:
                kotlin.jvm.internal.k.f(sink, "sink");
                File file = (File) obj;
                Logger logger = V9.o.f1422a;
                kotlin.jvm.internal.k.f(file, "<this>");
                V9.c cVar = new V9.c(1, new FileInputStream(file), V9.y.d);
                try {
                    sink.B(cVar);
                    cVar.close();
                    return;
                } finally {
                }
            case 1:
                kotlin.jvm.internal.k.f(sink, "sink");
                sink.A((ByteString) obj);
                return;
            default:
                ((K) obj).writeTo(sink);
                return;
        }
    }

    public H(K k, B b) {
        this.f627a = 2;
        this.c = k;
        this.b = b;
    }
}
