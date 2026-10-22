package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k2 implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k2 f114531a = null;

    public k2() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f114531a = new k2();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        switch(r100.hashCode()) {
            case -1772881225: goto L18;
            case -1115849514: goto L15;
            case 479193863: goto L12;
            case 1499179894: goto L9;
            case 1499265855: goto L6;
            default: goto L35;
        };
    L35:
        return;
    L6:
        if (r100.equals("livesdk_live_show") == false) goto L28;
    L26:
        IHostBusiness r102 = (IHostBusiness) jc1.k.f(IHostBusiness.class);     // Catch: Throwable -> L25
        if (r102 != null) goto L22;
        return;
    L22:
        if (r102.hasPadContinus() != true) goto L34;
        r101.put("url_source", "app_continued");     // Catch: Throwable -> L25
        return;
    L34:
        return;
    L36:
        return;
    L28:
        return;
    L9:
        if (r100.equals("livesdk_live_play") == true) goto L26;
        return;
    L12:
        if (r100.equals("livesdk_rec_live_play") == true) goto L26;
        return;
    L15:
        if (r100.equals("livesdk_live_duration") == true) goto L26;
        return;
    L18:
        if (r100.equals("livesdk_live_duration_new") == true) goto L26;
    }
}
