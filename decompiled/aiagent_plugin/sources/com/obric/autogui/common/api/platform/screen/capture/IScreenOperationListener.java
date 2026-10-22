package com.obric.autogui.common.api.platform.screen.capture;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: IScreenOperationListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IScreenOperationListener {
    void onError(int r1, String r2);

    void onEvent(OScreenEvent r1, Bitmap r2);
}
