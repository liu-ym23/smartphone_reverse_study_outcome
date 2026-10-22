package com.byted.cast.common.api.inner;

import com.byted.cast.common.api.IBrowseListener;

/* JADX INFO: loaded from: classes39.dex */
public final class ErrorCodeUtils {
    public ErrorCodeUtils() {
    }

    public static int generateBrowseErrorCode(int r100) {
        if (r100 != 1) goto L5;
        return 17100001;
    L5:
        if (r100 != 2) goto L7;
        return 17100002;
    L7:
        if (r100 != 4) goto L9;
        return 17100001;
    L9:
        if (r100 == 6) goto L11;
        return r100;
    L11:
        return IBrowseListener.ERROR_CODE_GOOGLECAST_UNSUPPORTED_DEVICE;
    }

    public static String generateBrowseErrorMsg(int r100) {
        if (r100 != 1) goto L5;
        return IBrowseListener.BROWSE_MSG_SUCCESS;
    L5:
        if (r100 != 2) goto L7;
        return IBrowseListener.BROWSE_MSG_STOP;
    L7:
        if (r100 == 6) goto L10;
        return "";
    L10:
        return IBrowseListener.ERROR_MSG_GOOGLECAST_UNSUPPORTED_DEVICE;
    }
}
