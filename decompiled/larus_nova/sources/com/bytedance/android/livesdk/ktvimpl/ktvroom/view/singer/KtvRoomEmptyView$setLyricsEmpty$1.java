package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/util/p;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/ktvimpl/base/util/p;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvRoomEmptyView$setLyricsEmpty$1 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ KtvRoomEmptyView this$0;

    public KtvRoomEmptyView$setLyricsEmpty$1(KtvRoomEmptyView r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f143571b = 2;
        if (this.this$0.getVisibility() == 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r100.f143570a = r101;
        return;
    L5:
        if (this.this$0.isShown() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
