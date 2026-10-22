package com.bytedance.android.shopping.anchorv4.launcher.bizHandler;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f167016a = null;

    static {
        f167016a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        CommerceBaseResponse r101 = (CommerceBaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r101, "$this$isResponseSuccess");
        if (r101.getStatusCode() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        throw new IllegalStateException("report failed");
    L5:
        r102 = false;
        goto L6
    }
}
