package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.AnAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class EmergeComboEnterAnimHelper extends b {
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> b() {
        return EmergeComboEnterAnimHelper$enterAnimDescription$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> c() {
        return EmergeComboEnterAnimHelper$exitAnimDescription$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> d() {
        return EmergeComboEnterAnimHelper$stayAnimDescription$1.INSTANCE;
    }

    public EmergeComboEnterAnimHelper(BaseWindScreenAnimEnterTrayView r100, BaseWindScreenAnimEnterTrayView r101, z r102) {
        Intrinsics.checkNotNullParameter(r100, "animView");
        Intrinsics.checkNotNullParameter(r101, "comboView");
        Intrinsics.checkNotNullParameter(r102, "comboAnimBridge");
        super(r100, r101, r102);
    }
}
