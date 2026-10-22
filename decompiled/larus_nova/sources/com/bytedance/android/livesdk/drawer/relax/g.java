package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.relax.relaxframework.TapEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f122635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super TapEvent, Unit> f122636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Long> f122637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f122638d;

    public g(Function0<String> r100, Function1<? super TapEvent, Unit> r101, Function0<Long> r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r102, "followStatus");
        Intrinsics.checkNotNullParameter(r103, "doFollowing");
        this.f122635a = r100;
        this.f122636b = r101;
        this.f122637c = r102;
        this.f122638d = r103;
    }
}
