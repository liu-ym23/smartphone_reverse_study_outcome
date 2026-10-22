package com.bytedance.android.livesdk.locallife;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153263b;

    @Override // com.bytedance.android.livesdk.locallife.d
    public final void handle(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeExtraInfoMap");
        if (this.f153262a == true) goto L5;
    L7:
        String r101 = "0";
    L8:
        r100.put("life_is_ad", r101);
        return;
    L5:
        if (this.f153263b == false) goto L7;
        r101 = "1";
        goto L8
    }

    public f(boolean r100, boolean r101) {
        this.f153262a = r100;
        this.f153263b = r101;
    }
}
