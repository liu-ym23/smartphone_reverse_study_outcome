package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Unit;)Lio/reactivex/Single;"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class VCDLotteryPlugin$onLoad$1 extends FunctionReferenceImpl implements Function1<Unit, Single<Boolean>> {
    public VCDLotteryPlugin$onLoad$1(e r100) {
        super(1, r100, e.class, "interceptLotteryEntrance", "interceptLotteryEntrance(Lkotlin/Unit;)Lio/reactivex/Single;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Single<Boolean> invoke2(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((e) this.receiver).getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Single<Boolean> invoke(Unit r100) {
        return invoke2(r100);
    }
}
