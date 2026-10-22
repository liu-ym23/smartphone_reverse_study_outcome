package com.bytedance.android.ec.window.base.common.starter;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class f {
    public static /* synthetic */ void b(xn.b r100, Context r110, String r111, String r112, JSONObject r113, Map r114, String r115) {
        r100.c(r110, r111, r112, r113, r114, r115, null, false);
    }

    public static /* synthetic */ void a(xn.b r310, Context r311, String r312, String r313, String r314, String r315, String r316, String r317, Integer r410, String r411, String r412, String r413, String r414, JSONObject r415, String r416, boolean r417, String r418, long r419, Map r510, String r511, String r512, String r513, int r514) {
        if ((r514 & 2048) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r514 & 4096) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r514 & 8192) == 0) goto L13;
        JSONObject r112 = null;
    L15:
        if ((32768 & r514) == 0) goto L17;
        boolean r113 = true;
    L19:
        if ((131072 & r514) == 0) goto L21;
        String r210 = null;
    L23:
        if ((524288 & r514) == 0) goto L25;
        Boolean r211 = Boolean.FALSE;
    L27:
        if ((1048576 & r514) == 0) goto L29;
        Map r212 = null;
    L31:
        if ((2097152 & r514) == 0) goto L33;
        String r213 = null;
    L35:
        if ((4194304 & r514) == 0) goto L37;
        String r214 = null;
    L39:
        if ((r514 & 67108864) == 0) goto L41;
        String r318 = null;
    L42:
        r310.b(r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r110, r111, r112, r416, r113, null, r210, r419, r211, r212, r213, r214, null, null, null, r318, null);
        return;
    L41:
        r318 = r513;
        goto L42
    L37:
        r214 = r512;
        goto L39
    L33:
        r213 = r511;
        goto L35
    L29:
        r212 = r510;
        goto L31
    L25:
        r211 = null;
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
