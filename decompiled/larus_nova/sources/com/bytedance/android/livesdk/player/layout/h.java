package com.bytedance.android.livesdk.player.layout;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.WtnPlayCallback;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements WtnPlayCallback {
    public h() {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.WtnPlayCallback
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ALogger.i("MiniPlayPlayerLayoutManager", "switchToWtnStream, wtn play fail, reason " + r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.WtnPlayCallback
    public final void onSuccess(String r100, HashMap<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "info");
        ALogger.i("MiniPlayPlayerLayoutManager", "switchToWtnStream, wtn play success, streamId " + r100);
    }
}
