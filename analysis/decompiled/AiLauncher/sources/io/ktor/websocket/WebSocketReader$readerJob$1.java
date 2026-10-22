package io.ktor.websocket;

import Ua.M;
import Wa.r;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.websocket.WebSocketReader$readerJob$1", f = "WebSocketReader.kt", l = {43}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class WebSocketReader$readerJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    Object L$0;
    int label;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketReader$readerJob$1(ObjectPool<ByteBuffer> objectPool, WebSocketReader webSocketReader, InterfaceC4014c<? super WebSocketReader$readerJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pool = objectPool;
        this.this$0 = webSocketReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WebSocketReader$readerJob$1(this.$pool, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((WebSocketReader$readerJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        ByteBuffer byteBuffer;
        ProtocolViolationException e10;
        FrameTooBigException e11;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                ByteBuffer byteBufferBorrow = this.$pool.borrow();
                try {
                    WebSocketReader webSocketReader = this.this$0;
                    this.L$0 = byteBufferBorrow;
                    this.label = 1;
                    if (webSocketReader.readLoop(byteBufferBorrow, this) == objG) {
                        return objG;
                    }
                } catch (FrameTooBigException e12) {
                    byteBuffer = byteBufferBorrow;
                    e11 = e12;
                    this.this$0.queue.close(e11);
                    this.$pool.recycle(byteBuffer);
                    s.a(this.this$0.queue, null, 1, null);
                    return t.f7040a;
                } catch (ProtocolViolationException e13) {
                    byteBuffer = byteBufferBorrow;
                    e10 = e13;
                    this.this$0.queue.close(e10);
                    this.$pool.recycle(byteBuffer);
                    s.a(this.this$0.queue, null, 1, null);
                    return t.f7040a;
                } catch (ClosedChannelException | CancellationException unused) {
                } catch (IOException unused2) {
                    byteBuffer = byteBufferBorrow;
                    r.o(this.this$0.queue, null, 1, null);
                    this.$pool.recycle(byteBuffer);
                    s.a(this.this$0.queue, null, 1, null);
                    return t.f7040a;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
                byteBuffer = byteBufferBorrow;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBuffer = (ByteBuffer) this.L$0;
                try {
                    C4849c.b(obj);
                } catch (FrameTooBigException e14) {
                    e11 = e14;
                    this.this$0.queue.close(e11);
                } catch (ProtocolViolationException e15) {
                    e10 = e15;
                    this.this$0.queue.close(e10);
                } catch (ClosedChannelException | CancellationException unused3) {
                } catch (IOException unused4) {
                    r.o(this.this$0.queue, null, 1, null);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
            this.$pool.recycle(byteBuffer);
            s.a(this.this$0.queue, null, 1, null);
            return t.f7040a;
        } catch (Throwable th4) {
            this.$pool.recycle(objG);
            s.a(this.this$0.queue, null, 1, null);
            throw th4;
        }
    }
}
