package com.bytedance.android.live.revlink.impl.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements p11.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p11.f f97516a;

    public c(GiftReceiverRepoService.g r100) {
        this.f97516a = r100;
    }

    @Override // p11.a
    public final void a(int r100, List<? extends p> r101) {
        this.f97516a.onOnlineListChanged(r101);
    }
}
