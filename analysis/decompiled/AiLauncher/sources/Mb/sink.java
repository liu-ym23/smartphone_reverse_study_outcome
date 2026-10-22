package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"LMb/y;", "LMb/G;", "Ljava/io/OutputStream;", "out", "LMb/J;", "timeout", "<init>", "(Ljava/io/OutputStream;LMb/J;)V", "LMb/d;", "source", "", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "()V", "close", "c", "()LMb/J;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/io/OutputStream;", Const.INTENT_KEY_PKGNAME, "LMb/J;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.y, reason: from toString */
/* loaded from: classes5.dex */
public final class sink implements G {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final OutputStream out;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final J timeout;

    public sink(OutputStream out, J timeout) {
        kotlin.jvm.internal.p.i(out, "out");
        kotlin.jvm.internal.p.i(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // Mb.G
    public void K(C0966d source, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        C0963a.b(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            this.timeout.g();
            E e10 = source.head;
            kotlin.jvm.internal.p.f(e10);
            int iMin = (int) Math.min(byteCount, e10.limit - e10.pos);
            this.out.write(e10.data, e10.pos, iMin);
            e10.pos += iMin;
            long j10 = iMin;
            byteCount -= j10;
            source.a1(source.getSize() - j10);
            if (e10.pos == e10.limit) {
                source.head = e10.b();
                F.b(e10);
            }
        }
    }

    @Override // Mb.G
    /* renamed from: c, reason: from getter */
    public J getTimeout() {
        return this.timeout;
    }

    @Override // Mb.G, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // Mb.G, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }
}
