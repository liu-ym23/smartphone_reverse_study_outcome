package com.bytedance.applog.params.extract;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class JsonUtils {
    static {
    }

    public static List a(JSONObject r100) {
        if (r100 == null) goto L4;
        Object r101 = r100.opt("__applog_cp_ids");
        if (r101 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if ((r101 instanceof String) == false) goto L19;
        if (((CharSequence) r101).length() <= 0) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L19;
        return CollectionsKt.listOf(r101);
    L14:
        r102 = false;
    L19:
        if ((r101 instanceof JSONArray) == false) goto L21;
        JSONArray r103 = (JSONArray) r101;
    L22:
        if (r103 == null) goto L24;
        ArrayList r104 = new ArrayList(r103.length());
        int r105 = r103.length();
        int r106 = 0;
    L26:
        if (r106 >= r105) goto L36;
        Object r107 = r103.opt(r106);
        if ((r107 instanceof String) == false) goto L35;
        if (((CharSequence) r107).length() <= 0) goto L32;
        boolean r108 = true;
    L33:
        if (r108 == false) goto L35;
        r104.add(r107);
        goto L35
    L32:
        r108 = false;
    L35:
        r106 = r106 + 1;
        goto L26
    L36:
        return r104;
    L24:
        return CollectionsKt.emptyList();
    L21:
        r103 = null;
        goto L22
    L4:
        return CollectionsKt.emptyList();
    }

    public static Sequence b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return SequencesKt.sequence(new JsonUtils$keysOf$1(r100, null));
    }
}
