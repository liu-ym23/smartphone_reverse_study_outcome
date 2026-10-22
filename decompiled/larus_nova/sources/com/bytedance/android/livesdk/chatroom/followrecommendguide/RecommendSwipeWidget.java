package com.bytedance.android.livesdk.chatroom.followrecommendguide;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.livesdk.config.du;
import com.bytedance.android.livesdk.config.h31;
import com.bytedance.android.livesdk.config.r4;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/followrecommendguide/RecommendSwipeWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendSwipeWidget extends LiveRecyclableWidget {
    public String A;
    public String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveVerticalViewPager f106210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f106211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f106212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f106213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveTextView f106214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveTextView f106215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveTextView f106216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveTextView f106217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f106218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f106219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RelativeLayout f106220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelativeLayout f106221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f106222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f106223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f106224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f106225p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f106226q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f106227r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f106228s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f106229t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ValueAnimator f106230u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f106231v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f106232w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f106233x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Handler f106234y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f106235z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendSwipeWidget f106236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f106237b;

        public b(RecommendSwipeWidget r100, float r101) {
            this.f106236a = r100;
            this.f106237b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f106236a.f106211b;
            if (r101 == null) goto L10;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L8;
            r101.setTranslationY(((Float) r102).floatValue());
            goto L10
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L10:
            if (r100.getAnimatedFraction() < 0.99f) goto L18;
            View r103 = this.f106236a.f106211b;
            if (r103 == null) goto L14;
            r103.setScaleX(1.0f);
        L14:
            View r104 = this.f106236a.f106211b;
            if (r104 == null) goto L17;
            r104.setScaleY(1.0f);
        L17:
            this.f106236a.yq();
            return;
        L18:
            float r105 = this.f106237b + (r100.getAnimatedFraction() * (1 - this.f106237b));
            if ((r105 - 1.0E-4f) < 1.0f) goto L26;
            View r106 = this.f106236a.f106211b;
            if (r106 == null) goto L23;
            r106.setScaleX(1.0f);
        L23:
            View r107 = this.f106236a.f106211b;
            if (r107 == null) goto L34;
            r107.setScaleY(1.0f);
            return;
        L34:
            return;
        L26:
            View r108 = this.f106236a.f106211b;
            if (r108 == null) goto L29;
            r108.setScaleX(r105);
        L29:
            View r109 = this.f106236a.f106211b;
            if (r109 == null) goto L36;
            r109.setScaleY(r105);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_recommend_swipe_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        h31 r100 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        View r101 = this.f106211b;
        if (r101 == null) goto L5;
        r101.clearAnimation();
    L5:
        ValueAnimator r102 = this.f106230u;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        Handler r103 = this.f106234y;
        if (r103 == null) goto L12;
        r103.removeCallbacksAndMessages(null);
        return;
    }

    public final void yq() {
        LiveTextView r100 = this.f106216g;
        if (r100 == null) goto L5;
        r100.setAlpha(0.0f);
    L5:
        LiveTextView r101 = this.f106217h;
        if (r101 == null) goto L8;
        r101.setAlpha(0.0f);
    L8:
        h31 r102 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        ViewGroup r103 = this.containerView;
        if (r103 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r103);
        return;
    }

    public RecommendSwipeWidget() {
        this.f106225p = -1.0f;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f106213d = (LinearLayout) findViewById(R.id.linear_top_container);
        this.f106212c = (LinearLayout) findViewById(R.id.linear_bottom_container);
        this.f106214e = (LiveTextView) findViewById(R.id.ttlive_bottom_desc_tv);
        this.f106215f = (LiveTextView) findViewById(R.id.ttlive_top_desc_tv);
        this.f106216g = (LiveTextView) findViewById(R.id.swipe_up_tv);
        this.f106217h = (LiveTextView) findViewById(R.id.drag_down_tv);
        this.f106218i = (ImageView) findViewById(R.id.image_arrow_up);
        this.f106219j = (ImageView) findViewById(R.id.image_arrow_down);
        this.f106220k = (RelativeLayout) findViewById(R.id.relative_bottom);
        this.f106221l = (RelativeLayout) findViewById(R.id.relative_top);
        boolean r101 = false;
        String r102 = null;
        if (r2.a(this.B) == true) goto L5;
    L24:
        String r103 = this.f106235z;
        String r104 = this.A;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == true) goto L27;
    L26:
        r4 r105 = null;
    L68:
        LiveTextView r106 = this.f106215f;
        if (r106 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("topDescTv");
    L71:
        if (r105 == null) goto L73;
        String r107 = r105.j();
    L74:
        if (r107 != null) goto L76;
    L79:
        boolean r108 = true;
    L80:
        if (r108 == false) goto L82;
        String r109 = this.context.getString(R.string.ttlive_recommend_top_desc_tv_prima_tips);
    L85:
        r106.setText(r109);
        LiveTextView r110 = this.f106217h;
        if (r110 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("dragDownTv");
    L88:
        if (r105 == null) goto L90;
        String r111 = r105.c();
    L91:
        if (r111 != null) goto L93;
    L96:
        boolean r112 = true;
    L97:
        if (r112 == false) goto L99;
        String r113 = this.context.getString(R.string.ttlive_recommend_top_desc_tv_second_tips);
    L102:
        r110.setText(r113);
        LiveTextView r114 = this.f106214e;
        if (r114 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("bottomDescTv");
    L105:
        if (r105 == null) goto L107;
        String r115 = r105.a();
    L108:
        if (r115 != null) goto L110;
    L113:
        boolean r116 = true;
    L114:
        if (r116 == false) goto L116;
        String r117 = this.context.getString(R.string.ttlive_recommend_bottom_desc_tv_prima_tips);
    L119:
        r114.setText(r117);
        LiveTextView r118 = this.f106216g;
        if (r118 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("swipeUpTv");
    L122:
        if (r105 == null) goto L124;
        String r119 = r105.e();
    L125:
        if (r119 != null) goto L127;
    L128:
        r101 = true;
    L129:
        if (r101 == false) goto L131;
        String r120 = this.context.getString(R.string.ttlive_recommend_bottom_desc_tv_second_tips);
    L134:
        r118.setText(r120);
        return;
    L131:
        if (r105 == null) goto L133;
        r102 = r105.e();
    L133:
        r120 = r102;
        goto L134
    L127:
        if (StringsKt.isBlank(r119) == false) goto L129;
    L124:
        r119 = null;
        goto L125
    L116:
        if (r105 == null) goto L118;
        r117 = r105.a();
        goto L119
    L118:
        r117 = null;
        goto L119
    L110:
        if (StringsKt.isBlank(r115) == true) goto L113;
        r116 = false;
        goto L114
    L107:
        r115 = null;
        goto L108
    L99:
        if (r105 == null) goto L101;
        r113 = r105.c();
        goto L102
    L101:
        r113 = null;
        goto L102
    L93:
        if (StringsKt.isBlank(r111) == true) goto L96;
        r112 = false;
        goto L97
    L90:
        r111 = null;
        goto L91
    L82:
        if (r105 == null) goto L84;
        r109 = r105.j();
        goto L85
    L84:
        r109 = null;
        goto L85
    L76:
        if (StringsKt.isBlank(r107) == true) goto L79;
        r108 = false;
        goto L80
    L73:
        r107 = null;
        goto L74
    L27:
        if (r103 != null) goto L29;
    L32:
        boolean r121 = true;
    L33:
        if (r121 == true) goto L26;
        if (r104 != null) goto L36;
    L39:
        boolean r122 = true;
    L40:
        if (r122 == true) goto L26;
        String r123 = r103 + '-' + r104;
        h31 r124 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r124 == null) goto L49;
        Map<String, r4> r125 = r124.c();
        if (r125 == null) goto L49;
        if (r125.containsKey(r123) != true) goto L49;
        r105 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a.c().get(r123);
    L49:
        h31 r126 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r126 == null) goto L26;
        Map<String, r4> r127 = r126.c();
        if (r127 == null) goto L26;
        Collection<r4> r128 = r127.values();
        if (r128 == null) goto L26;
        if ((!r128.isEmpty()) == true) goto L59;
        r128 = null;
    L59:
        if (r128 == null) goto L26;
        Iterator<T> r129 = r128.iterator();
    L62:
        if (r129.hasNext() == false) goto L26;
        r4 r130 = (r4) r129.next();
        if (Intrinsics.areEqual(r130.f(), r103) == false) goto L62;
        if (Intrinsics.areEqual(r130.g(), r104) == false) goto L62;
        r105 = r130;
        goto L68
    L36:
        if (r104.length() == 0) goto L39;
        r122 = false;
        goto L40
    L29:
        if (r103.length() == 0) goto L32;
        r121 = false;
        goto L33
    L5:
        if (CollectionsKt.contains(du.f120064a.getValue(), this.B) == false) goto L24;
        String r131 = this.B;
        if (com.bytedance.android.livesdk.chatroom.followrecommendguide.a.b() == false) goto L26;
        if (r131 != null) goto L11;
    L14:
        boolean r132 = true;
    L15:
        if (r132 == true) goto L26;
        h31 r133 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r133 == null) goto L26;
        Map<String, r4> r134 = r133.c();
        if (r134 == null) goto L26;
        if (r134.containsKey(r131) != true) goto L26;
        r105 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a.c().get(r131);
        goto L68
    L11:
        if (r131.length() == 0) goto L14;
        r132 = false;
        goto L15
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f106234y = new Handler(Looper.getMainLooper());
        LinearLayout r101 = this.f106213d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearTop");
    L5:
        r101.setVisibility(8);
        LinearLayout r102 = this.f106212c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linearBottom");
    L8:
        r102.setVisibility(8);
        LiveTextView r103 = this.f106216g;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("swipeUpTv");
    L11:
        r103.setAlpha(0.0f);
        LiveTextView r104 = this.f106217h;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dragDownTv");
    L14:
        r104.setAlpha(0.0f);
    }

    public final void wq(boolean r100) {
        h31 r101 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        ValueAnimator r102 = this.f106230u;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        View r103 = this.f106211b;
        if (r103 == null) goto L8;
        r103.clearAnimation();
    L8:
        View r104 = this.f106211b;
        if (r104 == null) goto L11;
        float r105 = r104.getTranslationY();
    L12:
        int r106 = this.f106232w;
        if (r106 <= 0) goto L15;
        long r107 = (long) ((r105 / r106) * 300);
    L16:
        long r108 = Math.abs(r107);
        if (r108 <= 0) goto L34;
        if (r100 == false) goto L34;
        View r109 = this.f106211b;
        if (r109 == null) goto L23;
        float r110 = r109.getScaleX();
    L24:
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{r105, 0.0f});
        this.f106230u = r111;
        if (r111 == null) goto L27;
        r111.setDuration(r108);
    L27:
        ValueAnimator r112 = this.f106230u;
        if (r112 == null) goto L30;
        r112.addUpdateListener(new b(this, r110));
    L30:
        ValueAnimator r113 = this.f106230u;
        if (r113 == null) goto L45;
        r113.start();
        return;
    L45:
        return;
    L23:
        r110 = 0.9f;
    L34:
        View r114 = this.f106211b;
        if (r114 == null) goto L37;
        r114.setTranslationY(0.0f);
    L37:
        View r115 = this.f106211b;
        if (r115 == null) goto L40;
        r115.setScaleX(1.0f);
    L40:
        View r116 = this.f106211b;
        if (r116 == null) goto L43;
        r116.setScaleY(1.0f);
    L43:
        yq();
        return;
    L15:
        r107 = 0;
        goto L16
    L11:
        r105 = 0.0f;
        goto L12
    }

    public final void xq(boolean r100, boolean r101) {
        h31 r102 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        if (r101 == true) goto L5;
        wq(r100);
    L5:
        this.f106222m = 0.0f;
        View r103 = this.f106211b;
        if (r103 == null) goto L8;
        com.bytedance.android.live.core.utils.r2.a(r103, 0);
    L8:
        this.f106231v = -1;
        this.f106232w = 0;
        this.f106224o = 0.0f;
    }
}
