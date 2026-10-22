package com.bytedance.android.livesdk.gift.platform.business.normal.utils;

import android.graphics.PointF;
import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f129800a = 0;

    static {
    }

    public static PointF a(float r110, PointF r210, int r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, "centerPointF");
        PointF r100 = new PointF();
        float r101 = r110 % 90;
        if (r101 == 0.0f) goto L5;
    L8:
        if (r101 == 0.0f) goto L10;
    L13:
        double r102 = Math.toRadians(r110);
        double r103 = Math.tan(r102);
        double r111 = Math.sin(r102);
        Math.cos(r102);
        float r104 = r210.y;
        float r112 = r210.x;
        double r105 = ((double) r104) - (((double) r112) * r103);
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L23;
        if (r103 > 1.0d) goto L23;
        if (r111 <= 0) goto L20;
        r100.x = r112 + (r211 / 2.0f);
    L21:
        r100.y = (float) ((((double) r100.x) * r103) + r105);
    L30:
        if (r103 < (-1.0d)) goto L39;
        if (r103 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L39;
        if (r111 <= 0) goto L36;
        r100.x = r210.x - (r211 / 2.0f);
    L37:
        r100.y = (float) ((r103 * ((double) r100.x)) + r105);
    L45:
        return r100;
    L36:
        r100.x = r210.x + (r211 / 2.0f);
    L39:
        if (r103 >= (-1)) goto L45;
        if (r111 <= 0) goto L43;
        r100.y = r210.y + (r212 / 2.0f);
    L44:
        r100.x = (float) ((((double) r100.y) - r105) / r103);
        goto L45
    L43:
        r100.y = r210.y - (r212 / 2.0f);
        goto L44
    L20:
        r100.x = r112 - (r211 / 2.0f);
    L23:
        if (r103 <= 1) goto L30;
        if (r111 <= 0) goto L27;
        r100.y = r104 + (r212 / 2.0f);
    L28:
        r100.x = (float) ((((double) r100.y) - r105) / r103);
        goto L30
    L27:
        r100.y = r104 - (r212 / 2.0f);
        goto L28
    L10:
        if (r110 <= 0) goto L13;
        r100.x = r210.x;
        r100.y = r210.y + (r212 / 2);
        return r100;
    L5:
        if (r110 >= 0) goto L8;
        r100.x = r210.x;
        r100.y = r210.y - (r212 / 2);
        return r100;
    }
}
