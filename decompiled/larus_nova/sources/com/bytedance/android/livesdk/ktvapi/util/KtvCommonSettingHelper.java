package com.bytedance.android.livesdk.ktvapi.util;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class KtvCommonSettingHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f142336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f142337b = null;

    public KtvCommonSettingHelper() {
    }

    static {
        f142336a = LazyKt.lazy(KtvCommonSettingHelper$LIVE_VIDEO_CHORUS_FEATURE_ENABLE$2.INSTANCE);
        f142337b = LazyKt.lazy(KtvCommonSettingHelper$LIVE_VIDEO_CHORUS_FEATURE_ANCHOR_ENABLE$2.INSTANCE);
    }

    public static boolean b() {
        if (((Boolean) f142337b.getValue()).booleanValue() == false) goto L5;
        return true;
    L5:
        Room r100 = m.i().getCurrentRoom();
        String r101 = null;
        if (r100 != null) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        r101 = r100.getAnchorAbValue("video_real_time_chorus");
    L11:
        return Intrinsics.areEqual(r101, "1");
    }

    public static boolean a(Map r100) {
        if (v.a() == false) goto L7;
        return ((Boolean) vm2.d.f555948r1.getValue(null, vm2.d.f555776a[119(0x77, float:1.67E-43)])).booleanValue();
    L7:
        if (((Boolean) vm2.d.f555938q1.getValue(null, vm2.d.f555776a[118(0x76, float:1.65E-43)])).booleanValue() == true) goto L22;
        if (r100 != null) goto L16;
        com.bytedance.live.datacontext.m<IRoom> r101 = m.i().getRoom();
        if (r101 == null) goto L14;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L14;
        r100 = r102.getAnchorABMap();
    L14:
        r100 = null;
    L16:
        if (r100 == null) goto L20;
        String r103 = (String) r100.get("ktv_new_mv");
        if (r103 == null) goto L20;
        int r104 = CastIntegerProtector.parseInt(r103);
    L21:
        if (r104 > 0) goto L22;
        return false;
    L20:
        r104 = 0;
    L22:
        return true;
    }
}
