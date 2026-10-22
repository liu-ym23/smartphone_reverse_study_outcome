package com.stepos.backend.llama;

import android.util.Log;
import b7.k;
import com.stepos.backend.llama.ScpRiskJni;
import com.stepos.backend.llama.ScpRiskModel;
import com.stepos.base.model.ModelBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import com.stepos.core.ota.d;
import com.stepos.core.ota.domain.OtaAction;
import e7.f;
import e7.h;
import gc.n;
import gc.q;
import h0.e;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import mb.y;
import org.json.JSONObject;
import rb.c;
import v6.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ScpRiskModel extends ModelBase implements h {
    private static final String BACKEND_COMPAT_KEY = "scp_risk";
    private static final String BUNDLE_CONFIG = "bundle_config.json";
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_THREADS = 4;
    private static final int EXPECTED_CATEGORY_COUNT = 29;
    private final Mutex inferLock;
    private final String modelId;
    private volatile long nativeHandle;
    private final String tag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class BackendCompatRange {
        private final String max;
        private final String min;

        public BackendCompatRange(String str, String str2) {
            this.min = str;
            this.max = str2;
        }

        public static /* synthetic */ BackendCompatRange copy$default(BackendCompatRange backendCompatRange, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = backendCompatRange.min;
            }
            if ((i10 & 2) != 0) {
                str2 = backendCompatRange.max;
            }
            return backendCompatRange.copy(str, str2);
        }

        private final SemanticVersion parseSemanticVersion(String str) {
            Integer numC0;
            List listE0 = q.E0(q.J0(q.J0(str, '-'), '+'), new char[]{'.'});
            if (listE0.size() != 3 || (numC0 = n.c0((String) listE0.get(0))) == null) {
                return null;
            }
            int iIntValue = numC0.intValue();
            Integer numC02 = n.c0((String) listE0.get(1));
            if (numC02 == null) {
                return null;
            }
            int iIntValue2 = numC02.intValue();
            Integer numC03 = n.c0((String) listE0.get(2));
            if (numC03 != null) {
                return new SemanticVersion(iIntValue, iIntValue2, numC03.intValue());
            }
            return null;
        }

        public final String component1() {
            return this.min;
        }

        public final String component2() {
            return this.max;
        }

        public final boolean contains(String actual) {
            SemanticVersion semanticVersion;
            SemanticVersion semanticVersion2;
            g.f(actual, "actual");
            SemanticVersion semanticVersion3 = parseSemanticVersion(actual);
            if (semanticVersion3 == null) {
                return false;
            }
            String str = this.min;
            SemanticVersion semanticVersion4 = null;
            if (str == null || (semanticVersion = parseSemanticVersion(str)) == null) {
                if (this.min != null) {
                    return false;
                }
                semanticVersion = null;
            }
            String str2 = this.max;
            if (str2 != null && (semanticVersion2 = parseSemanticVersion(str2)) != null) {
                semanticVersion4 = semanticVersion2;
            } else if (this.max != null) {
                return false;
            }
            return (semanticVersion == null || semanticVersion3.compareTo(semanticVersion) >= 0) && (semanticVersion4 == null || semanticVersion3.compareTo(semanticVersion4) <= 0);
        }

        public final BackendCompatRange copy(String str, String str2) {
            return new BackendCompatRange(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BackendCompatRange)) {
                return false;
            }
            BackendCompatRange backendCompatRange = (BackendCompatRange) obj;
            return g.b(this.min, backendCompatRange.min) && g.b(this.max, backendCompatRange.max);
        }

        public final String getDisplayValue() {
            String str = this.min;
            String str2 = OtaAction.GLOBAL;
            if (str == null) {
                str = OtaAction.GLOBAL;
            }
            String str3 = this.max;
            if (str3 != null) {
                str2 = str3;
            }
            return d.i(str, "~", str2);
        }

        public final String getMax() {
            return this.max;
        }

        public final String getMin() {
            return this.min;
        }

        public int hashCode() {
            String str = this.min;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.max;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return e.c("BackendCompatRange(min=", this.min, ", max=", this.max, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BackendCompatRange parseBackendCompat(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("min", "");
            if (q.t0(strOptString)) {
                strOptString = null;
            }
            String strOptString2 = jSONObject.optString("max", "");
            return new BackendCompatRange(strOptString, q.t0(strOptString2) ? null : strOptString2);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SemanticVersion implements Comparable<SemanticVersion> {
        private final int major;
        private final int minor;
        private final int patch;

        public SemanticVersion(int i10, int i11, int i12) {
            this.major = i10;
            this.minor = i11;
            this.patch = i12;
        }

        public static /* synthetic */ SemanticVersion copy$default(SemanticVersion semanticVersion, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = semanticVersion.major;
            }
            if ((i13 & 2) != 0) {
                i11 = semanticVersion.minor;
            }
            if ((i13 & 4) != 0) {
                i12 = semanticVersion.patch;
            }
            return semanticVersion.copy(i10, i11, i12);
        }

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.patch;
        }

        public final SemanticVersion copy(int i10, int i11, int i12) {
            return new SemanticVersion(i10, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SemanticVersion)) {
                return false;
            }
            SemanticVersion semanticVersion = (SemanticVersion) obj;
            return this.major == semanticVersion.major && this.minor == semanticVersion.minor && this.patch == semanticVersion.patch;
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getPatch() {
            return this.patch;
        }

        public int hashCode() {
            return Integer.hashCode(this.patch) + ai.onnxruntime.a.d(this.minor, Integer.hashCode(this.major) * 31, 31);
        }

        public String toString() {
            return ai.onnxruntime.a.j(")", this.patch, e.d(this.major, "SemanticVersion(major=", this.minor, ", minor=", ", patch="));
        }

        @Override // java.lang.Comparable
        public int compareTo(SemanticVersion other) {
            g.f(other, "other");
            l[] lVarArr = {new PropertyReference1Impl() { // from class: com.stepos.backend.llama.ScpRiskModel$SemanticVersion$compareTo$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((ScpRiskModel.SemanticVersion) obj).getMajor());
                }
            }, new PropertyReference1Impl() { // from class: com.stepos.backend.llama.ScpRiskModel$SemanticVersion$compareTo$2
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((ScpRiskModel.SemanticVersion) obj).getMinor());
                }
            }, new PropertyReference1Impl() { // from class: com.stepos.backend.llama.ScpRiskModel$SemanticVersion$compareTo$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, ec.h
                public Object get(Object obj) {
                    return Integer.valueOf(((ScpRiskModel.SemanticVersion) obj).getPatch());
                }
            }};
            for (int i10 = 0; i10 < 3; i10++) {
                l lVar = lVarArr[i10];
                int iA = ob.b.a((Comparable) lVar.invoke(this), (Comparable) lVar.invoke(other));
                if (iA != 0) {
                    return iA;
                }
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.ScpRiskModel", f = "ScpRiskModel.kt", l = {298, 161, 172}, m = "classifyOnce")
    /* renamed from: com.stepos.backend.llama.ScpRiskModel$classifyOnce$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScpRiskModel.this.classifyOnce(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.ScpRiskModel", f = "ScpRiskModel.kt", l = {297, 233}, m = "doClose")
    /* renamed from: com.stepos.backend.llama.ScpRiskModel$doClose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02031(qb.b<? super C02031> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScpRiskModel.this.doClose(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.ScpRiskModel$doFlowInfer$2", f = "ScpRiskModel.kt", l = {137, 139, 140}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.ScpRiskModel$doFlowInfer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
            this.$input = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass2 anonymousClass2 = ScpRiskModel.this.new AnonymousClass2(this.$input, bVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        
            if (r7 == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        
            if (r1.emit(r2, r6) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
        
            if (r1.emit(r3, r6) == r0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        
            return r0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L26
                if (r1 == r4) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                goto L18
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L18:
                kotlin.c.b(r7)
                goto L6c
            L1c:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r7)     // Catch: java.lang.Throwable -> L24
                goto L41
            L24:
                r7 = move-exception
                goto L3d
            L26:
                kotlin.c.b(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.backend.llama.ScpRiskModel r7 = com.stepos.backend.llama.ScpRiskModel.this
                java.lang.Object r5 = r6.$input
                r6.L$0 = r1     // Catch: java.lang.Throwable -> L24
                r6.label = r4     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = r7.doInfer(r5, r6)     // Catch: java.lang.Throwable -> L24
                if (r7 != r0) goto L41
                goto L6b
            L3d:
                kotlin.Result$Failure r7 = kotlin.c.a(r7)
            L41:
                java.lang.Throwable r4 = kotlin.Result.b(r7)
                r5 = 0
                if (r4 != 0) goto L58
                kotlin.Result r2 = new kotlin.Result
                r2.<init>(r7)
                r6.L$0 = r5
                r6.label = r3
                java.lang.Object r6 = r1.emit(r2, r6)
                if (r6 != r0) goto L6c
                goto L6b
            L58:
                kotlin.Result$Failure r7 = kotlin.c.a(r4)
                kotlin.Result r3 = new kotlin.Result
                r3.<init>(r7)
                r6.L$0 = r5
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r6)
                if (r6 != r0) goto L6c
            L6b:
                return r0
            L6c:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.ScpRiskModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass2) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.ScpRiskModel", f = "ScpRiskModel.kt", l = {98}, m = "doInitialize")
    /* renamed from: com.stepos.backend.llama.ScpRiskModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02041(qb.b<? super C02041> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScpRiskModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.llama.ScpRiskModel$processText$2", f = "ScpRiskModel.kt", l = {146, 146, 149}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.llama.ScpRiskModel$processText$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02052 extends SuspendLambda implements p<FlowCollector<? super v6.d>, qb.b<? super lb.n>, Object> {
        final /* synthetic */ c.g $input;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02052(c.g gVar, qb.b<? super C02052> bVar) {
            super(2, bVar);
            this.$input = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            C02052 c02052 = ScpRiskModel.this.new C02052(this.$input, bVar);
            c02052.L$0 = obj;
            return c02052;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        
            if (r1.emit(r10, r9) == r0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        
            if (r1.emit(r4, r9) != r0) goto L31;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r1v4 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L37
                if (r1 == r4) goto L28
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.c.b(r10)
                goto L9e
            L15:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1d:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r10)     // Catch: java.lang.Exception -> L26
                goto L9e
            L26:
                r10 = move-exception
                goto L62
            L28:
                java.lang.Object r1 = r9.L$1
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r4 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.c.b(r10)     // Catch: java.lang.Exception -> L34
                goto L55
            L34:
                r10 = move-exception
                r1 = r4
                goto L62
            L37:
                kotlin.c.b(r10)
                java.lang.Object r10 = r9.L$0
                r1 = r10
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                com.stepos.backend.llama.ScpRiskModel r10 = com.stepos.backend.llama.ScpRiskModel.this     // Catch: java.lang.Exception -> L26
                v6.c$g r6 = r9.$input     // Catch: java.lang.Exception -> L26
                java.lang.String r7 = r6.f13416b     // Catch: java.lang.Exception -> L26
                java.lang.String r6 = r6.f13417c     // Catch: java.lang.Exception -> L26
                r9.L$0 = r1     // Catch: java.lang.Exception -> L26
                r9.L$1 = r1     // Catch: java.lang.Exception -> L26
                r9.label = r4     // Catch: java.lang.Exception -> L26
                java.lang.Object r10 = com.stepos.backend.llama.ScpRiskModel.access$classifyOnce(r10, r7, r6, r9)     // Catch: java.lang.Exception -> L26
                if (r10 != r0) goto L54
                goto L9d
            L54:
                r4 = r1
            L55:
                r9.L$0 = r4     // Catch: java.lang.Exception -> L34
                r9.L$1 = r5     // Catch: java.lang.Exception -> L34
                r9.label = r3     // Catch: java.lang.Exception -> L34
                java.lang.Object r9 = r1.emit(r10, r9)     // Catch: java.lang.Exception -> L34
                if (r9 != r0) goto L9e
                goto L9d
            L62:
                com.stepos.backend.llama.ScpRiskModel r4 = com.stepos.backend.llama.ScpRiskModel.this
                java.lang.String r4 = com.stepos.backend.llama.ScpRiskModel.access$getTag$p(r4)
                java.lang.String r6 = r10.getMessage()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "processText failed: "
                r7.<init>(r8)
                r7.append(r6)
                java.lang.String r6 = r7.toString()
                android.util.Log.e(r4, r6, r10)
                v6.d$f r4 = new v6.d$f
                java.lang.String r10 = r10.getMessage()
                java.lang.String r6 = "SCP risk classify failed: "
                java.lang.String r10 = ai.onnxruntime.a.k(r6, r10)
                v6.c$g r6 = r9.$input
                java.lang.String r6 = r6.f13417c
                r7 = 0
                r4.<init>(r10, r7, r3, r6)
                r9.L$0 = r5
                r9.L$1 = r5
                r9.label = r2
                java.lang.Object r9 = r1.emit(r4, r9)
                if (r9 != r0) goto L9e
            L9d:
                return r0
            L9e:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.ScpRiskModel.C02052.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super v6.d> flowCollector, qb.b<? super lb.n> bVar) {
            return ((C02052) create(flowCollector, bVar)).invokeSuspend(lb.n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.backend.llama.ScpRiskModel", f = "ScpRiskModel.kt", l = {212}, m = "reportInferencePhase")
    /* renamed from: com.stepos.backend.llama.ScpRiskModel$reportInferencePhase$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02061 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02061(qb.b<? super C02061> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScpRiskModel.this.reportInferencePhase(0L, this);
        }
    }

    static {
        Object obj = f.f8615a;
        f.b(i.a(ScpRiskModel.class), y.M(ProtocolType.f6378a));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScpRiskModel(k config) {
        super(config);
        g.f(config, "config");
        this.tag = "ScpRiskModel";
        this.modelId = config.f3090a;
        this.inferLock = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object classifyOnce(java.lang.String r17, java.lang.String r18, qb.b<? super v6.d> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.ScpRiskModel.classifyOnce(java.lang.String, java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScpRiskJni.Result classifyOnce$lambda$9$lambda$8(long j10, String str) {
        return (ScpRiskJni.Result) AiEngineAtrace.section("llama/call", "scp_risk_classify", new a(j10, str, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScpRiskJni.Result classifyOnce$lambda$9$lambda$8$lambda$7(long j10, String str) {
        ScpRiskJni.Result resultNativeClassify = ScpRiskJni.nativeClassify(j10, str);
        if (resultNativeClassify != null) {
            return resultNativeClassify;
        }
        throw new IllegalStateException("SCP risk nativeClassify returned null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reportInferencePhase(long r7, qb.b<? super lb.n> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.backend.llama.ScpRiskModel.C02061
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.backend.llama.ScpRiskModel$reportInferencePhase$1 r0 = (com.stepos.backend.llama.ScpRiskModel.C02061) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.llama.ScpRiskModel$reportInferencePhase$1 r0 = new com.stepos.backend.llama.ScpRiskModel$reportInferencePhase$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            long r7 = r0.J$0
            java.lang.Object r6 = r0.L$0
            com.stepos.backend.llama.ScpRiskModel r6 = (com.stepos.backend.llama.ScpRiskModel) r6
            kotlin.c.b(r9)
        L2c:
            r4 = r7
            goto L48
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.c.b(r9)
            com.stepos.core.common.telemetry.TrackerContext$Key r9 = com.stepos.core.common.telemetry.TrackerContext.Key
            r0.L$0 = r6
            r0.J$0 = r7
            r0.label = r3
            java.lang.Object r9 = r9.currentTracker(r0)
            if (r9 != r1) goto L2c
            return r1
        L48:
            boolean r7 = r9 instanceof com.stepos.core.common.telemetry.PowerPerfTracker
            if (r7 == 0) goto L4f
            com.stepos.core.common.telemetry.PowerPerfTracker r9 = (com.stepos.core.common.telemetry.PowerPerfTracker) r9
            goto L50
        L4f:
            r9 = 0
        L50:
            if (r9 != 0) goto L55
            lb.n r6 = lb.n.f10413a
            return r6
        L55:
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r7 = r7 - r4
            int r3 = (int) r7
            com.stepos.core.common.telemetry.PhaseRecord r0 = new com.stepos.core.common.telemetry.PhaseRecord     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = "INFERENCE"
            com.stepos.core.common.telemetry.Hardware r2 = com.stepos.core.common.telemetry.Hardware.CPU     // Catch: java.lang.Throwable -> L6e
            r0.<init>(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L6e
            java.util.List r7 = androidx.datastore.preferences.protobuf.b1.P(r0)     // Catch: java.lang.Throwable -> L6e
            r9.addPhasesFromNative(r7)     // Catch: java.lang.Throwable -> L6e
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L6e
            goto L74
        L6e:
            r0 = move-exception
            r7 = r0
            kotlin.Result$Failure r7 = kotlin.c.a(r7)
        L74:
            java.lang.Throwable r7 = kotlin.Result.b(r7)
            if (r7 == 0) goto L85
            java.lang.String r6 = r6.tag
            java.lang.String r7 = r7.getMessage()
            java.lang.String r8 = "report INFERENCE phase failed: "
            a0.a.A(r8, r7, r6)
        L85:
            lb.n r6 = lb.n.f10413a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.ScpRiskModel.reportInferencePhase(long, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super lb.n> bVar) {
        return lb.n.f10413a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r2, r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doClose(qb.b<? super lb.n> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.stepos.backend.llama.ScpRiskModel.C02031
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.backend.llama.ScpRiskModel$doClose$1 r0 = (com.stepos.backend.llama.ScpRiskModel.C02031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.llama.ScpRiskModel$doClose$1 r0 = new com.stepos.backend.llama.ScpRiskModel$doClose$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            kotlin.c.b(r12)     // Catch: java.lang.Throwable -> L2f
            goto L7f
        L2f:
            r12 = move-exception
            goto L87
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r2 = r0.L$0
            com.stepos.backend.llama.ScpRiskModel r2 = (com.stepos.backend.llama.ScpRiskModel) r2
            kotlin.c.b(r12)
            r12 = r11
            r11 = r2
            goto L59
        L47:
            kotlin.c.b(r12)
            kotlinx.coroutines.sync.Mutex r12 = r11.inferLock
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r4
            java.lang.Object r2 = r12.lock(r5, r0)
            if (r2 != r1) goto L59
            goto L78
        L59:
            long r6 = r11.nativeHandle     // Catch: java.lang.Throwable -> L79
            r8 = 0
            r11.nativeHandle = r8     // Catch: java.lang.Throwable -> L79
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 == 0) goto L7e
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L79
            com.stepos.backend.llama.ScpRiskModel$doClose$2$1 r2 = new com.stepos.backend.llama.ScpRiskModel$doClose$2$1     // Catch: java.lang.Throwable -> L79
            r2.<init>(r6, r5)     // Catch: java.lang.Throwable -> L79
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L79
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L79
            r0.label = r3     // Catch: java.lang.Throwable -> L79
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r2, r0)     // Catch: java.lang.Throwable -> L79
            if (r11 != r1) goto L7e
        L78:
            return r1
        L79:
            r11 = move-exception
            r10 = r12
            r12 = r11
            r11 = r10
            goto L87
        L7e:
            r11 = r12
        L7f:
            lb.n r12 = lb.n.f10413a     // Catch: java.lang.Throwable -> L2f
            r11.unlock(r5)
            lb.n r11 = lb.n.f10413a
            return r11
        L87:
            r11.unlock(r5)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.ScpRiskModel.doClose(qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flow(new AnonymousClass2(obj, null));
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doInfer(Object obj, qb.b<Object> bVar) {
        String str;
        boolean z = obj instanceof c.g;
        if (z) {
            str = ((c.g) obj).f13416b;
        } else {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(ai.onnxruntime.a.k("ScpRiskModel expects Input.Text or String, got ", i.a(obj.getClass()).c()));
            }
            str = (String) obj;
        }
        c.g gVar = z ? (c.g) obj : null;
        String str2 = gVar != null ? gVar.f13417c : null;
        if (str2 == null) {
            str2 = "";
        }
        return classifyOnce(str, str2, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r10, b7.k r11, qb.b<? super lb.n> r12) throws com.stepos.base.model.ModelLoadException {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.llama.ScpRiskModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super lb.n> bVar) {
        Log.d(this.tag, "doWarmup: skip (small classifier)");
        return lb.n.f10413a;
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6378a;
    }

    @Override // e7.h
    public Object processText(c.g gVar, Object obj, qb.b<? super Flow<? extends v6.d>> bVar) {
        return FlowKt.flow(new C02052(gVar, null));
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }
}
