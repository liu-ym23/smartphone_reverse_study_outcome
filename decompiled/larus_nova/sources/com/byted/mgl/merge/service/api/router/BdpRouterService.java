package com.byted.mgl.merge.service.api.router;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.serviceapi.hostimpl.router.listener.BdpScanCodeCallback;
import mb4.a;
import mb4.b;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpRouterService extends IBdpService {
    void jumpToWebView(Context r100, String r101, String r102, boolean r103);

    void openChooseAddress(Activity r100, String r101, a r102);

    void openChooseAddress(Activity r100, a r101);

    boolean openCustomerService(Context r100, String r101);

    void openMarket(Context r100, String r101, b r102);

    boolean openProfile(Activity r100, String r101, String r102, String r103);

    void openScanCode(Activity r100, BdpScanCodeCallback r101);

    boolean openSchema(Activity r100, String r101, String r102);

    boolean openSchema(Context r100, String r101);

    boolean openVideoView(Activity r100, String r101);

    boolean openWebBrowser(Context r100, String r101, boolean r102);

    boolean supportCustomerService();
}
