package com.bytedance.android.livesdk.castscreen.castscreenapi.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.PaidLiveProjectionResponse.ProjectionData.streamData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/h;", "", "", "name", "Ljava/lang/String;", "sdkKey", "hlsUrl", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("hls_url")
    public String hlsUrl;

    @SerializedName("name")
    public String name;

    @SerializedName("sdk_key")
    public String sdkKey;

    public h() {
        this.name = "";
        this.sdkKey = "";
        this.hlsUrl = "";
    }

    public h(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.sdkKey = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.hlsUrl = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.name != null) goto L19;
        this.name = "";
    L19:
        if (this.sdkKey != null) goto L22;
        this.sdkKey = "";
    L22:
        if (this.hlsUrl != null) goto L37;
        this.hlsUrl = "";
        return;
    }
}
