package com.bytedance.android.shopping.sku.inner.repo.composer;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataExParamsComposer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SkuParams f182955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f182956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SkuSchemaParams f182957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Object> f182958d;

    public final List<SkuPassThroughItem> a() {
        if (Intrinsics.areEqual(this.f182956b, "forDiff") == true) goto L5;
        String r100 = this.f182955a.getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        this.f182955a.getEventParams();
        LinkedHashMap r101 = new LinkedHashMap();
        Lazy r102 = SkuPerformanceOpt.f45320a;
        BuyNowPerformanceOpt.l();
        if (this.f182955a.getActionType() != 2) goto L9;
    L10:
        Function0<String> r103 = new SkuYataExParamsComposer$getPassThrough$1(this);
        SkuSchemaParams r104 = this.f182957c;
        if (r104 != null) goto L13;
    L14:
        r101.put("api.add.extra", r103.invoke());
    L15:
        Function0<String> r105 = new SkuYataExParamsComposer$getPassThrough$2(this);
        SkuSchemaParams r106 = this.f182957c;
        if (r106 != null) goto L18;
    L19:
        r101.put("api.sku.entrance_info", r105.invoke());
    L20:
        ArrayList r107 = new ArrayList(r101.size());
        Iterator r108 = r101.entrySet().iterator();
    L22:
        if (r108.hasNext() == false) goto L24;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.add(new SkuPassThroughItem(CollectionsKt.listOf(r109.getKey()), (String) r109.getValue(), null, 4, null));
        goto L22
    L24:
        return r107;
    L18:
        if (r106.getPassThroughToKeys().contains("api.sku.entrance_info") == false) goto L20;
    L13:
        if (r104.getPassThroughToKeys().contains("api.add.extra") == false) goto L15;
    L9:
        if (this.f182955a.getActionType() != 4) goto L15;
    L5:
        return CollectionsKt.emptyList();
    }

    public SkuYataExParamsComposer(SkuParams r100, String r101, SkuSchemaParams r102, WeakReference<Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        Intrinsics.checkNotNullParameter(r101, "skuUniqueId");
        this.f182955a = r100;
        this.f182956b = r101;
        this.f182957c = r102;
        this.f182958d = r103;
    }
}
