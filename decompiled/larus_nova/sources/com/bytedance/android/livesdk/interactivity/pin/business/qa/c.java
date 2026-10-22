package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f138750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HighlightItem.a f138751b;

    public c(boolean r100, HighlightItem.a r101) {
        this.f138750a = r100;
        this.f138751b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(this.f138750a) == false) goto L5;
        j42.e r101 = new j42.e(this.f138751b);
        r101.f479967d = true;
        g42.i.a(r101);
        return;
    L5:
        f2.b(R.string.ttlive_pin_not_have_pin_privilege, 0);
    }
}
