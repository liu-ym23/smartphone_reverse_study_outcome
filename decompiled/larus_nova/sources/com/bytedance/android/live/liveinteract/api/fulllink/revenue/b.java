package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import com.bytedance.crash.dumper.Scraps;
import io.reactivex.functions.Function4;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T1, T2, T3, T4, R> implements Function4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f71462a = null;

    static {
        f71462a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function4
    public final Object apply(Object r100, Object r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter((Unit) r100, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter((Unit) r101, "unit1");
        Intrinsics.checkNotNullParameter((Unit) r102, "unit2");
        Intrinsics.checkNotNullParameter((Unit) r103, "unit3");
        return Boolean.TRUE;
    }
}
