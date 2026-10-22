package com.bytedance.android.livesdk.interactivity.imagerecognition;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements ImageRecognitionTask.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageRecognitionServiceWidget f136982a;

    @Override // com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionTask.b
    public final void onCancel() {
        this.f136982a.f136947a = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionTask.b
    public final void onFailed() {
        this.f136982a.f136947a = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionTask.b
    public final void onSuccess() {
        this.f136982a.f136947a = null;
    }

    public b(ImageRecognitionServiceWidget r100) {
        this.f136982a = r100;
    }
}
