package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreTabAreaVO {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f183632f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECStoreHomeTabResponseTabkit f183633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<uj3.j> f183634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f183635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f183636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f183637e;

    public static final class a {
        public static ECStoreTabAreaVO a(ECStoreHomeTabResponseTabkit r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            ECStoreTabAreaVO r101 = new ECStoreTabAreaVO();
            r101.f183633a = r100;
            if (r100 == null) goto L23;
            com.bytedance.android.shopping.store.tabkit.model.z r102 = r100.getTabkitResponse();
            if (r102 == null) goto L23;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r103 = r102.j();
            if (r103 == null) goto L23;
            Iterator<T> r104 = r103.iterator();
        L10:
            if (r104.hasNext() == false) goto L23;
            com.bytedance.android.shopping.store.tabkit.model.k r105 = (com.bytedance.android.shopping.store.tabkit.model.k) r104.next();
            ECShopABSettings.f186148k.getClass();
            if (ECShopABSettings.f() == true) goto L13;
            String r106 = r105.b();
            if (r106 == null) goto L10;
            Object r107 = new Gson().fromJson(r106, b.class);     // Catch: Exception -> L21
        L22:
            b r108 = (b) r107;
        L21:
            r107 = null;
            goto L22
        L13:
            if (r105 == null) goto L16;
            a0 r109 = (a0) r105;
            goto L10
        L16:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.home.entity.StoreTab");
        L23:
            com.bytedance.android.shopping.store.tabkit.model.z r110 = r100.getTabkitResponse();
            if (r110 == null) goto L26;
            Integer r111 = r110.a();
        L27:
            r101.f183635c = r111;
            com.bytedance.android.shopping.store.tabkit.model.z r112 = r100.getTabkitResponse();
            if (r112 == null) goto L39;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r113 = r112.j();
            if (r113 == null) goto L39;
            List<com.bytedance.android.shopping.store.tabkit.model.k> r114 = r113;
            ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
            Iterator<T> r116 = r114.iterator();
        L33:
            if (r116.hasNext() == false) goto L40;
            com.bytedance.android.shopping.store.tabkit.model.k r117 = (com.bytedance.android.shopping.store.tabkit.model.k) r116.next();
            int r118 = r.f183764a;
            com.bytedance.android.shopping.store.tabkit.model.z r119 = r100.getTabkitResponse();
            if (r119 == null) goto L37;
            Integer r120 = r119.a();
        L38:
            r115.add(r.a(r117, r120));
            goto L33
        L37:
            r120 = null;
        L40:
            r101.f183634b = r115;
            Map<String, String> r121 = r100.getLogExtra();
            if (r121 == null) goto L43;
            String r122 = r121.get(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID);
        L44:
            r101.f183636d = r122;
            r101.f183637e = r100.getPerfLogExtra();
            List<uj3.j> r123 = r101.f183634b;
            if (r123 != null) goto L47;
        L50:
            boolean r124 = true;
        L51:
            if (r124 == true) goto L68;
            List<uj3.j> r125 = r101.f183634b;
            if (r125 == null) goto L68;
            Iterator<T> r126 = r125.iterator();
        L57:
            if (r126.hasNext() == false) goto L68;
            uj3.j r127 = (uj3.j) r126.next();
            r127.A = null;
            List<uj3.j> r128 = r127.f550298b;
            if (r128 == null) goto L57;
            Iterator<T> r129 = r128.iterator();
        L62:
            if (r129.hasNext() == false) goto L57;
            uj3.j r130 = (uj3.j) r129.next();
            r130.f550297a = r127;
            r130.A = null;
            String r131 = r127.b();
            String r132 = r130.b();
            if ((!StringsKt.isBlank(r131)) == false) goto L62;
            if ((!StringsKt.isBlank(r132)) == false) goto L62;
            r130.A = r131 + '_' + r132;
        L68:
            return r101;
        L47:
            if (r123.isEmpty() == true) goto L50;
            r124 = false;
            goto L51
        L43:
            r122 = null;
        L39:
            r115 = null;
            goto L40
        L26:
            r111 = null;
            goto L27
        }
    }

    static {
    }

    public ECStoreTabAreaVO() {
    }

    public final boolean b() {
        List<uj3.j> r100 = this.f183634b;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        uj3.j r101 = a(r100, ECStoreTabAreaVO$hasProductMarquee$productTab$1.INSTANCE);
        if (r101 == null) goto L51;
        com.bytedance.android.ec.hybrid.list.entity.k r102 = r101.I;
        Object r103 = null;
        if (r102 == null) goto L19;
        ArrayList<com.bytedance.android.ec.hybrid.list.entity.i> r104 = r102.f47130c;
        if (r104 == null) goto L19;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r106).f47107a, "__PRODUCTS_SECTION__") == false) goto L13;
    L18:
        com.bytedance.android.ec.hybrid.list.entity.i r107 = (com.bytedance.android.ec.hybrid.list.entity.i) r106;
    L21:
        if (r107 == null) goto L44;
        ArrayList<ECHybridListItemVO> r108 = r107.f47115i;
        if (r108 == null) goto L44;
        ECHybridListItemVO r109 = (ECHybridListItemVO) CollectionsKt.getOrNull(r108, 0);
        if (r109 == null) goto L44;
        Map<String, Object> r110 = r109.V;
        if (r110 == null) goto L29;
        Object r111 = r110.get("slice_item_states");
    L31:
        if ((r111 instanceof Map) == true) goto L33;
        r111 = null;
    L33:
        Map r112 = (Map) r111;
        if (r112 == null) goto L36;
        Object r113 = r112.get("product_undertake");
    L38:
        if ((r113 instanceof Boolean) == false) goto L42;
        r103 = r113;
    L42:
        if (Intrinsics.areEqual((Boolean) r103, Boolean.TRUE) != true) goto L44;
        boolean r114 = true;
    L45:
        if (r114 != true) goto L52;
        return true;
    L52:
        return false;
    L36:
        r113 = null;
        goto L38
    L29:
        r111 = null;
    L44:
        r114 = false;
        goto L45
    L17:
        r106 = null;
    L19:
        r107 = null;
        goto L21
    L51:
        return false;
    }

    public static uj3.j a(List r100, Function1 r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        uj3.j r103 = (uj3.j) r102.next();
        if (((Boolean) r101.invoke(r103)).booleanValue() == true) goto L7;
        List<uj3.j> r104 = r103.f550298b;
        if (r104 != null) goto L11;
        r104 = CollectionsKt.emptyList();
    L11:
        uj3.j r105 = a(r104, r101);
        if (r105 == null) goto L4;
        return r105;
    L7:
        return r103;
    L14:
        return null;
    }
}
