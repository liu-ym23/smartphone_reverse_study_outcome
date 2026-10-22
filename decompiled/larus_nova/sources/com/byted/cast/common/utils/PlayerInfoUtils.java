package com.byted.cast.common.utils;

import android.text.TextUtils;
import com.byted.cast.common.api.PlayerInfo;
import com.byted.cast.common.bean.XiguaBdLinkUriInfo;

/* JADX INFO: loaded from: classes39.dex */
public class PlayerInfoUtils {
    public PlayerInfoUtils() {
    }

    public static String getBdLinkUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        XiguaBdLinkUriInfo r101 = (XiguaBdLinkUriInfo) GsonUtils.fromJsonIgnoreException(r100, XiguaBdLinkUriInfo.class);
        if (r101 != null) goto L10;
        return r100;
    L10:
        return r101.getTargetResolutionUrl();
    }

    public static String getUrlByProtocolType(PlayerInfo r100, String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r100.getUrl()) == false) goto L7;
        return "";
    L7:
        return getUrlByProtocolType(r100.getUrl(), r101);
    }

    public static String getUrlByProtocolType(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if ("BDLink".equals(r101) == true) goto L9;
        return r100;
    L9:
        return getBdLinkUrl(r100);
    }
}
