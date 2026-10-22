package com.bytedance.android.livesdk.arch.strategy;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class TbDoubleCheckManager$realBizCheckResult$checkResult$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ToolbarMatchInterface $compModel;
    final /* synthetic */ ObservableEmitter $emmit;

    public TbDoubleCheckManager$realBizCheckResult$checkResult$1(ObservableEmitter r100, ToolbarMatchInterface r101) {
        this.$emmit = r100;
        this.$compModel = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$emmit.onNext(je1.a.b.f498798b);
        if (this.$compModel.isBizCheckFinish() == false) goto L6;
        this.$emmit.onComplete();
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
