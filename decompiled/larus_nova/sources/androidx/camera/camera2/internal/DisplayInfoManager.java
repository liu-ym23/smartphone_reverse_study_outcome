package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.camera.camera2.internal.compat.workaround.DisplaySizeCorrector;
import androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize;
import androidx.camera.core.internal.utils.SizeUtil;
import com.ss.android.ttvecamera.TECameraUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayInfoManager {
    private static final Size ABNORMAL_DISPLAY_SIZE_THRESHOLD = null;
    private static final Size FALLBACK_DISPLAY_SIZE = null;
    private static final Object INSTANCE_LOCK = null;
    private static final Size MAX_PREVIEW_SIZE = null;
    private static volatile DisplayInfoManager sInstance;
    private final DisplayManager mDisplayManager;
    private final DisplaySizeCorrector mDisplaySizeCorrector;
    private final MaxPreviewSize mMaxPreviewSize;
    private volatile Size mPreviewSize;

    public static void releaseInstance() {
        sInstance = null;
    }

    static {
        MAX_PREVIEW_SIZE = new Size(TECameraUtils.CAPTURE_NORMAL, 1080);
        ABNORMAL_DISPLAY_SIZE_THRESHOLD = new Size(320, 240);
        FALLBACK_DISPLAY_SIZE = new Size(640, 480);
        INSTANCE_LOCK = new Object();
    }

    private Size getCorrectedDisplaySize() {
        Point r100 = new Point();
        getMaxSizeDisplay(false).getRealSize(r100);
        Size r101 = new Size(r100.x, r100.y);
        if (SizeUtil.isSmallerByArea(r101, ABNORMAL_DISPLAY_SIZE_THRESHOLD) == false) goto L8;
        r101 = this.mDisplaySizeCorrector.getDisplaySize();
        if (r101 != null) goto L8;
        r101 = FALLBACK_DISPLAY_SIZE;
    L8:
        if (r101.getHeight() > r101.getWidth()) goto L10;
        return r101;
    L10:
        return new Size(r101.getHeight(), r101.getWidth());
    }

    public Size getPreviewSize() {
        if (this.mPreviewSize != null) goto L5;
        this.mPreviewSize = calculatePreviewSize();
        return this.mPreviewSize;
    L5:
        return this.mPreviewSize;
    }

    private Size calculatePreviewSize() {
        Size r100 = getCorrectedDisplaySize();
        int r101 = r100.getWidth() * r100.getHeight();
        Size r102 = MAX_PREVIEW_SIZE;
        if (r101 <= (r102.getWidth() * r102.getHeight())) goto L6;
        r100 = r102;
    L6:
        return this.mMaxPreviewSize.getMaxPreviewResolution(r100);
    }

    public void refresh() {
        this.mPreviewSize = calculatePreviewSize();
    }

    private DisplayInfoManager(Context r100) {
        this.mPreviewSize = null;
        this.mMaxPreviewSize = new MaxPreviewSize();
        this.mDisplaySizeCorrector = new DisplaySizeCorrector();
        this.mDisplayManager = (DisplayManager) r100.getSystemService("display");
    }

    public static DisplayInfoManager getInstance(Context r100) {
        if (sInstance != null) goto L15;
        Object r101 = INSTANCE_LOCK;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DisplayInfoManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Display getMaxSizeDisplay(boolean r100) {
        Display[] r101 = this.mDisplayManager.getDisplays();
        if (r101.length == 1) goto L5;
        Display r102 = getMaxSizeDisplayInternal(r101, r100);
        if (r102 != null) goto L10;
        if (r100 == false) goto L10;
        r102 = getMaxSizeDisplayInternal(r101, false);
    L10:
        if (r102 == null) goto L13;
        return r102;
    L13:
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    L5:
        return r101[0];
    }

    private Display getMaxSizeDisplayInternal(Display[] r100, boolean r110) {
        int r101 = r100.length;
        Display r102 = null;
        int r103 = -1;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L13;
        Display r105 = r100[r104];
        if (r110 == true) goto L7;
    L9:
        Point r106 = new Point();
        r105.getRealSize(r106);
        int r107 = r106.x;
        int r108 = r106.y;
        if ((r107 * r108) <= r103) goto L12;
        r102 = r105;
        r103 = r107 * r108;
    L12:
        r104 = r104 + 1;
        goto L3
    L7:
        if (r105.getState() != 1) goto L9;
    L13:
        return r102;
    }
}
