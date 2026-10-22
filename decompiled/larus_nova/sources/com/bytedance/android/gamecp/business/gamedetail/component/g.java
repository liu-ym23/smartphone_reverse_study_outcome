package com.bytedance.android.gamecp.business.gamedetail.component;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class g {
    public static final List<JSONObject> a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getChildrenList");
        JSONArray r101 = r100.optJSONArray("children");
        if (r101 != null) goto L7;
        return null;
    L7:
        return d(r101);
    }

    public static final String b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getComponentClass");
        String r101 = r100.optString("class");
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static final String c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getComponentId");
        String r101 = r100.optString("id");
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static final List<JSONObject> d(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$jsonArrayToList");
        ArrayList r101 = new ArrayList(16);
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(r100.optJSONObject(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }
}
