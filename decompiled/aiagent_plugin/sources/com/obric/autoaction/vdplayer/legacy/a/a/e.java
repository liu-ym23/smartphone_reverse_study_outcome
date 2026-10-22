package com.obric.autoaction.vdplayer.legacy.a.a;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.logging.Loog;

/* JADX INFO: compiled from: GetSnapshotUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public e() {
    }

    public final Bitmap a(Bitmap r3) {
        Loog.INSTANCE.d("GetSnapshotUseCase", "getLastScreenShot");
        if (r3 != null) goto L5;
    L7:
        Loog.INSTANCE.d("GetSnapshotUseCase", "lastScreenShot is null or recycled");
        return null;
    L5:
        if (r3.isRecycled() == true) goto L7;
        return r3;
    }
}
