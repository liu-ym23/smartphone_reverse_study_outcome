package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f174614a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174614a.optString("cid");
        String r101 = this.f174614a.optString("log_extra");
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r102 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("cid", r100, r102);
        appendParam("value", r100, r102);
        appendParam("log_extra", r101, r102);
        appendParam("is_ad_event", "1", r102);
        appendParam("category", "umeng", r102);
        appendParam("nt", "4", r102);
        appendParam("tag", "draw_ad", r102);
    }

    public b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "enterInfo");
        super("otherclick");
        this.f174614a = r100;
    }
}
