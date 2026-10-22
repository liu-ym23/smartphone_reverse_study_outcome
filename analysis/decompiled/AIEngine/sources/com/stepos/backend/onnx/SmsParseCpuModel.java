package com.stepos.backend.onnx;

import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtSession;
import android.util.Log;
import b7.k;
import b7.m;
import com.stepos.base.model.ModelBase;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.common.log.AiEngineAtrace;
import e7.h;
import gc.o;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.l;
import mb.v;
import org.json.JSONException;
import org.json.JSONObject;
import rb.c;
import wb.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SmsParseCpuModel extends ModelBase implements h {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAX_SEQ_LEN = 150;
    private Map<Integer, String> classifierDict;
    private File modelDir;
    private OrtEnvironment ortEnv;
    private OrtSession ortSession;
    private Map<Integer, String> slotDict;
    private final String tag;
    private Map<String, Integer> vocab;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.onnx.SmsParseCpuModel", f = "SmsParseCpuModel.kt", l = {102, 102}, m = "doInfer")
    /* renamed from: com.stepos.backend.onnx.SmsParseCpuModel$doInfer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SmsParseCpuModel.this.doInfer(null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.onnx.SmsParseCpuModel", f = "SmsParseCpuModel.kt", l = {83}, m = "doInitialize")
    /* renamed from: com.stepos.backend.onnx.SmsParseCpuModel$doInitialize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02251(qb.b<? super C02251> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SmsParseCpuModel.this.doInitialize(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.onnx.SmsParseCpuModel", f = "SmsParseCpuModel.kt", l = {419}, m = "processText")
    /* renamed from: com.stepos.backend.onnx.SmsParseCpuModel$processText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02261 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02261(qb.b<? super C02261> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SmsParseCpuModel.this.processText(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.backend.onnx.SmsParseCpuModel$streamCpuInference$1", f = "SmsParseCpuModel.kt", l = {126, 134}, m = "invokeSuspend")
    /* renamed from: com.stepos.backend.onnx.SmsParseCpuModel$streamCpuInference$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02271 extends SuspendLambda implements p<FlowCollector<? super Result<? extends Object>>, qb.b<? super n>, Object> {
        final /* synthetic */ Object $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SmsParseCpuModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02271(Object obj, SmsParseCpuModel smsParseCpuModel, qb.b<? super C02271> bVar) {
            super(2, bVar);
            this.$input = obj;
            this.this$0 = smsParseCpuModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final JSONObject invokeSuspend$lambda$1(final SmsParseCpuModel smsParseCpuModel, final String str) {
            return (JSONObject) AiEngineAtrace.section("onnx/call", "sms_parse", new zb.a() { // from class: com.stepos.backend.onnx.a
                @Override // zb.a
                public final Object invoke() {
                    return SmsParseCpuModel.access$runInference(smsParseCpuModel, str);
                }
            });
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            C02271 c02271 = new C02271(this.$input, this.this$0, bVar);
            c02271.L$0 = obj;
            return c02271;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        
            if (r1.emit(r8, r7) == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.c.b(r8)
                goto L6f
            L10:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L18:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.c.b(r8)
                goto L4d
            L20:
                kotlin.c.b(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r8 = r7.$input
                boolean r4 = r8 instanceof v6.c.g
                if (r4 == 0) goto L33
                v6.c$g r8 = (v6.c.g) r8
                java.lang.String r8 = r8.f13416b
                goto L39
            L33:
                boolean r4 = r8 instanceof java.lang.String
                if (r4 == 0) goto L72
                java.lang.String r8 = (java.lang.String) r8
            L39:
                com.stepos.base.concurrency.cpuset.AiTier r4 = com.stepos.base.concurrency.cpuset.AiTier.f6204a
                com.stepos.backend.onnx.SmsParseCpuModel r5 = r7.this$0
                com.stepos.backend.onnx.b r6 = new com.stepos.backend.onnx.b
                r6.<init>()
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = r4.b(r6, r7)
                if (r8 != r0) goto L4d
                goto L6e
            L4d:
                org.json.JSONObject r8 = (org.json.JSONObject) r8
                java.lang.String r8 = r8.toString()
                java.lang.String r3 = "toString(...)"
                kotlin.jvm.internal.g.e(r8, r3)
                v6.d$q r3 = new v6.d$q
                r4 = 6
                r5 = 0
                r3.<init>(r8, r5, r5, r4)
                kotlin.Result r8 = new kotlin.Result
                r8.<init>(r3)
                r7.L$0 = r5
                r7.label = r2
                java.lang.Object r7 = r1.emit(r8, r7)
                if (r7 != r0) goto L6f
            L6e:
                return r0
            L6f:
                lb.n r7 = lb.n.f10413a
                return r7
            L72:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.Object r7 = r7.$input
                java.lang.Class r7 = r7.getClass()
                kotlin.jvm.internal.c r7 = kotlin.jvm.internal.i.a(r7)
                java.lang.String r7 = r7.c()
                java.lang.String r0 = "SmsParseCpuModel expects Input.Text or String, got "
                java.lang.String r7 = ai.onnxruntime.a.k(r0, r7)
                r8.<init>(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.onnx.SmsParseCpuModel.C02271.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(FlowCollector<? super Result<? extends Object>> flowCollector, qb.b<? super n> bVar) {
            return ((C02271) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsParseCpuModel(k config) {
        super(config);
        g.f(config, "config");
        this.tag = "SmsParseCpuModel";
    }

    public static final /* synthetic */ JSONObject access$runInference(SmsParseCpuModel smsParseCpuModel, String str) {
        return smsParseCpuModel.runInference(str);
    }

    private final String decodeClassification(Object obj) {
        float[] fArrExtractFloatArray = extractFloatArray(obj);
        if (fArrExtractFloatArray.length == 0) {
            return "other";
        }
        int i10 = 0;
        float f8 = fArrExtractFloatArray[0];
        int length = fArrExtractFloatArray.length;
        for (int i11 = 1; i11 < length; i11++) {
            float f9 = fArrExtractFloatArray[i11];
            if (f9 > f8) {
                i10 = i11;
                f8 = f9;
            }
        }
        Map<Integer, String> map = this.classifierDict;
        if (map != null) {
            String str = map.get(Integer.valueOf(i10));
            return str == null ? "other" : str;
        }
        g.l("classifierDict");
        throw null;
    }

    private final Map<String, String> decodeSlotsFromIndices(Object obj, String str) {
        int[] iArrExtractIntArray = extractIntArray(obj);
        ArrayList arrayList = new ArrayList(iArrExtractIntArray.length);
        for (int i10 : iArrExtractIntArray) {
            Map<Integer, String> map = this.slotDict;
            if (map == null) {
                g.l("slotDict");
                throw null;
            }
            String str2 = map.get(Integer.valueOf(i10));
            if (str2 == null) {
                str2 = "O";
            }
            arrayList.add(str2);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        String strSubstring = null;
        for (int i11 = 0; i11 < size && i11 < str.length(); i11++) {
            String str3 = (String) arrayList.get(i11);
            char cCharAt = str.charAt(i11);
            if (o.k0(str3, "B-", false) || o.k0(str3, "U-", false)) {
                if (strSubstring != null && sb2.length() > 0) {
                    String str4 = (String) linkedHashMap.get(strSubstring);
                    String string = sb2.toString();
                    g.e(string, "toString(...)");
                    linkedHashMap.put(strSubstring, mergeSlotValue(str4, string));
                }
                strSubstring = str3.substring(2);
                g.e(strSubstring, "substring(...)");
                sb2.setLength(0);
                sb2.append(cCharAt);
                if (o.k0(str3, "U-", false)) {
                    String str5 = (String) linkedHashMap.get(strSubstring);
                    String string2 = sb2.toString();
                    g.e(string2, "toString(...)");
                    linkedHashMap.put(strSubstring, mergeSlotValue(str5, string2));
                    sb2.setLength(0);
                    strSubstring = null;
                }
            } else {
                if ((o.k0(str3, "I-", false) || o.k0(str3, "L-", false)) && strSubstring != null) {
                    sb2.append(cCharAt);
                    if (o.k0(str3, "L-", false)) {
                        String str6 = (String) linkedHashMap.get(strSubstring);
                        String string3 = sb2.toString();
                        g.e(string3, "toString(...)");
                        linkedHashMap.put(strSubstring, mergeSlotValue(str6, string3));
                        sb2.setLength(0);
                    }
                } else {
                    if (strSubstring != null && sb2.length() > 0) {
                        String str7 = (String) linkedHashMap.get(strSubstring);
                        String string4 = sb2.toString();
                        g.e(string4, "toString(...)");
                        linkedHashMap.put(strSubstring, mergeSlotValue(str7, string4));
                    }
                    sb2.setLength(0);
                }
                strSubstring = null;
            }
        }
        if (strSubstring != null && sb2.length() > 0) {
            String str8 = (String) linkedHashMap.get(strSubstring);
            String string5 = sb2.toString();
            g.e(string5, "toString(...)");
            linkedHashMap.put(strSubstring, mergeSlotValue(str8, string5));
        }
        return linkedHashMap;
    }

    private final float[] extractFloatArray(Object obj) {
        if (!(obj instanceof Object[])) {
            return obj instanceof float[] ? (float[]) obj : new float[0];
        }
        Object objE0 = l.e0((Object[]) obj);
        if (objE0 instanceof float[]) {
            return (float[]) objE0;
        }
        if (!(objE0 instanceof Object[])) {
            return new float[0];
        }
        float[][] fArr = (float[][]) objE0;
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int length2 = 0;
        for (float[] fArr4 : fArr) {
            int i10 = (12 & 2) != 0 ? 0 : length2;
            int length3 = (12 & 8) != 0 ? fArr4.length : 6;
            g.f(fArr4, "<this>");
            System.arraycopy(fArr4, 0, fArr3, i10, length3);
            length2 += fArr4.length;
        }
        return fArr3;
    }

    private final int[] extractIntArray(Object obj) {
        if (obj instanceof int[]) {
            return (int[]) obj;
        }
        int i10 = 0;
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length = jArr.length;
            int[] iArr = new int[length];
            while (i10 < length) {
                iArr[i10] = (int) jArr[i10];
                i10++;
            }
            return iArr;
        }
        if (!(obj instanceof Object[])) {
            return new int[0];
        }
        Object objE0 = l.e0((Object[]) obj);
        if (objE0 instanceof int[]) {
            return (int[]) objE0;
        }
        if (!(objE0 instanceof long[])) {
            return new int[0];
        }
        long[] jArr2 = (long[]) objE0;
        int length2 = jArr2.length;
        int[] iArr2 = new int[length2];
        while (i10 < length2) {
            iArr2[i10] = (int) jArr2[i10];
            i10++;
        }
        return iArr2;
    }

    private final int getPadId() {
        Map<String, Integer> map = this.vocab;
        if (map == null) {
            g.l("vocab");
            throw null;
        }
        Integer num = map.get("<pad>");
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final int getUnkId() {
        Map<String, Integer> map = this.vocab;
        if (map == null) {
            g.l("vocab");
            throw null;
        }
        Integer num = map.get("<UNK>");
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final Map<Integer, String> loadClassifierDict(File file) {
        JSONObject jSONObject = new JSONObject(d.Z(file, gc.a.f9106b));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        g.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(Integer.valueOf(jSONObject.getInt(next)), next);
        }
        return linkedHashMap;
    }

    private final Map<Integer, String> loadSlotDict(File file) {
        JSONObject jSONObject = new JSONObject(d.Z(file, gc.a.f9106b));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        g.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            g.c(next);
            linkedHashMap.put(Integer.valueOf(Integer.parseInt(next)), jSONObject.getString(next));
        }
        return linkedHashMap;
    }

    private final Map<String, Integer> loadVocab(File file) {
        JSONObject jSONObject = new JSONObject(d.Z(file, gc.a.f9106b));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        g.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, Integer.valueOf(jSONObject.getInt(next)));
        }
        return linkedHashMap;
    }

    private final String mergeSlotValue(String str, String str2) {
        return (str == null || str.length() == 0) ? str2 : com.stepos.core.ota.d.i(str, ",", str2);
    }

    private final File requireConfigFile(k kVar, String str) {
        File fileA = m.a(kVar, str);
        if (fileA != null) {
            return fileA;
        }
        String absolutePath = m.f(kVar, m.b(kVar), "config", "configs").getAbsolutePath();
        throw new IllegalStateException(ai.onnxruntime.a.o(ai.onnxruntime.a.s("SMS-parse 缺少必需配置 ", str, "（查找目录 ", absolutePath, "，modelId="), kVar.f3090a, "）"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject runInference(String str) throws JSONException {
        Collection collectionD0;
        OrtSession ortSession = this.ortSession;
        if (ortSession == null) {
            throw new IllegalStateException("ONNX session not initialized");
        }
        OrtEnvironment ortEnvironment = this.ortEnv;
        if (ortEnvironment == null) {
            throw new IllegalStateException("OrtEnvironment not initialized");
        }
        List<Integer> list = tokenize(str);
        if (list.size() >= 150) {
            collectionD0 = kotlin.collections.a.J0(MAX_SEQ_LEN, list);
        } else {
            int size = MAX_SEQ_LEN - list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(Integer.valueOf(getPadId()));
            }
            collectionD0 = kotlin.collections.a.D0(list, arrayList);
        }
        OnnxTensor onnxTensorCreateTensor = OnnxTensor.createTensor(ortEnvironment, IntBuffer.wrap(kotlin.collections.a.N0(collectionD0)), new long[]{1, 150});
        Set<String> inputNames = ortSession.getInputNames();
        g.e(inputNames, "getInputNames(...)");
        OrtSession.Result resultRun = ortSession.run(v.b0(new Pair((String) kotlin.collections.a.s0(inputNames), onnxTensorCreateTensor)));
        Set<String> outputNames = ortSession.getOutputNames();
        g.e(outputNames, "getOutputNames(...)");
        List listO0 = kotlin.collections.a.O0(outputNames);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("backend", "smsparse_cpu");
        try {
            if (listO0.size() > 1) {
                Object value = resultRun.get(1).getValue();
                g.c(value);
                jSONObject.put("domain", decodeClassification(value));
                Object value2 = resultRun.get(0).getValue();
                g.c(value2);
                Map<String, String> mapDecodeSlotsFromIndices = decodeSlotsFromIndices(value2, str);
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : mapDecodeSlotsFromIndices.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("slots", jSONObject2);
            } else if (!listO0.isEmpty()) {
                Object value3 = resultRun.get(0).getValue();
                g.c(value3);
                jSONObject.put("domain", decodeClassification(value3));
            }
            resultRun.close();
            onnxTensorCreateTensor.close();
            return jSONObject;
        } catch (Throwable th) {
            resultRun.close();
            onnxTensorCreateTensor.close();
            throw th;
        }
    }

    private final Flow<Result<Object>> streamCpuInference(Object obj) {
        return FlowKt.flow(new C02271(obj, this, null));
    }

    private final List<Integer> tokenize(String str) {
        ArrayList arrayList = new ArrayList(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            Map<String, Integer> map = this.vocab;
            if (map == null) {
                g.l("vocab");
                throw null;
            }
            Integer num = map.get(String.valueOf(cCharAt));
            arrayList.add(Integer.valueOf(num != null ? num.intValue() : getUnkId()));
        }
        return arrayList;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doCleanup(qb.b<? super n> bVar) {
        Log.d(this.tag, "doCleanup");
        return n.f10413a;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doClose(qb.b<? super n> bVar) {
        Log.d(this.tag, "doClose");
        OrtSession ortSession = this.ortSession;
        if (ortSession != null) {
            ortSession.close();
        }
        this.ortSession = null;
        OrtEnvironment ortEnvironment = this.ortEnv;
        if (ortEnvironment != null) {
            ortEnvironment.close();
        }
        this.ortEnv = null;
        return n.f10413a;
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doFlowInfer(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar) {
        return FlowKt.flowOn(streamCpuInference(obj), Dispatchers.getIO());
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r8).collect(r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInfer(java.lang.Object r7, qb.b<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.backend.onnx.SmsParseCpuModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.backend.onnx.SmsParseCpuModel$doInfer$1 r0 = (com.stepos.backend.onnx.SmsParseCpuModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.backend.onnx.SmsParseCpuModel$doInfer$1 r0 = new com.stepos.backend.onnx.SmsParseCpuModel$doInfer$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            kotlin.c.b(r8)
            goto L66
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.L$0
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            kotlin.c.b(r8)
            goto L54
        L3e:
            kotlin.c.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r6 = r6.doFlowInfer(r7, r0)
            if (r6 != r1) goto L51
            goto L65
        L51:
            r5 = r8
            r8 = r6
            r6 = r5
        L54:
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
            com.stepos.backend.onnx.SmsParseCpuModel$doInfer$2 r7 = new com.stepos.backend.onnx.SmsParseCpuModel$doInfer$2
            r7.<init>()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r8.collect(r7, r0)
            if (r7 != r1) goto L66
        L65:
            return r1
        L66:
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.g.e(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.onnx.SmsParseCpuModel.doInfer(java.lang.Object, qb.b):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.base.model.ModelBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doInitialize(android.content.Context r11, b7.k r12, qb.b<? super lb.n> r13) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.onnx.SmsParseCpuModel.doInitialize(android.content.Context, b7.k, qb.b):java.lang.Object");
    }

    @Override // com.stepos.base.model.ModelBase
    public Object doWarmup(qb.b<? super n> bVar) {
        Log.d(this.tag, "warmup: run a dummy inference");
        try {
            runInference("测试");
        } catch (Exception e10) {
            a0.a.A("warmup failed (non-fatal): ", e10.getMessage(), this.tag);
        }
        return n.f10413a;
    }

    @Override // e7.b
    public ProtocolType getType() {
        return ProtocolType.f6378a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // e7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object processText(v6.c.g r23, java.lang.Object r24, qb.b<? super kotlinx.coroutines.flow.Flow<? extends v6.d>> r25) {
        /*
            r22 = this;
            r0 = r24
            r1 = r25
            boolean r2 = r1 instanceof com.stepos.backend.onnx.SmsParseCpuModel.C02261
            if (r2 == 0) goto L19
            r2 = r1
            com.stepos.backend.onnx.SmsParseCpuModel$processText$1 r2 = (com.stepos.backend.onnx.SmsParseCpuModel.C02261) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r22
            goto L20
        L19:
            com.stepos.backend.onnx.SmsParseCpuModel$processText$1 r2 = new com.stepos.backend.onnx.SmsParseCpuModel$processText$1
            r3 = r22
            r2.<init>(r1)
        L20:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r5 = r2.label
            r6 = 1
            if (r5 == 0) goto L38
            if (r5 != r6) goto L30
            kotlin.c.b(r1)
            goto La0
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.c.b(r1)
            boolean r1 = r0 instanceof com.stepos.core.model.task.AITaskRecord
            r5 = 0
            if (r1 == 0) goto L43
            com.stepos.core.model.task.AITaskRecord r0 = (com.stepos.core.model.task.AITaskRecord) r0
            goto L44
        L43:
            r0 = r5
        L44:
            j7.e r7 = new j7.e
            b7.k r1 = r3.getConfig()
            java.lang.String r10 = r1.f3090a
            r1 = 0
            if (r0 == 0) goto L55
            int r3 = r0.getCallerUid()
            r12 = r3
            goto L56
        L55:
            r12 = r1
        L56:
            if (r0 == 0) goto L5c
            int r1 = r0.getCallerPid()
        L5c:
            r13 = r1
            if (r0 == 0) goto L68
            java.lang.String r1 = r0.getCallerPackage()
            if (r1 != 0) goto L66
            goto L68
        L66:
            r14 = r1
            goto L6b
        L68:
            java.lang.String r1 = ""
            goto L66
        L6b:
            if (r0 == 0) goto L74
            boolean r1 = r0.isForeground()
            r16 = r1
            goto L76
        L74:
            r16 = r6
        L76:
            if (r0 == 0) goto L7c
            java.lang.Object r5 = r0.getPowerTracker()
        L7c:
            r17 = r5
            r20 = 0
            r21 = 6529(0x1981, float:9.149E-42)
            r8 = 0
            java.lang.String r9 = "chat-smsparse"
            r15 = 0
            r18 = 0
            r11 = r23
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21)
            com.stepos.core.model.task.AITaskSupervisor$Companion r0 = com.stepos.core.model.task.AITaskSupervisor.Companion
            android.content.Context r1 = l7.a.f10344a
            if (r1 == 0) goto La8
            com.stepos.core.model.task.AITaskSupervisor r0 = r0.getInstance(r1)
            r2.label = r6
            java.lang.Object r1 = r0.submitTask(r7, r2)
            if (r1 != r4) goto La0
            return r4
        La0:
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            com.stepos.backend.onnx.SmsParseCpuModel$processText$$inlined$map$1 r0 = new com.stepos.backend.onnx.SmsParseCpuModel$processText$$inlined$map$1
            r0.<init>()
            return r0
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContextHolder must be initialized before use!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.backend.onnx.SmsParseCpuModel.processText(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    @Override // e7.h
    public boolean resetContext() {
        return false;
    }
}
