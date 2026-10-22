package io.ktor.client.plugins.sse;

import La.D;
import Z8.C1165m;
import Z8.F;
import io.ktor.client.plugins.sse.BodyBuffer;
import io.ktor.client.plugins.sse.SSEBufferPolicy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "Lio/ktor/client/plugins/sse/BodyBuffer;", "toBodyBuffer", "(Lio/ktor/client/plugins/sse/SSEBufferPolicy;)Lio/ktor/client/plugins/sse/BodyBuffer;", "LZ8/m;", "array", "", "toByteArray", "(LZ8/m;)[B", "", "NEWLINE", "Ljava/lang/String;", "EMPTY", "[B", "getEMPTY", "()[B", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SSEBufferPolicyKt {
    private static final byte[] EMPTY = new byte[0];
    private static final String NEWLINE = "\r\n";

    public static final byte[] getEMPTY() {
        return EMPTY;
    }

    public static final BodyBuffer toBodyBuffer(SSEBufferPolicy sSEBufferPolicy) {
        kotlin.jvm.internal.p.i(sSEBufferPolicy, "<this>");
        if (sSEBufferPolicy instanceof SSEBufferPolicy.Off) {
            return BodyBuffer.Empty.INSTANCE;
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.LastEvent) {
            return new BodyBuffer.Events(1);
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.LastEvents) {
            return new BodyBuffer.Events(((SSEBufferPolicy.LastEvents) sSEBufferPolicy).getCount());
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.LastLines) {
            return new BodyBuffer.Lines(((SSEBufferPolicy.LastLines) sSEBufferPolicy).getCount());
        }
        if (sSEBufferPolicy instanceof SSEBufferPolicy.All) {
            return new BodyBuffer.Lines(Integer.MAX_VALUE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] toByteArray(C1165m<?> c1165m) {
        return D.G(F.A0(c1165m, "\r\n", null, null, 0, null, null, 62, null));
    }
}
