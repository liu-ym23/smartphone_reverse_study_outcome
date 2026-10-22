package com.bytedance.android.livesdk.revenue.service.hybrid;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements cq2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscriberJsEvent f157345a;

    @Override // cq2.d
    public final String getEventName() {
        return this.f157345a.getEventName();
    }

    @Override // cq2.d
    public final Map<String, Object> getParams() {
        return this.f157345a.getParams();
    }

    public g(SubscriberJsEvent r100) {
        this.f157345a = r100;
    }
}
