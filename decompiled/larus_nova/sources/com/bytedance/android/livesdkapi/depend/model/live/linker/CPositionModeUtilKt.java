package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CPositionModeUtilKt;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "user", "", "isCPositionUser", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionModeUtilKt {
    public static final CPositionModeUtilKt INSTANCE = null;

    private CPositionModeUtilKt() {
    }

    static {
        INSTANCE = new CPositionModeUtilKt();
    }

    @JvmStatic
    public static final boolean isCPositionUser(k r100) {
        if (r100 == null) goto L10;
        k1 r101 = r100.getContent();
        if (r101 == null) goto L10;
        l1 r102 = r101.getLinkMicAudienceContent();
        if (r102 == null) goto L10;
        if (r102.isEnlarged() != true) goto L10;
        return true;
    L10:
        return false;
    }
}
