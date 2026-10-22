package com.bytedance.android.livesdk.locallife;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f153267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153268b;

    @Override // com.bytedance.android.livesdk.locallife.d
    public final void handle(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeExtraInfoMap");
        if (this.f153268b == false) goto L5;
        String r101 = "1";
    L6:
        r100.put("first_inner_item", r101);
        String r102 = this.f153267a;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L21;
        Object r104 = r100.get("initial_recommend_info");
        if ((r104 instanceof String) == true) goto L17;
        r104 = null;
    L17:
        String r105 = (String) r104;
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        this.f153267a = r105;
    L21:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, this.f153267a);
        return;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = "0";
        goto L6
    }

    public j(String r100, boolean r101) {
        this.f153267a = r100;
        this.f153268b = r101;
    }
}
