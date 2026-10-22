package com.byted.mgl.merge.service.api.host;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.serviceapi.hostimpl.aweme.a;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpGameVideoService extends IBdpService {
    public static final int FEATURE_INTERTRUST_DRM = 241;
    public static final int FEATURE_SUPPORT_BASH = 243;
    public static final int FEATURE_SUPPORT_DASH = 242;

    BdpGameVideoEditor getVideoEditor(Context r100, String r101);

    boolean queryVideoFeature(int r100);

    void uploadDouyinVideo(Activity r100, Object r101, Object r102, a r103);
}
