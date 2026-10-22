package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/l;", "it", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/ktvimpl/mv/l;ILjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class MvPlayController$fetchAndPlay$1 extends Lambda implements Function3<l, Integer, String, Unit> {
    final /* synthetic */ MvPlayController this$0;

    public MvPlayController$fetchAndPlay$1(MvPlayController r100) {
        this.this$0 = r100;
        super(3);
    }

    public final void invoke(l r100, int r101, String r102) {
        if (r100 != null) goto L5;
        com.bytedance.android.live.ktv.common.util.g.c("get mvInfo fail is null");
        return;
    L5:
        Intrinsics.checkNotNullParameter("startPlayForSinger", "<set-?>");
        r100.f146074k = "startPlayForSinger";
        Function0<y> r103 = this.this$0.f146015p;
        if (r103 == null) goto L14;
        y r104 = r103.invoke();
        if (r104 == null) goto L14;
        this.this$0.getClass();
        if (MvPlayController.b(r104, r100) == true) goto L14;
        com.bytedance.android.live.ktv.common.util.g.c("checkMvInfoValid fail," + r100);
        return;
    L14:
        if (MvPlayController.e(this.this$0, r100, false, r100.f146072i, 1) != true) goto L19;
        Function1<? super String, Unit> r105 = this.this$0.f146010k;
        if (r105 == null) goto L20;
        Unit r106 = r105.invoke(r100.f146067d);
        return;
    L20:
        return;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(l r100, Integer r101, String r102) {
        invoke(r100, r101.intValue(), r102);
        return Unit.INSTANCE;
    }
}
