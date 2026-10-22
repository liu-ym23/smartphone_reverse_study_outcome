package com.bytedance.android.livesdk.livecommerce.event;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class j0 extends ECEventV3 {

    public static final class a {
    }

    static {
    }

    public j0(String r100) {
        super(r100);
        String r101 = l0.i("room_id");
        String r102 = l0.i("room_unique_key");
        f("enter_method", l0.e());
        f("anchor_id", l0.i("anchor_id"));
        f("room_id", r101);
        f("action_type", l0.i("action_type"));
        f("request_id", l0.i("request_id"));
        f("enter_from_merge", l0.i("enter_from_merge"));
        f("follow_status", l0.i("follow_status"));
        f("screen_type", l0.m(r101, r102));
        f("group_id", l0.i("group_id"));
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, l0.i("group_type"));
        f("enter_from", "live");
        f(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
    }

    public final void n(Map r100) {
        if (r100 == null) goto L7;
        Iterator r101 = r100.entrySet().iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        f((String) r102.getKey(), (String) r102.getValue());
        goto L5
    L9:
        return;
    }
}
