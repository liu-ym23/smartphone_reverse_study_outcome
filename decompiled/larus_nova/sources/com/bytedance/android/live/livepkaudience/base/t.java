package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f81565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f81566b;

    public t(String r100, long r101) {
        this.f81565a = r100;
        this.f81566b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        ExtraResponse r111 = (ExtraResponse) r110;
        String r112 = this.f81565a;
        long r100 = this.f81566b;
        long r101 = System.currentTimeMillis() - r100;
        dl0.m r102 = dl0.m.f469074a;
        Intrinsics.checkNotNullParameter(r112, "token");
        JSONObject r103 = new JSONObject();
        BaseMonitor.add(r103, "token", r112);
        dl0.m.f469074a.getClass();
        dl0.m.z("audience_notify_join_rtc", 0, "", r101, r103);
    }
}
