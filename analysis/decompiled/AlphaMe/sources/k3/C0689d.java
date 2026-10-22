package k3;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import f1.AbstractC0557a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0689d implements InterfaceC0680B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13344a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13345b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13346c;

    public C0689d(InputStream input, C0683E timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f13345b = input;
        this.f13346c = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i4 = this.f13344a;
        Object obj = this.f13345b;
        switch (i4) {
            case 0:
                C0690e c0690e = (C0690e) obj;
                InterfaceC0680B interfaceC0680B = (InterfaceC0680B) this.f13346c;
                c0690e.enter();
                try {
                    interfaceC0680B.close();
                    Unit unit = Unit.INSTANCE;
                    if (c0690e.exit()) {
                        throw c0690e.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e4) {
                    if (!c0690e.exit()) {
                        throw e4;
                    }
                    throw c0690e.access$newTimeoutException(e4);
                } finally {
                    c0690e.exit();
                }
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    @Override // k3.InterfaceC0680B
    public final long read(C0694i sink, long j4) throws IOException {
        int i4 = this.f13344a;
        Object obj = this.f13345b;
        Object obj2 = this.f13346c;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(sink, "sink");
                C0690e c0690e = (C0690e) obj;
                InterfaceC0680B interfaceC0680B = (InterfaceC0680B) obj2;
                c0690e.enter();
                try {
                    long j5 = interfaceC0680B.read(sink, j4);
                    if (c0690e.exit()) {
                        throw c0690e.access$newTimeoutException(null);
                    }
                    return j5;
                } catch (IOException e4) {
                    if (c0690e.exit()) {
                        throw c0690e.access$newTimeoutException(e4);
                    }
                    throw e4;
                } finally {
                    c0690e.exit();
                }
            default:
                Intrinsics.checkNotNullParameter(sink, "sink");
                if (j4 == 0) {
                    return 0L;
                }
                if (j4 < 0) {
                    throw new IllegalArgumentException(AbstractC0351g.n("byteCount < 0: ", j4).toString());
                }
                try {
                    ((C0683E) obj2).throwIfReached();
                    w wVarR = sink.R(1);
                    int i5 = ((InputStream) obj).read(wVarR.f13385a, wVarR.f13387c, (int) Math.min(j4, 8192 - wVarR.f13387c));
                    if (i5 == -1) {
                        if (wVarR.f13386b == wVarR.f13387c) {
                            sink.f13356a = wVarR.a();
                            x.a(wVarR);
                        }
                        return -1L;
                    }
                    wVarR.f13387c += i5;
                    long j6 = i5;
                    sink.f13357b += j6;
                    return j6;
                } catch (AssertionError e5) {
                    if (AbstractC0557a.G(e5)) {
                        throw new IOException(e5);
                    }
                    throw e5;
                }
        }
    }

    @Override // k3.InterfaceC0680B
    public final C0683E timeout() {
        switch (this.f13344a) {
            case 0:
                return (C0690e) this.f13345b;
            default:
                return (C0683E) this.f13346c;
        }
    }

    public final String toString() {
        switch (this.f13344a) {
            case 0:
                return "AsyncTimeout.source(" + ((InterfaceC0680B) this.f13346c) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            default:
                return "source(" + ((InputStream) this.f13345b) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public C0689d(C0690e c0690e, InterfaceC0680B interfaceC0680B) {
        this.f13345b = c0690e;
        this.f13346c = interfaceC0680B;
    }
}
