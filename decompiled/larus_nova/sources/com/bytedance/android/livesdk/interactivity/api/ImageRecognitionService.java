package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.jsb.ImageRecognitionResultModel;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/ImageRecognitionService;", "Lcom/bytedance/android/livesdk/interactivity/api/IImageRecognitionService;", "Lj70/h;", "Ld90/a;", "getServiceWidgetDescriptor", "Lq82/a;", "Lq82/d;", "Lcom/bytedance/android/livesdk/interactivity/jsb/ImageRecognitionResultModel;", "createImageRecognitionMethod", "", "scene", "Lcom/bytedance/android/livesdkapi/imagerecognition/ImageRecognitionEntry;", "entry", "", "btmToken", "", "recognize", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ImageRecognitionService implements IImageRecognitionService {
    public ImageRecognitionService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService
    public q82.a<q82.d, ImageRecognitionResultModel> createImageRecognitionMethod() {
        return new f82.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService
    public j70.h<d90.a> getServiceWidgetDescriptor() {
        return new com.bytedance.android.livesdk.interactivity.imagerecognition.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService
    public void recognize(int r100, ImageRecognitionEntry r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "entry");
        xs2.b.a().post(new com.bytedance.android.livesdk.interactivity.imagerecognition.a(r100, r101, r102));
    }
}
