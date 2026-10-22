package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService;
import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import xr.q;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements IGameCPWhiteBoxTestService {
    public e() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService
    public final void executeToolbarCase() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L8;
        q r101 = r100.getWhiteBoxTestService();
        if (r101 == null) goto L9;
        r101.executeToolbarCase();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService
    public final void unRegisterToolbarCase() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L8;
        q r101 = r100.getWhiteBoxTestService();
        if (r101 == null) goto L9;
        r101.unRegisterToolbarCase();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService
    public final void enterScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L8;
        q r102 = r101.getWhiteBoxTestService();
        if (r102 == null) goto L9;
        r102.K0();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService
    public final void exitScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L8;
        q r102 = r101.getWhiteBoxTestService();
        if (r102 == null) goto L9;
        r102.s();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService
    public final void registerToolbarCase(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L8;
        q r102 = r101.getWhiteBoxTestService();
        if (r102 == null) goto L9;
        r102.v0();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService
    public final void onFail(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r101, "content");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        q r103 = r102.getWhiteBoxTestService();
        if (r103 == null) goto L9;
        r103.onFail();
        return;
    L9:
        return;
    }
}
