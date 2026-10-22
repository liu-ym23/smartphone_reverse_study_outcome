package com.stepos.core.ability.pipeline;

import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Pipeline {
    private final String TAG;
    private final List<PipelineStage> stages;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ability.pipeline.Pipeline$execute$1", f = "Pipeline.kt", l = {37, 37, 61, 66, 75, 79}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.pipeline.Pipeline$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<FlowCollector<? super PipelineOutput>, b<? super n>, Object> {
        final /* synthetic */ v6.c $input;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ Pipeline this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(v6.c cVar, Pipeline pipeline, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$input = cVar;
            this.this$0 = pipeline;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.this$0, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x013c, code lost:
        
            if (((kotlinx.coroutines.flow.Flow) r0).collect(r15, r17) != r2) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x01cd, code lost:
        
            if (r14.emit(r0, r17) == r2) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01fd, code lost:
        
            if (r14.emit(r0, r17) == r2) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0261, code lost:
        
            if (r14.emit(r3, r17) != r2) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0280, code lost:
        
            if (r14.emit(r4, r17) == r2) goto L86;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0299  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x029f  */
        /* JADX WARN: Type inference failed for: r4v2, types: [T, com.stepos.core.ability.pipeline.PipelineOutput$Error] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0232 -> B:22:0x00a5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0280 -> B:7:0x0029). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 692
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.pipeline.Pipeline.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super PipelineOutput> flowCollector, b<? super n> bVar) {
            return ((AnonymousClass1) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public Pipeline(List<PipelineStage> stages) {
        g.f(stages, "stages");
        this.stages = stages;
        this.TAG = "Pipeline";
    }

    public final Flow<PipelineOutput> execute(v6.c input) {
        g.f(input, "input");
        return FlowKt.flow(new AnonymousClass1(input, this, null));
    }

    public final List<PipelineStage> getStages$ability_release() {
        return this.stages;
    }
}
