package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.EventProcessorDispatch;
import com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.r;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/consumechain/r;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/consumechain/r;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkOutStrategy$handleReplySuccess$dispatch$2 extends FunctionReferenceImpl implements Function1<r, Unit> {
    public RevLinkOutStrategy$handleReplySuccess$dispatch$2(EventProcessorDispatch r100) {
        super(1, r100, EventProcessorDispatch.class, "dispatch", "dispatch(Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(r r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((EventProcessorDispatch) this.receiver).a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(r r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
