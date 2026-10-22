package com.bytedance.android.live.profit.dress;

import com.bytedance.android.livedress.impl.PbDecodeService;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class DressLocalDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, p> f87067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d> f87068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Map<String, d>> f87069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<byte[], String> f87070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f87071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f87072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f87073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f87074h;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DressLocalDataSource f87075a;

        public a(DressLocalDataSource r100) {
            this.f87075a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            List r111 = (List) r110;
            DressLocalDataSource r100 = this.f87075a;
            r100.getClass();
            com.bytedance.live.kmp.util.c r101 = com.bytedance.live.kmp.util.c.f255167a;
            long r102 = System.currentTimeMillis();
            String r103 = (String) r100.f87072f.getValue();
            if (r103 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == true) goto L60;
            String r105 = (String) r100.f87074h.getValue();
            if (r105 != null) goto L13;
        L16:
            boolean r106 = true;
        L17:
            if (r106 == true) goto L61;
            Iterator r112 = r111.iterator();
        L21:
            if (r112.hasNext() == false) goto L44;
            p r107 = (p) r112.next();
            String r108 = r107.getDecoded().getDressId();
            if (r108.length() != 0) goto L25;
            boolean r109 = true;
        L26:
            if (r109 == true) goto L21;
            byte[] r113 = r107.getPbBytes();
            if (r113 == null) goto L21;
            if (((LinkedHashMap) r100.f87070d).get(r113) != null) goto L32;
            PbDecodeService r114 = PbDecodeService.f102885b;
            String r115 = (String) r100.f87072f.getValue();
            Intrinsics.checkNotNull(r115);
            String r116 = (String) r100.f87074h.getValue();
            Intrinsics.checkNotNull(r116);
            r114.getClass();
            com.bytedance.android.livedress.impl.a r117 = PbDecodeService.a(r113, r115, r116);
            if (r117.f102886a == false) goto L21;
            String r118 = r117.f102887b;
            if (r118 != null) goto L38;
        L41:
            boolean r119 = true;
        L42:
            if (r119 == true) goto L21;
            r100.f87070d.put(r113, r117.f102887b);
            goto L21
        L38:
            if (r118.length() == 0) goto L41;
            r119 = false;
            goto L42
        L32:
            jy0.b.a("DressRepository", "preParsePbData. 已解析 return dressId: ".concat(r108));
            goto L21
        L25:
            r109 = false;
            goto L26
        L44:
            StringBuilder r120 = new StringBuilder("preParsePbData cost: ");
            com.bytedance.live.kmp.util.c r121 = com.bytedance.live.kmp.util.c.f255167a;
            r120.append(System.currentTimeMillis() - r102);
            jy0.b.a("DressRepository", r120.toString());
            return;
        L61:
            return;
        L13:
            if (r105.length() == 0) goto L16;
            r106 = false;
            goto L17
        L60:
            return;
        L5:
            if (r103.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f87076a = null;

        static {
            f87076a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            jy0.b.c("DressRepository", "Error in preParsePbData: " + ((Throwable) r100).getMessage(), null, 4);
        }
    }

    public DressLocalDataSource() {
        this.f87067a = new LinkedHashMap();
        this.f87068b = new LinkedHashMap();
        this.f87069c = new LinkedHashMap();
        this.f87070d = new LinkedHashMap();
        this.f87071e = LazyKt.lazy(DressLocalDataSource$dressList$2.INSTANCE);
        this.f87072f = LazyKt.lazy(DressLocalDataSource$dressConfigIDL$2.INSTANCE);
        this.f87073g = LazyKt.lazy(DressLocalDataSource$dressConfigIDLVersion$2.INSTANCE);
        this.f87074h = LazyKt.lazy(DressLocalDataSource$definitionName$2.INSTANCE);
    }

    public final void a(List<? extends p> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ArrayList r101 = new ArrayList();
        Iterator<? extends p> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L26;
        p r103 = r102.next();
        o r104 = r103.getDecoded();
        String r105 = r104.getDressId();
        int r106 = r104.getDressType();
        if (r105.length() <= 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L4;
        this.f87067a.put(r105, r103);
        d r108 = c.a(r104);
        if (((List) this.f87071e.getValue()) == null) goto L19;
        List r109 = (List) this.f87071e.getValue();
        Intrinsics.checkNotNull(r109);
        if (r109.contains(r105) == false) goto L19;
        if (r104.getDressType() != 1) goto L17;
    L18:
        r101.add(r103);
        goto L19
    L17:
        if (r104.getDressType() == 2) goto L18;
    L19:
        this.f87068b.put(r105, r108);
        if (this.f87069c.containsKey(Integer.valueOf(r106)) == true) goto L22;
        this.f87069c.put(Integer.valueOf(r106), new LinkedHashMap());
    L22:
        Map<Integer, Map<String, d>> r110 = this.f87069c;
        LinkedHashMap r111 = (LinkedHashMap) r110;
        Map r112 = (Map) r111.get(Integer.valueOf(r106));
        if (r112 == null) goto L4;
        d r113 = (d) r112.put(r105, r108);
        goto L4
    L8:
        r107 = false;
        goto L9
    L26:
        if (r101.size() <= 0) goto L36;
        int r114 = com.bytedance.revenue.platform.api.core.rx.q.f267523a;
        Single r115 = Single.just(r101);
        int r116 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        r115.subscribeOn(Schedulers.io()).subscribe(new a(this), b.f87076a);
        return;
    }
}
