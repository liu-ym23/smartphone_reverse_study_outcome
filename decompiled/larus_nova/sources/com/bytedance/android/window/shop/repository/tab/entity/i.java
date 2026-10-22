package com.bytedance.android.window.shop.repository.tab.entity;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f189574k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final tq3.c f189575j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final String b() {
        return this.f189575j.f49463a;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final void d() {
        Integer r100 = this.f189553b;
        if (r100 == null) goto L10;
        int r101 = r100.intValue();
        tq3.c r102 = this.f189575j;
        if (r102 == null) goto L11;
        fo.b r103 = r102.C;
        if (r103 == null) goto L12;
        fo.a<String> r104 = wn.a.f560404a;
        Integer r105 = (Integer) r103.b(wn.a.C, Integer.valueOf(r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.f189575j;
    }

    public i(tq3.c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        super(103);
        this.f189575j = r100;
        r100.C.b(wn.a.f560409f, 103);
    }
}
