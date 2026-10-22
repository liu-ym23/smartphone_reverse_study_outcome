package com.bytedance.android.live.effect;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f68060a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<ILiveEffectComposerManager.EffectInstanceType, String[]> f68061a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f68061a, ((a) r100).f68061a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Map<ILiveEffectComposerManager.EffectInstanceType, String[]> r100 = this.f68061a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "GetPathResult(pathMap=" + this.f68061a + ")";
        }

        public a(Map<ILiveEffectComposerManager.EffectInstanceType, String[]> r100) {
            Intrinsics.checkNotNullParameter(r100, "pathMap");
            this.f68061a = r100;
        }
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.android.live.effect.composer.n) r100).f67977g), Long.valueOf(((com.bytedance.android.live.effect.composer.n) r101).f67977g));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.android.live.effect.composer.n) r100).f67977g), Long.valueOf(((com.bytedance.android.live.effect.composer.n) r101).f67977g));
        }
    }

    static {
    }

    public static List f(List r100) {
        Intrinsics.checkNotNullParameter(r100, "composerNodeList");
        ArrayList r101 = new ArrayList();
        r101.addAll(r100);
        if (r101.size() <= 1) goto L5;
        CollectionsKt.sortWith(r101, new c());
    L5:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((com.bytedance.android.live.effect.composer.n) r104).f67980j == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        return r102;
    }

    @JvmStatic
    public static final int a(Sticker.ComposerConfig r100, float r101) {
        if (r101 != 0.0f) goto L5;
        return 0;
    L5:
        if (r100 == null) goto L7;
        int r102 = r100.getMaxValue();
        int r103 = r100.getMinValue();
    L8:
        if (r103 >= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
        float r105 = r101 * 10000;
        float r106 = r102 - r103;
    L19:
        return (int) (r105 / r106);
    L13:
        if (r101 <= 0) goto L15;
        float r107 = 5000 / r102;
    L16:
        r105 = r101 * r107;
        r106 = 2;
        goto L19
    L15:
        r107 = (-5000) / r103;
        goto L16
    L10:
        r104 = false;
        goto L11
    L7:
        r102 = 100;
        r103 = 0;
        goto L8
    }

    @JvmStatic
    public static final int b(Sticker r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        return a(r100.getSmallItemConfig(), r101);
    }

    @JvmStatic
    public static final float c(Sticker.ComposerConfig r100, int r101) {
        if (r101 != 0) goto L5;
        return 0.0f;
    L5:
        boolean r102 = false;
        if (r100 == null) goto L8;
        int r103 = r100.getMaxValue();
        int r104 = r100.getMinValue();
    L9:
        if (r104 >= 0) goto L12;
        r102 = true;
    L12:
        if (r102 == false) goto L19;
        if (r101 <= 0) goto L16;
        double r105 = ((double) r103) * 1.0d;
        double r106 = 5000.0d;
    L20:
        return (float) (((r105 / r106) * ((double) r101)) * ((double) 2));
    L16:
        r105 = ((double) r104) * 1.0d;
        r106 = -5000.0d;
        goto L20
    L19:
        return (float) (((((double) (r103 - r104)) * 1.0d) / 10000.0d) * ((double) r101));
    L8:
        r103 = 100;
        r104 = 0;
        goto L9
    }

    @JvmStatic
    public static final float d(Sticker r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        return c(r100.getSmallItemConfig(), r101);
    }

    public static a e(List r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "composerNodeList");
        ArrayList r100 = new ArrayList();
        r100.addAll(r110);
        if (r100.size() <= 1) goto L5;
        CollectionsKt.sortWith(r100, new b());
    L5:
        Map r112 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveEffectComposerManager.EffectInstanceType.DEFAULT, new ArrayList()), TuplesKt.to(ILiveEffectComposerManager.EffectInstanceType.RENDER_FILTER, new ArrayList())});
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((com.bytedance.android.live.effect.composer.n) r103).f67980j == false) goto L7;
        r101.add(r103);
        goto L7
    L11:
        Iterator r104 = r101.iterator();
    L13:
        if (r104.hasNext() == false) goto L56;
        com.bytedance.android.live.effect.composer.n r105 = (com.bytedance.android.live.effect.composer.n) r104.next();
        ArrayList r106 = (ArrayList) r112.get(r105.f67982l);
        Iterator<T> r107 = r105.f67979i.iterator();
    L16:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        com.bytedance.android.live.effect.composer.p r109 = (com.bytedance.android.live.effect.composer.p) r108;
        if (r111 == false) goto L20;
    L23:
        boolean r113 = true;
    L24:
        if (r113 == false) goto L16;
    L27:
        if (r108 == null) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == true) goto L33;
        if (r106 == null) goto L54;
        r106.add(r105.f67974d);
    L54:
        if (r106 == null) goto L13;
        r112.put(r105.f67982l, r106);
        goto L13
    L33:
        List<com.bytedance.android.live.effect.composer.p> r115 = r105.f67979i;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L35:
        if (r117.hasNext() == false) goto L45;
        Object r118 = r117.next();
        com.bytedance.android.live.effect.composer.p r119 = (com.bytedance.android.live.effect.composer.p) r118;
        if (r111 == false) goto L39;
    L42:
        boolean r120 = true;
    L43:
        if (r120 == false) goto L35;
        r116.add(r118);
        goto L35
    L39:
        if (r119.f67983a != null) goto L42;
        r120 = false;
        goto L43
    L45:
        Iterator r121 = r116.iterator();
    L47:
        if (r121.hasNext() == false) goto L54;
        com.bytedance.android.live.effect.composer.p r122 = (com.bytedance.android.live.effect.composer.p) r121.next();
        if (r111 == true) goto L50;
        if (r106 == null) goto L47;
        r106.add(r105.f67974d + ':' + r122.f67984b + ':' + r122.f67983a);
        goto L47
    L50:
        if (r106 == null) goto L47;
        r106.add(r105.f67974d + ':' + r122.f67984b + ":0");
        goto L47
    L29:
        r114 = false;
        goto L30
    L20:
        if (r109.f67983a != null) goto L23;
        r113 = false;
        goto L24
    L26:
        r108 = null;
        goto L27
    L56:
        LinkedHashMap r123 = new LinkedHashMap();
        Iterator r124 = r112.entrySet().iterator();
    L58:
        if (r124.hasNext() == false) goto L65;
        Map.Entry r125 = (Map.Entry) r124.next();
        Object r126 = r125.getKey();
        Object[] r127 = ((Collection) r125.getValue()).toArray(new String[0]);
        if (r127 == null) goto L63;
        r123.put(r126, r127);
        goto L58
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L65:
        return new a(r123);
    }
}
