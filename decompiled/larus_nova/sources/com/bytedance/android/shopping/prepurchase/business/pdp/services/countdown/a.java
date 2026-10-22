package com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown;

import com.bytedance.android.ec.core.utils.l1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements l1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuctionCountDownService f182057a;

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        Iterator<T> r100 = this.f182057a.f182047k.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l1.a) r100.next()).onFinish();
        goto L4
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
        Iterator<T> r100 = this.f182057a.f182047k.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l1.a) r100.next()).onStart();
        goto L4
    }

    public a(AuctionCountDownService r100) {
        this.f182057a = r100;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        AuctionCountDownService r101 = this.f182057a;
        r101.f182048l = true;
        Iterator<T> r102 = r101.f182047k.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l1.a) r102.next()).onTick(r100);
        goto L4
    L6:
        this.f182057a.f182048l = false;
    }
}
