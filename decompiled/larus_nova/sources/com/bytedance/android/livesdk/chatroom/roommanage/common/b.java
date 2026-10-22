package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f111378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveRoomTabLayout f111379b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveRoomTabLayout r101 = this.f111379b;
        if (r101.f111365s != null) goto L5;
    L8:
        LiveRoomTabLayout r102 = this.f111379b;
        r102.f111351e = true;
        LiveRoomTabLayout.a r103 = r102.f111365s;
        if (r103 == null) goto L12;
        r103.a(this.f111378a);
        return;
    L12:
        return;
    L5:
        if (r101.f111348b.getCurrentItem() != this.f111378a) goto L8;
        this.f111379b.f111365s.b();
    }

    public b(LiveRoomTabLayout r100, int r101) {
        this.f111379b = r100;
        this.f111378a = r101;
    }
}
