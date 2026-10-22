package com.bytedance.android.livesdk.locallife;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153261b;

    @Override // com.bytedance.android.livesdk.locallife.c
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeExtraInfoJson");
        if (this.f153260a == true) goto L5;
    L7:
        String r101 = "0";
    L8:
        r100.put("life_is_ad", r101);
        return;
    L5:
        if (this.f153261b == false) goto L7;
        r101 = "1";
        goto L8
    }

    public e(boolean r100, boolean r101) {
        this.f153260a = r100;
        this.f153261b = r101;
    }
}
