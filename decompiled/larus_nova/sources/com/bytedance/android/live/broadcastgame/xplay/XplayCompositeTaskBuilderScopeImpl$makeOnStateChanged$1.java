package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/l1;", "Lcom/bytedance/android/live/broadcastgame/xplay/m1;", "state", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/broadcastgame/xplay/l1;Lcom/bytedance/android/live/broadcastgame/xplay/m1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class XplayCompositeTaskBuilderScopeImpl$makeOnStateChanged$1 extends Lambda implements Function2<l1, m1, Unit> {
    final /* synthetic */ XplayCompositeTaskBuilderScopeImpl this$0;

    public XplayCompositeTaskBuilderScopeImpl$makeOnStateChanged$1(XplayCompositeTaskBuilderScopeImpl r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l1 r100, m1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "state");
        Iterator<T> r102 = this.this$0.f61861b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((Function2) r102.next()).invoke(r100, r101);
        goto L4
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(l1 r100, m1 r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
