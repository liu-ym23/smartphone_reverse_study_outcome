package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RealTimeChorusMidiWidget$initStageViewModel$6 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public RealTimeChorusMidiWidget$initStageViewModel$6(RealTimeChorusMidiWidget r100) {
        super(1, r100, RealTimeChorusMidiWidget.class, "updateLyricProgress", "updateLyricProgress(Ljava/lang/Long;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long r100) {
        ((RealTimeChorusMidiWidget) this.receiver).xq(r100);
    }
}
