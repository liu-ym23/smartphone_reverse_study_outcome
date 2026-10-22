package com.bytedance.android.livehostapi.business.castscreen.bean;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastCameraPosInfo;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", MiniAppConstants.KEY_MINI_APP_STREAM_DATA, "getStream_data", "setStream_data", "url", "getUrl", "setUrl", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastCameraPosInfo {
    private String name;
    private String stream_data;
    private String url;

    public LiveCastCameraPosInfo() {
        this.name = "";
        this.stream_data = "";
        this.url = "";
    }

    public final String getName() {
        return this.name;
    }

    public final String getStream_data() {
        return this.stream_data;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setStream_data(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stream_data = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }
}
