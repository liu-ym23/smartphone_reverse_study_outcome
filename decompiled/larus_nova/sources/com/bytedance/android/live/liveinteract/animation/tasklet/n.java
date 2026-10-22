package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class n extends com.bytedance.android.live.liveinteract.animation.tasklet.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f71212r = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f71213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<HSImageView> f71214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Animatable> f71215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Animatable> f71216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f71217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageRequest f71218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.c f71219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.e f71220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a f71221k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Integer> f71222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f71223m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f71224n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f71225o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f71226p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function2<d, Boolean, Unit> f71227q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f71228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HSImageView f71229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EPointF f71230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f71231d;

        public b(n r100, HSImageView r101, EPointF r102, String r103) {
            this.f71228a = r100;
            this.f71229b = r101;
            this.f71230c = r102;
            this.f71231d = r103;
        }

        public final void a() {
            n r100 = this.f71228a;
            HSImageView r101 = this.f71229b;
            EPointF r102 = this.f71230c;
            r100.getClass();
            r101.setX(((PointF) r102).x - (r101.getLayoutParams().width / 2));
            r101.setY(((PointF) r102).y - (r101.getLayoutParams().height / 2));
            n r103 = this.f71228a;
            HSImageView r104 = this.f71229b;
            int r105 = r103.f71220j.zl(this.f71231d);
            if (r103.f71168b.isValid() == true) goto L5;
            ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "playReceiverSeatAnimation#animation data invalid:" + r103.f71168b);
            return;
        L5:
            if (r105 > 0) goto L7;
        L9:
            String r106 = r103.f71168b.getSoundUrl();
            Uri r107 = null;
            if (r106 == null) goto L23;
            if (StringsKt.endsWith$default(r106, "null", false, 2, null) == true) goto L23;
            com.bytedance.android.live.liveinteract.animation.e r108 = r103.f71220j;
            if ((r108 instanceof InteractAnimationController.d) == true) goto L16;
            r108 = null;
        L16:
            InteractAnimationController.d r109 = (InteractAnimationController.d) r108;
            if (r109 == null) goto L21;
            EmojiSoundManager r110 = InteractAnimationController.d.a.c(r109);
            if (r110 == null) goto L21;
            r110.e(r103.f71224n, r106, r103.f71225o);
        L21:
            r103.f71220j.Mb(r103.f71224n, r106, r103.f71225o);
        L23:
            if (r103.f71168b.getReshape() == true) goto L25;
        L30:
            List<py.k> r111 = r103.f71168b.getResources();
            if (r111 != null) goto L34;
            return;
        L34:
            if (r111.size() == 0) goto L69;
            List<py.k> r112 = r103.f71168b.getResources();
            if (r112 == null) goto L45;
            int r113 = r103.f71167a.f79401b.f79379g - 1;
            if (vm2.d.F() == false) goto L47;
            if (r113 < 0) goto L47;
            if (r113 >= r112.size()) goto L45;
            py.k r114 = (py.k) ListProtector.get(r112, r113);
        L48:
            ImageRequest[] r115 = a1.b(r114, 1);
            if (r103.f71218h != null) goto L54;
            if (r115 == null) goto L52;
            ImageRequest r116 = r115[0];
        L53:
            r103.f71218h = r116;
            goto L54
        L52:
            r116 = null;
        L54:
            UtilityKotlinExtentionsKt.w(r104);
            AbstractDraweeController r117 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r115).setAutoPlayAnimations(true).setControllerListener(new q(r103, r104, r103.f71220j.vj())).build();
            if (vm2.d.G() == true) goto L57;
        L64:
            r104.setController(r117);
            return;
        L57:
            if ((r117 instanceof PipelineDraweeController) == false) goto L64;
            PipelineDraweeController r118 = (PipelineDraweeController) r117;
            Context r119 = r104.getContext();
            if (r115 == null) goto L63;
            ImageRequest r120 = r115[0];
            if (r120 == null) goto L63;
            r107 = r120.getSourceUri();
        L63:
            com.bytedance.android.live.core.utils.fresco.c.a(r118, r119, String.valueOf(r107));
        L47:
            r114 = (py.k) ListProtector.get(r112, (int) (r103.f71167a.f79401b.f79378f % ((long) r112.size())));
        L45:
            r114 = null;
            goto L48
        L69:
            return;
        L25:
            if (r103.f71223m == true) goto L30;
            long r121 = r103.f71168b.getSizeScale();
            com.bytedance.android.live.liveinteract.animation.e r122 = r103.f71220j;
            if (r121 != 0) goto L29;
            r121 = 1000;
        L29:
            r122.Ka(r105, r121 / 1000.0f);
            goto L30
        L7:
            if (r103.f71220j.Ed(r105) == true) goto L9;
            ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "playReceiverSeatAnimation#cur seat cant play,pos:" + r105);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ((ArrayList) this.f71213c).clear();
        ((ArrayList) this.f71213c).addAll(this.f71167a.f79403d.f79397b);
        if ((!((ArrayList) this.f71213c).isEmpty()) == true) goto L6;
        ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "start#resource parse failed.");
        return;
    L6:
        ((ArrayList) this.f71214d).clear();
        FrameLayout r100 = this.f71220j.vj();
        int r101 = ((ArrayList) this.f71213c).size();
        int r102 = 0;
    L7:
        long r103 = 0;
        if (r102 >= r101) goto L24;
        HSImageView r104 = this.f71221k.b();
        int r105 = this.f71220j.zl((String) ListProtector.get(this.f71213c, r102));
        r100.addView(r104);
        long r110 = this.f71168b.getSizeScale();
        if (r110 > 0) goto L12;
        r110 = 1000;
    L12:
        float r106 = r110 / 1000.0f;
        if (r104 == null) goto L15;
        ViewGroup.LayoutParams r107 = r104.getLayoutParams();
    L16:
        com.bytedance.android.live.liveinteract.animation.e r111 = this.f71220j;
        Intrinsics.checkNotNull(r111);
        float r108 = r111.ma(r105, 1) / 1.2f;
        if (r107 == null) goto L19;
        r107.width = (int) (r108 * r106);
    L19:
        if (r107 == null) goto L21;
        r107.height = (int) (r108 * r106);
    L21:
        if (r104 == null) goto L23;
        r104.setLayoutParams(r107);
    L23:
        ((ArrayList) this.f71214d).add(r104);
        r102 = r102 + 1;
        goto L7
    L15:
        r107 = null;
        goto L16
    L24:
        this.f71220j.vj().getLocationOnScreen(new int[2]);
        if (((ArrayList) this.f71214d).isEmpty() == false) goto L27;
        return;
    L27:
        if (((ArrayList) this.f71213c).size() != ((ArrayList) this.f71214d).size()) goto L60;
        int r109 = ((ArrayList) this.f71213c).size();
        int r112 = 0;
    L30:
        if (r112 >= r109) goto L61;
        HSImageView r113 = (HSImageView) ListProtector.get(this.f71214d, r112);
        String r114 = (String) ListProtector.get(this.f71213c, r112);
        EPointF r115 = this.f71220j.Mj(r114);
        if (r115 == null) goto L52;
        int r116 = this.f71220j.zl(r114);
        if (r116 <= 0) goto L40;
        com.bytedance.android.live.liveinteract.animation.e r117 = this.f71220j;
        Intrinsics.checkNotNull(r117);
        if (r117.Ed(r116) == false) goto L52;
    L40:
        if (this.f71226p == false) goto L43;
        this.f71220j.dm(r116);
        goto L52
    L43:
        Integer r118 = this.f71222l.get(r114);
        if (r118 == null) goto L46;
        int r119 = r118.intValue();
    L48:
        if (this.f71167a.f79401b.f79377e == false) goto L50;
        long r120 = r103;
    L51:
        double r121 = 0.5f;
        double r122 = 2;
        int r123 = (int) r120;
        float r124 = ((float) ((Math.random() - r121) * r122)) * UtilityKotlinExtentionsKt.i(r123);
        float r125 = ((float) (r122 * (Math.random() - r121))) * UtilityKotlinExtentionsKt.i(r123);
        int[] r126 = new int[2];
        this.f71220j.vj().getLocationOnScreen(r126);
        ((PointF) r115).x = (((PointF) r115).x - r126[0]) + r124;
        ((PointF) r115).y = (((PointF) r115).y - r126[1]) + r125;
        r113.postDelayed(new b(this, r113, r115, r114), r119);
        goto L52
    L50:
        r120 = this.f71168b.getOffset();
        goto L51
    L46:
        r119 = 0;
    L52:
        r112 = r112 + 1;
        r109 = r109;
        r103 = 0;
        goto L30
    L61:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        Iterator r100 = ((ArrayList) this.f71214d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((HSImageView) r100.next()).setController(null);
        goto L4
    L6:
        FrameLayout r101 = this.f71220j.vj();
        r101.post(new r(this, r101));
    }

    public static final void b(n r100) {
        Function2<d, Boolean, Unit> r101 = r100.f71227q;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(r100, Boolean.FALSE);
    L5:
        r100.f71219i.k();
        r100.stop();
        if (vm2.d.G() == false) goto L10;
        CountingMemoryCache<CacheKey, CloseableImage> r103 = com.bytedance.android.live.core.utils.fresco.e.f66139a;
        if (r103 == null) goto L10;
        r103.removeAll(new o(r100));
    L10:
        r100.f71217g = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r100, com.bytedance.android.live.liveinteract.animation.c r101, com.bytedance.android.live.liveinteract.animation.e r102, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r103, com.bytedance.android.live.liveinteract.animation.tasklet.a r104, Map<String, Integer> r105, boolean r106, String r107, int r110, boolean r111, Function2<? super d, ? super Boolean, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "revenueData");
        Intrinsics.checkNotNullParameter(r101, "mTask");
        Intrinsics.checkNotNullParameter(r102, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "animationData");
        Intrinsics.checkNotNullParameter(r104, "mViewProvider");
        Intrinsics.checkNotNullParameter(r105, "mDelayMap");
        Intrinsics.checkNotNullParameter(r107, "mTaskID");
        super(r100, r103);
        this.f71219i = r101;
        this.f71220j = r102;
        this.f71221k = r104;
        this.f71222l = r105;
        this.f71223m = r106;
        this.f71224n = r107;
        this.f71225o = r110;
        this.f71226p = r111;
        this.f71227q = r112;
        this.f71213c = new ArrayList();
        this.f71214d = new ArrayList();
        this.f71215e = new LinkedHashSet();
        this.f71216f = new LinkedHashSet();
    }
}
