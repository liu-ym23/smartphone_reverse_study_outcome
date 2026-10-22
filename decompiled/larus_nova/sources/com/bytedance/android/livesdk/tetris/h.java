package com.bytedance.android.livesdk.tetris;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s22.e f158590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f158591b;

    public h(s22.e r100, k r101) {
        this.f158590a = r100;
        this.f158591b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f158590a.removeListener(this.f158591b);
    }
}
