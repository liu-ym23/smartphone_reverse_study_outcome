package com.bytedanceos.common.eventbus;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubListEvent extends BaseEvent {
    private List dataList;
    private boolean hasSubscribe;

    public GameSubListEvent() {
    }

    public List getDataList() {
        return this.dataList;
    }

    public boolean isHasSubscribe() {
        return this.hasSubscribe;
    }

    public void setDataList(List r10) {
        this.dataList = r10;
    }

    public void setHasSubscribe(boolean r10) {
        this.hasSubscribe = r10;
    }
}
