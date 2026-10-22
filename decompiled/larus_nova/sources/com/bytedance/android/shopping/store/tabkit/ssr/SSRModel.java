package com.bytedance.android.shopping.store.tabkit.ssr;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0010R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/ssr/SSRModel;", "", "ssrData", "", "hydrateData", "", "hydrateUrl", "hydrateHash", "hydrateBytes", "timingData", "", "", "errorCode", "", "errorMsg", "errorNetCode", "([BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getErrorNetCode", "setErrorNetCode", "getHydrateBytes", "()[B", "setHydrateBytes", "([B)V", "getHydrateData", "setHydrateData", "getHydrateHash", "setHydrateHash", "getHydrateUrl", "setHydrateUrl", "getSsrData", "setSsrData", "getTimingData", "()Ljava/util/Map;", "setTimingData", "(Ljava/util/Map;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SSRModel {
    private Integer errorCode;
    private String errorMsg;
    private Integer errorNetCode;
    private byte[] hydrateBytes;
    private String hydrateData;
    private String hydrateHash;
    private String hydrateUrl;
    private byte[] ssrData;
    private Map<String, Long> timingData;

    public SSRModel() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Integer getErrorNetCode() {
        return this.errorNetCode;
    }

    public final byte[] getHydrateBytes() {
        return this.hydrateBytes;
    }

    public final String getHydrateData() {
        return this.hydrateData;
    }

    public final String getHydrateHash() {
        return this.hydrateHash;
    }

    public final String getHydrateUrl() {
        return this.hydrateUrl;
    }

    public final byte[] getSsrData() {
        return this.ssrData;
    }

    public final Map<String, Long> getTimingData() {
        return this.timingData;
    }

    public final void setErrorCode(Integer r100) {
        this.errorCode = r100;
    }

    public final void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public final void setErrorNetCode(Integer r100) {
        this.errorNetCode = r100;
    }

    public final void setHydrateBytes(byte[] r100) {
        this.hydrateBytes = r100;
    }

    public final void setHydrateData(String r100) {
        this.hydrateData = r100;
    }

    public final void setHydrateHash(String r100) {
        this.hydrateHash = r100;
    }

    public final void setHydrateUrl(String r100) {
        this.hydrateUrl = r100;
    }

    public final void setSsrData(byte[] r100) {
        this.ssrData = r100;
    }

    public final void setTimingData(Map<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timingData = r100;
    }

    public SSRModel(byte[] r100, String r101, String r102, String r103, byte[] r104, Map<String, Long> r105, Integer r106, String r107, Integer r110) {
        Intrinsics.checkNotNullParameter(r105, "timingData");
        this.ssrData = r100;
        this.hydrateData = r101;
        this.hydrateUrl = r102;
        this.hydrateHash = r103;
        this.hydrateBytes = r104;
        this.timingData = r105;
        this.errorCode = r106;
        this.errorMsg = r107;
        this.errorNetCode = r110;
    }

    public /* synthetic */ SSRModel(byte[] r110, String r111, String r112, String r113, byte[] r114, Map r115, Integer r116, String r117, Integer r118, int r210, DefaultConstructorMarker r211) {
        Integer r100 = null;
        if ((r210 & 1) == 0) goto L5;
        byte[] r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        byte[] r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r106 = new LinkedHashMap();
    L27:
        if ((r210 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
