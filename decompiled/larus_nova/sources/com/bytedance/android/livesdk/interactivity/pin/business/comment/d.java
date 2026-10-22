package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f138670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.c f138671b;

    public d(boolean r100, HighlightItem.c r101) {
        this.f138670a = r100;
        this.f138671b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(this.f138670a) == false) goto L5;
        e42.b r101 = new e42.b(this.f138671b);
        r101.f479967d = true;
        g42.i.a(r101);
        return;
    L5:
        f2.b(R.string.ttlive_pin_not_have_pin_privilege, 0);
    }
}
