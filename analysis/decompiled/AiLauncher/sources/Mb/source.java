package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LMb/p;", "LMb/I;", "Ljava/io/InputStream;", "input", "LMb/J;", "timeout", "<init>", "(Ljava/io/InputStream;LMb/J;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LY8/t;", "close", "()V", "c", "()LMb/J;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/io/InputStream;", Const.INTENT_KEY_PKGNAME, "LMb/J;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.p, reason: from toString */
/* loaded from: classes5.dex */
public class source implements I {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InputStream input;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final J timeout;

    public source(InputStream input, J timeout) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // Mb.I
    /* renamed from: c, reason: from getter */
    public J getTimeout() {
        return this.timeout;
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    public String toString() {
        return "source(" + this.input + ')';
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount == 0) {
            return 0L;
        }
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        try {
            this.timeout.g();
            E eH1 = sink.h1(1);
            int i10 = this.input.read(eH1.data, eH1.limit, (int) Math.min(byteCount, 8192 - eH1.limit));
            if (i10 != -1) {
                eH1.limit += i10;
                long j10 = i10;
                sink.a1(sink.getSize() + j10);
                return j10;
            }
            if (eH1.pos != eH1.limit) {
                return -1L;
            }
            sink.head = eH1.b();
            F.b(eH1);
            return -1L;
        } catch (AssertionError e10) {
            if (Nb.t.b(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }
}
