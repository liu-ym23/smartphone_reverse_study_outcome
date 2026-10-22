package io.modelcontextprotocol.kotlin.sdk.shared;

import Ua.InterfaceC1083u;
import Ua.M;
import Ua.Q;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.EmptyRequestResult;
import io.modelcontextprotocol.kotlin.sdk.ErrorCode;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCError;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCResponse;
import io.modelcontextprotocol.kotlin.sdk.McpError;
import io.modelcontextprotocol.kotlin.sdk.Method;
import io.modelcontextprotocol.kotlin.sdk.Notification;
import io.modelcontextprotocol.kotlin.sdk.PingRequest;
import io.modelcontextprotocol.kotlin.sdk.Progress;
import io.modelcontextprotocol.kotlin.sdk.ProgressNotification;
import io.modelcontextprotocol.kotlin.sdk.Request;
import io.modelcontextprotocol.kotlin.sdk.RequestId;
import io.modelcontextprotocol.kotlin.sdk.RequestResult;
import io.modelcontextprotocol.kotlin.sdk.TypesKt;
import io.modelcontextprotocol.kotlin.sdk.shared.Protocol;
import j8.InterfaceC4782h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.serialization.KSerializer;
import mb.C4931a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;
import qb.D;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H$¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H$¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b)\u0010'J.\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010+*\u00020*2\u0006\u0010\u000e\u001a\u00020,2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010-H\u0086@¢\u0006\u0004\b\u000e\u0010.J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020/H\u0086@¢\u0006\u0004\b\n\u00100JU\u00105\u001a\u00020\u0006\"\n\b\u0000\u0010+\u0018\u0001*\u00020,2\u0006\u0010%\u001a\u00020$2,\b\b\u00104\u001a&\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000202\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010*03\u0012\u0006\u0012\u0004\u0018\u00010\u000101H\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u00106JU\u00105\u001a\u00020\u0006\"\b\b\u0000\u0010+*\u00020,2\u0006\u00108\u001a\u0002072\u0006\u0010%\u001a\u00020$2*\u00104\u001a&\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000202\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010*03\u0012\u0006\u0012\u0004\u0018\u00010\u000101H\u0001¢\u0006\u0004\b5\u00109J\u0015\u0010:\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b:\u0010'J9\u0010>\u001a\u00020\u0006\"\b\b\u0000\u0010+*\u00020/2\u0006\u0010%\u001a\u00020$2\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060<0;¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b@\u0010'R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010A\u0012\u0004\bD\u0010\b\u001a\u0004\bB\u0010CR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010E\u001a\u0004\u0018\u00010\u001e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001f\u0010F\u001a\u0004\bG\u0010HRH\u0010I\u001a(\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000202\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010*03\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR@\u0010P\u001a \b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000603\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010URA\u0010Z\u001a2\u0012\u0004\u0012\u00020W\u0012(\u0012&\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000202\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010*03\u0012\u0006\u0012\u0004\u0018\u00010\u0001010V8F¢\u0006\u0006\u001a\u0004\bX\u0010YR9\u0010\\\u001a*\u0012\u0004\u0012\u00020W\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000603\u0012\u0006\u0012\u0004\u0018\u00010\u00010O0V8F¢\u0006\u0006\u001a\u0004\b[\u0010YR9\u0010a\u001a*\u0012\u0004\u0012\u00020]\u0012 \u0012\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\f\u0012\n\u0018\u00010^j\u0004\u0018\u0001`_\u0012\u0004\u0012\u00020\u00060O0V8F¢\u0006\u0006\u001a\u0004\b`\u0010YR-\u0010e\u001a\u001e\u0012\u0004\u0012\u00020]\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u00060;j\u0002`c0V8F¢\u0006\u0006\u001a\u0004\bd\u0010Y\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006f"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/Protocol;", "", "Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;", "options", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;)V", "LY8/t;", "doClose", "()V", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "notification", "onNotification", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "request", "onRequest", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "onProgress", "(Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;)V", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;", UxipConstants.f30685x, "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "error", "onResponse", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;)V", "onClose", "", "onError", "(Ljava/lang/Throwable;)V", "Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;", "transport", Constants.METHOD_CONNECT, "(Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;Le9/c;)Ljava/lang/Object;", "close", "(Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "assertCapabilityForMethod", "(Lio/modelcontextprotocol/kotlin/sdk/Method;)V", "assertNotificationCapability", "assertRequestHandlerCapability", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/modelcontextprotocol/kotlin/sdk/Request;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;", "(Lio/modelcontextprotocol/kotlin/sdk/Request;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/Notification;", "(Lio/modelcontextprotocol/kotlin/sdk/Notification;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;", "Le9/c;", "block", "setRequestHandler", "(Lio/modelcontextprotocol/kotlin/sdk/Method;Lp9/q;)V", "Lw9/n;", "requestType", "(Lw9/n;Lio/modelcontextprotocol/kotlin/sdk/Method;Lp9/q;)V", "removeRequestHandler", "Lkotlin/Function1;", "LUa/Q;", "handler", "setNotificationHandler", "(Lio/modelcontextprotocol/kotlin/sdk/Method;Lp9/l;)V", "removeNotificationHandler", "Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;", "getOptions", "()Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;", "getOptions$annotations", UxipConstants.f30680s, "Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;", "getTransport", "()Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;", "fallbackRequestHandler", "Lp9/q;", "getFallbackRequestHandler", "()Lp9/q;", "setFallbackRequestHandler", "(Lp9/q;)V", "Lkotlin/Function2;", "fallbackNotificationHandler", "Lp9/p;", "getFallbackNotificationHandler", "()Lp9/p;", "setFallbackNotificationHandler", "(Lp9/p;)V", "", "", "getRequestHandlers", "()Ljava/util/Map;", "requestHandlers", "getNotificationHandlers", "notificationHandlers", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getResponseHandlers", "responseHandlers", "Lio/modelcontextprotocol/kotlin/sdk/Progress;", "Lio/modelcontextprotocol/kotlin/sdk/shared/ProgressCallback;", "getProgressHandlers", "progressHandlers", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Protocol {
    private p9.p<? super JSONRPCNotification, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> fallbackNotificationHandler;
    private p9.q<? super JSONRPCRequest, ? super RequestHandlerExtra, ? super InterfaceC4014c<? super RequestResult>, ? extends Object> fallbackRequestHandler;
    private final ProtocolOptions options;
    private Transport transport;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _requestHandlers$FU = AtomicReferenceFieldUpdater.newUpdater(Protocol.class, Object.class, "_requestHandlers");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _notificationHandlers$FU = AtomicReferenceFieldUpdater.newUpdater(Protocol.class, Object.class, "_notificationHandlers");
    static final /* synthetic */ AtomicReferenceFieldUpdater _responseHandlers$FU = AtomicReferenceFieldUpdater.newUpdater(Protocol.class, Object.class, "_responseHandlers");
    static final /* synthetic */ AtomicReferenceFieldUpdater _progressHandlers$FU = AtomicReferenceFieldUpdater.newUpdater(Protocol.class, Object.class, "_progressHandlers");
    private volatile /* synthetic */ Object _requestHandlers = Pa.a.b();
    private volatile /* synthetic */ Object _notificationHandlers = Pa.a.b();
    volatile /* synthetic */ Object _responseHandlers = Pa.a.b();
    volatile /* synthetic */ Object _progressHandlers = Pa.a.b();

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/PingRequest;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol$2", f = "Protocol.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.Protocol$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.q<PingRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PingRequest pingRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            return new AnonymousClass2(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return new EmptyRequestResult((D) null, 1, (kotlin.jvm.internal.i) null);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "LY8/t;", "<anonymous>", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol$connect$4", f = "Protocol.kt", l = {200, 201}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.Protocol$connect$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<JSONRPCMessage, InterfaceC4014c<? super Y8.t>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass4 anonymousClass4 = Protocol.this.new AnonymousClass4(interfaceC4014c);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // p9.p
        public final Object invoke(JSONRPCMessage jSONRPCMessage, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(jSONRPCMessage, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        
            if (r6.onRequest(r2, r5) == r1) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        
            if (r6.onNotification(r2, r5) == r1) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage r0 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r5.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L1f
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.C4849c.b(r6)
                goto L6a
            L1f:
                kotlin.C4849c.b(r6)
                boolean r6 = r0 instanceof io.modelcontextprotocol.kotlin.sdk.JSONRPCResponse
                r2 = 0
                if (r6 == 0) goto L2f
                io.modelcontextprotocol.kotlin.sdk.shared.Protocol r5 = io.modelcontextprotocol.kotlin.sdk.shared.Protocol.this
                io.modelcontextprotocol.kotlin.sdk.JSONRPCResponse r0 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCResponse) r0
                io.modelcontextprotocol.kotlin.sdk.shared.Protocol.access$onResponse(r5, r0, r2)
                goto L6a
            L2f:
                boolean r6 = r0 instanceof io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest
                if (r6 == 0) goto L47
                io.modelcontextprotocol.kotlin.sdk.shared.Protocol r6 = io.modelcontextprotocol.kotlin.sdk.shared.Protocol.this
                r2 = r0
                io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest r2 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest) r2
                java.lang.Object r0 = g9.h.a(r0)
                r5.L$0 = r0
                r5.label = r4
                java.lang.Object r5 = io.modelcontextprotocol.kotlin.sdk.shared.Protocol.access$onRequest(r6, r2, r5)
                if (r5 != r1) goto L6a
                goto L5e
            L47:
                boolean r6 = r0 instanceof io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification
                if (r6 == 0) goto L5f
                io.modelcontextprotocol.kotlin.sdk.shared.Protocol r6 = io.modelcontextprotocol.kotlin.sdk.shared.Protocol.this
                r2 = r0
                io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification r2 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification) r2
                java.lang.Object r0 = g9.h.a(r0)
                r5.L$0 = r0
                r5.label = r3
                java.lang.Object r5 = io.modelcontextprotocol.kotlin.sdk.shared.Protocol.access$onNotification(r6, r2, r5)
                if (r5 != r1) goto L6a
            L5e:
                return r1
            L5f:
                boolean r6 = r0 instanceof io.modelcontextprotocol.kotlin.sdk.JSONRPCError
                if (r6 == 0) goto L6d
                io.modelcontextprotocol.kotlin.sdk.shared.Protocol r5 = io.modelcontextprotocol.kotlin.sdk.shared.Protocol.this
                io.modelcontextprotocol.kotlin.sdk.JSONRPCError r0 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCError) r0
                io.modelcontextprotocol.kotlin.sdk.shared.Protocol.access$onResponse(r5, r2, r0)
            L6a:
                Y8.t r5 = Y8.t.f7040a
                return r5
            L6d:
                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                r5.<init>()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.Protocol.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol", f = "Protocol.kt", l = {232}, m = "onNotification")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.Protocol$onNotification$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Protocol.this.onNotification(null, this);
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol", f = "Protocol.kt", l = {247, 264, 267, 278}, m = "onRequest")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.Protocol$onRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C46351(InterfaceC4014c<? super C46351> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Protocol.this.onRequest(null, this);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol", f = "Protocol.kt", l = {441, 445, 448}, m = "request")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.Protocol$request$1, reason: invalid class name and case insensitive filesystem */
    public static final class C46361<T extends RequestResult> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C46361(InterfaceC4014c<? super C46361> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Protocol.this.request(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.shared.Protocol$request$6", f = "Protocol.kt", l = {443}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.shared.Protocol$request$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ JSONRPCRequest $message;
        final /* synthetic */ RequestId $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(JSONRPCRequest jSONRPCRequest, RequestId requestId, InterfaceC4014c<? super AnonymousClass6> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$message = jSONRPCRequest;
            this.$messageId = requestId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invokeSuspend$lambda$0(RequestId requestId) {
            return "Sending request message with id: " + requestId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return Protocol.this.new AnonymousClass6(this.$message, this.$messageId, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass6) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC4782h interfaceC4782h = ProtocolKt.LOGGER;
                final RequestId requestId = this.$messageId;
                interfaceC4782h.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.x
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return Protocol.AnonymousClass6.invokeSuspend$lambda$0(requestId);
                    }
                });
                Transport transport = Protocol.this.getTransport();
                if (transport == null) {
                    return null;
                }
                JSONRPCRequest jSONRPCRequest = this.$message;
                this.label = 1;
                if (transport.send(jSONRPCRequest, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public Protocol(ProtocolOptions protocolOptions) {
        this.options = protocolOptions;
        setNotificationHandler(Method.Defined.NotificationsProgress, new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Protocol._init_$lambda$0(this.f33849a, (ProgressNotification) obj);
            }
        });
        setRequestHandler(kotlin.jvm.internal.t.m(PingRequest.class), Method.Defined.Ping, new AnonymousClass2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q _init_$lambda$0(Protocol protocol, ProgressNotification notification) {
        kotlin.jvm.internal.p.i(notification, "notification");
        protocol.onProgress(notification);
        return ProtocolKt.getCOMPLETED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t connect$lambda$1(Protocol protocol) {
        protocol.doClose();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t connect$lambda$2(Protocol protocol, Throwable it) {
        kotlin.jvm.internal.p.i(it, "it");
        protocol.onError(it);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ Object connect$suspendImpl(final Protocol protocol, Transport transport, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        protocol.transport = transport;
        transport.onClose(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Protocol.connect$lambda$1(this.f33852a);
            }
        });
        transport.onError(new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Protocol.connect$lambda$2(this.f33853a, (Throwable) obj);
            }
        });
        transport.onMessage(protocol.new AnonymousClass4(null));
        Object objStart = transport.start(interfaceC4014c);
        return objStart == C4063a.g() ? objStart : Y8.t.f7040a;
    }

    private final void doClose() {
        List listM1 = F.m1(((Pa.d) this._responseHandlers).values());
        _responseHandlers$FU.getAndSet(this, Pa.a.b());
        _progressHandlers$FU.getAndSet(this, Pa.a.b());
        this.transport = null;
        onClose();
        McpError mcpError = new McpError(ErrorCode.Defined.ConnectionClosed.getCode(), "Connection closed", null, 4, null);
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((p9.p) it.next()).invoke(null, mcpError);
        }
    }

    public static /* synthetic */ void getOptions$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object notification$lambda$23(Notification notification) {
        return "Sending notification: " + notification.getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onNotification(final io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.modelcontextprotocol.kotlin.sdk.shared.Protocol.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.modelcontextprotocol.kotlin.sdk.shared.Protocol$onNotification$1 r0 = (io.modelcontextprotocol.kotlin.sdk.shared.Protocol.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.shared.Protocol$onNotification$1 r0 = new io.modelcontextprotocol.kotlin.sdk.shared.Protocol$onNotification$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$1
            p9.p r5 = (p9.p) r5
            java.lang.Object r5 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification r5 = (io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification) r5
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L31
            goto L8d
        L31:
            r6 = move-exception
            goto L7e
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r6)
            j8.h r6 = io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt.access$getLOGGER$p()
            io.modelcontextprotocol.kotlin.sdk.shared.l r2 = new io.modelcontextprotocol.kotlin.sdk.shared.l
            r2.<init>()
            r6.f(r2)
            java.util.Map r6 = r4.getNotificationHandlers()
            java.lang.String r2 = r5.getMethod()
            java.lang.Object r6 = r6.get(r2)
            p9.p r6 = (p9.p) r6
            if (r6 != 0) goto L5c
            p9.p<? super io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification, ? super e9.c<? super Y8.t>, ? extends java.lang.Object> r6 = r4.fallbackNotificationHandler
        L5c:
            if (r6 != 0) goto L6d
            j8.h r4 = io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt.access$getLOGGER$p()
            io.modelcontextprotocol.kotlin.sdk.shared.m r6 = new io.modelcontextprotocol.kotlin.sdk.shared.m
            r6.<init>()
            r4.f(r6)
            Y8.t r4 = Y8.t.f7040a
            return r4
        L6d:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L31
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L31
            r0.label = r3     // Catch: java.lang.Throwable -> L31
            java.lang.Object r4 = r6.invoke(r5, r0)     // Catch: java.lang.Throwable -> L31
            if (r4 != r1) goto L8d
            return r1
        L7e:
            j8.h r0 = io.modelcontextprotocol.kotlin.sdk.shared.ProtocolKt.access$getLOGGER$p()
            io.modelcontextprotocol.kotlin.sdk.shared.n r1 = new io.modelcontextprotocol.kotlin.sdk.shared.n
            r1.<init>()
            r0.a(r6, r1)
            r4.onError(r6)
        L8d:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.Protocol.onNotification(io.modelcontextprotocol.kotlin.sdk.JSONRPCNotification, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onNotification$lambda$3(JSONRPCNotification jSONRPCNotification) {
        return "Received notification: " + jSONRPCNotification.getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onNotification$lambda$4(JSONRPCNotification jSONRPCNotification) {
        return "No handler found for notification: " + jSONRPCNotification.getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onNotification$lambda$5(JSONRPCNotification jSONRPCNotification) {
        return "Error handling notification: " + jSONRPCNotification.getMethod();
    }

    private final void onProgress(final ProgressNotification notification) {
        ProtocolKt.LOGGER.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Protocol.onProgress$lambda$12(notification);
            }
        });
        int progress = notification.getProgress();
        Double total = notification.getTotal();
        String message = notification.getMessage();
        InterfaceC5074l interfaceC5074l = (InterfaceC5074l) ((Pa.d) this._progressHandlers).get(notification.getProgressToken());
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(new Progress(progress, total, message));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received a progress notification for an unknown token: ");
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        sb2.append(mcpJson.a(ProgressNotification.INSTANCE.serializer(), notification));
        final Error error = new Error(sb2.toString());
        ProtocolKt.LOGGER.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return error.getMessage();
            }
        });
        onError(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onProgress$lambda$12(ProgressNotification progressNotification) {
        return "Received progress notification: token=" + progressNotification.getProgressToken() + ", progress=" + progressNotification.getProgress() + JsonPointer.SEPARATOR + progressNotification.getTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0103, code lost:
    
        if (r0.send(r10, r3) == r4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0165, code lost:
    
        if (r0.send(r8, r3) == r4) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0143 A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #3 {all -> 0x0168, blocks: (B:51:0x0130, B:53:0x0143, B:48:0x0119), top: B:80:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0179 A[Catch: all -> 0x018c, TryCatch #4 {all -> 0x018c, blocks: (B:58:0x0175, B:60:0x0179, B:65:0x018f), top: B:82:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, p9.q] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onRequest(io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest r20, e9.InterfaceC4014c<? super Y8.t> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.Protocol.onRequest(io.modelcontextprotocol.kotlin.sdk.JSONRPCRequest, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onRequest$lambda$10(JSONRPCRequest jSONRPCRequest) {
        return "Error handling request: " + jSONRPCRequest.getMethod() + " (id: " + jSONRPCRequest.getId() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onRequest$lambda$11(JSONRPCRequest jSONRPCRequest) {
        return "Failed to send error response for request: " + jSONRPCRequest.getMethod() + " (id: " + jSONRPCRequest.getId() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onRequest$lambda$6(JSONRPCRequest jSONRPCRequest) {
        return "Received request: " + jSONRPCRequest.getMethod() + " (id: " + jSONRPCRequest.getId() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onRequest$lambda$7(JSONRPCRequest jSONRPCRequest) {
        return "No handler found for request: " + jSONRPCRequest.getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onRequest$lambda$8() {
        return "Error sending method not found response";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onRequest$lambda$9(JSONRPCRequest jSONRPCRequest) {
        return "Request handled successfully: " + jSONRPCRequest.getMethod() + " (id: " + jSONRPCRequest.getId() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onResponse(JSONRPCResponse response, JSONRPCError error) {
        Object obj;
        Pa.d dVar;
        Object obj2;
        RequestId id = response != null ? response.getId() : null;
        do {
            obj = this._responseHandlers;
            dVar = (Pa.d) obj;
        } while (!_responseHandlers$FU.compareAndSet(this, obj, (id == null || !dVar.containsKey(id)) ? dVar : dVar.remove((Pa.d) id)));
        p9.p pVar = (p9.p) dVar.get(id);
        if (pVar == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received a response for an unknown message ID: ");
            AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
            mcpJson.getSerializersModule();
            sb2.append(mcpJson.a(C4931a.t(JSONRPCResponse.INSTANCE.serializer()), response));
            onError(new Error(sb2.toString()));
            return;
        }
        if (id != null) {
            do {
                obj2 = this._progressHandlers;
            } while (!_progressHandlers$FU.compareAndSet(this, obj2, ((Pa.d) obj2).remove((Pa.d) id)));
        }
        if (response != null) {
            pVar.invoke(response, null);
        } else {
            if (error == null) {
                throw new IllegalStateException("Check failed.");
            }
            pVar.invoke(null, new McpError(error.getCode().getCode(), error.getMessage(), error.getData()));
        }
    }

    public static /* synthetic */ Object request$default(Protocol protocol, Request request, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return protocol.request(request, requestOptions, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object request$lambda$17(Request request) {
        return "Sending request: " + request.getMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object request$lambda$18(RequestId requestId) {
        return "Registering progress handler for request id: " + requestId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t request$lambda$21$lambda$20(InterfaceC1083u interfaceC1083u, JSONRPCResponse jSONRPCResponse, Exception exc) {
        if (exc != null) {
            interfaceC1083u.e(exc);
            return Y8.t.f7040a;
        }
        if ((jSONRPCResponse != null ? jSONRPCResponse.getError() : null) != null) {
            interfaceC1083u.e(new IllegalStateException(jSONRPCResponse.getError().toString()));
            return Y8.t.f7040a;
        }
        try {
            kotlin.jvm.internal.p.f(jSONRPCResponse);
            RequestResult result = jSONRPCResponse.getResult();
            kotlin.jvm.internal.p.g(result, "null cannot be cast to non-null type T of io.modelcontextprotocol.kotlin.sdk.shared.Protocol.request");
            interfaceC1083u.complete(result);
        } catch (Throwable th) {
            interfaceC1083u.e(th);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object request$lambda$22(long j10, Request request) {
        return "Request timed out after " + kotlin.time.a.s(j10) + "ms: " + request.getMethod();
    }

    public abstract void assertCapabilityForMethod(Method method);

    public abstract void assertNotificationCapability(Method method);

    public abstract void assertRequestHandlerCapability(Method method);

    public final Object close(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objClose;
        Transport transport = this.transport;
        return (transport == null || (objClose = transport.close(interfaceC4014c)) != C4063a.g()) ? Y8.t.f7040a : objClose;
    }

    public Object connect(Transport transport, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return connect$suspendImpl(this, transport, interfaceC4014c);
    }

    public final p9.p<JSONRPCNotification, InterfaceC4014c<? super Y8.t>, Object> getFallbackNotificationHandler() {
        return this.fallbackNotificationHandler;
    }

    public final p9.q<JSONRPCRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> getFallbackRequestHandler() {
        return this.fallbackRequestHandler;
    }

    public final Map<String, p9.p<JSONRPCNotification, InterfaceC4014c<? super Y8.t>, Object>> getNotificationHandlers() {
        return (Map) this._notificationHandlers;
    }

    public final ProtocolOptions getOptions() {
        return this.options;
    }

    public final Map<RequestId, InterfaceC5074l<Progress, Y8.t>> getProgressHandlers() {
        return (Map) this._progressHandlers;
    }

    public final Map<String, p9.q<JSONRPCRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object>> getRequestHandlers() {
        return (Map) this._requestHandlers;
    }

    public final Map<RequestId, p9.p<JSONRPCResponse, Exception, Y8.t>> getResponseHandlers() {
        return (Map) this._responseHandlers;
    }

    public final Transport getTransport() {
        return this.transport;
    }

    public final Object notification(final Notification notification, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ProtocolKt.LOGGER.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.shared.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Protocol.notification$lambda$23(notification);
            }
        });
        Transport transport = this.transport;
        if (transport == null) {
            throw new IllegalStateException("Not connected");
        }
        assertNotificationCapability(notification.getMethod());
        Object objSend = transport.send(TypesKt.toJSON(notification), interfaceC4014c);
        return objSend == C4063a.g() ? objSend : Y8.t.f7040a;
    }

    public void onClose() {
    }

    public void onError(Throwable error) {
        kotlin.jvm.internal.p.i(error, "error");
    }

    public final void removeNotificationHandler(Method method) {
        Object obj;
        kotlin.jvm.internal.p.i(method, "method");
        do {
            obj = this._notificationHandlers;
        } while (!_notificationHandlers$FU.compareAndSet(this, obj, ((Pa.d) obj).remove((Pa.d) method.getValue())));
    }

    public final void removeRequestHandler(Method method) {
        Object obj;
        kotlin.jvm.internal.p.i(method, "method");
        do {
            obj = this._requestHandlers;
        } while (!_requestHandlers$FU.compareAndSet(this, obj, ((Pa.d) obj).remove((Pa.d) method.getValue())));
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0210, code lost:
    
        if (r3.invoke(r0, r8) != r9) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T extends io.modelcontextprotocol.kotlin.sdk.RequestResult> java.lang.Object request(io.modelcontextprotocol.kotlin.sdk.Request r19, io.modelcontextprotocol.kotlin.sdk.shared.RequestOptions r20, e9.InterfaceC4014c<? super T> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.shared.Protocol.request(io.modelcontextprotocol.kotlin.sdk.Request, io.modelcontextprotocol.kotlin.sdk.shared.RequestOptions, e9.c):java.lang.Object");
    }

    public final void setFallbackNotificationHandler(p9.p<? super JSONRPCNotification, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        this.fallbackNotificationHandler = pVar;
    }

    public final void setFallbackRequestHandler(p9.q<? super JSONRPCRequest, ? super RequestHandlerExtra, ? super InterfaceC4014c<? super RequestResult>, ? extends Object> qVar) {
        this.fallbackRequestHandler = qVar;
    }

    public final <T extends Notification> void setNotificationHandler(Method method, InterfaceC5074l<? super T, ? extends Q<Y8.t>> handler) {
        Object obj;
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(handler, "handler");
        do {
            obj = this._notificationHandlers;
        } while (!_notificationHandlers$FU.compareAndSet(this, obj, ((Pa.d) obj).put((Pa.d) method.getValue(), (String) new Protocol$setNotificationHandler$1$1(handler, null))));
    }

    public final /* synthetic */ <T extends Request> void setRequestHandler(Method method, p9.q<? super T, ? super RequestHandlerExtra, ? super InterfaceC4014c<? super RequestResult>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(block, "block");
        kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        setRequestHandler(null, method, block);
    }

    public final <T extends Request> void setRequestHandler(InterfaceC5755n requestType, Method method, p9.q<? super T, ? super RequestHandlerExtra, ? super InterfaceC4014c<? super RequestResult>, ? extends Object> block) {
        Object obj;
        kotlin.jvm.internal.p.i(requestType, "requestType");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(block, "block");
        assertRequestHandlerCapability(method);
        KSerializer<Object> kSerializerB = lb.u.b(ProtocolKt.getMcpJson().getSerializersModule(), requestType);
        do {
            obj = this._requestHandlers;
        } while (!_requestHandlers$FU.compareAndSet(this, obj, ((Pa.d) obj).put((Pa.d) method.getValue(), (String) new Protocol$setRequestHandler$1$1(kSerializerB, block, null))));
    }
}
