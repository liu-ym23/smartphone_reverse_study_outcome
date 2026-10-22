package com.bytedance.android.live.wallet.platform.business.verify;

import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f102744a;

    public class a {
        public a() {
        }
    }

    public q(s r100) {
        this.f102744a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ((dr2.i) com.bytedance.android.live.revenue.core.util.e.a(dr2.i.class)).sg(((com.bytedance.android.livesdk.revenue.service.user.a) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class)).getCurrentUserId(), this.f102744a.f102748d, new Bundle(), new a());
    }
}
