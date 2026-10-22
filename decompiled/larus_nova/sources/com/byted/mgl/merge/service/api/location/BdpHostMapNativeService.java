package com.byted.mgl.merge.service.api.location;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpHostMapNativeService extends IBdpService {
    boolean chooseLocation(Activity r100, BdpGetLocationCallback r101);

    boolean openLocation(Activity r100, String r101, String r102, double r103, double r104, int r105, String r106);
}
