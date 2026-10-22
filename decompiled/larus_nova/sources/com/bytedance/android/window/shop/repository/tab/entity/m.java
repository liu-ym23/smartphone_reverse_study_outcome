package com.bytedance.android.window.shop.repository.tab.entity;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f189597k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final rq3.a f189598j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final String b() {
        return this.f189598j.f49463a;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final void d() {
        Integer r100 = this.f189553b;
        if (r100 == null) goto L6;
        int r101 = r100.intValue();
        fo.b r102 = this.f189598j.C;
        fo.a<String> r103 = wn.a.f560404a;
        r102.b(wn.a.C, Integer.valueOf(r101));
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.f189598j;
    }

    public m(rq3.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        super(402);
        this.f189598j = r100;
        fo.b r101 = r100.C;
        fo.a<Integer> r102 = wn.a.f560409f;
        int r103 = com.bytedance.android.window.shop.b.f187760a;
        r101.b(r102, 402);
    }
}
