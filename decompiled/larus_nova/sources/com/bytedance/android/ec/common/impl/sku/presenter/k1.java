package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f43245a;

    public k1(l1 r100) {
        this.f43245a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        l1 r102 = this.f43245a;
        LinearLayout r103 = r102.f43250g;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L5:
        int r104 = r103.getChildCount();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L14;
        LinearLayout r106 = r102.f43250g;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
    L10:
        View r107 = r106.getChildAt(r105);
        if ((r107 instanceof com.bytedance.android.ec.common.impl.sku.view.h) == false) goto L13;
        com.bytedance.android.ec.common.impl.sku.view.h r108 = (com.bytedance.android.ec.common.impl.sku.view.h) r107;
        r108.setSelectedStatus(r108.getSelectedStatus());
    L13:
        r105 = r105 + 1;
        goto L6
    }
}
