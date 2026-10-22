package com.bytedance.android.livesdk.interactivity.common.utils;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f136568a = 0;

    static {
    }

    @JvmStatic
    public static final void c(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("enable", String.valueOf(r100));
        j0.l().sendLog("livesdk_live_contour_enable", r101, new Object[]{new x(), IRoom.class});
    }

    @JvmStatic
    public static final void a(Long r100, Long r101) {
        HashMap r102 = new HashMap();
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        String r103 = "";
    L14:
        r102.put("trigger_type", r103);
        r102.put("duration", String.valueOf(r101));
        j0.l().sendLog("livesdk_comment_carnival_loading_time", r102, new Object[]{new x(), IRoom.class});
        return;
    L11:
        if (r100.longValue() != 2) goto L13;
        r103 = "setting";
        goto L14
    L6:
        if (r100.longValue() != 1) goto L8;
        r103 = "prop";
        goto L14
    }

    @JvmStatic
    public static final void b(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100, String r101, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r101, "carnivalType");
        Intrinsics.checkNotNullParameter(r110, "extra");
        HashMap r102 = new HashMap();
        if (r100 == null) goto L5;
        Long r103 = Long.valueOf(r100.h());
    L6:
        if (r103 != null) goto L9;
    L11:
        if (r103 != null) goto L14;
    L16:
        String r104 = "";
    L17:
        r102.put("trigger_type", r104);
        if (r100 == null) goto L20;
        Long r105 = Long.valueOf(r100.getMessageId());
    L21:
        r102.put("comment_carnival_ID", String.valueOf(r105));
        if (r100 == null) goto L26;
        Map<String, String> r106 = r100.f();
        if (r106 == null) goto L26;
        r102.putAll(r106);
    L26:
        r102.put("carnival_type", r101);
        if ((!r110.isEmpty()) == true) goto L30;
        r110 = null;
    L30:
        if (r110 == null) goto L32;
        r102.putAll(r110);
    L32:
        j0.l().sendLog("livesdk_comment_carnival_start_show", r102, new Object[]{new x(), IRoom.class});
        return;
    L20:
        r105 = null;
        goto L21
    L14:
        if (r103.longValue() != 2) goto L16;
        r104 = "setting";
        goto L17
    L9:
        if (r103.longValue() != 1) goto L11;
        r104 = "prop";
        goto L17
    L5:
        r103 = null;
        goto L6
    }
}
