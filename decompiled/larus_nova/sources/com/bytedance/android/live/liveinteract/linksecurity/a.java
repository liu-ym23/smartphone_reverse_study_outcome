package com.bytedance.android.live.liveinteract.linksecurity;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends LinkSecurityMonitor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f75437g = null;

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final String f() {
        return "multi_link_interact";
    }

    static {
        f75437g = new a();
    }

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final void g() {
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.f65134a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.C1072a r101 = com.bytedance.android.live.core.privacy.av.api.b.a.f65135a;
        com.bytedance.android.live.core.privacy.av.api.a r102 = com.bytedance.android.live.core.privacy.av.api.a.f65132b;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "config");
        c("on_close_broadcast", r100, r101, r102);
    }

    public a() {
    }

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final void h(ILinkPlayerInfoBridge r100, ILinkPlayerInfoBridge r101, LinkSecurityMonitor.b r102) {
        Intrinsics.checkNotNullParameter(r101, "new");
        Intrinsics.checkNotNullParameter(r101, "new");
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = "";
        if (r100 == null) goto L6;
        String r105 = String.valueOf(r100.getLinkType());
        if (r105 == null) goto L6;
    L7:
        r103.put("last_link_type", r105);
        r103.put("current_link_type", String.valueOf(r101.getLinkType()));
        if (r102 == null) goto L13;
        String r106 = r102.toString();
        if (r106 == null) goto L13;
        r104 = r106;
    L13:
        r103.put("last_log_info", r104);
        com.bytedance.android.live.core.privacy.av.api.b.f65134a.getClass();
        e("on_user_list_camera_closed", r103, com.bytedance.android.live.core.privacy.av.api.b.a.f65135a, com.bytedance.android.live.core.privacy.av.api.a.f65132b);
        return;
    L6:
        r105 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor
    public final void i(ILinkPlayerInfoBridge r100, ILinkPlayerInfoBridge r101, LinkSecurityMonitor.b r102) {
        Intrinsics.checkNotNullParameter(r101, "new");
        Intrinsics.checkNotNullParameter(r101, "new");
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = "";
        if (r100 == null) goto L6;
        String r105 = String.valueOf(r100.getSilenceStatus());
        if (r105 == null) goto L6;
    L7:
        r103.put("last_silence_state", r105);
        r103.put("current_silence_state", String.valueOf(r101.getSilenceStatus()));
        if (r102 == null) goto L13;
        String r106 = r102.toString();
        if (r106 == null) goto L13;
        r104 = r106;
    L13:
        r103.put("last_log_info", r104);
        com.bytedance.android.live.core.privacy.av.api.b.f65134a.getClass();
        d("on_user_list_self_mute", r103, com.bytedance.android.live.core.privacy.av.api.b.a.f65135a, com.bytedance.android.live.core.privacy.av.api.a.f65132b);
        return;
    L6:
        r105 = "";
        goto L7
    }
}
