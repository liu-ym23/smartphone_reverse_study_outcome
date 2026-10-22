package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"", "volume", Const.INTENT_KEY_APIKEY, "(F)F", "WAVE_VOL_AMP_MIN", "F", "WAVE_VOL_AMP_MAX", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class P {
    public static final float WAVE_VOL_AMP_MAX = 1.1f;
    public static final float WAVE_VOL_AMP_MIN = 0.25f;

    public static final float a(float f10) {
        return (C5685n.m(f10, 0.0f, 1.0f) * 0.85f) + 0.25f;
    }
}
