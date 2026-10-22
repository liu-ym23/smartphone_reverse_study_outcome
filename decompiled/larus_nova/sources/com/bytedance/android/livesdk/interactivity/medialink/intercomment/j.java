package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends hy.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaInteractCommentWidget f138208a;

    public j(MediaInteractCommentWidget r100) {
        this.f138208a = r100;
    }

    @Override // hy.f.a, hy.f.b
    public final void d(int r100, List<AnchorLinkUser> r101) {
        if (r101 != null) goto L4;
    L5:
        MediaInteractCommentWidget r102 = this.f138208a;
        if (r101 == null) goto L8;
        int r103 = ((CopyOnWriteArrayList) r101).size();
    L9:
        r102.f138196j = r103;
        this.f138208a.f138195i = false;
    L10:
        MediaInteractCommentWidget r104 = this.f138208a;
        int r105 = MediaInteractCommentWidget.f138186p;
        r104.Bq();
        return;
    L8:
        r103 = 0;
        goto L9
    L4:
        if (((CopyOnWriteArrayList) r101).size() == this.f138208a.f138196j) goto L10;
        goto L5
    }
}
