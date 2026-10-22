package com.bytedance.android.livesdk.utils;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f159236a;

    public static String a(View r100) {
        if (r100.getContext() != null) goto L5;
        return "";
    L5:
        if (r100.getContext().getResources() == null) goto L13;
        StringBuilder r101 = new StringBuilder(128);
        int r102 = f159236a;
        f159236a = r102 + 1;
        r101.append(r102);
        if ((r100 instanceof ProgressBar) == false) goto L10;
        r101.append("#ProgressBar#");
    L10:
        return r101.toString();
    L13:
        return "";
    }

    public static JSONObject b(ViewGroup r100) {
        ArrayList r101 = new ArrayList();
        HashSet r102 = new HashSet();
        JSONObject r103 = new JSONObject();
        if (r100 != null) goto L6;
        return r103;
    L6:
        if (r100.getId() == (-1)) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L18;
        r101.add(Integer.valueOf(r100.getId()));
    L18:
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L15
        r105.put(a(r100), c(r100, r101, r102));     // Catch: JSONException -> L15
        r103.put("view_info", r105);     // Catch: JSONException -> L15
        if (CollectionUtils.isEmpty(r102) == true) goto L17;
        r103.put("repeat_id", TextUtils.join(", ", r102));     // Catch: JSONException -> L15
    L17:
        return r103;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L8:
        r104 = false;
        goto L9
    }

    public static JSONObject c(ViewGroup r100, List<Integer> r101, HashSet<Integer> r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r103 = new JSONObject();
        r103.put("id", r100.getId());     // Catch: JSONException -> L23
        int r104 = 0;
    L7:
        if (r104 >= r100.getChildCount()) goto L25;
        View r105 = r100.getChildAt(r104);     // Catch: JSONException -> L23
        if (r105.getId() == (-1)) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L19;
        ArrayList r107 = (ArrayList) r101;     // Catch: JSONException -> L23
        if (r107.contains(Integer.valueOf(r105.getId())) == false) goto L17;
        r102.add(Integer.valueOf(r105.getId()));     // Catch: JSONException -> L23
        goto L19
    L17:
        r107.add(Integer.valueOf(r105.getId()));     // Catch: JSONException -> L23
    L19:
        if ((r105 instanceof ViewGroup) == false) goto L21;
        JSONObject r108 = c((ViewGroup) r105, r101, r102);     // Catch: JSONException -> L23
        r103.put(a(r105), r108);     // Catch: JSONException -> L23
    L22:
        r104 = r104 + 1;
        goto L7
    L21:
        r103.put(a(r105), String.valueOf(r105.getId()));     // Catch: JSONException -> L23
        goto L22
    L12:
        r106 = false;
    L25:
        return r103;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }
}
