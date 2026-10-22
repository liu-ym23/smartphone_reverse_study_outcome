package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = null;
    private final Context mContext;

    static class Api17Impl {
        private Api17Impl() {
        }

        static Display getDisplay(DisplayManager r0, int r1) {
            return r0.getDisplay(r1);
        }

        static Display[] getDisplays(DisplayManager r0) {
            return r0.getDisplays();
        }
    }

    static {
        sInstances = new WeakHashMap();
    }

    private DisplayManagerCompat(Context r1) {
        this.mContext = r1;
    }

    public static DisplayManagerCompat getInstance(Context r2) {
        WeakHashMap<Context, DisplayManagerCompat> r0 = sInstances;
        monitor-enter(r0);
        DisplayManagerCompat r1 = r0.get(r2);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new DisplayManagerCompat(r2);     // Catch: Throwable -> L9
        r0.put(r2, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public Display getDisplay(int r2) {
        return Api17Impl.getDisplay((DisplayManager) this.mContext.getSystemService("display"), r2);
    }

    public Display[] getDisplays() {
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    }

    public Display[] getDisplays(String r1) {
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    }
}
