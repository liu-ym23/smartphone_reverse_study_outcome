package io.ktor.utils.io.streams;

import Y8.t;
import fb.C4074a;
import fb.C4078e;
import fb.C4080g;
import fb.o;
import fb.q;
import fb.s;
import fb.v;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.SinkByteWriteChannelKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.io.SourcesJvmKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\n\u001a\u00020\t*\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\n\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0015\u001a\u00020\u0014*\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ljava/io/InputStream;", "Lfb/v;", "Lio/ktor/utils/io/core/Input;", "asInput", "(Ljava/io/InputStream;)Lfb/v;", "inputStream", "(Lfb/v;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "packet", "LY8/t;", "writePacket", "(Ljava/io/OutputStream;Lfb/v;)V", "Lkotlin/Function1;", "Lfb/s;", "block", "(Ljava/io/OutputStream;Lp9/l;)V", "", "min", "readPacketAtLeast", "(Ljava/io/InputStream;I)Lfb/v;", "Lio/ktor/utils/io/ByteWriteChannel;", "asByteWriteChannel", "(Ljava/io/OutputStream;)Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamsKt {
    public static final ByteWriteChannel asByteWriteChannel(OutputStream outputStream) {
        p.i(outputStream, "<this>");
        return SinkByteWriteChannelKt.asByteWriteChannel(C4080g.a(outputStream));
    }

    public static final v asInput(InputStream inputStream) {
        p.i(inputStream, "<this>");
        return C4078e.b(C4080g.b(inputStream));
    }

    public static final InputStream inputStream(v vVar) {
        p.i(vVar, "<this>");
        return SourcesJvmKt.b(vVar);
    }

    public static final v readPacketAtLeast(InputStream inputStream, int i10) throws IOException {
        p.i(inputStream, "<this>");
        C4074a c4074a = new C4074a();
        C4845d c4845d = C4845d.f34666a;
        o oVarK0 = c4074a.k0(i10);
        byte[] bArrB = oVarK0.b(false);
        int limit = oVarK0.getLimit();
        int i11 = inputStream.read(bArrB, limit, bArrB.length - limit);
        int i12 = i11 >= 0 ? i11 : 0;
        if (i12 == i10) {
            oVarK0.D(bArrB, i12);
            oVarK0.s(oVarK0.getLimit() + i12);
            c4074a.Y(c4074a.getSizeMut() + i12);
            return c4074a;
        }
        if (i12 < 0 || i12 > oVarK0.h()) {
            throw new IllegalStateException(("Invalid number of bytes written: " + i12 + ". Should be in 0.." + oVarK0.h()).toString());
        }
        if (i12 == 0) {
            if (q.b(oVarK0)) {
                c4074a.U();
            }
            return c4074a;
        }
        oVarK0.D(bArrB, i12);
        oVarK0.s(oVarK0.getLimit() + i12);
        c4074a.Y(c4074a.getSizeMut() + i12);
        return c4074a;
    }

    public static /* synthetic */ v readPacketAtLeast$default(InputStream inputStream, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return readPacketAtLeast(inputStream, i10);
    }

    public static final void writePacket(OutputStream outputStream, v packet) {
        p.i(outputStream, "<this>");
        p.i(packet, "packet");
        packet.B(C4080g.a(outputStream));
    }

    public static final void writePacket(OutputStream outputStream, InterfaceC5074l<? super s, t> block) {
        p.i(outputStream, "<this>");
        p.i(block, "block");
        C4074a c4074a = new C4074a();
        block.invoke(c4074a);
        writePacket(outputStream, c4074a);
    }
}
