package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.core.math.MathUtils;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.view.BarrageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends AbsBarrageController {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f137594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<Float> f137595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PathMeasure f137596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f137597q;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void m() {
        p();
        this.f137595o.clear();
        super.m();
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void i(AbsBarrage r100) {
        Intrinsics.checkNotNullParameter(r100, IPerformanceManager.MODULE_BARRAGE);
        o();
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void j(com.ss.ugc.live.barrage.util.a r110, float r111) {
        Intrinsics.checkNotNullParameter(r110, "runningBarrageList");
        float r100 = r111 / this.f137597q;
        Iterator<AbsBarrage> r101 = r110.iterator();
        ListIterator<Float> r102 = this.f137595o.listIterator();
    L3:
        com.ss.ugc.live.barrage.util.a.C5473a r103 = (com.ss.ugc.live.barrage.util.a.C5473a) r101;
        if (r103.hasNext() == false) goto L25;
        AbsBarrage r104 = (AbsBarrage) r103.next();
        float r112 = r102.next().floatValue();
        if ((r104 instanceof com.bytedance.android.livesdk.interactivity.like.barrage.a) == false) goto L3;
        float[] r113 = new float[2];
        float[] r114 = new float[2];
        PathMeasure r115 = this.f137596p;
        r115.getPosTan(r115.getLength() * r112, r113, null);
        PathMeasure r116 = this.f137596p;
        float r117 = r112 + r100;
        r116.getPosTan(r117 * r116.getLength(), r114, null);
        RectF r105 = r104.f458058f;
        float r106 = r105.top;
        float r118 = r114[1] - r113[1];
        r105.top = r106 + r118;
        r105.bottom += r118;
        float r107 = r105.left;
        float r119 = r114[0] - r113[0];
        r105.left = r107 + r119;
        r105.right += r119;
        if (r117 <= 0.75f) goto L12;
        ((com.bytedance.android.livesdk.interactivity.like.barrage.a) r104).f137585t = (int) (((1.0f - r112) - r100) * 612.0f);
    L12:
        if (r117 < 0.2f) goto L17;
        com.bytedance.android.livesdk.interactivity.like.barrage.a r108 = (com.bytedance.android.livesdk.interactivity.like.barrage.a) r104;
        if (r108.f137584s <= 0.8f) goto L17;
        r108.f137584s = 0.8f;
    L19:
        if (r117 >= 1) goto L20;
        if (((com.bytedance.android.livesdk.interactivity.like.barrage.a) r104).f137585t == 0) goto L23;
        r102.set(Float.valueOf(r117));
        goto L3
    L23:
        r103.remove();
        r102.remove();
        goto L3
    L20:
        r103.remove();
        r102.remove();
    L17:
        ((com.bytedance.android.livesdk.interactivity.like.barrage.a) r104).f137584s = MathUtils.clamp((3.2f * r117) + 0.36f, 0.0f, 0.8f);
    L25:
        AbsBarrage r109 = g();
        if (r109 == null) goto L27;
        if ((r109 instanceof com.bytedance.android.livesdk.interactivity.like.barrage.a) == false) goto L25;
        float r120 = r109.f458058f.width();
        float r121 = r109.f458058f.height();
        RectF r122 = r109.f458058f;
        float[] r123 = this.f137594n;
        float r124 = r123[0];
        r122.left = r124;
        r122.right = r124 + r120;
        float r125 = r123[1];
        r122.top = r125;
        r122.bottom = r125 + r121;
        ((com.bytedance.android.livesdk.interactivity.like.barrage.a) r109).f137584s = 0.36f;
        r110.add(r109);
        this.f137595o.add(Float.valueOf(0.0f));
        goto L25
    }

    public d(BarrageLayout r100, Path r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "barrageView");
        Intrinsics.checkNotNullParameter(r101, "path");
        super(r100);
        this.f137597q = r102;
        float[] r103 = new float[2];
        this.f137594n = r103;
        this.f137595o = new ArrayList();
        PathMeasure r104 = new PathMeasure();
        r104.setPath(r101, false);
        r104.getPosTan(0.0f, r103, null);
        Unit r105 = Unit.INSTANCE;
        this.f137596p = r104;
    }
}
