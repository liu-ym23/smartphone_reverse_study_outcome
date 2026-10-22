package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class h0 extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f78778a;

    public h0(g0 r100) {
        this.f78778a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r100) {
        if (r100 == null) goto L15;
        g0 r101 = this.f78778a;
        if (r101.f78772c == true) goto L16;
        int r102 = r101.f78775f.b();
        ALogger.i("LinkInfoReportHelper", "onLinkListChange: curLinkCount = " + r101.f78771b + ", newLinkCount=" + r102);
        int r103 = r101.f78771b;
        if (r103 != 0) goto L10;
        if (r102 <= 0) goto L10;
        r101.e(0, null);
    L13:
        r101.f78771b = r102;
        return;
    L10:
        if (r103 <= 0) goto L13;
        if (r102 != 0) goto L13;
        r101.d(0, null);
        goto L13
    L16:
        return;
    }
}
