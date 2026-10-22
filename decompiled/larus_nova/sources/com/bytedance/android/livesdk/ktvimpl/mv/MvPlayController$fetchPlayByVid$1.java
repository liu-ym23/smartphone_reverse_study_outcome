package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/l;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/ktvimpl/mv/l;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class MvPlayController$fetchPlayByVid$1 extends Lambda implements Function1<l, Unit> {
    final /* synthetic */ MvPlayController this$0;

    public MvPlayController$fetchPlayByVid$1(MvPlayController r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.getClass();
        Intrinsics.checkNotNullParameter("fetchPlayByVid", "<set-?>");
        r100.f146074k = "fetchPlayByVid";
        MvPlayController.e(this.this$0, r100, false, null, 3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(l r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
