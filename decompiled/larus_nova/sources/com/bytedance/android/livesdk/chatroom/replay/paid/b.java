package com.bytedance.android.livesdk.chatroom.replay.paid;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public interface b {
    void B1(Function0<Unit> r100, Function0<Unit> r101);

    void N(FrameLayout r100);

    void hide();

    boolean isShowing();

    void l4(Bitmap r100, int r101);

    void release();

    void x1(Function0<Unit> r100, Function0<Unit> r101);
}
