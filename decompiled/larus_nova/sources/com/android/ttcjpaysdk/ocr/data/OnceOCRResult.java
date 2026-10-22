package com.android.ttcjpaysdk.ocr.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018¨\u0006."}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/OnceOCRResult;", "", "result", "", "code", "", "msg", "imageSize", "", "cardInputType", "singleTime", "stayTime", "(ILjava/lang/String;Ljava/lang/String;JIJJ)V", "getCardInputType", "()I", "setCardInputType", "(I)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getImageSize", "()J", "setImageSize", "(J)V", "getMsg", "setMsg", "getResult", "setResult", "getSingleTime", "setSingleTime", "getStayTime", "setStayTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnceOCRResult {
    private int cardInputType;
    private String code;
    private long imageSize;
    private String msg;
    private int result;
    private long singleTime;
    private long stayTime;

    public OnceOCRResult() {
        this(0, null, null, 0, 0, 0, 0, 127, null);
    }

    public static /* synthetic */ OnceOCRResult copy$default(OnceOCRResult r110, int r111, String r112, String r113, long r114, int r115, long r116, long r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        int r100 = r110.result;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.code;
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r102 = r110.msg;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r103 = r110.imageSize;
    L19:
        if ((r211 & 16) == 0) goto L21;
        int r104 = r110.cardInputType;
    L23:
        if ((r211 & 32) == 0) goto L25;
        long r105 = r110.singleTime;
    L27:
        if ((r211 & 64) == 0) goto L29;
        long r106 = r110.stayTime;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.result;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.msg;
    }

    public final long component4() {
        return this.imageSize;
    }

    public final int component5() {
        return this.cardInputType;
    }

    public final long component6() {
        return this.singleTime;
    }

    public final long component7() {
        return this.stayTime;
    }

    public final OnceOCRResult copy(int r110, String r111, String r112, long r113, int r114, long r115, long r210) {
        Intrinsics.checkNotNullParameter(r111, "code");
        Intrinsics.checkNotNullParameter(r112, "msg");
        return new OnceOCRResult(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OnceOCRResult) == true) goto L8;
        return false;
    L8:
        OnceOCRResult r101 = (OnceOCRResult) r100;
        if (this.result == r101.result) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L18;
        return false;
    L18:
        if (this.imageSize == r101.imageSize) goto L21;
        return false;
    L21:
        if (this.cardInputType == r101.cardInputType) goto L24;
        return false;
    L24:
        if (this.singleTime == r101.singleTime) goto L27;
        return false;
    L27:
        if (this.stayTime == r101.stayTime) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.result * 31) + this.code.hashCode()) * 31) + this.msg.hashCode()) * 31;
        long r101 = this.imageSize;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.cardInputType) * 31;
        long r103 = this.singleTime;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.stayTime;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public String toString() {
        return "OnceOCRResult(result=" + this.result + ", code=" + this.code + ", msg=" + this.msg + ", imageSize=" + this.imageSize + ", cardInputType=" + this.cardInputType + ", singleTime=" + this.singleTime + ", stayTime=" + this.stayTime + ')';
    }

    public final int getCardInputType() {
        return this.cardInputType;
    }

    public final String getCode() {
        return this.code;
    }

    public final long getImageSize() {
        return this.imageSize;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getResult() {
        return this.result;
    }

    public final long getSingleTime() {
        return this.singleTime;
    }

    public final long getStayTime() {
        return this.stayTime;
    }

    public final void setCardInputType(int r100) {
        this.cardInputType = r100;
    }

    public final void setCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.code = r100;
    }

    public final void setImageSize(long r100) {
        this.imageSize = r100;
    }

    public final void setMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msg = r100;
    }

    public final void setResult(int r100) {
        this.result = r100;
    }

    public final void setSingleTime(long r100) {
        this.singleTime = r100;
    }

    public final void setStayTime(long r100) {
        this.stayTime = r100;
    }

    public OnceOCRResult(int r100, String r101, String r102, long r103, int r104, long r105, long r110) {
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.result = r100;
        this.code = r101;
        this.msg = r102;
        this.imageSize = r103;
        this.cardInputType = r104;
        this.singleTime = r105;
        this.stayTime = r110;
    }

    public /* synthetic */ OnceOCRResult(int r110, String r111, String r112, long r113, int r114, long r115, long r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        int r100 = 0;
    L6:
        String r101 = "";
        if ((r211 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r211 & 4) != 0) goto L14;
        r101 = r112;
    L14:
        long r103 = 0;
        if ((r211 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r211 & 16) == 0) goto L21;
        int r105 = 1;
    L23:
        if ((r211 & 32) == 0) goto L25;
        long r106 = 0;
    L27:
        if ((r211 & 64) != 0) goto L30;
        r103 = r210;
    L30:
        this(r100, r102, r101, r104, r105, r106, r103);
        return;
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
