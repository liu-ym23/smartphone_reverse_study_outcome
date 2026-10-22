package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.p0;
import com.bytedance.android.anya.u0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public final class i<SUPER_STATE extends MVIState<?>, STATE extends MVIState<?>, ACTION extends p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0<SUPER_STATE, STATE, ACTION> f41597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<p0<SUPER_STATE>, SUPER_STATE, u0<SUPER_STATE, STATE>> f41598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<ACTION> f41599c;

    public i(b0 r100, Function2 r101, Class r102) {
        this.f41597a = r100;
        this.f41598b = r101;
        this.f41599c = r102;
    }
}
