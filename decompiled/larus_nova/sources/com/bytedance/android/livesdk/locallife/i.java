package com.bytedance.android.livesdk.locallife;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f153265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153266b;

    @Override // com.bytedance.android.livesdk.locallife.c
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeExtraInfoJson");
        if (this.f153266b == false) goto L5;
        String r101 = "1";
    L6:
        r100.put("first_inner_item", r101);
        String r102 = this.f153265a;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        this.f153265a = r100.optString("initial_recommend_info", "");
    L15:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f153265a);
        return;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = "0";
        goto L6
    }

    public i(String r100, boolean r101) {
        this.f153265a = r100;
        this.f153266b = r101;
    }
}
