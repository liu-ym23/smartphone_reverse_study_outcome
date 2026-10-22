package com.stepos.core.ability.config.cloud;

import androidx.compose.runtime.i;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.ota.d;
import dc.h;
import fc.m;
import fc.o;
import fc.p;
import h0.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.g;
import mb.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityConfigDiff {
    public static final AbilityConfigDiff INSTANCE = new AbilityConfigDiff();
    private static final int MAX_ARRAY_VALUE_LEN = 256;
    private static final int MAX_FIELD_LINES = 20;
    private static final int MAX_VALUE_LEN = 48;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class FieldDiffer {

        /* renamed from: new, reason: not valid java name */
        private final Map<String, JSONObject> f0new;
        private final Map<String, JSONObject> old;

        /* JADX WARN: Multi-variable type inference failed */
        public FieldDiffer(Map<String, ? extends JSONObject> old, Map<String, ? extends JSONObject> map) {
            g.f(old, "old");
            g.f(map, "new");
            this.old = old;
            this.f0new = map;
        }

        public final List<String> diff(String id2) {
            g.f(id2, "id");
            return AbilityConfigDiff.INSTANCE.diffEntry(this.old.get(id2), this.f0new.get(id2));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Result {
        private final List<String> addedIds;
        private final List<String> changedIds;
        private final List<String> removedIds;
        private final List<String> unchangedIds;

        public Result(List<String> addedIds, List<String> removedIds, List<String> changedIds, List<String> unchangedIds) {
            g.f(addedIds, "addedIds");
            g.f(removedIds, "removedIds");
            g.f(changedIds, "changedIds");
            g.f(unchangedIds, "unchangedIds");
            this.addedIds = addedIds;
            this.removedIds = removedIds;
            this.changedIds = changedIds;
            this.unchangedIds = unchangedIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, List list, List list2, List list3, List list4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = result.addedIds;
            }
            if ((i10 & 2) != 0) {
                list2 = result.removedIds;
            }
            if ((i10 & 4) != 0) {
                list3 = result.changedIds;
            }
            if ((i10 & 8) != 0) {
                list4 = result.unchangedIds;
            }
            return result.copy(list, list2, list3, list4);
        }

        public final List<String> component1() {
            return this.addedIds;
        }

        public final List<String> component2() {
            return this.removedIds;
        }

        public final List<String> component3() {
            return this.changedIds;
        }

        public final List<String> component4() {
            return this.unchangedIds;
        }

        public final Result copy(List<String> addedIds, List<String> removedIds, List<String> changedIds, List<String> unchangedIds) {
            g.f(addedIds, "addedIds");
            g.f(removedIds, "removedIds");
            g.f(changedIds, "changedIds");
            g.f(unchangedIds, "unchangedIds");
            return new Result(addedIds, removedIds, changedIds, unchangedIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return g.b(this.addedIds, result.addedIds) && g.b(this.removedIds, result.removedIds) && g.b(this.changedIds, result.changedIds) && g.b(this.unchangedIds, result.unchangedIds);
        }

        public final List<String> getAddedIds() {
            return this.addedIds;
        }

        public final List<String> getChangedIds() {
            return this.changedIds;
        }

        public final List<String> getRemovedIds() {
            return this.removedIds;
        }

        public final List<String> getUnchangedIds() {
            return this.unchangedIds;
        }

        public int hashCode() {
            return this.unchangedIds.hashCode() + e.b(this.changedIds, e.b(this.removedIds, this.addedIds.hashCode() * 31, 31), 31);
        }

        public String toString() {
            return "Result(addedIds=" + this.addedIds + ", removedIds=" + this.removedIds + ", changedIds=" + this.changedIds + ", unchangedIds=" + this.unchangedIds + ")";
        }
    }

    private AbilityConfigDiff() {
    }

    private final String canonical(Object obj) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            g.e(itKeys, "keys(...)");
            return p.y(new o(m.x(itKeys)), ",", new i(jSONObject, 11), 24);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            return a.z0(h.e0(0, jSONArray.length()), ",", "[", "]", new androidx.compose.runtime.g(jSONArray, 20), 24);
        }
        if (!(obj instanceof String)) {
            return String.valueOf(obj);
        }
        return "\"" + obj + "\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence canonical$lambda$7(Object obj, String str) {
        return ai.onnxruntime.a.l("\"", str, "\":", INSTANCE.canonical(((JSONObject) obj).get(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence canonical$lambda$8(Object obj, int i10) {
        return INSTANCE.canonical(((JSONArray) obj).get(i10));
    }

    private final int capFor(String str) {
        return gc.o.k0(str, "[", false) ? 256 : 48;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> diffEntry(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return EmptyList.f10001a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AbilityConfigDiff abilityConfigDiff = INSTANCE;
        abilityConfigDiff.flatten(jSONObject, "", linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        abilityConfigDiff.flatten(jSONObject2, "", linkedHashMap2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(linkedHashMap2.keySet());
        linkedHashSet.addAll(linkedHashMap.keySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        g.e(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            g.e(next, "next(...)");
            String str = (String) next;
            String str2 = (String) linkedHashMap.get(str);
            String str3 = (String) linkedHashMap2.get(str);
            if (!g.b(str2, str3)) {
                if (arrayList.size() >= 20) {
                    arrayList.add("... (超过 20 行已截断)");
                    return arrayList;
                }
                arrayList.add(str + " : " + render(str2) + " -> " + render(str3));
            }
        }
        return arrayList;
    }

    private final void flatten(JSONObject jSONObject, String str, Map<String, String> map) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        g.e(itKeys, "keys(...)");
        fc.i iVarX = m.x(itKeys);
        ArrayList arrayList = new ArrayList();
        Iterator it = iVarX.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            String strI = str.length() == 0 ? str2 : d.i(str, ".", str2);
            Object obj = jSONObject.get(str2);
            if (obj instanceof JSONObject) {
                g.c(strI);
                INSTANCE.flatten((JSONObject) obj, strI, map);
            } else {
                map.put(strI, INSTANCE.canonical(obj));
            }
        }
    }

    private final Map<String, String> index(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            String strOptString = jSONObject.optString(ModelDownloadNotifier.EXTRA_NOTIF_ID, "");
            g.c(strOptString);
            if (strOptString.length() > 0) {
                linkedHashMap.put(strOptString, canonical(jSONObject));
            }
        }
        return linkedHashMap;
    }

    private final Map<String, JSONObject> indexRaw(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            String strOptString = jSONObject.optString(ModelDownloadNotifier.EXTRA_NOTIF_ID, "");
            g.c(strOptString);
            if (strOptString.length() > 0) {
                linkedHashMap.put(strOptString, jSONObject);
            }
        }
        return linkedHashMap;
    }

    private final String render(String str) {
        return str == null ? "(absent)" : str.length() <= capFor(str) ? str : a0.a.g("len=", str.length(), ",hash=", sha8(str));
    }

    private final String sha8(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(gc.a.f9106b);
        g.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        g.e(bArrDigest, "digest(...)");
        return a.z0(l.l0(bArrDigest, 4), "", null, null, new o6.a(1), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence sha8$lambda$6(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    public final Result compute(String oldJson, String newJson) {
        g.f(oldJson, "oldJson");
        g.f(newJson, "newJson");
        Map<String, String> mapIndex = index(oldJson);
        Map<String, String> mapIndex2 = index(newJson);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (String str : mapIndex2.keySet()) {
            if (!mapIndex.containsKey(str)) {
                arrayList.add(str);
            } else if (g.b(mapIndex.get(str), mapIndex2.get(str))) {
                arrayList4.add(str);
            } else {
                arrayList3.add(str);
            }
        }
        for (String str2 : mapIndex.keySet()) {
            if (!mapIndex2.containsKey(str2)) {
                arrayList2.add(str2);
            }
        }
        return new Result(arrayList, arrayList2, arrayList3, arrayList4);
    }

    public final List<String> fieldDiff(String oldJson, String newJson, String id2) {
        g.f(oldJson, "oldJson");
        g.f(newJson, "newJson");
        g.f(id2, "id");
        return fieldDiffer(oldJson, newJson).diff(id2);
    }

    public final FieldDiffer fieldDiffer(String oldJson, String newJson) {
        g.f(oldJson, "oldJson");
        g.f(newJson, "newJson");
        return new FieldDiffer(indexRaw(oldJson), indexRaw(newJson));
    }
}
