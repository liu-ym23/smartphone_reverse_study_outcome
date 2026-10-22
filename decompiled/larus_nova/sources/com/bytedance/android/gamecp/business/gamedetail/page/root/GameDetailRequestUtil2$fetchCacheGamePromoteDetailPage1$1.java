package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GameDetailRequestUtil2$fetchCacheGamePromoteDetailPage1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ o0 $listener;
    final /* synthetic */ h0 this$0;

    public GameDetailRequestUtil2$fetchCacheGamePromoteDetailPage1$1(h0 r100, o0 r101) {
        this.this$0 = r100;
        this.$listener = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        h0 r101 = this.this$0;     // Catch: Throwable -> L7
        if (r101.f55529a == null) goto L5;
        r101.getClass();     // Catch: Throwable -> L7
    L5:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
