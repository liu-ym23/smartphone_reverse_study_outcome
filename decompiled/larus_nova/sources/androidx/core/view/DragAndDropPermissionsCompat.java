package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: loaded from: classes17.dex */
public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void release(DragAndDropPermissions r100) {
            r100.release();
        }

        public static DragAndDropPermissions requestDragAndDropPermissions(Activity r100, DragEvent r101) {
            return r100.requestDragAndDropPermissions(r101);
        }
    }

    public void release() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.release(this.mDragAndDropPermissions);
        return;
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions r100) {
        this.mDragAndDropPermissions = r100;
    }

    public static DragAndDropPermissionsCompat request(Activity r100, DragEvent r101) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        DragAndDropPermissions r102 = Api24Impl.requestDragAndDropPermissions(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new DragAndDropPermissionsCompat(r102);
    L8:
        return null;
    }
}
