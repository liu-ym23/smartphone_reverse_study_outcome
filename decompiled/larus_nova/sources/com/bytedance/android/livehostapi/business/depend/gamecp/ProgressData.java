package com.bytedance.android.livehostapi.business.depend.gamecp;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0010HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003Jm\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\b\u00103\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!¨\u00064"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/ProgressData;", "", "progress", "", "speed", "", "progressTransformed", "speedTransformed", "disguisedProgress", "realCurrentBytes", "", DBDefinition.TOTAL_BYTES, "lastRealSpeed", "", "downloadRedeemText", "enableDisguisedProgress", "", "(ILjava/lang/String;ILjava/lang/String;IJJFLjava/lang/String;Z)V", "getDisguisedProgress", "()I", "getDownloadRedeemText", "()Ljava/lang/String;", "setDownloadRedeemText", "(Ljava/lang/String;)V", "getEnableDisguisedProgress", "()Z", "setEnableDisguisedProgress", "(Z)V", "getLastRealSpeed", "()F", "getProgress", "getProgressTransformed", "getRealCurrentBytes", "()J", "getSpeed", "getSpeedTransformed", "getTotalBytes", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProgressData {
    private final int disguisedProgress;
    private String downloadRedeemText;
    private boolean enableDisguisedProgress;
    private final float lastRealSpeed;
    private final int progress;
    private final int progressTransformed;
    private final long realCurrentBytes;
    private final String speed;
    private final String speedTransformed;
    private final long totalBytes;

    public ProgressData() {
        this(0, null, 0, null, 0, 0, 0, 0.0f, null, false, 1023, null);
    }

    public static /* synthetic */ ProgressData copy$default(ProgressData r110, int r111, String r112, int r113, String r114, int r115, long r116, long r210, float r211, String r212, boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = r110.progress;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.speed;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r110.progressTransformed;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.speedTransformed;
    L19:
        if ((r214 & 16) == 0) goto L21;
        int r104 = r110.disguisedProgress;
    L23:
        if ((r214 & 32) == 0) goto L25;
        long r105 = r110.realCurrentBytes;
    L27:
        if ((r214 & 64) == 0) goto L29;
        long r106 = r110.totalBytes;
    L31:
        if ((r214 & 128) == 0) goto L33;
        float r117 = r110.lastRealSpeed;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.downloadRedeemText;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r107 = r110.enableDisguisedProgress;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
    L41:
        r107 = r213;
        goto L43
    L37:
        r118 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
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
        return this.progress;
    }

    public final boolean component10() {
        return this.enableDisguisedProgress;
    }

    public final String component2() {
        return this.speed;
    }

    public final int component3() {
        return this.progressTransformed;
    }

    public final String component4() {
        return this.speedTransformed;
    }

    public final int component5() {
        return this.disguisedProgress;
    }

    public final long component6() {
        return this.realCurrentBytes;
    }

    public final long component7() {
        return this.totalBytes;
    }

    public final float component8() {
        return this.lastRealSpeed;
    }

    public final String component9() {
        return this.downloadRedeemText;
    }

    public final ProgressData copy(int r110, String r111, int r112, String r113, int r114, long r210, long r211, float r212, String r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r111, "speed");
        Intrinsics.checkNotNullParameter(r113, "speedTransformed");
        Intrinsics.checkNotNullParameter(r213, "downloadRedeemText");
        return new ProgressData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProgressData) == false) goto L26;
        ProgressData r101 = (ProgressData) r100;
        if (this.progress == r101.progress) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.speed, r101.speed) == true) goto L10;
        return false;
    L10:
        if (this.progressTransformed == r101.progressTransformed) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.speedTransformed, r101.speedTransformed) == true) goto L14;
        return false;
    L14:
        if (this.disguisedProgress == r101.disguisedProgress) goto L16;
        return false;
    L16:
        if (this.realCurrentBytes == r101.realCurrentBytes) goto L18;
        return false;
    L18:
        if (this.totalBytes == r101.totalBytes) goto L20;
        return false;
    L20:
        if (Float.compare(this.lastRealSpeed, r101.lastRealSpeed) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.downloadRedeemText, r101.downloadRedeemText) == true) goto L24;
        return false;
    L24:
        if (this.enableDisguisedProgress == r101.enableDisguisedProgress) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    public int hashCode() {
        int r100 = this.progress * 31;
        String r101 = this.speed;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.progressTransformed) * 31;
        String r105 = this.speedTransformed;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.disguisedProgress) * 31;
        long r108 = this.realCurrentBytes;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.totalBytes;
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + Float.floatToIntBits(this.lastRealSpeed)) * 31;
        String r112 = this.downloadRedeemText;
        if (r112 == null) goto L13;
        r102 = r112.hashCode();
    L13:
        int r113 = (r111 + r102) * 31;
        boolean r114 = this.enableDisguisedProgress;
        ?? r115 = r114;
        if (r114 == false) goto L17;
        r115 = 1;
    L17:
        return r113 + r115;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "{progress=" + this.progress + ", speed=" + this.speed + ", lastRealSpeed=" + this.lastRealSpeed + ", progressTransformed=" + this.progressTransformed + ",speedTransformed=" + this.speedTransformed + ", disguisedProgress=" + this.disguisedProgress + "},downloadRedeemText=" + this.downloadRedeemText;
    }

    public final int getDisguisedProgress() {
        return this.disguisedProgress;
    }

    public final String getDownloadRedeemText() {
        return this.downloadRedeemText;
    }

    public final boolean getEnableDisguisedProgress() {
        return this.enableDisguisedProgress;
    }

    public final float getLastRealSpeed() {
        return this.lastRealSpeed;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getProgressTransformed() {
        return this.progressTransformed;
    }

    public final long getRealCurrentBytes() {
        return this.realCurrentBytes;
    }

    public final String getSpeed() {
        return this.speed;
    }

    public final String getSpeedTransformed() {
        return this.speedTransformed;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final void setDownloadRedeemText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.downloadRedeemText = r100;
    }

    public final void setEnableDisguisedProgress(boolean r100) {
        this.enableDisguisedProgress = r100;
    }

    public ProgressData(int r100, String r101, int r102, String r103, int r104, long r105, long r106, float r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "speed");
        Intrinsics.checkNotNullParameter(r103, "speedTransformed");
        Intrinsics.checkNotNullParameter(r111, "downloadRedeemText");
        this.progress = r100;
        this.speed = r101;
        this.progressTransformed = r102;
        this.speedTransformed = r103;
        this.disguisedProgress = r104;
        this.realCurrentBytes = r105;
        this.totalBytes = r106;
        this.lastRealSpeed = r110;
        this.downloadRedeemText = r111;
        this.enableDisguisedProgress = r112;
    }

    public /* synthetic */ ProgressData(int r110, String r111, int r112, String r113, int r114, long r115, long r210, float r211, String r212, boolean r213, int r214, DefaultConstructorMarker r215) {
        boolean r100 = false;
        if ((r214 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = "0Kb/s";
        if ((r214 & 2) == 0) goto L9;
        String r103 = "0Kb/s";
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r214 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r214 & 16) == 0) goto L21;
        int r105 = 0;
    L22:
        long r106 = 0;
        if ((r214 & 32) == 0) goto L25;
        long r116 = 0;
    L27:
        if ((r214 & 64) != 0) goto L31;
        r106 = r210;
    L31:
        if ((r214 & 128) == 0) goto L33;
        float r107 = 0.0f;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = "";
    L39:
        if ((r214 & 512) != 0) goto L42;
        r100 = r213;
    L42:
        this(r101, r103, r104, r102, r105, r116, r106, r107, r117, r100);
        return;
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L25:
        r116 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
