package k3;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0691f implements z {
    @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // k3.z, java.io.Flushable
    public final void flush() {
    }

    @Override // k3.z
    public final C0683E timeout() {
        return C0683E.NONE;
    }

    @Override // k3.z
    public final void write(C0694i source, long j4) throws EOFException {
        Intrinsics.checkNotNullParameter(source, "source");
        source.j(j4);
    }
}
