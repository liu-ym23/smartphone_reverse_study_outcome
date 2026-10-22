package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FriendsInviteItemBinder f74951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ILinkPlayerInfoBridge f74952b;

    public h(FriendsInviteItemBinder r100, ILinkPlayerInfoBridge r101) {
        this.f74951a = r100;
        this.f74952b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f74951a.f74866c.invoke(this.f74952b);
    }
}
