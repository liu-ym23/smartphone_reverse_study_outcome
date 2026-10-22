package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageInfoProcessor {
    CaptureStage getCaptureStage();

    boolean process(ImageInfo r100);
}
