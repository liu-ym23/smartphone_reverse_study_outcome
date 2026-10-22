package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.configmodel.f0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import py.k;
import qz1.i;
import qz1.j;
import qz1.l;
import qz1.m;
import qz1.n;
import qz1.o;
import qz1.p;
import qz1.q;
import qz1.r;

/* JADX INFO: loaded from: classes9.dex */
public class LiveSendGiftAnimationView extends FrameLayout {
    public ObjectAnimator A;
    public String B;
    public String C;
    public Bitmap D;
    public Spannable E;
    public HSImageView F;
    public HSImageView G;
    public final boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final f0 f126697J;
    public int K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f126698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<Float, Animator> f126699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<Float, Animator> f126700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f126701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f126702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f126703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f126704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f126705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f126706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f126707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f126708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f126709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f126710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f126711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AnimatorSet f126712o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public k f126713p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f126714q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AnimatedDrawable2 f126715r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f126716s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ObjectAnimator f126717t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ObjectAnimator f126718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ObjectAnimator f126719v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ObjectAnimator f126720w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ObjectAnimator f126721x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ObjectAnimator f126722y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ObjectAnimator f126723z;

    public class a extends GiftPanelIconLoadListener {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ LiveSendGiftAnimationView f126724h;

        @Override // com.bytedance.android.livesdk.gift.util.GiftPanelIconLoadListener
        public final Map<String, String> g() {
            HashMap r100 = new HashMap();
            r100.put("position", String.valueOf(this.f126724h.N));
            r100.put("tab_position", String.valueOf(this.f126724h.O));
            r100.put("icon_type", "send_item");
            return r100;
        }

        public a(LiveSendGiftAnimationView r100, GiftContext r101) {
            this.f126724h = r100;
            super(r101);
        }
    }

    public class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSendGiftAnimationView f126725a;

        public b(LiveSendGiftAnimationView r100) {
            this.f126725a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
            AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
            this.f126725a.f126715r = r104;
            com.bytedance.android.live.core.utils.fresco.c.c(r104);
            r104.setAnimationListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.a(this));
            this.f126725a.p();
            return;
        }
    }

    public class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSendGiftAnimationView f126726a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public c(LiveSendGiftAnimationView r100) {
            this.f126726a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f126726a.f126701d.setVisibility(8);
            LiveSendGiftAnimationView r101 = this.f126726a;
            r101.f126716s = false;
            r101.p();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            LiveSendGiftAnimationView r101 = this.f126726a;
            r101.f126716s = true;
            r101.f126701d.setVisibility(0);
            LiveSendGiftAnimationView.e(this.f126726a, true);
            this.f126726a.p();
        }
    }

    public class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSendGiftAnimationView f126727a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public d(LiveSendGiftAnimationView r100) {
            this.f126727a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f126727a.f126701d.setVisibility(8);
            LiveSendGiftAnimationView r101 = this.f126727a;
            r101.f126716s = false;
            r101.p();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            LiveSendGiftAnimationView r101 = this.f126727a;
            r101.f126716s = true;
            r101.f126701d.setVisibility(0);
            LiveSendGiftAnimationView.e(this.f126727a, true);
        }
    }

    private float getBreathLightAnimScale() {
        f0 r100 = this.f126697J;
        if (r100 != null) goto L5;
        return 1.0f;
    L5:
        if (r100.b() == true) goto L8;
        return 1.0f;
    L8:
        if (this.f126697J.c() > 0.0f) goto L14;
        return 1.14f;
    L14:
        return this.f126697J.c();
    }

    public final void l() {
        if (this.I == true) goto L5;
        return;
    L5:
        HSImageView r100 = this.f126703f;
        if (r100 != null) goto L8;
        return;
    L8:
        r100.setController(null);
        setGiftImageVisible(true);
        AnimatedDrawable2 r101 = this.f126715r;
        if (r101 == null) goto L12;
        r101.stop();
        this.f126715r = null;
        return;
    }

    public final void m() {
        this.f126717t = ObjectAnimator.ofFloat(this.f126702e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-this.f126698a, 0.0f});
        this.f126718u = ObjectAnimator.ofFloat(this.f126701d, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, this.f126698a});
        this.f126717t.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126718u.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126717t.addUpdateListener(new qz1.k(this));
        this.f126718u.addUpdateListener(new l(this));
        this.f126717t.setDuration(200);
        this.f126718u.setDuration(200);
        this.f126718u.addListener(new c(this));
    }

    public final void n() {
        this.f126719v = ObjectAnimator.ofFloat(this.f126702e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{this.f126698a, 0.0f});
        this.f126720w = ObjectAnimator.ofFloat(this.f126701d, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -this.f126698a});
        this.f126719v.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126720w.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126719v.addUpdateListener(new o(this));
        this.f126720w.addUpdateListener(new p(this));
        this.f126719v.setDuration(200);
        this.f126720w.setDuration(200);
        this.f126720w.addListener(new d(this));
    }

    public final void o() {
        Pair<Float, Animator> r100 = this.f126700c;
        if (r100 == null) goto L9;
        Object r101 = r100.second;
        if (r101 == null) goto L9;
        if (((Animator) r101).isStarted() == false) goto L9;
        return;
    L9:
        float r102 = getBreathLightAnimScale();
        Pair<Float, Animator> r103 = this.f126700c;
        if (r103 != null) goto L12;
    L17:
        PropertyValuesHolder r104 = PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, r102});
        PropertyValuesHolder r105 = PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, r102});
        ObjectAnimator r106 = ObjectAnimator.ofPropertyValuesHolder(this.f126702e, new PropertyValuesHolder[]{r104, r105});
        f0 r107 = this.f126697J;
        if (r107 != null) goto L20;
    L22:
        long r108 = 400;
    L23:
        r106.setDuration(r108);
        r106.setInterpolator(new LinearInterpolator());
        r106.setRepeatCount(-1);
        r106.setRepeatMode(2);
        this.f126700c = new Pair(Float.valueOf(r102), r106);
    L24:
        Object r109 = this.f126700c.second;
        if (r109 == null) goto L28;
        ((Animator) r109).start();
        return;
    L28:
        return;
    L20:
        if (r107.a() <= 0) goto L22;
        r108 = this.f126697J.a();
        goto L23
    L12:
        if (r103.second == null) goto L17;
        Object r110 = r103.first;
        if (r110 == null) goto L17;
        if (((Float) r110).floatValue() == r102) goto L24;
        goto L17
    }

    public final void p() {
        if (this.I == true) goto L6;
        return;
    L6:
        if (this.f126703f != null) goto L8;
        return;
    L8:
        if (this.f126715r != null) goto L10;
        return;
    L10:
        if (getVisibility() == 0) goto L13;
        return;
    L13:
        if (this.f126716s == true) goto L15;
        this.f126715r.start();
        return;
    L15:
        if (this.f126715r.isRunning() == false) goto L20;
        this.f126715r.stop();
        this.f126715r.jumpToFrame(0);
        return;
    }

    public final void r() {
        if (this.L == false) goto L9;
        this.f126706i.setText(R.string.ttlive_send_v2);
        if (this.M == false) goto L7;
        this.f126706i.setTextColor(getContext().getResources().getColor(R.color.white));
        this.f126708k.setBackgroundResource(R.drawable.ttlive_base_gift_selected_bottom_bg);
    L16:
        if (TextUtils.isEmpty(this.B) == true) goto L19;
        this.f126706i.setText(this.B);
    L19:
        if (TextUtils.isEmpty(this.C) == true) goto L22;
        this.f126706i.setText(this.C);
        return;
    L22:
        Spannable r100 = this.E;
        if (r100 == null) goto L26;
        this.f126706i.setText(r100);
        return;
    L26:
        return;
    L7:
        this.f126706i.setTextColor(getContext().getResources().getColor(R.color.ttlive_colorffffff_57));
        this.f126708k.setBackgroundResource(R.drawable.ttlive_base_gift_selected_bottom_lock_bg);
        goto L16
    L9:
        if (this.f126711n == false) goto L11;
        this.f126706i.setText(R.string.ttlive_send_single);
        this.f126706i.setTextColor(getContext().getResources().getColor(R.color.white));
        this.f126708k.setBackgroundResource(R.drawable.ttlive_base_gift_selected_bottom_lock_bg);
        goto L16
    L11:
        this.f126706i.setText(R.string.ttlive_send_v2);
        if (this.K != 1) goto L14;
        this.f126706i.setTextColor(getContext().getResources().getColor(R.color.ttlive_color733F23));
        this.f126708k.setBackgroundResource(R.drawable.ttlive_base_gift_rare_shop_selected_bottom_bg);
        goto L16
    L14:
        this.f126706i.setTextColor(getContext().getResources().getColor(R.color.white));
        this.f126708k.setBackgroundResource(R.drawable.ttlive_base_gift_selected_bottom_bg);
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        l();
        Pair<Float, Animator> r100 = this.f126700c;
        if (r100 == null) goto L9;
        Object r101 = r100.second;
        if (r101 == null) goto L9;
        if (((Animator) r101).isStarted() == false) goto L9;
        ((Animator) this.f126700c.second).cancel();
        ((Animator) this.f126700c.second).removeAllListeners();
        this.f126700c = null;
    L9:
        super.onDetachedFromWindow();
    }

    public HSImageView getGiftImage() {
        return this.f126702e;
    }

    public HSImageView getIconAnimationContainer() {
        return this.F;
    }

    public LiveSendGiftAnimationView(Context r100) {
        this(r100, null);
    }

    private void setGiftImageVisible(boolean r100) {
        HSImageView r101 = this.f126702e;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        if (this.I == false) goto L20;
        HSImageView r104 = this.f126703f;
        if (r104 == null) goto L21;
        int r105 = r104.getVisibility();
        if (r100 == false) goto L13;
        int r106 = 0;
    L14:
        if (r105 != r106) goto L22;
        HSImageView r107 = this.f126703f;
        if (r100 == false) goto L18;
        r102 = 8;
    L18:
        r107.setVisibility(r102);
        return;
    L22:
        return;
    L13:
        r106 = 8;
        goto L14
    L21:
        return;
    L20:
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public final void g(k r100) {
        if (this.I == true) goto L6;
        return;
    L6:
        if (this.f126703f != null) goto L9;
        return;
    L9:
        if (r100 != null) goto L11;
    L25:
        this.f126703f.setVisibility(8);
        this.f126703f.setController(null);
        this.f126714q = null;
        this.f126715r = null;
        return;
    L11:
        if (r100.isValid() == false) goto L25;
        k r101 = this.f126714q;
        if (r101 != null) goto L16;
    L21:
        b r102 = new b(this);
        AbstractDraweeController r103 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(ImageLoader.createImageRequests(r100, null, null)).setOldController(this.f126703f.getController()).setControllerListener(r102).setAutoPlayAnimations(false).build();
        this.f126703f.setController(r103);
        if (this.f126703f.getDrawable() == null) goto L27;
        this.f126703f.getDrawable().setVisible(true, false);
        return;
    L27:
        return;
    L16:
        if (r101.equalsOnlyUri(r100) == false) goto L21;
        if (this.f126703f.hasController() == false) goto L21;
        p();
    }

    public void setDiamondText(String r100) {
        TextView r101 = this.f126704g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public void setLockStatus(boolean r100) {
        this.L = r100;
        r();
    }

    public void setLockText(String r100) {
        this.C = r100;
    }

    public void setPanelBackground(Drawable r100) {
        if (r100 == null) goto L7;
        ViewGroup r101 = this.f126710m;
        if (r101 == null) goto L8;
        r101.setBackground(r100);
        return;
    L8:
        return;
    }

    public void setPanelTopBackground(Drawable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f126710m == null) goto L8;
        this.f126707j.setBackground(r100);
        return;
    }

    public void setRightTopSelectedLabelView(k r100) {
        HSImageView r101 = this.G;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r101.setVisibility(4);
        return;
    L7:
        r101.setVisibility(0);
        ImageLoader.bindImage(this.G, r100, s1.j(R.dimen.ttlive_gift_panel_right_top_label_size), s1.j(R.dimen.ttlive_gift_panel_right_top_label_size));
    }

    public void setSendText(Spannable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L8;
        this.E = r100;
        this.f126706i.setText(r100);
        return;
    }

    public void setUseCustomTextStyleWhenLocked(boolean r100) {
        this.M = r100;
        r();
    }

    public void setSendText(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.B = r100;
        this.f126706i.setText(r100);
        return;
    }

    public LiveSendGiftAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ void a(LiveSendGiftAnimationView r100, ValueAnimator r101) {
        float r102 = r100.getBreathLightAnimScale() * r100.f126701d.getWidth();
        float r103 = r100.getBreathLightAnimScale() * r100.f126701d.getHeight();
        float r104 = (r100.f126708k.getWidth() - r102) / 2.0f;
        float r105 = ((Float) r101.getAnimatedValue()).floatValue();
        float r106 = -r104;
        if (r105 <= r106) goto L5;
        float r107 = 0.0f;
    L6:
        r100.f126701d.setClipBounds(new Rect((int) r107, 0, (int) r102, (int) r103));
        return;
    L5:
        r107 = r106 - r105;
        goto L6
    }

    public static /* synthetic */ void b(LiveSendGiftAnimationView r100, ValueAnimator r101) {
        float r102 = r100.getBreathLightAnimScale() * r100.f126702e.getWidth();
        float r103 = r100.getBreathLightAnimScale() * r100.f126702e.getHeight();
        float r104 = ((r100.f126708k.getWidth() - r102) / 2.0f) + r102;
        float r105 = ((Float) r101.getAnimatedValue()).floatValue();
        if (r105 >= (-r104)) goto L5;
        float r106 = r102;
    L6:
        r100.f126702e.setClipBounds(new Rect((int) r106, 0, (int) r102, (int) r103));
        return;
    L5:
        r106 = r102 - (r105 + r104);
        goto L6
    }

    public static /* synthetic */ void c(LiveSendGiftAnimationView r100, ValueAnimator r101) {
        float r102 = r100.getBreathLightAnimScale() * r100.f126702e.getWidth();
        float r103 = r100.getBreathLightAnimScale() * r100.f126702e.getHeight();
        float r104 = ((r100.f126708k.getWidth() - r102) / 2.0f) + r102;
        float r105 = ((Float) r101.getAnimatedValue()).floatValue();
        if (r105 <= r104) goto L5;
        float r106 = 0.0f;
    L6:
        r100.f126702e.setClipBounds(new Rect(0, 0, (int) r106, (int) r103));
        return;
    L5:
        r106 = r104 - r105;
        goto L6
    }

    public static /* synthetic */ void d(LiveSendGiftAnimationView r100, ValueAnimator r101) {
        float r102 = r100.getBreathLightAnimScale() * r100.f126701d.getWidth();
        float r103 = r100.getBreathLightAnimScale() * r100.f126701d.getHeight();
        float r104 = (r100.f126708k.getWidth() - r102) / 2.0f;
        float r105 = ((Float) r101.getAnimatedValue()).floatValue();
        if (r105 < r104) goto L6;
        r102 = r102 - (r105 - r104);
    L6:
        r100.f126701d.setClipBounds(new Rect(0, 0, (int) r102, (int) r103));
    }

    public static /* synthetic */ void e(LiveSendGiftAnimationView r100, boolean r101) {
        r100.setGiftImageVisible(r101);
    }

    public static boolean k(k r100, k r101) {
        if (((Boolean) nz1.a.f521351n0.getValue(null, nz1.a.f521324a[64])).booleanValue() == false) goto L11;
        if (r100 == null) goto L11;
        if (TextUtils.isEmpty(r100.getUri()) == true) goto L11;
        if (r100.equalsOnlyUri(r101) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public final void i(boolean r110, String r111) {
        if (nz1.a.g() == true) goto L6;
        return;
    L6:
        if (r110 == false) goto L8;
        this.f126721x = ObjectAnimator.ofFloat(this.f126704g, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-this.f126698a, 0.0f});
        this.f126722y = ObjectAnimator.ofFloat(this.f126705h, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, this.f126698a});
        this.f126721x.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126722y.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126721x.addUpdateListener(new m(this));
        this.f126722y.addUpdateListener(new n(this));
        this.f126721x.setDuration(200);
        this.f126722y.setDuration(200);
        this.f126722y.addListener(new q(this));
    L9:
        this.f126705h.setText(this.f126704g.getText());
        this.f126704g.setText(r111);
        if (r110 == false) goto L12;
        this.f126721x.start();
        this.f126722y.start();
        return;
    L12:
        this.f126723z.start();
        this.A.start();
        return;
    L8:
        this.f126723z = ObjectAnimator.ofFloat(this.f126704g, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{this.f126698a, 0.0f});
        this.A = ObjectAnimator.ofFloat(this.f126705h, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -this.f126698a});
        this.f126723z.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.A.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        this.f126723z.addUpdateListener(new i(this));
        this.A.addUpdateListener(new j(this));
        this.f126723z.setDuration(200);
        this.A.setDuration(200);
        this.A.addListener(new r(this));
        goto L9
    }

    public LiveSendGiftAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f126698a = UIUtils.dip2Px(getContext(), 120.0f);
        this.f126711n = false;
        this.f126716s = false;
        this.B = "";
        this.C = "";
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        ReadOnlyProperty r103 = nz1.a.f521341i0;
        KProperty<?>[] r104 = nz1.a.f521324a;
        boolean r105 = ((Boolean) r103.getValue(null, r104[59])).booleanValue();
        this.H = r105;
        this.I = ((Boolean) nz1.a.f521353o0.getValue(null, r104[65])).booleanValue();
        f0 r106 = (f0) nz1.a.f521355p0.getValue(null, r104[66]);
        this.f126697J = r106;
        this.K = 0;
        this.L = false;
        this.M = false;
        if (com.bytedance.android.livesdk.gift.util.b.b() != null) goto L5;
    L7:
        GiftPanelViewPreloadService.f128162l.getClass();
        View r107 = GiftPanelViewPreloadService.a.a(R.layout.ttlive_base_send_gift_animation_view_v2);
        if (r107 == null) goto L10;
        addView(r107);
    L11:
        this.f126702e = (HSImageView) findViewById(R.id.gift_image);
        if (r106 != null) goto L14;
    L30:
        q(this.f126702e, (int) UIUtils.dip2Px(getContext(), 64.0f), (int) UIUtils.dip2Px(getContext(), 64.0f));
    L31:
        HSImageView r108 = (HSImageView) findViewById(R.id.new_gift_image);
        this.f126701d = r108;
        q(r108, (int) UIUtils.dip2Px(getContext(), 64.0f), (int) UIUtils.dip2Px(getContext(), 64.0f));
        this.f126704g = (TextView) findViewById(R.id.diamond);
        this.f126705h = (TextView) findViewById(R.id.new_diamond);
        this.f126706i = (TextView) findViewById(R.id.send);
        this.f126707j = findViewById(R.id.top_container);
        this.f126709l = findViewById(R.id.cover_bg);
        this.f126708k = findViewById(R.id.bottom_container);
        this.f126710m = (ViewGroup) findViewById(R.id.root_view);
        this.f126701d.setVisibility(8);
        this.F = (HSImageView) findViewById(R.id.icon_animation_container);
        this.G = (HSImageView) findViewById(R.id.right_top_label_image);
        HSImageView r109 = (HSImageView) findViewById(R.id.dynamic_gift_image);
        this.f126703f = r109;
        q(r109, (int) UIUtils.dip2Px(getContext(), 88.0f), (int) UIUtils.dip2Px(getContext(), 80.0f));
        return;
    L14:
        if (r106.b() == false) goto L30;
        if (r105 == false) goto L18;
        int r110 = 56;
    L19:
        float r111 = r110;
        HSImageView r112 = this.f126702e;
        int r113 = (int) UIUtils.dip2Px(getContext(), r111);
        int r114 = (int) UIUtils.dip2Px(getContext(), r111);
        if (r112 == null) goto L24;
        ViewGroup.LayoutParams r115 = r112.getLayoutParams();
        if (r115 == null) goto L24;
        r115.width = r113;
        r115.height = r114;
        r112.setLayoutParams(r115);
    L24:
        if (r105 == false) goto L26;
        int r116 = 5;
    L27:
        float r117 = r116;
        if ((this.f126702e.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L31;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f126702e.getLayoutParams())).topMargin = (int) UIUtils.dip2Px(getContext(), r117);
        goto L31
    L26:
        r116 = 7;
        goto L27
    L18:
        r110 = 52;
        goto L19
    L10:
        View.inflate(r100, R.layout.ttlive_base_send_gift_animation_view_v2, this);
        goto L11
    L5:
        if (com.bytedance.android.livesdk.gift.util.b.b().isVS().getValue().booleanValue() == false) goto L7;
        View.inflate(r100, R.layout.ttlive_vs_base_send_gift_animation_view_v2, this);
        goto L11
    }

    public final void q(HSImageView r100, int r101, int r102) {
        if (this.H == false) goto L9;
        if (r100 == null) goto L10;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L11;
        r103.width = r101;
        r103.height = r102;
        r100.setLayoutParams(r103);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void j(k r100, k r101, boolean r102, String r103) {
        i(r102, r103);
        if (r102 == false) goto L5;
        m();
    L6:
        k r104 = this.f126713p;
        if (r104 != null) goto L11;
        Bitmap r105 = this.D;
        if (r105 == null) goto L11;
        this.f126701d.setImageBitmap(r105);
    L13:
        if (k(this.f126713p, r100) == false) goto L15;
        ImageLoader.bindImage(this.f126702e, r100, s1.j(R.dimen.ttlive_gift_panel_icon_size), s1.j(R.dimen.ttlive_gift_panel_icon_size));
    L15:
        g(r101);
        this.f126701d.setVisibility(0);
        setGiftImageVisible(true);
        if (r102 == false) goto L18;
        this.f126717t.start();
        this.f126718u.start();
    L19:
        this.f126714q = r101;
        this.f126713p = r100;
        this.D = null;
        return;
    L18:
        this.f126719v.start();
        this.f126720w.start();
    L11:
        ImageLoader.bindImage(this.f126701d, r104, s1.j(R.dimen.ttlive_gift_panel_icon_size), s1.j(R.dimen.ttlive_gift_panel_icon_size));
        goto L13
    L5:
        n();
        goto L6
    }

    public final void h(k r100, Bitmap r101, boolean r102, boolean r103, String r104) {
        if (r103 == false) goto L21;
        i(r102, r104);
        if (r102 == false) goto L6;
        m();
    L7:
        Bitmap r105 = this.D;
        if (r105 != null) goto L13;
        HSImageView r106 = this.f126701d;
        k r107 = this.f126713p;
        if (r107 != null) goto L12;
        r107 = r100;
    L12:
        ImageLoader.bindImage(r106, r107);
    L14:
        if (r101 != null) goto L16;
        ImageLoader.bindImage(this.f126702e, r100);
    L17:
        this.f126701d.setVisibility(0);
        setGiftImageVisible(true);
        if (r102 == false) goto L20;
        this.f126717t.start();
        this.f126718u.start();
    L24:
        this.D = r101;
        return;
    L20:
        this.f126719v.start();
        this.f126720w.start();
        goto L24
    L16:
        this.f126702e.setImageBitmap(r101);
        goto L17
    L13:
        this.f126701d.setImageBitmap(r105);
        goto L14
    L6:
        n();
        goto L7
    L21:
        if (r101 != null) goto L23;
        ImageLoader.bindImage(this.f126702e, r100);
        goto L24
    L23:
        this.f126702e.setImageBitmap(r101);
        goto L24
    }

    public final void f(k r110, k r111, String r112, int r210, String r211, boolean r212, int r213) {
        Bitmap r100 = this.D;
        if (r100 != null) goto L7;
        g(r111);
        if (k(this.f126714q, r110) == false) goto L8;
        GiftImageLoader r101 = GiftImageLoader.f132324k;
        HSImageView r102 = this.f126702e;
        int r103 = ((Number) GiftImageLoader.f132321h.getValue()).intValue();
        int r104 = e.b(R.dimen.ttlive_gift_panel_icon_size);
        int r105 = e.b(R.dimen.ttlive_gift_panel_icon_size);
        a r106 = new a(this, com.bytedance.android.livesdk.gift.util.b.b());
        String r113 = this.O + "-" + this.N;
        r101.getClass();
        GiftImageLoader.a(r102, r110, null, r103, r104, r105, null, r106, false, true, "live_gift_panel_send_icon", r113);
    L8:
        this.f126713p = r110;
        this.f126714q = r111;
        this.f126704g.setText(r112);
        this.f126704g.setTextColor(r210);
        this.f126706i.setText(r211);
        this.L = r212;
        this.K = r213;
        r();
        return;
    L7:
        this.f126702e.setImageBitmap(r100);
        goto L8
    }
}
