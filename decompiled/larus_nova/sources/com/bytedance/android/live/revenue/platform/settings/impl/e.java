package com.bytedance.android.live.revenue.platform.settings.impl;

import com.bytedance.android.scope.o;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements b01.e, o {
    public e() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // b01.e
    public final <T> T f0(String r100, T r101, Type r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        return (T) f.a(r100, r101, r102, r103);
    }
}
