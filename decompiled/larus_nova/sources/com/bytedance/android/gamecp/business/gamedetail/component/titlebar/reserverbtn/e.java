package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.reserverbtn;

import android.view.View;
import com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.o;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleReserveButtonWidget f55253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f55254b;

    public e(TitleReserveButtonWidget r100, a r101) {
        this.f55253a = r100;
        this.f55254b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TitleReserveButtonWidget r101 = this.f55253a;
        Long r102 = this.f55254b.a();
        if (r102 != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        r101.Wo(new o(r103, 0));
        return;
    L6:
        if (r102.longValue() != 0) goto L8;
        r103 = true;
        goto L9
    }
}
