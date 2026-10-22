package com.bytedance.android.livesdk.chatroom.tetris.vr;

import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f111954a = null;

    static {
        f111954a = new v();
    }

    public v() {
    }

    @Override // io.reactivex.functions.BiPredicate
    public final boolean test(Object r100, Object r101) {
        zg1.s r102 = (zg1.s) r100;
        zg1.s r103 = (zg1.s) r101;
        Intrinsics.checkNotNullParameter(r102, "t1");
        Intrinsics.checkNotNullParameter(r103, "t2");
        if (r102.f571933a != r103.f571933a) goto L5;
        return true;
    L5:
        return false;
    }
}
