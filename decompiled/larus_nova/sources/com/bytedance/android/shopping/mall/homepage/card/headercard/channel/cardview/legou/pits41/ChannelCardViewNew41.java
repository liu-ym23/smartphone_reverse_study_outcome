package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemActivity;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.MiaoShaPriceLabelView;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.BigCardTitleView;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits41/ChannelCardViewNew41;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "", "", "action", "setClickItem", "Lcom/facebook/drawee/view/SimpleDraweeView;", "f", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getBgStyleContainer", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "bgStyleContainer", ce.f26391f, "getTitle", "title", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "h", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "getTitleContainer", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "titleContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelCardViewNew41 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f177639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f177640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f177641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f177642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f177643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f177644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f177645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BigCardTitleView f177646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a> f177647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ChannelCardViewNew41$disableChannelSwiper$1 f177648j;

    public final class a extends FrameLayout {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f177649i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SimpleDraweeView f177650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MiaoShaPriceLabelView f177651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChannelItemActivity f177652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f177653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Timer f177654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Timer f177655f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ECCommonCard f177656g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f177657h;

        public a() {
            throw null;
        }

        public final void a() {
            Timer r100 = this.f177654e;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            Timer r101 = this.f177655f;
            if (r101 == null) goto L8;
            r101.cancel();
        L8:
            this.f177654e = null;
            this.f177655f = null;
            this.f177653d.setVisibility(0);
            this.f177652c.setVisibility(8);
            int r102 = hf3.a.f484919a;
            LinearLayout r103 = this.f177653d;
            Intrinsics.checkNotNullParameter(r103, "view");
            r103.setScaleX(1.0f);
            r103.setScaleY(1.0f);
            ChannelItemActivity r104 = this.f177652c;
            Intrinsics.checkNotNullParameter(r104, "view");
            r104.setScaleX(1.0f);
            r104.setScaleY(1.0f);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            a();
        }

        public final Timer getDelayHandle() {
            return this.f177654e;
        }

        public final Timer getIntervalHandle() {
            return this.f177655f;
        }

        public final ECCommonCard getItem() {
            return this.f177656g;
        }

        public final int getItemLoopTimes() {
            return this.f177657h;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        public final void setDelayHandle(Timer r100) {
            this.f177654e = r100;
        }

        public final void setIntervalHandle(Timer r100) {
            this.f177655f = r100;
        }

        public final void setItem(ECCommonCard r100) {
            this.f177656g = r100;
        }

        public final void setItemLoopTimes(int r100) {
            this.f177657h = r100;
        }

        public a(ChannelCardViewNew41 r100, Context r110) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            AttributeSet r101 = null;
            int r102 = 0;
            super(r110, null, 0);
            SimpleDraweeView r103 = new SimpleDraweeView(r110);
            this.f177650a = r103;
            int r104 = 6;
            MiaoShaPriceLabelView r105 = new MiaoShaPriceLabelView(r110, r101, r104, r102);
            this.f177651b = r105;
            ChannelItemActivity r106 = new ChannelItemActivity(r110, r101, r104, r102);
            this.f177652c = r106;
            LinearLayout r107 = new LinearLayout(r110);
            this.f177653d = r107;
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            r107.setOrientation(1);
            r107.setGravity(1);
            r107.addView(r103, new FrameLayout.LayoutParams(r100.f177641c, r100.f177642d));
            int r108 = c.f47296a;
            r107.addView(r105, new FrameLayout.LayoutParams(-2, c.c(18, r110, true)));
            FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
            r109.gravity = 17;
            Unit r111 = Unit.INSTANCE;
            addView(r107, r109);
            FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, -2);
            r112.gravity = 17;
            addView(r106, r112);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f177658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f177659b;

        public b(int r100, Function1 r101) {
            this.f177658a = r100;
            this.f177659b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f177659b.invoke(Integer.valueOf(this.f177658a));
        }
    }

    public ChannelCardViewNew41(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelCardViewNew41(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        Iterator r100 = ((ArrayList) this.f177647i).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).a();
        goto L4
    }

    public final SimpleDraweeView getBgStyleContainer() {
        return this.f177644f;
    }

    public final SimpleDraweeView getTitle() {
        return this.f177645g;
    }

    public final BigCardTitleView getTitleContainer() {
        return this.f177646h;
    }

    public final void setClickItem(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Iterator<T> r101 = this.f177647i.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((a) r103).setOnClickListener(new b(r102, r100));
        r102 = r104;
        goto L4
    }

    public final void a(ChannelVO r110, com.bytedance.android.shopping.mall.homepage.card.headercard.a r111) {
        Intrinsics.checkNotNullParameter(r111, "cardContext");
        Iterator r100 = ((ArrayList) this.f177647i).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L91;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final a r104 = (a) r102;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r111, "mallContext");
        String r105 = null;
        if (r110 == null) goto L15;
        ChannelVO.Data r106 = r110.getData();
        if (r106 == null) goto L15;
        List<ECCommonCard> r107 = r106.getItems();
        if (r107 == null) goto L15;
        ECCommonCard r108 = (ECCommonCard) ListProtector.get(r107, r101);
    L16:
        r104.f177656g = r108;
        if (r108 == null) goto L90;
        if ((!r108.getAnimItems().isEmpty()) == false) goto L24;
        ECCommonCard.AnimItem r109 = r108.getAnimItems().get(0);
        if (r109 == null) goto L25;
        r105 = r109.getImageUrl();
    L25:
        r110.getItemImageUrl(r101);
        Map<Integer, ECCommonCard.AnimItem> r112 = r108.getAnimItems();
        if (r112 == null) goto L30;
        ECCommonCard.AnimItem r113 = r112.get(0);
        if (r113 == null) goto L30;
        r113.getImageUrl();
    L30:
        Map<Integer, ECCommonCard.AnimItem> r114 = r108.getAnimItems();
        if (r114 == null) goto L35;
        ECCommonCard.AnimItem r115 = r114.get(1);
        if (r115 == null) goto L35;
        r115.getImageUrl();
    L35:
        if (r105 != null) goto L37;
    L40:
        boolean r116 = true;
    L41:
        if (r116 == true) goto L43;
        d0.c(r104.f177650a, r105, r111.f177572k);
    L43:
        r104.f177657h = 0;
        r104.f177651b.a(r110.getItemPrice(r101));
        ECCommonCard.AnimItem r117 = r108.getAnimItems().get(1);
        if (r117 == null) goto L90;
        ChannelItemActivity r118 = r104.f177652c;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r117, MapController.ITEM_LAYER_TAG);
        String r119 = r117.getImageUrl();
        if (r119 != null) goto L48;
    L51:
        boolean r120 = true;
    L52:
        if (r120 == false) goto L54;
        r118.f177615a = false;
    L60:
        if (r104.f177652c.f177615a == false) goto L90;
        ECCommonCard r121 = r104.f177656g;
        if (r121 == null) goto L71;
        Map<Integer, ECCommonCard.AnimItem> r122 = r121.getAnimItems();
        if (r122 == null) goto L71;
        ECCommonCard.AnimItem r123 = r122.get(0);
        if (r123 == null) goto L71;
        Long r124 = r123.getInterval();
        if (r124 == null) goto L71;
        long r125 = r124.longValue();
    L72:
        ECCommonCard r126 = r104.f177656g;
        if (r126 == null) goto L81;
        Map<Integer, ECCommonCard.AnimItem> r127 = r126.getAnimItems();
        if (r127 == null) goto L81;
        ECCommonCard.AnimItem r128 = r127.get(0);
        if (r128 == null) goto L81;
        Long r129 = r128.getDelayTime();
        if (r129 == null) goto L81;
        long r130 = r129.longValue();
    L82:
        Function0<Unit> r131 = new ChannelCardViewNew41$ContentContainer$applyAnimateItemAnimation$1(r104);
        if (r104.f177656g == null) goto L90;
        if (r125 <= 0) goto L90;
        if (r130 <= 0) goto L90;
        PthreadTimer r132 = new PthreadTimer("ChannelCardViewNew41$ContentContainer");
        r132.schedule(new com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.a(r104, r131, r125), r130);
        Unit r133 = Unit.INSTANCE;
        r104.f177654e = r132;
    L81:
        r130 = 0;
    L71:
        r125 = 0;
        goto L72
    L54:
        l93.b.a(r117.getImageUrl());
        String r134 = l93.b.a(r117.getImageUrl());
        if (r134 == null) goto L57;
        r118.f177615a = true;
        d0.c(r118.f177616b, r134, "");
    L58:
        r118.f177617c.a(r117.getTagContent());
        goto L60
    L57:
        r118.f177615a = false;
        Unit r135 = Unit.INSTANCE;
        goto L58
    L48:
        if (r119.length() == 0) goto L51;
        r120 = false;
        goto L52
    L37:
        if (r105.length() == 0) goto L40;
        r116 = false;
        goto L41
    L24:
        r105 = r110.getItemImageUrl(r101);
    L90:
        r101 = r103;
    L15:
        r108 = null;
        goto L16
    L91:
        ECEventCenter.e("disable_channel_swiper", this.f177648j, r111.f472425i);
    }

    public ChannelCardViewNew41(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        int r101 = c.f47296a;
        this.f177639a = c.c(89, getContext(), true);
        this.f177640b = c.c(1, getContext(), true);
        int r102 = c.c(63, getContext(), true);
        this.f177641c = r102;
        this.f177642d = r102;
        int r103 = c.c(28, getContext(), true);
        this.f177643e = r103;
        SimpleDraweeView r104 = new SimpleDraweeView(r100);
        this.f177644f = r104;
        SimpleDraweeView r105 = new SimpleDraweeView(r100);
        this.f177645g = r105;
        int r106 = 0;
        this.f177646h = new BigCardTitleView(r100, null, 6, r106);
        this.f177647i = new ArrayList();
        this.f177648j = new ChannelCardViewNew41$disableChannelSwiper$1(this);
        c.c(12, r100, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, c.c(120, getContext(), true)));
        com.bytedance.android.shopping.mall.homepage.card.headercard.util.c.a(this, r100, r110);
        addView(r104, new FrameLayout.LayoutParams(-1, -1));
        addView(r105, new FrameLayout.LayoutParams(-1, r103));
        LinearLayout r107 = new LinearLayout(r100, r110, r111);
        r107.setOrientation(0);
    L4:
        if (r106 >= 4) goto L6;
        a r112 = new a(this, r100);
        r107.setGravity(16);
        ((ArrayList) this.f177647i).add(r112);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(this.f177639a, -1);
        r113.setMarginStart(this.f177640b);
        Unit r108 = Unit.INSTANCE;
        r107.addView(r112, r113);
        r106 = r106 + 1;
        goto L4
    L6:
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
        r109.topMargin = this.f177643e;
        Unit r114 = Unit.INSTANCE;
        addView(r107, r109);
    }

    public /* synthetic */ ChannelCardViewNew41(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
