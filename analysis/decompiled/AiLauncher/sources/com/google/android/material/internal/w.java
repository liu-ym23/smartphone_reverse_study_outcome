package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public class w {

    public static class a {
        public static Rect a(WindowManager windowManager) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
    }

    public static Rect a(Context context) {
        return a.a((WindowManager) context.getSystemService("window"));
    }
}
