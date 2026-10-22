package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\f\"\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "x1", "y1", "x2", "y2", "x", Const.INTENT_KEY_UMID, "(FFFFF)F", "p1", "p2", "u", Const.INTENT_KEY_PKGNAME, "(FFF)F", "c", "Lcom/stepos/ailauncher/chat/voice/motionkit/g;", "AudioWaveIntroEase", "Lcom/stepos/ailauncher/chat/voice/motionkit/g;", "e", "()Lcom/stepos/ailauncher/chat/voice/motionkit/g;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3068h {
    private static final C3067g AudioWaveIntroEase = new C3067g(0.3f, 0.0f, 0.1f, 1.0f);

    public static final float b(float f10, float f11, float f12) {
        float f13 = 1.0f - f12;
        float f14 = 3.0f * f13;
        return (f13 * f14 * f12 * f10) + (f14 * f12 * f12 * f11) + (f12 * f12 * f12);
    }

    public static final float c(float f10, float f11, float f12) {
        float f13 = 1.0f - f12;
        return (f13 * 3.0f * f13 * f10) + (f13 * 6.0f * f12 * (f11 - f10)) + (3.0f * f12 * f12 * (1.0f - f11));
    }

    public static final float d(float f10, float f11, float f12, float f13, float f14) {
        if (f14 <= 0.0f) {
            return 0.0f;
        }
        if (f14 >= 1.0f) {
            return 1.0f;
        }
        float fM = f14;
        for (int i10 = 0; i10 < 8; i10++) {
            float fB = b(f10, f12, fM) - f14;
            if (Math.abs(fB) < 1.0E-5f) {
                return b(f11, f13, fM);
            }
            float fC = c(f10, f12, fM);
            if (Math.abs(fC) < 1.0E-6f) {
                return b(f11, f13, fM);
            }
            fM = C5685n.m(fM - (fB / fC), 0.0f, 1.0f);
        }
        return b(f11, f13, fM);
    }

    public static final C3067g e() {
        return AudioWaveIntroEase;
    }
}
