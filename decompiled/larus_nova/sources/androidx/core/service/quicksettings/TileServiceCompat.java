package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;

/* JADX INFO: loaded from: classes17.dex */
public class TileServiceCompat {
    private static TileServiceWrapper sTileServiceWrapper;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void startActivityAndCollapse(TileService r100, Intent r101) {
            r100.startActivityAndCollapse(r101);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void startActivityAndCollapse(TileService r100, PendingIntent r101) {
            r100.startActivityAndCollapse(r101);
        }
    }

    public interface TileServiceWrapper {
        void startActivityAndCollapse(PendingIntent r100);

        void startActivityAndCollapse(Intent r100);
    }

    public static void clearTileServiceWrapper() {
        sTileServiceWrapper = null;
    }

    private TileServiceCompat() {
    }

    public static void setTileServiceWrapper(TileServiceWrapper r100) {
        sTileServiceWrapper = r100;
    }

    public static void startActivityAndCollapse(TileService r100, PendingIntentActivityWrapper r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 34) goto L9;
        TileServiceWrapper r103 = sTileServiceWrapper;
        if (r103 == null) goto L7;
        r103.startActivityAndCollapse(r101.getPendingIntent());
        return;
    L7:
        Api34Impl.startActivityAndCollapse(r100, r101.getPendingIntent());
        return;
    L9:
        if (r102 < 24) goto L17;
        TileServiceWrapper r104 = sTileServiceWrapper;
        if (r104 == null) goto L13;
        r104.startActivityAndCollapse(r101.getIntent());
        return;
    L13:
        Api24Impl.startActivityAndCollapse(r100, r101.getIntent());
        return;
    }
}
