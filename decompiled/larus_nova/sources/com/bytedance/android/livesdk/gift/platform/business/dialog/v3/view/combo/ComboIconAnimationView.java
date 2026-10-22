package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b02.c;
import b02.d;
import b02.e;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboIconAnimationView;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "J", "getGiftId", "()J", "setGiftId", "(J)V", "giftId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboIconAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f128625h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f128626i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f128627j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f128628k = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f128629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f128630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f128631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f128632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f128633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f128634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Random f128635g;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboIconAnimationView f128636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f128637b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f128636a.removeView(this.f128637b);
        }

        public b(ComboIconAnimationView r100, View r101) {
            this.f128636a = r100;
            this.f128637b = r101;
        }
    }

    public ComboIconAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ComboIconAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        f128625h = s1.f(25.0f);
        f128626i = s1.f(15.0f);
        f128627j = s1.f(70.0f);
        f128628k = s1.f(35.0f);
    }

    public final long getGiftId() {
        return this.f128629a;
    }

    public final void c(int r100) {
        if (r100 != 0) goto L4;
        Disposable r101 = this.f128630b;
        if (r101 == null) goto L15;
        r101.dispose();
        return;
    L15:
        return;
    L4:
        if (r100 != 66) goto L16;
        Disposable r102 = this.f128630b;
        if (r102 == null) goto L9;
        r102.dispose();
    L9:
        j.a r103 = j.f66356a;
        this.f128630b = j.a(0, 2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.f16829a, e.f16830a);
        return;
    }

    public final void setGiftId(long r100) {
        this.f128629a = r100;
    }

    public static View a(ComboIconAnimationView r100, Bitmap r101) {
        r100.getClass();
        ImageView r102 = new ImageView(r100.getContext());
        r102.setImageBitmap(r101);
        int r103 = (int) f128625h;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r103, r103);
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutParams(r104);
        return r102;
    }

    public final void d(Bitmap r110, int r111) {
        int r112 = r111 % 2;
        if (r112 != 0) goto L5;
        View r113 = a(this, r110);
        addView(r113);
        float r100 = f128627j;
        float r101 = -r100;
        Float r102 = Float.valueOf(r101);
        float r103 = -f128628k;
        b(r113, TuplesKt.to(r102, Float.valueOf(r103)), 0);
        View r114 = a(this, r110);
        addView(r114);
        b(r114, TuplesKt.to(Float.valueOf(r100), Float.valueOf(r103)), 0);
        View r115 = a(this, r110);
        addView(r115);
        b(r115, TuplesKt.to(Float.valueOf(-f128626i), Float.valueOf(r101)), 300);
        return;
    L5:
        if (r112 != 1) goto L11;
        View r116 = a(this, r110);
        addView(r116);
        float r104 = f128627j;
        float r105 = -r104;
        Float r106 = Float.valueOf(r105);
        float r107 = f128628k;
        b(r116, TuplesKt.to(r106, Float.valueOf(r107)), 0);
        View r117 = a(this, r110);
        addView(r117);
        b(r117, TuplesKt.to(Float.valueOf(r104), Float.valueOf(r107)), 0);
        View r118 = a(this, r110);
        addView(r118);
        b(r118, TuplesKt.to(Float.valueOf(f128626i), Float.valueOf(r105)), 300);
        return;
    }

    public ComboIconAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f128633e = 600;
        this.f128634f = 400;
        this.f128635g = new Random();
    }

    public final void b(View r110, Pair<Float, Float> r111, long r112) {
        ObjectAnimator r100 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r111.getFirst().floatValue()}).setDuration(this.f128633e);
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r110, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r111.getSecond().floatValue()}).setDuration(this.f128633e);
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{1.0f, 0.0f}).setDuration(this.f128633e - this.f128634f);
        r101.setStartDelay(this.f128634f);
        AnimatorSet r102 = new AnimatorSet();
        r102.setStartDelay(r112);
        r102.playTogether(new Animator[]{r100, r113, r101});
        r102.addListener(new b(this, r110));
        r102.start();
    }

    public /* synthetic */ ComboIconAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
