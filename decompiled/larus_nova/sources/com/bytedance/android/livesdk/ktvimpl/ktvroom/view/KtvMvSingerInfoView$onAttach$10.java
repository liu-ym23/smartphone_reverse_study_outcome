package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/a;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvMvSingerInfoView$onAttach$10 extends FunctionReferenceImpl implements Function1<Pair<? extends Boolean, ? extends com.bytedance.android.live.ktv.common.model.bean.a>, Unit> {
    public KtvMvSingerInfoView$onAttach$10(KtvMvSingerInfoView r100) {
        super(1, r100, KtvMvSingerInfoView.class, "handleCountdownEvent", "handleCountdownEvent(Lkotlin/Pair;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a> r100) {
        KtvMvSingerInfoView r101 = (KtvMvSingerInfoView) this.receiver;
        int r102 = KtvMvSingerInfoView.f144923m;
        r101.getClass();
        if (r100 == null) goto L7;
        r101.U5(r100.getSecond().f69995b);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends com.bytedance.android.live.ktv.common.model.bean.a> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
