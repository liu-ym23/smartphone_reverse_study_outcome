package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.v0;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f89188a = null;

    static {
        f89188a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (v0) r101.data;
    }
}
