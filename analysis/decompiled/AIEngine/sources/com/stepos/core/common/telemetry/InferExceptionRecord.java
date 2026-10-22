package com.stepos.core.common.telemetry;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import com.tonyodev.fetch2core.server.FileResponse;
import fc.p;
import fc.q;
import gc.r;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.text.Regex;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InferExceptionRecord {
    public static final Companion Companion = new Companion(null);
    private static final SimpleDateFormat occurredAtFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    private final String abilityId;
    private final String backend;
    private final String callerPkg;
    private final int callerUid;
    private final long e2eMs;
    private final long endMonoNs;
    private final String engineVersion;
    private final int errorCode;
    private final String exceptionMsg;
    private final String executionLocation;
    private final String expLogId;
    private final String failClass;
    private final String failStack;
    private final String failStage;
    private final String hardware;
    private final boolean isForeground;
    private final String modelId;
    private final String modelVersion;
    private final String phases;
    private final String priority;
    private final int queueWaitMs;
    private final long retryAfterMs;
    private final String stackDigest;
    private final long startMonoNs;
    private final long startWallMs;
    private final String status;
    private final String taskId;
    private final String traceId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final String flattenPhases(List<PhaseRecord> list) {
            if (list.isEmpty()) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder(64);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                String phase = ((PhaseRecord) obj).getPhase();
                Object arrayList = linkedHashMap.get(phase);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(phase, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list2 = (List) entry.getValue();
                Iterator it = list2.iterator();
                int durationMs = 0;
                while (it.hasNext()) {
                    durationMs += ((PhaseRecord) it.next()).getDurationMs();
                }
                Long l10 = (Long) p.z(new fc.f(new q(kotlin.collections.a.l0(list2), new b(2)), new com.stepos.core.common.cloud.d(7)));
                long jLongValue = l10 != null ? l10.longValue() : -1L;
                sb2.append('{');
                sb2.append(str);
                sb2.append('|');
                sb2.append(jLongValue);
                sb2.append('|');
                sb2.append(durationMs);
                sb2.append('}');
            }
            String string = sb2.toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long flattenPhases$lambda$7$lambda$5(PhaseRecord it) {
            kotlin.jvm.internal.g.f(it, "it");
            return it.getBeginMs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean flattenPhases$lambda$7$lambda$6(long j10) {
            return j10 >= 0;
        }

        public static /* synthetic */ boolean shouldEmitSnapshot$default(Companion companion, int i10, String str, String str2, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = "";
            }
            if ((i11 & 4) != 0) {
                str2 = "";
            }
            return companion.shouldEmitSnapshot(i10, str, str2);
        }

        public final String formatOccurredAt(long j10) {
            String str;
            if (j10 <= 0) {
                return null;
            }
            synchronized (InferExceptionRecord.occurredAtFormat) {
                str = InferExceptionRecord.occurredAtFormat.format(new Date(j10));
            }
            return str;
        }

        public final InferExceptionRecord from(AiPowerPerfRecord r) {
            kotlin.jvm.internal.g.f(r, "r");
            if (r.getExpLogId().length() == 0 || !shouldEmitSnapshot(r.getErrorCode(), r.getFailStage(), r.getExceptionMsg())) {
                return null;
            }
            String expLogId = r.getExpLogId();
            String traceId = r.getTraceId();
            String taskId = r.getTaskId();
            int callerUid = r.getCallerUid();
            String callerPkg = r.getCallerPkg();
            String abilityId = r.getAbilityId();
            String modelId = r.getModelId();
            String modelVersion = r.getModelVersion();
            String backend = r.getBackend();
            String hardware = r.getHardware();
            String engineVersion = r.getEngineVersion();
            String executionLocation = r.getExecutionLocation();
            boolean zIsForeground = r.isForeground();
            String priority = r.getPriority();
            long startWallMs = r.getStartWallMs();
            long startMonoNs = r.getStartMonoNs();
            long endMonoNs = r.getEndMonoNs();
            long e2eMs = r.getE2eMs();
            List<PhaseRecord> phases = r.getPhases();
            ArrayList arrayList = new ArrayList();
            Iterator it = phases.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Iterator it2 = it;
                if (kotlin.jvm.internal.g.b(((PhaseRecord) next).getPhase(), FailStage.QUEUE_WAIT)) {
                    arrayList.add(next);
                }
                it = it2;
            }
            int size = arrayList.size();
            int i10 = 0;
            int durationMs = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                durationMs = ((PhaseRecord) obj).getDurationMs() + durationMs;
            }
            return new InferExceptionRecord(expLogId, traceId, taskId, callerUid, callerPkg, abilityId, modelId, modelVersion, backend, hardware, engineVersion, executionLocation, zIsForeground, priority, startWallMs, startMonoNs, endMonoNs, e2eMs, durationMs, r.getStatus(), r.getErrorCode(), r.getFailStage(), r.getFailClass(), r.getExceptionMsg(), r.getStackDigest(), r.getFailStack(), r.getRetryAfterMs(), flattenPhases(r.getPhases()));
        }

        public final boolean shouldEmitSnapshot(int i10, String failStage, String exceptionMsg) {
            kotlin.jvm.internal.g.f(failStage, "failStage");
            kotlin.jvm.internal.g.f(exceptionMsg, "exceptionMsg");
            return (i10 == 110001 || i10 == 210009 || failStage.equals(FailStage.MODEL_LOAD_BACKOFF) || gc.q.l0(exceptionMsg, "load-failure backoff", false)) ? false : true;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class JsonBool extends JsonValue {

        /* renamed from: v, reason: collision with root package name */
        private final boolean f7382v;

        public JsonBool(boolean z) {
            super(null);
            this.f7382v = z;
        }

        public final boolean getV() {
            return this.f7382v;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class JsonNum extends JsonValue {

        /* renamed from: v, reason: collision with root package name */
        private final long f7383v;

        public JsonNum(long j10) {
            super(null);
            this.f7383v = j10;
        }

        public final long getV() {
            return this.f7383v;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class JsonStr extends JsonValue {

        /* renamed from: v, reason: collision with root package name */
        private final String f7384v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JsonStr(String v3) {
            super(null);
            kotlin.jvm.internal.g.f(v3, "v");
            this.f7384v = v3;
        }

        public final String getV() {
            return this.f7384v;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class JsonStrArray extends JsonValue {

        /* renamed from: v, reason: collision with root package name */
        private final List<String> f7385v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JsonStrArray(List<String> v3) {
            super(null);
            kotlin.jvm.internal.g.f(v3, "v");
            this.f7385v = v3;
        }

        public final List<String> getV() {
            return this.f7385v;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class JsonValue {
        public /* synthetic */ JsonValue(kotlin.jvm.internal.e eVar) {
            this();
        }

        private JsonValue() {
        }
    }

    public InferExceptionRecord(String expLogId, String traceId, String taskId, int i10, String callerPkg, String abilityId, String modelId, String modelVersion, String backend, String hardware, String engineVersion, String executionLocation, boolean z, String priority, long j10, long j11, long j12, long j13, int i11, String status, int i12, String failStage, String failClass, String exceptionMsg, String stackDigest, String failStack, long j14, String phases) {
        kotlin.jvm.internal.g.f(expLogId, "expLogId");
        kotlin.jvm.internal.g.f(traceId, "traceId");
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(modelVersion, "modelVersion");
        kotlin.jvm.internal.g.f(backend, "backend");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        kotlin.jvm.internal.g.f(engineVersion, "engineVersion");
        kotlin.jvm.internal.g.f(executionLocation, "executionLocation");
        kotlin.jvm.internal.g.f(priority, "priority");
        kotlin.jvm.internal.g.f(status, "status");
        kotlin.jvm.internal.g.f(failStage, "failStage");
        kotlin.jvm.internal.g.f(failClass, "failClass");
        kotlin.jvm.internal.g.f(exceptionMsg, "exceptionMsg");
        kotlin.jvm.internal.g.f(stackDigest, "stackDigest");
        kotlin.jvm.internal.g.f(failStack, "failStack");
        kotlin.jvm.internal.g.f(phases, "phases");
        this.expLogId = expLogId;
        this.traceId = traceId;
        this.taskId = taskId;
        this.callerUid = i10;
        this.callerPkg = callerPkg;
        this.abilityId = abilityId;
        this.modelId = modelId;
        this.modelVersion = modelVersion;
        this.backend = backend;
        this.hardware = hardware;
        this.engineVersion = engineVersion;
        this.executionLocation = executionLocation;
        this.isForeground = z;
        this.priority = priority;
        this.startWallMs = j10;
        this.startMonoNs = j11;
        this.endMonoNs = j12;
        this.e2eMs = j13;
        this.queueWaitMs = i11;
        this.status = status;
        this.errorCode = i12;
        this.failStage = failStage;
        this.failClass = failClass;
        this.exceptionMsg = exceptionMsg;
        this.stackDigest = stackDigest;
        this.failStack = failStack;
        this.retryAfterMs = j14;
        this.phases = phases;
    }

    public static /* synthetic */ InferExceptionRecord copy$default(InferExceptionRecord inferExceptionRecord, String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, String str12, long j10, long j11, long j12, long j13, int i11, String str13, int i12, String str14, String str15, String str16, String str17, String str18, long j14, String str19, int i13, Object obj) {
        String str20;
        long j15;
        long j16;
        long j17;
        long j18;
        int i14;
        int i15;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        int i16;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        boolean z3;
        String str36;
        long j19;
        String str37;
        String str38 = (i13 & 1) != 0 ? inferExceptionRecord.expLogId : str;
        String str39 = (i13 & 2) != 0 ? inferExceptionRecord.traceId : str2;
        String str40 = (i13 & 4) != 0 ? inferExceptionRecord.taskId : str3;
        int i17 = (i13 & 8) != 0 ? inferExceptionRecord.callerUid : i10;
        String str41 = (i13 & 16) != 0 ? inferExceptionRecord.callerPkg : str4;
        String str42 = (i13 & 32) != 0 ? inferExceptionRecord.abilityId : str5;
        String str43 = (i13 & 64) != 0 ? inferExceptionRecord.modelId : str6;
        String str44 = (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? inferExceptionRecord.modelVersion : str7;
        String str45 = (i13 & 256) != 0 ? inferExceptionRecord.backend : str8;
        String str46 = (i13 & VadSessionManager.FRAME_BYTES) != 0 ? inferExceptionRecord.hardware : str9;
        String str47 = (i13 & 1024) != 0 ? inferExceptionRecord.engineVersion : str10;
        String str48 = (i13 & 2048) != 0 ? inferExceptionRecord.executionLocation : str11;
        boolean z10 = (i13 & 4096) != 0 ? inferExceptionRecord.isForeground : z;
        String str49 = (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? inferExceptionRecord.priority : str12;
        String str50 = str38;
        long j20 = (i13 & 16384) != 0 ? inferExceptionRecord.startWallMs : j10;
        long j21 = (i13 & 32768) != 0 ? inferExceptionRecord.startMonoNs : j11;
        long j22 = (i13 & 65536) != 0 ? inferExceptionRecord.endMonoNs : j12;
        long j23 = (i13 & 131072) != 0 ? inferExceptionRecord.e2eMs : j13;
        int i18 = (i13 & 262144) != 0 ? inferExceptionRecord.queueWaitMs : i11;
        String str51 = (i13 & 524288) != 0 ? inferExceptionRecord.status : str13;
        int i19 = i18;
        int i20 = (i13 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? inferExceptionRecord.errorCode : i12;
        String str52 = (i13 & 2097152) != 0 ? inferExceptionRecord.failStage : str14;
        String str53 = (i13 & 4194304) != 0 ? inferExceptionRecord.failClass : str15;
        String str54 = (i13 & 8388608) != 0 ? inferExceptionRecord.exceptionMsg : str16;
        String str55 = (i13 & 16777216) != 0 ? inferExceptionRecord.stackDigest : str17;
        String str56 = (i13 & 33554432) != 0 ? inferExceptionRecord.failStack : str18;
        String str57 = str51;
        long j24 = (i13 & 67108864) != 0 ? inferExceptionRecord.retryAfterMs : j14;
        if ((i13 & 134217728) != 0) {
            j15 = j24;
            str20 = inferExceptionRecord.phases;
            j17 = j22;
            j18 = j23;
            i14 = i19;
            i15 = i20;
            str21 = str52;
            str22 = str53;
            str23 = str54;
            str24 = str55;
            str25 = str57;
            str26 = str56;
            str28 = str41;
            str29 = str42;
            str30 = str43;
            str31 = str44;
            str32 = str45;
            str33 = str46;
            str34 = str47;
            str35 = str48;
            z3 = z10;
            str36 = str49;
            j19 = j20;
            j16 = j21;
            str37 = str39;
            str27 = str40;
            i16 = i17;
        } else {
            str20 = str19;
            j15 = j24;
            j16 = j21;
            j17 = j22;
            j18 = j23;
            i14 = i19;
            i15 = i20;
            str21 = str52;
            str22 = str53;
            str23 = str54;
            str24 = str55;
            str25 = str57;
            str26 = str56;
            str27 = str40;
            i16 = i17;
            str28 = str41;
            str29 = str42;
            str30 = str43;
            str31 = str44;
            str32 = str45;
            str33 = str46;
            str34 = str47;
            str35 = str48;
            z3 = z10;
            str36 = str49;
            j19 = j20;
            str37 = str39;
        }
        return inferExceptionRecord.copy(str50, str37, str27, i16, str28, str29, str30, str31, str32, str33, str34, str35, z3, str36, j19, j16, j17, j18, i14, str25, i15, str21, str22, str23, str24, str26, j15, str20);
    }

    public static /* synthetic */ String emsDetailBody$default(InferExceptionRecord inferExceptionRecord, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = FailStack.MAX_CHARS;
        }
        return inferExceptionRecord.emsDetailBody(i10);
    }

    private final String jsonQuote(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 8);
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\t') {
                sb2.append("\\t");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (cCharAt < ' ') {
                sb2.append("\\u");
                b1.l(16);
                String string = Integer.toString(cCharAt, 16);
                kotlin.jvm.internal.g.e(string, "toString(...)");
                sb2.append(gc.q.x0(4, string));
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append('\"');
        String string2 = sb2.toString();
        kotlin.jvm.internal.g.e(string2, "toString(...)");
        return string2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String renderJsonObject(List<? extends Pair<String, ? extends JsonValue>> list, boolean z) {
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        String str3 = z ? "  " : "";
        String str4 = z ? "    " : "";
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append('{');
        sb2.append(str);
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                m.f0();
                throw null;
            }
            Pair pair = (Pair) obj;
            String str5 = (String) pair.f9985a;
            JsonValue jsonValue = (JsonValue) pair.f9986b;
            sb2.append(str3);
            sb2.append(jsonQuote(str5));
            sb2.append(':');
            sb2.append(str2);
            if (jsonValue instanceof JsonStr) {
                sb2.append(jsonQuote(((JsonStr) jsonValue).getV()));
            } else if (jsonValue instanceof JsonNum) {
                sb2.append(((JsonNum) jsonValue).getV());
            } else if (jsonValue instanceof JsonBool) {
                sb2.append(((JsonBool) jsonValue).getV());
            } else {
                if (!(jsonValue instanceof JsonStrArray)) {
                    throw new NoWhenBranchMatchedException();
                }
                sb2.append('[');
                sb2.append(str);
                JsonStrArray jsonStrArray = (JsonStrArray) jsonValue;
                int i12 = 0;
                for (Object obj2 : jsonStrArray.getV()) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        m.f0();
                        throw null;
                    }
                    sb2.append(str4);
                    sb2.append(jsonQuote((String) obj2));
                    if (i12 != m.a0(jsonStrArray.getV())) {
                        sb2.append(',');
                    }
                    sb2.append(str);
                    i12 = i13;
                }
                sb2.append(str3);
                sb2.append(']');
            }
            if (i10 != m.a0(list)) {
                sb2.append(',');
            }
            sb2.append(str);
            i10 = i11;
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String toJson$default(InferExceptionRecord inferExceptionRecord, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = false;
        }
        return inferExceptionRecord.toJson(z);
    }

    public final String component1() {
        return this.expLogId;
    }

    public final String component10() {
        return this.hardware;
    }

    public final String component11() {
        return this.engineVersion;
    }

    public final String component12() {
        return this.executionLocation;
    }

    public final boolean component13() {
        return this.isForeground;
    }

    public final String component14() {
        return this.priority;
    }

    public final long component15() {
        return this.startWallMs;
    }

    public final long component16() {
        return this.startMonoNs;
    }

    public final long component17() {
        return this.endMonoNs;
    }

    public final long component18() {
        return this.e2eMs;
    }

    public final int component19() {
        return this.queueWaitMs;
    }

    public final String component2() {
        return this.traceId;
    }

    public final String component20() {
        return this.status;
    }

    public final int component21() {
        return this.errorCode;
    }

    public final String component22() {
        return this.failStage;
    }

    public final String component23() {
        return this.failClass;
    }

    public final String component24() {
        return this.exceptionMsg;
    }

    public final String component25() {
        return this.stackDigest;
    }

    public final String component26() {
        return this.failStack;
    }

    public final long component27() {
        return this.retryAfterMs;
    }

    public final String component28() {
        return this.phases;
    }

    public final String component3() {
        return this.taskId;
    }

    public final int component4() {
        return this.callerUid;
    }

    public final String component5() {
        return this.callerPkg;
    }

    public final String component6() {
        return this.abilityId;
    }

    public final String component7() {
        return this.modelId;
    }

    public final String component8() {
        return this.modelVersion;
    }

    public final String component9() {
        return this.backend;
    }

    public final InferExceptionRecord copy(String expLogId, String traceId, String taskId, int i10, String callerPkg, String abilityId, String modelId, String modelVersion, String backend, String hardware, String engineVersion, String executionLocation, boolean z, String priority, long j10, long j11, long j12, long j13, int i11, String status, int i12, String failStage, String failClass, String exceptionMsg, String stackDigest, String failStack, long j14, String phases) {
        kotlin.jvm.internal.g.f(expLogId, "expLogId");
        kotlin.jvm.internal.g.f(traceId, "traceId");
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(callerPkg, "callerPkg");
        kotlin.jvm.internal.g.f(abilityId, "abilityId");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(modelVersion, "modelVersion");
        kotlin.jvm.internal.g.f(backend, "backend");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        kotlin.jvm.internal.g.f(engineVersion, "engineVersion");
        kotlin.jvm.internal.g.f(executionLocation, "executionLocation");
        kotlin.jvm.internal.g.f(priority, "priority");
        kotlin.jvm.internal.g.f(status, "status");
        kotlin.jvm.internal.g.f(failStage, "failStage");
        kotlin.jvm.internal.g.f(failClass, "failClass");
        kotlin.jvm.internal.g.f(exceptionMsg, "exceptionMsg");
        kotlin.jvm.internal.g.f(stackDigest, "stackDigest");
        kotlin.jvm.internal.g.f(failStack, "failStack");
        kotlin.jvm.internal.g.f(phases, "phases");
        return new InferExceptionRecord(expLogId, traceId, taskId, i10, callerPkg, abilityId, modelId, modelVersion, backend, hardware, engineVersion, executionLocation, z, priority, j10, j11, j12, j13, i11, status, i12, failStage, failClass, exceptionMsg, stackDigest, failStack, j14, phases);
    }

    public final String emsDetailBody(int i10) {
        StringBuilder sb2 = new StringBuilder(VadSessionManager.FRAME_BYTES);
        sb2.append(glanceLabel());
        sb2.append("\nfail_class=");
        sb2.append(this.failClass);
        sb2.append("\nexception_msg=");
        sb2.append(this.exceptionMsg);
        sb2.append("\nstack_digest=");
        sb2.append(this.stackDigest);
        sb2.append("\ntask_id=");
        sb2.append(this.taskId);
        sb2.append("\nmodel_id=");
        sb2.append(this.modelId);
        sb2.append(" backend=");
        sb2.append(this.backend);
        sb2.append('\n');
        if (this.failStack.length() > 0) {
            sb2.append("----\n");
            sb2.append(this.failStack);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string.length() <= i10 ? string : r.R0(i10, string);
    }

    public final String emsReason() {
        String str = this.failClass;
        if (gc.q.t0(str)) {
            str = "unknown";
        }
        return com.stepos.core.ota.d.i(glanceLabel(), " class=", str);
    }

    public final String emsSubType() {
        String str = this.abilityId;
        if (gc.q.t0(str)) {
            str = this.modelId;
        }
        if (gc.q.t0(str)) {
            str = "unknown";
        }
        return new Regex("[^A-Za-z0-9._-]").d(str, "_") + "_" + this.failStage + "_" + this.errorCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InferExceptionRecord)) {
            return false;
        }
        InferExceptionRecord inferExceptionRecord = (InferExceptionRecord) obj;
        return kotlin.jvm.internal.g.b(this.expLogId, inferExceptionRecord.expLogId) && kotlin.jvm.internal.g.b(this.traceId, inferExceptionRecord.traceId) && kotlin.jvm.internal.g.b(this.taskId, inferExceptionRecord.taskId) && this.callerUid == inferExceptionRecord.callerUid && kotlin.jvm.internal.g.b(this.callerPkg, inferExceptionRecord.callerPkg) && kotlin.jvm.internal.g.b(this.abilityId, inferExceptionRecord.abilityId) && kotlin.jvm.internal.g.b(this.modelId, inferExceptionRecord.modelId) && kotlin.jvm.internal.g.b(this.modelVersion, inferExceptionRecord.modelVersion) && kotlin.jvm.internal.g.b(this.backend, inferExceptionRecord.backend) && kotlin.jvm.internal.g.b(this.hardware, inferExceptionRecord.hardware) && kotlin.jvm.internal.g.b(this.engineVersion, inferExceptionRecord.engineVersion) && kotlin.jvm.internal.g.b(this.executionLocation, inferExceptionRecord.executionLocation) && this.isForeground == inferExceptionRecord.isForeground && kotlin.jvm.internal.g.b(this.priority, inferExceptionRecord.priority) && this.startWallMs == inferExceptionRecord.startWallMs && this.startMonoNs == inferExceptionRecord.startMonoNs && this.endMonoNs == inferExceptionRecord.endMonoNs && this.e2eMs == inferExceptionRecord.e2eMs && this.queueWaitMs == inferExceptionRecord.queueWaitMs && kotlin.jvm.internal.g.b(this.status, inferExceptionRecord.status) && this.errorCode == inferExceptionRecord.errorCode && kotlin.jvm.internal.g.b(this.failStage, inferExceptionRecord.failStage) && kotlin.jvm.internal.g.b(this.failClass, inferExceptionRecord.failClass) && kotlin.jvm.internal.g.b(this.exceptionMsg, inferExceptionRecord.exceptionMsg) && kotlin.jvm.internal.g.b(this.stackDigest, inferExceptionRecord.stackDigest) && kotlin.jvm.internal.g.b(this.failStack, inferExceptionRecord.failStack) && this.retryAfterMs == inferExceptionRecord.retryAfterMs && kotlin.jvm.internal.g.b(this.phases, inferExceptionRecord.phases);
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getCallerPkg() {
        return this.callerPkg;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final long getE2eMs() {
        return this.e2eMs;
    }

    public final long getEndMonoNs() {
        return this.endMonoNs;
    }

    public final String getEngineVersion() {
        return this.engineVersion;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public final String getExecutionLocation() {
        return this.executionLocation;
    }

    public final String getExpLogId() {
        return this.expLogId;
    }

    public final String getFailClass() {
        return this.failClass;
    }

    public final String getFailStack() {
        return this.failStack;
    }

    public final String getFailStage() {
        return this.failStage;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getModelVersion() {
        return this.modelVersion;
    }

    public final String getPhases() {
        return this.phases;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final int getQueueWaitMs() {
        return this.queueWaitMs;
    }

    public final long getRetryAfterMs() {
        return this.retryAfterMs;
    }

    public final String getStackDigest() {
        return this.stackDigest;
    }

    public final long getStartMonoNs() {
        return this.startMonoNs;
    }

    public final long getStartWallMs() {
        return this.startWallMs;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String glanceLabel() {
        String str = this.abilityId;
        if (gc.q.t0(str)) {
            str = this.modelId;
        }
        if (gc.q.t0(str)) {
            str = "unknown";
        }
        String str2 = this.failStage;
        int i10 = this.errorCode;
        StringBuilder sbS = ai.onnxruntime.a.s("ability=", str, " stage=", str2, " code=");
        sbS.append(i10);
        return sbS.toString();
    }

    public int hashCode() {
        return this.phases.hashCode() + a0.a.c(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(ai.onnxruntime.a.d(this.errorCode, v1.d.a(ai.onnxruntime.a.d(this.queueWaitMs, a0.a.c(a0.a.c(a0.a.c(a0.a.c(v1.d.a(ai.onnxruntime.a.f(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(v1.d.a(ai.onnxruntime.a.d(this.callerUid, v1.d.a(v1.d.a(this.expLogId.hashCode() * 31, 31, this.traceId), 31, this.taskId), 31), 31, this.callerPkg), 31, this.abilityId), 31, this.modelId), 31, this.modelVersion), 31, this.backend), 31, this.hardware), 31, this.engineVersion), 31, this.executionLocation), 31, this.isForeground), 31, this.priority), this.startWallMs, 31), this.startMonoNs, 31), this.endMonoNs, 31), this.e2eMs, 31), 31), 31, this.status), 31), 31, this.failStage), 31, this.failClass), 31, this.exceptionMsg), 31, this.stackDigest), 31, this.failStack), this.retryAfterMs, 31);
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final String toJson(boolean z) {
        List<String> lines = FailStack.INSTANCE.toLines(this.failStack);
        ListBuilder listBuilderY = b1.y();
        listBuilderY.add(new Pair("exp_log_id", new JsonStr(this.expLogId)));
        String occurredAt = Companion.formatOccurredAt(this.startWallMs);
        if (occurredAt != null) {
            listBuilderY.add(new Pair("occurred_at", new JsonStr(occurredAt)));
        }
        listBuilderY.add(new Pair("caller_pkg", new JsonStr(this.callerPkg)));
        listBuilderY.add(new Pair("caller_uid", new JsonNum(this.callerUid)));
        listBuilderY.add(new Pair("is_foreground", new JsonBool(this.isForeground)));
        if (this.priority.length() > 0) {
            listBuilderY.add(new Pair("priority", new JsonStr(this.priority)));
        }
        listBuilderY.add(new Pair("ability_id", new JsonStr(this.abilityId)));
        listBuilderY.add(new Pair("model_id", new JsonStr(this.modelId)));
        listBuilderY.add(new Pair("backend", new JsonStr(this.backend)));
        if (this.hardware.length() > 0) {
            listBuilderY.add(new Pair("hardware", new JsonStr(this.hardware)));
        }
        if (this.executionLocation.length() > 0) {
            listBuilderY.add(new Pair("execution_location", new JsonStr(this.executionLocation)));
        }
        listBuilderY.add(new Pair("infer_id", new JsonStr(this.taskId)));
        listBuilderY.add(new Pair(FileResponse.FIELD_STATUS, new JsonStr(this.status)));
        listBuilderY.add(new Pair("fail_stage", new JsonStr(this.failStage)));
        listBuilderY.add(new Pair("error_code", new JsonNum(this.errorCode)));
        listBuilderY.add(new Pair("fail_class", new JsonStr(this.failClass)));
        listBuilderY.add(new Pair("exception_msg", new JsonStr(this.exceptionMsg)));
        listBuilderY.add(new Pair("e2e_ms", new JsonNum(this.e2eMs)));
        int i10 = this.queueWaitMs;
        if (i10 > 0) {
            listBuilderY.add(new Pair("queue_wait_ms", new JsonNum(i10)));
        }
        if (!lines.isEmpty()) {
            listBuilderY.add(new Pair("fail_stack", new JsonStrArray(lines)));
        }
        return renderJsonObject(b1.i(listBuilderY), z);
    }

    public String toString() {
        String str = this.expLogId;
        String str2 = this.traceId;
        String str3 = this.taskId;
        int i10 = this.callerUid;
        String str4 = this.callerPkg;
        String str5 = this.abilityId;
        String str6 = this.modelId;
        String str7 = this.modelVersion;
        String str8 = this.backend;
        String str9 = this.hardware;
        String str10 = this.engineVersion;
        String str11 = this.executionLocation;
        boolean z = this.isForeground;
        String str12 = this.priority;
        long j10 = this.startWallMs;
        long j11 = this.startMonoNs;
        long j12 = this.endMonoNs;
        long j13 = this.e2eMs;
        int i11 = this.queueWaitMs;
        String str13 = this.status;
        int i12 = this.errorCode;
        String str14 = this.failStage;
        String str15 = this.failClass;
        String str16 = this.exceptionMsg;
        String str17 = this.stackDigest;
        String str18 = this.failStack;
        long j14 = this.retryAfterMs;
        String str19 = this.phases;
        StringBuilder sbS = ai.onnxruntime.a.s("InferExceptionRecord(expLogId=", str, ", traceId=", str2, ", taskId=");
        com.stepos.core.ota.d.o(i10, str3, ", callerUid=", ", callerPkg=", sbS);
        ai.onnxruntime.a.z(sbS, str4, ", abilityId=", str5, ", modelId=");
        ai.onnxruntime.a.z(sbS, str6, ", modelVersion=", str7, ", backend=");
        ai.onnxruntime.a.z(sbS, str8, ", hardware=", str9, ", engineVersion=");
        ai.onnxruntime.a.z(sbS, str10, ", executionLocation=", str11, ", isForeground=");
        sbS.append(z);
        sbS.append(", priority=");
        sbS.append(str12);
        sbS.append(", startWallMs=");
        sbS.append(j10);
        a0.a.s(j11, ", startMonoNs=", ", endMonoNs=", sbS);
        sbS.append(j12);
        a0.a.s(j13, ", e2eMs=", ", queueWaitMs=", sbS);
        h0.e.h(i11, ", status=", str13, ", errorCode=", sbS);
        h0.e.h(i12, ", failStage=", str14, ", failClass=", sbS);
        ai.onnxruntime.a.z(sbS, str15, ", exceptionMsg=", str16, ", stackDigest=");
        ai.onnxruntime.a.z(sbS, str17, ", failStack=", str18, ", retryAfterMs=");
        ai.onnxruntime.a.u(j14, ", phases=", str19, sbS);
        sbS.append(")");
        return sbS.toString();
    }

    public final Map<String, String> toTags() {
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("exp_log_id", this.expLogId);
        mapBuilder.put("ai_trace_id", this.traceId);
        mapBuilder.put("ai_task_id", this.taskId);
        mapBuilder.put("caller_uid", String.valueOf(this.callerUid));
        mapBuilder.put("caller_pkg", this.callerPkg);
        mapBuilder.put("ability_id", this.abilityId);
        mapBuilder.put("model_id", this.modelId);
        if (this.modelVersion.length() > 0) {
            mapBuilder.put("model_version", this.modelVersion);
        }
        mapBuilder.put("backend", this.backend);
        mapBuilder.put("hardware", this.hardware);
        mapBuilder.put("engine_version", this.engineVersion);
        mapBuilder.put("execution_location", this.executionLocation);
        mapBuilder.put("is_foreground", String.valueOf(this.isForeground));
        mapBuilder.put(FileResponse.FIELD_STATUS, this.status);
        mapBuilder.put("error_code", String.valueOf(this.errorCode));
        mapBuilder.put("e2e_ms", String.valueOf(this.e2eMs));
        int i10 = this.queueWaitMs;
        if (i10 > 0) {
            mapBuilder.put("queue_wait_ms", String.valueOf(i10));
        }
        mapBuilder.put("fail_stage", this.failStage);
        if (this.failClass.length() > 0) {
            mapBuilder.put("fail_class", this.failClass);
        }
        if (this.stackDigest.length() > 0) {
            mapBuilder.put("stack_digest", this.stackDigest);
        }
        if (this.priority.length() > 0) {
            mapBuilder.put("priority", this.priority);
        }
        long j10 = this.retryAfterMs;
        if (j10 >= 0) {
            mapBuilder.put("retry_after_ms", String.valueOf(j10));
        }
        return mapBuilder.b();
    }

    public /* synthetic */ InferExceptionRecord(String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, String str12, long j10, long j11, long j12, long j13, int i11, String str13, int i12, String str14, String str15, String str16, String str17, String str18, long j14, String str19, int i13, kotlin.jvm.internal.e eVar) {
        this(str, str2, str3, i10, str4, str5, str6, str7, str8, str9, str10, str11, z, (i13 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? "" : str12, j10, j11, j12, j13, i11, str13, i12, str14, str15, str16, str17, (i13 & 33554432) != 0 ? "" : str18, j14, str19);
    }
}
