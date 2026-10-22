package io.ktor.server.application;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.server.application.debug.DebugPhaseNamesKt;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.random.Random;
import p9.InterfaceC5074l;
import p9.p;
import p9.q;
import p9.r;

@KtorDsl
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J£\u0001\u0010\u001a\u001a\u00020\u0018\"\b\b\u0001\u0010\b*\u00020\u0001\"\u000e\b\u0002\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102$\u0010\u0015\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00028\u00020\u00122.\u0010\u0019\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ£\u0001\u0010\u001c\u001a\u00020\u0018\"\b\b\u0001\u0010\b*\u00020\u0001\"\u000e\b\u0002\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102$\u0010\u0015\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00028\u00020\u00122.\u0010\u0019\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ=\u0010\u001f\u001a\u00020\u00182.\u0010\u0019\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d¢\u0006\u0004\b\u001f\u0010 JC\u0010\"\u001a\u00020\u001824\u0010\u0019\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016¢\u0006\u0004\b\"\u0010#JC\u0010%\u001a\u00020\u001824\u0010\u0019\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016¢\u0006\u0004\b%\u0010#J)\u0010*\u001a\u00020\u0018\"\u0004\b\u0001\u0010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0004\b*\u0010+J=\u0010\"\u001a\u00020\u00182.\u0010\u0019\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d¢\u0006\u0004\b\"\u0010 J=\u0010%\u001a\u00020\u00182.\u0010\u0019\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d¢\u0006\u0004\b%\u0010 J\u000f\u0010.\u001a\u00020\u000eH\u0000¢\u0006\u0004\b,\u0010-R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u00101R*\u00103\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00180\fj\u0002`20\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R*\u00108\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00010\fj\u0002`70\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u00106R*\u0010;\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00010\fj\u0002`:0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u00106R*\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00010\fj\u0002`:0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u00106R$\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u00104\u001a\u0004\bA\u00106R\u0014\u0010E\u001a\u00020B8&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010H\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8 X \u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0011\u0010P\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0011\u0010T\u001a\u00020Q8F¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lio/ktor/server/application/PluginBuilder;", "", "PluginConfig", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/application/PluginInstance;", "key", "<init>", "(Lio/ktor/util/AttributeKey;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/server/application/CallContext;", "ContextT", "", "Lio/ktor/server/application/Interception;", "interceptions", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "", "handlerName", "Lkotlin/Function2;", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "contextInit", "Lkotlin/Function4;", "Le9/c;", "LY8/t;", "block", "onDefaultPhaseWithMessage", "(Ljava/util/List;Lio/ktor/util/pipeline/PipelinePhase;Ljava/lang/String;Lp9/p;Lp9/r;)V", "onDefaultPhase", "Lkotlin/Function3;", "Lio/ktor/server/application/OnCallContext;", DebugPhaseNamesKt.PHASE_ON_CALL, "(Lp9/q;)V", "Lio/ktor/server/application/OnCallReceiveContext;", DebugPhaseNamesKt.PHASE_ON_CALL_RECEIVE, "(Lp9/r;)V", "Lio/ktor/server/application/OnCallRespondContext;", DebugPhaseNamesKt.PHASE_ON_CALL_RESPOND, "HookHandler", "Lio/ktor/server/application/Hook;", "hook", "handler", W4.a.ENABLE_ON, "(Lio/ktor/server/application/Hook;Ljava/lang/Object;)V", "newPhase$ktor_server_core", "()Lio/ktor/util/pipeline/PipelinePhase;", "newPhase", "Lio/ktor/util/AttributeKey;", "getKey$ktor_server_core", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/server/application/CallInterception;", "callInterceptions", "Ljava/util/List;", "getCallInterceptions$ktor_server_core", "()Ljava/util/List;", "Lio/ktor/server/application/ReceiveInterception;", "onReceiveInterceptions", "getOnReceiveInterceptions$ktor_server_core", "Lio/ktor/server/application/ResponseInterception;", "onResponseInterceptions", "getOnResponseInterceptions$ktor_server_core", "afterResponseInterceptions", "getAfterResponseInterceptions$ktor_server_core", "Lio/ktor/server/application/HookHandler;", "hooks", "getHooks$ktor_server_core", "Lio/ktor/server/application/Application;", "getApplication", "()Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "getPluginConfig", "()Ljava/lang/Object;", "pluginConfig", "Lio/ktor/server/application/ApplicationCallPipeline;", "getPipeline$ktor_server_core", "()Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/server/config/ApplicationConfig;", "getApplicationConfig", "()Lio/ktor/server/config/ApplicationConfig;", "applicationConfig", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PluginBuilder<PluginConfig> {
    private final List<Interception<Object>> afterResponseInterceptions;
    private final List<Interception<t>> callInterceptions;
    private final List<HookHandler<?>> hooks;
    private final AttributeKey<PluginInstance> key;
    private final List<Interception<Object>> onReceiveInterceptions;
    private final List<Interception<Object>> onResponseInterceptions;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.PluginBuilder$onCall$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements p<PluginConfig, PipelineContext<t, PipelineCall>, OnCallContext<PluginConfig>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, OnCallContext.class, "<init>", "<init>(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", 0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final OnCallContext<PluginConfig> invoke2(PluginConfig p02, PipelineContext<t, PipelineCall> p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new OnCallContext<>(p02, p12);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, PipelineContext<t, PipelineCall> pipelineContext) {
            return invoke2((AnonymousClass1) obj, pipelineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "PluginConfig", "Lio/ktor/server/application/OnCallContext;", "Lio/ktor/server/application/PipelineCall;", "call", "LY8/t;", "<unused var>", "<anonymous>", "(Lio/ktor/server/application/OnCallContext;Lio/ktor/server/application/PipelineCall;V)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onCall$2", f = "PluginBuilder.kt", l = {103}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.PluginBuilder$onCall$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements r<OnCallContext<PluginConfig>, PipelineCall, t, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<OnCallContext<PluginConfig>, PipelineCall, InterfaceC4014c<? super t>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(q<? super OnCallContext<PluginConfig>, ? super PipelineCall, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(4, interfaceC4014c);
            this.$block = qVar;
        }

        @Override // p9.r
        public final Object invoke(OnCallContext<PluginConfig> onCallContext, PipelineCall pipelineCall, t tVar, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, interfaceC4014c);
            anonymousClass2.L$0 = onCallContext;
            anonymousClass2.L$1 = pipelineCall;
            return anonymousClass2.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                OnCallContext<PluginConfig> onCallContext = (OnCallContext) this.L$0;
                PipelineCall pipelineCall = (PipelineCall) this.L$1;
                q<OnCallContext<PluginConfig>, PipelineCall, InterfaceC4014c<? super t>, Object> qVar = this.$block;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke(onCallContext, pipelineCall, this) == objG) {
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

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.PluginBuilder$onCallReceive$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C43201 extends FunctionReferenceImpl implements p<PluginConfig, PipelineContext<Object, PipelineCall>, OnCallReceiveContext<PluginConfig>> {
        public static final C43201 INSTANCE = new C43201();

        public C43201() {
            super(2, OnCallReceiveContext.class, "<init>", "<init>(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", 0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final OnCallReceiveContext<PluginConfig> invoke2(PluginConfig p02, PipelineContext<Object, PipelineCall> p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new OnCallReceiveContext<>(p02, p12);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, PipelineContext<Object, PipelineCall> pipelineContext) {
            return invoke2((C43201) obj, pipelineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "PluginConfig", "Lio/ktor/server/application/OnCallReceiveContext;", "Lio/ktor/server/application/PipelineCall;", "call", "body", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/OnCallReceiveContext;Lio/ktor/server/application/PipelineCall;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onCallReceive$2", f = "PluginBuilder.kt", l = {125}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.PluginBuilder$onCallReceive$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43212 extends SuspendLambda implements r<OnCallReceiveContext<PluginConfig>, PipelineCall, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ r<OnCallReceiveContext<PluginConfig>, PipelineCall, Object, InterfaceC4014c<? super t>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43212(r<? super OnCallReceiveContext<PluginConfig>, ? super PipelineCall, Object, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, InterfaceC4014c<? super C43212> interfaceC4014c) {
            super(4, interfaceC4014c);
            this.$block = rVar;
        }

        @Override // p9.r
        public final Object invoke(OnCallReceiveContext<PluginConfig> onCallReceiveContext, PipelineCall pipelineCall, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            C43212 c43212 = new C43212(this.$block, interfaceC4014c);
            c43212.L$0 = onCallReceiveContext;
            c43212.L$1 = pipelineCall;
            c43212.L$2 = obj;
            return c43212.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                OnCallReceiveContext<PluginConfig> onCallReceiveContext = (OnCallReceiveContext) this.L$0;
                PipelineCall pipelineCall = (PipelineCall) this.L$1;
                Object obj2 = this.L$2;
                r<OnCallReceiveContext<PluginConfig>, PipelineCall, Object, InterfaceC4014c<? super t>, Object> rVar = this.$block;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (rVar.invoke(onCallReceiveContext, pipelineCall, obj2, this) == objG) {
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "PluginConfig", "Lio/ktor/server/application/OnCallReceiveContext;", "Lio/ktor/server/application/PipelineCall;", "call", "<unused var>", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/OnCallReceiveContext;Lio/ktor/server/application/PipelineCall;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onCallReceive$3", f = "PluginBuilder.kt", l = {F.GESTURE_WIDTH_DP}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.PluginBuilder$onCallReceive$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements r<OnCallReceiveContext<PluginConfig>, PipelineCall, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<OnCallReceiveContext<PluginConfig>, PipelineCall, InterfaceC4014c<? super t>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(q<? super OnCallReceiveContext<PluginConfig>, ? super PipelineCall, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(4, interfaceC4014c);
            this.$block = qVar;
        }

        @Override // p9.r
        public final Object invoke(OnCallReceiveContext<PluginConfig> onCallReceiveContext, PipelineCall pipelineCall, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, interfaceC4014c);
            anonymousClass3.L$0 = onCallReceiveContext;
            anonymousClass3.L$1 = pipelineCall;
            return anonymousClass3.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                OnCallReceiveContext<PluginConfig> onCallReceiveContext = (OnCallReceiveContext) this.L$0;
                PipelineCall pipelineCall = (PipelineCall) this.L$1;
                q<OnCallReceiveContext<PluginConfig>, PipelineCall, InterfaceC4014c<? super t>, Object> qVar = this.$block;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke(onCallReceiveContext, pipelineCall, this) == objG) {
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

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.PluginBuilder$onCallRespond$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C43221 extends FunctionReferenceImpl implements p<PluginConfig, PipelineContext<Object, PipelineCall>, OnCallRespondContext<PluginConfig>> {
        public static final C43221 INSTANCE = new C43221();

        public C43221() {
            super(2, OnCallRespondContext.class, "<init>", "<init>(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", 0);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final OnCallRespondContext<PluginConfig> invoke2(PluginConfig p02, PipelineContext<Object, PipelineCall> p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            return new OnCallRespondContext<>(p02, p12);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, PipelineContext<Object, PipelineCall> pipelineContext) {
            return invoke2((C43221) obj, pipelineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "PluginConfig", "Lio/ktor/server/application/OnCallRespondContext;", "Lio/ktor/server/application/PipelineCall;", "call", "<unused var>", "LY8/t;", "<anonymous>", "(Lio/ktor/server/application/OnCallRespondContext;Lio/ktor/server/application/PipelineCall;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onCallRespond$2", f = "PluginBuilder.kt", l = {206}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.PluginBuilder$onCallRespond$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43232 extends SuspendLambda implements r<OnCallRespondContext<PluginConfig>, PipelineCall, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<OnCallRespondContext<PluginConfig>, PipelineCall, InterfaceC4014c<? super t>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43232(q<? super OnCallRespondContext<PluginConfig>, ? super PipelineCall, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super C43232> interfaceC4014c) {
            super(4, interfaceC4014c);
            this.$block = qVar;
        }

        @Override // p9.r
        public final Object invoke(OnCallRespondContext<PluginConfig> onCallRespondContext, PipelineCall pipelineCall, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            C43232 c43232 = new C43232(this.$block, interfaceC4014c);
            c43232.L$0 = onCallRespondContext;
            c43232.L$1 = pipelineCall;
            return c43232.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                OnCallRespondContext<PluginConfig> onCallRespondContext = (OnCallRespondContext) this.L$0;
                PipelineCall pipelineCall = (PipelineCall) this.L$1;
                q<OnCallRespondContext<PluginConfig>, PipelineCall, InterfaceC4014c<? super t>, Object> qVar = this.$block;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke(onCallRespondContext, pipelineCall, this) == objG) {
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

    /* JADX INFO: Add missing generic type declarations: [T, ContextT] */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\b\u001a\u00020\u0007\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0002*\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0002H\n"}, d2 = {"Lio/ktor/server/application/CallContext;", "ContextT", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/server/application/PipelineCall;", "call", "body", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onDefaultPhase$1", f = "PluginBuilder.kt", l = {245}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.PluginBuilder$onDefaultPhase$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43241<ContextT, T> extends SuspendLambda implements r<ContextT, PipelineCall, T, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ r<ContextT, PipelineCall, T, InterfaceC4014c<? super t>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C43241(r<? super ContextT, ? super PipelineCall, ? super T, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, InterfaceC4014c<? super C43241> interfaceC4014c) {
            super(4, interfaceC4014c);
            this.$block = rVar;
        }

        /* JADX WARN: Incorrect types in method signature: (TContextT;Lio/ktor/server/application/PipelineCall;TT;Le9/c<-LY8/t;>;)Ljava/lang/Object; */
        public final Object invoke(CallContext callContext, PipelineCall pipelineCall, Object obj, InterfaceC4014c interfaceC4014c) {
            C43241 c43241 = new C43241(this.$block, interfaceC4014c);
            c43241.L$0 = callContext;
            c43241.L$1 = pipelineCall;
            c43241.L$2 = obj;
            return c43241.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                CallContext callContext = (CallContext) this.L$0;
                PipelineCall pipelineCall = (PipelineCall) this.L$1;
                Object obj2 = this.L$2;
                r<ContextT, PipelineCall, T, InterfaceC4014c<? super t>, Object> rVar = this.$block;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (rVar.invoke(callContext, pipelineCall, obj2, this) == objG) {
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

        @Override // p9.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, PipelineCall pipelineCall, Object obj2, InterfaceC4014c<? super t> interfaceC4014c) {
            return invoke((CallContext) obj, pipelineCall, obj2, (InterfaceC4014c) interfaceC4014c);
        }
    }

    public PluginBuilder(AttributeKey<PluginInstance> key) {
        kotlin.jvm.internal.p.i(key, "key");
        this.key = key;
        this.callInterceptions = new ArrayList();
        this.onReceiveInterceptions = new ArrayList();
        this.onResponseInterceptions = new ArrayList();
        this.afterResponseInterceptions = new ArrayList();
        this.hooks = new ArrayList();
    }

    private final <T, ContextT extends CallContext<PluginConfig>> void onDefaultPhase(List<Interception<T>> interceptions, Phase phase, String handlerName, p<? super PluginConfig, ? super PipelineContext<T, PipelineCall>, ? extends ContextT> contextInit, r<? super ContextT, ? super PipelineCall, ? super T, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        onDefaultPhaseWithMessage(interceptions, phase, handlerName, contextInit, new C43241(block, null));
    }

    private final <T, ContextT extends CallContext<PluginConfig>> void onDefaultPhaseWithMessage(List<Interception<T>> interceptions, final Phase phase, final String handlerName, final p<? super PluginConfig, ? super PipelineContext<T, PipelineCall>, ? extends ContextT> contextInit, final r<? super ContextT, ? super PipelineCall, ? super T, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        interceptions.add(new Interception<>(phase, new InterfaceC5074l() { // from class: io.ktor.server.application.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PluginBuilder.onDefaultPhaseWithMessage$lambda$0(phase, this, handlerName, block, contextInit, (Pipeline) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t onDefaultPhaseWithMessage$lambda$0(Phase phase, PluginBuilder pluginBuilder, String str, r rVar, p pVar, Pipeline pipeline) {
        kotlin.jvm.internal.p.i(pipeline, "pipeline");
        pipeline.intercept(phase, new PluginBuilder$onDefaultPhaseWithMessage$1$1(pluginBuilder, str, rVar, pVar, null));
        return t.f7040a;
    }

    public final List<Interception<Object>> getAfterResponseInterceptions$ktor_server_core() {
        return this.afterResponseInterceptions;
    }

    public abstract Application getApplication();

    public final ApplicationConfig getApplicationConfig() {
        return getEnvironment().getConfig();
    }

    public final List<Interception<t>> getCallInterceptions$ktor_server_core() {
        return this.callInterceptions;
    }

    public final ApplicationEnvironment getEnvironment() {
        return getPipeline$ktor_server_core().getEnvironment();
    }

    public final List<HookHandler<?>> getHooks$ktor_server_core() {
        return this.hooks;
    }

    public final AttributeKey<PluginInstance> getKey$ktor_server_core() {
        return this.key;
    }

    public final List<Interception<Object>> getOnReceiveInterceptions$ktor_server_core() {
        return this.onReceiveInterceptions;
    }

    public final List<Interception<Object>> getOnResponseInterceptions$ktor_server_core() {
        return this.onResponseInterceptions;
    }

    public abstract ApplicationCallPipeline getPipeline$ktor_server_core();

    public abstract PluginConfig getPluginConfig();

    public final Phase newPhase$ktor_server_core() {
        return new Phase(this.key.getName() + "Phase" + Random.INSTANCE.f());
    }

    public final <HookHandler> void on(Hook<HookHandler> hook, HookHandler handler) {
        kotlin.jvm.internal.p.i(hook, "hook");
        this.hooks.add(new HookHandler<>(hook, handler));
    }

    public final void onCall(q<? super OnCallContext<PluginConfig>, ? super PipelineCall, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        onDefaultPhase(this.callInterceptions, ApplicationCallPipeline.INSTANCE.getPlugins(), DebugPhaseNamesKt.PHASE_ON_CALL, AnonymousClass1.INSTANCE, new AnonymousClass2(block, null));
    }

    public final void onCallReceive(r<? super OnCallReceiveContext<PluginConfig>, ? super PipelineCall, Object, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        onDefaultPhase(this.onReceiveInterceptions, ApplicationReceivePipeline.INSTANCE.getTransform(), DebugPhaseNamesKt.PHASE_ON_CALL_RECEIVE, C43201.INSTANCE, new C43212(block, null));
    }

    public final void onCallRespond(r<? super OnCallRespondContext<PluginConfig>, ? super PipelineCall, Object, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        onDefaultPhase(this.onResponseInterceptions, ApplicationSendPipeline.INSTANCE.getTransform(), DebugPhaseNamesKt.PHASE_ON_CALL_RESPOND, C43221.INSTANCE, block);
    }

    public final void onCallReceive(q<? super OnCallReceiveContext<PluginConfig>, ? super PipelineCall, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        onCallReceive(new AnonymousClass3(block, null));
    }

    public final void onCallRespond(q<? super OnCallRespondContext<PluginConfig>, ? super PipelineCall, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        onCallRespond(new C43232(block, null));
    }
}
