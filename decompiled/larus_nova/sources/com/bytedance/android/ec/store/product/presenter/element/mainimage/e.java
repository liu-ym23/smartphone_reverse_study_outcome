package com.bytedance.android.ec.store.product.presenter.element.mainimage;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import sm.k;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECProductCardMainImagePresenter f48311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f48312b;

    @Override // sm.k
    public final String c7() {
        ECProductCardMainImagePresenter r100 = this.f48311a;
        if (r100.f48303r == false) goto L8;
        String r101 = (String) CollectionsKt.getOrNull((List) this.f48312b.element, r100.f48304s);
        if (r101 == null) goto L10;
        return r101;
    L10:
        return (String) CollectionsKt.firstOrNull((List) this.f48312b.element);
    L8:
        return (String) CollectionsKt.firstOrNull((List) this.f48312b.element);
    }

    public e(ECProductCardMainImagePresenter r100, Ref.ObjectRef r101) {
        this.f48311a = r100;
        this.f48312b = r101;
    }
}
