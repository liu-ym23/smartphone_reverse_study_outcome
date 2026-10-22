package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/GiftComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/BaseGiftComboView;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/z;", "", "getCountDownTime", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/EXGaugeLevel;", "getCurrentEXGaugeLevel", "countDownTime", "", "setCountDownTime", "", "isGroupSend", "setIsGroupSend", "isSeriesSend", "setIsSeriesSend", "", "count", "setComboCount", "", "giftType", "setGiftType", "RecommendStatus", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftComboView extends BaseGiftComboView implements z {
    public static final /* synthetic */ int R = 0;
    public final boolean A;
    public AnimatorSet B;
    public AnimatorSet C;
    public Runnable D;
    public RecommendStatus E;
    public View F;
    public TextView G;
    public View H;
    public ImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public TextView f126805J;
    public TextView K;
    public long L;
    public Disposable M;
    public Disposable N;
    public final t O;
    public final s P;
    public final boolean Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f126806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f126807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f126808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f126809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f126810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f126811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f126812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f126813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f126814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HSImageView f126815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnimatorSet f126816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ComboProgressAnimationViewNew f126817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ComboWaveView f126818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GiftComboProgressBar f126819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f126820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f> f126821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Animator f126822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Animator f126823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnimatedDrawable2 f126824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AnimatorSet f126825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f126826u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Animator f126827v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f126828w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f126829x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f126830y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h f126831z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/GiftComboView$RecommendStatus;", "", "Idle", "OnlyCount", "Gift", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RecommendStatus extends Enum<RecommendStatus> {
        public static final RecommendStatus Gift = null;
        public static final RecommendStatus Idle = null;
        public static final RecommendStatus OnlyCount = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecommendStatus[] f126832a = null;

        static {
            RecommendStatus r100 = new RecommendStatus("Idle", 0);
            Idle = r100;
            RecommendStatus r101 = new RecommendStatus("OnlyCount", 1);
            OnlyCount = r101;
            RecommendStatus r102 = new RecommendStatus("Gift", 2);
            Gift = r102;
            f126832a = new RecommendStatus[]{r100, r101, r102};
        }

        public static RecommendStatus valueOf(String r100) {
            return (RecommendStatus) r27.a.a(RecommendStatus.class, r100);
        }

        public static RecommendStatus[] values() {
            return (RecommendStatus[]) f126832a.clone();
        }

        public RecommendStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f126834b;

        public a(GiftComboView r100, long r101) {
            this.f126833a = r100;
            this.f126834b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            TextView r102 = this.f126833a.G;
            if (r102 == null) goto L5;
            r102.setText("X" + this.f126834b);
        L5:
            TextView r103 = this.f126833a.K;
            if (r103 == null) goto L9;
            r103.setText("X" + this.f126834b);
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h2 f126836b;

        public b(GiftComboView r100, h2 r101) {
            this.f126835a = r100;
            this.f126836b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ImageUtil.loadImage(this.f126835a.I, this.f126836b.getImage(), 0);
            com.bytedance.android.livesdk.gift.platform.business.config.j r102 = com.bytedance.android.livesdk.gift.util.b.a();
            GiftConfigKey r103 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
            DiamondConfig.f126567d.getClass();
            DiamondConfig r104 = (DiamondConfig) r102.c(r103, DiamondConfig.a.a());
            TextView r105 = this.f126835a.f126805J;
            if (r105 == null) goto L6;
            r105.setText(String.valueOf(this.f126836b.getDiamondCount()) + r104.f126569b);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126837a;

        public c(GiftComboView r100) {
            this.f126837a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            TextView r102 = this.f126837a.K;
            if (r102 == null) goto L6;
            r102.setText("X1");
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126838a;

        public d(GiftComboView r100) {
            this.f126838a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GiftComboView r100 = this.f126838a;     // Catch: Throwable -> L4
            int r101 = GiftComboView.R;     // Catch: Throwable -> L4
            r100.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f126839a;

        public e(View r100) {
            this.f126839a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f126839a.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            this.f126839a.setVisibility(0);
        }
    }

    public static final class f extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f126840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126841b;

        public f(GiftComboView r100) {
            this.f126841b = r100;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f126840a = true;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f126840a == false) goto L5;
            return;
        L5:
            Runnable r101 = this.f126841b.D;
            if (r101 == null) goto L8;
            r101.run();
        L8:
            this.f126841b.setVisibility(8);
            System.currentTimeMillis();
            this.f126840a = false;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            System.currentTimeMillis();
        }
    }

    public static final class g extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f126843b;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f126842a.f126807b;
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }

        public g(GiftComboView r100, View r101) {
            this.f126842a = r100;
            this.f126843b = r101;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r102 = this.f126843b;
            if (r102 == null) goto L6;
            r102.setVisibility(0);
            return;
        }
    }

    public static final class h extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftComboView f126844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f126845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f126846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f126847d;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if ((!Intrinsics.areEqual(this.f126845b, this.f126846c)) == false) goto L11;
            View r101 = this.f126845b;
            if (r101 == null) goto L7;
            r101.setVisibility(8);
        L7:
            View r102 = this.f126846c;
            if (r102 == null) goto L11;
            r102.setVisibility(0);
        L11:
            if (this.f126847d == false) goto L14;
            GiftComboView r103 = this.f126844a;
            int r104 = GiftComboView.R;
            r103.l();
            return;
        }

        public h(GiftComboView r100, View r101, View r102, boolean r103) {
            this.f126844a = r100;
            this.f126845b = r101;
            this.f126846c = r102;
            this.f126847d = r103;
        }
    }

    public GiftComboView(Context r100) {
        this(r100, null, 0, 14);
    }

    public GiftComboView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public GiftComboView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    public final void k() {
        j(true);
        AnimatorSet r100 = this.f126816k;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r100);
    L5:
        AnimatorSet r101 = this.f126816k;
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r101);
    L8:
        this.f126816k = new AnimatorSet();
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.f126830y);
        AnimatorSet r103 = this.f126816k;
        if (r103 == null) goto L11;
        r103.playTogether(new Animator[]{r102});
    L11:
        AnimatorSet r104 = this.f126816k;
        if (r104 == null) goto L14;
        r104.addListener(new f(this));
    L14:
        AnimatorSet r105 = this.f126816k;
        if (r105 == null) goto L18;
        r105.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setCountDownTime(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setGiftType(String r100) {
    }

    private final long getCountDownTime() {
        if (this.Q == true) goto L7;
        KProperty[] r100 = b02.a.f16821a;
        return com.bytedance.android.livesdk.gift.platform.business.j.b().M7() * 1000;
    L7:
        return b02.a.a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void d() {
        AnimatorSet r100 = this.f126816k;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r100);
    L5:
        Animator r101 = this.f126822q;
        if (r101 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r101);
    L8:
        Animator r102 = this.f126823r;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r102);
    L11:
        AnimatorSet r103 = this.f126825t;
        if (r103 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r103);
    L14:
        AnimatorSet r104 = this.f126826u;
        if (r104 == null) goto L17;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r104);
    L17:
        Animator r105 = this.f126827v;
        if (r105 == null) goto L20;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r105);
    L20:
        AnimatorSet r106 = this.B;
        if (r106 == null) goto L23;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r106);
    L23:
        AnimatorSet r107 = this.B;
        if (r107 == null) goto L26;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r107);
    L26:
        AnimatorSet r108 = this.C;
        if (r108 == null) goto L29;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r108);
    L29:
        AnimatorSet r109 = this.C;
        if (r109 == null) goto L32;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r109);
    L32:
        Disposable r110 = this.M;
        if (r110 == null) goto L35;
        r110.dispose();
    L35:
        this.M = null;
        Disposable r111 = this.N;
        if (r111 == null) goto L38;
        r111.dispose();
    L38:
        this.M = null;
        ComboWaveView r112 = this.f126818m;
        if (r112 == null) goto L41;
        r112.removeAllViews();
    L41:
        GiftComboProgressBar r113 = this.f126819n;
        if (r113 == null) goto L63;
        AnimatorSet r114 = r113.f126787h;
        if (r114 == null) goto L46;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r114);
    L46:
        AnimatorSet r115 = r113.f126787h;
        if (r115 == null) goto L56;
        ArrayList<Animator> r116 = r115.getChildAnimations();
        if (r116 == null) goto L56;
        Iterator<T> r117 = r116.iterator();
    L52:
        if (r117.hasNext() == false) goto L56;
        Animator r118 = (Animator) r117.next();
        if ((r118 instanceof ValueAnimator) == false) goto L52;
        r118.removeAllListeners();
        ((ValueAnimator) r118).removeAllUpdateListeners();
    L56:
        Animator r119 = r113.f126797r;
        if (r119 == null) goto L59;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r119);
    L59:
        Animator r120 = r113.f126799t;
        if (r120 == null) goto L62;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r120);
    L62:
        r113.f126787h = null;
        r113.f126797r = null;
        r113.f126799t = null;
        r113.f126786g = 0.0f;
        r113.f126798s = 0.0f;
        r113.f126802w = 0.0f;
    L63:
        ComboProgressAnimationViewNew r121 = this.f126817l;
        if (r121 == null) goto L66;
        r121.g();
    L66:
        AnimatedDrawable2 r122 = this.f126824s;
        if (r122 == null) goto L69;
        r122.stop();
    L69:
        Iterator<T> r123 = this.f126821p.iterator();
    L71:
        if (r123.hasNext() == false) goto L73;
        ((com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f) r123.next()).b(true);
        goto L71
    L73:
        HSImageView r124 = this.f126820o;
        if (r124 == null) goto L76;
        r124.setVisibility(4);
    L76:
        HSImageView r125 = this.f126815j;
        if (r125 == null) goto L79;
        r125.setVisibility(4);
    L79:
        HSImageView r126 = this.f126815j;
        if (r126 == null) goto L82;
        r126.setAlpha(0.0f);
    L82:
        this.f126828w = 0;
        this.f126829x = 0.0f;
        this.E = RecommendStatus.Idle;
        View r127 = this.f126807b;
        if (r127 == null) goto L85;
        r127.setScaleX(1.0f);
    L85:
        View r128 = this.f126807b;
        if (r128 == null) goto L88;
        r128.setScaleY(1.0f);
    L88:
        View r129 = this.f126807b;
        if (r129 == null) goto L91;
        r129.setAlpha(1.0f);
    L91:
        View r130 = this.f126807b;
        if (r130 == null) goto L101;
        r130.setTranslationY(0.0f);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void f() {
        if (this.E != RecommendStatus.Idle) goto L12;
        View r100 = this.f126808c;
        if (r100 == null) goto L7;
        r100.setVisibility(8);
    L7:
        View r101 = this.f126809d;
        if (r101 == null) goto L10;
        r101.setVisibility(0);
    L10:
        this.f126807b = this.f126809d;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void g() {
        if (this.E != RecommendStatus.Idle) goto L12;
        View r100 = this.f126808c;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
    L7:
        View r101 = this.f126809d;
        if (r101 == null) goto L10;
        r101.setVisibility(8);
    L10:
        this.f126807b = this.f126808c;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.z
    public EXGaugeLevel getCurrentEXGaugeLevel() {
        return this.f126831z.f126865c;
    }

    public final void l() {
        if (this.E != RecommendStatus.Gift) goto L29;
        AnimatorSet r100 = this.C;
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r100);
    L7:
        AnimatorSet r101 = this.C;
        if (r101 == null) goto L10;
        r101.cancel();
    L10:
        this.C = new AnimatorSet();
        TextView r102 = this.f126805J;
        if (r102 == null) goto L13;
        r102.setAlpha(1.0f);
    L13:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f126805J, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r104 = this.C;
        if (r104 == null) goto L16;
        r104.playTogether(new Animator[]{r103});
    L16:
        AnimatorSet r105 = this.C;
        if (r105 == null) goto L19;
        r105.setStartDelay(1350);
    L19:
        AnimatorSet r106 = this.C;
        if (r106 == null) goto L22;
        r106.setDuration(300);
    L22:
        AnimatorSet r107 = this.C;
        if (r107 == null) goto L25;
        r107.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L25:
        AnimatorSet r108 = this.C;
        if (r108 == null) goto L30;
        r108.start();
        return;
    L30:
        return;
    }

    public final void m() {
        AnimatorSet r100 = this.f126826u;
        if (r100 != null) goto L5;
    L6:
        AnimatorSet r101 = this.f126825t;
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L49;
        AnimatorSet r103 = this.f126825t;
        if (r103 == null) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r103);
    L16:
        AnimatorSet r104 = this.f126826u;
        if (r104 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r104);
    L19:
        View r105 = this.f126807b;
        if (r105 == null) goto L22;
        r105.setVisibility(8);
    L22:
        View r106 = this.f126810e;
        if (r106 == null) goto L25;
        r106.setVisibility(8);
    L25:
        View r107 = this.f126811f;
        if (r107 == null) goto L28;
        r107.setVisibility(8);
    L28:
        View r108 = this.f126812g;
        if (r108 == null) goto L31;
        r108.setVisibility(8);
    L31:
        View r109 = this.f126813h;
        if (r109 == null) goto L34;
        r109.setVisibility(8);
    L34:
        View r110 = this.f126807b;
        if (r110 == null) goto L37;
        r110.setTranslationY(0.0f);
    L37:
        View r111 = this.f126810e;
        if (r111 == null) goto L40;
        r111.setAlpha(1.0f);
    L40:
        View r112 = this.f126811f;
        if (r112 == null) goto L43;
        r112.setAlpha(1.0f);
    L43:
        View r113 = this.f126812g;
        if (r113 == null) goto L46;
        r113.setAlpha(1.0f);
    L46:
        View r114 = this.f126813h;
        if (r114 == null) goto L49;
        r114.setAlpha(1.0f);
    L49:
        k();
        AnimatorSet r115 = this.B;
        if (r115 == null) goto L52;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r115);
    L52:
        AnimatorSet r116 = this.B;
        if (r116 == null) goto L55;
        r116.cancel();
    L55:
        this.B = new AnimatorSet();
        if (this.E != RecommendStatus.OnlyCount) goto L58;
        View r117 = this.F;
    L59:
        AnimatorSet r118 = new AnimatorSet();
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r117, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.2f, 1.1f});
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r117, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.2f, 1.1f});
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r117, "alpha", new float[]{0.0f, 1.0f});
        if (r102 == true) goto L66;
        View r122 = this.f126807b;
        if (r122 == null) goto L66;
        if (r122.getVisibility() != 0) goto L66;
        r118.playTogether(new Animator[]{r119, r120, r121, ObjectAnimator.ofFloat(this.f126807b, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.2f}), ObjectAnimator.ofFloat(this.f126807b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.2f}), ObjectAnimator.ofFloat(this.f126807b, "alpha", new float[]{1.0f, 0.0f})});
    L67:
        r118.setDuration(250);
        r118.addListener(new g(this, r117));
        AnimatorSet r123 = new AnimatorSet();
        r123.playTogether(new Animator[]{ObjectAnimator.ofFloat(r117, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.1f, 1.0f}), ObjectAnimator.ofFloat(r117, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.1f, 1.0f})});
        r123.setDuration(300);
        AnimatorSet r124 = this.B;
        if (r124 == null) goto L70;
        r124.playSequentially(new Animator[]{r118, r123});
    L70:
        AnimatorSet r125 = this.B;
        if (r125 == null) goto L73;
        r125.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L73:
        AnimatorSet r126 = this.B;
        if (r126 == null) goto L76;
        r126.start();
    L76:
        l();
        return;
    L66:
        r118.playTogether(new Animator[]{r119, r120, r121});
        goto L67
    L58:
        r117 = this.H;
        goto L59
    L9:
        if (r101.isRunning() != true) goto L11;
    L10:
        r102 = true;
        goto L12
    L5:
        if (r100.isRunning() == true) goto L10;
        goto L6
    }

    public final void i() {
        if (getParent() != null) goto L5;
        return;
    L5:
        int[] r100 = {0, 0};
        View r101 = this.f126814i;
        if (r101 == null) goto L8;
        r101.getLocationOnScreen(r100);
    L8:
        boolean r102 = false;
        if (this.Q == false) goto L19;
        PointF r103 = new PointF(r100[0] + UtilityKotlinExtentionsKt.h(25.5f), r100[1] + UtilityKotlinExtentionsKt.h(8.5f));
        PointF r104 = new PointF(r103.x - UtilityKotlinExtentionsKt.h(33.0f), r103.y - UtilityKotlinExtentionsKt.h(113.0f));
        ViewParent r105 = getParent();
        if (r105 == null) goto L17;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f r106 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f(r103, r104, (ViewGroup) r105, getContext());
        ((ArrayList) this.f126821p).add(r106);
        if (this.f126831z.f126865c != EXGaugeLevel.OVERHEATED) goto L15;
        r102 = true;
    L15:
        r106.a(r102, this.Q);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L19:
        if (com.bytedance.android.livesdk.gift.util.c.c() == false) goto L21;
        float r107 = nz1.a.q().c();
    L22:
        PointF r108 = new PointF((r100[0] / r107) + UtilityKotlinExtentionsKt.h(25.5f), (r100[1] / r107) + UtilityKotlinExtentionsKt.h(6.5f));
        PointF r109 = new PointF(r108.x, r108.y - UtilityKotlinExtentionsKt.h(85.0f));
        ViewParent r110 = getParent();
        if (r110 == null) goto L30;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f r111 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.f(r108, r109, (ViewGroup) r110, getContext());
        ((ArrayList) this.f126821p).add(r111);
        if (this.f126831z.f126865c != EXGaugeLevel.OVERHEATED) goto L27;
        r102 = true;
    L27:
        r111.a(r102, this.Q);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L21:
        r107 = 1.0f;
        goto L22
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GiftComboProgressBar r100 = this.f126819n;
        if (r100 == null) goto L7;
        NextLiveData<Boolean> r101 = r100.f126803x;
        if (r101 == null) goto L7;
        r101.removeObserver(this.O);
    L7:
        GiftComboProgressBar r102 = this.f126819n;
        if (r102 == null) goto L13;
        NextLiveData<Pair<Boolean, Boolean>> r103 = r102.getShowCountDown();
        if (r103 == null) goto L14;
        r103.removeObserver(this.P);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void a(long r100) {
        long r101 = System.currentTimeMillis();
        RecommendStatus r102 = this.E;
        if (r102 != RecommendStatus.Idle) goto L6;
        this.E = RecommendStatus.OnlyCount;
        m();
    L8:
        long r103 = 0;
    L14:
        this.L = r101;
        ComboProgressAnimationViewNew r104 = this.f126817l;
        if (r104 == null) goto L17;
        r104.setBanHint(true);
    L17:
        Disposable r105 = this.N;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        this.N = Observable.timer(r103, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r100));
        return;
    L6:
        if ((r101 - this.L) > 250) goto L10;
        k();
        goto L8
    L10:
        if (r102 != RecommendStatus.OnlyCount) goto L12;
        View r106 = this.F;
    L13:
        n(r106, r106, false);
        r103 = 125;
        goto L14
    L12:
        r106 = this.H;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void b(h2 r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        long r100 = System.currentTimeMillis();
        RecommendStatus r101 = this.E;
        if (r101 != RecommendStatus.Idle) goto L7;
        this.E = RecommendStatus.Gift;
        m();
    L13:
        long r102 = 0;
    L15:
        this.L = r100;
        ComboProgressAnimationViewNew r103 = this.f126817l;
        if (r103 == null) goto L18;
        r103.setBanHint(true);
    L18:
        Disposable r104 = this.M;
        if (r104 == null) goto L21;
        r104.dispose();
    L21:
        TimeUnit r105 = TimeUnit.MILLISECONDS;
        this.M = Observable.timer(r102, r105).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r110));
        Disposable r111 = this.N;
        if (r111 == null) goto L24;
        r111.dispose();
    L24:
        this.N = Observable.timer(r102, r105).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L7:
        r102 = 125;
        if (r101 != RecommendStatus.OnlyCount) goto L11;
        this.E = RecommendStatus.Gift;
        n(this.F, this.H, true);
        goto L15
    L11:
        if ((r100 - this.L) > 250) goto L14;
        k();
        l();
        goto L13
    L14:
        View r106 = this.H;
        n(r106, r106, true);
        goto L15
    }

    public final AnimatorSet h(View r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.8f, 1.0f}).setDuration(1000);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.8f, 1.0f}).setDuration(1000);
        r102.addListener(new e(r100));
        AnimatorSet r103 = new AnimatorSet();
        r103.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        r103.playTogether(new Animator[]{r101, r102});
        return r103;
    }

    public final void j(boolean r100) {
        GiftComboProgressBar r101 = this.f126819n;
        if (r101 == null) goto L10;
        r101.f126788i = r100;
        float r102 = r101.f126786g;
        AnimatorSet r103 = r101.f126787h;
        if (r103 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r103);
    L7:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r102, 0.0f});
        r104.setDuration(250);
        r104.addUpdateListener(new o(r101));
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r105.setDuration(r101.f126789j);
        r105.addUpdateListener(new p(r105, r101));
        r105.addListener(new q(r101));
        AnimatorSet r106 = new AnimatorSet();
        r101.f126787h = r106;
        r106.playSequentially(new Animator[]{r104, r105});
        AnimatorSet r107 = r101.f126787h;
        if (r107 == null) goto L10;
        r107.start();
    L10:
        EXGaugeLevel r108 = this.f126831z.f126865c;
        if (r108 != EXGaugeLevel.HEATED) goto L13;
    L14:
        GiftComboProgressBar r109 = this.f126819n;
        if (r109 == null) goto L27;
        Animator r110 = r109.f126799t;
        if (r110 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r110);
    L19:
        Animator r111 = r109.f126797r;
        if (r111 != null) goto L22;
    L24:
        r109.f126798s = 0.0f;
        ValueAnimator r112 = ValueAnimator.ofFloat(new float[]{r109.f126802w, 1.0f});
        r112.setDuration(2500);
        r112.addUpdateListener(new n(r109));
        Unit r113 = Unit.INSTANCE;
        r109.f126797r = r112;
        r112.start();
        return;
    L22:
        if (r111.isRunning() != true) goto L24;
        return;
    L27:
        return;
    L13:
        if (r108 == EXGaugeLevel.OVERHEATED) goto L14;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setComboCount(int r100) {
        this.f126828w = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsGroupSend(boolean r100) {
        ComboProgressAnimationViewNew r101 = this.f126817l;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.setGroupSend(r100);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsSeriesSend(boolean r100) {
        ComboProgressAnimationViewNew r101 = this.f126817l;
        if (r101 == null) goto L6;
        r101.setSeriesSend(r100);
        return;
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
        int r100 = this.f126828w;
        if (r100 != 0) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h r101 = this.f126831z;
        GiftComboProgressBar r102 = this.f126819n;
        if (r102 == null) goto L10;
        NextLiveData<Boolean> r103 = r102.f126803x;
        if (r103 == null) goto L10;
        Boolean r104 = r103.getValue();
    L11:
        r101.a(r100, Intrinsics.areEqual(r104, Boolean.TRUE));
        this.D = r110;
        AnimatorSet r105 = this.f126816k;
        if (r105 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r105);
    L14:
        int r106 = r.f126881a[this.E.ordinal()];
        boolean r107 = true;
        if (r106 == 1) goto L22;
        if (r106 == 2) goto L21;
        if (r106 != 3) goto L20;
        View r108 = this.H;
    L26:
        View r109 = this.f126806a;
        if (r109 == null) goto L29;
        r109.setVisibility(0);
    L29:
        this.f126816k = new AnimatorSet();
        View r113 = this.f126806a;
        if (r113 == null) goto L32;
        AnimatorSet r114 = com.bytedance.android.live.revenue.common.e.c(r113, new float[]{r113.getScaleX(), 0.8f}).setDuration(100);
    L33:
        if (r108 == null) goto L35;
        AnimatorSet r115 = com.bytedance.android.live.revenue.common.e.c(r108, new float[]{r108.getScaleX(), 0.8f}).setDuration(100);
    L36:
        AnimatorSet r116 = new AnimatorSet();
        r116.playTogether(new Animator[]{r114, r115});
        View r117 = this.f126806a;
        if (r117 == null) goto L39;
        AnimatorSet r118 = com.bytedance.android.live.revenue.common.e.c(r117, new float[]{0.8f, 1.0f}).setDuration(400);
        r118.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L40:
        if (r108 == null) goto L42;
        AnimatorSet r119 = com.bytedance.android.live.revenue.common.e.c(r108, new float[]{0.8f, 1.0f}).setDuration(400);
        r119.setInterpolator(new PathInterpolator(0.32f, 1.64f, 0.6f, 1.0f));
    L43:
        AnimatorSet r120 = new AnimatorSet();
        r120.playTogether(new Animator[]{r118, r119, ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(this.f126830y)});
        AnimatorSet r121 = this.f126816k;
        if (r121 == null) goto L46;
        r121.playSequentially(new Animator[]{r116, r120});
    L46:
        AnimatorSet r122 = this.f126816k;
        if (r122 == null) goto L49;
        r122.addListener(new v(this, r110));
    L49:
        AnimatorSet r123 = this.f126816k;
        if (r123 == null) goto L53;
        r123.start();
    L53:
        if (this.f126828w <= 0) goto L130;
        EXGaugeLevel r124 = this.f126831z.f126865c;
        EXGaugeLevel r125 = EXGaugeLevel.HEATED;
        if (r124 != r125) goto L66;
        Animator r126 = this.f126823r;
        if (r126 == null) goto L59;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r126);
    L59:
        Animator r127 = this.f126822q;
        if (r127 != null) goto L62;
    L64:
        Drawable r128 = s1.m(R.drawable.ttlive_base_gift_combo_bg_new_style);
        Drawable r129 = s1.m(R.drawable.ttlive_gift_big_combo_gradient_bg);
        ValueAnimator r130 = ValueAnimator.ofFloat(new float[]{this.f126829x, 1.0f});
        r130.setDuration((long) ((1.0f - this.f126829x) * 2000));
        r130.addUpdateListener(new y(this, r129, r128));
        Unit r131 = Unit.INSTANCE;
        this.f126822q = r130;
        r130.start();
        goto L66
    L62:
        if (r127.isRunning() != true) goto L64;
    L66:
        if (this.A == false) goto L96;
        AnimatedDrawable2 r132 = this.f126824s;
        if (r132 == null) goto L72;
        if (r132.isRunning() != true) goto L72;
    L93:
        if (this.Q == false) goto L95;
        i();
        goto L96
    L95:
        post(new d(this));
    L72:
        if (this.f126831z.f126865c != EXGaugeLevel.OVERHEATED) goto L93;
        HSImageView r133 = this.f126820o;
        if (r133 == null) goto L76;
        r133.setVisibility(0);
    L76:
        AnimatedDrawable2 r134 = this.f126824s;
        if (r134 == null) goto L79;
        com.bytedance.android.live.core.utils.fresco.c.b(r134);
    L79:
        AnimatedDrawable2 r135 = this.f126824s;
        if (r135 == null) goto L82;
        r135.start();
    L82:
        Animator r136 = this.f126827v;
        if (r136 == null) goto L85;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r136);
    L85:
        HSImageView r137 = this.f126820o;
        if (r137 == null) goto L88;
        ObjectAnimator r138 = ObjectAnimator.ofFloat(r137, "alpha", new float[]{0.0f, 1.0f}).setDuration(250);
    L89:
        this.f126827v = r138;
        if (r138 == null) goto L93;
        r138.start();
        goto L93
    L88:
        r138 = null;
    L96:
        ComboWaveView r139 = this.f126818m;
        if (r139 == null) goto L115;
        EXGaugeLevel r140 = this.f126831z.f126865c;
        if (r140 != r125) goto L101;
    L104:
        c0 r141 = c0.f127389d;
        r141.getClass();
        if (((f0) c0.f127387b.getValue(r141, c0.f127386a[0])).a() == true) goto L107;
    L111:
        if (r107 == false) goto L113;
        Drawable r142 = r139.f126777a;
    L114:
        View r143 = new View(r139.getContext());
        r143.setBackground(r142);
        FrameLayout.LayoutParams r144 = new FrameLayout.LayoutParams(s1.f(128.0f), s1.f(128.0f));
        r144.gravity = 17;
        Unit r145 = Unit.INSTANCE;
        r143.setLayoutParams(r144);
        r143.setAlpha(1.0f);
        r143.setScaleX(0.88f);
        r143.setScaleY(0.88f);
        r139.addView(r143);
        r143.animate().alpha(0.0f).scaleX(1.3f).scaleY(1.3f).setDuration(1030).setListener(new k(r139, r143)).start();
        goto L115
    L113:
        r142 = r139.f126778b;
        goto L114
    L107:
        if (r139.f126777a != null) goto L109;
    L110:
        r139.a();
        goto L111
    L109:
        if (r139.f126778b != null) goto L111;
    L101:
        if (r140 == EXGaugeLevel.OVERHEATED) goto L104;
        r107 = false;
    L115:
        j(false);
        ComboProgressAnimationViewNew r146 = this.f126817l;
        if (r146 == null) goto L119;
        r146.setVisibility(0);
    L119:
        if (this.Q == false) goto L123;
        ComboProgressAnimationViewNew r147 = this.f126817l;
        if (r147 == null) goto L126;
        r147.e(this.f126828w, r112);
    L126:
        ComboProgressAnimationViewNew r148 = this.f126817l;
        if (r148 == null) goto L131;
        r148.f();
        return;
    L131:
        return;
    L123:
        ComboProgressAnimationViewNew r149 = this.f126817l;
        if (r149 == null) goto L126;
        r149.e(this.f126828w, 0);
        goto L126
    L130:
        return;
    L42:
        r119 = null;
        goto L43
    L39:
        r118 = null;
        goto L40
    L35:
        r115 = null;
        goto L36
    L32:
        r114 = null;
        goto L33
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r108 = this.F;
        goto L26
    L22:
        View r150 = this.f126807b;
        if (r150 == null) goto L25;
        r150.setVisibility(0);
    L25:
        r108 = this.f126807b;
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void e(h2 r100, l1 r101, com.bytedance.android.livesdk.gift.model.n r102) {
        ComboProgressAnimationViewNew r103 = this.f126817l;
        if (r103 == null) goto L7;
        if (r103 == null) goto L8;
        r103.setGift(r100);
        return;
    L8:
        return;
    }

    public final void n(View r110, View r111, boolean r112) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r111 != null) goto L7;
        return;
    L7:
        k();
        AnimatorSet r100 = this.B;
        if (r100 == null) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.b(r100);
    L10:
        AnimatorSet r101 = this.B;
        if (r101 == null) goto L13;
        r101.cancel();
    L13:
        this.B = new AnimatorSet();
        AnimatorSet r102 = new AnimatorSet();
        r102.playTogether(new Animator[]{ObjectAnimator.ofFloat(r110, "alpha", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.2f}), ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.2f})});
        r102.addListener(new h(this, r110, r111, r112));
        r102.setDuration(125);
        AnimatorSet r103 = new AnimatorSet();
        r103.playTogether(new Animator[]{ObjectAnimator.ofFloat(r111, "alpha", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(r111, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.2f, 1.1f}), ObjectAnimator.ofFloat(r111, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.2f, 1.1f})});
        r103.setDuration(125);
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{ObjectAnimator.ofFloat(r111, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.1f, 1.0f}), ObjectAnimator.ofFloat(r111, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.1f, 1.0f})});
        r104.setDuration(300);
        AnimatorSet r105 = this.B;
        if (r105 == null) goto L16;
        r105.playSequentially(new Animator[]{r102, r103, r104});
    L16:
        AnimatorSet r106 = this.B;
        if (r106 == null) goto L19;
        r106.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L19:
        AnimatorSet r107 = this.B;
        if (r107 == null) goto L23;
        r107.start();
        return;
    }

    public GiftComboView(Context r100, AttributeSet r110, int r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if ((r112 & 4) == 0) goto L8;
        r111 = 0;
    L8:
        boolean r101 = true;
        if ((r112 & 8) == 0) goto L11;
        boolean r113 = true;
    L12:
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r110, r111);
        this.Q = r113;
        this.f126821p = new ArrayList();
        this.f126830y = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.f126831z = new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.h();
        this.A = true;
        i12.e r114 = i12.o.b();
        if (r114 == null) goto L15;
        Object r115 = com.bytedance.android.scope.m.f163449e.d(r114, com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d.class);
    L16:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d r116 = (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d) r115;
        if (r116 != null) goto L19;
    L21:
        r101 = false;
    L22:
        this.E = RecommendStatus.Idle;
        t r117 = new t(this);
        this.O = r117;
        s r102 = new s(this);
        this.P = r102;
        if (r113 == false) goto L25;
        FrameLayout.inflate(r100, R.layout.ttlive_base_gift_combo_view_new_style, this);
    L32:
        this.f126830y = getCountDownTime();
        this.f126806a = findViewById(R.id.combo_bg);
        this.f126808c = findViewById(R.id.combo_title);
        this.f126809d = findViewById(R.id.long_combo_title);
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().c() == false) goto L48;
        View r103 = this.f126809d;
        if (r103 == null) goto L37;
        r103.setBackgroundResource(R.drawable.ttlive_gift_long_click_comb_title_opt);
    L37:
        View r104 = this.f126809d;
        if (r104 == null) goto L40;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L41:
        if (r105 == null) goto L43;
        r105.width = (int) t6.a(getContext(), 37.0f);
    L43:
        if (r105 == null) goto L45;
        r105.height = (int) t6.a(getContext(), 40.0f);
    L45:
        View r106 = this.f126809d;
        if (r106 == null) goto L48;
        r106.setLayoutParams(r105);
        goto L48
    L40:
        r105 = null;
    L48:
        this.f126807b = this.f126808c;
        ComboProgressAnimationViewNew r107 = (ComboProgressAnimationViewNew) findViewById(R.id.combo_progress);
        this.f126817l = r107;
        if (r107 == null) goto L51;
        r107.setVisibility(4);
    L51:
        this.f126818m = (ComboWaveView) findViewById(R.id.round_wave_anim_view);
        GiftComboProgressBar r108 = (GiftComboProgressBar) findViewById(R.id.combo_progress_bar);
        r108.setCountDownTime(getCountDownTime());
        Unit r109 = Unit.INSTANCE;
        this.f126819n = r108;
        this.f126820o = (HSImageView) findViewById(R.id.combo_effect_container);
        this.f126815j = (HSImageView) findViewById(R.id.gradient_bg_container);
        this.f126814i = findViewById(R.id.location_view);
        this.f126810e = findViewById(R.id.count_down_0);
        this.f126811f = findViewById(R.id.count_down_1);
        this.f126812g = findViewById(R.id.count_down_2);
        this.f126813h = findViewById(R.id.count_down_3);
        ComboWaveView r118 = this.f126818m;
        if (r118 == null) goto L57;
        c0 r119 = c0.f127389d;
        r119.getClass();
        if (((f0) c0.f127387b.getValue(r119, c0.f127386a[0])).a() == true) goto L57;
        r118.a();
    L57:
        KProperty[] r120 = b02.a.f16821a;
        if (r113 == false) goto L60;
        String r121 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_base_gift_big_combo_arrow_effect.webp";
    L61:
        HSImageView r122 = this.f126820o;
        if (r122 == null) goto L64;
        r122.setController(Fresco.newDraweeControllerBuilder().setUri(r121).setControllerListener(new u(this)).build());
    L64:
        GiftComboProgressBar r123 = this.f126819n;
        if (r123 == null) goto L69;
        NextLiveData<Boolean> r124 = r123.f126803x;
        if (r124 == null) goto L69;
        r124.observeForever(r117);
    L69:
        GiftComboProgressBar r125 = this.f126819n;
        if (r125 == null) goto L74;
        NextLiveData<Pair<Boolean, Boolean>> r126 = r125.getShowCountDown();
        if (r126 == null) goto L74;
        r126.observeForever(r102);
    L74:
        this.F = findViewById(R.id.recommend_count_layout);
        this.G = (TextView) findViewById(R.id.recommend_count_detail);
        this.H = findViewById(R.id.recommend_gift_layout);
        this.I = (ImageView) findViewById(R.id.recommend_gift_icon);
        this.f126805J = (TextView) findViewById(R.id.recommend_gift_price);
        this.K = (TextView) findViewById(R.id.recommend_gift_combo_count_detail);
        if (r101 == false) goto L78;
        if (r116 == null) goto L78;
        Typeface r127 = r116.a(getContext());     // Catch: Exception -> L86
    L79:
        TextView r128 = this.G;     // Catch: Exception -> L86
        if (r128 == null) goto L82;
        r128.setTypeface(r127);     // Catch: Exception -> L86
    L82:
        TextView r129 = this.K;     // Catch: Exception -> L86
        if (r129 == null) goto L91;
        r129.setTypeface(r127);     // Catch: Exception -> L86
        return;
    L91:
        return;
    L78:
        r127 = Typeface.createFromAsset(getContext().getAssets(), "font/ttlive_base_gift_combo_opt_font.ttf");     // Catch: Exception -> L86
    L86:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("NormalGiftCombViewV2", "load font asset exception: " + e.getMessage(), null, 4);
        return;
    L60:
        r121 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_base_gift_combo_arrow_effect.webp";
        goto L61
    L25:
        c0.f127389d.getClass();
        if (c0.a() == false) goto L28;
        GiftPanelViewPreloadService.f128162l.getClass();
        View r130 = GiftPanelViewPreloadService.a.a(R.layout.ttlive_base_gift_combo_view_new_style_small);
    L29:
        if (r130 == null) goto L31;
        addView(r130);
        goto L32
    L31:
        FrameLayout.inflate(r100, R.layout.ttlive_base_gift_combo_view_new_style_small, this);
        goto L32
    L28:
        r130 = null;
        goto L29
    L19:
        if (r116.f129969a.b() != true) goto L21;
    L15:
        r115 = null;
        goto L16
    L11:
        r113 = false;
        goto L12
    }
}
