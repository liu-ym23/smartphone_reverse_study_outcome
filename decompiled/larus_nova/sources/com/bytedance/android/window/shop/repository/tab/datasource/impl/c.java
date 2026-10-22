package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.window.shop.repository.dto.WindowExtensionDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.w;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f189466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c f189467b;

    public c(a r100, com.bytedance.android.window.shop.repository.tab.datasource.c r101) {
        this.f189466a = r100;
        this.f189467b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        WindowExtensionDataListResponseDTO r102 = (WindowExtensionDataListResponseDTO) r101.component1();
        List r103 = (List) r101.component2();
        a.a(this.f189466a, r103);
        uq3.j r104 = null;
        if ((!r103.isEmpty()) == false) goto L5;
        this.f189467b.y(new n0(r103, this.f189466a.getType(), null, 12), ShopWindowVODataType.NORMAL);
    L5:
        ((mq3.a) this.f189466a.f189454e.b()).setExtensionCardParam(null);
        a r105 = this.f189466a;
        com.bytedance.android.window.shop.repository.tab.datasource.c r106 = this.f189467b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "dto");
        Intrinsics.checkNotNullParameter(r106, "callback");
        if (r102.getControlInfo() == null) goto L24;
        r105.f189451b.update(true);
        w r107 = r102.getControlInfo();
        if (r107 == null) goto L10;
        int r108 = uq3.j.f551233e;
        Intrinsics.checkNotNullParameter(r107, "dto");
        r104 = new uq3.j();
        r104.f551234a = Intrinsics.areEqual(r107.c(), Boolean.TRUE);
        r104.f551235b = r107.b();
        r104.f551236c = r107.d();
        r104.f551237d = r107.a();
    L10:
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.f551234a == true) goto L14;
        return;
    L14:
        if (r104.f551235b == null) goto L29;
        String r109 = r104.f551236c;
        if (r109 == null) goto L30;
        ((mq3.a) r105.f189454e.b()).setPath(r109);
        ((mq3.a) r105.f189454e.b()).setCommonPassThroughParam(r104.f551237d);
        mq3.a r110 = (mq3.a) r105.f189454e.b();
        Integer r111 = r104.f551235b;
        if (r111 == null) goto L22;
        int r112 = r111.intValue();
    L23:
        r110.setPageNum(r112);
        r105.f189451b.f189470a = r104.f551234a;
        r106.e();
        r105.d(r106);
        return;
    L22:
        r112 = 0;
        goto L23
    L30:
        return;
    L29:
        return;
    L24:
        r106.c(r105);
    }
}
