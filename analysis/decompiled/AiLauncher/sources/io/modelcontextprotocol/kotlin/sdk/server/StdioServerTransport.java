package io.modelcontextprotocol.kotlin.sdk.server;

import Ua.C1056g;
import Ua.C1060i;
import Ua.C1086v0;
import Ua.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4078e;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import io.modelcontextprotocol.kotlin.sdk.internal.Utils_jvmKt;
import io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.AbstractTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.ReadBuffer;
import j8.C4785k;
import j8.InterfaceC4782h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bH\u0096@¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/StdioServerTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/AbstractTransport;", "Lfb/v;", "inputStream", "Lfb/s;", "outputStream", "<init>", "(Lfb/v;Lfb/s;)V", "LY8/t;", "processReadBuffer", "(Le9/c;)Ljava/lang/Object;", "start", "close", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "send", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;Le9/c;)Ljava/lang/Object;", "Lfb/v;", "Lj8/h;", "logger", "Lj8/h;", "Lio/modelcontextprotocol/kotlin/sdk/shared/ReadBuffer;", "readBuffer", "Lio/modelcontextprotocol/kotlin/sdk/shared/ReadBuffer;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/g;", "readingJob", "Lkotlinx/coroutines/g;", "sendingJob", "Lkotlin/coroutines/d;", "coroutineContext", "Lkotlin/coroutines/d;", "LUa/M;", "scope", "LUa/M;", "LWa/g;", "", "readChannel", "LWa/g;", "writeChannel", "outputWriter", "Lfb/s;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StdioServerTransport extends AbstractTransport {
    private final kotlin.coroutines.d coroutineContext;
    private final AtomicBoolean initialized;
    private final fb.v inputStream;
    private final InterfaceC4782h logger;
    private final fb.s outputWriter;
    private final ReadBuffer readBuffer;
    private final Wa.g<byte[]> readChannel;
    private kotlinx.coroutines.g readingJob;
    private final Ua.M scope;
    private kotlinx.coroutines.g sendingJob;
    private final Wa.g<JSONRPCMessage> writeChannel;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$close$2", f = "StdioServerTransport.kt", l = {131}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$close$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invokeSuspend$lambda$2$lambda$1() {
            return "Failed to close stdin";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invokeSuspend$lambda$5$lambda$4() {
            return "Failed to close stdout";
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = StdioServerTransport.this.new AnonymousClass2(interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objB2;
            Ua.M m10 = (Ua.M) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Wa.s.a(StdioServerTransport.this.writeChannel, null, 1, null);
                kotlinx.coroutines.g gVar = StdioServerTransport.this.sendingJob;
                if (gVar != null) {
                    this.L$0 = m10;
                    this.label = 1;
                    if (C1086v0.g(gVar, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            StdioServerTransport stdioServerTransport = StdioServerTransport.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                stdioServerTransport.inputStream.close();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            StdioServerTransport stdioServerTransport2 = StdioServerTransport.this;
            Throwable thE = Result.e(objB);
            if (thE != null) {
                stdioServerTransport2.logger.h(thE, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.x0
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return StdioServerTransport.AnonymousClass2.invokeSuspend$lambda$2$lambda$1();
                    }
                });
            }
            kotlinx.coroutines.g gVar2 = StdioServerTransport.this.readingJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            Wa.s.a(StdioServerTransport.this.readChannel, null, 1, null);
            StdioServerTransport.this.readBuffer.clear();
            StdioServerTransport stdioServerTransport3 = StdioServerTransport.this;
            try {
                stdioServerTransport3.outputWriter.flush();
                stdioServerTransport3.outputWriter.close();
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            StdioServerTransport stdioServerTransport4 = StdioServerTransport.this;
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                stdioServerTransport4.logger.h(thE2, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.y0
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return StdioServerTransport.AnonymousClass2.invokeSuspend$lambda$5$lambda$4();
                    }
                });
            }
            StdioServerTransport.this.get_onClose().invoke();
            return Y8.t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport", f = "StdioServerTransport.kt", l = {119}, m = "processReadBuffer")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$processReadBuffer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StdioServerTransport.this.processReadBuffer(this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$start$2", f = "StdioServerTransport.kt", l = {68, 76, 76, 76}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$start$2, reason: invalid class name and case insensitive filesystem */
    public static final class C46032 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C46032(InterfaceC4014c<? super C46032> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invokeSuspend$lambda$0() {
            return "Error reading from stdin";
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C46032 c46032 = StdioServerTransport.this.new C46032(interfaceC4014c);
            c46032.L$0 = obj;
            return c46032;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C46032) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
        
            if (r13.close(r12) == r1) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d2, code lost:
        
            if (r13.close(r12) != r1) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00f1, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.C46032.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$start$3", f = "StdioServerTransport.kt", l = {83, 85}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$start$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return StdioServerTransport.this.new AnonymousClass3(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        
            if (r4.processReadBuffer(r6) == r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0053 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0016, B:18:0x003a, B:22:0x004b, B:24:0x0053, B:14:0x0029, B:17:0x0030), top: B:30:0x0008 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0072 -> B:8:0x0019). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2d
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r6.L$1
                byte[] r1 = (byte[]) r1
                java.lang.Object r1 = r6.L$0
                Wa.i r1 = (Wa.i) r1
                kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L1b
            L19:
                r7 = r1
                goto L3a
            L1b:
                r7 = move-exception
                goto L75
            L1d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L25:
                java.lang.Object r1 = r6.L$0
                Wa.i r1 = (Wa.i) r1
                kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L1b
                goto L4b
            L2d:
                kotlin.C4849c.b(r7)
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r7 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this     // Catch: java.lang.Throwable -> L1b
                Wa.g r7 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$getReadChannel$p(r7)     // Catch: java.lang.Throwable -> L1b
                Wa.i r7 = r7.iterator()     // Catch: java.lang.Throwable -> L1b
            L3a:
                r6.L$0 = r7     // Catch: java.lang.Throwable -> L1b
                r1 = 0
                r6.L$1 = r1     // Catch: java.lang.Throwable -> L1b
                r6.label = r3     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r1 = r7.a(r6)     // Catch: java.lang.Throwable -> L1b
                if (r1 != r0) goto L48
                goto L74
            L48:
                r5 = r1
                r1 = r7
                r7 = r5
            L4b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L1b
                boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L1b
                if (r7 == 0) goto L7e
                java.lang.Object r7 = r1.next()     // Catch: java.lang.Throwable -> L1b
                byte[] r7 = (byte[]) r7     // Catch: java.lang.Throwable -> L1b
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r4 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this     // Catch: java.lang.Throwable -> L1b
                io.modelcontextprotocol.kotlin.sdk.shared.ReadBuffer r4 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$getReadBuffer$p(r4)     // Catch: java.lang.Throwable -> L1b
                r4.append(r7)     // Catch: java.lang.Throwable -> L1b
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r4 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this     // Catch: java.lang.Throwable -> L1b
                r6.L$0 = r1     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L1b
                r6.L$1 = r7     // Catch: java.lang.Throwable -> L1b
                r6.label = r2     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r7 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$processReadBuffer(r4, r6)     // Catch: java.lang.Throwable -> L1b
                if (r7 != r0) goto L19
            L74:
                return r0
            L75:
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r6 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this
                p9.l r6 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$get_onError(r6)
                r6.invoke(r7)
            L7e:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$start$4", f = "StdioServerTransport.kt", l = {95}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$start$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        Object L$0;
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invokeSuspend$lambda$0() {
            return "Error writing to stdout";
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return StdioServerTransport.this.new AnonymousClass4(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #0 {all -> 0x0013, blocks: (B:6:0x000f, B:17:0x0037, B:19:0x003f, B:14:0x002c, B:13:0x0021), top: B:24:0x0007 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0034 -> B:17:0x0037). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r9.L$0
                Wa.i r1 = (Wa.i) r1
                kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L13
                goto L37
            L13:
                r0 = move-exception
                r10 = r0
                goto L60
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1e:
                kotlin.C4849c.b(r10)
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r10 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this     // Catch: java.lang.Throwable -> L13
                Wa.g r10 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$getWriteChannel$p(r10)     // Catch: java.lang.Throwable -> L13
                Wa.i r10 = r10.iterator()     // Catch: java.lang.Throwable -> L13
                r1 = r10
            L2c:
                r9.L$0 = r1     // Catch: java.lang.Throwable -> L13
                r9.label = r2     // Catch: java.lang.Throwable -> L13
                java.lang.Object r10 = r1.a(r9)     // Catch: java.lang.Throwable -> L13
                if (r10 != r0) goto L37
                return r0
            L37:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L13
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L13
                if (r10 == 0) goto L77
                java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L13
                io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r10 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r10     // Catch: java.lang.Throwable -> L13
                java.lang.String r4 = io.modelcontextprotocol.kotlin.sdk.shared.ReadBufferKt.serializeMessage(r10)     // Catch: java.lang.Throwable -> L13
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r10 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this     // Catch: java.lang.Throwable -> L13
                fb.s r3 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$getOutputWriter$p(r10)     // Catch: java.lang.Throwable -> L13
                r7 = 6
                r8 = 0
                r5 = 0
                r6 = 0
                fb.y.f(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L13
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r10 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this     // Catch: java.lang.Throwable -> L13
                fb.s r10 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$getOutputWriter$p(r10)     // Catch: java.lang.Throwable -> L13
                r10.flush()     // Catch: java.lang.Throwable -> L13
                goto L2c
            L60:
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r0 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this
                j8.h r0 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$getLogger$p(r0)
                io.modelcontextprotocol.kotlin.sdk.server.A0 r1 = new io.modelcontextprotocol.kotlin.sdk.server.A0
                r1.<init>()
                r0.a(r10, r1)
                io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport r9 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.this
                p9.l r9 = io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.access$get_onError(r9)
                r9.invoke(r10)
            L77:
                Y8.t r9 = Y8.t.f7040a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public StdioServerTransport(fb.v inputStream, fb.s outputStream) {
        kotlin.jvm.internal.p.i(inputStream, "inputStream");
        kotlin.jvm.internal.p.i(outputStream, "outputStream");
        this.inputStream = inputStream;
        this.logger = C4785k.f34533a.b(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.w0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Y8.t.f7040a;
            }
        });
        this.readBuffer = new ReadBuffer();
        this.initialized = new AtomicBoolean(false);
        kotlin.coroutines.d dVarPlus = Utils_jvmKt.getIODispatcher().plus(L0.b(null, 1, null));
        this.coroutineContext = dVarPlus;
        this.scope = kotlinx.coroutines.d.a(dVarPlus);
        this.readChannel = Wa.j.b(Integer.MAX_VALUE, null, null, 6, null);
        this.writeChannel = Wa.j.b(Integer.MAX_VALUE, null, null, 6, null);
        this.outputWriter = C4078e.a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x005f -> B:30:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processReadBuffer(e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$processReadBuffer$1 r0 = (io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$processReadBuffer$1 r0 = new io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport$processReadBuffer$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r2 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r2 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r2
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L3a
        L2d:
            r6 = move-exception
            goto L5f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.C4849c.b(r6)
        L3a:
            io.modelcontextprotocol.kotlin.sdk.shared.ReadBuffer r6 = r5.readBuffer     // Catch: java.lang.Throwable -> L41
            io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r6 = r6.readMessage()     // Catch: java.lang.Throwable -> L41
            goto L4a
        L41:
            r6 = move-exception
            p9.l r2 = r5.get_onError()
            r2.invoke(r6)
            r6 = 0
        L4a:
            if (r6 == 0) goto L67
            p9.p r2 = r5.get_onMessage()     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L2d
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r6 = r2.invoke(r6, r0)     // Catch: java.lang.Throwable -> L2d
            if (r6 != r1) goto L3a
            return r1
        L5f:
            p9.l r2 = r5.get_onError()
            r2.invoke(r6)
            goto L3a
        L67:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.StdioServerTransport.processReadBuffer(e9.c):java.lang.Object");
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object close(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ;
        return (this.initialized.compareAndSet(true, false) && (objJ = C1056g.j(kotlinx.coroutines.h.f36771a, new AnonymousClass2(null), interfaceC4014c)) == C4063a.g()) ? objJ : Y8.t.f7040a;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object send(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objSend = this.writeChannel.send(jSONRPCMessage, interfaceC4014c);
        return objSend == C4063a.g() ? objSend : Y8.t.f7040a;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Transport
    public Object start(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!this.initialized.compareAndSet(false, true)) {
            throw new IllegalStateException("StdioServerTransport already started!");
        }
        this.readingJob = C1060i.d(this.scope, null, null, new C46032(null), 3, null);
        C1060i.d(this.scope, null, null, new AnonymousClass3(null), 3, null);
        this.sendingJob = C1060i.d(this.scope, null, null, new AnonymousClass4(null), 3, null);
        return Y8.t.f7040a;
    }
}
