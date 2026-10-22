package com.bytedance.android.livesdk.utils.condition.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f158923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConditionConstant$Target f158924b;

    public final ConditionConstant$Target getType() {
        return this.f158924b;
    }

    public f(ConditionConstant$Target r100, com.bytedance.android.livesdk.clearscreen.f r101) {
        Intrinsics.checkNotNullParameter(r100, "targetType");
        Intrinsics.checkNotNullParameter(r101, "runnable");
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f158924b = r100;
        this.f158923a = r101;
    }
}
