package com.bytedance.android.livesdk.chatroom.replay.widget;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f110371a = null;

    static {
        f110371a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        JsonObject r101 = (JsonObject) r100;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "$this$toJson");
        return GsonProtectorUtils.toJson(com.bytedance.android.annie.util.h.f40058b, r101);
    L5:
        return null;
    }
}
