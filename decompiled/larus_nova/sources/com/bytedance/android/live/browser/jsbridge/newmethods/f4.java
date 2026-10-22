package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.UtilsKt;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f4<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f4 f63373a = null;

    static {
        f63373a = new f4();
    }

    public f4() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        JsonObject r101 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return UtilsKt.h(r101);
    }
}
