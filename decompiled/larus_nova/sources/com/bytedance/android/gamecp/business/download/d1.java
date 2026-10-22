package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.c3;

/* JADX INFO: loaded from: classes44.dex */
public final class d1 implements h1 {
    public d1() {
    }

    @Override // com.bytedance.android.gamecp.business.download.h1
    public final void a(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        yr.c.a("GameResDownloaderOld", "action params = " + r101);
        com.bytedance.gamecenter.base.q.l().a(r100, r101, null);
    }

    @Override // com.bytedance.android.gamecp.business.download.h1
    public final void b(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        yr.c.a("GameResDownloaderOld", "unSubscribe params = " + r101);
        com.bytedance.gamecenter.base.q.l().p(r100, r101, null);
    }

    @Override // com.bytedance.android.gamecp.business.download.h1
    public final void c(Context r100, JSONObject r101, com.bytedance.android.gamecp.business.t r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "listener");
        yr.c.a("GameResDownloaderOld", "subscribe params = " + r101);
        com.bytedance.gamecenter.base.q.l().o(r100, r101, null, new GameResDownloaderOld$subscribe$1(this, r102, c3.f561291a.getValue()));
    }
}
