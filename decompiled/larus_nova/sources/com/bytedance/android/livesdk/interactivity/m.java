package com.bytedance.android.livesdk.interactivity;

import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LeftAvatarWidget f137980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.user.e f137981b;

    public m(LeftAvatarWidget r100, com.bytedance.android.live.base.model.user.e r101) {
        this.f137980a = r100;
        this.f137981b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f137981b.getSchema();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r2.a(r101) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L14;
        LeftAvatarWidget r102 = this.f137980a;
        com.bytedance.android.live.base.model.user.e r103 = this.f137981b;
        int r104 = LeftAvatarWidget.f132689n;
        r102.Bq("click", r103, "number");
        IBaseLiveActionHandler r105 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
        if (r105 == null) goto L15;
        r105.handle(this.f137980a.context, r101);
        return;
    L15:
        return;
    }
}
