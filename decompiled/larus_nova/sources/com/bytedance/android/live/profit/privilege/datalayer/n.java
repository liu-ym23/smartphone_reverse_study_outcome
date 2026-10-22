package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Long f88407b;

    public n(d r100, Long r101) {
        this.f88406a = r100;
        this.f88407b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        com.bytedance.android.live.profit.privilege.e r102 = com.bytedance.android.live.profit.privilege.e.f88414a;
        String r103 = this.f88406a.f();
        long r104 = this.f88406a.d();
        Long r105 = this.f88407b;
        Intrinsics.checkNotNullParameter(r103, "userId");
        JSONObject r106 = com.bytedance.android.live.profit.privilege.e.k(true, null, null);
        JSONObject r107 = com.bytedance.android.live.profit.privilege.e.m(r102, Long.valueOf(r104), 4);
        if (r105 == null) goto L5;
        long r108 = r105.longValue();
    L6:
        com.bytedance.android.live.profit.privilege.e.t(r107, "meta_id", Long.valueOf(r108));
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_ack_entrance_status_all", r106, null, r107);
        return;
    L5:
        r108 = 0;
        goto L6
    }
}
