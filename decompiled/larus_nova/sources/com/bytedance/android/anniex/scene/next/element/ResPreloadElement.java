package com.bytedance.android.anniex.scene.next.element;

import android.net.Uri;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.handler.idle.b;
import com.bytedance.android.anniex.scene.handler.idle.c;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.o;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.f;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ResPreloadElement implements wa.a<xa.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41276a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ResPreloadElement$Companion$preloadUrlMap$1 f41277b = null;

    public static final class a {
    }

    public ResPreloadElement() {
    }

    static {
        int r100 = ((Number) SwitchCenter.f41303d0.getValue()).intValue();
        f41276a = r100;
        f41277b = new ResPreloadElement$Companion$preloadUrlMap$1(r100);
    }

    public static final void b(ResPreloadElement r110, HashSet r111) {
        r110.getClass();
        Iterator r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L15;
        final String r100 = (String) r112.next();
        Uri r113 = UriProtector.parse(r100);
        if (Intrinsics.areEqual(r113.getScheme(), "http") == false) goto L8;
    L11:
        boolean r114 = GeckoXAdapter.Companion.canParsed(r113);
    L12:
        if (r114 == true) goto L13;
        HybridLogger r115 = HybridLogger.f246343a;
        HybridLogger.f("PredictManager", "forest can not parsed url:" + r100, null, 12);
        goto L4
    L13:
        f41277b.put(r100, Boolean.TRUE);
        f<String, o> r116 = ForestLoader.f246728a;
        ForestLoader.f(null, r100, TrafficMetrics.FRPM_TTNET, Scene.LYNX_TEMPLATE, null, null, true, null, new ResPreloadElement$forestPreloadUrls$1$1(r100), 161);
        goto L4
    L8:
        if (Intrinsics.areEqual(r113.getScheme(), "https") == true) goto L11;
        r114 = true;
        goto L12
    }

    public static final void c(ResPreloadElement r100, HashSet r101) {
        r100.getClass();
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        String r103 = (String) r102.next();
        Uri r104 = UriProtector.parse(r103);     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r104.getScheme(), "http") == true) goto L12;
        if (Intrinsics.areEqual(r104.getScheme(), "https") == true) goto L12;
        HybridLogger r105 = HybridLogger.f246343a;     // Catch: Exception -> L14
        HybridLogger.f("PredictManager", "Skipping non-HTTP/HTTPS URL: " + r103, null, 12);     // Catch: Exception -> L14
    L12:
        String r106 = r104.getScheme() + "://" + r104.getHost();     // Catch: Exception -> L14
        vq7.a.a(r106);     // Catch: Exception -> L14
        HybridLogger r107 = HybridLogger.f246343a;     // Catch: Exception -> L14
        HybridLogger.f("PredictManager", "Preconnect to domain: " + r106, null, 12);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        HybridLogger r108 = HybridLogger.f246343a;
        HybridLogger.i("PredictManager", "Error processing URL for preconnect: " + r103 + ", error: " + e.getMessage(), null, 12);
        goto L4
    }

    public static final Pair d(ResPreloadElement r100, List r101) {
        r100.getClass();
        HashSet r102 = new HashSet();
        HashSet r103 = new HashSet();
        int r104 = ((Number) SwitchCenter.f41307f0.getValue()).intValue();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L3:
        boolean r107 = false;
        if (r106.hasNext() == false) goto L10;
        Object r108 = r106.next();
        if (((xa.a) r108).f563020b.size() > r104) goto L8;
        r107 = true;
    L8:
        if (r107 == false) goto L3;
        r105.add(r108);
        goto L3
    L10:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r105.iterator();
    L12:
        if (r110.hasNext() == false) goto L14;
        CollectionsKt.addAll(r109, ((xa.a) r110.next()).f563020b);
        goto L12
    L14:
        Iterator r111 = r109.iterator();
    L16:
        if (r111.hasNext() == false) goto L22;
        String r112 = (String) r111.next();
        if (StringsKt.endsWith$default(r112, ".html", false, 2, null) == true) goto L19;
        r102.add(r112);
        goto L16
    L19:
        r103.add(r112);
        goto L16
    L22:
        return new Pair(r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wa.a
    public final b a(String r100, final List r101) {
        Intrinsics.checkNotNullParameter(r100, "currentSceneId");
        Intrinsics.checkNotNullParameter(r101, "input");
        if (((ArrayList) r101).isEmpty() == false) goto L6;
        return null;
    L6:
        c.a r102 = new c.a();
        Intrinsics.checkNotNullParameter(r100, "group");
        r102.f41207a = r100;
        r102.f41209c = 100;
        r102.f41210d = 10000;
        r102.f41211e = 0;
        r102.f41212f = false;
        r102.f41213g = r101;
        Intrinsics.checkNotNullParameter("view_pre_create", "tag");
        r102.f41208b = "view_pre_create";
        Function1<List<? extends xa.a>, Unit> r103 = new ResPreloadElement$createTaskForPrediction$1(this, r101);
        Intrinsics.checkNotNullParameter(r103, "r");
        r102.f41214h = r103;
        return r102.a(TaskType.NEXT_THRESHOLD_PREDICT);
    }
}
