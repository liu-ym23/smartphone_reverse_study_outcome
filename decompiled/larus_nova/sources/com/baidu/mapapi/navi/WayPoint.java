package com.baidu.mapapi.navi;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class WayPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<WayPointInfo> f31698a;

    public List<WayPointInfo> getViaPoints() {
        return this.f31698a;
    }

    public WayPoint(List<WayPointInfo> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.f31698a = r100;
    }
}
