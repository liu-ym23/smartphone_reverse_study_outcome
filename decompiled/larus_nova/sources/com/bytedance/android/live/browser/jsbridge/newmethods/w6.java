package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/w6;", "", "", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "videoId", "d", "setVideoId", "", "adrDuplicateDetect", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setAdrDuplicateDetect", "(Ljava/lang/Integer;)V", "anchorId", "b", "setAnchorId", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w6 {

    @SerializedName("adrDuplicateDetect")
    private Integer adrDuplicateDetect;

    @SerializedName("anchorId")
    private String anchorId;

    @SerializedName("url")
    private String url;

    @SerializedName("videoId")
    private String videoId;

    public w6() {
    }

    public final Integer a() {
        return this.adrDuplicateDetect;
    }

    public final String b() {
        return this.anchorId;
    }

    public final String c() {
        return this.url;
    }

    public final String d() {
        return this.videoId;
    }
}
