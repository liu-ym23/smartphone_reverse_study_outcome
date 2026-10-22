package com.bytedance.android.live.revenue.platform.hybrid.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vy0.d;
import yy0.c;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements d, o {
    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vy0.d
    public final <PARAMS> zy0.b Xi(Context r100, vy0.a<PARAMS> r101, Uri r102, Function1<? super c, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        return ((vy0.c) f.a(vy0.c.class)).q8(r100, r102, r103);
    }
}
