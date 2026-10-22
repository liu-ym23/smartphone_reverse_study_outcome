package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.PreloadReplayResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.replay_api.model.ReplayVideoPositionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "preloadReplay")
public final class x9 extends w20.a5<w20.bd, PreloadReplayResultModel> {
    public x9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.bd r112 = (w20.bd) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        nm1.k r113 = pm1.f.i();
        if (r113 != null) goto L5;
        return;
    L5:
        if (r113.c() != true) goto L31;
        Episode r114 = (Episode) GsonHelper.get().fromJson(r112.a(), Episode.class);     // Catch: Exception -> L21
        if (r114 != null) goto L10;
        return;
    L10:
        if (r114.getPlayVideoModel() == null) goto L28;
        nm1.i r115 = pm1.f.g();     // Catch: Exception -> L21
        if (r115 == null) goto L14;
        lm1.c r116 = r115.a();     // Catch: Exception -> L21
    L15:
        if (r116 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.replay.enter.preload.i r117 = r116.g();     // Catch: Exception -> L21
        if (r117 == null) goto L30;
        long r100 = r114.getIdExt();     // Catch: Exception -> L21
        ReplayVideoPositionInfo.Companion.getClass();     // Catch: Exception -> L21
        r117.preLoad(new pm1.b(r100, new ReplayVideoPositionInfo(-1000, -1000, false, true)));     // Catch: Exception -> L21
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r116 = null;
        goto L15
    L28:
        return;
    L21:
        e = move-exception;
        ALogger.e("PreloadReplayMethod", "invoke parse error: " + e);
        return;
    }
}
