package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.AnAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class NormalComboEnterAnimHelper extends b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f136767p = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f136768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f136769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f136770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f136771o;

    public static final class a {
    }

    static {
        f136767p = s1.f(20.0f);
        s1.f(14.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> b() {
        return new NormalComboEnterAnimHelper$enterAnimDescription$1(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> c() {
        return new NormalComboEnterAnimHelper$exitAnimDescription$1(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> d() {
        return new NormalComboEnterAnimHelper$stayAnimDescription$1(this);
    }

    public NormalComboEnterAnimHelper(BaseWindScreenAnimEnterTrayView r100, BaseWindScreenAnimEnterTrayView r101, z r102, float r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "animView");
        Intrinsics.checkNotNullParameter(r101, "comboView");
        Intrinsics.checkNotNullParameter(r102, "comboAnimBridge");
        super(r100, r101, r102);
        this.f136769m = 40.0f;
        this.f136770n = r103;
        this.f136771o = r104;
        this.f136768l = r100.getX();
    }
}
