package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T1, T2, T3, R> implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f73518a = null;

    static {
        f73518a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Function3
    public final Object apply(Object r100, Object r101, Object r102) {
        Boolean r103 = (Boolean) r100;
        Boolean r104 = (Boolean) r101;
        Boolean r105 = (Boolean) r102;
        Intrinsics.checkNotNullParameter(r103, "isStreamRending");
        Intrinsics.checkNotNullParameter(r104, "isRtcClientInitialized");
        Intrinsics.checkNotNullParameter(r105, "isMultiAvatarMode");
        if (r103.booleanValue() == true) goto L5;
    L9:
        boolean r106 = false;
    L11:
        return Boolean.valueOf(r106);
    L5:
        if (r104.booleanValue() == false) goto L9;
        if (r105.booleanValue() == false) goto L9;
        r106 = true;
        goto L11
    }
}
