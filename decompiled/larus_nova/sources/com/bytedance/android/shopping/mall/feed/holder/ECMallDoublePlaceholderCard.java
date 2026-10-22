package com.bytedance.android.shopping.mall.feed.holder;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.ECMediaType;
import com.bytedance.android.shopping.api.mall.IECMallDeliveryService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yj.t;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallDoublePlaceholderCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallDoublePlaceholderCard extends BaseViewHolder {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f177038r = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SimpleDraweeView f177039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SimpleDraweeView f177040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Runnable f177041q;

    public static final class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f177042a;

        public a(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f177042a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            this.f177042a.invoke();
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            this.f177042a.invoke();
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECMallDoublePlaceholderCard f177043a;

        public c(ECMallDoublePlaceholderCard r100) {
            this.f177043a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r100 = this.f177043a.f177041q;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.run();     // Catch: Throwable -> L7
        L5:
            this.f177043a.f177041q = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f177044a;

        public d(boolean r100) {
            this.f177044a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ServiceManager r100 = ServiceManager.get();     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            IECMallDeliveryService r101 = (IECMallDeliveryService) r100.getService(IECMallDeliveryService.class);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.notifyDeliveryEventBlockEnd(this.f177044a);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECMallDoublePlaceholderCard f177045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f177046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f177047c;

        public e(ECMallDoublePlaceholderCard r100, Object r101, boolean r102) {
            this.f177045a = r100;
            this.f177046b = r101;
            this.f177047c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = ((ECMallPlaceholderCardVO) this.f177046b).getSchema();
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L10:
            if ((!r102) == true) goto L13;
            r101 = null;
        L13:
            if (r101 != null) goto L15;
            return;
        L15:
            Uri r103 = UriProtector.parse(r101);
            SimpleDraweeView r104 = this.f177045a.f177039o;
            int r105 = View.generateViewId();
            r104.setId(r105);
            String r106 = r103.buildUpon().appendQueryParameter("share_element_view_id", String.valueOf(r105)).build().toString();
            IHybridHostService r107 = com.bytedance.android.ec.hybrid.a.h();
            if (r107 == null) goto L21;
            t r108 = r107.getHybridLynxHostService();
            if (r108 == null) goto L21;
            if (r108.isOptProductCardTransition() != true) goto L21;
        L22:
            k.f170443b.d(this.f177045a.itemView.getContext(), r106, null);
            Lazy r109 = TransitionAnimationHelper.f47620a;
            TransitionAnimationHelper.b(ECMediaType.PRODUCT.getType(), this.f177047c);
            return;
        L21:
            TransitionAnimationHelper.d(r104, "product");
            goto L22
        L5:
            if (r101.length() == 0) goto L8;
            r102 = false;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public ECMallDoublePlaceholderCard(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        SimpleDraweeView r101 = new SimpleDraweeView(r100.getContext());
        r101.setTag(R.id.transition_animation_bitmap_provider, new Object());
        Unit r102 = Unit.INSTANCE;
        this.f177039o = r101;
        SimpleDraweeView r103 = new SimpleDraweeView(r100.getContext());
        this.f177040p = r103;
        ViewGroup r104 = (ViewGroup) r100;
        r104.addView(r101, new ViewGroup.LayoutParams(-1, -2));
        r104.addView(r103, new ViewGroup.LayoutParams(-1, -2));
    }

    public final void q4(final String r100, ECMallDeliveryReduceConfig r101) {
        final Ref.LongRef r102 = new Ref.LongRef();
        r102.element = -1;
        boolean r103 = true;
        final Integer r104 = null;
        if (r101 == null) goto L10;
        final Integer r105 = Integer.valueOf(r101.getTargetDuration());
        if (r105.intValue() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
    L11:
        if (r101 == null) goto L18;
        Integer r107 = Integer.valueOf(r101.getMaxDelayJumpDuration());
        if (r107.intValue() > 0) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r104 = r107;
    L18:
        if (r100 == null) goto L22;
        if (r105 == null) goto L22;
        if (r104 == null) goto L22;
        kk.d.c(new ECMallDoublePlaceholderCard$executeDeliveryRunnable$1(r100, r102, r105, r104));
    L22:
        c r108 = new c(this);
        if (r102.element <= 0) goto L25;
        t93.a.b().postDelayed(r108, r102.element);
        return;
    L25:
        r108.run();
        return;
    L7:
        r106 = false;
    L10:
        r105 = null;
        goto L11
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r110, String r111, com.bytedance.android.ec.hybrid.list.entity.k.a r112) {
        Intrinsics.checkNotNullParameter(r111, "itemId");
        super.b4(r110, r111, r112);
        if ((r110 instanceof ECMallPlaceholderCardVO) == true) goto L5;
        return;
    L5:
        ECMallPlaceholderCardVO r113 = (ECMallPlaceholderCardVO) r110;
        if (r113.getBackgroundUrlPair() == null) goto L8;
    L10:
        ECMallDeliveryReduceConfig r114 = r113.getReduceConfig();
        String r100 = null;
        if (r114 == null) goto L13;
        Double r115 = Double.valueOf(r114.getCardRadius());
    L14:
        if (r115 == null) goto L16;
        float r116 = b0.c(r115);
        this.f177039o.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r116, r116, 0.0f, 0.0f));
        this.f177040p.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, r116, r116));
    L17:
        ECMallDeliveryReduceConfig r117 = r113.getReduceConfig();
        boolean r101 = false;
        if (r117 != null) goto L20;
    L22:
        boolean r118 = false;
    L24:
        if (r113.getShouldNotifyDelivery() == false) goto L26;
        d r102 = new d(r118);
    L27:
        this.f177041q = r102;
        ECMallDeliveryReduceConfig r103 = r113.getReduceConfig();
        if (r103 != null) goto L30;
    L32:
        a r104 = null;
    L33:
        String r105 = r113.getCover();
        if (r105 != null) goto L36;
    L39:
        boolean r106 = true;
    L40:
        int r107 = -1;
        if (r106 == true) goto L52;
        Pair<Float, Float> r108 = r113.getBackgroundUrlRatioPair();
        if (r108 == null) goto L47;
        Float r109 = r108.getFirst();
        if (r109 == null) goto L47;
        this.f177039o.setAspectRatio(r109.floatValue());
    L47:
        SimpleDraweeView r119 = this.f177039o;
        String r120 = r113.getCover();
        Intrinsics.checkNotNull(r120);
        if (d0.a(r119, r104, r120, "ec_na_mall", "ec_na_mall_product_cover") == true) goto L81;
        if (r104 == null) goto L51;
        this.f177039o.setController(Fresco.newDraweeControllerBuilder().setControllerListener(r104).build());
    L51:
        this.f177039o.setImageURI(r113.getCover());
    L81:
        Pair<String, String> r121 = r113.getBackgroundUrlPair();
        if (r121 == null) goto L84;
        r100 = r121.getSecond();
    L84:
        if (r100 != null) goto L86;
    L87:
        r101 = true;
    L88:
        if (r101 == true) goto L95;
        Pair<Float, Float> r122 = r113.getBackgroundUrlRatioPair();
        if (r122 == null) goto L94;
        Float r123 = r122.getSecond();
        if (r123 == null) goto L94;
        this.f177040p.setAspectRatio(r123.floatValue());
    L94:
        SimpleDraweeView r124 = this.f177040p;
        Pair<String, String> r125 = r113.getBackgroundUrlPair();
        Intrinsics.checkNotNull(r125);
        r124.setImageURI(r125.getSecond());
    L106:
        if (r104 != null) goto L108;
        q4(r113.getDeliverySessionId(), r113.getReduceConfig());
    L108:
        this.itemView.setOnClickListener(new e(this, r110, r118));
        return;
    L95:
        Pair<Float, Float> r126 = r113.getBackgroundResIdRatioPair();
        if (r126 == null) goto L100;
        Float r127 = r126.getSecond();
        if (r127 == null) goto L100;
        this.f177040p.setAspectRatio(r127.floatValue());
    L100:
        SimpleDraweeView r128 = this.f177040p;
        Pair<Integer, Integer> r129 = r113.getBackgroundResIdPair();
        if (r129 == null) goto L105;
        Integer r130 = r129.getSecond();
        if (r130 == null) goto L105;
        r107 = r130.intValue();
    L105:
        r128.setImageResource(r107);
        goto L106
    L86:
        if (r100.length() != 0) goto L88;
    L52:
        Pair<String, String> r131 = r113.getBackgroundUrlPair();
        if (r131 == null) goto L55;
        String r132 = r131.getFirst();
    L56:
        if (r132 != null) goto L58;
    L61:
        boolean r133 = true;
    L62:
        if (r133 == true) goto L69;
        Pair<Float, Float> r134 = r113.getBackgroundUrlRatioPair();
        if (r134 == null) goto L68;
        Float r135 = r134.getFirst();
        if (r135 == null) goto L68;
        this.f177039o.setAspectRatio(r135.floatValue());
    L68:
        SimpleDraweeView r136 = this.f177039o;
        Pair<String, String> r137 = r113.getBackgroundUrlPair();
        Intrinsics.checkNotNull(r137);
        r136.setImageURI(r137.getFirst());
        goto L81
    L69:
        Pair<Float, Float> r138 = r113.getBackgroundResIdRatioPair();
        if (r138 == null) goto L74;
        Float r139 = r138.getFirst();
        if (r139 == null) goto L74;
        this.f177039o.setAspectRatio(r139.floatValue());
    L74:
        SimpleDraweeView r140 = this.f177039o;
        Pair<Integer, Integer> r141 = r113.getBackgroundResIdPair();
        if (r141 == null) goto L79;
        Integer r142 = r141.getFirst();
        if (r142 == null) goto L79;
        int r143 = r142.intValue();
    L80:
        r140.setImageResource(r143);
    L79:
        r143 = -1;
        goto L80
    L58:
        if (r132.length() == 0) goto L61;
        r133 = false;
        goto L62
    L55:
        r132 = null;
        goto L56
    L36:
        if (r105.length() == 0) goto L39;
        r106 = false;
        goto L40
    L30:
        if (r103.getJumpAfterImageLoaded() != true) goto L32;
        r104 = new a(new ECMallDoublePlaceholderCard$onBind$controllerListener$1(this, r110));
        goto L33
    L26:
        r102 = null;
        goto L27
    L20:
        if (r117.getForbidExitAnimation() != true) goto L22;
        r118 = true;
        goto L24
    L16:
        this.f177039o.getHierarchy().setRoundingParams(null);
        this.f177040p.getHierarchy().setRoundingParams(null);
        goto L17
    L13:
        r115 = null;
        goto L14
    L8:
        if (r113.getBackgroundResIdPair() != null) goto L10;
    }
}
