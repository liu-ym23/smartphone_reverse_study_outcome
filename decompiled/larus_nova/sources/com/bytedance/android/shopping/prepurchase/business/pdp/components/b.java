package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f181087a;

    public b(e r100) {
        this.f181087a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        e r102 = this.f181087a;
        CommonMeta r103 = (CommonMeta) r101.getFirst();
        boolean r104 = ((Boolean) r101.getSecond()).booleanValue();
        r102.getClass();
        if (r103 == null) goto L5;
        String r105 = r103.getLastEcomSceneId();
    L6:
        boolean r106 = com.bytedance.android.shopping.anchorv4.helper.e.d(r105);
        if (r104 == false) goto L10;
        if (r106 == true) goto L10;
        boolean r107 = true;
    L11:
        BottomSheetBehavior<View> r108 = r102.f181094a;
        if (r108 == null) goto L14;
        r108.setSkipCollapsed(r107);
    L14:
        r102.f181095b = r107;
        return;
    L10:
        r107 = false;
        goto L11
    L5:
        r105 = null;
        goto L6
    }
}
