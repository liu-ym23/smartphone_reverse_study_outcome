package com.bytedance.android.livesdk.coupon.customview;

import android.widget.TextView;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f121850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f121851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f121852c;

    public i(h r100, long r101, String r102) {
        this.f121850a = r100;
        this.f121851b = r101;
        this.f121852c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        long r102 = System.currentTimeMillis();
        long r103 = this.f121851b;
        if (r102 <= r103) goto L8;
        Disposable r104 = this.f121850a.f121847b;
        if (r104 == null) goto L7;
        r104.dispose();
    L7:
        h r105 = this.f121850a;
        r105.f121847b = null;
        ((TextView) r105.findViewById(R.id.tv_coupon_popup_coupon_subtitle)).setText("00:00:00 " + this.f121852c);
        return;
    L8:
        com.bytedance.android.livesdk.coupon.util.a.f121922a.getClass();
        String r106 = com.bytedance.android.livesdk.coupon.util.a.b(r103 - r102);
        ((TextView) this.f121850a.findViewById(R.id.tv_coupon_popup_coupon_subtitle)).setText(r106 + ' ' + this.f121852c);
    }
}
