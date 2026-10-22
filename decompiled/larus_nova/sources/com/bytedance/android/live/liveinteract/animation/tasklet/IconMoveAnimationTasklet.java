package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.n0;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class IconMoveAnimationTasklet extends com.bytedance.android.live.liveinteract.animation.tasklet.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f71119r = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f71120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<HSImageView> f71121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnimatorSet f71122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Animatable> f71123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Animatable> f71124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f71125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f71126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f71127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageRequest f71128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.c f71129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.e f71130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a f71131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Integer> f71132o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f71133p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function2<d, Boolean, Unit> f71134q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IconMoveAnimationTasklet f71135a;

        public b(IconMoveAnimationTasklet r100) {
            this.f71135a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IconMoveAnimationTasklet r100 = this.f71135a;     // Catch: Throwable -> L6
            if (r100.f71126i == true) goto L9;
            IconMoveAnimationTasklet.c(r100);     // Catch: Throwable -> L6
            this.f71135a.f71126i = true;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ((ArrayList) this.f71120c).clear();
        ((ArrayList) this.f71120c).addAll(this.f71167a.f79403d.f79397b);
        int r100 = 1;
        if ((!((ArrayList) this.f71120c).isEmpty()) == true) goto L6;
        ALogger.e("InteractAnimation.IconMoveAnimationTasklet", "start#resource parse failed.");
        return;
    L6:
        this.f71125h = true;
        ((ArrayList) this.f71121d).clear();
        FrameLayout r101 = this.f71130m.vj();
        int r102 = ((ArrayList) this.f71120c).size();
        ?? r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        HSImageView r105 = this.f71131n.b();
        r101.addView(r105);
        d(r105, this.f71133p);
        ((ArrayList) this.f71121d).add(r105);
        r104 = r104 + 1;
        goto L7
    L9:
        final long r106 = SystemClock.uptimeMillis();
        Function1<Boolean, Unit> r110 = new AnonymousClass1(this, r106);
        if (((ArrayList) this.f71121d).isEmpty() == false) goto L12;
    L41:
        this.f71130m.vj().postDelayed(new b(this), 200);
        return;
    L12:
        if (((ArrayList) this.f71121d).size() != ((ArrayList) this.f71120c).size()) goto L41;
        Ref.IntRef r111 = new Ref.IntRef();
        r111.element = 0;
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = 0;
        int r113 = ((ArrayList) this.f71120c).size();
        int r114 = 0;
    L15:
        if (r114 >= r113) goto L41;
        HSImageView r115 = (HSImageView) ListProtector.get(this.f71121d, r114);
        List<py.k> r107 = this.f71168b.getResources();
        if (r107 == null) goto L40;
        if (r107.size() == 0) goto L40;
        FrameLayout r108 = this.f71130m.vj();
        UtilityKotlinExtentionsKt.w(r115);
        ImageRequest[] r109 = a1.b((py.k) ListProtector.get(r107, r103), r100);
        Uri r116 = null;
        if (this.f71128k != null) goto L28;
        if (r109 == null) goto L26;
        ImageRequest r117 = r109[r103];
    L27:
        this.f71128k = r117;
        goto L28
    L26:
        r117 = null;
    L28:
        AbstractDraweeController r118 = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r109).setAutoPlayAnimations(r103)).setControllerListener(new h(this, r108, r115, r111, r112, r110)).build();
        if (vm2.d.G() == false) goto L39;
        if ((r118 instanceof PipelineDraweeController) == false) goto L39;
        PipelineDraweeController r119 = (PipelineDraweeController) r118;
        Context r120 = r115.getContext();
        if (r109 == null) goto L37;
        ImageRequest r121 = r109[0];
        if (r121 == null) goto L37;
        r116 = r121.getSourceUri();
    L37:
        com.bytedance.android.live.core.utils.fresco.c.a(r119, r120, String.valueOf(r116));
    L39:
        r115.setController(r118);
    L40:
        r114 = r114 + 1;
        r100 = 1;
        r103 = 0;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        Iterator r100 = ((ArrayList) this.f71121d).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        DraweeController r101 = ((HSImageView) r100.next()).getController();
        if (r101 == null) goto L4;
        Animatable r102 = r101.getAnimatable();
        if (r102 == null) goto L4;
        r102.stop();
        goto L4
    L10:
        this.f71122e.end();
        this.f71122e.removeAllListeners();
        Iterator<T> r103 = this.f71122e.getChildAnimations().iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        Animator r104 = (Animator) r103.next();
        if ((r104 instanceof ValueAnimator) == false) goto L12;
        r104.removeAllListeners();
        ((ValueAnimator) r104).removeAllUpdateListeners();
        goto L12
    L16:
        Iterator r105 = ((ArrayList) this.f71121d).iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        ((HSImageView) r105.next()).setController(null);
        goto L18
    L20:
        FrameLayout r106 = this.f71130m.vj();
        r106.post(new j(this, r106));
        this.f71125h = false;
    }

    public static final void b(IconMoveAnimationTasklet r100) {
        Function2<d, Boolean, Unit> r101 = r100.f71134q;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100, Boolean.FALSE);
    L5:
        r100.f71129l.i();
        r100.stop();
        if (vm2.d.G() == false) goto L10;
        CountingMemoryCache<CacheKey, CloseableImage> r103 = com.bytedance.android.live.core.utils.fresco.e.f66139a;
        if (r103 == null) goto L10;
        r103.removeAll(new g(r100));
    L10:
        r100.f71127j = true;
    }

    public static final void c(IconMoveAnimationTasklet r210) {
        if (((ArrayList) r210.f71121d).isEmpty() == false) goto L5;
        return;
    L5:
        if (((ArrayList) r210.f71121d).size() != ((ArrayList) r210.f71120c).size()) goto L56;
        int r100 = ((ArrayList) r210.f71120c).size();
        char r110 = 0;
        int r111 = 0;
    L8:
        if (r111 >= r100) goto L50;
        String r101 = (String) ListProtector.get(r210.f71120c, r111);
        EPointF r112 = r210.f71130m.Mj(r101);
        if (r112 == null) goto L49;
        if (com.bytedance.android.live.liveinteract.utils.v.a(r112) == true) goto L49;
        PointF r102 = r210.f71167a.f79403d.f79396a;
        if (r102 == null) goto L17;
        EPointF r103 = com.bytedance.android.live.liveinteract.utils.v.b(r102);
    L19:
        if (r103 != null) goto L31;
        int r104 = r210.f71168b.getX();
        int r105 = r210.f71168b.getY();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r106 = r210.f71167a.f79402c;
        if (r106 == null) goto L49;
        int r107 = r106.f79391b;
        int r113 = r106.f79392c;
        float r114 = r106.f79393d;
        float r115 = r106.f79394e;
        float r108 = (r105 * 1.0f) / r113;
        PointF r109 = r106.f79390a;
        float r116 = ((r104 * 1.0f) / r107) * r114;
        if (r109 == null) goto L25;
        float r117 = r109.x;
    L26:
        float r118 = r116 + r117;
        float r119 = r108 * r115;
        if (r109 == null) goto L29;
        float r120 = r109.y;
    L30:
        EPointF r121 = new EPointF(r118, r119 + r120);
    L33:
        if (com.bytedance.android.live.liveinteract.utils.v.a(r121) == true) goto L49;
        int[] r122 = new int[2];
        r210.f71130m.vj().getLocationOnScreen(r122);
        float r123 = ((PointF) r121).x;
        float r124 = r122[r110];
        ((PointF) r121).x = r123 - r124;
        float r125 = ((PointF) r121).y;
        float r126 = r122[1];
        ((PointF) r121).y = r125 - r126;
        ((PointF) r112).x -= r124;
        ((PointF) r112).y -= r126;
        Integer r127 = r210.f71132o.get(r101);
        if (r127 == null) goto L38;
        int r128 = r127.intValue();
    L39:
        int r129 = r210.f71168b.getOffsetStart();
        double r130 = 0.5f;
        double r131 = 2;
        float r132 = ((float) ((Math.random() - r130) * r131)) * UtilityKotlinExtentionsKt.i(r129);
        float r133 = ((float) ((Math.random() - r130) * r131)) * UtilityKotlinExtentionsKt.i(r129);
        ((PointF) r121).x += r132;
        ((PointF) r121).y += r133;
        HSImageView r134 = (HSImageView) ListProtector.get(r210.f71121d, r111);
        UtilityKotlinExtentionsKt.w(r134);
        r134.setRotation(n0.a(r121, r112));
        DraweeController r135 = r134.getController();
        if (r135 == null) goto L42;
        Animatable r136 = r135.getAnimatable();
    L43:
        long r137 = r210.f71168b.getDuration();
        long r138 = r128;
        int r139 = r210.f71133p;
        Ref.BooleanRef r140 = new Ref.BooleanRef();
        r140.element = r210.f71130m.si();
        l r141 = new l();
        Object[] r142 = new Object[2];
        r142[r110] = r121;
        r142[1] = r112;
        ValueAnimator r143 = ValueAnimator.ofObject(r141, r142);
        if (r137 > 0) goto L47;
        r137 = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    L47:
        r143.setDuration(r137);
        r143.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        EPointF r144 = r121;
        r143.addUpdateListener(new e(r210, r134, r144, r112, r140, r139, r136));
        r143.addListener(new f(r210, r134, r144, r112, r139, r136));
        r143.setStartDelay(r138);
        r210.f71122e.playTogether(new Animator[]{r143});
        goto L49
    L42:
        r136 = null;
        goto L43
    L38:
        r128 = 0;
        goto L39
    L29:
        r120 = 0.0f;
        goto L30
    L25:
        r117 = 0.0f;
        goto L26
    L31:
        r121 = r103;
        goto L33
    L17:
        r103 = null;
    L49:
        r111 = r111 + 1;
        r100 = r100;
        r110 = 0;
        goto L8
    L50:
        r210.f71122e.start();
        return;
    }

    public final void d(HSImageView r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.width = (int) (this.f71130m.qq(r101) * 0.83f);
        r102.height = (int) (this.f71130m.qq(r101) * 0.83f);
        r100.setLayoutParams(r102);
    }

    public IconMoveAnimationTasklet(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r100, com.bytedance.android.live.liveinteract.animation.c r101, com.bytedance.android.live.liveinteract.animation.e r102, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r103, com.bytedance.android.live.liveinteract.animation.tasklet.a r104, Map r105, Function2 r106) {
        Intrinsics.checkNotNullParameter(r100, "revenueData");
        Intrinsics.checkNotNullParameter(r101, "mTask");
        Intrinsics.checkNotNullParameter(r102, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "animationData");
        Intrinsics.checkNotNullParameter(r104, "mViewProvider");
        Intrinsics.checkNotNullParameter(r105, "mDelayMap");
        super(r100, r103);
        this.f71129l = r101;
        this.f71130m = r102;
        this.f71131n = r104;
        this.f71132o = r105;
        this.f71133p = 1;
        this.f71134q = r106;
        this.f71120c = new ArrayList();
        this.f71121d = new ArrayList();
        this.f71122e = new AnimatorSet();
        this.f71123f = new LinkedHashSet();
        this.f71124g = new LinkedHashSet();
    }
}
