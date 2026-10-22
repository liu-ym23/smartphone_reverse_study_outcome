package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a1<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f115098a;

    public a1(f1 r100) {
        this.f115098a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        this.f115098a.getClass();
        return this.f115098a.f115247a;
    }
}
