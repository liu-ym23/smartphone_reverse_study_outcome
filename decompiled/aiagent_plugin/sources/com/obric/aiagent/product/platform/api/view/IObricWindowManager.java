package com.obric.aiagent.product.platform.api.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.Window;
import com.obric.aiagent.product.platform.api.inputmethod.ObricInputMethodListener;
import java.util.List;

/* JADX INFO: compiled from: IObricWindowManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricWindowManager {
    public static final Companion Companion = null;
    public static final int ERROR_ANR = 1;
    public static final int ERROR_CRASH = 2;
    public static final int ERROR_MOVE_DEFAULT_DISPLAY_TASK = 4;
    public static final int ERROR_RELAUNCH = 3;

    /* JADX INFO: compiled from: IObricWindowManager.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int ERROR_ANR = 1;
        public static final int ERROR_CRASH = 2;
        public static final int ERROR_MOVE_DEFAULT_DISPLAY_TASK = 4;
        public static final int ERROR_RELAUNCH = 3;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean focusedWindowIsSecure();

    boolean isAutoActionRunning();

    boolean isAutoImeReady();

    boolean isInputMethodShown();

    boolean registerInputMethodListener(ObricInputMethodListener r1);

    boolean registerWindowGestureListener(IBinder r1, ObricWindowGestureListener r2);

    boolean setAssistantWindowInKeyguardMode(Window r1);

    boolean showGlobalActions(Context r1);

    Bitmap takeScreenshot(List<String> r1, List<String> r2);

    boolean takeSurfaceControlScreenshot(List<String> r1, List<String> r2, Object r3);

    boolean unregisterInputMethodListener(ObricInputMethodListener r1);

    boolean unregisterWindowGestureListener(IBinder r1, ObricWindowGestureListener r2);
}
