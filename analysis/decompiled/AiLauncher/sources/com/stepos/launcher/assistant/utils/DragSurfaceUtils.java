package com.stepos.launcher.assistant.utils;

import android.graphics.HardwareRenderer;
import android.graphics.Matrix;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewRootImpl;
import java.util.function.BiConsumer;

/* loaded from: classes.dex */
public class DragSurfaceUtils {
    public static void cleanUpSurface(SurfaceControl surfaceControl) {
        if (isSurfaceValid(surfaceControl)) {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            transaction.remove(surfaceControl);
            transaction.apply();
            transaction.close();
        }
    }

    public static boolean hide(SurfaceControl surfaceControl) {
        if (!isSurfaceValid(surfaceControl)) {
            return false;
        }
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        try {
            transaction.setAlpha(surfaceControl, 0.0f);
            transaction.apply();
            transaction.close();
            return true;
        } catch (Throwable th) {
            try {
                transaction.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void hideAndMergeDragSurface(ViewRootImpl viewRootImpl, SurfaceControl surfaceControl, long j10) {
        setAlphaAndMergeDragSurface(viewRootImpl, surfaceControl, j10, 0.0f);
    }

    public static boolean isSurfaceValid(SurfaceControl surfaceControl) {
        return surfaceControl != null && surfaceControl.isValid();
    }

    public static void mergeDragSurface(View view, final BiConsumer<ViewRootImpl, Long> biConsumer) {
        if (view == null) {
            return;
        }
        final ViewRootImpl viewRootImpl = view.getViewRootImpl();
        viewRootImpl.registerRtFrameCallback(new HardwareRenderer.FrameDrawingCallback() { // from class: com.stepos.launcher.assistant.utils.DragSurfaceUtils.1
            public void onFrameDraw(long j10) {
                biConsumer.accept(viewRootImpl, Long.valueOf(j10));
            }
        });
    }

    public static void setAlphaAndMergeDragSurface(ViewRootImpl viewRootImpl, SurfaceControl surfaceControl, long j10, float f10) {
        if (isSurfaceValid(surfaceControl)) {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            transaction.setAlpha(surfaceControl, f10);
            if (viewRootImpl != null) {
                viewRootImpl.mergeWithNextTransaction(transaction, j10);
            } else {
                transaction.apply();
                transaction.close();
            }
        }
    }

    public static void setXY(SurfaceControl surfaceControl, float f10, float f11) {
        if (isSurfaceValid(surfaceControl)) {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            try {
                Matrix matrix = new Matrix();
                float[] fArr = new float[9];
                matrix.postTranslate(f10, f11);
                if (!matrix.isIdentity()) {
                    transaction.setMatrix(surfaceControl, matrix, fArr);
                }
                transaction.apply();
                transaction.close();
            } catch (Throwable th) {
                try {
                    transaction.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void showAndMergeDragSurface(View view, final SurfaceControl surfaceControl) {
        mergeDragSurface(view, new BiConsumer<ViewRootImpl, Long>() { // from class: com.stepos.launcher.assistant.utils.DragSurfaceUtils.2
            @Override // java.util.function.BiConsumer
            public void accept(ViewRootImpl viewRootImpl, Long l10) {
                DragSurfaceUtils.showAndMergeDragSurface(viewRootImpl, surfaceControl, l10.longValue());
            }
        });
    }

    public static void showAndMergeDragSurface(ViewRootImpl viewRootImpl, SurfaceControl surfaceControl, long j10) {
        setAlphaAndMergeDragSurface(viewRootImpl, surfaceControl, j10, 1.0f);
    }
}
