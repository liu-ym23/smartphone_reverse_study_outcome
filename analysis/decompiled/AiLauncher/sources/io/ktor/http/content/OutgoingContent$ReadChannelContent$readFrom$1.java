package io.ktor.http.content;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import v9.C5683l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.http.content.OutgoingContent$ReadChannelContent$readFrom$1", f = "OutgoingContent.kt", l = {119, 121}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class OutgoingContent$ReadChannelContent$readFrom$1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ C5683l $range;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OutgoingContent.ReadChannelContent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingContent$ReadChannelContent$readFrom$1(OutgoingContent.ReadChannelContent readChannelContent, C5683l c5683l, InterfaceC4014c<? super OutgoingContent$ReadChannelContent$readFrom$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = readChannelContent;
        this.$range = c5683l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        OutgoingContent$ReadChannelContent$readFrom$1 outgoingContent$ReadChannelContent$readFrom$1 = new OutgoingContent$ReadChannelContent$readFrom$1(this.this$0, this.$range, interfaceC4014c);
        outgoingContent$ReadChannelContent$readFrom$1.L$0 = obj;
        return outgoingContent$ReadChannelContent$readFrom$1;
    }

    @Override // p9.p
    public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((OutgoingContent$ReadChannelContent$readFrom$1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        if (io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(r2, r9, r4, r8) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.L$0
            io.ktor.utils.io.WriterScope r0 = (io.ktor.utils.io.WriterScope) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r8.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2a
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r8 = r8.L$1
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.C4849c.b(r9)
            goto L71
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L22:
            java.lang.Object r2 = r8.L$1
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r9)
            goto L46
        L2a:
            kotlin.C4849c.b(r9)
            io.ktor.http.content.OutgoingContent$ReadChannelContent r9 = r8.this$0
            io.ktor.utils.io.ByteReadChannel r2 = r9.readFrom()
            v9.l r9 = r8.$range
            long r5 = r9.getFirst()
            r8.L$0 = r0
            r8.L$1 = r2
            r8.label = r4
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannelOperationsKt.discard(r2, r5, r8)
            if (r9 != r1) goto L46
            goto L70
        L46:
            v9.l r9 = r8.$range
            long r4 = r9.getLast()
            v9.l r9 = r8.$range
            long r6 = r9.getFirst()
            long r4 = r4 - r6
            r6 = 1
            long r4 = r4 + r6
            io.ktor.utils.io.ByteWriteChannel r9 = r0.getChannel()
            java.lang.Object r0 = g9.h.a(r0)
            r8.L$0 = r0
            java.lang.Object r0 = g9.h.a(r2)
            r8.L$1 = r0
            r8.J$0 = r4
            r8.label = r3
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(r2, r9, r4, r8)
            if (r8 != r1) goto L71
        L70:
            return r1
        L71:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.OutgoingContent$ReadChannelContent$readFrom$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
