package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket;

import android.view.View;
import com.bytedance.android.livesdk.message.model.qk;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f160493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qk f160494b;

    public c(e r100, qk r101) {
        this.f160493a = r100;
        this.f160494b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e.a r101 = this.f160493a.f160500d;
        if (r101 == null) goto L6;
        r101.Lj(this.f160494b);
        return;
    }
}
