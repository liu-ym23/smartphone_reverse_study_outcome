package com.bytedance.android.livesdk.livecommerce.event;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class v0 extends ECEventV3 {
    public final void o() {
        Intrinsics.checkNotNullParameter("live_ad", "tag");
        d("is_ad_event", 1);
        f("category", "umeng");
        f("tag", "live_ad");
    }

    public v0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }

    public final void n(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), (String) r103.getValue());
        goto L4
    L6:
        f("ad_extra_data", r101.toString());
    }
}
