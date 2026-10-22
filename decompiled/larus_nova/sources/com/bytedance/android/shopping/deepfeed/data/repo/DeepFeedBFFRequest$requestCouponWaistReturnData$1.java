package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/repo/i;", "result", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/shopping/deepfeed/data/repo/i;)V", VideoEventOneOutSync.END_TYPE_FINISH}, k = 3, mv = {1, 4, 3})
final class DeepFeedBFFRequest$requestCouponWaistReturnData$1 extends Lambda implements Function1<i, Unit> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ Ref.BooleanRef $finished;

    public DeepFeedBFFRequest$requestCouponWaistReturnData$1(Ref.BooleanRef r100, Function1 r101) {
        this.$finished = r100;
        this.$callback = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(i r100) {
        Ref.BooleanRef r101 = this.$finished;
        if (r101.element == false) goto L5;
        return;
    L5:
        r101.element = true;
        this.$callback.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(i r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
