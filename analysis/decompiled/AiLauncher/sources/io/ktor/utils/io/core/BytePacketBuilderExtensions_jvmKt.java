package io.ktor.utils.io.core;

import fb.C4075b;
import fb.s;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lfb/s;", "Ljava/nio/ByteBuffer;", "buffer", "LY8/t;", "writeFully", "(Lfb/s;Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BytePacketBuilderExtensions_jvmKt {
    public static final void writeFully(s sVar, ByteBuffer buffer) {
        p.i(sVar, "<this>");
        p.i(buffer, "buffer");
        C4075b.d(sVar.getBufferField(), buffer);
    }
}
