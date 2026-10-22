package fb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kb.C4845d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lfb/a;", "Ljava/io/OutputStream;", "out", "", "byteCount", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lfb/a;Ljava/io/OutputStream;J)V", "Ljava/nio/ByteBuffer;", "sink", "", Const.INTENT_KEY_APIKEY, "(Lfb/a;Ljava/nio/ByteBuffer;)I", "source", Const.INTENT_KEY_UMID, "(Lfb/a;Ljava/nio/ByteBuffer;)Lfb/a;", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4075b {
    public static final int a(C4074a c4074a, ByteBuffer sink) throws EOFException {
        kotlin.jvm.internal.p.i(c4074a, "<this>");
        kotlin.jvm.internal.p.i(sink, "sink");
        if (c4074a.k()) {
            return -1;
        }
        C4845d c4845d = C4845d.f34666a;
        if (c4074a.k()) {
            throw new IllegalArgumentException("Buffer is empty");
        }
        o head = c4074a.getHead();
        kotlin.jvm.internal.p.f(head);
        byte[] bArrB = head.b(true);
        int pos = head.getPos();
        int iMin = Math.min(sink.remaining(), head.getLimit() - pos);
        sink.put(bArrB, pos, iMin);
        if (iMin == 0) {
            return iMin;
        }
        if (iMin < 0) {
            throw new IllegalStateException("Returned negative read bytes count");
        }
        if (iMin > head.j()) {
            throw new IllegalStateException("Returned too many bytes");
        }
        c4074a.skip(iMin);
        return iMin;
    }

    public static final void b(C4074a c4074a, OutputStream out, long j10) throws IOException {
        kotlin.jvm.internal.p.i(c4074a, "<this>");
        kotlin.jvm.internal.p.i(out, "out");
        z.b(c4074a.n(), 0L, j10);
        while (j10 > 0) {
            C4845d c4845d = C4845d.f34666a;
            if (c4074a.k()) {
                throw new IllegalArgumentException("Buffer is empty");
            }
            o head = c4074a.getHead();
            kotlin.jvm.internal.p.f(head);
            byte[] bArrB = head.b(true);
            int pos = head.getPos();
            int iMin = (int) Math.min(j10, head.getLimit() - pos);
            out.write(bArrB, pos, iMin);
            long j11 = iMin;
            j10 -= j11;
            if (iMin != 0) {
                if (iMin < 0) {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
                if (iMin > head.j()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                c4074a.skip(j11);
            }
        }
    }

    public static /* synthetic */ void c(C4074a c4074a, OutputStream outputStream, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = c4074a.n();
        }
        b(c4074a, outputStream, j10);
    }

    public static final C4074a d(C4074a c4074a, ByteBuffer source) {
        kotlin.jvm.internal.p.i(c4074a, "<this>");
        kotlin.jvm.internal.p.i(source, "source");
        int iRemaining = source.remaining();
        while (iRemaining > 0) {
            C4845d c4845d = C4845d.f34666a;
            o oVarK0 = c4074a.k0(1);
            byte[] bArrB = oVarK0.b(false);
            int limit = oVarK0.getLimit();
            int iMin = Math.min(iRemaining, bArrB.length - limit);
            source.get(bArrB, limit, iMin);
            iRemaining -= iMin;
            if (iMin == 1) {
                oVarK0.D(bArrB, iMin);
                oVarK0.s(oVarK0.getLimit() + iMin);
                c4074a.Y(c4074a.getSizeMut() + iMin);
            } else {
                if (iMin < 0 || iMin > oVarK0.h()) {
                    throw new IllegalStateException(("Invalid number of bytes written: " + iMin + ". Should be in 0.." + oVarK0.h()).toString());
                }
                if (iMin != 0) {
                    oVarK0.D(bArrB, iMin);
                    oVarK0.s(oVarK0.getLimit() + iMin);
                    c4074a.Y(c4074a.getSizeMut() + iMin);
                } else if (q.b(oVarK0)) {
                    c4074a.U();
                }
            }
        }
        return c4074a;
    }
}
