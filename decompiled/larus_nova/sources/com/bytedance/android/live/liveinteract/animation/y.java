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
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
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
public final class y extends com.bytedance.android.live.liveinteract.animation.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.animation.e f71384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f71385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f71386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f71387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f71388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f71389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f71390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f71391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.j f71392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Animator f71393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f71394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public InteractAnimationController.c f71395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f71396p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f71397a;

        public b(y r100) {
            this.f71397a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71397a.f71386f;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71397a.f71386f);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71397a.f71386f;     // Catch: Throwable -> L8
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
        public final /* synthetic */ y f71398a;

        public c(y r100) {
            this.f71398a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71398a.f71385e;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71398a.f71385e);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71398a.f71385e;     // Catch: Throwable -> L8
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
        public final /* synthetic */ y f71399a;

        public d(y r100) {
            this.f71399a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71399a.f71387g;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71399a.f71387g);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71399a.f71387g;     // Catch: Throwable -> L8
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

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f71400a;

        public e(y r100) {
            this.f71400a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71400a.f71388h;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71400a.f71388h);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71400a.f71388h;     // Catch: Throwable -> L8
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

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f71401a;

        public f(y r100) {
            this.f71401a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HSImageView r100 = this.f71401a.f71389i;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            ViewGroup r101 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.removeView(this.f71401a.f71389i);     // Catch: Throwable -> L8
            List<HSImageView> r102 = l0.f71075a;     // Catch: Throwable -> L8
            HSImageView r103 = this.f71401a.f71389i;     // Catch: Throwable -> L8
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

    public static final class g extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f71402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f71403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f71404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EPointF f71405d;

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
            ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask" + this.f71402a.f70971b, "sender emoji load failed " + r101);
            y r102 = this.f71402a;
            r102.h(r102);
            r102.s(false);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "id");
            if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
            ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask" + this.f71402a.f70971b, "sender emoji load success");
            ((AnimatedDrawable2) r102).setAnimationListener(new i0(this));
            return;
        }

        public g(y r100, Ref.ObjectRef r101, Ref.ObjectRef r102, EPointF r103) {
            this.f71402a = r100;
            this.f71403b = r101;
            this.f71404c = r102;
            this.f71405d = r103;
        }
    }

    public static final class h extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f71406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.f f71407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EPointF f71408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EPointF f71409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ EPointF f71410e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f71411f;

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
            ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "path emoji load failed " + r101);
            y r102 = this.f71406a;
            r102.h(r102);
            r102.s(false);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r110, Object r111, Animatable r112) {
            ImageInfo r113 = (ImageInfo) r111;
            Intrinsics.checkNotNullParameter(r110, "id");
            if ((r112 instanceof AnimatedDrawable2) == false) goto L17;
            y r114 = this.f71406a;
            AnimatedDrawable2 r115 = (AnimatedDrawable2) r112;
            long r100 = this.f71407b.getDuration();
            EPointF r116 = this.f71408c;
            EPointF r101 = this.f71409d;
            EPointF r102 = this.f71410e;
            int r103 = this.f71411f;
            if (r114.f71384d != null) goto L8;
        L15:
            r115.setAnimationListener(new j0());
            return;
        L8:
            if (r114.f71385e == null) goto L15;
            Ref.BooleanRef r104 = new Ref.BooleanRef();
            com.bytedance.android.live.liveinteract.animation.e r105 = r114.f71384d;
            Intrinsics.checkNotNull(r105);
            r104.element = r105.si();
            ValueAnimator r106 = ValueAnimator.ofObject(new com.bytedance.android.live.liveinteract.utils.f(r102), new Object[]{r116, r101});
            if (r100 > 0) goto L14;
            r100 = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        L14:
            r106.setDuration(r100);
            r106.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
            r106.addUpdateListener(new z(r114, r103, r116, r101, r104));
            r106.addListener(new a0(r114, r103, r116, r101, r115));
            Unit r117 = Unit.INSTANCE;
            r114.f71393m = r106;
            r106.start();
            goto L15
        }

        public h(y r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r101, EPointF r102, EPointF r103, EPointF r104, int r105) {
            this.f71406a = r100;
            this.f71407b = r101;
            this.f71408c = r102;
            this.f71409d = r103;
            this.f71410e = r104;
            this.f71411f = r105;
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
        this.f71384d = null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final int f() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void recycle() {
        s(false);
        HSImageView r100 = this.f71386f;
        if (r100 == null) goto L5;
        r100.postDelayed(new b(this), 100);
    L5:
        HSImageView r101 = this.f71385e;
        if (r101 == null) goto L8;
        r101.postDelayed(new c(this), 100);
    L8:
        HSImageView r102 = this.f71387g;
        if (r102 == null) goto L11;
        r102.postDelayed(new d(this), 100);
    L11:
        HSImageView r103 = this.f71388h;
        if (r103 == null) goto L14;
        r103.postDelayed(new e(this), 100);
    L14:
        HSImageView r104 = this.f71389i;
        if (r104 == null) goto L18;
        r104.postDelayed(new f(this), 100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void startAnimation() {
        this.f71394n.add(Observable.timer(10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h0(this)));
        com.bytedance.android.live.liveinteract.animation.e r100 = this.f71384d;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f71392l != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r100);
        int r101 = r100.zl(this.f71390j);
        com.bytedance.android.live.liveinteract.animation.e r102 = this.f71384d;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.zl(this.f71391k);
        if (r101 == r103) goto L112;
        if (r101 < 0) goto L112;
        if (r103 < 0) goto L112;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r104 = this.f71392l;
        if (r104 == null) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r105 = r104.getInteractEmoji();
        if (r105 == null) goto L21;
        if (r105.isValid() == true) goto L21;
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "invalid emoji since data invalid");
        return;
    L21:
        com.bytedance.android.live.liveinteract.animation.e r106 = this.f71384d;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNullParameter(r106, "seatInfoProvider");
        if (l0.b() == false) goto L24;
        this.f71386f = l0.a();
    L26:
        if (l0.b() == false) goto L28;
        this.f71385e = l0.a();
    L30:
        if (l0.b() == false) goto L32;
        this.f71387g = l0.a();
    L34:
        if (l0.b() == false) goto L36;
        this.f71388h = l0.a();
    L38:
        if (l0.b() == false) goto L40;
        this.f71389i = l0.a();
    L41:
        r106.vj().addView(this.f71386f);
        r106.vj().addView(this.f71385e);
        r106.vj().addView(this.f71387g);
        r106.vj().addView(this.f71388h);
        r106.vj().addView(this.f71389i);
        com.bytedance.android.live.liveinteract.animation.e r107 = this.f71384d;
        Intrinsics.checkNotNull(r107);
        if (r107.wc(this.f71390j) == false) goto L44;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(true, r101);
        com.bytedance.android.live.liveinteract.animation.e r108 = this.f71384d;
        Intrinsics.checkNotNull(r108);
        r108.Bn(this.f71390j);
    L44:
        com.bytedance.android.live.liveinteract.animation.e r109 = this.f71384d;
        Intrinsics.checkNotNull(r109);
        if (r109.wc(this.f71391k) == false) goto L47;
        com.bytedance.android.live.liveinteract.voicechat.emoji.b.a(false, r103);
        com.bytedance.android.live.liveinteract.animation.e r110 = this.f71384d;
        Intrinsics.checkNotNull(r110);
        r110.Bn(this.f71391k);
    L47:
        StringBuilder r111 = new StringBuilder("play ");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r112 = this.f71392l;
        Intrinsics.checkNotNull(r112);
        r111.append(r112.getEmojiName());
        r111.append(" from{");
        r111.append(this.f71390j);
        r111.append(", ");
        r111.append(r101);
        r111.append("} to{");
        r111.append(this.f71391k);
        r111.append(", ");
        r111.append(r103);
        r111.append('}');
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", r111.toString());
        String r113 = this.f71390j;
        String r114 = this.f71391k;
        com.bytedance.android.live.liveinteract.animation.e r115 = this.f71384d;
        if (r115 != null) goto L51;
        return;
    L51:
        if (this.f71386f != null) goto L54;
        return;
    L54:
        if (this.f71392l == null) goto L116;
        Intrinsics.checkNotNull(r115);
        if (r115.Pf(r103) == false) goto L117;
        com.bytedance.android.live.liveinteract.animation.e r116 = this.f71384d;
        Intrinsics.checkNotNull(r116);
        EPointF r117 = r116.C7(r101, r103);
        com.bytedance.android.live.liveinteract.animation.e r118 = this.f71384d;
        Intrinsics.checkNotNull(r118);
        EPointF r119 = r118.Kl(r101, r103);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r120 = this.f71392l;
        Intrinsics.checkNotNull(r120);
        System.currentTimeMillis();
        this.f71395o = new InteractAnimationController.c(r120, r113, r114, false);
        int[] r121 = new int[2];
        com.bytedance.android.live.liveinteract.animation.e r122 = this.f71384d;
        Intrinsics.checkNotNull(r122);
        r122.vj().getLocationOnScreen(r121);
        Intrinsics.checkNotNull(r117);
        ((PointF) r117).x -= r121[0];
        Intrinsics.checkNotNull(r117);
        ((PointF) r117).y -= r121[1];
        Intrinsics.checkNotNull(r119);
        ((PointF) r119).x -= r121[0];
        Intrinsics.checkNotNull(r119);
        ((PointF) r119).y -= r121[1];
        HSImageView r123 = this.f71388h;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r124 = this.f71392l;
        Intrinsics.checkNotNull(r124);
        n(r123, r101, r124.getEmojiCategory());
        HSImageView r125 = this.f71389i;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r126 = this.f71392l;
        Intrinsics.checkNotNull(r126);
        n(r125, r103, r126.getEmojiCategory());
        HSImageView r127 = this.f71388h;
        if (r127 == null) goto L62;
        o(r127, r117);
    L62:
        HSImageView r128 = this.f71389i;
        if (r128 == null) goto L65;
        o(r128, r119);
    L65:
        DraweeController r129 = null;
        if (this.f71384d == null) goto L89;
        if (this.f71388h == null) goto L89;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r130 = this.f71392l;
        if (r130 == null) goto L76;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r131 = r130.interactEmoji();
        if (r131 == null) goto L76;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r132 = r131.getSenderEmoji();
    L77:
        if (r132 == null) goto L89;
        ImageRequest[] r133 = a1.b(r132.extraDynamicImage(), -1);
        HSImageView r134 = this.f71388h;
        if (r134 == null) goto L81;
        UtilityKotlinExtentionsKt.w(r134);
    L81:
        HSImageView r135 = this.f71388h;
        if (r135 == null) goto L89;
        PipelineDraweeControllerBuilder r136 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r133);
        HSImageView r137 = this.f71388h;
        if (r137 == null) goto L86;
        DraweeController r138 = r137.getController();
    L87:
        r135.setController(r136.setOldController(r138).setAutoPlayAnimations(true).setControllerListener(new g0(this)).build());
        goto L89
    L86:
        r138 = null;
    L76:
        r132 = null;
    L89:
        if (this.f71384d != null) goto L92;
    L110:
        q(r101, r103, false);
        return;
    L92:
        if (this.f71389i == null) goto L110;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r139 = this.f71392l;
        if (r139 == null) goto L99;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r140 = r139.interactEmoji();
        if (r140 == null) goto L99;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r141 = r140.getReceiverEmoji();
    L100:
        if (r141 == null) goto L110;
        ImageRequest[] r142 = a1.b(r141.extraDynamicImage(), -1);
        HSImageView r143 = this.f71389i;
        if (r143 == null) goto L104;
        UtilityKotlinExtentionsKt.w(r143);
    L104:
        HSImageView r144 = this.f71389i;
        if (r144 == null) goto L110;
        PipelineDraweeControllerBuilder r145 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r142);
        HSImageView r146 = this.f71389i;
        if (r146 == null) goto L109;
        r129 = r146.getController();
    L109:
        r144.setController(r145.setOldController(r129).setAutoPlayAnimations(true).setControllerListener(new e0(this)).build());
    L99:
        r141 = null;
        goto L100
    L117:
        return;
    L116:
        return;
    L40:
        this.f71389i = new HSImageView(r106.vj().getContext());
        goto L41
    L36:
        this.f71388h = new HSImageView(r106.vj().getContext());
        goto L38
    L32:
        this.f71387g = new HSImageView(r106.vj().getContext());
        goto L34
    L28:
        this.f71385e = new HSImageView(r106.vj().getContext());
        goto L30
    L24:
        this.f71386f = new HSImageView(r106.vj().getContext());
    L112:
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "invalid emoji since from=" + r101 + " to=" + r103);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String getToUserId() {
        return this.f71391k;
    }

    public static final void m(y r100) {
        if (r100.f71384d == null) goto L32;
        InteractAnimationController.c r101 = r100.f71395o;
        if (r101 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r102 = r101.f70942a;
        if (r102 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r103 = r102.interactEmoji();
        if (r103 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r104 = r103.getReceiverEmoji();
    L13:
        com.bytedance.android.live.liveinteract.animation.e r105 = r100.f71384d;
        Intrinsics.checkNotNull(r105);
        InteractAnimationController.c r106 = r100.f71395o;
        if (r106 == null) goto L17;
        String r107 = r106.f70943b;
        if (r107 == null) goto L17;
    L18:
        int r108 = r105.zl(r107);
        if (r104 != null) goto L21;
    L28:
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "won't play receiver animation for " + r104 + " invalid");
        r100.h(r100);
        r100.s(true);
        return;
    L21:
        if (r104.isValid() != true) goto L28;
        if (r108 <= 0) goto L27;
        com.bytedance.android.live.liveinteract.animation.e r109 = r100.f71384d;
        Intrinsics.checkNotNull(r109);
        if (r109.Ed(r108) == true) goto L27;
        ALogger.e("InteractAnimation.InteractRewardEmojiAnimationTask", "won't play receiver animation for seat " + r108 + " invalid");
        r100.h(r100);
        r100.s(true);
        return;
    L27:
        r100.l();
        ImageRequest[] r110 = a1.b(r104.dynamicImage(), -1);
        HSImageView r111 = r100.f71387g;
        Intrinsics.checkNotNull(r111);
        UtilityKotlinExtentionsKt.w(r111);
        HSImageView r112 = r100.f71387g;
        Intrinsics.checkNotNull(r112);
        PipelineDraweeControllerBuilder r113 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r110);
        HSImageView r114 = r100.f71387g;
        Intrinsics.checkNotNull(r114);
        r112.setController(r113.setOldController(r114.getController()).setAutoPlayAnimations(true).setControllerListener(new c0(r100)).build());
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
        this.f71384d = r100;
    }

    public final void p(int r100) {
        HSImageView r101 = this.f71385e;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f71384d != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        com.bytedance.android.live.liveinteract.animation.e r103 = this.f71384d;
        Intrinsics.checkNotNull(r103);
        r102.width = r103.qq(r100);
        com.bytedance.android.live.liveinteract.animation.e r104 = this.f71384d;
        Intrinsics.checkNotNull(r104);
        r102.height = r104.qq(r100);
        HSImageView r105 = this.f71385e;
        Intrinsics.checkNotNull(r105);
        r105.setLayoutParams(r102);
    }

    public final void s(boolean r100) {
        if (this.f71395o != null) goto L5;
        return;
    L5:
        this.f71390j = "";
        this.f71391k = "";
        this.f71395o = null;
        HSImageView r101 = this.f71385e;
        if (r101 == null) goto L8;
        r101.setController(null);
    L8:
        HSImageView r102 = this.f71386f;
        if (r102 == null) goto L11;
        r102.setController(null);
    L11:
        HSImageView r103 = this.f71387g;
        if (r103 == null) goto L14;
        r103.setController(null);
    L14:
        HSImageView r104 = this.f71388h;
        if (r104 == null) goto L17;
        r104.setController(null);
    L17:
        HSImageView r105 = this.f71389i;
        if (r105 == null) goto L20;
        r105.setController(null);
    L20:
        this.f71394n.dispose();
        this.f70970a.clear();
        HSImageView r106 = this.f71385e;
        if (r106 == null) goto L23;
        UtilityKotlinExtentionsKt.u(r106);
    L23:
        HSImageView r107 = this.f71386f;
        if (r107 == null) goto L26;
        UtilityKotlinExtentionsKt.u(r107);
    L26:
        HSImageView r108 = this.f71387g;
        if (r108 == null) goto L29;
        UtilityKotlinExtentionsKt.u(r108);
    L29:
        HSImageView r109 = this.f71388h;
        if (r109 == null) goto L32;
        UtilityKotlinExtentionsKt.u(r109);
    L32:
        HSImageView r110 = this.f71389i;
        if (r110 == null) goto L35;
        UtilityKotlinExtentionsKt.u(r110);
    L35:
        Animator r111 = this.f71393m;
        if (r111 != null) goto L38;
        return;
    L38:
        if (r111.isRunning() != true) goto L44;
        Animator r112 = this.f71393m;
        if (r112 == null) goto L45;
        r112.cancel();
        return;
    L45:
        return;
    }

    public y(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276354d);
        super(r100, r101);
        this.f71390j = "";
        this.f71391k = "";
        this.f71394n = new CompositeDisposable();
    }

    public final void o(HSImageView r100, EPointF r101) {
        r100.setX(((PointF) r101).x - (r100.getLayoutParams().width / 2));
        r100.setY(((PointF) r101).y - (r100.getLayoutParams().height / 2));
    }

    public final void n(HSImageView r100, int r101, int r102) {
        if (this.f71384d != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
    L8:
        if (r103 == null) goto L10;
        com.bytedance.android.live.liveinteract.animation.e r104 = this.f71384d;
        Intrinsics.checkNotNull(r104);
        r103.width = r104.ma(r101, r102);
    L10:
        if (r103 == null) goto L12;
        com.bytedance.android.live.liveinteract.animation.e r105 = this.f71384d;
        Intrinsics.checkNotNull(r105);
        r103.height = r105.ma(r101, r102);
    L12:
        if (r100 == null) goto L15;
        r100.setLayoutParams(r103);
        return;
    L15:
        return;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.bytedance.android.live.liveinteract.utils.EPointF] */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.bytedance.android.live.liveinteract.utils.EPointF] */
    public final void q(int r110, int r111, boolean r112) {
        if (this.f71392l != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.animation.e r100 = this.f71384d;
        if (r100 != null) goto L8;
        return;
    L8:
        this.f71396p = r112;
        Intrinsics.checkNotNull(r100);
        if (r100.Pf(r111) == true) goto L11;
        return;
    L11:
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r101 = this.f71384d;
        Intrinsics.checkNotNull(r101);
        r113.element = r101.C7(r110, r111);
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        com.bytedance.android.live.liveinteract.animation.e r103 = this.f71384d;
        Intrinsics.checkNotNull(r103);
        r102.element = r103.Kl(r110, r111);
        com.bytedance.android.live.liveinteract.animation.e r104 = this.f71384d;
        Intrinsics.checkNotNull(r104);
        EPointF r105 = r104.Se(r110, r111, (EPointF) r113.element, (EPointF) r102.element);
        int[] r106 = new int[2];
        com.bytedance.android.live.liveinteract.animation.e r107 = this.f71384d;
        Intrinsics.checkNotNull(r107);
        r107.vj().getLocationOnScreen(r106);
        EPointF r108 = (EPointF) r113.element;
        Intrinsics.checkNotNull(r108);
        EPointF r109 = (EPointF) r113.element;
        ((PointF) r108).x = ((PointF) r109).x - r106[0];
        Intrinsics.checkNotNull(r109);
        ((PointF) r109).y = ((PointF) ((EPointF) r113.element)).y - r106[1];
        EPointF r114 = (EPointF) r102.element;
        Intrinsics.checkNotNull(r114);
        EPointF r115 = (EPointF) r102.element;
        ((PointF) r114).x = ((PointF) r115).x - r106[0];
        Intrinsics.checkNotNull(r115);
        ((PointF) r115).y = ((PointF) ((EPointF) r102.element)).y - r106[1];
        HSImageView r116 = this.f71386f;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r117 = this.f71392l;
        Intrinsics.checkNotNull(r117);
        n(r116, r110, r117.getEmojiCategory());
        HSImageView r118 = this.f71387g;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r119 = this.f71392l;
        Intrinsics.checkNotNull(r119);
        n(r118, r111, r119.getEmojiCategory());
        HSImageView r120 = this.f71387g;
        if (r120 == null) goto L14;
        o(r120, (EPointF) r102.element);
    L14:
        HSImageView r121 = this.f71386f;
        if (r121 == null) goto L17;
        o(r121, (EPointF) r113.element);
    L17:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r122 = this.f71392l;
        Intrinsics.checkNotNull(r122);
        p(r122.getEmojiCategory());
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r123 = this.f71392l;
        if (r123 == null) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r124 = r123.interactEmoji();
        if (r124 == null) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r125 = r124.getSenderEmoji();
        if (r125 == null) goto L40;
        if (r125.isValid() != true) goto L40;
        com.bytedance.android.live.liveinteract.animation.e r126 = this.f71384d;
        Intrinsics.checkNotNull(r126);
        if (r126.Ed(r110) == false) goto L40;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r127 = this.f71392l;
        if (r127 == null) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r128 = r127.interactEmoji();
        if (r128 == null) goto L34;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r129 = r128.getSenderEmoji();
        if (r129 == null) goto L34;
        py.k r130 = r129.dynamicImage();
    L35:
        ImageRequest[] r131 = a1.b(r130, -1);
        Iterator<com.bytedance.android.live.liveinteract.animation.g> r132 = this.f70970a.iterator();
    L37:
        if (r132.hasNext() == false) goto L39;
        r132.next().c();
        goto L37
    L39:
        HSImageView r133 = this.f71386f;
        Intrinsics.checkNotNull(r133);
        PipelineDraweeControllerBuilder r134 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r131);
        HSImageView r135 = this.f71386f;
        Intrinsics.checkNotNull(r135);
        r133.setController(r134.setOldController(r135.getController()).setAutoPlayAnimations(true).setControllerListener(new g(this, r113, r102, r105)).build());
        HSImageView r136 = this.f71386f;
        Intrinsics.checkNotNull(r136);
        UtilityKotlinExtentionsKt.w(r136);
        int r137 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.f80165a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r138 = this.f71392l;
        Intrinsics.checkNotNull(r138);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r139 = r138.interactEmoji();
        Intrinsics.checkNotNull(r139);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r140 = r139.getPathEmoji();
        Intrinsics.checkNotNull(r140);
        py.k r141 = r140.dynamicImage();
        Intrinsics.checkNotNull(r141);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r141);
    L41:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r142 = this.f71392l;
        Intrinsics.checkNotNull(r142);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r143 = r142.interactEmoji();
        if (r143 == null) goto L50;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r144 = r143.getReceiverEmoji();
        if (r144 != null) goto L46;
        return;
    L46:
        if (r144.isValid() != true) goto L52;
        int r145 = com.bytedance.android.live.liveinteract.voicechat.emoji.a.f80165a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r146 = this.f71392l;
        Intrinsics.checkNotNull(r146);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r147 = r146.interactEmoji();
        Intrinsics.checkNotNull(r147);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r148 = r147.getReceiverEmoji();
        Intrinsics.checkNotNull(r148);
        py.k r149 = r148.dynamicImage();
        Intrinsics.checkNotNull(r149);
        com.bytedance.android.live.liveinteract.voicechat.emoji.a.a(r149);
        return;
    L52:
        return;
    L50:
        return;
    L34:
        r130 = null;
    L40:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r150 = this.f71392l;
        Intrinsics.checkNotNull(r150);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r151 = r150.interactEmoji();
        Intrinsics.checkNotNull(r151);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r152 = r151.getPathEmoji();
        Intrinsics.checkNotNull(r152);
        EPointF r153 = (EPointF) r113.element;
        EPointF r154 = (EPointF) r102.element;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r155 = this.f71392l;
        Intrinsics.checkNotNull(r155);
        r(r152, r153, r154, r105, r155.getEmojiCategory());
        goto L41
    }

    public final void r(com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r110, EPointF r111, EPointF r112, EPointF r113, int r114) {
        if (this.f71385e != null) goto L5;
        return;
    L5:
        ImageRequest[] r100 = a1.b(r110.dynamicImage(), -1);
        j();
        HSImageView r101 = this.f71385e;
        Intrinsics.checkNotNull(r101);
        UtilityKotlinExtentionsKt.w(r101);
        HSImageView r102 = this.f71385e;
        Intrinsics.checkNotNull(r102);
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r100);
        HSImageView r104 = this.f71385e;
        Intrinsics.checkNotNull(r104);
        r102.setController(r103.setOldController(r104.getController()).setAutoPlayAnimations(false).setControllerListener(new h(this, r110, r111, r112, r113, r114)).build());
    }
}
