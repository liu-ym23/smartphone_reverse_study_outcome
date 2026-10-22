package com.bytedance.android.livesdk.player.utils;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f156216a;

    public f(Function0 r100) {
        this.f156216a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.f156216a.invoke();
    }
}
