package io.ktor.server.application;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.AttributeKey;
import io.ktor.util.debug.ContextUtilsKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import p9.q;
import p9.r;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "it", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onDefaultPhaseWithMessage$1$1", f = "PluginBuilder.kt", l = {224}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class PluginBuilder$onDefaultPhaseWithMessage$1$1<T> extends SuspendLambda implements q<PipelineContext<T, PipelineCall>, T, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ r<ContextT, PipelineCall, T, InterfaceC4014c<? super t>, Object> $block;
    final /* synthetic */ p<PluginConfig, PipelineContext<T, PipelineCall>, ContextT> $contextInit;
    final /* synthetic */ String $handlerName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PluginBuilder<PluginConfig> this$0;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.PluginBuilder$onDefaultPhaseWithMessage$1$1$1", f = "PluginBuilder.kt", l = {225, 228, 230}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.PluginBuilder$onDefaultPhaseWithMessage$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ PipelineContext<T, PipelineCall> $$this$intercept;
        final /* synthetic */ r<ContextT, PipelineCall, T, InterfaceC4014c<? super t>, Object> $block;
        final /* synthetic */ p<PluginConfig, PipelineContext<T, PipelineCall>, ContextT> $contextInit;
        final /* synthetic */ String $handlerName;
        final /* synthetic */ AttributeKey<PluginInstance> $key;
        final /* synthetic */ PluginConfig $pluginConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(AttributeKey<PluginInstance> attributeKey, String str, r<? super ContextT, ? super PipelineCall, ? super T, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, p<? super PluginConfig, ? super PipelineContext<T, PipelineCall>, ? extends ContextT> pVar, PluginConfig pluginconfig, PipelineContext<T, PipelineCall> pipelineContext, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.$key = attributeKey;
            this.$handlerName = str;
            this.$block = rVar;
            this.$contextInit = pVar;
            this.$pluginConfig = pluginconfig;
            this.$$this$intercept = pipelineContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$key, this.$handlerName, this.$block, this.$contextInit, this.$pluginConfig, this.$$this$intercept, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
        
            if (io.ktor.server.application.debug.UtilsKt.ijDebugReportHandlerFinished(r7, r1, r6) != r0) goto L21;
         */
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.C4849c.b(r7)
                goto L6d
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1d:
                kotlin.C4849c.b(r7)
                goto L5c
            L21:
                kotlin.C4849c.b(r7)
                goto L39
            L25:
                kotlin.C4849c.b(r7)
                io.ktor.util.AttributeKey<io.ktor.server.application.PluginInstance> r7 = r6.$key
                java.lang.String r7 = r7.getName()
                java.lang.String r1 = r6.$handlerName
                r6.label = r4
                java.lang.Object r7 = io.ktor.server.application.debug.UtilsKt.ijDebugReportHandlerStarted(r7, r1, r6)
                if (r7 != r0) goto L39
                goto L6c
            L39:
                p9.r<ContextT, io.ktor.server.application.PipelineCall, T, e9.c<? super Y8.t>, java.lang.Object> r7 = r6.$block
                p9.p<PluginConfig, io.ktor.util.pipeline.PipelineContext<T, io.ktor.server.application.PipelineCall>, ContextT> r1 = r6.$contextInit
                PluginConfig r4 = r6.$pluginConfig
                io.ktor.util.pipeline.PipelineContext<T, io.ktor.server.application.PipelineCall> r5 = r6.$$this$intercept
                java.lang.Object r1 = r1.invoke(r4, r5)
                io.ktor.util.pipeline.PipelineContext<T, io.ktor.server.application.PipelineCall> r4 = r6.$$this$intercept
                java.lang.Object r4 = r4.getContext()
                io.ktor.server.application.PipelineCall r4 = (io.ktor.server.application.PipelineCall) r4
                io.ktor.util.pipeline.PipelineContext<T, io.ktor.server.application.PipelineCall> r5 = r6.$$this$intercept
                java.lang.Object r5 = r5.getSubject()
                r6.label = r3
                java.lang.Object r7 = r7.invoke(r1, r4, r5, r6)
                if (r7 != r0) goto L5c
                goto L6c
            L5c:
                io.ktor.util.AttributeKey<io.ktor.server.application.PluginInstance> r7 = r6.$key
                java.lang.String r7 = r7.getName()
                java.lang.String r1 = r6.$handlerName
                r6.label = r2
                java.lang.Object r6 = io.ktor.server.application.debug.UtilsKt.ijDebugReportHandlerFinished(r7, r1, r6)
                if (r6 != r0) goto L6d
            L6c:
                return r0
            L6d:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.PluginBuilder$onDefaultPhaseWithMessage$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PluginBuilder$onDefaultPhaseWithMessage$1$1(PluginBuilder<PluginConfig> pluginBuilder, String str, r<? super ContextT, ? super PipelineCall, ? super T, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, p<? super PluginConfig, ? super PipelineContext<T, PipelineCall>, ? extends ContextT> pVar, InterfaceC4014c<? super PluginBuilder$onDefaultPhaseWithMessage$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.this$0 = pluginBuilder;
        this.$handlerName = str;
        this.$block = rVar;
        this.$contextInit = pVar;
    }

    public final Object invoke(PipelineContext<T, PipelineCall> pipelineContext, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        PluginBuilder$onDefaultPhaseWithMessage$1$1 pluginBuilder$onDefaultPhaseWithMessage$1$1 = new PluginBuilder$onDefaultPhaseWithMessage$1$1(this.this$0, this.$handlerName, this.$block, this.$contextInit, interfaceC4014c);
        pluginBuilder$onDefaultPhaseWithMessage$1$1.L$0 = pipelineContext;
        return pluginBuilder$onDefaultPhaseWithMessage$1$1.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            AttributeKey<PluginInstance> key$ktor_server_core = this.this$0.getKey$ktor_server_core();
            Object pluginConfig = this.this$0.getPluginConfig();
            String name = key$ktor_server_core.getName();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(key$ktor_server_core, this.$handlerName, this.$block, this.$contextInit, pluginConfig, pipelineContext, null);
            this.label = 1;
            if (ContextUtilsKt.addToContextInDebugMode(name, anonymousClass1, this) == objG) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke((PipelineContext<PipelineContext<T, PipelineCall>, PipelineCall>) obj, (PipelineContext<T, PipelineCall>) obj2, interfaceC4014c);
    }
}
