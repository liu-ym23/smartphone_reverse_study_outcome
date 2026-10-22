package com.stepos.taskrobot.llmapi.stepfun.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ClickRegionXmlInfo {

    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.util.ClickRegionXmlInfo$1Candidate, reason: invalid class name */
    public class C1Candidate {
        final int area;
        final int depth;
        final int interactive;
        final JSONObject node;

        public C1Candidate(int i, int i6, int i10, JSONObject jSONObject) {
            this.depth = i;
            this.interactive = i6;
            this.area = i10;
            this.node = jSONObject;
        }
    }

    public static List<JSONObject> extractClickRegionXmlInfos(JSONObject jSONObject, int i, int i6, int i10) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("displays");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return Collections.EMPTY_LIST;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("allWindows");
        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optJSONObject("rootNode") : null;
            if (jSONObjectOptJSONObject3 != null) {
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(jSONObjectOptJSONObject3);
                map.put(Integer.valueOf(System.identityHashCode(jSONObjectOptJSONObject3)), jSONObjectOptJSONObject3);
                map3.put(Integer.valueOf(System.identityHashCode(jSONObjectOptJSONObject3)), 0);
                while (!arrayDeque.isEmpty()) {
                    JSONObject jSONObject2 = (JSONObject) arrayDeque.pop();
                    int iIdentityHashCode = System.identityHashCode(jSONObject2);
                    for (JSONObject jSONObject3 : getChildren(jSONObject2)) {
                        int iIdentityHashCode2 = System.identityHashCode(jSONObject3);
                        map2.put(Integer.valueOf(iIdentityHashCode2), jSONObject2);
                        map.put(Integer.valueOf(iIdentityHashCode2), jSONObject3);
                        map3.put(Integer.valueOf(iIdentityHashCode2), Integer.valueOf(((Integer) map3.getOrDefault(Integer.valueOf(iIdentityHashCode), 0)).intValue() + 1));
                        arrayDeque.push(jSONObject3);
                    }
                }
            }
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            JSONObject jSONObject4 = (JSONObject) entry.getValue();
            JSONObject jSONObjectOptJSONObject4 = jSONObject4.optJSONObject("bounds");
            if (jSONObjectOptJSONObject4 != null && pointInBounds(i, i6, jSONObjectOptJSONObject4)) {
                arrayList.add(new C1Candidate(((Integer) map3.getOrDefault(entry.getKey(), 0)).intValue(), isInteractive(jSONObject4) ? 1 : 0, nodeArea(jSONObjectOptJSONObject4), jSONObject4));
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1Candidate c1Candidate = (C1Candidate) it.next();
            if (c1Candidate.interactive == 1) {
                arrayList2.add(c1Candidate);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        arrayList.sort(new a());
        ArrayList arrayList3 = new ArrayList();
        for (JSONObject jSONObject5 = ((C1Candidate) arrayList.get(0)).node; jSONObject5 != null && arrayList3.size() < i10; jSONObject5 = (JSONObject) map2.get(Integer.valueOf(System.identityHashCode(jSONObject5)))) {
            try {
                arrayList3.add(nodeToInfo(jSONObject5));
            } catch (JSONException unused) {
            }
        }
        return arrayList3;
    }

    private static List<JSONObject> getChildren(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                Object objOpt = jSONArrayOptJSONArray.opt(i);
                if (objOpt instanceof JSONObject) {
                    arrayList.add((JSONObject) objOpt);
                }
            }
        }
        return arrayList;
    }

    private static boolean isInteractive(JSONObject jSONObject) {
        return jSONObject.optBoolean("isClickable", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$extractClickRegionXmlInfos$0(C1Candidate c1Candidate, C1Candidate c1Candidate2) {
        int iCompare = Integer.compare(c1Candidate2.depth, c1Candidate.depth);
        return iCompare != 0 ? iCompare : Integer.compare(c1Candidate.area, c1Candidate2.area);
    }

    private static int nodeArea(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("left", 0);
        int iOptInt2 = jSONObject.optInt("top", 0);
        int iOptInt3 = jSONObject.optInt("right", 0);
        int iOptInt4 = jSONObject.optInt("bottom", 0);
        return Math.max(0, iOptInt4 - iOptInt2) * Math.max(0, iOptInt3 - iOptInt);
    }

    private static JSONObject nodeToInfo(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bounds");
        JSONObject jSONObject2 = new JSONObject();
        Object obj = JSONObject.NULL;
        jSONObject2.put("className", jSONObject.optString("className", obj.toString()));
        jSONObject2.put("packageName", jSONObject.optString("packageName", obj.toString()));
        jSONObject2.put("text", jSONObject.optString("text", ""));
        jSONObject2.put("contentDescription", jSONObject.optString("contentDescription", ""));
        jSONObject2.put("viewId", jSONObject.optString("viewId", obj.toString()));
        jSONObject2.put("index", jSONObject.optInt("index", 0));
        jSONObject2.put("isClickable", jSONObject.optBoolean("isClickable", false));
        jSONObject2.put("isEnabled", jSONObject.optBoolean("isEnabled", false));
        jSONObject2.put("isVisible", jSONObject.optBoolean("isVisible", false));
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObjectOptJSONObject != null) {
            jSONObject3.put("left", jSONObjectOptJSONObject.optInt("left", 0));
            jSONObject3.put("top", jSONObjectOptJSONObject.optInt("top", 0));
            jSONObject3.put("right", jSONObjectOptJSONObject.optInt("right", 0));
            jSONObject3.put("bottom", jSONObjectOptJSONObject.optInt("bottom", 0));
        }
        jSONObject2.put("bounds", jSONObject3);
        return jSONObject2;
    }

    private static boolean pointInBounds(int i, int i6, JSONObject jSONObject) {
        return jSONObject.optInt("left", 0) <= i && i <= jSONObject.optInt("right", 0) && jSONObject.optInt("top", 0) <= i6 && i6 <= jSONObject.optInt("bottom", 0);
    }
}
