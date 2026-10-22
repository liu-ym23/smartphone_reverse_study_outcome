package io.ktor.websocket;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.websocket.WebSocketWriter$writeLoopJob$1", f = "WebSocketWriter.kt", l = {44}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class WebSocketWriter$writeLoopJob$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketWriter$writeLoopJob$1(WebSocketWriter webSocketWriter, InterfaceC4014c<? super WebSocketWriter$writeLoopJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = webSocketWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WebSocketWriter$writeLoopJob$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((WebSocketWriter$writeLoopJob$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        ObjectPool objectPool;
        Object obj2;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ObjectPool<ByteBuffer> pool = this.this$0.getPool();
            WebSocketWriter webSocketWriter = this.this$0;
            ByteBuffer byteBufferBorrow = pool.borrow();
            try {
                ByteBuffer byteBuffer = byteBufferBorrow;
                this.L$0 = pool;
                this.L$1 = byteBufferBorrow;
                this.L$2 = g9.h.a(byteBuffer);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                if (webSocketWriter.writeLoop(byteBuffer, this) == objG) {
                    return objG;
                }
                objectPool = pool;
                obj2 = byteBufferBorrow;
            } catch (Throwable th2) {
                th = th2;
                objectPool = pool;
                obj2 = byteBufferBorrow;
                objectPool.recycle(obj2);
                throw th;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.L$1;
            objectPool = (ObjectPool) this.L$0;
            try {
                C4849c.b(obj);
            } catch (Throwable th3) {
                th = th3;
                objectPool.recycle(obj2);
                throw th;
            }
        }
        t tVar = t.f7040a;
        objectPool.recycle(obj2);
        return t.f7040a;
    }
}
