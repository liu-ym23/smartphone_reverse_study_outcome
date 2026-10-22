package com.bytedance.android.ec.hybrid.list.ability.impl;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.hybrid.list.ability.y;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<View> f46975a;

    @Override // com.bytedance.android.ec.hybrid.list.ability.s
    public final void release() {
    }

    public a() {
        this.f46975a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.y
    public final void l40(View r100, ECHybridListItemVO r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ECNAMallCardExtra r102 = r101.c();
        if (r102 == null) goto L5;
        Boolean r103 = r102.getGrayEnable();
    L7:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L12;
        if (this.f46975a.contains(r100) == true) goto L15;
        com.bytedance.android.ec.hybrid.list.a.b(r100);
        this.f46975a.add(r100);
        return;
    L15:
        return;
    L12:
        if (this.f46975a.contains(r100) == false) goto L17;
        com.bytedance.android.ec.hybrid.list.a.a(r100);
        this.f46975a.remove(r100);
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
