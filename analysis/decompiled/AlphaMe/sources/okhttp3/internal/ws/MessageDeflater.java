package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import k3.AbstractC0685G;
import k3.C0692g;
import k3.C0694i;
import k3.l;
import k3.m;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "Lk3/i;", "Lk3/l;", "suffix", "", "endsWith", "(Lk3/i;Lk3/l;)Z", "buffer", "", "deflate", "(Lk3/i;)V", "close", "()V", "noContextTakeover", "Z", "deflatedBytes", "Lk3/i;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "Lk3/m;", "deflaterSink", "Lk3/m;", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class MessageDeflater implements Closeable {

    @NotNull
    private final C0694i deflatedBytes;

    @NotNull
    private final Deflater deflater;

    @NotNull
    private final m deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z4) {
        this.noContextTakeover = z4;
        C0694i c0694i = new C0694i();
        this.deflatedBytes = c0694i;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new m(c0694i, deflater);
    }

    private final boolean endsWith(C0694i c0694i, l bytes) {
        long jC = c0694i.f13357b - bytes.c();
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int iC = bytes.c();
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (jC < 0 || iC < 0 || c0694i.f13357b - jC < iC || bytes.c() < iC) {
            return false;
        }
        for (int i4 = 0; i4 < iC; i4++) {
            if (c0694i.l(i4 + jC) != bytes.f(i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    public final void deflate(@NotNull C0694i buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (this.deflatedBytes.f13357b != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.f13357b);
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            C0694i c0694i = this.deflatedBytes;
            long j4 = c0694i.f13357b - 4;
            C0692g c0692gC = c0694i.C(AbstractC0685G.f13339a);
            try {
                c0692gC.a(j4);
                CloseableKt.closeFinally(c0692gC, null);
            } finally {
            }
        } else {
            this.deflatedBytes.V(0);
        }
        C0694i c0694i2 = this.deflatedBytes;
        buffer.write(c0694i2, c0694i2.f13357b);
    }
}
