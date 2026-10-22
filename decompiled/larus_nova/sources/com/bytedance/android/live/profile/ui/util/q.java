package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q implements Function0<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NewProfileUser f86959a;

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(!this.f86959a.isFromOtherIntercomRoom());
    }

    public q(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f86959a = r100;
    }
}
