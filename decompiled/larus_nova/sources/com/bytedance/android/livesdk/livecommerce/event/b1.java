package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class b1 extends ECEventV3 {
    public b1() {
        super("livesdk_ecom_live_params_log");
        f("enter_from_merge", l0.i("enter_from_merge"));
        f("enter_method", l0.e());
        f("action_type", l0.i("action_type"));
        f("enter_from", "live");
        f(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
    }
}
