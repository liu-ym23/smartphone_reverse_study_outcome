package com.bytedance.android.livesdk.interactivity;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes9.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f141184a = 0;

    static {
    }

    public static Rect a(View r100) {
        if (r100 == null) goto L5;
        return new Rect(MathKt.roundToInt(r100.getX()), MathKt.roundToInt(r100.getY()), r100.getWidth(), r100.getHeight());
    L5:
        return new Rect(0, 0, 0, 0);
    }
}
