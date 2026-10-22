package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import fr2.v;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class AnchorContextBuilder extends BaseContextBuilder {
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.i A;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.g B;
    public sc0.c C;
    public Function0<? extends v> D;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.f E;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.k F;
    public boolean G;
    public boolean H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<Long, String> f98621v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<Long, String> f98622w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<Long, String> f98623x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<Long, String> f98624y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public sc0.a f98625z;

    public AnchorContextBuilder() {
        this.f98621v = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.f98622w = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.f98623x = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.f98624y = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        this.D = AnchorContextBuilder$liveVideoClientFactoryGetter$1.INSTANCE;
        this.H = true;
    }
}
