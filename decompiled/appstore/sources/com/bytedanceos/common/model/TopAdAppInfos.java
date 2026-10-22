package com.bytedanceos.common.model;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TopAdAppInfos implements IAppExtra {
    private List<TopAdAppInfo> topAdAppInfos;

    public TopAdAppInfos() {
    }

    @Override // com.bytedanceos.common.model.IAppExtra
    public int getItemType() {
        return 3;
    }

    public List<TopAdAppInfo> getTopAdAppInfos() {
        return this.topAdAppInfos;
    }

    public void setTopAdAppInfos(List<TopAdAppInfo> r10) {
        this.topAdAppInfos = r10;
    }

    public TopAdAppInfos(List<TopAdAppInfo> r10) {
        this.topAdAppInfos = r10;
    }
}
