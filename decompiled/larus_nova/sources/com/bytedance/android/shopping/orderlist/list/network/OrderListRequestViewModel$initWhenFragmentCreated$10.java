package com.bytedance.android.shopping.orderlist.list.network;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class OrderListRequestViewModel$initWhenFragmentCreated$10 extends Lambda implements Function0<String> {
    public static final OrderListRequestViewModel$initWhenFragmentCreated$10 INSTANCE = null;

    static {
        INSTANCE = new OrderListRequestViewModel$initWhenFragmentCreated$10();
    }

    public OrderListRequestViewModel$initWhenFragmentCreated$10() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "使用列表预加载的response";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
