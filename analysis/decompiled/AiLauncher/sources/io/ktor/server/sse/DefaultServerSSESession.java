package io.ktor.server.sse;

import Y8.t;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.sse.ServerSSESession;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/server/sse/DefaultServerSSESession;", "Lio/ktor/server/sse/ServerSSESession;", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lio/ktor/server/application/ApplicationCall;", "call", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/server/application/ApplicationCall;Lkotlin/coroutines/d;)V", "Lio/ktor/sse/ServerSentEvent;", "event", "LY8/t;", "writeSSE", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/sse/ServerSentEvent;Le9/c;)Ljava/lang/Object;", "send", "(Lio/ktor/sse/ServerSentEvent;Le9/c;)Ljava/lang/Object;", "close", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Leb/a;", "mutex", "Leb/a;", "ktor-server-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultServerSSESession implements ServerSSESession {
    private final ApplicationCall call;
    private final kotlin.coroutines.d coroutineContext;
    private final InterfaceC4021a mutex;
    private final ByteWriteChannel output;

    @InterfaceC4112d(c = "io.ktor.server.sse.DefaultServerSSESession", f = "DefaultServerSSESession.kt", l = {44, 28}, m = "close")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.sse.DefaultServerSSESession$close$1, reason: invalid class name */
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
            return DefaultServerSSESession.this.close(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.sse.DefaultServerSSESession", f = "DefaultServerSSESession.kt", l = {44, 22}, m = "send")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.sse.DefaultServerSSESession$send$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C44071(InterfaceC4014c<? super C44071> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultServerSSESession.this.send(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.sse.DefaultServerSSESession", f = "DefaultServerSSESession.kt", l = {34, 35}, m = "writeSSE")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.sse.DefaultServerSSESession$writeSSE$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44081(InterfaceC4014c<? super C44081> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultServerSSESession.this.writeSSE(null, null, this);
        }
    }

    public DefaultServerSSESession(ByteWriteChannel output, ApplicationCall call, kotlin.coroutines.d coroutineContext) {
        p.i(output, "output");
        p.i(call, "call");
        p.i(coroutineContext, "coroutineContext");
        this.output = output;
        this.call = call;
        this.coroutineContext = coroutineContext;
        this.mutex = f.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        if (r5.flush(r0) == r7) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeSSE(io.ktor.utils.io.ByteWriteChannel r5, io.ktor.sse.ServerSentEvent r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.server.sse.DefaultServerSSESession.C44081
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.server.sse.DefaultServerSSESession$writeSSE$1 r0 = (io.ktor.server.sse.DefaultServerSSESession.C44081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.sse.DefaultServerSSESession$writeSSE$1 r0 = new io.ktor.server.sse.DefaultServerSSESession$writeSSE$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.C4849c.b(r4)
            goto L67
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.C4849c.b(r4)
            goto L5b
        L3c:
            kotlin.C4849c.b(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r6 = "\r\n"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeStringUtf8(r5, r4, r0)
            if (r4 != r7) goto L5b
            goto L66
        L5b:
            r4 = 0
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r4 = r5.flush(r0)
            if (r4 != r7) goto L67
        L66:
            return r7
        L67:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.sse.DefaultServerSSESession.writeSSE(io.ktor.utils.io.ByteWriteChannel, io.ktor.sse.ServerSentEvent, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.sse.ServerSSESession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object close(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.ktor.server.sse.DefaultServerSSESession.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.sse.DefaultServerSSESession$close$1 r0 = (io.ktor.server.sse.DefaultServerSSESession.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.sse.DefaultServerSSESession$close$1 r0 = new io.ktor.server.sse.DefaultServerSSESession$close$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$0
            eb.a r7 = (eb.InterfaceC4021a) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L31
            goto L62
        L31:
            r8 = move-exception
            goto L6e
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r2 = r0.L$0
            eb.a r2 = (eb.InterfaceC4021a) r2
            kotlin.C4849c.b(r8)
            r8 = r2
            goto L54
        L44:
            kotlin.C4849c.b(r8)
            eb.a r8 = r7.mutex
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r2 = r8.m(r5, r0)
            if (r2 != r1) goto L54
            goto L60
        L54:
            io.ktor.utils.io.ByteWriteChannel r7 = r7.output     // Catch: java.lang.Throwable -> L6a
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L6a
            r0.label = r3     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r7 = r7.flushAndClose(r0)     // Catch: java.lang.Throwable -> L6a
            if (r7 != r1) goto L61
        L60:
            return r1
        L61:
            r7 = r8
        L62:
            Y8.t r8 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L31
            r7.l(r5)
            Y8.t r7 = Y8.t.f7040a
            return r7
        L6a:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L6e:
            r7.l(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.sse.DefaultServerSSESession.close(e9.c):java.lang.Object");
    }

    @Override // io.ktor.server.sse.ServerSSESession
    public ApplicationCall getCall() {
        return this.call;
    }

    @Override // io.ktor.server.sse.ServerSSESession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.server.sse.ServerSSESession
    public Object send(String str, String str2, String str3, Long l10, String str4, InterfaceC4014c<? super t> interfaceC4014c) {
        return ServerSSESession.DefaultImpls.send(this, str, str2, str3, l10, str4, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.sse.ServerSSESession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object send(io.ktor.sse.ServerSentEvent r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.server.sse.DefaultServerSSESession.C44071
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.server.sse.DefaultServerSSESession$send$1 r0 = (io.ktor.server.sse.DefaultServerSSESession.C44071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.sse.DefaultServerSSESession$send$1 r0 = new io.ktor.server.sse.DefaultServerSSESession$send$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$0
            eb.a r7 = (eb.InterfaceC4021a) r7
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L31
            goto L6b
        L31:
            r8 = move-exception
            goto L77
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r8 = r0.L$1
            eb.a r8 = (eb.InterfaceC4021a) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.sse.ServerSentEvent r2 = (io.ktor.sse.ServerSentEvent) r2
            kotlin.C4849c.b(r9)
            goto L5b
        L47:
            kotlin.C4849c.b(r9)
            eb.a r9 = r7.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = r9.m(r5, r0)
            if (r2 != r1) goto L59
            goto L69
        L59:
            r2 = r8
            r8 = r9
        L5b:
            io.ktor.utils.io.ByteWriteChannel r9 = r7.output     // Catch: java.lang.Throwable -> L73
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L73
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L73
            r0.label = r3     // Catch: java.lang.Throwable -> L73
            java.lang.Object r7 = r7.writeSSE(r9, r2, r0)     // Catch: java.lang.Throwable -> L73
            if (r7 != r1) goto L6a
        L69:
            return r1
        L6a:
            r7 = r8
        L6b:
            Y8.t r8 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L31
            r7.l(r5)
            Y8.t r7 = Y8.t.f7040a
            return r7
        L73:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L77:
            r7.l(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.sse.DefaultServerSSESession.send(io.ktor.sse.ServerSentEvent, e9.c):java.lang.Object");
    }
}
