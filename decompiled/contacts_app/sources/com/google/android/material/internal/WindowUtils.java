package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class WindowUtils {
    private static final String TAG = "WindowUtils";

    private static class Api14Impl {
        private Api14Impl() {
        }

        static Rect getCurrentWindowBounds(WindowManager r3) {
            Display r4 = r3.getDefaultDisplay();
            Point r0 = getRealSizeForDisplay(r4);
            Rect r1 = new Rect();
            if (r0.x != 0) goto L5;
        L8:
            r4.getRectSize(r1);
        L9:
            return r1;
        L5:
            if (r0.y == 0) goto L8;
            r1.right = r0.x;
            r1.bottom = r0.y;
            goto L9
        }

        private static Point getRealSizeForDisplay(Display r7) {
            Point r0 = new Point();
            Method r1 = Display.class.getDeclaredMethod("getRealSize", new Class[]{Point.class});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
            r1.setAccessible(true);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
            r1.invoke(r7, new Object[]{r0});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9
        L11:
            return r0;
        L7:
            e = move-exception;
            Log.w(WindowUtils.access$000(), e);
        L9:
            e = move-exception;
            Log.w(WindowUtils.access$000(), e);
        L5:
            e = move-exception;
            Log.w(WindowUtils.access$000(), e);
            goto L11
        }
    }

    private static class Api17Impl {
        private Api17Impl() {
        }

        static Rect getCurrentWindowBounds(WindowManager r2) {
            Display r3 = r2.getDefaultDisplay();
            Point r0 = new Point();
            r3.getRealSize(r0);
            Rect r4 = new Rect();
            r4.right = r0.x;
            r4.bottom = r0.y;
            return r4;
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static Rect getCurrentWindowBounds(WindowManager r0) {
            return r0.getCurrentWindowMetrics().getBounds();
        }
    }

    static {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    private WindowUtils() {
    }

    public static Rect getCurrentWindowBounds(Context r1) {
        return Api30Impl.getCurrentWindowBounds((WindowManager) r1.getSystemService("window"));
    }
}
