package com.bytedance.android.gamecp.business.gamedetail.component.lynx;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.common.utils.c1;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import wu.f3;

/* JADX INFO: loaded from: classes44.dex */
public final class j {
    public static final String b(String r110, g r111) {
        if (r110 != null) goto L5;
        return "";
    L5:
        if (r111 == null) goto L10;
        String r100 = r111.f54504f;
        if (r100 == null) goto L10;
        String r101 = r100;
    L11:
        if (r111 == null) goto L16;
        String r102 = r111.f54505g;
        if (r102 == null) goto L16;
        String r103 = r102;
    L17:
        if (r111 == null) goto L22;
        String r104 = r111.f54506h;
        if (r104 == null) goto L22;
        String r105 = r104;
    L23:
        if (r111 == null) goto L26;
        String r106 = String.valueOf(r111.f54509k);
        if (r106 == null) goto L26;
    L27:
        String r107 = r106;
        if (r111 == null) goto L30;
        String r108 = r111.f54507i;
    L31:
        String r109 = r108;
        if (r111 == null) goto L35;
        String r112 = r111.f54508j;
        if (r112 == null) goto L35;
    L36:
        String r113 = r112;
        if (r111 == null) goto L42;
        String r114 = r111.f54510l;
        if (r114 == null) goto L42;
        String r115 = r114;
    L43:
        if (r111 == null) goto L48;
        String r116 = r111.f54511m;
        if (r116 == null) goto L48;
        String r117 = r116;
    L50:
        return a(r110, r101, r103, r105, r107, r109, r113, r115, r117);
    L48:
        r117 = "";
    L42:
        r115 = "";
    L35:
        r112 = SliceInitService.DEFAULT_SWITCH;
        goto L36
    L30:
        r108 = null;
    L26:
        r106 = "0";
    L22:
        r105 = "";
    L16:
        r103 = "";
    L10:
        r101 = "";
        goto L11
    }

    public static final String a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "schemaString");
        Intrinsics.checkNotNullParameter(r101, "promoterId");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        Intrinsics.checkNotNullParameter(r103, "gameName");
        Intrinsics.checkNotNullParameter(r104, "scene");
        Intrinsics.checkNotNullParameter(r106, "reportParams");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r111, "videoId");
        HashMap r107 = new HashMap();
        r107.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r101);
        r107.put("game_id", r102);
        r107.put(EventConstants.ExtraJson.GAME_NAME, r103);
        r107.put("scene", r104);
        if (f3.f561309a.getValue().booleanValue() == false) goto L5;
        r107.put("report_params", c1.d(r106));
    L5:
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        r107.put("enter_from", r105);
        r107.put("room_id", r110);
        r107.put("video_id", r111);
        return c1.c(r100, r107);
    }
}
