package com.stepos.core.ability.sla;

import ai.onnxruntime.a;
import com.stepos.core.common.atomic.AtomicDispatchResult;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.q;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SlaResultBuilder {
    public static final SlaResultBuilder INSTANCE = new SlaResultBuilder();
    public static final String PHASE_DECISION = "decision";
    public static final String PHASE_EXECUTION = "execution";
    public static final String PHASE_SLA_OUTPUT = "sla_output";
    private static final String SCHEMA_VERSION = "v1";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MockAlt {
        private final float confidence;
        private final String function;
        private final Map<String, String> params;
        private final String text;

        public MockAlt(String function, String text, Map<String, String> params, float f8) {
            g.f(function, "function");
            g.f(text, "text");
            g.f(params, "params");
            this.function = function;
            this.text = text;
            this.params = params;
            this.confidence = f8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MockAlt copy$default(MockAlt mockAlt, String str, String str2, Map map, float f8, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = mockAlt.function;
            }
            if ((i10 & 2) != 0) {
                str2 = mockAlt.text;
            }
            if ((i10 & 4) != 0) {
                map = mockAlt.params;
            }
            if ((i10 & 8) != 0) {
                f8 = mockAlt.confidence;
            }
            return mockAlt.copy(str, str2, map, f8);
        }

        public final String component1() {
            return this.function;
        }

        public final String component2() {
            return this.text;
        }

        public final Map<String, String> component3() {
            return this.params;
        }

        public final float component4() {
            return this.confidence;
        }

        public final MockAlt copy(String function, String text, Map<String, String> params, float f8) {
            g.f(function, "function");
            g.f(text, "text");
            g.f(params, "params");
            return new MockAlt(function, text, params, f8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MockAlt)) {
                return false;
            }
            MockAlt mockAlt = (MockAlt) obj;
            return g.b(this.function, mockAlt.function) && g.b(this.text, mockAlt.text) && g.b(this.params, mockAlt.params) && Float.compare(this.confidence, mockAlt.confidence) == 0;
        }

        public final float getConfidence() {
            return this.confidence;
        }

        public final String getFunction() {
            return this.function;
        }

        public final Map<String, String> getParams() {
            return this.params;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Float.hashCode(this.confidence) + ((this.params.hashCode() + d.a(this.function.hashCode() * 31, 31, this.text)) * 31);
        }

        public String toString() {
            String str = this.function;
            String str2 = this.text;
            Map<String, String> map = this.params;
            float f8 = this.confidence;
            StringBuilder sbS = a.s("MockAlt(function=", str, ", text=", str2, ", params=");
            sbS.append(map);
            sbS.append(", confidence=");
            sbS.append(f8);
            sbS.append(")");
            return sbS.toString();
        }
    }

    private SlaResultBuilder() {
    }

    public static /* synthetic */ String buildSlaOutputPhase$default(SlaResultBuilder slaResultBuilder, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return slaResultBuilder.buildSlaOutputPhase(str, j10);
    }

    private final JSONObject decisionJson(MockDecision mockDecision) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("function", mockDecision.getFunction());
        jSONObject.put("text", mockDecision.getText());
        jSONObject.put(BaseConstantsKt.KEY_PARAMS, new JSONObject(mockDecision.getParams()));
        jSONObject.putOpt("priority", mockDecision.getPriority());
        jSONObject.put("confidence", mockDecision.getConfidence());
        JSONArray jSONArray = new JSONArray();
        for (MockAlt mockAlt : mockDecision.getAlternatives()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("function", mockAlt.getFunction());
            jSONObject2.put("text", mockAlt.getText());
            jSONObject2.put(BaseConstantsKt.KEY_PARAMS, new JSONObject(mockAlt.getParams()));
            jSONObject2.put("confidence", mockAlt.getConfidence());
            jSONArray.put(jSONObject2);
        }
        n nVar = n.f10413a;
        jSONObject.put("alternatives", jSONArray);
        jSONObject.putOpt("rejectReason", mockDecision.getRejectReason());
        return jSONObject;
    }

    private final JSONObject executionJson(MockDecision mockDecision, AtomicDispatchResult atomicDispatchResult) throws JSONException {
        Object objA;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dispatched", !(mockDecision.getFallback() || atomicDispatchResult.getStatus() == AtomicDispatchResult.Status.NOT_DISPATCHED));
        jSONObject.put("executor", atomicDispatchResult.getExecutor());
        jSONObject.put(FileResponse.FIELD_STATUS, atomicDispatchResult.getStatus().name());
        jSONObject.put(BaseConstantsKt.KEY_ERROR_CODE, atomicDispatchResult.getErrorCode());
        jSONObject.putOpt("errorMsg", atomicDispatchResult.getErrorMsg());
        String resultJson = atomicDispatchResult.getResultJson();
        if (resultJson != null) {
            try {
                objA = jSONObject.put("result", new JSONObject(resultJson));
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (Result.b(objA) != null) {
                jSONObject.put("result", resultJson);
            }
        }
        jSONObject.put("elapsedMs", atomicDispatchResult.getElapsedMs());
        return jSONObject;
    }

    public final String build(MockDecision decision, AtomicDispatchResult execution, String str, long j10, long j11) throws JSONException {
        g.f(decision, "decision");
        g.f(execution, "execution");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", SCHEMA_VERSION);
        jSONObject.put("phase", PHASE_EXECUTION);
        jSONObject.put(PHASE_DECISION, decisionJson(decision));
        jSONObject.put(PHASE_EXECUTION, executionJson(decision, execution));
        if (str != null && !q.t0(str)) {
            jSONObject.put("asrText", str);
        }
        jSONObject.put("totalElapsedMs", j10);
        jSONObject.put("modelInferMs", j11);
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final String buildDecisionPhase(MockDecision decision, boolean z, int i10, String str, String str2, long j10) throws JSONException {
        g.f(decision, "decision");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", SCHEMA_VERSION);
        jSONObject.put("phase", PHASE_DECISION);
        jSONObject.put(PHASE_DECISION, decisionJson(decision));
        jSONObject.put("canExecute", z);
        jSONObject.put("execErrorCode", i10);
        if (str != null) {
            jSONObject.put("execReason", str);
        }
        if (str2 != null && !q.t0(str2)) {
            jSONObject.put("asrText", str2);
        }
        jSONObject.put("modelInferMs", j10);
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final String buildSlaOutputPhase(String rawText, long j10) throws JSONException {
        g.f(rawText, "rawText");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", SCHEMA_VERSION);
        jSONObject.put("phase", PHASE_SLA_OUTPUT);
        jSONObject.put("slaOutput", rawText);
        jSONObject.put("modelInferMs", j10);
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        return string;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MockDecision {
        private final List<MockAlt> alternatives;
        private final float confidence;
        private final boolean fallback;
        private final String function;
        private final Map<String, String> params;
        private final String priority;
        private final String rejectReason;
        private final String text;

        public MockDecision(String str, String str2, Map map, String str3, float f8, List list, boolean z, String str4, int i10, e eVar) {
            this(str, str2, map, str3, f8, (i10 & 32) != 0 ? EmptyList.f10001a : list, (i10 & 64) != 0 ? false : z, (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : str4);
        }

        public static /* synthetic */ MockDecision copy$default(MockDecision mockDecision, String str, String str2, Map map, String str3, float f8, List list, boolean z, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = mockDecision.function;
            }
            if ((i10 & 2) != 0) {
                str2 = mockDecision.text;
            }
            if ((i10 & 4) != 0) {
                map = mockDecision.params;
            }
            if ((i10 & 8) != 0) {
                str3 = mockDecision.priority;
            }
            if ((i10 & 16) != 0) {
                f8 = mockDecision.confidence;
            }
            if ((i10 & 32) != 0) {
                list = mockDecision.alternatives;
            }
            if ((i10 & 64) != 0) {
                z = mockDecision.fallback;
            }
            if ((i10 & TraceIdKeys.MAX_LENGTH) != 0) {
                str4 = mockDecision.rejectReason;
            }
            boolean z3 = z;
            String str5 = str4;
            float f9 = f8;
            List list2 = list;
            return mockDecision.copy(str, str2, map, str3, f9, list2, z3, str5);
        }

        public final String component1() {
            return this.function;
        }

        public final String component2() {
            return this.text;
        }

        public final Map<String, String> component3() {
            return this.params;
        }

        public final String component4() {
            return this.priority;
        }

        public final float component5() {
            return this.confidence;
        }

        public final List<MockAlt> component6() {
            return this.alternatives;
        }

        public final boolean component7() {
            return this.fallback;
        }

        public final String component8() {
            return this.rejectReason;
        }

        public final MockDecision copy(String str, String text, Map<String, String> params, String str2, float f8, List<MockAlt> alternatives, boolean z, String str3) {
            g.f(text, "text");
            g.f(params, "params");
            g.f(alternatives, "alternatives");
            return new MockDecision(str, text, params, str2, f8, alternatives, z, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MockDecision)) {
                return false;
            }
            MockDecision mockDecision = (MockDecision) obj;
            return g.b(this.function, mockDecision.function) && g.b(this.text, mockDecision.text) && g.b(this.params, mockDecision.params) && g.b(this.priority, mockDecision.priority) && Float.compare(this.confidence, mockDecision.confidence) == 0 && g.b(this.alternatives, mockDecision.alternatives) && this.fallback == mockDecision.fallback && g.b(this.rejectReason, mockDecision.rejectReason);
        }

        public final List<MockAlt> getAlternatives() {
            return this.alternatives;
        }

        public final float getConfidence() {
            return this.confidence;
        }

        public final boolean getFallback() {
            return this.fallback;
        }

        public final String getFunction() {
            return this.function;
        }

        public final Map<String, String> getParams() {
            return this.params;
        }

        public final String getPriority() {
            return this.priority;
        }

        public final String getRejectReason() {
            return this.rejectReason;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.function;
            int iHashCode = (this.params.hashCode() + d.a((str == null ? 0 : str.hashCode()) * 31, 31, this.text)) * 31;
            String str2 = this.priority;
            int iF = a.f(h0.e.b(this.alternatives, a0.a.a(this.confidence, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31), 31, this.fallback);
            String str3 = this.rejectReason;
            return iF + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.function;
            String str2 = this.text;
            Map<String, String> map = this.params;
            String str3 = this.priority;
            float f8 = this.confidence;
            List<MockAlt> list = this.alternatives;
            boolean z = this.fallback;
            String str4 = this.rejectReason;
            StringBuilder sbS = a.s("MockDecision(function=", str, ", text=", str2, ", params=");
            sbS.append(map);
            sbS.append(", priority=");
            sbS.append(str3);
            sbS.append(", confidence=");
            sbS.append(f8);
            sbS.append(", alternatives=");
            sbS.append(list);
            sbS.append(", fallback=");
            sbS.append(z);
            sbS.append(", rejectReason=");
            sbS.append(str4);
            sbS.append(")");
            return sbS.toString();
        }

        public MockDecision(String str, String text, Map<String, String> params, String str2, float f8, List<MockAlt> alternatives, boolean z, String str3) {
            g.f(text, "text");
            g.f(params, "params");
            g.f(alternatives, "alternatives");
            this.function = str;
            this.text = text;
            this.params = params;
            this.priority = str2;
            this.confidence = f8;
            this.alternatives = alternatives;
            this.fallback = z;
            this.rejectReason = str3;
        }
    }
}
