package com.bytedance.android.livesdk.notification.notificationsetting.viewbinder;

import android.view.View;
import com.bytedance.android.live.base.model.user.FollowInfo;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorNotifyViewBinder.ViewHolder f154120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cn2.a f154121b;

    public a(AnchorNotifyViewBinder.ViewHolder r100, cn2.a r101) {
        this.f154120a = r100;
        this.f154121b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorNotifyViewBinder.a r101 = this.f154120a.f154118d;
        if (r101 == null) goto L10;
        String r102 = this.f154121b.d();
        FollowInfo r103 = this.f154121b.b();
        if (r103 == null) goto L7;
        long r104 = r103.getPushStatus();
    L8:
        r101.a(r102, r104, this.f154121b.c(), this.f154121b.a());
        return;
    L7:
        r104 = 2;
        goto L8
    }
}
