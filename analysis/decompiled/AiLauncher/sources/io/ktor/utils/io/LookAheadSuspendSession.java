package io.ktor.utils.io;

import e9.InterfaceC4014c;
import fb.v;
import fb.x;
import g9.InterfaceC4112d;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/LookAheadSuspendSession;", "", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "skip", "atLeast", "Ljava/nio/ByteBuffer;", "request", "(II)Ljava/nio/ByteBuffer;", "min", "", "awaitAtLeast", "(ILe9/c;)Ljava/lang/Object;", "count", "LY8/t;", "consumed", "(I)V", "Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LookAheadSuspendSession {
    private final ByteReadChannel channel;

    @InterfaceC4112d(c = "io.ktor.utils.io.LookAheadSuspendSession", f = "LookAheadSession.kt", l = {42}, m = "awaitAtLeast")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.LookAheadSuspendSession$awaitAtLeast$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LookAheadSuspendSession.this.awaitAtLeast(0, this);
        }
    }

    public LookAheadSuspendSession(ByteReadChannel channel) {
        p.i(channel, "channel");
        this.channel = channel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteBuffer request$lambda$0(v it) {
        p.i(it, "it");
        return ByteBuffer.wrap(x.c(it));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitAtLeast(int r9, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.LookAheadSuspendSession.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.LookAheadSuspendSession$awaitAtLeast$1 r0 = (io.ktor.utils.io.LookAheadSuspendSession.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.LookAheadSuspendSession$awaitAtLeast$1 r0 = new io.ktor.utils.io.LookAheadSuspendSession$awaitAtLeast$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r9 = r0.I$0
            kotlin.C4849c.b(r10)
            goto L57
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.C4849c.b(r10)
            io.ktor.utils.io.ByteReadChannel r10 = r8.channel
            fb.v r10 = r10.getReadBuffer()
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r10)
            long r6 = (long) r9
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 < 0) goto L4a
            java.lang.Boolean r8 = g9.C4109a.a(r3)
            return r8
        L4a:
            io.ktor.utils.io.ByteReadChannel r10 = r8.channel
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r10 = r10.awaitContent(r9, r0)
            if (r10 != r1) goto L57
            return r1
        L57:
            io.ktor.utils.io.ByteReadChannel r8 = r8.channel
            fb.v r8 = r8.getReadBuffer()
            long r0 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r8)
            long r8 = (long) r9
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 < 0) goto L67
            goto L68
        L67:
            r3 = 0
        L68:
            java.lang.Boolean r8 = g9.C4109a.a(r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.LookAheadSuspendSession.awaitAtLeast(int, e9.c):java.lang.Object");
    }

    public final void consumed(int count) throws EOFException {
        ByteReadPacketKt.discard(this.channel.getReadBuffer(), count);
    }

    public final ByteBuffer request(int skip, int atLeast) {
        if (ByteReadPacketKt.getRemaining(this.channel.getReadBuffer()) < atLeast + skip) {
            return null;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ByteReadPacketKt.preview(this.channel.getReadBuffer(), new InterfaceC5074l() { // from class: io.ktor.utils.io.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return LookAheadSuspendSession.request$lambda$0((v) obj);
            }
        });
        if (skip > 0) {
            byteBuffer.position(byteBuffer.position() + skip);
        }
        return byteBuffer;
    }
}
