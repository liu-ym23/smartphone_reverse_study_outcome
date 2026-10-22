package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f60230a = null;

    static {
        f60230a = new g0();
    }

    public g0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        int r103 = 1;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenEntranceMessageSender", new Object[]{"on app/start response", ", logId: ", r101.logId, ", status: ", Integer.valueOf(r101.statusCode)});
        if (r101.statusCode == 0) goto L13;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r104 = AnchorGameContext.a.a();
        if (r104 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.isRequsetingAppStart();
        if (r105 == null) goto L10;
        r105.setValue(Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r101.ttStable, "1") == false) goto L25;
        r103 = 2;
    L25:
        return new com.bytedance.android.live.broadcastgame.j0(r103, String.valueOf(r101.statusCode));
    L13:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r106 = AnchorGameContext.a.a();
        if (r106 == null) goto L18;
        com.bytedance.live.datacontext.m<String> r107 = r106.getOpenGameStartId();
        if (r107 == null) goto L18;
        r107.setValue(((com.bytedance.android.live.broadcastgame.opengame.network.v) r101.data).b());
    L18:
        AnchorGameContext r108 = AnchorGameContext.a.a();
        if (r108 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r109 = r108.isRequsetingAppStart();
        if (r109 == null) goto L24;
        r109.setValue(Boolean.FALSE);
    L24:
        return new com.bytedance.android.live.broadcastgame.j0();
    }
}
