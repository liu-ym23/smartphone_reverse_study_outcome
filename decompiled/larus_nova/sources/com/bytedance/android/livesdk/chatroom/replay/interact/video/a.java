package com.bytedance.android.livesdk.chatroom.replay.interact.video;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f108838a = null;

    static {
        f108838a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        return (IBaseUser) r101.getFirst();
    }
}
