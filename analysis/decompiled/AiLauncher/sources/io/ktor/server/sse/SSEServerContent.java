package io.ktor.server.sse;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.sse.ServerSentEvent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import p9.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eB5\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\r\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R3\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR+\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/server/sse/SSEServerContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/server/application/ApplicationCall;", "call", "Lkotlin/Function2;", "Lio/ktor/server/sse/ServerSSESession;", "Le9/c;", "LY8/t;", "", "handle", "Lio/ktor/util/reflect/TypeInfo;", "", "serialize", "<init>", "(Lio/ktor/server/application/ApplicationCall;Lp9/p;Lp9/p;)V", "(Lio/ktor/server/application/ApplicationCall;Lp9/p;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "Lp9/p;", "getHandle", "()Lp9/p;", "getSerialize", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "ktor-server-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SSEServerContent extends OutgoingContent.WriteChannelContent {
    private final ApplicationCall call;
    private final ContentType contentType;
    private final p<ServerSSESession, InterfaceC4014c<? super t>, Object> handle;
    private final p<TypeInfo, Object, String> serialize;

    @InterfaceC4112d(c = "io.ktor.server.sse.SSEServerContent", f = "SSEServerContent.kt", l = {47, 61, 61}, m = "writeTo")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.sse.SSEServerContent$writeTo$1, reason: invalid class name */
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
            return SSEServerContent.this.writeTo(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.sse.SSEServerContent$writeTo$2", f = "SSEServerContent.kt", l = {56}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.sse.SSEServerContent$writeTo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteWriteChannel $channel;
        final /* synthetic */ Ref$ObjectRef<ServerSSESession> $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SSEServerContent this$0;

        @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096A¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0096A¢\u0006\u0004\b\u0006\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005H\u0096A¢\u0006\u0004\b\u000f\u0010\u0010R,\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"io/ktor/server/sse/SSEServerContent$writeTo$2$1", "Lio/ktor/server/sse/ServerSSESessionWithSerialization;", "Lio/ktor/server/sse/ServerSSESession;", "Lio/ktor/sse/ServerSentEvent;", "event", "LY8/t;", "send", "(Lio/ktor/sse/ServerSentEvent;Le9/c;)Ljava/lang/Object;", "", "data", "id", "", "retry", "comments", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "close", "(Le9/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lio/ktor/util/reflect/TypeInfo;", "", "serializer", "Lp9/p;", "getSerializer", "()Lp9/p;", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "call", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "ktor-server-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: io.ktor.server.sse.SSEServerContent$writeTo$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements ServerSSESessionWithSerialization, ServerSSESession {
            private final /* synthetic */ DefaultServerSSESession $$delegate_0;
            private final p<TypeInfo, Object, String> serializer;

            public AnonymousClass1(Ref$ObjectRef<ServerSSESession> ref$ObjectRef, SSEServerContent sSEServerContent) {
                ServerSSESession serverSSESession = ref$ObjectRef.f34820a;
                kotlin.jvm.internal.p.g(serverSSESession, "null cannot be cast to non-null type io.ktor.server.sse.DefaultServerSSESession");
                this.$$delegate_0 = (DefaultServerSSESession) serverSSESession;
                this.serializer = sSEServerContent.getSerialize();
            }

            @Override // io.ktor.server.sse.ServerSSESession
            public Object close(InterfaceC4014c<? super t> interfaceC4014c) {
                return this.$$delegate_0.close(interfaceC4014c);
            }

            @Override // io.ktor.server.sse.ServerSSESession
            public ApplicationCall getCall() {
                return this.$$delegate_0.getCall();
            }

            @Override // io.ktor.server.sse.ServerSSESessionWithSerialization, io.ktor.server.sse.ServerSSESession, Ua.M
            public kotlin.coroutines.d getCoroutineContext() {
                return this.$$delegate_0.getCoroutineContext();
            }

            @Override // io.ktor.server.sse.ServerSSESessionWithSerialization
            public p<TypeInfo, Object, String> getSerializer() {
                return this.serializer;
            }

            @Override // io.ktor.server.sse.ServerSSESession
            public Object send(ServerSentEvent serverSentEvent, InterfaceC4014c<? super t> interfaceC4014c) {
                return this.$$delegate_0.send(serverSentEvent, interfaceC4014c);
            }

            @Override // io.ktor.server.sse.ServerSSESession
            public Object send(String str, String str2, String str3, Long l10, String str4, InterfaceC4014c<? super t> interfaceC4014c) {
                return this.$$delegate_0.send(str, str2, str3, l10, str4, interfaceC4014c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef<ServerSSESession> ref$ObjectRef, ByteWriteChannel byteWriteChannel, SSEServerContent sSEServerContent, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$session = ref$ObjectRef;
            this.$channel = byteWriteChannel;
            this.this$0 = sSEServerContent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$session, this.$channel, this.this$0, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [T, io.ktor.server.sse.SSEServerContent$writeTo$2$1] */
        /* JADX WARN: Type inference failed for: r3v0, types: [T, io.ktor.server.sse.DefaultServerSSESession] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                M m10 = (M) this.L$0;
                this.$session.f34820a = new DefaultServerSSESession(this.$channel, this.this$0.getCall(), m10.getCoroutineContext());
                if (this.this$0.getSerialize() != null) {
                    Ref$ObjectRef<ServerSSESession> ref$ObjectRef = this.$session;
                    ref$ObjectRef.f34820a = new AnonymousClass1(ref$ObjectRef, this.this$0);
                }
                ServerSSESession serverSSESession = this.$session.f34820a;
                if (serverSSESession == null) {
                    return null;
                }
                p<ServerSSESession, InterfaceC4014c<? super t>, Object> handle = this.this$0.getHandle();
                this.label = 1;
                if (handle.invoke(serverSSESession, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    public /* synthetic */ SSEServerContent(ApplicationCall applicationCall, p pVar, p pVar2, int i10, i iVar) {
        this(applicationCall, pVar, (i10 & 4) != 0 ? null : pVar2);
    }

    public final ApplicationCall getCall() {
        return this.call;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public final p<ServerSSESession, InterfaceC4014c<? super t>, Object> getHandle() {
        return this.handle;
    }

    public final p<TypeInfo, Object, String> getSerialize() {
        return this.serialize;
    }

    public String toString() {
        return "SSEServerContent";
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
    
        if (r9.close(r0) == r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.sse.SSEServerContent.writeTo(io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSEServerContent(ApplicationCall call, p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> handle, p<? super TypeInfo, Object, String> pVar) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(handle, "handle");
        this.call = call;
        this.handle = handle;
        this.serialize = pVar;
        this.contentType = ContentType.Text.INSTANCE.getEventStream();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSEServerContent(ApplicationCall call, p<? super ServerSSESession, ? super InterfaceC4014c<? super t>, ? extends Object> handle) {
        this(call, handle, null);
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(handle, "handle");
    }
}
