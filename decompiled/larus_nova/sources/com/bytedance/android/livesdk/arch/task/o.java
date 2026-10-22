package com.bytedance.android.livesdk.arch.task;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103911b;

    public o(TbTaskFlower r100, x r101) {
        this.f103910a = r100;
        this.f103911b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f103910a.e(this.f103911b, ne1.b.a.C6916a.f518859b);
    }
}
