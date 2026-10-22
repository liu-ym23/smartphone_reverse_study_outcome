package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import n9.C4946a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StdioClientTransport$start$3$readJob$1", f = "StdioClientTransport.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class StdioClientTransport$start$3$readJob$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ StdioClientTransport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StdioClientTransport$start$3$readJob$1(StdioClientTransport stdioClientTransport, InterfaceC4014c<? super StdioClientTransport$start$3$readJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = stdioClientTransport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeSuspend$lambda$0() {
        return "Read coroutine started.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object invokeSuspend$lambda$2() {
        return "Error reading from input stream";
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        StdioClientTransport$start$3$readJob$1 stdioClientTransport$start$3$readJob$1 = new StdioClientTransport$start$3$readJob$1(this.this$0, interfaceC4014c);
        stdioClientTransport$start$3$readJob$1.L$0 = obj;
        return stdioClientTransport$start$3$readJob$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((StdioClientTransport$start$3$readJob$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AutoCloseable autoCloseable;
        StdioClientTransport stdioClientTransport;
        int i10;
        AutoCloseable autoCloseable2;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                C4849c.b(obj);
                this.this$0.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.w
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return StdioClientTransport$start$3$readJob$1.invokeSuspend$lambda$0();
                    }
                });
                autoCloseable = this.this$0.input;
                stdioClientTransport = this.this$0;
                i10 = 0;
                autoCloseable2 = autoCloseable;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = this.I$0;
                autoCloseable2 = (fb.v) this.L$3;
                stdioClientTransport = (StdioClientTransport) this.L$2;
                autoCloseable = (AutoCloseable) this.L$1;
                try {
                    C4849c.b(obj);
                } finally {
                }
            }
            while (kotlinx.coroutines.d.h(m10)) {
                C4074a c4074a = new C4074a();
                long atMostTo = stdioClientTransport.input.readAtMostTo(c4074a, 8192L);
                if (atMostTo == -1) {
                    break;
                }
                if (atMostTo > 0) {
                    stdioClientTransport.readBuffer.append(fb.x.c(c4074a));
                    this.L$0 = m10;
                    this.L$1 = autoCloseable;
                    this.L$2 = stdioClientTransport;
                    this.L$3 = g9.h.a(autoCloseable2);
                    this.L$4 = g9.h.a(c4074a);
                    this.I$0 = i10;
                    this.J$0 = atMostTo;
                    this.label = 1;
                    if (stdioClientTransport.processReadBuffer(this) == objG) {
                        return objG;
                    }
                }
            }
            Y8.t tVar = Y8.t.f7040a;
            C4946a.a(autoCloseable, null);
        } catch (Exception e10) {
            this.this$0.get_onError().invoke(e10);
            this.this$0.logger.a(e10, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.x
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return StdioClientTransport$start$3$readJob$1.invokeSuspend$lambda$2();
                }
            });
        }
        return Y8.t.f7040a;
    }
}
