package com.bytedance.android.ec.store.common.starter;

import android.content.Context;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e {
    public static /* synthetic */ void b(hm.b r110, Context r111, String r112, String r113, JSONObject r114, Map r115, String r116, boolean r117, int r210) {
        if ((r210 & 32) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r210 & 64) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r210 & 256) == 0) goto L13;
        boolean r118 = false;
    L14:
        r110.b(r111, r112, r113, r114, r100, r101, null, r118);
        return;
    L13:
        r118 = r117;
        goto L14
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }

    public static /* synthetic */ void a(hm.b r310, Context r311, String r312, String r313, String r314, String r315, String r316, String r317, Integer r410, String r411, String r412, String r413, String r414, JSONObject r415, String r416, boolean r417, String r418, long r419, Boolean r510, Map r511, String r512, String r513, String r514, String r515, int r516) {
        if ((r516 & 2048) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r516 & 4096) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r516 & 8192) == 0) goto L13;
        JSONObject r112 = null;
    L15:
        if ((32768 & r516) == 0) goto L17;
        boolean r113 = true;
    L19:
        if ((131072 & r516) == 0) goto L21;
        String r210 = null;
    L23:
        if ((524288 & r516) == 0) goto L25;
        Boolean r211 = Boolean.FALSE;
    L27:
        if ((1048576 & r516) == 0) goto L29;
        Map r212 = null;
    L31:
        if ((8388608 & r516) == 0) goto L33;
        String r213 = null;
    L35:
        if ((33554432 & r516) == 0) goto L37;
        String r214 = null;
    L39:
        if ((67108864 & r516) == 0) goto L41;
        String r318 = null;
    L43:
        if ((r516 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L45;
        String r319 = null;
    L46:
        r310.a(r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r110, r111, r112, r416, r113, null, r210, r419, r211, r212, null, null, r213, null, r214, r318, r319);
        return;
    L45:
        r319 = r515;
        goto L46
    L41:
        r318 = r514;
        goto L43
    L37:
        r214 = r513;
        goto L39
    L33:
        r213 = r512;
        goto L35
    L29:
        r212 = r511;
        goto L31
    L25:
        r211 = r510;
        goto L27
    L21:
        r210 = r418;
        goto L23
    L17:
        r113 = r417;
        goto L19
    L13:
        r112 = r415;
        goto L15
    L9:
        r111 = r414;
        goto L11
    L5:
        r110 = r413;
        goto L7
    }
}
