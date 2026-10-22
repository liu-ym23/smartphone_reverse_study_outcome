package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftEffectConfigurationCommonItemKt {
    public static final void b(boolean r100) {
        if (r100 == true) goto L5;
        ToastUtil.a(R.string.ttlive_gift_sound_vibrate_switch_off_new, 0);
        return;
    L5:
        ToastUtil.a(R.string.ttlive_gift_sound_vibrate_switch_on_new, 0);
    }

    public static final i a(Context r100, boolean r110, final Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$1 r101 = new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$1(r110);
        final GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3 r102 = new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3(r110, new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2(r100, r110));
        if (r110 == false) goto L5;
        String r112 = "主播侧播放礼物声音/震动";
    L6:
        GiftEffectSwitchConfigType r103 = GiftEffectSwitchConfigType.SoundAndVibrationSwitch;
        return new i(r103, r112, new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$4(r101), new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$5(r102), true, new GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$6(r111), "礼物声音/震动功能说明");
    L5:
        r112 = "礼物声音/震动";
        goto L6
    }
}
