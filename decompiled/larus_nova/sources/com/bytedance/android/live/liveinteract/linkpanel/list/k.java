package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.s0;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FriendsItemBinderHorizontal.ViewHolder f74957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FriendsItemBinderHorizontal f74958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ILinkPlayerInfoBridge f74959c;

    public k(FriendsItemBinderHorizontal.ViewHolder r100, FriendsItemBinderHorizontal r101, ILinkPlayerInfoBridge r102) {
        this.f74957a = r100;
        this.f74958b = r101;
        this.f74959c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        final FriendsItemBinderHorizontal r101 = this.f74958b;
        Context r102 = this.f74957a.itemView.getContext();
        final ILinkPlayerInfoBridge r103 = this.f74959c;
        r101.getClass();
        s0.a(r102, new FriendsItemBinderHorizontal$tryInvite$1(r101, r103));
    }
}
