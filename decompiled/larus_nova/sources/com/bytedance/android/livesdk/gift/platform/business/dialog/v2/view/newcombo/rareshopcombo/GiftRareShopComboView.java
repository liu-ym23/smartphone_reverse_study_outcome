package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.ComboProgressAnimationViewNew;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.EXGaugeLevel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/rareshopcombo/GiftRareShopComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/BaseGiftComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/z;", "", "countDownTime", "", "setCountDownTime", "", "isGroupSend", "setIsGroupSend", "isSeriesSend", "setIsSeriesSend", "", "count", "setComboCount", "", "giftType", "setGiftType", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/EXGaugeLevel;", "getCurrentEXGaugeLevel", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftRareShopComboView extends BaseGiftComboView implements z {
    public Animator A;
    public AnimatedDrawable2 B;
    public AnimatedDrawable2 C;
    public int D;
    public long E;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h F;
    public float G;
    public final boolean H;
    public final GiftRareShopComboHeatHelper I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f126887J;
    public Disposable K;
    public boolean L;
    public final d M;
    public final b N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f126888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f126889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f126890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f126891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f126892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f126893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f126894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f126895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ComboProgressAnimationViewNew f126896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HSImageView f126897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HSImageView f126898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HSImageView f126899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public GiftRareShopComboWaveView f126900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HSImageView f126901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f126902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f126903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatorSet f126904q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f> f126905r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnimatedDrawable2 f126906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animator f126907t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f126908u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Animator f126909v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Animator f126910w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AnimatorSet f126911x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AnimatedDrawable2 f126912y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AnimatedDrawable2 f126913z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftRareShopComboView f126914a;

        public b(GiftRareShopComboView r100) {
            this.f126914a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            if (((Boolean) r110).booleanValue() == false) goto L36;
            GiftRareShopComboView r111 = this.f126914a;
            r111.L = false;
            AnimatorSet r100 = r111.f126908u;
            if (r100 == null) goto L7;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r100);
        L7:
            AnimatorSet r101 = r111.f126911x;
            if (r101 == null) goto L10;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r101);
        L10:
            View r102 = r111.f126889b;
            if (r102 == null) goto L18;
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r102, View.TRANSLATION_Y, new float[]{UtilityKotlinExtentionsKt.h(16.0f)}).setDuration(250);
            ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, View.SCALE_X, new float[]{0.5f}).setDuration(250);
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r102, View.SCALE_Y, new float[]{0.5f}).setDuration(250);
            AnimatorSet r106 = new AnimatorSet();
            r106.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f));
            Unit r107 = Unit.INSTANCE;
            r111.f126908u = r106;
            r106.playTogether(new Animator[]{r103, r104, r105});
            AnimatorSet r108 = r111.f126908u;
            if (r108 == null) goto L15;
            r108.addListener(new n(r111));
        L15:
            AnimatorSet r109 = r111.f126908u;
            if (r109 == null) goto L18;
            r109.start();
        L18:
            ArrayList r112 = new ArrayList();
            View r113 = r111.f126895h;
            if (r113 == null) goto L21;
            r112.add(r111.h(r113));
        L21:
            View r114 = r111.f126894g;
            if (r114 == null) goto L24;
            r112.add(r111.h(r114));
        L24:
            View r115 = r111.f126893f;
            if (r115 == null) goto L27;
            r112.add(r111.h(r115));
        L27:
            View r116 = r111.f126892e;
            if (r116 == null) goto L30;
            r112.add(r111.h(r116));
        L30:
            AnimatorSet r117 = new AnimatorSet();
            r111.f126911x = r117;
            r117.playSequentially(r112);
            Animator r118 = r111.A;
            if (r118 != null) goto L33;
        L35:
            ObjectAnimator r119 = ObjectAnimator.ofFloat(r111.f126902o, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(200);
            r119.addListener(new j(r111));
            r119.start();
            Unit r120 = Unit.INSTANCE;
            r111.A = r119;
            return;
        L33:
            if (r118.isRunning() != true) goto L35;
            return;
        L36:
            GiftRareShopComboView r121 = this.f126914a;
            HSImageView r122 = r121.f126902o;
            if (r122 == null) goto L39;
            r122.setVisibility(8);
        L39:
            HSImageView r123 = r121.f126899l;
            if (r123 == null) goto L42;
            r123.setVisibility(8);
        L42:
            AnimatedDrawable2 r124 = r121.C;
            if (r124 == null) goto L45;
            r124.stop();
        L45:
            AnimatedDrawable2 r125 = r121.f126913z;
            if (r125 == null) goto L48;
            r125.stop();
        L48:
            AnimatorSet r126 = r121.f126908u;
            if (r126 == null) goto L51;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r126);
        L51:
            AnimatorSet r127 = r121.f126911x;
            if (r127 == null) goto L54;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r127);
        L54:
            View r128 = r121.f126895h;
            if (r128 == null) goto L57;
            r128.setVisibility(8);
        L57:
            View r129 = r121.f126894g;
            if (r129 == null) goto L60;
            r129.setVisibility(8);
        L60:
            View r130 = r121.f126893f;
            if (r130 == null) goto L63;
            r130.setVisibility(8);
        L63:
            View r131 = r121.f126892e;
            if (r131 == null) goto L66;
            r131.setVisibility(8);
        L66:
            View r132 = r121.f126889b;
            if (r132 != null) goto L69;
            return;
        L69:
            if (r132.getScaleX() == 1.0f) goto L71;
            boolean r133 = true;
        L72:
            if (r133 == true) goto L75;
            r132 = null;
        L75:
            if (r132 == null) goto L82;
            ObjectAnimator r134 = ObjectAnimator.ofFloat(r132, View.TRANSLATION_Y, new float[]{0.0f}).setDuration(250);
            ObjectAnimator r135 = ObjectAnimator.ofFloat(r132, View.SCALE_X, new float[]{1.0f}).setDuration(250);
            ObjectAnimator r136 = ObjectAnimator.ofFloat(r132, View.SCALE_Y, new float[]{1.0f}).setDuration(250);
            AnimatorSet r137 = new AnimatorSet();
            r121.f126908u = r137;
            r137.playTogether(new Animator[]{r134, r135, r136});
            AnimatorSet r138 = r121.f126908u;
            if (r138 == null) goto L83;
            r138.start();
            return;
        L83:
            return;
        L82:
            return;
        L71:
            r133 = false;
            goto L72
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftRareShopComboView f126915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f126916b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f126916b.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            this.f126916b.setVisibility(0);
            AnimatedDrawable2 r101 = this.f126915a.f126913z;
            if (r101 != null) goto L5;
        L8:
            GiftRareShopComboView r102 = this.f126915a;
            HSImageView r103 = r102.f126899l;
            if (r103 == null) goto L11;
            r103.setVisibility(r102.getVisibility());
        L11:
            AnimatedDrawable2 r104 = r102.C;
            if (r104 != null) goto L14;
            return;
        L14:
            if (r104.isRunning() == false) goto L16;
            r104.stop();
        L16:
            r104.start();
            return;
        L5:
            if (r101.isRunning() == false) goto L7;
            r101.stop();
        L7:
            r101.start();
            goto L8
        }

        public c(GiftRareShopComboView r100, View r101) {
            this.f126915a = r100;
            this.f126916b = r101;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftRareShopComboView f126917a;

        public d(GiftRareShopComboView r100) {
            this.f126917a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L32;
            final GiftRareShopComboView r101 = this.f126917a;
            AnimatedDrawable2 r102 = r101.f126906s;
            if (r102 != null) goto L7;
        L8:
            HSImageView r103 = r101.f126897j;
            if (r103 != null) goto L11;
        L12:
            Animator r104 = r101.f126907t;
            if (r104 == null) goto L15;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r104);
        L15:
            HSImageView r105 = r101.f126897j;
            if (r105 == null) goto L18;
            ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(800);
            Function1<Animator, Unit> r107 = new GiftRareShopComboView$playEndEffectAnimation$$inlined$let$lambda$1(r101);
            Intrinsics.checkNotNullParameter(r106, "$this$doOnNormalEnd");
            Intrinsics.checkNotNullParameter(r107, "action");
            r106.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.b(r107));
        L19:
            r101.f126907t = r106;
            if (r106 == null) goto L22;
            r106.start();
        L22:
            Animator r108 = r101.f126909v;
            if (r108 == null) goto L25;
            com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r108);
        L25:
            Animator r109 = r101.f126910w;
            if (r109 != null) goto L28;
        L30:
            ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{r101.G, 0.0f});
            r110.setDuration((long) (r101.G * 2000));
            r110.addUpdateListener(new o(r101));
            Unit r111 = Unit.INSTANCE;
            r101.f126910w = r110;
            r110.start();
            return;
        L28:
            if (r109.isRunning() != true) goto L30;
            return;
        L18:
            r106 = null;
            goto L19
        L11:
            if (r103.getAlpha() == 0.0f) goto L22;
        L7:
            if (r102.isRunning() == true) goto L12;
        }
    }

    static {
    }

    public GiftRareShopComboView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftRareShopComboView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void a(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void b(h2 r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setCountDownTime(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setGiftType(String r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void f() {
        View r100 = this.f126890c;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        View r101 = this.f126891d;
        if (r101 == null) goto L8;
        r101.setVisibility(0);
    L8:
        this.f126889b = this.f126891d;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void g() {
        View r100 = this.f126890c;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        View r101 = this.f126891d;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        this.f126889b = this.f126890c;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z
    public EXGaugeLevel getCurrentEXGaugeLevel() {
        return this.F.f126865c;
    }

    public final void i() {
        this.I.f126884c.removeObserver(this.M);
        this.I.f126885d.removeObserver(this.N);
        Animator r100 = this.f126907t;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r100);
    L5:
        AnimatorSet r101 = this.f126904q;
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r101);
    L8:
        AnimatorSet r102 = this.f126908u;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r102);
    L11:
        Animator r103 = this.f126909v;
        if (r103 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r103);
    L14:
        Animator r104 = this.f126910w;
        if (r104 == null) goto L17;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r104);
    L17:
        AnimatorSet r105 = this.f126911x;
        if (r105 == null) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r105);
    L20:
        Animator r106 = this.A;
        if (r106 == null) goto L23;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r106);
    L23:
        GiftRareShopComboHeatHelper r107 = this.I;
        AnimatorSet r108 = r107.f126883b;
        if (r108 == null) goto L26;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r108);
    L26:
        AnimatorSet r109 = r107.f126883b;
        if (r109 == null) goto L36;
        ArrayList<Animator> r110 = r109.getChildAnimations();
        if (r110 == null) goto L36;
        Iterator<T> r111 = r110.iterator();
    L32:
        if (r111.hasNext() == false) goto L36;
        Animator r112 = (Animator) r111.next();
        if ((r112 instanceof ValueAnimator) == false) goto L32;
        r112.removeAllListeners();
        ((ValueAnimator) r112).removeAllUpdateListeners();
    L36:
        Animator r113 = r107.f126882a;
        if (r113 == null) goto L39;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r113);
    L39:
        r107.f126883b = null;
        r107.f126882a = null;
        ComboProgressAnimationViewNew r114 = this.f126896i;
        if (r114 == null) goto L42;
        r114.g();
    L42:
        AnimatedDrawable2 r115 = this.f126906s;
        if (r115 == null) goto L45;
        r115.stop();
    L45:
        AnimatedDrawable2 r116 = this.f126912y;
        if (r116 == null) goto L48;
        r116.stop();
    L48:
        AnimatedDrawable2 r117 = this.f126913z;
        if (r117 == null) goto L51;
        r117.stop();
    L51:
        AnimatedDrawable2 r118 = this.C;
        if (r118 == null) goto L54;
        r118.stop();
    L54:
        AnimatedDrawable2 r119 = this.B;
        if (r119 == null) goto L63;
        r119.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void d() {
        i();
        Iterator r100 = ((ArrayList) this.f126905r).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f) r100.next()).b(true);
        goto L4
    L6:
        GiftRareShopComboWaveView r101 = this.f126900m;
        if (r101 == null) goto L11;
        r101.removeAllViews();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
        Iterator<T> r100 = this.f126905r.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f) r100.next()).b(false);
        goto L4
    }

    public final AnimatorSet h(View r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, View.SCALE_X, new float[]{0.8f, 1.0f}).setDuration(1000);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, View.SCALE_Y, new float[]{0.8f, 1.0f}).setDuration(1000);
        r102.addListener(new c(this, r100));
        AnimatorSet r103 = new AnimatorSet();
        r103.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        r103.playTogether(new Animator[]{r101, r102});
        return r103;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setComboCount(int r100) {
        this.D = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsGroupSend(boolean r100) {
        ComboProgressAnimationViewNew r101 = this.f126896i;
        if (r101 == null) goto L6;
        r101.setGroupSend(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsSeriesSend(boolean r100) {
        ComboProgressAnimationViewNew r101 = this.f126896i;
        if (r101 == null) goto L6;
        r101.setSeriesSend(r100);
        return;
    }

    public GiftRareShopComboView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.f126905r = new ArrayList();
        this.E = b02.a.a();
        this.F = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h();
        this.H = true;
        GiftRareShopComboHeatHelper r103 = new GiftRareShopComboHeatHelper(this.E);
        this.I = r103;
        this.f126887J = true;
        d r104 = new d(this);
        this.M = r104;
        b r105 = new b(this);
        this.N = r105;
        FrameLayout.inflate(r100, R.layout.ttlive_base_gift_combo_view_for_rare_shop, this);
        this.f126897j = (HSImageView) findViewById(R.id.combo_arrow_effect_container);
        ComboProgressAnimationViewNew r106 = (ComboProgressAnimationViewNew) findViewById(R.id.combo_progress);
        r106.setComboButtonStyle(1);
        Unit r107 = Unit.INSTANCE;
        this.f126896i = r106;
        this.f126898k = (HSImageView) findViewById(R.id.background_wave_anim_view);
        this.f126899l = (HSImageView) findViewById(R.id.background_count_down_wave_anim_view);
        GiftRareShopComboWaveView r108 = (GiftRareShopComboWaveView) findViewById(R.id.wave_anim_view);
        if (r108 == null) goto L8;
        c0 r109 = c0.f127389d;
        r109.getClass();
        if (((f0) c0.f127387b.getValue(r109, c0.f127386a[0])).a() == true) goto L9;
        r108.f126918a = s1.m(R.drawable.ttlive_gift_rare_shop_combo_heat_gradient);
    L9:
        this.f126900m = r108;
        this.f126903p = findViewById(R.id.location_view);
        this.f126888a = findViewById(R.id.combo_bg);
        this.f126901n = (HSImageView) findViewById(R.id.combo_bg_wave_anim_view);
        this.f126902o = (HSImageView) findViewById(R.id.combo_bg_count_down_wave_anim_view);
        this.f126890c = findViewById(R.id.combo_title);
        this.f126891d = findViewById(R.id.long_combo_title);
        this.f126889b = this.f126890c;
        this.f126892e = findViewById(R.id.count_down_0);
        this.f126893f = findViewById(R.id.count_down_1);
        this.f126894g = findViewById(R.id.count_down_2);
        this.f126895h = findViewById(R.id.count_down_3);
        this.E = b02.a.a();
        HSImageView r110 = this.f126897j;
        if (r110 == null) goto L12;
        r110.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_base_gift_big_combo_arrow_effect.webp").setControllerListener(new e(this)).build());
    L12:
        HSImageView r111 = this.f126901n;
        if (r111 == null) goto L15;
        r111.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_wave_anim.webp").setControllerListener(new f(this)).build());
    L15:
        HSImageView r112 = this.f126902o;
        if (r112 == null) goto L18;
        r112.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_count_down_wave_anim.webp").setControllerListener(new g(this)).build());
    L18:
        HSImageView r113 = this.f126898k;
        if (r113 == null) goto L21;
        r113.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_background_wave_anim.webp").setControllerListener(new h(this)).build());
    L21:
        HSImageView r114 = this.f126899l;
        if (r114 == null) goto L24;
        r114.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_rare_shop_combo_background_count_down_anim.webp").setControllerListener(new i(this)).build());
    L24:
        r103.f126884c.observeForever(r104);
        r103.f126885d.observeForever(r105);
        return;
    L8:
        r108 = null;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void c(Runnable r110, int r111, int r112) {
        int r100 = this.D;
        if (r100 == 0) goto L163;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h r101 = this.F;
        Boolean r102 = this.I.f126884c.getValue();
        if (r102 != null) goto L8;
        r102 = Boolean.FALSE;
    L8:
        r101.a(r100, r102.booleanValue());
        AnimatorSet r103 = this.f126904q;
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r103);
    L11:
        View r104 = this.f126889b;
        if (r104 == null) goto L14;
        r104.setVisibility(0);
    L14:
        View r105 = this.f126888a;
        if (r105 == null) goto L17;
        r105.setVisibility(0);
    L17:
        this.f126904q = new AnimatorSet();
        View r106 = this.f126888a;
        ObjectAnimator r107 = null;
        if (r106 == null) goto L20;
        AnimatorSet r108 = com.bytedance.android.live.revenue.common.e.c(r106, new float[]{r106.getScaleX(), 0.8f}).setDuration(100);
    L21:
        View r109 = this.f126889b;
        if (r109 == null) goto L24;
        AnimatorSet r113 = com.bytedance.android.live.revenue.common.e.c(r109, new float[]{r109.getScaleX(), 0.8f}).setDuration(100);
    L25:
        AnimatorSet r114 = new AnimatorSet();
        r114.playTogether(new Animator[]{r108, r113});
        View r115 = this.f126888a;
        if (r115 == null) goto L28;
        AnimatorSet r116 = com.bytedance.android.live.revenue.common.e.c(r115, new float[]{0.8f, 1.0f}).setDuration(400);
        r116.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L29:
        View r117 = this.f126889b;
        if (r117 == null) goto L32;
        AnimatorSet r118 = com.bytedance.android.live.revenue.common.e.c(r117, new float[]{0.8f, 1.0f}).setDuration(400);
        r118.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L33:
        AnimatorSet r119 = new AnimatorSet();
        r119.playTogether(new Animator[]{r116, r118, ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.E)});
        AnimatorSet r120 = this.f126904q;
        if (r120 == null) goto L36;
        r120.playSequentially(new Animator[]{r114, r119});
    L36:
        AnimatorSet r121 = this.f126904q;
        if (r121 == null) goto L39;
        r121.addListener(new l(this, (com.bytedance.android.livesdk.gift.biggift.view.d) r110));
    L39:
        AnimatorSet r122 = this.f126904q;
        if (r122 == null) goto L43;
        r122.start();
    L43:
        if (this.f126887J == false) goto L49;
        this.f126887J = false;
        AnimatedDrawable2 r123 = this.f126912y;
        if (r123 == null) goto L47;
        r123.start();
    L48:
        this.K = Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this));
    L60:
        if (this.D <= 0) goto L161;
        EXGaugeLevel r124 = this.F.f126865c;
        EXGaugeLevel r125 = EXGaugeLevel.HEATED;
        if (r124 != r125) goto L73;
        Animator r126 = this.f126910w;
        if (r126 == null) goto L66;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r126);
    L66:
        Animator r127 = this.f126909v;
        if (r127 != null) goto L69;
    L71:
        Drawable r128 = s1.m(R.drawable.ttlive_gift_rare_shop_combo_bg);
        Drawable r129 = s1.m(R.drawable.ttlive_gift_rare_shop_combo_button_high_light);
        ValueAnimator r130 = ValueAnimator.ofFloat(new float[]{this.G, 1.0f});
        r130.setDuration((long) ((1.0f - this.G) * 2000));
        r130.addUpdateListener(new k(this, r129, r128));
        Unit r131 = Unit.INSTANCE;
        this.f126909v = r130;
        r130.start();
        goto L73
    L69:
        if (r127.isRunning() != true) goto L71;
    L73:
        if (this.H == false) goto L113;
        AnimatedDrawable2 r132 = this.f126906s;
        if (r132 == null) goto L79;
        if (r132.isRunning() != true) goto L79;
    L99:
        if (getParent() == null) goto L113;
        int[] r133 = {0, 0};
        View r134 = this.f126903p;
        if (r134 == null) goto L104;
        r134.getLocationOnScreen(r133);
    L104:
        PointF r135 = new PointF(r133[0] + UtilityKotlinExtentionsKt.h(35.0f), r133[1] + UtilityKotlinExtentionsKt.h(8.5f));
        PointF r136 = new PointF(r135.x - UtilityKotlinExtentionsKt.h(33.0f), r135.y - UtilityKotlinExtentionsKt.h(113.0f));
        ViewParent r137 = getParent();
        if (r137 == null) goto L112;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f r138 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f(r135, r136, (ViewGroup) r137, getContext(), 1);
        ((ArrayList) this.f126905r).add(r138);
        if (this.F.f126865c != EXGaugeLevel.OVERHEATED) goto L109;
        boolean r139 = true;
    L110:
        r138.a(r139, true);
        goto L113
    L109:
        r139 = false;
        goto L110
    L112:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L79:
        if (this.F.f126865c != EXGaugeLevel.OVERHEATED) goto L99;
        HSImageView r140 = this.f126897j;
        if (r140 == null) goto L83;
        r140.setVisibility(0);
    L83:
        AnimatedDrawable2 r141 = this.f126906s;
        if (r141 == null) goto L86;
        com.bytedance.android.live.core.utils.fresco.c.b(r141);
    L86:
        AnimatedDrawable2 r142 = this.f126906s;
        if (r142 == null) goto L89;
        r142.start();
    L89:
        Animator r143 = this.f126907t;
        if (r143 == null) goto L92;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r143);
    L92:
        HSImageView r144 = this.f126897j;
        if (r144 == null) goto L95;
        r107 = ObjectAnimator.ofFloat(r144, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(250);
    L95:
        this.f126907t = r107;
        if (r107 == null) goto L99;
        r107.start();
    L113:
        AnimatedDrawable2 r145 = this.B;
        if (r145 != null) goto L116;
    L118:
        GiftRareShopComboWaveView r146 = this.f126900m;
        if (r146 == null) goto L135;
        EXGaugeLevel r147 = this.F.f126865c;
        if (r147 != r125) goto L123;
    L126:
        boolean r148 = true;
    L127:
        if (r148 == false) goto L135;
        c0 r149 = c0.f127389d;
        r149.getClass();
        if (((f0) c0.f127387b.getValue(r149, c0.f127386a[0])).a() == true) goto L132;
    L134:
        View r150 = new View(r146.getContext());
        r150.setBackground(r146.f126918a);
        FrameLayout.LayoutParams r151 = new FrameLayout.LayoutParams(s1.f(128.0f), s1.f(128.0f));
        r151.gravity = 17;
        Unit r152 = Unit.INSTANCE;
        r150.setLayoutParams(r151);
        r150.setAlpha(1.0f);
        r150.setScaleX(0.88f);
        r150.setScaleY(0.88f);
        r146.addView(r150);
        r150.animate().alpha(0.0f).scaleX(1.3f).scaleY(1.3f).setDuration(1030).setListener(new p(r146, r150)).start();
        goto L135
    L132:
        if (r146.f126918a != null) goto L134;
        r146.f126918a = s1.m(R.drawable.ttlive_gift_rare_shop_combo_heat_gradient);
        goto L134
    L123:
        if (r147 == EXGaugeLevel.OVERHEATED) goto L126;
        r148 = false;
    L135:
        ComboProgressAnimationViewNew r153 = this.f126896i;
        if (r153 == null) goto L138;
        r153.setVisibility(0);
    L138:
        ComboProgressAnimationViewNew r154 = this.f126896i;
        if (r154 == null) goto L141;
        r154.e(this.D, r112);
    L141:
        ComboProgressAnimationViewNew r155 = this.f126896i;
        if (r155 == null) goto L144;
        r155.f();
    L144:
        GiftRareShopComboHeatHelper r156 = this.I;
        AnimatorSet r157 = r156.f126883b;
        if (r157 == null) goto L147;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r157);
    L147:
        ValueAnimator r158 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r158.setDuration(250);
        r158.addUpdateListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.b(r156));
        Ref.FloatRef r159 = new Ref.FloatRef();
        r159.element = 0.0f;
        ValueAnimator r160 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r160.setDuration(r156.f126886e);
        r160.addUpdateListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.c(r160, r156, r159));
        r160.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.d(r156));
        AnimatorSet r161 = new AnimatorSet();
        r156.f126883b = r161;
        r161.playSequentially(new Animator[]{r158, r160});
        AnimatorSet r162 = r156.f126883b;
        if (r162 == null) goto L150;
        r162.start();
    L150:
        EXGaugeLevel r163 = this.F.f126865c;
        if (r163 != r125) goto L153;
    L154:
        GiftRareShopComboHeatHelper r164 = this.I;
        Animator r165 = r164.f126882a;
        if (r165 != null) goto L157;
    L159:
        ValueAnimator r166 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r166.setDuration(2500);
        r166.addListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo.a(r164));
        Unit r167 = Unit.INSTANCE;
        r164.f126882a = r166;
        r166.start();
        return;
    L157:
        if (r165.isRunning() != true) goto L159;
        return;
    L153:
        if (r163 == EXGaugeLevel.OVERHEATED) goto L154;
        return;
    L116:
        if (r145.isRunning() == true) goto L118;
        r145.start();
        goto L118
    L161:
        return;
    L47:
        this.L = true;
        goto L48
    L49:
        this.L = false;
        AnimatedDrawable2 r168 = this.f126912y;
        if (r168 == null) goto L60;
        AnimationBackend r169 = r168.getAnimationBackend();
        if (r169 != null) goto L54;
    L55:
        r168.setAnimationBackend(new q(r168.getAnimationBackend()));
        r168.stop();
    L57:
        if (r168.isRunning() == true) goto L60;
        r168.start();
        goto L60
    L54:
        if (r169.getLoopCount() == 1) goto L57;
    L32:
        r118 = null;
        goto L33
    L28:
        r116 = null;
        goto L29
    L24:
        r113 = null;
        goto L25
    L20:
        r108 = null;
        goto L21
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void e(h2 r100, l1 r101, com.bytedance.android.livesdk.gift.model.n r102) {
        ComboProgressAnimationViewNew r103 = this.f126896i;
        if (r103 == null) goto L6;
        r103.setGift(r100);
        r103.setBuffInfo(r101);
        r103.setDiyInfo(r102);
        return;
    }

    public /* synthetic */ GiftRareShopComboView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
