package com.bytedance.android.livesdk.player.roisr;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f156041a = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f156041a = new a();
        LiveMode r100 = LiveMode.VIDEO;
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100.hashCode() == (-1235807369)) goto L6;
        return;
    L6:
        if (r100.equals("livesdk_performance_monitor_base_new") == false) goto L25;
        as0.a r102 = LivePlatformPlayerManager.b();
        Boolean r103 = null;
        if (r102 == null) goto L10;
        ILivePlayerClient r104 = r102.player();
    L12:
        if (r104 != null) goto L14;
    L18:
        if (r104 == null) goto L26;
        Boolean r105 = Boolean.valueOf(r104.isSrUsed());
        if (r105.booleanValue() == false) goto L22;
        r103 = r105;
    L22:
        if (r103 == null) goto L27;
        r103.booleanValue();
        r101.put("sr_used", "1");
        return;
    L27:
        return;
    L26:
        return;
    L14:
        if (Boolean.valueOf(r104.roiSrUsed(true)).booleanValue() == false) goto L16;
        String r106 = "1";
    L17:
        r101.put("roi_sr_used", r106);
        goto L18
    L16:
        r106 = "0";
        goto L17
    L10:
        r104 = null;
        goto L12
    }
}
