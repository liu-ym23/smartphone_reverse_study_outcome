package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.n0;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.live.datacontext.m;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/GiftSwitchImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", ce.f26396k, "Z", "isPlaying", "()Z", "setPlaying", "(Z)V", "", "m", "I", "getDuration", "()I", "setDuration", "(I)V", "duration", OfficeSDKRequestTag.KEY_NEW_USER, "getCurrentSwitchType", "setCurrentSwitchType", "currentSwitchType", "getState", "state", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftSwitchImageView extends ConstraintLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f126646o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f126647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f126648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f126649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f126650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f126651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f126652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AnimatorSet f126653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f126654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f126655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f126656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f126657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f126658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f126659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f126660n;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126661a;

        public a(GiftSwitchImageView r100) {
            this.f126661a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ViewGroup.LayoutParams r101 = this.f126661a.getLayoutParams();
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L11;
            r101.width = ((Integer) r102).intValue();
            GiftSwitchImageView r103 = this.f126661a;
            float r104 = r103.f126656j + com.bytedance.android.live.revenue.common.i.b(68);
            Object r105 = r100.getAnimatedValue();
            if (r105 == null) goto L9;
            r103.setX(r104 - ((Integer) r105).intValue());
            this.f126661a.requestLayout();
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126662a;

        public b(GiftSwitchImageView r100) {
            this.f126662a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            TextView r101 = (TextView) this.f126662a._$_findCachedViewById(R.id.switch_guide_text);
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setAlpha(((Float) r102).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126663a;

        public c(GiftSwitchImageView r100) {
            this.f126663a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            HSImageView r101 = (HSImageView) this.f126663a._$_findCachedViewById(R.id.switch_button_image);
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setAlpha(((Float) r102).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126664a;

        public d(GiftSwitchImageView r100) {
            this.f126664a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ((TextView) this.f126664a._$_findCachedViewById(R.id.switch_guide_text)).setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ((HSImageView) this.f126664a._$_findCachedViewById(R.id.switch_button_image)).setVisibility(0);
            ((HSImageView) this.f126664a._$_findCachedViewById(R.id.switch_button_image)).setAlpha(0.0f);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126665a;

        public e(GiftSwitchImageView r100) {
            this.f126665a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GiftSwitchImageView r101 = this.f126665a;
            if ((r100 instanceof HSImageView) == true) goto L5;
            r100 = null;
        L5:
            GiftSwitchImageView.R5(r101, (HSImageView) r100);
        }
    }

    public static final class f {
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126666a;

        public g(GiftSwitchImageView r100) {
            this.f126666a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            GiftSwitchImageView r101 = this.f126666a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setAlpha(((Float) r102).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126667a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f126668a;

            public a(h r100) {
                this.f126668a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                this.f126668a.f126667a.f126653g.start();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f126669a = null;

            static {
                f126669a = new b();
            }

            public b() {
            }

            @Override // io.reactivex.functions.Consumer
            public final /* bridge */ /* synthetic */ void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
            }
        }

        public h(GiftSwitchImageView r100) {
            this.f126667a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            GiftSwitchImageView r101 = this.f126667a;
            if (r101.f126658l == false) goto L6;
            r101.f126655i = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.f126669a);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            GiftSwitchImageView r101 = this.f126667a;
            if (r101.f126658l == false) goto L5;
            ((TextView) r101._$_findCachedViewById(R.id.switch_guide_text)).setVisibility(0);
            ((TextView) this.f126667a._$_findCachedViewById(R.id.switch_guide_text)).setAlpha(1.0f);
            ((HSImageView) this.f126667a._$_findCachedViewById(R.id.switch_button_image)).setVisibility(8);
            ViewGroup.LayoutParams r102 = this.f126667a.getLayoutParams();
            r102.width = s1.j(R.dimen.ttlive_gift_effect_switch_size);
        L6:
            this.f126667a.setAlpha(1.0f);
            this.f126667a.requestLayout();
            return;
        L5:
            ((TextView) r101._$_findCachedViewById(R.id.switch_guide_text)).setVisibility(8);
            ((HSImageView) this.f126667a._$_findCachedViewById(R.id.switch_button_image)).setVisibility(0);
            ViewGroup.LayoutParams r103 = this.f126667a.getLayoutParams();
            r103.width = s1.j(R.dimen.ttlive_gift_effect_switch_image_size);
            goto L6
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftSwitchImageView f126670a;

        public i(GiftSwitchImageView r100) {
            this.f126670a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            GiftSwitchImageView r112 = this.f126670a;
            int r100 = GiftSwitchImageView.f126646o;
            r112.getClass();
            AnimatorSet r101 = new AnimatorSet();
            ObjectAnimator r102 = ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.5f});
            r102.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r102.setDuration(150);
            Unit r113 = Unit.INSTANCE;
            ObjectAnimator r103 = ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.5f});
            r103.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r103.setDuration(150);
            ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r104.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r104.setDuration(150);
            r104.addUpdateListener(new qz1.c(r112));
            r101.playTogether(new Animator[]{r102, r103, r104});
            r101.addListener(new qz1.d(r112));
            r112.f126652f = r101;
            r101.start();
            Disposable r114 = this.f126670a.f126654h;
            if (r114 == null) goto L5;
            r114.dispose();
        L5:
            this.f126670a.setPlaying(false);
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f126671a = null;

        static {
            f126671a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    public GiftSwitchImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftSwitchImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getState() {
        int r100 = this.f126660n;
        if (r100 != 1) goto L5;
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L43;
        m<Boolean> r102 = r101.getEffectAudioSwitch();
        if (r102 != null) goto L31;
        return 0;
    L31:
        if (r102.getValue().booleanValue() == true) goto L45;
    L32:
        return 1;
    L45:
        return 0;
    L43:
        return 0;
    L5:
        if (r100 == 2) goto L19;
        GiftContext r103 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r103 == null) goto L34;
        m<Boolean> r104 = r103.getEffectVibrateSwitch();
        if (r104 != null) goto L11;
        return 0;
    L11:
        if (r104.getValue().booleanValue() == true) goto L36;
        GiftContext r105 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r105 == null) goto L37;
        m<Boolean> r106 = r105.getEffectAudioSwitch();
        if (r106 != null) goto L17;
        return 0;
    L17:
        if (r106.getValue().booleanValue() == false) goto L32;
        return 0;
    L37:
        return 0;
    L36:
        return 0;
    L34:
        return 0;
    L19:
        GiftContext r107 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r107 == null) goto L40;
        m<Boolean> r108 = r107.getEffectVibrateSwitch();
        if (r108 != null) goto L24;
        return 0;
    L24:
        if (r108.getValue().booleanValue() == false) goto L32;
        return 0;
    L40:
        return 0;
    }

    public final boolean T5() {
        if ((this.f126660n & 2) == 2) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == true) goto L7;
        return true;
    }

    public final void U5() {
        long r100 = this.f126648b;
        if (r100 == 0) goto L13;
        String r101 = com.bytedance.android.livesdk.gift.platform.core.utils.h.f132038a;
        int r102 = this.f126660n;
        n r103 = new n();
        Map<String, String> r104 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r104, "map");
        String r105 = String.valueOf(r100);
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r105);
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L9;
        String r106 = "";
    L12:
        Intrinsics.checkNotNullParameter("mode_type", "key");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put("mode_type", r106);
        mz0.m r107 = new mz0.m();
        r107.b(LogCommon.LIVE_SHARE_LOG);
        r107.b(LogCommon.ROOM);
        r107.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r103.f516448b).addAll(r107.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r108 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r109 = com.bytedance.android.scope.m.b(r108).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r109);
        ((mz0.i) ((f80.a) r109)).w3("livesdk_gift_mode_button_show", r103.f516447a, r103.f516448b);
        goto L13
    L9:
        r106 = "dual_mode";
        goto L12
    L10:
        r106 = "vibration";
        goto L12
    L11:
        r106 = RemoteMessageConst.Notification.SOUND;
    L13:
        AnimatorSet r110 = new AnimatorSet();
        ObjectAnimator r111 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.5f, 1.0f});
        r111.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r111.setDuration(150);
        Unit r112 = Unit.INSTANCE;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.5f, 1.0f});
        r113.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r113.setDuration(150);
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r114.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r114.setDuration(150);
        r114.addUpdateListener(new g(this));
        r110.playTogether(new Animator[]{r111, r113, r114});
        this.f126651e = r110;
        r110.addListener(new h(this));
        AnimatorSet r115 = this.f126651e;
        if (r115 == null) goto L17;
        r115.start();
        return;
    }

    public final void V5() {
        if (this.f126657k == false) goto L6;
        return;
    L6:
        if (this.f126660n != 0) goto L8;
        return;
    L8:
        this.f126657k = true;
        this.f126656j = getX();
        int r100 = n0.f127469a;
        if (n0.a.a(this.f126660n) == false) goto L11;
        this.f126658l = false;
        U5();
    L18:
        if (this.f126659m == 0) goto L24;
        Disposable r101 = this.f126654h;
        if (r101 == null) goto L22;
        r101.dispose();
    L22:
        this.f126654h = Observable.timer(((long) this.f126659m) - 550, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this), j.f126671a);
        return;
    L24:
        return;
    L11:
        this.f126658l = true;
        U5();
        int r102 = this.f126660n;
        if (r102 != 1) goto L15;
        ay1.b.f16709r.setValue(null, ay1.b.f16675a[20], Boolean.TRUE);
        goto L18
    L15:
        if (r102 != 2) goto L18;
        ay1.b.f16711s.setValue(null, ay1.b.f16675a[21], Boolean.TRUE);
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        AnimatorSet r100 = this.f126651e;
        if (r100 == null) goto L5;
        S5(r100);
    L5:
        AnimatorSet r101 = this.f126652f;
        if (r101 == null) goto L8;
        S5(r101);
    L8:
        AnimatorSet r102 = this.f126653g;
        if (r102 == null) goto L11;
        S5(r102);
    L11:
        Disposable r103 = this.f126654h;
        if (r103 == null) goto L14;
        r103.dispose();
    L14:
        Disposable r104 = this.f126655i;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        super.onDetachedFromWindow();
    }

    public final int getCurrentSwitchType() {
        return this.f126660n;
    }

    public final int getDuration() {
        return this.f126659m;
    }

    public static void S5(AnimatorSet r100) {
        r100.cancel();
        ArrayList<Animator> r101 = r100.getChildAnimations();
        if (r101 == null) goto L11;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Animator r103 = (Animator) r102.next();
        if ((r103 instanceof ValueAnimator) == false) goto L10;
        ((ValueAnimator) r103).removeAllUpdateListeners();
    L10:
        r103.removeAllListeners();
        goto L6
    L15:
        return;
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f126647a != null) goto L5;
        this.f126647a = new LinkedHashMap();
    L5:
        View r101 = this.f126647a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f126647a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setCurrentSwitchType(int r100) {
        this.f126660n = r100;
    }

    public final void setDuration(int r100) {
        this.f126659m = r100;
    }

    public final void setPlaying(boolean r100) {
        this.f126657k = r100;
    }

    public static final void R5(GiftSwitchImageView r100, HSImageView r110) {
        if (r110 != null) goto L4;
        r100.getClass();
        return;
    L4:
        boolean r101 = true;
        if (r100.getState() != 0) goto L41;
        long r102 = r100.f126648b;
        if (r102 == 0) goto L9;
        String r103 = com.bytedance.android.livesdk.gift.platform.core.utils.h.f132038a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.C(r102, r100.f126660n, "close");
    L9:
        ImageLoader.bindImage(r110, r100.f126650d, s1.j(R.dimen.ttlive_gift_effect_switch_image_size), s1.j(R.dimen.ttlive_gift_effect_switch_image_size));
        int r111 = r100.f126660n;
        if (r111 != 3) goto L23;
        GiftContext r104 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r104 == null) goto L16;
        m<Boolean> r105 = r104.getEffectAudioSwitch();
        if (r105 == null) goto L16;
        r105.setValue(Boolean.FALSE);
    L16:
        GiftContext r106 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r106 == null) goto L21;
        m<Boolean> r107 = r106.getEffectVibrateSwitch();
        if (r107 == null) goto L21;
        r107.setValue(Boolean.FALSE);
    L21:
        ToastUtil.a(R.string.ttlive_gift_audio_vibrate_switch_off, 0);
        return;
    L23:
        if ((r111 & 1) == 1) goto L26;
        r101 = false;
    L26:
        if (r101 == false) goto L34;
        GiftContext r112 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r112 == null) goto L32;
        m<Boolean> r113 = r112.getEffectAudioSwitch();
        if (r113 == null) goto L32;
        r113.setValue(Boolean.FALSE);
    L32:
        ToastUtil.a(R.string.ttlive_gift_audio_switch_off, 0);
    L34:
        if (r100.T5() == false) goto L79;
        GiftContext r108 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r108 == null) goto L40;
        m<Boolean> r109 = r108.getEffectVibrateSwitch();
        if (r109 == null) goto L40;
        r109.setValue(Boolean.FALSE);
    L40:
        ToastUtil.a(R.string.ttlive_gift_vibrate_switch_off, 0);
        return;
    L79:
        return;
    L41:
        long r114 = r100.f126648b;
        if (r114 == 0) goto L44;
        String r115 = com.bytedance.android.livesdk.gift.platform.core.utils.h.f132038a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.C(r114, r100.f126660n, "open");
    L44:
        ImageLoader.bindImage(r110, r100.f126649c, s1.j(R.dimen.ttlive_gift_effect_switch_image_size), s1.j(R.dimen.ttlive_gift_effect_switch_image_size));
        int r116 = r100.f126660n;
        if (r116 != 3) goto L58;
        GiftContext r117 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r117 == null) goto L51;
        m<Boolean> r118 = r117.getEffectAudioSwitch();
        if (r118 == null) goto L51;
        r118.setValue(Boolean.TRUE);
    L51:
        GiftContext r119 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r119 == null) goto L56;
        m<Boolean> r120 = r119.getEffectVibrateSwitch();
        if (r120 == null) goto L56;
        r120.setValue(Boolean.TRUE);
    L56:
        ToastUtil.a(R.string.ttlive_gift_audio_vibrate_switch_on, 0);
        return;
    L58:
        if ((r116 & 1) == 1) goto L61;
        r101 = false;
    L61:
        if (r101 == false) goto L69;
        GiftContext r121 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r121 == null) goto L67;
        m<Boolean> r122 = r121.getEffectAudioSwitch();
        if (r122 == null) goto L67;
        r122.setValue(Boolean.TRUE);
    L67:
        ToastUtil.a(R.string.ttlive_gift_audio_switch_on, 0);
    L69:
        if (r100.T5() == false) goto L82;
        GiftContext r123 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r123 == null) goto L75;
        m<Boolean> r124 = r123.getEffectVibrateSwitch();
        if (r124 == null) goto L75;
        r124.setValue(Boolean.TRUE);
    L75:
        ToastUtil.a(R.string.ttlive_gift_vibrate_switch_on, 0);
        return;
    }

    public GiftSwitchImageView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f126647a = new LinkedHashMap();
        LayoutInflater.from(r110).inflate(R.layout.ttlive_base_gift_switch_view, this);
        ((HSImageView) _$_findCachedViewById(R.id.switch_button_image)).setOnClickListener(new e(this));
        this.f126649c = "";
        this.f126650d = "";
        AnimatorSet r113 = new AnimatorSet();
        ObjectAnimator r114 = ObjectAnimator.ofInt(_$_findCachedViewById(R.id.switch_guide_text), LiveDegradeFpsAnimator.TRANSLATION_X, new int[]{0, com.bytedance.android.live.revenue.common.i.b(10)});
        r114.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r114.setDuration(100);
        Unit r100 = Unit.INSTANCE;
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{getWidth(), s1.j(R.dimen.ttlive_gift_effect_switch_image_size)});
        r115.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r115.addUpdateListener(new a(this));
        r115.setDuration(100);
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r116.setDuration(100);
        r116.addUpdateListener(new b(this));
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r117.setStartDelay(100);
        r117.setDuration(100);
        r117.addUpdateListener(new c(this));
        r113.playTogether(new Animator[]{r114, r115, r116, r117});
        r113.addListener(new d(this));
        this.f126653g = r113;
        this.f126658l = true;
        this.f126660n = 1;
    }

    public /* synthetic */ GiftSwitchImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void Y5(String r100, String r101, int r102, long r103) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.f126649c = r100;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        this.f126650d = r101;
        this.f126660n = r102;
        this.f126648b = r103;
        if ((r102 & 1) != 1) goto L11;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        ((TextView) _$_findCachedViewById(R.id.switch_guide_text)).setText(getContext().getString(R.string.ttlive_gift_audio_gift));
    L19:
        if ((this.f126660n & 1) != 1) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L24;
    L26:
        int r106 = n0.f127469a;
        if (n0.a.a(r102) == false) goto L29;
        this.f126658l = false;
        ((TextView) _$_findCachedViewById(R.id.switch_guide_text)).setVisibility(8);
    L31:
        if (getState() != 1) goto L33;
        ImageLoader.bindImage((HSImageView) _$_findCachedViewById(R.id.switch_button_image), this.f126650d, s1.j(R.dimen.ttlive_gift_effect_switch_image_size), s1.j(R.dimen.ttlive_gift_effect_switch_image_size));
        return;
    L33:
        ImageLoader.bindImage((HSImageView) _$_findCachedViewById(R.id.switch_button_image), this.f126649c, s1.j(R.dimen.ttlive_gift_effect_switch_image_size), s1.j(R.dimen.ttlive_gift_effect_switch_image_size));
        return;
    L29:
        this.f126658l = true;
        ((TextView) _$_findCachedViewById(R.id.switch_guide_text)).setVisibility(0);
        goto L31
    L24:
        if (T5() == true) goto L26;
        this.f126660n = 0;
        goto L26
    L21:
        r105 = false;
        goto L22
    L16:
        if (T5() == false) goto L19;
        ((TextView) _$_findCachedViewById(R.id.switch_guide_text)).setText(getContext().getString(R.string.ttlive_gift_vibrate_gift));
        goto L19
    L11:
        r104 = false;
        goto L13
    }
}
