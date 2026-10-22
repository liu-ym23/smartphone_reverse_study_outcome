package fb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.OutputStream;
import kb.C4845d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lfb/h;", "Lfb/j;", "Ljava/io/OutputStream;", "out", "<init>", "(Ljava/io/OutputStream;)V", "Lfb/a;", "source", "", "byteCount", "LY8/t;", "write", "(Lfb/a;J)V", "flush", "()V", "close", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/io/OutputStream;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.h, reason: case insensitive filesystem and from toString */
/* loaded from: classes5.dex */
public class RawSink implements InterfaceC4083j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final OutputStream out;

    public RawSink(OutputStream out) {
        kotlin.jvm.internal.p.i(out, "out");
        this.out = out;
    }

    @Override // fb.InterfaceC4083j
    public void close() throws IOException {
        this.out.close();
    }

    @Override // fb.InterfaceC4083j, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    public String toString() {
        return "RawSink(" + this.out + ')';
    }

    @Override // fb.InterfaceC4083j
    public void write(C4074a source, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        z.b(source.n(), 0L, byteCount);
        while (byteCount > 0) {
            C4845d c4845d = C4845d.f34666a;
            if (source.k()) {
                throw new IllegalArgumentException("Buffer is empty");
            }
            o head = source.getHead();
            kotlin.jvm.internal.p.f(head);
            byte[] bArrB = head.b(true);
            int pos = head.getPos();
            int iMin = (int) Math.min(byteCount, head.getLimit() - pos);
            this.out.write(bArrB, pos, iMin);
            long j10 = iMin;
            byteCount -= j10;
            if (iMin != 0) {
                if (iMin < 0) {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
                if (iMin > head.j()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                source.skip(j10);
            }
        }
    }
}
