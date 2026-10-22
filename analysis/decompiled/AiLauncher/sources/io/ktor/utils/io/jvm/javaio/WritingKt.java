package io.ktor.utils.io.jvm.javaio;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a&\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/OutputStream;", "out", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLe9/c;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WritingKt {

    @InterfaceC4112d(c = "io.ktor.utils.io.jvm.javaio.WritingKt", f = "Writing.kt", l = {25}, m = "copyTo")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WritingKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0073 -> B:25:0x007b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0081 -> B:27:0x0082). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r17, java.io.OutputStream r18, long r19, e9.InterfaceC4014c<? super java.lang.Long> r21) throws java.lang.Throwable {
        /*
            r0 = r19
            r2 = r21
            boolean r3 = r2 instanceof io.ktor.utils.io.jvm.javaio.WritingKt.AnonymousClass1
            if (r3 == 0) goto L17
            r3 = r2
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r3 = (io.ktor.utils.io.jvm.javaio.WritingKt.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L17
            int r4 = r4 - r5
            r3.label = r4
            goto L1c
        L17:
            io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1 r3 = new io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1
            r3.<init>(r2)
        L1c:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = f9.C4063a.g()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L41
            if (r5 != r6) goto L39
            long r0 = r3.J$1
            long r7 = r3.J$0
            java.lang.Object r5 = r3.L$1
            java.io.OutputStream r5 = (java.io.OutputStream) r5
            java.lang.Object r9 = r3.L$0
            io.ktor.utils.io.ByteReadChannel r9 = (io.ktor.utils.io.ByteReadChannel) r9
            kotlin.C4849c.b(r2)
            goto L7b
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.C4849c.b(r2)
            r7 = 0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 < 0) goto La5
            r5 = r3
            r2 = r0
            r0 = r17
            r1 = r18
        L50:
            boolean r9 = r0.isClosedForRead()
            if (r9 != 0) goto La0
            fb.v r9 = r0.getReadBuffer()
            boolean r9 = r9.k()
            if (r9 == 0) goto L81
            r5.L$0 = r0
            r5.L$1 = r1
            r5.J$0 = r2
            r5.J$1 = r7
            r5.label = r6
            r9 = 0
            r10 = 0
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r0, r9, r5, r6, r10)
            if (r9 != r4) goto L73
            return r4
        L73:
            r9 = r0
            r16 = r5
            r5 = r1
            r0 = r7
            r7 = r2
            r3 = r16
        L7b:
            r11 = r5
            r5 = r3
            r2 = r7
            r7 = r0
            r0 = r9
            goto L82
        L81:
            r11 = r1
        L82:
            fb.v r1 = r0.getReadBuffer()
            fb.a r1 = r1.getBufferField()
            long r9 = r1.n()
            long r7 = r7 + r9
            fb.v r1 = r0.getReadBuffer()
            fb.a r10 = r1.getBufferField()
            r14 = 2
            r15 = 0
            r12 = 0
            fb.C4075b.c(r10, r11, r12, r14, r15)
            r1 = r11
            goto L50
        La0:
            java.lang.Long r0 = g9.C4109a.g(r7)
            return r0
        La5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Limit shouldn't be negative: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, outputStream, j10, interfaceC4014c);
    }
}
