package com.bytedanceos.common.ad.entity.rep;

import com.bytedanceos.common.ad.entity.rep.media.RepMediaEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepAdsEntity<M extends RepMediaEntity> extends RepBaseAdEntity {

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private List<RepAdEntity<M>> f9584ad;

    public RepAdsEntity() {
    }

    public List<RepAdEntity<M>> getAd() {
        return this.f9584ad;
    }

    public void setAd(List<RepAdEntity<M>> r10) {
        this.f9584ad = r10;
    }
}
