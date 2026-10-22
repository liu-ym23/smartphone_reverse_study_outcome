package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements IGameCpLiveService {
    public g() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void injectPreviewData(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "businessBundle");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void injectPreviewToolbarData(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onAnchorPreRequestTransferPage() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onInteractionVisibilityChanged(boolean r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onWebDialogShow(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void reportCardDynamicEvent(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void sendGameCpToolbarCancelEvent(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final String getCurrentGameId() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L8;
        xr.j r101 = r100.getGameCpLiveService();
        if (r101 == null) goto L8;
        String r102 = r101.getCurrentGameId();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final Object getGameCpRoomControllerProvider() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L7;
        xr.j r101 = r100.getGameCpLiveService();
        if (r101 == null) goto L7;
        return r101.getGameCpRoomControllerProvider();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final boolean isCardVisible() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L7;
        xr.j r101 = r100.getGameCpLiveService();
        if (r101 == null) goto L7;
        return r101.isCardVisible();
    L7:
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final boolean isPOI() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L7;
        xr.j r101 = r100.getGameCpLiveService();
        if (r101 == null) goto L7;
        return r101.isPOI();
    L7:
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onAnchorClickToolbarIcon() {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L8;
        xr.j r101 = r100.getGameCpLiveService();
        if (r101 == null) goto L9;
        r101.onAnchorClickToolbarIcon();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void isCleanModeChange(boolean r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L8;
        xr.j r102 = r101.getGameCpLiveService();
        if (r102 == null) goto L9;
        r102.isCleanModeChange(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onOrientationChange(int r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L8;
        xr.j r102 = r101.getGameCpLiveService();
        if (r102 == null) goto L9;
        r102.onOrientationChange(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onCardDataRaw(String r100, long r101) {
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.j r103 = r102.getGameCpLiveService();
        if (r103 == null) goto L9;
        r103.onCardDataRaw(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onMoveToFold(boolean r100, int r101) {
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.j r103 = r102.getGameCpLiveService();
        if (r103 == null) goto L9;
        r103.onMoveToFold(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onReplaceResult(boolean r100, int r101) {
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.j r103 = r102.getGameCpLiveService();
        if (r103 == null) goto L9;
        r103.onReplaceResult(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void setParentView(View r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.j r103 = r102.getGameCpLiveService();
        if (r103 == null) goto L9;
        r103.setParentView(r100, r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void fillGameCpTrackAttrMap(Map<String, String> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "trackAttrMap");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.j r104 = r103.getGameCpLiveService();
        if (r104 == null) goto L9;
        r104.fillGameCpTrackAttrMap(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final Object getPreloadToolbarHandler(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L7;
        xr.j r104 = r103.getGameCpLiveService();
        if (r104 == null) goto L7;
        return r104.getPreloadToolbarHandler(r100, r101, r102);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final Pair<Boolean, Boolean> isGameCpToolbarShowSuccess(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        Boolean r103 = Boolean.FALSE;
        return new Pair(r103, r103);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void onAudienceClickMoreIcon(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.j r104 = r103.getGameCpLiveService();
        if (r104 == null) goto L9;
        r104.onAudienceClickMoreIcon(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void sendResultGameStatus(Context r100, boolean r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.j r105 = r104.getGameCpLiveService();
        if (r105 == null) goto L9;
        r105.sendResultGameStatus(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService
    public final void roomEnterGameCpForPreload(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r110, "eventParams");
        Intrinsics.checkNotNullParameter(r111, "gameId");
        Intrinsics.checkNotNullParameter(r112, "uniqueKey");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.j r103 = r102.getGameCpLiveService();
        if (r103 == null) goto L9;
        r103.roomEnterGameCpForPreload(r100, r101, r110, r111, r112);
        return;
    L9:
        return;
    }
}
