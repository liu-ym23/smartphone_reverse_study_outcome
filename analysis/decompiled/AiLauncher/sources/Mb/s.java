package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013¨\u0006\u0018"}, d2 = {"LMb/s;", "LMb/l;", "LMb/I;", "delegate", "", "byteCount", "", "throwIfSourceIsLonger", "<init>", "(LMb/I;JZ)V", "LMb/d;", "sink", "u0", "(LMb/d;J)J", "newByteCount", "LY8/t;", "e", "(LMb/d;J)V", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "Z", "c", "bytesReceived", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class s extends AbstractC0974l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long byteCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean throwIfSourceIsLonger;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long bytesReceived;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(I delegate, long j10, boolean z10) {
        super(delegate);
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.byteCount = j10;
        this.throwIfSourceIsLonger = z10;
        if (j10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    public final void e(C0966d c0966d, long j10) throws IOException {
        C0966d c0966d2 = new C0966d();
        c0966d2.V0(c0966d);
        c0966d.K(c0966d2, j10);
        c0966d2.g();
    }

    @Override // Mb.AbstractC0974l, Mb.I
    public long u0(C0966d sink, long byteCount) throws IOException {
        long jK;
        kotlin.jvm.internal.p.i(sink, "sink");
        long j10 = this.byteCount - this.bytesReceived;
        if (j10 < 0) {
            throw new IOException("expected " + this.byteCount + " bytes but got " + this.bytesReceived);
        }
        if (this.throwIfSourceIsLonger) {
            jK = C5685n.k(byteCount, j10 + 1);
        } else {
            if (j10 == 0) {
                return -1L;
            }
            jK = C5685n.k(byteCount, j10);
        }
        long jU0 = super.u0(sink, jK);
        if (jU0 == -1) {
            if (j10 == 0) {
                return -1L;
            }
            throw new EOFException("expected " + this.byteCount + " bytes but got " + this.bytesReceived);
        }
        long j11 = this.bytesReceived + jU0;
        this.bytesReceived = j11;
        long j12 = j11 - this.byteCount;
        if (j12 <= 0) {
            return jU0;
        }
        e(sink, sink.getSize() - j12);
        throw new IOException("expected " + this.byteCount + " bytes but got " + this.bytesReceived);
    }
}
