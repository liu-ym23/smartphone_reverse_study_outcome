package com.bytedance.android.anya;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class h0<STATE extends MVIState<?>, ACTION extends p, VIEW extends BaseMVIView<STATE, ACTION>> extends DelegatingMVIBindingImpl<STATE, ACTION, VIEW> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f41617g;

    public h0(com.bytedance.android.anya.internal.m<?, ACTION> r100, VIEW r101, STATE r102, int r103, Function1<? super DelegatingMVIBindingImpl<STATE, ACTION, VIEW>, Unit> r104) {
        super(r100, r101, r102, r104);
        this.f41617g = r103;
    }
}
