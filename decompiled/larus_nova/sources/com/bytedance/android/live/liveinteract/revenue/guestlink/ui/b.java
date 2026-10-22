package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.n5;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f78508a;

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d.a
    public final void a() {
        ALogger.d("GiftMarqueeViewController", "onMarqueeCompleted");
        if ((!this.f78508a.f78510b.isEmpty()) == false) goto L6;
        n5 r100 = (n5) CollectionsKt.first(this.f78508a.f78510b);
        ((ArrayList) this.f78508a.f78510b).remove(r100);
        this.f78508a.f78512d.c(r100);
        return;
    }

    public b(c r100) {
        this.f78508a = r100;
    }
}
