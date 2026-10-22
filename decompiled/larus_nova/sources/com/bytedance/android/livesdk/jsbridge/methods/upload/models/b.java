package com.bytedance.android.livesdk.jsbridge.methods.upload.models;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.subscribe.UploadImageResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/models/b;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("image")
    protected ImageModel image;

    public b() {
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.image = x.a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
