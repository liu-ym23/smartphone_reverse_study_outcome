package com.bytedance.android.livesdk.livecommerce.room.controller;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class p implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f151699a;

    public p(Function1 r100) {
        this.f151699a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f151699a.invoke(r100);
    }
}
