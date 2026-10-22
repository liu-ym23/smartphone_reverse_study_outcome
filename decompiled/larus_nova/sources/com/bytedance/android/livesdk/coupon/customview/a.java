package com.bytedance.android.livesdk.coupon.customview;

import android.widget.TextView;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgCouponGoodsNewDialog f121837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f121838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f121839c;

    public a(UgCouponGoodsNewDialog r100, long r101, String r102) {
        this.f121837a = r100;
        this.f121838b = r101;
        this.f121839c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        long r102 = System.currentTimeMillis();
        long r103 = this.f121838b;
        if (r102 <= r103) goto L8;
        Disposable r104 = this.f121837a.f121834b;
        if (r104 == null) goto L7;
        r104.dispose();
    L7:
        UgCouponGoodsNewDialog r105 = this.f121837a;
        r105.f121834b = null;
        ((TextView) r105.findViewById(R.id.tv_coupon_popup_goods_coupon_subtitle)).setText("00:00:00 " + this.f121839c);
        return;
    L8:
        com.bytedance.android.livesdk.coupon.util.a.f121922a.getClass();
        String r106 = com.bytedance.android.livesdk.coupon.util.a.b(r103 - r102);
        ((TextView) this.f121837a.findViewById(R.id.tv_coupon_popup_goods_coupon_subtitle)).setText(r106 + ' ' + this.f121839c);
    }
}
