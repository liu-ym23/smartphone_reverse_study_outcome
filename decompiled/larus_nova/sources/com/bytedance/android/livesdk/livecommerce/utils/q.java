package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153109a = 0;

    static {
    }

    public static gl.a a(EnumEntranceInfoScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        int r102 = ECSdk.f48106a;
        IEntranceInfoService r103 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.initEntranceInfo(new EntranceInfoScene("ecomLive", r100.getValue()), r101);
    }
}
