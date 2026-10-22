package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f118819a = null;

    static {
        f118819a = new i1();
    }

    public i1() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        return Unit.INSTANCE;
    }
}
