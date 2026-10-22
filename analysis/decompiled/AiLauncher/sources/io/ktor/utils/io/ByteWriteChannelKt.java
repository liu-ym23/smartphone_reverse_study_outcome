package io.ktor.utils.io;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "LY8/t;", "close", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "Lio/ktor/utils/io/ByteChannel;", "cancel", "(Lio/ktor/utils/io/ByteChannel;)V", "flushIfNeeded", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteWriteChannelKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.ByteWriteChannelKt$close$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
        public AnonymousClass1(Object obj) {
            super(1, obj, ByteWriteChannel.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
            return ((ByteWriteChannel) this.receiver).flushAndClose(interfaceC4014c);
        }
    }

    public static final void cancel(ByteChannel byteChannel) {
        p.i(byteChannel, "<this>");
        byteChannel.cancel(new IOException("Channel was cancelled"));
    }

    public static final void close(ByteWriteChannel byteWriteChannel) {
        p.i(byteWriteChannel, "<this>");
        ByteWriteChannelOperationsKt.fireAndForget(new AnonymousClass1(byteWriteChannel));
    }

    @InternalAPI
    public static final Object flushIfNeeded(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objFlush;
        ByteReadChannelOperationsKt.rethrowCloseCauseIfNeeded(byteWriteChannel);
        return ((byteWriteChannel.getAutoFlush() || BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer()) >= 1048576) && (objFlush = byteWriteChannel.flush(interfaceC4014c)) == C4063a.g()) ? objFlush : t.f7040a;
    }

    public static final void cancel(ByteWriteChannel byteWriteChannel) {
        p.i(byteWriteChannel, "<this>");
        byteWriteChannel.cancel(new IOException("Channel was cancelled"));
    }
}
