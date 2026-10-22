package com.bytedance.android.ec.core.toolbox.rxanimation;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f45482a;

    public f(g r100) {
        this.f45482a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        g r100 = this.f45482a;
        r100.f45483a.setText(r100.f45487e);
    }
}
