package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.Image")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageModelLive extends ImageModel {
    public ImageModelLive() {
    }

    public ImageModelLive(am3.g r100) {
        this.urls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.urls.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.uri = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._height = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._width = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
