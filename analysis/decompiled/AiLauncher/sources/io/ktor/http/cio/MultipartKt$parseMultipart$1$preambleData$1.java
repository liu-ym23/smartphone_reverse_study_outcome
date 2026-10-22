package io.ktor.http.cio;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import gb.C4114a;
import io.ktor.utils.io.CountedByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1$preambleData$1", f = "Multipart.kt", l = {206, 207}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class MultipartKt$parseMultipart$1$preambleData$1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ CountedByteReadChannel $countedInput;
    final /* synthetic */ C4114a $firstBoundary;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipartKt$parseMultipart$1$preambleData$1(C4114a c4114a, CountedByteReadChannel countedByteReadChannel, InterfaceC4014c<? super MultipartKt$parseMultipart$1$preambleData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$firstBoundary = c4114a;
        this.$countedInput = countedByteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MultipartKt$parseMultipart$1$preambleData$1 multipartKt$parseMultipart$1$preambleData$1 = new MultipartKt$parseMultipart$1$preambleData$1(this.$firstBoundary, this.$countedInput, interfaceC4014c);
        multipartKt$parseMultipart$1$preambleData$1.L$0 = obj;
        return multipartKt$parseMultipart$1$preambleData$1;
    }

    @Override // p9.p
    public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((MultipartKt$parseMultipart$1$preambleData$1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r10.flushAndClose(r9) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            io.ktor.utils.io.WriterScope r0 = (io.ktor.utils.io.WriterScope) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L23
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.C4849c.b(r11)
            goto L50
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1e:
            kotlin.C4849c.b(r11)
            r9 = r10
            goto L3d
        L23:
            kotlin.C4849c.b(r11)
            r11 = r4
            gb.a r4 = r10.$firstBoundary
            io.ktor.utils.io.CountedByteReadChannel r5 = r10.$countedInput
            io.ktor.utils.io.ByteWriteChannel r6 = r0.getChannel()
            r10.L$0 = r0
            r10.label = r11
            r7 = 8193(0x2001, double:4.048E-320)
            r9 = r10
            java.lang.Object r10 = io.ktor.http.cio.MultipartKt.access$parsePreambleImpl(r4, r5, r6, r7, r9)
            if (r10 != r1) goto L3d
            goto L4f
        L3d:
            io.ktor.utils.io.ByteWriteChannel r10 = r0.getChannel()
            java.lang.Object r11 = g9.h.a(r0)
            r9.L$0 = r11
            r9.label = r3
            java.lang.Object r10 = r10.flushAndClose(r9)
            if (r10 != r1) goto L50
        L4f:
            return r1
        L50:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt$parseMultipart$1$preambleData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
