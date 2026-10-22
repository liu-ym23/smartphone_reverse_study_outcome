package io.ktor.server.routing;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.HttpMethod;
import io.ktor.server.plugins.CannotTransformContentToTypeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u001a/\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\n\u001aC\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0012\u001aW\u0010\u0013\u001a\u00020\u0000\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0004\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aC\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0012\u001aC\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u0019\u0010\u0012\u001aW\u0010\u0019\u001a\u00020\u0000\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0004\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0017\u001aC\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u0012\u001aW\u0010\u001b\u001a\u00020\u0000\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0004\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017\u001aC\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u001d\u0010\u0012\u001aC\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u0010\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u0012\u001a\u001b\u0010 \u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Lio/ktor/server/routing/Route;", "Lkotlin/text/Regex;", "path", "Lkotlin/Function1;", "LY8/t;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, M5.a.CARD_TYPE_ROUTE, "(Lio/ktor/server/routing/Route;Lkotlin/text/Regex;Lp9/l;)Lio/ktor/server/routing/Route;", "Lio/ktor/http/HttpMethod;", "method", "(Lio/ktor/server/routing/Route;Lkotlin/text/Regex;Lio/ktor/http/HttpMethod;Lp9/l;)Lio/ktor/server/routing/Route;", "Lkotlin/Function2;", "Lio/ktor/server/routing/RoutingContext;", "Le9/c;", "", "Lio/ktor/server/routing/RoutingHandler;", "body", "get", "(Lio/ktor/server/routing/Route;Lkotlin/text/Regex;Lp9/p;)Lio/ktor/server/routing/Route;", "post", "R", "Lkotlin/Function3;", "postTypedPath", "(Lio/ktor/server/routing/Route;Lkotlin/text/Regex;Lp9/q;)Lio/ktor/server/routing/Route;", "head", "put", "putTypedPath", "patch", "patchTypedPath", ChatTracker.CLICK_DELETE, "options", "regex", "createRouteFromRegexPath", "(Lio/ktor/server/routing/Route;Lkotlin/text/Regex;)Lio/ktor/server/routing/Route;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RegexRoutingKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.routing.RegexRoutingKt$patch$2", f = "RegexRouting.kt", l = {316, 217}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RegexRoutingKt$patch$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$body, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
        
            if (r6.invoke(r1, r14, r13) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r13.label
                r2 = 6
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 4
                r5 = 2
                r6 = 1
                java.lang.String r7 = "R"
                r8 = 0
                if (r1 == 0) goto L2d
                if (r1 == r6) goto L21
                if (r1 != r5) goto L19
                kotlin.C4849c.b(r14)
                goto L69
            L19:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L21:
                java.lang.Object r1 = r13.L$1
                io.ktor.server.routing.RoutingContext r1 = (io.ktor.server.routing.RoutingContext) r1
                java.lang.Object r6 = r13.L$0
                p9.q r6 = (p9.q) r6
                kotlin.C4849c.b(r14)
                goto L5a
            L2d:
                kotlin.C4849c.b(r14)
                java.lang.Object r14 = r13.L$0
                r1 = r14
                io.ktor.server.routing.RoutingContext r1 = (io.ktor.server.routing.RoutingContext) r1
                p9.q<io.ktor.server.routing.RoutingContext, R, e9.c<? super Y8.t>, java.lang.Object> r14 = r13.$body
                io.ktor.server.routing.RoutingCall r9 = r1.getCall()
                kotlin.jvm.internal.p.o(r4, r7)
                w9.d r10 = kotlin.jvm.internal.t.b(r3)
                kotlin.jvm.internal.p.o(r2, r7)     // Catch: java.lang.Throwable -> L45
            L45:
                io.ktor.util.reflect.TypeInfo r11 = new io.ktor.util.reflect.TypeInfo
                r11.<init>(r10, r8)
                r13.L$0 = r14
                r13.L$1 = r1
                r13.label = r6
                java.lang.Object r6 = r9.receiveNullable(r11, r13)
                if (r6 != r0) goto L57
                goto L68
            L57:
                r12 = r6
                r6 = r14
                r14 = r12
            L5a:
                if (r14 == 0) goto L6c
                r13.L$0 = r8
                r13.L$1 = r8
                r13.label = r5
                java.lang.Object r13 = r6.invoke(r1, r14, r13)
                if (r13 != r0) goto L69
            L68:
                return r0
            L69:
                Y8.t r13 = Y8.t.f7040a
                return r13
            L6c:
                kotlin.jvm.internal.p.o(r4, r7)
                w9.d r13 = kotlin.jvm.internal.t.b(r3)
                kotlin.jvm.internal.p.o(r2, r7)     // Catch: java.lang.Throwable -> L76
            L76:
                io.ktor.util.reflect.TypeInfo r14 = new io.ktor.util.reflect.TypeInfo
                r14.<init>(r13, r8)
                w9.n r13 = r14.getKotlinType()
                kotlin.jvm.internal.p.f(r13)
                io.ktor.server.plugins.CannotTransformContentToTypeException r14 = new io.ktor.server.plugins.CannotTransformContentToTypeException
                r14.<init>(r13)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RegexRoutingKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invokeSuspend$$forInline(Object obj) throws CannotTransformContentToTypeException {
            RoutingContext routingContext = (RoutingContext) this.L$0;
            kotlin.jvm.internal.n.c(10);
            p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$body;
            RoutingCall call = routingContext.getCall();
            kotlin.jvm.internal.p.o(4, "R");
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, "R");
            } catch (Throwable unused) {
            }
            TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
            kotlin.jvm.internal.n.c(0);
            Object objReceiveNullable = call.receiveNullable(typeInfo, this);
            kotlin.jvm.internal.n.c(1);
            if (objReceiveNullable != null) {
                qVar.invoke(routingContext, objReceiveNullable, this);
                return Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.o(4, "R");
            InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, "R");
            } catch (Throwable unused2) {
            }
            InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, null).getKotlinType();
            kotlin.jvm.internal.p.f(kotlinType);
            throw new CannotTransformContentToTypeException(kotlinType);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.routing.RegexRoutingKt$post$2", f = "RegexRouting.kt", l = {316, 114}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RegexRoutingKt$post$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43942 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43942(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super C43942> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43942 c43942 = new C43942(this.$body, interfaceC4014c);
            c43942.L$0 = obj;
            return c43942;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43942) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
        
            if (r6.invoke(r1, r14, r13) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r13.label
                r2 = 6
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 4
                r5 = 2
                r6 = 1
                java.lang.String r7 = "R"
                r8 = 0
                if (r1 == 0) goto L2d
                if (r1 == r6) goto L21
                if (r1 != r5) goto L19
                kotlin.C4849c.b(r14)
                goto L69
            L19:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L21:
                java.lang.Object r1 = r13.L$1
                io.ktor.server.routing.RoutingContext r1 = (io.ktor.server.routing.RoutingContext) r1
                java.lang.Object r6 = r13.L$0
                p9.q r6 = (p9.q) r6
                kotlin.C4849c.b(r14)
                goto L5a
            L2d:
                kotlin.C4849c.b(r14)
                java.lang.Object r14 = r13.L$0
                r1 = r14
                io.ktor.server.routing.RoutingContext r1 = (io.ktor.server.routing.RoutingContext) r1
                p9.q<io.ktor.server.routing.RoutingContext, R, e9.c<? super Y8.t>, java.lang.Object> r14 = r13.$body
                io.ktor.server.routing.RoutingCall r9 = r1.getCall()
                kotlin.jvm.internal.p.o(r4, r7)
                w9.d r10 = kotlin.jvm.internal.t.b(r3)
                kotlin.jvm.internal.p.o(r2, r7)     // Catch: java.lang.Throwable -> L45
            L45:
                io.ktor.util.reflect.TypeInfo r11 = new io.ktor.util.reflect.TypeInfo
                r11.<init>(r10, r8)
                r13.L$0 = r14
                r13.L$1 = r1
                r13.label = r6
                java.lang.Object r6 = r9.receiveNullable(r11, r13)
                if (r6 != r0) goto L57
                goto L68
            L57:
                r12 = r6
                r6 = r14
                r14 = r12
            L5a:
                if (r14 == 0) goto L6c
                r13.L$0 = r8
                r13.L$1 = r8
                r13.label = r5
                java.lang.Object r13 = r6.invoke(r1, r14, r13)
                if (r13 != r0) goto L69
            L68:
                return r0
            L69:
                Y8.t r13 = Y8.t.f7040a
                return r13
            L6c:
                kotlin.jvm.internal.p.o(r4, r7)
                w9.d r13 = kotlin.jvm.internal.t.b(r3)
                kotlin.jvm.internal.p.o(r2, r7)     // Catch: java.lang.Throwable -> L76
            L76:
                io.ktor.util.reflect.TypeInfo r14 = new io.ktor.util.reflect.TypeInfo
                r14.<init>(r13, r8)
                w9.n r13 = r14.getKotlinType()
                kotlin.jvm.internal.p.f(r13)
                io.ktor.server.plugins.CannotTransformContentToTypeException r14 = new io.ktor.server.plugins.CannotTransformContentToTypeException
                r14.<init>(r13)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RegexRoutingKt.C43942.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invokeSuspend$$forInline(Object obj) throws CannotTransformContentToTypeException {
            RoutingContext routingContext = (RoutingContext) this.L$0;
            kotlin.jvm.internal.n.c(10);
            p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$body;
            RoutingCall call = routingContext.getCall();
            kotlin.jvm.internal.p.o(4, "R");
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, "R");
            } catch (Throwable unused) {
            }
            TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
            kotlin.jvm.internal.n.c(0);
            Object objReceiveNullable = call.receiveNullable(typeInfo, this);
            kotlin.jvm.internal.n.c(1);
            if (objReceiveNullable != null) {
                qVar.invoke(routingContext, objReceiveNullable, this);
                return Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.o(4, "R");
            InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, "R");
            } catch (Throwable unused2) {
            }
            InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, null).getKotlinType();
            kotlin.jvm.internal.p.f(kotlinType);
            throw new CannotTransformContentToTypeException(kotlinType);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.routing.RegexRoutingKt$put$2", f = "RegexRouting.kt", l = {316, 175}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RegexRoutingKt$put$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43952 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43952(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super C43952> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43952 c43952 = new C43952(this.$body, interfaceC4014c);
            c43952.L$0 = obj;
            return c43952;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43952) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
        
            if (r6.invoke(r1, r14, r13) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r13.label
                r2 = 6
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 4
                r5 = 2
                r6 = 1
                java.lang.String r7 = "R"
                r8 = 0
                if (r1 == 0) goto L2d
                if (r1 == r6) goto L21
                if (r1 != r5) goto L19
                kotlin.C4849c.b(r14)
                goto L69
            L19:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L21:
                java.lang.Object r1 = r13.L$1
                io.ktor.server.routing.RoutingContext r1 = (io.ktor.server.routing.RoutingContext) r1
                java.lang.Object r6 = r13.L$0
                p9.q r6 = (p9.q) r6
                kotlin.C4849c.b(r14)
                goto L5a
            L2d:
                kotlin.C4849c.b(r14)
                java.lang.Object r14 = r13.L$0
                r1 = r14
                io.ktor.server.routing.RoutingContext r1 = (io.ktor.server.routing.RoutingContext) r1
                p9.q<io.ktor.server.routing.RoutingContext, R, e9.c<? super Y8.t>, java.lang.Object> r14 = r13.$body
                io.ktor.server.routing.RoutingCall r9 = r1.getCall()
                kotlin.jvm.internal.p.o(r4, r7)
                w9.d r10 = kotlin.jvm.internal.t.b(r3)
                kotlin.jvm.internal.p.o(r2, r7)     // Catch: java.lang.Throwable -> L45
            L45:
                io.ktor.util.reflect.TypeInfo r11 = new io.ktor.util.reflect.TypeInfo
                r11.<init>(r10, r8)
                r13.L$0 = r14
                r13.L$1 = r1
                r13.label = r6
                java.lang.Object r6 = r9.receiveNullable(r11, r13)
                if (r6 != r0) goto L57
                goto L68
            L57:
                r12 = r6
                r6 = r14
                r14 = r12
            L5a:
                if (r14 == 0) goto L6c
                r13.L$0 = r8
                r13.L$1 = r8
                r13.label = r5
                java.lang.Object r13 = r6.invoke(r1, r14, r13)
                if (r13 != r0) goto L69
            L68:
                return r0
            L69:
                Y8.t r13 = Y8.t.f7040a
                return r13
            L6c:
                kotlin.jvm.internal.p.o(r4, r7)
                w9.d r13 = kotlin.jvm.internal.t.b(r3)
                kotlin.jvm.internal.p.o(r2, r7)     // Catch: java.lang.Throwable -> L76
            L76:
                io.ktor.util.reflect.TypeInfo r14 = new io.ktor.util.reflect.TypeInfo
                r14.<init>(r13, r8)
                w9.n r13 = r14.getKotlinType()
                kotlin.jvm.internal.p.f(r13)
                io.ktor.server.plugins.CannotTransformContentToTypeException r14 = new io.ktor.server.plugins.CannotTransformContentToTypeException
                r14.<init>(r13)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RegexRoutingKt.C43952.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invokeSuspend$$forInline(Object obj) throws CannotTransformContentToTypeException {
            RoutingContext routingContext = (RoutingContext) this.L$0;
            kotlin.jvm.internal.n.c(10);
            p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$body;
            RoutingCall call = routingContext.getCall();
            kotlin.jvm.internal.p.o(4, "R");
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, "R");
            } catch (Throwable unused) {
            }
            TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
            kotlin.jvm.internal.n.c(0);
            Object objReceiveNullable = call.receiveNullable(typeInfo, this);
            kotlin.jvm.internal.n.c(1);
            if (objReceiveNullable != null) {
                qVar.invoke(routingContext, objReceiveNullable, this);
                return Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.o(4, "R");
            InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, "R");
            } catch (Throwable unused2) {
            }
            InterfaceC5755n kotlinType = new TypeInfo(interfaceC5745dB2, null).getKotlinType();
            kotlin.jvm.internal.p.f(kotlinType);
            throw new CannotTransformContentToTypeException(kotlinType);
        }
    }

    private static final Route createRouteFromRegexPath(Route route, Regex regex) {
        return route.createChild(new Regex(regex));
    }

    @KtorDsl
    public static final Route delete(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getDelete(), new InterfaceC5074l() { // from class: io.ktor.server.routing.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.delete$lambda$5(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t delete$lambda$5(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route get(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getGet(), new InterfaceC5074l() { // from class: io.ktor.server.routing.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.get$lambda$0(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t get$lambda$0(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route head(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getHead(), new InterfaceC5074l() { // from class: io.ktor.server.routing.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.head$lambda$2(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t head$lambda$2(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route options(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getOptions(), new InterfaceC5074l() { // from class: io.ktor.server.routing.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.options$lambda$6(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t options$lambda$6(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route patch(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getPatch(), new InterfaceC5074l() { // from class: io.ktor.server.routing.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.patch$lambda$4(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t patch$lambda$4(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route patchTypedPath(Route route, Regex path, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return patch(route, path, new AnonymousClass2(body, null));
    }

    @KtorDsl
    public static final Route post(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getPost(), new InterfaceC5074l() { // from class: io.ktor.server.routing.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.post$lambda$1(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t post$lambda$1(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route postTypedPath(Route route, Regex path, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return post(route, path, new C43942(body, null));
    }

    @KtorDsl
    public static final Route put(Route route, Regex path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getPut(), new InterfaceC5074l() { // from class: io.ktor.server.routing.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RegexRoutingKt.put$lambda$3(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t put$lambda$3(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route putTypedPath(Route route, Regex path, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return put(route, path, new C43952(body, null));
    }

    @KtorDsl
    public static final Route route(Route route, Regex path, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateRouteFromRegexPath = createRouteFromRegexPath(route, path);
        build.invoke(routeCreateRouteFromRegexPath);
        return routeCreateRouteFromRegexPath;
    }

    @KtorDsl
    public static final Route route(Route route, Regex path, HttpMethod method, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = createRouteFromRegexPath(route, path).createChild(new HttpMethodRouteSelector(method));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }
}
