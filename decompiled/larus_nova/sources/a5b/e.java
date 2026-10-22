package a5b;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class e {
    public static final String d(Object r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (Intrinsics.areEqual(r110, JSONObject.NULL) == false) goto L7;
        return null;
    L7:
        if ((r110 instanceof String) == false) goto L11;
        return (String) r110;
    L11:
        if ((r110 instanceof JSONArray) == false) goto L21;
        JSONArray r111 = (JSONArray) r110;
        IntRange r100 = RangesKt.until(0, r111.length());
        ArrayList r101 = new ArrayList();
        Iterator<Integer> r102 = r100.iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        String r103 = d(r111.opt(((IntIterator) r102).nextInt()));
        if (r103 == null) goto L14;
        r101.add(r103);
        goto L14
    L19:
        return CollectionsKt.joinToString$default(r101, "\n", null, null, 0, null, null, 62, null);
    L21:
        if ((r110 instanceof JSONObject) == false) goto L27;
        return ((JSONObject) r110).toString(2);
    L25:
        return ((JSONObject) r110).toString();
    L27:
        return r110.toString();
    }

    public static final String a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "eventContent");
        String r102 = c(r100, new String[]{"delta", "text", "content_delta", "args_delta"});
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return r101;
    L9:
        return r102;
    L5:
        r103 = false;
        goto L6
    }

    public static final Object b(JSONObject r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "keys");
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L14;
        String r104 = r101[r103];
        if (r100.has(r104) == true) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        Object r105 = r100.opt(r104);
        if (r105 != null) goto L10;
        return null;
    L10:
        if ((!Intrinsics.areEqual(r105, JSONObject.NULL)) == true) goto L12;
        return null;
    L12:
        return r105;
    L14:
        return null;
    }

    public static final String c(JSONObject r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "keys");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        String r104 = r101[r103];
        if (r100.has(r104) == false) goto L14;
        if (r100.isNull(r104) == true) goto L14;
        String r105 = r100.optString(r104);
        Intrinsics.checkNotNull(r105);
        if (r105.length() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        return r105;
    L11:
        r106 = false;
    L14:
        r103 = r103 + 1;
        goto L3
    L15:
        return "";
    }
}
