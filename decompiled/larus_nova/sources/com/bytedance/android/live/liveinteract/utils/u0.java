package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.livesdk.chatroom.model.interact.j2;
import com.bytedance.android.livesdk.link.model.bridge.m2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78834a = 0;

    static {
    }

    public static String a(int r110, tc0.b r111) {
        Map<Long, String> r100 = null;
        if (r111 == null) goto L5;
        String r101 = r111.getLiveCoreExtInfo();
    L6:
        if (r111 == null) goto L12;
        u1 r112 = r111.getMultiLiveCoreInfo();
        if (r112 == null) goto L12;
        m2 r113 = r112.getVideoPositionLiveCoreInfo();
        if (r113 == null) goto L12;
        r100 = r113.getLiveCoreInfoMap();
    L12:
        if (r100 == null) goto L32;
        Iterator<T> r114 = r100.keySet().iterator();
        long r102 = -1;
    L15:
        if (r114.hasNext() == false) goto L22;
        long r103 = ((Number) r114.next()).longValue();
        if (r110 < r103) goto L15;
        if (r103 <= r102) goto L15;
        r102 = r103;
        goto L15
    L22:
        if (r102 > (-1)) goto L24;
        return r101;
    L24:
        return r100.get(Long.valueOf(r102));
    L32:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public static String b(int r110, tc0.b r111) {
        Map<Long, String> r100 = null;
        if (r111 == null) goto L5;
        String r101 = r111.getRtcExtInfo();
    L6:
        if (r111 == null) goto L12;
        v1 r112 = r111.getMultiRtcInfo();
        if (r112 == null) goto L12;
        j2 r113 = r112.getVideoPositionRtcInfo();
        if (r113 == null) goto L12;
        r100 = r113.getRtcInfoMap();
    L12:
        if (r100 == null) goto L35;
        Iterator<T> r114 = r100.keySet().iterator();
        long r102 = -1;
    L15:
        if (r114.hasNext() == false) goto L22;
        long r103 = ((Number) r114.next()).longValue();
        if (r110 < r103) goto L15;
        if (r103 <= r102) goto L15;
        r102 = r103;
        goto L15
    L22:
        if (r102 <= (-1)) goto L36;
        String r115 = r100.get(Long.valueOf(r102));
        if (r115 != null) goto L27;
        return r101;
    L27:
        return r115;
    L36:
        return r101;
    L35:
        return r101;
    L5:
        r101 = null;
        goto L6
    }
}
