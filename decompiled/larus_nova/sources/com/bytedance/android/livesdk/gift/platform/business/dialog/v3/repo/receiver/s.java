package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f128500a = null;

    static {
        f128500a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.gift.platform.core.b0 r101 = com.bytedance.android.livesdk.gift.platform.core.b0.f130471a;
        String r102 = ((Throwable) r100).getMessage();
        if (r102 != null) goto L5;
        r102 = "response is empty";
    L5:
        JSONObject r103 = new JSONObject();
        j01.d.b(r103, "error_msg", r102);
        com.bytedance.android.livesdk.gift.platform.core.b0.c(r101, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_group_live_list_sync_failed"), r103, 1);
        j01.d.b(r103, "duration", 0L);
        com.bytedance.android.livesdk.gift.platform.core.b0.c(r101, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_group_live_list_sync_failed"), r103, 1);
    }
}
