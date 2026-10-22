package com.bytedance.android.live.revlink.impl.multianchor.feed.wm;

import com.bytedance.android.live.revlink.impl.multianchor.dynamic.k;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/k;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/k;)Z", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedMultiWindowManager$updateLayout$layoutState$1 extends FunctionReferenceImpl implements Function1<k, Boolean> {
    public FeedMultiWindowManager$updateLayout$layoutState$1(FeedMultiWindowManager r100) {
        super(1, r100, FeedMultiWindowManager.class, "localLoadCheck", "localLoadCheck(Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/MultiLocalComponent;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(k r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return ((FeedMultiWindowManager) this.receiver).b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(k r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
