package com.bytedance.android.live.broadcastgame.xplay;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class XplayProgressKt {
    public static final void a(n1 r100, final c1 r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$progress");
        Intrinsics.checkNotNullParameter(r101, "pm");
        r101.getClass();
        final c1.a r103 = new c1.a(r102);
        ((ArrayList) r101.f62033c).add(r103);
        final Function0<Unit> r104 = new XplayProgressManager$task$1(r101, r103);
        Function2<l1, m1.b, Unit> r105 = new XplayProgressKt$progress$1(r104);
        Intrinsics.checkNotNullParameter(r100, "$this$onComplete");
        Intrinsics.checkNotNullParameter(r105, "callback");
        r100.c(new XplayTasksDslKt$onComplete$1(r105));
        final Function2<l1, m1.f, Unit> r106 = new XplayProgressKt$progress$2(r104);
        Intrinsics.checkNotNullParameter(r100, "$this$onSkip");
        Intrinsics.checkNotNullParameter(r106, "callback");
        r100.c(new XplayTasksDslKt$onSkip$1(r106));
    }
}
