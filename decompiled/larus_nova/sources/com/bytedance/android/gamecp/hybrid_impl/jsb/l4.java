package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.network.preload.PreloadManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class l4 implements PreloadManager.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4 f57526a;

    @Override // com.bytedance.android.gamecp.common.network.preload.PreloadManager.b
    public final void T0() {
        yr.c.b("GetPreloadDataMethod", "IGetDataCallback onTimeOut  ");
        this.f57526a.finishWithFailure();
    }

    public l4(i4 r100) {
        this.f57526a = r100;
    }

    @Override // com.bytedance.android.gamecp.common.network.preload.PreloadManager.b
    public final void U0(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        yr.c.b("GetPreloadDataMethod", "IGetDataCallback onData " + r101 + tb2.c.DEFAULT_TEXT);
        JSONObject r102 = new JSONObject(r101);
        JSONObject r103 = new JSONObject();
        r103.put("code", 1);
        r103.put("preloadData", r102);
        this.f57526a.finishWithRawResult(r103);
    }

    @Override // com.bytedance.android.gamecp.common.network.preload.PreloadManager.b
    public final void onError(int r100) {
        yr.c.b("GetPreloadDataMethod", "IGetDataCallback onError " + r100 + tb2.c.DEFAULT_TEXT);
        this.f57526a.finishWithFailure();
    }
}
