package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f115581a = 0;

    static {
    }

    public static String a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJson");
        return GsonProtectorUtils.toJson(new Gson(), r100);
    }

    public static List b(JSONArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toList");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L8;
        r104 = b((JSONArray) r104);
    L10:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r104 = c((JSONObject) r104);
        goto L10
    L11:
        return r101;
    }

    public static Map c(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toMap");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = b((JSONArray) r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = c((JSONObject) r104);
        goto L11
    L12:
        return r101;
    }
}
