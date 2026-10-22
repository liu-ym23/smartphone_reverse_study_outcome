package k3;

import androidx.room.AbstractC0351g;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class r implements InterfaceC0680B {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0696k f13371a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f13372b;

    /* renamed from: c, reason: collision with root package name */
    public int f13373c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13374d;

    public r(v source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.f13371a = source;
        this.f13372b = inflater;
    }

    public final long a(C0694i sink, long j4) throws DataFormatException, IOException {
        Inflater inflater = this.f13372b;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("byteCount < 0: ", j4).toString());
        }
        if (!(!this.f13374d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j4 == 0) {
            return 0L;
        }
        try {
            w wVarR = sink.R(1);
            int iMin = (int) Math.min(j4, 8192 - wVarR.f13387c);
            boolean zNeedsInput = inflater.needsInput();
            InterfaceC0696k interfaceC0696k = this.f13371a;
            if (zNeedsInput && !interfaceC0696k.s()) {
                w wVar = interfaceC0696k.f().f13356a;
                Intrinsics.checkNotNull(wVar);
                int i4 = wVar.f13387c;
                int i5 = wVar.f13386b;
                int i6 = i4 - i5;
                this.f13373c = i6;
                inflater.setInput(wVar.f13385a, i5, i6);
            }
            int iInflate = inflater.inflate(wVarR.f13385a, wVarR.f13387c, iMin);
            int i7 = this.f13373c;
            if (i7 != 0) {
                int remaining = i7 - inflater.getRemaining();
                this.f13373c -= remaining;
                interfaceC0696k.j(remaining);
            }
            if (iInflate > 0) {
                wVarR.f13387c += iInflate;
                long j5 = iInflate;
                sink.f13357b += j5;
                return j5;
            }
            if (wVarR.f13386b == wVarR.f13387c) {
                sink.f13356a = wVarR.a();
                x.a(wVarR);
            }
            return 0L;
        } catch (DataFormatException e4) {
            throw new IOException(e4);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f13374d) {
            return;
        }
        this.f13372b.end();
        this.f13374d = true;
        this.f13371a.close();
    }

    @Override // k3.InterfaceC0680B
    public final long read(C0694i sink, long j4) throws DataFormatException, IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long jA = a(sink, j4);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f13372b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f13371a.s());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // k3.InterfaceC0680B
    public final C0683E timeout() {
        return this.f13371a.timeout();
    }
}
