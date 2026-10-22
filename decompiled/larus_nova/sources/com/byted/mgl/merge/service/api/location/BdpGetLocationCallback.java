package com.byted.mgl.merge.service.api.location;

import com.byted.mgl.merge.service.model.BdpLocation;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpGetLocationCallback {
    void onFail(String r100);

    void onSuccess(BdpLocation r100);
}
