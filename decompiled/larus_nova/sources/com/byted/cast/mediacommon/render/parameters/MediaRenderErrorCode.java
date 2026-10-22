package com.byted.cast.mediacommon.render.parameters;

import com.byted.cast.mediacommon.MediaMonitor;

/* JADX INFO: loaded from: classes39.dex */
public class MediaRenderErrorCode {
    public static int MEDIARENDER_DECODE_ERROR = -1002;
    public static int MEDIARENDER_INIT_ERROR = -1001;
    public static int MEDIARENDER_RENDER_ERROR = -1004;
    public static int MEDIARENDER_SURFACE_ERROR = -1003;

    public MediaRenderErrorCode() {
    }

    public static void onError(String r100, int r101, String r102) {
        int r103 = MEDIARENDER_INIT_ERROR;
        if (r101 != r103) goto L5;
        MediaMonitor.onSinkMonitor("MEDIARENDER_INIT_ERROR", r103, r102, r100);
        return;
    L5:
        int r104 = MEDIARENDER_DECODE_ERROR;
        if (r101 != r104) goto L8;
        MediaMonitor.onSinkMonitor("MEDIARENDER_DECODE_ERROR", r104, r102, r100);
        return;
    L8:
        int r105 = MEDIARENDER_SURFACE_ERROR;
        if (r101 != r105) goto L11;
        MediaMonitor.onSinkMonitor("MEDIARENDER_SURFACE_ERROR", r105, r102, r100);
        return;
    L11:
        int r106 = MEDIARENDER_RENDER_ERROR;
        if (r101 != r106) goto L18;
        MediaMonitor.onSinkMonitor("MEDIARENDER_RENDER_ERROR", r106, r102, r100);
        return;
    }
}
