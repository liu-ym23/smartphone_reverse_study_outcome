package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f145534a;

    public l(k r100) {
        this.f145534a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k r101 = this.f145534a;
        r101.m((List) r100);
    }
}
