package com.zyql.ai.selector.camera.listener;

/* loaded from: classes4.dex */
public interface CaptureListener {
    void recordEnd(long j10);

    void recordError();

    void recordShort(long j10);

    void recordStart();

    void recordZoom(float f10);

    void takePictures();
}
