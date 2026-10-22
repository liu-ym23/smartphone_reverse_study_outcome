package com.bytedance.android.shopping.orderlist.common.widgets.task;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f180071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f180072c;

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.task.a
    public final void a(e r100) {
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OrderCommonBaseTask", new BaseTaskKt$newTask$1$doTask$1(this));
        this.f180072c.invoke(this.f180070a, r100);
    }

    public b(String r100, Function2 r101) {
        this.f180071b = r100;
        this.f180072c = r101;
    }
}
