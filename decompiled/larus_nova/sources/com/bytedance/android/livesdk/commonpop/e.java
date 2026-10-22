package com.bytedance.android.livesdk.commonpop;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.room.IRoomService;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.push.b f119727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f119728b;

    public e(com.bytedance.android.live.base.model.push.b r100, Context r101) {
        this.f119727a = r100;
        this.f119728b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((IRoomService) k.n(IRoomService.class)).actionHandler().handle(this.f119728b, this.f119727a.getScheme());
    }
}
