package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import com.bytedance.android.livesdk.chatroom.model.interact.j2;
import com.bytedance.android.livesdk.link.model.bridge.m2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f75875a = 0;

    static {
    }

    public static String a(int r110) {
        tc0.c r100 = tc0.c.h();
        Map<Long, String> r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f545356m;
    L6:
        tc0.c r103 = tc0.c.h();
        if (r103 == null) goto L13;
        u1 r104 = r103.f545361r;
        if (r104 == null) goto L13;
        m2 r105 = r104.getVideoPositionLiveCoreInfo();
        if (r105 == null) goto L13;
        r101 = r105.getLiveCoreInfoMap();
    L13:
        if (r101 == null) goto L33;
        Iterator<T> r106 = r101.keySet().iterator();
        long r107 = -1;
    L16:
        if (r106.hasNext() == false) goto L23;
        long r108 = ((Number) r106.next()).longValue();
        if (r110 < r108) goto L16;
        if (r108 <= r107) goto L16;
        r107 = r108;
        goto L16
    L23:
        if (r107 > (-1)) goto L25;
        return r102;
    L25:
        return r101.get(Long.valueOf(r107));
    L33:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static String b(int r110) {
        tc0.c r100 = tc0.c.h();
        Map<Long, String> r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f545354k;
    L6:
        tc0.c r103 = tc0.c.h();
        if (r103 == null) goto L13;
        v1 r104 = r103.f545357n;
        if (r104 == null) goto L13;
        j2 r105 = r104.getVideoPositionRtcInfo();
        if (r105 == null) goto L13;
        r101 = r105.getRtcInfoMap();
    L13:
        if (r101 == null) goto L33;
        Iterator<T> r106 = r101.keySet().iterator();
        long r107 = -1;
    L16:
        if (r106.hasNext() == false) goto L23;
        long r108 = ((Number) r106.next()).longValue();
        if (r110 < r108) goto L16;
        if (r108 <= r107) goto L16;
        r107 = r108;
        goto L16
    L23:
        if (r107 > (-1)) goto L25;
        return r102;
    L25:
        return r101.get(Long.valueOf(r107));
    L33:
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
