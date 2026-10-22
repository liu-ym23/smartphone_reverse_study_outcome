package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f79793a;

    public b(a r100) {
        this.f79793a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r100) {
        if (r100 == null) goto L5;
        this.f79793a.b(r100);
        return;
    }
}
