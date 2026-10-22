package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util;

import am3.h;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements am3.c<f> {
    public g() {
    }

    @Override // am3.c
    public final f decode(am3.g r100) throws Exception {
        f r101 = new f();
        r101.vsCameraInfo = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.vsCameraInfo.add((VSCameraInfo) vh7.f.a(r100, VSCameraInfo.class));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.entryLinkRoomTitle = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.multiCameraTitle = h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.entryLinkRoomSubTitle = h.c(r100);
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.multiCameraSubTitle = h.c(r100);
        goto L3
    L15:
        h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }
}
