package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class PathEffectAnimationTasklet extends b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f71136s = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f71137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<HSImageView> f71138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EPointF f71139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<EPointF> f71140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<py.k> f71141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f71142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Animatable> f71143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Animatable> f71144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageRequest f71146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.c f71147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.e f71148n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.animation.tasklet.a f71149o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, Integer> f71150p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f71151q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function2<d, Boolean, Unit> f71152r;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void start() {
        ((ArrayList) this.f71137c).clear();
        ((ArrayList) this.f71137c).addAll(this.f71167a.f79403d.f79397b);
        DraweeController r100 = null;
        char r101 = 1;
        int r110 = 0;
        if (((ArrayList) this.f71137c).isEmpty() == false) goto L6;
        ALogger.e("InteractAnimation.PathEffectAnimationTasklet", "parseAnimationResourceData#toUserIds is empty");
    L5:
        boolean r102 = false;
    L44:
        if (r102 == true) goto L47;
        ALogger.e("InteractAnimation.PathEffectAnimationTasklet", "start#resource parse failed.");
        return;
    L47:
        int r111 = -1;
        if (this.f71142h == null) goto L62;
        ((ArrayList) this.f71138d).clear();
        int r103 = this.f71168b.getLevel();
        int r104 = ((ArrayList) this.f71137c).size();
        int r105 = 0;
    L51:
        if (r105 >= r104) goto L62;
        HSImageView r106 = this.f71149o.b();
        FrameLayout r107 = this.f71142h;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getChildCount();
        int r112 = 0;
    L53:
        if (r112 >= r108) goto L60;
        FrameLayout r113 = this.f71142h;
        Intrinsics.checkNotNull(r113);
        Object r114 = r113.getChildAt(r112).getTag();
        if ((r114 instanceof com.bytedance.android.live.liveinteract.animation.a) == false) goto L59;
        if (((com.bytedance.android.live.liveinteract.animation.a) r114).f70963a <= r103) goto L59;
    L61:
        FrameLayout r109 = this.f71142h;
        Intrinsics.checkNotNull(r109);
        r109.addView(r106, r112);
        ((ArrayList) this.f71138d).add(r106);
        r105 = r105 + 1;
    L59:
        r112 = r112 + 1;
        goto L53
    L60:
        r112 = -1;
    L62:
        final long r115 = SystemClock.uptimeMillis();
        new AnonymousClass1(this, r115);
        if (this.f71139e == null) goto L116;
        FrameLayout r116 = this.f71142h;
        if (r116 != null) goto L69;
        return;
    L69:
        if (((ArrayList) this.f71138d).isEmpty() == false) goto L71;
        return;
    L71:
        if (((ArrayList) this.f71138d).size() != ((ArrayList) this.f71137c).size()) goto L118;
        int[] r117 = new int[2];
        FrameLayout r118 = this.f71142h;
        if (r118 == null) goto L76;
        r118.getLocationOnScreen(r117);
    L76:
        int r119 = ((ArrayList) this.f71137c).size();
        int r120 = 0;
    L77:
        if (r120 >= r119) goto L119;
        String r121 = (String) ListProtector.get(this.f71137c, r120);
        EPointF r122 = this.f71148n.Mj(r121);
        if (r122 == null) goto L100;
        ((PointF) r122).x -= r117[r110];
        ((PointF) r122).y -= r117[r101];
        ((ArrayList) this.f71140f).add(r122);
        EPointF r123 = this.f71139e;
        Intrinsics.checkNotNull(r123);
        float r124 = ((PointF) r123).x - ((PointF) r122).x;
        float r125 = ((PointF) r123).y - ((PointF) r122).y;
        float r126 = (float) Math.sqrt((r124 * r124) + (r125 * r125));
        float r127 = this.f71148n.qq(this.f71151q);
        List<py.k> r128 = this.f71168b.getResources();
        py.k r129 = (py.k) ListProtector.get(r128, r110);
        Iterator<py.k> r130 = r128.iterator();
        float r131 = Float.MAX_VALUE;
    L83:
        if (r130.hasNext() == false) goto L88;
        py.k r132 = r130.next();
        float r133 = ((r126 / r132.getHeight()) * r132.getWidth()) - r127;
        if (Math.abs(r133) >= Math.abs(r131)) goto L83;
        r131 = r133;
        r129 = r132;
        goto L83
    L88:
        if (r129 == null) goto L100;
        ((ArrayList) this.f71141g).add(r129);
        ALogger.i("InteractAnimation.PathEffectAnimationTasklet", "loadAnimationResources#select:" + r129 + ".width:" + r129.getWidth() + ",height:" + r129.getHeight());
        HSImageView r134 = (HSImageView) ListProtector.get(this.f71138d, r120);
        r134.setController(r100);
        UtilityKotlinExtentionsKt.w(r134);
        ImageRequest[] r135 = a1.b(r129, r111);
        if (r135 == null) goto L95;
        int r136 = r135.length;
        int r137 = 0;
    L93:
        if (r137 >= r136) goto L95;
        ImageRequest r138 = r135[r137];
        CountingMemoryCache<CacheKey, CloseableImage> r139 = com.bytedance.android.live.core.utils.fresco.e.f66139a;
        Fresco.getImagePipeline().prefetchToDiskCache(r138, r100);
        r137 = r137 + 1;
    L95:
        Integer r140 = this.f71150p.get(r121);
        if (r140 == null) goto L98;
        long r141 = r140.intValue();
    L99:
        r134.postDelayed(new v(this, r129, r134, r116, r122), r141);
        goto L100
    L98:
        r141 = 0;
    L100:
        r120 = r120 + 1;
        r100 = null;
        r101 = 1;
        r110 = 0;
        r111 = -1;
        goto L77
    L119:
        return;
    L118:
        return;
    L116:
        return;
    L6:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r142 = this.f71167a.f79402c;
        if (r142 == null) goto L11;
        Integer r143 = r142.f79395f;
        if (r143 == null) goto L11;
        int r144 = r143.intValue();
    L12:
        int r145 = this.f71168b.getLevel();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r146 = this.f71167a.f79400a;
        if (r146 == null) goto L15;
        FrameLayout r147 = r146.a();
    L16:
        if (r145 < r144) goto L19;
        if (r147 == null) goto L19;
    L20:
        this.f71142h = r147;
        if (r147 == null) goto L5;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r148 = this.f71167a.f79402c;
        if (r148 == null) goto L26;
        PointF r149 = r148.f79390a;
    L27:
        int[] r150 = new int[2];
        r147.getLocationOnScreen(r150);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r151 = this.f71167a.f79402c;
        if (r151 == null) goto L37;
        int r152 = r151.f79391b;
        int r153 = r151.f79392c;
        float r154 = r151.f79393d;
        float r155 = r151.f79394e;
        float r156 = (this.f71168b.getX() * 1.0f) / r152;
        float r157 = (this.f71168b.getY() * 1.0f) / r153;
        float r158 = (r156 * r154) - r150[0];
        float r159 = 0.0f;
        if (r149 == null) goto L32;
        float r160 = r149.x;
    L33:
        float r161 = r158 + r160;
        float r162 = (r157 * r155) - r150[1];
        if (r149 == null) goto L36;
        r159 = r149.y;
    L36:
        EPointF r163 = new EPointF(r161, r162 + r159);
    L38:
        if (r163 == null) goto L5;
        PointF r164 = this.f71167a.f79403d.f79396a;
        if (r164 == null) goto L43;
        r163 = com.bytedance.android.live.liveinteract.utils.v.b(r164);
    L43:
        int r165 = this.f71168b.getOffsetStart();
        double r166 = 0.5f;
        double r167 = 2;
        float r168 = ((float) ((Math.random() - r166) * r167)) * UtilityKotlinExtentionsKt.i(r165);
        float r169 = ((float) ((Math.random() - r166) * r167)) * UtilityKotlinExtentionsKt.i(r165);
        ((PointF) r163).x += r168;
        ((PointF) r163).y += r169;
        this.f71139e = r163;
        r102 = true;
        goto L44
    L32:
        r160 = 0.0f;
        goto L33
    L37:
        r163 = null;
        goto L38
    L26:
        r149 = null;
    L19:
        r147 = this.f71148n.vj();
        goto L20
    L15:
        r147 = null;
    L11:
        r144 = 5;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.d
    public final void stop() {
        Iterator r100 = ((ArrayList) this.f71138d).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((HSImageView) r100.next()).setController(null);
        goto L4
    L6:
        FrameLayout r101 = this.f71142h;
        if (r101 == null) goto L11;
        r101.post(new x(this));
        return;
    }

    public static final void b(PathEffectAnimationTasklet r100, ImageRequest r101) {
        Function2<d, Boolean, Unit> r102 = r100.f71152r;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(r100, Boolean.FALSE);
    L5:
        r100.f71147m.i();
        r100.stop();
        if (vm2.d.G() == false) goto L10;
        CountingMemoryCache<CacheKey, CloseableImage> r104 = com.bytedance.android.live.core.utils.fresco.e.f66139a;
        if (r104 == null) goto L10;
        r104.removeAll(new t(r101));
    L10:
        r100.f71145k = true;
    }

    public PathEffectAnimationTasklet(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r100, com.bytedance.android.live.liveinteract.animation.c r101, com.bytedance.android.live.liveinteract.animation.e r102, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r103, com.bytedance.android.live.liveinteract.animation.tasklet.a r104, Map r105, Function2 r106) {
        Intrinsics.checkNotNullParameter(r100, "revenueData");
        Intrinsics.checkNotNullParameter(r101, "mTask");
        Intrinsics.checkNotNullParameter(r102, "mSeatInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "animationData");
        Intrinsics.checkNotNullParameter(r104, "mViewProvider");
        Intrinsics.checkNotNullParameter(r105, "mDelayMap");
        super(r100, r103);
        this.f71147m = r101;
        this.f71148n = r102;
        this.f71149o = r104;
        this.f71150p = r105;
        this.f71151q = 1;
        this.f71152r = r106;
        this.f71137c = new ArrayList();
        this.f71138d = new ArrayList();
        this.f71140f = new ArrayList();
        this.f71141g = new ArrayList();
        this.f71143i = new LinkedHashSet();
        this.f71144j = new LinkedHashSet();
    }
}
