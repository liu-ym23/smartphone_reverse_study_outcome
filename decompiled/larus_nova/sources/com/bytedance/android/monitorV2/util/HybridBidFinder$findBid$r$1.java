package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class HybridBidFinder$findBid$r$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HybridEvent $event;
    final /* synthetic */ Function1<a.C2495a, Unit> $resolve;

    /* JADX WARN: Multi-variable type inference failed */
    public HybridBidFinder$findBid$r$1(Function1<? super a.C2495a, Unit> r100, HybridEvent r101) {
        this.$resolve = r100;
        this.$event = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        i r100 = i.f163237d;
        HybridEvent r101 = this.$event;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
        if ((r101 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L16;
        String r103 = ((com.bytedance.android.monitorV2.event.b) r101).f163022m.f501102b;     // Catch: Throwable -> L25
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L16;
        if (Intrinsics.areEqual(((com.bytedance.android.monitorV2.event.b) r101).f163022m.f501102b, "__hybrid_default") == true) goto L16;
        a.C2495a r105 = new a.C2495a(((com.bytedance.android.monitorV2.event.b) r101).f163022m.f501102b, "custom_bid");     // Catch: Throwable -> L25
    L23:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L25
    L28:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L31;
        r106 = i.f163237d.f163231b;
    L31:
        Function1<a.C2495a, Unit> r107 = this.$resolve;
        r107.invoke((a.C2495a) r106);
        return;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
    L16:
        List<String> r108 = r101.b();     // Catch: Throwable -> L25
        int r109 = r108.size();     // Catch: Throwable -> L25
        if (r109 != 1) goto L19;
        r105 = r100.a((String) ListProtector.get(r108, 0), "");     // Catch: Throwable -> L25
        goto L23
    L19:
        if (r109 == 2) goto L21;
        r105 = r100.f163231b;     // Catch: Throwable -> L25
        goto L23
    L21:
        r105 = r100.a((String) ListProtector.get(r108, 0), (String) ListProtector.get(r108, 1));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
