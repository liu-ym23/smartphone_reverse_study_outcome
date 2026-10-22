package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftRareShopComboHeatHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animator f126882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f126883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<Boolean> f126884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<Boolean> f126885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f126886e;

    public static final class a {
    }

    static {
    }

    public GiftRareShopComboHeatHelper(long r100) {
        this.f126886e = r100;
        this.f126884c = new NextLiveData();
        final NextLiveData<Boolean> r101 = new NextLiveData();
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftRareShopComboHeatHelper$showCountDown$1$1(r101), 7);
        Unit r102 = Unit.INSTANCE;
        this.f126885d = r101;
    }
}
