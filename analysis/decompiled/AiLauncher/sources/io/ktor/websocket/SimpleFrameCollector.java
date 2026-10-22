package io.ktor.websocket;

import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/ktor/websocket/SimpleFrameCollector;", "", "<init>", "()V", "", "length", "Ljava/nio/ByteBuffer;", "bb", "LY8/t;", "start", "(ILjava/nio/ByteBuffer;)V", "handle", "(Ljava/nio/ByteBuffer;)V", "maskKey", "take", "(Ljava/lang/Integer;)Ljava/nio/ByteBuffer;", "remaining", "I", "buffer", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "maskBuffer", "", "getHasRemaining", "()Z", "hasRemaining", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SimpleFrameCollector {
    private ByteBuffer buffer;
    private final ByteBuffer maskBuffer = ByteBuffer.allocate(4);
    private int remaining;

    public final boolean getHasRemaining() {
        return this.remaining > 0;
    }

    public final void handle(ByteBuffer bb2) {
        p.i(bb2, "bb");
        int i10 = this.remaining;
        ByteBuffer byteBuffer = this.buffer;
        p.f(byteBuffer);
        this.remaining = i10 - NIOKt.moveTo(bb2, byteBuffer, this.remaining);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void start(int r2, java.nio.ByteBuffer r3) {
        /*
            r1 = this;
            java.lang.String r0 = "bb"
            kotlin.jvm.internal.p.i(r3, r0)
            int r0 = r1.remaining
            if (r0 != 0) goto L2a
            r1.remaining = r2
            java.nio.ByteBuffer r0 = r1.buffer
            if (r0 == 0) goto L18
            kotlin.jvm.internal.p.f(r0)
            int r0 = r0.capacity()
            if (r0 >= r2) goto L1e
        L18:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)
            r1.buffer = r2
        L1e:
            java.nio.ByteBuffer r2 = r1.buffer
            kotlin.jvm.internal.p.f(r2)
            r2.clear()
            r1.handle(r3)
            return
        L2a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "remaining should be 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.SimpleFrameCollector.start(int, java.nio.ByteBuffer):void");
    }

    public final ByteBuffer take(Integer maskKey) {
        ByteBuffer byteBuffer = this.buffer;
        p.f(byteBuffer);
        byteBuffer.flip();
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        if (maskKey != null) {
            this.maskBuffer.clear();
            this.maskBuffer.asIntBuffer().put(maskKey.intValue());
            this.maskBuffer.clear();
            p.f(byteBufferSlice);
            ByteBuffer maskBuffer = this.maskBuffer;
            p.h(maskBuffer, "maskBuffer");
            UtilsKt.xor(byteBufferSlice, maskBuffer);
        }
        this.buffer = null;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBufferSlice.asReadOnlyBuffer();
        p.h(byteBufferAsReadOnlyBuffer, "run(...)");
        return byteBufferAsReadOnlyBuffer;
    }
}
