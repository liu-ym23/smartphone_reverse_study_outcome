package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.livesdk.livecommerce.event.a2;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f152103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f152104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f152105c;

    public b(a r100, c r101, boolean r102) {
        this.f152103a = r100;
        this.f152104b = r101;
        this.f152105c = r102;
    }

    public final void a() {
        a2 r100 = new a2();
        r100.f("anchor_id", this.f152103a.f152100h.getAnchorId().getValue());
        r100.f("product_id", this.f152104b.f152107b);
        r100.f(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f152104b.f152108c);
        r100.f(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f152104b.f152109d);
        r100.f("room_id", this.f152103a.f152100h.getRoomId().getValue());
        if (this.f152105c == false) goto L5;
        String r101 = BitableAnalytic.LinkSceneClickType.EXPAND;
    L6:
        r100.f("click_type", r101);
        ECFloatWindowInfo r102 = this.f152104b.f152106a;
        if (r102 == null) goto L9;
        String r103 = r102.getInfoType();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        Intrinsics.checkNotNullParameter(r103, "infoType");
        r100.f("info_type", r103);
        r100.k();
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = "close";
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
