package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/p0;", "", "<init>", "()V", "", "data", "", "noiseFloorRms", Const.INTENT_KEY_APIKEY, "([SF)F", "NOISE_FLOOR", "F", "RESPONSE_GAMMA", "LOUDNESS_GAIN", "DEFAULT_NOISE_FLOOR_RMS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p0 {
    public static final float DEFAULT_NOISE_FLOOR_RMS = 196.602f;
    public static final p0 INSTANCE = new p0();
    private static final float LOUDNESS_GAIN = 3.0f;
    private static final float NOISE_FLOOR = 0.006f;
    private static final float RESPONSE_GAMMA = 0.35f;

    public static /* synthetic */ float b(p0 p0Var, short[] sArr, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 196.602f;
        }
        return p0Var.a(sArr, f10);
    }

    public final float a(short[] data, float noiseFloorRms) {
        kotlin.jvm.internal.p.i(data, "data");
        if (data.length == 0) {
            return 0.0f;
        }
        double d10 = 0.0d;
        for (short s10 : data) {
            double d11 = s10 / 32767;
            d10 += d11 * d11;
        }
        if (((float) Math.sqrt(d10 / data.length)) <= noiseFloorRms / 32767) {
            return 0.0f;
        }
        return C5685n.m(((float) Math.pow(r9 - r11, 0.35f)) * 3.0f, 0.0f, 1.0f);
    }
}
