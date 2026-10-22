package com.stepos.launcher.assistant.widgetdrag;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Rect;
import android.os.PersistableBundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GlobalDragItemInfoExt {
    public static boolean canDragOverlay(int i10, int i11) {
        if (i10 != 2 || i11 != 2) {
            if (i10 != 4 && i10 != 5) {
                return false;
            }
            if (i11 != 1 && i11 != 2 && i11 != 4) {
                return false;
            }
        }
        return true;
    }

    public static ClipData createDragClipData(String str, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(GlobalDragConstant.MIME_TYPE);
        if (z10) {
            arrayList.add(GlobalDragConstant.MIME_TYPE_HIDE_SURFACE);
        }
        ClipDescription clipDescription = new ClipDescription(GlobalDragConstant.DRAG_CLIP_DESCRIPTION, (String[]) arrayList.toArray(new String[0]));
        PersistableBundle persistableBundle = new PersistableBundle(1);
        persistableBundle.putString(GlobalDragConstant.DRAG_CONFIG_KEY, str);
        persistableBundle.putInt(GlobalDragConstant.DRAG_TYPE_KEY, i10);
        clipDescription.setExtras(persistableBundle);
        return new ClipData(clipDescription, new ClipData.Item(GlobalDragConstant.DRAG_CLIP_DESCRIPTION));
    }

    public static float getSurfaceTouchPointX(GlobalDragItemInfo globalDragItemInfo) {
        return globalDragItemInfo.getTouchPointX() + (((globalDragItemInfo.getDragScale() - 1.0f) / 2.0f) * globalDragItemInfo.getViewWidth());
    }

    public static float getSurfaceTouchPointY(GlobalDragItemInfo globalDragItemInfo) {
        return globalDragItemInfo.getTouchPointY() + (((globalDragItemInfo.getDragScale() - 1.0f) / 2.0f) * globalDragItemInfo.getViewHeight());
    }

    public static float getSurfaceViewHeight(GlobalDragItemInfo globalDragItemInfo) {
        return globalDragItemInfo.getViewHeight() * globalDragItemInfo.getDragScale();
    }

    public static float getSurfaceViewWidth(GlobalDragItemInfo globalDragItemInfo) {
        return globalDragItemInfo.getViewWidth() * globalDragItemInfo.getDragScale();
    }

    public static Rect getSurfaceVisualBound(GlobalDragItemInfo globalDragItemInfo) {
        Rect visualBound = globalDragItemInfo.getVisualBound();
        return (visualBound == null || visualBound.width() <= 0 || visualBound.height() <= 0) ? new Rect(0, 0, globalDragItemInfo.getViewWidth(), globalDragItemInfo.getViewHeight()) : new Rect(visualBound);
    }

    public static boolean canDragOverlay(GlobalDragItemInfo globalDragItemInfo) {
        return (globalDragItemInfo.getDragType() == 1 || globalDragItemInfo.getDragType() == 4) && canDragOverlay(globalDragItemInfo.getSpanX(), globalDragItemInfo.getSpanY());
    }
}
