package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/task/a;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/orderlist/common/widgets/task/a;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class BaseLinkedFootHelper$startYataFootRefresh$3 extends Lambda implements Function2<com.bytedance.android.shopping.orderlist.common.widgets.task.a, Object, Unit> {
    final /* synthetic */ String $tag;
    final /* synthetic */ BaseLinkedFootHelper this$0;

    public BaseLinkedFootHelper$startYataFootRefresh$3(BaseLinkedFootHelper r100, String r101) {
        this.this$0 = r100;
        this.$tag = r101;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.shopping.orderlist.common.widgets.task.a r100, Object r101) {
        BaseLinkedFootHelper r102 = this.this$0;
        if (r102.f180021b != 1) goto L5;
        return;
    L5:
        r102.f180021b = 1;
        Lazy r103 = OrderCommonLog.f179948a;
        OrderCommonLog.a(this.$tag, AnonymousClass1.INSTANCE);
        if (this.this$0.i(new BaseLinkedFootHelper$startYataFootRefresh$3$hasStarted$1(this), new BaseLinkedFootHelper$startYataFootRefresh$3$hasStarted$2(this)) == true) goto L9;
        OrderCommonLog.a(this.$tag, AnonymousClass2.INSTANCE);
        this.this$0.f180026g.b("");
        this.this$0.a();
        this.this$0.f180021b = 0;
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.shopping.orderlist.common.widgets.task.a r100, Object r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
