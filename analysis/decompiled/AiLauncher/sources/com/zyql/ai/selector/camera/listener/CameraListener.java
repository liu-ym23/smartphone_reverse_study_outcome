package com.zyql.ai.selector.camera.listener;

import java.io.File;

/* loaded from: classes4.dex */
public interface CameraListener {
    void onError(int i10, String str, Throwable th);

    void onPictureSuccess(File file);

    void onRecordSuccess(File file);
}
