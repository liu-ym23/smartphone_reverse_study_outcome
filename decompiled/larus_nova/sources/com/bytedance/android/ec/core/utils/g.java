package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.media.AudioManager;
import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudioManager f45595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f45596b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f45597c = -1;

    public static double a() {
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        boolean r101 = b(r100.getApplicationContext());
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 == false) goto L24;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L24:
        int r103 = -1;
        if (f45596b < 0) goto L8;
    L15:
        int r104 = f45597c;     // Catch: Exception -> L21
        if (b(r100.getApplicationContext()) == false) goto L26;
    L19:
        f45597c = r103;     // Catch: Exception -> L21
        r102 = (((double) r103) * 1.0d) / ((double) f45596b);     // Catch: Exception -> L21
        return new BigDecimal(r102).setScale(2, 4).doubleValue();
    L26:
        r103 = f45595a.getStreamVolume(3);     // Catch: Exception -> L23
        goto L19
    L8:
        if (b(r100.getApplicationContext()) == false) goto L11;
        int r105 = -1;
    L14:
        f45596b = r105;     // Catch: Exception -> L21
        goto L15
    L11:
        if (f45596b >= 0) goto L13;
        f45596b = f45595a.getStreamMaxVolume(3);     // Catch: Exception -> L21
    L13:
        r105 = f45596b;     // Catch: Exception -> L21
    L22:
        return r102;
    }

    public static boolean b(Context r100) {
        if (f45595a != null) goto L8;
        f45595a = (AudioManager) r100.getApplicationContext().getSystemService("audio");     // Catch: Exception -> L6
    L8:
        if (f45595a != null) goto L10;
        return true;
    L10:
        return false;
    }
}
