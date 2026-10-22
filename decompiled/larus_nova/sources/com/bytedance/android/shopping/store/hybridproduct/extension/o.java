package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends Object> f185014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f185015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f185016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Object> f185017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f185018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f185019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f185020g;

    public o() {
        this.f185014a = MapsKt.emptyMap();
        this.f185015b = MapsKt.emptyMap();
        this.f185016c = MapsKt.emptyMap();
        this.f185017d = new LinkedHashMap();
    }

    public final void b(ECHybridListItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        ECNAMallCardExtra r101 = r100.c();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getSliceActions();
    L6:
        this.f185015b = com.bytedance.android.shopping.store.slicecard.i.a(r103);
        ECNAMallCardExtra r104 = r100.c();
        if (r104 == null) goto L9;
        String r105 = r104.getSliceItemStates();
    L10:
        this.f185017d = com.bytedance.android.shopping.store.slicecard.i.c(r105);
        ECNAMallCardExtra r106 = r100.c();
        if (r106 == null) goto L13;
        String r107 = r106.getSliceItemExtra();
    L14:
        this.f185016c = com.bytedance.android.shopping.store.slicecard.i.b(r107);
        ECNAMallCardExtra r108 = r100.c();
        if (r108 == null) goto L17;
        r102 = r108.getSliceItemType();
    L17:
        this.f185018e = r102;
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
