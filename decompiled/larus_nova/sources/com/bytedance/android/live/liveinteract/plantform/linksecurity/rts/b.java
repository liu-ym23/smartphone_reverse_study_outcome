package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends i.a<ILinkPlayerInfoBridge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RTSVideoWidget f77206a;

    public b(RTSVideoWidget r100) {
        this.f77206a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r100) {
        this.f77206a.xq(r100);
    }
}
