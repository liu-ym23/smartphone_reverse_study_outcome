package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.i0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.anya.z;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public final class j<SUPER_STATE extends MVIState<?>, STATE extends MVIState<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<SUPER_STATE, STATE, ?> f41600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<i0<SUPER_STATE>, SUPER_STATE, u0<SUPER_STATE, STATE>> f41601b;

    public j(z r100, Function2 r101) {
        this.f41600a = r100;
        this.f41601b = r101;
    }
}
