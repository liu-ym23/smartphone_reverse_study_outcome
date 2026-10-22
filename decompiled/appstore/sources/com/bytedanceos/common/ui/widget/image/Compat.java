package com.bytedanceos.common.ui.widget.image;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    public Compat() {
    }

    public static void postOnAnimation(View r10, Runnable r11) {
        SDK16.postOnAnimation(r10, r11);
    }
}
