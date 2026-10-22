package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends com.bytedance.android.ec.core.anchorv3.q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HeadLynxAbilityManager f169107e;

    @Override // com.bytedance.android.ec.core.anchorv3.q
    public final void c() {
        AnchorV4HeadV2VO r100 = this.f169107e.f169045d.K10();     // Catch: Throwable -> L18
        if (r100 == null) goto L30;
        List<HeaderContentModel> r101 = r100.getCells();     // Catch: Throwable -> L18
        if (r101 == null) goto L31;
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L18
    L8:
        if (r102.hasNext() == false) goto L32;
        HeaderContentModel r103 = (HeaderContentModel) r102.next();     // Catch: Throwable -> L18
        if (r103.getLynx() == null) goto L8;
        if (r103.getLynx().c() == false) goto L8;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r104 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c(this.f169107e.f169045d.getContext(), this.f169107e.f169045d);     // Catch: Throwable -> L18
        r104.l(r103.getLynx(), 0, null);     // Catch: Throwable -> L18
        HeadLynxAbilityManager r105 = this.f169107e;     // Catch: Throwable -> L18
        String r106 = r103.getLynx().a();     // Catch: Throwable -> L18
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        r105.d(r106, r104);     // Catch: Throwable -> L18
        goto L8
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L18:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }

    public j(HeadLynxAbilityManager r100) {
        this.f169107e = r100;
        super(3);
    }
}
