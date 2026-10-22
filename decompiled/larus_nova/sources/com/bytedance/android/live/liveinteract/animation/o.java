package com.bytedance.android.live.liveinteract.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class o extends com.bytedance.android.live.liveinteract.animation.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.animation.e f71087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f71088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f71089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f71090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f71091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f71092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.j f71093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Animator f71094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f71095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InteractAnimationController.c f71096m;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f71097a;

        public b(o r100) {
            this.f71097a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71097a.f71089f;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71097a.f71089f);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71097a.f71089f;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L8
            l0.c(r103);     // Catch: Throwable -> L8
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f71098a;

        public c(o r100) {
            this.f71098a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71098a.f71088e;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71098a.f71088e);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71098a.f71088e;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L8
            l0.c(r103);     // Catch: Throwable -> L8
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

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f71099a;

        public d(o r100) {
            this.f71099a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71099a.f71090g;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71099a.f71090g);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71099a.f71090g;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L8
            l0.c(r103);     // Catch: Throwable -> L8
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

    public static final class e extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f71100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.f f71101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EPointF f71102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EPointF f71103d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ EPointF f71104e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f71105f;

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
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.f71100a.f70971b, "path emoji load failed " + r101);
            o r102 = this.f71100a;
            r102.h(r102);
            r102.r(false);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r110, Animatable r111) {
            ImageInfo r112 = (ImageInfo) r110;
            Intrinsics.checkNotNullParameter(r100, "id");
            if ((r111 instanceof AnimatedDrawable2) == false) goto L5;
            AnimatedDrawable2 r113 = (AnimatedDrawable2) r111;
            o.m(this.f71100a, r113, this.f71101b.getDuration(), this.f71102c, this.f71103d, this.f71104e, this.f71105f);
            r113.setAnimationListener(new w());
            return;
        L5:
            o.m(this.f71100a, null, this.f71101b.getDuration(), this.f71102c, this.f71103d, this.f71104e, this.f71105f);
        }

        public e(o r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101, EPointF r102, EPointF r103, EPointF r104, int r105) {
            this.f71100a = r100;
            this.f71101b = r101;
            this.f71102c = r102;
            this.f71103d = r103;
            this.f71104e = r104;
            this.f71105f = r105;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final long b() {
        return -1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void c() {
        this.f71087d = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        r(false);
        this.f70970a.clear();
        HSImageView r100 = this.f71089f;
        if (r100 == null) goto L5;
        r100.postDelayed(new b(this), 100);
    L5:
        HSImageView r101 = this.f71088e;
        if (r101 == null) goto L8;
        r101.postDelayed(new c(this), 100);
    L8:
        HSImageView r102 = this.f71090g;
        if (r102 == null) goto L12;
        r102.postDelayed(new d(this), 100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, com.bytedance.android.live.liveinteract.utils.EPointF] */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.bytedance.android.live.liveinteract.utils.EPointF] */
    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        this.f71095l.add(Observable.timer(10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this)));
        com.bytedance.android.live.liveinteract.animation.e r100 = this.f71087d;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f71093j != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r100);
        int r101 = r100.zl(this.f71091h);
        com.bytedance.android.live.liveinteract.animation.e r102 = this.f71087d;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.zl(this.f71092i);
        if (r101 == r103) goto L116;
        if (r101 < 0) goto L116;
        if (r103 < 0) goto L116;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r104 = this.f71093j;
        if (r104 == null) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r105 = r104.getInteractEmoji();
        if (r105 == null) goto L21;
        if (r105.isValid() == true) goto L21;
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.f70971b, "invalid emoji since data invalid");
        return;
    L21:
        com.bytedance.android.live.liveinteract.animation.e r106 = this.f71087d;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNullParameter(r106, "seatInfoProvider");
        if (l0.b() == false) goto L24;
        this.f71089f = l0.a();
    L25:
        r106.vj().addView(this.f71089f);
        if (l0.b() == false) goto L28;
        this.f71088e = l0.a();
    L29:
        r106.vj().addView(this.f71088e);
        if (l0.b() == false) goto L32;
        this.f71090g = l0.a();
    L33:
        r106.vj().addView(this.f71090g);
        com.bytedance.android.live.liveinteract.animation.e r107 = this.f71087d;
        Intrinsics.checkNotNull(r107);
        if (r107.wc(this.f71091h) == false) goto L36;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(true, r101);
        com.bytedance.android.live.liveinteract.animation.e r108 = this.f71087d;
        Intrinsics.checkNotNull(r108);
        r108.Bn(this.f71091h);
    L36:
        com.bytedance.android.live.liveinteract.animation.e r109 = this.f71087d;
        Intrinsics.checkNotNull(r109);
        if (r109.wc(this.f71092i) == false) goto L39;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(false, r103);
        com.bytedance.android.live.liveinteract.animation.e r110 = this.f71087d;
        Intrinsics.checkNotNull(r110);
        r110.Bn(this.f71092i);
    L39:
        String r111 = "InteractAnimation.InteractEmojiAnimationTask" + this.f70971b;
        StringBuilder r112 = new StringBuilder("play ");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r113 = this.f71093j;
        Intrinsics.checkNotNull(r113);
        r112.append(r113.getEmojiName());
        r112.append(" from{");
        r112.append(this.f71091h);
        r112.append(", ");
        r112.append(r101);
        r112.append("} to{");
        r112.append(this.f71092i);
        r112.append(", ");
        r112.append(r103);
        r112.append('}');
        ALogger.i(r111, r112.toString());
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r114 = this.f71093j;
        Intrinsics.checkNotNull(r114);
        String r115 = this.f71091h;
        String r116 = this.f71092i;
        if (this.f71087d != null) goto L43;
        return;
    L43:
        if (this.f71089f == null) goto L122;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r117 = r114.interactEmoji();
        if (r117 == null) goto L123;
        com.bytedance.android.live.liveinteract.animation.e r118 = this.f71087d;
        Intrinsics.checkNotNull(r118);
        if (r118.Pf(r103) == false) goto L124;
        Ref.ObjectRef r119 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r120 = this.f71087d;
        Intrinsics.checkNotNull(r120);
        r119.element = r120.C7(r101, r103);
        Ref.ObjectRef r121 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r122 = this.f71087d;
        Intrinsics.checkNotNull(r122);
        r121.element = r122.Kl(r101, r103);
        com.bytedance.android.live.liveinteract.animation.e r123 = this.f71087d;
        Intrinsics.checkNotNull(r123);
        EPointF r124 = r123.Se(r101, r103, (EPointF) r119.element, (EPointF) r121.element);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.b() == true) goto L54;
    L56:
        boolean r125 = false;
    L57:
        System.currentTimeMillis();
        this.f71096m = new InteractAnimationController.c(r114, r115, r116, r125);
        int[] r126 = new int[2];
        com.bytedance.android.live.liveinteract.animation.e r127 = this.f71087d;
        Intrinsics.checkNotNull(r127);
        r127.vj().getLocationOnScreen(r126);
        EPointF r128 = (EPointF) r119.element;
        Intrinsics.checkNotNull(r128);
        EPointF r129 = (EPointF) r119.element;
        ((PointF) r128).x = ((PointF) r129).x - r126[0];
        Intrinsics.checkNotNull(r129);
        ((PointF) r129).y = ((PointF) ((EPointF) r119.element)).y - r126[1];
        EPointF r130 = (EPointF) r121.element;
        Intrinsics.checkNotNull(r130);
        EPointF r131 = (EPointF) r121.element;
        ((PointF) r130).x = ((PointF) r131).x - r126[0];
        Intrinsics.checkNotNull(r131);
        ((PointF) r131).y = ((PointF) ((EPointF) r121.element)).y - r126[1];
        int r132 = r114.getEmojiCategory();
        HSImageView r133 = this.f71089f;
        if (r133 != null) goto L61;
    L64:
        int r134 = r114.getEmojiCategory();
        HSImageView r135 = this.f71090g;
        if (r135 != null) goto L68;
    L73:
        HSImageView r136 = this.f71089f;
        if (r136 == null) goto L76;
        o(r136, (EPointF) r119.element);
    L76:
        HSImageView r137 = this.f71090g;
        if (r137 == null) goto L80;
        o(r137, (EPointF) r121.element);
    L80:
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.b() == false) goto L85;
        p(r114.getEmojiCategory());
        EPointF r138 = (EPointF) r119.element;
        EPointF r139 = (EPointF) r121.element;
        T r140 = r138;
        if (r114.getEmojiCategory() != 4) goto L84;
        float r141 = ((PointF) r138).x;
        com.bytedance.android.live.liveinteract.animation.e r142 = this.f71087d;
        Intrinsics.checkNotNull(r142);
        float r143 = r141 - (r142.ma(r101, 4) * 0.0625f);
        float r144 = ((PointF) r138).y;
        com.bytedance.android.live.liveinteract.animation.e r145 = this.f71087d;
        Intrinsics.checkNotNull(r145);
        r140 = new EPointF(r143, r144 - (r145.ma(r101, 4) * 0.4625f));
    L84:
        r119.element = r140;
    L85:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r146 = r117.getSenderEmoji();
        if (r146 != null) goto L88;
    L96:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r147 = r117.getPathEmoji();
        Intrinsics.checkNotNull(r147);
        q(r147, (EPointF) r119.element, (EPointF) r121.element, r124, r114.getEmojiCategory());
    L97:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r148 = this.f71093j;
        Intrinsics.checkNotNull(r148);
        String r149 = r148.getEmojiSoundUrl();
        if (r149 == null) goto L110;
        com.bytedance.android.live.liveinteract.animation.e r150 = this.f71087d;
        if ((r150 instanceof InteractAnimationController.d) == true) goto L102;
        r150 = null;
    L102:
        InteractAnimationController.d r151 = (InteractAnimationController.d) r150;
        if (r151 == null) goto L107;
        EmojiSoundManager r152 = InteractAnimationController.d.a.c(r151);
        if (r152 == null) goto L107;
        r152.e(this.f70971b, r149, getType());
    L107:
        com.bytedance.android.live.liveinteract.animation.e r153 = this.f71087d;
        if (r153 == null) goto L110;
        r153.Mb(this.f70971b, r149, getType());
    L110:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r154 = r117.getReceiverEmoji();
        if (r154 != null) goto L113;
        return;
    L113:
        if (r154.isValid() != true) goto L120;
        int r155 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.f80165a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r156 = r117.getReceiverEmoji();
        Intrinsics.checkNotNull(r156);
        py.k r157 = r156.dynamicImage();
        Intrinsics.checkNotNull(r157);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r157);
        return;
    L120:
        return;
    L88:
        if (r146.isValid() != true) goto L96;
        com.bytedance.android.live.liveinteract.animation.e r158 = this.f71087d;
        Intrinsics.checkNotNull(r158);
        if (r158.Ed(r101) == false) goto L96;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r159 = r117.getSenderEmoji();
        Intrinsics.checkNotNull(r159);
        ImageRequest[] r160 = a1.b(r159.dynamicImage(), -1);
        Iterator<g> r161 = this.f70970a.iterator();
    L93:
        if (r161.hasNext() == false) goto L95;
        r161.next().c();
        goto L93
    L95:
        HSImageView r162 = this.f71089f;
        Intrinsics.checkNotNull(r162);
        PipelineDraweeControllerBuilder r163 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r160);
        HSImageView r164 = this.f71089f;
        Intrinsics.checkNotNull(r164);
        r162.setController(r163.setOldController(r164.getController()).setAutoPlayAnimations(true).setControllerListener(new v(this, r117, r119, r121, r124, r114)).build());
        HSImageView r165 = this.f71089f;
        Intrinsics.checkNotNull(r165);
        UtilityKotlinExtentionsKt.w(r165);
        int r166 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.f80165a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r167 = r117.getPathEmoji();
        Intrinsics.checkNotNull(r167);
        py.k r168 = r167.dynamicImage();
        Intrinsics.checkNotNull(r168);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r168);
        goto L97
    L68:
        if (this.f71087d == null) goto L73;
        Intrinsics.checkNotNull(r135);
        ViewGroup.LayoutParams r169 = r135.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r170 = this.f71087d;
        Intrinsics.checkNotNull(r170);
        r169.width = r170.ma(r103, r134);
        com.bytedance.android.live.liveinteract.animation.e r171 = this.f71087d;
        Intrinsics.checkNotNull(r171);
        r169.height = r171.ma(r103, r134);
        HSImageView r172 = this.f71090g;
        if (r172 == null) goto L73;
        r172.setLayoutParams(r169);
        goto L73
    L61:
        if (this.f71087d == null) goto L64;
        Intrinsics.checkNotNull(r133);
        ViewGroup.LayoutParams r173 = r133.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r174 = this.f71087d;
        Intrinsics.checkNotNull(r174);
        r173.width = r174.ma(r101, r132);
        com.bytedance.android.live.liveinteract.animation.e r175 = this.f71087d;
        Intrinsics.checkNotNull(r175);
        r173.height = r175.ma(r101, r132);
        HSImageView r176 = this.f71089f;
        Intrinsics.checkNotNull(r176);
        r176.setLayoutParams(r173);
        goto L64
    L54:
        if (r114.getEmojiCategory() != 4) goto L56;
        r125 = true;
        goto L57
    L124:
        return;
    L123:
        return;
    L122:
        return;
    L32:
        this.f71090g = new HSImageView(r106.vj().getContext());
        goto L33
    L28:
        this.f71088e = new HSImageView(r106.vj().getContext());
        goto L29
    L24:
        this.f71089f = new HSImageView(r106.vj().getContext());
    L116:
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + this.f70971b, "invalid emoji since from=" + r101 + " to=" + r103);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return this.f71092i;
    }

    public static final void n(o r100) {
        if (r100.f71087d == null) goto L32;
        InteractAnimationController.c r101 = r100.f71096m;
        if (r101 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r102 = r101.f70942a;
        if (r102 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r103 = r102.interactEmoji();
        if (r103 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r104 = r103.getReceiverEmoji();
    L13:
        com.bytedance.android.live.liveinteract.animation.e r105 = r100.f71087d;
        Intrinsics.checkNotNull(r105);
        InteractAnimationController.c r106 = r100.f71096m;
        if (r106 == null) goto L17;
        String r107 = r106.f70943b;
        if (r107 == null) goto L17;
    L18:
        int r108 = r105.zl(r107);
        if (r104 != null) goto L21;
    L28:
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + r100.f70971b, "won't play receiver animation for " + r104 + " invalid");
        r100.h(r100);
        r100.r(true);
        return;
    L21:
        if (r104.isValid() != true) goto L28;
        if (r108 <= 0) goto L27;
        com.bytedance.android.live.liveinteract.animation.e r109 = r100.f71087d;
        Intrinsics.checkNotNull(r109);
        if (r109.Ed(r108) == true) goto L27;
        ALogger.e("InteractAnimation.InteractEmojiAnimationTask" + r100.f70971b, "won't play receiver animation for seat " + r108 + " invalid");
        r100.h(r100);
        r100.r(true);
        return;
    L27:
        r100.l();
        ImageRequest[] r110 = a1.b(r104.dynamicImage(), -1);
        HSImageView r111 = r100.f71090g;
        Intrinsics.checkNotNull(r111);
        UtilityKotlinExtentionsKt.w(r111);
        HSImageView r112 = r100.f71090g;
        Intrinsics.checkNotNull(r112);
        PipelineDraweeControllerBuilder r113 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r110);
        HSImageView r114 = r100.f71090g;
        Intrinsics.checkNotNull(r114);
        r112.setController(r113.setOldController(r114.getController()).setAutoPlayAnimations(true).setControllerListener(new s(r100)).build());
        return;
    L17:
        r107 = "";
    L12:
        r104 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final boolean e(InteractAnimationController r100) {
        Intrinsics.checkNotNullParameter(r100, "interactAnimationController");
        if (r100.k(2) == false) goto L6;
        return false;
    L6:
        if (r100.k(1) == false) goto L9;
        return false;
    L9:
        if (r100.k(3) == false) goto L11;
        return false;
    L11:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f71316f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r101 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C1150a.a();
        if (r101 != null) goto L14;
    L16:
        return true;
    L14:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r101) != true) goto L16;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void g(com.bytedance.android.live.liveinteract.animation.e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f71087d = r100;
    }

    public final void p(int r100) {
        HSImageView r101 = this.f71088e;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f71087d != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r103 = this.f71087d;
        Intrinsics.checkNotNull(r103);
        r102.width = r103.qq(r100);
        com.bytedance.android.live.liveinteract.animation.e r104 = this.f71087d;
        Intrinsics.checkNotNull(r104);
        r102.height = r104.qq(r100);
        HSImageView r105 = this.f71088e;
        Intrinsics.checkNotNull(r105);
        r105.setLayoutParams(r102);
    }

    public final void r(boolean r100) {
        InteractAnimationController.c r101 = this.f71096m;
        if (r101 == null) goto L11;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r102 = r101.f70942a;
        if (r102 == null) goto L11;
        String r103 = r102.getEmojiSoundUrl();
        if (r103 == null) goto L11;
        if (r100 == false) goto L11;
        xs2.b.a().post(new wj0.f(this.f70971b, r103, r100));
    L11:
        if (this.f71096m != null) goto L13;
        return;
    L13:
        this.f71096m = null;
        HSImageView r104 = this.f71088e;
        if (r104 == null) goto L16;
        r104.setController(null);
    L16:
        HSImageView r105 = this.f71089f;
        if (r105 == null) goto L19;
        r105.setController(null);
    L19:
        HSImageView r106 = this.f71090g;
        if (r106 == null) goto L22;
        r106.setController(null);
    L22:
        this.f71095l.dispose();
        p(0);
        HSImageView r107 = this.f71088e;
        if (r107 == null) goto L25;
        UtilityKotlinExtentionsKt.u(r107);
    L25:
        HSImageView r108 = this.f71089f;
        if (r108 == null) goto L28;
        UtilityKotlinExtentionsKt.u(r108);
    L28:
        HSImageView r109 = this.f71090g;
        if (r109 == null) goto L31;
        UtilityKotlinExtentionsKt.u(r109);
    L31:
        Animator r110 = this.f71094k;
        if (r110 != null) goto L34;
        return;
    L34:
        if (r110.isRunning() != true) goto L40;
        Animator r111 = this.f71094k;
        if (r111 == null) goto L41;
        r111.cancel();
        return;
    L41:
        return;
    }

    public o(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276354d);
        super(r100, r101);
        this.f71091h = "";
        this.f71092i = "";
        this.f71095l = new CompositeDisposable();
    }

    public final void o(HSImageView r100, EPointF r101) {
        r100.setX(((PointF) r101).x - (r100.getLayoutParams().width / 2));
        r100.setY(((PointF) r101).y - (r100.getLayoutParams().height / 2));
    }

    public final void q(com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r110, EPointF r111, EPointF r112, EPointF r113, int r114) {
        if (this.f71088e != null) goto L5;
        return;
    L5:
        ImageRequest[] r100 = a1.b(r110.dynamicImage(), -1);
        j();
        com.bytedance.android.live.liveinteract.animation.e r101 = this.f71087d;
        if (r101 != null) goto L8;
    L10:
        HSImageView r102 = this.f71088e;
        Intrinsics.checkNotNull(r102);
        UtilityKotlinExtentionsKt.w(r102);
    L11:
        HSImageView r103 = this.f71088e;
        Intrinsics.checkNotNull(r103);
        PipelineDraweeControllerBuilder r104 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r100);
        HSImageView r105 = this.f71088e;
        Intrinsics.checkNotNull(r105);
        r103.setController(r104.setOldController(r105.getController()).setAutoPlayAnimations(false).setControllerListener(new e(this, r110, r111, r112, r113, r114)).build());
        return;
    L8:
        if (r101.W7(r111, r112) == true) goto L10;
        HSImageView r106 = this.f71088e;
        Intrinsics.checkNotNull(r106);
        UtilityKotlinExtentionsKt.u(r106);
        goto L11
    }

    public static final void m(o r100, AnimatedDrawable2 r101, long r102, EPointF r110, EPointF r111, EPointF r112, int r113) {
        if (r100.f71087d != null) goto L6;
        return;
    L6:
        if (r100.f71088e == null) goto L15;
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        com.bytedance.android.live.liveinteract.animation.e r104 = r100.f71087d;
        Intrinsics.checkNotNull(r104);
        r103.element = r104.si();
        ValueAnimator r114 = ValueAnimator.ofObject(new com.bytedance.android.live.liveinteract.utils.f(r112), new Object[]{r110, r111});
        if (r102 > 0) goto L12;
        r102 = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    L12:
        r114.setDuration(r102);
        r114.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r114.addUpdateListener(new p(r100, r113, r110, r111, r103));
        r114.addListener(new q(r100, r113, r110, r111, r101));
        Unit r105 = Unit.INSTANCE;
        r100.f71094k = r114;
        r114.start();
        return;
    }
}
