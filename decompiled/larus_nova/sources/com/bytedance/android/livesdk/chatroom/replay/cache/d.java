package com.bytedance.android.livesdk.chatroom.replay.cache;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheHostFragment;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements nm1.d, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nm1.e f108139a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // nm1.d
    public final ReplayCacheHostFragment a() {
        return new ReplayCacheHostFragment();
    }

    @Override // nm1.d
    public final boolean c() {
        Boolean r100 = ReplayConfigSettingKeys.REPLAY_ENABLE_VIDEO_DOWNLOAD_ENTRANCE.getValue();
        if (r100.booleanValue() == false) goto L6;
        HashMap r101 = new HashMap();
        r101.put("is_vs", String.valueOf(1));
        c.c("vs_my_download_item_show", r101);
    L6:
        return r100.booleanValue();
    }

    @Override // nm1.d
    public final long getReplayCacheSize() {
        ALogger.e("ReplayExternalCacheService", "getReplayCacheSize db start " + System.currentTimeMillis());
        lm1.a r100 = this.f108139a.c();
        if (r100 == null) goto L5;
        long r101 = r100.getCacheSize();
    L6:
        ALogger.e("ReplayExternalCacheService", "getReplayCacheSize db end " + System.currentTimeMillis());
        return r101;
    L5:
        r101 = 0;
        goto L6
    }

    public d(nm1.e r100) {
        Intrinsics.checkNotNullParameter(r100, "replayExternalCommonService");
        this.f108139a = r100;
    }
}
