package com.bytedanceos.common.ad.entity.rep;

import com.bytedanceos.common.ad.entity.rep.media.RepMediaEntity;
import com.bytedanceos.common.toolbox.c;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepAdEntity<M extends RepMediaEntity> {
    private String aid;
    private int cache_time;
    private List<RepCreativeEntity<M>> creative;
    private RepSetEntity set;
    private String tid;

    public RepAdEntity() {
        this.aid = "";
        this.tid = "";
        this.cache_time = 0;
    }

    public String getAid() {
        return this.aid;
    }

    public int getCache_time() {
        return this.cache_time;
    }

    public List<RepCreativeEntity<M>> getCreative() {
        return this.creative;
    }

    public RepSetEntity getSet() {
        RepSetEntity r10 = this.set;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new RepSetEntity();
    }

    public String getTid() {
        return this.tid;
    }

    public boolean isCreativeAvailable() {
        return !c.a(getCreative());
    }

    public void setAid(String r10) {
        this.aid = r10;
    }

    public void setCache_time(int r10) {
        this.cache_time = r10;
    }

    public void setCreative(List<RepCreativeEntity<M>> r10) {
        this.creative = r10;
    }

    public void setSet(RepSetEntity r10) {
        this.set = r10;
    }

    public void setTid(String r10) {
        this.tid = r10;
    }
}
