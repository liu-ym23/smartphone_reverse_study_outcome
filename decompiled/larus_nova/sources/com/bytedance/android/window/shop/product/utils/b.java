package com.bytedance.android.window.shop.product.utils;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends WindowBstReport.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.core.event.c f189405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f189406c;

    @Override // com.bytedance.android.window.shop.product.utils.WindowBstReport.a
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f189405b.doAnyEventAction(com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, r101, new Pair[0]);
    }

    public b(BaseViewModel r100, Map r101, Map r102) {
        this.f189405b = r100;
        this.f189406c = r101;
        super(r102);
    }
}
