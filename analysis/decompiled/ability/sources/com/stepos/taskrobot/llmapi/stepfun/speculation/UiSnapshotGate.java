package com.stepos.taskrobot.llmapi.stepfun.speculation;

import D7.q;
import D7.v;
import D7.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.util.ClickRegionXmlInfo;
import j9.m;
import j9.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J<\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0007J\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J@\u0010\u001a\u001a\u00020\u001b2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u000b2\u001a\u0010\u001d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u000bH\u0002J4\u0010\u001e\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0002J$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\u0019\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J8\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u000b2\u001a\u0010%\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u000bH\u0002J,\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0018\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010\u0019\u001a\u00020*H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/speculation/UiSnapshotGate;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "BOUNDS_TOLERANCE_PX", "", "BOUNDS_KEYS", "", "verifyPendingCandidates", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;", "pageJson", "Lorg/json/JSONObject;", "pendingPairs", "screenSize", "Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "extractObservedUiXmlInfos", "", "x", "y", "limit", "parsePoint", "Lkotlin/Pair;", "value", "structuralMatch", "", "observed", "expected", "mapMatch", "valueMatch", "key", "toIntOrNull", "(Ljava/lang/Object;)Ljava/lang/Integer;", "toStringNormalized", "normalizeInfoList", "items", "normalizeMap", "normalizeValue", "jsonObjectToMap", "jsonArrayToList", "Lorg/json/JSONArray;", "jsonValueToAny", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UiSnapshotGate {
    private static final int BOUNDS_TOLERANCE_PX = 5;
    private static final String TAG = "UiSnapshotGate";
    public static final UiSnapshotGate INSTANCE = new UiSnapshotGate();
    private static final Set<String> BOUNDS_KEYS = q.K0(new String[]{"left", "top", "right", "bottom"});

    private UiSnapshotGate() {
    }

    public static /* synthetic */ List extractObservedUiXmlInfos$default(UiSnapshotGate uiSnapshotGate, JSONObject jSONObject, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = 3;
        }
        return uiSnapshotGate.extractObservedUiXmlInfos(jSONObject, i, i6, i10);
    }

    private final List<Object> jsonArrayToList(JSONArray value) {
        ArrayList arrayList = new ArrayList();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jsonValueToAny(value.opt(i)));
        }
        return arrayList;
    }

    private final Map<String, Object> jsonObjectToMap(JSONObject value) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = value.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jsonValueToAny(value.opt(next)));
        }
        return normalizeMap(linkedHashMap);
    }

    private final Object jsonValueToAny(Object value) {
        if (k.b(value, JSONObject.NULL)) {
            return null;
        }
        return value instanceof JSONObject ? jsonObjectToMap((JSONObject) value) : value instanceof JSONArray ? jsonArrayToList((JSONArray) value) : value;
    }

    private final boolean mapMatch(Map<String, ? extends Object> observed, Map<String, ? extends Object> expected) {
        if (!k.b(observed.keySet(), expected.keySet())) {
            return false;
        }
        Set<String> setKeySet = observed.keySet();
        if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
            return true;
        }
        for (String str : setKeySet) {
            if (!INSTANCE.valueMatch(str, observed.get(str), expected.get(str))) {
                return false;
            }
        }
        return true;
    }

    private final List<Map<String, Object>> normalizeInfoList(List<? extends Map<String, ? extends Object>> items) {
        List<? extends Map<String, ? extends Object>> list = items;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.normalizeMap((Map) it.next()));
        }
        return arrayList;
    }

    private final Map<String, Object> normalizeMap(Map<String, ? extends Object> value) {
        Object objNormalizeValue;
        Set<Map.Entry<String, ? extends Object>> setEntrySet = value.entrySet();
        int iP = a.P(w.c0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Object value2 = entry.getValue();
            if (value2 instanceof Map) {
                UiSnapshotGate uiSnapshotGate = INSTANCE;
                Set<Map.Entry> setEntrySet2 = ((Map) value2).entrySet();
                int iP2 = a.P(w.c0(setEntrySet2, 10));
                if (iP2 < 16) {
                    iP2 = 16;
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(iP2);
                for (Map.Entry entry2 : setEntrySet2) {
                    linkedHashMap2.put(String.valueOf(entry2.getKey()), entry2.getValue());
                }
                objNormalizeValue = uiSnapshotGate.normalizeMap(linkedHashMap2);
            } else if (value2 instanceof List) {
                Iterable iterable = (Iterable) value2;
                ArrayList arrayList = new ArrayList(w.c0(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList.add(INSTANCE.normalizeValue(it2.next()));
                }
                objNormalizeValue = arrayList;
            } else {
                objNormalizeValue = INSTANCE.normalizeValue(value2);
            }
            linkedHashMap.put(str, objNormalizeValue);
        }
        return linkedHashMap;
    }

    private final Object normalizeValue(Object value) {
        if (!(value instanceof Map)) {
            if (!(value instanceof List)) {
                return value instanceof Number ? ((value instanceof Float) || (value instanceof Double)) ? Double.valueOf(((Number) value).doubleValue()) : Integer.valueOf(((Number) value).intValue()) : value;
            }
            Iterable iterable = (Iterable) value;
            ArrayList arrayList = new ArrayList(w.c0(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.normalizeValue(it.next()));
            }
            return arrayList;
        }
        Set<Map.Entry> setEntrySet = ((Map) value).entrySet();
        int iP = a.P(w.c0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        return normalizeMap(linkedHashMap);
    }

    private final boolean structuralMatch(List<? extends Map<String, ? extends Object>> observed, List<? extends Map<String, ? extends Object>> expected) {
        if (observed.size() != expected.size()) {
            return false;
        }
        ArrayList arrayListM1 = v.m1(observed, expected);
        if (arrayListM1.isEmpty()) {
            return true;
        }
        Iterator it = arrayListM1.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!INSTANCE.mapMatch((Map) pair.f4886a, (Map) pair.b)) {
                return false;
            }
        }
        return true;
    }

    private final Integer toIntOrNull(Object value) {
        Double dU;
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Long) {
            return Integer.valueOf((int) ((Number) value).longValue());
        }
        if (value instanceof Float) {
            return Integer.valueOf((int) ((Number) value).floatValue());
        }
        if (value instanceof Double) {
            return Integer.valueOf((int) ((Number) value).doubleValue());
        }
        if (!(value instanceof String) || (dU = s.U((String) value)) == null) {
            return null;
        }
        return Integer.valueOf((int) dU.doubleValue());
    }

    private final String toStringNormalized(Object value) {
        if (value == null) {
            return "null";
        }
        Integer intOrNull = toIntOrNull(value);
        return intOrNull != null ? String.valueOf(intOrNull.intValue()) : value.toString();
    }

    private final boolean valueMatch(String key, Object observed, Object expected) {
        if (observed == null && expected == null) {
            return true;
        }
        if (observed == null || expected == null) {
            return false;
        }
        if ((observed instanceof Map) && (expected instanceof Map)) {
            return mapMatch((Map) observed, (Map) expected);
        }
        if (!(observed instanceof List) || !(expected instanceof List)) {
            if (BOUNDS_KEYS.contains(key)) {
                Integer intOrNull = toIntOrNull(observed);
                Integer intOrNull2 = toIntOrNull(expected);
                if (intOrNull != null && intOrNull2 != null) {
                    return Math.abs(intOrNull.intValue() - intOrNull2.intValue()) <= 5;
                }
            }
            return k.b(toStringNormalized(observed), toStringNormalized(expected));
        }
        if (((List) observed).size() != ((List) expected).size()) {
            return false;
        }
        ArrayList arrayListM1 = v.m1((Iterable) observed, (Iterable) expected);
        if (arrayListM1.isEmpty()) {
            return true;
        }
        Iterator it = arrayListM1.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!INSTANCE.valueMatch(key, pair.f4886a, pair.b)) {
                return false;
            }
        }
        return true;
    }

    public final List<Map<String, Object>> extractObservedUiXmlInfos(JSONObject pageJson, int x10, int y, int limit) {
        k.f(pageJson, "pageJson");
        List<JSONObject> listExtractClickRegionXmlInfos = ClickRegionXmlInfo.extractClickRegionXmlInfos(pageJson, x10, y, limit);
        k.c(listExtractClickRegionXmlInfos);
        List<JSONObject> list = listExtractClickRegionXmlInfos;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        for (JSONObject jSONObject : list) {
            UiSnapshotGate uiSnapshotGate = INSTANCE;
            k.c(jSONObject);
            arrayList.add(uiSnapshotGate.jsonObjectToMap(jSONObject));
        }
        return arrayList;
    }

    public final Pair<Integer, Integer> parsePoint(Object value) {
        if (value instanceof List) {
            List list = (List) value;
            if (list.size() >= 2) {
                Double dU = s.U(String.valueOf(list.get(0)));
                Integer numValueOf = dU != null ? Integer.valueOf((int) dU.doubleValue()) : null;
                Double dU2 = s.U(String.valueOf(list.get(1)));
                Integer numValueOf2 = dU2 != null ? Integer.valueOf((int) dU2.doubleValue()) : null;
                if (numValueOf != null && numValueOf2 != null) {
                    return new Pair<>(numValueOf, numValueOf2);
                }
            }
        } else if (value instanceof Object[]) {
            Object[] objArr = (Object[]) value;
            if (objArr.length >= 2) {
                Double dU3 = s.U(String.valueOf(objArr[0]));
                Integer numValueOf3 = dU3 != null ? Integer.valueOf((int) dU3.doubleValue()) : null;
                Double dU4 = s.U(String.valueOf(objArr[1]));
                Integer numValueOf4 = dU4 != null ? Integer.valueOf((int) dU4.doubleValue()) : null;
                if (numValueOf3 != null && numValueOf4 != null) {
                    return new Pair<>(numValueOf3, numValueOf4);
                }
            }
        } else if (value instanceof String) {
            List listD0 = m.D0((CharSequence) value, new String[]{","}, 6);
            ArrayList arrayList = new ArrayList(w.c0(listD0, 10));
            Iterator it = listD0.iterator();
            while (it.hasNext()) {
                arrayList.add(m.R0((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (((String) next).length() > 0) {
                    arrayList2.add(next);
                }
            }
            if (arrayList2.size() >= 2) {
                Double dU5 = s.U((String) arrayList2.get(0));
                Integer numValueOf5 = dU5 != null ? Integer.valueOf((int) dU5.doubleValue()) : null;
                Double dU6 = s.U((String) arrayList2.get(1));
                Integer numValueOf6 = dU6 != null ? Integer.valueOf((int) dU6.doubleValue()) : null;
                if (numValueOf5 != null && numValueOf6 != null) {
                    return new Pair<>(numValueOf5, numValueOf6);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult.StepCandidatePair> verifyPendingCandidates(org.json.JSONObject r26, java.util.List<com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult.StepCandidatePair> r27, com.stepos.taskrobot.llmapi.stepfun.speculation.ActionNormalizer.ScreenSize r28) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.speculation.UiSnapshotGate.verifyPendingCandidates(org.json.JSONObject, java.util.List, com.stepos.taskrobot.llmapi.stepfun.speculation.ActionNormalizer$ScreenSize):java.util.List");
    }
}
