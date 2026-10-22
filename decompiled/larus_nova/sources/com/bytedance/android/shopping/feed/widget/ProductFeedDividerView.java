package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.b2;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductFeedDividerView;", "Landroid/widget/FrameLayout;", "", "isBlackStyle", "", "setStyle", "", "color", "setTextAndDividerColor", "", "copyWriting", "setCopyWriting", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "d", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "getAdapter", "()Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "setAdapter", "(Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;)V", "adapter", "h", "I", "getStartColor", "()I", "startColor", RXScreenCaptureService.KEY_INDEX, "getEndColor", "endColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedDividerView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f175963j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f175964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f175965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f175966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ProductFeedAdapter f175967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f175968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f175969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProductFeedViewModel f175970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f175971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f175972i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductFeedDividerView f175973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f175974b;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.ProductFeedDividerView$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC2607a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ECAlertDialog f175975a;

            public DialogInterfaceOnClickListenerC2607a(ECAlertDialog r100) {
                this.f175975a = r100;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                this.f175975a.cancel();
            }
        }

        public a(ProductFeedDividerView r100, Context r101) {
            this.f175973a = r100;
            this.f175974b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ProductFeedViewModel r101 = this.f175973a.f175970g;
            if (r101 == null) goto L9;
            MutableLiveData<AnchorV3Param> r102 = r101.getAnchorV3Param();
            if (r102 == null) goto L9;
            AnchorV3Param r103 = r102.getValue();
            if (r103 == null) goto L9;
            InnerFlowAdRawData r104 = r103.getAdInnerFlowLogExtra();
        L11:
            if (r104 != null) goto L24;
            int r105 = ld3.f.f508690a;
            int r106 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
            Object r107 = "以下商品是平台根据您的偏好所做展示，并非平台收费推广商品，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。";
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L17
            jj4.b r109 = jj4.b.f499326b;     // Catch: Throwable -> L17
            Object r110 = jj4.a.a("inner_feed_product_attention", String.class, "以下商品是平台根据您的偏好所做展示，并非平台收费推广商品，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。", false);     // Catch: Throwable -> L17
            if (r110 != null) goto L23;
            Intrinsics.throwNpe();     // Catch: Throwable -> L17
        L23:
            String r111 = (String) r110;
        L36:
            ECAlertDialog r112 = new ECAlertDialog(this.f175974b);
            if (ld3.d.e(ld3.d.b()) == false) goto L39;
            View r113 = new View(this.f175974b);
            r113.setLayoutParams(new ViewGroup.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(24)));
            r112.setTopCustomView(r113);
        L39:
            r112.setMessage(r111);
            r112.setPositiveButton(ag4.a.d(R.string.i_know), new DialogInterfaceOnClickListenerC2607a(r112));
            if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L48;
            DialogLancet.handleBlockedDialogShow(r112);
            return;
        L48:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
        L43:
            DialogLancet.beforeDialogShow(r112);
            r112.show();
            DialogLancet.afterDialogShow(r112);
            return;
        L17:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            if (Result.m9455isFailureimpl(r115) == true) goto L22;
            r107 = r115;
        L22:
            r110 = r107;
            goto L23
        L24:
            int r116 = ld3.f.f508690a;
            int r117 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
            Object r118 = "以下商品是平台根据您的偏好所做展示，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。";
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L29
            jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L29
            Object r121 = jj4.a.a("inner_feed_product_attention_ad", String.class, "以下商品是平台根据您的偏好所做展示，与视频内容无关。请您在了解商品情况后购买，售后问题可向商家或平台客服反馈。", false);     // Catch: Throwable -> L29
            if (r121 != null) goto L35;
            Intrinsics.throwNpe();     // Catch: Throwable -> L29
        L35:
            r111 = (String) r121;
        L29:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            Object r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            if (Result.m9455isFailureimpl(r123) == true) goto L34;
            r118 = r123;
        L34:
            r121 = r118;
        L9:
            r104 = null;
            goto L11
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductFeedDividerView f175976a;

        public b(ProductFeedDividerView r100) {
            this.f175976a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f175976a.a(R.id.switch_bubble_container).setVisibility(8);
        }
    }

    public static final class c {
        public static String a(int r100) {
            if (r100 != 0) goto L4;
            return "big_card";
        L4:
            if (r100 != 1) goto L6;
            return "small_card";
        L6:
            if (r100 == 2) goto L8;
            return "";
        L8:
            return "biserial_card";
        }
    }

    static {
    }

    public ProductFeedDividerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFeedDividerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        ProductFeedAdapter r100 = this.f175967d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        if (r100.f174348y != 0) goto L10;
        TextView r101 = (TextView) a(R.id.list_style_switch_tv);
        int r102 = g1.f45599a;
        r101.setText(g1.a.c(getContext(), R.string.shopping_big_card_mode, new Object[0]));
        ImageView r103 = (ImageView) a(R.id.list_style_switch_iv);
        if (r103 == null) goto L22;
        r103.setImageResource(R.drawable.commerce_short_video_feed_list_style_switch_icon_big);
        return;
    L22:
        return;
    L10:
        ProductFeedAdapter r104 = this.f175967d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L14:
        if (r104.f174348y != 1) goto L18;
        TextView r105 = (TextView) a(R.id.list_style_switch_tv);
        int r106 = g1.f45599a;
        r105.setText(g1.a.c(getContext(), R.string.shopping_small_card_mode, new Object[0]));
        ImageView r107 = (ImageView) a(R.id.list_style_switch_iv);
        if (r107 == null) goto L24;
        r107.setImageResource(R.drawable.commerce_short_video_feed_list_style_switch_icon_tiny);
        return;
    L24:
        return;
    L18:
        TextView r108 = (TextView) a(R.id.list_style_switch_tv);
        int r109 = g1.f45599a;
        r108.setText(g1.a.c(getContext(), R.string.shopping_small_card_mode, new Object[0]));
        ImageView r110 = (ImageView) a(R.id.list_style_switch_iv);
        if (r110 == null) goto L26;
        r110.setImageResource(R.drawable.commerce_short_video_feed_list_style_switch_icon_double_list);
        return;
    }

    public final ProductFeedAdapter getAdapter() {
        ProductFeedAdapter r100 = this.f175967d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ProductFeedAdapter r100 = this.f175967d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        if (r100.f174346w != 0) goto L8;
        return;
    L8:
        if (this.f175969f == true) goto L40;
        b2 r101 = new b2();
        ProductFeedAdapter r102 = this.f175967d;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L12:
        r101.f174628e = c.a(r102.f174348y);
        ProductFeedViewModel r103 = this.f175970g;
        if (r103 == null) goto L17;
        AnchorV3Param r104 = r103.m8290getAnchorV3Param();
        if (r104 == null) goto L17;
        ECLogExtraData r105 = r104.getLogExtraData();
    L18:
        if (r105 == null) goto L20;
        String r106 = r105.getEnterFrom();
    L21:
        r101.f174624a = r106;
        if (r105 == null) goto L24;
        String r107 = r105.getEComEntranceForm();
    L25:
        r101.f174625b = r107;
        ProductFeedViewModel r108 = this.f175970g;
        if (r108 == null) goto L30;
        AnchorV3Param r109 = r108.m8290getAnchorV3Param();
        if (r109 == null) goto L30;
        String r110 = r109.getAuthorId();
    L31:
        r101.f174626c = r110;
        ProductFeedViewModel r111 = this.f175970g;
        if (r111 == null) goto L36;
        AnchorV3Param r112 = r111.m8290getAnchorV3Param();
        if (r112 == null) goto L36;
        String r113 = r112.getVideoId();
    L37:
        r101.f174627d = r113;
        r101.post(null, null);
        this.f175969f = true;
        return;
    L36:
        r113 = null;
    L30:
        r110 = null;
        goto L31
    L24:
        r107 = null;
        goto L25
    L20:
        r106 = null;
    L17:
        r105 = null;
        goto L18
    }

    public final int getEndColor() {
        return this.f175972i;
    }

    public final int getStartColor() {
        return this.f175971h;
    }

    public final View a(int r100) {
        if (this.f175964a != null) goto L5;
        this.f175964a = new LinkedHashMap();
    L5:
        View r101 = this.f175964a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f175964a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setAdapter(ProductFeedAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f175967d = r100;
    }

    public final void setCopyWriting(String r100) {
        Intrinsics.checkNotNullParameter(r100, "copyWriting");
        ((TextView) a(R.id.product_feed_title_view)).setText(r100);
    }

    public final void setStyle(boolean r100) {
        if (this.f175966c != r100) goto L5;
        boolean r101 = false;
    L6:
        if (r101 == false) goto L15;
        if (r100 == false) goto L9;
        int r102 = getContext().getResources().getColor(R.color.commerce_color_FFFFFF);
    L10:
        setTextAndDividerColor(r102);
        if (r100 == false) goto L13;
        ((ImageView) a(R.id.comma_iv)).setImageResource(R.drawable.commerce_comma_white);
        return;
    L13:
        ((ImageView) a(R.id.comma_iv)).setImageResource(R.drawable.commerce_comma_grey);
        return;
    L9:
        r102 = getContext().getResources().getColor(R.color.shopping_color_000000);
        goto L10
    L15:
        return;
    L5:
        this.f175966c = r100;
        r101 = true;
        goto L6
    }

    public final void setTextAndDividerColor(int r100) {
        ((TextView) a(R.id.product_feed_title_view)).setTextColor(r100);
        a(R.id.left_divider_advanced).setBackgroundColor(r100);
        a(R.id.right_divider_advanced).setBackgroundColor(r100);
    }

    public ProductFeedDividerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175964a = new LinkedHashMap();
        boolean r103 = ld3.d.e(ld3.d.a());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r104 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_commerce_recommend_feed_product_title, this, true);
    L6:
        this.f175965b = findViewById(R.id.maybe_like_container);
        setStyle(r103);
        ((ImageView) a(R.id.comma_iv)).setOnClickListener(new a(this, r100));
        LinearLayout r105 = (LinearLayout) a(R.id.list_style_switch_container);
        if (r105 == null) goto L9;
        r105.setOnClickListener(new t(this));
    L9:
        ((FrameLayout) a(R.id.switch_bubble_container)).setOnClickListener(new b(this));
        this.f175971h = r100.getResources().getColor(R.color.commerce_color_FFFFFF);
        this.f175972i = r100.getResources().getColor(R.color.shopping_color_161823);
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_recommend_feed_product_title, this, true);
        goto L6
    }

    public /* synthetic */ ProductFeedDividerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
