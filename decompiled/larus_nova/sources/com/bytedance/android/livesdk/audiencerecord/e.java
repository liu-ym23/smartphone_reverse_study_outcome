package com.bytedance.android.livesdk.audiencerecord;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BacktrackServiceImp f104045a;

    public e(BacktrackServiceImp r100) {
        this.f104045a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f104045a.f103977a.e(((Float) r100).floatValue());
    }
}
