package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public final class u {
    public static final boolean b() {
        IMiddlewareHostBusiness r100 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        if (r100 != null) goto L5;
    L7:
        IRoom r101 = a();
        if (r101 == null) goto L15;
        if (r101.isLiveTypeAudio() != true) goto L15;
        if (d51.c.A0.r().Y3() == true) goto L15;
        return false;
    L15:
        return d51.c.A0.r().getEnable();
    L5:
        if (r100.isEnablePersonalRecommend() == true) goto L7;
        return false;
    }

    public static final IRoom a() {
        s r100 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public static final String c() {
        s r100 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public static final long d() {
        s r100 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.d();
    }

    public static final String e() {
        s r100 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e();
    }

    public static final Pair<Integer, Integer> f() {
        com.bytedance.android.live.revenuelink.rtc.f r100 = com.bytedance.android.live.revlink.impl.global.b.d();
        uf2.d0 r101 = null;
        Object r102 = null;
        if (r100 == null) goto L26;
        com.bytedance.android.live.revenuelink.rtc.i r103 = r100.getRtcManager();
        if (r103 == null) goto L26;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r104 = ILiveWrappedLivePusher.a.b();
        if (r104 == null) goto L13;
        vc0.a r105 = r103.getLiveCore();
        if (r105 == null) goto L12;
        r102 = r105.f554079a;
    L12:
        r101 = r104.buildLiveCore(r102);
    L13:
        int r106 = 0;
        if (r101 == null) goto L18;
        uf2.d0.a r107 = r101.getBuilder();
        if (r107 == null) goto L18;
        int r108 = r107.n();
    L19:
        Integer r109 = Integer.valueOf(r108);
        if (r101 == null) goto L25;
        uf2.d0.a r110 = r101.getBuilder();
        if (r110 == null) goto L25;
        r106 = r110.getVideoHeight();
    L25:
        return new Pair(r109, Integer.valueOf(r106));
    L18:
        r108 = 0;
    L26:
        return null;
    }
}
