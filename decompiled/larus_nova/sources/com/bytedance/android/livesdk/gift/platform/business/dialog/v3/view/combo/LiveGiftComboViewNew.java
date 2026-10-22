package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b02.l;
import b02.m;
import b02.n;
import b02.o;
import b02.p;
import b02.s;
import b02.t;
import b02.u;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import pz1.e;

/* JADX INFO: loaded from: classes9.dex */
public class LiveGiftComboViewNew extends FrameLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f128676r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f128677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f128678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f128679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatorSet f128680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f128681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f128682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f128683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f128684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AbsPanel f128685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f128686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RoundWaveAnimationView f128687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ComboEffectAnimationView f128688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ComboProgressAnimationView f128689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ComboIconAnimationView f128690n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f128691o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f128692p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f128693q;

    public class a extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f128694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveGiftComboViewNew f128695b;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            LiveGiftComboViewNew r101 = this.f128695b;
            r101.f128681e = 0;
            r101.f128684h = 0;
            ComboEffectAnimationView r102 = r101.f128688l;
            if (r102 == null) goto L5;
            r102.a(0);
        L5:
            LiveGiftComboViewNew r103 = this.f128695b;
            ComboIconAnimationView r104 = r103.f128690n;
            if (r104 == null) goto L8;
            r104.c(r103.f128684h);
        L8:
            LiveGiftComboViewNew r105 = this.f128695b;
            ComboProgressAnimationView r106 = r105.f128689m;
            if (r106 == null) goto L11;
            r106.i(r105.f128684h, 0);
        L11:
            Runnable r107 = this.f128694a;
            if (r107 == null) goto L15;
            r107.run();
            return;
        }

        public a(LiveGiftComboViewNew r100, Runnable r101) {
            this.f128695b = r100;
            this.f128694a = r101;
        }
    }

    public class b extends o12.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f128696a;

        public b(Runnable r100) {
            this.f128696a = r100;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Runnable r101 = this.f128696a;
            if (r101 == null) goto L6;
            r101.run();
            return;
        }
    }

    public final void d() {
        this.f128684h = 0;
        b();
        setScaleX(1.0f);
        setScaleY(1.0f);
        View r100 = this.f128677a;
        if (r100 == null) goto L5;
        r100.setRotation(0.0f);
    L5:
        this.f128693q = 0;
        this.f128681e = 0;
        RoundWaveAnimationView r101 = this.f128687k;
        if (r101 == null) goto L11;
        Disposable r102 = r101.f128697a;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        r101.removeAllViews();
    L11:
        ComboIconAnimationView r103 = this.f128690n;
        Long r104 = null;
        if (r103 == null) goto L23;
        Bitmap r105 = r103.f128632d;
        if (r105 == null) goto L16;
        r105.recycle();
    L16:
        r103.f128632d = null;
        Disposable r106 = r103.f128630b;
        if (r106 == null) goto L19;
        r106.dispose();
    L19:
        Disposable r107 = r103.f128631c;
        if (r107 == null) goto L22;
        r107.dispose();
    L22:
        r103.removeAllViews();
    L23:
        ComboEffectAnimationView r108 = this.f128688l;
        if (r108 == null) goto L29;
        Disposable r109 = r108.f128621b;
        if (r109 == null) goto L28;
        r109.dispose();
    L28:
        r108.removeAllViews();
    L29:
        ComboProgressAnimationView r110 = this.f128689m;
        if (r110 == null) goto L41;
        r110.f128640b = 0;
        r110.f128644f = false;
        r110.f128646h = false;
        r110.f128648j = false;
        HSImageView r111 = r110.f128661w;
        if (r111 == null) goto L34;
        r111.setScaleX(0.0f);
    L34:
        HSImageView r112 = r110.f128661w;
        if (r112 == null) goto L37;
        r112.setScaleY(0.0f);
    L37:
        r110.e();
        r110.d();
        r110.f();
        ((LinkedHashMap) r110.f128657s).clear();
        h2 r113 = r110.f128652n;
        if (r113 == null) goto L40;
        r104 = Long.valueOf(r113.getId());
    L40:
        r110.q(r104);
    L41:
        Disposable r114 = this.f128692p;
        if (r114 != null) goto L44;
    L46:
        Disposable r115 = this.f128691o;
        if (r115 != null) goto L49;
        return;
    L49:
        if (r115.isDisposed() == true) goto L53;
        this.f128691o.dispose();
        return;
    L53:
        return;
    L44:
        if (r114.isDisposed() == true) goto L46;
        this.f128692p.dispose();
        goto L46
    }

    public final boolean a() {
        if ((this.f128685i instanceof e) == false) goto L11;
        int r100 = this.f128686j;
        if (r100 > 0) goto L7;
    L9:
        return false;
    L7:
        if (r100 <= this.f128684h) goto L9;
        return true;
    L11:
        return true;
    }

    public final void b() {
        AnimatorSet r100 = this.f128680d;
        if (r100 != null) goto L5;
    L7:
        this.f128680d = null;
        View r101 = this.f128677a;
        if (r101 == null) goto L11;
        r101.animate().cancel();
        return;
    L11:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f128680d.removeAllListeners();
        this.f128680d.cancel();
        goto L7
    }

    public final void e() {
        TextView r100 = this.f128678b;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        View r101 = this.f128679c;
        if (r101 != null) goto L8;
        return;
    L8:
        if ((r101.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L12;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) this.f128679c.getLayoutParams();
        r102.topToTop = 0;
        r102.topToBottom = -1;
        r102.bottomToBottom = 0;
        r102.bottomToTop = -1;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = 0;
        this.f128679c.setLayoutParams(r102);
        return;
    }

    public int getComboCount() {
        return this.f128684h;
    }

    public LiveGiftComboViewNew(Context r100) {
        this(r100, null);
    }

    public final void f(Runnable r110) {
        b();
        this.f128680d = new AnimatorSet();
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.f128677a, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f128677a, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f128678b, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f128678b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f128679c, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f128679c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.95f, 1.0f});
        this.f128680d.playTogether(new Animator[]{r100, r101, r102, r103, r104, r105});
        this.f128680d.setDuration(200);
        this.f128680d.addListener(new b(r110));
        ViewPropertyAnimator r111 = this.f128677a.animate().rotation(0.0f).setDuration(150);
        PathInterpolator r106 = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        r111.setInterpolator(r106);
        this.f128680d.setInterpolator(r106);
        r111.start();
        this.f128680d.start();
    }

    public final void g(Runnable r100) {
        b();
        this.f128680d = new AnimatorSet();
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f128677a, "rotation", new float[]{0.0f, 360.0f});
        this.f128680d.playTogether(new Animator[]{r101});
        this.f128680d.setDuration(2000);
        this.f128680d.addListener(new a(this, r100));
        this.f128680d.start();
    }

    public final void i(final Runnable r100) {
        int r101 = (((int) (this.f128693q / 1000)) * 3) + 5;
        if (r101 <= 50) goto L10;
        Disposable r102 = this.f128692p;
        if (r102 != null) goto L7;
    L9:
        r101 = 50;
        goto L10
    L7:
        if (r102.isDisposed() == true) goto L9;
        this.f128692p.dispose();
    L10:
        int r103 = 1000 / r101;
        Disposable r104 = this.f128691o;
        if (r104 != null) goto L13;
    L15:
        j.a r105 = j.f66356a;
        this.f128691o = j.a(0, r103, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, r100), new n(), new o());
        return;
    L13:
        if (r104.isDisposed() == true) goto L15;
        this.f128691o.dispose();
        goto L15
    }

    public void setGiftId(long r100) {
        this.f128682f = r100;
        ComboIconAnimationView r101 = this.f128690n;
        if (r101 == null) goto L6;
        r101.setGiftId(r100);
        return;
    }

    public void setPanel(AbsPanel r100) {
        this.f128685i = r100;
        if (r100 == null) goto L7;
        T r101 = r100.f126620h;
        if ((r101 instanceof l2) == false) goto L7;
        this.f128686j = ((l2) r101).getCount();
    L7:
        if (r100 == null) goto L14;
        T r102 = r100.f126620h;
        if ((r102 instanceof h1) == false) goto L15;
        ComboProgressAnimationView r103 = this.f128689m;
        if (r103 == null) goto L16;
        r103.setGift((h1) r102);
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setPropId(long r100) {
        this.f128683g = r100;
    }

    public LiveGiftComboViewNew(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void h(final Runnable r100, boolean r101) {
        if (r101 == true) goto L5;
        this.f128693q = 0;
    L5:
        Disposable r102 = this.f128692p;
        if (r102 != null) goto L8;
    L10:
        j.a r103 = j.f66356a;
        this.f128692p = j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this, r100), new n(), new o());
        return;
    L8:
        if (r102.isDisposed() == true) goto L10;
        this.f128692p.dispose();
        goto L10
    }

    public LiveGiftComboViewNew(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f128681e = 0;
        this.f128682f = 0;
        this.f128683g = 0;
        this.f128684h = 0;
        this.f128686j = 0;
        View.inflate(r100, R.layout.ttlive_base_gift_combo_view_new, this);
        this.f128677a = findViewById(R.id.combo_bg);
        this.f128678b = (TextView) findViewById(R.id.combo_title_1);
        this.f128679c = findViewById(R.id.combo_title_2);
        this.f128687k = (RoundWaveAnimationView) findViewById(R.id.combo_round_wave);
        this.f128688l = (ComboEffectAnimationView) findViewById(R.id.combo_effect);
        this.f128689m = (ComboProgressAnimationView) findViewById(R.id.combo_progress);
        this.f128690n = (ComboIconAnimationView) findViewById(R.id.combo_icon_animation);
    }

    public final void c(final Runnable r100, boolean r101, boolean r102) {
        if (r102 == false) goto L9;
        long r103 = this.f128683g;
        if (r103 != (-1)) goto L7;
        h.L(this.f128682f, true);
        goto L9
    L7:
        h.L(r103, false);
    L9:
        if (this.f128681e != 0) goto L12;
        return;
    L12:
        if (a() == true) goto L15;
        r100.run();
        this.f128686j = 0;
        ToastUtil.a(R.string.ttlive_live_prop_count_error_title, 0);
        return;
    L15:
        this.f128681e = 1;
        f(new l(this, r100));
        if (r101 == false) goto L21;
        h(r100, false);
        i(r100);
        RoundWaveAnimationView r104 = this.f128687k;
        if (r104 == null) goto L22;
        r104.a();
        j.a r105 = j.f66356a;
        r104.f128697a = j.a(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(r104), t.f16853a, u.f16854a);
        return;
    L22:
        return;
    }
}
