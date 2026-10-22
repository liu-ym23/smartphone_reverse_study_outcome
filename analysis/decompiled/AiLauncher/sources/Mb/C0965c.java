package Mb;

import java.io.EOFException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0003¨\u0006\u0010"}, d2 = {"LMb/c;", "LMb/G;", "<init>", "()V", "LMb/d;", "source", "", "byteCount", "LY8/t;", "K", "(LMb/d;J)V", "flush", "LMb/J;", "c", "()LMb/J;", "close", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0965c implements G {
    @Override // Mb.G
    public void K(C0966d source, long byteCount) throws EOFException {
        kotlin.jvm.internal.p.i(source, "source");
        source.skip(byteCount);
    }

    @Override // Mb.G
    public J c() {
        return J.f4694f;
    }

    @Override // Mb.G, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // Mb.G, java.io.Flushable
    public void flush() {
    }
}
