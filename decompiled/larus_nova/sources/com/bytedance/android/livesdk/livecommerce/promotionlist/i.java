package com.bytedance.android.livesdk.livecommerce.promotionlist;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f150905a;

    public i(b r100) {
        this.f150905a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        b.a(this.f150905a, !r100.optBoolean("show"));
    }
}
