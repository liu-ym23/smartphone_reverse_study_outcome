package com.bytedance.android.live.profit.lottery.plugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class VCDLotteryPlugin$onLoad$2 extends FunctionReferenceImpl implements Function1<Integer, Single<Boolean>> {
    public VCDLotteryPlugin$onLoad$2(e r100) {
        super(1, r100, e.class, "interceptLotteryEntranceIconClick", "interceptLotteryEntranceIconClick(I)Lio/reactivex/Single;", 0);
    }

    public final Single<Boolean> invoke(int r100) {
        ((e) this.receiver).getClass();
        Unit r101 = Unit.INSTANCE;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Single<Boolean> invoke(Integer r100) {
        return invoke(r100.intValue());
    }
}
