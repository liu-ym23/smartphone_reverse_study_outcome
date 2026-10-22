package com.stepos.ailauncher.chat.wake.circle;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001b\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00078\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012\"\u001a\u0010\u0014\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0018\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\"\u001a\u0010\u001a\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u001a\u0010\u001c\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\"\u001a\u0010\u001e\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u001a\u0010 \u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017¨\u0006\""}, d2 = {"", "pointCount", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Z", "startColor", "endColor", "", "fraction", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(IIF)I", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "shift", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(IIIF)I", "TRAIL_HOLD_START", "F", "TRAIL_HOLD_END", "TRAIL_GLOW1_START", "I", Const.INTENT_KEY_UMID, "()I", "TRAIL_GLOW1_END", "c", "TRAIL_GLOW2_START", "f", "TRAIL_GLOW2_END", "e", "TRAIL_CORE_START", Const.INTENT_KEY_PKGNAME, "TRAIL_CORE_END", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K {
    private static final int TRAIL_CORE_END = -1;
    private static final int TRAIL_CORE_START = -855638017;
    private static final int TRAIL_GLOW1_END = -1711276033;
    private static final int TRAIL_GLOW1_START = 1946157055;
    private static final int TRAIL_GLOW2_END = -38106;
    private static final int TRAIL_GLOW2_START = 1124059568;
    public static final float TRAIL_HOLD_END = 0.727f;
    public static final float TRAIL_HOLD_START = 0.586f;

    public static final int a() {
        return TRAIL_CORE_END;
    }

    public static final int b() {
        return TRAIL_CORE_START;
    }

    public static final int c() {
        return TRAIL_GLOW1_END;
    }

    public static final int d() {
        return TRAIL_GLOW1_START;
    }

    public static final int e() {
        return TRAIL_GLOW2_END;
    }

    public static final int f() {
        return TRAIL_GLOW2_START;
    }

    public static final boolean g(int i10) {
        return i10 > 1;
    }

    public static final int h(int i10, int i11, int i12, float f10) {
        return C5685n.n((int) (((i10 >>> i12) & 255) + ((((i11 >>> i12) & 255) - r2) * f10)), 0, 255) << i12;
    }

    public static final int i(int i10, int i11, float f10) {
        if (f10 <= 0.586f) {
            return i10;
        }
        if (f10 >= 0.727f) {
            return i11;
        }
        float f11 = (f10 - 0.586f) / 0.14099997f;
        return h(i10, i11, 0, f11) | h(i10, i11, 24, f11) | h(i10, i11, 16, f11) | h(i10, i11, 8, f11);
    }
}
