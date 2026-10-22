package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.ComboHintInfo;
import com.bytedance.android.livesdk.gift.model.ComboHintScene;
import com.bytedance.android.livesdk.gift.model.ComboHintType;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l;
import com.bytedance.android.livesdk.gift.model.m;
import com.bytedance.android.livesdk.gift.model.u;
import com.bytedance.android.livesdk.gift.model.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import defpackage.l0;
import i12.o;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboProgressAnimationView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gift/model/h2;", "value", OfficeSDKRequestTag.KEY_NEW_USER, "Lcom/bytedance/android/livesdk/gift/model/h2;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h2;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h2;)V", PbRequest.SwitchType.GIFT, "", "o", "Z", "isGroupSend", "()Z", "setGroupSend", "(Z)V", "p", "isSeriesSend", "setSeriesSend", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboProgressAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f128638x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f128639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f128640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f128641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatorSet f128642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f128643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f128644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f128645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f128646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f128647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f128648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f128649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f128650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.gift.platform.core.model.e> f128651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h2 f128652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f128653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f128654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f128655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f128656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<Integer, Boolean> f128657s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f128658t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public v f128659u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public u f128660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HSImageView f128661w;

    public static final class a {
    }

    public static final class b implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f128663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f128664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f128665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ v f128666e;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void e(k r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(k r100, Exception r101) {
            ConstraintLayout r102 = (ConstraintLayout) this.f128662a.a(R.id.combo_count_container);
            if (r102 == null) goto L6;
            r102.setVisibility(0);
            return;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(k r100, int r101, int r102, boolean r103) {
            HSImageView r104 = this.f128662a.f128661w;
            Long r105 = null;
            if (r104 == null) goto L5;
            ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        L7:
            if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r107 = r101 / r102;
            HSImageView r108 = this.f128662a.f128661w;
            if (r108 == null) goto L11;
            ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        L12:
            if (r109 == null) goto L14;
            r109.height = (int) this.f128662a.getContext().getResources().getDimension(R.dimen.ttlive_gift_send_together_combo_view_height);
        L14:
            if (r109 == null) goto L16;
            r109.width = (int) (r109.height * r107);
        L16:
            HSImageView r110 = this.f128662a.f128661w;
            if (r110 == null) goto L20;
            r110.setLayoutParams(r109);
            goto L20
        L11:
            r109 = null;
        L20:
            if ((new Random().nextInt(10) % 2) != 0) goto L22;
            float r111 = -5.0f;
        L23:
            HSImageView r112 = this.f128662a.f128661w;
            if (r112 == null) goto L26;
            r112.setRotation(r111);
        L26:
            ComboProgressAnimationView.c(this.f128662a, true, true);
            h2 r113 = this.f128662a.getGift();
            if (r113 == null) goto L29;
            r105 = Long.valueOf(r113.getId());
        L29:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r105, this.f128663b, this.f128664c, Integer.valueOf(this.f128665d), this.f128666e.getName());
            return;
        L22:
            r111 = 5.0f;
            goto L23
        L5:
            r106 = null;
            goto L7
        }

        public b(ComboProgressAnimationView r100, int r101, String r102, int r103, v r104) {
            this.f128662a = r100;
            this.f128663b = r101;
            this.f128664c = r102;
            this.f128665d = r103;
            this.f128666e = r104;
        }
    }

    public static final class c implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f128667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f128668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128669c;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void e(k r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(k r100, Exception r101) {
            ConstraintLayout r102 = (ConstraintLayout) this.f128669c.a(R.id.combo_count_container);
            if (r102 == null) goto L6;
            r102.setVisibility(0);
            return;
        }

        public c(l r100, m r101, ComboProgressAnimationView r102) {
            this.f128667a = r100;
            this.f128668b = r101;
            this.f128669c = r102;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(k r100, int r101, int r102, boolean r103) {
            HSImageView r104 = this.f128669c.f128661w;
            Integer r105 = null;
            if (r104 == null) goto L5;
            ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        L7:
            if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r107 = r101 / r102;
            HSImageView r108 = this.f128669c.f128661w;
            if (r108 == null) goto L11;
            ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        L12:
            if (r109 == null) goto L14;
            r109.height = (int) this.f128669c.getContext().getResources().getDimension(R.dimen.ttlive_gift_combo_hint_view_height);
        L14:
            if (r109 == null) goto L16;
            r109.width = (int) (r109.height * r107);
        L16:
            HSImageView r110 = this.f128669c.f128661w;
            if (r110 == null) goto L20;
            r110.setLayoutParams(r109);
            goto L20
        L11:
            r109 = null;
        L20:
            if ((new Random().nextInt(10) % 2) != 0) goto L22;
            float r111 = -5.0f;
        L23:
            HSImageView r112 = this.f128669c.f128661w;
            if (r112 == null) goto L26;
            r112.setRotation(r111);
        L26:
            ComboProgressAnimationView.c(this.f128669c, true, false);
            h2 r113 = this.f128669c.getGift();
            if (r113 == null) goto L29;
            Long r114 = Long.valueOf(r113.getId());
        L30:
            m r115 = this.f128668b;
            int r116 = r115.leftGiftCount;
            if (this.f128667a.dataList.indexOf(r115) != (this.f128667a.dataList.size() - 1)) goto L33;
            String r117 = "2";
        L34:
            h2 r118 = this.f128669c.getGift();
            if (r118 == null) goto L39;
            l r119 = l0.a(r118);
            if (r119 == null) goto L39;
            r105 = Integer.valueOf(r119.bizType);
        L39:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r114, r116, r117, r105, "");
            return;
        L33:
            r117 = "1";
            goto L34
        L29:
            r114 = null;
            goto L30
        L22:
            r111 = 5.0f;
            goto L23
        L5:
            r106 = null;
            goto L7
        }
    }

    public static final class d implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128670a;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void e(k r100) {
        }

        public d(ComboProgressAnimationView r100) {
            this.f128670a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(k r100, Exception r101) {
            ConstraintLayout r102 = (ConstraintLayout) this.f128670a.a(R.id.combo_count_container);
            if (r102 == null) goto L6;
            r102.setVisibility(0);
            return;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(k r100, int r101, int r102, boolean r103) {
            if (GiftManagerKt.s().size() > 0) goto L5;
        L7:
            HSImageView r104 = this.f128670a.f128661w;
            ViewGroup.LayoutParams r105 = null;
            if (r104 == null) goto L10;
            ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        L12:
            if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L24;
            float r107 = r101 / r102;
            HSImageView r108 = this.f128670a.f128661w;
            if (r108 == null) goto L16;
            r105 = r108.getLayoutParams();
        L16:
            if (r105 == null) goto L18;
            r105.height = (int) this.f128670a.getContext().getResources().getDimension(R.dimen.ttlive_gift_special_combo_view_height);
        L18:
            if (r105 == null) goto L20;
            r105.width = (int) (r105.height * r107);
        L20:
            HSImageView r109 = this.f128670a.f128661w;
            if (r109 == null) goto L24;
            r109.setLayoutParams(r105);
        L24:
            if ((new Random().nextInt(10) % 2) != 0) goto L26;
            float r110 = -5.0f;
        L27:
            HSImageView r111 = this.f128670a.f128661w;
            if (r111 == null) goto L30;
            r111.setRotation(r110);
        L30:
            ComboProgressAnimationView.c(this.f128670a, false, false);
            return;
        L26:
            r110 = 5.0f;
            goto L27
        L10:
            r106 = null;
            goto L12
        L5:
            if (this.f128670a.f128640b >= ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), 0)).comboCount) goto L7;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128671a;

        public e(ComboProgressAnimationView r100) {
            this.f128671a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Disposable r102 = this.f128671a.f128658t;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            ComboProgressAnimationView r103 = this.f128671a;
            r103.f128658t = null;
            r103.f128659u = null;
            r103.f128660v = null;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f128672a = null;

        static {
            f128672a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class g implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128673a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public g(ComboProgressAnimationView r100) {
            this.f128673a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ConstraintLayout r101 = (ConstraintLayout) this.f128673a.a(R.id.combo_count_container);
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ConstraintLayout r101 = (ConstraintLayout) this.f128673a.a(R.id.combo_count_container);
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }
    }

    public static final class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128674a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public h(ComboProgressAnimationView r100) {
            this.f128674a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ConstraintLayout r101 = (ConstraintLayout) this.f128674a.a(R.id.combo_progress_bar_container);
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ConstraintLayout r101 = (ConstraintLayout) this.f128674a.a(R.id.combo_progress_bar_container);
            if (r101 == null) goto L6;
            r101.setVisibility(8);
            return;
        }
    }

    public static final class i extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboProgressAnimationView f128675a;

        public i(ComboProgressAnimationView r100) {
            this.f128675a = r100;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ComboProgressAnimationView r101 = this.f128675a;
            if (r101.f128648j == false) goto L6;
            ComboProgressAnimationView.b(r101, false);
            return;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ComboProgressAnimationView r101 = this.f128675a;
            if (r101.f128648j == false) goto L6;
            ComboProgressAnimationView.b(r101, false);
            return;
        }
    }

    static {
    }

    public ComboProgressAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ComboProgressAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d() {
        AnimatorSet r100 = this.f128642d;
        if (r100 != null) goto L5;
    L12:
        this.f128642d = null;
        return;
    L5:
        if (r100.isRunning() != true) goto L12;
        AnimatorSet r101 = this.f128642d;
        if (r101 == null) goto L9;
        r101.removeAllListeners();
    L9:
        AnimatorSet r102 = this.f128642d;
        if (r102 == null) goto L12;
        r102.cancel();
        goto L12
    }

    public final void e() {
        AnimatorSet r100 = this.f128641c;
        if (r100 != null) goto L5;
    L12:
        this.f128641c = null;
        return;
    L5:
        if (r100.isRunning() != true) goto L12;
        AnimatorSet r101 = this.f128641c;
        if (r101 == null) goto L9;
        r101.removeAllListeners();
    L9:
        AnimatorSet r102 = this.f128641c;
        if (r102 == null) goto L12;
        r102.cancel();
        goto L12
    }

    public final void f() {
        AnimatorSet r100 = this.f128643e;
        if (r100 != null) goto L5;
    L12:
        this.f128643e = null;
        return;
    L5:
        if (r100.isRunning() != true) goto L12;
        AnimatorSet r101 = this.f128643e;
        if (r101 == null) goto L9;
        r101.removeAllListeners();
    L9:
        AnimatorSet r102 = this.f128643e;
        if (r102 == null) goto L12;
        r102.cancel();
        goto L12
    }

    public final void k() {
        Disposable r100 = this.f128658t;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f128658t = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.f128672a);
    }

    public final void l() {
        h2 r100 = this.f128652n;
        int r101 = 0;
        if (r100 == null) goto L9;
        l r102 = l0.a(r100);
        if (r102 == null) goto L9;
        List<m> r103 = r102.dataList;
        if (r103 == null) goto L9;
        int r104 = r103.size();
    L10:
        Integer r105 = null;
        if (r104 <= 0) goto L17;
        h2 r106 = this.f128652n;
        if (r106 == null) goto L15;
        l r107 = l0.a(r106);
    L16:
        p(r107);
        goto L17
    L15:
        r107 = null;
    L17:
        d();
        this.f128651m.size();
        float r108 = 1.0f;
        if (this.f128648j == true) goto L45;
        int r109 = this.f128651m.size();
        int r110 = 0;
    L21:
        if (r110 >= r109) goto L45;
        com.bytedance.android.livesdk.gift.platform.core.model.e r111 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(this.f128651m, r110);
        int r112 = this.f128640b;
        if (r111 == null) goto L25;
        int r113 = r111.comboCount;
    L26:
        if (r112 < r113) goto L27;
        r110 = r110 + 1;
        goto L21
    L27:
        if (r110 != 0) goto L32;
        float r114 = r112;
        if (r111 == null) goto L31;
        r108 = r111.comboCount;
    L31:
        r108 = r114 / r108;
        goto L45
    L32:
        com.bytedance.android.livesdk.gift.platform.core.model.e r115 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(this.f128651m, r110 - 1);
        int r116 = this.f128640b;
        if (r115 == null) goto L35;
        int r117 = r115.comboCount;
    L36:
        float r118 = r116 - r117;
        if (r111 == null) goto L39;
        int r119 = r111.comboCount;
    L40:
        if (r115 == null) goto L42;
        int r120 = r115.comboCount;
    L43:
        r108 = r118 / (r119 - r120);
        goto L45
    L42:
        r120 = 0;
        goto L43
    L39:
        r119 = 0;
        goto L40
    L35:
        r117 = 0;
        goto L36
    L25:
        r113 = 0;
    L45:
        int r121 = GiftManagerKt.s().size();
        if (r121 <= 0) goto L56;
        View r122 = a(R.id.combo_count_bg);
        if (r122 == null) goto L56;
        int r123 = this.f128640b;
        com.bytedance.android.livesdk.gift.platform.core.model.e r124 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r121 - 1);
        if (r124 == null) goto L53;
        r105 = Integer.valueOf(r124.comboCount);
    L53:
        if (r123 < r105.intValue()) goto L55;
        r101 = 4;
    L55:
        r122.setVisibility(r101);
    L56:
        float r125 = s1.e(38.0f) * r108;
        ConstraintLayout r126 = (ConstraintLayout) a(R.id.combo_count_container);
        if (r126 == null) goto L62;
        r126.setTranslationY(-r125);
        return;
    L62:
        return;
    L9:
        r104 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h2 r100 = this.f128652n;
        if (r100 == null) goto L5;
        Long r101 = Long.valueOf(r100.getId());
    L6:
        q(r101);
        super.onDetachedFromWindow();
        Disposable r102 = this.f128658t;
        if (r102 == null) goto L10;
        r102.dispose();
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void j() {
        e();
        ConstraintLayout r100 = (ConstraintLayout) a(R.id.combo_progress_bar_container);
        if (r100 == null) goto L6;
        r100.setScaleY(1.0f);
    L6:
        if (this.f128640b > this.f128649k) goto L8;
    L19:
        n();
        if (this.f128646h == false) goto L22;
        long r101 = 100;
    L23:
        m(r101);
        Object r102 = getContext().getSystemService("vibrator");
        if (r102 == null) goto L28;
        ((Vibrator) r102).vibrate(50);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L22:
        r101 = 1800;
        goto L23
    L8:
        if (this.f128650l == true) goto L19;
        HSImageView r103 = this.f128661w;
        if (r103 == null) goto L12;
        r103.setTranslationY(this.f128647i);
    L12:
        HSImageView r104 = this.f128661w;
        if (r104 == null) goto L15;
        r104.setScaleX(1.0f);
    L15:
        HSImageView r105 = this.f128661w;
        if (r105 == null) goto L18;
        r105.setScaleY(1.0f);
    L18:
        o();
        goto L19
    }

    public final void n() {
        e();
        this.f128641c = new AnimatorSet();
        ConstraintLayout r100 = (ConstraintLayout) a(R.id.combo_progress_bar_container);
        if (r100 == null) goto L9;
        ConstraintLayout r101 = (ConstraintLayout) a(R.id.combo_progress_bar_container);
        if (r101 == null) goto L7;
        Integer r102 = Integer.valueOf(r101.getHeight());
    L8:
        r100.setPivotY(r102.intValue());
        goto L9
    L7:
        r102 = null;
    L9:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(a(R.id.combo_progress_bar_container), LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.2f});
        AnimatorSet r104 = this.f128641c;
        if (r104 == null) goto L12;
        r104.playTogether(new Animator[]{r103});
    L12:
        AnimatorSet r105 = this.f128641c;
        if (r105 == null) goto L15;
        r105.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.86f, 0.0f));
    L15:
        AnimatorSet r106 = this.f128641c;
        if (r106 == null) goto L18;
        r106.setDuration(1800);
    L18:
        ConstraintLayout r107 = (ConstraintLayout) a(R.id.combo_progress_bar_container);
        if (r107 == null) goto L21;
        r107.setVisibility(0);
    L21:
        AnimatorSet r108 = this.f128641c;
        if (r108 == null) goto L24;
        r108.addListener(new h(this));
    L24:
        AnimatorSet r109 = this.f128641c;
        if (r109 == null) goto L28;
        r109.start();
        return;
    }

    public final void o() {
        f();
        this.f128650l = false;
        this.f128643e = new AnimatorSet();
        if (this.f128648j == false) goto L13;
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.f128661w, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{this.f128647i, s1.e(90.0f)});
        PropertyValuesHolder r101 = PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f});
        PropertyValuesHolder r102 = PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f});
        ObjectAnimator r103 = ObjectAnimator.ofPropertyValuesHolder(this.f128661w, new PropertyValuesHolder[]{r101, r102});
        AnimatorSet r104 = this.f128643e;
        if (r104 == null) goto L7;
        r104.playTogether(new Animator[]{r100, r103});
    L7:
        AnimatorSet r105 = this.f128643e;
        if (r105 == null) goto L10;
        r105.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.86f, 0.0f));
    L10:
        AnimatorSet r106 = this.f128643e;
        if (r106 == null) goto L16;
        r106.setDuration(1800);
    L16:
        AnimatorSet r107 = this.f128643e;
        if (r107 == null) goto L19;
        r107.addListener(new i(this));
    L19:
        AnimatorSet r108 = this.f128643e;
        if (r108 == null) goto L22;
        r108.start();
    L22:
        this.f128644f = false;
        return;
    L13:
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this.f128661w, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, s1.e(50.0f)});
        PropertyValuesHolder r110 = PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f});
        PropertyValuesHolder r111 = PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f});
        ObjectAnimator r112 = ObjectAnimator.ofPropertyValuesHolder(this.f128661w, new PropertyValuesHolder[]{r110, r111});
        r109.setDuration(300);
        r109.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        AnimatorSet r113 = this.f128643e;
        if (r113 == null) goto L16;
        r113.playSequentially(new Animator[]{r109, r112});
        goto L16
    }

    public final h2 getGift() {
        return this.f128652n;
    }

    public final View a(int r100) {
        if (this.f128639a != null) goto L5;
        this.f128639a = new LinkedHashMap();
    L5:
        View r101 = this.f128639a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f128639a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void m(long r100) {
        d();
        this.f128642d = new AnimatorSet();
        ObjectAnimator r101 = ObjectAnimator.ofFloat(a(R.id.combo_count_container), LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.e(32.0f)});
        AnimatorSet r102 = this.f128642d;
        if (r102 == null) goto L5;
        r102.playTogether(new Animator[]{r101});
    L5:
        AnimatorSet r103 = this.f128642d;
        if (r103 == null) goto L8;
        r103.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.86f, 0.0f));
    L8:
        AnimatorSet r104 = this.f128642d;
        if (r104 == null) goto L11;
        r104.setDuration(r100);
    L11:
        AnimatorSet r105 = this.f128642d;
        if (r105 == null) goto L14;
        r105.start();
    L14:
        AnimatorSet r106 = this.f128642d;
        if (r106 == null) goto L18;
        r106.addListener(new g(this));
        return;
    }

    public final void p(l r100) {
        this.f128651m.clear();
        if (r100 == null) goto L7;
        List<m> r101 = r100.dataList;
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L8:
        if (r102 <= 0) goto L90;
        int r103 = 0;
        int r104 = 0;
    L10:
        k r105 = null;
        if (r103 >= GiftManagerKt.s().size()) goto L46;
        if (r100 == null) goto L16;
        List<m> r106 = r100.dataList;
        if (r106 == null) goto L16;
        int r107 = r106.size();
    L17:
        if (r104 >= r107) goto L46;
        com.bytedance.android.livesdk.gift.platform.core.model.e r108 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r103);
        if (r100 == null) goto L21;
        int r109 = r100.curLeftGiftCount;
    L22:
        if (r100 == null) goto L28;
        List<m> r110 = r100.dataList;
        if (r110 == null) goto L28;
        m r111 = (m) ListProtector.get(r110, r104);
        if (r111 == null) goto L28;
        int r112 = r111.leftGiftCount;
    L29:
        int r113 = (r109 - r112) + 1;
        int r114 = r108.comboCount;
        if (r114 < r113) goto L31;
        com.bytedance.android.livesdk.gift.platform.core.model.e r115 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r115.comboCount = r113;
        if (r100 == null) goto L41;
        List<m> r116 = r100.dataList;
        if (r116 == null) goto L41;
        m r117 = (m) ListProtector.get(r116, r104);
        if (r117 == null) goto L41;
        r105 = r117.hintImg;
    L41:
        r115.comboEffectImg = r105;
        if (r115.comboCount <= 0) goto L44;
        this.f128651m.add(r115);
    L44:
        r104 = r104 + 1;
        goto L10
    L31:
        if (r114 <= 0) goto L33;
        this.f128651m.add(r108);
    L33:
        r103 = r103 + 1;
    L28:
        r112 = 0;
        goto L29
    L21:
        r109 = 0;
    L16:
        r107 = 0;
    L46:
        if (r103 >= GiftManagerKt.s().size()) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.model.e r118 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r103);
        if (r118.comboCount <= 0) goto L50;
        this.f128651m.add(r118);
    L50:
        r103 = r103 + 1;
    L51:
        h2 r119 = this.f128652n;
        if (r119 == null) goto L58;
        l r120 = l0.a(r119);
        if (r120 == null) goto L58;
        List<m> r121 = r120.dataList;
        if (r121 == null) goto L58;
        int r122 = r121.size();
    L59:
        if (r104 >= r122) goto L106;
        h2 r123 = this.f128652n;
        if (r123 == null) goto L65;
        l r124 = l0.a(r123);
        if (r124 == null) goto L65;
        int r125 = r124.curLeftGiftCount;
    L66:
        h2 r126 = this.f128652n;
        if (r126 == null) goto L75;
        l r127 = l0.a(r126);
        if (r127 == null) goto L75;
        List<m> r128 = r127.dataList;
        if (r128 == null) goto L75;
        m r129 = (m) ListProtector.get(r128, r104);
        if (r129 == null) goto L75;
        int r130 = r129.leftGiftCount;
    L76:
        int r131 = (r125 - r130) + 1;
        com.bytedance.android.livesdk.gift.platform.core.model.e r132 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r132.comboCount = r131;
        h2 r133 = this.f128652n;
        if (r133 == null) goto L85;
        l r134 = l0.a(r133);
        if (r134 == null) goto L85;
        List<m> r135 = r134.dataList;
        if (r135 == null) goto L85;
        m r136 = (m) ListProtector.get(r135, r104);
        if (r136 == null) goto L85;
        k r137 = r136.hintImg;
    L86:
        r132.comboEffectImg = r137;
        if (r132.comboCount <= 0) goto L89;
        this.f128651m.add(r132);
    L89:
        r104 = r104 + 1;
    L85:
        r137 = null;
    L75:
        r130 = 0;
    L65:
        r125 = 0;
        goto L66
    L106:
        return;
    L58:
        r122 = 0;
        goto L59
    L90:
        this.f128651m.addAll(GiftManagerKt.s());
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final void q(Long r100) {
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
        String r102 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + String.valueOf(r101);
        HashMap<String, Boolean> r103 = ay1.b.i();
        r103.put(r102, Boolean.valueOf(this.f128655q));
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        ay1.b.f16692i0.setValue(null, ay1.b.f16675a[72], r103);
        return;
    }

    public final void setGift(h2 r100) {
        Long r101 = null;
        if (r100 == null) goto L5;
        l r102 = l0.a(r100);
    L6:
        p(r102);
        if (r100 == null) goto L9;
        r101 = Long.valueOf(r100.getId());
    L9:
        if (r101 == null) goto L15;
        long r103 = r101.longValue();
        Boolean r104 = ay1.b.i().get(((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + String.valueOf(r103));
        if (r104 == null) goto L13;
        boolean r105 = r104.booleanValue();
    L14:
        this.f128655q = r105;
        goto L15
    L13:
        r105 = false;
    L15:
        this.f128652n = r100;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setGroupSend(boolean r100) {
        this.f128653o = r100;
    }

    public final void setSeriesSend(boolean r100) {
        this.f128654p = r100;
    }

    public static final void b(ComboProgressAnimationView r100, boolean r101) {
        r100.getClass();
        int r102 = GiftManagerKt.s().size();
        if (r102 <= 0) goto L7;
        ImageLoader.bindImage(r100.f128661w, ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r102 - 1)).comboEffectImg, new b02.g(r100, r101));
        return;
    }

    public static int g(int r100, List r101) {
        if (r101 == null) goto L10;
        Iterator r102 = r101.iterator();
        int r103 = 99999;
    L6:
        if (r102.hasNext() == false) goto L11;
        v r104 = (v) r102.next();
        if (r104.getCount() <= r100) goto L6;
        r103 = Math.min(r103, ((int) r104.getCount()) - r100);
    L11:
        if (r103 != 99999) goto L19;
        return 0;
    L19:
        return r103;
    L10:
        r103 = 99999;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    public final void i(int r210, int r211) {
        int r100 = this.f128640b;
        if (r100 != r210) goto L6;
        return;
    L6:
        if (r100 <= r210) goto L13;
        this.f128648j = false;
        HSImageView r101 = this.f128661w;
        if (r101 == null) goto L10;
        r101.setScaleX(0.0f);
    L10:
        HSImageView r102 = this.f128661w;
        if (r102 == null) goto L13;
        r102.setScaleY(0.0f);
    L13:
        this.f128640b = r210;
        if (r210 != 0) goto L16;
        return;
    L16:
        TextView r103 = (TextView) a(R.id.combo_count_tv_1);
        if (r103 == null) goto L19;
        r103.setText(String.valueOf(r210));
    L19:
        TextView r104 = (TextView) a(R.id.combo_count_tv_2);
        if (r104 == null) goto L22;
        r104.setText(String.valueOf(r210));
    L22:
        TextView r105 = (TextView) a(R.id.combo_count_tv_3);
        if (r105 == null) goto L25;
        r105.setText(String.valueOf(r210));
    L25:
        ?? r106 = 1;
        if (r210 != 1) goto L45;
        e();
        this.f128641c = new AnimatorSet();
        ConstraintLayout r107 = (ConstraintLayout) a(R.id.combo_progress_bar_container);
        if (r107 == null) goto L30;
        r107.setPivotY(s1.e(110.0f));
    L30:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(a(R.id.combo_progress_bar_container), LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.2f, 1.0f});
        AnimatorSet r109 = this.f128641c;
        if (r109 == null) goto L33;
        r109.playTogether(new Animator[]{r108});
    L33:
        AnimatorSet r110 = this.f128641c;
        if (r110 == null) goto L36;
        r110.setDuration(200);
    L36:
        AnimatorSet r111 = this.f128641c;
        if (r111 == null) goto L39;
        r111.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
    L39:
        AnimatorSet r112 = this.f128641c;
        if (r112 == null) goto L42;
        r112.addListener(new b02.h(this));
    L42:
        AnimatorSet r113 = this.f128641c;
        if (r113 == null) goto L45;
        r113.start();
    L45:
        Disposable r114 = this.f128658t;
        if (r114 != null) goto L48;
    L70:
        h2 r115 = this.f128652n;
        if (r115 == null) goto L83;
        long r116 = r115.getId();
        i12.e r117 = o.b();
        if (r117 == null) goto L75;
        Object r118 = com.bytedance.android.scope.m.f163449e.d(r117, GiftExtraRepo.class);
    L76:
        GiftExtraRepo r119 = (GiftExtraRepo) r118;
        if (r119 == null) goto L83;
        g0 r120 = r119.q(r116);
        if (r120 == null) goto L83;
        ComboHintInfo r121 = r120.getComboHintInfo();
        if (r121 == null) goto L83;
        List<u> r122 = r121.getComboHintList();
    L84:
        h2 r123 = this.f128652n;
        if (r123 == null) goto L87;
        long r124 = r123.getPrimaryEffectId();
    L89:
        if (this.f128654p == true) goto L246;
        if (r122 == null) goto L246;
        Iterator<T> r125 = r122.iterator();
    L93:
        if (r125.hasNext() == false) goto L246;
        u r126 = (u) r125.next();
        String r127 = "";
        if (r126.getComboHintScene() != ComboHintScene.SEND_TOGETHER.getScene()) goto L175;
        ArrayList r128 = new ArrayList();
        GiftContext r129 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r129 == null) goto L103;
        com.bytedance.live.datacontext.m<Boolean> r130 = r129.isIntercept();
        if (r130 == null) goto L103;
        Boolean r131 = r130.getValue();
        if (r131 == null) goto L103;
        boolean r132 = r131.booleanValue();
    L104:
        GiftContext r133 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r133 == null) goto L113;
        n<i02.a> r134 = r133.getCurrentSendTogetherInfo();
        if (r134 == null) goto L113;
        i02.a r135 = r134.getValue();
        if (r135 == null) goto L113;
        Integer r136 = r135.f487856c;
        if (r136 == null) goto L113;
        int r137 = r136.intValue();
    L114:
        GiftContext r138 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r138 == null) goto L121;
        n<i02.a> r139 = r138.getCurrentSendTogetherInfo();
        if (r139 == null) goto L121;
        i02.a r140 = r139.getValue();
        if (r140 == null) goto L121;
        List<i02.e> r141 = r140.f487855b;
    L122:
        if (r141 == null) goto L127;
        Iterator<T> r142 = r141.iterator();
    L125:
        if (r142.hasNext() == false) goto L127;
        r128.addAll(((i02.e) r142.next()).f487869a);
    L127:
        boolean r143 = r128.contains(Integer.valueOf((int) r124));
        if (r132 == true) goto L140;
        if (r143 == false) goto L140;
        GiftContext r144 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r144 == null) goto L138;
        com.bytedance.live.datacontext.m<Integer> r145 = r144.getMsgCount();
        if (r145 == null) goto L138;
        Integer r146 = r145.getValue();
        if (r146 == null) goto L138;
        int r147 = r146.intValue();
    L139:
        int r148 = r137 + r147;
    L141:
        List<v> r149 = r126.getComboHintData();
        if (r149 == null) goto L175;
        int r150 = r149.size() - r106;
        if (r150 < 0) goto L175;
        int r151 = 0;
    L146:
        v r152 = (v) ListProtector.get(r149, r151);
        if (r152.getComboHintType() != ComboHintType.COMMON.getType()) goto L158;
        List<v> r153 = r149;
        if (((r148 + r210) - r211) != (((int) r152.getCount()) - r106)) goto L172;
        Boolean r154 = (Boolean) ((LinkedHashMap) this.f128657s).get(Integer.valueOf((int) r152.getCount()));
        if (r154 == null) goto L153;
        boolean r155 = r154.booleanValue();
    L154:
        if (r155 == true) goto L172;
        this.f128655q = r106;
        this.f128657s.put(Integer.valueOf((int) r152.getCount()), Boolean.TRUE);
        h(r152, 0, 3, "");
        this.f128659u = r152;
        this.f128660v = r126;
        k();
        return;
    L153:
        r155 = false;
    L172:
        if (r151 == r150) goto L175;
        r151 = r151 + 1;
        r149 = r153;
        goto L146
    L158:
        r153 = r149;
        if (r152.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L172;
        if (this.f128655q == true) goto L172;
        this.f128655q = r106;
        h2 r156 = this.f128652n;
        if (r156 == null) goto L166;
        Long r157 = Long.valueOf(r156.getId());
    L167:
        q(r157);
        if (this.f128653o == true) goto L172;
        this.f128659u = r152;
        this.f128660v = r126;
        h(r152, 0, 3, "");
        k();
        return;
    L166:
        r157 = null;
    L138:
        r147 = 0;
    L140:
        r148 = 0;
    L121:
        r141 = null;
    L113:
        r137 = 0;
    L103:
        r132 = false;
    L175:
        if (r126.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L244;
        List<v> r158 = r126.getComboHintData();
        if (r158 == null) goto L244;
        int r159 = r158.size() - r106;
        if (r159 < 0) goto L244;
        int r160 = 0;
    L181:
        v r161 = (v) ListProtector.get(r158, r160);
        if (r161.getComboHintType() != ComboHintType.COMMON.getType()) goto L192;
        if (r210 == ((int) r161.getCount())) goto L185;
    L239:
        List<v> r162 = r158;
    L241:
        if (r160 == r159) goto L244;
        r160 = r160 + 1;
        r158 = r162;
        goto L181
    L185:
        int r163 = g(r210, r126.getComboHintData());
        String r164 = r161.getName();
        if (r164 == null) goto L189;
        r127 = r164;
    L189:
        h(r161, r163, 4, r127);
        this.f128659u = r161;
        this.f128660v = r126;
        k();
        return;
    L192:
        if (r161.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L239;
        h2 r165 = this.f128652n;
        if (r165 == null) goto L196;
        Long r166 = Long.valueOf(r165.getId());
    L198:
        if (r166 == null) goto L214;
        r166.longValue();
        int r167 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r168 = ay1.b.r();
        if (r168 != null) goto L202;
    L201:
        r162 = r158;
    L213:
        boolean r169 = true;
    L216:
        if (r169 == false) goto L241;
        if (this.f128656r == true) goto L241;
        this.f128656r = true;
        String r170 = r161.getName();
        if (r170 == null) goto L224;
        r127 = r170;
    L224:
        h(r161, 0, 4, r127);
        this.f128659u = r161;
        this.f128660v = r126;
        k();
        h2 r171 = this.f128652n;
        if (r171 == null) goto L227;
        Long r172 = Long.valueOf(r171.getId());
    L228:
        if (r172 == null) goto L300;
        r172.longValue();
        int r173 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r174 = ay1.b.r();
        Pair<Integer, Integer> r175 = r174.get(r172);
        if (r175 != null) goto L233;
        r175 = new Pair(Integer.valueOf(r173), 0);
    L233:
        if (r175.getFirst().intValue() == r173) goto L235;
        Pair<Integer, Integer> r176 = new Pair(Integer.valueOf(r173), 1);
    L236:
        r174.put(r172, r176);
        Intrinsics.checkNotNullParameter(r174, "<set-?>");
        ay1.b.f16704o0.setValue(null, ay1.b.f16675a[79], r174);
        return;
    L235:
        r176 = new Pair(Integer.valueOf(r173), Integer.valueOf(r175.getSecond().intValue() + 1));
        goto L236
    L300:
        return;
    L227:
        r172 = null;
        goto L228
    L202:
        Pair<Integer, Integer> r177 = r168.get(r166);
        if (r177 == null) goto L201;
        r162 = r158;
        Integer r178 = (Integer) ((HashMap) nz1.a.M.getValue(null, nz1.a.f521324a[37])).get(r166);
        if (r178 != null) goto L208;
        r178 = 3;
    L208:
        int r179 = r178.intValue();
        if (r177.getFirst().intValue() != r167) goto L213;
        if (r177.getSecond().intValue() <= r179) goto L213;
    L215:
        r169 = false;
        goto L216
    L214:
        r162 = r158;
        goto L215
    L196:
        r166 = null;
    L244:
        r106 = 1;
    L246:
        if (this.f128645g == true) goto L261;
        h2 r180 = this.f128652n;
        if (r180 == null) goto L261;
        l r181 = l0.a(r180);
        if (r181 == null) goto L261;
        Iterator<m> r182 = r181.dataList.iterator();
    L253:
        if (r182.hasNext() == false) goto L261;
        m r183 = r182.next();
        if (r183.leftGiftCount != ((r181.curLeftGiftCount - r210) + 1)) goto L253;
        ConstraintLayout r184 = (ConstraintLayout) a(R.id.combo_count_container);
        if (r184 == null) goto L259;
        r184.setVisibility(8);
    L259:
        ImageLoader.bindImage(this.f128661w, r183.hintImg, new c(r181, r183, this));
        l();
        return;
    L261:
        this.f128646h = false;
        int r185 = GiftManagerKt.s().size();
        int r186 = 0;
    L262:
        if (r186 >= r185) goto L279;
        if (this.f128645g == true) goto L279;
        com.bytedance.android.livesdk.gift.platform.core.model.e r187 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r186);
        if (r210 == r187.comboCount) goto L267;
        r186 = r186 + 1;
        goto L262
    L267:
        this.f128646h = true;
        if (r186 != (GiftManagerKt.s().size() - 1)) goto L270;
        boolean r188 = true;
    L271:
        this.f128648j = r188;
        if (r188 == true) goto L276;
        ConstraintLayout r189 = (ConstraintLayout) a(R.id.combo_count_container);
        if (r189 == null) goto L276;
        r189.setVisibility(8);
    L276:
        ImageLoader.bindImage(this.f128661w, r187.comboEffectImg, new d(this));
        goto L279
    L270:
        r188 = false;
    L279:
        if (this.f128646h == true) goto L283;
        ConstraintLayout r190 = (ConstraintLayout) a(R.id.combo_count_container);
        if (r190 == null) goto L283;
        r190.setVisibility(0);
    L283:
        l();
        return;
    L87:
        r124 = -1;
        goto L89
    L75:
        r118 = null;
    L83:
        r122 = null;
        goto L84
    L48:
        if (r114.isDisposed() == true) goto L70;
        v r191 = this.f128659u;
        if (r191 == null) goto L70;
        h2 r192 = this.f128652n;
        if (r192 == null) goto L54;
        Long r193 = Long.valueOf(r192.getId());
    L55:
        u r194 = this.f128660v;
        if (r194 == null) goto L58;
        List<v> r195 = r194.getComboHintData();
    L59:
        int r196 = g(r210, r195);
        u r197 = this.f128660v;
        if (r197 != null) goto L62;
    L64:
        if (r197 != null) goto L66;
    L68:
        int r198 = 0;
    L69:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.n(r193, r196, Integer.valueOf(r198), r191.getName(), r191.getName());
        goto L70
    L66:
        if (r197.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L68;
        r198 = 4;
        goto L69
    L62:
        if (r197.getComboHintScene() != ComboHintScene.SEND_TOGETHER.getScene()) goto L64;
        r198 = 3;
        goto L69
    L58:
        r195 = null;
        goto L59
    L54:
        r193 = null;
        goto L55
    }

    public ComboProgressAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f128639a = new LinkedHashMap();
        this.f128651m = new ArrayList();
        this.f128657s = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_base_gift_combo_progress, this);
        this.f128661w = (HSImageView) a(R.id.special_combo_iv);
        int r103 = GiftManagerKt.s().size();
        if (r103 <= 0) goto L21;
        this.f128649k = ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r103 - 1)).comboCount;
    L21:
        Typeface r104 = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L15
        TextView r105 = (TextView) a(R.id.combo_count_tv_1);     // Catch: Exception -> L15
        if (r105 == null) goto L8;
        r105.setTypeface(r104);     // Catch: Exception -> L15
    L8:
        TextView r106 = (TextView) a(R.id.combo_count_tv_2);     // Catch: Exception -> L15
        if (r106 == null) goto L11;
        r106.setTypeface(r104);     // Catch: Exception -> L15
    L11:
        TextView r107 = (TextView) a(R.id.combo_count_tv_3);     // Catch: Exception -> L15
        if (r107 == null) goto L18;
        r107.setTypeface(r104);     // Catch: Exception -> L15
    L18:
        if (this.f128651m.isEmpty() == false) goto L23;
        this.f128651m.addAll(GiftManagerKt.s());
        return;
    L23:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("ComboProgressAnimationView", "load font asset exception: " + e.getMessage(), null, 4);
        goto L18
    }

    public static final void c(ComboProgressAnimationView r110, boolean r111, boolean r112) {
        r110.f128650l = r111;
        r110.f();
        r110.f128643e = new AnimatorSet();
        if (r110.f128648j == false) goto L6;
        if (r111 == true) goto L6;
        float r100 = s1.e(36.0f);
    L7:
        r110.f128647i = r100;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r110.f128661w, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.e(90.0f), r110.f128647i});
        r101.setDuration(150);
        ObjectAnimator r102 = ObjectAnimator.ofPropertyValuesHolder(r110.f128661w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.3f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.3f})});
        r102.setDuration(250);
        AnimatorSet r103 = new AnimatorSet();
        r103.playTogether(new Animator[]{r101, r102});
        ObjectAnimator r104 = ObjectAnimator.ofPropertyValuesHolder(r110.f128661w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.3f, 0.9f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.3f, 0.9f})});
        r104.setDuration(200);
        ObjectAnimator r105 = ObjectAnimator.ofPropertyValuesHolder(r110.f128661w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{0.9f, 1.02f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.9f, 1.02f})});
        r105.setDuration(250);
        ObjectAnimator r106 = ObjectAnimator.ofPropertyValuesHolder(r110.f128661w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.02f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.02f, 1.0f})});
        r106.setDuration(250);
        AnimatorSet r113 = new AnimatorSet();
        r113.playSequentially(new Animator[]{r103, r104, r105, r106});
        r113.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r110.f128661w, "alpha", new float[]{1.0f, 1.0f});
        r107.setDuration(800);
        ObjectAnimator r108 = ObjectAnimator.ofPropertyValuesHolder(r110.f128661w, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.0f})});
        r108.setDuration(250);
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r107, r108});
        r109.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
        if (r110.f128648j == false) goto L13;
        if (r111 == true) goto L13;
        AnimatorSet r114 = r110.f128643e;
        if (r114 == null) goto L16;
        r114.playSequentially(new Animator[]{r113});
    L16:
        AnimatorSet r115 = r110.f128643e;
        if (r115 == null) goto L19;
        r115.addListener(new b02.i(r110, r112, r111));
    L19:
        AnimatorSet r116 = r110.f128643e;
        if (r116 == null) goto L23;
        r116.start();
        return;
    L23:
        return;
    L13:
        AnimatorSet r117 = r110.f128643e;
        if (r117 == null) goto L16;
        r117.playSequentially(new Animator[]{r113, r109});
    L6:
        r100 = 0.0f;
        goto L7
    }

    public /* synthetic */ ComboProgressAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void h(v r110, int r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "each");
        Intrinsics.checkNotNullParameter(r113, "showTime");
        ConstraintLayout r100 = (ConstraintLayout) a(R.id.combo_count_container);
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        ImageLoader.bindImage(this.f128661w, r110.getHintImg(), new b(this, r111, r113, r112, r110));
        l();
    }
}
