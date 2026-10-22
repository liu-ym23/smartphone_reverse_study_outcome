package com.bytedance.android.livesdk.widget;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g3<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f161707a = null;

    static {
        f161707a = new g3();
    }

    public g3() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        if (r101.booleanValue() == false) goto L6;
        xs2.b.a().post(new zg1.z1());
    L6:
        return Unit.INSTANCE;
    }
}
