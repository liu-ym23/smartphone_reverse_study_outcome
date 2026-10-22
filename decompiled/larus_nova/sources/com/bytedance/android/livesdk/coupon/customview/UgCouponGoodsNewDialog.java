package com.bytedance.android.livesdk.coupon.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class UgCouponGoodsNewDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f121833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f121834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.coupon.b f121835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dt1.a f121836d;

    public static final class a {
    }

    static {
    }

    public static final void a(UgCouponGoodsNewDialog r100) {
        r100.getClass();
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r100);
    L17:
        dt1.a r102 = r100.f121836d;
        com.bytedance.android.livesdk.coupon.b.C1771b r103 = r100.f121835c.retainWindowInfoV2;
        if (r103 == null) goto L27;
        r102.a(r103);
        return;
    L27:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L7;
        r101.post(DialogLancet.createDismissRunnable(r100));
        goto L17
    }

    public static SpannableString b(com.bytedance.android.livesdk.coupon.b.a r110) {
        UgCouponGoodsNewDialog$createPricingSpannableString$1 r100 = UgCouponGoodsNewDialog$createPricingSpannableString$1.INSTANCE;
        Long r101 = r110.discountPrice;
        if (r101 != null) goto L5;
    L14:
        com.bytedance.android.livesdk.coupon.util.a r102 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r103 = r110.originalPrice;
        r102.getClass();
        String r111 = "￥" + com.bytedance.android.livesdk.coupon.util.a.d(r103);
        SpannableString r112 = new SpannableString(r111);
        r112.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF1C49")), 0, r111.length(), 17);
        r112.setSpan(new StyleSpan(1), 0, r111.length(), 17);
        Pair<Integer, Integer> r104 = r100.invoke2(r111, "￥");
        if (r104 == null) goto L17;
        int r105 = r104.component1().intValue();
        int r106 = r104.component2().intValue();
        r112.setSpan(new RelativeSizeSpan(11.0f), r105, r106, 17);
        r112.setSpan(new RelativeSizeSpan(18.0f), r106, r111.length(), 17);
    L17:
        return r112;
    L5:
        if (r101.longValue() <= 0) goto L14;
        StringBuilder r107 = new StringBuilder("￥");
        com.bytedance.android.livesdk.coupon.util.a r108 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r113 = r101.longValue();
        r108.getClass();
        r107.append(com.bytedance.android.livesdk.coupon.util.a.d(r113));
        String r109 = r107.toString();
        String r114 = "￥" + com.bytedance.android.livesdk.coupon.util.a.d(r110.originalPrice);
        String r115 = r109 + ' ' + r114;
        r112 = new SpannableString(r109 + ' ' + r114);
        Pair<Integer, Integer> r116 = r100.invoke2(r115, r109);
        if (r116 == null) goto L11;
        int r117 = r116.component1().intValue();
        int r118 = r116.component2().intValue();
        r112.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF1C49")), r117, r118, 17);
        r112.setSpan(new StyleSpan(1), r117, r118, 17);
        Pair<Integer, Integer> r119 = r100.invoke2(r109, "￥");
        if (r119 == null) goto L11;
        int r120 = r119.component1().intValue();
        int r121 = r120 + r117;
        int r122 = r117 + r119.component2().intValue();
        r112.setSpan(new RelativeSizeSpan(11.0f), r121, r122, 17);
        r112.setSpan(new RelativeSizeSpan(18.0f), r122, r118, 17);
    L11:
        Pair<Integer, Integer> r123 = r100.invoke2(r115, r114);
        if (r123 == null) goto L17;
        int r124 = r123.component1().intValue();
        int r125 = r123.component2().intValue();
        r112.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#99161823")), r124, r125, 17);
        r112.setSpan(new RelativeSizeSpan(12.0f), r124, r125, 17);
        r112.setSpan(new StrikethroughSpan(), r124, r125, 17);
        goto L17
    }

    public UgCouponGoodsNewDialog(Context r100, com.bytedance.android.livesdk.coupon.b r110, com.bytedance.android.livesdk.coupon.h r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "ugCouponResponse");
        Intrinsics.checkNotNullParameter(r111, "callback");
        super(r100, R.style.ttlive_ug_coupon_dialog);
        this.f121835c = r110;
        this.f121836d = r111;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_dialog_coupon_popup_goods_coupon, null);
        this.f121833a = r101;
        setContentView(r101);
        com.bytedance.android.livesdk.coupon.b.C1771b r102 = r110.retainWindowInfoV2;
        if (r102 == null) goto L11;
        String r103 = r102.title;
        if (r103 == null) goto L11;
        TextView r104 = (TextView) findViewById(R.id.tv_coupon_popup_goods_coupon_title);
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
        ALogger.d("UgCouponGoodsNewDialog", "initCountDown skip, expireSuffixText=" + r107 + " expireTime=" + r108);
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_coupon_subtitle)).setText("");
        goto L26
    L22:
        if (r108 == 0) goto L25;
        this.f121834b = du2.a.b(0, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.coupon.customview.a(this, r108, r107), b.f121840a);
        goto L26
    L19:
        r109 = false;
    L26:
        com.bytedance.android.livesdk.coupon.b.C1771b r112 = r110.retainWindowInfoV2;
        if (r112 == null) goto L50;
        List<com.bytedance.android.livesdk.coupon.b.a> r113 = r112.productInfoList;
        if (r113 == null) goto L50;
        com.bytedance.android.livesdk.coupon.b.a r114 = (com.bytedance.android.livesdk.coupon.b.a) CollectionsKt.getOrNull(r113, 0);
        if (r114 == null) goto L50;
        ImageModel r115 = r114.image;
        if (r115 == null) goto L35;
        ImageUtil.loadImageWithRadius((HSImageView) findViewById(R.id.iv_coupon_popup_goods_1_image), r115, R.drawable.ttlive_bg_dialog_popup_goods_image, 8);
    L35:
        String r116 = r114.title;
        if (r116 == null) goto L38;
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_1_name)).setText(r116);
    L38:
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_1_discount_pricing)).setText(b(r114));
        View r117 = findViewById(R.id.bg_coupon_popup_goods_1);
        if (r117 == null) goto L41;
        r117.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$3(this)));
    L41:
        View r118 = findViewById(R.id.iv_coupon_popup_goods_1_image);
        if (r118 == null) goto L44;
        r118.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$4(this)));
    L44:
        View r119 = findViewById(R.id.tv_coupon_popup_goods_1_name);
        if (r119 == null) goto L47;
        r119.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$5(this)));
    L47:
        View r120 = findViewById(R.id.tv_coupon_popup_goods_1_discount_pricing);
        if (r120 == null) goto L50;
        r120.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$6(this)));
    L50:
        com.bytedance.android.livesdk.coupon.b.C1771b r121 = r110.retainWindowInfoV2;
        if (r121 == null) goto L74;
        List<com.bytedance.android.livesdk.coupon.b.a> r122 = r121.productInfoList;
        if (r122 == null) goto L74;
        com.bytedance.android.livesdk.coupon.b.a r123 = (com.bytedance.android.livesdk.coupon.b.a) CollectionsKt.getOrNull(r122, 1);
        if (r123 == null) goto L74;
        ImageModel r124 = r123.image;
        if (r124 == null) goto L59;
        ImageUtil.loadImageWithRadius((HSImageView) findViewById(R.id.iv_coupon_popup_goods_2_image), r124, R.drawable.ttlive_bg_dialog_popup_goods_image, 8);
    L59:
        String r125 = r123.title;
        if (r125 == null) goto L62;
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_2_name)).setText(r125);
    L62:
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_2_discount_pricing)).setText(b(r123));
        View r126 = findViewById(R.id.bg_coupon_popup_goods_2);
        if (r126 == null) goto L65;
        r126.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$3(this)));
    L65:
        View r127 = findViewById(R.id.iv_coupon_popup_goods_2_image);
        if (r127 == null) goto L68;
        r127.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$4(this)));
    L68:
        View r128 = findViewById(R.id.tv_coupon_popup_goods_2_name);
        if (r128 == null) goto L71;
        r128.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$5(this)));
    L71:
        View r129 = findViewById(R.id.tv_coupon_popup_goods_2_discount_pricing);
        if (r129 == null) goto L74;
        r129.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$6(this)));
    L74:
        com.bytedance.android.livesdk.coupon.b.C1771b r130 = r110.retainWindowInfoV2;
        if (r130 == null) goto L98;
        List<com.bytedance.android.livesdk.coupon.b.a> r131 = r130.productInfoList;
        if (r131 == null) goto L98;
        com.bytedance.android.livesdk.coupon.b.a r132 = (com.bytedance.android.livesdk.coupon.b.a) CollectionsKt.getOrNull(r131, 2);
        if (r132 == null) goto L98;
        ImageModel r133 = r132.image;
        if (r133 == null) goto L83;
        ImageUtil.loadImageWithRadius((HSImageView) findViewById(R.id.iv_coupon_popup_goods_3_image), r133, R.drawable.ttlive_bg_dialog_popup_goods_image, 8);
    L83:
        String r134 = r132.title;
        if (r134 == null) goto L86;
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_3_name)).setText(r134);
    L86:
        ((TextView) findViewById(R.id.tv_coupon_popup_goods_3_discount_pricing)).setText(b(r132));
        View r135 = findViewById(R.id.bg_coupon_popup_goods_3);
        if (r135 == null) goto L89;
        r135.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$3(this)));
    L89:
        View r136 = findViewById(R.id.iv_coupon_popup_goods_3_image);
        if (r136 == null) goto L92;
        r136.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$4(this)));
    L92:
        View r137 = findViewById(R.id.tv_coupon_popup_goods_3_name);
        if (r137 == null) goto L95;
        r137.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$5(this)));
    L95:
        View r138 = findViewById(R.id.tv_coupon_popup_goods_3_discount_pricing);
        if (r138 == null) goto L98;
        r138.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$6(this)));
    L98:
        com.bytedance.android.livesdk.coupon.b.C1771b r139 = r110.retainWindowInfoV2;
        if (r139 == null) goto L103;
        String r140 = r139.buttonText;
        if (r140 == null) goto L103;
        ((TextView) findViewById(R.id.tv_coupon_popup_positive_button)).setText(r140);
    L103:
        View r141 = findViewById(R.id.tv_coupon_popup_positive_button);
        if (r141 == null) goto L106;
        r141.setOnClickListener(new g(new UgCouponGoodsNewDialog$initPositiveButton$2(this)));
    L106:
        com.bytedance.android.livesdk.coupon.b.C1771b r142 = r110.retainWindowInfoV2;
        if (r142 == null) goto L111;
        String r143 = r142.cancelText;
        if (r143 == null) goto L111;
        ((TextView) findViewById(R.id.tv_coupon_popup_negative_button)).setText(r143);
    L111:
        View r144 = findViewById(R.id.tv_coupon_popup_negative_button);
        if (r144 == null) goto L114;
        r144.setOnClickListener(new c(this));
    L114:
        View r145 = findViewById(R.id.iv_close_btn);
        if (r145 == null) goto L117;
        r145.setOnClickListener(new d(this));
    L117:
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new e(this));
        setOnDismissListener(new f(this));
    }
}
