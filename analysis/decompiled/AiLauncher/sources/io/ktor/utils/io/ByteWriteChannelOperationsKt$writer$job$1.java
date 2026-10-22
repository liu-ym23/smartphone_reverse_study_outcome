package io.ktor.utils.io;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt$writer$job$1", f = "ByteWriteChannelOperations.kt", l = {185, 195, 196, 195, 196, 195, 196}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ByteWriteChannelOperationsKt$writer$job$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ p<WriterScope, InterfaceC4014c<? super t>, Object> $block;
    final /* synthetic */ ByteChannel $channel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteWriteChannelOperationsKt$writer$job$1(p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, ByteChannel byteChannel, InterfaceC4014c<? super ByteWriteChannelOperationsKt$writer$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$block = pVar;
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ByteWriteChannelOperationsKt$writer$job$1 byteWriteChannelOperationsKt$writer$job$1 = new ByteWriteChannelOperationsKt$writer$job$1(this.$block, this.$channel, interfaceC4014c);
        byteWriteChannelOperationsKt$writer$job$1.L$0 = obj;
        return byteWriteChannelOperationsKt$writer$job$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ByteWriteChannelOperationsKt$writer$job$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[Catch: all -> 0x006c, TRY_LEAVE, TryCatch #4 {all -> 0x006c, blocks: (B:21:0x0068, B:30:0x00a0, B:32:0x00b1), top: B:81:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5 A[PHI: r2
      0x00d5: PHI (r2v15 Ua.x) = (r2v12 Ua.x), (r2v18 Ua.x) binds: [B:34:0x00d1, B:19:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelOperationsKt$writer$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
