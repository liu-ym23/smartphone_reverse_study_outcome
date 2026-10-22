package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GameGetUserProfileResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import w20.b9;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.getUserProfile")
public final class GameGetUserProfileMethod extends w20.v0<b9, GameGetUserProfileResultModel> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f57453b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f57454a;

    public static final class a {
    }

    static {
    }

    public GameGetUserProfileMethod() {
        this.f57454a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f57454a.dispose();
    }

    public final void j(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        GameGetUserProfileResultModel r102 = new GameGetUserProfileResultModel();
        r102.a(GameGetUserProfileResultModel.Code.Failed);
        r102.c("gameId is null or empty");
        Unit r103 = Unit.INSTANCE;
        finishWithResult(r102);
    L10:
        JSONObject r104 = new JSONObject();
        r104.put("game_id", r100);
        r104.put("user_id", com.bytedance.android.gamecp.host_api.a.b().getUserService().getCurUserId());
        xr.f r105 = (xr.f) xr.s.a(xr.f.class);     // Catch: JSONException -> L17
        if (r105 == null) goto L22;
        Disposable r106 = r105.V0(r104, new GameGetUserProfileMethod$fetchUserPortrait$2(this), new GameGetUserProfileMethod$fetchUserPortrait$3(this));     // Catch: JSONException -> L17
        if (r106 == null) goto L23;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r106, this.f57454a);     // Catch: JSONException -> L17
        return;
    L23:
        return;
    L22:
        return;
    L17:
        e = move-exception;
        GameGetUserProfileResultModel r107 = new GameGetUserProfileResultModel();
        r107.a(GameGetUserProfileResultModel.Code.Failed);
        r107.c(e.getMessage());
        r107.b(new GameGetUserProfileResultModel.a());
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        b9 r102 = (b9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r103 = r102.b();
        String r104 = r102.a();
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L5;
        com.bytedance.android.gamecp.host_api.a.b().getHostBusiness().isEnablePersonalRecommend();
        GameGetUserProfileResultModel r105 = new GameGetUserProfileResultModel();
        r105.a(GameGetUserProfileResultModel.Code.Success);
        r105.b(new GameGetUserProfileResultModel.a());
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L5:
        j(r104);
    }
}
