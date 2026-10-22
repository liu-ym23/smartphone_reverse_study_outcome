package com.android.ttcjpaysdk.thirdparty.voiceprint.record;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceVibrateUtil;", "", "()V", "<set-?>", "", "SHORT", "getSHORT", "()J", "TAG", "", "initVibrateDuration", "", "duration", "triggerShakeSyncedVibration", "ctx", "Landroid/content/Context;", "triggerStrongVibration", "vibrate", PerfLog.PARAM_KEY_CONTEXT_ID, "milliseconds", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoiceVibrateUtil {
    public static final VoiceVibrateUtil INSTANCE = null;
    private static long SHORT = 0;
    private static final String TAG = "VoiceVibrateUtil";

    private VoiceVibrateUtil() {
    }

    static {
        INSTANCE = new VoiceVibrateUtil();
        SHORT = 50;
    }

    public final long getSHORT() {
        return SHORT;
    }

    public final void initVibrateDuration(long r100) {
        SHORT = r100;
    }

    public final void triggerShakeSyncedVibration(Context r110) {
        Intrinsics.checkNotNullParameter(r110, "ctx");
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L38
        Boolean r101 = null;
        if (r100 < 31) goto L11;
        Object r102 = r110.getSystemService("vibrator_manager");     // Catch: Throwable -> L38
        if ((r102 instanceof VibratorManager) == false) goto L8;
        VibratorManager r103 = (VibratorManager) r102;     // Catch: Throwable -> L38
    L9:
        if (r103 == null) goto L14;
        Vibrator r104 = r103.getDefaultVibrator();     // Catch: Throwable -> L38
    L15:
        if (r104 != null) goto L17;
    L33:
        StringBuilder r105 = new StringBuilder("vibrator unavailable, hasVibrator=");     // Catch: Throwable -> L38
        if (r104 == null) goto L36;
        r101 = Boolean.valueOf(r104.hasVibrator());     // Catch: Throwable -> L38
    L36:
        r105.append(r101);     // Catch: Throwable -> L38
        CJLogger.e(TAG, r105.toString());     // Catch: Throwable -> L38
        return;
    L17:
        if (r104.hasVibrator() == false) goto L33;
        if (r100 < 30) goto L26;
        if (r104.areAllPrimitivesSupported(new int[]{7}) == false) goto L26;
        r104.vibrate(VibrationEffect.startComposition().addPrimitive(7, 1.0f, 0).addPrimitive(7, 1.0f, 130).compose());     // Catch: Throwable -> L38
        return;
    L26:
        if (r100 < 26) goto L32;
        long[] r106 = {0, 25, 105, 25};     // Catch: Throwable -> L38
        if (r104.hasAmplitudeControl() == false) goto L30;
        int r107 = 160;
    L31:
        r104.vibrate(VibrationEffect.createWaveform(r106, new int[]{0, r107, 0, r107}, -1));     // Catch: Throwable -> L38
        return;
    L30:
        r107 = -1;
        goto L31
    L32:
        r104.vibrate(new long[]{0, 25, 105, 25}, -1);     // Catch: Throwable -> L38
        return;
    L14:
        r104 = null;
        goto L15
    L8:
        r103 = null;
        goto L9
    L11:
        Object r108 = r110.getSystemService("vibrator");     // Catch: Throwable -> L38
        if ((r108 instanceof Vibrator) == false) goto L14;
        r104 = (Vibrator) r108;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CJLogger.b(TAG, "triggerShakeSyncedVibration failed: " + th.getMessage());
    }

    public final void triggerStrongVibration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L28
        Boolean r102 = null;
        if (r101 < 31) goto L11;
        Object r103 = r100.getSystemService("vibrator_manager");     // Catch: Throwable -> L28
        if ((r103 instanceof VibratorManager) == false) goto L8;
        VibratorManager r104 = (VibratorManager) r103;     // Catch: Throwable -> L28
    L9:
        if (r104 == null) goto L14;
        Vibrator r105 = r104.getDefaultVibrator();     // Catch: Throwable -> L28
    L15:
        if (r105 != null) goto L17;
    L23:
        StringBuilder r106 = new StringBuilder("vibrator unavailable, hasVibrator=");     // Catch: Throwable -> L28
        if (r105 == null) goto L26;
        r102 = Boolean.valueOf(r105.hasVibrator());     // Catch: Throwable -> L28
    L26:
        r106.append(r102);     // Catch: Throwable -> L28
        CJLogger.e(TAG, r106.toString());     // Catch: Throwable -> L28
        return;
    L17:
        if (r105.hasVibrator() == false) goto L23;
        if (r101 < 26) goto L22;
        r105.hasAmplitudeControl();     // Catch: Throwable -> L28
        r105.vibrate(VibrationEffect.createOneShot(80, -1));     // Catch: Throwable -> L28
        return;
    L22:
        r105.vibrate(80);     // Catch: Throwable -> L28
        return;
    L14:
        r105 = null;
        goto L15
    L8:
        r104 = null;
        goto L9
    L11:
        Object r107 = r100.getSystemService("vibrator");     // Catch: Throwable -> L28
        if ((r107 instanceof Vibrator) == false) goto L14;
        r105 = (Vibrator) r107;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CJLogger.b(TAG, "triggerStrongVibration failed: " + th.getMessage());
    }

    public final void vibrate(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 >= 0) goto L43;
        CJLogger.b(TAG, "milliseconds error!!! millisecond cannot be less than 0");
        return;
    L43:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L36
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L36
        Unit r104 = null;
        if (r103 < 31) goto L20;
        Object r105 = r100.getSystemService("vibrator_manager");     // Catch: Throwable -> L36
        if ((r105 instanceof VibratorManager) == false) goto L11;
        VibratorManager r106 = (VibratorManager) r105;     // Catch: Throwable -> L36
    L12:
        if (r106 == null) goto L14;
        Vibrator r107 = r106.getDefaultVibrator();     // Catch: Throwable -> L36
    L15:
        VibrationEffect r108 = VibrationEffect.createOneShot(r101, -1);     // Catch: Throwable -> L36
        if (r107 == null) goto L34;
        r107.vibrate(r108);     // Catch: Throwable -> L36
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L34:
        Object r109 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L36
    L38:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L45;
        CJLogger.b(TAG, "vibrate failed: " + r110.getMessage());
        return;
    L45:
        return;
    L14:
        r107 = null;
        goto L15
    L11:
        r106 = null;
        goto L12
    L20:
        if (r103 < 26) goto L28;
        Object r111 = r100.getSystemService("vibrator");     // Catch: Throwable -> L36
        if ((r111 instanceof Vibrator) == false) goto L24;
        Vibrator r112 = (Vibrator) r111;     // Catch: Throwable -> L36
    L25:
        VibrationEffect r113 = VibrationEffect.createOneShot(r101, -1);     // Catch: Throwable -> L36
        if (r112 == null) goto L34;
        r112.vibrate(r113);     // Catch: Throwable -> L36
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L24:
        r112 = null;
        goto L25
    L28:
        Object r114 = r100.getSystemService("vibrator");     // Catch: Throwable -> L36
        if ((r114 instanceof Vibrator) == false) goto L31;
        Vibrator r115 = (Vibrator) r114;     // Catch: Throwable -> L36
    L32:
        if (r115 == null) goto L34;
        r115.vibrate(r101);     // Catch: Throwable -> L36
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L31:
        r115 = null;
    L36:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    }

    public static /* synthetic */ void vibrate$default(VoiceVibrateUtil r100, Context r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = SHORT;
    L5:
        r100.vibrate(r101, r102);
    }
}
