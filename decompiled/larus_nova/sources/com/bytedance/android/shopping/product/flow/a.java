package com.bytedance.android.shopping.product.flow;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements yg3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f182316a;

    @Override // yg3.b
    public final String a() {
        ECUrlModel r100 = (ECUrlModel) CollectionsKt.firstOrNull(this.f182316a);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getFirstUrl();
    }

    public a(List r100) {
        this.f182316a = r100;
    }
}
