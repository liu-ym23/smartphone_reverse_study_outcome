package com.bytedance.android.livesdk.commerce.coupon;

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
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f119631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f119632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f119633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f119634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f119635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveAlignTextView f119636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Typeface f119637g;

    public static final class a {
    }

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
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
        TextView r102 = this.f119635e;
        if (r102 == null) goto L25;
        r102.setText(r100.typeString);
        return;
    L25:
        return;
    L13:
        if (r101.longValue() != 2) goto L17;
        TextView r103 = this.f119635e;
        if (r103 == null) goto L23;
        r103.setText(s1.C(R.string.ttlive_live_coupon_day, new Object[]{Long.valueOf(r100.validPeriod)}));
        return;
    L23:
        return;
    L6:
        if (r101.longValue() != 1) goto L10;
        TextView r104 = this.f119635e;
        if (r104 == null) goto L21;
        r104.setText(s1.C(R.string.ttlive_live_coupon_time, new Object[]{r100.expireTime}));
        return;
    }

    public n(long r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r101, "parent");
        r101.removeAllViews();
        long r102 = r100 % ((long) 10);
        if (r102 != 1) goto L6;
        this.f119633c = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_yellow_coupon_discount_view, r101);
        this.f119632b = 1;
    L11:
        View r103 = this.f119633c;
        LiveAlignTextView r104 = null;
        if (r103 == null) goto L14;
        ImageView r105 = (ImageView) r103.findViewById(R.id.image_view);
    L15:
        this.f119631a = r105;
        View r106 = this.f119633c;
        if (r106 == null) goto L18;
        TextView r107 = (TextView) r106.findViewById(R.id.coupon_red_msg);
    L19:
        this.f119634d = r107;
        View r108 = this.f119633c;
        if (r108 == null) goto L22;
        TextView r109 = (TextView) r108.findViewById(R.id.coupon_time);
    L23:
        this.f119635e = r109;
        View r110 = this.f119633c;
        if (r110 == null) goto L26;
        r104 = (LiveAlignTextView) r110.findViewById(R.id.coupon_detail);
    L26:
        this.f119636f = r104;
        this.f119637g = Typeface.DEFAULT_BOLD;
        return;
    L22:
        r109 = null;
        goto L23
    L18:
        r107 = null;
        goto L19
    L14:
        r105 = null;
        goto L15
    L6:
        if (r102 != 2) goto L9;
        this.f119633c = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_yellow_coupon_reduce_view, r101);
        this.f119632b = 2;
        goto L11
    L9:
        if (r102 != 3) goto L11;
        this.f119633c = LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_yellow_coupon_view, r101);
        this.f119632b = 3;
        goto L11
    }
}
