package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveQualityDetail;", "", "()V", "codec", "", "getCodec", "()Ljava/lang/String;", "setCodec", "(Ljava/lang/String;)V", "level", "", "getLevel", "()I", "setLevel", "(I)V", "name", "getName", "setName", "resolution", "getResolution", "setResolution", "sdkKey", "getSdkKey", "setSdkKey", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastLiveQualityDetail {
    private String codec;
    private int level;
    private String name;
    private String resolution;
    private String sdkKey;

    public LiveCastLiveQualityDetail() {
        this.name = "";
        this.sdkKey = "";
        this.resolution = "";
        this.codec = "";
    }

    public final String getCodec() {
        return this.codec;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getSdkKey() {
        return this.sdkKey;
    }

    public final void setCodec(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.codec = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolution = r100;
    }

    public final void setSdkKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sdkKey = r100;
    }
}
