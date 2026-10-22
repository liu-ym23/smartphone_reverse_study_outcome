package io.ktor.network.sockets;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.net.SocketTimeoutException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1$timeout$1", f = "CIOReader.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class CIOReaderKt$attachForReadingImpl$1$timeout$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ByteChannel $channel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOReaderKt$attachForReadingImpl$1$timeout$1(ByteChannel byteChannel, InterfaceC4014c<? super CIOReaderKt$attachForReadingImpl$1$timeout$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$channel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CIOReaderKt$attachForReadingImpl$1$timeout$1(this.$channel, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CIOReaderKt$attachForReadingImpl$1$timeout$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ByteWriteChannelOperationsKt.close(this.$channel, new SocketTimeoutException());
        return t.f7040a;
    }
}
