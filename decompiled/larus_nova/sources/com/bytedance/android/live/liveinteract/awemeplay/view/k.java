package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveVideoCommentSelectPanelVideoViewHolder f71617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sd0.a f71618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sd0.a f71619c;

    public k(LiveVideoCommentSelectPanelVideoViewHolder r100, sd0.a r101, sd0.a r102) {
        this.f71617a = r100;
        this.f71618b = r101;
        this.f71619c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        sd0.a r101 = this.f71618b;
        if (r101 == null) goto L5;
        Long r102 = r101.b();
    L7:
        if (Intrinsics.areEqual(r102, this.f71619c.b()) == false) goto L11;
        l r103 = this.f71617a.f71599f;
        if (r103 == null) goto L15;
        r103.ZZ(null);
        return;
    L15:
        return;
    L11:
        l r104 = this.f71617a.f71599f;
        if (r104 == null) goto L17;
        r104.ZZ(this.f71619c);
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
