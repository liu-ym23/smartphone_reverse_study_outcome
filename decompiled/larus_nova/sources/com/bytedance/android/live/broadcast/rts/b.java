package com.bytedance.android.live.broadcast.rts;

import com.relax.relaxframework.f5;
import com.relax.relaxframework.p6;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<p6> f59187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super f5, Unit> f59188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f59189c;

    public b(ArrayList<p6> r100, Function1<? super f5, Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "modifiers");
        Intrinsics.checkNotNullParameter(r102, "onLoadSuccess");
        this.f59187a = r100;
        this.f59188b = r101;
        this.f59189c = r102;
    }
}
