package com.bytedance.android.livesdk.livecommerce.room.controller.related;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b {
    public static final void a(JSONObject r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$merge");
        if (r101 == null) goto L11;
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();
        if (r100.has(r104) == false) goto L10;
        if (r102 == false) goto L6;
    L10:
        r100.put(r104, r101.get(r104));
        goto L6
    L18:
        return;
    }
}
