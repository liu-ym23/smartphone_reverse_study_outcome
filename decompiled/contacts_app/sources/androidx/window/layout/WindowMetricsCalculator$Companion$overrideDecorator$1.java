package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowMetricsCalculator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends FunctionReferenceImpl implements Function1<WindowMetricsCalculator, WindowMetricsCalculator> {
    WindowMetricsCalculator$Companion$overrideDecorator$1(Object r8) {
        super(1, r8, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WindowMetricsCalculator invoke2(WindowMetricsCalculator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(r2);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WindowMetricsCalculator invoke(WindowMetricsCalculator r1) {
        return invoke2(r1);
    }
}
