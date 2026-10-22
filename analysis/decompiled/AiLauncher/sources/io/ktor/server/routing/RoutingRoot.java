package io.ktor.server.routing;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.events.EventDefinition;
import io.ktor.http.ContentType;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.BaseApplicationPlugin;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@KtorDsl
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ4\u0010\u0010\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\u001b\u001a\u00028\u0002\"\b\b\u0000\u0010\u0013*\u00020\u0012\"\b\b\u0001\u0010\u0014*\u00020\u0012\"\u0014\b\u0002\u0010\u0016*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\u0017\u001a\u00028\u00022\u0006\u0010\u0018\u001a\u00028\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00020\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u001dH\u0016¢\u0006\u0004\b \u0010!J$\u0010\"\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R&\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u001d0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lio/ktor/server/routing/RoutingRoot;", "Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/server/routing/Routing;", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "<init>", "(Lio/ktor/server/application/Application;)V", "LY8/t;", "addDefaultTracing", "()V", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "context", M5.a.CARD_TYPE_ROUTE, "Lio/ktor/http/Parameters;", "parameters", "executeResult", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/server/routing/RoutingNode;Lio/ktor/http/Parameters;Le9/c;)Ljava/lang/Object;", "", "Subject", "Context", "Lio/ktor/util/pipeline/Pipeline;", "P", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "Lkotlin/Function0;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "merge", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/Pipeline;Lp9/a;)Lio/ktor/util/pipeline/Pipeline;", "Lkotlin/Function1;", "Lio/ktor/server/routing/RoutingResolveTrace;", "block", "trace", "(Lp9/l;)V", "interceptor", "(Lio/ktor/util/pipeline/PipelineContext;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/Application;", "getApplication", "()Lio/ktor/server/application/Application;", "", "tracers", "Ljava/util/List;", "Plugin", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingRoot extends RoutingNode implements Routing {
    private static final AttributeKey<RoutingRoot> key;
    private final Application application;
    private final List<InterfaceC5074l<RoutingResolveTrace, Y8.t>> tracers;

    /* renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final EventDefinition<RoutingCall> RoutingCallStarted = new EventDefinition<>();
    private static final EventDefinition<RoutingCall> RoutingCallFinished = new EventDefinition<>();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/server/routing/RoutingRoot$Plugin;", "Lio/ktor/server/application/BaseApplicationPlugin;", "Lio/ktor/server/application/Application;", "Lio/ktor/server/routing/Routing;", "Lio/ktor/server/routing/RoutingRoot;", "<init>", "()V", "pipeline", "Lkotlin/Function1;", "LY8/t;", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/server/application/Application;Lp9/l;)Lio/ktor/server/routing/RoutingRoot;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/server/routing/RoutingCall;", "RoutingCallStarted", "Lio/ktor/events/EventDefinition;", "getRoutingCallStarted", "()Lio/ktor/events/EventDefinition;", "RoutingCallFinished", "getRoutingCallFinished", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.routing.RoutingRoot$Plugin, reason: from kotlin metadata */
    public static final class Companion implements BaseApplicationPlugin<Application, Routing, RoutingRoot> {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        @Override // io.ktor.server.application.Plugin
        public AttributeKey<RoutingRoot> getKey() {
            return RoutingRoot.key;
        }

        public final EventDefinition<RoutingCall> getRoutingCallFinished() {
            return RoutingRoot.RoutingCallFinished;
        }

        public final EventDefinition<RoutingCall> getRoutingCallStarted() {
            return RoutingRoot.RoutingCallStarted;
        }

        @Override // io.ktor.server.application.Plugin
        public /* bridge */ /* synthetic */ Object install(Pipeline pipeline, InterfaceC5074l interfaceC5074l) {
            return install((Application) pipeline, (InterfaceC5074l<? super Routing, Y8.t>) interfaceC5074l);
        }

        private Companion() {
        }

        public RoutingRoot install(Application pipeline, InterfaceC5074l<? super Routing, Y8.t> configure) {
            kotlin.jvm.internal.p.i(pipeline, "pipeline");
            kotlin.jvm.internal.p.i(configure, "configure");
            RoutingRoot routingRoot = new RoutingRoot(pipeline);
            configure.invoke(routingRoot);
            pipeline.intercept(ApplicationCallPipeline.INSTANCE.getCall(), new RoutingRoot$Plugin$install$1(routingRoot, null));
            return routingRoot;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingRoot", f = "RoutingRoot.kt", l = {211}, m = "executeResult")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.routing.RoutingRoot$executeResult$1, reason: invalid class name */
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
            return RoutingRoot.this.executeResult(null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingRoot", f = "RoutingRoot.kt", l = {69, 71}, m = "interceptor")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.routing.RoutingRoot$interceptor$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C44001(InterfaceC4014c<? super C44001> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoutingRoot.this.interceptor(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        InterfaceC5755n interfaceC5755nM = null;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(RoutingRoot.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(RoutingRoot.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("Routing", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoutingRoot(Application application) {
        super(null, new RootRouteSelector(application.getRootPath()), application.getDevelopmentMode(), application.getEnvironment());
        kotlin.jvm.internal.p.i(application, "application");
        this.application = application;
        this.tracers = new ArrayList();
        addDefaultTracing();
    }

    private final void addDefaultTracing() {
        this.tracers.add(new InterfaceC5074l() { // from class: io.ktor.server.routing.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingRoot.addDefaultTracing$lambda$0((RoutingResolveTrace) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t addDefaultTracing$lambda$0(RoutingResolveTrace it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (RoutingRootKt.getLOGGER().isTraceEnabled()) {
            RoutingRootKt.getLOGGER().trace(it.buildText());
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeResult(io.ktor.util.pipeline.PipelineContext<Y8.t, io.ktor.server.application.PipelineCall> r17, io.ktor.server.routing.RoutingNode r18, io.ktor.http.Parameters r19, e9.InterfaceC4014c<? super Y8.t> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingRoot.executeResult(io.ktor.util.pipeline.PipelineContext, io.ktor.server.routing.RoutingNode, io.ktor.http.Parameters, e9.c):java.lang.Object");
    }

    private final <Subject, Context, P extends Pipeline<Subject, Context>> P merge(P first, P second, InterfaceC5063a<? extends P> build) {
        if (first.isEmpty()) {
            return second;
        }
        if (second.isEmpty()) {
            return first;
        }
        P pInvoke = build.invoke();
        pInvoke.merge(first);
        pInvoke.merge(second);
        return pInvoke;
    }

    public final Application getApplication() {
        return this.application;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (executeResult(r7, r2, r8, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object interceptor(io.ktor.util.pipeline.PipelineContext<Y8.t, io.ktor.server.application.PipelineCall> r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.server.routing.RoutingRoot.C44001
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.routing.RoutingRoot$interceptor$1 r0 = (io.ktor.server.routing.RoutingRoot.C44001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.routing.RoutingRoot$interceptor$1 r0 = new io.ktor.server.routing.RoutingRoot$interceptor$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r8)
            goto L73
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r7 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r7 = (io.ktor.util.pipeline.PipelineContext) r7
            kotlin.C4849c.b(r8)
            goto L57
        L3c:
            kotlin.C4849c.b(r8)
            io.ktor.server.routing.RoutingResolveContext r8 = new io.ktor.server.routing.RoutingResolveContext
            java.lang.Object r2 = r7.getContext()
            io.ktor.server.application.PipelineCall r2 = (io.ktor.server.application.PipelineCall) r2
            java.util.List<p9.l<io.ktor.server.routing.RoutingResolveTrace, Y8.t>> r5 = r6.tracers
            r8.<init>(r6, r2, r5)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.resolve(r0)
            if (r8 != r1) goto L57
            goto L72
        L57:
            io.ktor.server.routing.RoutingResolveResult r8 = (io.ktor.server.routing.RoutingResolveResult) r8
            boolean r2 = r8 instanceof io.ktor.server.routing.RoutingResolveResult.Success
            if (r2 == 0) goto L76
            io.ktor.server.routing.RoutingNode r2 = r8.getRoute()
            io.ktor.server.routing.RoutingResolveResult$Success r8 = (io.ktor.server.routing.RoutingResolveResult.Success) r8
            io.ktor.http.Parameters r8 = r8.getParameters()
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.executeResult(r7, r2, r8, r0)
            if (r6 != r1) goto L73
        L72:
            return r1
        L73:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L76:
            boolean r6 = r8 instanceof io.ktor.server.routing.RoutingResolveResult.Failure
            if (r6 == 0) goto L94
            java.lang.Object r6 = r7.getContext()
            io.ktor.server.application.PipelineCall r6 = (io.ktor.server.application.PipelineCall) r6
            io.ktor.util.Attributes r6 = r6.getAttributes()
            io.ktor.util.AttributeKey r7 = io.ktor.server.routing.RoutingRootKt.getRoutingFailureStatusCode()
            io.ktor.server.routing.RoutingResolveResult$Failure r8 = (io.ktor.server.routing.RoutingResolveResult.Failure) r8
            io.ktor.http.HttpStatusCode r8 = r8.getErrorStatusCode()
            r6.put(r7, r8)
            Y8.t r6 = Y8.t.f7040a
            return r6
        L94:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingRoot.interceptor(io.ktor.util.pipeline.PipelineContext, e9.c):java.lang.Object");
    }

    @Override // io.ktor.server.routing.Routing
    public void trace(InterfaceC5074l<? super RoutingResolveTrace, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.tracers.add(block);
    }
}
