package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.marquee.ECStoreTopMultiMarqueeItemVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f183739g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.bytedance.android.ec.store.repository.vo.i> f183740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f183741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f183742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ij3.b f183743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECStoreTopMultiMarqueeItemVO f183744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Blcok f183745f;

    public static final class a {
        public static l a(ECStoreHomeActivityResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            l r101 = new l();
            ECStoreDynamicModule r102 = r100.getDynamicModule();
            ECStoreTopMultiMarqueeItemVO r103 = null;
            if (r102 == null) goto L10;
            List<com.bytedance.android.ec.store.repository.dto.d> r104 = r102.getComponents();
            if (r104 == null) goto L10;
            List<com.bytedance.android.ec.store.repository.dto.d> r105 = r104;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L8:
            if (r107.hasNext() == false) goto L11;
            com.bytedance.android.ec.store.repository.dto.d r108 = (com.bytedance.android.ec.store.repository.dto.d) r107.next();
            int r109 = com.bytedance.android.ec.store.repository.vo.i.f48459a;
            r106.add(com.bytedance.android.ec.store.repository.vo.i.a.a(r108));
        L11:
            r101.f183740a = r106;
            r101.f183741b = r100.getExtraSchema();
            r101.f183742c = r100.getFloatSchema();
            int r110 = ij3.b.f490055b;
            List<ij3.a> r111 = r100.getMarqueeBubble();
            if (r111 != null) goto L14;
            ij3.b r112 = null;
        L19:
            r101.f183743d = r112;
            int r113 = ECStoreTopMultiMarqueeItemVO.f185616b;
            List<ij3.c> r114 = r100.getMultiMarqueeBubble();
            if (r114 == null) goto L27;
            ArrayList r115 = new ArrayList();
            Iterator<T> r116 = r114.iterator();
        L24:
            if (r116.hasNext() == false) goto L26;
            ij3.c r117 = (ij3.c) r116.next();
            r115.add(new ECStoreTopMultiMarqueeItemVO.b(r117.c(), r117.d(), r117.a(), r117.b()));
            goto L24
        L26:
            r103 = new ECStoreTopMultiMarqueeItemVO(r115);
        L27:
            r101.f183744e = r103;
            r101.f183745f = r100.getBlock();
            return r101;
        L14:
            ArrayList r118 = new ArrayList();
            Iterator<T> r119 = r111.iterator();
        L16:
            if (r119.hasNext() == false) goto L18;
            ij3.a r120 = (ij3.a) r119.next();
            r118.add(new ij3.b.C6274b(r120.c(), r120.d(), r120.a(), r120.b()));
            goto L16
        L18:
            r112 = new ij3.b(r118);
        L10:
            r106 = null;
            goto L11
        }
    }

    static {
    }

    public l() {
    }
}
