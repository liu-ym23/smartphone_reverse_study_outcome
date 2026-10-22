package fb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import kb.C4845d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lfb/f;", "Lfb/k;", "Ljava/io/InputStream;", "input", "<init>", "(Ljava/io/InputStream;)V", "Lfb/a;", "sink", "", "byteCount", "readAtMostTo", "(Lfb/a;J)J", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/io/InputStream;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public class RawSource implements InterfaceC4084k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InputStream input;

    public RawSource(InputStream input) {
        kotlin.jvm.internal.p.i(input, "input");
        this.input = input;
    }

    @Override // fb.InterfaceC4084k, java.lang.AutoCloseable, fb.InterfaceC4083j
    public void close() throws IOException {
        this.input.close();
    }

    @Override // fb.InterfaceC4084k
    public long readAtMostTo(C4074a sink, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount == 0) {
            return 0L;
        }
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
        }
        try {
            C4845d c4845d = C4845d.f34666a;
            o oVarK0 = sink.k0(1);
            int i10 = 0;
            byte[] bArrB = oVarK0.b(false);
            long j10 = this.input.read(bArrB, oVarK0.getLimit(), (int) Math.min(byteCount, bArrB.length - r4));
            if (j10 != -1) {
                i10 = (int) j10;
            }
            if (i10 == 1) {
                oVarK0.D(bArrB, i10);
                oVarK0.s(oVarK0.getLimit() + i10);
                sink.Y(sink.getSizeMut() + i10);
                return j10;
            }
            if (i10 < 0 || i10 > oVarK0.h()) {
                throw new IllegalStateException(("Invalid number of bytes written: " + i10 + ". Should be in 0.." + oVarK0.h()).toString());
            }
            if (i10 == 0) {
                if (q.b(oVarK0)) {
                    sink.U();
                }
                return j10;
            }
            oVarK0.D(bArrB, i10);
            oVarK0.s(oVarK0.getLimit() + i10);
            sink.Y(sink.getSizeMut() + i10);
            return j10;
        } catch (AssertionError e10) {
            if (C4080g.c(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    public String toString() {
        return "RawSource(" + this.input + ')';
    }
}
