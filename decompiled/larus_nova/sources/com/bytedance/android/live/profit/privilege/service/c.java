package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f88453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f88454b;

    public c(HashMap r100, String r101) {
        this.f88453a = r100;
        this.f88454b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        int r102 = ToastUtil.f90810a;
        ToastUtil.b((String) this.f88453a.get(this.f88454b), 0);
        this.f88453a.put(this.f88454b, "");
        HashMap r103 = this.f88453a;
        KProperty[] r104 = com.bytedance.android.live.profit.privilege.datalayer.c.f88378a;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        com.bytedance.android.live.profit.privilege.datalayer.c.f88379b.setValue(null, com.bytedance.android.live.profit.privilege.datalayer.c.f88378a[0], r103);
    }
}
