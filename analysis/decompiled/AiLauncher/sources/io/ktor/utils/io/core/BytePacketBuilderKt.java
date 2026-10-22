package io.ktor.utils.io.core;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import fb.C4074a;
import fb.s;
import fb.v;
import io.ktor.http.ContentDisposition;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a-\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0012\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0015\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016\"\u001b\u0010\u001b\u001a\u00020\u0005*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018*\f\b\u0007\u0010\u0001\"\u00020\u00002\u00020\u0000¨\u0006\u001c"}, d2 = {"Lfb/s;", "BytePacketBuilder", "()Lfb/s;", "", UxipConstants.f30680s, "", "startIndex", "endIndex", "LY8/t;", "append", "(Lfb/s;Ljava/lang/CharSequence;II)V", "Lfb/v;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(Lfb/s;)Lfb/v;", "", "buffer", "offset", "length", "writeFully", "(Lfb/s;[BII)V", "packet", "writePacket", "(Lfb/s;Lfb/v;)V", "getSize", "(Lfb/s;)I", "getSize$annotations", "(Lfb/s;)V", ContentDisposition.Parameters.Size, "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BytePacketBuilderKt {
    public static final s BytePacketBuilder() {
        return new C4074a();
    }

    public static /* synthetic */ void BytePacketBuilder$annotations() {
    }

    public static final void append(s sVar, CharSequence value, int i10, int i11) {
        p.i(sVar, "<this>");
        p.i(value, "value");
        StringsKt.writeText$default(sVar, value, i10, i11, (Charset) null, 8, (Object) null);
    }

    public static /* synthetic */ void append$default(s sVar, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        append(sVar, charSequence, i10, i11);
    }

    public static final v build(s sVar) {
        p.i(sVar, "<this>");
        return sVar.getBufferField();
    }

    public static final int getSize(s sVar) {
        p.i(sVar, "<this>");
        return (int) sVar.getBufferField().n();
    }

    public static /* synthetic */ void getSize$annotations(s sVar) {
    }

    public static final void writeFully(s sVar, byte[] buffer, int i10, int i11) {
        p.i(sVar, "<this>");
        p.i(buffer, "buffer");
        sVar.write(buffer, i10, i11 + i10);
    }

    public static /* synthetic */ void writeFully$default(s sVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        writeFully(sVar, bArr, i10, i11);
    }

    public static final void writePacket(s sVar, v packet) {
        p.i(sVar, "<this>");
        p.i(packet, "packet");
        sVar.m0(packet);
    }
}
