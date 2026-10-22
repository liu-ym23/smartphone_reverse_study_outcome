package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.OpenMiniAppCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements IGameCpGameService {

    public static final class a implements qv.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenMiniAppCallback f125444a;

        public a(OpenMiniAppCallback r100) {
            this.f125444a = r100;
        }

        @Override // qv.d
        public final void onFail(int r100, String r101) {
            OpenMiniAppCallback r102 = this.f125444a;
            if (r102 == null) goto L6;
            r102.onFail(r100, r101);
            return;
        }
    }

    public f() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService
    public final void preloadMiniGame(String r100) {
        xr.f r101 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r101 == null) goto L8;
        xr.h r102 = r101.getGameService();
        if (r102 == null) goto L9;
        r102.preloadMiniGame(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService
    public final void openExternalBrowser(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        xr.f r103 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r103 == null) goto L8;
        xr.h r104 = r103.getGameService();
        if (r104 == null) goto L9;
        r104.openExternalBrowser(r100, r101, r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService
    public final void preloadInteractGame(String r100, String r101, Function0<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r102, "suc");
        Intrinsics.checkNotNullParameter(r103, "failCheck");
        xr.f r104 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r104 == null) goto L8;
        xr.h r105 = r104.getGameService();
        if (r105 == null) goto L9;
        r105.preloadInteractGame(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService
    public final void openLiveMiniPlay(Context r100, String r101, Map<String, ? extends Object> r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r110, "meta");
        Intrinsics.checkNotNullParameter(r111, "suc");
        Intrinsics.checkNotNullParameter(r112, "failCheck");
        xr.f r102 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r102 == null) goto L8;
        xr.h r103 = r102.getGameService();
        if (r103 == null) goto L9;
        r103.openLiveMiniPlay(r100, r101, r110, r111, r112);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService
    public final void openMiniApp(int r110, String r111, boolean r112, String r113, String r114, Integer r115, OpenMiniAppCallback r116) {
        xr.f r100 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r100 == null) goto L8;
        xr.h r101 = r100.getGameService();
        if (r101 == null) goto L9;
        xr.h.a.a(r101, r110, r111, r112, r113, r114, r115, new a(r116));
        return;
    L9:
        return;
    }
}
