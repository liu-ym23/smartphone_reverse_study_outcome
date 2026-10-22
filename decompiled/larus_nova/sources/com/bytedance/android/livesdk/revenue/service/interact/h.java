package com.bytedance.android.livesdk.revenue.service.interact;

import com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Observer f157356a;

    public h(GiftAnchorTicketWidget.b r100) {
        this.f157356a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Observer r101 = this.f157356a;
        r101.onChanged((List) r100);
    }
}
