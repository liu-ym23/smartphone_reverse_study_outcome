package com.stepos.launcher.assistant.widgetdrag;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import com.stepos.launcher.assistant.utils.DragSurfaceUtils;

/* loaded from: classes.dex */
public class BlurGlobalDragController extends GlobalDragController {
    private SurfaceControl mDragSurface;

    public BlurGlobalDragController(Context context) {
        super(context);
    }

    private void blurSurface(SurfaceControl surfaceControl, GlobalDragItemInfo globalDragItemInfo) {
        try {
            if (canGlobalItemBlur(globalDragItemInfo)) {
                Rect surfaceVisualBound = GlobalDragItemInfoExt.getSurfaceVisualBound(globalDragItemInfo);
                int iWidth = surfaceVisualBound.width();
                int iHeight = surfaceVisualBound.height();
                int i10 = (int) ((iWidth * 0.0f) / 2.0f);
                int i11 = (int) ((0.0f * iHeight) / 2.0f);
                int i12 = surfaceVisualBound.left;
                int i13 = surfaceVisualBound.top;
                surfaceVisualBound.set(i12 + i10, i13 + i11, (i12 + iWidth) - i10, (i13 + iHeight) - i11);
                BlurRegionHelper.blurSurface(surfaceControl, BlurRegionHelper.createBlurRegion(surfaceVisualBound, 1.0f, globalDragItemInfo.getCornerRadius(), getBlurRadius()));
            }
        } finally {
            if (surfaceControl != null) {
                surfaceControl.release();
            }
        }
    }

    public boolean canGlobalItemBlur(GlobalDragItemInfo globalDragItemInfo) {
        return globalDragItemInfo != null && globalDragItemInfo.isBlur() && globalDragItemInfo.getDragSource() == 2 && globalDragItemInfo.getCornerRadius() >= 0.0f;
    }

    public int getBlurRadius() {
        return 30;
    }

    public SurfaceControl getDragSurface() {
        return this.mDragSurface;
    }

    public void releaseDragSurface(boolean z10) {
        SurfaceControl surfaceControl = this.mDragSurface;
        if (surfaceControl != null) {
            if (z10) {
                DragSurfaceUtils.cleanUpSurface(surfaceControl);
            }
            this.mDragSurface.release();
            this.mDragSurface = null;
        }
    }

    public void scaleSurface(SurfaceControl surfaceControl, GlobalDragItemInfo globalDragItemInfo, float f10) {
        if (DragSurfaceUtils.isSurfaceValid(surfaceControl) && f10 != 1.0f) {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            matrix.postTranslate(globalDragItemInfo.getViewScreenX(), globalDragItemInfo.getViewScreenY());
            matrix.postScale(f10, f10, globalDragItemInfo.getViewScreenX() + (globalDragItemInfo.getViewWidth() / 2.0f), globalDragItemInfo.getViewScreenY() + (globalDragItemInfo.getViewHeight() / 2.0f));
            if (!matrix.isIdentity()) {
                transaction.setMatrix(surfaceControl, matrix, fArr);
            }
            transaction.apply();
            transaction.close();
        }
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.GlobalDragController, com.stepos.launcher.assistant.widgetdrag.IGlobalDragListener
    public boolean startDrag(View view, GlobalDragItemInfo globalDragItemInfo, Bundle bundle, int i10) {
        Bundle bundle2 = new Bundle();
        boolean zStartDrag = super.startDrag(view, globalDragItemInfo, bundle2, i10);
        if (zStartDrag) {
            this.mDragSurface = (SurfaceControl) bundle2.getParcelable(GlobalDragConstant.KEY_DRAG_SURFACE, SurfaceControl.class);
            blurSurface((SurfaceControl) bundle2.getParcelable(GlobalDragConstant.KEY_DRAG_SURFACE_BBQ_WRAPPER, SurfaceControl.class), globalDragItemInfo);
        }
        bundle2.clear();
        return zStartDrag;
    }
}
