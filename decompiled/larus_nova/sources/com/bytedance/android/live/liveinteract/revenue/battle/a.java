package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements zt0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f78020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f78021b;

    @Override // zt0.b
    public final void a(String r100) {
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [asyncCrownBeautyEffectId] onSyncSuccess id " + r100);
        int r101 = i.f78024a;
        com.bytedance.android.live.profit.dress.s r102 = (com.bytedance.android.live.profit.dress.s) yt0.c.a().getDressData(r100, 33, "CommonWidgetResouce fetchDressList--onSyncSuccess");
        if (r102 == null) goto L5;
        String r103 = r102.f87162d;
    L7:
        if (r2.a(r103) == false) goto L9;
        Function1 r104 = this.f78020a;
        Intrinsics.checkNotNull(r103);
        r104.invoke(r103);
        return;
    L9:
        ALogger.e("CommonWidgetResouce", "#DressResourceDebug# [asyncCrownBeautyEffectId] onSyncSuccess id " + r100 + ", but effectIdSync is invalid " + r103);
        this.f78021b.invoke(-1, "onSyncSuccess id " + r100 + ", but effectIdSync is invalid " + r103);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public a(Function1 r100, Function2 r101) {
        this.f78020a = r100;
        this.f78021b = r101;
    }

    @Override // zt0.b
    public final void b(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "version");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [asyncCrownBeautyEffectId] onSyncFailed id " + r100);
        this.f78021b.invoke(Integer.valueOf(r102), r103);
    }
}
