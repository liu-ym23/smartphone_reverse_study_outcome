package io.ktor.server.routing;

import Z8.C1173v;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMethod;
import io.ktor.server.plugins.CannotTransformContentToTypeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a/\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\n\u001a/\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\t\u0010\f\u001a7\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0007\u001a/\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0007\u001a7\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0010\u001a;\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u00142\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aC\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a;\u0010\u001f\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b\u001f\u0010!\u001aC\u0010\"\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b\"\u0010 \u001aO\u0010\"\u001a\u00020\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001d*\u00020\u00002*\b\u0004\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aW\u0010\"\u001a\u00020\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001d*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0004\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a;\u0010\"\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b\"\u0010!\u001aC\u0010)\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b)\u0010 \u001a;\u0010)\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b)\u0010!\u001aC\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b*\u0010 \u001a;\u0010*\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b*\u0010!\u001aO\u0010*\u001a\u00020\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001d*\u00020\u00002*\b\u0004\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010&\u001aW\u0010*\u001a\u00020\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001d*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0004\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010(\u001aC\u0010-\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b-\u0010 \u001a;\u0010-\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b-\u0010!\u001aO\u0010-\u001a\u00020\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001d*\u00020\u00002*\b\u0004\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$H\u0087\bø\u0001\u0000¢\u0006\u0004\b.\u0010&\u001aW\u0010-\u001a\u00020\u0000\"\n\b\u0000\u0010#\u0018\u0001*\u00020\u001d*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0004\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$H\u0087\bø\u0001\u0000¢\u0006\u0004\b/\u0010(\u001aC\u00100\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b0\u0010 \u001a;\u00100\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b0\u0010!\u001aC\u00101\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b1\u0010 \u001a;\u00101\u001a\u00020\u0000*\u00020\u00002&\u0010\u000b\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aj\u0002`\u001eH\u0007¢\u0006\u0004\b1\u0010!\u001a\u0019\u00102\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Lio/ktor/server/routing/Route;", "", "path", "Lkotlin/Function1;", "LY8/t;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, M5.a.CARD_TYPE_ROUTE, "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/l;)Lio/ktor/server/routing/Route;", "Lio/ktor/http/HttpMethod;", "method", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lio/ktor/http/HttpMethod;Lp9/l;)Lio/ktor/server/routing/Route;", "body", "(Lio/ktor/server/routing/Route;Lio/ktor/http/HttpMethod;Lp9/l;)Lio/ktor/server/routing/Route;", "name", UxipConstants.f30680s, "param", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Ljava/lang/String;Lp9/l;)Lio/ktor/server/routing/Route;", "optionalParam", "header", "", "Lio/ktor/http/ContentType;", "contentTypes", "accept", "(Lio/ktor/server/routing/Route;[Lio/ktor/http/ContentType;Lp9/l;)Lio/ktor/server/routing/Route;", "contentType", "(Lio/ktor/server/routing/Route;Lio/ktor/http/ContentType;Lp9/l;)Lio/ktor/server/routing/Route;", "Lkotlin/Function2;", "Lio/ktor/server/routing/RoutingContext;", "Le9/c;", "", "Lio/ktor/server/routing/RoutingHandler;", "get", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/p;)Lio/ktor/server/routing/Route;", "(Lio/ktor/server/routing/Route;Lp9/p;)Lio/ktor/server/routing/Route;", "post", "R", "Lkotlin/Function3;", "postTyped", "(Lio/ktor/server/routing/Route;Lp9/q;)Lio/ktor/server/routing/Route;", "postTypedPath", "(Lio/ktor/server/routing/Route;Ljava/lang/String;Lp9/q;)Lio/ktor/server/routing/Route;", "head", "put", "putTyped", "putTypedPath", "patch", "patchTyped", "patchTypedPath", ChatTracker.CLICK_DELETE, "options", "createRouteFromPath", "(Lio/ktor/server/routing/Route;Ljava/lang/String;)Lio/ktor/server/routing/Route;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingBuilderKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoutingPathSegmentKind.values().length];
            try {
                iArr[RoutingPathSegmentKind.Parameter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoutingPathSegmentKind.Constant.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingBuilderKt$patch$3", f = "RoutingBuilder.kt", l = {473, 324}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RoutingBuilderKt$patch$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$body, interfaceC4014c);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingBuilderKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
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
    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingBuilderKt$patch$4", f = "RoutingBuilder.kt", l = {473, 340}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RoutingBuilderKt$patch$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$body, interfaceC4014c);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingBuilderKt.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
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
    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingBuilderKt$post$2", f = "RoutingBuilder.kt", l = {473, 178}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RoutingBuilderKt$post$2, reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingBuilderKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
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
    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingBuilderKt$post$3", f = "RoutingBuilder.kt", l = {473, 194}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RoutingBuilderKt$post$3, reason: invalid class name and case insensitive filesystem */
    public static final class C43963 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43963(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super C43963> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43963 c43963 = new C43963(this.$body, interfaceC4014c);
            c43963.L$0 = obj;
            return c43963;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43963) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingBuilderKt.C43963.invokeSuspend(java.lang.Object):java.lang.Object");
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
    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingBuilderKt$put$3", f = "RoutingBuilder.kt", l = {473, 269}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RoutingBuilderKt$put$3, reason: invalid class name and case insensitive filesystem */
    public static final class C43973 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43973(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super C43973> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43973 c43973 = new C43973(this.$body, interfaceC4014c);
            c43973.L$0 = obj;
            return c43973;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43973) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingBuilderKt.C43973.invokeSuspend(java.lang.Object):java.lang.Object");
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
    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingBuilderKt$put$4", f = "RoutingBuilder.kt", l = {473, 285}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.routing.RoutingBuilderKt$put$4, reason: invalid class name and case insensitive filesystem */
    public static final class C43984 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<RoutingContext, R, InterfaceC4014c<? super Y8.t>, Object> $body;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43984(p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super C43984> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$body = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43984 c43984 = new C43984(this.$body, interfaceC4014c);
            c43984.L$0 = obj;
            return c43984;
        }

        @Override // p9.p
        public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((C43984) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingBuilderKt.C43984.invokeSuspend(java.lang.Object):java.lang.Object");
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

    @KtorDsl
    public static final Route accept(Route route, ContentType[] contentTypes, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(contentTypes, "contentTypes");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new HttpMultiAcceptRouteSelector(C1173v.p(Arrays.copyOf(contentTypes, contentTypes.length))));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    @KtorDsl
    public static final Route contentType(Route route, ContentType contentType, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new ContentTypeHeaderRouteSelector(contentType));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    public static final Route createRouteFromPath(Route route, String path) {
        RouteSelector parameter;
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        List<RoutingPathSegment> parts = RoutingPath.INSTANCE.parse(path).getParts();
        int size = parts.size();
        for (int i10 = 0; i10 < size; i10++) {
            RoutingPathSegment routingPathSegment = parts.get(i10);
            String value = routingPathSegment.getValue();
            int i11 = WhenMappings.$EnumSwitchMapping$0[routingPathSegment.getKind().ordinal()];
            if (i11 == 1) {
                parameter = PathSegmentSelectorBuilder.INSTANCE.parseParameter(value);
            } else {
                if (i11 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                parameter = PathSegmentSelectorBuilder.INSTANCE.parseConstant(value);
            }
            route = route.createChild(parameter);
        }
        return La.D.K(path, "/", false, 2, null) ? route.createChild(TrailingSlashRouteSelector.INSTANCE) : route;
    }

    @KtorDsl
    public static final Route delete(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getDelete(), new InterfaceC5074l() { // from class: io.ktor.server.routing.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.delete$lambda$10(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t delete$lambda$10(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t delete$lambda$11(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route get(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getGet(), new InterfaceC5074l() { // from class: io.ktor.server.routing.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.get$lambda$0(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t get$lambda$0(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t get$lambda$1(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route head(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getHead(), new InterfaceC5074l() { // from class: io.ktor.server.routing.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.head$lambda$4(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t head$lambda$4(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t head$lambda$5(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route header(Route route, String name, String value, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new HttpHeaderRouteSelector(name, value));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    @KtorDsl
    public static final Route method(Route route, HttpMethod method, InterfaceC5074l<? super Route, Y8.t> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(body, "body");
        Route routeCreateChild = route.createChild(new HttpMethodRouteSelector(method));
        body.invoke(routeCreateChild);
        return routeCreateChild;
    }

    @KtorDsl
    public static final Route optionalParam(Route route, String name, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new OptionalParameterRouteSelector(name));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    @KtorDsl
    public static final Route options(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getOptions(), new InterfaceC5074l() { // from class: io.ktor.server.routing.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.options$lambda$12(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t options$lambda$12(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t options$lambda$13(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final Route param(Route route, String name, String value, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new ConstantParameterRouteSelector(name, value));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    @KtorDsl
    public static final Route patch(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getPatch(), new InterfaceC5074l() { // from class: io.ktor.server.routing.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.patch$lambda$8(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t patch$lambda$8(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t patch$lambda$9(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route patchTyped(Route route, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return patch(route, new AnonymousClass3(body, null));
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route patchTypedPath(Route route, String path, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return patch(route, path, new AnonymousClass4(body, null));
    }

    @KtorDsl
    public static final Route post(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getPost(), new InterfaceC5074l() { // from class: io.ktor.server.routing.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.post$lambda$2(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t post$lambda$2(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t post$lambda$3(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route postTyped(Route route, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return post(route, new AnonymousClass2(body, null));
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route postTypedPath(Route route, String path, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return post(route, path, new C43963(body, null));
    }

    @KtorDsl
    public static final Route put(Route route, String path, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        return route(route, path, HttpMethod.INSTANCE.getPut(), new InterfaceC5074l() { // from class: io.ktor.server.routing.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.put$lambda$6(body, (Route) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t put$lambda$6(p9.p pVar, Route route) {
        kotlin.jvm.internal.p.i(route, "$this$route");
        route.handle(pVar);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t put$lambda$7(p9.p pVar, Route method) {
        kotlin.jvm.internal.p.i(method, "$this$method");
        method.handle(pVar);
        return Y8.t.f7040a;
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route putTyped(Route route, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return put(route, new C43973(body, null));
    }

    @KtorDsl
    public static final /* synthetic */ <R> Route putTypedPath(Route route, String path, p9.q<? super RoutingContext, ? super R, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.n();
        return put(route, path, new C43984(body, null));
    }

    @KtorDsl
    public static final Route route(Route route, String path, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateRouteFromPath = createRouteFromPath(route, path);
        build.invoke(routeCreateRouteFromPath);
        return routeCreateRouteFromPath;
    }

    @KtorDsl
    public static final Route delete(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getDelete(), new InterfaceC5074l() { // from class: io.ktor.server.routing.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.delete$lambda$11(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route get(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getGet(), new InterfaceC5074l() { // from class: io.ktor.server.routing.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.get$lambda$1(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route head(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getHead(), new InterfaceC5074l() { // from class: io.ktor.server.routing.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.head$lambda$5(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route options(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getOptions(), new InterfaceC5074l() { // from class: io.ktor.server.routing.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.options$lambda$13(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route patch(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getPatch(), new InterfaceC5074l() { // from class: io.ktor.server.routing.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.patch$lambda$9(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route post(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getPost(), new InterfaceC5074l() { // from class: io.ktor.server.routing.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.post$lambda$3(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route put(Route route, final p9.p<? super RoutingContext, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> body) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(body, "body");
        return method(route, HttpMethod.INSTANCE.getPut(), new InterfaceC5074l() { // from class: io.ktor.server.routing.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingBuilderKt.put$lambda$7(body, (Route) obj);
            }
        });
    }

    @KtorDsl
    public static final Route route(Route route, String path, HttpMethod method, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = createRouteFromPath(route, path).createChild(new HttpMethodRouteSelector(method));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }

    @KtorDsl
    public static final Route param(Route route, String name, InterfaceC5074l<? super Route, Y8.t> build) {
        kotlin.jvm.internal.p.i(route, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(build, "build");
        Route routeCreateChild = route.createChild(new ParameterRouteSelector(name));
        build.invoke(routeCreateChild);
        return routeCreateChild;
    }
}
