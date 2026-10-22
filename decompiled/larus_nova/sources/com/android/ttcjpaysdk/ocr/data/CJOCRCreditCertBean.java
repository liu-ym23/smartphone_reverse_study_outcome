package com.android.ttcjpaysdk.ocr.data;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/CJOCRCreditCertBean;", "Ljava/io/Serializable;", "()V", "extParams", "Lorg/json/JSONObject;", "getExtParams", "()Lorg/json/JSONObject;", "setExtParams", "(Lorg/json/JSONObject;)V", TextureRenderKeys.KEY_MODULE_NAME, "", "getModuleName", "()Ljava/lang/String;", "setModuleName", "(Ljava/lang/String;)V", "ocrCompressSize", "", "getOcrCompressSize", "()I", "setOcrCompressSize", "(I)V", "ocrUrl", "getOcrUrl", "setOcrUrl", "pageType", "getPageType", "setPageType", "photoCompressSize", "getPhotoCompressSize", "setPhotoCompressSize", "getExtraParam", "key", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRCreditCertBean implements Serializable {
    public static final int COMPRESS_DEFAULT_SIZE = 512;
    public static final Companion Companion = null;
    private JSONObject extParams;
    private String moduleName;
    private int ocrCompressSize;
    private String ocrUrl;
    private int pageType;
    private int photoCompressSize;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/CJOCRCreditCertBean$Companion;", "", "()V", "COMPRESS_DEFAULT_SIZE", "", "toBean", "Lcom/android/ttcjpaysdk/ocr/data/CJOCRCreditCertBean;", "json", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJOCRCreditCertBean toBean(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            CJOCRCreditCertBean r101 = new CJOCRCreditCertBean();
            JSONObject r102 = new JSONObject(new JSONObject(r100).optString("params"));     // Catch: Exception -> L8
            r101.setPageType(r102.optInt("page_type"));     // Catch: Exception -> L8
            r101.setOcrUrl(r102.optString("ocr_url"));     // Catch: Exception -> L8
            r101.setOcrCompressSize(r102.optInt("ocr_compress_size", 512));     // Catch: Exception -> L8
            r101.setPhotoCompressSize(r102.optInt("photo_compress_size", 512));     // Catch: Exception -> L8
            JSONObject r103 = r102.optJSONObject("ext_params");     // Catch: Exception -> L8
            if (r103 != null) goto L6;
            r103 = new JSONObject();     // Catch: Exception -> L8
        L6:
            r101.setExtParams(r103);     // Catch: Exception -> L8
            r101.setModuleName(r101.getExtParams().optString("module_name"));     // Catch: Exception -> L8
        L10:
            return r101;
        L8:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJOCRCreditCertBean#toBean", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJOCRCreditCertBean#toBean", e);
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJOCRCreditCertBean() {
        this.pageType = 1;
        this.ocrUrl = "";
        this.extParams = new JSONObject();
        this.moduleName = "";
        this.ocrCompressSize = 512;
        this.photoCompressSize = 512;
    }

    public final JSONObject getExtParams() {
        return this.extParams;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final int getOcrCompressSize() {
        return this.ocrCompressSize;
    }

    public final String getOcrUrl() {
        return this.ocrUrl;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final int getPhotoCompressSize() {
        return this.photoCompressSize;
    }

    public final String getExtraParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.extParams.optString(r100);
    }

    public final void setExtParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extParams = r100;
    }

    public final void setModuleName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.moduleName = r100;
    }

    public final void setOcrCompressSize(int r100) {
        this.ocrCompressSize = r100;
    }

    public final void setOcrUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ocrUrl = r100;
    }

    public final void setPageType(int r100) {
        this.pageType = r100;
    }

    public final void setPhotoCompressSize(int r100) {
        this.photoCompressSize = r100;
    }
}
