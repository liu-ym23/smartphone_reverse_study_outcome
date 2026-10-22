package com.bytedance.android.livesdk.chatroom.end.vip;

import io.reactivex.functions.Function3;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T1, T2, T3, R> implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f106138a = null;

    static {
        f106138a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function3
    public final Object apply(Object r100, Object r101, Object r102) {
        ug1.a r103 = (ug1.a) r100;
        Boolean r104 = (Boolean) r101;
        Intrinsics.checkNotNullParameter(r103, "liveState");
        Intrinsics.checkNotNullParameter(r104, "isVip");
        Intrinsics.checkNotNullParameter((Boolean) r102, "<anonymous parameter 2>");
        return new Pair(r103, r104);
    }
}
