package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CountdownTaskWidget$startCountDown$2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public CountdownTaskWidget$startCountDown$2(CountdownTaskWidget r100) {
        super(1, r100, CountdownTaskWidget.class, "onCountdownError", "onCountdownError(Ljava/lang/Throwable;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        CountdownTaskWidget r101 = (CountdownTaskWidget) this.receiver;
        int r102 = CountdownTaskWidget.f160797j;
        r101.clear();
        ALogger.e("CountdownTaskWidget", "error occurred when countdown", r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
