package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.text.TextUtils;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gameCpAnchorPrivacy")
public final class v1 extends g<x1, GameCpAnchorPrivacyResultModel> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        x1 r102 = (x1) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gameCpAnchorPrivacy", GsonProtectorUtils.toJson(new Gson(), r102));
        if (r102.a() != null) goto L5;
    L8:
        finishWithFailure(new IllegalArgumentException("param invalid"));
    L9:
        Room r103 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r103 == null) goto L12;
    L14:
        Boolean r104 = null;
        if (r103 == null) goto L19;
        Long r105 = r103.getRoomId();
        if (r105 == null) goto L19;
        String r106 = String.valueOf(r105.longValue());
    L20:
        boolean r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().isAnchor();
        if (r103 == null) goto L23;
        String r108 = r103.getOwnerUserId();
    L24:
        if (r103 == null) goto L27;
        r104 = r103.isScreenRecord();
    L27:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == true) goto L33;
        if (r107 == false) goto L33;
        if (TextUtils.equals(r106, r102.b()) == false) goto L33;
        if (TextUtils.equals(r108, r102.a()) == false) goto L33;
    L34:
        Integer r109 = r102.c();
        if (r109 != null) goto L38;
    L40:
        if (r109 != null) goto L43;
    L45:
        finishWithFailure(new IllegalArgumentException("status must be 1 or 0"));
        return;
    L43:
        if (r109.intValue() != 0) goto L45;
        Logger.d("game-promote", "JSB 关闭隐私模式");
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().R0(new w1());
        return;
    L38:
        if (r109.intValue() != 1) goto L40;
        Logger.d("game-promote", "JSB 开启隐私模式");
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().gamePrivacyMonitorEnsureRelease();
        com.bytedance.android.gamecp.host_api.a.b().getLiveService().pauseLive();
        GameCpAnchorPrivacyResultModel r110 = new GameCpAnchorPrivacyResultModel();
        r110.a(GameCpAnchorPrivacyResultModel.Code.Success);
        Unit r111 = Unit.INSTANCE;
        finishWithResult(r110);
        return;
    L33:
        GameCpAnchorPrivacyResultModel r112 = new GameCpAnchorPrivacyResultModel();
        r112.a(GameCpAnchorPrivacyResultModel.Code.Failed);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        Logger.d("game-promote", "JSB 非法调用，不开启隐私模式");
        goto L34
    L23:
        r108 = null;
    L19:
        r106 = null;
        goto L20
    L12:
        if (cs.a.a() == false) goto L14;
        LocalTestManager.a(new Class[]{uv.a.class});
        goto L14
    L5:
        if (r102.b() == null) goto L8;
        if (r102.c() != null) goto L9;
        goto L8
    }
}
