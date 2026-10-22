package com.bytedance.android.live.revlink.link.streaminteract.biz;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.pk.mixer.mapping.LayoutMode;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class StreamMixDescriptor implements k41.a<String> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f98749i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, RectF> f98750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f98751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f98752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f98753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, t51.b> f98754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, t51.b> f98755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IConfig.e f98756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f98757h;

    public static final class a {
        public static k41.b a(StreamMixDescriptor r100, IConfig.e r101) {
            Intrinsics.checkNotNullParameter(r100, "descriptor");
            IConfig.e.f157388f1.getClass();
            float r102 = 1.0f;
            if (Intrinsics.areEqual(r101, IConfig.e.a.f157395g) == false) goto L5;
        L15:
            k41.c r103 = new k41.c(r100);
            r103.f501738a = true;
            int r104 = StreamMixDescriptor.f98749i;
            if (r101 == null) goto L18;
            float r105 = r101.getWidth();
        L19:
            if (r101 == null) goto L21;
            r102 = r101.getHeight();
        L21:
            r103.f501739b = Float.valueOf(r105 / r102);
            LayoutMode[] r106 = {LayoutMode.Center};
            Intrinsics.checkNotNullParameter(r106, "layoutMode");
            r103.f501740c = r106;
            return r103.a();
        L18:
            r105 = 1.0f;
            goto L19
        L5:
            if (Intrinsics.areEqual(r101, IConfig.e.a.f157394f) == true) goto L15;
            k41.c r107 = new k41.c(r100);
            r107.f501738a = false;
            int r108 = StreamMixDescriptor.f98749i;
            if (r101 == null) goto L10;
            float r109 = r101.getWidth();
        L11:
            if (r101 == null) goto L13;
            r102 = r101.getHeight();
        L13:
            r107.f501739b = Float.valueOf(r109 / r102);
            LayoutMode[] r110 = {LayoutMode.CenterHorizontal};
            Intrinsics.checkNotNullParameter(r110, "layoutMode");
            r107.f501740c = r110;
            r107.f501741d = r100.f98751b;
            return r107.a();
        L10:
            r109 = 1.0f;
            goto L11
        }
    }

    static {
    }

    public final List<RectF> d() {
        return (List) this.f98753d.getValue();
    }

    @Override // k41.a
    public final float a() {
        return (f() + h()) + 0.0f;
    }

    @Override // k41.a
    public final float c() {
        return (g() + e()) + 0.0f;
    }

    public final float e() {
        if (d().isEmpty() == false) goto L5;
        return 0.0f;
    L5:
        Iterator<T> r100 = d().iterator();
        if (r100.hasNext() == false) goto L22;
        float r101 = ((RectF) r100.next()).bottom;
    L9:
        if (r100.hasNext() == false) goto L11;
        r101 = Math.max(r101, ((RectF) r100.next()).bottom);
        goto L9
    L11:
        Iterator<T> r102 = d().iterator();
        if (r102.hasNext() == false) goto L20;
        float r103 = ((RectF) r102.next()).top;
    L15:
        if (r102.hasNext() == false) goto L18;
        r103 = Math.min(r103, ((RectF) r102.next()).top);
        goto L15
    L18:
        return r101 - r103;
    L20:
        throw new NoSuchElementException();
    L22:
        throw new NoSuchElementException();
    }

    public final float f() {
        Iterator<T> r100 = d().iterator();
        if (r100.hasNext() == true) goto L5;
        Float r101 = null;
    L10:
        if (r101 != null) goto L15;
        return 0.0f;
    L15:
        return r101.floatValue();
    L5:
        float r102 = ((RectF) r100.next()).left;
    L7:
        if (r100.hasNext() == false) goto L9;
        r102 = Math.min(r102, ((RectF) r100.next()).left);
        goto L7
    L9:
        r101 = Float.valueOf(r102);
        goto L10
    }

    public final float g() {
        Iterator<T> r100 = d().iterator();
        if (r100.hasNext() == true) goto L5;
        Float r101 = null;
    L10:
        if (r101 != null) goto L15;
        return 0.0f;
    L15:
        return r101.floatValue();
    L5:
        float r102 = ((RectF) r100.next()).top;
    L7:
        if (r100.hasNext() == false) goto L9;
        r102 = Math.min(r102, ((RectF) r100.next()).top);
        goto L7
    L9:
        r101 = Float.valueOf(r102);
        goto L10
    }

    public final float h() {
        if (d().isEmpty() == false) goto L5;
        return 0.0f;
    L5:
        Iterator<T> r100 = d().iterator();
        if (r100.hasNext() == false) goto L22;
        float r101 = ((RectF) r100.next()).right;
    L9:
        if (r100.hasNext() == false) goto L11;
        r101 = Math.max(r101, ((RectF) r100.next()).right);
        goto L9
    L11:
        Iterator<T> r102 = d().iterator();
        if (r102.hasNext() == false) goto L20;
        float r103 = ((RectF) r102.next()).left;
    L15:
        if (r102.hasNext() == false) goto L18;
        r103 = Math.min(r103, ((RectF) r102.next()).left);
        goto L15
    L18:
        return r101 - r103;
    L20:
        throw new NoSuchElementException();
    L22:
        throw new NoSuchElementException();
    }

    @Override // k41.a
    public final RectF b(String r100) {
        LinkedHashMap r101 = (LinkedHashMap) this.f98750a;
        return (RectF) r101.get(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreamMixDescriptor(Map<String, ? extends t51.b> r100, Map<String, ? extends t51.b> r101, IConfig.e r102, t51.c r110, float r111) {
        Intrinsics.checkNotNullParameter(r100, "mixStreamRegionMap");
        Intrinsics.checkNotNullParameter(r101, "audienceMixStreamRegionMap");
        Intrinsics.checkNotNullParameter(r110, "canvasTransform");
        this.f98754e = r100;
        this.f98755f = r101;
        this.f98756g = r102;
        this.f98757h = r111;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r100);
        r103.putAll(r101);
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
        Iterator r105 = r103.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        Object r112 = r106.getKey();
        t51.b r107 = (t51.b) r106.getValue();
        r104.put(r112, new RectF(r107.e(), r107.f(), r107.e() + r107.d(), r107.f() + r107.a()));
        goto L4
    L6:
        List r108 = CollectionsKt.toList(r104.values());
        Iterator r109 = r108.iterator();
        if (r109.hasNext() == false) goto L43;
        float r113 = ((RectF) r109.next()).left;
    L10:
        if (r109.hasNext() == false) goto L12;
        r113 = Math.min(r113, ((RectF) r109.next()).left);
        goto L10
    L12:
        Iterator r114 = r108.iterator();
        if (r114.hasNext() == false) goto L41;
        float r115 = ((RectF) r114.next()).top;
    L16:
        if (r114.hasNext() == false) goto L18;
        r115 = Math.min(r115, ((RectF) r114.next()).top);
        goto L16
    L18:
        Iterator r116 = r108.iterator();
        if (r116.hasNext() == false) goto L39;
        float r117 = ((RectF) r116.next()).right;
    L22:
        if (r116.hasNext() == false) goto L24;
        r117 = Math.max(r117, ((RectF) r116.next()).right);
        goto L22
    L24:
        Iterator r118 = r108.iterator();
        if (r118.hasNext() == false) goto L37;
        float r119 = ((RectF) r118.next()).bottom;
    L28:
        if (r118.hasNext() == false) goto L30;
        r119 = Math.max(r119, ((RectF) r118.next()).bottom);
        goto L28
    L30:
        RectF r120 = new RectF(r113, r115, r117, r119);
        this.f98751b = r115;
        this.f98752c = r113;
        LinkedHashMap r121 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator r122 = r104.entrySet().iterator();
    L32:
        if (r122.hasNext() == false) goto L34;
        Map.Entry r123 = (Map.Entry) r122.next();
        r121.put(r123.getKey(), new RectF(((RectF) r123.getValue()).left - r120.left, (((RectF) r123.getValue()).top - r120.top) / this.f98757h, (((RectF) r123.getValue()).left - r120.left) + ((RectF) r123.getValue()).width(), ((((RectF) r123.getValue()).top - r120.top) + ((RectF) r123.getValue()).height()) / this.f98757h));
        goto L32
    L34:
        this.f98750a = r121;
        this.f98753d = LazyKt.lazy(new StreamMixDescriptor$grids$2(this));
        return;
    L37:
        throw new NoSuchElementException();
    L39:
        throw new NoSuchElementException();
    L41:
        throw new NoSuchElementException();
    L43:
        throw new NoSuchElementException();
    }
}
