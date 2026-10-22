package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class x1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f136017a;

    public x1(t1.c r100) {
        this.f136017a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        MainThreadPostUtils.b(new w1(this));
    }
}
