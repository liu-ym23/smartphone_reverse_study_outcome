package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    void F0(String r100);

    void dismiss();

    boolean isShowing();

    void n0(long r100, Function0<Unit> r101);

    void setContent(String r100);

    void setIcon(Drawable r100);

    void setTitle(String r100);

    void show();

    void v(Function0<Unit> r100);

    void y(String r100);
}
