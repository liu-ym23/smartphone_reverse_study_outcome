package com.stepos.core.common.cloud;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.log.Sanitizer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptyList;
import lb.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudRequestBodyLog {
    public static final CloudRequestBodyLog INSTANCE = new CloudRequestBodyLog();

    private CloudRequestBodyLog() {
    }

    private final JSONObject cloneMasked(JSONObject jSONObject, String str, Set<String> set, Set<String> set2, Map<String, Integer> map) throws JSONException {
        CloudRequestBodyLog cloudRequestBodyLog;
        Set<String> set3;
        Set<String> set4;
        Map<String, Integer> map2;
        int length;
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strI = str.length() == 0 ? next : com.stepos.core.ota.d.i(str, ".", next);
            if (set2.contains(strI)) {
                n nVar = n.f10413a;
            } else if (set.contains(strI)) {
                Integer num = map.get(strI);
                if (num != null) {
                    length = num.intValue();
                } else {
                    Object obj = jSONObject.get(next);
                    String str2 = obj instanceof String ? (String) obj : null;
                    length = str2 != null ? str2.length() : obj.toString().length();
                }
                jSONObject2.put(next, Sanitizer.len(length));
            } else {
                Object obj2 = jSONObject.get(next);
                if (obj2 instanceof JSONObject) {
                    kotlin.jvm.internal.g.c(strI);
                    cloudRequestBodyLog = this;
                    set3 = set;
                    set4 = set2;
                    map2 = map;
                    jSONObject2.put(next, cloudRequestBodyLog.cloneMasked((JSONObject) obj2, strI, set3, set4, map2));
                } else {
                    cloudRequestBodyLog = this;
                    set3 = set;
                    set4 = set2;
                    map2 = map;
                    jSONObject2.put(next, obj2);
                }
                this = cloudRequestBodyLog;
                set = set3;
                set2 = set4;
                map = map2;
            }
            cloudRequestBodyLog = this;
            set3 = set;
            set4 = set2;
            map2 = map;
            this = cloudRequestBodyLog;
            set = set3;
            set2 = set4;
            map = map2;
        }
        return jSONObject2;
    }

    public static void logRequest$default(CloudRequestBodyLog cloudRequestBodyLog, String str, String str2, String str3, JSONObject jSONObject, List list, List list2, Map map, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            list = EmptyList.f10001a;
        }
        List list3 = list;
        if ((i10 & 32) != 0) {
            list2 = EmptyList.f10001a;
        }
        cloudRequestBodyLog.logRequest(str, str2, str3, jSONObject, list3, list2, (i10 & 64) != 0 ? kotlin.collections.b.d0() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String sanitize$default(CloudRequestBodyLog cloudRequestBodyLog, JSONObject jSONObject, List list, List list2, Map map, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = EmptyList.f10001a;
        }
        if ((i10 & 4) != 0) {
            list2 = EmptyList.f10001a;
        }
        if ((i10 & 8) != 0) {
            map = kotlin.collections.b.d0();
        }
        return cloudRequestBodyLog.sanitize(jSONObject, list, list2, map);
    }

    public final void logRequest(String tag, String logPrefix, String stage, JSONObject body, List<String> redactPaths, List<String> omitPaths, Map<String, Integer> redactLengths) {
        kotlin.jvm.internal.g.f(tag, "tag");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        kotlin.jvm.internal.g.f(stage, "stage");
        kotlin.jvm.internal.g.f(body, "body");
        kotlin.jvm.internal.g.f(redactPaths, "redactPaths");
        kotlin.jvm.internal.g.f(omitPaths, "omitPaths");
        kotlin.jvm.internal.g.f(redactLengths, "redactLengths");
        AIEngineLogger.i(LogModule.ABILITY, tag, logPrefix + " stage=" + stage + "[DIAG] req=" + sanitize(body, redactPaths, omitPaths, redactLengths));
    }

    public final String sanitize(JSONObject body, List<String> redactPaths, List<String> omitPaths, Map<String, Integer> redactLengths) {
        kotlin.jvm.internal.g.f(body, "body");
        kotlin.jvm.internal.g.f(redactPaths, "redactPaths");
        kotlin.jvm.internal.g.f(omitPaths, "omitPaths");
        kotlin.jvm.internal.g.f(redactLengths, "redactLengths");
        HashSet hashSetM0 = kotlin.collections.a.M0(redactPaths);
        hashSetM0.addAll(redactLengths.keySet());
        if (hashSetM0.isEmpty() && omitPaths.isEmpty()) {
            String string = body.toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            return string;
        }
        String string2 = cloneMasked(body, "", hashSetM0, kotlin.collections.a.M0(omitPaths), redactLengths).toString();
        kotlin.jvm.internal.g.e(string2, "toString(...)");
        return string2;
    }
}
