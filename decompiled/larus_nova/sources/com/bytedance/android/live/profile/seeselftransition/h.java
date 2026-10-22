package com.bytedance.android.live.profile.seeselftransition;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewProfileTransitionDialogManager f86170a;

    public h(NewProfileTransitionDialogManager r100) {
        this.f86170a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        NewProfileTransitionDialogManager.c(this.f86170a);
    }
}
