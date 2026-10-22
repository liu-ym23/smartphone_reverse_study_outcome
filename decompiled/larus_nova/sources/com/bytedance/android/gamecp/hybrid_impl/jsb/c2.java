package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gameCpOpenGame")
public final class c2 extends h<d2, e2> {

    public static final class a {
    }

    static {
    }

    public c2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        d2 r102 = (d2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gameCpOpenGame", GsonProtectorUtils.toJson(new Gson(), r102));
        String r103 = r102.a();
        Context r104 = r101.getContext();
        int r105 = 0;
        if (r103 != null) goto L5;
    L19:
        e2 r106 = new e2();
        r106.a(Integer.valueOf(r105));
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L5:
        if (r103.length() <= 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == false) goto L19;
        r104.getPackageManager().getPackageInfo(r103, 1);     // Catch: PackageManager.NameNotFoundException -> L11
        boolean r109 = true;
    L12:
        if (r109 == false) goto L19;
        Intent r110 = r104.getPackageManager().getLaunchIntentForPackage(r103);     // Catch: Exception -> L17
        if (r110 == null) goto L19;
        r110.setFlags(268435456);     // Catch: Exception -> L17
        r104.startActivity(r110);     // Catch: Exception -> L17
        r105 = 1;
    L17:
        e = move-exception;
        Logger.e("game-promote", "JSB open game error");
        e.printStackTrace();
    L11:
        r109 = false;
        goto L12
    L7:
        r108 = false;
        goto L8
    }
}
