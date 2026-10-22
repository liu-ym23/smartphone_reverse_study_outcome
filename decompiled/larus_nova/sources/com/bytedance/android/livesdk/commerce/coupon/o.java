package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f119638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f119639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f119640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f119641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f119642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f119643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveCouponPriceView f119644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f119645h;

    public static final class a {
    }

    static {
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.length() > 2) goto L8;
        return r100;
    L8:
        if (StringsKt.contains$default(r100, '.', false, 2, null) == true) goto L11;
        return r100;
    L11:
        if ('0' == r100.charAt(r100.length() - 1)) goto L13;
        return r100;
    L13:
        return r100.substring(0, r100.length() - 2);
    }

    public final void b(d r100) {
        Long r101 = Long.valueOf(r100.periodType);
        if (r101 != null) goto L6;
    L10:
        if (r101 != null) goto L13;
    L17:
        TextView r102 = this.f119642e;
        if (r102 == null) goto L25;
        r102.setText(s1.C(R.string.ttlive_live_apply_time, new Object[]{r100.startTime, r100.expireTime}));
        return;
    L25:
        return;
    L13:
        if (r101.longValue() != 2) goto L17;
        TextView r103 = this.f119642e;
        if (r103 == null) goto L23;
        r103.setText(s1.C(R.string.ttlive_live_coupon_day, new Object[]{Long.valueOf(r100.validPeriod)}));
        return;
    L23:
        return;
    L6:
        if (r101.longValue() != 1) goto L10;
        TextView r104 = this.f119642e;
        if (r104 == null) goto L21;
        r104.setText(s1.C(R.string.ttlive_live_coupon_time, new Object[]{r100.expireTime}));
        return;
    }

    public o(long r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.f119639b = r101.getContext();
        r101.removeAllViews();
        long r102 = r100 % ((long) 10);
        TextView r103 = null;
        if (r102 != 1) goto L10;
        View r104 = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_yellow_coupon_discount_view_2, r101);
        this.f119641d = r104;
        if (r104 == null) goto L7;
        TextView r105 = (TextView) r104.findViewById(R.id.coupon_price_discount);
    L8:
        this.f119645h = r105;
        this.f119640c = 1;
    L23:
        View r106 = this.f119641d;
        if (r106 == null) goto L26;
        ImageView r107 = (ImageView) r106.findViewById(R.id.image_view);
    L27:
        this.f119638a = r107;
        View r108 = this.f119641d;
        if (r108 == null) goto L30;
        TextView r109 = (TextView) r108.findViewById(R.id.coupon_time);
    L31:
        this.f119642e = r109;
        View r110 = this.f119641d;
        if (r110 == null) goto L34;
        r103 = (TextView) r110.findViewById(R.id.use_limit_text);
    L34:
        this.f119643f = r103;
        Typeface r111 = Typeface.DEFAULT_BOLD;
        return;
    L30:
        r109 = null;
        goto L31
    L26:
        r107 = null;
        goto L27
    L7:
        r105 = null;
        goto L8
    L10:
        if (r102 != 2) goto L17;
        View r112 = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_yellow_coupon_reduce_view_2, r101);
        this.f119641d = r112;
        if (r112 == null) goto L14;
        LiveCouponPriceView r113 = (LiveCouponPriceView) r112.findViewById(R.id.coupon_price);
    L15:
        this.f119644g = r113;
        this.f119640c = 2;
        goto L23
    L14:
        r113 = null;
        goto L15
    L17:
        if (r102 != 3) goto L23;
        View r114 = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_yellow_coupon_reduce_view_2, r101);
        this.f119641d = r114;
        if (r114 == null) goto L21;
        LiveCouponPriceView r115 = (LiveCouponPriceView) r114.findViewById(R.id.coupon_price);
    L22:
        this.f119644g = r115;
        this.f119640c = 3;
        goto L23
    L21:
        r115 = null;
        goto L22
    }
}
