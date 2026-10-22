package com.bytedance.android.live.recharge.nopassword;

import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f90051a;

    public f(l r100) {
        Intrinsics.checkNotNullParameter(r100, "settingStrategy");
        this.f90051a = r100;
        SetsKt.hashSetOf(new NoPasswordScene[]{NoPasswordScene.SCENE_PK, NoPasswordScene.SCENE_FANS_CLUB_JOIN, NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT});
    }
}
