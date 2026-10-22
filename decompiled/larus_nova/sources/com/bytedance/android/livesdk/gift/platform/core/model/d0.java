package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.p2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class d0 implements s {
    public d0() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.s
    public y a(t r100, y r101, List<? extends r> r102, Function1<? super y, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Intrinsics.checkNotNullParameter(r103, "nextPlugin");
        return r101;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.s
    public void c(t r100, p2 r101, List<? extends r> r102, Function1<? super y, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Intrinsics.checkNotNullParameter(r103, "nextPlugin");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.s
    public y b(t r100, List<? extends r> r101, Function1<? super y, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r102, "nextPlugin");
        return y.d.f130943c;
    }
}
