package io.ktor.utils.io;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ChannelJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Lkotlinx/coroutines/g;", "job", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/coroutines/g;)V", "LY8/t;", "flushAndClose", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "getChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlinx/coroutines/g;", "getJob", "()Lkotlinx/coroutines/g;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReaderJob implements ChannelJob {
    private final ByteWriteChannel channel;
    private final g job;

    @InterfaceC4112d(c = "io.ktor.utils.io.ReaderJob", f = "ByteReadChannelOperations.kt", l = {311, 313}, m = "flushAndClose")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ReaderJob$flushAndClose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReaderJob.this.flushAndClose(this);
        }
    }

    public ReaderJob(ByteWriteChannel channel, g job) {
        p.i(channel, "channel");
        p.i(job, "job");
        this.channel = channel;
        this.job = job;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a3, code lost:
    
        if (r11.flushAndClose(r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object flushAndClose(e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof io.ktor.utils.io.ReaderJob.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            io.ktor.utils.io.ReaderJob$flushAndClose$1 r0 = (io.ktor.utils.io.ReaderJob.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ReaderJob$flushAndClose$1 r0 = new io.ktor.utils.io.ReaderJob$flushAndClose$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L49
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            kotlin.C4849c.b(r12)
            goto La6
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.g r7 = (kotlinx.coroutines.g) r7
            java.lang.Object r7 = r0.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$0
            Ka.j r8 = (Ka.j) r8
            kotlin.C4849c.b(r12)
            goto L62
        L49:
            kotlin.C4849c.b(r12)
            kotlinx.coroutines.g r12 = r11.getJob()
            Ua.C1086v0.k(r12, r6, r5, r6)
            kotlinx.coroutines.g r12 = r11.getJob()
            Ka.j r12 = r12.getChildren()
            java.util.Iterator r2 = r12.iterator()
            r8 = r12
            r7 = r2
            r2 = r3
        L62:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L93
            java.lang.Object r12 = r7.next()
            r9 = r12
            kotlinx.coroutines.g r9 = (kotlinx.coroutines.g) r9
            kotlinx.coroutines.g.a.a(r9, r6, r5, r6)
            java.lang.Object r10 = g9.h.a(r8)
            r0.L$0 = r10
            r0.L$1 = r7
            java.lang.Object r12 = g9.h.a(r12)
            r0.L$2 = r12
            java.lang.Object r12 = g9.h.a(r9)
            r0.L$3 = r12
            r0.I$0 = r2
            r0.I$1 = r3
            r0.label = r5
            java.lang.Object r12 = r9.T0(r0)
            if (r12 != r1) goto L62
            goto La5
        L93:
            io.ktor.utils.io.ByteWriteChannel r11 = r11.channel
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.L$3 = r6
            r0.label = r4
            java.lang.Object r11 = r11.flushAndClose(r0)
            if (r11 != r1) goto La6
        La5:
            return r1
        La6:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReaderJob.flushAndClose(e9.c):java.lang.Object");
    }

    public final ByteWriteChannel getChannel() {
        return this.channel;
    }

    @Override // io.ktor.utils.io.ChannelJob
    public g getJob() {
        return this.job;
    }
}
