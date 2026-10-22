package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f73517a = null;

    static {
        f73517a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r102 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r100;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r103 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r101;
        Intrinsics.checkNotNullParameter(r102, "beforeSwitchScene");
        Intrinsics.checkNotNullParameter(r103, "sceneEvent");
        return new Pair(r102, r103);
    }
}
