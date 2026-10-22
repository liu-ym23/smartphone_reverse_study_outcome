package com.baidu.naviapi.open;

import com.baidu.naviapi.platform.ex.a;

/* JADX INFO: loaded from: classes39.dex */
public interface IBNAManager {
    void addCallback(INaviMsgCallback r100);

    void clearCallback();

    void exitNavi();

    void removeCallback(INaviMsgCallback r100);

    void routePlan(RoutePlanParam r100, IRouteResult r101) throws a;

    void sendLocData(LocInfo r100) throws a;
}
