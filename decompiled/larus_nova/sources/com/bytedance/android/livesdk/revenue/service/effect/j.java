package com.bytedance.android.livesdk.revenue.service.effect;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f157304a = null;

    static {
        f157304a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Sticker r101 = (Sticker) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new yp2.c(r101);
    }
}
