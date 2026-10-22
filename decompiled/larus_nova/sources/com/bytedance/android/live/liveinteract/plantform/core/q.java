package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f76310a;

    public q(String r100) {
        this.f76310a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        String r102 = this.f76310a;
        int r103 = com.bytedance.android.live.liveinteract.plantform.utils.x.f77572a;
        Intrinsics.checkNotNullParameter(r102, "token");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("token", r102);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("notify_join_rtc_success", r104);
    }
}
