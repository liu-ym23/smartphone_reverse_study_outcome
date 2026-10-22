package com.bytedance.android.livesdk.coupon.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f121846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f121847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.coupon.b f121848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dt1.a f121849d;

    public static final class a {
    }

    static {
    }

    public h(Context r100, com.bytedance.android.livesdk.coupon.b r110, com.bytedance.android.livesdk.coupon.g r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "ugCouponResponse");
        Intrinsics.checkNotNullParameter(r111, "callback");
        super(r100, R.style.ttlive_ug_coupon_dialog);
        this.f121848c = r110;
        this.f121849d = r111;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_dialog_coupon_popup_only_coupon, null);
        this.f121846a = r101;
        setContentView(r101);
        com.bytedance.android.livesdk.coupon.b.C1771b r102 = r110.retainWindowInfoV2;
        if (r102 == null) goto L11;
        String r103 = r102.title;
        if (r103 == null) goto L11;
        TextView r104 = (TextView) findViewById(R.id.tv_coupon_popup_coupon_title);
        if (Build.VERSION.SDK_INT < 24) goto L9;
        Spanned r105 = Html.fromHtml(r103, 0);
    L10:
        r104.setText(r105);
        goto L11
    L9:
        r105 = Html.fromHtml(r103);
    L11:
        com.bytedance.android.livesdk.coupon.b.C1771b r106 = r110.retainWindowInfoV2;
        if (r106 == null) goto L26;
        String r107 = r106.expireSuffixText;
        if (r107 == null) goto L26;
        long r108 = r106.countdownTime * ((long) 1000);
        if (r107.length() != 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L22;
    L25:
        ALogger.d("UgCouponOnlyNewDialog", "initCountDown skip, expireSuffixText=" + r107 + " expireTime=" + r108);
        ((TextView) findViewById(R.id.tv_coupon_popup_coupon_subtitle)).setText("");
        goto L26
    L22:
        if (r108 == 0) goto L25;
        this.f121847b = du2.a.b(0, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r108, r107), j.f121853a);
        goto L26
    L19:
        r109 = false;
    L26:
        com.bytedance.android.livesdk.coupon.b.C1771b r112 = r110.retainWindowInfoV2;
        if (r112 == null) goto L31;
        com.bytedance.android.livesdk.coupon.b.c r113 = r112.couponData;
        if (r113 == null) goto L31;
        long r114 = r113.credit;
        TextView r115 = (TextView) findViewById(R.id.tv_coupon_price);
        com.bytedance.android.livesdk.coupon.util.a.f121922a.getClass();
        r115.setText(com.bytedance.android.livesdk.coupon.util.a.c(r114));
    L31:
        com.bytedance.android.livesdk.coupon.b.C1771b r116 = r110.retainWindowInfoV2;
        if (r116 == null) goto L49;
        com.bytedance.android.livesdk.coupon.b.c r117 = r116.couponData;
        if (r117 == null) goto L49;
        String r118 = r117.discountInfoDesc;
        if (r118 != null) goto L38;
    L41:
        boolean r119 = true;
    L43:
        if (r119 == true) goto L45;
        ((TextView) findViewById(R.id.tv_coupon_price_condition)).setText(r117.discountInfoDesc);
        goto L49
    L45:
        long r120 = r117.threshold;
        if (r120 > 0) goto L48;
        ((TextView) findViewById(R.id.tv_coupon_price_condition)).setText(getContext().getString(R.string.ttlive_coupon_popup_no_threshod));
        goto L49
    L48:
        com.bytedance.android.livesdk.coupon.util.a.f121922a.getClass();
        ((TextView) findViewById(R.id.tv_coupon_price_condition)).setText(getContext().getString(R.string.ttlive_coupon_popup_threshod_format, new Object[]{com.bytedance.android.livesdk.coupon.util.a.c(r120)}));
        goto L49
    L38:
        if (r118.length() == 0) goto L41;
        r119 = false;
    L49:
        com.bytedance.android.livesdk.coupon.b.C1771b r121 = r110.retainWindowInfoV2;
        if (r121 == null) goto L56;
        com.bytedance.android.livesdk.coupon.b.c r122 = r121.couponData;
        if (r122 == null) goto L56;
        String r123 = r122.title;
        if (r123 == null) goto L56;
        ((TextView) findViewById(R.id.tv_coupon_name)).setText(r123);
    L56:
        com.bytedance.android.livesdk.coupon.b.C1771b r124 = r110.retainWindowInfoV2;
        if (r124 == null) goto L63;
        com.bytedance.android.livesdk.coupon.b.c r125 = r124.couponData;
        if (r125 == null) goto L63;
        String r126 = r125.description;
        if (r126 == null) goto L63;
        ((TextView) findViewById(R.id.tv_coupon_use_condition)).setText(r126);
    L63:
        com.bytedance.android.livesdk.coupon.b.C1771b r127 = r110.retainWindowInfoV2;
        if (r127 == null) goto L68;
        String r128 = r127.buttonText;
        if (r128 == null) goto L68;
        ((TextView) findViewById(R.id.tv_coupon_popup_positive_button)).setText(r128);
    L68:
        findViewById(R.id.tv_coupon_popup_positive_button).setOnClickListener(new l(this));
        com.bytedance.android.livesdk.coupon.b.C1771b r129 = r110.retainWindowInfoV2;
        if (r129 == null) goto L73;
        String r130 = r129.cancelText;
        if (r130 == null) goto L73;
        ((TextView) findViewById(R.id.tv_coupon_popup_negative_button)).setText(r130);
    L73:
        findViewById(R.id.tv_coupon_popup_negative_button).setOnClickListener(new k(this));
        findViewById(R.id.iv_close_btn).setOnClickListener(new m(this));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new n(this));
        setOnDismissListener(new o(this));
        Window r131 = getWindow();
        if (r131 == null) goto L77;
        r131.setLayout(ov2.c.b(getContext(), 280.0f), ov2.c.b(getContext(), 283.0f));
        return;
    }
}
