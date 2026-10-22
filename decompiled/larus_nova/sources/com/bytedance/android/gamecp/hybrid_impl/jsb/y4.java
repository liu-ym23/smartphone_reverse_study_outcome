package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/y4;", "", "", "maxImageCount", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setMaxImageCount", "(Ljava/lang/Integer;)V", "", "privacyCert", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setPrivacyCert", "(Ljava/lang/String;)V", "bottomViewTitle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBottomViewTitle", "nextButtonTitle", "e", "setNextButtonTitle", "limitTips", "b", "setLimitTips", "selectedImageCount", ce.f26391f, "setSelectedImageCount", "maxFileSize", "c", "setMaxFileSize", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y4 {

    @SerializedName("bottomViewTitle")
    private String bottomViewTitle;

    @SerializedName("limitTips")
    private String limitTips;

    @SerializedName("maxFileSize")
    private Integer maxFileSize;

    @SerializedName("maxImageCount")
    private Integer maxImageCount;

    @SerializedName("nextButtonTitle")
    private String nextButtonTitle;

    @SerializedName("privacyCert")
    private String privacyCert;

    @SerializedName("selectedImageCount")
    private Integer selectedImageCount;

    public y4() {
    }

    public final String a() {
        return this.bottomViewTitle;
    }

    public final String b() {
        return this.limitTips;
    }

    public final Integer c() {
        return this.maxFileSize;
    }

    public final Integer d() {
        return this.maxImageCount;
    }

    public final String e() {
        return this.nextButtonTitle;
    }

    public final String f() {
        return this.privacyCert;
    }

    public final Integer g() {
        return this.selectedImageCount;
    }
}
