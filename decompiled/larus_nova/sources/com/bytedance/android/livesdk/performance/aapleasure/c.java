package com.bytedance.android.livesdk.performance.aapleasure;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Function2<? super Integer, ? super String, Unit> f154426a;

    public c() {
    }

    static {
    }

    public static void a(Level r100, AAPleasureNotifyScene r101) {
        Intrinsics.checkNotNullParameter(r100, "curNotifyLevel");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Function2<? super Integer, ? super String, Unit> r102 = f154426a;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(Integer.valueOf(r100.getLevel()), r101.getValue());
        return;
    }
}
