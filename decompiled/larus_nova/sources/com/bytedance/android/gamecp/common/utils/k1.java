package com.bytedance.android.gamecp.common.utils;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f57232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f57233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super View, Unit> f57234c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = System.currentTimeMillis();
        if ((r101 - this.f57232a) <= this.f57233b) goto L6;
        this.f57232a = r101;
        this.f57234c.invoke(r100);
        return;
    }

    public k1(long r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f57233b = r100;
        this.f57234c = r101;
    }
}
