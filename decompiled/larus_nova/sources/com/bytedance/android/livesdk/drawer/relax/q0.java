package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.y5;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f122733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f122734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> f122735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Function1<? super y5, ? extends y5>, Unit> f122736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<? extends y5> f122737e;

    public q0(Function0<Boolean> r100, Function0<Boolean> r101, Function1<? super Function1<? super Boolean, Boolean>, Unit> r102, Function1<? super Function1<? super y5, ? extends y5>, Unit> r103, Function0<? extends y5> r104) {
        Intrinsics.checkNotNullParameter(r100, "showResult");
        Intrinsics.checkNotNullParameter(r101, "showSug");
        Intrinsics.checkNotNullParameter(r102, "setShowSug");
        Intrinsics.checkNotNullParameter(r103, "setInputRef");
        Intrinsics.checkNotNullParameter(r104, "inputRef");
        this.f122733a = r100;
        this.f122734b = r101;
        this.f122735c = r102;
        this.f122736d = r103;
        this.f122737e = r104;
    }
}
