package com.bytedance.android.ec.hybrid.list;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridItemDataShrinkHelper;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f47010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECHybridItemDataShrinkHelper f47011b;

    public c(List r100, ECHybridItemDataShrinkHelper r101) {
        this.f47010a = r100;
        this.f47011b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        long r100 = System.currentTimeMillis();
        Iterator r101 = this.f47010a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ECHybridListItemVO) r101.next()).r(this.f47011b);
        goto L4
    L6:
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.a.f47501b, "ECHybridListEngine#shrinkItemData(), async duration = " + (System.currentTimeMillis() - r100));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
