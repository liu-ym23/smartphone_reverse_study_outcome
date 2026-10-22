package com.bytedance.android.live.profile;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rs0.x0;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f86053a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f86054a = 0;

        /* JADX INFO: renamed from: com.bytedance.android.live.profile.j$a$a, reason: collision with other inner class name */
        public static final class C1325a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            r101.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L18;
            r101.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L19;
            r101.getClass();
            if (Float.compare(0.0f, 0.0f) != 0) goto L20;
            r101.getClass();
            if (Float.compare(0.0f, 0.0f) == 0) goto L22;
            return false;
        L22:
            return true;
        L20:
            return false;
        L19:
            return false;
        L18:
            return false;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(0.0f) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f)) * 31) + Float.floatToIntBits(0.0f);
        }

        public final String toString() {
            return "Area(x=0.0, y=0.0, width=0.0, height=0.0)";
        }
    }

    public static boolean b() {
        return Intrinsics.areEqual(x0.f539089a.getValue(), Boolean.TRUE);
    }

    public static int a() {
        if (PadConfigUtils.c() == false) goto L7;
        return UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    L7:
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    static {
    }
}
