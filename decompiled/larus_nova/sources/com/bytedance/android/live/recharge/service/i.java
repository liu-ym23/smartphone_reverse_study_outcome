package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.recharge.r0;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f90378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f90379b;

    public i(HashMap r100, String r101) {
        this.f90378a = r100;
        this.f90379b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.recharge.deal.i r101 = (com.bytedance.android.live.recharge.deal.i) r100;
        HashMap r102 = this.f90378a;
        r102.put(this.f90379b, Long.valueOf(System.currentTimeMillis()));
        KProperty[] r103 = r0.f90340a;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r0.f90344e.setValue(null, r0.f90340a[3], r102);
    }
}
