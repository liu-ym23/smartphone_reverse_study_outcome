package com.android.ttcjpaysdk.base.ui.component.vibration;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/vibration/CJVibration;", "", "()V", "elaborate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", GestureAction.longPress, "scan", "slide", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJVibration {
    public static final CJVibration INSTANCE = null;

    static {
        INSTANCE = new CJVibration();
    }

    private CJVibration() {
    }

    public final void elaborate(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("vibrator");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r101).vibrate(VibrationEffect.createOneShot(10, 125), null);
    }

    public final void longPress(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("vibrator");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r101).vibrate(VibrationEffect.createOneShot(45, 160), null);
    }

    public final void scan(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("vibrator");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r101).vibrate(VibrationEffect.createOneShot(20, 180), null);
    }

    public final void slide(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("vibrator");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) r101).vibrate(VibrationEffect.createOneShot(35, 80), null);
    }
}
