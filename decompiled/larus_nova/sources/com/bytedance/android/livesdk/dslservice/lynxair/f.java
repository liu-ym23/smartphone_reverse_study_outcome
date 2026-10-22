package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dslservice.util.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f122878a;

    public f(String r100) {
        this.f122878a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        m.f123003h.i(((Long) r100).longValue(), this.f122878a, "ViewCache");
    }
}
