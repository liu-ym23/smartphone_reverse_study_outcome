package k3;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: k3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0688c implements z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13341a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13342b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13343c;

    public C0688c(OutputStream out, C0683E timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f13342b = out;
        this.f13343c = timeout;
    }

    @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i4 = this.f13341a;
        Object obj = this.f13342b;
        switch (i4) {
            case 0:
                C0690e c0690e = (C0690e) obj;
                z zVar = (z) this.f13343c;
                c0690e.enter();
                try {
                    zVar.close();
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
                ((OutputStream) obj).close();
                return;
        }
    }

    @Override // k3.z, java.io.Flushable
    public final void flush() throws IOException {
        int i4 = this.f13341a;
        Object obj = this.f13342b;
        switch (i4) {
            case 0:
                C0690e c0690e = (C0690e) obj;
                z zVar = (z) this.f13343c;
                c0690e.enter();
                try {
                    zVar.flush();
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
                ((OutputStream) obj).flush();
                return;
        }
    }

    @Override // k3.z
    public final C0683E timeout() {
        switch (this.f13341a) {
            case 0:
                return (C0690e) this.f13342b;
            default:
                return (C0683E) this.f13343c;
        }
    }

    public final String toString() {
        switch (this.f13341a) {
            case 0:
                return "AsyncTimeout.sink(" + ((z) this.f13343c) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            default:
                return "sink(" + ((OutputStream) this.f13342b) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Override // k3.z
    public final void write(C0694i source, long j4) throws IOException {
        int i4 = this.f13341a;
        Object obj = this.f13342b;
        Object obj2 = this.f13343c;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(source, "source");
                AbstractC0685G.b(source.f13357b, 0L, j4);
                while (j4 > 0) {
                    w wVar = source.f13356a;
                    Intrinsics.checkNotNull(wVar);
                    long j5 = 0;
                    while (true) {
                        if (j5 < 65536) {
                            j5 += wVar.f13387c - wVar.f13386b;
                            if (j5 >= j4) {
                                j5 = j4;
                            } else {
                                wVar = wVar.f13390f;
                                Intrinsics.checkNotNull(wVar);
                            }
                        }
                    }
                    C0690e c0690e = (C0690e) obj;
                    z zVar = (z) obj2;
                    c0690e.enter();
                    try {
                        zVar.write(source, j5);
                        Unit unit = Unit.INSTANCE;
                        if (c0690e.exit()) {
                            throw c0690e.access$newTimeoutException(null);
                        }
                        j4 -= j5;
                    } catch (IOException e4) {
                        if (!c0690e.exit()) {
                            throw e4;
                        }
                        throw c0690e.access$newTimeoutException(e4);
                    } finally {
                        c0690e.exit();
                    }
                }
                return;
            default:
                Intrinsics.checkNotNullParameter(source, "source");
                AbstractC0685G.b(source.f13357b, 0L, j4);
                while (j4 > 0) {
                    ((C0683E) obj2).throwIfReached();
                    w wVar2 = source.f13356a;
                    Intrinsics.checkNotNull(wVar2);
                    int iMin = (int) Math.min(j4, wVar2.f13387c - wVar2.f13386b);
                    ((OutputStream) obj).write(wVar2.f13385a, wVar2.f13386b, iMin);
                    int i5 = wVar2.f13386b + iMin;
                    wVar2.f13386b = i5;
                    long j6 = iMin;
                    j4 -= j6;
                    source.f13357b -= j6;
                    if (i5 == wVar2.f13387c) {
                        source.f13356a = wVar2.a();
                        x.a(wVar2);
                    }
                }
                return;
        }
    }

    public C0688c(C0690e c0690e, z zVar) {
        this.f13342b = c0690e;
        this.f13343c = zVar;
    }
}
