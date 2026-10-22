package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.saleticket;

import com.bytedance.android.livesdk.message.model.qk;
import com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.AutoFallbackHybridComponentContainer;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements AutoFallbackHybridComponentContainer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f160495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qk f160496b;

    public d(e r100, qk r101) {
        this.f160495a = r100;
        this.f160496b = r101;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.AutoFallbackHybridComponentContainer.a
    public final void b() {
        e.a r100 = this.f160495a.f160500d;
        if (r100 == null) goto L6;
        r100.jb(this.f160496b);
        return;
    }
}
