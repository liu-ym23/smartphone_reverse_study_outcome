package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

/* JADX INFO: loaded from: classes17.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private final Context mContext;

    public Display[] getDisplays() {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }

    private DisplayManagerCompat(Context r100) {
        this.mContext = r100;
    }

    public static DisplayManagerCompat getInstance(Context r100) {
        return new DisplayManagerCompat(r100);
    }

    public Display getDisplay(int r100) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplay(r100);
    }

    public Display[] getDisplays(String r100) {
        return ((DisplayManager) this.mContext.getSystemService("display")).getDisplays();
    }
}
