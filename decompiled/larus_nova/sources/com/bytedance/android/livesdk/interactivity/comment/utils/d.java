package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.livesdk.interactivity.comment.y0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f136255a;

    public d(y0 r100) {
        this.f136255a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        e.f136258c = true;
        e.a((x22.a) this.f136255a.invoke());
    }
}
