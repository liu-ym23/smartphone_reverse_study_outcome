package com.obric.utils;

import android.content.Context;
import android.os.Vibrator;
import bytedanceos.api.VibratorSmt;
import kotlin.Metadata;

/* JADX INFO: compiled from: VibratorHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/obric/utils/VibratorHelper;", "", "()V", "answer", "", "context", "Landroid/content/Context;", "dial", "handUp", "vibrate", "effect", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VibratorHelper {
    public static final VibratorHelper INSTANCE = null;

    static {
        INSTANCE = new VibratorHelper();
    }

    private VibratorHelper() {
    }

    private final void vibrate(Context r2, int r3) {
        Vibrator r1 = null;
        if (r2 == null) goto L5;
        Object r4 = r2.getSystemService("vibrator");
    L7:
        if ((r4 instanceof Vibrator) == false) goto L9;
        r1 = (Vibrator) r4;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        VibratorSmt.vibrateEffectWithHapticPlayer(r1, r3);
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void dial(Context r2) {
        vibrate(r2, 1);
    }

    public final void answer(Context r2) {
        vibrate(r2, 5);
    }

    public final void handUp(Context r2) {
        vibrate(r2, 4);
    }
}
