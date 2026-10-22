package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/d6;", "", "", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/d6$a;", "selectedPhotoArray", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setSelectedPhotoArray", "(Ljava/util/List;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d6 {

    @SerializedName("selectedPhotoArray")
    private List<a> selectedPhotoArray;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/d6$a;", "", "", "rawDataWithBase64", "Ljava/lang/String;", "getRawDataWithBase64", "()Ljava/lang/String;", "setRawDataWithBase64", "(Ljava/lang/String;)V", "thumbnailWithBase64", "getThumbnailWithBase64", "setThumbnailWithBase64", "rawDataUrl", "b", "setRawDataUrl", "key", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setKey", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("key")
        private String key;

        @SerializedName("rawDataUrl")
        private String rawDataUrl;

        @SerializedName("rawDataWithBase64")
        private String rawDataWithBase64;

        @SerializedName("thumbnailWithBase64")
        private String thumbnailWithBase64;

        public a() {
        }

        public final String a() {
            return this.key;
        }

        public final String b() {
            return this.rawDataUrl;
        }
    }

    public d6() {
    }

    public final List<a> a() {
        return this.selectedPhotoArray;
    }
}
