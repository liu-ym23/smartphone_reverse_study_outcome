package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f89721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f89722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f89723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Entrance f89724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FetchFrom f89725e;

    public m(long r100, Entrance r101, FetchFrom r102) {
        Intrinsics.checkNotNullParameter(r101, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r102, "fetchFrom");
        this.f89723c = r100;
        this.f89724d = r101;
        this.f89725e = r102;
        this.f89721a = new HashMap();
        this.f89722b = new HashMap();
    }
}
