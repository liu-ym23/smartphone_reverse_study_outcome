package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.network.preload.PreloadManager;
import com.bytedance.android.gamecp.common.network.preload.PreloadState;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpGetPreloadData")
public final class i4 extends u<m3, GamecpGetPreloadDataResultModel> {

    public static final class a {
    }

    static {
    }

    public i4() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [io.reactivex.Observable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.android.gamecp.hybrid_impl.jsb.l4] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        m3 r112 = (m3) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamecpGetPreloadData", GsonProtectorUtils.toJson(new Gson(), r112));
        yr.c.e("GetPreloadDataMethod", String.valueOf(com.bytedance.android.gamecp.common.utils.e1.a(r112)));
        r111.getContext();
        xr.f r113 = (xr.f) xr.s.a(xr.f.class);
        if (r112.a() != null) goto L5;
    L53:
        finishWithFailure();
        return;
    L5:
        if (Intrinsics.areEqual(r112.a(), "") == true) goto L53;
        Object r100 = null;
        if (r113 == null) goto L9;
        String r101 = r112.a();
        Intrinsics.checkNotNull(r101);
        String r102 = r113.h(r101);
    L10:
        if (r102 == null) goto L53;
        PreloadManager r103 = (PreloadManager) PreloadManager.f56704c.getValue();
        String r104 = r112.a();
        Intrinsics.checkNotNull(r104);
        String r114 = r113.h(r104);
        Intrinsics.checkNotNull(r114);
        ?? r105 = new l4(this);
        Integer r115 = r112.b();
        yr.c.e("PreloadManager", "getData : " + r114);
        monitor-enter(r103);
        PreloadState.a r106 = PreloadState.Companion;     // Catch: Throwable -> L50
        PreloadState r107 = r103.f56706b.get(r114);     // Catch: Throwable -> L50
        r106.getClass();     // Catch: Throwable -> L50
        boolean r108 = false;
        boolean r109 = true;
        if (r107 != PreloadState.RUNNING) goto L17;
    L20:
        boolean r116 = true;
    L22:
        if (r116 == true) goto L27;
        yr.c.b("PreloadManager", "getData :  state error " + r114);     // Catch: Throwable -> L50
        r105.onError(-1);     // Catch: Throwable -> L50
        monitor-exit(r103);
        return;
    L27:
        if (r103.f56706b.get(r114) != PreloadState.FINISH) goto L29;
        r108 = true;
    L29:
        if (r108 == false) goto L40;
        yr.c.e("PreloadManager", "cache exit : " + r114);     // Catch: Throwable -> L50
        yr.c.e("PreloadManager", "preload : " + r114);     // Catch: Throwable -> L50
        Object r117 = r103.f56705a.a(r114);     // Catch: Throwable -> L50
        if (r117 == null) goto L33;
        r109 = r117 instanceof String;     // Catch: Throwable -> L50
    L33:
        if (r109 == false) goto L35;
        r100 = (String) r103.f56705a.a(r114);     // Catch: Throwable -> L50
    L35:
        if (r100 == null) goto L37;
        r105.U0(r100);     // Catch: Throwable -> L50
    L38:
        monitor-exit(r103);
        return;
    L37:
        r105.onError(-1);     // Catch: Throwable -> L50
        goto L38
    L40:
        Observable<Object> r118 = r103.f56705a.d(r114);     // Catch: Throwable -> L50
        ?? r119 = r118;
        if (r115 == null) goto L46;
        r115.intValue();     // Catch: Throwable -> L50
        if (r118 == null) goto L45;
        r100 = r118.timeout(r115.intValue(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L50
    L45:
        r119 = r100;
    L46:
        if (r119 == 0) goto L48;
        r119.subscribe(new j4(r103, r114, r105), new k4(r105));     // Catch: Throwable -> L50
    L48:
        monitor-exit(r103);
        return;
    L17:
        if (r107 == PreloadState.FINISH) goto L20;
        r116 = false;
    L50:
        th = move-exception;
        throw th;
    L9:
        r102 = null;
        goto L10
    }
}
