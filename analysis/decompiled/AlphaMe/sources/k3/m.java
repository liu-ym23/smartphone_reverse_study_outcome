package k3;

import ch.qos.logback.core.CoreConstants;
import f1.AbstractC0557a;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class m implements z {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0695j f13362a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f13363b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13364c;

    public m(C0694i sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        u sink2 = AbstractC0557a.g(sink);
        Intrinsics.checkNotNullParameter(sink2, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.f13362a = sink2;
        this.f13363b = deflater;
    }

    public final void a(boolean z4) {
        w wVarR;
        int iDeflate;
        InterfaceC0695j interfaceC0695j = this.f13362a;
        C0694i c0694iF = interfaceC0695j.f();
        while (true) {
            wVarR = c0694iF.R(1);
            Deflater deflater = this.f13363b;
            byte[] bArr = wVarR.f13385a;
            if (z4) {
                int i4 = wVarR.f13387c;
                iDeflate = deflater.deflate(bArr, i4, 8192 - i4, 2);
            } else {
                int i5 = wVarR.f13387c;
                iDeflate = deflater.deflate(bArr, i5, 8192 - i5);
            }
            if (iDeflate > 0) {
                wVarR.f13387c += iDeflate;
                c0694iF.f13357b += iDeflate;
                interfaceC0695j.x();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (wVarR.f13386b == wVarR.f13387c) {
            c0694iF.f13356a = wVarR.a();
            x.a(wVarR);
        }
    }

    @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.f13363b;
        if (this.f13364c) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f13362a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f13364c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // k3.z, java.io.Flushable
    public final void flush() {
        a(true);
        this.f13362a.flush();
    }

    @Override // k3.z
    public final C0683E timeout() {
        return this.f13362a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f13362a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Override // k3.z
    public final void write(C0694i source, long j4) {
        Intrinsics.checkNotNullParameter(source, "source");
        AbstractC0685G.b(source.f13357b, 0L, j4);
        while (j4 > 0) {
            w wVar = source.f13356a;
            Intrinsics.checkNotNull(wVar);
            int iMin = (int) Math.min(j4, wVar.f13387c - wVar.f13386b);
            this.f13363b.setInput(wVar.f13385a, wVar.f13386b, iMin);
            a(false);
            long j5 = iMin;
            source.f13357b -= j5;
            int i4 = wVar.f13386b + iMin;
            wVar.f13386b = i4;
            if (i4 == wVar.f13387c) {
                source.f13356a = wVar.a();
                x.a(wVar);
            }
            j4 -= j5;
        }
    }
}
