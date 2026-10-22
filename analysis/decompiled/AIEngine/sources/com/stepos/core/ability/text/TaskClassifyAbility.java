package com.stepos.core.ability.text;

import com.stepos.base.ability.AbilityBase;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import gc.i;
import gc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.l;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskClassifyAbility extends AbilityBase<v6.c, d.q> {
    private static final Regex THINK_REGEX;
    private static final Regex TIER_JSON_PATTERN;
    private static final Regex TIER_VALUE_PATTERN;
    private final String TAG;
    public static final Companion Companion = new Companion(null);
    private static final Regex CHAT_TEMPLATE_REGEX = new Regex("<\\|[^|]+\\|>");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String parseTier(String str) {
            i iVarB = TaskClassifyAbility.TIER_VALUE_PATTERN.b(str, 0);
            if (iVarB == null) {
                return null;
            }
            String upperCase = ((String) ((i.a) iVarB.a()).get(1)).toUpperCase(Locale.ROOT);
            g.e(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String stripThink(String str) {
            return q.L0(TaskClassifyAbility.THINK_REGEX.d(str, "")).toString();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.text.TaskClassifyAbility$doFlowInfer$2", f = "TaskClassifyAbility.kt", l = {ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR, 69, 81, 96, 96, 116, 130, 135}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.text.TaskClassifyAbility$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.q>>, qb.b<? super n>, Object> {
        final /* synthetic */ v6.c $input;
        final /* synthetic */ Object $record;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(v6.c cVar, Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = cVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = TaskClassifyAbility.this.new AnonymousClass2(this.$input, this.$record, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, qb.b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00bd, code lost:
        
            if (r11.emit(r3, r17) == r2) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x016a, code lost:
        
            if (r11.emit(r3, r17) != r2) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x01c4, code lost:
        
            if (r11.emit(r3, r17) == r2) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0288, code lost:
        
            if (r11.emit(r3, r17) == r2) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x02cd, code lost:
        
            if (r11.emit(r3, r17) == r2) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0307, code lost:
        
            if (r11.emit(r3, r17) != r2) goto L92;
         */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x0303: INVOKE (r0 I:java.lang.Object) = (r11 I:kotlinx.coroutines.flow.FlowCollector), (r3 I:java.lang.Object), (r1 I:qb.b) INTERFACE call: kotlinx.coroutines.flow.FlowCollector.emit(java.lang.Object, qb.b):java.lang.Object A[MD:(T, qb.b<? super lb.n>):java.lang.Object (m)] (LINE:772), block:B:89:0x02d3 */
        /* JADX WARN: Removed duplicated region for block: B:76:0x020f A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #2 {Exception -> 0x0036, blocks: (B:9:0x0031, B:14:0x0047, B:74:0x020b, B:76:0x020f, B:70:0x01f1), top: B:97:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0245  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x028c  */
        /* JADX WARN: Type inference failed for: r11v0, types: [kotlinx.coroutines.flow.FlowCollector] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 804
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.TaskClassifyAbility.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    static {
        Set options = l.s0(new RegexOption[]{RegexOption.f10096c, RegexOption.f10095b});
        g.f(options, "options");
        Iterator it = options.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= ((gc.c) it.next()).getValue();
        }
        if ((value & 2) != 0) {
            value |= 64;
        }
        Pattern patternCompile = Pattern.compile("<think>.*?</think>|<think>", value);
        g.e(patternCompile, "compile(...)");
        THINK_REGEX = new Regex(patternCompile);
        RegexOption regexOption = RegexOption.f10095b;
        TIER_JSON_PATTERN = new Regex("\\{\\s*\"tier\"\\s*:\\s*\"(SIMPLE|MEDIUM|COMPLEX|RESEARCH|REASONING)\"\\s*\\}", 0);
        TIER_VALUE_PATTERN = new Regex("\"tier\"\\s*:\\s*\"(SIMPLE|MEDIUM|COMPLEX|RESEARCH|REASONING)\"", 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskClassifyAbility(p6.a config) {
        super(config.f11416a, config);
        g.f(config, "config");
        this.TAG = "TaskClassifyAbility";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractText(v6.c cVar) {
        String string;
        if (cVar instanceof c.g) {
            string = ((c.g) cVar).f13416b;
        } else if (cVar instanceof c.e) {
            List<v6.c> list = ((c.e) cVar).f13409b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof c.g) {
                    arrayList.add(obj);
                }
            }
            string = kotlin.collections.a.z0(arrayList, "\n", null, null, new a(1), 30);
        } else {
            string = cVar.toString();
        }
        return q.L0(CHAT_TEMPLATE_REGEX.d(string, "")).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence extractText$lambda$0(c.g it) {
        g.f(it, "it");
        return it.f13416b;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public Object doFlowInfer(v6.c cVar, Object obj, qb.b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(cVar, obj, null));
    }

    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    public Object mo19doInfergIAlus(v6.c cVar, qb.b<? super Result<d.q>> bVar) {
        return new d.q("{\"tier\":\"SIMPLE\"}", null, null, 6);
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("{\"tier\":\"SIMPLE\"}", null, null, 6);
    }
}
