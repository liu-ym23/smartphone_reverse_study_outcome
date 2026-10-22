package com.bytedance.android.shopping.store.tabkit.ssr;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    public static final boolean b(SSRModel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isError");
        if (r100.getErrorCode() != null) goto L15;
        String r101 = r100.getErrorMsg();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    L15:
        return true;
    }

    public static final boolean c(SSRModel r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isHydrateDataValid");
        String r102 = r100.getHydrateData();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L31;
        String r104 = r100.getHydrateUrl();
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L32;
        String r106 = r100.getHydrateHash();
        if (r106 != null) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L33;
        if (r101 == false) goto L28;
    L29:
        return true;
    L28:
        if (r100.getHydrateBytes() != null) goto L29;
        return false;
    L33:
        return false;
    L21:
        if (StringsKt.isBlank(r106) == true) goto L24;
        r107 = false;
        goto L25
    L32:
        return false;
    L13:
        if (StringsKt.isBlank(r104) == true) goto L16;
        r105 = false;
        goto L17
    L31:
        return false;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static final Map<String, String> a(int r100, String r101, Integer r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("ssr_downgrade", "1");
        r103.put("ssr_error_code", String.valueOf(r100));
        if (r101 != null) goto L5;
        r101 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L5:
        r103.put("ssr_error_message", r101);
        if (r102 == null) goto L9;
        String r104 = String.valueOf(r102.intValue());
        if (r104 == null) goto L9;
    L10:
        r103.put("ssr_sub_error_code", r104);
        return r103;
    L9:
        r104 = "";
        goto L10
    }
}
