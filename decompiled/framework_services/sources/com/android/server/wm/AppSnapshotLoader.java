package com.android.server.wm;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.SystemClock;
import android.util.Slog;
import android.window.TaskSnapshot;
import com.android.server.wm.nano.WindowManagerProtos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* JADX INFO: loaded from: classes3.dex */
class AppSnapshotLoader {
    private static final String TAG = "WindowManager";
    private final BaseAppSnapshotPersister.PersistInfoProvider mPersistInfoProvider;

    static class PreRLegacySnapshotConfig {
        final boolean mForceLoadReducedJpeg;
        final float mScale;

        PreRLegacySnapshotConfig(float scale, boolean forceLoadReducedJpeg) {
            this.mScale = scale;
            this.mForceLoadReducedJpeg = forceLoadReducedJpeg;
        }
    }

    AppSnapshotLoader(BaseAppSnapshotPersister.PersistInfoProvider persistInfoProvider) {
        this.mPersistInfoProvider = persistInfoProvider;
    }

    PreRLegacySnapshotConfig getLegacySnapshotConfig(int taskWidth, float legacyScale, boolean highResFileExists, boolean loadLowResolutionBitmap) {
        float preRLegacyScale = 0.0f;
        boolean forceLoadReducedJpeg = false;
        boolean isPreQLegacyProto = false;
        if (taskWidth != 0) goto L5;
        boolean isPreRLegacySnapshot = true;
    L6:
        if (isPreRLegacySnapshot == true) goto L10;
        return null;
    L10:
        if (isPreRLegacySnapshot == true) goto L12;
    L15:
        float r3 = 0.5f;
        if (isPreQLegacyProto == true) goto L18;
        if (isPreRLegacySnapshot == true) goto L27;
    L34:
        return new PreRLegacySnapshotConfig(preRLegacyScale, forceLoadReducedJpeg);
    L27:
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L29;
        preRLegacyScale = legacyScale;
        forceLoadReducedJpeg = true;
        goto L34
    L29:
        if (loadLowResolutionBitmap == false) goto L31;
        float r4 = 0.5f * legacyScale;
    L32:
        preRLegacyScale = r4;
        goto L34
    L31:
        r4 = legacyScale;
        goto L32
    L18:
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L21;
        if (highResFileExists == true) goto L21;
        preRLegacyScale = 0.6f;
        forceLoadReducedJpeg = true;
    L21:
        if (loadLowResolutionBitmap == true) goto L24;
        r3 = 1.0f;
    L24:
        preRLegacyScale = r3;
        goto L34
    L12:
        if (Float.compare(legacyScale, 0.0f) != 0) goto L15;
        isPreQLegacyProto = true;
        goto L15
    L5:
        isPreRLegacySnapshot = false;
        goto L6
    }

    TaskSnapshot loadTask(int id, int userId, boolean loadLowResolutionBitmap) {
        File protoFile = this.mPersistInfoProvider.getProtoFile(id, userId);
        if (protoFile.exists() == true) goto L58;
        return null;
    L58:
        byte[] bytes = Files.readAllBytes(protoFile.toPath());     // Catch: IOException -> L10
        WindowManagerProtos.TaskSnapshotProto proto = WindowManagerProtos.TaskSnapshotProto.parseFrom(bytes);     // Catch: IOException -> L10
        File highResBitmap = this.mPersistInfoProvider.getHighResolutionBitmapFile(id, userId);     // Catch: IOException -> L10
        PreRLegacySnapshotConfig legacyConfig = getLegacySnapshotConfig(proto.taskWidth, proto.legacyScale, highResBitmap.exists(), loadLowResolutionBitmap);     // Catch: IOException -> L10
        if (legacyConfig != null) goto L8;
    L12:
        boolean r9 = false;
    L13:
        boolean forceLoadReducedJpeg = r9;
        if (loadLowResolutionBitmap == true) goto L18;
        if (forceLoadReducedJpeg == true) goto L18;
        File r10 = highResBitmap;
    L19:
        File bitmapFile = r10;
        if (bitmapFile.exists() == true) goto L22;
        return null;
    L22:
        BitmapFactory.Options options = new BitmapFactory.Options();     // Catch: IOException -> L10
        if (this.mPersistInfoProvider.use16BitFormat() == true) goto L25;
    L27:
        Bitmap.Config r11 = Bitmap.Config.ARGB_8888;     // Catch: IOException -> L10
    L28:
        options.inPreferredConfig = r11;     // Catch: IOException -> L10
        Bitmap bitmap = BitmapFactory.decodeFile(bitmapFile.getPath(), options);     // Catch: IOException -> L10
        if (bitmap != null) goto L32;
        Slog.w(TAG, "Failed to load bitmap: " + bitmapFile.getPath());     // Catch: IOException -> L10
        return null;
    L32:
        Bitmap hwBitmap = bitmap.copy(Bitmap.Config.HARDWARE, false);     // Catch: IOException -> L10
        bitmap.recycle();     // Catch: IOException -> L10
        if (hwBitmap != null) goto L36;
        Slog.w(TAG, "Failed to create hardware bitmap: " + bitmapFile.getPath());     // Catch: IOException -> L10
        return null;
    L36:
        HardwareBuffer buffer = hwBitmap.getHardwareBuffer();     // Catch: IOException -> L10
        if (buffer != null) goto L40;
        Slog.w(TAG, "Failed to retrieve gralloc buffer for bitmap: " + bitmapFile.getPath());     // Catch: IOException -> L10
        return null;
    L40:
        ComponentName topActivityComponent = ComponentName.unflattenFromString(proto.topActivityComponent);     // Catch: IOException -> L10
        if (legacyConfig == null) goto L43;
        int taskWidth = (int) (hwBitmap.getWidth() / legacyConfig.mScale);     // Catch: IOException -> L10
        int taskHeight = (int) (hwBitmap.getHeight() / legacyConfig.mScale);     // Catch: IOException -> L10
        Point taskSize = new Point(taskWidth, taskHeight);     // Catch: IOException -> L10
    L44:
        long r12 = proto.id;     // Catch: IOException -> L10
        long r7 = SystemClock.elapsedRealtimeNanos();     // Catch: IOException -> L10
        ColorSpace r13 = hwBitmap.getColorSpace();     // Catch: IOException -> L10
        int r14 = proto.orientation;     // Catch: IOException -> L10
        int r15 = proto.rotation;     // Catch: IOException -> L10
        Rect r16 = new Rect(proto.insetLeft, proto.insetTop, proto.insetRight, proto.insetBottom);     // Catch: IOException -> L10
        Rect r0 = new Rect(proto.letterboxInsetLeft, proto.letterboxInsetTop, proto.letterboxInsetRight, proto.letterboxInsetBottom);     // Catch: IOException -> L52
        boolean r1 = proto.isRealSnapshot;     // Catch: IOException -> L52
        int r3 = proto.windowingMode;     // Catch: IOException -> L52
        int r4 = proto.appearance;     // Catch: IOException -> L52
        boolean r5 = proto.isTranslucent;     // Catch: IOException -> L52
        int r2 = proto.uiMode;     // Catch: IOException -> L52
        String r6 = TAG;
        return new TaskSnapshot(r12, r7, topActivityComponent, buffer, r13, r14, r15, taskSize, r16, r0, loadLowResolutionBitmap, r1, r3, r4, r5, false, r2);
    L54:
        Slog.w(r6, "Unable to load task snapshot data for Id=" + id);
        return null;
    L53:
        r6 = TAG;
        goto L54
    L43:
        taskSize = new Point(proto.taskWidth, proto.taskHeight);     // Catch: IOException -> L10
        goto L44
    L25:
        if (proto.isTranslucent == true) goto L27;
        r11 = Bitmap.Config.RGB_565;     // Catch: IOException -> L10
    L18:
        r10 = this.mPersistInfoProvider.getLowResolutionBitmapFile(id, userId);     // Catch: IOException -> L10
        goto L19
    L8:
        if (legacyConfig.mForceLoadReducedJpeg == false) goto L12;
        r9 = true;
        goto L13
    L11:
        r6 = TAG;
        goto L54
    }
}
