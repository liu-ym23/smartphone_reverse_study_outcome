package com.bytedance.android.live.revlink.link.domain.streammix;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static final void a(d r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$writeToAnchorSeiInfo");
        Intrinsics.checkNotNullParameter(r101, "anchorSeiInfo");
        r101.put("mix_owner_index", r100.f98559b);
        JSONObject r102 = new JSONObject();
        r102.put("x", Float.valueOf(r100.f98560c.left));
        r102.put("y", Float.valueOf(r100.f98560c.top));
        r102.put("w", Float.valueOf(r100.f98560c.width()));
        r102.put("h", Float.valueOf(r100.f98560c.height()));
        Unit r103 = Unit.INSTANCE;
        r101.put("content", r102);
    }
}
