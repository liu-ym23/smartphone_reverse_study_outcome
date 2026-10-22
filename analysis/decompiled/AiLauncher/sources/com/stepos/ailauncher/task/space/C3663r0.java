package com.stepos.ailauncher.task.space;

import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "obj", "", "", Const.INTENT_KEY_APIKEY, "(Lorg/json/JSONObject;)Ljava/util/List;", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3663r0 {
    public static final List<String> a(JSONObject obj) {
        kotlin.jvm.internal.p.i(obj, "obj");
        if (!obj.has("memory_ids")) {
            String strOptString = obj.optString("memory_id", "");
            kotlin.jvm.internal.p.h(strOptString, "optString(...)");
            String string = La.H.D1(strOptString).toString();
            return string.length() == 0 ? C1173v.m() : C1172u.e(string);
        }
        JSONArray jSONArrayOptJSONArray = obj.optJSONArray("memory_ids");
        if (jSONArrayOptJSONArray == null) {
            return C1173v.m();
        }
        int length = jSONArrayOptJSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            String strOptString2 = jSONArrayOptJSONArray.optString(i10);
            kotlin.jvm.internal.p.h(strOptString2, "optString(...)");
            arrayList.add(La.H.D1(strOptString2).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((String) obj2).length() > 0) {
                arrayList2.add(obj2);
            }
        }
        return Z8.F.g0(arrayList2);
    }
}
