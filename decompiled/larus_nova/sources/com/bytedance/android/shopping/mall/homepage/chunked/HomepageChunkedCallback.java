package com.bytedance.android.shopping.mall.homepage.chunked;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECTrackDataDTO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.api.mall.model.ChunkedSectionData;
import com.bytedance.android.shopping.api.mall.model.ChunkedTrackAndRec;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.l;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class HomepageChunkedCallback implements com.bytedance.android.ec.hybrid.data.utils.a.InterfaceC0820a<HomePageDTO> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f178071o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f178072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f178073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataEngineWrapper f178074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f178075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f178076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f178077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f178078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile HomePageDTO f178079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile HomePageDTO f178080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f178081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f178082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Map<String, String> f178083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile Map<String, String> f178084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f178085n;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<HomePageDTO> f178086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<HomePageDTO, Boolean, Unit> f178087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f178088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DataEngineWrapper f178089d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function0<ECHybridListEngine> f178090e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function4<String, ECHybridNetworkVO, String, HomePageDTO, Unit> f178091f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function1<HomePageDTO, Unit> f178092g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function3<String, Throwable, ECHybridNetworkVO, Unit> f178093h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<HomePageDTO, Unit> f178094i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L24;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f178086a, r101.f178086a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f178087b, r101.f178087b) == true) goto L10;
            return false;
        L10:
            if (this.f178088c == r101.f178088c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f178089d, r101.f178089d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f178090e, r101.f178090e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f178091f, r101.f178091f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f178092g, r101.f178092g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f178093h, r101.f178093h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f178094i, r101.f178094i) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public final int hashCode() {
            Function0<HomePageDTO> r100 = this.f178086a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Function2<HomePageDTO, Boolean, Unit> r104 = this.f178087b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f178088c;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            int r109 = (r106 + r108) * 31;
            DataEngineWrapper r110 = this.f178089d;
            if (r110 == null) goto L16;
            int r111 = r110.hashCode();
        L17:
            int r112 = (r109 + r111) * 31;
            Function0<ECHybridListEngine> r113 = this.f178090e;
            if (r113 == null) goto L20;
            int r114 = r113.hashCode();
        L21:
            int r115 = (r112 + r114) * 31;
            Function4<String, ECHybridNetworkVO, String, HomePageDTO, Unit> r116 = this.f178091f;
            if (r116 == null) goto L24;
            int r117 = r116.hashCode();
        L25:
            int r118 = (r115 + r117) * 31;
            Function1<HomePageDTO, Unit> r119 = this.f178092g;
            if (r119 == null) goto L28;
            int r120 = r119.hashCode();
        L29:
            int r121 = (r118 + r120) * 31;
            Function3<String, Throwable, ECHybridNetworkVO, Unit> r122 = this.f178093h;
            if (r122 == null) goto L32;
            int r123 = r122.hashCode();
        L33:
            int r124 = (r121 + r123) * 31;
            Function1<HomePageDTO, Unit> r125 = this.f178094i;
            if (r125 == null) goto L37;
            r101 = r125.hashCode();
        L37:
            return r124 + r101;
        L32:
            r123 = 0;
            goto L33
        L28:
            r120 = 0;
            goto L29
        L24:
            r117 = 0;
            goto L25
        L20:
            r114 = 0;
            goto L21
        L16:
            r111 = 0;
            goto L17
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(cacheDataGetter=" + this.f178086a + ", checkHeaderCardType=" + this.f178087b + ", notifyProcessor=" + this.f178088c + ", dataEngineWrapper=" + this.f178089d + ", listContainer=" + this.f178090e + ", onRenderBack=" + this.f178091f + ", onRequestSuccess=" + this.f178092g + ", onRequestError=" + this.f178093h + ", updateCache=" + this.f178094i + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<HomePageDTO> r100, Function2<? super HomePageDTO, ? super Boolean, Unit> r101, boolean r102, DataEngineWrapper r103, Function0<ECHybridListEngine> r104, Function4<? super String, ? super ECHybridNetworkVO, ? super String, ? super HomePageDTO, Unit> r105, Function1<? super HomePageDTO, Unit> r106, Function3<? super String, ? super Throwable, ? super ECHybridNetworkVO, Unit> r107, Function1<? super HomePageDTO, Unit> r110) {
            Intrinsics.checkNotNullParameter(r100, "cacheDataGetter");
            Intrinsics.checkNotNullParameter(r101, "checkHeaderCardType");
            Intrinsics.checkNotNullParameter(r104, "listContainer");
            Intrinsics.checkNotNullParameter(r105, "onRenderBack");
            Intrinsics.checkNotNullParameter(r106, "onRequestSuccess");
            Intrinsics.checkNotNullParameter(r107, "onRequestError");
            Intrinsics.checkNotNullParameter(r110, "updateCache");
            this.f178086a = r100;
            this.f178087b = r101;
            this.f178088c = r102;
            this.f178089d = r103;
            this.f178090e = r104;
            this.f178091f = r105;
            this.f178092g = r106;
            this.f178093h = r107;
            this.f178094i = r110;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f178095a;

        public c(Function0 r100) {
            this.f178095a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f178095a.invoke();     // Catch: Throwable -> L4
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

    public final void e() {
        if (this.f178081j != 1) goto L5;
    L8:
        f(new HomepageChunkedCallback$onFirstScreenSuccess$1(this));
    L9:
        this.f178082k = true;
        return;
    L5:
        if (this.f178081j != 2) goto L9;
        if (this.f178080i == null) goto L9;
        goto L8
    }

    public HomepageChunkedCallback(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f178085n = r100;
        this.f178072a = LazyKt.lazy(HomepageChunkedCallback$firstScreenImageOptEnable$2.INSTANCE);
        this.f178073b = LazyKt.lazy(HomepageChunkedCallback$ioDispatchOptEnable$2.INSTANCE);
        this.f178074c = r100.f178089d;
        this.f178075d = LazyKt.lazy(new HomepageChunkedCallback$_listContainer$2(this));
        this.f178076e = new AtomicInteger(0);
        this.f178077f = new Handler(Looper.getMainLooper());
        this.f178078g = new Object();
    }

    public final void f(Function0<Unit> r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f178077f.postAtFrontOfQueue(new c(r100));
    }

    public static final void d(HomepageChunkedCallback r110, boolean r111) {
        ECHybridListEngine r100 = (ECHybridListEngine) r110.f178075d.getValue();
        if (r100 == null) goto L81;
        k r101 = r100.f46872c.f46941g;
        if (r101 == null) goto L126;
        ArrayList<i> r102 = r101.f47130c;
        if (r102 == null) goto L127;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L128;
        i r104 = (i) r103.next();
        HomePageDTO r105 = r110.f178080i;
        if (r105 == null) goto L10;
        List<ChunkedSectionData> r106 = r105.getChunkDataList();
        if (r106 == null) goto L10;
        Iterator<T> r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((ChunkedSectionData) r108).getChunkSectionId(), r104.f47107a) == false) goto L17;
    L22:
        ChunkedSectionData r109 = (ChunkedSectionData) r108;
        if (r109 == null) goto L10;
        List<ChunkedTrackAndRec> r112 = r109.getChunkInfo();
        if (r112 == null) goto L10;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L29:
        if (r114.hasNext() == false) goto L36;
        Object r115 = r114.next();
        if (((ChunkedTrackAndRec) r115).getId() == null) goto L33;
        boolean r116 = true;
    L34:
        if (r116 == false) goto L29;
        r113.add(r115);
        goto L29
    L33:
        r116 = false;
        goto L34
    L36:
        LinkedHashMap r117 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r113, 10)), 16));
        Iterator r118 = r113.iterator();
    L38:
        if (r118.hasNext() == false) goto L41;
        Object r119 = r118.next();
        String r120 = ((ChunkedTrackAndRec) r119).getId();
        Intrinsics.checkNotNull(r120);
        r117.put(r120, r119);
        goto L38
    L41:
        if (Intrinsics.areEqual(r104.f47107a, "favorite_section") == false) goto L10;
        ArrayList<ECHybridListItemVO> r121 = r104.f47115i;
        if (r121 == null) goto L71;
        Iterator<T> r122 = r121.iterator();
    L46:
        if (r122.hasNext() == false) goto L71;
        ECHybridListItemVO r123 = (ECHybridListItemVO) r122.next();
        String r124 = r123.f47029d;
        if (r124 == null) goto L46;
        ChunkedTrackAndRec r125 = (ChunkedTrackAndRec) r117.get(r124);
        if (r125 == null) goto L46;
        ECTrackDataDTO r126 = r125.getTrackData();
        if (r126 == null) goto L56;
        ECTrackDataDTO.Companion.getClass();
        r123.f47041o = ECTrackDataDTO.a.b(r126, r123);
    L56:
        r123.q(r125.getRecommendInfo());
        String r127 = r123.f47029d;
        String r128 = r125.getRecommendInfo();
        if (r127 == null) goto L46;
        if (r128 == null) goto L46;
        ECHybridListEngine r129 = (ECHybridListEngine) r110.f178075d.getValue();
        if (r129 == null) goto L46;
        BaseViewHolder r130 = r129.e(r104.f47107a, r127);
        if (r130 == null) goto L46;
        n r131 = r123.f47041o;
        if (r131 == null) goto L66;
        HashMap<String, Object> r132 = r131.f47140b;
    L67:
        if (r131 == null) goto L69;
        String r133 = r131.f47146h;
    L70:
        r130.m4(new com.bytedance.android.ec.hybrid.list.entity.a(r128, r132, r133));
        goto L46
    L69:
        r133 = null;
        goto L70
    L66:
        r132 = null;
    L71:
        if (r111 == true) goto L10;
        ECHybridListEngine r134 = (ECHybridListEngine) r110.f178075d.getValue();
        if (r134 == null) goto L10;
        ECHybridRecyclerView r135 = r134.f46871b;
        if (r135 == null) goto L10;
        Iterator r136 = ((ArrayList) r135.K).iterator();
    L78:
        if (r136.hasNext() == false) goto L80;
        ((Runnable) r136.next()).run();
        goto L78
    L80:
        ((ArrayList) r135.K).clear();
        goto L10
    L21:
        r108 = null;
        goto L22
    L128:
        return;
    L127:
        return;
    L126:
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.data.utils.a.InterfaceC0820a
    public final void a(String r100, Object r101) {
        HomePageDTO r102 = (HomePageDTO) r101;
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        this.f178085n.f178092g.invoke(r102);
        if (r102 == null) goto L6;
        Single.fromCallable(new com.bytedance.android.shopping.mall.homepage.chunked.b(this, r102)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.data.utils.a.InterfaceC0820a
    public final void b(String r100, ECHybridNetworkVO r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r102, "error");
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r102, "error");
        this.f178085n.f178093h.invoke(r100, r102, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.data.utils.a.InterfaceC0820a
    public final void c(final String r100, final ECHybridNetworkVO r101, final String r102, HomePageDTO r110) {
        final HomePageDTO r103 = r110;
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r102, "chunkedResult");
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r102, "chunkedResult");
        this.f178085n.f178087b.invoke(r103, Boolean.FALSE);
        if (this.f178085n.f178088c == false) goto L11;
        if (r103 == null) goto L11;
        int r111 = l.f178531i;
        if (Intrinsics.areEqual(r103.getChunkedSection(), "rendering_data") == false) goto L11;
        com.bytedance.android.shopping.mall.homepage.chunked.a r112 = new com.bytedance.android.shopping.mall.homepage.chunked.a(this, r103);
        if (((Boolean) this.f178073b.getValue()).booleanValue() == false) goto L10;
        Schedulers.io().createWorker().schedule(r112);
        goto L11
    L10:
        r112.run();
    L11:
        final int r113 = this.f178076e.incrementAndGet();
        DataEngineWrapper r104 = this.f178074c;
        if (r104 == null) goto L14;
        r104.L(new HomepageChunkedCallback$updateFirstScreenMonitor$1(this, r113, r101, r103));
    L14:
        if (r103 == null) goto L16;
        String r114 = r103.getChunkedSection();
    L17:
        if (r114 == null) goto L91;
        int r105 = r114.hashCode();
        int r106 = 1;
        if (r105 == (-1727465091)) goto L65;
        if (r105 == 1738089522) goto L25;
        return;
    L25:
        if (r114.equals("tracking_data") == false) goto L86;
        this.f178080i = r103;
        Object r107 = this.f178078g;
        monitor-enter(r107);
    L61:
        th = move-exception;
        throw th;
    L29:
        if (this.f178084m != null) goto L31;
        this.f178084m = new LinkedHashMap();     // Catch: Throwable -> L61
    L31:
        List<ChunkedSectionData> r108 = r103.getChunkDataList();     // Catch: Throwable -> L61
        if (r108 == null) goto L55;
        Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L61
    L35:
        if (r109.hasNext() == false) goto L54;
        List<ChunkedTrackAndRec> r115 = ((ChunkedSectionData) r109.next()).getChunkInfo();     // Catch: Throwable -> L61
        if (r115 == null) goto L35;
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L61
        Iterator<T> r117 = r115.iterator();     // Catch: Throwable -> L61
    L40:
        if (r117.hasNext() == false) goto L47;
        Object r118 = r117.next();     // Catch: Throwable -> L61
        if (((ChunkedTrackAndRec) r118).getId() == null) goto L44;
        boolean r119 = true;
    L45:
        if (r119 == false) goto L40;
        r116.add(r118);     // Catch: Throwable -> L61
        goto L40
    L44:
        r119 = false;
        goto L45
    L47:
        LinkedHashMap r120 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r116, 10)), 16));     // Catch: Throwable -> L61
        Iterator r121 = r116.iterator();     // Catch: Throwable -> L61
    L49:
        if (r121.hasNext() == false) goto L51;
        ChunkedTrackAndRec r122 = (ChunkedTrackAndRec) r121.next();     // Catch: Throwable -> L61
        String r123 = r122.getId();     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r123);     // Catch: Throwable -> L61
        Pair r124 = TuplesKt.to(r123, r122.getRecommendInfo());     // Catch: Throwable -> L61
        r120.put(r124.getFirst(), r124.getSecond());     // Catch: Throwable -> L61
        goto L49
    L51:
        Map<String, String> r125 = this.f178084m;     // Catch: Throwable -> L61
        if (r125 == null) goto L35;
        r125.putAll(r120);     // Catch: Throwable -> L61
        goto L35
    L54:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L61
    L55:
        monitor-exit(r107);
        if (this.f178079h != null) goto L59;
        return;
    L59:
        if (this.f178082k == false) goto L88;
        f(new HomepageChunkedCallback$onTrackBack$1(this));
        return;
    L88:
        return;
    L86:
        return;
    L65:
        if (r114.equals("rendering_data") == false) goto L90;
        this.f178079h = r103;
        if (this.f178080i == null) goto L69;
        int r127 = l.f178531i;
        l.a.a(r103, this.f178080i);
        r106 = 2;
    L69:
        this.f178081j = r106;
        f(new HomepageChunkedCallback$onRenderBack$1(this, r100, r101, r102, r103));
        return;
    L90:
        return;
    L91:
        return;
    L16:
        r114 = null;
        goto L17
    }
}
