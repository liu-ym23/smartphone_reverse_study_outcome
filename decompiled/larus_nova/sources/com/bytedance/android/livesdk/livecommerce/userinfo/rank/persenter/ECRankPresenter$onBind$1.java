package com.bytedance.android.livesdk.livecommerce.userinfo.rank.persenter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkl2/a;", "<name for destructuring parameter 0>", "", AbsMethodDelegate.TAG_INVOKE, "(Lkl2/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECRankPresenter$onBind$1 extends Lambda implements Function1<kl2.a, Unit> {
    final /* synthetic */ a this$0;

    public ECRankPresenter$onBind$1(a r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(kl2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
        kl2.a.C6568a r101 = r100.f503844a;
        if (r100.f503845b != null) goto L5;
        return;
    L5:
        int r102 = a.f152982e;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(kl2.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
