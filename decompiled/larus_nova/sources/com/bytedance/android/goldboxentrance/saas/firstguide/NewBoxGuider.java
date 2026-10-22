package com.bytedance.android.goldboxentrance.saas.firstguide;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class NewBoxGuider {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static WeakReference<NewBoxGuider> f58137o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.goldboxentrance.saas.firstguide.b f58138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f58139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f58140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LottieAnimationView f58141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f58142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PointF f58144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PointF f58145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f58146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f58147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Animator f58148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f58149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f58150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f58151n;

    public static final class a implements TypeEvaluator<PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PointF f58152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f58153b;

        public a(PointF r100, PointF r101) {
            Intrinsics.checkNotNullParameter(r100, "controlPoint1");
            Intrinsics.checkNotNullParameter(r100, "controlPoint");
            this.f58153b = r100;
            this.f58152a = r101;
        }

        @Override // android.animation.TypeEvaluator
        public final PointF evaluate(float r100, PointF r110, PointF r111) {
            PointF r112 = r110;
            PointF r113 = r111;
            Intrinsics.checkNotNullParameter(r112, "startValue");
            Intrinsics.checkNotNullParameter(r113, "endValue");
            PointF r101 = this.f58152a;
            if (r101 == null) goto L5;
            PointF r102 = this.f58153b;
            Intrinsics.checkNotNull(r101);
            float r103 = 1.0f - r100;
            PointF r104 = new PointF();
            float r105 = (r103 * r103) * r103;
            float r106 = 3 * r103;
            float r107 = (r103 * r106) * r100;
            float r108 = (r106 * r100) * r100;
            float r109 = (r100 * r100) * r100;
            r104.x = (((r112.x * r105) + (r102.x * r107)) + (r101.x * r108)) + (r113.x * r109);
            r104.y = (((r105 * r112.y) + (r107 * r102.y)) + (r108 * r101.y)) + (r109 * r113.y);
            return r104;
        L5:
            PointF r114 = this.f58153b;
            PointF r115 = new PointF();
            float r116 = 1 - r100;
            float r117 = r116 * r116;
            float r118 = (2 * r100) * r116;
            float r119 = r100 * r100;
            r115.x = ((r112.x * r117) + (r114.x * r118)) + (r113.x * r119);
            r115.y = ((r117 * r112.y) + (r118 * r114.y)) + (r119 * r113.y);
            return r115;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        this.f58147j = false;
        Disposable r100 = this.f58149l;
        if (r100 != null) goto L5;
    L9:
        Animator r101 = this.f58148k;
        if (r101 != null) goto L12;
    L17:
        LottieAnimationView r102 = this.f58141d;
        if (r102 != null) goto L20;
        return;
    L20:
        if (r102.isAnimating() == true) goto L23;
        r102 = null;
    L23:
        if (r102 == null) goto L30;
        Disposable r103 = this.f58146i;
        if (r103 == null) goto L27;
        r103.dispose();
    L27:
        r102.cancelAnimation();
        UIUtils.setViewVisibility(r102, 8);
        UIUtils.setViewVisibility(this.f58138a, 8);
        this.f58151n.removeView(this.f58138a);
        this.f58147j = false;
        return;
    L30:
        return;
    L12:
        if (r101.isRunning() != true) goto L17;
        Animator r104 = this.f58148k;
        if (r104 == null) goto L16;
        r104.cancel();
    L16:
        UIUtils.setViewVisibility(this.f58138a, 8);
        this.f58151n.removeView(this.f58138a);
        goto L17
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r105 = this.f58149l;
        if (r105 == null) goto L9;
        r105.dispose();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        if (LiveInfraSettingKeys.LIVE_MOCK_SHOW_GOLD_BOX_GUIDER.getValue().booleanValue() == false) goto L7;
        c();
        return;
    L7:
        if (((Boolean) com.bytedance.android.goldboxentrance.saas.firstguide.a.f58155b.getValue(null, com.bytedance.android.goldboxentrance.saas.firstguide.a.f58154a[0])).booleanValue() == false) goto L9;
        return;
    L9:
        if (((bq2.a) com.bytedance.android.live.revenue.core.util.f.a(bq2.a.class)).H3() == true) goto L14;
        c();
        return;
    }

    public final void c() {
        WeakReference<NewBoxGuider> r100 = f58137o;
        if (r100 == null) goto L7;
        NewBoxGuider r101 = r100.get();
        if (r101 == null) goto L7;
        r101.a();
    L7:
        f58137o = new WeakReference(this);
        this.f58138a = new com.bytedance.android.goldboxentrance.saas.firstguide.b(this.f58151n.getContext());
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-1, -1);
        View.inflate(this.f58151n.getContext(), R.layout.gold_box_first_guide_layout, this.f58138a);
        com.bytedance.android.goldboxentrance.saas.firstguide.b r103 = this.f58138a;
        LottieAnimationView r104 = null;
        if (r103 == null) goto L10;
        HSImageView r105 = (HSImageView) r103.findViewById(R.id.fake_box_iv);
    L11:
        this.f58139b = r105;
        com.bytedance.android.goldboxentrance.saas.firstguide.b r106 = this.f58138a;
        if (r106 == null) goto L14;
        HSImageView r107 = (HSImageView) r106.findViewById(R.id.fake_box_mask);
    L15:
        this.f58140c = r107;
        com.bytedance.android.goldboxentrance.saas.firstguide.b r108 = this.f58138a;
        if (r108 == null) goto L18;
        r104 = (LottieAnimationView) r108.findViewById(R.id.box_tip_lottie);
    L18:
        this.f58141d = r104;
        HSImageView r109 = this.f58140c;
        if (r109 == null) goto L21;
        r109.setImageResource(R.color.ttlive_black_50);
    L21:
        this.f58151n.addView(this.f58138a, 0, r102);
        Disposable r110 = this.f58149l;
        if (r110 == null) goto L24;
        r110.dispose();
    L24:
        this.f58149l = Observable.just(1).delay(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this));
        return;
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    }

    public NewBoxGuider(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f58151n = r100;
        String r101 = k0.f90841a;
        this.f58150m = new NewBoxGuider$pageFinishedListener$1(this);
    }
}
