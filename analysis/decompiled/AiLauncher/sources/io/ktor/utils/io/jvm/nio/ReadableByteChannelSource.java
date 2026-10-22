package io.ktor.utils.io.jvm.nio;

import fb.C4074a;
import fb.InterfaceC4084k;
import fb.o;
import fb.q;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/jvm/nio/ReadableByteChannelSource;", "Lfb/k;", "Ljava/nio/channels/ReadableByteChannel;", "channel", "<init>", "(Ljava/nio/channels/ReadableByteChannel;)V", "Lfb/a;", "sink", "", "byteCount", "readAtMostTo", "(Lfb/a;J)J", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/nio/channels/ReadableByteChannel;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
class ReadableByteChannelSource implements InterfaceC4084k {
    private final ReadableByteChannel channel;

    public ReadableByteChannelSource(ReadableByteChannel channel) {
        p.i(channel, "channel");
        this.channel = channel;
    }

    @Override // fb.InterfaceC4084k, java.lang.AutoCloseable, fb.InterfaceC4083j
    public void close() throws IOException {
        this.channel.close();
    }

    @Override // fb.InterfaceC4084k
    public long readAtMostTo(C4074a sink, long byteCount) throws IOException {
        p.i(sink, "sink");
        if (byteCount <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(byteCount, 2147483647L);
        C4845d c4845d = C4845d.f34666a;
        o oVarK0 = sink.k0(1);
        byte[] bArrB = oVarK0.b(false);
        int limit = oVarK0.getLimit();
        int i10 = this.channel.read(ByteBuffer.wrap(bArrB, limit, Math.min(iMin, bArrB.length - limit)));
        int iMax = Math.max(i10, 0);
        if (iMax == 1) {
            oVarK0.D(bArrB, iMax);
            oVarK0.s(oVarK0.getLimit() + iMax);
            sink.Y(sink.getSizeMut() + iMax);
        } else {
            if (iMax < 0 || iMax > oVarK0.h()) {
                throw new IllegalStateException(("Invalid number of bytes written: " + iMax + ". Should be in 0.." + oVarK0.h()).toString());
            }
            if (iMax != 0) {
                oVarK0.D(bArrB, iMax);
                oVarK0.s(oVarK0.getLimit() + iMax);
                sink.Y(sink.getSizeMut() + iMax);
            } else if (q.b(oVarK0)) {
                sink.U();
            }
        }
        return i10;
    }

    public String toString() {
        return "ReadableByteChannelSource(" + this.channel + ')';
    }
}
