package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f137571a;

    public a1(x0 r100) {
        this.f137571a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Set<Bitmap> r101 = this.f137571a.f137970i;
        r101.add((Bitmap) r100);
    }
}
